package com.tencent.mobileqq.zootopia.scene.fragment.base;

import a84.a;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.d;
import com.tencent.mobileqq.zootopia.lua.ZootopiaCleanSceneDataPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaReturnLuaPlugin;
import com.tencent.mobileqq.zootopia.scene.data.SceneComponentType;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import od3.c;
import xk3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0014J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\u0004H\u0014J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016J\u0016\u0010&\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0$H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0014J\b\u0010(\u001a\u00020\u001cH&J\u0011\u0010)\u001a\u0004\u0018\u00010\u0006H&\u00a2\u0006\u0004\b)\u0010*J\u0011\u0010+\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b+\u0010,J\b\u0010-\u001a\u00020\u001cH&J\u0010\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0004J\b\u00102\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020\rH\u0016J\b\u00104\u001a\u00020\rH\u0016J\b\u00105\u001a\u00020\u001cH\u0016R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/zootopia/scene/fragment/base/BaseAvatarWithLoadingFragment;", "Lcom/tencent/mobileqq/zootopia/scene/fragment/base/BaseAvatarFragment;", "Lcom/tencent/mobileqq/zootopia/api/d;", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaCleanSceneDataPlugin$b;", "", "isEngineReady", "", "Yh", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "g0", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "ci", "from", "", "Wh", "hi", "Uh", "Xh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "errorCode", "", "errorMessage", "hotPatchDownloadFailed", "enginePurged", "enginePurging", "rh", "engineDestroy", "Vd", "", "keyList", "u8", "Mh", "di", "bi", "()Ljava/lang/Integer;", "fi", "()Ljava/lang/Boolean;", "getPageId", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "gi", "ai", "beforeFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "ei", ExifInterface.LATITUDE_SOUTH, "Z", "mServiceConnected", "T", "mSelfAlreadyFirstFrame", "Ljava/lang/Runnable;", "U", "Ljava/lang/Runnable;", "delayShowLoadingTask", "<init>", "()V", "V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class BaseAvatarWithLoadingFragment extends BaseAvatarFragment implements d, ZootopiaCleanSceneDataPlugin.b {

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mServiceConnected;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mSelfAlreadyFirstFrame;

    /* renamed from: U, reason: from kotlin metadata */
    private final Runnable delayShowLoadingTask = new Runnable() { // from class: nd3.d
        @Override // java.lang.Runnable
        public final void run() {
            BaseAvatarWithLoadingFragment.Zh(BaseAvatarWithLoadingFragment.this);
        }
    };

    private final void Wh(int from) {
        g0();
        boolean isEngineReady = isEngineReady();
        int Yh = Yh();
        SceneInfo ci5 = ci();
        SceneInfo M2 = M2();
        Integer bi5 = bi();
        boolean z16 = bi5 == null || Yh != bi5.intValue();
        boolean z17 = !ci5.m(M2);
        Boolean fi5 = fi();
        boolean booleanValue = fi5 != null ? fi5.booleanValue() : true;
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "doEnterScene curViewType:" + Yh + ", mySceneInfo:" + M2 + ", lastSceneInfo:" + ci5 + ", viewTypeChanged:" + z16 + ", sceneInfoChanged:" + z17 + ", isEngineReady:" + isEngineReady + ", isLoadingShowing:" + booleanValue);
        if (!booleanValue && !z16 && !z17 && isEngineReady) {
            QLog.i("BaseAvatarWithLoadingFragment_", 1, "same scene, enter task passed!");
            return;
        }
        ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).onLoadingStart(di(), getPageId(), ah.b(Ch()), ei());
        hi();
        super.Mh(from);
    }

    private final int Yh() {
        c Oh = Oh(SceneComponentType.TYPE_AVATAR);
        a aVar = Oh instanceof a ? (a) Oh : null;
        if (aVar == null) {
            return 0;
        }
        return aVar.J7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(BaseAvatarWithLoadingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "delayShowLoadingTask running");
        this$0.showLoadingView();
    }

    private final SceneInfo ci() {
        c Oh = Oh(SceneComponentType.TYPE_AVATAR);
        a aVar = Oh instanceof a ? (a) Oh : null;
        if (aVar == null) {
            return SceneInfo.INSTANCE.c();
        }
        return aVar.I9();
    }

    private final AvatarEngineType g0() {
        c Oh = Oh(SceneComponentType.TYPE_AVATAR);
        a aVar = Oh instanceof a ? (a) Oh : null;
        if (aVar == null) {
            return AvatarEngineType.UE;
        }
        return aVar.g0();
    }

    private final void hi() {
        long m16 = FilamentApiImpl.f369933a.d() ? ZPlanFeatureSwitch.f369852a.m1() : 1000L;
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.delayShowLoadingTask, m16);
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "scheduleLoadingShowTask delayShowLoadingTask schedule, delayDuration=" + m16);
    }

    private final boolean isEngineReady() {
        c Oh = Oh(SceneComponentType.TYPE_AVATAR);
        a aVar = Oh instanceof a ? (a) Oh : null;
        if (aVar == null) {
            return false;
        }
        return aVar.isEngineReady();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment
    public void Mh(int from) {
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "doEnterScene from:" + from);
        if (from != 1) {
            if (from != 2) {
                if (from != 3) {
                    if (from != 4 && from != 5) {
                        return;
                    }
                }
            }
            if (!this.mSelfAlreadyFirstFrame) {
                QLog.i("BaseAvatarWithLoadingFragment_", 1, "doEnterScene mSelfAlreadyFirstFrame is false, do enter");
                ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).onLoadingStart(di(), getPageId(), ah.b(Ch()), ei());
                hi();
                super.Mh(from);
                return;
            }
            Wh(from);
            return;
        }
        ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).onLoadingStart(di(), getPageId(), ah.b(Ch()), ei());
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "doEnterScene FORCE_RELOAD or ENGINE_INIT, do enter");
        hi();
        super.Mh(from);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment
    public void Uh(int from) {
        boolean a16 = com.tencent.mobileqq.zplan.utils.a.f335750a.a();
        FragmentActivity activity = getActivity();
        boolean c16 = activity != null ? b.f448110a.c(activity) : false;
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "doOnVisibilityChange isAppForeground:" + a16 + ", isHiddenState:" + getIsHiddenState() + ", isResumedState:" + getIsResumedState() + ", ac:" + activity + ", isTopEngineActivity:" + c16);
        if (a16 && c16) {
            super.Uh(from);
        }
        Xh();
    }

    @Override // com.tencent.mobileqq.zootopia.api.d
    public void Vd() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xh() {
        Context context = getContext();
        boolean z16 = this.mServiceConnected;
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "checkIfNeedLoading mServiceConnected:" + z16 + ", mServiceConnected:" + z16 + ", isHiddenState:" + getIsHiddenState() + ", resumed:" + getIsResumedState() + " ctx=" + context);
        if (this.mServiceConnected || context == null || getIsHiddenState() || !getIsResumedState()) {
            return;
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startEngineWhenNotReady(null, "zootopia_loadingFragment");
        showLoadingView();
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).clearLoadingStartInfo(ei());
    }

    public abstract Integer bi();

    public abstract String di();

    public String ei() {
        return String.valueOf(this);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        super.engineDestroy();
        this.mServiceConnected = false;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        super.enginePurged();
        this.mSelfAlreadyFirstFrame = false;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        super.enginePurging();
        this.mSelfAlreadyFirstFrame = false;
    }

    public abstract Boolean fi();

    public abstract String getPageId();

    protected final boolean gi(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int curType = result.getCurType();
        String params = result.getParams();
        if (params == null) {
            params = "";
        }
        SceneInfo sceneInfo = new SceneInfo(curType, params);
        SceneInfo M2 = M2();
        boolean m3 = sceneInfo.m(M2);
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "isSameScene, isSame:" + m3 + ", firstFrameScene:" + sceneInfo + ", selfScene:" + M2);
        return m3;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        super.hotPatchDownloadFailed(errorCode, errorMessage);
        QLog.e("BaseAvatarWithLoadingFragment_", 1, "hotPatchDownloadFailed :" + errorCode + " - " + errorMessage);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).clearLoadingStartInfo(ei());
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        super.onFirstFrame(result);
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "onFirstFrame, result:" + result);
        boolean gi5 = gi(result);
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "onFirstFrame, isSame:" + gi5);
        if (gi5) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.delayShowLoadingTask);
            hideLoadingView();
            this.mSelfAlreadyFirstFrame = true;
            ai();
        }
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ZootopiaReturnLuaPlugin.INSTANCE.a().c(this);
        ZootopiaCleanSceneDataPlugin.INSTANCE.a().c(this);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ZootopiaReturnLuaPlugin.INSTANCE.a().b(this);
        ZootopiaCleanSceneDataPlugin.INSTANCE.a().b(this);
        Xh();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (FilamentApiImpl.f369933a.d()) {
            return;
        }
        ed3.a.f396118a.b();
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment
    protected boolean rh() {
        return true;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        super.serviceConnected(connect);
        QLog.i("BaseAvatarWithLoadingFragment_", 1, "serviceConnected connect:" + connect);
        this.mServiceConnected = connect;
        if (!connect) {
            this.mSelfAlreadyFirstFrame = false;
        }
        Xh();
    }

    @Override // com.tencent.mobileqq.zootopia.lua.ZootopiaCleanSceneDataPlugin.b
    public void u8(List<String> keyList) {
        Intrinsics.checkNotNullParameter(keyList, "keyList");
    }

    public void ai() {
    }
}
