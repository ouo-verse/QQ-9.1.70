package com.tencent.kuikly.core.render.android.expand.component;

import android.content.Context;
import android.text.Layout;
import android.text.method.TransformationMethod;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\n\u001a\u00020\u00072+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002JI\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRTextAreaView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRTextFieldView;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "m0", "value", "", "d0", "", "method", "params", "call", "propKey", "propValue", "b", "Landroid/content/Context;", "context", "", "softInputMode", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRTextAreaView extends KRTextFieldView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRTextAreaView(@NotNull Context context, @Nullable Integer num) {
        super(context, num);
        Intrinsics.checkNotNullParameter(context, "context");
        setSingleLine(false);
        setGravity(51);
    }

    private final boolean d0(Object value) {
        TransformationMethod transformationMethod = getTransformationMethod();
        setSingleLine(true);
        setTransformationMethod(transformationMethod);
        setMaxLines(Integer.MAX_VALUE);
        int i3 = 0;
        setHorizontallyScrolling(false);
        if (value != null) {
            String str = (String) value;
            switch (str.hashCode()) {
                case -906336856:
                    if (str.equals("search")) {
                        i3 = 3;
                        break;
                    }
                    break;
                case 3304:
                    if (str.equals(ResourceAttributes.TelemetrySdkLanguageValues.GO)) {
                        i3 = 2;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        i3 = 6;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        i3 = 5;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        i3 = 4;
                        break;
                    }
                    break;
            }
            setImeOptions(i3);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void m0(Function1<Object, Unit> callback) {
        Map mapOf;
        if (callback != null) {
            com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
            Layout layout = getLayout();
            Intrinsics.checkNotNullExpressionValue(layout, "layout");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("height", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(aVar, layout.getHeight()))));
            callback.invoke(mapOf);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (propKey.hashCode() == 947486441 && propKey.equals("returnKeyType")) {
            return d0(propValue);
        }
        return super.b(propKey, propValue);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView, i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method.hashCode() == 1505784384 && method.equals("getInnerContentHeight")) {
            m0(callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
