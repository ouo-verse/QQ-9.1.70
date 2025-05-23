package com.tencent.ecommerce.biz.hippy;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import cg0.a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpanStatus;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngine;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngineListener;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0003_`aB\u0007\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010(\u001a\u00020\u001aH\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u00100R\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010AR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010HR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u0016\u0010Q\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010JR\u0016\u0010S\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010JR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006b"}, d2 = {"Lcom/tencent/ecommerce/biz/hippy/ECBaseHippyFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Lcom/tencent/ecommerce/biz/hippy/IHippyUI;", "", "Zh", "Oh", "Xh", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "hippyEngine", "Yh", "ai", "", "state", "Ph", "Qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "getContentLayoutId", "", "getBusinessDescription", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "showing", "toggleLoadingView", "onDestroyView", "Sh", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "Wh", "Lcom/tencent/mtt/hippy/uimanager/HippyCustomViewCreator;", "Rh", "Th", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Vh", "Lorg/json/JSONObject;", "Uh", "Eh", "P", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "getHippyEngine", "()Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "setHippyEngine", "(Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "rootLayout", BdhLogUtil.LogTag.Tag_Req, "loadingView", ExifInterface.LATITUDE_SOUTH, "errorView", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "backView", "Landroid/view/ViewGroup;", "U", "Landroid/view/ViewGroup;", "hippyContainer", "V", "titlebar", "W", "I", "loadState", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngineListener;", "X", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngineListener;", "hippyEngineListener", "Y", "Ljava/lang/String;", "url", "Z", "minVersion", "a0", "moduleName", "b0", "params", "c0", "hippyControlLoading", "d0", UIJsPlugin.EVENT_HIDE_LOADING, "Llj0/b;", "e0", "Llj0/b;", "memoryMonitor", "Lcom/tencent/ecommerce/biz/hippy/ECBaseHippyFragment$b;", "f0", "Lcom/tencent/ecommerce/biz/hippy/ECBaseHippyFragment$b;", "loadTelemetrySpan", "<init>", "()V", "g0", "a", "b", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECBaseHippyFragment extends ECBaseFragment implements IHippyUI {

    /* renamed from: P, reason: from kotlin metadata */
    private IECHippyEngine hippyEngine;

    /* renamed from: Q, reason: from kotlin metadata */
    private View rootLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: S, reason: from kotlin metadata */
    private View errorView;

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView backView;

    /* renamed from: U, reason: from kotlin metadata */
    private ViewGroup hippyContainer;

    /* renamed from: V, reason: from kotlin metadata */
    private View titlebar;

    /* renamed from: W, reason: from kotlin metadata */
    private int loadState;

    /* renamed from: X, reason: from kotlin metadata */
    private IECHippyEngineListener hippyEngineListener;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean hippyControlLoading;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean hideLoading;

    /* renamed from: Y, reason: from kotlin metadata */
    private String url = "";

    /* renamed from: Z, reason: from kotlin metadata */
    private int minVersion = -1;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String moduleName = "";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String params = "";

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final lj0.b memoryMonitor = new lj0.b("ECBaseHippyFragment");

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final b loadTelemetrySpan = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/hippy/ECBaseHippyFragment$c;", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngineListener;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "msg", "", "onError", "onSuccess", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/ecommerce/biz/hippy/ECBaseHippyFragment;", "a", "Ljava/lang/ref/WeakReference;", "fragmentRef", "fragment", "<init>", "(Lcom/tencent/ecommerce/biz/hippy/ECBaseHippyFragment;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECHippyEngineListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ECBaseHippyFragment> fragmentRef;

        public c(ECBaseHippyFragment eCBaseHippyFragment) {
            this.fragmentRef = new WeakReference<>(eCBaseHippyFragment);
        }

        @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngineListener
        public void onError(int statusCode, String msg2) {
            a.f("ECBaseHippyFragment", "#onError: statusCode=" + statusCode + ", msg=" + msg2);
            ECBaseHippyFragment eCBaseHippyFragment = this.fragmentRef.get();
            if (eCBaseHippyFragment != null) {
                eCBaseHippyFragment.loadTelemetrySpan.c(false, statusCode, msg2);
                eCBaseHippyFragment.Ph(2);
            }
        }

        @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngineListener
        public void onSuccess() {
            ECBaseHippyFragment eCBaseHippyFragment = this.fragmentRef.get();
            if (eCBaseHippyFragment != null) {
                b.d(eCBaseHippyFragment.loadTelemetrySpan, true, 0, null, 6, null);
                eCBaseHippyFragment.Ph(1);
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECBaseHippyFragment.this.ai();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECBaseHippyFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private final void Oh() {
        if (fg0.a.f398587b.a()) {
            ImageView imageView = this.backView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backView");
            }
            imageView.setImageResource(R.drawable.a4v);
            View view = this.rootLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            }
            view.setBackgroundColor((int) 4281545523L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(int state) {
        if (this.loadState == state) {
            return;
        }
        this.loadState = state;
        if (state == 0) {
            View view = this.loadingView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            }
            view.setVisibility(this.hideLoading ? 8 : 0);
            View view2 = this.errorView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorView");
            }
            view2.setVisibility(8);
            ViewGroup viewGroup = this.hippyContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
            }
            viewGroup.setVisibility(4);
            View view3 = this.titlebar;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titlebar");
            }
            view3.setVisibility(0);
            return;
        }
        if (state != 1) {
            if (state != 2) {
                return;
            }
            View view4 = this.loadingView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            }
            view4.setVisibility(8);
            View view5 = this.errorView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorView");
            }
            view5.setVisibility(0);
            ViewGroup viewGroup2 = this.hippyContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
            }
            viewGroup2.setVisibility(4);
            View view6 = this.titlebar;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titlebar");
            }
            view6.setVisibility(0);
            Qh();
            return;
        }
        View view7 = this.rootLayout;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        }
        if (!(view7 instanceof ViewGroup)) {
            view7 = null;
        }
        ViewGroup viewGroup3 = (ViewGroup) view7;
        if (viewGroup3 != null) {
            View view8 = this.errorView;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorView");
            }
            viewGroup3.removeView(view8);
            View view9 = this.titlebar;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titlebar");
            }
            viewGroup3.removeView(view9);
        }
        if (!this.hippyControlLoading) {
            toggleLoadingView(false);
        }
        ViewGroup viewGroup4 = this.hippyContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
        }
        viewGroup4.setVisibility(0);
        Qh();
    }

    private final void Qh() {
        this.memoryMonitor.a();
        this.memoryMonitor.b();
    }

    private final void Xh() {
        this.loadTelemetrySpan.e(this.moduleName, this.params);
        IECHippyEngine newEngine = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getHippyProxy().newEngine(this, this.moduleName, getUrl(), Wh(), Rh(), getMinVersion());
        newEngine.setPropsMap(Vh());
        Yh(newEngine);
        Unit unit = Unit.INSTANCE;
        this.hippyEngine = newEngine;
    }

    private final void Yh(IECHippyEngine hippyEngine) {
        this.hippyEngineListener = new c(this);
        ViewGroup viewGroup = this.hippyContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
        }
        hippyEngine.initHippyInContainer(viewGroup, Uh(), this.hippyEngineListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00af, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Zh() {
        Integer intOrNull;
        Integer intOrNull2;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("moduleName", "");
            this.moduleName = string;
            if (string.length() == 0) {
                String string2 = arguments.getString("modulename", "");
                this.moduleName = string2;
                if (string2.length() == 0) {
                    a.a("ECBaseHippyFragment", "parseArgs", "moduleName can not be empty");
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
            }
            String string3 = arguments.getString("framework", "");
            if (string3.length() == 0) {
                a.a("ECBaseHippyFragment", "parseArgs", "framework can not be empty");
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.finish();
                    return;
                }
                return;
            }
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.moduleName;
                String format = String.format("https://viola.qq.com/js/%s.js?v_bundleName=%s&framework=%s", Arrays.copyOf(new Object[]{str, str, string3}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                this.url = format;
                String string4 = arguments.getString("minVersion");
                int i3 = -1;
                int intValue = (string4 == null || intOrNull2 == null) ? -1 : intOrNull2.intValue();
                this.minVersion = intValue;
                if (intValue == -1) {
                    String string5 = arguments.getString("minversion");
                    if (string5 != null && intOrNull != null) {
                        i3 = intOrNull.intValue();
                    }
                    this.minVersion = i3;
                }
                this.hippyControlLoading = Intrinsics.areEqual(arguments.getString("hippyControlLoading", "0"), "1");
                this.hideLoading = Intrinsics.areEqual(arguments.getString(UIJsPlugin.EVENT_HIDE_LOADING, "0"), "1");
                this.params = arguments.getString("params", "");
            } catch (IllegalFormatException e16) {
                a.a("ECBaseHippyFragment", "parseArgs", e16.toString());
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.finish();
                    return;
                }
                return;
            }
        }
        a.b("ECBaseHippyFragment", "#parseArgs: url=" + this.url + ", minVersion=" + this.minVersion + ", params=" + this.params);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    public HippyCustomViewCreator Rh() {
        return null;
    }

    /* renamed from: Sh, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    /* renamed from: Th, reason: from getter */
    public int getMinVersion() {
        return this.minVersion;
    }

    public JSONObject Uh() {
        return null;
    }

    public HippyMap Vh() {
        HippyMap hippyMap = new HippyMap();
        if (this.params.length() > 0) {
            hippyMap.pushString("params", this.params);
        }
        hippyMap.pushBoolean("isNight", fg0.a.f398587b.a());
        int a16 = r.f104881b.a(getActivity());
        if (a16 != 0) {
            a16 = (int) ((a16 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
        }
        hippyMap.pushInt("statusbarHeight", a16);
        hippyMap.pushBoolean("hippyControlLoading", this.hippyControlLoading);
        return hippyMap;
    }

    public HippyAPIProvider Wh() {
        return new ij0.b(this.loadTelemetrySpan.b());
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECBaseHippyFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqo;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.memoryMonitor.d();
        Zh();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.loadTelemetrySpan.a();
        IECHippyEngine iECHippyEngine = this.hippyEngine;
        if (iECHippyEngine != null) {
            iECHippyEngine.onDestroyView();
        }
        this.hippyEngine = null;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b("EC_STAGE_HIPPY_PAGE");
        IECHippyEngine iECHippyEngine = this.hippyEngine;
        if (iECHippyEngine != null) {
            iECHippyEngine.onPause();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECRMonitorManager.f100953c.c("EC_STAGE_HIPPY_PAGE");
        IECHippyEngine iECHippyEngine = this.hippyEngine;
        if (iECHippyEngine != null) {
            iECHippyEngine.onResume();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.rootLayout = view.findViewById(R.id.o0t);
        this.hippyContainer = (ViewGroup) view.findViewById(R.id.o0s);
        this.loadingView = view.findViewById(R.id.o3p);
        View findViewById = view.findViewById(R.id.nyi);
        this.errorView = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorView");
        }
        findViewById.findViewById(R.id.f163072o52).setOnClickListener(new d());
        View findViewById2 = view.findViewById(R.id.nzl);
        this.titlebar = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titlebar");
        }
        ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = r.f104881b.a(getActivity());
            View view2 = this.titlebar;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titlebar");
            }
            view2.setLayoutParams(layoutParams2);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.o18);
        this.backView = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backView");
        }
        imageView.setOnClickListener(new e());
        Ph(0);
        Xh();
        Oh();
    }

    @Override // com.tencent.ecommerce.biz.hippy.IHippyUI
    public void toggleLoadingView(boolean showing) {
        View view = this.loadingView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        view.setVisibility(showing ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai() {
        Ph(0);
        IECHippyEngine iECHippyEngine = this.hippyEngine;
        if (iECHippyEngine == null) {
            Xh();
        } else {
            Intrinsics.checkNotNull(iECHippyEngine);
            Yh(iECHippyEngine);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J$\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000e\u001a\u00020\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/hippy/ECBaseHippyFragment$b;", "", "", "b", "moduleName", "params", "", "e", "", "isSuccess", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "msg", "c", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b {
        public final void a() {
            com.tencent.ecommerce.base.fragment.d dVar = com.tencent.ecommerce.base.fragment.d.f100713c;
            String b16 = b();
            hg0.c d16 = dVar.d();
            dVar.c(b16, d16 != null ? d16.getParentSpan() : null, IECSpanStatus.ECSpanStatusOK.ordinal());
        }

        public final String b() {
            return "ECHippyPageTrace_" + hashCode();
        }

        public final void c(boolean isSuccess, int statusCode, String msg2) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (isSuccess) {
                linkedHashMap.put("loadSuccess", String.valueOf(true));
            } else {
                linkedHashMap.put("loadSuccess", String.valueOf(false));
                linkedHashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(statusCode));
                if (!TextUtils.isEmpty(msg2)) {
                    Intrinsics.checkNotNull(msg2);
                    linkedHashMap.put("errMsg", msg2);
                }
            }
            com.tencent.ecommerce.base.fragment.d.f100713c.a(b(), "bundleLoaded", linkedHashMap);
        }

        public final void e(String moduleName, String params) {
            com.tencent.ecommerce.base.fragment.d dVar = com.tencent.ecommerce.base.fragment.d.f100713c;
            dVar.f(b(), "ECHippyPageTrace", dVar.d());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("moduleName", moduleName);
            if (params.length() > 0) {
                linkedHashMap.put("params", params);
            }
            dVar.a(b(), "startLoadingBundle", linkedHashMap);
        }

        public static /* synthetic */ void d(b bVar, boolean z16, int i3, String str, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            if ((i16 & 4) != 0) {
                str = "";
            }
            bVar.c(z16, i3, str);
        }
    }
}
