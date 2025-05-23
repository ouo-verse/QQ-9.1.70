package com.tencent.mobileqq.guild.base.repository;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B%\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJM\u0010\u0012\u001aI\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00018\u0000\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\nR\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/base/repository/ResultDispatcher;", "", "T", "Lri1/a;", "error", "", "b", "result", "c", "(Ljava/lang/Object;)V", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "code", "", "message", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "Ljava/lang/String;", "functionName", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "callback", "Lcom/tencent/mobileqq/guild/base/repository/g;", "Lcom/tencent/mobileqq/guild/base/repository/g;", "repositoryDispatcher", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/base/repository/h;Lcom/tencent/mobileqq/guild/base/repository/g;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ResultDispatcher<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String functionName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h<T> callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g repositoryDispatcher;

    public ResultDispatcher(@NotNull String functionName, @NotNull h<T> callback, @NotNull g repositoryDispatcher) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(repositoryDispatcher, "repositoryDispatcher");
        this.functionName = functionName;
        this.callback = callback;
        this.repositoryDispatcher = repositoryDispatcher;
    }

    @NotNull
    public final Function3<Integer, String, T, Unit> a() {
        return new Function3<Integer, String, T, Unit>(this) { // from class: com.tencent.mobileqq.guild.base.repository.ResultDispatcher$defaultMethod$1
            final /* synthetic */ ResultDispatcher<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Object obj) {
                invoke(num.intValue(), str, (String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String message, @Nullable T t16) {
                Intrinsics.checkNotNullParameter(message, "message");
                ri1.a error = ri1.a.b(i3, message);
                if (!error.d()) {
                    ResultDispatcher<T> resultDispatcher = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(error, "error");
                    resultDispatcher.b(error);
                } else {
                    if (t16 == null) {
                        ResultDispatcher<T> resultDispatcher2 = this.this$0;
                        ri1.a b16 = ri1.a.b(-10, message);
                        Intrinsics.checkNotNullExpressionValue(b16, "error(SDK_CLIENT_RETURN_NULL_OBJECT, message)");
                        resultDispatcher2.b(b16);
                        return;
                    }
                    this.this$0.c(t16);
                }
            }
        };
    }

    public final void b(@NotNull ri1.a error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.repositoryDispatcher.c(this.callback, this.functionName, error);
    }

    public final void c(@NotNull T result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.repositoryDispatcher.e(this.callback, this.functionName, result);
    }
}
