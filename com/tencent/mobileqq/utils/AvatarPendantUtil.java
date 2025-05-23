package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.pendant.AvatarPendantRecordHelper;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import java.util.ArrayList;

/* loaded from: classes20.dex */
public final class AvatarPendantUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements com.tencent.mobileqq.webview.util.u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.hitrate.d f306891a;

        a(com.tencent.mobileqq.hitrate.d dVar) {
            this.f306891a = dVar;
        }

        @Override // com.tencent.mobileqq.webview.util.u
        public void onResult(boolean z16) {
            com.tencent.mobileqq.hitrate.d dVar;
            if (z16 && (dVar = this.f306891a) != null) {
                dVar.a();
            }
        }
    }

    private static void a(String str) {
        if (str == null) {
            return;
        }
        ArrayList<String> arrayList = AvatarPendantRecordHelper.BULK_PULL_LIST;
        synchronized (arrayList) {
            if (arrayList.contains(str)) {
                return;
            }
            arrayList.add(str);
        }
    }

    public static void b(String str, QQAppInterface qQAppInterface) {
        a(str);
        c(qQAppInterface);
    }

    private static void c(QQAppInterface qQAppInterface) {
        d(qQAppInterface, false);
    }

    private static void d(final QQAppInterface qQAppInterface, boolean z16) {
        final boolean z17;
        long j3;
        final boolean z18;
        Runnable runnable;
        if (qQAppInterface != null) {
            ArrayList<String> arrayList = AvatarPendantRecordHelper.BULK_PULL_LIST;
            if (arrayList.size() != 0) {
                if (!z16 && arrayList.size() < 5) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (AvatarPendantRecordHelper.getLastRequestTime() != -1) {
                    j3 = System.currentTimeMillis() - AvatarPendantRecordHelper.getLastRequestTime();
                    if (j3 < PendantConstant.BULK_GET_STRANGER_MIN_INTERVAL) {
                        z18 = false;
                        if (z17 && !z18 && AvatarPendantRecordHelper.sHasSendDelayMsg) {
                            if (QLog.isColorLevel() && QLog.isDebugVersion()) {
                                QLog.d("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, condition unavailable, abort");
                                return;
                            }
                            return;
                        }
                        runnable = new Runnable() { // from class: com.tencent.mobileqq.utils.AvatarPendantUtil.1
                            @Override // java.lang.Runnable
                            public void run() {
                                int i3;
                                int size;
                                String[] strArr;
                                ArrayList<String> arrayList2 = AvatarPendantRecordHelper.BULK_PULL_LIST;
                                synchronized (arrayList2) {
                                    AvatarPendantRecordHelper.sHasSendDelayMsg = false;
                                    size = arrayList2.size();
                                    strArr = new String[size];
                                    arrayList2.toArray(strArr);
                                    arrayList2.clear();
                                }
                                if (size == 0) {
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    for (i3 = 0; i3 < size; i3++) {
                                        String str = strArr[i3];
                                        sb5.append(",");
                                        sb5.append(str);
                                    }
                                    QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, thresholdReached=" + z17 + ", intervalReached=" + z18 + "pull list size=" + AvatarPendantRecordHelper.BULK_PULL_LIST.size() + ",size=" + size + " list:" + ((Object) sb5));
                                }
                                com.tencent.mobileqq.apollo.handler.b bVar = (com.tencent.mobileqq.apollo.handler.b) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
                                if (bVar != null) {
                                    bVar.j2(strArr, new int[]{ProfileContants.FIELD_VIP_MAGIC_FONT_FLAG, 27025, ProfileContants.FIELD_VIP_FONT_ID_TYPE, 27235, 27238, ProfileContants.FIELD_VIP_FONT_EFFECT});
                                    AvatarPendantRecordHelper.setLastRequestTime(System.currentTimeMillis());
                                }
                            }
                        };
                        if (z17 && !z18) {
                            synchronized (arrayList) {
                                AvatarPendantRecordHelper.sHasSendDelayMsg = true;
                            }
                            ThreadManagerV2.executeDelay(runnable, 16, null, true, PendantConstant.BULK_GET_STRANGER_MIN_INTERVAL - j3);
                            return;
                        }
                        ThreadManagerV2.excute(runnable, 128, null, false);
                    }
                } else {
                    j3 = 0;
                }
                z18 = true;
                if (z17) {
                }
                runnable = new Runnable() { // from class: com.tencent.mobileqq.utils.AvatarPendantUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i3;
                        int size;
                        String[] strArr;
                        ArrayList<String> arrayList2 = AvatarPendantRecordHelper.BULK_PULL_LIST;
                        synchronized (arrayList2) {
                            AvatarPendantRecordHelper.sHasSendDelayMsg = false;
                            size = arrayList2.size();
                            strArr = new String[size];
                            arrayList2.toArray(strArr);
                            arrayList2.clear();
                        }
                        if (size == 0) {
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            for (i3 = 0; i3 < size; i3++) {
                                String str = strArr[i3];
                                sb5.append(",");
                                sb5.append(str);
                            }
                            QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, thresholdReached=" + z17 + ", intervalReached=" + z18 + "pull list size=" + AvatarPendantRecordHelper.BULK_PULL_LIST.size() + ",size=" + size + " list:" + ((Object) sb5));
                        }
                        com.tencent.mobileqq.apollo.handler.b bVar = (com.tencent.mobileqq.apollo.handler.b) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
                        if (bVar != null) {
                            bVar.j2(strArr, new int[]{ProfileContants.FIELD_VIP_MAGIC_FONT_FLAG, 27025, ProfileContants.FIELD_VIP_FONT_ID_TYPE, 27235, 27238, ProfileContants.FIELD_VIP_FONT_EFFECT});
                            AvatarPendantRecordHelper.setLastRequestTime(System.currentTimeMillis());
                        }
                    }
                };
                if (z17) {
                }
                ThreadManagerV2.excute(runnable, 128, null, false);
            }
        }
    }

    public static void e(QQAppInterface qQAppInterface, String str) {
        ((com.tencent.mobileqq.apollo.handler.b) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).j2(new String[]{str}, new int[]{27235});
    }

    public static float f(Paint paint, Rect rect, String str) {
        int width = rect.width();
        if (width <= 0) {
            return 0.0f;
        }
        TextPaint textPaint = new TextPaint(paint);
        float height = rect.height();
        textPaint.setTextSize(height);
        while (true) {
            if ((textPaint.measureText(str) > width || Math.ceil(textPaint.getFontMetrics().descent - textPaint.getFontMetrics().ascent) > rect.height()) && height > 0.0f) {
                height -= 1.0f;
                textPaint.setTextSize(height);
            }
        }
        return height;
    }

    public static void g(QQAppInterface qQAppInterface, Context context) {
        h(qQAppInterface, context, true);
    }

    public static void h(QQAppInterface qQAppInterface, Context context, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        int i3;
        if (qQAppInterface != null && context != null) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            com.tencent.mobileqq.servlet.e eVar = (com.tencent.mobileqq.servlet.e) qQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            int a16 = eVar.a("100005.100006");
            if (a16 == 1 || a16 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("AvatarPendantUtil", 2, "Clear pendant red flag");
                }
                intent.putExtra(AvatarPendantUiPlugin.KEY_UPDATE_FLAG, true);
                IRedTouchManager iRedTouchManager = (IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
                iRedTouchManager.onRedTouchItemClick("100005.100006");
                if (eVar.a("100005.100003") != -1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (eVar.a("100005.100002") != -1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (eVar.a("100005.100001") != -1) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (eVar.a("100005.100018") != -1) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (eVar.a("100005.100020") != -1) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (eVar.a("100005.100021") != -1) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if (((IFontManagerService) qQAppInterface.getRuntimeService(IFontManagerService.class, "")).isSupportFont() && eVar.a("100005.100011") != -1) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if (!z17 && !z18 && !z19 && !z26 && !z29 && !z27 && !z28) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AvatarPendantUtil", 2, "Clear parent red flag");
                    }
                    iRedTouchManager.onRedTouchItemClick("100005");
                }
            }
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            intent.putExtra("show_right_close_button", false);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", IndividuationUrlHelper.getMarketUrl(context, IndividuationUrlHelper.UrlId.PENDANT_HOME, ""));
            intent.putExtra("business", 512L);
            if (z16) {
                i3 = VasWebviewConstants.REPORT_FROM_USER_PROFILE_CARD;
            } else {
                i3 = VasWebviewConstants.REPORT_FROM_FRIEND_PROFILE_CARD;
            }
            intent.putExtra("individuation_url_type", i3);
            VasWebviewUtil.insertVasWbPluginToIntent(512L, intent);
            intent.putExtra("isShowAd", false);
            context.startActivity(intent);
            ReportController.o(qQAppInterface, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
        }
    }

    public static void i(QQAppInterface qQAppInterface, Context context, String str, String str2, com.tencent.mobileqq.hitrate.d dVar) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (qQAppInterface != null) {
                IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) qQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
                if (iWebProcessManagerService != null) {
                    if (System.currentTimeMillis() - ((Long) p.c(context, String.format(PendantConstant.SP_PENDANT_MARKET_OPEN_TIME, str2), "", str, 0L)).longValue() < 604800000) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, startWebProcess");
                        }
                        iWebProcessManagerService.startWebProcess(16, new a(dVar));
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, web process alive aready");
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, entrance=" + str + ", uin=" + str2 + ", context=" + context + ", app=" + qQAppInterface);
        }
    }

    public static void j(Context context, String str, String str2, long j3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            p.e(context, String.format(PendantConstant.SP_PENDANT_MARKET_OPEN_TIME, str2), "", false, str, Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantUtil", 2, "saveMarketOpenTime, entrance=" + str + ", uin=" + str2 + ", context=" + context);
        }
    }
}
