package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.ba;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader;
import com.tencent.mobileqq.emoticon.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IEmoticonService;
import com.tencent.qqnt.kernel.api.IYellowFaceForManagerService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelYellowFaceDownloadCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PullMomentType;
import cooperation.photoplus.sticker.Sticker;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class m implements e, n.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private String f204842b;

    /* renamed from: c, reason: collision with root package name */
    private final QQSysFaceResImpl f204843c;

    /* renamed from: d, reason: collision with root package name */
    private final QQEmojiResImpl f204844d;

    /* renamed from: e, reason: collision with root package name */
    protected List<String> f204845e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f204846f;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f204847g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f204848h;

    /* renamed from: i, reason: collision with root package name */
    private QQSysAndEmojiResReloader.IResReloadListener f204849i;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f204843c = new QQSysFaceResImpl();
        this.f204844d = new QQEmojiResImpl();
        this.f204845e = new ArrayList(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(int i3, long j3, String str, String str2) {
        QLog.d("LegacyQQSysAndEmojiMgr", 1, "nt download -> result: " + i3 + "; reason: " + j3 + "; fullMd5: " + str + " ; errMsg: " + str2);
        if (i3 == 0 && j3 == 0) {
            E(2, str);
            this.f204843c.resDownloadFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(final int i3, final String str, final long j3, final String str2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticon.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.B(i3, j3, str2, str);
            }
        });
    }

    public static long D(int i3) {
        return BaseApplication.getContext().getSharedPreferences(QQSysAndEmojiResMgr.SP_QQ_EMOTICON, 4).getLong("size_type_" + i3, 0L);
    }

    public static boolean E(int i3, String str) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(QQSysAndEmojiResMgr.SP_QQ_EMOTICON, 4).edit();
        edit.putString("md5_type_" + i3, str);
        QLog.d("LegacyQQSysAndEmojiMgr", 1, "saveResItem:", Integer.valueOf(i3), " ,md5:", str);
        return edit.commit();
    }

    public static void F(int i3, long j3) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(QQSysAndEmojiResMgr.SP_QQ_EMOTICON, 4).edit();
        edit.putLong("size_type_" + i3, j3);
        QLog.d("LegacyQQSysAndEmojiMgr", 1, "saveResItem:", Integer.valueOf(i3), " ,size:", Long.valueOf(j3));
        edit.apply();
    }

    private void G(@NonNull QQSysAndEmojiResMgr.DownloadResItem downloadResItem) {
        String signature = downloadResItem.getSignature();
        if (this.f204845e.contains(signature)) {
            if (QLog.isColorLevel()) {
                QLog.d("LegacyQQSysAndEmojiMgr", 2, "already in download list! resType=", Integer.valueOf(downloadResItem.mType));
            }
        } else {
            this.f204845e.add(signature);
            n.d(downloadResItem, q(), this);
        }
    }

    private boolean H(String str, String str2) {
        try {
            FileUtils.uncompressZip(str, str2, false);
            return true;
        } catch (IOException e16) {
            QLog.e("LegacyQQSysAndEmojiMgr", 1, "unzipFile error ", e16);
            return false;
        }
    }

    private void J(boolean z16) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("LegacyQQSysAndEmojiMgr", 2, "updateExtAniStickerConfig");
        }
        oa1.c a16 = ba.INSTANCE.a();
        if (a16 != null) {
            str = a16.f422289e;
        } else {
            str = "";
        }
        Pair<JSONObject, Boolean> c16 = n.c(6, p(), QQSysAndEmojiResInfo.EXT_ANI_STICKER_CONFIG_FILE_NAME, str, false);
        JSONObject jSONObject = (JSONObject) c16.first;
        this.f204847g = jSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f204843c.parseConfigData(new f(this.f204846f, jSONObject));
        this.f204844d.parseConfigData(new f(this.f204846f, null));
        if (!z16) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) c16.second).booleanValue()) {
            arrayList.addAll(Arrays.asList(6));
            QLog.d("LegacyQQSysAndEmojiMgr", 1, "updateExtAniStickerConfig, download res");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticon.h
                @Override // java.lang.Runnable
                public final void run() {
                    m.y(arrayList);
                }
            }, 128, null, false);
        }
    }

    private void K(boolean z16) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("LegacyQQSysAndEmojiMgr", 2, "updateFaceConfig");
        }
        oa1.d c16 = ba.INSTANCE.c();
        if (c16 != null) {
            str = c16.f422296c;
        } else {
            str = "";
        }
        Pair<JSONObject, Boolean> c17 = n.c(1, p(), QQSysAndEmojiResInfo.FACE_CONFIG_FILE_NAME, str, true);
        JSONObject jSONObject = (JSONObject) c17.first;
        this.f204846f = jSONObject;
        this.f204843c.parseConfigData(new f(jSONObject, this.f204847g));
        this.f204844d.parseConfigData(new f(this.f204846f, null));
        if (!z16) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) c17.second).booleanValue()) {
            arrayList.addAll(Arrays.asList(1));
            QLog.d("LegacyQQSysAndEmojiMgr", 1, "updateFaceConfig, download res");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticon.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.z(arrayList);
                }
            }, 128, null, false);
        }
    }

    private void L(boolean z16) {
        String p16 = p();
        String q16 = q();
        String str = ba.INSTANCE.c().f422305l;
        IYellowFaceForManagerService yellowFaceForManagerService = ((IEmoticonService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IEmoticonService.class, "")).getYellowFaceForManagerService();
        if (yellowFaceForManagerService == null) {
            QLog.e("LegacyQQSysAndEmojiMgr", 1, "[useNtDownloadQQSysAndEmoji] error, faceService is null!");
        } else {
            yellowFaceForManagerService.setHistory(o(2), new IOperateCallback() { // from class: com.tencent.mobileqq.emoticon.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    m.A(i3, str2);
                }
            });
            yellowFaceForManagerService.download(str, p16, q16, z16, new IKernelYellowFaceDownloadCallback() { // from class: com.tencent.mobileqq.emoticon.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelYellowFaceDownloadCallback
                public final void onResult(int i3, String str2, long j3, String str3) {
                    m.this.C(i3, str2, j3, str3);
                }
            });
        }
    }

    public static boolean j(int i3, String str) {
        String string = BaseApplication.getContext().getSharedPreferences(QQSysAndEmojiResMgr.SP_QQ_EMOTICON, 4).getString("md5_type_" + i3, "");
        boolean equals = string.equals(str) ^ true;
        QLog.d("LegacyQQSysAndEmojiMgr", 1, "type:", Integer.valueOf(i3), " ,needDownload:", Boolean.valueOf(equals), " ,curr:", string, " ,new:", str);
        return equals;
    }

    private Map<Integer, QQSysAndEmojiResMgr.DownloadResItem> l() {
        HashMap hashMap = new HashMap();
        oa1.c a16 = ba.INSTANCE.a();
        if (a16 == null) {
            QLog.d("LegacyQQSysAndEmojiMgr", 1, "[getSysAndEmojiDownloadConfigMap] configBean is null");
            return hashMap;
        }
        if (!TextUtils.isEmpty(a16.f422288d) && !TextUtils.isEmpty(a16.f422289e)) {
            hashMap.put(6, new QQSysAndEmojiResMgr.DownloadResItem(a16.f422288d, a16.f422289e, 6));
        }
        if (!TextUtils.isEmpty(a16.f422290f) && !TextUtils.isEmpty(a16.f422291h)) {
            hashMap.put(7, new QQSysAndEmojiResMgr.DownloadResItem(a16.f422290f, a16.f422291h, 7));
        }
        if (!TextUtils.isEmpty(a16.f422292i) && !TextUtils.isEmpty(a16.f422293m)) {
            hashMap.put(9, new QQSysAndEmojiResMgr.DownloadResItem(a16.f422292i, a16.f422293m, 9));
        }
        return hashMap;
    }

    private String m(int i3, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(p());
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        sb5.append("qlottie");
                    }
                } else {
                    sb5.append("sysface_res/apng");
                }
            } else {
                sb5.append("emoji_res");
            }
        } else {
            sb5.append("sysface_res/static");
        }
        sb5.append(str);
        return sb5.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r3 != 4) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String n(int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 2) {
            if (i3 == 3) {
                sb5.append(String.format("/emoji_%03d.png", Integer.valueOf(QQEmojiUtil.getEmojiLocalId(i16))));
            }
            return sb5.toString();
        }
        sb5.append("/s");
        sb5.append(i16);
        sb5.append(".png");
        return sb5.toString();
    }

    public static String o(int i3) {
        return BaseApplication.getContext().getSharedPreferences(QQSysAndEmojiResMgr.SP_QQ_EMOTICON, 4).getString("md5_type_" + i3, "");
    }

    private String p() {
        if (!TextUtils.isEmpty(this.f204842b)) {
            return this.f204842b;
        }
        String str = "/qq_emoticon_res";
        try {
            File file = new File(BaseApplication.getContext().getFilesDir(), "/qq_emoticon_res");
            if (!file.exists()) {
                file.mkdirs();
            }
            str = file.getAbsolutePath() + File.separator;
            this.f204842b = str;
            return str;
        } catch (NullPointerException e16) {
            QLog.e("LegacyQQSysAndEmojiMgr", 1, "npe:", e16);
            return str;
        }
    }

    private static String q() {
        StringBuilder sb5 = new StringBuilder(AppConstants.SDCARD_PATH);
        sb5.append("emoji");
        String str = File.separator;
        sb5.append(str);
        sb5.append("res");
        sb5.append(str);
        return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
    }

    private Map<Integer, QQSysAndEmojiResMgr.DownloadResItem> r() {
        oa1.d c16 = ba.INSTANCE.c();
        HashMap hashMap = new HashMap();
        if (c16 == null) {
            QLog.d("LegacyQQSysAndEmojiMgr", 1, "[getSysAndEmojiDownloadConfigMap] configBean is null");
            return hashMap;
        }
        if (!TextUtils.isEmpty(c16.f422295b) && !TextUtils.isEmpty(c16.f422296c)) {
            hashMap.put(1, new QQSysAndEmojiResMgr.DownloadResItem(c16.f422295b, c16.f422296c, 1));
        }
        if (!TextUtils.isEmpty(c16.f422297d) && !TextUtils.isEmpty(c16.f422298e)) {
            hashMap.put(2, new QQSysAndEmojiResMgr.DownloadResItem(c16.f422297d, c16.f422298e, 2));
        }
        if (!TextUtils.isEmpty(c16.f422299f) && !TextUtils.isEmpty(c16.f422300g)) {
            hashMap.put(3, new QQSysAndEmojiResMgr.DownloadResItem(c16.f422299f, c16.f422300g, 3));
        }
        if (!TextUtils.isEmpty(c16.f422303j) && !TextUtils.isEmpty(c16.f422304k)) {
            hashMap.put(5, new QQSysAndEmojiResMgr.DownloadResItem(c16.f422303j, c16.f422304k, 5));
        }
        return hashMap;
    }

    private boolean s(@NonNull QQSysAndEmojiResMgr.DownloadResItem downloadResItem) {
        if (downloadResItem.mType != 2 || !QQSysFaceUtil.isSysFaceUseNtDownload()) {
            return false;
        }
        QLog.d("LegacyQQSysAndEmojiMgr", 1, "handleDownloadSysFaceRes useNtDownload=true");
        try {
            L(false);
        } catch (Throwable th5) {
            QLog.d("LegacyQQSysAndEmojiMgr", 1, "nt download error:" + th5.getMessage());
        }
        return true;
    }

    private void t(String str) {
        I(6, new File(str + QQSysAndEmojiResInfo.EXT_ANI_STICKER_CONFIG_FILE_NAME));
        J(true);
    }

    private void u(String str) {
        String str2 = str + QQSysAndEmojiResInfo.EXT_ANI_STICKER_QLOTTIE_FOLDER_NAME;
        if (FileUtils.copyDirectory(str2, str + QQSysAndEmojiResInfo.QLOTTIE_FOLDER_NAME, true, true, false) == 0) {
            QQSysAndEmojiResReloader.IResReloadListener iResReloadListener = this.f204849i;
            if (iResReloadListener != null) {
                iResReloadListener.resDownloadFinish();
            }
        } else {
            QLog.e("LegacyQQSysAndEmojiMgr", 1, "[handleUnzipExtAniStickerLottieResSuccess] copy directory failed!");
        }
        FileUtils.deleteDirectory(str2);
    }

    private void v(String str) {
        String str2 = str + QQSysAndEmojiResInfo.EXT_ANI_STICKER_SYS_FACE_RES_FOLDER_NAME;
        if (FileUtils.copyDirectory(str2, str + QQSysAndEmojiResInfo.SYS_FACE_RES_FOLDER_NAME, true, true, false) == 0) {
            this.f204843c.resDownloadFinish();
        } else {
            QLog.e("LegacyQQSysAndEmojiMgr", 1, "[handleUnzipExtAniStickerSysFaceResSuccess] copy directory failed!");
        }
        FileUtils.deleteDirectory(str2);
    }

    private void w(String str) {
        I(1, new File(str + QQSysAndEmojiResInfo.FACE_CONFIG_FILE_NAME));
        K(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        K(true);
        J(true);
        this.f204848h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(List list) {
        QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(List list) {
        QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes(list);
    }

    protected void I(int i3, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) file);
        } else if (file != null && file.exists()) {
            F(i3, file.length());
        } else {
            QLog.i("LegacyQQSysAndEmojiMgr", 1, "updateConfigContentMd5, file not exist");
        }
    }

    protected int M(String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            return 103;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("LegacyQQSysAndEmojiMgr", 2, "verifyResMD5 file not exist!");
                return 102;
            }
            return 102;
        }
        try {
            try {
                str3 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
            } catch (Exception unused) {
                str3 = null;
            }
        } catch (UnsatisfiedLinkError unused2) {
            str3 = com.tencent.qqprotect.singleupdate.a.d(file);
        }
        if (QLog.isColorLevel()) {
            QLog.d("LegacyQQSysAndEmojiMgr", 2, file.getName() + ", verifyResMD5 configMd5:" + str2 + ", calMd5:" + str3);
        }
        if (str2.equalsIgnoreCase(str3)) {
            return 100;
        }
        return 104;
    }

    @Override // com.tencent.mobileqq.emoticon.n.a
    public void a(@NonNull QQSysAndEmojiResMgr.DownloadResItem downloadResItem, @NonNull String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, downloadResItem, str, Boolean.valueOf(z16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (z16) {
            int M = M(str, downloadResItem.mMd5);
            if (M == 100) {
                String p16 = p();
                if (!H(str, p16)) {
                    QLog.e("LegacyQQSysAndEmojiMgr", 1, "[onResp] unzipFile failed! path=", str);
                } else {
                    QLog.d("LegacyQQSysAndEmojiMgr", 1, "[onResp] update res, type=", Integer.valueOf(downloadResItem.mType), ", name=", downloadResItem.mName, ", md5=", downloadResItem.mMd5, ", url=" + downloadResItem.mUrl);
                    E(downloadResItem.mType, downloadResItem.mMd5);
                    int i3 = downloadResItem.mType;
                    if (i3 == 1) {
                        w(p16);
                    } else if (i3 == 2) {
                        this.f204843c.resDownloadFinish();
                    } else if (i3 == 3) {
                        this.f204844d.resDownloadFinish();
                    } else if (i3 == 5) {
                        QQSysAndEmojiResReloader.IResReloadListener iResReloadListener = this.f204849i;
                        if (iResReloadListener != null) {
                            iResReloadListener.resDownloadFinish();
                        }
                    } else if (i3 == 6) {
                        t(p16);
                    } else if (i3 == 7) {
                        v(p16);
                    } else if (i3 == 9) {
                        u(p16);
                    }
                }
            } else {
                QLog.e("LegacyQQSysAndEmojiMgr", 1, "verifyResMD5 failed! " + M);
            }
        } else {
            QLog.e("LegacyQQSysAndEmojiMgr", 1, "[onResp] failed! type=", Integer.valueOf(downloadResItem.mType));
        }
        k(str);
        String signature = downloadResItem.getSignature();
        this.f204845e.remove(signature);
        if (QLog.isColorLevel()) {
            QLog.d("LegacyQQSysAndEmojiMgr", 2, "[onResp] type:", Integer.valueOf(downloadResItem.mType), " ,cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), " ,signature:", signature.substring(signature.lastIndexOf(47)));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.e
    @NonNull
    public QQEmojiResImpl b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQEmojiResImpl) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f204844d;
    }

    @Override // com.tencent.mobileqq.emoticon.e
    @NonNull
    public QQSysFaceResImpl c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQSysFaceResImpl) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f204843c;
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void downloadEmoticonRes(List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            return;
        }
        Map<Integer, QQSysAndEmojiResMgr.DownloadResItem> r16 = r();
        r16.putAll(l());
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            QQSysAndEmojiResMgr.DownloadResItem downloadResItem = r16.get(Integer.valueOf(intValue));
            if (downloadResItem != null && !s(downloadResItem) && j(intValue, downloadResItem.mMd5)) {
                G(downloadResItem);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NonNull
    public String getAniStickerLoadingResPath(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerRandomResultFullResPath(int i3, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), str, str2, str3);
        }
        StringBuilder sb5 = new StringBuilder();
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str);
        sb5.append(str4);
        sb5.append(str2);
        sb5.append(str4);
        sb5.append(str2);
        sb5.append("_");
        sb5.append(str3);
        sb5.append(Sticker.JSON_SUFFIX);
        return m(5, sb5.toString());
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerResPath(int i3, @NotNull String str, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), str, str2);
        }
        StringBuilder sb5 = new StringBuilder();
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str);
        sb5.append(str3);
        sb5.append(str2);
        sb5.append(str3);
        sb5.append(str2);
        sb5.append(Sticker.JSON_SUFFIX);
        return m(5, sb5.toString());
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerSurpriseFullResPath(int i3, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, str2, str3, Boolean.valueOf(z16));
        }
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            String str4 = File.separator;
            sb5.append(str4);
            sb5.append(str);
            sb5.append(str4);
            sb5.append(str2);
            sb5.append(str4);
            sb5.append(CacheManager.SURPRISE_RESOURCE_PATH);
            sb5.append(str4);
            sb5.append(str3);
            sb5.append("_padLandScape.json");
            String m3 = m(5, sb5.toString());
            if (FileUtils.fileExistsAndNotEmpty(m3)) {
                return m3;
            }
        }
        StringBuilder sb6 = new StringBuilder();
        String str5 = File.separator;
        sb6.append(str5);
        sb6.append(str);
        sb6.append(str5);
        sb6.append(str2);
        sb6.append(str5);
        sb6.append(CacheManager.SURPRISE_RESOURCE_PATH);
        sb6.append(str5);
        sb6.append(str3);
        sb6.append(Sticker.JSON_SUFFIX);
        return m(5, sb6.toString());
    }

    @Override // com.tencent.mobileqq.emoticon.d
    public String getFullResPath(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return m(i3, n(i3, i16));
    }

    @Override // com.tencent.mobileqq.emoticon.d
    public Pair<String, Boolean> getSysFaceFullResPath(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Pair) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 == 4) {
            String m3 = m(4, n(4, i16));
            if (new File(m3).exists()) {
                return new Pair<>(m3, Boolean.TRUE);
            }
        }
        String m16 = m(2, n(2, i16));
        if (new File(m16).exists()) {
            if (QLog.isColorLevel()) {
                QLog.i("LegacyQQSysAndEmojiMgr", 2, "getSysFaceFullResPath() ----- static  path:" + m16);
            }
            return new Pair<>(m16, Boolean.FALSE);
        }
        return new Pair<>(null, Boolean.FALSE);
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void initConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f204848h || this.f204843c.getConfigEmoCount() > 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LegacyQQSysAndEmojiMgr", 2, "initConfig");
        }
        this.f204848h = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticon.g
            @Override // java.lang.Runnable
            public final void run() {
                m.this.x();
            }
        }, 64, null, true);
    }

    protected void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void refreshConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void setLottieResReloadListener(QQSysAndEmojiResReloader.IResReloadListener iResReloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) iResReloadListener);
        } else {
            this.f204849i = iResReloadListener;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void refreshConfig(@NonNull PullMomentType pullMomentType, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, this, pullMomentType, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(int i3, String str) {
    }
}
