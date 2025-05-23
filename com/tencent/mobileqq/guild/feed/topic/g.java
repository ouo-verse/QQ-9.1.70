package com.tencent.mobileqq.guild.feed.topic;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopicFeedsRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0003\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/g;", "", "Lri1/a;", "a", "Lri1/a;", "c", "()Lri1/a;", "rspStatus", "", "Lvn1/b;", "b", "Ljava/util/List;", "()Ljava/util/List;", "list", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsRsp;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsRsp;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsRsp;", "rawRsp", "", "d", "Z", "()Z", "isFinish", "<init>", "(Lri1/a;Ljava/util/List;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsRsp;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ri1.a rspStatus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<vn1.b> list;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProGetTopicFeedsRsp rawRsp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isFinish;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull ri1.a rspStatus, @NotNull List<? extends vn1.b> list, @NotNull GProGetTopicFeedsRsp rawRsp) {
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(rawRsp, "rawRsp");
        this.rspStatus = rspStatus;
        this.list = list;
        this.rawRsp = rawRsp;
        this.isFinish = rawRsp.isFinish == 1;
    }

    @NotNull
    public final List<vn1.b> a() {
        return this.list;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final GProGetTopicFeedsRsp getRawRsp() {
        return this.rawRsp;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ri1.a getRspStatus() {
        return this.rspStatus;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }
}
