package com.tencent.mobileqq.guild.heartbeatreport;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J?\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fH&\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/heartbeatreport/IFragmentStatusReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "pause", "", "reportResume", "guildId", "", "channelId", JumpGuildParam.EXTRA_KEY_CHANNEL_OPEN_SOURCE, "", "pginSourceName", "fromGuildTab", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes13.dex */
public interface IFragmentStatusReportApi extends QRouteApi {
    void pause();

    void reportResume(@Nullable String guildId, @Nullable String channelId, @Nullable Integer channelOpenSource, @Nullable String pginSourceName, boolean fromGuildTab);
}
