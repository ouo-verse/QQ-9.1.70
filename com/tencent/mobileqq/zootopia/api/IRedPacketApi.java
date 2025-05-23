package com.tencent.mobileqq.zootopia.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J \u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J \u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H&J\b\u0010\u0015\u001a\u00020\u000eH&J\b\u0010\u0016\u001a\u00020\u000eH&J\b\u0010\u0017\u001a\u00020\u0013H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IRedPacketApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "id", "", "getRedPacketPreViewCover", "getRedPacketCover", "getBigRedPacketCover", "usrId", "", "avatarId", "getAvatarPicSpUrl", "getAvatarPicApngUrl", "getAvatarPngUrl", "", "isShowZPlanRedPacketEntrance", "Landroid/app/Activity;", "context", "requestCode", "", "startRedPacketActivity", "isMaintenance", "isPreloadAvatar", "preloadAvatar", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IRedPacketApi extends QRouteApi {

    @NotNull
    public static final String AVATAR_ID_KEY = "avatarIdKey";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f327899a;

    @NotNull
    public static final String RED_PACKET_ID_KEY = "redPacketIdKey";

    @NotNull
    public static final String RED_PACKET_TITLE_KEY = "redPacketTitleKey";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IRedPacketApi$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.api.IRedPacketApi$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f327899a = new Companion();

        Companion() {
        }
    }

    @NotNull
    String getAvatarPicApngUrl(@NotNull String usrId, int id5, long avatarId);

    @NotNull
    String getAvatarPicSpUrl(@NotNull String usrId, int id5, long avatarId);

    @NotNull
    String getAvatarPngUrl(@NotNull String usrId, int id5, long avatarId);

    @NotNull
    String getBigRedPacketCover(int id5);

    @NotNull
    String getRedPacketCover(int id5);

    @NotNull
    String getRedPacketPreViewCover(int id5);

    boolean isMaintenance();

    boolean isPreloadAvatar();

    boolean isShowZPlanRedPacketEntrance();

    void preloadAvatar();

    void startRedPacketActivity(@NotNull Activity context, int requestCode);
}
