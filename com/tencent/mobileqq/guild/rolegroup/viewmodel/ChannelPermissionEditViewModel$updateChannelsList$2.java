package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionTypeForRole;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.PermissionForRoleRepository;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.rolegroup.viewmodel.ChannelPermissionEditViewModel$updateChannelsList$2", f = "ChannelPermissionEditViewModel.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class ChannelPermissionEditViewModel$updateChannelsList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RoleGroupModel $model;
    int label;
    final /* synthetic */ ChannelPermissionEditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelPermissionEditViewModel$updateChannelsList$2(ChannelPermissionEditViewModel channelPermissionEditViewModel, RoleGroupModel roleGroupModel, Continuation<? super ChannelPermissionEditViewModel$updateChannelsList$2> continuation) {
        super(2, continuation);
        this.this$0 = channelPermissionEditViewModel;
        this.$model = roleGroupModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChannelPermissionEditViewModel$updateChannelsList$2(this.this$0, this.$model, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List list;
        List list2;
        List<String> b16;
        PermissionForRoleRepository permissionForRoleRepository;
        List list3;
        MutableLiveData mutableLiveData;
        List e26;
        List q26;
        List list4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            list = this.this$0.mOriginList;
            list.clear();
            ChannelPermissionTypeForRole channelPermissionTypeForRole = this.this$0.mType;
            ChannelPermissionTypeForRole channelPermissionTypeForRole2 = ChannelPermissionTypeForRole.ApproveSpeak;
            if (channelPermissionTypeForRole == channelPermissionTypeForRole2) {
                list3 = this.this$0.mOriginList;
                list3.addAll(this.$model.getChannelPermission().a());
            } else {
                list2 = this.this$0.mOriginList;
                list2.addAll(this.$model.getChannelPermission().b());
            }
            if (this.this$0.mType == channelPermissionTypeForRole2) {
                b16 = this.$model.getChannelPermission().a();
            } else {
                b16 = this.$model.getChannelPermission().b();
            }
            permissionForRoleRepository = this.this$0.mPermissionForRoleRepository;
            this.label = 1;
            obj = permissionForRoleRepository.h(b16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List list5 = (List) obj;
        this.this$0.r2(list5);
        mutableLiveData = this.this$0.mChannelListLiveData;
        ChannelPermissionEditViewModel channelPermissionEditViewModel = this.this$0;
        e26 = channelPermissionEditViewModel.e2(list5);
        q26 = channelPermissionEditViewModel.q2(e26);
        mutableLiveData.setValue(q26);
        Logger logger = Logger.f235387a;
        ChannelPermissionEditViewModel channelPermissionEditViewModel2 = this.this$0;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            list4 = channelPermissionEditViewModel2.mOriginList;
            d16.d("Guild.rg.ChannelPermissionEditViewModel", 2, "updateChannelsList mOriginList:" + list4);
        }
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.ChannelPermissionEditViewModel", 2, "updateChannelsList mChannelUIDataList:" + list5);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelPermissionEditViewModel$updateChannelsList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
