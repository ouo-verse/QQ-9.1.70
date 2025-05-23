package com.tencent.mobileqq.kandian.base.image.api.impl;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptBitmapFile;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptConfig;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.base.image.c;
import com.tencent.mobileqq.kandian.base.image.d;
import com.tencent.mobileqq.nearby.now.utils.IIOUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.dns.IpData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import com.tencent.qqnt.http.api.m;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.apache.http.Header;

/* loaded from: classes33.dex */
public class PublicAccountHttpDownloaderImpl extends HttpDownloader implements IPublicAccountHttpDownloader {
    public static final String TAG = "PubAccountHttpDownloader";
    private BaseApplicationImpl application = BaseApplicationImpl.getApplication();

    /* loaded from: classes33.dex */
    public class b {

        /* renamed from: b, reason: collision with root package name */
        private final int f238979b;

        /* renamed from: c, reason: collision with root package name */
        private final String f238980c;

        /* renamed from: d, reason: collision with root package name */
        private int f238981d;

        /* renamed from: e, reason: collision with root package name */
        private long f238982e;

        /* renamed from: f, reason: collision with root package name */
        private long f238983f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f238984g;

        /* renamed from: h, reason: collision with root package name */
        private String f238985h;

        /* renamed from: i, reason: collision with root package name */
        private String f238986i;

        /* renamed from: j, reason: collision with root package name */
        private String f238987j;

        /* renamed from: k, reason: collision with root package name */
        private int f238988k;

        /* renamed from: l, reason: collision with root package name */
        private long f238989l;

        /* renamed from: m, reason: collision with root package name */
        private String f238990m;

        /* renamed from: n, reason: collision with root package name */
        private String f238991n;

        /* renamed from: o, reason: collision with root package name */
        private String f238992o;

        /* renamed from: p, reason: collision with root package name */
        private String f238993p;

        /* renamed from: q, reason: collision with root package name */
        private String f238994q;

        /* renamed from: r, reason: collision with root package name */
        private Map<String, String> f238995r;

        /* renamed from: s, reason: collision with root package name */
        private BaseApplicationImpl f238996s;

        /* renamed from: a, reason: collision with root package name */
        private HashMap<String, String> f238978a = new HashMap<>();

        /* renamed from: t, reason: collision with root package name */
        private String[] f238997t = {"2909288299"};

        /* renamed from: u, reason: collision with root package name */
        public int f238998u = 0;

        /* loaded from: classes33.dex */
        public class a implements URLDrawableHandler {

            /* renamed from: d, reason: collision with root package name */
            private URLDrawableHandler f239000d;

            /* renamed from: e, reason: collision with root package name */
            private b f239001e;

            public a(URLDrawableHandler uRLDrawableHandler, b bVar) {
                this.f239000d = uRLDrawableHandler;
                this.f239001e = bVar;
            }

            public void a(String str) {
                URLDrawableHandler uRLDrawableHandler = this.f239000d;
                if (uRLDrawableHandler instanceof d) {
                    ((d) uRLDrawableHandler).a(str);
                }
            }

            public b b() {
                return this.f239001e;
            }

            protected void c() {
                QLog.d(b.this.f238980c, 1, "image download start: " + b.this.f238985h + " supportInnerIp: " + ((HttpDownloader) PublicAccountHttpDownloaderImpl.this).mSupportInnerIp);
                if (((HttpDownloader) PublicAccountHttpDownloaderImpl.this).mSupportInnerIp) {
                    ArrayList<ServerAddr> reqSerAddrList = InnerDns.getInstance().reqSerAddrList(InnerDns.getHostFromUrl(b.this.f238985h), 1002);
                    if (reqSerAddrList != null && reqSerAddrList.size() > 0) {
                        StringBuilder sb5 = new StringBuilder();
                        Iterator<ServerAddr> it = reqSerAddrList.iterator();
                        while (it.hasNext()) {
                            sb5.append(it.next().toString());
                            sb5.append(" ");
                        }
                        QLog.d(b.this.f238980c, 1, "InnerIp address " + ((Object) sb5));
                        return;
                    }
                    QLog.d(b.this.f238980c, 1, "InnerIp address empty");
                }
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void doCancel() {
                this.f239000d.doCancel();
            }

            @Override // com.tencent.image.URLDrawableHandler
            public boolean isCancelled() {
                return this.f239000d.isCancelled();
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadFailed(int i3) {
                this.f239001e.n(false, i3);
                this.f239000d.onFileDownloadFailed(i3);
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadStarted() {
                this.f239001e.o();
                this.f239000d.onFileDownloadStarted();
                c();
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadSucceed(long j3) {
                this.f239001e.n(true, 0);
                this.f239000d.onFileDownloadSucceed(j3);
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void publishProgress(int i3) {
                this.f239000d.publishProgress(i3);
            }
        }

        public b(BaseApplicationImpl baseApplicationImpl, int i3) {
            this.f238981d = i3;
            this.f238996s = baseApplicationImpl;
            int l3 = l();
            this.f238979b = l3;
            this.f238980c = "PubAccountHttpDownloader." + l3;
        }

        private String j(MessageRecord messageRecord) {
            if (messageRecord instanceof MessageForStructing) {
                MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
                if (messageForStructing.structingMsg != null) {
                    return "" + messageForStructing.structingMsg.msgId;
                }
            }
            if (!(messageRecord instanceof MessageForPubAccount)) {
                return null;
            }
            MessageForPubAccount messageForPubAccount = (MessageForPubAccount) messageRecord;
            if (messageForPubAccount.mPAMessage == null) {
                return null;
            }
            return "" + messageForPubAccount.mPAMessage.mMsgId;
        }

        private void q(String str) {
            int i3;
            AppRuntime runtime = this.f238996s.getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                if (str != null) {
                    int accountType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(qQAppInterface, str);
                    if (accountType == -5) {
                        i3 = 4;
                    } else if (accountType == -4) {
                        i3 = 2;
                    } else if (accountType == -3) {
                        i3 = 3;
                    } else if (accountType == -1) {
                        i3 = 1;
                    } else if (this.f238981d == 0) {
                        return;
                    } else {
                        i3 = 0;
                    }
                    this.f238978a.put("param_acc_type", "" + i3);
                    this.f238978a.put(ReportConstant.KEY_LONG_MSG_PUIN, str);
                }
                String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                if (currentAccountUin != null) {
                    this.f238978a.put("param_uin", currentAccountUin);
                }
            }
        }

        public void h(DownloadParams downloadParams, Map<String, String> map) {
            int i3;
            long netType = NetworkCenter.getInstance().getNetType();
            this.f238993p = "None";
            if (netType > 0) {
                String[] strArr = AppConstants.NET_TYPE_NAME;
                if (netType < strArr.length) {
                    this.f238993p = strArr[(int) netType];
                }
            }
            this.f238992o = "ANDROID.MOBILE-" + DeviceInfoMonitor.getModel() + ".SDK-" + Build.VERSION.SDK;
            DisplayMetrics displayMetrics = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDisplayMetrics();
            this.f238994q = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            this.f238985h = downloadParams.urlStr;
            this.f238986i = downloadParams.url.getHost();
            this.f238990m = "none";
            int lastIndexOf = this.f238985h.lastIndexOf("/");
            if (lastIndexOf != -1 && (i3 = lastIndexOf + 1) <= this.f238985h.length() && i3 < this.f238985h.length()) {
                String substring = this.f238985h.substring(i3);
                this.f238990m = substring;
                int indexOf = substring.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (indexOf != -1) {
                    this.f238990m = this.f238990m.substring(0, indexOf);
                }
            }
            this.f238995r = map;
        }

        public void i(int i3, DownloadParams downloadParams) {
            String str;
            String str2;
            if (this.f238995r.containsKey(IPublicAccountBrowser.KEY_PUB_UIN)) {
                str = this.f238995r.get(IPublicAccountBrowser.KEY_PUB_UIN);
                str2 = this.f238995r.get("msgid");
            } else {
                Object obj = downloadParams.mExtraInfo;
                if (obj instanceof MessageRecord) {
                    MessageRecord messageRecord = (MessageRecord) obj;
                    String str3 = messageRecord.frienduin;
                    str2 = j(messageRecord);
                    str = str3;
                } else {
                    str = null;
                    str2 = null;
                }
            }
            if (m(str)) {
                return;
            }
            q(str);
            if (str2 != null) {
                this.f238978a.put("param_msgid", str2);
            }
            this.f238978a.put("AttemptCount", "" + i3);
            this.f238978a.put("picFormat", this.f238990m);
            this.f238978a.put("netType", this.f238993p);
            this.f238978a.put("plateform", this.f238992o);
            this.f238978a.put("pixDensity", this.f238994q);
            ArrayList<String> reqDnsForIpList = InnerDns.getInstance().reqDnsForIpList(this.f238986i, 1009);
            this.f238978a.put("IPs", reqDnsForIpList != null ? TextUtils.join(",", reqDnsForIpList) : "");
            this.f238978a.put("ServerIP", "");
            this.f238978a.put("OriginURL", this.f238985h);
            this.f238978a.put("Success", this.f238984g ? String.valueOf(1) : String.valueOf(0));
            this.f238978a.put("TotalTime", Long.toString(this.f238983f));
            this.f238978a.put("picType", this.f238991n);
            this.f238978a.put("ReceivedBytes", String.valueOf(this.f238989l));
            this.f238978a.put("ErrorReason", this.f238987j);
            this.f238978a.put("param_FailCode", this.f238988k + "");
            this.f238978a.put(TAVBaseAutomaticEffect.TYPE_SPEED, Float.toString(((float) this.f238989l) / (((float) this.f238983f) / 1000.0f)));
            String k3 = k(this.f238981d);
            QLog.d(this.f238980c, 1, "reportTag:" + k3 + ", success:" + this.f238984g + ", time:" + this.f238983f + ", size:" + this.f238989l + ", url:" + this.f238985h + ", exInfo:" + this.f238978a.toString());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, k3, this.f238984g, this.f238983f, this.f238989l, this.f238978a, "", true);
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("state", this.f238984g ? String.valueOf(1) : String.valueOf(0));
            String str4 = this.f238985h;
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put("url", str4);
            String str5 = this.f238987j;
            hashMap.put("error_msg", str5 != null ? str5 : "");
            hashMap.put("error_code", String.valueOf(this.f238988k));
            hashMap.put("cost_time", Long.toString(this.f238983f));
            hashMap.put("size", String.valueOf(this.f238989l));
            hashMap.put("speed", Float.toString(((float) this.f238989l) / (((float) this.f238983f) / 1000.0f)));
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).dataReport("ec_quality_show_pic_succ_rate", hashMap);
        }

        public synchronized int l() {
            int i3;
            i3 = this.f238998u + 1;
            this.f238998u = i3;
            return i3;
        }

        public void n(boolean z16, int i3) {
            this.f238984g = z16;
            this.f238988k = i3;
            this.f238983f = SystemClock.uptimeMillis() - this.f238982e;
        }

        public void o() {
            this.f238982e = SystemClock.uptimeMillis();
        }

        public void p(int i3, String str) {
            if (this.f238988k == 0) {
                this.f238988k = i3;
            }
            this.f238987j = str;
            this.f238984g = false;
            this.f238983f = SystemClock.uptimeMillis() - this.f238982e;
        }

        public URLDrawableHandler r(URLDrawableHandler uRLDrawableHandler) {
            return new a(uRLDrawableHandler, this);
        }

        public void g() {
            this.f238988k = 0;
            this.f238987j = null;
        }

        private boolean m(String str) {
            if (str != null) {
                for (String str2 : this.f238997t) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private String k(int i3) {
            if (i3 == 0) {
                return "actSubscriptionAIO";
            }
            if (i3 == 1) {
                return "actSubscriptionFolder";
            }
            if (i3 == 2) {
                return "actSubscriptionDetail";
            }
            if (i3 == 3) {
                return "actKandianImage";
            }
            if (i3 != 4) {
                return "actSubscriptionUnkonw";
            }
            return "actNativeWebImage";
        }
    }

    private byte[] getByteArrayInputStream(InputStream inputStream, long j3) throws IOException {
        return ((IIOUtils) QRoute.api(IIOUtils.class)).readBytes(inputStream, (int) j3);
    }

    private String getNetIdentifier() {
        return "";
    }

    private void hook(URL url) {
        try {
            ArrayList<ServerAddr> reqSerAddrList = InnerDns.getInstance().reqSerAddrList(url.getHost(), 1002);
            if (reqSerAddrList == null || reqSerAddrList.size() == 0) {
                ArrayList arrayList = new ArrayList();
                InetAddress[] allByName = InetAddress.getAllByName(url.getHost());
                if (allByName == null || allByName.length <= 0) {
                    return;
                }
                for (InetAddress inetAddress : allByName) {
                    IpData ipData = new IpData();
                    String hostAddress = inetAddress.getHostAddress();
                    ipData.mIp = hostAddress;
                    ipData.mPort = 80;
                    ipData.mType = IPAddressUtil.isIPv4LiteralAddress(hostAddress) ? 1 : 28;
                    arrayList.add(ipData);
                }
                DomainData domainData = new DomainData(url.getHost(), arrayList);
                HashMap hashMap = (HashMap) Reflect.on(InnerDns.getInstance()).get("mNetMap");
                String netIdentifier = getNetIdentifier();
                if (hashMap != null) {
                    if (hashMap.containsKey(netIdentifier)) {
                        ((HashMap) hashMap.get(netIdentifier)).put(url.getHost(), domainData);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(url.getHost(), domainData);
                        hashMap.put(netIdentifier, hashMap2);
                    }
                }
                QLog.d(TAG, 1, "hook success: " + Arrays.toString(allByName));
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16.getMessage());
        }
    }

    private boolean isSupportInnerIpDNS(DownloadParams downloadParams) {
        if (downloadParams instanceof c) {
            return ((c) downloadParams).f239028a;
        }
        return false;
    }

    private boolean isUseIpConnect(DownloadParams downloadParams) {
        if (downloadParams instanceof c) {
            return ((c) downloadParams).f239029b;
        }
        return false;
    }

    private void saveFileInSingleThread(final OutputStream outputStream, final DownloadParams downloadParams, final URLDrawableHandler uRLDrawableHandler, final int i3, final boolean z16, final int i16, final InputStream inputStream, final long j3) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PublicAccountHttpDownloaderImpl.super.getDownloadFile(outputStream, downloadParams, uRLDrawableHandler, i3, z16, i16, inputStream, j3);
                    OutputStream outputStream2 = outputStream;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                } catch (IOException e16) {
                    QLog.e(PublicAccountHttpDownloaderImpl.TAG, 1, e16.getMessage());
                    PublicAccountHttpDownloaderImpl.this.reportIOException(downloadParams, i3, z16, i16, e16);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.transfile.HttpDownloader
    protected void copyRespInfo(com.tencent.qqnt.http.api.b bVar, m mVar, URLDrawableHandler uRLDrawableHandler) {
        b.a aVar;
        b b16;
        if (!(uRLDrawableHandler instanceof b.a) || (b16 = (aVar = (b.a) uRLDrawableHandler).b()) == null) {
            return;
        }
        b16.f238991n = "none";
        Map<String, String> headers = mVar.d().getHeaders();
        if (headers != null) {
            String str = headers.get("param_rspHeader");
            QLog.d(b16.f238980c, 1, "resp: " + str);
            String str2 = headers.get("Content-Type");
            if (str2 != null && str2.startsWith(ImageContentType.IMAGE_PREFIX)) {
                b16.f238991n = str2.replace(ImageContentType.IMAGE_PREFIX, "");
            }
        } else {
            QLog.d(b16.f238980c, 1, "esp headers: empty");
        }
        b16.f238989l = bVar.s().d();
        aVar.a(ImageContentType.IMAGE_PREFIX + b16.f238991n);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader
    public HttpDownloader getHttpDownloader() {
        return this;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    protected boolean isCommitBimapFileAsyn(File file) {
        return file instanceof RIJImageOptBitmapFile;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader
    public URL makeURL(String str, int i3) {
        return makeURL(str, i3, null);
    }

    /* loaded from: classes33.dex */
    private class a extends FilterOutputStream {

        /* renamed from: d, reason: collision with root package name */
        int f238976d;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.f238976d = 0;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i16) throws IOException {
            this.f238976d += i16;
            ((FilterOutputStream) this).out.write(bArr, i3, i16);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i3) throws IOException {
            this.f238976d++;
            ((FilterOutputStream) this).out.write(i3);
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader
    public URL makeURL(String str, int i3, Object obj) {
        return makeURL(str, i3, obj, false);
    }

    private File getBitmapFile(byte[] bArr, long j3) throws IOException {
        if (bArr != null) {
            return new RIJImageOptBitmapFile(bArr, j3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader
    public URL makeURL(String str, int i3, Object obj, boolean z16) {
        String addParameter;
        URL url;
        URL url2 = null;
        try {
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "<--generateURL urlString", e16);
            }
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            return new URL(str);
        }
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        if (argumentsFromURL.containsKey(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY)) {
            addParameter = str.replace("busiType=" + argumentsFromURL.get(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY), "busiType=" + i3);
        } else {
            addParameter = URLUtil.addParameter(str, IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, i3 + "");
        }
        if (!z16) {
            url = new URL("pubaccountimage", (String) null, addParameter);
        } else {
            url = new URL(addParameter);
        }
        url2 = url;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<--generateURL urlString =" + url2.toString());
        }
        return url2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.HttpDownloader
    public File getDownloadFile(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, int i3, boolean z16, int i16, InputStream inputStream, long j3) throws IOException {
        if (RIJImageOptConfig.INSTANCE.isDecodeHttpStream()) {
            byte[] byteArrayInputStream = getByteArrayInputStream(inputStream, j3);
            QLog.d(TAG, 1, "read into memory done");
            if (byteArrayInputStream != null) {
                saveFileInSingleThread(outputStream, downloadParams, uRLDrawableHandler, i3, z16, i16, new ByteArrayInputStream(byteArrayInputStream), j3);
                return getBitmapFile(byteArrayInputStream, j3);
            }
        }
        return super.getDownloadFile(outputStream, downloadParams, uRLDrawableHandler, i3, z16, i16, inputStream, j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x019d A[EDGE_INSN: B:128:0x019d->B:53:0x019d BREAK  A[LOOP:1: B:19:0x009f->B:42:0x0166], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0177 A[EDGE_INSN: B:92:0x0177->B:52:0x0177 BREAK  A[LOOP:1: B:19:0x009f->B:42:0x0166], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    @Override // com.tencent.mobileqq.transfile.HttpDownloader, com.tencent.mobileqq.transfile.AbsDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        int parseInt;
        Header[] headerArr;
        a aVar;
        int i3;
        int i16;
        int i17;
        int i18;
        a aVar2;
        char c16;
        String str = downloadParams.urlStr;
        if (str.startsWith("pubaccountimage")) {
            str = downloadParams.url.getFile();
        }
        String str2 = str;
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str2);
        char c17 = 2;
        int i19 = -1;
        if (argumentsFromURL.get(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY) != null) {
            try {
                parseInt = Integer.parseInt(argumentsFromURL.get(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY));
            } catch (NumberFormatException e16) {
                QLog.e(TAG, 2, "urlString: " + str2 + "  busiType:" + argumentsFromURL.get(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY), e16);
            }
            downloadParams.url = new URL(str2);
            downloadParams.urlStr = str2;
            b bVar = new b(this.application, parseInt);
            bVar.h(downloadParams, argumentsFromURL);
            headerArr = downloadParams.headers;
            if (headerArr != null) {
                for (Header header : headerArr) {
                    if ("my_uin".equals(header.getName())) {
                        header.getValue();
                    }
                }
            }
            aVar = new a(outputStream);
            this.mSupportInnerIp = isSupportInnerIpDNS(downloadParams);
            i3 = 1;
            File file = null;
            i16 = 0;
            while (true) {
                i17 = i3 - 1;
                if (i3 > 0) {
                    break;
                }
                i18 = i16 + 1;
                try {
                    try {
                        bVar.g();
                        if (this.mSupportInnerIp && isUseIpConnect(downloadParams)) {
                            hook(downloadParams.url);
                        }
                    } catch (IOException e17) {
                        e = e17;
                    }
                } catch (Throwable th5) {
                    if (!this.isCancelled.get()) {
                        if (i17 == -1 || i17 == 0) {
                            if (bVar.f238988k == 0 || downloadParams.retryCount == com.tencent.mobileqq.kandian.base.image.b.f239003y) {
                                bVar.i(i18, downloadParams);
                                throw th5;
                            }
                            throw th5;
                        }
                        try {
                            LockMethodProxy.sleep(5L);
                            throw th5;
                        } catch (InterruptedException e18) {
                            e18.printStackTrace();
                            throw th5;
                        }
                    }
                }
                try {
                    file = super.downloadImage(aVar, downloadParams, bVar.r(uRLDrawableHandler));
                    if (file == null || (file instanceof RIJImageOptBitmapFile)) {
                        i17 = i19;
                    }
                } catch (IOException e19) {
                    e = e19;
                    if (!e.getMessage().contains(" response error! response code: ")) {
                        bVar.p(i19, e.getMessage());
                    }
                    if (i17 != 0) {
                        try {
                            aVar2 = aVar;
                            try {
                                ((FileOutputStream) outputStream).getChannel().truncate(0L);
                                c16 = 2;
                            } catch (Exception e26) {
                                e = e26;
                                c16 = 2;
                                QLog.e(TAG, 2, "urlString: " + str2, e);
                                if (this.isCancelled.get()) {
                                }
                            }
                        } catch (Exception e27) {
                            e = e27;
                            aVar2 = aVar;
                        }
                        if (this.isCancelled.get()) {
                            if (i17 == -1 || i17 == 0) {
                                if (bVar.f238988k == 0 || downloadParams.retryCount == com.tencent.mobileqq.kandian.base.image.b.f239003y) {
                                    bVar.i(i18, downloadParams);
                                }
                            } else {
                                try {
                                    LockMethodProxy.sleep(5L);
                                } catch (InterruptedException e28) {
                                    e28.printStackTrace();
                                }
                            }
                            c17 = c16;
                            i16 = i18;
                            i3 = i17;
                            aVar = aVar2;
                            i19 = -1;
                        } else {
                            bVar.i(i18, downloadParams);
                            if (this.isCancelled.get()) {
                            }
                        }
                    } else {
                        throw e;
                    }
                }
                if (this.isCancelled.get()) {
                    break;
                }
                if (i17 == i19 || i17 == 0) {
                    if (bVar.f238988k == 0 || downloadParams.retryCount == com.tencent.mobileqq.kandian.base.image.b.f239003y) {
                        bVar.i(i18, downloadParams);
                    }
                } else {
                    try {
                        LockMethodProxy.sleep(5L);
                    } catch (InterruptedException e29) {
                        e29.printStackTrace();
                    }
                }
                aVar2 = aVar;
                c16 = c17;
                c17 = c16;
                i16 = i18;
                i3 = i17;
                aVar = aVar2;
                i19 = -1;
            }
            bVar.i(i18, downloadParams);
            if (this.isCancelled.get()) {
                throw new IOException("cancelled");
            }
            return file;
        }
        parseInt = -1;
        downloadParams.url = new URL(str2);
        downloadParams.urlStr = str2;
        b bVar2 = new b(this.application, parseInt);
        bVar2.h(downloadParams, argumentsFromURL);
        headerArr = downloadParams.headers;
        if (headerArr != null) {
        }
        aVar = new a(outputStream);
        this.mSupportInnerIp = isSupportInnerIpDNS(downloadParams);
        i3 = 1;
        File file2 = null;
        i16 = 0;
        while (true) {
            i17 = i3 - 1;
            if (i3 > 0) {
            }
            c17 = c16;
            i16 = i18;
            i3 = i17;
            aVar = aVar2;
            i19 = -1;
        }
        bVar2.i(i18, downloadParams);
        if (this.isCancelled.get()) {
        }
    }
}
