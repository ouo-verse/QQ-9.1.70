package ge;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.OverlayInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lge/e;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;", "b", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;", "f", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/OverlayInfo;)V", "overlayInfo", "", "J", "()J", "e", "(J)V", "batchId", "", "c", "I", "()I", tl.h.F, "(I)V", "praiseNum", "", "d", "Z", "()Z", "g", "(Z)V", "isPraise", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private OverlayInfo overlayInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long batchId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int praiseNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isPraise;

    /* renamed from: a, reason: from getter */
    public final long getBatchId() {
        return this.batchId;
    }

    /* renamed from: b, reason: from getter */
    public final OverlayInfo getOverlayInfo() {
        return this.overlayInfo;
    }

    /* renamed from: c, reason: from getter */
    public final int getPraiseNum() {
        return this.praiseNum;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsPraise() {
        return this.isPraise;
    }

    public final void e(long j3) {
        this.batchId = j3;
    }

    public final void f(OverlayInfo overlayInfo) {
        this.overlayInfo = overlayInfo;
    }

    public final void g(boolean z16) {
        this.isPraise = z16;
    }

    public final void h(int i3) {
        this.praiseNum = i3;
    }
}
