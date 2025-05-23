package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetShuoshuoListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SealOffMemory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/QzoneMoodListInfo;", "", "()V", "attachInfo", "", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "sealOffMemory", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "getSealOffMemory", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "setSealOffMemory", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;)V", "shuoshuoTimerUnpublishedCount", "", "getShuoshuoTimerUnpublishedCount", "()I", "setShuoshuoTimerUnpublishedCount", "(I)V", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneMoodListInfo {
    private String attachInfo = "";
    private boolean hasMore;
    private SealOffMemory sealOffMemory;
    private int shuoshuoTimerUnpublishedCount;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/QzoneMoodListInfo$Companion;", "", "()V", "fromRsp", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/QzoneMoodListInfo;", "rsp", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetShuoshuoListRsp;", "fromRsp$qecommerce_biz_release", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QzoneMoodListInfo fromRsp$qecommerce_biz_release(GetShuoshuoListRsp rsp) {
            QzoneMoodListInfo qzoneMoodListInfo = new QzoneMoodListInfo();
            qzoneMoodListInfo.setAttachInfo(rsp.attachInfo);
            qzoneMoodListInfo.setHasMore(rsp.hasMore);
            qzoneMoodListInfo.setSealOffMemory(rsp.sealOffMemory);
            qzoneMoodListInfo.setShuoshuoTimerUnpublishedCount(rsp.shuoshuoTimerUnpublishedCount);
            return qzoneMoodListInfo;
        }

        Companion() {
        }
    }

    public final String getAttachInfo() {
        return this.attachInfo;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final SealOffMemory getSealOffMemory() {
        return this.sealOffMemory;
    }

    public final int getShuoshuoTimerUnpublishedCount() {
        return this.shuoshuoTimerUnpublishedCount;
    }

    public final void setAttachInfo(String str) {
        this.attachInfo = str;
    }

    public final void setHasMore(boolean z16) {
        this.hasMore = z16;
    }

    public final void setSealOffMemory(SealOffMemory sealOffMemory) {
        this.sealOffMemory = sealOffMemory;
    }

    public final void setShuoshuoTimerUnpublishedCount(int i3) {
        this.shuoshuoTimerUnpublishedCount = i3;
    }
}
