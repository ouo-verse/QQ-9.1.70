package com.tencent.qqguild.base.mvvm;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import ol3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u00020\u0006B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqguild/base/mvvm/AIOViewModel;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/base/mvvm/b;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "d", "Lkotlin/Lazy;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class AIOViewModel<I extends ol3.b, S extends MviUIState> extends com.tencent.aio.base.mvvm.b<I, S> implements CoroutineScope {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy coroutineContext;

    public AIOViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineContext>(this) { // from class: com.tencent.qqguild.base.mvvm.AIOViewModel$coroutineContext$2
            final /* synthetic */ AIOViewModel<I, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineContext invoke() {
                return this.this$0.vmScope().getCoroutineContext().plus(new CoroutineName(this.this$0.getClass().getCanonicalName().toString()));
            }
        });
        this.coroutineContext = lazy;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public final CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.coroutineContext.getValue();
    }
}
