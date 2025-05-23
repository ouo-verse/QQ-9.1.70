package com.tencent.biz.qrcode.fragment.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qrcode.fragment.viewmodel.QRDisplayMyCardViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010\u0016\u001a\u00020\u0006R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/biz/qrcode/fragment/part/QRDisplayMyCardTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "titlePart", "", "U9", "N9", "R9", "L9", "T9", "", "H9", "ca", "aa", "", HippyHeaderListViewController.VIEW_TAG, "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "P9", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "E9", "()Landroid/widget/ImageView;", "V9", "(Landroid/widget/ImageView;)V", "backButton", "e", "I9", "Y9", "settingButton", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "F9", "()Landroid/widget/TextView;", "W9", "(Landroid/widget/TextView;)V", "backToNormalBtn", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", tl.h.F, "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "J9", "()Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "Z9", "(Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;)V", "viewModel", "Lcom/tencent/widget/ActionSheet;", "i", "Lcom/tencent/widget/ActionSheet;", "G9", "()Lcom/tencent/widget/ActionSheet;", "X9", "(Lcom/tencent/widget/ActionSheet;)V", "mPayShareActionSheet", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QRDisplayMyCardTitlePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageView backButton;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ImageView settingButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView backToNormalBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public QRDisplayMyCardViewModel viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ActionSheet mPayShareActionSheet;

    private final float H9() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
        return displayMetrics.density / FontSettingManager.systemMetrics.density;
    }

    private final void K9(int viewTag) {
        Context context = getContext();
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + viewTag + "&entry=1"));
            Activity activity = getActivity();
            if (activity != null) {
                activity.startActivity(intent);
            }
        }
    }

    private final void L9(Context context, RelativeLayout titlePart) {
        V9(new ImageView(context));
        E9().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRDisplayMyCardTitlePart.M9(QRDisplayMyCardTitlePart.this, view);
            }
        });
        int dip2px = ViewUtils.dip2px(24.0f);
        int dip2px2 = ViewUtils.dip2px(16.0f);
        if (H9() > 1.0f) {
            dip2px = (int) (dip2px / H9());
            dip2px2 = (int) (dip2px2 / H9());
        }
        E9().setImageResource(R.drawable.qui_arrow_left_selector);
        AccessibilityUtil.c(E9(), E9().getResources().getString(R.string.f170549u3), Button.class.getName());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
        layoutParams.addRule(9);
        layoutParams.addRule(14);
        layoutParams.setMargins(dip2px2, 0, 0, 0);
        titlePart.addView(E9(), layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(QRDisplayMyCardTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N9(Context context, RelativeLayout titlePart) {
        W9(new TextView(context));
        F9().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRDisplayMyCardTitlePart.O9(QRDisplayMyCardTitlePart.this, view);
            }
        });
        F9().setText(HardCodeUtil.qqStr(R.string.f17901388));
        F9().setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_common_text_primary_selector));
        int dip2px = ViewUtils.dip2px(16.0f);
        float f16 = 17.0f;
        if (H9() > 1.0f) {
            f16 = 17.0f / H9();
            dip2px = (int) (dip2px / H9());
        }
        F9().setTextSize(2, f16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, 0, dip2px, 0);
        com.tencent.biz.qrcode.util.a.f95053a.b(F9(), "em_my_qrcode_default_button", null);
        titlePart.addView(F9(), layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QRDisplayMyCardTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9().H2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R9(Context context, RelativeLayout titlePart) {
        Y9(new ImageView(context));
        I9().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRDisplayMyCardTitlePart.S9(QRDisplayMyCardTitlePart.this, view);
            }
        });
        int dip2px = ViewUtils.dip2px(24.0f);
        int dip2px2 = ViewUtils.dip2px(16.0f);
        if (H9() > 1.0f) {
            dip2px = (int) (dip2px / H9());
            dip2px2 = (int) (dip2px2 / H9());
        }
        I9().setImageResource(R.drawable.qui_chat_settings_selector);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
        layoutParams.addRule(11);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, 0, dip2px2, 0);
        com.tencent.biz.qrcode.util.a.f95053a.b(I9(), "em_bas_my_qrcode_more_button", null);
        titlePart.addView(I9(), layoutParams);
        I9().setVisibility(8);
        if (!com.tencent.biz.qrcode.util.f.a()) {
            I9().setVisibility(0);
            VideoReport.reportEvent("imp", I9(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QRDisplayMyCardTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aa();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9(Context context, RelativeLayout titlePart) {
        TextView textView = new TextView(context);
        textView.setText(HardCodeUtil.qqStr(R.string.dzu));
        textView.setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_common_text_primary));
        float f16 = 17.0f;
        if (H9() > 1.0f) {
            f16 = 17.0f / H9();
        }
        textView.setTextSize(2, f16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13, -1);
        titlePart.addView(textView, layoutParams);
    }

    @SuppressLint({"InflateParams"})
    private final void U9(Context context, RelativeLayout titlePart) {
        L9(context, titlePart);
        R9(context, titlePart);
        N9(context, titlePart);
        T9(context, titlePart);
        ca();
    }

    private final void aa() {
        if (this.mPayShareActionSheet == null) {
            Context context = getContext();
            if (context != null) {
                Dialog createDialog = ActionSheetHelper.createDialog(context, null);
                Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
                X9((ActionSheet) createDialog);
            }
            if (this.mPayShareActionSheet == null) {
                return;
            }
        }
        if (G9().isShowing()) {
            return;
        }
        G9().addButton(R.string.dzo, 0, 7);
        G9().addButton(R.string.dzs, 0, 8);
        G9().addCancelButton(R.string.cancel);
        G9().setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.u
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                QRDisplayMyCardTitlePart.ba(QRDisplayMyCardTitlePart.this, view, i3);
            }
        });
        G9().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(QRDisplayMyCardTitlePart this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int id5 = view.getId();
        if (id5 != 7) {
            if (id5 == 8) {
                this$0.K9(8);
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", "0X800AEB7", "0X800AEB7", 0, 0, "", "", "", "");
            }
        } else {
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", "0X800AEB6", "0X800AEB6", 0, 0, "", "", "", "");
            this$0.K9(7);
        }
        this$0.G9().dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca() {
        if (this.backToNormalBtn == null) {
            return;
        }
        if (J9().x2()) {
            F9().setVisibility(0);
        } else {
            F9().setVisibility(8);
        }
    }

    @NotNull
    public final ImageView E9() {
        ImageView imageView = this.backButton;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backButton");
        return null;
    }

    @NotNull
    public final TextView F9() {
        TextView textView = this.backToNormalBtn;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backToNormalBtn");
        return null;
    }

    @NotNull
    public final ActionSheet G9() {
        ActionSheet actionSheet = this.mPayShareActionSheet;
        if (actionSheet != null) {
            return actionSheet;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPayShareActionSheet");
        return null;
    }

    @NotNull
    public final ImageView I9() {
        ImageView imageView = this.settingButton;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingButton");
        return null;
    }

    @NotNull
    public final QRDisplayMyCardViewModel J9() {
        QRDisplayMyCardViewModel qRDisplayMyCardViewModel = this.viewModel;
        if (qRDisplayMyCardViewModel != null) {
            return qRDisplayMyCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void P9() {
        QBaseActivity qBaseActivity = (QBaseActivity) getActivity();
        if (qBaseActivity != null) {
            MutableLiveData<com.tencent.biz.qrcode.mgr.d> p26 = J9().p2();
            final Function1<com.tencent.biz.qrcode.mgr.d, Unit> function1 = new Function1<com.tencent.biz.qrcode.mgr.d, Unit>() { // from class: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardTitlePart$initObserver$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.biz.qrcode.mgr.d dVar) {
                    invoke2(dVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable com.tencent.biz.qrcode.mgr.d dVar) {
                    QRDisplayMyCardTitlePart.this.ca();
                }
            };
            p26.observe(qBaseActivity, new Observer() { // from class: com.tencent.biz.qrcode.fragment.part.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QRDisplayMyCardTitlePart.Q9(Function1.this, obj);
                }
            });
        }
    }

    public final void V9(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.backButton = imageView;
    }

    public final void W9(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.backToNormalBtn = textView;
    }

    public final void X9(@NotNull ActionSheet actionSheet) {
        Intrinsics.checkNotNullParameter(actionSheet, "<set-?>");
        this.mPayShareActionSheet = actionSheet;
    }

    public final void Y9(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.settingButton = imageView;
    }

    public final void Z9(@NotNull QRDisplayMyCardViewModel qRDisplayMyCardViewModel) {
        Intrinsics.checkNotNullParameter(qRDisplayMyCardViewModel, "<set-?>");
        this.viewModel = qRDisplayMyCardViewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        super.onInitView(rootView);
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.f98745nx);
        } else {
            relativeLayout = null;
        }
        if (relativeLayout == null) {
            QLog.i("QRDisplayMyCardTitlePart", 1, "card part is null");
            return;
        }
        QRDisplayMyCardViewModel qRDisplayMyCardViewModel = (QRDisplayMyCardViewModel) getViewModel(QRDisplayMyCardViewModel.class);
        if (qRDisplayMyCardViewModel == null) {
            return;
        }
        Z9(qRDisplayMyCardViewModel);
        Context context = getContext();
        if (context != null) {
            U9(context, relativeLayout);
            P9();
        }
    }
}
