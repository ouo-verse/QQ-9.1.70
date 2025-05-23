package e40;

import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$MapEntry;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\tBM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u001f\u0010\u000eR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b!\u0010\u000eR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b#\u0010\u000eR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001e\u0010\f\"\u0004\b%\u0010\u000e\u00a8\u0006)"}, d2 = {"Le40/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setFeedId", "(Ljava/lang/String;)V", "feedId", "b", "I", "f", "()I", "setFeedPos", "(I)V", "feedPos", "c", "Z", "g", "()Z", "l", "(Z)V", "hasBtnVariant", "d", "i", "btnIcon", "j", "btnJumpUrl", tl.h.F, "btnAdId", "k", "btnTraceInfo", "<init>", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e40.d, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSPublishFeedVariantInfo {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String feedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int feedPos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasBtnVariant;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String btnIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String btnJumpUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String btnAdId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String btnTraceInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Le40/d$a;", "", "", "Ltianshu/QQCircleTianShu$AdItem;", "lst", "Le40/d;", "variantInfo", "", "b", "", "feedPos", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "a", "", "KEY_ICON", "Ljava/lang/String;", "KEY_JUMP_URL", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e40.d$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void b(List<QQCircleTianShu$AdItem> lst, QFSPublishFeedVariantInfo variantInfo) {
            boolean z16;
            List<QQCircleTianShu$AdItem> list = lst;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            QQCircleTianShu$AdItem qQCircleTianShu$AdItem = lst.get(0);
            variantInfo.l(true);
            variantInfo.h(String.valueOf(qQCircleTianShu$AdItem.iAdId.get()));
            String str = qQCircleTianShu$AdItem.traceinfo.get();
            Intrinsics.checkNotNullExpressionValue(str, "adItem.traceinfo.get()");
            variantInfo.k(str);
            List<QQCircleTianShu$MapEntry> list2 = qQCircleTianShu$AdItem.argList.get();
            Intrinsics.checkNotNullExpressionValue(list2, "adItem.argList.get()");
            for (QQCircleTianShu$MapEntry qQCircleTianShu$MapEntry : list2) {
                String str2 = qQCircleTianShu$MapEntry.key.get();
                if (Intrinsics.areEqual(str2, "icon")) {
                    String str3 = qQCircleTianShu$MapEntry.value.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "it.value.get()");
                    variantInfo.i(str3);
                } else if (Intrinsics.areEqual(str2, "jump_url")) {
                    String str4 = qQCircleTianShu$MapEntry.value.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "it.value.get()");
                    variantInfo.j(str4);
                }
            }
        }

        @NotNull
        public final QFSPublishFeedVariantInfo a(int feedPos, @NotNull FeedCloudMeta$StFeed stFeed) {
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            String str = stFeed.f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.id.get()");
            QFSPublishFeedVariantInfo qFSPublishFeedVariantInfo = new QFSPublishFeedVariantInfo(str, feedPos, false, null, null, null, null, 124, null);
            List<QQCircleTianShu$RspEntry> tianShuEntry = stFeed.tianshuEntry.get();
            Intrinsics.checkNotNullExpressionValue(tianShuEntry, "tianShuEntry");
            for (QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry : tianShuEntry) {
                if (qQCircleTianShu$RspEntry.key.get() == 1059) {
                    Companion companion = QFSPublishFeedVariantInfo.INSTANCE;
                    List<QQCircleTianShu$AdItem> list = qQCircleTianShu$RspEntry.value.lst.get();
                    Intrinsics.checkNotNullExpressionValue(list, "it.value.lst.get()");
                    companion.b(list, qFSPublishFeedVariantInfo);
                }
            }
            return qFSPublishFeedVariantInfo;
        }

        Companion() {
        }
    }

    public QFSPublishFeedVariantInfo() {
        this(null, 0, false, null, null, null, null, 127, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBtnAdId() {
        return this.btnAdId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBtnIcon() {
        return this.btnIcon;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getBtnJumpUrl() {
        return this.btnJumpUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getBtnTraceInfo() {
        return this.btnTraceInfo;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSPublishFeedVariantInfo)) {
            return false;
        }
        QFSPublishFeedVariantInfo qFSPublishFeedVariantInfo = (QFSPublishFeedVariantInfo) other;
        if (Intrinsics.areEqual(this.feedId, qFSPublishFeedVariantInfo.feedId) && this.feedPos == qFSPublishFeedVariantInfo.feedPos && this.hasBtnVariant == qFSPublishFeedVariantInfo.hasBtnVariant && Intrinsics.areEqual(this.btnIcon, qFSPublishFeedVariantInfo.btnIcon) && Intrinsics.areEqual(this.btnJumpUrl, qFSPublishFeedVariantInfo.btnJumpUrl) && Intrinsics.areEqual(this.btnAdId, qFSPublishFeedVariantInfo.btnAdId) && Intrinsics.areEqual(this.btnTraceInfo, qFSPublishFeedVariantInfo.btnTraceInfo)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getFeedPos() {
        return this.feedPos;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getHasBtnVariant() {
        return this.hasBtnVariant;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnAdId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.feedId.hashCode() * 31) + this.feedPos) * 31;
        boolean z16 = this.hasBtnVariant;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((((hashCode + i3) * 31) + this.btnIcon.hashCode()) * 31) + this.btnJumpUrl.hashCode()) * 31) + this.btnAdId.hashCode()) * 31) + this.btnTraceInfo.hashCode();
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnIcon = str;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnJumpUrl = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnTraceInfo = str;
    }

    public final void l(boolean z16) {
        this.hasBtnVariant = z16;
    }

    @NotNull
    public String toString() {
        return "QFSPublishFeedVariantInfo(feedId=" + this.feedId + ", feedPos=" + this.feedPos + ", hasBtnVariant=" + this.hasBtnVariant + ", btnIcon=" + this.btnIcon + ", btnJumpUrl=" + this.btnJumpUrl + ", btnAdId=" + this.btnAdId + ", btnTraceInfo=" + this.btnTraceInfo + ")";
    }

    public QFSPublishFeedVariantInfo(@NotNull String feedId, int i3, boolean z16, @NotNull String btnIcon, @NotNull String btnJumpUrl, @NotNull String btnAdId, @NotNull String btnTraceInfo) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(btnIcon, "btnIcon");
        Intrinsics.checkNotNullParameter(btnJumpUrl, "btnJumpUrl");
        Intrinsics.checkNotNullParameter(btnAdId, "btnAdId");
        Intrinsics.checkNotNullParameter(btnTraceInfo, "btnTraceInfo");
        this.feedId = feedId;
        this.feedPos = i3;
        this.hasBtnVariant = z16;
        this.btnIcon = btnIcon;
        this.btnJumpUrl = btnJumpUrl;
        this.btnAdId = btnAdId;
        this.btnTraceInfo = btnTraceInfo;
    }

    public /* synthetic */ QFSPublishFeedVariantInfo(String str, int i3, boolean z16, String str2, String str3, String str4, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? -1 : i3, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? "" : str2, (i16 & 16) != 0 ? "" : str3, (i16 & 32) != 0 ? "" : str4, (i16 & 64) != 0 ? "" : str5);
    }
}
