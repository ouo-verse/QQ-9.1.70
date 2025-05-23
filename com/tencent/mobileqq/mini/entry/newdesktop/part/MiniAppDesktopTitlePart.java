package com.tencent.mobileqq.mini.entry.newdesktop.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010*\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopTitlePart;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopAbstractPart;", "Landroid/view/View$OnClickListener;", "", "asyncPreloadTitlePartEvent", "setNotificationRedDotListener", "Lcom/tencent/qqnt/kernel/api/w;", "getMsgService", "initTitlePartView", "setTitleViewInfo", "handleJumpToNotificationClick", "notificationButtonExposureReport", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "setLiveDataObserver", "", "isStudyMode", "studyModeChange", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnAccountChanged;", "uiState", "onAccountChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "view", NodeProps.ON_CLICK, "", "getLogTag", "Landroid/widget/RelativeLayout;", "mDesktopNavbarLayout", "Landroid/widget/RelativeLayout;", "mCapsuleLeftContainer", "Landroid/widget/TextView;", "mTitleView", "Landroid/widget/TextView;", "mCapsuleRl", "Landroid/widget/ImageView;", "mCapsuleLeftIv", "Landroid/widget/ImageView;", "mRedDotTv", "mCloseDesktopIv", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "mKernelMsgListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "mShowCapsuleLeftButtonAsNotificationButton", "Z", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniAppDesktopTitlePart extends MiniAppDesktopAbstractPart implements View.OnClickListener {
    private static final String RED_DOT_HIDE_TAG = "0";
    private static final String RED_DOT_SHOW_TAG = "1";
    private RelativeLayout mCapsuleLeftContainer;
    private ImageView mCapsuleLeftIv;
    private RelativeLayout mCapsuleRl;
    private ImageView mCloseDesktopIv;
    private RelativeLayout mDesktopNavbarLayout;
    private IKernelMsgListener mKernelMsgListener;
    private TextView mRedDotTv;
    private boolean mShowCapsuleLeftButtonAsNotificationButton;
    private TextView mTitleView;

    private final void asyncPreloadTitlePartEvent() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.ae
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopTitlePart.asyncPreloadTitlePartEvent$lambda$1(MiniAppDesktopTitlePart.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncPreloadTitlePartEvent$lambda$1(MiniAppDesktopTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiniAppUtils.isTeenagerMode() || !MiniAppConfProcessor.n() || !com.tencent.mobileqq.applets.b.a()) {
            QLog.i(this$0.getLogTag(), 1, "async preload, not need setMiniAppRedDotListener!");
        }
        if (MiniAppConfProcessor.n() || MiniAppConfProcessor.o()) {
            QLog.i(this$0.getLogTag(), 1, "async preload, showLeftButton!");
        }
        MiniAppConfProcessor.a();
    }

    private final com.tencent.qqnt.kernel.api.w getMsgService() {
        IKernelService iKernelService;
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface == null || (iKernelService = (IKernelService) appInterface.getRuntimeService(IKernelService.class, "")) == null) {
            return null;
        }
        return iKernelService.getMsgService();
    }

    private final void initTitlePartView() {
        int roundToInt;
        View partRootView = getPartRootView();
        RelativeLayout relativeLayout = null;
        View findViewById = partRootView != null ? partRootView.findViewById(R.id.rf8) : null;
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mDesktopNavbarLayout = (RelativeLayout) findViewById;
        View partRootView2 = getPartRootView();
        View findViewById2 = partRootView2 != null ? partRootView2.findViewById(R.id.rfp) : null;
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mCapsuleLeftContainer = (RelativeLayout) findViewById2;
        View findViewById3 = getPartRootView().findViewById(R.id.rg8);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.mTitleView = (TextView) findViewById3;
        View findViewById4 = getPartRootView().findViewById(R.id.rfn);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mCapsuleRl = (RelativeLayout) findViewById4;
        View findViewById5 = getPartRootView().findViewById(R.id.rfo);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.mCapsuleLeftIv = (ImageView) findViewById5;
        View findViewById6 = getPartRootView().findViewById(R.id.rfr);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.mRedDotTv = (TextView) findViewById6;
        View findViewById7 = getPartRootView().findViewById(R.id.rff);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.ImageView");
        this.mCloseDesktopIv = (ImageView) findViewById7;
        ImageView imageView = this.mCapsuleLeftIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCapsuleLeftIv");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.mCloseDesktopIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseDesktopIv");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(46.0f));
        roundToInt = MathKt__MathJVMKt.roundToInt(ImmersiveUtils.getStatusBarHeight(getContext()));
        layoutParams.setMargins(0, roundToInt, 0, 0);
        RelativeLayout relativeLayout2 = this.mDesktopNavbarLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopNavbarLayout");
        } else {
            relativeLayout = relativeLayout2;
        }
        relativeLayout.setLayoutParams(layoutParams);
    }

    private final void notificationButtonExposureReport() {
        String str;
        if (this.mShowCapsuleLeftButtonAsNotificationButton) {
            TextView textView = this.mRedDotTv;
            String str2 = null;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDotTv");
                textView = null;
            }
            if (textView.getVisibility() == 0) {
                TextView textView3 = this.mRedDotTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRedDotTv");
                } else {
                    textView2 = textView3;
                }
                CharSequence text = textView2.getText();
                Intrinsics.checkNotNullExpressionValue(text, "mRedDotTv.text");
                str2 = text.toString();
            }
            String str3 = str2;
            if (TextUtils.isEmpty(str3)) {
                str = "0";
            } else {
                str = "1";
            }
            String str4 = str;
            AppInterface appInterface = MiniAppUtils.getAppInterface();
            if (appInterface != null) {
                Manager manager = appInterface.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
                ((MiniAppExposureManager) manager).putReportDataToMap("notification", new MiniAppExposureManager.CommonExposureData("desktop", "notification", "expo", str4, str3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$0(MiniAppDesktopTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppDesktopTitlePart$setLiveDataObserver$1$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNotificationRedDotListener() {
        List mutableListOf;
        if (!MiniAppUtils.isTeenagerMode() && MiniAppConfProcessor.n() && com.tencent.mobileqq.applets.b.a()) {
            if (this.mKernelMsgListener != null) {
                QLog.i(getLogTag(), 1, "mKernelMsgListener is init!");
                return;
            }
            this.mKernelMsgListener = new MiniAppDesktopTitlePart$setNotificationRedDotListener$1(this);
            com.tencent.qqnt.kernel.api.w msgService = getMsgService();
            if (msgService != null) {
                IKernelMsgListener iKernelMsgListener = this.mKernelMsgListener;
                Intrinsics.checkNotNull(iKernelMsgListener, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener");
                msgService.addMsgListener(iKernelMsgListener);
            }
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new Contact(114, QzoneConfig.DEFAULT_APPLETS_UID, ""));
            com.tencent.qqnt.kernel.api.w msgService2 = getMsgService();
            if (msgService2 != null) {
                Intrinsics.checkNotNull(mutableListOf, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernelpublic.nativeinterface.Contact>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.kernelpublic.nativeinterface.Contact> }");
                msgService2.getContactUnreadCnt((ArrayList) mutableListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.af
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        MiniAppDesktopTitlePart.setNotificationRedDotListener$lambda$2(MiniAppDesktopTitlePart.this, i3, str);
                    }
                });
                return;
            }
            return;
        }
        QLog.i(getLogTag(), 1, "not need setMiniAppRedDotListener!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNotificationRedDotListener$lambda$2(MiniAppDesktopTitlePart this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.getLogTag(), 1, "IOperateCallback + result = " + i3 + " errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTitleViewInfo() {
        TextView textView = this.mTitleView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
            textView = null;
        }
        textView.setText(MiniAppConfProcessor.a());
        if (MiniAppConfProcessor.n() || MiniAppConfProcessor.o()) {
            if (MiniAppConfProcessor.n()) {
                ImageView imageView2 = this.mCapsuleLeftIv;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCapsuleLeftIv");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageResource(R.drawable.qui_mail_selector);
                return;
            }
            ImageView imageView3 = this.mCapsuleLeftIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCapsuleLeftIv");
            } else {
                imageView = imageView3;
            }
            imageView.setImageResource(R.drawable.qui_tuning);
            return;
        }
        RelativeLayout relativeLayout = this.mCapsuleRl;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCapsuleRl");
            relativeLayout = null;
        }
        relativeLayout.setBackground(null);
        RelativeLayout relativeLayout2 = this.mCapsuleLeftContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCapsuleLeftContainer");
            relativeLayout2 = null;
        }
        relativeLayout2.setVisibility(8);
        ImageView imageView4 = this.mCloseDesktopIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseDesktopIv");
            imageView4 = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(11);
        ImageView imageView5 = this.mCloseDesktopIv;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseDesktopIv");
        } else {
            imageView = imageView5;
        }
        imageView.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "MiniAppDesktopPart.MiniAppDesktopTitlePart";
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void onAccountChanged(MiniAppDeskTopUIState.OnAccountChanged uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        asyncPreloadTitlePartEvent();
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e(getLogTag(), 1, "onInitView rootView is null!");
        } else {
            initTitlePartView();
            asyncPreloadTitlePartEvent();
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        com.tencent.qqnt.kernel.api.w msgService;
        QLog.i(getLogTag(), 1, "onPartDestroy");
        if (this.mKernelMsgListener != null && (msgService = getMsgService()) != null) {
            IKernelMsgListener iKernelMsgListener = this.mKernelMsgListener;
            Intrinsics.checkNotNull(iKernelMsgListener, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener");
            msgService.removeMsgListener(iKernelMsgListener);
        }
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.i(getLogTag(), 1, "onPartResume");
        notificationButtonExposureReport();
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void setLiveDataObserver() {
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.ad
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopTitlePart.setLiveDataObserver$lambda$0(MiniAppDesktopTitlePart.this);
            }
        });
    }

    private final void handleJumpToNotificationClick() {
        String str;
        String str2;
        TextView textView = null;
        ei.a(null, "Recent_clk_enterchat");
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String b16 = MiniAppConfProcessor.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getAppletsNotificationNickName()");
        String c16 = MiniAppConfProcessor.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getAppletsNotificationUin()");
        iAIOStarterApi.navigateToAIO(context, 114, QzoneConfig.DEFAULT_APPLETS_UID, b16, Long.parseLong(c16), null);
        ei.a("Recent_clk_enterchat", null);
        TextView textView2 = this.mRedDotTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDotTv");
            textView2 = null;
        }
        if (textView2.getVisibility() == 0) {
            TextView textView3 = this.mRedDotTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDotTv");
                textView3 = null;
            }
            CharSequence text = textView3.getText();
            Intrinsics.checkNotNullExpressionValue(text, "mRedDotTv.text");
            str = text.toString();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        MiniProgramLpReportDC04239.reportAsync("desktop", "notification", "click", str2, str, (String) null);
        TextView textView4 = this.mRedDotTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDotTv");
        } else {
            textView = textView4;
        }
        textView.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.rfo) {
            if (MiniAppConfProcessor.n()) {
                handleJumpToNotificationClick();
                return;
            } else {
                PublicFragmentActivity.start(getContext(), MiniAppEntrySettingFragment.class);
                return;
            }
        }
        if (valueOf != null && valueOf.intValue() == R.id.rff) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost");
            ((MiniAppDesktopPartHost) partHost).hideMiniAppEntry(2);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void studyModeChange(boolean isStudyMode) {
        if (isStudyMode && this.mKernelMsgListener != null) {
            com.tencent.qqnt.kernel.api.w msgService = getMsgService();
            if (msgService != null) {
                IKernelMsgListener iKernelMsgListener = this.mKernelMsgListener;
                Intrinsics.checkNotNull(iKernelMsgListener);
                msgService.removeMsgListener(iKernelMsgListener);
                return;
            }
            return;
        }
        asyncPreloadTitlePartEvent();
    }
}
