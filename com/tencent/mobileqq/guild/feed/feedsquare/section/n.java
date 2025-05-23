package com.tencent.mobileqq.guild.feed.feedsquare.section;

import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\r\u001a\u0004\u0018\u00010\fR#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/n;", "", "T", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "p", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "r", "Lxj1/c;", "u", "", "d", "Ljava/util/Map;", "t", "()Ljava/util/Map;", "mDtParams", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class n<T> extends Section<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> mDtParams = new ConcurrentHashMap();

    public final int p() {
        xj1.c u16 = u();
        if (u16 != null) {
            return u16.getBusinessType();
        }
        return 0;
    }

    @NotNull
    public final String q() {
        String channelName;
        xj1.c u16 = u();
        if (u16 == null || (channelName = u16.getChannelName()) == null) {
            return "";
        }
        return channelName;
    }

    @Nullable
    public final JumpGuildParam.JoinInfoParam r() {
        xj1.c u16 = u();
        if (u16 != null) {
            return u16.b();
        }
        return null;
    }

    public final int s() {
        xj1.c u16 = u();
        if (u16 != null) {
            return u16.a();
        }
        return 0;
    }

    @NotNull
    public final Map<String, Object> t() {
        return this.mDtParams;
    }

    @Nullable
    public final xj1.c u() {
        return (xj1.c) SectionIOCKt.getIocInterface(this, xj1.c.class);
    }

    @NotNull
    public String v() {
        return "GuildFeedSquareBaseSection";
    }
}
