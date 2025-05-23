package com.tencent.state.square.data;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/data/SquareSmallHomeItem;", "Lcom/tencent/state/map/MapItem;", "name", "", "uin", "image", "tag", "isCenter", "", "location", "Lcom/tencent/state/map/Location;", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, QCircleLpReportDc010001.KEY_SUBTYPE, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/state/map/Location;Ljava/lang/String;I)V", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "isFixed", "()Z", "getLink", "setLink", "getName", "setName", "getSubType", "()I", "getTag", "setTag", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareSmallHomeItem extends MapItem {
    private String image;
    private final boolean isFixed;
    private String link;
    private String name;
    private final int subType;
    private String tag;

    public /* synthetic */ SquareSmallHomeItem(String str, String str2, String str3, String str4, boolean z16, Location location, String str5, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i16 & 8) != 0 ? null : str4, z16, location, (i16 & 64) != 0 ? "" : str5, (i16 & 128) != 0 ? 0 : i3);
    }

    public final String getImage() {
        return this.image;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final String getTag() {
        return this.tag;
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }

    public final void setImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image = str;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareSmallHomeItem(String name, String uin, String image, String str, boolean z16, Location location, String link, int i3) {
        super(6, uin, z16, location);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(link, "link");
        this.name = name;
        this.image = image;
        this.tag = str;
        this.link = link;
        this.subType = i3;
        this.isFixed = true;
    }
}
