package com.tencent.mobileqq.zplan.avatar.impl.fragment;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.avatar.c;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarMallHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "", "wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/a;", "avatarHippyApi", "<init>", "(Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/a;)V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarMallHippyFragment extends CommonHippyFragment implements com.tencent.sqshow.zootopia.avatar.c {

    /* renamed from: C, reason: from kotlin metadata */
    private final a avatarHippyApi;

    public ZPlanAvatarMallHippyFragment(a avatarHippyApi) {
        Intrinsics.checkNotNullParameter(avatarHippyApi, "avatarHippyApi");
        this.avatarHippyApi = avatarHippyApi;
    }

    private final void wh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        LiveData<m94.a> a16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().a();
        final Function1<m94.a, Unit> function1 = new Function1<m94.a, Unit>() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.ZPlanAvatarMallHippyFragment$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m94.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m94.a aVar) {
                if (aVar.b().isEmpty()) {
                    QLog.e("ZPlanAvatarMallHippyFragment_", 1, "dressMap isEmpty");
                    return;
                }
                JSONObject e16 = aVar.e();
                QLog.i("ZPlanAvatarMallHippyFragment_", 1, "CurrentDressInfo:" + e16);
                ZPlanAvatarMallHippyFragment zPlanAvatarMallHippyFragment = ZPlanAvatarMallHippyFragment.this;
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushJSONObject(e16);
                Unit unit = Unit.INSTANCE;
                zPlanAvatarMallHippyFragment.sendHippyNativeEvent("onCurrentDressChanged", hippyMap);
            }
        };
        a16.observe(activity, new Observer() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanAvatarMallHippyFragment.xh(Function1.this, obj);
            }
        });
        LiveData<Boolean> f16 = com.tencent.sqshow.zootopia.nativeui.ue.n.f371383a.f();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.ZPlanAvatarMallHippyFragment$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                boolean booleanValue = bool == null ? false : bool.booleanValue();
                QLog.i("ZPlanAvatarMallHippyFragment_", 1, "ChangeDressTaskRunningStatus:" + booleanValue);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dressTaskRunning", booleanValue);
                ZPlanAvatarMallHippyFragment zPlanAvatarMallHippyFragment = ZPlanAvatarMallHippyFragment.this;
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushJSONObject(jSONObject);
                Unit unit = Unit.INSTANCE;
                zPlanAvatarMallHippyFragment.sendHippyNativeEvent("onDressStatusChanged", hippyMap);
            }
        };
        f16.observe(activity, new Observer() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanAvatarMallHippyFragment.yh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(boolean z16) {
        c.a.a(this, z16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b mAvatarPanelHelper = this.avatarHippyApi.getMAvatarPanelHelper();
        if (mAvatarPanelHelper != null) {
            mAvatarPanelHelper.i(this);
        }
        wh();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i("ZPlanAvatarMallHippyFragment_", 1, "onNativeStoreReady");
        sendHippyNativeEvent("onNativeStoreReady", new HippyMap());
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b mAvatarPanelHelper;
        super.onPause();
        FragmentActivity activity = getActivity();
        boolean z16 = false;
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        }
        if (!z16 || (mAvatarPanelHelper = this.avatarHippyApi.getMAvatarPanelHelper()) == null) {
            return;
        }
        mAvatarPanelHelper.p();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(boolean z16) {
        c.a.c(this, z16);
    }
}
