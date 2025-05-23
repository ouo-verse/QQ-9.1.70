package com.tencent.mobileqq.guild.media.core.notify;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/m;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "d", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "a", "()Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "giftData", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "pngFilePath", "<init>", "(Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class m implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String pngFilePath;

    public m(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftData, @Nullable String str) {
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        this.giftData = giftData;
        this.pngFilePath = str;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.mobileqq.qqgift.mvvm.business.anim.a getGiftData() {
        return this.giftData;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getPngFilePath() {
        return this.pngFilePath;
    }
}
