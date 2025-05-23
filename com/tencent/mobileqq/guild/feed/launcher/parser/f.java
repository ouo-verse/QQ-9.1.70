package com.tencent.mobileqq.guild.feed.launcher.parser;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.topic.GuildTopicFragment;
import com.tencent.mobileqq.guild.feed.topic.TopicLaunchParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ:\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/launcher/parser/f;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedLauncher;", "Landroid/content/Context;", "context", "", "topicId", "", "topicName", QCircleWeakNetReporter.KEY_TRACE_ID, "guildId", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends GuildFeedLauncher {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f220101a = new f();

    f() {
    }

    public static /* synthetic */ void R(f fVar, Context context, long j3, String str, String str2, String str3, int i3, Object obj) {
        String str4;
        String str5;
        String str6;
        if ((i3 & 4) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        if ((i3 & 8) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i3 & 16) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        fVar.Q(context, j3, str4, str5, str6);
    }

    public final void Q(@NotNull Context context, long topicId, @Nullable String topicName, @Nullable String traceID, @Nullable String guildId) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("GuildTopicFragment", 1, "context: " + context + ", topicId: " + topicId + ", topicName: " + topicName + ", traceID: " + traceID + ", guildId: " + guildId);
        GuildTopicFragment.INSTANCE.a(context, new TopicLaunchParams(topicId, topicName, traceID, guildId));
    }
}
