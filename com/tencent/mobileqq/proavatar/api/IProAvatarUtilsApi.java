package com.tencent.mobileqq.proavatar.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqnt.avatar.fetch.c;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J,\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0002H&J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J,\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000bH&J'\u0010#\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190!H&\u00a2\u0006\u0004\b#\u0010$\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/proavatar/api/IProAvatarUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "getComponentSwitch", "", "initProAvatarComponent", "isProAvatarDebug", "isQZoneAvatarBugfixSwitchOn", "isEnableMp4Avatar", "Ljava/io/File;", "getDownloadCacheDir", "", "headType", "", "uin", "Lcom/tencent/mobileqq/proavatar/e;", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/avatar/fetch/c;", "buildResourceFetchRequest", "isRefresh", "", "", "getAvatarInfo", "Lcom/tencent/mobileqq/data/Setting;", "getAvatarInfoSetting", "Landroid/graphics/Bitmap;", "getTroopFaceBitmap", "faceType", "", "shape", "sizeType", "getFaceBitmap", "size", "", "bitmapArr", "getGroupAvatar", "(I[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProAvatarUtilsApi extends QRouteApi {
    @NotNull
    c buildResourceFetchRequest(int headType, @NotNull String uin, @Nullable e config);

    @NotNull
    c buildResourceFetchRequest(int headType, @NotNull String uin, @Nullable e config, boolean isRefresh);

    @NotNull
    Map<String, Object> getAvatarInfo(int headType, @NotNull String uin);

    @Nullable
    Setting getAvatarInfoSetting(int headType, @Nullable String uin);

    boolean getComponentSwitch();

    @NotNull
    File getDownloadCacheDir();

    @Nullable
    Bitmap getFaceBitmap(int faceType, @Nullable String uin, byte shape, int sizeType);

    @Nullable
    Bitmap getGroupAvatar(int size, @NotNull Bitmap[] bitmapArr);

    @Nullable
    Bitmap getTroopFaceBitmap(@Nullable String uin);

    void initProAvatarComponent();

    boolean isEnableMp4Avatar();

    boolean isProAvatarDebug();

    boolean isQZoneAvatarBugfixSwitchOn();
}
