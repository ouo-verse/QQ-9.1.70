package com.tencent.mobileqq.onlinestatus.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.onlinestatus.model.a;
import com.tencent.mobileqq.onlinestatus.model.b;
import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&JM\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011H&J=\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\f2#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00160\u00112\u0006\u0010\u001b\u001a\u00020\fH&J5\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011H&J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH&J5\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00160\u0011H&J]\u0010#\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2K\u0010\u0017\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00160\u001fH&J5\u0010$\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\f2#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011H&JP\u0010(\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\f26\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00160%2\u0006\u0010\u001b\u001a\u00020\fH&J\u0018\u0010)\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH&J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH&J\b\u0010+\u001a\u00020\u0016H&J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH&J+\u0010.\u001a\u00020\u00162!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00160\u0011H&J\b\u0010/\u001a\u00020\u0016H&J\b\u00100\u001a\u00020\u0016H&J\u0010\u00101\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\fH&J=\u00104\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000102\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00160\u0011H&J\u0018\u00105\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH&J*\u00106\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\fH&J\u001a\u00107\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH&J0\u00109\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH&J\u0018\u0010;\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010:\u001a\u00020\nH&J#\u0010>\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b>\u0010?J\b\u0010@\u001a\u00020\u0016H&\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/IAvatarStatusViewApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isDeviceSupportFilament", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "scene", "Lcom/tencent/mobileqq/onlinestatus/view/aj;", "createIAvatarStatusView", "", "uin", "", "onlineStatus", "Lcom/tencent/mobileqq/onlinestatus/model/a;", "actionKey", "dressKey", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "callback", "getPreviewImage", "onlineStatusId", "path", "subIndex", "getSelfPreviewImage", "getCachedDressKey", "getDressKey", "Lkotlin/Function3;", "suc", "hasCustomDressUp", "fromNet", "checkIsCustomDressUp", "getFallbackPreviewImage", "Lkotlin/Function2;", "imageUrl", "color", "getNormalBackground", "getTofuBackgroundImage", "isTofuBackgroundImageReady", "downloadFallbackPreviewImages", "downloadResource", "success", "downloadAllTofuBg", "preloadConfig", "clearResource", "isSupportAvatarView", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "getFilamentActionResource", "isActionResourcesReady", "isAvatarFirstFramePngReady", "getFilamentActionKey", "previewPath", "saveSelfPreviewToLocal", "imagePath", "uploadSelfActionPreview", "showPreview", "showFilament", "setAvatarViewShowStrategy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "forceReleaseFilamentView", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IAvatarStatusViewApi extends QRouteApi {
    void checkIsCustomDressUp(@NotNull String uin, @NotNull Function3<? super Boolean, ? super Boolean, ? super Boolean, Unit> callback);

    void clearResource();

    @NotNull
    aj createIAvatarStatusView(@NotNull Context context, @NotNull AvatarStatusViewScene scene);

    void downloadAllTofuBg(@NotNull Function1<? super Boolean, Unit> callback);

    void downloadFallbackPreviewImages();

    void downloadResource(int onlineStatusId, int subIndex);

    void forceReleaseFilamentView();

    @Nullable
    String getCachedDressKey(@NotNull String uin);

    void getDressKey(@NotNull String uin, @NotNull Function1<? super String, Unit> callback);

    void getFallbackPreviewImage(int onlineStatusId, @NotNull Function1<? super Drawable, Unit> callback);

    @Nullable
    a getFilamentActionKey(int onlineStatusId, int subIndex);

    void getFilamentActionResource(int onlineStatusId, int subIndex, @NotNull Function1<? super b, Unit> callback);

    void getNormalBackground(int onlineStatusId, @NotNull Function2<? super String, ? super String, Unit> callback, int subIndex);

    void getPreviewImage(@NotNull String uin, int onlineStatus, @NotNull a actionKey, @NotNull String dressKey, @NotNull Function1<? super Drawable, Unit> callback);

    void getPreviewImage(@NotNull String uin, @NotNull Function1<? super Drawable, Unit> callback);

    void getSelfPreviewImage(int onlineStatusId, @NotNull Function1<? super Drawable, Unit> callback, int subIndex);

    @NotNull
    String getTofuBackgroundImage(int onlineStatusId, int subIndex);

    boolean isActionResourcesReady(int onlineStatusId, int subIndex);

    @Nullable
    String isAvatarFirstFramePngReady(@NotNull String uin, int onlineStatusId, @NotNull String dressKey, int subIndex);

    boolean isDeviceSupportFilament();

    boolean isSupportAvatarView(int onlineStatusId);

    boolean isTofuBackgroundImageReady(int onlineStatusId, int subIndex);

    void preloadConfig();

    void saveSelfPreviewToLocal(@NotNull String uin, int onlineStatusId, @NotNull String actionKey, @NotNull String dressKey, @NotNull String previewPath);

    void setAvatarViewShowStrategy(@Nullable Boolean showPreview, @Nullable Boolean showFilament);

    void uploadSelfActionPreview(int onlineStatusId, @NotNull String imagePath);
}
