package com.tencent.mobileqq.guild.media.core.notify;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/bf;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "d", "Ljava/util/List;", "getRaiseHandUserList", "()Ljava/util/List;", "raiseHandUserList", "<init>", "(Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bf implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProUserInfo> raiseHandUserList;

    /* JADX WARN: Multi-variable type inference failed */
    public bf(@NotNull List<? extends IGProUserInfo> raiseHandUserList) {
        Intrinsics.checkNotNullParameter(raiseHandUserList, "raiseHandUserList");
        this.raiseHandUserList = raiseHandUserList;
    }
}
