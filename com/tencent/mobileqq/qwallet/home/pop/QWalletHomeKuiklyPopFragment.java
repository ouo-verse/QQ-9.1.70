package com.tencent.mobileqq.qwallet.home.pop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qwallet.home.BackendControlPopViewModel;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.home.pop.QWalletHomeKuiklyPopFragment;
import com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyPopWindowModule;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tenpay.sdk.util.QWSoterConstans;
import dl2.QWalletCommonPopConfig;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u00019\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\"\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020$H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/pop/QWalletHomeKuiklyPopFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "initData", "registerReceiver", OcrConfig.CHINESE, "initTimer", "uh", "Landroid/view/View;", "view", "wh", "Landroid/view/ViewGroup;", "vh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "showLoadingView", "hideLoadingView", "showErrorView", "hideErrorView", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getFragmentAnimation", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "kuiklyView", "", "D", "Ljava/lang/String;", "currentPageName", "E", "currentBundleName", UserInfo.SEX_FEMALE, "Z", "isTimeout", "G", "isBizLoadSuccess", "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "timeoutRunnable", "com/tencent/mobileqq/qwallet/home/pop/QWalletHomeKuiklyPopFragment$receiver$1", "I", "Lcom/tencent/mobileqq/qwallet/home/pop/QWalletHomeKuiklyPopFragment$receiver$1;", "receiver", "<init>", "()V", "J", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletHomeKuiklyPopFragment extends QWalletBaseFragment implements h {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private g kuiklyView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String currentPageName;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String currentBundleName;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isTimeout;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isBizLoadSuccess;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Runnable timeoutRunnable = new Runnable() { // from class: dl2.c
        @Override // java.lang.Runnable
        public final void run() {
            QWalletHomeKuiklyPopFragment.yh(QWalletHomeKuiklyPopFragment.this);
        }
    };

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final QWalletHomeKuiklyPopFragment$receiver$1 receiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qwallet.home.pop.QWalletHomeKuiklyPopFragment$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String action;
            String str;
            String str2;
            if (intent != null && (action = intent.getAction()) != null) {
                String str3 = null;
                if (Intrinsics.areEqual(action, IQWalletKuiklyApi.EVENT_ACTION_CLOSE_WINDOW)) {
                    QWalletKuiklyPopWindowModule.CloseWindowBean closeWindowBean = (QWalletKuiklyPopWindowModule.CloseWindowBean) intent.getParcelableExtra("data");
                    if (closeWindowBean != null) {
                        str3 = closeWindowBean.getPageName();
                    }
                    str2 = QWalletHomeKuiklyPopFragment.this.currentPageName;
                    if (Intrinsics.areEqual(str3, str2)) {
                        QWalletHomeKuiklyPopFragment.this.finish();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(action, IQWalletKuiklyApi.EVENT_ACTION_NOTIFY_LOAD_STATE)) {
                    QWalletKuiklyPopWindowModule.NotifyPagerLoadStateBean notifyPagerLoadStateBean = (QWalletKuiklyPopWindowModule.NotifyPagerLoadStateBean) intent.getParcelableExtra("data");
                    if (notifyPagerLoadStateBean != null) {
                        str3 = notifyPagerLoadStateBean.getPageName();
                    }
                    str = QWalletHomeKuiklyPopFragment.this.currentPageName;
                    if (Intrinsics.areEqual(str3, str)) {
                        boolean z16 = false;
                        if (notifyPagerLoadStateBean != null && notifyPagerLoadStateBean.getLoadState() == QWalletKuiklyPopWindowModule.NotifyPagerLoadStateBean.Companion.ENUM_LOAD_STATE.SUCCESS.ordinal()) {
                            z16 = true;
                        }
                        if (z16) {
                            QWalletHomeKuiklyPopFragment.this.uh();
                            QWalletHomeKuiklyPopFragment.this.isBizLoadSuccess = true;
                        }
                    }
                }
            }
        }
    };

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J0\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/pop/QWalletHomeKuiklyPopFragment$a;", "", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "pageName", "bundleName", "args", "", "b", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "", "a", "KEY_KUIKLY_BUNDLE_NAME", "Ljava/lang/String;", "KEY_KUIKLY_PAGE_NAME", "KEY_KUIKLY_PARAM", "KEY_TO_KUIKLY_CONTENT", "TAG", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.pop.QWalletHomeKuiklyPopFragment$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, FragmentActivity fragmentActivity, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str2 = null;
            }
            if ((i3 & 8) != 0) {
                str3 = null;
            }
            companion.b(fragmentActivity, str, str2, str3);
        }

        public final boolean a(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
            boolean z16;
            if (appInfo == null) {
                return false;
            }
            String str = appInfo.buffer.get();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
            try {
                if (new JSONObject(str).optInt(QWSoterConstans.CGI_KEY_BUSI_TYPE, BackendControlPopViewModel.EnumRedPointExtraType.NONE.ordinal()) != BackendControlPopViewModel.EnumRedPointExtraType.BACKEND_CONTROL_POP.ordinal()) {
                    return false;
                }
                return true;
            } catch (JSONException e16) {
                QLog.e("QWalletHomeKuiklyPopFragment", 1, e16, new Object[0]);
                return false;
            }
        }

        public final void b(@Nullable FragmentActivity fragmentActivity, @NotNull String pageName, @Nullable String bundleName, @Nullable String args) {
            Intrinsics.checkNotNullParameter(pageName, "pageName");
            if (fragmentActivity == null) {
                QLog.w("QWalletHomeKuiklyPopFragment", 1, "start fail, fragmentActivity is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("KEY_KUIKLY_PAGE_NAME", pageName);
            intent.putExtra("KEY_KUIKLY_BUNDLE_NAME", bundleName);
            intent.putExtra("KEY_KUIKLY_PARAM", args);
            intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, 0);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0);
            intent.putExtra("public_fragment_window_feature", 1);
            QPublicFragmentActivity.b.b(fragmentActivity, intent, QPublicTransFragmentActivity.class, QWalletHomeKuiklyPopFragment.class);
            fragmentActivity.overridePendingTransition(0, 0);
        }

        Companion() {
        }
    }

    private final void initData() {
        String string;
        String str;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("KEY_KUIKLY_PAGE_NAME")) != null) {
            this.currentPageName = string;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("KEY_KUIKLY_BUNDLE_NAME");
            } else {
                str = null;
            }
            this.currentBundleName = str;
            return;
        }
        QLog.w("QWalletHomeKuiklyPopFragment", 1, "path is null");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initTimer() {
        long j3;
        Long timeoutMS = ((QWalletCommonPopConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_COMMON_POP_WINDOW_CONFIG, QWalletCommonPopConfig.INSTANCE.a())).getTimeoutMS();
        if (timeoutMS != null) {
            j3 = timeoutMS.longValue();
        } else {
            j3 = 3000;
        }
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "initTimer:" + j3);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.timeoutRunnable, j3);
    }

    private final void registerReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IQWalletKuiklyApi.EVENT_ACTION_NOTIFY_LOAD_STATE);
            intentFilter.addAction(IQWalletKuiklyApi.EVENT_ACTION_CLOSE_WINDOW);
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                mobileQQ.registerReceiver(this.receiver, intentFilter);
            }
        } catch (Exception e16) {
            QLog.w("QWalletHomeKuiklyPopFragment", 1, "register error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh() {
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "closeTimer");
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.timeoutRunnable);
    }

    private final void vh(ViewGroup view) {
        String str;
        String string;
        Context context = getContext();
        if (context == null || (str = this.currentPageName) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str2 = this.currentBundleName;
        if (str2 != null) {
            linkedHashMap.put("bundle_name", str2);
        }
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("KEY_KUIKLY_PARAM")) != null) {
            linkedHashMap.put("popContent", string);
        }
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "start kuikly: pageName=" + this.currentPageName + " params=" + linkedHashMap);
        g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(context, this);
        g.a.b(createKuiklyRenderView, str, linkedHashMap, null, 4, null);
        createKuiklyRenderView.onResume();
        this.kuiklyView = createKuiklyRenderView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Object obj = this.kuiklyView;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        ((View) obj).setBackgroundColor(0);
        Object obj2 = this.kuiklyView;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
        view.addView((View) obj2, layoutParams);
    }

    private final void wh(View view) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: dl2.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean xh5;
                xh5 = QWalletHomeKuiklyPopFragment.xh(QWalletHomeKuiklyPopFragment.this, view2, motionEvent);
                return xh5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean xh(QWalletHomeKuiklyPopFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QWalletHomeKuiklyPopFragment", 2, "onTouch, isTimeout=" + this$0.isTimeout + " isBizLoadSuccess=" + this$0.isBizLoadSuccess);
        if (this$0.isTimeout && !this$0.isBizLoadSuccess) {
            this$0.finish();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(QWalletHomeKuiklyPopFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.w("QWalletHomeKuiklyPopFragment", 1, "timeout");
        this$0.isTimeout = true;
    }

    private final void zh() {
        try {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                mobileQQ.unregisterReceiver(this.receiver);
            }
        } catch (Exception e16) {
            QLog.w("QWalletHomeKuiklyPopFragment", 1, "unregisterReceiver error", e16);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.NONE;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "ignored hideErrorView");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "ignored hideLoadingView");
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        View view;
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        if (view != null) {
            view.setSystemUiVisibility(1792);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setNavigationBarColor(0);
        }
        initData();
        initTimer();
        registerReceiver();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hkb, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.kuiklyView;
        if (gVar != null) {
            gVar.onDetach();
        }
        zh();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        View view;
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "onPageLoadComplete isSucceed:" + isSucceed + " errorReason:" + errorReason + " executeMode:" + executeMode);
        if (isSucceed) {
            Object obj = this.kuiklyView;
            if (obj instanceof View) {
                view = (View) obj;
            } else {
                view = null;
            }
            if (view != null) {
                view.setBackgroundColor(0);
                return;
            }
            return;
        }
        finish();
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "dismiss " + this.currentBundleName + "-" + this.currentPageName);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        g gVar = this.kuiklyView;
        if (gVar != null) {
            gVar.onPause();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g gVar = this.kuiklyView;
        if (gVar != null) {
            gVar.onResume();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        wh(view);
        vh((ViewGroup) view);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "ignored showErrorView");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        QLog.i("QWalletHomeKuiklyPopFragment", 1, "ignored showLoadingView");
    }
}
