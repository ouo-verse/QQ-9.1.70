package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Editable;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd1.e;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u0018\u00010\u0005H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J!\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u0006\u0010\r\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/e;", "V", "Lzd1/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/g;", "Ljava/lang/Class;", "spanClazz", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/p;", "e", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "editor", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Selection;", "c", "value", "", "a", "(Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;Ljava/lang/Object;)V", "g", "(Ljava/lang/Object;)Lzd1/e;", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class e<V, C extends zd1.e<V>> extends g<V, C> {
    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.g
    public void a(@Nullable GameStrategyEditTextView editor, V value) {
        int i3;
        Editable editable;
        zd1.e<V> g16;
        V v3;
        boolean z16;
        Selection c16 = c(editor);
        if (c16.isEmpty()) {
            i3 = 18;
        } else {
            i3 = 34;
        }
        if (editor != null) {
            editable = editor.getText();
        } else {
            editable = null;
        }
        Intrinsics.checkNotNull(editable, "null cannot be cast to non-null type android.text.Spannable");
        try {
            List<zd1.e<V>> d16 = d(editable, c16, SpanCollectMode.SPAN_FLAGS);
            Intrinsics.checkNotNull(d16);
            for (zd1.e<V> eVar : d16) {
                if (eVar != null) {
                    v3 = eVar.getValue();
                } else {
                    v3 = null;
                }
                if (v3 != null) {
                    V value2 = eVar.getValue();
                    if (value2 != null) {
                        z16 = value2.equals(value);
                    } else {
                        z16 = false;
                    }
                    int spanStart = editable.getSpanStart(eVar);
                    if (spanStart < c16.getMStart()) {
                        if (z16) {
                            c16.offset(c16.getMStart() - spanStart, 0);
                            i3 = 34;
                        } else {
                            editable.setSpan(g(eVar.getValue()), spanStart, c16.getMStart(), 33);
                        }
                    }
                    int spanEnd = editable.getSpanEnd(eVar);
                    if (spanEnd > c16.getMEnd()) {
                        if (z16) {
                            c16.offset(0, spanEnd - c16.getMEnd());
                        } else {
                            editable.setSpan(g(eVar.getValue()), c16.getMEnd(), spanEnd, 34);
                        }
                    }
                    editable.removeSpan(eVar);
                }
            }
            if (value != null && (g16 = g(value)) != null) {
                editable.setSpan(g16, c16.getMStart(), c16.getMEnd(), i3);
            }
        } catch (Exception e16) {
            QLog.e("CharacterEffect", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.g
    @NotNull
    protected Selection c(@Nullable GameStrategyEditTextView editor) {
        Intrinsics.checkNotNull(editor, "null cannot be cast to non-null type android.widget.EditText");
        return new Selection(editor);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.g
    @NotNull
    protected p<V> e(@Nullable Class<? extends zd1.e<V>> spanClazz) {
        return new f(spanClazz);
    }

    @Nullable
    protected abstract zd1.e<V> g(V value);
}
