package com.tencent.timi.game.ui.widget;

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
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.ui.widget.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u00019B\u0011\b\u0002\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010'R\u0016\u0010+\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010'R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010'R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u001a\u00a8\u0006:"}, d2 = {"Lcom/tencent/timi/game/ui/widget/e;", "Lcom/tencent/timi/game/ui/widget/a;", "Lcom/tencent/timi/game/ui/widget/k;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "g0", "U", ExifInterface.LATITUDE_SOUTH, "onBackPressed", "Landroid/widget/TextView;", "k0", "j0", "i0", "", "text", "K", "hideLoadingView", "", "Z", "backPressEnable", "L", "lightMode", "M", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N", "bgView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "P", "Landroidx/constraintlayout/widget/ConstraintLayout;", "contentView", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "loadingView", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "positiveButton", "negativeButton", "T", "messageView", "titleView", "V", "subTitleView", "Landroid/widget/FrameLayout;", "W", "Landroid/widget/FrameLayout;", "contentContainer", "X", "verticalDivider", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e extends com.tencent.timi.game.ui.widget.a implements k {

    /* renamed from: K, reason: from kotlin metadata */
    private boolean backPressEnable;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean lightMode;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private View bgView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private ConstraintLayout contentView;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private TimiGamePageLoadingView loadingView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private TextView positiveButton;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private TextView negativeButton;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private TextView messageView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private TextView titleView;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private TextView subTitleView;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private FrameLayout contentContainer;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private View verticalDivider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0015\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013J8\u0010\u001e\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010'R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010'R\u0018\u00100\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010'R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010*R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010*R\u0016\u00104\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00103R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00106R\u0018\u00108\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00103R\u0016\u0010\u001f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00103R\u0016\u0010E\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00103R\u0016\u0010G\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010*\u00a8\u0006J"}, d2 = {"Lcom/tencent/timi/game/ui/widget/e$a;", "", "", "title", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "message", "j", "", LayoutAttrDefine.Gravity.Gravity, "k", "text", "p", "Landroid/content/DialogInterface$OnClickListener;", "listener", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/DialogInterface$OnDismissListener;", tl.h.F, "", "b", "f", MiniAppConst.MENU_STYLE_LIGHT, "i", "Landroid/view/View;", "view", "leftMargin", "topMargin", "rightMargin", "bottomMargin", "g", "negativeBtnCanDismiss", "l", "Lcom/tencent/timi/game/ui/widget/e;", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Ljava/lang/String;", QQWinkConstants.TAB_SUBTITLE, "d", "I", "titleGravity", "e", "subTitleGravity", "messageGravity", "positiveButtonText", "negativeButtonText", "positiveButtonTextColorId", "negativeButtonTextColorId", "Z", "cancleOnOutside", "backPressEnable", "Landroid/content/DialogInterface$OnClickListener;", "positiveButtonClickListener", "negativeButtonClickListener", "Landroid/content/DialogInterface$OnDismissListener;", "mDismissListener", "Landroid/view/View;", "customMsgView", "", "r", "[I", "customMargins", ReportConstant.COSTREPORT_PREFIX, "positiveBtnCanDismiss", "t", "u", "lightMode", "v", "messageMaxLine", "<init>", "(Landroid/content/Context;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
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

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00ef, code lost:
        
            if (r2 != false) goto L38;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
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
            eVar.titleView.setText(this.title);
            eVar.messageView.setText(this.message);
            eVar.messageView.setMaxLines(this.messageMaxLine);
            TextView textView = eVar.titleView;
            String str4 = this.title;
            boolean z26 = false;
            if (str4 != null) {
                isBlank5 = StringsKt__StringsJVMKt.isBlank(str4);
                if (!isBlank5) {
                    z16 = false;
                    fh4.g.o(textView, !z16);
                    TextView textView2 = eVar.subTitleView;
                    str = this.subTitle;
                    if (str != null) {
                        isBlank4 = StringsKt__StringsJVMKt.isBlank(str);
                        if (!isBlank4) {
                            z17 = false;
                            fh4.g.o(textView2, !z17);
                            eVar.titleView.setText(this.title);
                            eVar.titleView.setGravity(this.titleGravity);
                            eVar.subTitleView.setText(this.subTitle);
                            eVar.subTitleView.setGravity(this.subTitleGravity);
                            if (this.customMsgView == null) {
                                TextView textView3 = eVar.messageView;
                                String str5 = this.message;
                                if (str5 != null) {
                                    isBlank3 = StringsKt__StringsJVMKt.isBlank(str5);
                                    if (!isBlank3) {
                                        z19 = false;
                                        fh4.g.o(textView3, !z19);
                                        eVar.messageView.setText(this.message);
                                        eVar.messageView.setGravity(this.messageGravity);
                                    }
                                }
                                z19 = true;
                                fh4.g.o(textView3, !z19);
                                eVar.messageView.setText(this.message);
                                eVar.messageView.setGravity(this.messageGravity);
                            } else {
                                eVar.contentContainer.removeAllViews();
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                                int[] iArr = this.customMargins;
                                layoutParams.leftMargin = iArr[0];
                                layoutParams.topMargin = iArr[1];
                                layoutParams.rightMargin = iArr[2];
                                layoutParams.bottomMargin = iArr[3];
                                eVar.contentContainer.addView(this.customMsgView, layoutParams);
                            }
                            TextView textView4 = eVar.negativeButton;
                            str2 = this.negativeButtonText;
                            if (str2 != null) {
                                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                if (!isBlank2) {
                                    z18 = false;
                                    fh4.g.o(textView4, !z18);
                                    View view = eVar.verticalDivider;
                                    str3 = this.negativeButtonText;
                                    if (str3 != null) {
                                        isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                                    }
                                    z26 = true;
                                    fh4.g.o(view, !z26);
                                    eVar.positiveButton.setText(this.positiveButtonText);
                                    eVar.negativeButton.setText(this.negativeButtonText);
                                    if (this.positiveButtonTextColorId > 0) {
                                        eVar.positiveButton.setTextColor(yn4.c.a(this.positiveButtonTextColorId));
                                    }
                                    if (this.negativeButtonTextColorId > 0) {
                                        eVar.negativeButton.setTextColor(yn4.c.a(this.negativeButtonTextColorId));
                                    }
                                    eVar.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.c
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view2) {
                                            e.a.d(e.a.this, eVar, view2);
                                        }
                                    });
                                    eVar.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.d
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view2) {
                                            e.a.e(e.a.this, eVar, view2);
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
                            fh4.g.o(textView4, !z18);
                            View view2 = eVar.verticalDivider;
                            str3 = this.negativeButtonText;
                            if (str3 != null) {
                            }
                            z26 = true;
                            fh4.g.o(view2, !z26);
                            eVar.positiveButton.setText(this.positiveButtonText);
                            eVar.negativeButton.setText(this.negativeButtonText);
                            if (this.positiveButtonTextColorId > 0) {
                            }
                            if (this.negativeButtonTextColorId > 0) {
                            }
                            eVar.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.c
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view22) {
                                    e.a.d(e.a.this, eVar, view22);
                                }
                            });
                            eVar.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.d
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view22) {
                                    e.a.e(e.a.this, eVar, view22);
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
                    fh4.g.o(textView2, !z17);
                    eVar.titleView.setText(this.title);
                    eVar.titleView.setGravity(this.titleGravity);
                    eVar.subTitleView.setText(this.subTitle);
                    eVar.subTitleView.setGravity(this.subTitleGravity);
                    if (this.customMsgView == null) {
                    }
                    TextView textView42 = eVar.negativeButton;
                    str2 = this.negativeButtonText;
                    if (str2 != null) {
                    }
                    z18 = true;
                    fh4.g.o(textView42, !z18);
                    View view22 = eVar.verticalDivider;
                    str3 = this.negativeButtonText;
                    if (str3 != null) {
                    }
                    z26 = true;
                    fh4.g.o(view22, !z26);
                    eVar.positiveButton.setText(this.positiveButtonText);
                    eVar.negativeButton.setText(this.negativeButtonText);
                    if (this.positiveButtonTextColorId > 0) {
                    }
                    if (this.negativeButtonTextColorId > 0) {
                    }
                    eVar.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view222) {
                            e.a.d(e.a.this, eVar, view222);
                        }
                    });
                    eVar.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view222) {
                            e.a.e(e.a.this, eVar, view222);
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
            fh4.g.o(textView, !z16);
            TextView textView22 = eVar.subTitleView;
            str = this.subTitle;
            if (str != null) {
            }
            z17 = true;
            fh4.g.o(textView22, !z17);
            eVar.titleView.setText(this.title);
            eVar.titleView.setGravity(this.titleGravity);
            eVar.subTitleView.setText(this.subTitle);
            eVar.subTitleView.setGravity(this.subTitleGravity);
            if (this.customMsgView == null) {
            }
            TextView textView422 = eVar.negativeButton;
            str2 = this.negativeButtonText;
            if (str2 != null) {
            }
            z18 = true;
            fh4.g.o(textView422, !z18);
            View view222 = eVar.verticalDivider;
            str3 = this.negativeButtonText;
            if (str3 != null) {
            }
            z26 = true;
            fh4.g.o(view222, !z26);
            eVar.positiveButton.setText(this.positiveButtonText);
            eVar.negativeButton.setText(this.negativeButtonText);
            if (this.positiveButtonTextColorId > 0) {
            }
            if (this.negativeButtonTextColorId > 0) {
            }
            eVar.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2222) {
                    e.a.d(e.a.this, eVar, view2222);
                }
            });
            eVar.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2222) {
                    e.a.e(e.a.this, eVar, view2222);
                }
            });
            eVar.setOnDismissListener(this.mDismissListener);
            eVar.setCanceledOnTouchOutside(this.cancleOnOutside);
            eVar.backPressEnable = this.backPressEnable;
            eVar.lightMode = this.lightMode;
            return eVar;
        }

        @NotNull
        public final a f(boolean b16) {
            this.cancleOnOutside = b16;
            return this;
        }

        @NotNull
        public final a g(@Nullable View view, int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
            this.customMsgView = view;
            int[] iArr = this.customMargins;
            iArr[0] = leftMargin;
            iArr[1] = topMargin;
            iArr[2] = rightMargin;
            iArr[3] = bottomMargin;
            return this;
        }

        @NotNull
        public final a h(@Nullable DialogInterface.OnDismissListener listener) {
            this.mDismissListener = listener;
            return this;
        }

        @NotNull
        public final a i(boolean light) {
            this.lightMode = light;
            return this;
        }

        @NotNull
        public final a j(@Nullable String message) {
            this.message = message;
            return this;
        }

        @NotNull
        public final a k(int gravity) {
            this.messageGravity = gravity;
            return this;
        }

        @NotNull
        public final a l(boolean negativeBtnCanDismiss) {
            this.negativeBtnCanDismiss = negativeBtnCanDismiss;
            return this;
        }

        @NotNull
        public final a m(@Nullable DialogInterface.OnClickListener listener) {
            this.negativeButtonClickListener = listener;
            return this;
        }

        @NotNull
        public final a n(@Nullable String text) {
            this.negativeButtonText = text;
            return this;
        }

        @NotNull
        public final a o(@Nullable DialogInterface.OnClickListener listener) {
            this.positiveButtonClickListener = listener;
            return this;
        }

        @NotNull
        public final a p(@Nullable String text) {
            this.positiveButtonText = text;
            return this;
        }

        @NotNull
        public final a q(@Nullable String title) {
            this.title = title;
            return this;
        }
    }

    public /* synthetic */ e(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void K(@NotNull String text) {
        boolean z16;
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            text = this.G.getString(R.string.f23156727);
            Intrinsics.checkNotNullExpressionValue(text, "context.getString(R.stri\u2026ame_loading_hint_default)");
        }
        this.loadingView.setHintText(text);
        this.loadingView.d();
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    /* renamed from: S, reason: from getter */
    public View getBgView() {
        return this.bgView;
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    public View U() {
        return this.contentView;
    }

    @NotNull
    /* renamed from: g0, reason: from getter */
    public final View getRootView() {
        return this.rootView;
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void hideLoadingView() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.loadingView;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    @NotNull
    /* renamed from: i0, reason: from getter */
    public final TextView getMessageView() {
        return this.messageView;
    }

    @NotNull
    /* renamed from: j0, reason: from getter */
    public final TextView getNegativeButton() {
        return this.negativeButton;
    }

    @NotNull
    /* renamed from: k0, reason: from getter */
    public final TextView getPositiveButton() {
        return this.positiveButton;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.backPressEnable) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.a, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.lightMode) {
            com.tencent.timi.game.utils.u.e(getWindow());
        }
    }

    e(Context context) {
        super(context);
        this.backPressEnable = true;
        View inflate = View.inflate(context, R.layout.hxp, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026game_common_dialog, null)");
        this.rootView = inflate;
        setContentView(inflate);
        View findViewById = findViewById(R.id.t67);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.bgView)");
        this.bgView = findViewById;
        View findViewById2 = findViewById(R.id.b9r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.contentView)");
        this.contentView = (ConstraintLayout) findViewById2;
        View findViewById3 = findViewById(R.id.ef6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.loadingView)");
        this.loadingView = (TimiGamePageLoadingView) findViewById3;
        View findViewById4 = findViewById(R.id.fxl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.positiveButton)");
        this.positiveButton = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f6w);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.negativeButton)");
        this.negativeButton = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.z5b);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.messageView)");
        this.messageView = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.jo5);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.titleView)");
        this.titleView = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.f900651g);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.subTitleView)");
        this.subTitleView = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.contentContainer)");
        this.contentContainer = (FrameLayout) findViewById9;
        View findViewById10 = findViewById(R.id.f116646za);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.verticalDivider)");
        this.verticalDivider = findViewById10;
    }
}
