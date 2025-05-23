package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.y;
import com.tencent.mobileqq.guild.emoj.GuildEmotionPreviewDateSource;
import com.tencent.mobileqq.guild.temp.api.IGuildEmoPreviewDataSourceApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/GuildEmoPreviewDataSourceApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IGuildEmoPreviewDataSourceApi;", "()V", "createGuildEmoPreviewData", "", "msg", "Lcom/tencent/mobileqq/data/MessageRecord;", "createGuildEmoPreviewDataSource", "intent", "Landroid/content/Intent;", "curData", "sessionInfo", "Landroid/os/Parcelable;", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class GuildEmoPreviewDataSourceApiImpl implements IGuildEmoPreviewDataSourceApi {
    @Override // com.tencent.mobileqq.guild.temp.api.IGuildEmoPreviewDataSourceApi
    public Object createGuildEmoPreviewData(MessageRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new com.tencent.mobileqq.guild.emoj.e(msg2);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildEmoPreviewDataSourceApi
    public Object createGuildEmoPreviewDataSource(Intent intent, Object curData, Parcelable sessionInfo) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(curData, "curData");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        return new GuildEmotionPreviewDateSource(intent, curData instanceof y ? (y) curData : null, sessionInfo instanceof SessionInfo ? (SessionInfo) sessionInfo : null);
    }
}
