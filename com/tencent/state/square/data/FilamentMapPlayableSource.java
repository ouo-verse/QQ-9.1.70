package com.tencent.state.square.data;

import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.template.data.CommonDataKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u0006\u0010\u001e\u001a\u00020\u0000JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\r\u0010\"\u001a\u0004\u0018\u00010#\u00a2\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\u0007H\u00d6\u0001J\u0006\u0010&\u001a\u00020#J\t\u0010'\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/data/FilamentMapPlayableSource;", "Lcom/tencent/state/square/media/MapPlayableSource;", "uin", "", "mSource", "Lcom/tencent/state/square/media/MediaSource;", "dResourceId", "", "isMultiAction", "", "isSingleAction", "multiMotionUser", "Lcom/tencent/state/square/data/MultiMotionUser;", "(Ljava/lang/String;Lcom/tencent/state/square/media/MediaSource;IZZLcom/tencent/state/square/data/MultiMotionUser;)V", "getDResourceId", "()I", "isMe", "()Z", "getMSource", "()Lcom/tencent/state/square/media/MediaSource;", "getMultiMotionUser", "()Lcom/tencent/state/square/data/MultiMotionUser;", "getUin", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "guestUin", "", "()Ljava/lang/Long;", "hashCode", "hostUin", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FilamentMapPlayableSource extends MapPlayableSource {
    private final int dResourceId;
    private final boolean isMultiAction;
    private final boolean isSingleAction;
    private final MediaSource mSource;
    private final MultiMotionUser multiMotionUser;
    private final String uin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentMapPlayableSource(String uin, MediaSource mSource, int i3, boolean z16, boolean z17, MultiMotionUser multiMotionUser) {
        super(mSource, i3, null, null, 12, null);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(mSource, "mSource");
        this.uin = uin;
        this.mSource = mSource;
        this.dResourceId = i3;
        this.isMultiAction = z16;
        this.isSingleAction = z17;
        this.multiMotionUser = multiMotionUser;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final MediaSource getMSource() {
        return this.mSource;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDResourceId() {
        return this.dResourceId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsMultiAction() {
        return this.isMultiAction;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSingleAction() {
        return this.isSingleAction;
    }

    /* renamed from: component6, reason: from getter */
    public final MultiMotionUser getMultiMotionUser() {
        return this.multiMotionUser;
    }

    public final FilamentMapPlayableSource copy(String uin, MediaSource mSource, int dResourceId, boolean isMultiAction, boolean isSingleAction, MultiMotionUser multiMotionUser) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(mSource, "mSource");
        return new FilamentMapPlayableSource(uin, mSource, dResourceId, isMultiAction, isSingleAction, multiMotionUser);
    }

    public final int getDResourceId() {
        return this.dResourceId;
    }

    public final MediaSource getMSource() {
        return this.mSource;
    }

    public final MultiMotionUser getMultiMotionUser() {
        return this.multiMotionUser;
    }

    public final String getUin() {
        return this.uin;
    }

    public final Long guestUin() {
        String toUin;
        if (!this.isMultiAction) {
            return null;
        }
        MultiMotionUser multiMotionUser = this.multiMotionUser;
        if (multiMotionUser == null || (toUin = multiMotionUser.getSelectUin()) == null) {
            MultiMotionUser multiMotionUser2 = this.multiMotionUser;
            toUin = multiMotionUser2 != null ? multiMotionUser2.getToUin() : null;
        }
        if (toUin != null) {
            return Long.valueOf(Long.parseLong(toUin));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        MediaSource mediaSource = this.mSource;
        int hashCode2 = (((hashCode + (mediaSource != null ? mediaSource.hashCode() : 0)) * 31) + this.dResourceId) * 31;
        boolean z16 = this.isMultiAction;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.isSingleAction;
        int i17 = (i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        MultiMotionUser multiMotionUser = this.multiMotionUser;
        return i17 + (multiMotionUser != null ? multiMotionUser.hashCode() : 0);
    }

    public final long hostUin() {
        String str;
        if (this.isMultiAction) {
            MultiMotionUser multiMotionUser = this.multiMotionUser;
            if (multiMotionUser == null || (str = multiMotionUser.getUin()) == null) {
                str = this.uin;
            }
            return Long.parseLong(str);
        }
        return Long.parseLong(this.uin);
    }

    public final boolean isMe() {
        return CommonDataKt.isMe(Long.parseLong(this.uin));
    }

    public final boolean isMultiAction() {
        return this.isMultiAction;
    }

    public final boolean isSingleAction() {
        return this.isSingleAction;
    }

    public String toString() {
        return "FilamentMapPlayableSource(uin=" + this.uin + ", mSource=" + this.mSource + ", dResourceId=" + this.dResourceId + ", isMultiAction=" + this.isMultiAction + ", isSingleAction=" + this.isSingleAction + ", multiMotionUser=" + this.multiMotionUser + ")";
    }

    public final FilamentMapPlayableSource copy() {
        MultiMotionUser multiMotionUser = this.multiMotionUser;
        return new FilamentMapPlayableSource(this.uin, this.mSource, this.dResourceId, this.isMultiAction, this.isSingleAction, multiMotionUser != null ? MultiMotionUser.copy$default(multiMotionUser, null, null, null, 7, null) : null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilamentMapPlayableSource)) {
            return false;
        }
        FilamentMapPlayableSource filamentMapPlayableSource = (FilamentMapPlayableSource) other;
        return Intrinsics.areEqual(this.uin, filamentMapPlayableSource.uin) && Intrinsics.areEqual(this.mSource, filamentMapPlayableSource.mSource) && this.dResourceId == filamentMapPlayableSource.dResourceId && this.isMultiAction == filamentMapPlayableSource.isMultiAction && this.isSingleAction == filamentMapPlayableSource.isSingleAction && Intrinsics.areEqual(this.multiMotionUser, filamentMapPlayableSource.multiMotionUser);
    }

    public static /* synthetic */ FilamentMapPlayableSource copy$default(FilamentMapPlayableSource filamentMapPlayableSource, String str, MediaSource mediaSource, int i3, boolean z16, boolean z17, MultiMotionUser multiMotionUser, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = filamentMapPlayableSource.uin;
        }
        if ((i16 & 2) != 0) {
            mediaSource = filamentMapPlayableSource.mSource;
        }
        MediaSource mediaSource2 = mediaSource;
        if ((i16 & 4) != 0) {
            i3 = filamentMapPlayableSource.dResourceId;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            z16 = filamentMapPlayableSource.isMultiAction;
        }
        boolean z18 = z16;
        if ((i16 & 16) != 0) {
            z17 = filamentMapPlayableSource.isSingleAction;
        }
        boolean z19 = z17;
        if ((i16 & 32) != 0) {
            multiMotionUser = filamentMapPlayableSource.multiMotionUser;
        }
        return filamentMapPlayableSource.copy(str, mediaSource2, i17, z18, z19, multiMotionUser);
    }
}
