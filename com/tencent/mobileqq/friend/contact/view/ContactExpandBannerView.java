package com.tencent.mobileqq.friend.contact.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.friend.contact.api.impl.ContactExpandBannerApiImpl;
import com.tencent.mobileqq.friend.contact.view.ContactExpandBannerView;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/friend/contact/view/ContactExpandBannerView;", "Landroid/widget/RelativeLayout;", "", "b", "c", "Landroid/content/Context;", "context", "", "url", "g", "f", "e", "d", "Ljava/lang/String;", "imageUrl", WadlProxyConsts.KEY_JUMP_URL, "", "I", "jumpAction", "", h.F, "Z", "dismissOnClick", "<init>", "(Landroid/content/Context;)V", "i", "a", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ContactExpandBannerView extends RelativeLayout {

    /* renamed from: i, reason: collision with root package name */
    private static final a f211599i = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String imageUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String jumpUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int jumpAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean dismissOnClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/friend/contact/view/ContactExpandBannerView$a;", "", "", "JUMP_ACTION_MINI_APP", "I", "JUMP_ACTION_SCHEMA", "JUMP_ACTION_WEB", "", "KEY_DISMISS_ON_CLICK", "Ljava/lang/String;", "KEY_IMAGE_URL", "KEY_JUMP_ACTION", "KEY_JUMP_URL", "TAG", "VAS_TRAN_BG_URL_KEY", "<init>", "()V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactExpandBannerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.imageUrl = "";
        this.jumpUrl = "";
        this.jumpAction = 1;
        b();
        c();
    }

    private final void b() {
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(ContactExpandBannerApiImpl.CONFIG_ID, "");
            if (TextUtils.isEmpty(loadAsString)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(loadAsString);
            String optString = jSONObject.optString("imageURL", "");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY_IMAGE_URL, \"\")");
            this.imageUrl = optString;
            String optString2 = jSONObject.optString("jumpURL", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(KEY_JUMP_URL, \"\")");
            this.jumpUrl = optString2;
            this.jumpAction = jSONObject.optInt("jumpAction", 1);
            this.dismissOnClick = jSONObject.optInt("dismissOnClick", 0) == 1;
            if (QLog.isDebugVersion()) {
                QLog.i("ContactExpandBannerView", 4, "initData imageUrl = " + this.imageUrl + "; jumpUrl = " + this.jumpUrl + ';');
            }
        } catch (Exception e16) {
            QLog.e("ContactExpandBannerView", 1, "initData: failed, e=", e16);
        }
    }

    private final void c() {
        if (TextUtils.isEmpty(this.imageUrl)) {
            return;
        }
        RoundCornerImageView roundCornerImageView = new RoundCornerImageView(getContext());
        roundCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        roundCornerImageView.setCorner(ViewUtils.dpToPx(8.0f));
        String str = this.imageUrl;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        roundCornerImageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        addView(roundCornerImageView, new RelativeLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() { // from class: xc1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactExpandBannerView.d(ContactExpandBannerView.this, view);
            }
        });
        VideoReport.setElementId(this, "em_friends_spring_festival_banner");
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ContactExpandBannerView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = this$0.jumpAction;
        if (i3 == 1) {
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this$0.g(context, this$0.jumpUrl);
        } else if (i3 == 2) {
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            this$0.f(context2, this$0.jumpUrl);
        } else if (i3 == 3) {
            Context context3 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            this$0.e(context3, this$0.jumpUrl);
        }
        if (this$0.dismissOnClick) {
            this$0.setVisibility(8);
        }
    }

    private final void e(Context context, String url) {
        if (url.length() == 0) {
            return;
        }
        QRouteApi api = QRoute.api(IMiniAppService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
        ((IMiniAppService) api).startMiniApp(context, url, 2122, null);
    }

    private final void f(Context context, String url) {
        if (url.length() == 0) {
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(url));
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_JUMP);
    }

    private final void g(Context context, String url) {
        boolean startsWith$default;
        if (TextUtils.isEmpty(url)) {
            return;
        }
        VideoReport.reportEvent("clck", this, null);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://h5.vip.qq.com/p/pay", false, 2, null);
        if (startsWith$default) {
            Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("url", url);
            intent.setData(Uri.parse(url));
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("url", url);
        RouteUtils.startActivity(context, intent2, RouterConstants.UI_ROUTE_BROWSER);
    }
}
