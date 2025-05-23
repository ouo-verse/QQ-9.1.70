package com.tencent.state.square.data;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\u0005H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/square/data/QZoneFeedsInfo;", "", "id", "", "type", "", "text", "image", WadlProxyConsts.KEY_JUMP_URL, "hasNew", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getHasNew", "()Z", "setHasNew", "(Z)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getImage", "setImage", "getJumpUrl", "setJumpUrl", "getText", IECSearchBar.METHOD_SET_TEXT, "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class QZoneFeedsInfo {
    public static final int FEEDS_TYPE_PICTURE = 1;
    public static final int FEEDS_TYPE_TEXT = 0;
    public static final int FEEDS_TYPE_VIDEO = 2;
    private boolean hasNew;
    private String id;
    private String image;
    private String jumpUrl;
    private String text;
    private int type;

    public QZoneFeedsInfo() {
        this(null, 0, null, null, null, false, 63, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component5, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasNew() {
        return this.hasNew;
    }

    public final QZoneFeedsInfo copy(String id5, int type, String text, String image, String jumpUrl, boolean hasNew) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new QZoneFeedsInfo(id5, type, text, image, jumpUrl, hasNew);
    }

    public final boolean getHasNew() {
        return this.hasNew;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.type) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.image;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.jumpUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z16 = this.hasNew;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public final void setHasNew(boolean z16) {
        this.hasNew = z16;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image = str;
    }

    public final void setJumpUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        return "QZoneFeedsInfo(id=" + this.id + ", type=" + this.type + ", text=" + this.text + ", image=" + this.image + ", jumpUrl=" + this.jumpUrl + ", hasNew=" + this.hasNew + ")";
    }

    public QZoneFeedsInfo(String id5, int i3, String text, String image, String jumpUrl, boolean z16) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.id = id5;
        this.type = i3;
        this.text = text;
        this.image = image;
        this.jumpUrl = jumpUrl;
        this.hasNew = z16;
    }

    public /* synthetic */ QZoneFeedsInfo(String str, int i3, String str2, String str3, String str4, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) == 0 ? str4 : "", (i16 & 32) != 0 ? true : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneFeedsInfo)) {
            return false;
        }
        QZoneFeedsInfo qZoneFeedsInfo = (QZoneFeedsInfo) other;
        return Intrinsics.areEqual(this.id, qZoneFeedsInfo.id) && this.type == qZoneFeedsInfo.type && Intrinsics.areEqual(this.text, qZoneFeedsInfo.text) && Intrinsics.areEqual(this.image, qZoneFeedsInfo.image) && Intrinsics.areEqual(this.jumpUrl, qZoneFeedsInfo.jumpUrl) && this.hasNew == qZoneFeedsInfo.hasNew;
    }

    public static /* synthetic */ QZoneFeedsInfo copy$default(QZoneFeedsInfo qZoneFeedsInfo, String str, int i3, String str2, String str3, String str4, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = qZoneFeedsInfo.id;
        }
        if ((i16 & 2) != 0) {
            i3 = qZoneFeedsInfo.type;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            str2 = qZoneFeedsInfo.text;
        }
        String str5 = str2;
        if ((i16 & 8) != 0) {
            str3 = qZoneFeedsInfo.image;
        }
        String str6 = str3;
        if ((i16 & 16) != 0) {
            str4 = qZoneFeedsInfo.jumpUrl;
        }
        String str7 = str4;
        if ((i16 & 32) != 0) {
            z16 = qZoneFeedsInfo.hasNew;
        }
        return qZoneFeedsInfo.copy(str, i17, str5, str6, str7, z16);
    }
}
