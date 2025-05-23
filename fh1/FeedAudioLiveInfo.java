package fh1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedChannelStateInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceLiveInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010.\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'\u0012\b\b\u0002\u00102\u001a\u00020\u0005\u0012\b\b\u0002\u00106\u001a\u00020\u0005\u0012\b\b\u0002\u0010:\u001a\u00020\u0005\u00a2\u0006\u0004\b;\u0010<J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R2\u0010.\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00102\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001f\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\"\u00106\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\"\u0010:\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u001f\u001a\u0004\b8\u0010!\"\u0004\b9\u0010#\u00a8\u0006="}, d2 = {"Lfh1/b;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProVoiceLiveInfo;", "voiceLiveInfo", "a", "", "toString", "", "hashCode", "other", "", "equals", "", "J", "getGuildId", "()J", "setGuildId", "(J)V", "guildId", "b", "getChannelId", "setChannelId", "channelId", "c", "I", "getChannelType", "()I", "setChannelType", "(I)V", "channelType", "d", "Ljava/lang/String;", "getChannelName", "()Ljava/lang/String;", "setChannelName", "(Ljava/lang/String;)V", "channelName", "Ljava/util/ArrayList;", "Lfh1/c;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getRoomStatus", "()Ljava/util/ArrayList;", "setRoomStatus", "(Ljava/util/ArrayList;)V", "roomStatus", "f", "getMainSource", "setMainSource", "mainSource", "g", "getSubSource", "setSubSource", "subSource", h.F, "getJoinSign", "setJoinSign", "joinSign", "<init>", "(JJILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fh1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedAudioLiveInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int channelType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String channelName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<FeedChannelStateInfo> roomStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String mainSource;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String subSource;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String joinSign;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: fh1.b$a */
    /* loaded from: classes13.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((FeedChannelStateInfo) t16).getPriority()), Integer.valueOf(((FeedChannelStateInfo) t17).getPriority()));
            return compareValues;
        }
    }

    public FeedAudioLiveInfo() {
        this(0L, 0L, 0, null, null, null, null, null, 255, null);
    }

    @NotNull
    public final FeedAudioLiveInfo a(@NotNull GProVoiceLiveInfo voiceLiveInfo) {
        Intrinsics.checkNotNullParameter(voiceLiveInfo, "voiceLiveInfo");
        this.guildId = voiceLiveInfo.guildId;
        this.channelId = voiceLiveInfo.channelId;
        this.channelType = voiceLiveInfo.channelType;
        byte[] bArr = voiceLiveInfo.channelName;
        Intrinsics.checkNotNullExpressionValue(bArr, "voiceLiveInfo.channelName");
        this.channelName = new String(bArr, Charsets.UTF_8);
        ArrayList<GProFeedChannelStateInfo> arrayList = voiceLiveInfo.channelStatusList;
        this.roomStatus.clear();
        Iterator<GProFeedChannelStateInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            GProFeedChannelStateInfo next = it.next();
            this.roomStatus.add(new FeedChannelStateInfo(next.priority, next.state));
        }
        ArrayList<FeedChannelStateInfo> arrayList2 = this.roomStatus;
        if (arrayList2.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, new a());
        }
        String str = voiceLiveInfo.mainSource;
        Intrinsics.checkNotNullExpressionValue(str, "voiceLiveInfo.mainSource");
        this.mainSource = str;
        String str2 = voiceLiveInfo.subSource;
        Intrinsics.checkNotNullExpressionValue(str2, "voiceLiveInfo.subSource");
        this.subSource = str2;
        byte[] bArr2 = voiceLiveInfo.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(bArr2, "voiceLiveInfo.joinGuildSig");
        this.joinSign = new String(bArr2, Charsets.UTF_8);
        return this;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedAudioLiveInfo)) {
            return false;
        }
        FeedAudioLiveInfo feedAudioLiveInfo = (FeedAudioLiveInfo) other;
        if (this.guildId == feedAudioLiveInfo.guildId && this.channelId == feedAudioLiveInfo.channelId && this.channelType == feedAudioLiveInfo.channelType && Intrinsics.areEqual(this.channelName, feedAudioLiveInfo.channelName) && Intrinsics.areEqual(this.roomStatus, feedAudioLiveInfo.roomStatus) && Intrinsics.areEqual(this.mainSource, feedAudioLiveInfo.mainSource) && Intrinsics.areEqual(this.subSource, feedAudioLiveInfo.subSource) && Intrinsics.areEqual(this.joinSign, feedAudioLiveInfo.joinSign)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((androidx.fragment.app.a.a(this.guildId) * 31) + androidx.fragment.app.a.a(this.channelId)) * 31) + this.channelType) * 31) + this.channelName.hashCode()) * 31) + this.roomStatus.hashCode()) * 31) + this.mainSource.hashCode()) * 31) + this.subSource.hashCode()) * 31) + this.joinSign.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedAudioLiveInfo(guildId=" + this.guildId + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", channelName=" + this.channelName + ", roomStatus=" + this.roomStatus + ", mainSource=" + this.mainSource + ", subSource=" + this.subSource + ", joinSign=" + this.joinSign + ")";
    }

    public FeedAudioLiveInfo(long j3, long j16, int i3, @NotNull String channelName, @NotNull ArrayList<FeedChannelStateInfo> roomStatus, @NotNull String mainSource, @NotNull String subSource, @NotNull String joinSign) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(roomStatus, "roomStatus");
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        Intrinsics.checkNotNullParameter(joinSign, "joinSign");
        this.guildId = j3;
        this.channelId = j16;
        this.channelType = i3;
        this.channelName = channelName;
        this.roomStatus = roomStatus;
        this.mainSource = mainSource;
        this.subSource = subSource;
        this.joinSign = joinSign;
    }

    public /* synthetic */ FeedAudioLiveInfo(long j3, long j16, int i3, String str, ArrayList arrayList, String str2, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) == 0 ? j16 : 0L, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? new ArrayList() : arrayList, (i16 & 32) != 0 ? "" : str2, (i16 & 64) != 0 ? "" : str3, (i16 & 128) == 0 ? str4 : "");
    }
}
