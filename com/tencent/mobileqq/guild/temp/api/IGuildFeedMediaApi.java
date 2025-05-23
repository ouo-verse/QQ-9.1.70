package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J*\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\tH&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000fH&J\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u001b\u001a\u00020\u0005H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IGuildFeedMediaApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/guild/temp/api/e;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "maxMediaSize", "", "onlyPic", "Landroid/content/Intent;", "getOpenNativePublishAlbumIntent", "Lcom/tencent/mobileqq/guild/temp/api/b;", "albumInput", "getOpenSimplifiedNativePublisherAlbumIntent", "getOpenCommentAlbumIntent", "Landroidx/activity/result/ActivityResult;", "result", "", "", "getMediaInfoList", "Lcom/tencent/mobileqq/guild/temp/api/c;", "getAlbumResult", "Landroid/content/Context;", "context", "curMedia", "Lcom/tencent/mobileqq/qroute/route/ActivityURIRequest;", "getPreviewUriRequest", "getTranslucentBrowserType", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildFeedMediaApi extends QRouteApi, e {
    @Nullable
    c getAlbumResult(@NotNull ActivityResult result);

    @NotNull
    List<Object> getMediaInfoList(@NotNull Intent result);

    @NotNull
    List<Object> getMediaInfoList(@NotNull ActivityResult result);

    @NotNull
    Intent getOpenCommentAlbumIntent(@NotNull Activity activity, int maxMediaSize);

    @NotNull
    Intent getOpenNativePublishAlbumIntent(@NotNull Activity activity, int maxMediaSize, boolean onlyPic);

    @NotNull
    Intent getOpenSimplifiedNativePublisherAlbumIntent(@NotNull Activity activity, int maxMediaSize, boolean onlyPic, @Nullable b albumInput);

    @Nullable
    ActivityURIRequest getPreviewUriRequest(@NotNull Context context, @NotNull Object curMedia, @NotNull b albumInput);

    int getTranslucentBrowserType();

    @Override // com.tencent.mobileqq.guild.temp.api.e
    /* synthetic */ boolean hasQRCode(@NotNull String str);

    @Override // com.tencent.mobileqq.guild.temp.api.e
    /* synthetic */ int isValidImage(@NotNull Object obj, @Nullable String[] strArr);

    @Override // com.tencent.mobileqq.guild.temp.api.e
    /* synthetic */ int isValidVideo(@NotNull Object obj, @Nullable String[] strArr);
}
