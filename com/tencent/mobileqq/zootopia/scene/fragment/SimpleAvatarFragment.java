package com.tencent.mobileqq.zootopia.scene.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.c;
import com.tencent.mobileqq.zootopia.lua.ZootopiaReturnLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.scene.data.SceneComponentType;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment;
import com.tencent.mobileqq.zootopia.ue.ZootopiaUeModuleManager;
import com.tencent.mobileqq.zootopia.ue.d;
import com.tencent.mobileqq.zootopia.utils.n;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.scene.component.ComponentLoading;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;
import pd3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J&\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0012\u0010$\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zootopia/scene/fragment/SimpleAvatarFragment;", "Lcom/tencent/mobileqq/zootopia/scene/fragment/base/BaseAvatarFragment;", "Lod3/b;", "Lcom/tencent/mobileqq/zootopia/api/c;", "", "Xh", "()Ljava/lang/Integer;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "Zh", "Yh", "", "success", "engineInitFinish", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "engineDestroy", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "getSubSource", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Eh", "onBackPressedEvent", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "M2", "Landroid/view/KeyEvent;", "event", "J5", "Lcom/tencent/mobileqq/zootopia/ue/ZootopiaUeModuleManager;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/ue/ZootopiaUeModuleManager;", "moduleManager", "Lcom/tencent/mobileqq/zootopia/utils/n;", "T", "Lcom/tencent/mobileqq/zootopia/utils/n;", "zootopiaEngineHelper", "<init>", "()V", "U", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class SimpleAvatarFragment extends BaseAvatarFragment implements c {

    /* renamed from: S, reason: from kotlin metadata */
    private ZootopiaUeModuleManager moduleManager;

    /* renamed from: T, reason: from kotlin metadata */
    private n zootopiaEngineHelper = new n(1);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/scene/fragment/SimpleAvatarFragment$b", "Lpd3/a;", "", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, "", "b", "(Ljava/lang/Integer;I)V", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements a {
        b() {
        }

        @Override // pd3.a
        public void a(FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            SimpleAvatarFragment.this.hideLoadingView();
        }

        @Override // pd3.a
        public void b(Integer old, int r26) {
            SimpleAvatarFragment.this.showLoadingView();
        }

        @Override // pd3.a
        public void c() {
            a.C11005a.a(this);
        }
    }

    private final Integer Xh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return Integer.valueOf(arguments.getInt("subSceneType", -1));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public void Eh() {
        super.Eh();
        this.zootopiaEngineHelper.c();
    }

    @Override // com.tencent.mobileqq.zootopia.api.c
    public boolean J5(KeyEvent event) {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            return zootopiaUeModuleManager.d(event);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, od3.a
    public SceneInfo M2() {
        Intent intent;
        int intExtra;
        Intent intent2;
        Bundle arguments = getArguments();
        if (arguments != null) {
            intExtra = arguments.getInt("sceneType");
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                intExtra = intent.getIntExtra("sceneType", 0);
            } else {
                return Ph();
            }
        }
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("ueParams", null) : null;
        if (TextUtils.isEmpty(string)) {
            xb4.b bVar = xb4.b.f447772a;
            FragmentActivity activity2 = getActivity();
            JSONObject j3 = bVar.j((activity2 == null || (intent2 = activity2.getIntent()) == null) ? null : intent2.getExtras());
            string = j3 != null ? j3.toString() : null;
        }
        if (string == null) {
            string = "{}";
        }
        return new SceneInfo(intExtra, string);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.engineDestroy();
        }
        super.engineDestroy();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.engineInitFinish(success);
        }
        ar.f328509a.b(ZootopiaReturnLuaPlugin.INSTANCE.a());
        super.engineInitFinish(success);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        ZootopiaUeModuleManager.Companion companion = ZootopiaUeModuleManager.INSTANCE;
        Integer Xh = Xh();
        return companion.a(Xh != null ? Xh.intValue() : -1);
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        ZootopiaUeModuleManager zootopiaUeModuleManager;
        super.onCreate(savedInstanceState);
        Integer Xh = Xh();
        if (Xh != null) {
            this.moduleManager = new ZootopiaUeModuleManager(Xh.intValue(), null, 2, 0 == true ? 1 : 0);
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (zootopiaUeModuleManager = this.moduleManager) == null) {
            return;
        }
        zootopiaUeModuleManager.u9(activity, new d(Ch()));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        com.tencent.zplan.engine.service.d.f385635c.j();
        View inflate = inflater.inflate(R.layout.d9a, container, false);
        Zh((ViewGroup) inflate.findViewById(R.id.qz_));
        Yh((ViewGroup) inflate.findViewById(R.id.qz9));
        return inflate;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.destroy();
        }
        this.zootopiaEngineHelper.c();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.pause();
        }
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.resume();
        }
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        ZootopiaUeModuleManager zootopiaUeModuleManager = this.moduleManager;
        if (zootopiaUeModuleManager != null) {
            zootopiaUeModuleManager.serviceConnected(connect);
        }
        super.serviceConnected(connect);
    }

    private final void Yh(ViewGroup container) {
        if (container == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (!(activity instanceof FragmentActivity)) {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        ld3.c cVar = new ld3.c(false, 1, defaultConstructorMarker);
        Kh(SceneComponentType.TYPE_AVATAR, cVar);
        cVar.B6(this);
        cVar.Qf(new b());
        cVar.j(activity, this, this, container);
        cVar.a0(R.drawable.nzw);
    }

    private final void Zh(ViewGroup container) {
        if (container == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        AvatarEngineType avatarEngineType = null;
        byte b16 = 0;
        if (!(activity instanceof FragmentActivity)) {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        ComponentLoading componentLoading = new ComponentLoading(avatarEngineType, 1, b16 == true ? 1 : 0);
        Kh(SceneComponentType.TYPE_AVATAR_LOADING, componentLoading);
        componentLoading.j(activity, this, this, container);
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady()) {
            return;
        }
        componentLoading.show();
    }
}
