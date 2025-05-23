package com.tencent.mobileqq.richmedia.depend;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H&JB\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0011j\b\u0012\u0004\u0012\u00020\u0002`\u00122\u0006\u0010\u0014\u001a\u00020\u0002H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/richmedia/depend/b;", "Lcom/tencent/mobileqq/richmedia/depend/c;", "", "mediaId", "", "isSuccess", "targetPath", "Lcom/tencent/mobileqq/richmedia/depend/RichMediaDownloadType;", "type", "", "I7", "", "progress", "", "totalSize", "K8", "localPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", CoverDBCacheData.URLS, "errorMsg", "p9", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b extends c {
    void I7(@NotNull String mediaId, boolean isSuccess, @Nullable String targetPath, @NotNull RichMediaDownloadType type);

    void K8(@NotNull String mediaId, float progress, long totalSize, @NotNull RichMediaDownloadType type);

    void p9(@NotNull String mediaId, boolean isSuccess, @Nullable String localPath, @NotNull ArrayList<String> urls, @NotNull String errorMsg);
}
