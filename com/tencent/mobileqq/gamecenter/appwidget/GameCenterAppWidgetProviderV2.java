package com.tencent.mobileqq.gamecenter.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.data.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes12.dex */
public class GameCenterAppWidgetProviderV2 extends AppWidgetProvider {

    /* renamed from: a, reason: collision with root package name */
    private static final a f211951a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final a f211952b = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final a f211953c = new a();

    /* renamed from: d, reason: collision with root package name */
    private static q f211954d = null;

    /* renamed from: e, reason: collision with root package name */
    private static long f211955e = 0;

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<Bitmap> f211956a = new WeakReference<>(null);

        /* renamed from: b, reason: collision with root package name */
        public String f211957b = null;
    }

    private String a(String str, String str2) {
        return b(str, "gcwidget_native_report", str2);
    }

    private String b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str4 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str4 = ContainerUtils.FIELD_DELIMITER;
            }
            sb5.append(str4);
            sb5.append(str2);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str3);
            return sb5.toString();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap c(Context context, String str, @NonNull a aVar, int i3, int i16, int i17, int i18) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(aVar.f211957b) && (bitmap2 = aVar.f211956a.get()) != null && !bitmap2.isRecycled()) {
                QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 2, "createWidgetBitmap use cache bitmap");
                return bitmap2;
            }
            try {
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (new File(str).exists()) {
                bitmap = BitmapFactory.decodeFile(str);
                if (bitmap != null && i16 > 0) {
                    try {
                        bitmap = BaseImageUtil.getRoundedCornerBitmap2(bitmap, com.tencent.mobileqq.gamecenter.util.a.a(i16, context.getResources()), i17, i18);
                    } catch (OutOfMemoryError unused2) {
                        QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 2, "createWidgetBitmap oom");
                        if (bitmap == null) {
                        }
                    }
                }
                aVar.f211956a = new WeakReference<>(bitmap);
                aVar.f211957b = str;
                QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 2, "createWidgetBitmap create bitmap:" + str);
                if (bitmap == null) {
                    if (i3 == -1) {
                        return null;
                    }
                    Bitmap bitmap3 = ((BitmapDrawable) context.getResources().getDrawable(i3)).getBitmap();
                    if (bitmap3 != null && i16 > 0) {
                        return BaseImageUtil.getRoundedCornerBitmap3(bitmap3, com.tencent.mobileqq.gamecenter.util.a.a(i16, context.getResources()), i17, i18);
                    }
                    return bitmap3;
                }
                return bitmap;
            }
        }
        bitmap = null;
        if (bitmap == null) {
        }
    }

    private PendingIntent d(Context context) {
        String c16 = f211954d.c();
        if (TextUtils.isEmpty(c16)) {
            c16 = "mqqapi://kuikly/open?src_type=web&version=1&url=%25253FFFROMSCHEMA%25253D%252526adtag%25253Dwidget%252526page%25253Dcrunchy&page_name=QQGameCenterShell&bundle_name=gamecenter_shell&ssr_page_name=QQGameCenterRootPage&ssr_bundle_name=gamecenter";
        }
        return g(context, a(c16, "4"));
    }

    private PendingIntent e(Context context) {
        String str;
        q.e cloudGame = f211954d.getCloudGame();
        if (cloudGame != null && !TextUtils.isEmpty(cloudGame.getJumpUrl())) {
            str = cloudGame.getJumpUrl();
        } else {
            str = "mqqapi://hippy/open?src_type%3Dweb%26version%3D1%26bundleName%3DQQGameCenterPaymentSdk%26url%3Dhttps%253A%252F%252Fssr.gamecenter.qq.com%252Fhippy-ssr%252Fv1%252Fapp%252Faction-sheet%253Fp_collections%253D%252526adtag%25253Dwidget%252526action_type%25253Dcloudplay%252526appid%25253D1104466820%26isAnimated%3Dfalse%26isTransparent%3Dtrue%26";
        }
        return g(context, a(str, "2"));
    }

    private PendingIntent f(Context context) {
        String str;
        q.h messageNotice = f211954d.getMessageNotice();
        if (messageNotice != null && !TextUtils.isEmpty(messageNotice.getJumpUrl())) {
            str = messageNotice.getJumpUrl();
        } else {
            str = "mqqapi://kuikly/open?src_type=web&version=1&url=%25253FFFROMSCHEMA%25253D%252526adtag%25253Dwidget_default&page_name=QQGameCenterShell&bundle_name=gamecenter_shell&ssr_page_name=QQGameCenterRootPage&ssr_bundle_name=gamecenter";
        }
        return g(context, a(str, "3"));
    }

    private PendingIntent g(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        return PendingIntent.getActivity(context, 0, intent, 67108864);
    }

    private PendingIntent h(Context context) {
        String str;
        q.i promotionAd = f211954d.getPromotionAd();
        if (promotionAd != null && !TextUtils.isEmpty(promotionAd.getJumpUrl())) {
            str = promotionAd.getJumpUrl();
        } else {
            str = "mqqapi://kuikly/open?src_type=web&version=1&url=%25253FFFROMSCHEMA%25253D%252526adtag%25253Dwidget%252526page%25253Dcrunchy&page_name=QQGameCenterShell&bundle_name=gamecenter_shell&ssr_page_name=QQGameCenterRootPage&ssr_bundle_name=gamecenter";
        }
        return g(context, a(str, "0"));
    }

    private PendingIntent i(Context context) {
        return g(context, a("mqqapi://kuikly/open?src_type=web&version=1&url=%25253FFFROMSCHEMA%25253D%252526adtag%25253Dwidget_default&page_name=QQGameCenterShell&bundle_name=gamecenter_shell&ssr_page_name=QQGameCenterRootPage&ssr_bundle_name=gamecenter", "-1"));
    }

    private PendingIntent j(Context context) {
        String str;
        q.g gift = f211954d.getGift();
        if (gift != null && !TextUtils.isEmpty(gift.getJumpUrl())) {
            str = gift.getJumpUrl();
        } else {
            str = "mqqapi://kuikly/open?src_type=web&version=1&url=%25253FFFROMSCHEMA%25253D%252526adtag%25253Dwidget%252526page_tab%25253D0&page_name=QQGameCenterWelfareV2&bundle_name=gamecenter_welfare_v2";
        }
        return g(context, a(str, "1"));
    }

    private void k(int i3, Context context, RemoteViews remoteViews) {
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 == 4) {
                remoteViews.setViewVisibility(R.id.f111816m9, 0);
                remoteViews.setViewVisibility(R.id.yqq, 8);
                v(remoteViews, R.id.f111816m9, f211954d.i());
            }
        } else {
            remoteViews.setViewVisibility(R.id.f111816m9, 8);
            remoteViews.setViewVisibility(R.id.yqq, 0);
            v(remoteViews, R.id.f111556lj, f211954d.j());
            v(remoteViews, R.id.f110106hm, f211954d.l());
        }
        u(remoteViews, R.id.y0y, c(context, f211954d.k(), f211951a, -1, 4, com.tencent.mobileqq.gamecenter.util.a.a(24.0f, context.getResources()), com.tencent.mobileqq.gamecenter.util.a.a(24.0f, context.getResources())));
    }

    private void l(int i3, RemoteViews remoteViews) {
        v(remoteViews, R.id.kbs, f211954d.e());
        QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 1, "[initViewsV3], status:" + i3);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        o(remoteViews);
                        return;
                    }
                    return;
                }
                n(remoteViews);
                return;
            }
            q(remoteViews);
            return;
        }
        p(remoteViews);
    }

    private void m(Context context, RemoteViews remoteViews) {
        u(remoteViews, R.id.y5_, c(context, f211954d.x(), f211951a, -1, 4, com.tencent.mobileqq.gamecenter.util.a.a(43.0f, context.getResources()), com.tencent.mobileqq.gamecenter.util.a.a(43.0f, context.getResources())));
        v(remoteViews, R.id.f109036eq, String.valueOf(f211954d.v()));
        if (f211954d.w()) {
            remoteViews.setViewVisibility(R.id.f926058b, 0);
            remoteViews.setViewVisibility(R.id.f925958a, 8);
            remoteViews.setProgressBar(R.id.f926058b, 100, f211954d.y(), false);
        } else {
            remoteViews.setViewVisibility(R.id.f926058b, 8);
            remoteViews.setViewVisibility(R.id.f925958a, 0);
            remoteViews.setProgressBar(R.id.f925958a, 100, f211954d.y(), false);
        }
    }

    private void n(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.yr6, 8);
        remoteViews.setViewVisibility(R.id.f166096yo4, 8);
        remoteViews.setViewVisibility(R.id.yr5, 0);
        remoteViews.setViewVisibility(R.id.f109516g1, 8);
        v(remoteViews, R.id.f107126_k, String.valueOf(f211954d.d()));
        v(remoteViews, R.id.f112116n2, String.valueOf(f211954d.h()));
    }

    private void o(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.yr6, 8);
        remoteViews.setViewVisibility(R.id.f166096yo4, 8);
        remoteViews.setViewVisibility(R.id.yr5, 8);
        remoteViews.setViewVisibility(R.id.f109516g1, 0);
        v(remoteViews, R.id.f109516g1, f211954d.g());
    }

    private void p(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.yr6, 0);
        remoteViews.setViewVisibility(R.id.f166096yo4, 8);
        remoteViews.setViewVisibility(R.id.yr5, 8);
        remoteViews.setViewVisibility(R.id.f109516g1, 8);
        v(remoteViews, R.id.f111806m8, f211954d.g());
        v(remoteViews, R.id.f107816bf, f211954d.f());
    }

    private void q(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.yr6, 8);
        remoteViews.setViewVisibility(R.id.f166096yo4, 0);
        remoteViews.setViewVisibility(R.id.yr5, 8);
        remoteViews.setViewVisibility(R.id.f109516g1, 8);
        v(remoteViews, R.id.f107826bg, f211954d.f());
    }

    private void r(Context context, RemoteViews remoteViews) {
        int i3;
        try {
            q.j taskType = f211954d.getTaskType();
            if (taskType != null) {
                i3 = taskType.getType();
            } else {
                QLog.w("GCWidget.GameCenterAppWidgetProviderV2", 2, "[initViews] taskType is null.");
                i3 = 0;
            }
            if (i3 == 0) {
                remoteViews.setViewVisibility(R.id.f784046z, 0);
                remoteViews.setViewVisibility(R.id.f7841470, 8);
                s(context, remoteViews);
            } else if (i3 == 1) {
                remoteViews.setViewVisibility(R.id.f784046z, 8);
                remoteViews.setViewVisibility(R.id.f7841470, 0);
                t(context, remoteViews);
            }
        } catch (Throwable th5) {
            QLog.e("GCWidget.GameCenterAppWidgetProviderV2", 1, "[initViews], th:", th5);
        }
    }

    private void s(Context context, RemoteViews remoteViews) {
        String str;
        IGameCenterWidgetMgrApi iGameCenterWidgetMgrApi = (IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class);
        String A = f211954d.A();
        if (!TextUtils.isEmpty(A) && new File(A).exists()) {
            str = A;
        } else {
            String fileDownloadPath = iGameCenterWidgetMgrApi.getFileDownloadPath("https://img.gamecenter.qq.com/xgame/gm/1687607467576_f915369f1338e9428d87c718d48b79a7.jpg");
            if (!new File(fileDownloadPath).exists()) {
                iGameCenterWidgetMgrApi.downloadAndUpdateUi("https://img.gamecenter.qq.com/xgame/gm/1687607467576_f915369f1338e9428d87c718d48b79a7.jpg");
            }
            str = fileDownloadPath;
        }
        u(remoteViews, R.id.y87, c(context, str, f211951a, -1, 4, com.tencent.mobileqq.gamecenter.util.a.a(149.0f, context.getResources()), com.tencent.mobileqq.gamecenter.util.a.a(68.0f, context.getResources())));
        u(remoteViews, R.id.y_p, c(context, f211954d.r(), f211952b, R.drawable.mu_, 3, com.tencent.mobileqq.gamecenter.util.a.a(18.0f, context.getResources()), com.tencent.mobileqq.gamecenter.util.a.a(18.0f, context.getResources())));
        u(remoteViews, R.id.y1p, c(context, f211954d.n(), f211953c, R.drawable.mu9, 3, com.tencent.mobileqq.gamecenter.util.a.a(18.0f, context.getResources()), com.tencent.mobileqq.gamecenter.util.a.a(18.0f, context.getResources())));
        v(remoteViews, R.id.f112546o8, f211954d.s(context));
        v(remoteViews, R.id.f1068569u, f211954d.o(context));
        v(remoteViews, R.id.f109646gd, f211954d.u(context));
        long q16 = f211954d.q();
        if (q16 > 0) {
            remoteViews.setViewVisibility(R.id.f112556o9, 0);
            v(remoteViews, R.id.f112556o9, String.valueOf(q16));
        }
        remoteViews.setOnClickPendingIntent(R.id.f784046z, i(context));
        remoteViews.setOnClickPendingIntent(R.id.y87, h(context));
        remoteViews.setOnClickPendingIntent(R.id.f760940q, j(context));
        remoteViews.setOnClickPendingIntent(R.id.f75403yv, e(context));
        remoteViews.setOnClickPendingIntent(R.id.f109646gd, f(context));
    }

    private void t(Context context, RemoteViews remoteViews) {
        int C = f211954d.C();
        QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 1, "[initViewsV3], taskStatus:" + C);
        if (C == 0) {
            return;
        }
        l(C, remoteViews);
        k(C, context, remoteViews);
        m(context, remoteViews);
        remoteViews.setOnClickPendingIntent(R.id.f7841470, d(context));
    }

    private void u(RemoteViews remoteViews, int i3, Bitmap bitmap) {
        if (remoteViews != null && bitmap != null) {
            remoteViews.setBitmap(i3, "setImageBitmap", bitmap);
        }
    }

    private void v(RemoteViews remoteViews, int i3, CharSequence charSequence) {
        if (remoteViews != null) {
            remoteViews.setTextViewText(i3, charSequence);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 2, "[onDeleted] appWidgetIds:" + Arrays.toString(iArr));
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        String str;
        String str2;
        q.i promotionAd;
        QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 2, "onDisabled");
        q widgetCacheData = ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).getWidgetCacheData(false);
        if (widgetCacheData != null && (promotionAd = widgetCacheData.getPromotionAd()) != null) {
            str = promotionAd.getId();
            str2 = promotionAd.getAppid();
        } else {
            str = "";
            str2 = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext15", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_number", o.b());
        hashMap.put("ext6", str);
        hashMap.put("ext2", "2");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1091", "9402", "940201", "914331", "", hashMap);
        f211955e = 0L;
        ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).clearImgCache();
        ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).clearWidgetConfigCacheV2();
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 2, "[onEnabled]");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext15", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_number", o.b());
        hashMap.put("ext2", "2");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "1091", "9402", "940201", "914330", "", hashMap);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String str = intent.getPackage();
        QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 2, "[onReceive] action action:" + action + ",intentPkg:" + str + ",contextPkg:" + context.getPackageName());
        if (str != null && !str.equals(context.getPackageName())) {
            return;
        }
        ExitBroadcastReceiver.a(context);
        if ("tencent.notify.appwidget.GAME_CENTER_UPDATE_V2".equals(action)) {
            w(context, "brocast");
        } else {
            super.onReceive(context, intent);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        w(context, "onUpdate");
        if (Math.abs(System.currentTimeMillis() - f211955e) >= 600000 && ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).isPullConfigTimeUpV2()) {
            f211955e = System.currentTimeMillis();
            ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).fetchWidgetConfigFromSvrV2(2);
        } else {
            QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 1, "[onUpdate] has not reach pull time or in fast pull\uff0clastPullConfigTime:" + f211955e);
        }
    }

    public void w(Context context, String str) {
        AppWidgetManager appWidgetManager;
        QLog.i("GCWidget.GameCenterAppWidgetProviderV2", 2, "[updateAppWidget] from:" + str + ",process:" + MobileQQ.sMobileQQ.getQQProcessName());
        if (context == null || (appWidgetManager = AppWidgetManager.getInstance(context)) == null) {
            return;
        }
        q widgetCacheData = ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).getWidgetCacheData(true);
        f211954d = widgetCacheData;
        if (widgetCacheData == null) {
            f211954d = new q();
            QLog.e("GCWidget.GameCenterAppWidgetProviderV2", 1, "[refreshWidget] widgetStoreData parse error,use default");
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.ea8);
        r(context, remoteViews);
        appWidgetManager.updateAppWidget(new ComponentName(context, (Class<?>) GameCenterAppWidgetProviderV2.class), remoteViews);
    }
}
