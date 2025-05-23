package com.tencent.component.network.downloader.impl.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.network.Global;
import com.tencent.component.network.downloader.UrlKeyGenerator;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.utils.Base64;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.WiFiDash;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QzoneResumeTransfer implements ResumeTransfer {
    private FileCacheService mCache;
    private boolean mCheckContentType;
    private Context mContext;
    private String mName;
    private SharedPreferences mSharePre;
    private UrlKeyGenerator mUrlKeyGenerator;
    public boolean mForceEnable = false;
    private Map<String, CacheFileAttribute> mCacheAttributes = new ConcurrentHashMap();
    private final Object mLock = new Object();
    public Map<String, Pattern> mDominPatterns = new HashMap();
    private List<String> mDomainCacheList = Collections.synchronizedList(new ArrayList());
    private String[] mSupportDomains = {"a[0-9].qpic.cn", "m.qpic.cn", ".*qzonestyle.gtimg.cn", ".*qzs.qq.com", ".*i.gtimg.cn", "a\\d+.photo.store.qq.com", "b\\d+.photo.store.qq.com", "vqzone.tc.qq.com", "vwecam.tc.qq.com"};

    public QzoneResumeTransfer(Context context, String str, FileCacheService fileCacheService, boolean z16) {
        this.mCheckContentType = false;
        this.mContext = context;
        this.mName = str;
        this.mCache = fileCacheService;
        this.mCheckContentType = z16;
        initUrlPatterns();
        if (this.mCheckContentType) {
            this.mSharePre = Global.getSharedPreferences(context, "qzone_download_resume_" + getProcessName(this.mContext), 0);
            loadConfig();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean checkContentRange(String str, HttpResponse httpResponse, Response response) {
        ResponseBody body;
        long contentLength;
        long j3;
        File file;
        if ((httpResponse == null || httpResponse.getStatusLine() == null || httpResponse.getStatusLine().getStatusCode() != 206) && (response == null || response.code() != 206)) {
            return true;
        }
        long j16 = 0;
        if (httpResponse != null) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                contentLength = entity.getContentLength();
            }
            contentLength = 0;
        } else {
            if (response != null && (body = response.body()) != null) {
                try {
                    contentLength = body.getContentLength();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            contentLength = 0;
        }
        String str2 = null;
        if (httpResponse != null) {
            Header firstHeader = httpResponse.getFirstHeader("Content-Range");
            if (firstHeader != null) {
                str2 = firstHeader.getValue();
            }
        } else if (response != null) {
            str2 = response.header("Content-Range");
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                j3 = Integer.valueOf(str2.substring(str2.indexOf("/") + 1)).intValue();
            } catch (Exception unused) {
            }
            file = this.mCache.getFile(getTmpCacheFileName(str));
            if (file != null && file.exists()) {
                j16 = file.length();
            }
            if (j16 + contentLength != j3) {
                return true;
            }
            return false;
        }
        j3 = 0;
        file = this.mCache.getFile(getTmpCacheFileName(str));
        if (file != null) {
            j16 = file.length();
        }
        if (j16 + contentLength != j3) {
        }
    }

    private String getProcessName(Context context) {
        int lastIndexOf;
        try {
            String currentProcessName = Utils.getCurrentProcessName(context);
            if (currentProcessName != null && currentProcessName.contains(":") && (lastIndexOf = currentProcessName.lastIndexOf(":")) > 0) {
                currentProcessName = currentProcessName.substring(lastIndexOf + 1);
            }
            if (TextUtils.isEmpty(currentProcessName)) {
                return "";
            }
            return currentProcessName;
        } catch (Throwable unused) {
            return "";
        }
    }

    private String getTmpCacheFileName(String str) {
        String doGenerate;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        UrlKeyGenerator urlKeyGenerator = this.mUrlKeyGenerator;
        if (urlKeyGenerator == null) {
            doGenerate = str;
        } else {
            doGenerate = urlKeyGenerator.doGenerate(str);
        }
        if (!TextUtils.isEmpty(doGenerate)) {
            str = doGenerate;
        }
        return String.valueOf(str.hashCode());
    }

    private CacheFileAttribute getTmpFileAttr(String str) {
        String tmpCacheFileName = getTmpCacheFileName(str);
        if (tmpCacheFileName == null) {
            return null;
        }
        return this.mCacheAttributes.get(tmpCacheFileName);
    }

    private String getTmpFileContentType(String str) {
        CacheFileAttribute cacheFileAttribute;
        String tmpCacheFileName = getTmpCacheFileName(str);
        if (tmpCacheFileName == null || (cacheFileAttribute = this.mCacheAttributes.get(tmpCacheFileName)) == null) {
            return null;
        }
        return cacheFileAttribute.ContentType;
    }

    private void initUrlPatterns() {
        this.mDominPatterns.clear();
        int i3 = 0;
        while (true) {
            String[] strArr = this.mSupportDomains;
            if (i3 < strArr.length) {
                this.mDominPatterns.put(this.mSupportDomains[i3], Pattern.compile(strArr[i3], 2));
                i3++;
            } else {
                return;
            }
        }
    }

    private boolean isCacheFileVaild(File file) {
        if (file != null && file.exists()) {
            long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
            if (currentTimeMillis >= 0 && currentTimeMillis <= 86400000) {
                return true;
            }
        }
        return false;
    }

    private void loadConfig() {
        Parcel parcel = null;
        String string = this.mSharePre.getString("contenttype_" + this.mName, null);
        if (string != null) {
            try {
                parcel = Utils.unmarshall(Base64.decode(string, 0));
                this.mCacheAttributes.clear();
                parcel.readMap(this.mCacheAttributes, this.mContext.getClassLoader());
            } catch (Throwable th5) {
                try {
                    QDLog.e("download", "download", th5);
                } finally {
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                }
            }
        }
        if (this.mCacheAttributes == null) {
            this.mCacheAttributes = new HashMap();
        }
    }

    private CacheFileAttribute parseAttrs(HttpResponse httpResponse, Response response) {
        String str;
        String str2;
        MediaType mediaType;
        String str3;
        String str4;
        Header contentType;
        String str5 = null;
        if (httpResponse == null && response == null) {
            return null;
        }
        if (httpResponse != null) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null && (contentType = entity.getContentType()) != null) {
                str3 = contentType.getValue();
            } else {
                str3 = null;
            }
            Header firstHeader = httpResponse.getFirstHeader("Last-Modified");
            if (firstHeader != null) {
                str4 = firstHeader.getValue();
            } else {
                str4 = null;
            }
            Header firstHeader2 = httpResponse.getFirstHeader("Content-Encoding");
            if (firstHeader2 != null) {
                str5 = firstHeader2.getValue();
            }
            str = str4;
            String str6 = str5;
            str5 = str3;
            str2 = str6;
        } else if (response != null) {
            ResponseBody body = response.body();
            if (body != null && (mediaType = body.get$contentType()) != null) {
                str5 = mediaType.getMediaType();
            }
            str = response.header("Last-Modified");
            str2 = response.header("Content-Encoding");
        } else {
            str = null;
            str2 = null;
        }
        return new CacheFileAttribute(str5, str, str2);
    }

    private void saveConfig() {
        Parcel parcel = null;
        try {
            try {
                parcel = Parcel.obtain();
                parcel.writeMap(this.mCacheAttributes);
                String str = new String(Base64.encode(parcel.marshall(), 0));
                this.mSharePre.edit().putString("contenttype_" + this.mName, str).commit();
            } catch (Exception e16) {
                QDLog.w("QzoneResumeTransfer", "saveConfig", e16);
                if (parcel == null) {
                    return;
                }
            }
            OaidMonitor.parcelRecycle(parcel);
        } catch (Throwable th5) {
            if (parcel != null) {
                OaidMonitor.parcelRecycle(parcel);
            }
            throw th5;
        }
    }

    private boolean supportResumeDownload(String str, String str2) {
        if (this.mForceEnable) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (this.mDomainCacheList.contains(str2)) {
            return true;
        }
        Iterator<Map.Entry<String, Pattern>> it = this.mDominPatterns.entrySet().iterator();
        while (it.hasNext()) {
            if (Utils.match(it.next().getValue(), str2)) {
                this.mDomainCacheList.add(str2);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    public void addCacheTmpFile(String str, String str2, HttpResponse httpResponse, Response response) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists() && file.length() > 0 && this.mCache.putFile(getTmpCacheFileName(str)) && this.mCheckContentType) {
                if (httpResponse != null || response != null) {
                    CacheFileAttribute parseAttrs = parseAttrs(httpResponse, response);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Downloader Resume Response url:");
                    sb5.append(str);
                    sb5.append(" curr:");
                    if (parseAttrs != null) {
                        str3 = parseAttrs.toString();
                    } else {
                        str3 = WiFiDash.NOT_AVALIBLE;
                    }
                    sb5.append(str3);
                    QDLog.d(QDLog.TAG_DOWNLOAD, sb5.toString());
                    if (parseAttrs != null) {
                        synchronized (this.mLock) {
                            if (!parseAttrs.equals(this.mCacheAttributes.get(getTmpCacheFileName(str)))) {
                                this.mCacheAttributes.put(getTmpCacheFileName(str), parseAttrs);
                                saveConfig();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    public void cleanCache() {
        this.mCache.clear();
        synchronized (this.mLock) {
            this.mCacheAttributes.clear();
            saveConfig();
        }
    }

    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    public String getResumeTmpFile(String str) {
        File file = this.mCache.getFile(getTmpCacheFileName(str));
        if (file != null && file.exists()) {
            return file.getPath();
        }
        return null;
    }

    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    public boolean handleResponse(String str, String str2, HttpResponse httpResponse, Response response) {
        String str3;
        if (!this.mCheckContentType || !supportResumeDownload(str, str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str) || ((httpResponse == null && response == null) || !checkContentRange(str, httpResponse, response))) {
            return false;
        }
        CacheFileAttribute tmpFileAttr = getTmpFileAttr(str);
        if (tmpFileAttr == null) {
            return true;
        }
        CacheFileAttribute parseAttrs = parseAttrs(httpResponse, response);
        if (QDLog.isInfoEnable()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("download content-type check url:");
            sb5.append(str);
            sb5.append(" old:");
            sb5.append(tmpFileAttr.toString());
            sb5.append(" curr:");
            if (parseAttrs != null) {
                str3 = parseAttrs.toString();
            } else {
                str3 = WiFiDash.NOT_AVALIBLE;
            }
            sb5.append(str3);
            QDLog.i(QDLog.TAG_DOWNLOAD, sb5.toString());
        }
        if (tmpFileAttr.equals(parseAttrs)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    public void onDownloadResult(String str, boolean z16) {
        if (z16) {
            synchronized (this.mCache) {
                this.mCache.deleteFile(getTmpCacheFileName(str));
            }
            if (this.mCheckContentType) {
                synchronized (this.mLock) {
                    if (this.mCacheAttributes.containsKey(getTmpCacheFileName(str))) {
                        this.mCacheAttributes.remove(getTmpCacheFileName(str));
                        saveConfig();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prepareRequest(HttpGet httpGet, Request.Builder builder, String str, String str2) {
        long j3;
        if (!supportResumeDownload(str, str2)) {
            return;
        }
        String tmpCacheFileName = getTmpCacheFileName(str);
        File file = this.mCache.getFile(tmpCacheFileName);
        if (file != null && file.exists()) {
            if (isCacheFileVaild(file)) {
                j3 = file.length();
                String tmpFileContentType = getTmpFileContentType(str);
                if (j3 > 0) {
                    if (!this.mCheckContentType) {
                        if (httpGet != null) {
                            httpGet.addHeader("Range", "bytes=" + j3 + "-");
                        } else if (builder != null) {
                            builder.addHeader("Range", "bytes=" + j3 + "-");
                        }
                    } else if (!TextUtils.isEmpty(tmpFileContentType)) {
                        if (httpGet != null) {
                            httpGet.addHeader("Range", "bytes=" + j3 + "-");
                            httpGet.addHeader("Accept", tmpFileContentType);
                            httpGet.addHeader("Q-Accept", tmpFileContentType);
                        } else if (builder != null) {
                            builder.addHeader("Range", "bytes=" + j3 + "-");
                            builder.addHeader("Accept", tmpFileContentType);
                            builder.addHeader("Q-Accept", tmpFileContentType);
                        }
                    }
                }
                QDLog.i(QDLog.TAG_DOWNLOAD, "Downloader Resume --- begin range:" + j3 + " Accept:" + tmpFileContentType + " url:" + str);
            }
            this.mCache.deleteFile(tmpCacheFileName);
        }
        j3 = 0;
        String tmpFileContentType2 = getTmpFileContentType(str);
        if (j3 > 0) {
        }
        QDLog.i(QDLog.TAG_DOWNLOAD, "Downloader Resume --- begin range:" + j3 + " Accept:" + tmpFileContentType2 + " url:" + str);
    }

    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    public void setSupportDomains(String[] strArr, boolean z16) {
        if (strArr != null && strArr.length > 0) {
            if (!z16) {
                this.mSupportDomains = strArr;
            } else {
                int length = this.mSupportDomains.length + strArr.length;
                String[] strArr2 = new String[length];
                for (int i3 = 0; i3 < length; i3++) {
                    String[] strArr3 = this.mSupportDomains;
                    if (i3 < strArr3.length) {
                        strArr2[i3] = strArr3[i3];
                    } else {
                        strArr2[i3] = strArr[i3 - strArr3.length];
                    }
                }
                this.mSupportDomains = strArr2;
            }
            initUrlPatterns();
        }
    }

    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    public void setUrlKeyGenerator(UrlKeyGenerator urlKeyGenerator) {
        this.mUrlKeyGenerator = urlKeyGenerator;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class CacheFileAttribute implements Parcelable {
        public static final Parcelable.Creator<CacheFileAttribute> CREATOR = new Parcelable.Creator<CacheFileAttribute>() { // from class: com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer.CacheFileAttribute.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CacheFileAttribute createFromParcel(Parcel parcel) {
                return new CacheFileAttribute(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CacheFileAttribute[] newArray(int i3) {
                return new CacheFileAttribute[i3];
            }
        };
        public String ContentEncoding;
        public String ContentType;
        public String LastModifyTime;

        public CacheFileAttribute(String str, String str2, String str3) {
            this.ContentType = str;
            this.LastModifyTime = str2;
            this.ContentEncoding = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof CacheFileAttribute)) {
                return false;
            }
            CacheFileAttribute cacheFileAttribute = (CacheFileAttribute) obj;
            if (TextUtils.equals(this.ContentType, cacheFileAttribute.ContentType) && TextUtils.equals(this.LastModifyTime, cacheFileAttribute.LastModifyTime) && TextUtils.equals(this.ContentEncoding, cacheFileAttribute.ContentEncoding)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "CacheFileAttr --- ContentType:" + this.ContentType + " LastModify:" + this.LastModifyTime + " ContentEncoding:" + this.ContentEncoding;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            if (parcel == null) {
                return;
            }
            parcel.writeString(this.ContentType);
            parcel.writeString(this.LastModifyTime);
            parcel.writeString(this.ContentEncoding);
        }

        public CacheFileAttribute(Parcel parcel) {
            if (parcel == null) {
                return;
            }
            this.ContentType = parcel.readString();
            this.LastModifyTime = parcel.readString();
            this.ContentEncoding = parcel.readString();
        }
    }

    @Override // com.tencent.component.network.downloader.strategy.ResumeTransfer
    public void cleanCache(String str) {
        String tmpCacheFileName = getTmpCacheFileName(str);
        this.mCache.deleteFile(tmpCacheFileName);
        synchronized (this.mLock) {
            this.mCacheAttributes.remove(tmpCacheFileName);
            saveConfig();
        }
    }
}
