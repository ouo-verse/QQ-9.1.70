package com.tencent.mobileqq.guild.data;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0007\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010\u000b\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/data/f;", "Lcom/tencent/mobileqq/guild/data/d;", "", "w", "", "toString", "i", "Ljava/lang/String;", "u", "()Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/String;)V", "liveStreamUrl", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "guildName", "k", "t", "B", "liveRoomName", "l", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "liveAnchorId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", ReportConstant.COSTREPORT_PREFIX, "()J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(J)V", "liveRoomId", "", DomainData.DOMAIN_NAME, "I", "p", "()I", HippyTKDListViewAdapter.X, "(I)V", "enterSource", "o", "v", "D", "traceId", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.data.f, reason: from toString */
/* loaded from: classes13.dex */
public final class GuildLiveJumpData extends GuildJumpBaseData {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String liveStreamUrl = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String guildName = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String liveRoomName = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String liveAnchorId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private long liveRoomId = -1;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private int enterSource = -1;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceId = "";

    public final void A(long j3) {
        this.liveRoomId = j3;
    }

    public final void B(@Nullable String str) {
        this.liveRoomName = str;
    }

    public final void C(@Nullable String str) {
        this.liveStreamUrl = str;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }

    /* renamed from: p, reason: from getter */
    public final int getEnterSource() {
        return this.enterSource;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final String getLiveAnchorId() {
        return this.liveAnchorId;
    }

    /* renamed from: s, reason: from getter */
    public final long getLiveRoomId() {
        return this.liveRoomId;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final String getLiveRoomName() {
        return this.liveRoomName;
    }

    @Override // com.tencent.mobileqq.guild.data.GuildJumpBaseData
    @NotNull
    public String toString() {
        return "GuildLiveJumpData(guildId=" + getGuildId() + ", channelId=" + getChannelId() + ", joinSign=" + getJoinSign() + ", mainSource='" + getMainSource() + "', subSource='" + getSubSource() + "', liveStreamUrl=" + this.liveStreamUrl + ", guildName=" + this.guildName + ", liveRoomName=" + this.liveRoomName + ", liveAnchorId=" + this.liveAnchorId + ", liveRoomId=" + this.liveRoomId + ", enterSource=" + this.enterSource + ", )";
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final String getLiveStreamUrl() {
        return this.liveStreamUrl;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final boolean w() {
        ArrayList arrayListOf;
        boolean z16;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(getGuildId(), getChannelId(), getJoinSign(), getMainSource(), getSubSource(), this.liveStreamUrl, this.guildName, this.liveRoomName, this.liveAnchorId);
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
        if (this.liveRoomId != -1 && this.enterSource != -1) {
            return false;
        }
        return true;
    }

    public final void x(int i3) {
        this.enterSource = i3;
    }

    public final void y(@Nullable String str) {
        this.guildName = str;
    }

    public final void z(@Nullable String str) {
        this.liveAnchorId = str;
    }
}
