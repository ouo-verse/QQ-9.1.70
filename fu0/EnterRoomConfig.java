package fu0;

import android.os.Bundle;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0019\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&R$\u0010.\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b\u000f\u0010+\"\u0004\b,\u0010-R\u0019\u00100\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b\u001f\u0010&\u00a8\u00063"}, d2 = {"Lfu0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "roomId", "b", "I", "d", "()I", "setRoomType", "(I)V", "roomType", "Z", "()Z", "autoPlay", "Lcom/tencent/mobileqq/icgame/data/room/EnterRoomInfo$VideoDefinition;", "Lcom/tencent/mobileqq/icgame/data/room/EnterRoomInfo$VideoDefinition;", "getVideoDefinition", "()Lcom/tencent/mobileqq/icgame/data/room/EnterRoomInfo$VideoDefinition;", "videoDefinition", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataTrtcInfo;", "e", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataTrtcInfo;", "getTrtcInfo", "()Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataTrtcInfo;", "trtcInfo", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "source", "Landroid/os/Bundle;", "g", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "setExtraInfo", "(Landroid/os/Bundle;)V", "extraInfo", h.F, "shareToken", "<init>", "(JIZLcom/tencent/mobileqq/icgame/data/room/EnterRoomInfo$VideoDefinition;Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataTrtcInfo;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fu0.a, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class EnterRoomConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int roomType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean autoPlay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final EnterRoomInfo.VideoDefinition videoDefinition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final QQLiveAnchorDataTrtcInfo trtcInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String source;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Bundle extraInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String shareToken;

    public EnterRoomConfig(long j3, int i3, boolean z16, @NotNull EnterRoomInfo.VideoDefinition videoDefinition, @Nullable QQLiveAnchorDataTrtcInfo qQLiveAnchorDataTrtcInfo, @Nullable String str, @Nullable Bundle bundle, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(videoDefinition, "videoDefinition");
        this.roomId = j3;
        this.roomType = i3;
        this.autoPlay = z16;
        this.videoDefinition = videoDefinition;
        this.trtcInfo = qQLiveAnchorDataTrtcInfo;
        this.source = str;
        this.extraInfo = bundle;
        this.shareToken = str2;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Bundle getExtraInfo() {
        return this.extraInfo;
    }

    /* renamed from: c, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: d, reason: from getter */
    public final int getRoomType() {
        return this.roomType;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getShareToken() {
        return this.shareToken;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterRoomConfig)) {
            return false;
        }
        EnterRoomConfig enterRoomConfig = (EnterRoomConfig) other;
        if (this.roomId == enterRoomConfig.roomId && this.roomType == enterRoomConfig.roomType && this.autoPlay == enterRoomConfig.autoPlay && this.videoDefinition == enterRoomConfig.videoDefinition && Intrinsics.areEqual(this.trtcInfo, enterRoomConfig.trtcInfo) && Intrinsics.areEqual(this.source, enterRoomConfig.source) && Intrinsics.areEqual(this.extraInfo, enterRoomConfig.extraInfo) && Intrinsics.areEqual(this.shareToken, enterRoomConfig.shareToken)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int a16 = ((androidx.fragment.app.a.a(this.roomId) * 31) + this.roomType) * 31;
        boolean z16 = this.autoPlay;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode4 = (((a16 + i3) * 31) + this.videoDefinition.hashCode()) * 31;
        QQLiveAnchorDataTrtcInfo qQLiveAnchorDataTrtcInfo = this.trtcInfo;
        int i16 = 0;
        if (qQLiveAnchorDataTrtcInfo == null) {
            hashCode = 0;
        } else {
            hashCode = qQLiveAnchorDataTrtcInfo.hashCode();
        }
        int i17 = (hashCode4 + hashCode) * 31;
        String str = this.source;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        Bundle bundle = this.extraInfo;
        if (bundle == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bundle.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        String str2 = this.shareToken;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i19 + i16;
    }

    @NotNull
    public String toString() {
        return "EnterRoomConfig(roomId=" + this.roomId + ", roomType=" + this.roomType + ", autoPlay=" + this.autoPlay + ", videoDefinition=" + this.videoDefinition + ", trtcInfo=" + this.trtcInfo + ", source=" + this.source + ", extraInfo=" + this.extraInfo + ", shareToken=" + this.shareToken + ")";
    }
}
