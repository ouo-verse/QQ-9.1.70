package com.tencent.state.template.data;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.state.map.Location;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u00a2\u0006\u0002\u0010\u0010J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u00c6\u0003Jq\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u000201H\u00d6\u0001J\t\u00102\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u001bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012\u00a8\u00063"}, d2 = {"Lcom/tencent/state/template/data/RoomThemeData;", "", "text", "", "textResource", "signBoard", "background", "location", "Lcom/tencent/state/map/Location;", "option1", "option2", "backgroundClickAreas", "", "Lcom/tencent/state/template/data/ClickArea;", "quickSeatTables", "Lcom/tencent/state/template/data/QuickSeatTable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/map/Location;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getBackground", "()Ljava/lang/String;", "getBackgroundClickAreas", "()Ljava/util/List;", "getLocation", "()Lcom/tencent/state/map/Location;", "setLocation", "(Lcom/tencent/state/map/Location;)V", "getOption1", "setOption1", "(Ljava/lang/String;)V", "getOption2", "setOption2", "getQuickSeatTables", "getSignBoard", "getText", IECSearchBar.METHOD_SET_TEXT, "getTextResource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class RoomThemeData {
    private final String background;
    private final List<ClickArea> backgroundClickAreas;
    private Location location;
    private String option1;
    private String option2;
    private final List<QuickSeatTable> quickSeatTables;
    private final String signBoard;
    private String text;
    private final String textResource;

    public RoomThemeData(String text, String textResource, String signBoard, String background, Location location, String option1, String option2, List<ClickArea> backgroundClickAreas, List<QuickSeatTable> quickSeatTables) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textResource, "textResource");
        Intrinsics.checkNotNullParameter(signBoard, "signBoard");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(option1, "option1");
        Intrinsics.checkNotNullParameter(option2, "option2");
        Intrinsics.checkNotNullParameter(backgroundClickAreas, "backgroundClickAreas");
        Intrinsics.checkNotNullParameter(quickSeatTables, "quickSeatTables");
        this.text = text;
        this.textResource = textResource;
        this.signBoard = signBoard;
        this.background = background;
        this.location = location;
        this.option1 = option1;
        this.option2 = option2;
        this.backgroundClickAreas = backgroundClickAreas;
        this.quickSeatTables = quickSeatTables;
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTextResource() {
        return this.textResource;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSignBoard() {
        return this.signBoard;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    /* renamed from: component5, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    /* renamed from: component6, reason: from getter */
    public final String getOption1() {
        return this.option1;
    }

    /* renamed from: component7, reason: from getter */
    public final String getOption2() {
        return this.option2;
    }

    public final List<ClickArea> component8() {
        return this.backgroundClickAreas;
    }

    public final List<QuickSeatTable> component9() {
        return this.quickSeatTables;
    }

    public final RoomThemeData copy(String text, String textResource, String signBoard, String background, Location location, String option1, String option2, List<ClickArea> backgroundClickAreas, List<QuickSeatTable> quickSeatTables) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textResource, "textResource");
        Intrinsics.checkNotNullParameter(signBoard, "signBoard");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(option1, "option1");
        Intrinsics.checkNotNullParameter(option2, "option2");
        Intrinsics.checkNotNullParameter(backgroundClickAreas, "backgroundClickAreas");
        Intrinsics.checkNotNullParameter(quickSeatTables, "quickSeatTables");
        return new RoomThemeData(text, textResource, signBoard, background, location, option1, option2, backgroundClickAreas, quickSeatTables);
    }

    public final String getBackground() {
        return this.background;
    }

    public final List<ClickArea> getBackgroundClickAreas() {
        return this.backgroundClickAreas;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final String getOption1() {
        return this.option1;
    }

    public final String getOption2() {
        return this.option2;
    }

    public final List<QuickSeatTable> getQuickSeatTables() {
        return this.quickSeatTables;
    }

    public final String getSignBoard() {
        return this.signBoard;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextResource() {
        return this.textResource;
    }

    public int hashCode() {
        String str = this.text;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.textResource;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.signBoard;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.background;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Location location = this.location;
        int hashCode5 = (hashCode4 + (location != null ? location.hashCode() : 0)) * 31;
        String str5 = this.option1;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.option2;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<ClickArea> list = this.backgroundClickAreas;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        List<QuickSeatTable> list2 = this.quickSeatTables;
        return hashCode8 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setLocation(Location location) {
        this.location = location;
    }

    public final void setOption1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.option1 = str;
    }

    public final void setOption2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.option2 = str;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public String toString() {
        return "RoomThemeData(text=" + this.text + ", textResource=" + this.textResource + ", signBoard=" + this.signBoard + ", background=" + this.background + ", location=" + this.location + ", option1=" + this.option1 + ", option2=" + this.option2 + ", backgroundClickAreas=" + this.backgroundClickAreas + ", quickSeatTables=" + this.quickSeatTables + ")";
    }

    public /* synthetic */ RoomThemeData(String str, String str2, String str3, String str4, Location location, String str5, String str6, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i3 & 16) != 0 ? null : location, str5, str6, list, list2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomThemeData)) {
            return false;
        }
        RoomThemeData roomThemeData = (RoomThemeData) other;
        return Intrinsics.areEqual(this.text, roomThemeData.text) && Intrinsics.areEqual(this.textResource, roomThemeData.textResource) && Intrinsics.areEqual(this.signBoard, roomThemeData.signBoard) && Intrinsics.areEqual(this.background, roomThemeData.background) && Intrinsics.areEqual(this.location, roomThemeData.location) && Intrinsics.areEqual(this.option1, roomThemeData.option1) && Intrinsics.areEqual(this.option2, roomThemeData.option2) && Intrinsics.areEqual(this.backgroundClickAreas, roomThemeData.backgroundClickAreas) && Intrinsics.areEqual(this.quickSeatTables, roomThemeData.quickSeatTables);
    }
}
