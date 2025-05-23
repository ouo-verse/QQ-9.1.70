package com.tencent.icgame.game.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.icgame.game.base.ui.TimiGamePageLoadingView;
import com.tencent.icgame.game.ui.widget.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:B\u0011\b\u0002\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\n \u0014*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u001c\u0010\u001a\u001a\n \u0014*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\n \u0014*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\n \u0014*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u001c\u0010 \u001a\n \u0014*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001dR\u001c\u0010$\u001a\n \u0014*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010(\u001a\n \u0014*\u0004\u0018\u00010\u001b0\u001b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010'R\u001f\u0010+\u001a\n \u0014*\u0004\u0018\u00010\u001b0\u001b8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010'R\u001f\u0010/\u001a\n \u0014*\u0004\u0018\u00010\u00070\u00078\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010.R\u001f\u00105\u001a\n \u0014*\u0004\u0018\u000100008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/icgame/game/ui/widget/e;", "Lcom/tencent/icgame/game/ui/widget/a;", "", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "onBackPressed", "", "K", "Z", "backPressEnable", "L", "lightMode", "M", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "kotlin.jvm.PlatformType", "N", "bgView", "Lcom/tencent/icgame/game/base/ui/TimiGamePageLoadingView;", "P", "Lcom/tencent/icgame/game/base/ui/TimiGamePageLoadingView;", "loadingView", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "messageView", "negativeButton", "positiveButton", "Landroidx/constraintlayout/widget/ConstraintLayout;", "T", "Landroidx/constraintlayout/widget/ConstraintLayout;", "contentView", "U", "d0", "()Landroid/widget/TextView;", "titleView", "V", "c0", "subTitleView", "W", "e0", "()Landroid/view/View;", "verticalDivider", "Landroid/widget/FrameLayout;", "X", "Landroid/widget/FrameLayout;", "b0", "()Landroid/widget/FrameLayout;", "contentContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class e extends com.tencent.icgame.game.ui.widget.a {

    /* renamed from: K, reason: from kotlin metadata */
    private boolean backPressEnable;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean lightMode;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: N, reason: from kotlin metadata */
    private final View bgView;

    /* renamed from: P, reason: from kotlin metadata */
    private final TimiGamePageLoadingView loadingView;

    /* renamed from: Q, reason: from kotlin metadata */
    private final TextView messageView;

    /* renamed from: R, reason: from kotlin metadata */
    private final TextView negativeButton;

    /* renamed from: S, reason: from kotlin metadata */
    private final TextView positiveButton;

    /* renamed from: T, reason: from kotlin metadata */
    private final ConstraintLayout contentView;

    /* renamed from: U, reason: from kotlin metadata */
    private final TextView titleView;

    /* renamed from: V, reason: from kotlin metadata */
    private final TextView subTitleView;

    /* renamed from: W, reason: from kotlin metadata */
    private final View verticalDivider;

    /* renamed from: X, reason: from kotlin metadata */
    private final FrameLayout contentContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0016\u0010!\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0017R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010*\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010$R\u0016\u0010<\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010$R\u0016\u0010>\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010$R\u0016\u0010@\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\u0017\u00a8\u0006C"}, d2 = {"Lcom/tencent/icgame/game/ui/widget/e$a;", "", "", "message", "f", "text", "i", "Landroid/content/DialogInterface$OnClickListener;", "listener", tl.h.F, "g", "Lcom/tencent/icgame/game/ui/widget/e;", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "title", QQWinkConstants.TAB_SUBTITLE, "", "d", "I", "titleGravity", "e", "subTitleGravity", "messageGravity", "positiveButtonText", "negativeButtonText", "j", "positiveButtonTextColorId", "k", "negativeButtonTextColorId", "", "l", "Z", "cancleOnOutside", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "backPressEnable", DomainData.DOMAIN_NAME, "Landroid/content/DialogInterface$OnClickListener;", "positiveButtonClickListener", "o", "negativeButtonClickListener", "Landroid/content/DialogInterface$OnDismissListener;", "p", "Landroid/content/DialogInterface$OnDismissListener;", "mDismissListener", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "customMsgView", "", "r", "[I", "customMargins", ReportConstant.COSTREPORT_PREFIX, "positiveBtnCanDismiss", "t", "negativeBtnCanDismiss", "u", "lightMode", "v", "messageMaxLine", "<init>", "(Landroid/content/Context;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String subTitle;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int titleGravity;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int subTitleGravity;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String message;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int messageGravity;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String positiveButtonText;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String negativeButtonText;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @ColorRes
        private int positiveButtonTextColorId;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int negativeButtonTextColorId;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private boolean cancleOnOutside;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean backPressEnable;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private DialogInterface.OnClickListener positiveButtonClickListener;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private DialogInterface.OnClickListener negativeButtonClickListener;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private DialogInterface.OnDismissListener mDismissListener;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View customMsgView;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private int[] customMargins;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        private boolean positiveBtnCanDismiss;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        private boolean negativeBtnCanDismiss;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        private boolean lightMode;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        private int messageMaxLine;

        public a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.titleGravity = 17;
            this.subTitleGravity = 17;
            this.messageGravity = 8388611;
            this.positiveButtonText = "\u786e\u5b9a";
            this.negativeButtonText = "\u6682\u4e0d";
            this.backPressEnable = true;
            this.customMargins = new int[4];
            this.positiveBtnCanDismiss = true;
            this.negativeBtnCanDismiss = true;
            this.messageMaxLine = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a this$0, e this_apply, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            DialogInterface.OnClickListener onClickListener = this$0.positiveButtonClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this_apply, -1);
            }
            if (this$0.positiveBtnCanDismiss) {
                this_apply.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(a this$0, e this_apply, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            DialogInterface.OnClickListener onClickListener = this$0.negativeButtonClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this_apply, -2);
            }
            if (this$0.negativeBtnCanDismiss) {
                this_apply.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x010d, code lost:
        
            if (r2 != false) goto L38;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x013c  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x004f  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final e c() {
            boolean z16;
            String str;
            boolean z17;
            String str2;
            boolean z18;
            String str3;
            boolean isBlank;
            boolean isBlank2;
            boolean z19;
            boolean isBlank3;
            boolean isBlank4;
            boolean isBlank5;
            final e eVar = new e(this.context, null);
            eVar.getTitleView().setText(this.title);
            eVar.messageView.setText(this.message);
            eVar.messageView.setMaxLines(this.messageMaxLine);
            TextView titleView = eVar.getTitleView();
            Intrinsics.checkNotNullExpressionValue(titleView, "titleView");
            String str4 = this.title;
            boolean z26 = false;
            if (str4 != null) {
                isBlank5 = StringsKt__StringsJVMKt.isBlank(str4);
                if (!isBlank5) {
                    z16 = false;
                    uu0.b.i(titleView, !z16);
                    TextView subTitleView = eVar.getSubTitleView();
                    Intrinsics.checkNotNullExpressionValue(subTitleView, "subTitleView");
                    str = this.subTitle;
                    if (str != null) {
                        isBlank4 = StringsKt__StringsJVMKt.isBlank(str);
                        if (!isBlank4) {
                            z17 = false;
                            uu0.b.i(subTitleView, !z17);
                            eVar.getTitleView().setText(this.title);
                            eVar.getTitleView().setGravity(this.titleGravity);
                            eVar.getSubTitleView().setText(this.subTitle);
                            eVar.getSubTitleView().setGravity(this.subTitleGravity);
                            if (this.customMsgView == null) {
                                TextView messageView = eVar.messageView;
                                Intrinsics.checkNotNullExpressionValue(messageView, "messageView");
                                String str5 = this.message;
                                if (str5 != null) {
                                    isBlank3 = StringsKt__StringsJVMKt.isBlank(str5);
                                    if (!isBlank3) {
                                        z19 = false;
                                        uu0.b.i(messageView, !z19);
                                        eVar.messageView.setText(this.message);
                                        eVar.messageView.setGravity(this.messageGravity);
                                    }
                                }
                                z19 = true;
                                uu0.b.i(messageView, !z19);
                                eVar.messageView.setText(this.message);
                                eVar.messageView.setGravity(this.messageGravity);
                            } else {
                                eVar.getContentContainer().removeAllViews();
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                                int[] iArr = this.customMargins;
                                layoutParams.leftMargin = iArr[0];
                                layoutParams.topMargin = iArr[1];
                                layoutParams.rightMargin = iArr[2];
                                layoutParams.bottomMargin = iArr[3];
                                eVar.getContentContainer().addView(this.customMsgView, layoutParams);
                            }
                            TextView negativeButton = eVar.negativeButton;
                            Intrinsics.checkNotNullExpressionValue(negativeButton, "negativeButton");
                            str2 = this.negativeButtonText;
                            if (str2 != null) {
                                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                if (!isBlank2) {
                                    z18 = false;
                                    uu0.b.i(negativeButton, !z18);
                                    View verticalDivider = eVar.getVerticalDivider();
                                    Intrinsics.checkNotNullExpressionValue(verticalDivider, "verticalDivider");
                                    str3 = this.negativeButtonText;
                                    if (str3 != null) {
                                        isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                                    }
                                    z26 = true;
                                    uu0.b.i(verticalDivider, !z26);
                                    eVar.positiveButton.setText(this.positiveButtonText);
                                    eVar.negativeButton.setText(this.negativeButtonText);
                                    if (this.positiveButtonTextColorId > 0) {
                                        eVar.positiveButton.setTextColor(cy0.b.a(this.positiveButtonTextColorId));
                                    }
                                    if (this.negativeButtonTextColorId > 0) {
                                        eVar.negativeButton.setTextColor(cy0.b.a(this.negativeButtonTextColorId));
                                    }
                                    eVar.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.ui.widget.c
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            e.a.d(e.a.this, eVar, view);
                                        }
                                    });
                                    eVar.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.ui.widget.d
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            e.a.e(e.a.this, eVar, view);
                                        }
                                    });
                                    eVar.setOnDismissListener(this.mDismissListener);
                                    eVar.setCanceledOnTouchOutside(this.cancleOnOutside);
                                    eVar.backPressEnable = this.backPressEnable;
                                    eVar.lightMode = this.lightMode;
                                    return eVar;
                                }
                            }
                            z18 = true;
                            uu0.b.i(negativeButton, !z18);
                            View verticalDivider2 = eVar.getVerticalDivider();
                            Intrinsics.checkNotNullExpressionValue(verticalDivider2, "verticalDivider");
                            str3 = this.negativeButtonText;
                            if (str3 != null) {
                            }
                            z26 = true;
                            uu0.b.i(verticalDivider2, !z26);
                            eVar.positiveButton.setText(this.positiveButtonText);
                            eVar.negativeButton.setText(this.negativeButtonText);
                            if (this.positiveButtonTextColorId > 0) {
                            }
                            if (this.negativeButtonTextColorId > 0) {
                            }
                            eVar.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.ui.widget.c
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    e.a.d(e.a.this, eVar, view);
                                }
                            });
                            eVar.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.ui.widget.d
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    e.a.e(e.a.this, eVar, view);
                                }
                            });
                            eVar.setOnDismissListener(this.mDismissListener);
                            eVar.setCanceledOnTouchOutside(this.cancleOnOutside);
                            eVar.backPressEnable = this.backPressEnable;
                            eVar.lightMode = this.lightMode;
                            return eVar;
                        }
                    }
                    z17 = true;
                    uu0.b.i(subTitleView, !z17);
                    eVar.getTitleView().setText(this.title);
                    eVar.getTitleView().setGravity(this.titleGravity);
                    eVar.getSubTitleView().setText(this.subTitle);
                    eVar.getSubTitleView().setGravity(this.subTitleGravity);
                    if (this.customMsgView == null) {
                    }
                    TextView negativeButton2 = eVar.negativeButton;
                    Intrinsics.checkNotNullExpressionValue(negativeButton2, "negativeButton");
                    str2 = this.negativeButtonText;
                    if (str2 != null) {
                    }
                    z18 = true;
                    uu0.b.i(negativeButton2, !z18);
                    View verticalDivider22 = eVar.getVerticalDivider();
                    Intrinsics.checkNotNullExpressionValue(verticalDivider22, "verticalDivider");
                    str3 = this.negativeButtonText;
                    if (str3 != null) {
                    }
                    z26 = true;
                    uu0.b.i(verticalDivider22, !z26);
                    eVar.positiveButton.setText(this.positiveButtonText);
                    eVar.negativeButton.setText(this.negativeButtonText);
                    if (this.positiveButtonTextColorId > 0) {
                    }
                    if (this.negativeButtonTextColorId > 0) {
                    }
                    eVar.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.ui.widget.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            e.a.d(e.a.this, eVar, view);
                        }
                    });
                    eVar.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.ui.widget.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            e.a.e(e.a.this, eVar, view);
                        }
                    });
                    eVar.setOnDismissListener(this.mDismissListener);
                    eVar.setCanceledOnTouchOutside(this.cancleOnOutside);
                    eVar.backPressEnable = this.backPressEnable;
                    eVar.lightMode = this.lightMode;
                    return eVar;
                }
            }
            z16 = true;
            uu0.b.i(titleView, !z16);
            TextView subTitleView2 = eVar.getSubTitleView();
            Intrinsics.checkNotNullExpressionValue(subTitleView2, "subTitleView");
            str = this.subTitle;
            if (str != null) {
            }
            z17 = true;
            uu0.b.i(subTitleView2, !z17);
            eVar.getTitleView().setText(this.title);
            eVar.getTitleView().setGravity(this.titleGravity);
            eVar.getSubTitleView().setText(this.subTitle);
            eVar.getSubTitleView().setGravity(this.subTitleGravity);
            if (this.customMsgView == null) {
            }
            TextView negativeButton22 = eVar.negativeButton;
            Intrinsics.checkNotNullExpressionValue(negativeButton22, "negativeButton");
            str2 = this.negativeButtonText;
            if (str2 != null) {
            }
            z18 = true;
            uu0.b.i(negativeButton22, !z18);
            View verticalDivider222 = eVar.getVerticalDivider();
            Intrinsics.checkNotNullExpressionValue(verticalDivider222, "verticalDivider");
            str3 = this.negativeButtonText;
            if (str3 != null) {
            }
            z26 = true;
            uu0.b.i(verticalDivider222, !z26);
            eVar.positiveButton.setText(this.positiveButtonText);
            eVar.negativeButton.setText(this.negativeButtonText);
            if (this.positiveButtonTextColorId > 0) {
            }
            if (this.negativeButtonTextColorId > 0) {
            }
            eVar.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.ui.widget.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.a.d(e.a.this, eVar, view);
                }
            });
            eVar.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.ui.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.a.e(e.a.this, eVar, view);
                }
            });
            eVar.setOnDismissListener(this.mDismissListener);
            eVar.setCanceledOnTouchOutside(this.cancleOnOutside);
            eVar.backPressEnable = this.backPressEnable;
            eVar.lightMode = this.lightMode;
            return eVar;
        }

        @NotNull
        public final a f(@Nullable String message) {
            this.message = message;
            return this;
        }

        @NotNull
        public final a g(@Nullable String text) {
            this.negativeButtonText = text;
            return this;
        }

        @NotNull
        public final a h(@Nullable DialogInterface.OnClickListener listener) {
            this.positiveButtonClickListener = listener;
            return this;
        }

        @NotNull
        public final a i(@Nullable String text) {
            this.positiveButtonText = text;
            return this;
        }
    }

    public /* synthetic */ e(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Override // com.tencent.icgame.game.ui.widget.a
    @NotNull
    public View R() {
        View bgView = this.bgView;
        Intrinsics.checkNotNullExpressionValue(bgView, "bgView");
        return bgView;
    }

    @Override // com.tencent.icgame.game.ui.widget.a
    @NotNull
    public View S() {
        ConstraintLayout contentView = this.contentView;
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        return contentView;
    }

    /* renamed from: b0, reason: from getter */
    public final FrameLayout getContentContainer() {
        return this.contentContainer;
    }

    /* renamed from: c0, reason: from getter */
    public final TextView getSubTitleView() {
        return this.subTitleView;
    }

    /* renamed from: d0, reason: from getter */
    public final TextView getTitleView() {
        return this.titleView;
    }

    /* renamed from: e0, reason: from getter */
    public final View getVerticalDivider() {
        return this.verticalDivider;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.backPressEnable) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.icgame.game.ui.widget.a, com.tencent.icgame.game.ui.widget.h, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.lightMode) {
            com.tencent.icgame.game.utils.j.d(getWindow());
        }
    }

    e(Context context) {
        super(context);
        this.backPressEnable = true;
        View inflate = View.inflate(context, R.layout.fc_, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026game_common_dialog, null)");
        this.rootView = inflate;
        this.bgView = inflate.findViewById(R.id.t67);
        this.loadingView = (TimiGamePageLoadingView) inflate.findViewById(R.id.ef6);
        this.messageView = (TextView) inflate.findViewById(R.id.z5b);
        this.negativeButton = (TextView) inflate.findViewById(R.id.f6w);
        this.positiveButton = (TextView) inflate.findViewById(R.id.fxl);
        this.contentView = (ConstraintLayout) inflate.findViewById(R.id.b9r);
        this.titleView = (TextView) inflate.findViewById(R.id.jo5);
        this.subTitleView = (TextView) inflate.findViewById(R.id.f900651g);
        this.verticalDivider = inflate.findViewById(R.id.f116646za);
        this.contentContainer = (FrameLayout) inflate.findViewById(R.id.b9n);
        setContentView(inflate);
    }
}
