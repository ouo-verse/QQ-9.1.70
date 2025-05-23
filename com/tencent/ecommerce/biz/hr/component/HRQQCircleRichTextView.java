package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.util.SizeF;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import i01.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0002)\fB\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R;\u0010 \u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019j\u0004\u0018\u0001`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRQQCircleRichTextView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "", h.F, "Li01/b;", "shadow", CanvasView.ACTION_SET_SHADOW, "", "propKey", "", "propValue", "", "b", "Lcom/tencent/ecommerce/biz/hr/component/HRQQCircleRichTextView$b;", "H", "Lcom/tencent/ecommerce/biz/hr/component/HRQQCircleRichTextView$b;", "richTextShadow", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "I", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "qCircleApi", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView;", "J", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView;", "richTextView", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "K", "Lkotlin/jvm/functions/Function1;", "contentExpandCallback", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "L", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRQQCircleRichTextView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private b richTextShadow;

    /* renamed from: I, reason: from kotlin metadata */
    private IECQCircleApi qCircleApi;

    /* renamed from: J, reason: from kotlin metadata */
    private IECQCircleRichTextView richTextView;

    /* renamed from: K, reason: from kotlin metadata */
    private Function1<Object, Unit> contentExpandCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R>\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRQQCircleRichTextView$b;", "Li01/f;", "", "propKey", "", "propValue", "", "b", "Landroid/util/SizeF;", "constraintSize", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "e", "()Ljava/util/HashMap;", "setPropMap", "(Ljava/util/HashMap;)V", "propMap", "", UserInfo.SEX_FEMALE, "f", "()F", "setWidth", "(F)V", "width", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private HashMap<String, Object> propMap = new HashMap<>();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float width;

        @Override // i01.b
        public void b(String propKey, Object propValue) {
            this.propMap.put(propKey, propValue);
        }

        @Override // i01.b
        public SizeF c(SizeF constraintSize) {
            this.width = constraintSize.getWidth();
            IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
            return new SizeF(constraintSize.getWidth(), qCircleApi != null ? qCircleApi.calculateQCircleRichTextHeight(wg0.a.a(), constraintSize.getWidth(), this.propMap) : 0.0f);
        }

        public final HashMap<String, Object> e() {
            return this.propMap;
        }

        /* renamed from: f, reason: from getter */
        public final float getWidth() {
            return this.width;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/hr/component/HRQQCircleRichTextView$setShadow$1$1", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView$IQCircleContentExpandListener;", "", "isExpanded", "", NodeProps.ON_CLICK, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECQCircleRichTextView.IQCircleContentExpandListener {
        c() {
        }

        @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView.IQCircleContentExpandListener
        public void onClick(boolean isExpanded) {
            Map emptyMap;
            Function1 function1 = HRQQCircleRichTextView.this.contentExpandCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HRQQCircleRichTextView(Context context) {
        super(context);
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        this.qCircleApi = qCircleApi;
        IECQCircleRichTextView createQCircleRichTextView = qCircleApi != null ? qCircleApi.createQCircleRichTextView(context) : 0;
        this.richTextView = createQCircleRichTextView;
        if (createQCircleRichTextView != 0) {
            TextView textView = (TextView) createQCircleRichTextView;
            textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(textView);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(String propKey, Object propValue) {
        if (propKey.hashCode() != -723517325 || !propKey.equals("contentExpand")) {
            return super.b(propKey, propValue);
        }
        if (propValue != null) {
            this.contentExpandCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void h() {
        super.h();
        IECQCircleRichTextView iECQCircleRichTextView = this.richTextView;
        if (iECQCircleRichTextView != null) {
            iECQCircleRichTextView.resetView();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return true;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void setShadow(i01.b shadow) {
        super.setShadow(shadow);
        if (shadow != null) {
            b bVar = (b) shadow;
            this.richTextShadow = bVar;
            IECQCircleRichTextView iECQCircleRichTextView = this.richTextView;
            if (iECQCircleRichTextView != null) {
                iECQCircleRichTextView.setViewWidth(bVar.getWidth());
                b bVar2 = this.richTextShadow;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("richTextShadow");
                }
                IECQCircleRichTextView.a.a(iECQCircleRichTextView, bVar2.e(), false, 2, null);
                iECQCircleRichTextView.setContentExpandListener(new c());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.hr.component.HRQQCircleRichTextView.HRQQCircleRichTextShadow");
    }
}
