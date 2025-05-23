package com.tencent.mobileqq.gamecenter.kuikly;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import dd1.b;
import dd1.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020&\u00a2\u0006\u0004\b9\u0010:J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J8\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J*\u0010\u001c\u001a\u00020\t2\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0013J8\u0010\u001f\u001a\u00020\t2.\u0010\u001e\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0013\u0012\u0004\u0012\u00020\t0\u001dH\u0016J\b\u0010 \u001a\u00020\tH\u0016R@\u0010\u001e\u001a,\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0013\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010!R6\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/GuildBizCardKuiklyView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Ldd1/b;", "", "url", "", "", "e", "", "d", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extendParams", "b", "Ldd1/c;", "loadListener", "setLoadListener", "onResume", "a", "params", "c", "Lkotlin/Function1;", "reportHandler", "setReportHandler", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/jvm/functions/Function1;", "Ljava/util/HashMap;", "f", "Z", "isKuiklyViewInited", "", h.F, "I", "getCurrentScrollY", "()I", "setCurrentScrollY", "(I)V", "currentScrollY", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "i", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "mKuiklyRenderView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildBizCardKuiklyView extends FrameLayout implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super HashMap<String, String>, Unit> reportHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<String, Object> extendParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isKuiklyViewInited;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentScrollY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mKuiklyRenderView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String url;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildBizCardKuiklyView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        boolean z16;
        String str;
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
            QLog.e("GuildBizCardKuiklyView", 1, "initKuiklyView error url is null");
            return;
        }
        Map<String, Object> e16 = e(this.url);
        HashMap<String, Object> hashMap = this.extendParams;
        if (hashMap != null) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                e16.put(entry.getKey(), entry.getValue());
            }
        }
        if (e16.containsKey("page_name")) {
            Object obj = e16.get("page_name");
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            QLog.d("GuildBizCardKuiklyView", 1, "initKuiklyView pageName=", str);
            g gVar = this.mKuiklyRenderView;
            if (gVar != null) {
                gVar.b(str, e16, null);
            }
        }
    }

    private final Map<String, Object> e(String url) {
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

    @Override // dd1.b
    public void a() {
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.sentEvent("guild_biz_card_expose", new HashMap());
        }
    }

    @Override // dd1.b
    public void b(@NotNull String url, @Nullable HashMap<String, Object> extendParams) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.extendParams = extendParams;
        d();
    }

    public final void c(@NotNull HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Function1<? super HashMap<String, String>, Unit> function1 = this.reportHandler;
        if (function1 != null) {
            function1.invoke(params);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // dd1.b
    public void onDestroy() {
        QLog.i("GuildBizCardKuiklyView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
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

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("GuildBizCardKuiklyView", 1, "onPageLoadComplete result=" + isSucceed);
    }

    @Override // dd1.b
    public void onResume() {
        QLog.d("GuildBizCardKuiklyView", 2, "onResume");
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onResume();
        }
    }

    public final void setCurrentScrollY(int i3) {
        this.currentScrollY = i3;
    }

    public void setLoadListener(@NotNull c loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
    }

    @Override // dd1.b
    public void setReportHandler(@NotNull Function1<? super HashMap<String, String>, Unit> reportHandler) {
        Intrinsics.checkNotNullParameter(reportHandler, "reportHandler");
        this.reportHandler = reportHandler;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildBizCardKuiklyView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildBizCardKuiklyView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public GuildBizCardKuiklyView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.url = "";
        g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(context, this);
        this.mKuiklyRenderView = createKuiklyRenderView;
        Intrinsics.checkNotNull(createKuiklyRenderView, "null cannot be cast to non-null type android.view.View");
        addView((View) createKuiklyRenderView, new FrameLayout.LayoutParams(-1, -1, 17));
        QLog.d("GuildBizCardKuiklyView", 1, "init");
    }
}
