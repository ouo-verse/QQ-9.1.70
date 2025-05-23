package com.tencent.mobileqq.guild.setting.member.selector;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorViewModel$changeSearchModeIfNeed$1", f = "GuildMemberSelectorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildMemberSelectorViewModel$changeSearchModeIfNeed$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildMemberSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMemberSelectorViewModel$changeSearchModeIfNeed$1(GuildMemberSelectorViewModel guildMemberSelectorViewModel, Continuation<? super GuildMemberSelectorViewModel$changeSearchModeIfNeed$1> continuation) {
        super(2, continuation);
        this.this$0 = guildMemberSelectorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildMemberSelectorViewModel$changeSearchModeIfNeed$1 guildMemberSelectorViewModel$changeSearchModeIfNeed$1 = new GuildMemberSelectorViewModel$changeSearchModeIfNeed$1(this.this$0, continuation);
        guildMemberSelectorViewModel$changeSearchModeIfNeed$1.L$0 = obj;
        return guildMemberSelectorViewModel$changeSearchModeIfNeed$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildMemberSelectorViewModel", "search\uff1a" + str);
            }
            mutableLiveData = this.this$0._isSearchModeLiveData;
            if (Intrinsics.areEqual(mutableLiveData.getValue(), Boxing.boxBoolean(true))) {
                this.this$0.nextPos = 0L;
                mutableLiveData2 = this.this$0._searchLoadStateLiveData;
                mutableLiveData2.setValue(Boxing.boxInt(GuildMemberSelectorViewModel.b.INSTANCE.c()));
                this.this$0.h2();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull String str, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMemberSelectorViewModel$changeSearchModeIfNeed$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
