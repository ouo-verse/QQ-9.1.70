package com.tencent.qqnt.aio.adapter.api;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H&J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOPEPanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isPeResDownloaded", "isTypefaceLoading", "flag", "", "setTypefaceLoading", "Landroid/graphics/Typeface;", "getTypeFace", "loadFontTypeface", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "checkPEResDownloaded", "", QQSysAndEmojiResInfo.EMO_ID, "Landroid/graphics/drawable/Drawable;", "getAsyncEmoDrawable", "emoIndex", "count", "playPopEmoAnimation", "emoid", "playPokeEmoAnimation", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOPEPanelApi extends QRouteApi {
    void checkPEResDownloaded(@NotNull AppRuntime app, @NotNull com.tencent.aio.api.runtime.a aioContext);

    @Nullable
    Drawable getAsyncEmoDrawable(int emoId);

    @Nullable
    Typeface getTypeFace();

    boolean isPeResDownloaded();

    boolean isTypefaceLoading();

    void loadFontTypeface();

    void playPokeEmoAnimation(@NotNull com.tencent.aio.api.runtime.a aioContext, int emoid, int count);

    void playPopEmoAnimation(@NotNull com.tencent.aio.api.runtime.a aioContext, int emoIndex, int count);

    void setTypefaceLoading(boolean flag);
}
