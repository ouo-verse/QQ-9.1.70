package md3;

import a84.a;
import android.view.Surface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.z1.lua.ZootopiaSceneLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.scene.component.base.FromLifeCycle;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zootopia.utils.n;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle;
import com.tencent.sqshow.zootopia.avatar.scene.IAvatarSceneApi;
import com.tencent.sqshow.zootopia.nativeui.data.e;
import com.tencent.sqshow.zootopia.recommend.main.tab.b;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tencent.zplan.world.view.d;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r94.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b.\b&\u0018\u0000 \u00132\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010A\u001a\u00020\u0005\u00a2\u0006\u0004\bv\u0010bJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0004J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0014J\"\u0010\u0019\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\"\u0010\u001a\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u00020\u000eH\u0016J\u0012\u00107\u001a\u00020\u00072\b\b\u0001\u00106\u001a\u000205H\u0014J\u0012\u00108\u001a\u00020\u00072\b\b\u0001\u00106\u001a\u000205H\u0014J\u0010\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016R\u0014\u0010A\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R$\u0010H\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010P\u001a\u0004\u0018\u00010I8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010W\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010]\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010c\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010@\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010i\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0016\u0010j\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010@R$\u0010p\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bk\u0010m\"\u0004\bn\u0010oR\"\u0010s\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010@\u001a\u0004\bq\u0010`\"\u0004\br\u0010bR\u0016\u0010u\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010t\u00a8\u0006w"}, d2 = {"Lmd3/a;", "Lwb4/a;", "La84/a;", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "Lcom/tencent/mobileqq/z1/lua/a;", "", "I", "", "L", "Ldy4/a;", "J", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", ParseCommon.CONTAINER, "e9", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "params", "needWaitEngineInit", "Q2", "O", "N", "Landroid/view/Surface;", "surface", "", "width", "height", "b", "a", "onSurfaceDestroyed", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "listener", "B6", "engineDestroy", "enginePurging", "enginePurged", "success", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "engineInitFinish", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "Lpd3/a;", "Qf", "W7", "G", "viewType", "onAvatarSceneChanged", "isEngineReady", "J7", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "g0", "I9", "", "from", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "hidden", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "r", h.F, "t", BdhLogUtil.LogTag.Tag_Conn, "Z", "needInitDress", "D", "Lpd3/a;", "getProxySceneChangeCallback", "()Lpd3/a;", "setProxySceneChangeCallback", "(Lpd3/a;)V", "proxySceneChangeCallback", "Lcom/tencent/zplan/world/view/d;", "E", "Lcom/tencent/zplan/world/view/d;", "getProxyTextureListener", "()Lcom/tencent/zplan/world/view/d;", "setProxyTextureListener", "(Lcom/tencent/zplan/world/view/d;)V", "proxyTextureListener", UserInfo.SEX_FEMALE, "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "getProxyEngineStatusListener", "()Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "setProxyEngineStatusListener", "(Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;)V", "proxyEngineStatusListener", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "getProxyWorldStatusListener", "()Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "setProxyWorldStatusListener", "(Lcom/tencent/zplan/world/IZPlanWorldStatusListener;)V", "proxyWorldStatusListener", "H", "getEngineInited", "()Z", "setEngineInited", "(Z)V", "engineInited", "Ljava/lang/Integer;", "getLastSceneType", "()Ljava/lang/Integer;", "setLastSceneType", "(Ljava/lang/Integer;)V", "lastSceneType", "renderNeedDestroy", "K", "Ldy4/a;", "()Ldy4/a;", BdhLogUtil.LogTag.Tag_Req, "(Ldy4/a;)V", "zplanRender", "M", "setHiddenState", "isHiddenState", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "avatarInitDataContainer", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a extends wb4.a implements a84.a, IZPlanWorldStatusListener, com.tencent.mobileqq.z1.lua.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean needInitDress;

    /* renamed from: D, reason: from kotlin metadata */
    private pd3.a proxySceneChangeCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private d proxyTextureListener;

    /* renamed from: F, reason: from kotlin metadata */
    private ZPlanEngineStatusUpdateListener proxyEngineStatusListener;

    /* renamed from: G, reason: from kotlin metadata */
    private IZPlanWorldStatusListener proxyWorldStatusListener;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean engineInited;

    /* renamed from: I, reason: from kotlin metadata */
    private Integer lastSceneType;

    /* renamed from: K, reason: from kotlin metadata */
    private dy4.a zplanRender;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isHiddenState;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean renderNeedDestroy = true;

    /* renamed from: M, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.d avatarInitDataContainer = e.f370980d;

    public a(boolean z16) {
        this.needInitDress = z16;
    }

    private final boolean I() {
        return b.f372639a.a();
    }

    private final void L() {
        if (this.renderNeedDestroy) {
            dy4.a aVar = this.zplanRender;
            if (aVar != null) {
                aVar.destroy();
            }
            this.renderNeedDestroy = false;
        }
    }

    @Override // a84.a
    public void B6(ZPlanEngineStatusUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.proxyEngineStatusListener = listener;
    }

    @Override // wb4.a
    public void G() {
        ZootopiaSceneLuaPlugin.INSTANCE.a().c(this);
        this.proxySceneChangeCallback = null;
        this.proxyTextureListener = null;
        this.proxyEngineStatusListener = null;
    }

    @Override // a84.a
    public SceneInfo I9() {
        return ((xe3.a) vb3.a.f441346a.b(xe3.a.class)).Q0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized dy4.a J() {
        dy4.a aVar;
        aVar = this.zplanRender;
        if (aVar == null) {
            com.tencent.zplan.world.manager.b bVar = com.tencent.zplan.world.manager.b.f386323a;
            FragmentActivity attachedActivity = getAttachedActivity();
            Intrinsics.checkNotNull(attachedActivity);
            aVar = com.tencent.zplan.world.manager.b.d(bVar, attachedActivity, false, 2, null);
            this.zplanRender = aVar;
        }
        return aVar;
    }

    @Override // a84.a
    public int J7() {
        return ((IAvatarSceneApi) QRoute.api(IAvatarSceneApi.class)).currentViewType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K, reason: from getter */
    public final dy4.a getZplanRender() {
        return this.zplanRender;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: M, reason: from getter */
    public final boolean getIsHiddenState() {
        return this.isHiddenState;
    }

    protected boolean N() {
        return false;
    }

    @Override // a84.a
    public void N0() {
        a.C0021a.j(this);
    }

    protected boolean O() {
        return false;
    }

    protected void P(@FromLifeCycle String from) {
        dy4.a aVar;
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("BaseZPlanPortalComponentAvatar", 1, "pauseTexture isResumed:" + getIsResumed() + ", isHiddenState:" + this.isHiddenState);
        if ((!getIsResumed() || this.isHiddenState) && (aVar = this.zplanRender) != null) {
            aVar.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q(@FromLifeCycle String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("BaseZPlanPortalComponentAvatar", 1, "resumeTexture isResumed:" + getIsResumed() + ", isHiddenState:" + this.isHiddenState);
        if (!getIsResumed() || this.isHiddenState) {
            return;
        }
        J().resume();
    }

    public void Q2(SceneInfo params, boolean needWaitEngineInit) {
        qu4.a x06;
        Intrinsics.checkNotNullParameter(params, "params");
        boolean mInitDataReady = this.avatarInitDataContainer.getMInitDataReady();
        QLog.d("BaseZPlanPortalComponentAvatar", 1, "enterAvatarScene:" + params + ", " + this.engineInited + ", avatarDataInit=" + mInitDataReady);
        if (this.engineInited && mInitDataReady) {
            dy4.a J = J();
            if (ZPlanFeatureSwitch.f369852a.N()) {
                this.lastSceneType = Integer.valueOf(J.getCom.tencent.mobileqq.zplan.scheme.ISchemeApi.KEY_SCENE_DATA java.lang.String().getFirstFrameSceneType());
            }
            Integer num = this.lastSceneType;
            boolean z16 = num == null || num.intValue() != params.getSceneType();
            if (z16) {
                QLog.i("BaseZPlanPortalComponentAvatar", 1, "scene change when enterAvatarScene");
                pd3.a aVar = this.proxySceneChangeCallback;
                if (aVar != null) {
                    aVar.b(this.lastSceneType, params.getSceneType());
                }
                this.lastSceneType = Integer.valueOf(params.getSceneType());
            }
            try {
                JSONObject jSONObject = new JSONObject(params.getJsonStr());
                if (!jSONObject.has("ViewType")) {
                    jSONObject.put("ViewType", params.getSceneType());
                }
                if (!jSONObject.has("NeedActiveHotPatchUpdate")) {
                    jSONObject.put("NeedActiveHotPatchUpdate", true);
                }
                jSONObject.put("youngMode", StudyModeManager.t());
                if (this.needInitDress && (x06 = this.avatarInitDataContainer.x0()) != null) {
                    jSONObject.put("InitDress", c.h(x06));
                }
                jSONObject.put("ShareAvatarShowLock", I() ? false : true);
                ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).onRealEnterAvatar(z16);
                n.INSTANCE.a(J, params.getSceneType(), jSONObject.toString(), this);
                if (O()) {
                    ((xe3.a) vb3.a.f441346a.b(xe3.a.class)).F0(params, N());
                }
            } catch (Throwable th5) {
                QLog.e("BaseZPlanPortalComponentAvatar", 1, "enterAvatarScene, error, ", th5);
            }
        }
    }

    @Override // a84.a
    public void Qf(pd3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.proxySceneChangeCallback = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R(dy4.a aVar) {
        this.zplanRender = aVar;
    }

    @Override // a84.a
    public void W7(IZPlanWorldStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.proxyWorldStatusListener = listener;
    }

    @Override // com.tencent.zplan.world.view.d
    public void a(Surface surface, int width, int height) {
        d dVar = this.proxyTextureListener;
        if (dVar != null) {
            dVar.a(surface, width, height);
        }
    }

    public void b(Surface surface, int width, int height) {
        QLog.i("BaseZPlanPortalComponentAvatar", 1, "onSurfaceTextureAvailable, height=" + height + ", width=" + width);
        d dVar = this.proxyTextureListener;
        if (dVar != null) {
            dVar.b(surface, width, height);
        }
    }

    @Override // a84.a
    public void e9(com.tencent.sqshow.zootopia.nativeui.data.d container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.avatarInitDataContainer = container;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        a.C0021a.c(this);
    }

    public void engineInitFinish(boolean success) {
        this.engineInited = success;
        QLog.i("BaseZPlanPortalComponentAvatar", 1, "engineInitFinish:" + success);
        ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = this.proxyEngineStatusListener;
        if (zPlanEngineStatusUpdateListener != null) {
            zPlanEngineStatusUpdateListener.engineInitFinish(success);
        }
        ar arVar = ar.f328509a;
        ZootopiaSceneLuaPlugin.Companion companion = ZootopiaSceneLuaPlugin.INSTANCE;
        arVar.b(companion.a());
        companion.a().b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        a.C0021a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        a.C0021a.h(this);
    }

    @Override // a84.a
    public AvatarEngineType g0() {
        return AvatarEngineType.UE;
    }

    @Override // wb4.a, od3.d
    public void h() {
        super.h();
        L();
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        a.C0021a.l(this, i3, str);
    }

    @Override // a84.a
    public boolean isEngineReady() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady();
    }

    @Override // wb4.a, od3.d
    public void m(boolean hidden) {
        this.isHiddenState = hidden;
        if (hidden) {
            P(FromLifeCycle.HIDDEN_CHANGE);
        } else {
            Q(FromLifeCycle.HIDDEN_CHANGE);
        }
    }

    @Override // a84.a
    public b94.a m8() {
        return a.C0021a.k(this);
    }

    @Override // com.tencent.mobileqq.z1.lua.a
    public void onAvatarSceneChanged(int viewType) {
        QLog.i("BaseZPlanPortalComponentAvatar", 1, "onAvatarSceneChanged:" + viewType);
        if (this.engineInited) {
            this.lastSceneType = Integer.valueOf(viewType);
        }
    }

    @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onEnterSceneResult(boolean success) {
        IZPlanWorldStatusListener iZPlanWorldStatusListener = this.proxyWorldStatusListener;
        if (iZPlanWorldStatusListener != null) {
            iZPlanWorldStatusListener.onEnterSceneResult(success);
        }
    }

    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ((IAvatarSceneApi) QRoute.api(IAvatarSceneApi.class)).enterFirstFrame(result.getCurType());
        QLog.i("BaseZPlanPortalComponentAvatar", 2, "engineFirstFrame, curType: " + result.getCurType());
        IZPlanWorldStatusListener iZPlanWorldStatusListener = this.proxyWorldStatusListener;
        if (iZPlanWorldStatusListener != null) {
            iZPlanWorldStatusListener.onFirstFrame(result);
        }
        ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = this.proxyEngineStatusListener;
        if (zPlanEngineStatusUpdateListener != null) {
            zPlanEngineStatusUpdateListener.engineFirstFrame();
        }
        pd3.a aVar = this.proxySceneChangeCallback;
        if (aVar != null) {
            aVar.a(result);
        }
    }

    @Override // a84.a
    public void q0(com.tencent.sqshow.zootopia.scene.component.d dVar) {
        a.C0021a.a(this, dVar);
    }

    @Override // wb4.a, od3.d
    public void r() {
        super.r();
        P("resume");
    }

    @Override // wb4.a, od3.d
    public void t() {
        super.t();
        L();
    }

    @Override // wb4.a, od3.d
    public void y() {
        super.y();
        Q("resume");
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        QLog.i("BaseZPlanPortalComponentAvatar", 2, "engineDestroy");
        ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = this.proxyEngineStatusListener;
        if (zPlanEngineStatusUpdateListener != null) {
            zPlanEngineStatusUpdateListener.engineDestroy();
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        QLog.i("BaseZPlanPortalComponentAvatar", 2, "enginePurged");
        ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = this.proxyEngineStatusListener;
        if (zPlanEngineStatusUpdateListener != null) {
            zPlanEngineStatusUpdateListener.enginePurged();
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        QLog.i("BaseZPlanPortalComponentAvatar", 2, "enginePurging");
        ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = this.proxyEngineStatusListener;
        if (zPlanEngineStatusUpdateListener != null) {
            zPlanEngineStatusUpdateListener.enginePurging();
        }
    }

    @Override // com.tencent.zplan.world.view.d
    public void onSurfaceDestroyed(Surface surface) {
        QLog.i("BaseZPlanPortalComponentAvatar", 1, "onSurfaceTextureDestroyed");
        d dVar = this.proxyTextureListener;
        if (dVar != null) {
            dVar.onSurfaceDestroyed(surface);
        }
    }

    public void serviceConnected(boolean connect) {
        if (!connect) {
            this.engineInited = false;
        }
        QLog.i("BaseZPlanPortalComponentAvatar", 1, "serviceConnected:" + connect);
        ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = this.proxyEngineStatusListener;
        if (zPlanEngineStatusUpdateListener != null) {
            zPlanEngineStatusUpdateListener.serviceConnected(connect);
        }
    }
}
