package com.tencent.mobileqq.guild.data;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/data/e;", "Lcom/tencent/mobileqq/guild/data/d;", "", "t", "", "toString", "i", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "icon", "j", "r", "w", "name", "k", "p", "u", "coverUrl", "l", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "traceId", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.data.e, reason: from toString */
/* loaded from: classes13.dex */
public final class GuildJumpData extends GuildJumpBaseData {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String icon = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String name = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String coverUrl = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceId = "";

    @Nullable
    /* renamed from: p, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final boolean t() {
        ArrayList arrayListOf;
        boolean z16;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(getGuildId(), getJoinSign(), getMainSource(), getSubSource());
        Iterator it = arrayListOf.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.GuildJumpBaseData
    @NotNull
    public String toString() {
        return "GuildJumpData(guildId=" + getGuildId() + ", channelId=" + getChannelId() + ", joinSign=" + getJoinSign() + ", mainSource='" + getMainSource() + "', subSource='" + getSubSource() + "', icon=" + this.icon + ", coverUrl=" + this.coverUrl + ", )";
    }

    public final void u(@Nullable String str) {
        this.coverUrl = str;
    }

    public final void v(@Nullable String str) {
        this.icon = str;
    }

    public final void w(@Nullable String str) {
        this.name = str;
    }

    public final void x(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }
}
