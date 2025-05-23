package com.tencent.timi.game.liveroom.impl.room.share.timishare;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgShareParam;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.report.ShareLiveReportRequest;
import com.tencent.timi.game.utils.w;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.io.IOException;
import java.util.ArrayList;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiGameShareUtil {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f378499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TgShareParam f378500e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ShareActionSheet.OnItemClickListener f378501f;

        a(Context context, TgShareParam tgShareParam, ShareActionSheet.OnItemClickListener onItemClickListener) {
            this.f378499d = context;
            this.f378500e = tgShareParam;
            this.f378501f = onItemClickListener;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            TimiGameShareUtil.f(this.f378499d, actionSheetItem, this.f378500e);
            ShareActionSheet.OnItemClickListener onItemClickListener = this.f378501f;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(actionSheetItem, shareActionSheet);
            }
            shareActionSheet.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements DialogInterface.OnShowListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnShowListener f378502d;

        b(DialogInterface.OnShowListener onShowListener) {
            this.f378502d = onShowListener;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            DialogInterface.OnShowListener onShowListener = this.f378502d;
            if (onShowListener != null) {
                onShowListener.onShow(dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnCancelListener f378503d;

        c(DialogInterface.OnCancelListener onCancelListener) {
            this.f378503d = onCancelListener;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DialogInterface.OnCancelListener onCancelListener = this.f378503d;
            if (onCancelListener != null) {
                onCancelListener.onCancel(dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f378504d;

        d(DialogInterface.OnDismissListener onDismissListener) {
            this.f378504d = onDismissListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.f378504d;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements zi4.a<nq4.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TgShareParam f378505a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f378506b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TgShareParam.ShareBody f378507c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f378508d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f378509e;

        e(TgShareParam tgShareParam, Context context, TgShareParam.ShareBody shareBody, String str, int i3) {
            this.f378505a = tgShareParam;
            this.f378506b = context;
            this.f378507c = shareBody;
            this.f378508d = str;
            this.f378509e = i3;
        }

        @Override // zi4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(nq4.b bVar) {
            TgShareParam tgShareParam = this.f378505a;
            tgShareParam.tgLiveShareParam.arkJsonFromRemote = bVar.f420728a;
            Context context = this.f378506b;
            TgShareParam.ShareBody shareBody = this.f378507c;
            TimiGameShareUtil.g(context, tgShareParam, shareBody.title, shareBody.desc, shareBody.imageUrl, shareBody.jumpActionUrl, this.f378508d, this.f378509e);
        }

        @Override // zi4.a
        public void fail(int i3, String str) {
            Context context = this.f378506b;
            TgShareParam tgShareParam = this.f378505a;
            TgShareParam.ShareBody shareBody = this.f378507c;
            TimiGameShareUtil.g(context, tgShareParam, shareBody.title, shareBody.desc, shareBody.imageUrl, shareBody.jumpActionUrl, this.f378508d, this.f378509e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements WXShareHelper.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f378510d;

        f(int i3) {
            this.f378510d = i3;
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            int i3;
            int i16 = baseResp.errCode;
            if (i16 != 0 && i16 != -2) {
                com.tencent.timi.game.ui.widget.f.b(R.string.hit);
            } else if (i16 == 0) {
                if (this.f378510d == 0) {
                    i3 = 3;
                } else {
                    i3 = 4;
                }
                TimiGameShareUtil.k(i3);
            }
            WXShareHelper.b0().q0(this);
        }
    }

    private static boolean e() {
        if (!WXShareHelper.b0().e0()) {
            com.tencent.timi.game.ui.widget.f.b(R.string.f173257ih1);
            return false;
        }
        if (!WXShareHelper.b0().f0()) {
            com.tencent.timi.game.ui.widget.f.b(R.string.f173258ih2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, TgShareParam tgShareParam) {
        int i3 = actionSheetItem.action;
        int i16 = actionSheetItem.uinType;
        String str = actionSheetItem.uin;
        if (tgShareParam == null) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 26 && i3 != 72) {
                        if (i3 != 73) {
                            switch (i3) {
                                case 9:
                                    TgShareParam.ShareBody shareBody = tgShareParam.getShareBody(3);
                                    if (shareBody == null) {
                                        return;
                                    }
                                    o(context, shareBody.title, shareBody.desc, shareBody.imageUrl, shareBody.jumpActionUrl, 0);
                                    return;
                                case 10:
                                    TgShareParam.ShareBody shareBody2 = tgShareParam.getShareBody(2);
                                    if (shareBody2 == null) {
                                        return;
                                    }
                                    o(context, shareBody2.title, shareBody2.desc, shareBody2.imageUrl, shareBody2.jumpActionUrl, 1);
                                    return;
                                case 11:
                                    TgShareParam.ShareBody shareBody3 = tgShareParam.getShareBody(1);
                                    if (shareBody3 == null) {
                                        com.tencent.timi.game.ui.widget.f.c("\u5df2\u6536\u5230\u4f60\u7684\u4e3e\u62a5\uff0c\u6211\u4eec\u4f1a\u53ca\u65f6\u5904\u7406\u3002");
                                        return;
                                    } else {
                                        tk4.d.f436481a.A(context, shareBody3.jumpActionUrl, ((ll4.a) mm4.b.b(ll4.a.class)).B());
                                        return;
                                    }
                                default:
                                    return;
                            }
                        }
                    } else {
                        if (i3 == 26) {
                            str = AppConstants.DATALINE_NEW_VERSION_UIN;
                        }
                        TgShareParam.ShareBody shareBody4 = tgShareParam.getShareBody(1);
                        if (shareBody4 == null) {
                            return;
                        }
                        m(context, tgShareParam, shareBody4, str, i16);
                        return;
                    }
                } else {
                    TgShareParam.ShareBody shareBody5 = tgShareParam.getShareBody(0);
                    if (shareBody5 == null) {
                        return;
                    }
                    try {
                        n(context, shareBody5.title, shareBody5.desc, shareBody5.imageUrl, shareBody5.jumpActionUrl, str, 13421773);
                        return;
                    } catch (Exception e16) {
                        AegisLogger.e("Share|TimiGameShareUtil", "handleClickMenuItem", "shareToQzone error:" + e16);
                        return;
                    }
                }
            }
            TgShareParam.ShareBody shareBody6 = tgShareParam.getShareBody(1);
            if (shareBody6 == null) {
                return;
            }
            m(context, tgShareParam, shareBody6, null, 0);
            return;
        }
        TgShareParam.ShareBody shareBody7 = tgShareParam.getShareBody(4);
        if (shareBody7 == null) {
            return;
        }
        l(shareBody7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, TgShareParam tgShareParam, String str, String str2, String str3, String str4, String str5, int i3) {
        String str6;
        Activity activity = (Activity) context;
        if (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra("pluginName", "web_share");
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 13);
            intent.putExtra("req_share_id", 0);
            Intent arkIntentIfExist = tgShareParam.getArkIntentIfExist();
            if (arkIntentIfExist != null) {
                intent.putExtras(arkIntentIfExist);
            }
            intent.putExtra("app_name", tgShareParam.shareAppName);
            intent.putExtra("title", str);
            intent.putExtra("desc", str2);
            intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str3);
            intent.putExtra("detail_url", str4);
            boolean z16 = !TextUtils.isEmpty(str5);
            if (z16) {
                Bundle bundle = new Bundle();
                bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                bundle.putInt("key_direct_show_uin_type", i3);
                bundle.putString("key_direct_show_uin", str5);
                intent.putExtras(bundle);
            }
            if (z16) {
                str6 = RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS;
            } else {
                str6 = RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT;
            }
            RouteUtils.startActivityForResult(activity, intent, str6, 13421772);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(QQLiveResponse qQLiveResponse) {
        vq4.b bVar = (vq4.b) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && bVar != null) {
            AegisLogger.i("Share|TimiGameShareUtil", "reportShareResult", "success");
            return;
        }
        AegisLogger.w("Share|TimiGameShareUtil", "reportShareResult", "failed, response=" + qQLiveResponse);
    }

    public static void i(int i3, int i16, Intent intent) {
        if (intent == null) {
            return;
        }
        if (13421773 == i3) {
            k(2);
        } else if (13421772 == i3) {
            k(1);
        }
    }

    public static ShareActionSheet j(Context context, TgShareParam tgShareParam, ShareActionSheet.OnItemClickListener onItemClickListener, DialogInterface.OnShowListener onShowListener, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnDismissListener onDismissListener) {
        if (context == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("toast_d", 1, "openQQShareDialogV2:\u53c2\u6570\u5f02\u5e38 context == null");
            return null;
        }
        if (com.tencent.timi.game.liveroom.impl.room.util.b.a()) {
            AegisLogger.i("Share|TimiGameShareUtil", "openQQShareDialogV2", "openQQShareDialogV2 double click");
            return null;
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        ShareActionSheet create = ShareActionSheetFactory.create(p(context, param));
        create.setActionSheetTitle(context.getString(R.string.hja));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        if (tgShareParam.showReport) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        if (!TextUtils.isEmpty(tgShareParam.promotionUrl)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(211));
        }
        create.setActionSheetItems(arrayList, arrayList2);
        create.setRowVisibility(0, 0, 0);
        create.setItemClickListenerV2(new a(context, tgShareParam, onItemClickListener));
        Intent intent = new Intent();
        if (context instanceof Activity) {
            intent = ((Activity) context).getIntent();
        }
        intent.putExtra("big_brother_source_key", "biz_src_jc_qqlive");
        intent.putExtra("forward_type", 1001);
        intent.putExtra("pluginName", "web_share");
        create.setIntentForStartForwardRecentActivity(new Intent(intent));
        create.setOnShowListener(new b(onShowListener));
        create.setCancelListener(new c(onCancelListener));
        create.setOnDismissListener(new d(onDismissListener));
        create.show();
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(int i3) {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long l3 = cVar.m().l();
        long h16 = cVar.m().h(l3, 0);
        AegisLogger.i("Share|TimiGameShareUtil", "reportShareResult", "roomId=" + l3 + ", source=" + i3 + ", anchorUid=" + h16);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new ShareLiveReportRequest(l3, h16, i3), new ILiveNetRequest.Callback() { // from class: com.tencent.timi.game.liveroom.impl.room.share.timishare.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                TimiGameShareUtil.h(qQLiveResponse);
            }
        });
    }

    private static void l(TgShareParam.ShareBody shareBody) {
        Activity topActivity;
        if (shareBody == null || TextUtils.isEmpty(shareBody.jumpActionUrl) || (topActivity = Foreground.getTopActivity()) == null) {
            return;
        }
        ClipboardMonitor.setPrimaryClip((ClipboardManager) topActivity.getSystemService("clipboard"), ClipData.newPlainText(null, shareBody.jumpActionUrl));
    }

    public static void m(Context context, TgShareParam tgShareParam, TgShareParam.ShareBody shareBody, String str, int i3) {
        if (context == null) {
            return;
        }
        yk4.b bVar = new yk4.b();
        TgLiveShareParam tgLiveShareParam = tgShareParam.tgLiveShareParam;
        bVar.b(xk4.a.i("com.tencent.qqlive", tgLiveShareParam.roomId, tgLiveShareParam.roomCoverUrl, tgLiveShareParam.roomTitle, tgLiveShareParam.anchorUid, tgLiveShareParam.anchorAvatarUrl, tgLiveShareParam.anchorNick, tgLiveShareParam), new e(tgShareParam, context, shareBody, str, i3));
    }

    public static void n(Context context, String str, String str2, String str3, String str4, String str5, int i3) {
        if (context == null) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mTitle = str;
        qZoneShareData.mSummary = str2;
        ArrayList<String> arrayList = new ArrayList<>();
        qZoneShareData.mImageUrls = arrayList;
        arrayList.add(str3);
        qZoneShareData.from = 0;
        qZoneShareData.targetUrl = str4;
        qZoneShareData.shareUin = str5;
        QZoneShareManager.shareToQzone(activity, str5, qZoneShareData, null, i3);
    }

    private static void o(Context context, final String str, final String str2, final String str3, final String str4, final int i3) {
        if (!e()) {
            return;
        }
        final String valueOf = String.valueOf(System.currentTimeMillis());
        w.a(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.share.timishare.TimiGameShareUtil.6
            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeByteArray;
                int i16;
                try {
                    byte[] openUrlForByte = HttpUtil.openUrlForByte(eh4.a.b(), MsfSdkUtils.insertMtype("GameCenter", str3), "GET", null, null);
                    if (openUrlForByte != null && (decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length)) != null) {
                        int width = decodeByteArray.getWidth();
                        int height = decodeByteArray.getHeight();
                        double d16 = width * height;
                        if (d16 > 8000.0d) {
                            double sqrt = Math.sqrt(8000.0d / d16);
                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, (int) (width * sqrt), (int) (height * sqrt), true);
                            decodeByteArray.recycle();
                            WXShareHelper b06 = WXShareHelper.b0();
                            String str5 = valueOf;
                            String str6 = str;
                            String str7 = str2;
                            String str8 = str4;
                            if (i3 == 0) {
                                i16 = 0;
                            } else {
                                i16 = 1;
                            }
                            b06.L0(str5, str6, createScaledBitmap, str7, str8, i16);
                            createScaledBitmap.recycle();
                        }
                    }
                } catch (IOException | OutOfMemoryError unused) {
                }
            }
        });
        WXShareHelper.b0().A(new f(i3));
    }

    private static ShareActionSheetV2.Param p(Context context, ShareActionSheetV2.Param param) {
        if (ScreenUtils.isLandscape()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 80;
            layoutParams.topMargin = ViewUtils.getStatusBarHeight(context);
            param.f317475lp = layoutParams;
        }
        return param;
    }
}
