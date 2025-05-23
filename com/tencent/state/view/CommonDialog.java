package com.tencent.state.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareLibraryCommonDialogBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\fH\u0016J#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/view/CommonDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/state/view/CommonDialogData;", "(Landroid/content/Context;Lcom/tencent/state/view/CommonDialogData;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryCommonDialogBinding;", "dismissCallback", "Lkotlin/Function1;", "", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function1;", "setDismissCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasClickedBtn", "", "dismiss", "getReportParams", "", "", "", "clickButton", "(Ljava/lang/Integer;)Ljava/util/Map;", "initListener", "initReport", "initView", "initWindow", "reportClick", "reportImp", "show", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CommonDialog extends Dialog {
    public static final int CANCEL = -1;
    public static final int CLOSE = 3;
    public static final int LEFT = 1;
    public static final int MID = 0;
    public static final int RIGHT = 2;
    private static final String TAG = "CommonDialog";
    private final VasSquareLibraryCommonDialogBinding binding;
    private final CommonDialogData data;
    private Function1<? super Integer, Unit> dismissCallback;
    private boolean hasClickedBtn;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean hadDialogShowing = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/view/CommonDialog$Companion;", "", "()V", "CANCEL", "", "CLOSE", "LEFT", "MID", "RIGHT", "TAG", "", "hadDialogShowing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getHadDialogShowing", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final AtomicBoolean getHadDialogShowing() {
            return CommonDialog.hadDialogShowing;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonDialog(Context context, CommonDialogData data) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        VasSquareLibraryCommonDialogBinding inflate = VasSquareLibraryCommonDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryCommonDi\u2026utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getMContainer());
        initWindow();
        initReport();
        initListener();
        initView();
    }

    private final void initListener() {
        this.binding.btnLeft.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.CommonDialog$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonDialog.this.reportClick(1);
                Function1<Integer, Unit> dismissCallback = CommonDialog.this.getDismissCallback();
                if (dismissCallback != null) {
                    dismissCallback.invoke(1);
                }
                CommonDialog.this.hasClickedBtn = true;
                CommonDialog.this.dismiss();
            }
        });
        this.binding.btnRight.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.CommonDialog$initListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonDialog.this.reportClick(2);
                Function1<Integer, Unit> dismissCallback = CommonDialog.this.getDismissCallback();
                if (dismissCallback != null) {
                    dismissCallback.invoke(2);
                }
                CommonDialog.this.hasClickedBtn = true;
                CommonDialog.this.dismiss();
            }
        });
        this.binding.btnMid.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.CommonDialog$initListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonDialog.this.reportClick(0);
                Function1<Integer, Unit> dismissCallback = CommonDialog.this.getDismissCallback();
                if (dismissCallback != null) {
                    dismissCallback.invoke(0);
                }
                CommonDialog.this.hasClickedBtn = true;
                CommonDialog.this.dismiss();
            }
        });
        this.binding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.CommonDialog$initListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonDialog.this.reportClick(3);
                Function1<Integer, Unit> dismissCallback = CommonDialog.this.getDismissCallback();
                if (dismissCallback != null) {
                    dismissCallback.invoke(3);
                }
                CommonDialog.this.hasClickedBtn = true;
                CommonDialog.this.dismiss();
            }
        });
    }

    private final void initReport() {
        CommonDialogReportParams reportParams = this.data.getReportParams();
        if (reportParams != null) {
            Function2<Dialog, View, Unit> onBeforeInit = reportParams.getOnBeforeInit();
            RelativeLayout mContainer = this.binding.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
            onBeforeInit.invoke(this, mContainer);
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            RelativeLayout relativeLayout = this.binding.dialogContent;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.dialogContent");
            squareReporter.setElementInfo(relativeLayout, reportParams.getElementId(), getReportParams$default(this, null, 1, null), false, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        String resFilePath;
        boolean isBlank;
        Integer marginTop;
        Integer marginBottom;
        View contentView;
        boolean z16;
        boolean isBlank2;
        int dip;
        int dip2;
        TextView textView = this.binding.titleName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleName");
        textView.setText(this.data.getTitle());
        if (this.data.getNoTitle()) {
            TextView textView2 = this.binding.titleName;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleName");
            textView2.setVisibility(8);
        }
        if (this.data.getMidButton() != null) {
            TextView textView3 = this.binding.btnMid;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.btnMid");
            textView3.setVisibility(0);
            TextView textView4 = this.binding.btnMid;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.btnMid");
            textView4.setText(this.data.getMidButton());
            LinearLayout linearLayout = this.binding.conformView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.conformView");
            linearLayout.setVisibility(8);
        } else {
            TextView textView5 = this.binding.btnMid;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.btnMid");
            textView5.setVisibility(8);
            LinearLayout linearLayout2 = this.binding.conformView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.conformView");
            linearLayout2.setVisibility(0);
            TextView textView6 = this.binding.btnLeft;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.btnLeft");
            textView6.setText(this.data.getLeftButton());
            TextView textView7 = this.binding.btnRight;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.btnRight");
            textView7.setText(this.data.getRightButton());
        }
        ResStyle resStyle = this.data.getResStyle();
        if (resStyle != null) {
            SquareImageView squareImageView = this.binding.headIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.headIcon");
            ViewGroup.LayoutParams layoutParams = squareImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = resStyle.getWidth();
            }
            SquareImageView squareImageView2 = this.binding.headIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.headIcon");
            ViewGroup.LayoutParams layoutParams2 = squareImageView2.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = resStyle.getHeight();
            }
            SquareImageView squareImageView3 = this.binding.headIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.headIcon");
            ViewGroup.LayoutParams layoutParams3 = squareImageView3.getLayoutParams();
            if (!(layoutParams3 instanceof RelativeLayout.LayoutParams)) {
                layoutParams3 = null;
            }
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            if (layoutParams4 != null) {
                Integer marginBottom2 = resStyle.getMarginBottom();
                if (marginBottom2 != null) {
                    dip2 = marginBottom2.intValue();
                } else {
                    dip2 = ViewExtensionsKt.dip(getContext(), -60);
                }
                layoutParams4.bottomMargin = dip2;
            }
            View view = this.binding.imagePadding;
            Intrinsics.checkNotNullExpressionValue(view, "binding.imagePadding");
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            if (layoutParams5 != null) {
                Integer imagePadding = resStyle.getImagePadding();
                if (imagePadding != null) {
                    dip = imagePadding.intValue();
                } else {
                    dip = ViewExtensionsKt.dip(getContext(), 43);
                }
                layoutParams5.height = dip;
            }
            Integer bgResId = resStyle.getBgResId();
            if (bgResId != null) {
                this.binding.contentContainer.setBackgroundResource(bgResId.intValue());
            }
            Integer contentMarginBottom = resStyle.getContentMarginBottom();
            if (contentMarginBottom != null) {
                final int intValue = contentMarginBottom.intValue();
                LinearLayout linearLayout3 = this.binding.extraContent;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.extraContent");
                com.tencent.state.ViewExtensionsKt.updateLayoutParams(linearLayout3, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.view.CommonDialog$initView$1$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                        invoke2(marginLayoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.bottomMargin = intValue;
                    }
                });
            }
        }
        ResStyle resStyle2 = this.data.getResStyle();
        if ((resStyle2 != null ? resStyle2.getResId() : null) == null) {
            ResStyle resStyle3 = this.data.getResStyle();
            String resFilePath2 = resStyle3 != null ? resStyle3.getResFilePath() : null;
            if (resFilePath2 != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(resFilePath2);
                if (!isBlank2) {
                    z16 = false;
                    if (z16) {
                        ResStyle resStyle4 = this.data.getResStyle();
                        if ((resStyle4 != null ? resStyle4.getResDrawable() : null) == null) {
                            SquareImageView squareImageView4 = this.binding.headIcon;
                            Intrinsics.checkNotNullExpressionValue(squareImageView4, "binding.headIcon");
                            squareImageView4.setVisibility(8);
                            View view2 = this.binding.imagePadding;
                            Intrinsics.checkNotNullExpressionValue(view2, "binding.imagePadding");
                            view2.setVisibility(8);
                            TextView textView8 = this.binding.contentText;
                            Intrinsics.checkNotNullExpressionValue(textView8, "binding.contentText");
                            textView8.setText(this.data.getContentStyle().getTextContent());
                            TextView textView9 = this.binding.contentText;
                            Intrinsics.checkNotNullExpressionValue(textView9, "binding.contentText");
                            textView9.setTextSize(this.data.getContentStyle().getTextSize());
                            this.binding.contentText.setTextColor(this.data.getContentStyle().getTextColor());
                            TextView textView10 = this.binding.contentText;
                            Intrinsics.checkNotNullExpressionValue(textView10, "binding.contentText");
                            textView10.setGravity(this.data.getContentStyle().getGravity());
                            if (this.data.getContentStyle().isBold()) {
                                TextView textView11 = this.binding.contentText;
                                Intrinsics.checkNotNullExpressionValue(textView11, "binding.contentText");
                                textView11.setTypeface(Typeface.DEFAULT_BOLD);
                            }
                            marginTop = this.data.getContentStyle().getMarginTop();
                            if (marginTop != null) {
                                final int intValue2 = marginTop.intValue();
                                TextView textView12 = this.binding.contentText;
                                Intrinsics.checkNotNullExpressionValue(textView12, "binding.contentText");
                                com.tencent.state.ViewExtensionsKt.updateLayoutParams(textView12, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.view.CommonDialog$initView$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                                        invoke2(marginLayoutParams);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                                        receiver.topMargin = intValue2;
                                    }
                                });
                            }
                            marginBottom = this.data.getContentStyle().getMarginBottom();
                            if (marginBottom != null) {
                                final int intValue3 = marginBottom.intValue();
                                TextView textView13 = this.binding.contentText;
                                Intrinsics.checkNotNullExpressionValue(textView13, "binding.contentText");
                                com.tencent.state.ViewExtensionsKt.updateLayoutParams(textView13, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.view.CommonDialog$initView$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                                        invoke2(marginLayoutParams);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                                        receiver.bottomMargin = intValue3;
                                    }
                                });
                            }
                            contentView = this.data.getContentView();
                            if (contentView != null) {
                                this.binding.extraContent.addView(contentView);
                            }
                            SquareImageView squareImageView5 = this.binding.btnClose;
                            Intrinsics.checkNotNullExpressionValue(squareImageView5, "binding.btnClose");
                            com.tencent.state.ViewExtensionsKt.setVisibility(squareImageView5, this.data.isShowCloseButton());
                        }
                    }
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        View view3 = this.binding.imagePadding;
        Intrinsics.checkNotNullExpressionValue(view3, "binding.imagePadding");
        view3.setVisibility(0);
        SquareImageView squareImageView6 = this.binding.headIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView6, "binding.headIcon");
        squareImageView6.setVisibility(0);
        ResStyle resStyle5 = this.data.getResStyle();
        if ((resStyle5 != null ? resStyle5.getResId() : null) != null) {
            this.binding.headIcon.setImageResource(this.data.getResStyle().getResId().intValue());
        }
        ResStyle resStyle6 = this.data.getResStyle();
        if (resStyle6 != null && (resFilePath = resStyle6.getResFilePath()) != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(resFilePath);
            if (!isBlank) {
                this.binding.headIcon.setImageDrawable(URLDrawable.getFileDrawable(this.data.getResStyle().getResFilePath(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
            }
        }
        ResStyle resStyle7 = this.data.getResStyle();
        if ((resStyle7 != null ? resStyle7.getResDrawable() : null) != null) {
            this.binding.headIcon.setImageDrawable(this.data.getResStyle().getResDrawable());
        }
        TextView textView82 = this.binding.contentText;
        Intrinsics.checkNotNullExpressionValue(textView82, "binding.contentText");
        textView82.setText(this.data.getContentStyle().getTextContent());
        TextView textView92 = this.binding.contentText;
        Intrinsics.checkNotNullExpressionValue(textView92, "binding.contentText");
        textView92.setTextSize(this.data.getContentStyle().getTextSize());
        this.binding.contentText.setTextColor(this.data.getContentStyle().getTextColor());
        TextView textView102 = this.binding.contentText;
        Intrinsics.checkNotNullExpressionValue(textView102, "binding.contentText");
        textView102.setGravity(this.data.getContentStyle().getGravity());
        if (this.data.getContentStyle().isBold()) {
        }
        marginTop = this.data.getContentStyle().getMarginTop();
        if (marginTop != null) {
        }
        marginBottom = this.data.getContentStyle().getMarginBottom();
        if (marginBottom != null) {
        }
        contentView = this.data.getContentView();
        if (contentView != null) {
        }
        SquareImageView squareImageView52 = this.binding.btnClose;
        Intrinsics.checkNotNullExpressionValue(squareImageView52, "binding.btnClose");
        com.tencent.state.ViewExtensionsKt.setVisibility(squareImageView52, this.data.isShowCloseButton());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportClick(int clickButton) {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout = this.binding.dialogContent;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.dialogContent");
        squareReporter.reportEvent("clck", relativeLayout, getReportParams(Integer.valueOf(clickButton)));
    }

    private final void reportImp() {
        SquareBaseKt.getSquareThread().postOnUiDelayed(50L, new Function0<Unit>() { // from class: com.tencent.state.view.CommonDialog$reportImp$1
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
                VasSquareLibraryCommonDialogBinding vasSquareLibraryCommonDialogBinding;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                vasSquareLibraryCommonDialogBinding = CommonDialog.this.binding;
                RelativeLayout relativeLayout = vasSquareLibraryCommonDialogBinding.dialogContent;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.dialogContent");
                squareReporter.reportEvent("imp", relativeLayout, CommonDialog.getReportParams$default(CommonDialog.this, null, 1, null));
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Function1<? super Integer, Unit> function1;
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("dialog close ");
        sb5.append(this.data.getTitle());
        sb5.append(", hadDialogShowing: ");
        AtomicBoolean atomicBoolean = hadDialogShowing;
        sb5.append(atomicBoolean);
        squareLog.i(TAG, sb5.toString());
        atomicBoolean.compareAndSet(true, false);
        super.dismiss();
        if (this.hasClickedBtn || (function1 = this.dismissCallback) == null) {
            return;
        }
        function1.invoke(-1);
    }

    public final Function1<Integer, Unit> getDismissCallback() {
        return this.dismissCallback;
    }

    public final Map<String, Object> getReportParams(Integer clickButton) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        CommonDialogReportParams reportParams = this.data.getReportParams();
        if (reportParams != null) {
            linkedHashMap.putAll(reportParams.getExtraParams());
            if (clickButton != null) {
                int intValue = clickButton.intValue();
                String clickButtonKey = reportParams.getClickButtonKey();
                String str = reportParams.getClickButtonValue().get(Integer.valueOf(intValue));
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put(clickButtonKey, str);
            }
        }
        return linkedHashMap;
    }

    public final void setDismissCallback(Function1<? super Integer, Unit> function1) {
        this.dismissCallback = function1;
    }

    @Override // android.app.Dialog
    public void show() {
        String stackTraceToString;
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("dialog open ");
        sb5.append(this.data.getTitle());
        sb5.append(", hadDialogShowing: ");
        AtomicBoolean atomicBoolean = hadDialogShowing;
        sb5.append(atomicBoolean);
        squareLog.i(TAG, sb5.toString());
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                super.show();
                reportImp();
                return;
            } catch (Exception e16) {
                SquareLogger squareLog2 = SquareBaseKt.getSquareLog();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("dialog show exception ");
                sb6.append(this.data.getTitle());
                sb6.append(", ");
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                sb6.append(stackTraceToString);
                squareLog2.w(TAG, sb6.toString());
                hadDialogShowing.compareAndSet(true, false);
                return;
            }
        }
        SquareBaseKt.getSquareLog().i(TAG, "dialog conflict " + this.data.getTitle() + ", hadDialogShowing: " + atomicBoolean);
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public static /* synthetic */ Map getReportParams$default(CommonDialog commonDialog, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        return commonDialog.getReportParams(num);
    }
}
