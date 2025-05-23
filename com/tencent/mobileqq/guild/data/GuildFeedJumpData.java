package com.tencent.mobileqq.guild.data;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000b\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/data/c;", "Lcom/tencent/mobileqq/guild/data/d;", "", "v", "", "toString", "i", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "posterTinyId", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "feedId", "", "k", "J", "p", "()J", "w", "(J)V", WadlProxyConsts.CREATE_TIME, "", "l", "I", ReportConstant.COSTREPORT_PREFIX, "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(I)V", "shareSource", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "shareUrl", DomainData.DOMAIN_NAME, "u", "B", "traceId", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.data.c, reason: from toString */
/* loaded from: classes13.dex */
public final class GuildFeedJumpData extends GuildJumpBaseData {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String posterTinyId = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String feedId = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private long createTime = -1;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int shareSource = -1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String shareUrl = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceId = "";

    public final void A(@Nullable String str) {
        this.shareUrl = str;
    }

    public final void B(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }

    /* renamed from: p, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final String getPosterTinyId() {
        return this.posterTinyId;
    }

    /* renamed from: s, reason: from getter */
    public final int getShareSource() {
        return this.shareSource;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @Override // com.tencent.mobileqq.guild.data.GuildJumpBaseData
    @NotNull
    public String toString() {
        return "GuildFeedJumpData(guildId=" + getGuildId() + ", channelId=" + getChannelId() + ", posterTinyId=" + this.posterTinyId + ", feedId=" + this.feedId + ", createTime=" + this.createTime + ", shareSource=" + this.shareSource + ')';
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final boolean v() {
        ArrayList arrayListOf;
        boolean z16;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(getGuildId(), getChannelId(), this.posterTinyId, this.feedId);
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
        if (this.createTime != -1 && this.shareSource != -1) {
            return false;
        }
        return true;
    }

    public final void w(long j3) {
        this.createTime = j3;
    }

    public final void x(@Nullable String str) {
        this.feedId = str;
    }

    public final void y(@Nullable String str) {
        this.posterTinyId = str;
    }

    public final void z(int i3) {
        this.shareSource = i3;
    }
}
