package com.tencent.ecommerce.base.ui.tabbar;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\f\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\t\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/base/ui/tabbar/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "tabId", "b", "Ljava/lang/String;", "tabName", "c", "tabIdentifier", "d", "res", "", "e", UserInfo.SEX_FEMALE, "textSize", "f", "()I", "textSelectedColor", "g", "Z", "showIdentifier", h.F, "defaultTabWidth", "<init>", "(ILjava/lang/String;Ljava/lang/String;IFIZI)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.ui.tabbar.a, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class ECTabCoverInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int tabId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String tabName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String tabIdentifier;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int res;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final float textSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textSelectedColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean showIdentifier;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int defaultTabWidth;

    public ECTabCoverInfo(int i3, String str, String str2, int i16, float f16, int i17, boolean z16, int i18) {
        this.tabId = i3;
        this.tabName = str;
        this.tabIdentifier = str2;
        this.res = i16;
        this.textSize = f16;
        this.textSelectedColor = i17;
        this.showIdentifier = z16;
        this.defaultTabWidth = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getDefaultTabWidth() {
        return this.defaultTabWidth;
    }

    /* renamed from: b, reason: from getter */
    public final int getTextSelectedColor() {
        return this.textSelectedColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.tabId * 31;
        String str = this.tabName;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.tabIdentifier;
        int hashCode2 = (((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.res) * 31) + Float.floatToIntBits(this.textSize)) * 31) + this.textSelectedColor) * 31;
        boolean z16 = this.showIdentifier;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((hashCode2 + i16) * 31) + this.defaultTabWidth;
    }

    public String toString() {
        return "ECTabCoverInfo(tabId=" + this.tabId + ", tabName=" + this.tabName + ", tabIdentifier=" + this.tabIdentifier + ", res=" + this.res + ", textSize=" + this.textSize + ", textSelectedColor=" + this.textSelectedColor + ", showIdentifier=" + this.showIdentifier + ", defaultTabWidth=" + this.defaultTabWidth + ")";
    }

    public /* synthetic */ ECTabCoverInfo(int i3, String str, String str2, int i16, float f16, int i17, boolean z16, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i19 & 4) != 0 ? "" : str2, (i19 & 8) != 0 ? 0 : i16, (i19 & 16) != 0 ? 14.0f : f16, (i19 & 32) != 0 ? ECSkin.INSTANCE.getColor(R.color.f6942x) : i17, (i19 & 64) != 0 ? false : z16, (i19 & 128) != 0 ? 0 : i18);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECTabCoverInfo)) {
            return false;
        }
        ECTabCoverInfo eCTabCoverInfo = (ECTabCoverInfo) other;
        return this.tabId == eCTabCoverInfo.tabId && Intrinsics.areEqual(this.tabName, eCTabCoverInfo.tabName) && Intrinsics.areEqual(this.tabIdentifier, eCTabCoverInfo.tabIdentifier) && this.res == eCTabCoverInfo.res && Float.compare(this.textSize, eCTabCoverInfo.textSize) == 0 && this.textSelectedColor == eCTabCoverInfo.textSelectedColor && this.showIdentifier == eCTabCoverInfo.showIdentifier && this.defaultTabWidth == eCTabCoverInfo.defaultTabWidth;
    }
}
