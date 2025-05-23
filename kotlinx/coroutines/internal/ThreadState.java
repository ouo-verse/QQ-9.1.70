package kotlinx.coroutines.internal;

import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", DomainData.DOMAIN_NAME, "", "(Lkotlin/coroutines/CoroutineContext;I)V", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "Lkotlinx/coroutines/ThreadContextElement;", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "values", "[Ljava/lang/Object;", "append", "", DTConstants.TAG.ELEMENT, "value", CanvasView.ACTION_RESTORE, "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ThreadState {

    @JvmField
    @NotNull
    public final CoroutineContext context;

    @NotNull
    private final ThreadContextElement<Object>[] elements;
    private int i;

    @NotNull
    private final Object[] values;

    public ThreadState(@NotNull CoroutineContext coroutineContext, int i3) {
        this.context = coroutineContext;
        this.values = new Object[i3];
        this.elements = new ThreadContextElement[i3];
    }

    public final void append(@NotNull ThreadContextElement<?> element, @Nullable Object value) {
        Object[] objArr = this.values;
        int i3 = this.i;
        objArr[i3] = value;
        ThreadContextElement<Object>[] threadContextElementArr = this.elements;
        this.i = i3 + 1;
        threadContextElementArr[i3] = element;
    }

    public final void restore(@NotNull CoroutineContext context) {
        int length = this.elements.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i3 = length - 1;
            ThreadContextElement<Object> threadContextElement = this.elements[length];
            Intrinsics.checkNotNull(threadContextElement);
            threadContextElement.restoreThreadContext(context, this.values[length]);
            if (i3 >= 0) {
                length = i3;
            } else {
                return;
            }
        }
    }
}
