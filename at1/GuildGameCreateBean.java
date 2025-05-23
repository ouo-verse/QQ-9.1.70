package at1;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0019\u0012\b\b\u0002\u0010\"\u001a\u00020\u0019\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00190&j\b\u0012\u0004\u0012\u00020\u0019`'\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR2\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00190&j\b\u0012\u0004\u0012\u00020\u0019`'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010(\u001a\u0004\b\u0012\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lat1/a;", "", "", "a", "", "toString", "", "hashCode", "other", "", "equals", "I", "e", "()I", "setResult", "(I)V", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceSmobaGameRoomStateInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceSmobaGameRoomStateInfo;", "f", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceSmobaGameRoomStateInfo;", "j", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceSmobaGameRoomStateInfo;)V", "roomInfo", "", "c", "J", "()J", h.F, "(J)V", "newCaptainId", "d", "i", "newCurMember", "g", "k", "userActionType", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "()Ljava/util/HashSet;", "setJoinedMemberId", "(Ljava/util/HashSet;)V", "joinedMemberId", "<init>", "(ILcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceSmobaGameRoomStateInfo;JJILjava/util/HashSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: at1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildGameCreateBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private IGProVoiceSmobaGameRoomStateInfo roomInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long newCaptainId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long newCurMember;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int userActionType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private HashSet<Long> joinedMemberId;

    public GuildGameCreateBean() {
        this(0, null, 0L, 0L, 0, null, 63, null);
    }

    public final void a() {
        this.result = 0;
        this.roomInfo = null;
        this.newCaptainId = 0L;
        this.newCurMember = 0L;
        this.userActionType = 0;
        this.joinedMemberId = new HashSet<>();
    }

    @NotNull
    public final HashSet<Long> b() {
        return this.joinedMemberId;
    }

    /* renamed from: c, reason: from getter */
    public final long getNewCaptainId() {
        return this.newCaptainId;
    }

    /* renamed from: d, reason: from getter */
    public final long getNewCurMember() {
        return this.newCurMember;
    }

    /* renamed from: e, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildGameCreateBean)) {
            return false;
        }
        GuildGameCreateBean guildGameCreateBean = (GuildGameCreateBean) other;
        if (this.result == guildGameCreateBean.result && Intrinsics.areEqual(this.roomInfo, guildGameCreateBean.roomInfo) && this.newCaptainId == guildGameCreateBean.newCaptainId && this.newCurMember == guildGameCreateBean.newCurMember && this.userActionType == guildGameCreateBean.userActionType && Intrinsics.areEqual(this.joinedMemberId, guildGameCreateBean.joinedMemberId)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final IGProVoiceSmobaGameRoomStateInfo getRoomInfo() {
        return this.roomInfo;
    }

    /* renamed from: g, reason: from getter */
    public final int getUserActionType() {
        return this.userActionType;
    }

    public final void h(long j3) {
        this.newCaptainId = j3;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.result * 31;
        IGProVoiceSmobaGameRoomStateInfo iGProVoiceSmobaGameRoomStateInfo = this.roomInfo;
        if (iGProVoiceSmobaGameRoomStateInfo == null) {
            hashCode = 0;
        } else {
            hashCode = iGProVoiceSmobaGameRoomStateInfo.hashCode();
        }
        return ((((((((i3 + hashCode) * 31) + androidx.fragment.app.a.a(this.newCaptainId)) * 31) + androidx.fragment.app.a.a(this.newCurMember)) * 31) + this.userActionType) * 31) + this.joinedMemberId.hashCode();
    }

    public final void i(long j3) {
        this.newCurMember = j3;
    }

    public final void j(@Nullable IGProVoiceSmobaGameRoomStateInfo iGProVoiceSmobaGameRoomStateInfo) {
        this.roomInfo = iGProVoiceSmobaGameRoomStateInfo;
    }

    public final void k(int i3) {
        this.userActionType = i3;
    }

    @NotNull
    public String toString() {
        return "GuildGameCreateBean(result=" + this.result + ", roomInfo=" + this.roomInfo + ", newCaptainId=" + this.newCaptainId + ", newCurMember=" + this.newCurMember + ", userActionType=" + this.userActionType + ", joinedMemberId=" + this.joinedMemberId + ")";
    }

    public GuildGameCreateBean(int i3, @Nullable IGProVoiceSmobaGameRoomStateInfo iGProVoiceSmobaGameRoomStateInfo, long j3, long j16, int i16, @NotNull HashSet<Long> joinedMemberId) {
        Intrinsics.checkNotNullParameter(joinedMemberId, "joinedMemberId");
        this.result = i3;
        this.roomInfo = iGProVoiceSmobaGameRoomStateInfo;
        this.newCaptainId = j3;
        this.newCurMember = j16;
        this.userActionType = i16;
        this.joinedMemberId = joinedMemberId;
    }

    public /* synthetic */ GuildGameCreateBean(int i3, IGProVoiceSmobaGameRoomStateInfo iGProVoiceSmobaGameRoomStateInfo, long j3, long j16, int i16, HashSet hashSet, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? null : iGProVoiceSmobaGameRoomStateInfo, (i17 & 4) != 0 ? 0L : j3, (i17 & 8) == 0 ? j16 : 0L, (i17 & 16) == 0 ? i16 : 0, (i17 & 32) != 0 ? new HashSet() : hashSet);
    }
}
