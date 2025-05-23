package com.tencent.mobileqq.zplan.share.action;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.image.URLDrawable;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.mobileqq.zplan.share.ZPlanShareParam;
import com.tencent.mobileqq.zplan.share.action.b;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0002)'B\u001d\u0012\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+\u0018\u00010*\u00a2\u0006\u0004\bA\u0010BJ`\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002JB\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002JL\u0010\u0015\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010!\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0016J*\u0010&\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$H\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020(H\u0016R%\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006\u00a2\u0006\f\n\u0004\b'\u0010,\u001a\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u00109\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010@\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/i;", "Lcom/tencent/mobileqq/zplan/share/action/b;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "title", "desc", "shareUrl", "imageUrl", "directMessage", "", "requestCode", "uinType", "uin", "l", "url", "iconUrl", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "image_url", "k", "directMsg", "Landroid/content/Intent;", "j", "Lcom/tencent/mobileqq/zplan/share/action/i$b;", "callback", "i", "Lcom/tencent/mobileqq/zplan/share/e;", "shareParams", "d", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "f", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "listener", "", IProfileProtocolConst.PARAM_IS_FRIEND, "e", "b", "Lcom/tencent/mobileqq/zplan/share/report/c;", "a", "", "", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "extra", "c", "Ljava/lang/String;", "mWXTransaction", "Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;", "Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;", tl.h.F, "()Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;", "setApi", "(Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;)V", DTConstants.TAG.API, "Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;", "Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;", "getMWxShareListener", "()Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;", "setMWxShareListener", "(Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;)V", "mWxShareListener", "<init>", "(Ljava/util/Map;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i implements com.tencent.mobileqq.zplan.share.action.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> extra;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String mWXTransaction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private IWXShareHelper api;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IWXShareHelperListener mWxShareListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/i$b;", "", "Landroid/graphics/Bitmap;", "bmp", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(Bitmap bmp);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/share/action/i$c", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f335519d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f335520e;

        c(URLDrawable uRLDrawable, b bVar) {
            this.f335519d = uRLDrawable;
            this.f335520e = bVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            this.f335520e.a(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable urlDrawable, Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.f335520e.a(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            this.f335520e.a(BaseImageUtil.drawabletoBitmapV2(this.f335519d, 100, 100));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/share/action/i$e", "Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;", "Lcom/tencent/mobileqq/wxapi/data/WXShareRsp;", "resp", "", "onWXShareResp", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements IWXShareHelperListener {
        e() {
        }

        @Override // com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener
        public void onWXShareResp(WXShareRsp resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            if (i.this.mWXTransaction == null || !Intrinsics.areEqual(i.this.mWXTransaction, resp.transaction)) {
                return;
            }
            if (resp.errCode != ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_OK()) {
                ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_USER_CANCEL();
            }
            ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).removeObserver(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/share/action/i$f", "Lcom/tencent/mobileqq/zplan/share/action/i$b;", "Landroid/graphics/Bitmap;", "bmp", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanShareParam f335525b;

        f(ZPlanShareParam zPlanShareParam) {
            this.f335525b = zPlanShareParam;
        }

        @Override // com.tencent.mobileqq.zplan.share.action.i.b
        public void a(Bitmap bmp) {
            WXShareHelper.b0().J0(i.this.mWXTransaction, this.f335525b.getTitle(), bmp, this.f335525b.getDesc(), this.f335525b.getPath());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/share/action/i$g", "Lcom/tencent/mobileqq/zplan/share/action/i$b;", "Landroid/graphics/Bitmap;", "bmp", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanShareParam f335527b;

        g(ZPlanShareParam zPlanShareParam) {
            this.f335527b = zPlanShareParam;
        }

        @Override // com.tencent.mobileqq.zplan.share.action.i.b
        public void a(Bitmap bmp) {
            i.this.getApi().shareTroopToWXFriendCircle(i.this.mWXTransaction, this.f335527b.getTitle(), bmp, this.f335527b.getDesc(), this.f335527b.getPath());
        }
    }

    public i(Map<String, ? extends Object> map) {
        this.extra = map;
        QRouteApi api = QRoute.api(IWXShareHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n        IWXShareHelper::class.java\n    )");
        this.api = (IWXShareHelper) api;
        this.mWxShareListener = new e();
    }

    private final Intent j(String directMsg) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", -1);
        bundle.putString(AppConstants.Key.FORWARD_TEXT, directMsg);
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        intent.putExtra("isFromShare", true);
        intent.putExtras(bundle);
        return intent;
    }

    private final void m(Activity activity, String url, String title, String desc, String iconUrl, int requestCode) {
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mTitle = title;
        qZoneShareData.mSummary = desc;
        qZoneShareData.targetUrl = url;
        qZoneShareData.mShareBeginTime = SystemClock.currentThreadTimeMillis();
        if (!TextUtils.isEmpty(iconUrl)) {
            ArrayList<String> arrayList = new ArrayList<>();
            qZoneShareData.mImageUrls = arrayList;
            arrayList.add(iconUrl);
        }
        qZoneShareData.from = 2;
        qZoneShareData.mWebUrl = url;
        QZoneShareManager.shareToQzone(activity, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), qZoneShareData, null, requestCode);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public com.tencent.mobileqq.zplan.share.report.c a() {
        com.tencent.mobileqq.zplan.share.report.d dVar = new com.tencent.mobileqq.zplan.share.report.d();
        if (this.extra != null) {
            dVar.m().putAll(this.extra);
        }
        return dVar;
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void b(Activity activity, ZPlanShareParam shareParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        k(activity, shareParams.getTitle(), shareParams.getDesc(), shareParams.getPath(), shareParams.getThumbPath(), shareParams.getDirectMessage(), shareParams.getRequestCode());
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void c(ZPlanShareLaunchParam zPlanShareLaunchParam) {
        b.C9201b.d(this, zPlanShareLaunchParam);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void d(Activity activity, ZPlanShareParam shareParams, int uinType, String uin) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        l(activity, shareParams.getTitle(), shareParams.getDesc(), shareParams.getPath(), shareParams.getThumbPath(), shareParams.getDirectMessage(), shareParams.getRequestCode(), uinType, uin);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void e(Activity activity, ZPlanShareParam shareParams, WXShareHelper.a listener, boolean isFriend) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        this.mWXTransaction = String.valueOf(System.currentTimeMillis());
        if (listener != null) {
            WXShareHelper.b0().A(listener);
        }
        if (isFriend) {
            if (!TextUtils.isEmpty(shareParams.getThumbPath())) {
                String thumbPath = shareParams.getThumbPath();
                Intrinsics.checkNotNull(thumbPath);
                i(thumbPath, new f(shareParams));
                return;
            }
            WXShareHelper.b0().J0(this.mWXTransaction, shareParams.getTitle(), null, shareParams.getDesc(), shareParams.getPath());
            return;
        }
        if (!TextUtils.isEmpty(shareParams.getThumbPath())) {
            String thumbPath2 = shareParams.getThumbPath();
            Intrinsics.checkNotNull(thumbPath2);
            i(thumbPath2, new g(shareParams));
            return;
        }
        this.api.shareTroopToWXFriend(this.mWXTransaction, shareParams.getTitle(), null, shareParams.getDesc(), shareParams.getPath());
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void f(Activity activity, ZPlanShareParam shareParams, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        m(activity, shareParams.getPath(), shareParams.getTitle(), shareParams.getDesc(), shareParams.getThumbPath(), shareParams.getRequestCode());
    }

    /* renamed from: h, reason: from getter */
    public final IWXShareHelper getApi() {
        return this.api;
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onDestroy() {
        b.C9201b.a(this);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onFinish() {
        b.C9201b.b(this);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onResume() {
        b.C9201b.c(this);
    }

    private final void i(String url, b callback) {
        if (callback == null || TextUtils.isEmpty(url)) {
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, URLDrawable.URLDrawableOptions.obtain());
        drawable.setURLDrawableListener(new c(drawable, callback));
        drawable.setDownloadListener(new d(drawable, callback));
        if (drawable.getStatus() == 1) {
            callback.a(BaseImageUtil.drawabletoBitmapV2(drawable, 100, 100));
        } else {
            drawable.startDownload();
        }
    }

    private final int k(Activity activity, String title, String desc, String share_url, String image_url, String directMessage, int requestCode) {
        if (activity == null) {
            return -1;
        }
        if (directMessage != null) {
            share_url = directMessage;
        } else if (share_url == null) {
            share_url = "";
        }
        Intent j3 = j(share_url);
        j3.putExtra("is_multi_selection", false);
        j3.putExtra("only_single_selection", true);
        j3.putExtra("call_by_forward", true);
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, j3, requestCode);
        return 0;
    }

    private final int l(Activity activity, String title, String desc, String shareUrl, String imageUrl, String directMessage, int requestCode, int uinType, String uin) {
        if (activity == null) {
            return -1;
        }
        if (directMessage != null) {
            shareUrl = directMessage;
        } else if (shareUrl == null) {
            shareUrl = "";
        }
        Intent j3 = j(shareUrl);
        if (!TextUtils.isEmpty(uin)) {
            Bundle bundle = new Bundle();
            bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            bundle.putInt("key_direct_show_uin_type", uinType);
            bundle.putString("key_direct_show_uin", uin);
            j3.putExtras(bundle);
        }
        ForwardBaseOption.startForwardActivityForResult(activity, j3, requestCode, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
        return 0;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/share/action/i$d", "Lcom/tencent/image/URLDrawable$DownloadListener;", "", "onFileDownloadStarted", "", "l", "onFileDownloadSucceed", "", "i", "onFileDownloadFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements URLDrawable.DownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f335521d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f335522e;

        d(URLDrawable uRLDrawable, b bVar) {
            this.f335521d = uRLDrawable;
            this.f335522e = bVar;
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int i3) {
            this.f335522e.a(null);
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long l3) {
            this.f335522e.a(BaseImageUtil.drawabletoBitmapV2(this.f335521d, 100, 100));
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
        }
    }
}
