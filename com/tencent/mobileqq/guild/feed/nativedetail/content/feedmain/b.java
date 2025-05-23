package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain;

import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/b;", "Lhl1/g;", "", "getItemType", "", "getItemId", "newItem", "", "b", "a", "", "c", "I", "d", "()I", QzoneIPCModule.RESULT_CODE, "", "errMsg", "<init>", "(ILjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements hl1.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int resultCode;

    public b(int i3, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.resultCode = i3;
    }

    @Override // hl1.g
    public boolean a(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return true;
    }

    @Override // hl1.g
    public boolean b(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return true;
    }

    @Override // hl1.g
    @Nullable
    public Object c(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.TRUE;
    }

    /* renamed from: d, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    @Override // hl1.g
    public long getItemId() {
        return -559006440;
    }

    @Override // hl1.g
    public int getItemType() {
        return 10;
    }
}
