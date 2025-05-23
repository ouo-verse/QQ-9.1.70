package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Spannable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import java.lang.reflect.Array;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\b\u0004\u0012\u0018\u0010\u001a\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ0\u0010\u000b\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J3\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\n\u0010\u0014\u001a\u00020\u0013\"\u00020\fH\u0004R&\u0010\u0019\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/p;", "V", "", "Landroid/text/Spannable;", "str", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Selection;", "selection", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/SpanCollectMode;", "mode", "", "Lzd1/e;", "a", "", "selStart", "selEnd", "", "b", "(Landroid/text/Spannable;II)[Lzd1/e;", WadlProxyConsts.FLAGS, "", "value", "", "c", "Ljava/lang/Class;", "Ljava/lang/Class;", "mSpanClazz", "spanClazz", "<init>", "(Ljava/lang/Class;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class p<V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Class<? extends zd1.e<V>> mSpanClazz;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(@Nullable Class<? extends zd1.e<V>> cls) {
        this.mSpanClazz = cls;
    }

    @Nullable
    public abstract List<zd1.e<V>> a(@NotNull Spannable str, @NotNull Selection selection, @NotNull SpanCollectMode mode);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final zd1.e<V>[] b(@NotNull Spannable str, int selStart, int selEnd) {
        Intrinsics.checkNotNullParameter(str, "str");
        zd1.e<V>[] eVarArr = (zd1.e[]) str.getSpans(selStart, selEnd, this.mSpanClazz);
        if (eVarArr == null) {
            Object newInstance = Array.newInstance(this.mSpanClazz, new int[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<com.tencent.mobileqq.gamecenter.qa.editor.span.RTSpan<V of com.tencent.mobileqq.gamecenter.qa.editor.effect.SpanCollector>>");
            return (zd1.e[]) newInstance;
        }
        return eVarArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c(int flags, @NotNull int... value) {
        Intrinsics.checkNotNullParameter(value, "value");
        for (int i3 : value) {
            if ((flags & i3) == i3) {
                return true;
            }
        }
        return false;
    }
}
