package com.tencent.mobileqq.guild.media.core.notify;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/a;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "userIdList", "", "e", "Z", "a", "()Z", "notifyForAll", "<init>", "(Ljava/util/List;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<String> userIdList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean notifyForAll;

    public a(@Nullable List<String> list, boolean z16) {
        this.userIdList = list;
        this.notifyForAll = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNotifyForAll() {
        return this.notifyForAll;
    }

    @Nullable
    public final List<String> b() {
        return this.userIdList;
    }
}
