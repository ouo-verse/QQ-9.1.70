package com.qzone.module.personalitycomponent.coverWidget;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/module/personalitycomponent/coverWidget/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "iconUrl", "b", "c", "e", WadlProxyConsts.KEY_JUMP_URL, "Lcom/qzone/module/personalitycomponent/coverWidget/m;", "Lcom/qzone/module/personalitycomponent/coverWidget/m;", "()Lcom/qzone/module/personalitycomponent/coverWidget/m;", "setInfo", "(Lcom/qzone/module/personalitycomponent/coverWidget/m;)V", "info", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/qzone/module/personalitycomponent/coverWidget/m;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.module.personalitycomponent.coverWidget.a, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ADInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String iconUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String jumpUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private ReportInfo info;

    public ADInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: b, reason: from getter */
    public final ReportInfo getInfo() {
        return this.info;
    }

    /* renamed from: c, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrl = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public int hashCode() {
        return (((this.iconUrl.hashCode() * 31) + this.jumpUrl.hashCode()) * 31) + this.info.hashCode();
    }

    public String toString() {
        return "ADInfo(iconUrl=" + this.iconUrl + ", jumpUrl=" + this.jumpUrl + ", info=" + this.info + ")";
    }

    public ADInfo(String iconUrl, String jumpUrl, ReportInfo info) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(info, "info");
        this.iconUrl = iconUrl;
        this.jumpUrl = jumpUrl;
        this.info = info;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ADInfo)) {
            return false;
        }
        ADInfo aDInfo = (ADInfo) other;
        return Intrinsics.areEqual(this.iconUrl, aDInfo.iconUrl) && Intrinsics.areEqual(this.jumpUrl, aDInfo.jumpUrl) && Intrinsics.areEqual(this.info, aDInfo.info);
    }

    public /* synthetic */ ADInfo(String str, String str2, ReportInfo reportInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? new ReportInfo(null, null, null, null, 15, null) : reportInfo);
    }
}
