package com.tencent.state.square.data;

import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.mayknow.MayKnowLabel;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020 X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010!R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/square/data/SquareMayKnowItem;", "Lcom/tencent/state/map/MapItem;", "location", "Lcom/tencent/state/map/Location;", "gender", "", "age", "country", "", "province", "city", "reason", "labels", "", "Lcom/tencent/state/square/mayknow/MayKnowLabel;", "maleUrl", "femaleUrl", "(Lcom/tencent/state/map/Location;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAge", "()I", "setAge", "(I)V", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getCountry", "setCountry", "getFemaleUrl", "getGender", "setGender", "isFixed", "", "()Z", "getLabels", "()Ljava/util/List;", "setLabels", "(Ljava/util/List;)V", "getMaleUrl", "getProvince", "setProvince", "getReason", "setReason", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMayKnowItem extends MapItem {
    private int age;
    private String city;
    private String country;
    private final String femaleUrl;
    private int gender;
    private final boolean isFixed;
    private List<MayKnowLabel> labels;
    private final String maleUrl;
    private String province;
    private String reason;

    public /* synthetic */ SquareMayKnowItem(Location location, int i3, int i16, String str, String str2, String str3, String str4, List list, String str5, String str6, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(location, i3, i16, (i17 & 8) != 0 ? null : str, (i17 & 16) != 0 ? null : str2, (i17 & 32) != 0 ? null : str3, (i17 & 64) != 0 ? null : str4, list, str5, str6);
    }

    public final int getAge() {
        return this.age;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getFemaleUrl() {
        return this.femaleUrl;
    }

    public final int getGender() {
        return this.gender;
    }

    public final List<MayKnowLabel> getLabels() {
        return this.labels;
    }

    public final String getMaleUrl() {
        return this.maleUrl;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getReason() {
        return this.reason;
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }

    public final void setAge(int i3) {
        this.age = i3;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setGender(int i3) {
        this.gender = i3;
    }

    public final void setLabels(List<MayKnowLabel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.labels = list;
    }

    public final void setProvince(String str) {
        this.province = str;
    }

    public final void setReason(String str) {
        this.reason = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMayKnowItem(Location location, int i3, int i16, String str, String str2, String str3, String str4, List<MayKnowLabel> labels, String maleUrl, String femaleUrl) {
        super(7, "may_know_" + UUID.randomUUID(), false, location);
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(labels, "labels");
        Intrinsics.checkNotNullParameter(maleUrl, "maleUrl");
        Intrinsics.checkNotNullParameter(femaleUrl, "femaleUrl");
        this.gender = i3;
        this.age = i16;
        this.country = str;
        this.province = str2;
        this.city = str3;
        this.reason = str4;
        this.labels = labels;
        this.maleUrl = maleUrl;
        this.femaleUrl = femaleUrl;
    }
}
