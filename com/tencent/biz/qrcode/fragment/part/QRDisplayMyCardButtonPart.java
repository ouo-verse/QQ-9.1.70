package com.tencent.biz.qrcode.fragment.part;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardButtonPart;
import com.tencent.biz.qrcode.fragment.viewmodel.QRDisplayMyCardViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u00020\u0001:\u0002>?B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0003J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0012\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0017J\u0012\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010*\u001a\u00020\u0006J\b\u0010+\u001a\u00020#H\u0016J\b\u0010,\u001a\u00020#H\u0007R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010:\u001a\u0002058\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/biz/qrcode/fragment/part/QRDisplayMyCardButtonPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "buttonPart", "", "ba", "Landroid/widget/LinearLayout;", "qidButton", "buttonLayout", "V9", "aigcButton", "aigcRedDot", "T9", "scanButton", "X9", "shareButton", "Z9", "Landroid/view/View;", "anchor", "ga", "", "resId", "", "tips", "Lcom/tencent/biz/qrcode/fragment/part/QRDisplayMyCardButtonPart$a;", "P9", "Landroid/graphics/Bitmap;", "preView", LocaleUtils.L_JAPANESE, "actionId", "S9", "ha", "M9", "", "la", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "R9", "onBackEvent", "ca", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "d", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "Q9", "()Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "ea", "(Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;)V", "viewModel", "Landroid/view/View$OnTouchListener;", "e", "Landroid/view/View$OnTouchListener;", "getButtonTouchListener", "()Landroid/view/View$OnTouchListener;", "buttonTouchListener", "<init>", "()V", "f", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QRDisplayMyCardButtonPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public QRDisplayMyCardViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener buttonTouchListener = new View.OnTouchListener() { // from class: com.tencent.biz.qrcode.fragment.part.b
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean L9;
            L9 = QRDisplayMyCardButtonPart.L9(view, motionEvent);
            return L9;
        }
    };

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qrcode/fragment/part/QRDisplayMyCardButtonPart$a;", "", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/RelativeLayout;", "b", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/widget/LinearLayout;", "getButtonLayout", "()Landroid/widget/LinearLayout;", "buttonLayout", "Landroid/widget/RelativeLayout;", "getRedDot", "()Landroid/widget/RelativeLayout;", "redDot", "<init>", "(Landroid/widget/LinearLayout;Landroid/widget/RelativeLayout;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardButtonPart$a, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class ButtonAndRedDot {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final LinearLayout buttonLayout;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RelativeLayout redDot;

        public ButtonAndRedDot(@NotNull LinearLayout buttonLayout, @NotNull RelativeLayout redDot) {
            Intrinsics.checkNotNullParameter(buttonLayout, "buttonLayout");
            Intrinsics.checkNotNullParameter(redDot, "redDot");
            this.buttonLayout = buttonLayout;
            this.redDot = redDot;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final LinearLayout getButtonLayout() {
            return this.buttonLayout;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final RelativeLayout getRedDot() {
            return this.redDot;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ButtonAndRedDot)) {
                return false;
            }
            ButtonAndRedDot buttonAndRedDot = (ButtonAndRedDot) other;
            if (Intrinsics.areEqual(this.buttonLayout, buttonAndRedDot.buttonLayout) && Intrinsics.areEqual(this.redDot, buttonAndRedDot.redDot)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.buttonLayout.hashCode() * 31) + this.redDot.hashCode();
        }

        @NotNull
        public String toString() {
            return "ButtonAndRedDot(buttonLayout=" + this.buttonLayout + ", redDot=" + this.redDot + ")";
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qrcode/fragment/part/QRDisplayMyCardButtonPart$c", "Lcom/tencent/mobileqq/sharepanel/n;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements com.tencent.mobileqq.sharepanel.n {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(com.tencent.mobileqq.sharepanel.m callback, QRDisplayMyCardButtonPart this$0) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QRDisplayMyCardViewModel Q9 = this$0.Q9();
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            callback.a(Q9.k2(context));
        }

        @Override // com.tencent.mobileqq.sharepanel.n
        public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull final com.tencent.mobileqq.sharepanel.m callback) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            final QRDisplayMyCardButtonPart qRDisplayMyCardButtonPart = QRDisplayMyCardButtonPart.this;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.part.j
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayMyCardButtonPart.c.c(com.tencent.mobileqq.sharepanel.m.this, qRDisplayMyCardButtonPart);
                }
            }, 64, null, true);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qrcode/fragment/part/QRDisplayMyCardButtonPart$d", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d implements com.tencent.mobileqq.sharepanel.j {
        d() {
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Activity activity = QRDisplayMyCardButtonPart.this.getActivity();
            if (activity != null) {
                QRDisplayMyCardButtonPart.this.Q9().V2(activity, channelId);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            QRDisplayMyCardButtonPart.this.S9(actionId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L9(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                return false;
            }
            view.setAlpha(1.0f);
            return false;
        }
        view.setAlpha(0.5f);
        return false;
    }

    private final void M9() {
        final Activity activity = getActivity();
        if (activity != null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 232, (String) null, HardCodeUtil.qqStr(R.string.f20344508), HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.f2058156m), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QRDisplayMyCardButtonPart.N9(activity, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QRDisplayMyCardButtonPart.O9(dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(curAc\u2026          }, { _, _ -> })");
            createCustomDialog.show();
            QidCardManager.QidCardReport.reportQidQrCard("0X800B970");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Activity curActivity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(curActivity, "$curActivity");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            QidCardManager.jumpQidEditPage(peekAppRuntime, curActivity, 1);
            QidCardManager.QidCardReport.reportQidQrCard("0X800B971");
        }
    }

    private final ButtonAndRedDot P9(Context context, int resId, String tips) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        int dip2px = ViewUtils.dip2px(24.0f);
        int dip2px2 = ViewUtils.dip2px(0.0f);
        ImageView imageView = new ImageView(context);
        imageView.setPadding(dip2px2, dip2px2, dip2px2, dip2px2);
        imageView.setImageResource(resId);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
        layoutParams.addRule(13, -1);
        relativeLayout.addView(imageView, layoutParams);
        int dip2px3 = ViewUtils.dip2px(9.0f);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setBackgroundResource(R.drawable.kbd);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dip2px3, dip2px3);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(10, -1);
        relativeLayout.addView(relativeLayout2, layoutParams2);
        relativeLayout2.setVisibility(8);
        int dip2px4 = ViewUtils.dip2px(28.5f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dip2px4, dip2px4);
        layoutParams3.gravity = 1;
        linearLayout.addView(relativeLayout, layoutParams3);
        int dip2px5 = ViewUtils.dip2px(17.0f);
        int dip2px6 = ViewUtils.dip2px(14.0f);
        int dip2px7 = ViewUtils.dip2px(14.0f);
        TextView textView = new TextView(context);
        textView.setText(tips);
        textView.setTextSize(0, dip2px7);
        textView.setTextColor(AppCompatResources.getColorStateList(context, R.color.qui_common_text_primary_selector));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, dip2px5);
        layoutParams4.gravity = 1;
        layoutParams4.setMargins(0, dip2px6, 0, 0);
        linearLayout.addView(textView, layoutParams4);
        return new ButtonAndRedDot(linearLayout, relativeLayout2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(String actionId) {
        Activity activity;
        if (Intrinsics.areEqual(actionId, "save_to_phone")) {
            Q9().J2();
        } else if (Intrinsics.areEqual(actionId, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK) && (activity = getActivity()) != null) {
            Q9().d2(activity);
        }
    }

    private final void T9(LinearLayout aigcButton, final RelativeLayout aigcRedDot, RelativeLayout buttonLayout) {
        String str;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        aigcButton.setOnTouchListener(this.buttonTouchListener);
        buttonLayout.addView(aigcButton, layoutParams);
        aigcButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRDisplayMyCardButtonPart.U9(QRDisplayMyCardButtonPart.this, aigcRedDot, view);
            }
        });
        HashMap hashMap = new HashMap();
        if (!Q9().w2()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("plan_is_redpoint", str);
        com.tencent.biz.qrcode.util.a aVar = com.tencent.biz.qrcode.util.a.f95053a;
        aVar.b(aigcButton, "em_my_qrcode_change_button", null);
        aVar.b(aigcRedDot, "em_my_qrcode_change_reddot", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QRDisplayMyCardButtonPart this$0, RelativeLayout aigcRedDot, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(aigcRedDot, "$aigcRedDot");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            aigcRedDot.setVisibility(8);
            this$0.Q9().B2(activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9(LinearLayout qidButton, RelativeLayout buttonLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        qidButton.setOnTouchListener(this.buttonTouchListener);
        buttonLayout.addView(qidButton, layoutParams);
        com.tencent.biz.qrcode.util.a.f95053a.b(qidButton, "em_bas_my_qrcode_switch_qid_button", null);
        qidButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRDisplayMyCardButtonPart.W9(QRDisplayMyCardButtonPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QRDisplayMyCardButtonPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Q9().getMSwitchState() == 0) {
            this$0.M9();
        } else if (this$0.Q9().getMSwitchState() == 1) {
            this$0.Q9().c2();
            QidCardManager.QidCardReport.reportQidQrCard("0X800B96F");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X9(LinearLayout scanButton, RelativeLayout buttonLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        scanButton.setOnTouchListener(this.buttonTouchListener);
        buttonLayout.addView(scanButton, layoutParams);
        com.tencent.biz.qrcode.util.a.f95053a.b(scanButton, "em_bas_my_qrcode_scan_button", null);
        scanButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRDisplayMyCardButtonPart.Y9(QRDisplayMyCardButtonPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QRDisplayMyCardButtonPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void Z9(LinearLayout shareButton, RelativeLayout buttonLayout) {
        int dpToPx = ViewUtils.dpToPx(8.0f);
        shareButton.setPadding(dpToPx, 0, dpToPx, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        shareButton.setOnTouchListener(this.buttonTouchListener);
        buttonLayout.addView(shareButton, layoutParams);
        com.tencent.biz.qrcode.util.a.f95053a.b(shareButton, "em_bas_my_qrcode_share_button", null);
        shareButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRDisplayMyCardButtonPart.aa(QRDisplayMyCardButtonPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(QRDisplayMyCardButtonPart this$0, View view) {
        Unit unit;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bitmap value = this$0.Q9().r2().getValue();
        if (value != null) {
            if (this$0.la()) {
                this$0.ja(value);
            } else {
                this$0.ha(value);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.Q9().q2().postValue(Boolean.TRUE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void ba(Context context, RelativeLayout buttonPart) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        String qqStr = HardCodeUtil.qqStr(R.string.f1790938f);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qb_qrcode_share)");
        LinearLayout buttonLayout = P9(context, R.drawable.qui_share, qqStr).getButtonLayout();
        String qqStr2 = HardCodeUtil.qqStr(R.string.dzw);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qb_qrcode_scanner)");
        LinearLayout buttonLayout2 = P9(context, R.drawable.qui_scan, qqStr2).getButtonLayout();
        String qqStr3 = HardCodeUtil.qqStr(R.string.f1791338j);
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.qb_qrcode_switch_qid)");
        LinearLayout buttonLayout3 = P9(context, R.drawable.qui_super_member, qqStr3).getButtonLayout();
        String qqStr4 = HardCodeUtil.qqStr(R.string.f17899386);
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.qb_qrcode_aigc_code)");
        ButtonAndRedDot P9 = P9(context, R.drawable.qui_transfer, qqStr4);
        LinearLayout buttonLayout4 = P9.getButtonLayout();
        RelativeLayout redDot = P9.getRedDot();
        Z9(buttonLayout, relativeLayout);
        X9(buttonLayout2, relativeLayout);
        V9(buttonLayout3, relativeLayout);
        T9(buttonLayout4, redDot, relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(272.0f), -2);
        layoutParams.addRule(13);
        buttonPart.addView(relativeLayout, layoutParams);
        int i3 = 0;
        if (com.tencent.biz.qrcode.util.f.a()) {
            buttonLayout4.setVisibility(0);
            buttonLayout3.setVisibility(8);
            if (Q9().w2()) {
                i3 = 8;
            }
            redDot.setVisibility(i3);
            if (Q9().z2()) {
                ga(buttonLayout4);
                return;
            }
            return;
        }
        buttonLayout4.setVisibility(8);
        buttonLayout3.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ga(View anchor) {
        String str;
        QUIDefaultBubbleTip.r(anchor.getContext()).S(anchor).o0(HardCodeUtil.qqStr(R.string.f1790538b)).k0(0).R(0).m0(3).s0();
        HashMap hashMap = new HashMap();
        if (com.tencent.biz.qrcode.util.f.a()) {
            str = "3";
        } else {
            str = "1";
        }
        hashMap.put("my_qrcode_pg_source_type", str);
        VideoReport.reportEvent("ev_bas_my_qrcode_aigc_bubble_imp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(Bitmap preView) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        ShareActionSheetWithPreview b16 = com.tencent.biz.qrcode.util.i.f95067a.b(activity, preView);
        b16.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.biz.qrcode.fragment.part.f
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                QRDisplayMyCardButtonPart.ia(QRDisplayMyCardButtonPart.this, actionSheetItem, shareActionSheet);
            }
        });
        b16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(QRDisplayMyCardButtonPart this$0, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shareActionSheet.dismiss();
        QLog.d("QRDisplayMyCardButtonPart", 2, " showMyQrCodeActionSheet() click item = " + actionSheetItem.action);
        int i3 = actionSheetItem.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 26) {
                                if (i3 != 39) {
                                    if (i3 == 72 && (activity = this$0.getActivity()) != null) {
                                        QRDisplayMyCardViewModel Q9 = this$0.Q9();
                                        int i16 = actionSheetItem.uinType;
                                        String str = actionSheetItem.uin;
                                        Intrinsics.checkNotNullExpressionValue(str, "item.uin");
                                        QRDisplayMyCardViewModel.d3(Q9, activity, i16, str, false, 8, null);
                                        return;
                                    }
                                    return;
                                }
                                this$0.Q9().J2();
                                return;
                            }
                            Activity activity2 = this$0.getActivity();
                            if (activity2 != null) {
                                QRDisplayMyCardViewModel Q92 = this$0.Q9();
                                String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
                                Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                                QRDisplayMyCardViewModel.d3(Q92, activity2, 6000, DATALINE_PC_UIN, false, 8, null);
                                return;
                            }
                            return;
                        }
                        Activity activity3 = this$0.getActivity();
                        if (activity3 != null) {
                            this$0.Q9().l3(activity3, 10);
                            return;
                        }
                        return;
                    }
                    Activity activity4 = this$0.getActivity();
                    if (activity4 != null) {
                        this$0.Q9().l3(activity4, 9);
                        return;
                    }
                    return;
                }
                Activity activity5 = this$0.getActivity();
                if (activity5 != null) {
                    this$0.Q9().l3(activity5, 3);
                    return;
                }
                return;
            }
            Activity activity6 = this$0.getActivity();
            if (activity6 != null) {
                this$0.Q9().l3(activity6, 2);
                return;
            }
            return;
        }
        Activity activity7 = this$0.getActivity();
        if (activity7 != null) {
            this$0.Q9().d2(activity7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja(Bitmap preView) {
        FragmentActivity fragmentActivity;
        Activity activity = getActivity();
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && !fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed()) {
            ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(fragmentActivity, "relationship_qrcode").q0(preView).k0(new c()).t0(new d()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean la() {
        return ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("relationship_qrcode");
    }

    @NotNull
    public final QRDisplayMyCardViewModel Q9() {
        QRDisplayMyCardViewModel qRDisplayMyCardViewModel = this.viewModel;
        if (qRDisplayMyCardViewModel != null) {
            return qRDisplayMyCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void R9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800AEAF", "0X800AEAF", 0, 0, "", "", "", "");
            ReportController.o(peekAppRuntime, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
        }
        if (Intrinsics.areEqual("ScannerActivity", Q9().getMFrom())) {
            if (ca()) {
                QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.rdv));
            }
            onBackEvent();
        } else {
            if (ca()) {
                QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.rdx));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("from", "QRDisplayActivity");
            RouteUtils.startActivityForResult(getActivity(), intent, "/qrscan/scanner", 3);
        }
    }

    @TargetApi(24)
    public final boolean ca() {
        boolean isInMultiWindowMode;
        boolean z16 = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Activity activity = getActivity();
                if (activity != null) {
                    isInMultiWindowMode = activity.isInMultiWindowMode();
                    z16 = isInMultiWindowMode;
                }
            } catch (Exception unused) {
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.i("qqBaseActivity", 2, " fight...isInMultiWindowMode = " + z16);
        }
        return z16;
    }

    public final void ea(@NotNull QRDisplayMyCardViewModel qRDisplayMyCardViewModel) {
        Intrinsics.checkNotNullParameter(qRDisplayMyCardViewModel, "<set-?>");
        this.viewModel = qRDisplayMyCardViewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
            activity.finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @SuppressLint({"ClickableViewAccessibility"})
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        super.onInitView(rootView);
        QRDisplayMyCardViewModel qRDisplayMyCardViewModel = (QRDisplayMyCardViewModel) getViewModel(QRDisplayMyCardViewModel.class);
        if (qRDisplayMyCardViewModel == null) {
            return;
        }
        ea(qRDisplayMyCardViewModel);
        QBaseActivity qBaseActivity = null;
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.tjx);
        } else {
            relativeLayout = null;
        }
        if (relativeLayout == null) {
            QLog.i("QRDisplayMyCardTitlePart", 1, "card part is null");
            return;
        }
        Activity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        }
        if (qBaseActivity != null) {
            MutableLiveData<Bitmap> r26 = Q9().r2();
            final Function1<Bitmap, Unit> function1 = new Function1<Bitmap, Unit>() { // from class: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardButtonPart$onInitView$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                    invoke2(bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Bitmap bitmap) {
                    boolean la5;
                    if (bitmap != null) {
                        QRDisplayMyCardButtonPart qRDisplayMyCardButtonPart = QRDisplayMyCardButtonPart.this;
                        la5 = qRDisplayMyCardButtonPart.la();
                        if (la5) {
                            qRDisplayMyCardButtonPart.ja(bitmap);
                        } else {
                            qRDisplayMyCardButtonPart.ha(bitmap);
                        }
                    }
                }
            };
            r26.observe(qBaseActivity, new Observer() { // from class: com.tencent.biz.qrcode.fragment.part.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QRDisplayMyCardButtonPart.da(Function1.this, obj);
                }
            });
        }
        Context context = getContext();
        if (context != null) {
            ba(context, relativeLayout);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        Q9().C2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(DialogInterface dialogInterface, int i3) {
    }
}
