package com.tencent.mobileqq.emoticon.api;

import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH'\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/IEmoticonGifUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isSoLoaded", "", "staticImageToGif", "", "originPath", "generatedFile", "Ljava/io/File;", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonGifUtils extends QRouteApi {
    boolean isSoLoaded();

    @WorkerThread
    @Nullable
    String staticImageToGif(@NotNull String originPath, @NotNull File generatedFile);
}
