package com.tencent.kuikly.core.render.android.expand.component;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.util.SizeF;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00019B\u000f\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J1\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u000bj\u0002`\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R;\u00100\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bj\u0004\u0018\u0001`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRRichTextView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "O", "Lcom/tencent/kuikly/core/render/android/expand/component/KRRichTextShadow;", "richTextShadow", "P", "", "propValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "N", "", "", "M", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "textShadow", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "Lcom/tencent/kuikly/core/render/android/expand/component/text/f;", "T", "", ExifInterface.LATITUDE_SOUTH, "params", BdhLogUtil.LogTag.Tag_Req, "Li01/b;", "shadow", CanvasView.ACTION_SET_SHADOW, "setLayoutParams", tl.h.F, "propKey", "b", "onDraw", "H", "Lcom/tencent/kuikly/core/render/android/expand/component/KRRichTextShadow;", "I", "Lcom/tencent/kuikly/core/render/android/expand/component/text/f;", "textDrawer", "J", "Z", "isRichTextMode", "K", "Lkotlin/jvm/functions/Function1;", "textWithLineBreakCallback", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "L", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRRichTextView extends KRView {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private KRRichTextShadow richTextShadow;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.kuikly.core.render.android.expand.component.text.f textDrawer;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isRichTextMode;

    /* renamed from: K, reason: from kotlin metadata */
    private Function1<Object, Unit> textWithLineBreakCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRRichTextView$a;", "", "", "GRADIENT_RICH_TEXT_VIEW", "Ljava/lang/String;", "PROP_EVENT_TEXT_WITH_LINE_BREAK", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRRichTextView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R8\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/KRRichTextView$b", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "d", "Lkotlin/jvm/functions/Function1;", "getOriginClickCallback", "()Lkotlin/jvm/functions/Function1;", "originClickCallback", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b implements Function1<Object, Unit> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<Object, Unit> originClickCallback;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f117763f;

        b(Object obj) {
            this.f117763f = obj;
            if (obj != null) {
                this.originClickCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
        }

        public void a(@Nullable Object result) {
            if (!KRRichTextView.this.isRichTextMode) {
                this.originClickCallback.invoke(result);
            } else {
                this.originClickCallback.invoke(KRRichTextView.this.M(result));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRRichTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> M(Object result) {
        float f16;
        int i3;
        float f17;
        int i16;
        CharSequence charSequence;
        com.tencent.kuikly.core.render.android.expand.component.text.b[] bVarArr;
        boolean z16;
        Layout textLayout;
        Layout textLayout2;
        Layout textLayout3;
        Layout textLayout4;
        if (result != null) {
            Map map = (Map) result;
            com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
            Object obj = map.get(HippyTKDListViewAdapter.X);
            CharSequence charSequence2 = null;
            if (!(obj instanceof Float)) {
                obj = null;
            }
            Float f18 = (Float) obj;
            float f19 = 0.0f;
            if (f18 != null) {
                f16 = f18.floatValue();
            } else {
                f16 = 0.0f;
            }
            float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(aVar, f16);
            com.tencent.kuikly.core.render.android.a aVar2 = get_kuiklyRenderContext();
            Object obj2 = map.get("y");
            if (!(obj2 instanceof Float)) {
                obj2 = null;
            }
            Float f26 = (Float) obj2;
            if (f26 != null) {
                f19 = f26.floatValue();
            }
            int I2 = (int) com.tencent.kuikly.core.render.android.css.ktx.b.I(aVar2, f19);
            com.tencent.kuikly.core.render.android.expand.component.text.f fVar = this.textDrawer;
            if (fVar != null && (textLayout4 = fVar.getTextLayout()) != null) {
                i3 = textLayout4.getLineForVertical(I2);
            } else {
                i3 = 0;
            }
            com.tencent.kuikly.core.render.android.expand.component.text.f fVar2 = this.textDrawer;
            if (fVar2 != null && (textLayout3 = fVar2.getTextLayout()) != null) {
                f17 = textLayout3.getLineMax(i3);
            } else {
                f17 = -1.0f;
            }
            int i17 = -1;
            if (f17 == -1.0f || I <= f17) {
                com.tencent.kuikly.core.render.android.expand.component.text.f fVar3 = this.textDrawer;
                if (fVar3 != null && (textLayout2 = fVar3.getTextLayout()) != null) {
                    i16 = textLayout2.getOffsetForHorizontal(i3, I);
                } else {
                    i16 = 0;
                }
                com.tencent.kuikly.core.render.android.expand.component.text.f fVar4 = this.textDrawer;
                if (fVar4 != null && (textLayout = fVar4.getTextLayout()) != null) {
                    charSequence = textLayout.getText();
                } else {
                    charSequence = null;
                }
                if (charSequence instanceof Spanned) {
                    charSequence2 = charSequence;
                }
                Spanned spanned = (Spanned) charSequence2;
                if (spanned != null && (bVarArr = (com.tencent.kuikly.core.render.android.expand.component.text.b[]) spanned.getSpans(i16, i16, com.tencent.kuikly.core.render.android.expand.component.text.b.class)) != null) {
                    if (bVarArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        i17 = bVarArr[0].getIndex();
                    }
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map);
            linkedHashMap.put("index", Integer.valueOf(i17));
            return linkedHashMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    private final Function1<Object, Unit> N(Object propValue) {
        return new b(propValue);
    }

    private final void O(Canvas canvas) {
        com.tencent.kuikly.core.render.android.expand.component.text.f fVar = this.textDrawer;
        if (fVar != null) {
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            fVar.a(canvas);
            canvas.restore();
        }
    }

    private final void P(KRRichTextShadow richTextShadow) {
        Function1<Object, Unit> function1;
        if (richTextShadow != null && (function1 = this.textWithLineBreakCallback) != null) {
            function1.invoke(richTextShadow.v());
        }
    }

    private final void Q(KRRichTextShadow richTextShadow) {
        if (richTextShadow != null) {
            this.textDrawer = T(richTextShadow, getLayoutParams());
        }
    }

    private final boolean R(ViewGroup.LayoutParams params) {
        int i3 = params.width;
        if (i3 != -1 && i3 != -2 && i3 != 0) {
            return false;
        }
        return true;
    }

    private final boolean S(ViewGroup.LayoutParams layoutParams, KRRichTextShadow textShadow) {
        Layout layout;
        com.tencent.kuikly.core.render.android.expand.component.text.f textDrawer = textShadow.getTextDrawer();
        if (textDrawer != null) {
            layout = textDrawer.getTextLayout();
        } else {
            layout = null;
        }
        if (layout == null || R(layoutParams) || layoutParams.width == layout.getWidth()) {
            return false;
        }
        return true;
    }

    private final com.tencent.kuikly.core.render.android.expand.component.text.f T(KRRichTextShadow textShadow, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (S(layoutParams, textShadow)) {
                textShadow.x(new SizeF(layoutParams.width, layoutParams.height));
            }
            return textShadow.getTextDrawer();
        }
        return textShadow.getTextDrawer();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        int hashCode = propKey.hashCode();
        if (hashCode != -108791016) {
            if (hashCode != 94750088) {
                if (hashCode == 1292595405 && propKey.equals("backgroundImage")) {
                    return true;
                }
            } else if (propKey.equals("click")) {
                return super.b(propKey, N(propValue));
            }
        } else if (propKey.equals("textWithLineBreak")) {
            this.textWithLineBreakCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        return super.b(propKey, propValue);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void h() {
        super.h();
        this.richTextShadow = null;
        this.textDrawer = null;
        this.isRichTextMode = false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return true;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        O(canvas);
    }

    @Override // android.view.View
    public void setLayoutParams(@Nullable ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        Q(this.richTextShadow);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        super.setShadow(shadow);
        KRRichTextShadow kRRichTextShadow = (KRRichTextShadow) shadow;
        this.isRichTextMode = kRRichTextShadow.getIsRichTextMode();
        Unit unit = Unit.INSTANCE;
        this.richTextShadow = kRRichTextShadow;
        P(kRRichTextShadow);
        Q(this.richTextShadow);
        invalidate();
    }
}
