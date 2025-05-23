package com.tencent.guild.aio.msglist.marketface;

import android.widget.ImageView;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/aio/msglist/marketface/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "setMsgEle", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;)V", "msgEle", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setBubbleIv", "(Landroid/widget/ImageView;)V", "bubbleIv", "", "c", "J", "()J", "setMsgId", "(J)V", "msgId", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Landroid/widget/ImageView;J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.msglist.marketface.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class IntentData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private MarketFaceElement msgEle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ImageView bubbleIv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long msgId;

    public IntentData(@NotNull MarketFaceElement msgEle, @NotNull ImageView bubbleIv, long j3) {
        Intrinsics.checkNotNullParameter(msgEle, "msgEle");
        Intrinsics.checkNotNullParameter(bubbleIv, "bubbleIv");
        this.msgEle = msgEle;
        this.bubbleIv = bubbleIv;
        this.msgId = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ImageView getBubbleIv() {
        return this.bubbleIv;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final MarketFaceElement getMsgEle() {
        return this.msgEle;
    }

    /* renamed from: c, reason: from getter */
    public final long getMsgId() {
        return this.msgId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntentData)) {
            return false;
        }
        IntentData intentData = (IntentData) other;
        if (Intrinsics.areEqual(this.msgEle, intentData.msgEle) && Intrinsics.areEqual(this.bubbleIv, intentData.bubbleIv) && this.msgId == intentData.msgId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.msgEle.hashCode() * 31) + this.bubbleIv.hashCode()) * 31) + androidx.fragment.app.a.a(this.msgId);
    }

    @NotNull
    public String toString() {
        return "IntentData(msgEle=" + this.msgEle + ", bubbleIv=" + this.bubbleIv + ", msgId=" + this.msgId + ")";
    }
}
