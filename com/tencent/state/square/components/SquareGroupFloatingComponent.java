package com.tencent.state.square.components;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import as4.c;
import as4.d;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.rapier.b;
import com.tencent.state.FragmentComponent;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.library.focus.timer.FormatUtils;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.IVasSquareFocusService;
import com.tencent.state.service.VasLibraryRoomService;
import com.tencent.state.service.VasLibraryStatisticsService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.api.SimpleSquarePagViewListener;
import com.tencent.state.square.components.SquareGroupFloatingComponent;
import com.tencent.state.square.databinding.VasSquareGroupFragmentSquareBinding;
import com.tencent.state.square.event.RefreshSquareAvatarFootLabelEvent;
import com.tencent.state.template.data.FloatingLeveTip;
import com.tencent.state.template.data.FloatingSphereInfo;
import com.tencent.state.template.dialog.SceneCommonDialogs;
import com.tencent.state.template.service.ITemplateRoomService;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.utils.SimplePagDownloadListener;
import com.tencent.state.utils.SquarePagFileUtils;
import com.tencent.state.view.CommonDragView;
import com.tencent.state.view.ProgressDrawable;
import com.tencent.state.view.ProgressDrawableStyle;
import com.tencent.state.view.SquareImageView;
import cs4.a;
import ft4.e;
import ft4.f;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002]^B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u0014\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"J\b\u0010#\u001a\u00020 H\u0002J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020&0%H\u0002J\n\u0010'\u001a\u0004\u0018\u00010(H\u0002J \u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0012H\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020 H\u0002J,\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u000108J\u0012\u00109\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u001a\u0010<\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@H\u0016J,\u0010A\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\u0006\u0010:\u001a\u00020;2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J4\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020+0H2\u0006\u0010-\u001a\u00020\u0012H\u0002J\u0010\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020MH\u0016J\u0018\u0010N\u001a\u00020 2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0012H\u0002J\u0010\u0010O\u001a\u00020 2\u0006\u0010,\u001a\u00020\bH\u0002J\b\u0010P\u001a\u00020 H\u0007J\u0018\u0010Q\u001a\u00020 2\u0006\u0010R\u001a\u00020S2\u0006\u00102\u001a\u00020\bH\u0002J\u0018\u0010T\u001a\u00020 2\u0006\u0010R\u001a\u00020S2\u0006\u00102\u001a\u00020\bH\u0002J\u0018\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020XH\u0002J\u000e\u0010Y\u001a\u00020 2\u0006\u0010Z\u001a\u00020\bJ\u0012\u0010[\u001a\u00020 2\b\b\u0002\u0010\\\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006_"}, d2 = {"Lcom/tencent/state/square/components/SquareGroupFloatingComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/state/square/api/ISquarePushListener;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareGroupFragmentSquareBinding;", "currentNoticeText", "", "endFocusStatText", "focusDialog", "Lcom/tencent/state/library/focus/FocusDialogTips;", "focusStartTime", "", "isForwardToLibraryOrTemple", "", "isNeedLeaveRoom", "isNoticeTimes", "", "isShowFocus", "playingBgPag", "progressDrawable", "Lcom/tencent/state/view/ProgressDrawable;", "reporter", "Lcom/tencent/state/square/IReporter;", "seatDefaultText", "sphereInfo", "Lcom/tencent/state/template/data/FloatingSphereInfo;", "sphereService", "Lcom/tencent/state/service/IVasSquareFocusService;", "checkRootIsVisible", "exitSquareEndFocusDialog", "", "callback", "Lkotlin/Function0;", "getEndFocusStatText", "getReportParams", "", "", "getServiceProvider", "Lcom/tencent/state/IVasBaseServiceProvider;", "initPagPlayer", "view", "Landroid/widget/FrameLayout;", "pagFile", "repeatTimes", "initReport", "initTextSwitcher", "initView", "noticeText", "text", "needAnim", "inAnim", "outAnim", "onBackFromLibraryOrTemple", "intent", "Landroid/content/Intent;", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentViewCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onPagDownloaded", "resultFile", "Ljava/io/File;", "pagViewRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/square/api/ISquarePagView;", "containerViewRef", "onResult", "data", "", "playBgPag", "playNoticePag", "resetPosition", "safelySetCurrentText", "textSwitcher", "Landroid/widget/TextSwitcher;", "safelySetText", "showFocusRelatedDialog", "isBackFromLibOrTemple", "result", "Lcom/tencent/state/template/data/FloatingLeveTip;", "stopCountDown", "from", "updateCallBack", "isBackFromLibraryOrTemple", "Companion", "CountdownProgressListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareGroupFloatingComponent extends VasBaseFragmentComponent implements View.OnClickListener, ISquarePushListener {
    private static final String TAG = "SquareGroupFloatingComponent";
    private VasSquareGroupFragmentSquareBinding binding;
    private long focusStartTime;
    private boolean isForwardToLibraryOrTemple;
    private boolean isNeedLeaveRoom;
    private int isNoticeTimes;
    private boolean isShowFocus;
    private boolean playingBgPag;
    private ProgressDrawable progressDrawable;
    private FloatingSphereInfo sphereInfo;
    private final FocusDialogTips focusDialog = FocusDialogTips.INSTANCE;
    private String endFocusStatText = "";
    private IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
    private String seatDefaultText = "";
    private String currentNoticeText = "";
    private final IVasSquareFocusService sphereService = (IVasSquareFocusService) Square.INSTANCE.getConfig().getRapier().b(IVasSquareFocusService.class);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/components/SquareGroupFloatingComponent$CountdownProgressListener;", "Lcom/tencent/state/view/ProgressDrawable$OnCountdownProgressListener;", "result", "Lcom/tencent/state/template/data/FloatingSphereInfo;", HippyQQConstants.URL_COMPONENT_NAME, "Lcom/tencent/state/square/components/SquareGroupFloatingComponent;", "(Lcom/tencent/state/template/data/FloatingSphereInfo;Lcom/tencent/state/square/components/SquareGroupFloatingComponent;)V", "componentRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getResult", "()Lcom/tencent/state/template/data/FloatingSphereInfo;", "onProgress", "", "progress", "", "onProgressEnd", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class CountdownProgressListener implements ProgressDrawable.OnCountdownProgressListener {
        private final WeakReference<SquareGroupFloatingComponent> componentRef;
        private final FloatingSphereInfo result;

        public CountdownProgressListener(FloatingSphereInfo result, SquareGroupFloatingComponent component) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(component, "component");
            this.result = result;
            this.componentRef = new WeakReference<>(component);
        }

        public final FloatingSphereInfo getResult() {
            return this.result;
        }

        @Override // com.tencent.state.view.ProgressDrawable.OnCountdownProgressListener
        public void onProgress(float progress) {
            String str;
            SquareGroupFloatingComponent squareGroupFloatingComponent = this.componentRef.get();
            if (squareGroupFloatingComponent != null) {
                Intrinsics.checkNotNullExpressionValue(squareGroupFloatingComponent, "componentRef.get() ?: return");
                int maxLifeSeconds = (int) (this.result.getMaxLifeSeconds() * progress);
                if (maxLifeSeconds < 60) {
                    squareGroupFloatingComponent.playBgPag(PagStaticList.TIMEOUT_CALLBACK_PAG, Integer.MAX_VALUE);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(maxLifeSeconds);
                    sb5.append('\u79d2');
                    str = sb5.toString();
                } else {
                    str = squareGroupFloatingComponent.seatDefaultText;
                }
                String str2 = str;
                if (!Intrinsics.areEqual(str2, squareGroupFloatingComponent.currentNoticeText)) {
                    SquareGroupFloatingComponent.noticeText$default(squareGroupFloatingComponent, str2, false, 0, 0, 12, null);
                }
            }
        }

        @Override // com.tencent.state.view.ProgressDrawable.OnCountdownProgressListener
        public void onProgressEnd() {
            SquareGroupFloatingComponent squareGroupFloatingComponent = this.componentRef.get();
            if (squareGroupFloatingComponent != null) {
                Intrinsics.checkNotNullExpressionValue(squareGroupFloatingComponent, "componentRef.get() ?: return");
                squareGroupFloatingComponent.stopCountDown("progressEnd");
                squareGroupFloatingComponent.playingBgPag = false;
            }
        }
    }

    private final boolean checkRootIsVisible() {
        CommonDragView commonDragView;
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
        return (vasSquareGroupFragmentSquareBinding == null || (commonDragView = vasSquareGroupFragmentSquareBinding.floatingCallback) == null || commonDragView.getVisibility() != 0) ? false : true;
    }

    private final void getEndFocusStatText() {
        new VasLibraryStatisticsService().getUserFocusStatistics(new Function1<String, Unit>() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$getEndFocusStatText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareGroupFloatingComponent.this.endFocusStatText = it;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r1.getScene() == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Object> getReportParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FloatingSphereInfo floatingSphereInfo = this.sphereInfo;
        int i3 = floatingSphereInfo != null ? 1 : 2;
        linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_HOVER_BALL_TYPE, Integer.valueOf(i3));
        return linkedHashMap;
    }

    private final IVasBaseServiceProvider getServiceProvider() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareGroupServiceComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareGroupServiceComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareGroupServiceComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareGroupServiceComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        return (IVasBaseServiceProvider) fragmentComponent;
    }

    private final void initPagPlayer(FrameLayout view, final String pagFile, final int repeatTimes) {
        FrameLayout mRv;
        final Context context;
        View view2;
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
        if (vasSquareGroupFragmentSquareBinding == null || (mRv = vasSquareGroupFragmentSquareBinding.getMRv()) == null || (context = mRv.getContext()) == null) {
            return;
        }
        view.removeAllViews();
        ISquarePagView pagView = SquareBaseKt.getSquareCommon().getPagView(context);
        if (pagView == null || (view2 = pagView.getView()) == null) {
            return;
        }
        view.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        final WeakReference weakReference = new WeakReference(this);
        final WeakReference weakReference2 = new WeakReference(pagView);
        final WeakReference weakReference3 = new WeakReference(view);
        SquarePagFileUtils.INSTANCE.downloadPagFile(pagFile, new SimplePagDownloadListener() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$initPagPlayer$$inlined$run$lambda$1
            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                SquareGroupFloatingComponent squareGroupFloatingComponent;
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().d("SquareGroupFloatingComponent", "onTaskFailed: " + errorCode + ", " + errorMessage);
                FrameLayout frameLayout = (FrameLayout) weakReference3.get();
                if (frameLayout == null || frameLayout.getId() != R.id.pun || (squareGroupFloatingComponent = (SquareGroupFloatingComponent) weakReference.get()) == null) {
                    return;
                }
                squareGroupFloatingComponent.playingBgPag = false;
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                SquareBaseKt.getSquareLog().d("SquareGroupFloatingComponent", "onTaskSuccess");
                SquareGroupFloatingComponent squareGroupFloatingComponent = (SquareGroupFloatingComponent) weakReference.get();
                if (squareGroupFloatingComponent != null) {
                    squareGroupFloatingComponent.onPagDownloaded(resultFile, weakReference2, weakReference3, repeatTimes);
                }
            }
        });
    }

    private final void initReport() {
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
        if (vasSquareGroupFragmentSquareBinding != null) {
            IReporter iReporter = this.reporter;
            CommonDragView commonDragView = vasSquareGroupFragmentSquareBinding.floatingCallback;
            Intrinsics.checkNotNullExpressionValue(commonDragView, "binding.floatingCallback");
            iReporter.setElementInfo(commonDragView, SquareReportConst.ElementId.ELEMENT_ID_LIBRARY_FLOAT_BALL, getReportParams(), false, false);
            IReporter iReporter2 = this.reporter;
            SquareImageView squareImageView = vasSquareGroupFragmentSquareBinding.floatingCallbackClose;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.floatingCallbackClose");
            IReporter.DefaultImpls.setElementInfo$default(iReporter2, squareImageView, SquareReportConst.ElementId.ELEMENT_ID_LIBRARY_FLOAT_BALL_CLOSE, getReportParams(), false, false, 8, null);
        }
    }

    private final void initTextSwitcher() {
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding;
        TextSwitcher textSwitcher;
        final QBaseActivity activity = getActivity();
        if (activity == null || (vasSquareGroupFragmentSquareBinding = this.binding) == null || (textSwitcher = vasSquareGroupFragmentSquareBinding.libraryCallbackTips) == null) {
            return;
        }
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$initTextSwitcher$$inlined$apply$lambda$1
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                TextView textView = new TextView(activity);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                textView.setTextSize(11.0f);
                textView.setGravity(17);
                textView.setTextColor(-1);
                return textView;
            }
        });
        Intrinsics.checkNotNullExpressionValue(textSwitcher, "this");
        safelySetText(textSwitcher, this.currentNoticeText);
    }

    private final void initView() {
        CommonDragView commonDragView;
        SquareImageView squareImageView;
        CommonDragView commonDragView2;
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
        if (vasSquareGroupFragmentSquareBinding != null && (commonDragView2 = vasSquareGroupFragmentSquareBinding.floatingCallback) != null) {
            commonDragView2.setOnClickListener(this);
        }
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding2 = this.binding;
        if (vasSquareGroupFragmentSquareBinding2 != null && (squareImageView = vasSquareGroupFragmentSquareBinding2.floatingCallbackClose) != null) {
            squareImageView.setOnClickListener(this);
        }
        initReport();
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding3 = this.binding;
        if (vasSquareGroupFragmentSquareBinding3 == null || (commonDragView = vasSquareGroupFragmentSquareBinding3.floatingCallback) == null) {
            return;
        }
        commonDragView.actionUp(new Function0<Unit>() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$initView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IReporter iReporter;
                Map<String, Object> reportParams;
                iReporter = SquareGroupFloatingComponent.this.reporter;
                reportParams = SquareGroupFloatingComponent.this.getReportParams();
                iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_EV_ZPLAN_HOVER_BALL_DRAGGING, reportParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPagDownloaded(File resultFile, WeakReference<ISquarePagView> pagViewRef, WeakReference<FrameLayout> containerViewRef, int repeatTimes) {
        ISquarePagView iSquarePagView;
        if (checkRootIsVisible() && (iSquarePagView = pagViewRef.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(iSquarePagView, "pagViewRef.get() ?: return");
            final FrameLayout frameLayout = containerViewRef.get();
            if (frameLayout != null) {
                Intrinsics.checkNotNullExpressionValue(frameLayout, "containerViewRef.get() ?: return");
                if (frameLayout.getId() != R.id.pun || this.playingBgPag) {
                    iSquarePagView.setPagViewListener(new SimpleSquarePagViewListener() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$onPagDownloaded$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(null, 1, null);
                        }

                        @Override // com.tencent.state.square.api.SimpleSquarePagViewListener, com.tencent.state.square.api.ISquarePagViewListener
                        public void onAnimationEnd(ISquarePagView squarePagView) {
                            frameLayout.removeAllViews();
                            if (frameLayout.getId() == R.id.pun) {
                                SquareGroupFloatingComponent.this.playingBgPag = false;
                            }
                        }
                    });
                    SquareBaseKt.getSquareThread().postOnUi(new SquareGroupFloatingComponent$onPagDownloaded$2(iSquarePagView, resultFile, repeatTimes));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playBgPag(String pagFile, int repeatTimes) {
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
        FrameLayout frameLayout = vasSquareGroupFragmentSquareBinding != null ? vasSquareGroupFragmentSquareBinding.floatingCallbackCirclePag : null;
        if (this.playingBgPag) {
            if ((frameLayout != null ? frameLayout.getChildCount() : 0) > 0) {
                return;
            }
        }
        this.playingBgPag = true;
        if (frameLayout != null) {
            initPagPlayer(frameLayout, pagFile, repeatTimes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playNoticePag(String pagFile) {
        FrameLayout it;
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
        if (vasSquareGroupFragmentSquareBinding == null || (it = vasSquareGroupFragmentSquareBinding.floatingNoticePag) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        initPagPlayer(it, pagFile, 1);
    }

    private final void safelySetCurrentText(TextSwitcher textSwitcher, String text) {
        try {
            textSwitcher.setCurrentText(text);
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "safelySetCurrentText err.", th5);
        }
    }

    private final void safelySetText(TextSwitcher textSwitcher, String text) {
        try {
            textSwitcher.setText(text);
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "safelySetText err:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFocusRelatedDialog(boolean isBackFromLibOrTemple, FloatingLeveTip result) {
        QBaseActivity activity = getActivity();
        if (activity == null || this.isForwardToLibraryOrTemple || !isBackFromLibOrTemple) {
            return;
        }
        SceneCommonDialogs.INSTANCE.showKeepSceneTimeTipsDialog(activity, result);
    }

    private final void updateCallBack(final boolean isBackFromLibraryOrTemple) {
        SquareBaseKt.getSquareLog().i(TAG, "[EndFocus] updateLibraryCallBack: isBackFrom=" + isBackFromLibraryOrTemple);
        SimpleEventBus.getInstance().dispatchEvent(new RefreshSquareAvatarFootLabelEvent());
        stopCountDown("updateCallBack");
        this.sphereService.getSceneInfo(new e()).a(new b<f>() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$updateCallBack$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareGroupFloatingComponent", "getSceneInfo failed: " + errorCode + ", " + errorMessage, null, 4, null);
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0109, code lost:
            
                r1 = r11.this$0.binding;
             */
            @Override // com.tencent.rapier.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSuccess(f response) {
                FloatingSphereInfo floatingSphereInfo;
                ProgressDrawable progressDrawable;
                ProgressDrawable progressDrawable2;
                ProgressDrawable progressDrawable3;
                VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding;
                ProgressDrawable progressDrawable4;
                VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding2;
                ProgressDrawable progressDrawable5;
                VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding3;
                CommonDragView commonDragView;
                VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding4;
                SquareImageView squareImageView;
                View view;
                ProgressDrawable progressDrawable6;
                IReporter iReporter;
                Map<String, Object> reportParams;
                IReporter iReporter2;
                Map<String, Object> reportParams2;
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("SquareGroupFloatingComponent", "getSceneInfo success: " + response);
                d dVar = response.f400618b;
                if (dVar == null) {
                    return;
                }
                SquareGroupFloatingComponent squareGroupFloatingComponent = SquareGroupFloatingComponent.this;
                Intrinsics.checkNotNullExpressionValue(dVar, "response.sphereInfo");
                squareGroupFloatingComponent.sphereInfo = new FloatingSphereInfo(dVar);
                floatingSphereInfo = SquareGroupFloatingComponent.this.sphereInfo;
                if (floatingSphereInfo != null) {
                    progressDrawable = SquareGroupFloatingComponent.this.progressDrawable;
                    if (progressDrawable != null) {
                        progressDrawable.stop();
                    }
                    SquareGroupFloatingComponent.this.progressDrawable = new ProgressDrawable(ProgressDrawableStyle.RECT);
                    progressDrawable2 = SquareGroupFloatingComponent.this.progressDrawable;
                    if (progressDrawable2 != null) {
                        progressDrawable2.setTimeMillis(floatingSphereInfo.getMaxLifeSeconds() * 1000);
                    }
                    progressDrawable3 = SquareGroupFloatingComponent.this.progressDrawable;
                    if (progressDrawable3 != null) {
                        progressDrawable3.setStartOffset(floatingSphereInfo.pastTime());
                    }
                    SquareGroupFloatingComponent.this.focusStartTime = floatingSphereInfo.getStartTs();
                    SquareGroupFloatingComponent.this.isShowFocus = true;
                    SquareGroupFloatingComponent.this.seatDefaultText = floatingSphereInfo.getTip();
                    vasSquareGroupFragmentSquareBinding = SquareGroupFloatingComponent.this.binding;
                    if (vasSquareGroupFragmentSquareBinding != null) {
                        iReporter = SquareGroupFloatingComponent.this.reporter;
                        SquareImageView squareImageView2 = vasSquareGroupFragmentSquareBinding.floatingCallbackClose;
                        Intrinsics.checkNotNullExpressionValue(squareImageView2, "it.floatingCallbackClose");
                        reportParams = SquareGroupFloatingComponent.this.getReportParams();
                        iReporter.reportEvent("imp", squareImageView2, reportParams);
                        iReporter2 = SquareGroupFloatingComponent.this.reporter;
                        CommonDragView commonDragView2 = vasSquareGroupFragmentSquareBinding.floatingCallback;
                        Intrinsics.checkNotNullExpressionValue(commonDragView2, "it.floatingCallback");
                        reportParams2 = SquareGroupFloatingComponent.this.getReportParams();
                        iReporter2.reportEvent("imp", commonDragView2, reportParams2);
                    }
                    progressDrawable4 = SquareGroupFloatingComponent.this.progressDrawable;
                    if (progressDrawable4 != null) {
                        progressDrawable4.setCountdownProgressListener(new SquareGroupFloatingComponent.CountdownProgressListener(floatingSphereInfo, SquareGroupFloatingComponent.this));
                    }
                    vasSquareGroupFragmentSquareBinding2 = SquareGroupFloatingComponent.this.binding;
                    if (vasSquareGroupFragmentSquareBinding2 != null && (view = vasSquareGroupFragmentSquareBinding2.countDownCircle) != null) {
                        progressDrawable6 = SquareGroupFloatingComponent.this.progressDrawable;
                        view.setBackground(progressDrawable6);
                    }
                    progressDrawable5 = SquareGroupFloatingComponent.this.progressDrawable;
                    if (progressDrawable5 != null) {
                        progressDrawable5.start();
                    }
                    if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, floatingSphereInfo.getUrl(), false, 2, null) && vasSquareGroupFragmentSquareBinding4 != null && (squareImageView = vasSquareGroupFragmentSquareBinding4.floatingCallbackImage) != null) {
                        squareImageView.setImageDrawable(URLDrawable.getDrawable(floatingSphereInfo.getUrl(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
                    }
                    vasSquareGroupFragmentSquareBinding3 = SquareGroupFloatingComponent.this.binding;
                    if (vasSquareGroupFragmentSquareBinding3 != null && (commonDragView = vasSquareGroupFragmentSquareBinding3.floatingCallback) != null) {
                        commonDragView.setVisibility(0);
                    }
                    SquareGroupFloatingComponent squareGroupFloatingComponent2 = SquareGroupFloatingComponent.this;
                    boolean z16 = isBackFromLibraryOrTemple;
                    c[] cVarArr = response.f400619c;
                    Intrinsics.checkNotNullExpressionValue(cVarArr, "response.leaveTips");
                    ArrayList arrayList = new ArrayList();
                    for (c cVar : cVarArr) {
                        if (cVar.f26879a == floatingSphereInfo.getScene()) {
                            arrayList.add(cVar);
                        }
                    }
                    Object obj = arrayList.get(0);
                    Intrinsics.checkNotNullExpressionValue(obj, "response.leaveTips.filter { it.scene == scene }[0]");
                    squareGroupFloatingComponent2.showFocusRelatedDialog(z16, new FloatingLeveTip((c) obj));
                }
            }
        });
        getEndFocusStatText();
    }

    public final void exitSquareEndFocusDialog(final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QBaseActivity activity = getActivity();
        if (this.isShowFocus && activity != null) {
            String convertTime = FormatUtils.INSTANCE.convertTime(Square.INSTANCE.getConfig().getCommonUtils().getServerTime() - this.focusStartTime);
            Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$exitSquareEndFocusDialog$dialogCallback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        SquareGroupFloatingComponent.this.isShowFocus = false;
                        callback.invoke();
                    }
                }
            };
            FloatingSphereInfo floatingSphereInfo = this.sphereInfo;
            Integer valueOf = floatingSphereInfo != null ? Integer.valueOf(floatingSphereInfo.getScene()) : null;
            if (valueOf != null && valueOf.intValue() == 1) {
                this.focusDialog.showEndFocusDialog(activity, convertTime, this.endFocusStatText, function1);
                return;
            }
            return;
        }
        callback.invoke();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        ISquarePushService pushService;
        Intrinsics.checkNotNullParameter(f16, "f");
        SquareBaseKt.getSquareLog().i(TAG, "doOnActivityDestroyed");
        if (this.isNeedLeaveRoom) {
            FloatingSphereInfo floatingSphereInfo = this.sphereInfo;
            Integer valueOf = floatingSphereInfo != null ? Integer.valueOf(floatingSphereInfo.getScene()) : null;
            if (valueOf != null && valueOf.intValue() == 1) {
                ITemplateRoomService.DefaultImpls.leaveRoom$default(VasLibraryRoomService.INSTANCE, null, 1, null);
            }
        }
        IVasBaseServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider == null || (pushService = serviceProvider.getPushService()) == null) {
            return;
        }
        pushService.removeListener(6, this);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intent intent;
        Bundle extras;
        ISquarePushService pushService;
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareGroupFragmentSquareBinding.bind(v3);
        initView();
        QBaseActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(extras, "activity?.intent?.extras ?: return");
        boolean z16 = Intrinsics.areEqual(extras.getString(SquareConstants.KEY_FORWARD_TO_LIBRARY), "1") || Intrinsics.areEqual(extras.getString(SquareConstants.KEY_FORWARD_TO_TEMPLE), "1");
        this.isForwardToLibraryOrTemple = z16;
        if (!z16) {
            updateCallBack$default(this, false, 1, null);
        }
        initTextSwitcher();
        IVasBaseServiceProvider serviceProvider = getServiceProvider();
        if (serviceProvider == null || (pushService = serviceProvider.getPushService()) == null) {
            return;
        }
        pushService.addListener(6, this);
    }

    @Override // com.tencent.state.square.api.ISquarePushListener
    public void onResult(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (checkRootIsVisible()) {
                final a c16 = a.c(data);
                SquareBaseKt.getSquareLog().i(TAG, "PushListener " + c16.toString());
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$onResult$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        int i3;
                        int i16;
                        IReporter iReporter;
                        Map<String, Object> reportParams;
                        i3 = SquareGroupFloatingComponent.this.isNoticeTimes;
                        if (i3 < 0) {
                            SquareGroupFloatingComponent.this.isNoticeTimes = 0;
                        }
                        SquareGroupFloatingComponent squareGroupFloatingComponent = SquareGroupFloatingComponent.this;
                        i16 = squareGroupFloatingComponent.isNoticeTimes;
                        int i17 = 1;
                        squareGroupFloatingComponent.isNoticeTimes = i16 + 1;
                        SquareGroupFloatingComponent squareGroupFloatingComponent2 = SquareGroupFloatingComponent.this;
                        String str = c16.f391816b;
                        Intrinsics.checkNotNullExpressionValue(str, "info.floatingText");
                        SquareGroupFloatingComponent.noticeText$default(squareGroupFloatingComponent2, str, true, 0, 0, 12, null);
                        Square.INSTANCE.getConfig().getCommonUtils().phoneVibrate(2, 200L);
                        a aVar = c16;
                        int i18 = aVar.f391815a;
                        if (i18 == 1) {
                            SquareGroupFloatingComponent.this.playNoticePag(PagStaticList.LIBRARY_CALLBACK_CHEER_UP_PAG);
                        } else if (i18 == 2) {
                            SquareGroupFloatingComponent.this.playNoticePag(aVar.f391818d == 1 ? PagStaticList.LIBRARY_CALLBACK_NOTICE_BOY_PAG : PagStaticList.LIBRARY_CALLBACK_NOTICE_GIRL_PAG);
                            i17 = 2;
                        }
                        SquareGroupFloatingComponent.this.playBgPag(PagStaticList.LIBRARY_CALLBACK_NOTICE_PAG, 2);
                        SquareBaseKt.getSquareThread().postOnUiDelayed(c16.f391817c, new Function0<Unit>() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$onResult$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                int i19;
                                int i26;
                                i19 = SquareGroupFloatingComponent.this.isNoticeTimes;
                                if (i19 <= 1) {
                                    SquareGroupFloatingComponent.this.noticeText("", true, android.R.anim.fade_in, android.R.anim.fade_out);
                                }
                                SquareGroupFloatingComponent squareGroupFloatingComponent3 = SquareGroupFloatingComponent.this;
                                i26 = squareGroupFloatingComponent3.isNoticeTimes;
                                squareGroupFloatingComponent3.isNoticeTimes = i26 - 1;
                            }
                        });
                        iReporter = SquareGroupFloatingComponent.this.reporter;
                        reportParams = SquareGroupFloatingComponent.this.getReportParams();
                        reportParams.put(SquareReportConst.Key.KEY_ZPLAN_NOTIFICATION_TYPE, Integer.valueOf(i17));
                        Unit unit = Unit.INSTANCE;
                        iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_HOVER_BALL_INFORMATION_NOTIFICATION, reportParams);
                    }
                });
            }
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "PushListener parse error " + th5, null, 4, null);
        }
    }

    public final void resetPosition() {
        CommonDragView commonDragView;
        final QBaseActivity activity = getActivity();
        if (activity != null) {
            VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
            if (vasSquareGroupFragmentSquareBinding != null && (commonDragView = vasSquareGroupFragmentSquareBinding.floatingCallback) != null) {
                ViewExtensionsKt.updateLayoutParams(commonDragView, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$resetPosition$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                        invoke2(layoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FrameLayout.LayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.gravity = 85;
                        receiver.setMargins(0, 0, com.tencent.state.square.common.ViewExtensionsKt.dip((Context) QBaseActivity.this, 18), com.tencent.state.square.common.ViewExtensionsKt.dip((Context) QBaseActivity.this, 125));
                    }
                });
            }
            SquareBaseKt.getSquareLog().i(TAG, "resetPosition");
        }
    }

    public final void stopCountDown(String from) {
        FrameLayout frameLayout;
        CommonDragView commonDragView;
        Intrinsics.checkNotNullParameter(from, "from");
        if (checkRootIsVisible()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$stopCountDown$1
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleEventBus.getInstance().dispatchEvent(new RefreshSquareAvatarFootLabelEvent());
                }
            }, 500L);
            SquareBaseKt.getSquareLog().i(TAG, "[EndFocus] stopCountDown, from\uff1a" + from + ", drawable=" + this.progressDrawable);
            VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
            if (vasSquareGroupFragmentSquareBinding != null && (commonDragView = vasSquareGroupFragmentSquareBinding.floatingCallback) != null) {
                commonDragView.setVisibility(8);
            }
            ProgressDrawable progressDrawable = this.progressDrawable;
            if (progressDrawable != null) {
                progressDrawable.stop();
            }
            ProgressDrawable progressDrawable2 = this.progressDrawable;
            if (progressDrawable2 != null) {
                progressDrawable2.setCountdownProgressListener(null);
            }
            this.progressDrawable = null;
            this.isShowFocus = false;
            VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding2 = this.binding;
            if (vasSquareGroupFragmentSquareBinding2 != null && (frameLayout = vasSquareGroupFragmentSquareBinding2.floatingCallbackCirclePag) != null) {
                frameLayout.removeAllViews();
            }
            this.playingBgPag = false;
            VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding3 = this.binding;
            if (vasSquareGroupFragmentSquareBinding3 != null) {
                IReporter iReporter = this.reporter;
                SquareImageView squareImageView = vasSquareGroupFragmentSquareBinding3.floatingCallbackClose;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "it.floatingCallbackClose");
                iReporter.reportEvent("imp_end", squareImageView, getReportParams());
                IReporter iReporter2 = this.reporter;
                CommonDragView commonDragView2 = vasSquareGroupFragmentSquareBinding3.floatingCallback;
                Intrinsics.checkNotNullExpressionValue(commonDragView2, "it.floatingCallback");
                iReporter2.reportEvent("imp_end", commonDragView2, getReportParams());
            }
        }
    }

    public final void onBackFromLibraryOrTemple(Intent intent) {
        updateCallBack(true);
        this.isNeedLeaveRoom = intent != null ? intent.getBooleanExtra(SquareConstants.KEY_NEED_LEAVE_ROOM, false) : false;
        SquareBaseKt.getSquareLog().i(TAG, "[EndFocus] onBackFromLibrary, needLeaveRoom:" + this.isNeedLeaveRoom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void noticeText(String text, boolean needAnim, int inAnim, int outAnim) {
        TextSwitcher textSwitcher;
        if (!(text == null || text.length() == 0)) {
            this.currentNoticeText = text;
        }
        VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
        if (vasSquareGroupFragmentSquareBinding == null || (textSwitcher = vasSquareGroupFragmentSquareBinding.libraryCallbackTips) == null) {
            return;
        }
        if (needAnim) {
            textSwitcher.setInAnimation(AnimationUtils.loadAnimation(textSwitcher.getContext(), inAnim));
            textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(textSwitcher.getContext(), outAnim));
            Intrinsics.checkNotNullExpressionValue(textSwitcher, "this");
            safelySetText(textSwitcher, this.currentNoticeText);
            return;
        }
        if (this.isNoticeTimes == 0) {
            Intrinsics.checkNotNullExpressionValue(textSwitcher, "this");
            safelySetCurrentText(textSwitcher, this.currentNoticeText);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        String jumpUrl;
        QBaseActivity activity;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.pum) {
            FloatingSphereInfo floatingSphereInfo = this.sphereInfo;
            if (floatingSphereInfo == null || (jumpUrl = floatingSphereInfo.getJumpUrl()) == null || (activity = getActivity()) == null) {
                return;
            }
            stopCountDown("jumpPage");
            SquareBaseKt.getSquareRouter().routeLink(activity, new EntranceLink(jumpUrl, 2));
            VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
            if (vasSquareGroupFragmentSquareBinding != null) {
                IReporter iReporter = this.reporter;
                CommonDragView floatingCallback = vasSquareGroupFragmentSquareBinding.floatingCallback;
                Intrinsics.checkNotNullExpressionValue(floatingCallback, "floatingCallback");
                iReporter.reportEvent("clck", floatingCallback, getReportParams());
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.puo) {
            long serverTime = Square.INSTANCE.getConfig().getCommonUtils().getServerTime();
            final QBaseActivity activity2 = getActivity();
            if (activity2 != null) {
                String convertTime = FormatUtils.INSTANCE.convertTime(serverTime - this.focusStartTime);
                Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.SquareGroupFloatingComponent$onClick$callback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        FloatingSphereInfo floatingSphereInfo2;
                        String str;
                        if (z16) {
                            floatingSphereInfo2 = SquareGroupFloatingComponent.this.sphereInfo;
                            Integer valueOf2 = floatingSphereInfo2 != null ? Integer.valueOf(floatingSphereInfo2.getScene()) : null;
                            if (valueOf2 != null && valueOf2.intValue() == 1) {
                                ITemplateRoomService.DefaultImpls.standUp$default(VasLibraryRoomService.INSTANCE, "BallCloseButton", null, 2, null);
                                str = activity2.getString(R.string.xg8);
                                Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.stri\u2026e_library_end_focus_tips)");
                            } else {
                                str = "";
                            }
                            Square.INSTANCE.getConfig().getCommonUtils().showToast(activity2, str, 2);
                            SquareGroupFloatingComponent.this.stopCountDown("close");
                        }
                    }
                };
                FloatingSphereInfo floatingSphereInfo2 = this.sphereInfo;
                Integer valueOf2 = floatingSphereInfo2 != null ? Integer.valueOf(floatingSphereInfo2.getScene()) : null;
                if (valueOf2 != null && valueOf2.intValue() == 1) {
                    this.focusDialog.showEndFocusDialog(activity2, convertTime, this.endFocusStatText, function1);
                }
                VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding2 = this.binding;
                if (vasSquareGroupFragmentSquareBinding2 != null) {
                    IReporter iReporter2 = this.reporter;
                    SquareImageView squareImageView = vasSquareGroupFragmentSquareBinding2.floatingCallbackClose;
                    Intrinsics.checkNotNullExpressionValue(squareImageView, "it.floatingCallbackClose");
                    iReporter2.reportEvent("clck", squareImageView, getReportParams());
                }
            }
        }
    }

    static /* synthetic */ void updateCallBack$default(SquareGroupFloatingComponent squareGroupFloatingComponent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        squareGroupFloatingComponent.updateCallBack(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void noticeText$default(SquareGroupFloatingComponent squareGroupFloatingComponent, String str, boolean z16, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i3 = R.anim.f154352j9;
        }
        if ((i17 & 8) != 0) {
            i16 = R.anim.j_;
        }
        squareGroupFloatingComponent.noticeText(str, z16, i3, i16);
    }
}
