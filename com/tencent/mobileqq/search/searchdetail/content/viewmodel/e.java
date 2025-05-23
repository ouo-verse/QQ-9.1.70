package com.tencent.mobileqq.search.searchdetail.content.viewmodel;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b \u0010!J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\f\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/e;", "", "other", "", "equals", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/f;", "a", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/f;", "c", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/f;", "province", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/a;", "b", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/a;", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/a;", "city", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/d;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/d;", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/d;", "district", "", "d", "Ljava/lang/String;", "getDisplayText", "()Ljava/lang/String;", "displayText", "", "e", "I", "getCityId", "()I", "cityId", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/f;Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/a;Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/d;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Province province;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final City city;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final District district;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String displayText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int cityId;

    public e() {
        this(null, null, null, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final City getCity() {
        return this.city;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final District getDistrict() {
        return this.district;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Province getProvince() {
        return this.province;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof e) {
            e eVar = (e) other;
            if (Intrinsics.areEqual(eVar.displayText, this.displayText) && eVar.cityId == this.cityId) {
                return true;
            }
            return false;
        }
        return false;
    }

    public e(@NotNull Province province, @NotNull City city, @NotNull District district) {
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(district, "district");
        this.province = province;
        this.city = city;
        this.district = district;
        if (!Intrinsics.areEqual(district.getText(), IProfileCardConst.NAME_NO_LIMIT)) {
            this.displayText = district.getText();
            this.cityId = district.getId();
        } else if (!Intrinsics.areEqual(city.getText(), IProfileCardConst.NAME_NO_LIMIT)) {
            this.displayText = city.getText();
            this.cityId = city.getId();
        } else {
            this.displayText = province.getText();
            this.cityId = province.getId();
        }
    }

    public /* synthetic */ e(Province province, City city, District district, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? l.e() : province, (i3 & 2) != 0 ? l.c() : city, (i3 & 4) != 0 ? l.d() : district);
    }
}
