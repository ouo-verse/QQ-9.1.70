package com.tencent.mobileqq.pic.compress;

import android.graphics.BitmapFactory;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f258684a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f258685b;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqpic-api/src/main/resources/Inject_InitCompressPicType.yml", version = 1)
    public static HashMap<String, Class<? extends a>> f258686c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f258685b = BaseApplication.getContext().getString(R.string.a7u);
        HashMap<String, Class<? extends a>> hashMap = new HashMap<>();
        f258686c = hashMap;
        hashMap.put("4", PicTypeSharpP.class);
        f258686c.put("3", PicTypeAvif.class);
        f258686c.put("2", PicTypeGif.class);
        f258686c.put("1", PicTypeLong.class);
        f258686c.put("0", PicTypeNormal.class);
        f258686c.put("0_1036", PicTypeKandian.class);
        f258686c.put("0_1035", PicTypeTroopBar.class);
    }

    private static void a(CompressInfo compressInfo, boolean z16) {
        if (compressInfo != null && !TextUtils.isEmpty(compressInfo.D) && !TextUtils.isEmpty(compressInfo.H)) {
            com.tencent.mobileqq.pic.f.b("CompressOperator", compressInfo.f258514d + " checkAndLog()", compressInfo.toString());
            if (compressInfo.f258516f) {
                if (!z16) {
                    long r16 = g.r(compressInfo.D);
                    long r17 = g.r(compressInfo.H);
                    com.tencent.mobileqq.pic.f.b("CompressOperator", compressInfo.f258514d + " checkAndLog()", "src File size:" + r16);
                    com.tencent.mobileqq.pic.f.b("CompressOperator", compressInfo.f258514d + " checkAndLog()", "dest File size:" + r17);
                    if (r16 > 0 && r17 > r16) {
                        if (com.tencent.mobileqq.activity.photo.incompatiblephoto.b.a(compressInfo.D)) {
                            com.tencent.mobileqq.pic.f.b("CompressOperator", compressInfo.f258514d + " checkAndLog()", "src is incompatible ,keep compress file");
                            return;
                        }
                        if (r16 > 1024) {
                            FileUtils.estimateFileType(compressInfo.D);
                            String str = compressInfo.f258514d + " checkAndLog()";
                            String str2 = f258685b;
                            com.tencent.mobileqq.pic.f.b("CompressOperator", str, str2);
                            compressInfo.P = "CompressOperator" + compressInfo.f258514d + " checkAndLog()" + str2;
                            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            if (peekAppRuntime != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("forbid_delete_media_file_in_pub_dir")) {
                                if (compressInfo.H.startsWith(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH))) {
                                    FileUtils.deleteFile(compressInfo.H);
                                } else {
                                    QLog.w("CompressOperator", 1, "CheckAndLog delete file exception!!! srcFile:" + compressInfo.D + " -- size:" + r16 + "\n destFile:" + compressInfo.H + " -- size:" + r17);
                                    ReportController.o(null, "dc00898", "", "", "0X800C3E9", "0X800C3E9", 0, 0, "", "", "", "");
                                }
                            } else {
                                FileUtils.deleteFile(compressInfo.H);
                            }
                            if (f258684a == null) {
                                f258684a = new ArrayList();
                            }
                            if (!f258684a.contains(z16 + compressInfo.D)) {
                                f258684a.add(z16 + compressInfo.D);
                            }
                            compressInfo.H = compressInfo.D;
                            com.tencent.mobileqq.pic.f.d("CompressOperator", compressInfo.f258514d + " checkAndLog()", " destSize > srcSize, info.destPath = info.srcPath");
                            return;
                        }
                        com.tencent.mobileqq.pic.f.b("CompressOperator", compressInfo.f258514d + " checkAndLog()", "src length is too small");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SendPicSrcProblem", "MI 6".equals(DeviceInfoMonitor.getModel()), 0L, r16, null, "");
                        return;
                    }
                    return;
                }
                return;
            }
            compressInfo.H = compressInfo.D;
            com.tencent.mobileqq.pic.f.d("CompressOperator", compressInfo.f258514d + " checkAndLog()", "info.isSuccess = false, info.destPath = info.srcPath");
            return;
        }
        com.tencent.mobileqq.pic.f.d("CompressOperator", " checkAndLog()", "info == null || TextUtils.isEmpty(info.srcPath) || TextUtils.isEmpty(info.destPath)");
    }

    public static boolean b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BaseImageUtil.decodeFileWithBufferedStream(str, options);
        } catch (Exception e16) {
            QLog.e(PeakConstants.TAG, 1, e16, new Object[0]);
        } catch (OutOfMemoryError e17) {
            QLog.e(PeakConstants.TAG, 1, e17, new Object[0]);
        }
        int i3 = options.outHeight;
        int i16 = options.outWidth;
        if (QLog.isColorLevel()) {
            QLog.d(PeakConstants.TAG, 2, "isLargeFile w:" + i16 + ",h:" + i3);
        }
        if (i3 == -1 || i16 == -1) {
            return false;
        }
        if (i3 > i16 * 3 || i16 > i3 * 3) {
            return true;
        }
        return false;
    }

    static a c(CompressInfo compressInfo) {
        if (compressInfo != null) {
            Class<? extends a> cls = f258686c.get(compressInfo.K + "_" + compressInfo.f258515e);
            if (cls == null) {
                cls = f258686c.get(compressInfo.K + "");
            }
            if (cls != null) {
                try {
                    Constructor<? extends a> declaredConstructor = cls.getDeclaredConstructor(CompressInfo.class);
                    declaredConstructor.setAccessible(true);
                    return declaredConstructor.newInstance(compressInfo);
                } catch (Exception e16) {
                    com.tencent.mobileqq.pic.f.d("CompressOperator", " picTypeFactory", e16.getMessage());
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public static boolean d(CompressInfo compressInfo) {
        HashMap<String, String> hashMap;
        if (compressInfo == null) {
            return false;
        }
        com.tencent.mobileqq.pic.f.b("CompressOperator", compressInfo.f258514d + " CompressOperator.start()", "processName = " + MobileQQ.sMobileQQ.getQQProcessName() + ",srcPath = " + compressInfo.D);
        long currentTimeMillis = System.currentTimeMillis();
        int start = HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{Process.myTid()}, 2000, 203, 128L, Process.myTid(), "sendPic", true);
        boolean e16 = e(compressInfo, false);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (HardCoderManager.getInstance().isSupported()) {
            hashMap = new HashMap<>();
            hashMap.put("hcState", String.valueOf(HardCoderManager.getInstance().getState()));
            hashMap.put("model", DeviceInfoMonitor.getModel());
        } else {
            hashMap = null;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AIOPicCompress", e16, currentTimeMillis2, 0L, hashMap, "");
        if (start != 0) {
            HardCoderManager.getInstance().stop(start);
        }
        if (QLog.isColorLevel()) {
            QLog.d("CompressOperator", 2, "pic compress cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return e16;
    }

    private static boolean e(CompressInfo compressInfo, boolean z16) {
        boolean a16;
        if (compressInfo != null && FileUtils.fileExistsAndNotEmpty(compressInfo.D)) {
            List<String> list = f258684a;
            if (list != null) {
                if (list.contains(z16 + compressInfo.D)) {
                    String str = compressInfo.f258514d + " startImpl()";
                    String str2 = f258685b;
                    com.tencent.mobileqq.pic.f.b("CompressOperator", str, str2);
                    compressInfo.P = "CompressOperator" + compressInfo.f258514d + " startImpl()" + str2;
                    compressInfo.H = compressInfo.D;
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(compressInfo.H, options);
                    compressInfo.I = options.outWidth;
                    compressInfo.J = options.outHeight;
                    return true;
                }
            }
            compressInfo.M = NetworkUtil.getNetworkType(BaseApplication.getContext());
            if (BaseImageUtil.isGifFile(compressInfo.D)) {
                compressInfo.K = 2;
            } else if (b(compressInfo.D)) {
                compressInfo.K = 1;
            } else {
                compressInfo.K = 0;
            }
            if (QLog.isColorLevel()) {
                com.tencent.mobileqq.pic.f.b("CompressOperator", " startImpl()", "info:" + compressInfo);
            }
            a c16 = c(compressInfo);
            if (c16 != null) {
                if (z16) {
                    a16 = c16.b();
                } else {
                    a16 = c16.a();
                }
                compressInfo.f258516f = a16;
            }
            a(compressInfo, z16);
            if (compressInfo.H != null) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                try {
                    BaseImageUtil.decodeFileWithBufferedStream(compressInfo.H, options2);
                    compressInfo.I = options2.outWidth;
                    compressInfo.J = options2.outHeight;
                } catch (OutOfMemoryError unused) {
                    return false;
                }
            }
            return compressInfo.f258516f;
        }
        com.tencent.mobileqq.pic.f.d("CompressOperator", " startImpl()", "info == null || TextUtils.isEmpty(info.srcPath)");
        return false;
    }

    public static boolean f(CompressInfo compressInfo) {
        if (compressInfo == null) {
            return false;
        }
        com.tencent.mobileqq.pic.f.b("CompressOperator", compressInfo.f258514d + " startThumbnail()", "");
        return e(compressInfo, true);
    }

    public static int g(int i3) {
        if (i3 == 2) {
            return 2;
        }
        return 0;
    }
}
