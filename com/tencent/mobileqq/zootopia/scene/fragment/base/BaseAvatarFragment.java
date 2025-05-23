package com.tencent.mobileqq.zootopia.scene.fragment.base;

import a84.a;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.scene.data.SceneComponentType;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.nativeui.data.n;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import od3.a;
import od3.b;
import od3.c;
import org.json.JSONObject;
import uv4.ak;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0018H\u0014J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010!\u001a\u00020\u000bH\u0004J\b\u0010#\u001a\u00020\"H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\"H\u0004J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0018H\u0016J\b\u0010(\u001a\u00020\u000bH\u0004J\b\u0010)\u001a\u00020\u000bH\u0004J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0018H\u0016R&\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\"\u0010:\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010>\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/zootopia/scene/fragment/base/BaseAvatarFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Lod3/b;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "Lod3/a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/n;", "Lcom/tencent/mobileqq/zootopia/scene/data/SceneComponentType;", "type", "Lod3/c;", HippyQQConstants.URL_COMPONENT_NAME, "", "Kh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", "Luv4/ak;", "avatarData", "c7", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Eh", "", "hidden", "onHiddenChanged", NodeProps.VISIBLE, "Fh", "", "from", "Uh", "Mh", "Lh", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "M2", "Oh", "Ph", "success", "engineInitFinish", "hideLoadingView", "showLoadingView", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "onEnterSceneResult", "Ljava/util/concurrent/ConcurrentHashMap;", "N", "Ljava/util/concurrent/ConcurrentHashMap;", "getComponentMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "componentMap", "P", "Z", "Sh", "()Z", "setResumedState", "(Z)V", "isResumedState", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Rh", "setHiddenState", "isHiddenState", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class BaseAvatarFragment extends ZootopiaBaseFragment implements b, ZPlanEngineStatusUpdateListener, IZPlanWorldStatusListener, a, n {

    /* renamed from: N, reason: from kotlin metadata */
    private final ConcurrentHashMap<SceneComponentType, c> componentMap = new ConcurrentHashMap<>();

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isResumedState;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isHiddenState;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(BaseAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("BaseZPlanPortalFragment", 1, "engineInitFinish success, isResumedState:" + this$0.isResumedState + ", isHiddenState:" + this$0.isHiddenState);
        this$0.Uh(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(BaseAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c Oh = this$0.Oh(SceneComponentType.TYPE_AVATAR_LOADING);
        if (Oh != null) {
            c.a.a(Oh, 0L, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(BaseAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c Oh = this$0.Oh(SceneComponentType.TYPE_AVATAR_LOADING);
        if (Oh != null) {
            Oh.show();
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public void Eh() {
        super.Eh();
        for (Map.Entry<SceneComponentType, c> entry : this.componentMap.entrySet()) {
            entry.getValue().t();
            entry.getValue().destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public void Fh(boolean visible) {
        super.Fh(visible);
        Iterator<Map.Entry<SceneComponentType, c>> it = this.componentMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onWindowFocusChanged(visible);
        }
    }

    public void Kh(SceneComponentType type, c component) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(component, "component");
        this.componentMap.put(type, component);
    }

    protected final void Lh() {
        boolean z16 = getResources().getConfiguration().orientation == 1;
        c Oh = Oh(SceneComponentType.TYPE_AVATAR);
        a84.a aVar = Oh instanceof a84.a ? (a84.a) Oh : null;
        vc3.c.f441386a.b(z16, aVar != null ? aVar.getZplanTextureView() : null);
    }

    public SceneInfo M2() {
        return Ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mh(int from) {
        c Oh = Oh(SceneComponentType.TYPE_AVATAR);
        a84.a aVar = Oh instanceof a84.a ? (a84.a) Oh : null;
        if (aVar != null) {
            a.C0021a.i(aVar, M2(), false, 2, null);
        }
    }

    public c Oh(SceneComponentType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.componentMap.get(type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SceneInfo Ph() {
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ViewType", 1);
            String jSONObject2 = jSONObject.toString();
            if (jSONObject2 != null) {
                str = jSONObject2;
            }
        } catch (Throwable th5) {
            QLog.e("BaseZPlanPortalFragment", 1, "jsonParams error, ", th5);
        }
        return new SceneInfo(1, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Rh, reason: from getter */
    public final boolean getIsHiddenState() {
        return this.isHiddenState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Sh, reason: from getter */
    public final boolean getIsResumedState() {
        return this.isResumedState;
    }

    public void Uh(int from) {
        if (!this.isResumedState || this.isHiddenState) {
            return;
        }
        Mh(from);
        Lh();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.n
    public void c7(ak avatarData) {
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        Uh(4);
    }

    public void engineDestroy() {
        ZPlanEngineStatusUpdateListener.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        ZPlanEngineStatusUpdateListener.a.b(this);
    }

    public void engineInitFinish(boolean success) {
        QLog.i("BaseZPlanPortalFragment", 1, "engineInitFinish success\uff1a" + success);
        if (success) {
            ar.f328509a.b(com.tencent.zplan.luabridge.plugins.a.f385727e);
            Runnable runnable = new Runnable() { // from class: nd3.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseAvatarFragment.Nh(BaseAvatarFragment.this);
                }
            };
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                runnable.run();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(runnable);
            }
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        ZPlanEngineStatusUpdateListener.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        ZPlanEngineStatusUpdateListener.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        ZPlanEngineStatusUpdateListener.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        ZPlanEngineStatusUpdateListener.a.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hideLoadingView() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nd3.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseAvatarFragment.Qh(BaseAvatarFragment.this);
            }
        });
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.E(this);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        for (Map.Entry<SceneComponentType, c> entry : this.componentMap.entrySet()) {
            entry.getValue().h();
            entry.getValue().destroy();
        }
        this.componentMap.clear();
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.H(this);
    }

    @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.isHiddenState = hidden;
        Iterator<Map.Entry<SceneComponentType, c>> it = this.componentMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().m(hidden);
        }
        Uh(2);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isResumedState = false;
        Iterator<Map.Entry<SceneComponentType, c>> it = this.componentMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().r();
        }
        Uh(2);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isResumedState = true;
        Iterator<Map.Entry<SceneComponentType, c>> it = this.componentMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().y();
        }
        Uh(2);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Iterator<Map.Entry<SceneComponentType, c>> it = this.componentMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().i();
        }
    }

    public void serviceConnected(boolean z16) {
        ZPlanEngineStatusUpdateListener.a.i(this, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void showLoadingView() {
        QLog.i("BaseZPlanPortalFragment", 1, "showLoadingView ", new StackPrinter("showLoadingView"));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nd3.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseAvatarFragment.Th(BaseAvatarFragment.this);
            }
        });
    }

    @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onEnterSceneResult(boolean success) {
    }
}
