package com.tencent.icgame.game.liveroom.impl.room.share.timishare;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.ShareHandler;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.d;
import com.tencent.icgame.game.utils.k;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.io.IOException;
import java.util.ArrayList;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ShareHandler {

    /* renamed from: a, reason: collision with root package name */
    private f f115597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.share.timishare.ShareHandler$5, reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f115598d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f115599e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f115600f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f115601h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f115602i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f115603m;

        AnonymousClass5(String str, String str2, String str3, String str4, String str5, int i3) {
            this.f115598d = str;
            this.f115599e = str2;
            this.f115600f = str3;
            this.f115601h = str4;
            this.f115602i = str5;
            this.f115603m = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3) {
            int i16;
            if (ShareHandler.this.f115597a != null) {
                f fVar = ShareHandler.this.f115597a;
                if (i3 == 0) {
                    i16 = 3;
                } else {
                    i16 = 2;
                }
                fVar.a(i16);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap decodeByteArray;
            int i3;
            try {
                byte[] openUrlForByte = HttpUtil.openUrlForByte(tu0.a.b(), MsfSdkUtils.insertMtype("GameCenter", this.f115598d), "GET", null, null);
                if (openUrlForByte != null && (decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length)) != null) {
                    int width = decodeByteArray.getWidth();
                    int height = decodeByteArray.getHeight();
                    double d16 = width * height;
                    if (d16 > 8000.0d) {
                        double sqrt = Math.sqrt(8000.0d / d16);
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, (int) (width * sqrt), (int) (height * sqrt), true);
                        decodeByteArray.recycle();
                        WXShareHelper b06 = WXShareHelper.b0();
                        String str = this.f115599e;
                        String str2 = this.f115600f;
                        String str3 = this.f115601h;
                        String str4 = this.f115602i;
                        if (this.f115603m == 0) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        b06.L0(str, str2, createScaledBitmap, str3, str4, i3);
                        createScaledBitmap.recycle();
                        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                        final int i16 = this.f115603m;
                        uIHandlerV2.post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.share.timishare.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                ShareHandler.AnonymousClass5.this.b(i16);
                            }
                        });
                    }
                }
            } catch (IOException | OutOfMemoryError unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f115604d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.icgame.game.liveroom.impl.room.share.timishare.d f115605e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ShareActionSheet.OnItemClickListener f115606f;

        a(Context context, com.tencent.icgame.game.liveroom.impl.room.share.timishare.d dVar, ShareActionSheet.OnItemClickListener onItemClickListener) {
            this.f115604d = context;
            this.f115605e = dVar;
            this.f115606f = onItemClickListener;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            ShareHandler.this.e(this.f115604d, actionSheetItem, this.f115605e);
            ShareActionSheet.OnItemClickListener onItemClickListener = this.f115606f;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(actionSheetItem, shareActionSheet);
            }
            shareActionSheet.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements DialogInterface.OnShowListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnShowListener f115608d;

        b(DialogInterface.OnShowListener onShowListener) {
            this.f115608d = onShowListener;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            DialogInterface.OnShowListener onShowListener = this.f115608d;
            if (onShowListener != null) {
                onShowListener.onShow(dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnCancelListener f115610d;

        c(DialogInterface.OnCancelListener onCancelListener) {
            this.f115610d = onCancelListener;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DialogInterface.OnCancelListener onCancelListener = this.f115610d;
            if (onCancelListener != null) {
                onCancelListener.onCancel(dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class d implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f115612d;

        d(DialogInterface.OnDismissListener onDismissListener) {
            this.f115612d = onDismissListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.f115612d;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class e implements WXShareHelper.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f115614d;

        e(int i3) {
            this.f115614d = i3;
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            int i3 = baseResp.errCode;
            if (i3 != 0 && i3 != -2) {
                com.tencent.icgame.game.ui.widget.f.a(R.string.hit);
            } else if (i3 == 0) {
                rt0.a.e("ICGameShare|TimiGameShareUtil", "share wechat success:scene=" + this.f115614d);
            }
            WXShareHelper.b0().q0(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface f {
        void a(int i3);
    }

    private static boolean c() {
        if (!WXShareHelper.b0().e0()) {
            com.tencent.icgame.game.ui.widget.f.a(R.string.f173257ih1);
            return false;
        }
        if (!WXShareHelper.b0().f0()) {
            com.tencent.icgame.game.ui.widget.f.a(R.string.f173258ih2);
            return false;
        }
        return true;
    }

    private Intent d(com.tencent.icgame.game.liveroom.impl.room.share.timishare.d dVar, String str, String str2, String str3, String str4, String str5, int i3) {
        if (dVar == null) {
            rt0.a.c("ICGameShare|TimiGameShareUtil", "getShareArkIntent", "tgShareParam is null!");
            return null;
        }
        if (dVar.f115633a == null) {
            rt0.a.c("ICGameShare|TimiGameShareUtil", "getShareArkIntent", "tgLiveShareParam is null!");
            return null;
        }
        rt0.a.f("ICGameShare|TimiGameShareUtil", "getShareArkIntent", "param title:" + str + " desc:" + str2 + " imageUrl:" + str3 + " detailUrl:" + str4 + " uin:" + str5 + " uinType:" + i3);
        com.tencent.icgame.game.liveroom.impl.room.share.timishare.c cVar = dVar.f115633a;
        Intent intent = new Intent();
        try {
            intent.putExtra("forward_type", 57);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("app_name", dVar.f115640h);
            intent.putExtra("is_need_show_toast", false);
            intent.putExtra("key_allow_multiple_forward_from_limit", false);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
            intent.putExtra("title", dVar.f115635c);
            intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str3);
            intent.putExtra("desc", "\u76f4\u64ad x \u4e92\u52a8\u4e91\u73a9\u6cd5\uff0c\u6765\u548c\u5c0f\u4f19\u4f34\u4e00\u8d77\u73a9\u5427\uff5e");
            intent.putExtra("uintype", i3);
            intent.putExtra("uin", str5);
            intent.putExtra("forward_ark_app_prompt", "\u76f4\u64ad x \u4e92\u52a8\u4e91\u73a9\u6cd5\uff0c\u6765\u548c\u5c0f\u4f19\u4f34\u4e00\u8d77\u73a9\u5427\uff5e");
            intent.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", dVar.f115635c);
            jSONObject2.put("desc", "\u76f4\u64ad x \u4e92\u52a8\u4e91\u73a9\u6cd5\uff0c\u6765\u548c\u5c0f\u4f19\u4f34\u4e00\u8d77\u73a9\u5427\uff5e");
            jSONObject2.put(WadlProxyConsts.KEY_JUMP_URL, zw0.a.d(cVar, 1));
            jSONObject2.put("preview", str3);
            jSONObject2.put("tag", dVar.f115640h);
            jSONObject2.put("tagIcon", "https://nowpic.gtimg.com/hy_personal_room/0/nest1679653725894.jpeg/0");
            jSONObject.put("news", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            rt0.a.e("ICGameShare|TimiGameShareUtil", "getShareArkIntent meta:" + jSONObject3);
            intent.putExtra("forward_ark_app_meta", jSONObject3);
        } catch (JSONException e16) {
            rt0.a.d("ICGameShare|TimiGameShareUtil", "getShareArkIntent", "get intent exception:", e16);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, com.tencent.icgame.game.liveroom.impl.room.share.timishare.d dVar) {
        String str;
        int i3 = actionSheetItem.action;
        int i16 = actionSheetItem.uinType;
        String str2 = actionSheetItem.uin;
        if (dVar == null) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 26 && i3 != 72) {
                        if (i3 != 73) {
                            switch (i3) {
                                case 9:
                                    d.a a16 = dVar.a(3);
                                    if (a16 == null) {
                                        return;
                                    }
                                    l(context, a16.f115642a, a16.f115643b, a16.f115644c, a16.f115645d, 0);
                                    break;
                                case 10:
                                    d.a a17 = dVar.a(2);
                                    if (a17 == null) {
                                        return;
                                    }
                                    l(context, a17.f115642a, a17.f115643b, a17.f115644c, a17.f115645d, 1);
                                    break;
                                case 11:
                                    d.a a18 = dVar.a(1);
                                    if (a18 == null) {
                                        com.tencent.icgame.game.ui.widget.f.b("\u5df2\u6536\u5230\u4f60\u7684\u4e3e\u62a5\uff0c\u6211\u4eec\u4f1a\u53ca\u65f6\u5904\u7406\u3002");
                                        break;
                                    } else {
                                        xw0.b.f448881a.z(context, a18.f115645d, ((mx0.a) qx0.a.b(mx0.a.class)).B());
                                        break;
                                    }
                            }
                        }
                    } else {
                        if (i3 == 26) {
                            str = AppConstants.DATALINE_NEW_VERSION_UIN;
                        } else {
                            str = str2;
                        }
                        d.a a19 = dVar.a(1);
                        if (a19 == null) {
                            return;
                        } else {
                            j(context, dVar, a19, str, i16);
                        }
                    }
                } else {
                    d.a a26 = dVar.a(0);
                    if (a26 == null) {
                        return;
                    }
                    try {
                        k(context, a26.f115642a, a26.f115643b, a26.f115644c, a26.f115645d, str2, 13421773);
                    } catch (Exception e16) {
                        rt0.a.c("ICGameShare|TimiGameShareUtil", "handleClickMenuItem", "shareToQzone error:" + e16);
                    }
                }
                return;
            }
            d.a a27 = dVar.a(1);
            if (a27 == null) {
                return;
            }
            j(context, dVar, a27, str2, i16);
            return;
        }
        d.a a28 = dVar.a(4);
        if (a28 == null) {
            return;
        }
        i(a28);
    }

    private void f(Context context, com.tencent.icgame.game.liveroom.impl.room.share.timishare.d dVar, String str, String str2, String str3, String str4, String str5, int i3) {
        String str6;
        Activity activity = (Activity) context;
        if (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        Intent d16 = d(dVar, str, str2, str3, str4, str5, i3);
        if (d16 == null) {
            return;
        }
        boolean z16 = !TextUtils.isEmpty(str5);
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            bundle.putInt("key_direct_show_uin_type", i3);
            bundle.putString("key_direct_show_uin", str5);
            d16.putExtras(bundle);
        }
        if (z16) {
            str6 = RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS;
        } else {
            str6 = RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT;
        }
        RouteUtils.startActivityForResult(activity, d16, str6, 13421772);
    }

    private void i(d.a aVar) {
        Activity topActivity;
        if (aVar == null || TextUtils.isEmpty(aVar.f115645d) || (topActivity = Foreground.getTopActivity()) == null) {
            return;
        }
        ClipboardMonitor.setPrimaryClip((ClipboardManager) topActivity.getSystemService("clipboard"), ClipData.newPlainText(null, aVar.f115645d));
    }

    private void j(Context context, com.tencent.icgame.game.liveroom.impl.room.share.timishare.d dVar, d.a aVar, String str, int i3) {
        if (context == null) {
            return;
        }
        if (((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId()) == null) {
            rt0.a.c("ICGameShare|TimiGameShareUtil", "shareToQQ", "IQQLiveSDK is null.");
        } else {
            f(context, dVar, aVar.f115642a, aVar.f115643b, aVar.f115644c, aVar.f115645d, str, i3);
        }
    }

    private void k(Context context, String str, String str2, String str3, String str4, String str5, int i3) {
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

    private void l(Context context, String str, String str2, String str3, String str4, int i3) {
        if (!c()) {
            return;
        }
        k.a(new AnonymousClass5(str3, String.valueOf(System.currentTimeMillis()), str, str2, str4, i3));
        WXShareHelper.b0().A(new e(i3));
    }

    private ShareActionSheetV2.Param m(Context context, ShareActionSheetV2.Param param) {
        if (ut0.b.c()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 80;
            layoutParams.topMargin = ViewUtils.getStatusBarHeight(context);
            param.f317475lp = layoutParams;
        }
        return param;
    }

    public void g(int i3, int i16, Intent intent) {
        f fVar;
        if (intent == null || i16 != -1) {
            return;
        }
        if (13421773 == i3) {
            f fVar2 = this.f115597a;
            if (fVar2 != null) {
                fVar2.a(0);
                this.f115597a = null;
                return;
            }
            return;
        }
        if (13421772 == i3 && (fVar = this.f115597a) != null) {
            fVar.a(1);
            this.f115597a = null;
        }
    }

    public ShareActionSheet h(Context context, com.tencent.icgame.game.liveroom.impl.room.share.timishare.d dVar, ShareActionSheet.OnItemClickListener onItemClickListener, DialogInterface.OnShowListener onShowListener, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnDismissListener onDismissListener, f fVar) {
        if (context == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("toast_d", 1, "openQQShareDialogV2:\u53c2\u6570\u5f02\u5e38 context == null");
            return null;
        }
        if (com.tencent.icgame.game.liveroom.impl.room.util.c.a()) {
            rt0.a.f("ICGameShare|TimiGameShareUtil", "openQQShareDialogV2", "openQQShareDialogV2 double click");
            return null;
        }
        this.f115597a = fVar;
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        ShareActionSheet create = ShareActionSheetFactory.create(m(context, param));
        create.setActionSheetTitle(context.getString(R.string.hja));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        if (dVar.f115641i) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        create.setActionSheetItems(arrayList, arrayList2);
        create.setRowVisibility(0, 0, 0);
        create.setItemClickListenerV2(new a(context, dVar, onItemClickListener));
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
}
