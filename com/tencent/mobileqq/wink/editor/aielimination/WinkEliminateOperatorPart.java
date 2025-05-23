package com.tencent.mobileqq.wink.editor.aielimination;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationButtonStatus;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationTabName;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0015H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&R\"\u0010 \u001a\u00020\u00198\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/WinkEliminateOperatorPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationButtonStatus;", "buttonStatus", "I9", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAIEliminationFragment;", "D9", "v", NodeProps.ON_CLICK, "H9", "", "canClicked", "M9", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationTabName;", "x9", "C9", "", "z9", "", "A9", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "E9", "()Landroid/widget/LinearLayout;", "J9", "(Landroid/widget/LinearLayout;)V", "starAction", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "F9", "()Landroid/widget/TextView;", "K9", "(Landroid/widget/TextView;)V", "starActionText", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "G9", "()Landroid/widget/ImageView;", "L9", "(Landroid/widget/ImageView;)V", "startActionImage", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", tl.h.F, "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", "eliminationViewModel", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkEliminateOperatorPart extends Part implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected LinearLayout starAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected TextView starActionText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected ImageView startActionImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy eliminationViewModel;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f318810a;

        static {
            int[] iArr = new int[AIEliminationButtonStatus.values().length];
            try {
                iArr[AIEliminationButtonStatus.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIEliminationButtonStatus.OPEN_YELLOW_DIAMOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f318810a = iArr;
        }
    }

    public WinkEliminateOperatorPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAiEliminationViewModel>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart$eliminationViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAiEliminationViewModel invoke() {
                return (WinkAiEliminationViewModel) WinkEliminateOperatorPart.this.getViewModel(WinkAiEliminationViewModel.class);
            }
        });
        this.eliminationViewModel = lazy;
    }

    @Nullable
    public abstract String A9();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final WinkAiEliminationViewModel B9() {
        Object value = this.eliminationViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-eliminationViewModel>(...)");
        return (WinkAiEliminationViewModel) value;
    }

    @NotNull
    public abstract View C9();

    @Nullable
    public final WinkAIEliminationFragment D9() {
        IPartHost partHost = getPartHost();
        if (partHost instanceof WinkAIEliminationFragment) {
            return (WinkAIEliminationFragment) partHost;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LinearLayout E9() {
        LinearLayout linearLayout = this.starAction;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("starAction");
        return null;
    }

    @NotNull
    protected final TextView F9() {
        TextView textView = this.starActionText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("starActionText");
        return null;
    }

    @NotNull
    protected final ImageView G9() {
        ImageView imageView = this.startActionImage;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startActionImage");
        return null;
    }

    public final void H9() {
        int i3 = a.f318810a[B9().getMButtonStatus().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                WinkAIEliminationFragment D9 = D9();
                if (D9 != null) {
                    D9.oi();
                    return;
                }
                return;
            }
            WinkAIEliminationFragment D92 = D9();
            if (D92 != null) {
                D92.pi(3);
                return;
            }
            return;
        }
        WinkAIEliminationFragment D93 = D9();
        if (D93 != null) {
            D93.Ni();
        }
    }

    public void I9(@NotNull AIEliminationButtonStatus buttonStatus) {
        Resources resources;
        String str;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Intrinsics.checkNotNullParameter(buttonStatus, "buttonStatus");
        int i3 = a.f318810a[buttonStatus.ordinal()];
        String str2 = null;
        r1 = null;
        Drawable drawable = null;
        r1 = null;
        Drawable drawable2 = null;
        str2 = null;
        if (i3 != 1) {
            if (i3 != 2) {
                F9().setText(A9());
                G9().setVisibility(0);
                ImageView G9 = G9();
                WinkAIEliminationFragment D9 = D9();
                if (D9 != null && (resources4 = D9.getResources()) != null) {
                    drawable = resources4.getDrawable(z9());
                }
                G9.setImageDrawable(drawable);
            } else {
                TextView F9 = F9();
                WinkAIEliminationFragment D92 = D9();
                if (D92 != null && (resources3 = D92.getResources()) != null) {
                    str = resources3.getString(R.string.f240647pq);
                } else {
                    str = null;
                }
                F9.setText(str);
                G9().setVisibility(0);
                ImageView G92 = G9();
                WinkAIEliminationFragment D93 = D9();
                if (D93 != null && (resources2 = D93.getResources()) != null) {
                    drawable2 = resources2.getDrawable(R.drawable.otw);
                }
                G92.setImageDrawable(drawable2);
            }
        } else {
            TextView F92 = F9();
            WinkAIEliminationFragment D94 = D9();
            if (D94 != null && (resources = D94.getResources()) != null) {
                str2 = resources.getString(R.string.f240817q7);
            }
            F92.setText(str2);
            G9().setVisibility(8);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        CharSequence text = F9().getText();
        if (text == null) {
            text = "";
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.BUTTON_NAME, text);
        linkedHashMap.put("tab_name", Integer.valueOf(B9().getSelectTabName().getTabName()));
        WinkAIEliminationFragment D95 = D9();
        if (D95 != null) {
            D95.di(E9(), WinkDaTongReportConstant.ElementId.EM_XSJ_ELIMINATE_START, linkedHashMap);
        }
    }

    protected final void J9(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.starAction = linearLayout;
    }

    protected final void K9(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.starActionText = textView;
    }

    protected final void L9(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.startActionImage = imageView;
    }

    public abstract void M9(boolean canClicked);

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f87914vn) {
            H9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f87914vn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.start_action)");
        J9((LinearLayout) findViewById);
        View findViewById2 = rootView.findViewById(R.id.f87934vp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.start_action_text)");
        K9((TextView) findViewById2);
        View findViewById3 = rootView.findViewById(R.id.f87924vo);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.start_action_image)");
        L9((ImageView) findViewById3);
        E9().setOnClickListener(this);
    }

    @NotNull
    public abstract AIEliminationTabName x9();

    public abstract int z9();
}
