package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ae {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.filebrowser.view.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f209318d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f209319e;

        a(Context context, String str) {
            this.f209318d = context;
            this.f209319e = str;
        }

        @Override // com.tencent.mobileqq.filebrowser.view.a, android.text.style.ClickableSpan
        public void onClick(View view) {
            ae.l(this.f209318d, this.f209319e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(Exception exc);

        void b(String str, String str2);
    }

    public static String d(long j3) {
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        if (j3 <= 0) {
            return "00:00:00";
        }
        long j16 = j3 / 1000;
        long j17 = j16 / 3600;
        if (j17 > 9) {
            sb5 = new StringBuilder();
            sb5.append(j17);
            sb5.append("");
        } else {
            sb5 = new StringBuilder();
            sb5.append("0");
            sb5.append(j17);
        }
        String sb8 = sb5.toString();
        long j18 = j16 % 3600;
        long j19 = j18 / 60;
        if (j19 > 9) {
            sb6 = new StringBuilder();
            sb6.append(j19);
            sb6.append("");
        } else {
            sb6 = new StringBuilder();
            sb6.append("0");
            sb6.append(j19);
        }
        String sb9 = sb6.toString();
        long j26 = j18 % 60;
        if (j26 > 9) {
            sb7 = new StringBuilder();
            sb7.append(j26);
            sb7.append("");
        } else {
            sb7 = new StringBuilder();
            sb7.append("0");
            sb7.append(j26);
        }
        return sb8 + ":" + sb9 + ":" + sb7.toString();
    }

    public static int e(int i3) {
        switch (i3) {
            case 0:
                return 7;
            case 1:
                return 9;
            case 2:
                return 8;
            case 3:
                return 1;
            case 4:
                return 6;
            case 5:
            case 8:
            default:
                return 10;
            case 6:
                return 2;
            case 7:
                return 3;
            case 9:
                return 4;
            case 10:
                return 5;
        }
    }

    public static int f(int i3) {
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 6) {
                    return 3;
                }
                if (i3 != 7) {
                    if (i3 == 9) {
                        return 4;
                    }
                    return 6;
                }
                return 2;
            }
            return 5;
        }
        return 1;
    }

    public static int g(int i3) {
        if (i3 != 13) {
            switch (i3) {
                case 1:
                case 2:
                    return 0;
                case 3:
                case 4:
                    break;
                case 5:
                case 6:
                    return 3000;
                default:
                    return -1;
            }
        }
        return 1;
    }

    public static boolean h(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null || fileManagerEntity.entrance != 9 || fileManagerEntity.cloudType == 3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(b bVar, StringBuilder sb5, String str) {
        bVar.b(sb5.toString(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(Context context, final b bVar) {
        try {
            String string = new JSONObject(new String(HttpUtil.openUrlForByte(context, "https://appchannel.html5.qq.com/package?app=qqbrowser", "GET", null, null))).getString("downurl");
            int indexOf = string.indexOf("qqbrowser_") + 10;
            int indexOf2 = string.indexOf("GA_") + 3;
            final String substring = string.substring(indexOf, indexOf + 6);
            final StringBuilder sb5 = new StringBuilder(string.substring(indexOf2, indexOf2 + 8));
            sb5.insert(4, "/").insert(7, "/");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ae.i(ae.b.this, sb5, substring);
                }
            });
        } catch (IOException | JSONException e16) {
            QLog.e("QBrowserUtils", 1, "initQQBrowserDeveloperDesc", e16);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ae.b.this.a(e16);
                }
            });
        }
    }

    public static void l(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public static void m(String str, String str2, String str3, String str4, boolean z16) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && !TextUtils.isEmpty(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin())) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_event", "qqfile_page");
            hashMap.put("action", str);
            hashMap.put("file_type", str2);
            hashMap.put("file_suffix", str3);
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.BUTTON_NAME, str4);
            hashMap.put("is_use_new_tbs_view", String.valueOf(z16));
            QQBeaconReport.reportWithAppKey("0M300GVKSH1IMBEK", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "tbs_qq_file", hashMap);
            if (QLog.isColorLevel()) {
                QLog.d("QBrowserUtils", 1, "pageEventReport\n appKey : 0M300GVKSH1IMBEK\n uin : " + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "\n eventName : tbs_qq_file\n sub_event" + ProgressTracer.SEPARATOR + "qqfile_page\n action" + ProgressTracer.SEPARATOR + str + "\n file_type" + ProgressTracer.SEPARATOR + str2 + "\n file_suffix" + ProgressTracer.SEPARATOR + str3 + "\n " + WinkDaTongReportConstant.ElementParamKey.BUTTON_NAME + ProgressTracer.SEPARATOR + str4 + "\n is_use_new_tbs_view" + ProgressTracer.SEPARATOR + z16);
                return;
            }
            return;
        }
        QLog.e("QBrowserUtils", 1, "pageEventReport peekAppRuntime or currentUin error!");
    }

    public static void n(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, int i3, boolean z16, boolean z17) {
        int i16;
        int i17 = actionSheetItem.action;
        int i18 = 5;
        int i19 = 4;
        int i26 = 3;
        if (i17 != 2) {
            i16 = 6;
            if (i17 != 6) {
                if (i17 != 54) {
                    if (i17 != 64) {
                        if (i17 != 70 && i17 != 82) {
                            if (i17 != 26) {
                                if (i17 != 27) {
                                    switch (i17) {
                                        case 120:
                                            i16 = 3;
                                            break;
                                        case 121:
                                            i16 = 10;
                                            break;
                                        case 122:
                                            i16 = 8;
                                            break;
                                        case 123:
                                            i16 = 9;
                                            break;
                                        default:
                                            i16 = 0;
                                            break;
                                    }
                                } else {
                                    i16 = 4;
                                }
                            } else {
                                i16 = 2;
                            }
                        } else {
                            i16 = 5;
                        }
                    } else {
                        i16 = 11;
                    }
                } else {
                    i16 = 7;
                }
            }
        } else {
            i16 = 1;
        }
        if (z16) {
            if (i3 == 1) {
                i18 = 1;
                i19 = 1;
            } else if (i3 == 2) {
                i18 = 3;
                i19 = 1;
            } else {
                if (i3 == 3) {
                    i18 = 1;
                } else if (i3 == 13) {
                    i18 = 3;
                }
                i19 = 2;
            }
        }
        if (!z17) {
            i26 = i18;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QBrowserUtils", 2, "reportShareActionSheetClick action=" + actionSheetItem.action + ",fromType=" + i16 + ",sessionType=" + i19 + ",enterType=" + i26 + ",browserParamsEntrance=" + i3 + ",isFriendOrTroop=" + z16 + ",isFromHistory=" + z17);
        }
        ReportController.o(null, "dc00898", "", "", "0X800C36C", "0X800C36C", i16, 0, String.valueOf(i19), String.valueOf(i26), "", "");
    }

    public static void o(long j3) {
        int i3;
        if (j3 < 51200) {
            i3 = 1;
        } else if (j3 < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            i3 = 2;
        } else if (j3 < 512000) {
            i3 = 3;
        } else if (j3 < 1024000) {
            i3 = 4;
        } else if (j3 < 3072000) {
            i3 = 5;
        } else if (j3 < 10240000) {
            i3 = 6;
        } else {
            i3 = 7;
        }
        ReportController.o(null, "dc00898", "", "", "0X800ADC0", "0X800ADC0", i3, 0, "", "", "", "");
    }

    public static void p(final Context context, final b bVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.ab
            @Override // java.lang.Runnable
            public final void run() {
                ae.k(context, bVar);
            }
        }, 128, null, true);
    }

    public static void q(Context context, SpannableString spannableString, String str, int i3, int i16) {
        spannableString.setSpan(new a(context, str), i3, i16, 18);
    }
}
