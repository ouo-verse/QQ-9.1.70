package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.PopupWindow;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.m;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class AudioPanelUtils {

    /* renamed from: b, reason: collision with root package name */
    public static String f178227b;

    /* renamed from: a, reason: collision with root package name */
    public static final int f178226a = Color.parseColor("#666666");

    /* renamed from: c, reason: collision with root package name */
    static PopupWindow f178228c = null;

    public static void a(final QQAppInterface qQAppInterface, final boolean z16, final String str) {
        if (z16) {
            if (f178227b == null) {
                f178227b = TraeHelper.J(BaseApplicationImpl.sApplication);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "checkVcSo sync:" + f178227b);
            }
        }
        if (f178227b == null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!z16) {
                        if (AudioPanelUtils.f178227b == null) {
                            AudioPanelUtils.f178227b = TraeHelper.J(BaseApplicationImpl.sApplication);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AIOAudioPanel", 2, "checkVcSo async:" + AudioPanelUtils.f178227b);
                        }
                    }
                    if (AudioPanelUtils.f178227b == null) {
                        if (AVCoreSystemInfo.getCpuArchitecture() <= 2) {
                            try {
                                com.tencent.mobileqq.earlydownload.handler.b earlyHandler = ((IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(m.O());
                                if (earlyHandler != null) {
                                    earlyHandler.I(false);
                                } else {
                                    QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
                                }
                            } catch (Exception e16) {
                                QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo Exception:" + e16.getMessage());
                            }
                        } else {
                            AVSoUtils.i(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
                        }
                        QQAppInterface qQAppInterface2 = qQAppInterface;
                        String str2 = str;
                        ReportController.o(qQAppInterface2, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
                    }
                }
            }, 5, null, false);
        }
    }

    public static PopupWindow b() {
        return f178228c;
    }

    public static void c(View view) {
        float f16 = FontSettingManager.systemMetrics.density / view.getContext().getResources().getDisplayMetrics().density;
        view.setScaleX(f16);
        view.setScaleY(f16);
    }

    public static PopupWindow d(Context context, int i3, int i16, View view, int i17, int i18, int i19) {
        return e(context, i3, i16, view, i17, i18, i19, CellDynamicAlbum.sBtnBackgroundColor);
    }

    public static PopupWindow e(Context context, int i3, int i16, View view, int i17, int i18, int i19, int i26) {
        PopupWindow popupWindow = f178228c;
        if (popupWindow != null && popupWindow.isShowing()) {
            return f178228c;
        }
        View view2 = new View(context);
        view2.setBackgroundColor(i26);
        f178228c = new PopupWindow(view2, i3, i16);
        try {
            f178228c.setAttachedInDecor(false);
            f178228c.setClippingEnabled(false);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("AudioPanel", 2, th5, new Object[0]);
            }
        }
        if (view.getWindowToken() != null) {
            f178228c.showAtLocation(view, i17, i18, i19);
        }
        return f178228c;
    }
}
