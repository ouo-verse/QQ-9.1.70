package com.tencent.mobileqq.zplan.minihome.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.minihome.CreateMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.EditMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.GiftReportInfo;
import com.tencent.mobileqq.zplan.minihome.GuidanceSource;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfo;
import com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum;
import com.tencent.mobileqq.zplan.minihome.aa;
import com.tencent.mobileqq.zplan.minihome.ab;
import com.tencent.mobileqq.zplan.minihome.ao;
import com.tencent.mobileqq.zplan.minihome.y;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u00029:J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\tH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u000fH&J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0002H&J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H&J\b\u0010\u0017\u001a\u00020\u0016H&J,\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH&J$\u0010!\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010 H&J,\u0010%\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010 H&J \u0010(\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020'0&H&J\u001c\u0010*\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010)H&J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020+H&J\b\u0010.\u001a\u00020-H&J\b\u00100\u001a\u00020/H&J4\u00103\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u000102H&JF\u00104\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u000102H&J*\u00108\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u00022\u0006\u00107\u001a\u0002062\b\u0010#\u001a\u0004\u0018\u00010\"H&\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "uniqueKey", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "scene", "Lcom/tencent/mobileqq/zplan/minihome/y;", "getMiniHomeController", "", "releaseMiniHomeController", "Lcom/tencent/mobileqq/zplan/minihome/ao;", "getSaveRoomDesc", "value", "setTemporaryRoomDesc", "", "saveHasCreatedMiniHome", "getHasCreatedMiniHome", "roomHash", "getStaticImagePath", "imagePath", "setStaticImagePath", "", "askShowGuidanceDialog", "Landroid/content/Context;", "context", "parentSource", "Lcom/tencent/mobileqq/zplan/minihome/GuidanceSource;", "source", "Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper$c;", "callback", "showGuidanceDialog", "Lcom/tencent/mobileqq/zplan/minihome/CreateMiniHomeSource;", "startCreateMiniHomePage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "startCreateMiniHomePageForResult", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper$b;", "requestMiniHomeInfoFromNet", "Lnk3/a;", "requestSetZPlanMiniHomeSettingSwitch", "", "getZPlanMiniHomeSettingSwitch", "Lcom/tencent/mobileqq/zplan/minihome/aa;", "createMiniHomeReporter", "Lcom/tencent/mobileqq/zplan/minihome/ab;", "createMiniHomeReporterV2", "roomJson", "Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeSource;", "startEditMiniHomeFragment", "startEditMiniHomeFragmentForResult", "friendUin", "Lcom/tencent/mobileqq/zplan/minihome/w;", CacheTable.TABLE_NAME, "askShowGiftRewardDialog", "b", "c", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IMiniHomeHelper extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(IMiniHomeHelper iMiniHomeHelper, boolean z16, nk3.a aVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    aVar = null;
                }
                iMiniHomeHelper.requestSetZPlanMiniHomeSettingSwitch(z16, aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestSetZPlanMiniHomeSettingSwitch");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper$b;", "", "", "success", "Lcom/tencent/mobileqq/zplan/minihome/ag;", "info", "", "onResult", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void onResult(boolean success, @Nullable MiniHomeInfo info);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper$c;", "", "", "result", "", "onResult", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        void onResult(boolean result);
    }

    void askShowGiftRewardDialog(@NotNull Context context, @NotNull String friendUin, @NotNull GiftReportInfo reportInfo, @Nullable Activity activity);

    boolean askShowGuidanceDialog();

    @NotNull
    aa createMiniHomeReporter();

    @NotNull
    ab createMiniHomeReporterV2();

    int getHasCreatedMiniHome();

    @NotNull
    y getMiniHomeController(@NotNull String uin, @NotNull String uniqueKey, @NotNull MiniHomeSceneEnum scene);

    @Nullable
    ao getSaveRoomDesc(@NotNull String uin);

    @NotNull
    String getStaticImagePath(@NotNull String uin, @NotNull MiniHomeSceneEnum scene, @NotNull String roomHash);

    boolean getZPlanMiniHomeSettingSwitch(long uin);

    void releaseMiniHomeController();

    void requestMiniHomeInfoFromNet(@Nullable String uin, @NotNull WeakReference<b> callback);

    void requestSetZPlanMiniHomeSettingSwitch(boolean value, @Nullable nk3.a callback);

    void saveHasCreatedMiniHome(int value);

    void setStaticImagePath(@NotNull String uin, @NotNull MiniHomeSceneEnum scene, @NotNull String imagePath, @NotNull String roomHash);

    void setTemporaryRoomDesc(@NotNull String uin, @Nullable ao value);

    void showGuidanceDialog(@NotNull Context context, @Nullable String parentSource, @NotNull GuidanceSource source, @NotNull c callback);

    void startCreateMiniHomePage(@NotNull Context context, @NotNull String uin, @Nullable CreateMiniHomeSource source);

    void startCreateMiniHomePageForResult(@NotNull Activity activity, @NotNull String uin, int requestCode, @Nullable CreateMiniHomeSource source);

    void startEditMiniHomeFragment(@NotNull Context context, @NotNull String uin, @NotNull String uniqueKey, @NotNull String roomJson, @Nullable EditMiniHomeSource source);

    void startEditMiniHomeFragmentForResult(@NotNull Activity activity, int requestCode, @Nullable Context context, @NotNull String uin, @NotNull String uniqueKey, @NotNull String roomJson, @Nullable EditMiniHomeSource source);
}
