package com.tencent.mobileqq.wink.editor.export;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import common.config.service.QzoneConfig;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class q {
    private static int a() {
        QzoneConfig.getInstance();
        if (QzoneConfig.getWinkBitRateTestEnable()) {
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            if (!TextUtils.isEmpty(account)) {
                try {
                    int parseInt = Integer.parseInt(account.substring(account.length() - 2));
                    QzoneConfig.getInstance();
                    if (parseInt > QzoneConfig.getWinkBitRateTestEndNum()) {
                        return 1;
                    }
                    return 2;
                } catch (Exception e16) {
                    w53.b.e("[PublishUpload]WinkExportTestManager", e16);
                }
            }
        }
        return 1;
    }

    public static boolean b() {
        int hDModeDownToThreeEnable = QzoneConfig.getHDModeDownToThreeEnable();
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (!TextUtils.isEmpty(account)) {
            try {
                if (Integer.parseInt(account.substring(account.length() - 2)) < hDModeDownToThreeEnable) {
                    return true;
                }
            } catch (Exception e16) {
                w53.b.e("[PublishUpload]WinkExportTestManager", e16);
            }
        }
        return false;
    }

    public static boolean c() {
        QzoneConfig.getInstance();
        if (QzoneConfig.getUseUploadSeepToExportEnable()) {
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            if (!TextUtils.isEmpty(account)) {
                try {
                    if (Integer.parseInt(account.substring(account.length() - 2)) < 100) {
                        return true;
                    }
                } catch (Exception e16) {
                    w53.b.e("[PublishUpload]WinkExportTestManager", e16);
                }
            }
        }
        return false;
    }

    public static boolean d(WinkExportParams winkExportParams) {
        boolean z16;
        if (Build.VERSION.SDK_INT <= 25 || MobileQQ.sProcessId != 9) {
            return false;
        }
        try {
            z16 = "QCIRCLE".equals(winkExportParams.D);
        } catch (Exception e16) {
            w53.b.e("[PublishUpload]WinkExportTestManager", e16);
            z16 = false;
        }
        if (z16) {
            return WinkExportUtils.Q();
        }
        int winkNewCompressAPIEnable = QzoneConfig.getWinkNewCompressAPIEnable();
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (!TextUtils.isEmpty(account)) {
            try {
                if (Integer.parseInt(account.substring(account.length() - 2)) < winkNewCompressAPIEnable) {
                    return true;
                }
            } catch (Exception e17) {
                w53.b.e("[PublishUpload]WinkExportTestManager", e17);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(int i3, long j3, long j16) {
        long f16;
        z93.c f17;
        long j17 = 0;
        if (j3 > 0 && j16 > 0) {
            long j18 = (j3 / j16) * 1000;
            w53.b.f("[PublishUpload]WinkExportTestManager", "setUploadSpeed: nettype" + i3 + " nowSpeed " + j18);
            int i16 = 0;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                ar arVar = ar.f326685a;
                                f16 = arVar.f("key_video_compress_speed_5G", 1126400L);
                                if (f16 != 1126400) {
                                    arVar.p("key_video_compress_speed_5G", (f16 + j18) / 2);
                                    j17 = f16;
                                } else {
                                    arVar.p("key_video_compress_speed_5G", j18);
                                    i16 = 1;
                                    j17 = f16;
                                }
                            }
                            WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                            f17 = Wink.INSTANCE.f();
                            if (f17 != null) {
                                f17.a(reportData, 1);
                                return;
                            }
                            return;
                        }
                        ar arVar2 = ar.f326685a;
                        f16 = arVar2.f("key_video_compress_speed_4G", 512000L);
                        if (f16 != 512000) {
                            arVar2.p("key_video_compress_speed_4G", (f16 + j18) / 2);
                            j17 = f16;
                            WinkPublishQualityReportData reportData2 = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                            f17 = Wink.INSTANCE.f();
                            if (f17 != null) {
                            }
                        } else {
                            arVar2.p("key_video_compress_speed_4G", j18);
                            i16 = 1;
                            j17 = f16;
                            WinkPublishQualityReportData reportData22 = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                            f17 = Wink.INSTANCE.f();
                            if (f17 != null) {
                            }
                        }
                    } else {
                        ar arVar3 = ar.f326685a;
                        f16 = arVar3.f("key_video_compress_speed_3G", 358400L);
                        if (f16 != 358400) {
                            arVar3.p("key_video_compress_speed_3G", (f16 + j18) / 2);
                            j17 = f16;
                            WinkPublishQualityReportData reportData222 = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                            f17 = Wink.INSTANCE.f();
                            if (f17 != null) {
                            }
                        } else {
                            arVar3.p("key_video_compress_speed_3G", j18);
                            i16 = 1;
                            j17 = f16;
                            WinkPublishQualityReportData reportData2222 = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                            f17 = Wink.INSTANCE.f();
                            if (f17 != null) {
                            }
                        }
                    }
                } else {
                    ar arVar4 = ar.f326685a;
                    f16 = arVar4.f("key_video_compress_speed_2G", 256000L);
                    if (f16 != 256000) {
                        arVar4.p("key_video_compress_speed_2G", (f16 + j18) / 2);
                        j17 = f16;
                        WinkPublishQualityReportData reportData22222 = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                        f17 = Wink.INSTANCE.f();
                        if (f17 != null) {
                        }
                    } else {
                        arVar4.p("key_video_compress_speed_2G", j18);
                        i16 = 1;
                        j17 = f16;
                        WinkPublishQualityReportData reportData222222 = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                        f17 = Wink.INSTANCE.f();
                        if (f17 != null) {
                        }
                    }
                }
            } else {
                ar arVar5 = ar.f326685a;
                f16 = arVar5.f("key_video_compress_speed_WIFI", 1536000L);
                if (f16 != 1536000) {
                    arVar5.p("key_video_compress_speed_WIFI", (f16 + j18) / 2);
                    j17 = f16;
                    WinkPublishQualityReportData reportData2222222 = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                    f17 = Wink.INSTANCE.f();
                    if (f17 != null) {
                    }
                } else {
                    arVar5.p("key_video_compress_speed_WIFI", j18);
                    i16 = 1;
                    j17 = f16;
                    WinkPublishQualityReportData reportData22222222 = new WinkPublishQualityReportData.Builder().eventId("E_VIDEO_EXPORT_JUGE").retCode("0").ext1("setUploadSpeed").ext2(j17 + "").ext3(j18 + "").ext4(i16 + "").ext5(j16 + "").ext6(i3 + "").attachInfo("Peak").getReportData();
                    f17 = Wink.INSTANCE.f();
                    if (f17 != null) {
                    }
                }
            }
        }
    }

    public static void f(ExportOutput exportOutput, boolean z16, int i3) {
        double max;
        double d16;
        int i16;
        double min;
        double d17;
        int a16 = a();
        if (z16) {
            if (a16 == 2) {
                i16 = 7650000;
                if (i3 > 30) {
                    min = Math.min(((i3 * 1.0d) - 30.0d) / 30.0d, 1.0d);
                    d17 = 3060000.0d;
                    i16 += (int) (min * d17);
                }
            } else {
                max = Math.max((i3 * 1.0d) / 30.0d, 1.0d);
                d16 = 5242880.0d;
                i16 = (int) (max * d16);
            }
        } else if (a16 == 2) {
            i16 = sdk_event_log.SdkEventDimension.EVENT_CLICK;
            if (i3 > 30) {
                min = Math.min(((i3 * 1.0d) - 30.0d) / 30.0d, 1.0d);
                d17 = 1520000.0d;
                i16 += (int) (min * d17);
            }
        } else {
            max = Math.max((i3 * 1.0d) / 30.0d, 1.0d);
            d16 = 3145728.0d;
            i16 = (int) (max * d16);
        }
        exportOutput.setVideoBitRate(i16);
        w53.b.f("[PublishUpload]WinkExportTestManager", "setVideoBitRate: testMode" + a16 + " VideoBitRate: " + i16);
    }
}
