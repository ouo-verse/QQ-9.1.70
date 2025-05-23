package com.tencent.mobileqq.shortvideo.util;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RecentDanceConfigMgr {

    /* renamed from: c, reason: collision with root package name */
    private static AtomicReference<RecentDanceConfigMgr> f288234c = new AtomicReference<>(null);

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f288235d = false;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f288236e = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f288237a = false;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, DItemInfo> f288238b = new HashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f288239d;

        @Override // java.lang.Runnable
        public void run() {
            RecentDanceConfigMgr m3 = RecentDanceConfigMgr.m(this.f288239d);
            if (m3 != null) {
                RecentDanceConfigMgr.f288234c.getAndSet(m3);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr$3, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecentDanceConfigMgr.f288236e = RecentDanceConfigMgr.f();
            RecentDanceConfigMgr.f288235d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DItemInfo f288240d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f288241e;

        a(DItemInfo dItemInfo, String str) {
            this.f288240d = dItemInfo;
            this.f288241e = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (netResp.mResult == 0) {
                NetReq netReq = netResp.mReq;
                if (new File(netReq.mOutPath).exists()) {
                    String h16 = RecentDanceConfigMgr.h(netReq.mOutPath);
                    if (h16 != null && !"".equals(h16) && h16.equalsIgnoreCase(this.f288240d.icon_md5)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: check success");
                        }
                        FileUtils.rename(netReq.mOutPath, this.f288241e);
                        RecentDanceConfigMgr.i(this.f288240d, this.f288241e);
                        return;
                    }
                    FileUtils.deleteFile(netReq.mOutPath);
                    FileUtils.deleteFile(this.f288241e);
                    if (QLog.isColorLevel()) {
                        QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: item.icon_md5" + this.f288240d.icon_md5 + " md5=" + h16);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp[not exists]: mOutPath" + netReq.mOutPath);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: resp.mResult=" + netResp.mResult);
            }
            FileUtils.deleteFile(netResp.mReq.mOutPath);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.i("RecentDanceConfigMgr", 2, "processNetWork onUpdateProgeress: totalLen=" + j16 + " curOffset=" + j3);
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean f() {
        return l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(String str) {
        try {
            try {
                return HexUtil.bytes2HexStr(MD5.getFileMd5(str));
            } catch (Exception unused) {
                return null;
            }
        } catch (UnsatisfiedLinkError unused2) {
            return com.tencent.qqprotect.singleupdate.a.d(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(DItemInfo dItemInfo, String str) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("RecentDanceConfigMgr", 2, "genBitmapDrawable: oomError=", e16);
            }
            bitmap = null;
        }
        if (bitmap != null) {
            dItemInfo.drawable = new BitmapDrawable(bitmap);
        }
    }

    private static String j() {
        String str = AppConstants.SDCARD_PATH + "sv_config_icon" + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str + ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException unused) {
            }
        }
        return str;
    }

    private static String k(String str, DItemInfo dItemInfo) {
        return str + dItemInfo.icon_md5 + ".png";
    }

    private static boolean l() {
        if (!new File(CapturePtvTemplateManager.f281330j, "ptv_template_new.cfg").exists()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RecentDanceConfigMgr m(String str) {
        RecentDanceConfigMgr recentDanceConfigMgr = new RecentDanceConfigMgr();
        try {
            JSONObject jSONObject = new JSONObject(str);
            recentDanceConfigMgr.f288237a = jSONObject.optBoolean("showEntrance", false);
            JSONArray jSONArray = jSONObject.getJSONArray("ItemsInfo");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    DItemInfo dItemInfo = (DItemInfo) JSONUtils.b(jSONArray.getJSONObject(i3), DItemInfo.class);
                    if (dItemInfo != null) {
                        String str2 = dItemInfo.icon_url;
                        if (str2 != null && !"".equals(str2)) {
                            String k3 = k(j(), dItemInfo);
                            if (!new File(k3).exists()) {
                                if (dItemInfo.isContent) {
                                    n(dItemInfo, k3);
                                } else {
                                    o(dItemInfo, k3);
                                }
                            } else {
                                i(dItemInfo, k3);
                            }
                        }
                        dItemInfo.forceRefresh = false;
                        RecentDanceConfigMgr recentDanceConfigMgr2 = f288234c.get();
                        if (recentDanceConfigMgr2 != null) {
                            DItemInfo dItemInfo2 = recentDanceConfigMgr2.f288238b.get("" + dItemInfo.name);
                            if (dItemInfo2 != null) {
                                if (TextUtils.isEmpty(dItemInfo2.icon_md5) && !TextUtils.isEmpty(dItemInfo.icon_md5)) {
                                    dItemInfo.forceRefresh = true;
                                }
                                if (!TextUtils.isEmpty(dItemInfo2.icon_md5) && TextUtils.isEmpty(dItemInfo.icon_md5)) {
                                    dItemInfo.forceRefresh = true;
                                }
                                if (!TextUtils.isEmpty(dItemInfo2.icon_md5) && !TextUtils.isEmpty(dItemInfo.icon_md5) && !dItemInfo.icon_md5.equalsIgnoreCase(dItemInfo2.icon_md5)) {
                                    dItemInfo.forceRefresh = true;
                                }
                                if (TextUtils.isEmpty(dItemInfo2.showName) && !TextUtils.isEmpty(dItemInfo.showName)) {
                                    dItemInfo.forceRefresh = true;
                                }
                                if (!TextUtils.isEmpty(dItemInfo2.showName) && TextUtils.isEmpty(dItemInfo.showName)) {
                                    dItemInfo.forceRefresh = true;
                                }
                                if (!TextUtils.isEmpty(dItemInfo2.showName) && !TextUtils.isEmpty(dItemInfo.showName) && !dItemInfo.showName.equalsIgnoreCase(dItemInfo2.showName)) {
                                    dItemInfo.forceRefresh = true;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr item.forceRefresh=" + dItemInfo.forceRefresh);
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr oldItem=null");
                            }
                        }
                        recentDanceConfigMgr.f288238b.put(dItemInfo.name, dItemInfo);
                    }
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr[JSONException]", e16);
            }
            recentDanceConfigMgr.f288238b.clear();
        }
        return recentDanceConfigMgr;
    }

    private static void n(DItemInfo dItemInfo, String str) {
        byte[] decode = Base64.decode(dItemInfo.icon_url, 0);
        if (decode != null) {
            FileUtils.writeFile(decode, str);
            if (new File(str).exists()) {
                String h16 = h(str);
                if (h16 != null && !"".equals(h16) && h16.equalsIgnoreCase(dItemInfo.icon_md5)) {
                    i(dItemInfo, str);
                } else {
                    FileUtils.deleteFile(str);
                }
            }
        }
    }

    private static void o(DItemInfo dItemInfo, String str) {
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new a(dItemInfo, str);
        httpNetReq.mReqUrl = dItemInfo.icon_url;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str + "_temp";
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (QQAppInterface.class.isInstance(runtime)) {
                ((IHttpEngineService) ((QQAppInterface) runtime).getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                if (QLog.isColorLevel()) {
                    QLog.i("RecentDanceConfigMgr", 2, "processNetWork url: " + dItemInfo.icon_url);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("RecentDanceConfigMgr", 2, "processNetWork[Exception] url: " + dItemInfo.icon_url, e16);
            }
        }
    }

    public static boolean p(String str) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_stage_name_cfg", 4).edit();
        edit.putString("video_dance_stage_name_key", str);
        return edit.commit();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class DItemInfo {
        public int categoryID;
        public BitmapDrawable drawable;
        public boolean forceRefresh;
        public String icon_md5;
        public String icon_url;
        public boolean isContent;
        public String itemID;
        public String name;
        public boolean show;
        public String showName;
        public boolean unfold;

        public DItemInfo(String str) {
            this.show = false;
            this.isContent = true;
            this.unfold = true;
            this.drawable = null;
            this.forceRefresh = false;
            this.name = str;
        }

        public DItemInfo() {
            this.show = false;
            this.isContent = true;
            this.unfold = true;
            this.drawable = null;
            this.forceRefresh = false;
            this.name = "";
        }
    }
}
