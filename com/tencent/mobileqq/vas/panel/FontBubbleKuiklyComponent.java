package com.tencent.mobileqq.vas.panel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.css.ktx.b;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.panel.RichTextPanelView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0002\f%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u00020\u0004H\u0016J\"\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vas/panel/FontBubbleKuiklyComponent;", "T", "Lcom/tencent/mobileqq/panel/RichTextPanelView;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", QZoneDTLoginReporter.SCHEMA, "", "e", "f", "Lcom/tencent/mobileqq/vas/panel/FontBubbleKuiklyComponent$PanelType;", "panelType", "g", "a", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "show", "c", "b", "Lcom/tencent/mobileqq/vas/panel/FontBubbleKuiklyComponent$PanelType;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", h.F, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "fontBubblePanelView", "Lcom/tencent/mobileqq/vas/panel/FontBubblePayEventReceiver;", "i", "Lcom/tencent/mobileqq/vas/panel/FontBubblePayEventReceiver;", "fontBubblePayEventReceiver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "PanelType", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FontBubbleKuiklyComponent<T> extends RichTextPanelView implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PanelType panelType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private g fontBubblePanelView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FontBubblePayEventReceiver fontBubblePayEventReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/panel/FontBubbleKuiklyComponent$PanelType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "FONT", "BUBBLE", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum PanelType {
        FONT(3),
        BUBBLE(4);

        private final int value;

        PanelType(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontBubbleKuiklyComponent(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e(String schema) {
        QLog.i("FontBubbleKuiklyComponent", 1, "vas_aio_fontbubble: " + schema);
        IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
        Activity topActivity = Foreground.getTopActivity();
        Intrinsics.checkNotNullExpressionValue(topActivity, "getTopActivity()");
        g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(topActivity, this);
        this.fontBubblePanelView = createKuiklyRenderView;
        Object obj = null;
        if (createKuiklyRenderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fontBubblePanelView");
            createKuiklyRenderView = null;
        }
        g.a.a(createKuiklyRenderView, schema, null, 2, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        g gVar = this.fontBubblePanelView;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fontBubblePanelView");
        } else {
            obj = gVar;
        }
        addView((View) obj, layoutParams);
    }

    private final void f() {
        this.fontBubblePayEventReceiver = new FontBubblePayEventReceiver(new Function2<String, JSONObject, Unit>(this) { // from class: com.tencent.mobileqq.vas.panel.FontBubbleKuiklyComponent$initFontBubblePayEventReceiver$1
            final /* synthetic */ FontBubbleKuiklyComponent<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, JSONObject jSONObject) {
                invoke2(str, jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String event, JSONObject data) {
                g gVar;
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(data, "data");
                gVar = ((FontBubbleKuiklyComponent) this.this$0).fontBubblePanelView;
                if (gVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fontBubblePanelView");
                    gVar = null;
                }
                gVar.sentEvent(event, b.G(data));
            }
        });
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public String a() {
        PanelType panelType = this.panelType;
        if (panelType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelType");
            panelType = null;
        }
        if (panelType == PanelType.FONT) {
            String qqStr = HardCodeUtil.qqStr(R.string.mmu);
            Intrinsics.checkNotNullExpressionValue(qqStr, "{\n        HardCodeUtil.q\u2026_fontbubb_fe1a0959)\n    }");
            return qqStr;
        }
        String qqStr2 = HardCodeUtil.qqStr(R.string.mmt);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "{\n        HardCodeUtil.q\u2026_fontbubb_cbfdf4af)\n    }");
        return qqStr2;
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void b() {
        super.b();
        g gVar = this.fontBubblePanelView;
        if (gVar != null) {
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fontBubblePanelView");
                gVar = null;
            }
            gVar.onDetach();
        }
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void c(boolean show) {
        g gVar = null;
        if (show) {
            FontBubblePayEventReceiver fontBubblePayEventReceiver = this.fontBubblePayEventReceiver;
            if (fontBubblePayEventReceiver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fontBubblePayEventReceiver");
                fontBubblePayEventReceiver = null;
            }
            fontBubblePayEventReceiver.a();
            g gVar2 = this.fontBubblePanelView;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fontBubblePanelView");
            } else {
                gVar = gVar2;
            }
            gVar.onResume();
            return;
        }
        FontBubblePayEventReceiver fontBubblePayEventReceiver2 = this.fontBubblePayEventReceiver;
        if (fontBubblePayEventReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fontBubblePayEventReceiver");
            fontBubblePayEventReceiver2 = null;
        }
        fontBubblePayEventReceiver2.b();
        g gVar3 = this.fontBubblePanelView;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fontBubblePanelView");
        } else {
            gVar = gVar3;
        }
        gVar.onPause();
    }

    public final void g(String schema, PanelType panelType) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(panelType, "panelType");
        this.panelType = panelType;
        e(schema);
        f();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("FontBubbleKuiklyComponent", 1, "onPageLoadComplete");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }
}
