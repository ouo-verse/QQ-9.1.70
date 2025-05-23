package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Editable;
import android.text.Spannable;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0010\b\u0001\u0010\u0003*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0006\u001a\u00020\u0005J.\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0018\u0010\u0013\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u0018\u00010\u0012H$J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H$J!\u0010\u0019\u001a\u00020\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/g;", "V", "Lzd1/e;", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "editor", "", "b", "", "f", "Landroid/text/Spannable;", "str", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Selection;", "selection", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/SpanCollectMode;", "mode", "d", "Ljava/lang/Class;", "spanClazz", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/p;", "e", "c", "value", "", "a", "(Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;Ljava/lang/Object;)V", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/p;", "mSpanCollector", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class g<V, C extends zd1.e<V>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private p<V> mSpanCollector;

    public abstract void a(@Nullable GameStrategyEditTextView editor, V value);

    public final boolean b(@NotNull GameStrategyEditTextView editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Selection c16 = c(editor);
        Editable text = editor.getText();
        Intrinsics.checkNotNullExpressionValue(text, "editor.text");
        if (d(text, c16, SpanCollectMode.SPAN_FLAGS) == null || !(!r3.isEmpty())) {
            return false;
        }
        return true;
    }

    @NotNull
    protected abstract Selection c(@Nullable GameStrategyEditTextView editor);

    @Nullable
    public final List<zd1.e<V>> d(@NotNull Spannable str, @NotNull Selection selection, @NotNull SpanCollectMode mode) {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (this.mSpanCollector == null) {
            ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            Intrinsics.checkNotNull(parameterizedType);
            Type type = parameterizedType.getActualTypeArguments()[r0.length - 1];
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<out com.tencent.mobileqq.gamecenter.qa.editor.span.RTSpan<V of com.tencent.mobileqq.gamecenter.qa.editor.effect.Effect>?>");
            this.mSpanCollector = e((Class) type);
        }
        p<V> pVar = this.mSpanCollector;
        if (pVar != null) {
            return pVar.a(str, selection, mode);
        }
        return null;
    }

    @Nullable
    protected abstract p<V> e(@Nullable Class<? extends zd1.e<V>> spanClazz);

    @NotNull
    public final List<V> f(@NotNull GameStrategyEditTextView editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        ArrayList arrayList = new ArrayList();
        Selection c16 = c(editor);
        Editable text = editor.getText();
        Intrinsics.checkNotNullExpressionValue(text, "editor.text");
        List<zd1.e<V>> d16 = d(text, c16, SpanCollectMode.SPAN_FLAGS);
        if (d16 != null) {
            for (zd1.e<V> eVar : d16) {
                if (eVar != null) {
                    arrayList.add(eVar.getValue());
                }
            }
        }
        return arrayList;
    }
}
