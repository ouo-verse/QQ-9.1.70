package com.tencent.qqnt.aio.api;

import android.content.Context;
import android.net.Uri;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001'J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J2\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H&J<\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0012H&J*\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H&J*\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H&J8\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0004H&J\u001c\u0010&\u001a\u00020%2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010#H&\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/api/ISoGouEmoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "selfUin", "appId", "getOpenId", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "packId", "exprId", "", "trySend", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allPackId", "pullMultipleEmojiKey", "path", "action", "sendIMEExpression", "Landroid/net/Uri;", "uriPath", "targetName", "sendNewExp", "outputPath", "sampleRate", "bitRate", "voiceType", "changeType", "pcmPath", "startVoiceChange", "Lcom/tencent/qqnt/aio/api/ISoGouEmoApi$a;", "listener", "", "queryStateByPath", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ISoGouEmoApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/api/ISoGouEmoApi$a;", "", "", "path", "", "voiceType", "totalTime", "", "onCompressFinished", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        void onCompressFinished(@Nullable String path, int voiceType, int totalTime);
    }

    @NotNull
    String getOpenId(@NotNull Context context, @NotNull String selfUin, @NotNull String appId);

    void pullMultipleEmojiKey(@NotNull BaseQQAppInterface app, @NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @Nullable ArrayList<String> allPackId);

    boolean queryStateByPath(@Nullable String path, @Nullable a listener);

    void sendIMEExpression(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @Nullable String path, @NotNull String action);

    void sendNewExp(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Uri uriPath, @Nullable String targetName);

    void startVoiceChange(@NotNull String outputPath, int sampleRate, int bitRate, int voiceType, int changeType, @NotNull String pcmPath);

    void trySend(@NotNull BaseQQAppInterface app, @NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, int packId, @Nullable String exprId);
}
