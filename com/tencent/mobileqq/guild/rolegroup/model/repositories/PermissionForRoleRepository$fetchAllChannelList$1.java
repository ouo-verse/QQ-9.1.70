package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.rolegroup.model.repositories.PermissionForRoleRepository", f = "PermissionForRoleRepository.kt", i = {}, l = {181}, m = "fetchAllChannelList", n = {}, s = {})
/* loaded from: classes14.dex */
public final class PermissionForRoleRepository$fetchAllChannelList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionForRoleRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionForRoleRepository$fetchAllChannelList$1(PermissionForRoleRepository permissionForRoleRepository, Continuation<? super PermissionForRoleRepository$fetchAllChannelList$1> continuation) {
        super(continuation);
        this.this$0 = permissionForRoleRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
