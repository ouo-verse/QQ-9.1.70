package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.rolegroup.model.repositories.PermissionForRoleRepository", f = "PermissionForRoleRepository.kt", i = {0, 0}, l = {51}, m = "fetchPermissionForRole", n = {"this", "selectedChannels"}, s = {"L$0", "L$1"})
/* loaded from: classes14.dex */
public final class PermissionForRoleRepository$fetchPermissionForRole$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionForRoleRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionForRoleRepository$fetchPermissionForRole$1(PermissionForRoleRepository permissionForRoleRepository, Continuation<? super PermissionForRoleRepository$fetchPermissionForRole$1> continuation) {
        super(continuation);
        this.this$0 = permissionForRoleRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, this);
    }
}
