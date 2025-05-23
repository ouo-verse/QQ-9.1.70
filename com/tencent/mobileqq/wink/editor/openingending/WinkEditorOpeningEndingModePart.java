package com.tencent.mobileqq.wink.editor.openingending;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\"\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u001d\u0010%\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010)R\u001d\u0010/\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010.R\u001d\u00102\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001eR\u001d\u00105\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u0010)R\u001d\u00108\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\u001c\u001a\u0004\b7\u0010.R\u001d\u0010;\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010\u001c\u001a\u0004\b:\u0010\u001eR\u001d\u0010>\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010\u001c\u001a\u0004\b=\u0010)R\u001d\u0010A\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010\u001c\u001a\u0004\b@\u0010.\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingModePart;", "Lcom/tencent/mobileqq/wink/editor/d;", "", "aa", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "menuType", "", "needSwitchMenu", "xa", "Landroid/view/View;", "imageView", "textView", "select", "ba", "pa", "wa", "", "B9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "qa", "Landroid/view/View$OnClickListener;", "D", "Landroid/view/View$OnClickListener;", "finishBtnOnClick", "E", "backBtnOnClick", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "ga", "()Landroid/view/View;", "backBtn", "G", "oa", "finishedBtn", "H", "ha", "editClipBtn", "Landroid/widget/ImageView;", "I", "ia", "()Landroid/widget/ImageView;", "editClipImageView", "Landroid/widget/TextView;", "J", LocaleUtils.L_JAPANESE, "()Landroid/widget/TextView;", "editClipTextView", "K", "la", "editTextBtn", "L", "ma", "editTextImageView", "M", "na", "editTextTextView", "N", "ca", "aigcBtn", "P", "da", "aigcImageView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "ea", "aigcTextView", "<init>", "(Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingModePart extends com.tencent.mobileqq.wink.editor.d {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener finishBtnOnClick;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener backBtnOnClick;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy backBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy finishedBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy editClipBtn;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy editClipImageView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy editClipTextView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy editTextBtn;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy editTextImageView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy editTextTextView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy aigcBtn;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy aigcImageView;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy aigcTextView;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321336a;

        static {
            int[] iArr = new int[MenuType.values().length];
            try {
                iArr[MenuType.OPENING_ENDING_AIGC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MenuType.TEMPLATE_COLL_CLIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MenuType.TEMPLATE_TEXT_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f321336a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingModePart$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View ha5;
            boolean z16;
            ViewTreeObserver viewTreeObserver;
            View la5;
            boolean z17 = false;
            if (WinkEditorOpeningEndingModePart.this.G9().getIsAigcOpeningEndingTemplate()) {
                View ca5 = WinkEditorOpeningEndingModePart.this.ca();
                if (ca5 != null) {
                    ca5.setVisibility(0);
                }
            } else if (WinkEditorOpeningEndingModePart.this.G9().c2() && (ha5 = WinkEditorOpeningEndingModePart.this.ha()) != null) {
                ha5.setVisibility(0);
            }
            if (WinkEditorOpeningEndingModePart.this.G9().d2() && (la5 = WinkEditorOpeningEndingModePart.this.la()) != null) {
                la5.setVisibility(0);
            }
            View ca6 = WinkEditorOpeningEndingModePart.this.ca();
            if (ca6 != null && ca6.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                View ca7 = WinkEditorOpeningEndingModePart.this.ca();
                if (ca7 != null) {
                    ca7.performClick();
                }
            } else {
                View ha6 = WinkEditorOpeningEndingModePart.this.ha();
                if (ha6 != null && ha6.getVisibility() == 0) {
                    z17 = true;
                }
                if (z17) {
                    View ha7 = WinkEditorOpeningEndingModePart.this.ha();
                    if (ha7 != null) {
                        ha7.performClick();
                    }
                } else {
                    View la6 = WinkEditorOpeningEndingModePart.this.la();
                    if (la6 != null) {
                        la6.performClick();
                    }
                }
            }
            View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
            if (partRootView != null && (viewTreeObserver = partRootView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public WinkEditorOpeningEndingModePart(@NotNull View.OnClickListener finishBtnOnClick, @NotNull View.OnClickListener backBtnOnClick) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Intrinsics.checkNotNullParameter(finishBtnOnClick, "finishBtnOnClick");
        Intrinsics.checkNotNullParameter(backBtnOnClick, "backBtnOnClick");
        this.finishBtnOnClick = finishBtnOnClick;
        this.backBtnOnClick = backBtnOnClick;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$backBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return partRootView.findViewById(R.id.t2c);
                }
                return null;
            }
        });
        this.backBtn = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$finishedBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return partRootView.findViewById(R.id.v6j);
                }
                return null;
            }
        });
        this.finishedBtn = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$editClipBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return partRootView.findViewById(R.id.upj);
                }
                return null;
            }
        });
        this.editClipBtn = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$editClipImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return (ImageView) partRootView.findViewById(R.id.upk);
                }
                return null;
            }
        });
        this.editClipImageView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$editClipTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TextView invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return (TextView) partRootView.findViewById(R.id.upl);
                }
                return null;
            }
        });
        this.editClipTextView = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$editTextBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return partRootView.findViewById(R.id.upr);
                }
                return null;
            }
        });
        this.editTextBtn = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$editTextImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return (ImageView) partRootView.findViewById(R.id.ups);
                }
                return null;
            }
        });
        this.editTextImageView = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$editTextTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TextView invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return (TextView) partRootView.findViewById(R.id.upu);
                }
                return null;
            }
        });
        this.editTextTextView = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$aigcBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return partRootView.findViewById(R.id.sgm);
                }
                return null;
            }
        });
        this.aigcBtn = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$aigcImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return (ImageView) partRootView.findViewById(R.id.sgn);
                }
                return null;
            }
        });
        this.aigcImageView = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$aigcTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TextView invoke() {
                View partRootView = WinkEditorOpeningEndingModePart.this.getPartRootView();
                if (partRootView != null) {
                    return (TextView) partRootView.findViewById(R.id.sgo);
                }
                return null;
            }
        });
        this.aigcTextView = lazy11;
    }

    private final void aa() {
        View findViewById;
        View view = getHostFragment().getView();
        if (view != null && (findViewById = view.findViewById(R.id.f25760bp)) != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ImmersiveUtils.dpToPx(52.0f);
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = ImmersiveUtils.dpToPx(147.0f);
        }
    }

    private final void ba(View imageView, View textView, boolean select) {
        if (select) {
            if (imageView != null) {
                imageView.setAlpha(1.0f);
            }
            if (textView != null) {
                textView.setAlpha(1.0f);
                return;
            }
            return;
        }
        if (imageView != null) {
            imageView.setAlpha(0.55f);
        }
        if (textView != null) {
            textView.setAlpha(0.55f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View ca() {
        return (View) this.aigcBtn.getValue();
    }

    private final ImageView da() {
        return (ImageView) this.aigcImageView.getValue();
    }

    private final TextView ea() {
        return (TextView) this.aigcTextView.getValue();
    }

    private final View ga() {
        return (View) this.backBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View ha() {
        return (View) this.editClipBtn.getValue();
    }

    private final ImageView ia() {
        return (ImageView) this.editClipImageView.getValue();
    }

    private final TextView ja() {
        return (TextView) this.editClipTextView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View la() {
        return (View) this.editTextBtn.getValue();
    }

    private final ImageView ma() {
        return (ImageView) this.editTextImageView.getValue();
    }

    private final TextView na() {
        return (TextView) this.editTextTextView.getValue();
    }

    private final View oa() {
        return (View) this.finishedBtn.getValue();
    }

    private final void pa() {
        VideoReport.setElementId(oa(), "em_xsj_complete_button");
        VideoReport.setElementParams(oa(), WinkDTParamBuilder.buildElementParams());
        VideoReport.setElementEndExposePolicy(oa(), EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(oa(), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(oa(), ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(WinkEditorOpeningEndingModePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finishBtnOnClick.onClick(view);
        this$0.wa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(WinkEditorOpeningEndingModePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xa(MenuType.OPENING_ENDING_AIGC, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(WinkEditorOpeningEndingModePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xa(MenuType.TEMPLATE_COLL_CLIP, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(WinkEditorOpeningEndingModePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xa(MenuType.TEMPLATE_TEXT_LIST, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void wa() {
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra(QQWinkConstants.OPENING_ENDING_AIGC_DATA);
        if (serializableExtra != null && (serializableExtra instanceof OpeningEndingAigcData)) {
            VideoReport.setElementId(oa(), "em_xsj_complete_button");
            Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
            OpeningEndingAigcData openingEndingAigcData = (OpeningEndingAigcData) serializableExtra;
            reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STYLE_ID, openingEndingAigcData.getStyleMaterials().get(openingEndingAigcData.getCurrentStyleIndex()).f30533id);
            VideoReport.reportEvent("dt_clck", oa(), reportMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa(MenuType menuType, boolean needSwitchMenu) {
        int i3 = b.f321336a[menuType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ba(da(), ea(), false);
                    ba(ia(), ja(), false);
                    ba(ma(), na(), true);
                }
            } else {
                ba(da(), ea(), false);
                ba(ia(), ja(), true);
                ba(ma(), na(), false);
                dr H9 = H9();
                if (H9 != null) {
                    H9.play();
                }
            }
        } else {
            ba(da(), ea(), true);
            ba(ia(), ja(), false);
            ba(ma(), na(), false);
            dr H92 = H9();
            if (H92 != null) {
                H92.play();
            }
        }
        if (needSwitchMenu) {
            WinkEditorViewModel.v5(G9(), menuType, null, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zze;
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Q9(null);
        aa();
        View oa5 = oa();
        if (oa5 != null) {
            oa5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorOpeningEndingModePart.ra(WinkEditorOpeningEndingModePart.this, view);
                }
            });
        }
        View ga5 = ga();
        if (ga5 != null) {
            ga5.setOnClickListener(this.backBtnOnClick);
        }
        View ca5 = ca();
        if (ca5 != null) {
            ca5.setVisibility(8);
        }
        View ha5 = ha();
        if (ha5 != null) {
            ha5.setVisibility(8);
        }
        View la5 = la();
        if (la5 != null) {
            la5.setVisibility(8);
        }
        View ca6 = ca();
        if (ca6 != null) {
            ca6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.af
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorOpeningEndingModePart.sa(WinkEditorOpeningEndingModePart.this, view);
                }
            });
        }
        View ha6 = ha();
        if (ha6 != null) {
            ha6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ag
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorOpeningEndingModePart.ta(WinkEditorOpeningEndingModePart.this, view);
                }
            });
        }
        View la6 = la();
        if (la6 != null) {
            la6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ah
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorOpeningEndingModePart.ua(WinkEditorOpeningEndingModePart.this, view);
                }
            });
        }
        LiveData<MenuSwitchAction> f36 = G9().f3();
        Fragment hostFragment = getHostFragment();
        final Function1<MenuSwitchAction, Unit> function1 = new Function1<MenuSwitchAction, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingModePart$onInitView$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MenuSwitchAction menuSwitchAction) {
                invoke2(menuSwitchAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MenuSwitchAction menuSwitchAction) {
                WinkEditorOpeningEndingModePart.this.xa(menuSwitchAction.getMenuType(), false);
            }
        };
        f36.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingModePart.va(Function1.this, obj);
            }
        });
        pa();
    }

    public final void qa() {
        ViewTreeObserver viewTreeObserver;
        View partRootView = getPartRootView();
        if (partRootView != null && (viewTreeObserver = partRootView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new c());
        }
    }
}
