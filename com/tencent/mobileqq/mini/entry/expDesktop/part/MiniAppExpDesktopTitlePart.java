package com.tencent.mobileqq.mini.entry.expDesktop.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopTitlePart;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopAbstractPart;", "Landroid/view/View$OnClickListener;", "", "asyncPreloadTitlePartEvent", "Lcom/tencent/qqnt/kernel/api/w;", "getMsgService", "initTitlePartView", "setTitleViewInfo", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "setLiveDataObserver", "", "isStudyMode", "studyModeChange", "onAccountChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "view", NodeProps.ON_CLICK, "", "getLogTag", "Landroid/widget/RelativeLayout;", "mDesktopNavbarLayout", "Landroid/widget/RelativeLayout;", "Landroid/widget/TextView;", "mTitleView", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "mGotoNotificationIv", "Landroid/widget/ImageView;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "mKernelMsgListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "mIsViewInit", "Z", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopTitlePart extends MiniAppExpDesktopAbstractPart implements View.OnClickListener {
    private RelativeLayout mDesktopNavbarLayout;
    private ImageView mGotoNotificationIv;
    private boolean mIsViewInit;
    private IKernelMsgListener mKernelMsgListener;
    private TextView mTitleView;

    private final void asyncPreloadTitlePartEvent() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.ae
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopTitlePart.asyncPreloadTitlePartEvent$lambda$1(MiniAppExpDesktopTitlePart.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncPreloadTitlePartEvent$lambda$1(MiniAppExpDesktopTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiniAppUtils.isTeenagerMode() || !MiniAppConfProcessor.n() || !com.tencent.mobileqq.applets.b.a()) {
            QLog.i(this$0.getTAG(), 1, "async preload, not need setMiniAppRedDotListener!");
        }
        if (MiniAppConfProcessor.n() || MiniAppConfProcessor.o()) {
            QLog.i(this$0.getTAG(), 1, "async preload, showLeftButton!");
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
        View findViewById2 = getPartRootView().findViewById(R.id.rg8);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.mTitleView = (TextView) findViewById2;
        View findViewById3 = getPartRootView().findViewById(R.id.f163690rh2);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById3;
        this.mGotoNotificationIv = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGotoNotificationIv");
            imageView = null;
        }
        imageView.setOnClickListener(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$0(MiniAppExpDesktopTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopTitlePart$setLiveDataObserver$1$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTitleViewInfo() {
        if (this.mIsViewInit) {
            QLog.i(getTAG(), 1, "setTitleViewInfo is init!");
            return;
        }
        TextView textView = this.mTitleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
            textView = null;
        }
        textView.setText(MiniAppConfProcessor.a());
        this.mIsViewInit = true;
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppExpDesktopPart.MiniAppExpDesktopTitlePart";
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void onAccountChanged() {
        asyncPreloadTitlePartEvent();
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e(getTAG(), 1, "onInitView rootView is null!");
        } else {
            initTitlePartView();
            asyncPreloadTitlePartEvent();
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        com.tencent.qqnt.kernel.api.w msgService;
        QLog.i(getTAG(), 1, "onPartDestroy");
        if (this.mKernelMsgListener != null && (msgService = getMsgService()) != null) {
            IKernelMsgListener iKernelMsgListener = this.mKernelMsgListener;
            Intrinsics.checkNotNull(iKernelMsgListener, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener");
            msgService.removeMsgListener(iKernelMsgListener);
        }
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartResume(Activity activity) {
        com.tencent.biz.richframework.part.b.d(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void setLiveDataObserver() {
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.ad
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopTitlePart.setLiveDataObserver$lambda$0(MiniAppExpDesktopTitlePart.this);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f163690rh2) {
            getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopTitlePart$onClick$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MiniAppExpDesktopEffect invoke() {
                    return new MiniAppExpDesktopEffect.SetMiniAppNotificationData("");
                }
            });
            MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper.INSTANCE.getInstance(), "qq_clck", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_MENU_BUTTON, null, null, 12, null);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
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
