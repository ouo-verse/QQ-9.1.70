package com.tencent.mobileqq.wink.templatelibrary.meme.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.immersive.utils.QFSPersonalDraftUtil;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.util.m;
import com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel.WinkMemeViewModel;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u73.Background;
import u73.MemeData;
import u73.RecommendText;

@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001Y\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001dB\u0007\u00a2\u0006\u0004\ba\u0010bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J*\u0010!\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0016J*\u0010#\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010$H\u0016R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010.R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00106R\u0018\u0010A\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00106R\u0018\u0010C\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00106R\u0018\u0010E\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00106R\u0018\u0010G\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010.R\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010.R\u0016\u0010S\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010MR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010(\u001a\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/meme/part/WinkMemeDetailPart;", "Lp53/b;", "Landroid/view/View$OnClickListener;", "Landroid/text/TextWatcher;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "T9", "initData", "initViewModel", "", ark.ARKMETADATA_JSON, "Q9", "P9", "Landroid/content/DialogInterface$OnClickListener;", "positionListener", "ea", "textToInsert", "aa", "onInitView", "v", NodeProps.ON_CLICK, "", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "Lcom/tencent/mobileqq/wink/templatelibrary/meme/viewmodel/WinkMemeViewModel;", "d", "Lkotlin/Lazy;", "S9", "()Lcom/tencent/mobileqq/wink/templatelibrary/meme/viewmodel/WinkMemeViewModel;", "memeViewModel", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "winkMemeBackBtn", "Landroid/widget/EditText;", "f", "Landroid/widget/EditText;", "memeContentInput", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "textLimitShow", "i", "memeContentClear", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "memeTextHintLl", BdhLogUtil.LogTag.Tag_Conn, "memeTextHint1", "D", "memeTextHint2", "E", "memeTextHint3", UserInfo.SEX_FEMALE, "memeChangeText", "G", "memeChangeIv", "Landroid/widget/Button;", "H", "Landroid/widget/Button;", "memeGenerateBtn", "Landroid/widget/RelativeLayout;", "I", "Landroid/widget/RelativeLayout;", "memeToolBarRl", "J", "memeToolBarClose", "K", "rootHeight", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "L", "R9", "()Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingView", "com/tencent/mobileqq/wink/templatelibrary/meme/part/WinkMemeDetailPart$runnable$1", "M", "Lcom/tencent/mobileqq/wink/templatelibrary/meme/part/WinkMemeDetailPart$runnable$1;", "runnable", "Landroid/text/InputFilter;", "N", "Landroid/text/InputFilter;", "inputFilter", "<init>", "()V", "P", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMemeDetailPart extends p53.b implements View.OnClickListener, TextWatcher {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView memeTextHint1;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView memeTextHint2;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView memeTextHint3;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView memeChangeText;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView memeChangeIv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Button memeGenerateBtn;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout memeToolBarRl;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ImageView memeToolBarClose;

    /* renamed from: K, reason: from kotlin metadata */
    private int rootHeight;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final WinkMemeDetailPart$runnable$1 runnable;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final InputFilter inputFilter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy memeViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView winkMemeBackBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText memeContentInput;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView textLimitShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView memeContentClear;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout memeTextHintLl;

    public WinkMemeDetailPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkMemeViewModel>() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.WinkMemeDetailPart$memeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkMemeViewModel invoke() {
                return (WinkMemeViewModel) WinkMemeDetailPart.this.getViewModel(WinkMemeViewModel.class);
            }
        });
        this.memeViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new WinkMemeDetailPart$loadingView$2(this));
        this.loadingView = lazy2;
        this.runnable = new WinkMemeDetailPart$runnable$1(this);
        this.inputFilter = new InputFilter() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.i
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
                CharSequence Z9;
                Z9 = WinkMemeDetailPart.Z9(charSequence, i3, i16, spanned, i17, i18);
                return Z9;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        if (R9().isShowing() && getHostFragment().isAdded()) {
            R9().dismiss();
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(String json) {
        Object obj;
        Pair<Integer, Integer> g16 = m.f322645a.g(getContext());
        Bundle arguments = getHostFragment().getArguments();
        String str = null;
        if (arguments != null) {
            obj = arguments.get("key_content");
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str == null) {
            str = "";
        }
        WinkMemeViewModel S9 = S9();
        int intValue = g16.getFirst().intValue();
        int intValue2 = g16.getSecond().intValue();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        S9.W1(json, intValue, intValue2, context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QCircleCommonLoadingDialog R9() {
        Object value = this.loadingView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingView>(...)");
        return (QCircleCommonLoadingDialog) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMemeViewModel S9() {
        Object value = this.memeViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-memeViewModel>(...)");
        return (WinkMemeViewModel) value;
    }

    private final void T9(final View rootView) {
        Rect rect = new Rect();
        rootView.getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        this.rootHeight = height;
        w53.b.f("WinkMemeDetailPart", "height:" + height);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.h
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                WinkMemeDetailPart.U9(rootView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(View rootView, WinkMemeDetailPart this$0) {
        RelativeLayout relativeLayout;
        ViewGroup.LayoutParams layoutParams;
        boolean isInMultiWindowMode;
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Rect rect = new Rect();
        rootView.getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        w53.b.a("WinkMemeDetailPart", "newHeight:" + height);
        if (Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = this$0.getActivity().isInMultiWindowMode();
            if (isInMultiWindowMode) {
                RelativeLayout relativeLayout2 = this$0.memeToolBarRl;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                    return;
                }
                return;
            }
        }
        if (rect.width() > rect.height()) {
            RelativeLayout relativeLayout3 = this$0.memeToolBarRl;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
                return;
            }
            return;
        }
        if (this$0.rootHeight - height > 150 && height != ViewUtils.getScreenHeightByContext(this$0.getContext()) && height != ViewUtils.getScreenWidthByContext(this$0.getContext())) {
            int i3 = this$0.rootHeight - height;
            RelativeLayout relativeLayout4 = this$0.memeToolBarRl;
            ConstraintLayout.LayoutParams layoutParams2 = null;
            if (relativeLayout4 != null) {
                layoutParams = relativeLayout4.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            }
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i3;
            }
            RelativeLayout relativeLayout5 = this$0.memeToolBarRl;
            if (relativeLayout5 != null) {
                relativeLayout5.requestLayout();
            }
            RelativeLayout relativeLayout6 = this$0.memeToolBarRl;
            if (relativeLayout6 != null) {
                relativeLayout6.setVisibility(0);
            }
        } else if (height - this$0.rootHeight > 150 && (relativeLayout = this$0.memeToolBarRl) != null) {
            relativeLayout.setVisibility(8);
        }
        this$0.rootHeight = height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence Z9(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
        int length = 500 - (spanned.length() - (i18 - i17));
        if (length <= 0) {
            return "";
        }
        if (length >= i16 - i3) {
            return null;
        }
        return charSequence.subSequence(i3, length + i3);
    }

    private final void aa(String textToInsert) {
        EditText editText;
        if (textToInsert != null && (editText = this.memeContentInput) != null) {
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            Editable text = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            text.replace(selectionStart, selectionEnd, textToInsert);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(WinkMemeDetailPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getHostFragment().getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(WinkMemeDetailPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.memeContentInput;
        if (editText != null) {
            editText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(WinkMemeDetailPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getHostFragment().getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void ea(DialogInterface.OnClickListener positionListener) {
        Context context = getContext();
        if (context != null) {
            ViewUtilsKt.n(context, R.string.f215665w8, 0, Integer.valueOf(R.string.f215685w_), positionListener, null, null, 100, null);
        }
    }

    private final void initData() {
        S9().initData();
    }

    private final void initViewModel() {
        MutableLiveData<String> c26 = S9().c2();
        Fragment hostFragment = getHostFragment();
        final WinkMemeDetailPart$initViewModel$1 winkMemeDetailPart$initViewModel$1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.WinkMemeDetailPart$initViewModel$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        };
        c26.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMemeDetailPart.V9(Function1.this, obj);
            }
        });
        MutableLiveData<Triple<RecommendText, RecommendText, RecommendText>> b26 = S9().b2();
        Fragment hostFragment2 = getHostFragment();
        final Function1<Triple<? extends RecommendText, ? extends RecommendText, ? extends RecommendText>, Unit> function1 = new Function1<Triple<? extends RecommendText, ? extends RecommendText, ? extends RecommendText>, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.WinkMemeDetailPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends RecommendText, ? extends RecommendText, ? extends RecommendText> triple) {
                invoke2((Triple<RecommendText, RecommendText, RecommendText>) triple);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Triple<RecommendText, RecommendText, RecommendText> triple) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                textView = WinkMemeDetailPart.this.memeTextHint1;
                if (textView != null) {
                    String title = triple.getFirst().getTitle();
                    if (title.length() == 0) {
                        title = triple.getFirst().getContent();
                    }
                    textView.setText(title);
                }
                textView2 = WinkMemeDetailPart.this.memeTextHint2;
                if (textView2 != null) {
                    String title2 = triple.getSecond().getTitle();
                    if (title2.length() == 0) {
                        title2 = triple.getSecond().getContent();
                    }
                    textView2.setText(title2);
                }
                textView3 = WinkMemeDetailPart.this.memeTextHint3;
                if (textView3 == null) {
                    return;
                }
                String title3 = triple.getThird().getTitle();
                if (title3.length() == 0) {
                    title3 = triple.getThird().getContent();
                }
                textView3.setText(title3);
            }
        };
        b26.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMemeDetailPart.W9(Function1.this, obj);
            }
        });
        MutableLiveData<Pair<Boolean, String>> a26 = S9().a2();
        Fragment hostFragment3 = getHostFragment();
        final Function1<Pair<? extends Boolean, ? extends String>, Unit> function12 = new Function1<Pair<? extends Boolean, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.WinkMemeDetailPart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends String> pair) {
                invoke2((Pair<Boolean, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, String> pair) {
                w53.b.f("WinkMemeDetailPart", "queryResult... result:" + pair);
                if (pair.getFirst().booleanValue()) {
                    WinkMemeDetailPart.this.Q9(pair.getSecond());
                } else {
                    WinkMemeDetailPart.this.P9();
                    QQToast.makeText(WinkMemeDetailPart.this.getContext(), 1, TextUtils.isEmpty(pair.getSecond()) ? VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT : pair.getSecond(), 1).show();
                }
            }
        };
        a26.observe(hostFragment3, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMemeDetailPart.X9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> Z1 = S9().Z1();
        Fragment hostFragment4 = getHostFragment();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.WinkMemeDetailPart$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isSuccess) {
                WinkMemeViewModel S9;
                ArrayList arrayList;
                List<Background> a16;
                int collectionSizeOrDefault;
                w53.b.f("WinkMemeDetailPart", "downloadAndSaveFinish... isSuccess:" + isSuccess);
                WinkMemeDetailPart.this.P9();
                Intrinsics.checkNotNullExpressionValue(isSuccess, "isSuccess");
                if (isSuccess.booleanValue()) {
                    QFSPersonalDraftUtil qFSPersonalDraftUtil = new QFSPersonalDraftUtil();
                    Activity activity = WinkMemeDetailPart.this.getActivity();
                    DraftBean draftBean = new DraftBean();
                    WinkMemeDetailPart winkMemeDetailPart = WinkMemeDetailPart.this;
                    draftBean.setMissionId(WinkContext.INSTANCE.d().getMissionId());
                    S9 = winkMemeDetailPart.S9();
                    MemeData currentMemeData = S9.getCurrentMemeData();
                    if (currentMemeData == null || (a16 = currentMemeData.a()) == null) {
                        arrayList = null;
                    } else {
                        List<Background> list = a16;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Background) it.next()).c());
                        }
                    }
                    draftBean.setOriginPath(arrayList);
                    Unit unit = Unit.INSTANCE;
                    qFSPersonalDraftUtil.c(activity, draftBean, 12);
                    return;
                }
                QQToast.makeText(WinkMemeDetailPart.this.getContext(), "\u8d44\u6e90\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 1);
            }
        };
        Z1.observe(hostFragment4, new Observer() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMemeDetailPart.Y9(Function1.this, obj);
            }
        });
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s16) {
        boolean z16;
        if (s16 != null && s16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Button button = this.memeGenerateBtn;
            if (button != null) {
                button.setClickable(false);
            }
            Button button2 = this.memeGenerateBtn;
            if (button2 != null) {
                button2.setAlpha(0.3f);
                return;
            }
            return;
        }
        Button button3 = this.memeGenerateBtn;
        if (button3 != null) {
            button3.setClickable(true);
        }
        Button button4 = this.memeGenerateBtn;
        if (button4 != null) {
            button4.setAlpha(1.0f);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Editable text;
        EditText editText = this.memeContentInput;
        boolean z16 = false;
        if (editText != null && (text = editText.getText()) != null && text.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return super.onBackEvent();
        }
        ea(new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkMemeDetailPart.ba(WinkMemeDetailPart.this, dialogInterface, i3);
            }
        });
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        byte b16;
        RecommendText third;
        RecommendText second;
        RecommendText first;
        Editable text;
        Editable text2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IBinder iBinder = null;
        Editable editable = null;
        r0 = null;
        String str = null;
        r0 = null;
        String str2 = null;
        r0 = null;
        String str3 = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        boolean z16 = true;
        if (num != null && num.intValue() == R.id.f123527gw) {
            EditText editText = this.memeContentInput;
            if (editText == null || (text2 = editText.getText()) == null || text2.length() != 0) {
                z16 = false;
            }
            if (z16) {
                FragmentActivity activity = getHostFragment().getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else {
                ea(new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        WinkMemeDetailPart.da(WinkMemeDetailPart.this, dialogInterface, i3);
                    }
                });
            }
        } else {
            if ((num != null && num.intValue() == R.id.z2b) || (num != null && num.intValue() == R.id.z2a)) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 != false) {
                S9().U1();
            } else if (num != null && num.intValue() == R.id.z2g) {
                WinkMemeViewModel S9 = S9();
                EditText editText2 = this.memeContentInput;
                if (editText2 != null) {
                    editable = editText2.getText();
                }
                S9.f2(String.valueOf(editable));
                R9().show();
                R9().setProgress(0);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                WinkMemeDetailPart$runnable$1 winkMemeDetailPart$runnable$1 = this.runnable;
                winkMemeDetailPart$runnable$1.a(0);
                uIHandlerV2.post(winkMemeDetailPart$runnable$1);
            } else if (num != null && num.intValue() == R.id.z2c) {
                EditText editText3 = this.memeContentInput;
                if (editText3 == null || (text = editText3.getText()) == null || text.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    EditText editText4 = this.memeContentInput;
                    if (editText4 != null) {
                        editText4.setText("");
                    }
                } else {
                    ea(new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            WinkMemeDetailPart.ca(WinkMemeDetailPart.this, dialogInterface, i3);
                        }
                    });
                }
            } else if (num != null && num.intValue() == R.id.z2h) {
                Triple<RecommendText, RecommendText, RecommendText> value = S9().b2().getValue();
                if (value != null && (first = value.getFirst()) != null) {
                    str = first.getContent();
                }
                aa(str);
            } else if (num != null && num.intValue() == R.id.z2i) {
                Triple<RecommendText, RecommendText, RecommendText> value2 = S9().b2().getValue();
                if (value2 != null && (second = value2.getSecond()) != null) {
                    str2 = second.getContent();
                }
                aa(str2);
            } else if (num != null && num.intValue() == R.id.z2j) {
                Triple<RecommendText, RecommendText, RecommendText> value3 = S9().b2().getValue();
                if (value3 != null && (third = value3.getThird()) != null) {
                    str3 = third.getContent();
                }
                aa(str3);
            } else if (num != null && num.intValue() == R.id.z2l) {
                EditText editText5 = this.memeContentInput;
                if (editText5 != null) {
                    editText5.clearFocus();
                }
                Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                EditText editText6 = this.memeContentInput;
                if (editText6 != null) {
                    iBinder = editText6.getWindowToken();
                }
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.f123527gw);
            this.winkMemeBackBtn = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
            EditText editText = (EditText) rootView.findViewById(R.id.z2e);
            this.memeContentInput = editText;
            if (editText != null) {
                editText.addTextChangedListener(this);
            }
            EditText editText2 = this.memeContentInput;
            if (editText2 != null) {
                editText2.setFilters(new InputFilter[]{this.inputFilter});
            }
            this.textLimitShow = (TextView) rootView.findViewById(R.id.f95495f5);
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.z2c);
            this.memeContentClear = imageView2;
            if (imageView2 != null) {
                imageView2.setOnClickListener(this);
            }
            this.memeTextHintLl = (LinearLayout) rootView.findViewById(R.id.z2k);
            TextView textView = (TextView) rootView.findViewById(R.id.z2h);
            this.memeTextHint1 = textView;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = (TextView) rootView.findViewById(R.id.z2i);
            this.memeTextHint2 = textView2;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            TextView textView3 = (TextView) rootView.findViewById(R.id.z2j);
            this.memeTextHint3 = textView3;
            if (textView3 != null) {
                textView3.setOnClickListener(this);
            }
            TextView textView4 = (TextView) rootView.findViewById(R.id.z2b);
            this.memeChangeText = textView4;
            if (textView4 != null) {
                textView4.setOnClickListener(this);
            }
            ImageView imageView3 = (ImageView) rootView.findViewById(R.id.z2a);
            this.memeChangeIv = imageView3;
            if (imageView3 != null) {
                imageView3.setOnClickListener(this);
            }
            Button button = (Button) rootView.findViewById(R.id.z2g);
            if (button != null) {
                Intrinsics.checkNotNullExpressionValue(button, "findViewById<Button?>(R.id.meme_generate_btn)");
                button.setOnClickListener(this);
                button.setClickable(false);
                button.setAlpha(0.3f);
                com.tencent.mobileqq.wink.report.a.d(com.tencent.mobileqq.wink.report.a.f326259a, button, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBMIT_BUTTON, null, ExposurePolicy.REPORT_NONE, null, null, null, 116, null);
            } else {
                button = null;
            }
            this.memeGenerateBtn = button;
            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.z2m);
            this.memeToolBarRl = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            T9(rootView);
            ImageView imageView4 = (ImageView) rootView.findViewById(R.id.z2l);
            this.memeToolBarClose = imageView4;
            if (imageView4 != null) {
                imageView4.setOnClickListener(this);
            }
        }
        initViewModel();
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.runnable);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        int i3;
        TextView textView = this.textLimitShow;
        if (textView != null) {
            if (s16 != null) {
                i3 = s16.length();
            } else {
                i3 = 0;
            }
            textView.setText(i3 + "/500");
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
    }
}
