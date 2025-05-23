package ij1;

import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u0011\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lij1/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lij1/h;", "a", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "topData", "Lij1/i;", "b", "Lij1/i;", "()Lij1/i;", TangramHippyConstants.AD_DATA, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "noticeData", "Z", "()Z", "inviteFriend", "<init>", "(Ljava/util/ArrayList;Lij1/i;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij1.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedsHeaderData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<h> topData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GuildGameDistributeAdData adData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GuildInteractiveNotificationItem noticeData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean inviteFriend;

    public GuildFeedsHeaderData(@NotNull ArrayList<h> topData, @Nullable GuildGameDistributeAdData guildGameDistributeAdData, @Nullable GuildInteractiveNotificationItem guildInteractiveNotificationItem, boolean z16) {
        Intrinsics.checkNotNullParameter(topData, "topData");
        this.topData = topData;
        this.adData = guildGameDistributeAdData;
        this.noticeData = guildInteractiveNotificationItem;
        this.inviteFriend = z16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final GuildGameDistributeAdData getAdData() {
        return this.adData;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getInviteFriend() {
        return this.inviteFriend;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final GuildInteractiveNotificationItem getNoticeData() {
        return this.noticeData;
    }

    @NotNull
    public final ArrayList<h> d() {
        return this.topData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedsHeaderData)) {
            return false;
        }
        GuildFeedsHeaderData guildFeedsHeaderData = (GuildFeedsHeaderData) other;
        if (Intrinsics.areEqual(this.topData, guildFeedsHeaderData.topData) && Intrinsics.areEqual(this.adData, guildFeedsHeaderData.adData) && Intrinsics.areEqual(this.noticeData, guildFeedsHeaderData.noticeData) && this.inviteFriend == guildFeedsHeaderData.inviteFriend) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.topData.hashCode() * 31;
        GuildGameDistributeAdData guildGameDistributeAdData = this.adData;
        int i3 = 0;
        if (guildGameDistributeAdData == null) {
            hashCode = 0;
        } else {
            hashCode = guildGameDistributeAdData.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        GuildInteractiveNotificationItem guildInteractiveNotificationItem = this.noticeData;
        if (guildInteractiveNotificationItem != null) {
            i3 = guildInteractiveNotificationItem.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.inviteFriend;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        return i17 + i18;
    }

    @NotNull
    public String toString() {
        return "GuildFeedsHeaderData(topData=" + this.topData + ", adData=" + this.adData + ", noticeData=" + this.noticeData + ", inviteFriend=" + this.inviteFriend + ")";
    }

    public /* synthetic */ GuildFeedsHeaderData(ArrayList arrayList, GuildGameDistributeAdData guildGameDistributeAdData, GuildInteractiveNotificationItem guildInteractiveNotificationItem, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, guildGameDistributeAdData, guildInteractiveNotificationItem, (i3 & 8) != 0 ? false : z16);
    }
}
