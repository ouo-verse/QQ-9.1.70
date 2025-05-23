package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSetVideoCurrentTimeEvent;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/y;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class y extends c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "setVideoCurrentTime";
    }

    @Override // ok1.a
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        String g16 = g("videoId");
        int d16 = d(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME);
        QLog.d("SetVideoCurrentTime", 1, "[SetVideoCurrentTime] video_id=" + g16 + ", time=" + d16);
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedSetVideoCurrentTimeEvent(g16, d16), true);
        return true;
    }
}
