package com.tencent.troopguild.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.troopguild.dialog.data.TroopUpdateGuideDialogUIData;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J&\u0010\u000e\u001a\u00020\u0005*\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050%H\u0002J\b\u0010(\u001a\u00020\u0005H\u0002J\u0012\u0010*\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0+H\u0002J\u0012\u0010/\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00100\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J&\u00105\u001a\u0004\u0018\u00010\u00032\u0006\u00102\u001a\u0002012\b\u00104\u001a\u0004\u0018\u0001032\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010;\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0003J\u001a\u0010@\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010?\u001a\u0004\u0018\u00010>R\u0018\u0010C\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0018\u0010H\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010GR \u0010R\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010S\u00a8\u0006_"}, d2 = {"Lcom/tencent/troopguild/dialog/TroopUpgradeGuideDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/content/DialogInterface;", "Landroid/view/View;", "contentView", "", "wh", "Eh", "Landroid/widget/ImageView;", "", "imgUrl", "", "referWidth", "referHeight", "Ah", "Kh", "Nh", "root", "Mh", "Landroid/app/Dialog;", "dialog", "Bh", "Fh", "constraintHeight", "heightExceptImg", "constraintWidth", "widthExceptImg", "", "Rh", "windowWidth", "yh", "windowHeight", "xh", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lh", "", "skipAction", "Lkotlin/Function0;", "onClickAction", "Gh", "Hh", "view", "vh", "Lkotlin/Pair;", OcrConfig.CHINESE, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateDialog", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "cancel", "dismiss", "onDismiss", HippyNestedScrollComponent.PRIORITY_PARENT, "Jh", "Landroid/content/DialogInterface$OnClickListener;", "clickListener", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "Ih", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mPreviewImageView", "D", "mPreviewDynamicImageView", "E", "Landroid/view/View;", "mImageContainer", "Landroid/widget/Button;", UserInfo.SEX_FEMALE, "Landroid/widget/Button;", "mOpenBtn", "G", "mCloseBtn", "Ljava/lang/ref/WeakReference;", "H", "Ljava/lang/ref/WeakReference;", "mLogicViewParentWeakRef", "I", "Landroid/content/DialogInterface$OnClickListener;", "mDialogClickListener", "J", "Landroid/content/DialogInterface$OnDismissListener;", "mDialogDismissListener", "K", "mCloseTriggerType", "<init>", "()V", "L", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopUpgradeGuideDialogFragment extends BottomSheetDialogFragment implements DialogInterface {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView mPreviewImageView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView mPreviewDynamicImageView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mImageContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Button mOpenBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View mCloseBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private WeakReference<View> mLogicViewParentWeakRef;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnClickListener mDialogClickListener;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener mDialogDismissListener;

    /* renamed from: K, reason: from kotlin metadata */
    private int mCloseTriggerType = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/troopguild/dialog/TroopUpgradeGuideDialogFragment$b", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                TroopUpgradeGuideDialogFragment.this.dismissAllowingStateLoss();
            }
        }
    }

    private final void Ah(ImageView imageView, String str, int i3, int i16) {
        if (str != null) {
            ((ITroopGuildTempApi) QRoute.api(ITroopGuildTempApi.class)).loadImageByGuildPicLoader(str, imageView, TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(i16)), "TroopUpdateGuideDialogFragment");
        }
    }

    private final void Bh(Dialog dialog) {
        View findViewById;
        boolean z16;
        if (dialog != null && (findViewById = dialog.findViewById(R.id.ugk)) != null) {
            if (findViewById.getLayoutParams() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                findViewById = null;
            }
            if (findViewById != null) {
                findViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.troopguild.dialog.d
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                        TroopUpgradeGuideDialogFragment.Ch(TroopUpgradeGuideDialogFragment.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
                    }
                });
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.troopguild.dialog.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopUpgradeGuideDialogFragment.Dh(TroopUpgradeGuideDialogFragment.this, view);
                    }
                });
                findViewById.setOnTouchListener(null);
                findViewById.setBackgroundColor(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(TroopUpgradeGuideDialogFragment this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i17 - i3 != i27 - i19 || i26 - i28 != i16 - i18) {
            this$0.Fh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(TroopUpgradeGuideDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Eh() {
        TroopUpdateGuideDialogUIData troopUpdateGuideDialogUIData;
        Bundle arguments = getArguments();
        if (arguments != null && (troopUpdateGuideDialogUIData = (TroopUpdateGuideDialogUIData) arguments.getParcelable("ui_data")) != null) {
            Button button = this.mOpenBtn;
            if (button != null) {
                button.setText(troopUpdateGuideDialogUIData.getButtonText());
            }
            ImageView imageView = this.mPreviewImageView;
            if (imageView != null) {
                Ah(imageView, troopUpdateGuideDialogUIData.getImageUrl(), ViewUtils.dpToPx(396.0f), ViewUtils.dpToPx(530.0f));
            }
            ImageView imageView2 = this.mPreviewDynamicImageView;
            if (imageView2 != null) {
                Ah(imageView2, troopUpdateGuideDialogUIData.getCom.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController.PROPS_GIFURL java.lang.String(), ViewUtils.dpToPx(300.0f), ViewUtils.dpToPx(32.0f));
            }
        }
    }

    private final void Fh() {
        ViewGroup.LayoutParams layoutParams;
        if (!vh(getView())) {
            return;
        }
        Pair<Integer, Integer> zh5 = zh();
        Pair pair = TuplesKt.to(Integer.valueOf(yh(zh5.getFirst().intValue())), Integer.valueOf(xh(zh5.getSecond().intValue())));
        float Rh = Rh(((Number) pair.component2()).intValue(), ViewUtils.dpToPx(150.0f), ((Number) pair.component1()).intValue(), ViewUtils.dpToPx(32.0f));
        View view = this.mImageContainer;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.height = (int) Rh;
            layoutParams.width = (int) (Rh * 0.74764f);
        }
        View view2 = this.mImageContainer;
        if (view2 != null) {
            view2.requestLayout();
        }
        View view3 = getView();
        if (view3 != null) {
            view3.requestLayout();
        }
    }

    private final void Gh(boolean skipAction, Function0<Unit> onClickAction) {
        if (!(!skipAction)) {
            onClickAction = null;
        }
        if (onClickAction != null) {
            onClickAction.invoke();
        }
        VideoReport.reportEvent("dt_clck", this.mOpenBtn, null);
    }

    private final void Hh() {
        Map mapOf;
        int i3 = this.mCloseTriggerType;
        if (i3 != 0) {
            View view = this.mCloseBtn;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_pop_close_type", Integer.valueOf(i3)));
            VideoReport.reportEvent("dt_clck", view, mapOf);
        }
    }

    private final void Kh(View contentView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        contentView.setLayoutParams(layoutParams);
    }

    private final void Lh(View rootView) {
        View view;
        WeakReference<View> weakReference = this.mLogicViewParentWeakRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            VideoReport.setLogicParent(rootView, view);
        }
        VideoReport.setElementId(rootView, "em_group_aio_forum_upgrade");
        VideoReport.setElementExposePolicy(rootView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(rootView, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementId(this.mOpenBtn, "em_group_aio_forum_upgrade_go");
        VideoReport.setElementId(this.mCloseBtn, "em_group_aio_forum_upgrade_close");
        Button button = this.mOpenBtn;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(button, clickPolicy);
        VideoReport.setElementClickPolicy(this.mCloseBtn, clickPolicy);
        Button button2 = this.mOpenBtn;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(button2, exposurePolicy);
        VideoReport.setElementExposePolicy(this.mCloseBtn, exposurePolicy);
    }

    private final void Mh(View root) {
        View findViewById = root.findViewById(R.id.f10402627);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(2.5f));
        gradientDrawable.setColor(771751936);
        findViewById.setBackground(gradientDrawable);
    }

    private final void Nh(View contentView) {
        Button button = this.mOpenBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.troopguild.dialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopUpgradeGuideDialogFragment.Oh(TroopUpgradeGuideDialogFragment.this, view);
                }
            });
        }
        contentView.findViewById(R.id.az7).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.troopguild.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopUpgradeGuideDialogFragment.Ph(TroopUpgradeGuideDialogFragment.this, view);
            }
        });
        contentView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.troopguild.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopUpgradeGuideDialogFragment.Qh(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(final TroopUpgradeGuideDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCloseTriggerType = 0;
        this$0.Gh(false, new Function0<Unit>() { // from class: com.tencent.troopguild.dialog.TroopUpgradeGuideDialogFragment$setUpOnClickListener$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                DialogInterface.OnClickListener onClickListener;
                onClickListener = TroopUpgradeGuideDialogFragment.this.mDialogClickListener;
                if (onClickListener == null) {
                    return null;
                }
                onClickListener.onClick(TroopUpgradeGuideDialogFragment.this, -1);
                return Unit.INSTANCE;
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(TroopUpgradeGuideDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCloseTriggerType = 1;
        DialogInterface.OnClickListener onClickListener = this$0.mDialogClickListener;
        if (onClickListener == null) {
            this$0.dismissAllowingStateLoss();
        } else if (onClickListener != null) {
            onClickListener.onClick(this$0, -2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final float Rh(int constraintHeight, int heightExceptImg, int constraintWidth, int widthExceptImg) {
        float coerceAtMost;
        float coerceAtLeast;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(constraintHeight - heightExceptImg, (constraintWidth - widthExceptImg) / 0.74764f);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, 0.0f);
        return coerceAtLeast;
    }

    private final boolean vh(View view) {
        if (view != null && view.getWidth() > 0 && view.getHeight() > 0) {
            return true;
        }
        return false;
    }

    private final void wh(View contentView) {
        this.mPreviewImageView = (ImageView) contentView.findViewById(R.id.f10399624);
        this.mPreviewDynamicImageView = (ImageView) contentView.findViewById(R.id.f10400625);
        this.mImageContainer = contentView.findViewById(R.id.f10398623);
        this.mOpenBtn = (Button) contentView.findViewById(R.id.fdi);
        this.mCloseBtn = contentView.findViewById(R.id.az7);
    }

    private final int xh(int windowHeight) {
        if (!((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).isPhone(getContext())) {
            return (int) ((windowHeight * 0.8f) + 0.5f);
        }
        return windowHeight;
    }

    private final int yh(int windowWidth) {
        int coerceAtMost;
        if (!((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).isPhone(getContext())) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(ViewUtils.dpToPx(400.0f), windowWidth);
            return coerceAtMost;
        }
        return windowWidth;
    }

    private final Pair<Integer, Integer> zh() {
        View rootView;
        Pair<Integer, Integer> pair;
        View view = getView();
        if (view == null || (rootView = view.getRootView()) == null || (pair = TuplesKt.to(Integer.valueOf(rootView.getWidth()), Integer.valueOf(rootView.getHeight()))) == null) {
            return TuplesKt.to(Integer.valueOf(ViewUtils.getScreenWidth()), Integer.valueOf(ViewUtils.getScreenHeight()));
        }
        return pair;
    }

    public final void Ih(@Nullable DialogInterface.OnClickListener clickListener, @Nullable DialogInterface.OnDismissListener dismissListener) {
        this.mDialogClickListener = clickListener;
        this.mDialogDismissListener = dismissListener;
    }

    public final void Jh(@Nullable View parent) {
        this.mLogicViewParentWeakRef = new WeakReference<>(parent);
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        dismissAllowingStateLoss();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mCloseTriggerType = 2;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        behavior.setState(3);
        behavior.setPeekHeight(0);
        behavior.addBottomSheetCallback(new b());
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.i1k, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "this");
        wh(inflate);
        Kh(inflate);
        Nh(inflate);
        Mh(inflate);
        Lh(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        DialogInterface.OnDismissListener onDismissListener = this.mDialogDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        Hh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Eh();
        Bh(getDialog());
    }
}
