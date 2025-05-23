package com.tencent.mobileqq.guild.discovery.guildblockdetail;

import com.tencent.mobileqq.guild.discovery.avblockdetail.model.GuildRecommendCardItem;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.GuildRecommendDetailViewModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discovery.guildblockdetail.GuildRecommendDetailViewModel$fetchData$1", f = "GuildRecommendDetailViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildRecommendDetailViewModel$fetchData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $refreshNum;
    int label;
    final /* synthetic */ GuildRecommendDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRecommendDetailViewModel$fetchData$1(GuildRecommendDetailViewModel guildRecommendDetailViewModel, int i3, Continuation<? super GuildRecommendDetailViewModel$fetchData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildRecommendDetailViewModel;
        this.$refreshNum = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildRecommendDetailViewModel$fetchData$1(this.this$0, this.$refreshNum, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.util.ArrayList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i19 = this.label;
        if (i19 != 0) {
            if (i19 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildRecommendDetailViewModel guildRecommendDetailViewModel = this.this$0;
            int i26 = this.$refreshNum;
            this.label = 1;
            obj = guildRecommendDetailViewModel.getDiscoverRecommendDetail(i26, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp discoverRecommendDetailRsp = (GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp) obj;
        int categoryId = discoverRecommendDetailRsp.getCategoryId();
        i3 = this.this$0._categoryId;
        if (categoryId == i3) {
            int categoryConfId = discoverRecommendDetailRsp.getCategoryConfId();
            i16 = this.this$0._categoryConfId;
            if (categoryConfId == i16) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new ArrayList();
                GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp value = this.this$0.getDiscoverRecommendDetailRsp().getValue();
                if (value != null) {
                    GuildRecommendDetailViewModel guildRecommendDetailViewModel2 = this.this$0;
                    int categoryId2 = value.getCategoryId();
                    i18 = guildRecommendDetailViewModel2._categoryId;
                    if (categoryId2 == i18) {
                        ArrayList<GuildRecommendCardItem> d16 = value.d();
                        if (d16 != null && !d16.isEmpty()) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            objectRef.element = value.d();
                        }
                    }
                }
                ((ArrayList) objectRef.element).addAll(discoverRecommendDetailRsp.d());
                this.this$0.getDiscoverRecommendDetailRsp().setValue(new GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp(discoverRecommendDetailRsp.getCategoryId(), discoverRecommendDetailRsp.getCategoryConfId(), discoverRecommendDetailRsp.getResult(), discoverRecommendDetailRsp.getData(), (ArrayList) objectRef.element));
                this.this$0.getDiscoverRecommendDetailRspForNewCard().setValue(new GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp(discoverRecommendDetailRsp.getCategoryId(), discoverRecommendDetailRsp.getCategoryConfId(), discoverRecommendDetailRsp.getResult(), discoverRecommendDetailRsp.getData(), (ArrayList) objectRef.element));
                GuildRecommendDetailViewModel guildRecommendDetailViewModel3 = this.this$0;
                i17 = guildRecommendDetailViewModel3.mRefreshNum;
                guildRecommendDetailViewModel3.mRefreshNum = i17 + 1;
                return Unit.INSTANCE;
            }
        }
        QLog.d("Guild.discovery.recommend.GuildRecommendDetailViewModel", 1, "fetchData rsp.categoryId:" + discoverRecommendDetailRsp.getCategoryId() + " != cur categoryId:" + this.this$0.getCategoryId() + ", rsp.categoryConfId:" + discoverRecommendDetailRsp.getCategoryConfId() + " != cur categoryConfId:" + this.this$0.getCategoryConfId() + " return");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildRecommendDetailViewModel$fetchData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
