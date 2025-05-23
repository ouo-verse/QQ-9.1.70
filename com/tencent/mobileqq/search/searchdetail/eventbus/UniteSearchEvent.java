package com.tencent.mobileqq.search.searchdetail.eventbus;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/eventbus/UniteSearchEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "keyword", "", "time", "count", "", "businessMaskArray", "", "", "idList", "fromAction", "cookie", "", "latitude", "", "longitude", "isMoreSearch", "", "hasLocalData", IProfileCardConst.KEY_FROM_TYPE, WadlProxyConsts.EXTRA_DATA, "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;I[BDDZZILandroid/os/Bundle;)V", "getBusinessMaskArray", "()Ljava/util/List;", "getCookie", "()[B", "getCount", "()I", "getExtraData", "()Landroid/os/Bundle;", "getFromAction", "getFromType", "getHasLocalData", "()Z", "getIdList", "getKeyword", "()Ljava/lang/String;", "getLatitude", "()D", "getLongitude", "getTime", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class UniteSearchEvent extends SimpleBaseEvent {

    @NotNull
    private final List<Long> businessMaskArray;

    @Nullable
    private final byte[] cookie;
    private final int count;

    @Nullable
    private final Bundle extraData;
    private final int fromAction;
    private final int fromType;
    private final boolean hasLocalData;

    @Nullable
    private final List<Long> idList;
    private final boolean isMoreSearch;

    @NotNull
    private final String keyword;
    private final double latitude;
    private final double longitude;

    @NotNull
    private final String time;

    public UniteSearchEvent(@NotNull String keyword, @NotNull String time, int i3, @NotNull List<Long> businessMaskArray, @Nullable List<Long> list, int i16, @Nullable byte[] bArr, double d16, double d17, boolean z16, boolean z17, int i17, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(businessMaskArray, "businessMaskArray");
        this.keyword = keyword;
        this.time = time;
        this.count = i3;
        this.businessMaskArray = businessMaskArray;
        this.idList = list;
        this.fromAction = i16;
        this.cookie = bArr;
        this.latitude = d16;
        this.longitude = d17;
        this.isMoreSearch = z16;
        this.hasLocalData = z17;
        this.fromType = i17;
        this.extraData = bundle;
    }

    @NotNull
    public final List<Long> getBusinessMaskArray() {
        return this.businessMaskArray;
    }

    @Nullable
    public final byte[] getCookie() {
        return this.cookie;
    }

    public final int getCount() {
        return this.count;
    }

    @Nullable
    public final Bundle getExtraData() {
        return this.extraData;
    }

    public final int getFromAction() {
        return this.fromAction;
    }

    public final int getFromType() {
        return this.fromType;
    }

    public final boolean getHasLocalData() {
        return this.hasLocalData;
    }

    @Nullable
    public final List<Long> getIdList() {
        return this.idList;
    }

    @NotNull
    public final String getKeyword() {
        return this.keyword;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getTime() {
        return this.time;
    }

    /* renamed from: isMoreSearch, reason: from getter */
    public final boolean getIsMoreSearch() {
        return this.isMoreSearch;
    }
}
