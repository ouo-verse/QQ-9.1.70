package com.tencent.state.square.detail;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.detail.event.DetailMeGetNoviceGuideConfigEvent;
import com.tencent.state.square.guide.CreateRoleGuideConfig;
import com.tencent.state.square.guide.CreateRoleRedDotBubbleConfig;
import com.tencent.state.square.guide.PublishStatusGuideConfig;
import com.tencent.state.square.guide.SquareNoviceGuideConfig;
import com.tencent.state.square.mmkv.IMMKV;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0006\u0010\u001c\u001a\u00020\u0015J\b\u0010\u001d\u001a\u00020\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u0015J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u0006\u0010 \u001a\u00020\u0015J\b\u0010!\u001a\u00020\u0015H\u0002J,\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010'\u001a\u00020\u0015H\u0002J \u0010(\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/square/detail/DetailMeDressBubbleHelper;", "", "selectedView", "Lcom/tencent/state/square/detail/DetailSelectMeView;", "(Lcom/tencent/state/square/detail/DetailSelectMeView;)V", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "destroyed", "", "dressGuideBubble", "Lcom/tencent/state/square/detail/DetailMeDressTipsBubble;", "dressIcon", "Landroid/widget/RelativeLayout;", "hasClickDressIcon", "redDotView", "Landroid/view/View;", "registered", "getSelectedView", "()Lcom/tencent/state/square/detail/DetailSelectMeView;", "canShowDetailMeDressRedDot", "clickBubble", "", "clickDressIcon", "doOnClick", "hideBubble", "from", "", "hideRedDotView", "initConfig", "isRedDotViewVisible", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "recordClickDetailMeDressGuide", "recordPublishStatus", "recordShowedDetailMeDressGuide", "refreshCreateRoleRedDot", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "refreshPublishBtnText", "showBubble", "tips", "duration", "", "showRedDotView", "syncRolePageResult", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailMeDressBubbleHelper {
    private static final String TAG = "DetailMeDressBubbleHelper";
    private SquareNoviceGuideConfig config;
    private boolean destroyed;
    private DetailMeDressTipsBubble dressGuideBubble;
    private final RelativeLayout dressIcon;
    private boolean hasClickDressIcon;
    private final View redDotView;
    private boolean registered;
    private final DetailSelectMeView selectedView;

    public DetailMeDressBubbleHelper(DetailSelectMeView selectedView) {
        Intrinsics.checkNotNullParameter(selectedView, "selectedView");
        this.selectedView = selectedView;
        RelativeLayout relativeLayout = selectedView.getBinding().operatorContainer.operatorEnterDressMallContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "selectedView.binding.ope\u2026orEnterDressMallContainer");
        this.dressIcon = relativeLayout;
        View view = selectedView.getBinding().operatorContainer.operatorDressMallRedDot;
        Intrinsics.checkNotNullExpressionValue(view, "selectedView.binding.ope\u2026r.operatorDressMallRedDot");
        this.redDotView = view;
    }

    private final boolean canShowDetailMeDressRedDot(SquareNoviceGuideConfig config) {
        if (this.hasClickDressIcon || config.getCreateRoleGuideConfig().getAlreadyCreateRole() || IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.HAS_CLICK_DETAIL_ME_DRESS_GUIDE, false, null, false, 12, null)) {
            return false;
        }
        return (config.getCreateRoleGuideConfig().getCreateRoleRedDotBubbleConfig().isLimitFreq() && IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.HAS_SHOW_DETAIL_ME_DRESS_RED_DOT, false, null, false, 12, null)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickBubble() {
        doOnClick();
    }

    private final void hideRedDotView() {
        this.redDotView.setVisibility(8);
    }

    private final boolean isRedDotViewVisible() {
        return this.redDotView.getVisibility() == 0;
    }

    private final void recordClickDetailMeDressGuide() {
        IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.HAS_CLICK_DETAIL_ME_DRESS_GUIDE, true, null, false, 12, null);
    }

    private final void recordShowedDetailMeDressGuide() {
        IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.HAS_SHOW_DETAIL_ME_DRESS_RED_DOT, true, null, false, 12, null);
    }

    private final void refreshPublishBtnText() {
        PublishStatusGuideConfig publishStatusGuideConfig;
        TextView textView = this.selectedView.getBinding().chatOrStatusText;
        boolean decodeBool$default = IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.HAS_CLICK_PUBLISH_BTN, false, null, false, 12, null);
        SquareBaseKt.getSquareLog().i(TAG, "[NoviceGuide] refreshPublishBtnText, clicked:" + decodeBool$default);
        Context context = textView.getContext();
        SquareNoviceGuideConfig squareNoviceGuideConfig = this.config;
        textView.setText(context.getString(((squareNoviceGuideConfig == null || (publishStatusGuideConfig = squareNoviceGuideConfig.getPublishStatusGuideConfig()) == null || !publishStatusGuideConfig.getAlreadySetStatus()) && !decodeBool$default) ? R.string.xdo : R.string.f169751xe3));
    }

    private final void showBubble(FragmentActivity activity, String tips, final long duration) {
        hideBubble("reShow");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Context context = this.selectedView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "selectedView.context");
        DetailMeDressTipsBubble detailMeDressTipsBubble = new DetailMeDressTipsBubble(context, tips);
        detailMeDressTipsBubble.getBinding().getRoot().postDelayed(new Runnable() { // from class: com.tencent.state.square.detail.DetailMeDressBubbleHelper$showBubble$$inlined$apply$lambda$1
            @Override // java.lang.Runnable
            public final void run() {
                DetailMeDressBubbleHelper.this.hideBubble(WadlProxyConsts.PARAM_TIME_OUT);
            }
        }, duration);
        detailMeDressTipsBubble.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailMeDressBubbleHelper$showBubble$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailMeDressBubbleHelper.this.clickBubble();
            }
        });
        detailMeDressTipsBubble.showAsDropDown(this.dressIcon, ((-detailMeDressTipsBubble.getTipsWidth()) / 2) + (this.dressIcon.getWidth() / 2), ((-this.dressIcon.getHeight()) - detailMeDressTipsBubble.getTipsHeight()) - ViewExtensionsKt.dip(this.selectedView.getContext(), 6));
        Unit unit = Unit.INSTANCE;
        this.dressGuideBubble = detailMeDressTipsBubble;
    }

    private final void showRedDotView() {
        this.redDotView.setVisibility(0);
    }

    public final void clickDressIcon() {
        doOnClick();
    }

    public final DetailSelectMeView getSelectedView() {
        return this.selectedView;
    }

    public final void hideBubble(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        SquareBaseKt.getSquareLog().d(TAG, "hideBubble, " + from);
        DetailMeDressTipsBubble detailMeDressTipsBubble = this.dressGuideBubble;
        if (detailMeDressTipsBubble != null) {
            detailMeDressTipsBubble.dismiss();
        }
    }

    public final void initConfig() {
        SimpleEventBus.getInstance().dispatchEvent(new DetailMeGetNoviceGuideConfigEvent());
    }

    public final void onDestroy() {
        hideBubble(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.destroyed = true;
    }

    public final void recordPublishStatus() {
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.HAS_CLICK_PUBLISH_BTN, true, null, false, 12, null);
        refreshPublishBtnText();
    }

    public final void refreshCreateRoleRedDot(FragmentActivity activity, VasBaseFragment fragment, boolean registered, SquareNoviceGuideConfig config) {
        boolean isBlank;
        if (!this.registered) {
            this.registered = registered;
        }
        this.config = config;
        refreshPublishBtnText();
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[NoviceGuide] redDot: ");
        boolean z16 = true;
        sb5.append(activity == null);
        sb5.append(", ");
        sb5.append(fragment == null);
        sb5.append(", ");
        sb5.append(registered);
        sb5.append(", ");
        sb5.append(config);
        squareLog.d(TAG, sb5.toString());
        if (registered || activity == null || fragment == null || config == null) {
            return;
        }
        if (this.dressIcon.getVisibility() != 0) {
            SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] dressMall not showing");
            return;
        }
        if (!canShowDetailMeDressRedDot(config)) {
            SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] redDot can't show");
            return;
        }
        recordShowedDetailMeDressGuide();
        showRedDotView();
        String bubbleText = config.getCreateRoleGuideConfig().getCreateRoleRedDotBubbleConfig().getBubbleText();
        if (bubbleText != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(bubbleText);
            if (!isBlank) {
                z16 = false;
            }
        }
        if (z16) {
            return;
        }
        showBubble(activity, bubbleText, config.getCreateRoleGuideConfig().getCreateRoleRedDotBubbleConfig().getBubbleDisplayTime() * 1000);
    }

    private final void doOnClick() {
        DetailMeListener socialStatusListener;
        boolean isBlank;
        CreateRoleGuideConfig createRoleGuideConfig;
        CreateRoleRedDotBubbleConfig createRoleRedDotBubbleConfig;
        boolean z16 = true;
        this.hasClickDressIcon = true;
        SquareNoviceGuideConfig squareNoviceGuideConfig = this.config;
        String jumpSchema = (squareNoviceGuideConfig == null || (createRoleGuideConfig = squareNoviceGuideConfig.getCreateRoleGuideConfig()) == null || (createRoleRedDotBubbleConfig = createRoleGuideConfig.getCreateRoleRedDotBubbleConfig()) == null) ? null : createRoleRedDotBubbleConfig.getJumpSchema();
        boolean isRedDotViewVisible = isRedDotViewVisible();
        if (isRedDotViewVisible) {
            recordClickDetailMeDressGuide();
        }
        hideRedDotView();
        hideBubble(NodeProps.ON_CLICK);
        if (isRedDotViewVisible && !this.registered) {
            if (jumpSchema != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(jumpSchema);
                if (!isBlank) {
                    z16 = false;
                }
            }
            if (!z16) {
                IRouter squareRouter = SquareBaseKt.getSquareRouter();
                Context context = this.selectedView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "selectedView.context");
                squareRouter.routeLink(context, new EntranceLink(jumpSchema, 2));
                return;
            }
        }
        DetailSelectMeView detailSelectMeView = this.selectedView;
        if (detailSelectMeView == null || (socialStatusListener = detailSelectMeView.getSocialStatusListener()) == null) {
            return;
        }
        socialStatusListener.goToMall();
    }

    public final void syncRolePageResult(boolean registered) {
        if (registered) {
            if (!this.registered) {
                this.registered = registered;
            }
            hideBubble("syncRolePageResult");
            hideRedDotView();
        }
    }
}
