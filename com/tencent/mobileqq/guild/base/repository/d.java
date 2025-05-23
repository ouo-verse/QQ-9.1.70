package com.tencent.mobileqq.guild.base.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/base/repository/d;", "Lcom/tencent/mobileqq/guild/base/repository/b;", "Lcom/tencent/mobileqq/guild/base/repository/c;", "d", "Lcom/tencent/mobileqq/guild/base/repository/c;", "a", "()Lcom/tencent/mobileqq/guild/base/repository/c;", "repositoryCallbackConfig", "", "tag", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RepositoryCallbackConfig repositoryCallbackConfig;

    public d(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.repositoryCallbackConfig = new RepositoryCallbackConfig(tag);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.b
    @NotNull
    /* renamed from: a, reason: from getter */
    public RepositoryCallbackConfig getRepositoryCallbackConfig() {
        return this.repositoryCallbackConfig;
    }
}
