package com.tencent.mobileqq.minorsmode;

import com.tencent.oskplayer.util.SecretUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ8\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/minorsmode/a;", "", "", "title", SecretUtils.DES, "", "needTerm", "topBtnTxt", "bottomBtnTxt", "a", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "b", "d", h.F, "c", "Z", "e", "()Z", "g", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.minorsmode.a, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class MinorsKnowData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String des;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needTerm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String topBtnTxt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String bottomBtnTxt;

    public MinorsKnowData(String title, String des, boolean z16, String topBtnTxt, String bottomBtnTxt) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(des, "des");
        Intrinsics.checkNotNullParameter(topBtnTxt, "topBtnTxt");
        Intrinsics.checkNotNullParameter(bottomBtnTxt, "bottomBtnTxt");
        this.title = title;
        this.des = des;
        this.needTerm = z16;
        this.topBtnTxt = topBtnTxt;
        this.bottomBtnTxt = bottomBtnTxt;
    }

    public static /* synthetic */ MinorsKnowData b(MinorsKnowData minorsKnowData, String str, String str2, boolean z16, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = minorsKnowData.title;
        }
        if ((i3 & 2) != 0) {
            str2 = minorsKnowData.des;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            z16 = minorsKnowData.needTerm;
        }
        boolean z17 = z16;
        if ((i3 & 8) != 0) {
            str3 = minorsKnowData.topBtnTxt;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            str4 = minorsKnowData.bottomBtnTxt;
        }
        return minorsKnowData.a(str, str5, z17, str6, str4);
    }

    public final MinorsKnowData a(String title, String des, boolean needTerm, String topBtnTxt, String bottomBtnTxt) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(des, "des");
        Intrinsics.checkNotNullParameter(topBtnTxt, "topBtnTxt");
        Intrinsics.checkNotNullParameter(bottomBtnTxt, "bottomBtnTxt");
        return new MinorsKnowData(title, des, needTerm, topBtnTxt, bottomBtnTxt);
    }

    /* renamed from: c, reason: from getter */
    public final String getBottomBtnTxt() {
        return this.bottomBtnTxt;
    }

    /* renamed from: d, reason: from getter */
    public final String getDes() {
        return this.des;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getNeedTerm() {
        return this.needTerm;
    }

    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: g, reason: from getter */
    public final String getTopBtnTxt() {
        return this.topBtnTxt;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.des = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.des.hashCode()) * 31;
        boolean z16 = this.needTerm;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + this.topBtnTxt.hashCode()) * 31) + this.bottomBtnTxt.hashCode();
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "MinorsKnowData(title=" + this.title + ", des=" + this.des + ", needTerm=" + this.needTerm + ", topBtnTxt=" + this.topBtnTxt + ", bottomBtnTxt=" + this.bottomBtnTxt + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MinorsKnowData)) {
            return false;
        }
        MinorsKnowData minorsKnowData = (MinorsKnowData) other;
        return Intrinsics.areEqual(this.title, minorsKnowData.title) && Intrinsics.areEqual(this.des, minorsKnowData.des) && this.needTerm == minorsKnowData.needTerm && Intrinsics.areEqual(this.topBtnTxt, minorsKnowData.topBtnTxt) && Intrinsics.areEqual(this.bottomBtnTxt, minorsKnowData.bottomBtnTxt);
    }
}
