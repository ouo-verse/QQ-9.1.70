package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.LoadingUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001&B'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u00020\u001e\u00a2\u0006\u0004\bF\u0010GJ\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0016\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u0014\u0010\u001a\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u0014\u0010\u001b\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\tJ \u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!J\u0006\u0010$\u001a\u00020\tJ\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u000e\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u000bJ \u0010.\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020,H\u0016R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00100R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00104R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00106R\u0016\u00109\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00108R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00106R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010?\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryKuiklyFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/home/views/embeddable/e;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "url", "", "", "o", "", "i", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "showLoadingView", "hideLoadingView", "showErrorView", "hideErrorView", "categoryName", h.F, "Lkotlin/Function0;", "onLoadFinish", "g", "f", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "j", "k", "direction", "a", "canScrollVertically", "isKuiklyHorizontalDragging", "setKuiklyHorizontalDragging", "dX", "dY", "", "consumed", "c", "d", "Lkotlin/jvm/functions/Function0;", "e", "onLoadFailed", "Landroid/view/View;", "Landroid/view/View;", "loadingFrameLayout", "Z", "isKuiklyViewInited", "I", "currentScrollY", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "mKuiklyRenderView", "D", "Ljava/lang/String;", "E", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DiscoveryKuiklyFrameLayout extends FrameLayout implements com.tencent.mobileqq.guild.home.views.embeddable.e, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private g mKuiklyRenderView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String url;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String categoryName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onLoadFinish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onLoadFailed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View loadingFrameLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isKuiklyViewInited;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentScrollY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isKuiklyHorizontalDragging;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryKuiklyFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void i() {
        boolean z16;
        if (this.isKuiklyViewInited) {
            return;
        }
        this.isKuiklyViewInited = true;
        if (this.url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("DiscoveryKuiklyFrameLayout", 1, "initKuiklyView error url is null");
            return;
        }
        Map<String, Object> o16 = o(this.url);
        if (!o16.containsKey("page_name")) {
            QLog.e("DiscoveryKuiklyFrameLayout", 1, "initKuiklyView pageName is null");
            return;
        }
        String valueOf = String.valueOf(o16.get("page_name"));
        QLog.d("DiscoveryKuiklyFrameLayout", 1, "initKuiklyView pageName=", valueOf);
        o16.put("needNotifyPageScroll", "1");
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.b(valueOf, o16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DiscoveryKuiklyFrameLayout this$0) {
        ViewGroup viewGroup;
        KeyEvent.Callback callback;
        View childAt;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object obj = this$0.mKuiklyRenderView;
        ViewGroup viewGroup2 = null;
        if (obj instanceof ViewGroup) {
            viewGroup = (ViewGroup) obj;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            callback = viewGroup.getChildAt(0);
        } else {
            callback = null;
        }
        if (callback instanceof ViewGroup) {
            viewGroup2 = (ViewGroup) callback;
        }
        if (viewGroup2 != null && (childAt = viewGroup2.getChildAt(0)) != null) {
            childAt.requestLayout();
        }
    }

    private final Map<String, Object> o(String url) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri parse = Uri.parse(url);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null) {
                for (String it : queryParameterNames) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String queryParameter = parse.getQueryParameter(it);
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(it) ?: \"\"");
                    linkedHashMap.put(it, queryParameter);
                }
            }
        } catch (Throwable th5) {
            QLog.e("schemeParams", 1, "schemeParams error: " + th5);
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public boolean a(int direction) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryKuiklyFrameLayout", "isHorizontalDragging isKuiklyHorizontalDragging:" + this.isKuiklyHorizontalDragging);
        }
        return this.isKuiklyHorizontalDragging;
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public void c(int dX, int dY, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(consumed, "consumed");
    }

    @Override // android.view.View, com.tencent.mobileqq.guild.home.views.embeddable.e
    public boolean canScrollVertically(int direction) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryKuiklyFrameLayout", "canScrollVertically(" + direction + ") " + this.currentScrollY);
        }
        if (direction > 0) {
            return true;
        }
        if (direction < 0 && this.currentScrollY > 0) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull Function0<Unit> onLoadFinish) {
        Intrinsics.checkNotNullParameter(onLoadFinish, "onLoadFinish");
        this.onLoadFailed = onLoadFinish;
    }

    public final void g(@NotNull Function0<Unit> onLoadFinish) {
        Intrinsics.checkNotNullParameter(onLoadFinish, "onLoadFinish");
        this.onLoadFinish = onLoadFinish;
    }

    public final void h(@NotNull String url, @NotNull String categoryName) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.url = url;
        this.categoryName = categoryName;
        i();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        Logger.f235387a.d().d("DiscoveryKuiklyFrameLayout", 1, "[hideErrorView] ");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        Logger.f235387a.d().d("DiscoveryKuiklyFrameLayout", 1, "[hideLoadingView] ");
        this.loadingFrameLayout.setVisibility(8);
    }

    public final void j(int requestCode, int resultCode, @Nullable Intent data) {
        QLog.d("DiscoveryKuiklyFrameLayout", 2, "onActivityResult requestCode:" + requestCode + " resultCode:" + resultCode);
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onActivityResult(requestCode, resultCode, data);
        }
    }

    public final void k() {
        QLog.i("DiscoveryKuiklyFrameLayout", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onPause();
        }
        g gVar2 = this.mKuiklyRenderView;
        if (gVar2 != null) {
            gVar2.onDetach();
        }
        this.mKuiklyRenderView = null;
    }

    public final void m() {
        QLog.d("DiscoveryKuiklyFrameLayout", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onPause();
        }
    }

    public final void n() {
        QLog.d("DiscoveryKuiklyFrameLayout", 2, "onResume");
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onResume();
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.d("DiscoveryKuiklyFrameLayout", 1, "onPageLoadComplete result=", Boolean.valueOf(isSucceed));
        hideLoadingView();
        if (isSucceed) {
            Function0<Unit> function0 = this.onLoadFinish;
            if (function0 != null) {
                function0.invoke();
            }
            post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    DiscoveryKuiklyFrameLayout.l(DiscoveryKuiklyFrameLayout.this);
                }
            });
            return;
        }
        Function0<Unit> function02 = this.onLoadFailed;
        if (function02 != null) {
            function02.invoke();
        }
    }

    public final void setKuiklyHorizontalDragging(boolean isKuiklyHorizontalDragging) {
        this.isKuiklyHorizontalDragging = isKuiklyHorizontalDragging;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        Logger.f235387a.d().d("DiscoveryKuiklyFrameLayout", 1, "[showErrorView] ");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        Logger.f235387a.d().d("DiscoveryKuiklyFrameLayout", 1, "[showLoadingView] ");
        this.loadingFrameLayout.setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryKuiklyFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DiscoveryKuiklyFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DiscoveryKuiklyFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.url = "";
        this.categoryName = "";
        g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(context, this);
        this.mKuiklyRenderView = createKuiklyRenderView;
        Intrinsics.checkNotNull(createKuiklyRenderView, "null cannot be cast to non-null type android.view.View");
        addView((View) createKuiklyRenderView, new FrameLayout.LayoutParams(-1, -1, 17));
        View loadingDialogTipsRight = LoadingUtil.getLoadingDialogTipsRight(context, false);
        Intrinsics.checkNotNullExpressionValue(loadingDialogTipsRight, "getLoadingDialogTipsRight(context, false)");
        this.loadingFrameLayout = loadingDialogTipsRight;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        layoutParams.setMargins(0, 0, 0, QQGuildUIUtil.f(54.0f));
        addView(this.loadingFrameLayout, layoutParams);
        QLog.d("DiscoveryKuiklyFrameLayout", 1, "init");
    }
}
