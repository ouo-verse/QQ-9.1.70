package com.tencent.guild.aio.factory.business.holder.msglist.scrollers;

import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.factory.business.holder.msglist.scrollers.GuildChatPicPreloadScrollListener$doPreload$2", f = "GuildChatPicPreloadScrollListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildChatPicPreloadScrollListener$doPreload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollDirection $direction;
    final /* synthetic */ List<com.tencent.aio.data.msglist.a> $displayListCopy;
    final /* synthetic */ int $firstVisiblePos;
    final /* synthetic */ int $lastVisiblePos;
    int label;
    final /* synthetic */ GuildChatPicPreloadScrollListener this$0;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110631a;

        static {
            int[] iArr = new int[ScrollDirection.values().length];
            try {
                iArr[ScrollDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScrollDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScrollDirection.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f110631a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChatPicPreloadScrollListener$doPreload$2(ScrollDirection scrollDirection, GuildChatPicPreloadScrollListener guildChatPicPreloadScrollListener, List<com.tencent.aio.data.msglist.a> list, int i3, int i16, Continuation<? super GuildChatPicPreloadScrollListener$doPreload$2> continuation) {
        super(2, continuation);
        this.$direction = scrollDirection;
        this.this$0 = guildChatPicPreloadScrollListener;
        this.$displayListCopy = list;
        this.$firstVisiblePos = i3;
        this.$lastVisiblePos = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildChatPicPreloadScrollListener$doPreload$2(this.$direction, this.this$0, this.$displayListCopy, this.$firstVisiblePos, this.$lastVisiblePos, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                int i3 = a.f110631a[this.$direction.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            this.this$0.f(this.$displayListCopy, this.$firstVisiblePos);
                            this.this$0.e(this.$displayListCopy, this.$lastVisiblePos);
                        }
                    } else {
                        this.this$0.e(this.$displayListCopy, this.$lastVisiblePos);
                    }
                } else {
                    this.this$0.f(this.$displayListCopy, this.$firstVisiblePos);
                }
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String obj2 = e16.toString();
                if (obj2 instanceof String) {
                    bVar.a().add(obj2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GUILD_MSGPIC.Preload", 1, (String) it.next(), null);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildChatPicPreloadScrollListener$doPreload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
