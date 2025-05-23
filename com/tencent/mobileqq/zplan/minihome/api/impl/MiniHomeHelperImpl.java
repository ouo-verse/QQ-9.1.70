package com.tencent.mobileqq.zplan.minihome.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.aio.guidance.ZPlanMiniHomeGuidanceDialog;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment;
import com.tencent.mobileqq.zplan.minihome.CreateMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment;
import com.tencent.mobileqq.zplan.minihome.EditMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.GiftReportInfo;
import com.tencent.mobileqq.zplan.minihome.GuidanceSource;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfo;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfoObserver;
import com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum;
import com.tencent.mobileqq.zplan.minihome.aa;
import com.tencent.mobileqq.zplan.minihome.ab;
import com.tencent.mobileqq.zplan.minihome.ai;
import com.tencent.mobileqq.zplan.minihome.aj;
import com.tencent.mobileqq.zplan.minihome.ak;
import com.tencent.mobileqq.zplan.minihome.ao;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.minihome.y;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import q55.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J*\u0010!\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\"H\u0016J*\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\"H\u0016J \u0010*\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\u001a\u0010,\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00101\u001a\u000200H\u0016J2\u00104\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u000103H\u0016JD\u00105\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u000103H\u0016J*\u00109\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u00062\u0006\u00108\u001a\u0002072\b\u0010%\u001a\u0004\u0018\u00010$H\u0016\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/api/impl/MiniHomeHelperImpl;", "Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper;", "", "uin", "", "requestTurnZPlanProfileSettingSwitchOn", "", "uniqueKey", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "scene", "Lcom/tencent/mobileqq/zplan/minihome/y;", "getMiniHomeController", "releaseMiniHomeController", "Lcom/tencent/mobileqq/zplan/minihome/ao;", "getSaveRoomDesc", "value", "setTemporaryRoomDesc", "", "saveHasCreatedMiniHome", "getHasCreatedMiniHome", "roomHash", "getStaticImagePath", "imagePath", "setStaticImagePath", "", "askShowGuidanceDialog", "Landroid/content/Context;", "context", "parentSource", "Lcom/tencent/mobileqq/zplan/minihome/GuidanceSource;", "source", "Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper$c;", "callback", "showGuidanceDialog", "Lcom/tencent/mobileqq/zplan/minihome/CreateMiniHomeSource;", "startCreateMiniHomePage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "startCreateMiniHomePageForResult", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper$b;", "requestMiniHomeInfoFromNet", "Lnk3/a;", "requestSetZPlanMiniHomeSettingSwitch", "getZPlanMiniHomeSettingSwitch", "Lcom/tencent/mobileqq/zplan/minihome/aa;", "createMiniHomeReporter", "Lcom/tencent/mobileqq/zplan/minihome/ab;", "createMiniHomeReporterV2", "roomJson", "Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeSource;", "startEditMiniHomeFragment", "startEditMiniHomeFragmentForResult", "friendUin", "Lcom/tencent/mobileqq/zplan/minihome/w;", CacheTable.TABLE_NAME, "askShowGiftRewardDialog", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeHelperImpl implements IMiniHomeHelper {
    public static final String HAS_CREATE_MINI_HOME = "has_create_mini_home";
    public static final String SAVE_IMAGE_KEY = "save_image_key";
    public static final String SAVE_ROOM_KEY = "save_room_key";
    public static final String TAG = "MiniHomeHelperImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestSetZPlanMiniHomeSettingSwitch$lambda$2(boolean z16, MiniHomeHelperImpl this$0, nk3.a aVar, boolean z17) {
        QQAppInterface l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z17 && (l3 = bb.f335811a.l()) != null) {
            long longAccountUin = l3.getLongAccountUin();
            if (z16) {
                this$0.requestTurnZPlanProfileSettingSwitchOn(longAccountUin);
            }
            QRouteApi api = QRoute.api(IZPlanAccessibleHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAccessibleHelper::class.java)");
            IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) api;
            AccessibleDetail zplanAccessibleDetail = iZPlanAccessibleHelper.getZplanAccessibleDetail(1012L, longAccountUin);
            if (zplanAccessibleDetail != null) {
                zplanAccessibleDetail.settingPass = z16 ? 1 : 0;
                iZPlanAccessibleHelper.updateCache(zplanAccessibleDetail);
            }
        }
        if (aVar != null) {
            aVar.onResult(z17);
        }
    }

    private final void requestTurnZPlanProfileSettingSwitchOn(long uin) {
        IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class);
        AccessibleDetail zplanAccessibleDetail = iZPlanAccessibleHelper.getZplanAccessibleDetail(1004L, uin);
        if (zplanAccessibleDetail == null) {
            return;
        }
        zplanAccessibleDetail.settingPass = 1;
        iZPlanAccessibleHelper.updateCache(zplanAccessibleDetail);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void askShowGiftRewardDialog(Context context, String friendUin, GiftReportInfo reportInfo, Activity activity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        Intrinsics.checkNotNull(f16);
        CorountineFunKt.e(f16, "MiniHomeHelperImpl requestDrawMinihomeGift", null, null, null, new MiniHomeHelperImpl$askShowGiftRewardDialog$1(friendUin, activity, context, reportInfo, null), 14, null);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public boolean askShowGuidanceDialog() {
        return ZPlanMiniHomeGuidanceDialog.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public aa createMiniHomeReporter() {
        return new aj();
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public ab createMiniHomeReporterV2() {
        return new ak();
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public int getHasCreatedMiniHome() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getInt(HAS_CREATE_MINI_HOME, -1);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public y getMiniHomeController(String uin, String uniqueKey, MiniHomeSceneEnum scene) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(scene, "scene");
        return a.f334316a.a(uin, uniqueKey, scene);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public ao getSaveRoomDesc(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        MiniHomeInfoObserver miniHomeInfoObserver = MiniHomeInfoObserver.f334284c;
        d e16 = miniHomeInfoObserver.e(uin);
        if (e16 == null) {
            e16 = miniHomeInfoObserver.f(uin);
        }
        MiniHomeInfo a16 = e16 != null ? ai.a(e16) : null;
        QLog.i(TAG, 1, "getSaveRoomDesc, cachedMiniHomeInfoRoomDesc: " + (a16 != null ? a16.getRoomDesc() : null));
        if (a16 != null) {
            return a16.getRoomDesc();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public String getStaticImagePath(String uin, MiniHomeSceneEnum scene, String roomHash) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(roomHash, "roomHash");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("save_image_key_" + scene.name() + "_" + QQTheme.isNowThemeIsNight() + "_" + uin + "_" + roomHash, "");
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public boolean getZPlanMiniHomeSettingSwitch(long uin) {
        boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1012L, uin);
        if (isZPlanAccessible && StudyModeManager.t()) {
            return false;
        }
        return isZPlanAccessible;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void releaseMiniHomeController() {
        a.f334316a.b();
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void requestMiniHomeInfoFromNet(String uin, WeakReference<IMiniHomeHelper.b> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.e(TAG, 1, "requestMiniHomeInfo");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        Intrinsics.checkNotNull(f16);
        CorountineFunKt.e(f16, "MiniHomeHelperImpl requestMiniHomeInfo", Boolean.FALSE, null, null, new MiniHomeHelperImpl$requestMiniHomeInfoFromNet$1(uin, callback, null), 12, null);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void requestSetZPlanMiniHomeSettingSwitch(final boolean value, final nk3.a callback) {
        String str;
        List<com.tencent.mobileqq.zplan.model.b> listOf;
        IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
        if (value) {
            str = "1";
        } else {
            str = "0";
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.mobileqq.zplan.model.b(25, 3, str));
        iZPlanRequest.requestOidb1123(listOf, 13, new nk3.a() { // from class: com.tencent.mobileqq.zplan.minihome.api.impl.b
            @Override // nk3.a
            public final void onResult(boolean z16) {
                MiniHomeHelperImpl.requestSetZPlanMiniHomeSettingSwitch$lambda$2(value, this, callback, z16);
            }
        }, 3000L);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void saveHasCreatedMiniHome(int value) {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt(HAS_CREATE_MINI_HOME, value);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void setStaticImagePath(String uin, MiniHomeSceneEnum scene, String imagePath, String roomHash) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(roomHash, "roomHash");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("save_image_key_" + scene.name() + "_" + QQTheme.isNowThemeIsNight() + "_" + uin + "_" + roomHash, imagePath);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void setTemporaryRoomDesc(String uin, ao value) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (value == null) {
            MiniHomeInfoObserver.f334284c.d(uin);
        }
        MiniHomeInfoObserver.f334284c.l(uin, value);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void showGuidanceDialog(Context context, String parentSource, GuidanceSource source, final IMiniHomeHelper.c callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new ZPlanMiniHomeGuidanceDialog(context, parentSource, source, ZPlanQQMC.INSTANCE.getMiniHomeGuidanceConfig(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.api.impl.MiniHomeHelperImpl$showGuidanceDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void invoke(boolean z16) {
                IMiniHomeHelper.c.this.onResult(z16);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }).show();
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void startCreateMiniHomePage(Context context, String uin, CreateMiniHomeSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.e(TAG, 1, "startCreateMiniHomePage");
        Intent intent = new Intent();
        intent.putExtra("uin", uin);
        intent.putExtra("source", source != null ? source.name() : null);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, CreateMiniHomeFragment.class);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void startCreateMiniHomePageForResult(Activity activity, String uin, int requestCode, CreateMiniHomeSource source) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.e(TAG, 1, "startCreateMiniHomePage");
        Intent intent = new Intent();
        intent.putExtra("uin", uin);
        intent.putExtra("source", source != null ? source.name() : null);
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) CreateMiniHomeFragment.class, requestCode);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void startEditMiniHomeFragment(Context context, String uin, String uniqueKey, String roomJson, EditMiniHomeSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(roomJson, "roomJson");
        Intent intent = new Intent();
        intent.putExtra("uin", uin);
        intent.putExtra("uniqueKey", uniqueKey);
        intent.putExtra("roomJson", roomJson);
        intent.putExtra("source", source != null ? source.name() : null);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, EditMiniHomeFragment.class);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper
    public void startEditMiniHomeFragmentForResult(Activity activity, int requestCode, Context context, String uin, String uniqueKey, String roomJson, EditMiniHomeSource source) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(roomJson, "roomJson");
        Intent intent = new Intent();
        intent.putExtra("uin", uin);
        intent.putExtra("uniqueKey", uniqueKey);
        intent.putExtra("roomJson", roomJson);
        intent.putExtra("source", source != null ? source.name() : null);
        if (context != null && !(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) EditMiniHomeFragment.class, requestCode);
    }
}
