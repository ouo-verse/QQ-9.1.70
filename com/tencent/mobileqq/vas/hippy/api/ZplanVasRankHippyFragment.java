package com.tencent.mobileqq.vas.hippy.api;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0016\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012\u0018\u00010\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/ZplanVasRankHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "uh", "Lorg/json/JSONObject;", "jsInitData", "doBussinessInitData", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "event", "onReceiveEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanVasRankHippyFragment extends CommonHippyFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/ZplanVasRankHippyFragment$a;", "", "Lcom/tencent/mobileqq/vas/transit/VisitorInfo;", "visitorInfo", "Lcom/tencent/mobileqq/vas/hippy/api/ZplanVasRankHippyFragment;", "a", "", "GROUP", "I", "", "GROUP_ID_KEY", "Ljava/lang/String;", "IS_ADMIN_ID_KEY", "SOURCE_ID_KEY", "VISITOR_INFO", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.hippy.api.ZplanVasRankHippyFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ZplanVasRankHippyFragment a(VisitorInfo visitorInfo) {
            Intrinsics.checkNotNullParameter(visitorInfo, "visitorInfo");
            ZplanVasRankHippyFragment zplanVasRankHippyFragment = new ZplanVasRankHippyFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("visitor_info", visitorInfo);
            zplanVasRankHippyFragment.setArguments(bundle);
            return zplanVasRankHippyFragment;
        }

        Companion() {
        }
    }

    private final void uh() {
        try {
            Fragment parentFragment = getParentFragment();
            DialogFragment dialogFragment = parentFragment instanceof DialogFragment ? (DialogFragment) parentFragment : null;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            } else {
                getParentFragmentManager().beginTransaction().remove(this).commit();
            }
        } catch (Throwable th5) {
            QLog.e("BaseHippyFragment", 1, "finishSelf err.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public JSONObject doBussinessInitData(JSONObject jsInitData) {
        JSONObject doBussinessInitData = super.doBussinessInitData(jsInitData);
        if (doBussinessInitData == null) {
            doBussinessInitData = new JSONObject();
        }
        try {
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("visitor_info") : null;
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.vas.transit.VisitorInfo");
            VisitorInfo visitorInfo = (VisitorInfo) serializable;
            doBussinessInitData.put("groupId", visitorInfo.getGroupId());
            doBussinessInitData.put("isAdmin", visitorInfo.getIsAdmin());
            doBussinessInitData.put("source", 1);
        } catch (Throwable th5) {
            QLog.e("BaseHippyFragment", 1, "doBussinessInjectData error: " + th5);
        }
        return doBussinessInitData;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZplanVasHippyCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if ((event instanceof ZplanVasHippyCloseEvent ? (ZplanVasHippyCloseEvent) event : null) != null) {
            uh();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }
}
