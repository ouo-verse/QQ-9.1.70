package com.tencent.mobileqq.zootopia.api;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zootopia.ZootopiaDownloadResData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.rdelivery.reshub.api.i;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u001c\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&J6\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&JD\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015H&J&\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00060\u0015H&J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH&J?\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\"\u001a\u00020\u0006H&J\b\u0010#\u001a\u00020\u0006H&J\b\u0010$\u001a\u00020\u0006H&J\b\u0010%\u001a\u00020\u0002H&J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&J \u0010)\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010(\u001a\u00020'H&J*\u00101\u001a\u0004\u0018\u0001002\u0006\u0010*\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020/H&J(\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u000205H&J\b\u00107\u001a\u00020\u0002H&J\b\u00108\u001a\u00020\u0006H&J\b\u00109\u001a\u00020\u0002H&J\b\u0010:\u001a\u00020'H&J\b\u0010;\u001a\u00020\u0002H&J\b\u0010=\u001a\u00020<H&J\b\u0010>\u001a\u00020<H&JW\u0010F\u001a\u00020E2M\u0010D\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0015\u0012\u0013\u0018\u00010'\u00a2\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00060?H&\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IZootopiaApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "shouldHideSmallHomeEntry", "", "getSuperQQShowBeancurdId", "", "notifyAllConfigListener", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "startDemoActivity", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "startPortalActivity", "startMakeUpActivity", "startListActivity", "mapId", FavEmoConstant.ROAMING_TYPE_PANEL, "startDetailActivity", "Lkotlin/Function1;", "callback", "openMap", "Lcom/tencent/mobileqq/zootopia/h;", "queryDownloadStatus", "startProfileCustomerActivity", "sceneType", "subSceneType", "startSimpleAvatarFragment", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ILjava/lang/Integer;Landroid/os/Bundle;)V", "startSmallHomePermissionManagerActivity", "startFollowAndFansSettingActivity", "startBindingSettingActivity", "doWhenQQLogout", "onAccountChange", "onAvatarChange", "ignoreProfileCardCheckForDev", "startDownloadManagerActivity", "", "uin", "startSmallHomeByUin", "type", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lbd3/e;", "data", "Lbd3/c;", "Lbd3/b;", "createProfileCommonTips", "Lcom/tencent/common/app/AppInterface;", "app", "masterUin", "Lad3/a;", "checkSmallHomeVisitPermission", "enableZPlanAIOMakeGifEntrance", "preLoadCoreDatas", "isParadiseTabShow", "getOIDBPushHandlerName", "isDownloadingModRes", "Lcom/tencent/rdelivery/reshub/api/i;", "getResHubInstance", "getTestResHubInstance", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccess", QzoneIPCModule.RESULT_CODE, "onUpdate", "Lcom/tencent/mobileqq/app/BusinessObserver;", "createCardBusinessObserver", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZootopiaApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(IZootopiaApi iZootopiaApi, Context context, int i3, ZootopiaSource zootopiaSource, boolean z16, Bundle bundle, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    z16 = false;
                }
                boolean z17 = z16;
                if ((i16 & 16) != 0) {
                    bundle = null;
                }
                iZootopiaApi.startDetailActivity(context, i3, zootopiaSource, z17, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDetailActivity");
        }

        public static /* synthetic */ void b(IZootopiaApi iZootopiaApi, Context context, ZootopiaSource zootopiaSource, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bundle = null;
                }
                iZootopiaApi.startMakeUpActivity(context, zootopiaSource, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startMakeUpActivity");
        }

        public static /* synthetic */ void c(IZootopiaApi iZootopiaApi, Context context, ZootopiaSource zootopiaSource, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bundle = null;
                }
                iZootopiaApi.startPortalActivity(context, zootopiaSource, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPortalActivity");
        }
    }

    void checkSmallHomeVisitPermission(@NotNull AppInterface app, @NotNull String masterUin, int source, @NotNull ad3.a callback);

    @NotNull
    BusinessObserver createCardBusinessObserver(@NotNull Function3<? super Boolean, ? super String, ? super Integer, Unit> onUpdate);

    @Nullable
    bd3.b createProfileCommonTips(int type, @NotNull ViewGroup container, @NotNull bd3.e data, @NotNull bd3.c callback);

    void doWhenQQLogout();

    boolean enableZPlanAIOMakeGifEntrance();

    @NotNull
    String getOIDBPushHandlerName();

    @NotNull
    i getResHubInstance();

    int getSuperQQShowBeancurdId();

    @NotNull
    i getTestResHubInstance();

    boolean ignoreProfileCardCheckForDev();

    boolean isDownloadingModRes();

    boolean isParadiseTabShow();

    void notifyAllConfigListener();

    void onAccountChange();

    void onAvatarChange();

    void openMap(@NotNull Context context, int mapId, @NotNull ZootopiaSource source, @Nullable Bundle bundle, @Nullable Function1<? super Integer, Unit> callback);

    void preLoadCoreDatas();

    void queryDownloadStatus(int mapId, @NotNull Function1<? super ZootopiaDownloadResData, Unit> callback);

    boolean shouldHideSmallHomeEntry();

    void startBindingSettingActivity(@NotNull Context context, @NotNull Bundle bundle);

    void startDemoActivity(@NotNull Context context, @Nullable Bundle bundle);

    void startDetailActivity(@NotNull Context context, int mapId, @NotNull ZootopiaSource source, boolean needDownload, @Nullable Bundle bundle);

    void startDownloadManagerActivity(@NotNull Context context, @NotNull ZootopiaSource source);

    void startFollowAndFansSettingActivity(@NotNull Context context, @NotNull Bundle bundle);

    void startListActivity(@NotNull Context context, @NotNull ZootopiaSource source);

    void startMakeUpActivity(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startPortalActivity(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startProfileCustomerActivity(@NotNull Context context, @NotNull ZootopiaSource source, @NotNull Bundle bundle);

    void startSimpleAvatarFragment(@NotNull Context context, @NotNull ZootopiaSource source, int sceneType, @Nullable Integer subSceneType, @Nullable Bundle bundle);

    void startSmallHomeByUin(@NotNull Context context, @NotNull ZootopiaSource source, @NotNull String uin);

    void startSmallHomePermissionManagerActivity(@NotNull Context context, @NotNull Bundle bundle);
}
