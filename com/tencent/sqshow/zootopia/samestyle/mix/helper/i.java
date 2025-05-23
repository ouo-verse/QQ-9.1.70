package com.tencent.sqshow.zootopia.samestyle.mix.helper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.epicgames.ue4.GameActivityThunk;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.lua.ZPlanSameStyleProgress;
import com.tencent.mobileqq.zootopia.lua.y;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.samestyle.data.ZPlanTemplateFixedRoleConfig;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import dy4.a;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001B\b\u0000\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u000f\u0012\u0006\u0010#\u001a\u00020!\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010+R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010$R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u0010=\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b'\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006I"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/i;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/d;", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "Lcom/tencent/mobileqq/zootopia/lua/c;", "", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", BdhLogUtil.LogTag.Tag_Conn, "", ReportConstant.COSTREPORT_PREFIX, "I", "H", "Lcom/tencent/mobileqq/zootopia/lua/x;", "progress", "u", "D", "w", "r", "", "path", "y", "l", "k", "i", "G", "v", "t", "(Ljava/lang/String;)Z", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "a", "Lsb4/a;", "Lsb4/a;", "previewPage", "Z", "mIsEngineInitFlag", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "mTextureView", "Ldy4/a;", "Ldy4/a;", "mZPlanRender", "mUEResumed", "Ljava/lang/String;", "mPendingPakPath", "", "J", "mMixStartTime", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "K", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "mEnterParams", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/t;", "L", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/t;", "getMMixListener", "()Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/t;", "(Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/t;)V", "mMixListener", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "M", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "mEngineInitListener", "com/tencent/sqshow/zootopia/samestyle/mix/helper/i$b", "N", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/i$b;", "mTextureViewListener", "<init>", "(Lsb4/a;)V", "P", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i extends d implements IZPlanWorldStatusListener, com.tencent.mobileqq.zootopia.lua.c {

    /* renamed from: D, reason: from kotlin metadata */
    private final sb4.a previewPage;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsEngineInitFlag;

    /* renamed from: F, reason: from kotlin metadata */
    private View mTextureView;

    /* renamed from: G, reason: from kotlin metadata */
    private dy4.a mZPlanRender;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mUEResumed;

    /* renamed from: I, reason: from kotlin metadata */
    private String mPendingPakPath;

    /* renamed from: J, reason: from kotlin metadata */
    private long mMixStartTime;

    /* renamed from: K, reason: from kotlin metadata */
    private SceneInfo mEnterParams;

    /* renamed from: L, reason: from kotlin metadata */
    private t mMixListener;

    /* renamed from: M, reason: from kotlin metadata */
    private final GameActivityThunk.CMShowEngineInitFinishListener mEngineInitListener;

    /* renamed from: N, reason: from kotlin metadata */
    private final b mTextureViewListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/mix/helper/i$b", "Lcom/tencent/zplan/world/view/d;", "Landroid/view/Surface;", "surface", "", "width", "height", "", "b", "a", "onSurfaceDestroyed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.zplan.world.view.d {
        b() {
        }

        @Override // com.tencent.zplan.world.view.d
        public void a(Surface surface, int width, int height) {
            QLog.i("PreviewEngineHelper_", 1, "onSurfaceChanged, width = " + width + ", height = " + height);
        }

        @Override // com.tencent.zplan.world.view.d
        public void b(Surface surface, int width, int height) {
            QLog.i("PreviewEngineHelper_", 1, "onSurfaceCreate, width = " + width + ", height = " + height);
        }

        @Override // com.tencent.zplan.world.view.d
        public void onSurfaceDestroyed(Surface surface) {
            QLog.i("PreviewEngineHelper_", 1, "surfaceTextureDestroyed");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(sb4.a previewPage) {
        super(previewPage.getF372926a(), previewPage.getF372927b(), previewPage.getF372928c(), previewPage.getF372929d(), previewPage.b(), previewPage.getLifecycleOwner(), previewPage.getSource());
        Intrinsics.checkNotNullParameter(previewPage, "previewPage");
        this.previewPage = previewPage;
        this.mPendingPakPath = "";
        this.mEnterParams = SceneInfo.INSTANCE.c();
        this.mEngineInitListener = new GameActivityThunk.CMShowEngineInitFinishListener() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.f
            @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
            public final void onEngineInitFinish(boolean z16) {
                i.z(i.this, z16);
            }
        };
        this.mTextureViewListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y(this$0.mPendingPakPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(i this$0, ZPlanSameStyleProgress progress) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(progress, "$progress");
        this$0.u(progress);
    }

    private final void C() {
        dy4.a aVar;
        I();
        if (this.mUEResumed) {
            boolean z16 = false;
            this.mUEResumed = false;
            dy4.a aVar2 = this.mZPlanRender;
            if (aVar2 != null) {
                aVar2.a(false);
            }
            Activity activity = this.previewPage.getActivity();
            if (activity != null && !activity.isFinishing()) {
                z16 = true;
            }
            if (z16) {
                dy4.a aVar3 = this.mZPlanRender;
                if (aVar3 != null) {
                    aVar3.pause();
                }
            } else if (s() && (aVar = this.mZPlanRender) != null) {
                aVar.pause();
            }
            QLog.i("PreviewEngineHelper_", 1, "ue paused");
        }
    }

    private final void D() {
        long currentTimeMillis = System.currentTimeMillis() - this.mMixStartTime;
        HashMap hashMap = new HashMap();
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(this.previewPage.getSource()));
        hashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(getMTemplate().getId()));
        hashMap.put("zplan_samestyle_type", Integer.valueOf(getMTemplate().getContentType()));
        hashMap.put("zplan_loading_lvtm", Long.valueOf(currentTimeMillis));
        this.previewPage.b().d("ev_zplan_outfit_samestyle_loading_success", hashMap);
    }

    private final void E() {
        if (this.mTextureView == null || this.mUEResumed) {
            return;
        }
        QLog.i("PreviewEngineHelper_", 1, "ue resumed");
        this.mUEResumed = true;
        dy4.a aVar = this.mZPlanRender;
        if (aVar != null) {
            aVar.resume();
        }
        dy4.a aVar2 = this.mZPlanRender;
        if (aVar2 != null) {
            aVar2.a(true);
        }
    }

    private final void H() {
        SceneInfo sceneInfo = this.mEnterParams;
        QLog.i("PreviewEngineHelper_", 1, "trulyEnter params:" + sceneInfo);
        if (!sceneInfo.n()) {
            QLog.e("PreviewEngineHelper_", 1, "trulyEnter bad params");
            return;
        }
        dy4.a aVar = this.mZPlanRender;
        if (aVar != null) {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).enterAvatarScene(aVar, sceneInfo.getSceneType(), sceneInfo.getJsonStr(), this);
        }
    }

    private final void I() {
        Activity activity = this.previewPage.getActivity();
        if (activity != null ? activity.isFinishing() : true) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("SameStyleID", getMTemplate().getId());
            ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            zPlanLuaBridge.callLua("N2L_SameStyleMixCancel", jSONObject2, (a.b) null);
        }
    }

    private final void q() {
        if (this.mIsEngineInitFlag && this.mTextureView == null) {
            QLog.i("PreviewEngineHelper_", 1, "real add texture view");
            dy4.a d16 = com.tencent.zplan.world.manager.b.d(com.tencent.zplan.world.manager.b.f386323a, getMContext(), false, 2, null);
            this.mZPlanRender = d16;
            this.mTextureView = d16 != null ? a.C10207a.a(d16, this.previewPage.getActivity(), getMContext(), true, false, false, 24, null) : null;
            dy4.a aVar = this.mZPlanRender;
            if (aVar != null) {
                aVar.setRenderListener(this.mTextureViewListener);
            }
            getMBinding().f419265t.removeAllViews();
            getMBinding().f419265t.addView(this.mTextureView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private final boolean s() {
        int activeSceneCounter = ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).getActiveSceneCounter();
        QLog.i("PreviewEngineHelper_", 1, "tryPauseEngine activeSceneCounter:" + activeSceneCounter);
        return activeSceneCounter < 1;
    }

    private final void u(ZPlanSameStyleProgress progress) {
        QLog.i("PreviewEngineHelper_", 1, "handleMixProgress progress:" + progress + ", selfId:" + getMTemplate().getId());
        if (!(progress.getMSameStyleID() == getMTemplate().getId())) {
            QLog.e("PreviewEngineHelper_", 1, "handleMixProgress is not same Template");
            return;
        }
        int mMixState = progress.getMMixState();
        if (mMixState == 1) {
            QLog.i("PreviewEngineHelper_", 1, "handleMixProgress STATE_MIXING");
            t tVar = this.mMixListener;
            if (tVar != null) {
                tVar.ef(progress);
                return;
            }
            return;
        }
        if (mMixState == 2) {
            QLog.i("PreviewEngineHelper_", 1, "handleMixProgress STATE_MIX_SUCCEED");
            t tVar2 = this.mMixListener;
            if (tVar2 != null) {
                tVar2.fg(progress);
            }
            D();
            return;
        }
        if (mMixState == 3) {
            QLog.e("PreviewEngineHelper_", 1, "handleMixProgress STATE_MIX_FAILED");
            t tVar3 = this.mMixListener;
            if (tVar3 != null) {
                tVar3.X1(progress);
                return;
            }
            return;
        }
        if (mMixState != 4) {
            QLog.i("PreviewEngineHelper_", 1, "handleMixProgress state: " + progress.getMMixState());
            return;
        }
        QLog.i("PreviewEngineHelper_", 1, "handleMixProgress STATE_MIX_CANCEL");
        t tVar4 = this.mMixListener;
        if (tVar4 != null) {
            tVar4.o9(progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(final i this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("PreviewEngineHelper_", 1, "zplan engine init finish success = " + z16 + ", mPendingPakPath:" + this$0.mPendingPakPath);
        this$0.mIsEngineInitFlag = z16;
        if (this$0.mPendingPakPath.length() > 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.A(i.this);
                }
            });
        }
    }

    public final void F(t tVar) {
        this.mMixListener = tVar;
    }

    public final void G() {
        View view = this.mTextureView;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        getMBinding().f419266u.addView(view, new FrameLayout.LayoutParams(-1, -1));
        getMBinding().f419266u.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.zootopia.lua.c
    public void a(final ZPlanSameStyleProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.g
            @Override // java.lang.Runnable
            public final void run() {
                i.B(i.this, progress);
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void i() {
        super.i();
        y.f328583e.c(this);
        com.tencent.zplan.engine.service.c.INSTANCE.b(this.mEngineInitListener);
        QRouteApi api = QRoute.api(IZPlanApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
        IZPlanApi.b.a((IZPlanApi) api, "PreviewEngineHelper_", false, 20, 2, null);
        this.mMixListener = null;
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void k() {
        C();
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void l() {
        E();
    }

    @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onEnterSceneResult(boolean z16) {
        IZPlanWorldStatusListener.a.a(this, z16);
    }

    @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i("PreviewEngineHelper_", 1, "onFirstFrame result:" + result);
        t tVar = this.mMixListener;
        if (tVar != null) {
            tVar.onFirstFrame(result);
        }
    }

    public final void r() {
        this.mMixStartTime = System.currentTimeMillis();
    }

    public final boolean t(String path) {
        int i3;
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            if (getMSource().getMainSource() == Source.Emoticon) {
                ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplication.getContext());
                i3 = 1;
            } else {
                i3 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ViewType", 20);
            jSONObject.put("SameStyleID", getMTemplate().getId());
            jSONObject.put("TemplateTab", this.previewPage.a());
            jSONObject.put("SameStyleName", getMTemplate().getName());
            jSONObject.put("ContentType", getMTemplate().getShowVideo() ? 1 : 0);
            jSONObject.put("SameStylePath", path);
            jSONObject.put("Source", ah.b(getMSource()));
            Bundle arguments = this.previewPage.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("extra_fixed_role") : null;
            ZPlanTemplateFixedRoleConfig zPlanTemplateFixedRoleConfig = serializable instanceof ZPlanTemplateFixedRoleConfig ? (ZPlanTemplateFixedRoleConfig) serializable : null;
            if (zPlanTemplateFixedRoleConfig != null) {
                jSONObject.put("FixedRole", zPlanTemplateFixedRoleConfig.getFixedFlag());
                jSONObject.put("MasterUin", zPlanTemplateFixedRoleConfig.getMasterUin());
                jSONObject.put("GuestUin", zPlanTemplateFixedRoleConfig.getGuestUin());
                jSONObject.put("MasterNickname", zPlanTemplateFixedRoleConfig.getMasterNickName());
                jSONObject.put("GuestNickname", w.f373306a.a());
            }
            jSONObject.put("SameStyleMode", i3);
            jSONObject.put("SetDeviceProfile", getMTemplate().isDowngrade());
            jSONObject.put("AutoGenerate", "true");
            jSONObject.put("NeedProgressAndState", "true");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
            QLog.i("PreviewEngineHelper_", 1, "enterAvatarScene with params: " + jSONObject2);
            this.mEnterParams = new SceneInfo(20, jSONObject2);
            H();
            return true;
        } catch (Exception e16) {
            QLog.e("PreviewEngineHelper_", 1, e16, new Object[0]);
            return false;
        }
    }

    public final void v() {
        View view = this.mTextureView;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        getMBinding().f419265t.addView(view, new FrameLayout.LayoutParams(-1, -1));
        getMBinding().f419266u.setVisibility(8);
    }

    public void w() {
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).previewEngineHelperStartEngine("template_preview");
        x();
        q();
        y.f328583e.b(this);
    }

    public final void y(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.i("PreviewEngineHelper_", 1, "loadTemplatePak path:" + path + ", mUEResumed:" + this.mUEResumed);
        q();
        if (this.mUEResumed) {
            t(path);
            return;
        }
        this.mPendingPakPath = path;
        E();
        if (this.mUEResumed) {
            if (this.mPendingPakPath.length() > 0) {
                t(this.mPendingPakPath);
                this.mPendingPakPath = "";
            }
        }
    }

    private final void x() {
        QLog.i("PreviewEngineHelper_", 1, "init zplan engine");
        com.tencent.zplan.engine.service.c.INSTANCE.a(this.mEngineInitListener);
    }
}
