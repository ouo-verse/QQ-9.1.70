package com.tencent.mobileqq.guild.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/data/i;", "Lcom/tencent/mobileqq/guild/data/d;", "", ReportConstant.COSTREPORT_PREFIX, "", "toString", "i", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "scheduleId", "j", "r", "v", "shareUrl", "", "k", "I", "p", "()I", "t", "(I)V", "enterSource", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.data.i, reason: from toString */
/* loaded from: classes13.dex */
public final class GuildScheduleJumpData extends GuildJumpBaseData {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String scheduleId = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String shareUrl = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int enterSource = -1;

    /* renamed from: p, reason: from getter */
    public final int getEnterSource() {
        return this.enterSource;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final boolean s() {
        ArrayList arrayListOf;
        boolean z16;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(getGuildId(), getChannelId(), getJoinSign(), getMainSource(), getSubSource(), this.scheduleId, this.shareUrl);
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
        if (this.enterSource != -1) {
            return false;
        }
        return true;
    }

    public final void t(int i3) {
        this.enterSource = i3;
    }

    @Override // com.tencent.mobileqq.guild.data.GuildJumpBaseData
    @NotNull
    public String toString() {
        return "GuildScheduleJumpData(guildId='" + getGuildId() + "', channelId='" + getChannelId() + "', joinSign='" + getJoinSign() + "', mainSource='" + getMainSource() + "', subSource='" + getSubSource() + "', scheduleId='" + this.scheduleId + "', shareUrl='" + this.shareUrl + "'enterSource='" + this.enterSource + "')";
    }

    public final void u(@Nullable String str) {
        this.scheduleId = str;
    }

    public final void v(@Nullable String str) {
        this.shareUrl = str;
    }
}
