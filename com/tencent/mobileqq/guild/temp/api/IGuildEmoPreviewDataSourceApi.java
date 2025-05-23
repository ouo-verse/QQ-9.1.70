package com.tencent.mobileqq.guild.temp.api;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IGuildEmoPreviewDataSourceApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createGuildEmoPreviewData", "", "msg", "Lcom/tencent/mobileqq/data/MessageRecord;", "createGuildEmoPreviewDataSource", "intent", "Landroid/content/Intent;", "curData", "sessionInfo", "Landroid/os/Parcelable;", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildEmoPreviewDataSourceApi extends QRouteApi {
    @NotNull
    Object createGuildEmoPreviewData(@NotNull MessageRecord msg2);

    @NotNull
    Object createGuildEmoPreviewDataSource(@NotNull Intent intent, @NotNull Object curData, @NotNull Parcelable sessionInfo);
}
