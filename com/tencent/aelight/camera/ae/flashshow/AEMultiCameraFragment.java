package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qzonehub.api.IQZonePageApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\n\u001a\u00020\u00042&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0014J/\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001a2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070!2\u0006\u0010$\u001a\u00020#H\u0016\u00a2\u0006\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/AEMultiCameraFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Landroid/view/View;", "parentView", "", "xh", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/Intent;", "intent", "sh", "getPageId", "th", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;", "cameraUnit", "<init>", "()V", "D", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEMultiCameraFragment extends ImmersivePartFragment {
    private static final String E = "AEMultiCameraFragment";

    /* renamed from: C, reason: from kotlin metadata */
    private LSMultiCameraUnit cameraUnit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/AEMultiCameraFragment$c", "Lor/d;", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements or.d {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh(HashMap<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).jumpQZMomentPublishPage(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void xh(View parentView) {
        String str = E;
        ms.a.f(str, "register datong pageId");
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(parentView, getPageId());
        HashMap hashMap = new HashMap();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getIntent();
        }
        FragmentActivity activity2 = getActivity();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, sh(activity2 != null ? activity2.getIntent() : null));
        hashMap.put(th(), 0);
        ms.a.f(str, "DaTongParams::dt_appkey.name params " + hashMap);
        VideoReport.setPageParams(parentView, new PageParams(hashMap));
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dm6;
    }

    public final String getPageId() {
        return "pg_bas_capture";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        LSMultiCameraUnit lSMultiCameraUnit = this.cameraUnit;
        boolean z16 = false;
        if (lSMultiCameraUnit != null && lSMultiCameraUnit.onBackPressed()) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LSMultiCameraUnit lSMultiCameraUnit = new LSMultiCameraUnit(new b(), new c());
        this.cameraUnit = lSMultiCameraUnit;
        lSMultiCameraUnit.onCreate(savedInstanceState);
        MutableLiveData<HashMap<String, String>> U1 = lSMultiCameraUnit.c3().U1();
        final Function1<HashMap<String, String>, Unit> function1 = new Function1<HashMap<String, String>, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.AEMultiCameraFragment$onCreate$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap) {
                boolean z16 = false;
                if (hashMap != null && hashMap.size() == 2) {
                    z16 = true;
                }
                if (z16) {
                    LSMultiCameraUnit lSMultiCameraUnit2 = lSMultiCameraUnit;
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        ms.a.a(lSMultiCameraUnit2.f63731f, "camera dispatch result key is: " + key + " path = " + value);
                    }
                    AEMultiCameraFragment.this.uh(hashMap);
                }
            }
        };
        U1.observe(lSMultiCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEMultiCameraFragment.vh(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> Q1 = lSMultiCameraUnit.c3().Q1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.AEMultiCameraFragment$onCreate$1$2
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
                AEMultiCameraFragment.this.getHostActivity().finish();
            }
        };
        Q1.observe(lSMultiCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEMultiCameraFragment.wh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LSMultiCameraUnit lSMultiCameraUnit = this.cameraUnit;
        if (lSMultiCameraUnit != null) {
            lSMultiCameraUnit.c3().U1().removeObservers(lSMultiCameraUnit);
            lSMultiCameraUnit.c3().Q1().removeObservers(lSMultiCameraUnit);
            LSMultiCameraUnit lSMultiCameraUnit2 = this.cameraUnit;
            if (lSMultiCameraUnit2 != null) {
                lSMultiCameraUnit2.onDestroy();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LSMultiCameraUnit lSMultiCameraUnit = this.cameraUnit;
        if (lSMultiCameraUnit != null) {
            lSMultiCameraUnit.onActivityPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LSMultiCameraUnit lSMultiCameraUnit = this.cameraUnit;
        if (lSMultiCameraUnit != null) {
            lSMultiCameraUnit.k3(requestCode, permissions, grantResults);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LSMultiCameraUnit lSMultiCameraUnit = this.cameraUnit;
        if (lSMultiCameraUnit != null) {
            lSMultiCameraUnit.onActivityResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LSMultiCameraUnit lSMultiCameraUnit;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null && (lSMultiCameraUnit = this.cameraUnit) != null) {
            lSMultiCameraUnit.q(viewGroup);
        }
        xh(view);
    }

    public final String th() {
        return "is_supported_biphoto";
    }

    public final String sh(Intent intent) {
        Bundle extras;
        if (Intrinsics.areEqual((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString(QQWinkConstants.AE_MULTI_CAMERA_FROM), "QZONE")) {
            return "0AND0MWZXR4U3RVU";
        }
        return WinkContext.INSTANCE.d().getDtParams().b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/AEMultiCameraFragment$b", "Lor/e;", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "getActivity", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lmqq/util/WeakReference;", BdhLogUtil.LogTag.Tag_Req, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements or.e {
        b() {
        }

        @Override // or.e
        public WeakReference<Activity> R() {
            return new WeakReference<>(AEMultiCameraFragment.this.getHostActivity());
        }

        @Override // or.e
        public Activity getActivity() {
            return AEMultiCameraFragment.this.getHostActivity();
        }

        @Override // or.e
        public void Q() {
        }
    }
}
