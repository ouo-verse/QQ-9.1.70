package com.tencent.sqshow.zootopia.data;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u000eB5\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u000e\u0010\u001e\"\u0004\b\u001f\u0010 R#\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/n;", "", "", "c", "b", "", tl.h.F, "g", "i", "toString", "", "hashCode", "other", "equals", "a", "I", "d", "()I", "tabId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "tabName", "f", "type", "getUrl", "url", "", "Lpv4/f;", "Ljava/util/List;", "()Ljava/util/List;", "setNativeGuideList", "(Ljava/util/List;)V", "nativeGuideList", "", "Ljava/util/Map;", "getParam", "()Ljava/util/Map;", "param", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.n, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaMapTab {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int tabId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String tabName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private List<pv4.f> nativeGuideList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> param;

    public ZootopiaMapTab(int i3, String tabName, int i16, String url, List<pv4.f> nativeGuideList) {
        List<String> split$default;
        List split$default2;
        int indexOf$default;
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(nativeGuideList, "nativeGuideList");
        this.tabId = i3;
        this.tabName = tabName;
        this.type = i16;
        this.url = url;
        this.nativeGuideList = nativeGuideList;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (split$default != null) {
            for (String str : split$default) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2) {
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, (Object) null);
                    String substring = str.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    String substring2 = str.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    linkedHashMap.put(substring, substring2);
                }
            }
        }
        this.param = linkedHashMap;
    }

    public final List<pv4.f> a() {
        return this.nativeGuideList;
    }

    public final String b() {
        String str = this.param.get("rankId");
        return str == null ? "" : str;
    }

    public final String c() {
        String str = this.param.get("tab");
        return str == null ? "" : str;
    }

    /* renamed from: d, reason: from getter */
    public final int getTabId() {
        return this.tabId;
    }

    /* renamed from: e, reason: from getter */
    public final String getTabName() {
        return this.tabName;
    }

    /* renamed from: f, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final boolean g() {
        return TextUtils.equals(c(), "main") || TextUtils.equals(URLDecoder.decode(c()), "main");
    }

    public final boolean h() {
        return TextUtils.equals(c(), "rank") || TextUtils.equals(URLDecoder.decode(c()), "rank");
    }

    public int hashCode() {
        return (((((((this.tabId * 31) + this.tabName.hashCode()) * 31) + this.type) * 31) + this.url.hashCode()) * 31) + this.nativeGuideList.hashCode();
    }

    public final boolean i() {
        return this.type == 1 && (g() || h());
    }

    public String toString() {
        return "ZootopiaMapTab(tabId=" + this.tabId + ", tabName=" + this.tabName + ", type=" + this.type + ", url=" + this.url + ", nativeGuideList=" + this.nativeGuideList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaMapTab)) {
            return false;
        }
        ZootopiaMapTab zootopiaMapTab = (ZootopiaMapTab) other;
        return this.tabId == zootopiaMapTab.tabId && Intrinsics.areEqual(this.tabName, zootopiaMapTab.tabName) && this.type == zootopiaMapTab.type && Intrinsics.areEqual(this.url, zootopiaMapTab.url) && Intrinsics.areEqual(this.nativeGuideList, zootopiaMapTab.nativeGuideList);
    }
}
