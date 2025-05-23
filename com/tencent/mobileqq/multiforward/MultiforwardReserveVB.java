package com.tencent.mobileqq.multiforward;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.multiforward.MultiforwardUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0019\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/multiforward/MultiforwardReserveVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve1UIState;", "", "h1", "i1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/widget/RelativeLayout;", "o1", "Lcom/tencent/aio/base/mvvm/b;", "g1", "state", "", ICustomDataEditor.NUMBER_PARAM_1, "d", "I", "FULL_SCREEN_IMAGE_HEIGHT_DP", "e", "FULL_SCREEN_IMAGE_WIDTH_DP", "f", "Lkotlin/Lazy;", "j1", "()Landroid/widget/RelativeLayout;", "mContent", "Landroid/widget/LinearLayout;", h.F, "k1", "()Landroid/widget/LinearLayout;", "mDescriptionView", "Landroid/widget/ImageView;", "i", "l1", "()Landroid/widget/ImageView;", "mImageView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "m1", "()Landroid/widget/TextView;", "mTextView", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiforwardReserveVB extends com.tencent.aio.base.mvvm.a<at.d, Reserve1UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int FULL_SCREEN_IMAGE_HEIGHT_DP;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int FULL_SCREEN_IMAGE_WIDTH_DP;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mDescriptionView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mImageView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTextView;

    public MultiforwardReserveVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.FULL_SCREEN_IMAGE_HEIGHT_DP = 192;
        this.FULL_SCREEN_IMAGE_WIDTH_DP = 256;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.multiforward.MultiforwardReserveVB$mContent$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiforwardReserveVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RelativeLayout relativeLayout = new RelativeLayout(MultiforwardReserveVB.this.getMContext());
                relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                relativeLayout.setBackground(MobileQQ.sMobileQQ.getResources().getDrawable(R.drawable.skin_panel_background));
                relativeLayout.setVisibility(8);
                return relativeLayout;
            }
        });
        this.mContent = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.multiforward.MultiforwardReserveVB$mDescriptionView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiforwardReserveVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                ImageView l16;
                TextView m16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                LinearLayout linearLayout = new LinearLayout(MultiforwardReserveVB.this.getMContext());
                MultiforwardReserveVB multiforwardReserveVB = MultiforwardReserveVB.this;
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
                linearLayout.setOrientation(1);
                l16 = multiforwardReserveVB.l1();
                linearLayout.addView(l16);
                m16 = multiforwardReserveVB.m1();
                linearLayout.addView(m16);
                return linearLayout;
            }
        });
        this.mDescriptionView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.multiforward.MultiforwardReserveVB$mImageView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiforwardReserveVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                int i3;
                int i16;
                int h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ImageView imageView = new ImageView(MultiforwardReserveVB.this.getMContext());
                MultiforwardReserveVB multiforwardReserveVB = MultiforwardReserveVB.this;
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                i3 = multiforwardReserveVB.FULL_SCREEN_IMAGE_HEIGHT_DP;
                layoutParams.height = ViewUtils.dpToPx(i3);
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                i16 = multiforwardReserveVB.FULL_SCREEN_IMAGE_WIDTH_DP;
                layoutParams2.width = ViewUtils.dpToPx(i16);
                ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                ((LinearLayout.LayoutParams) layoutParams3).gravity = 1;
                h16 = multiforwardReserveVB.h1();
                imageView.setImageResource(h16);
                return imageView;
            }
        });
        this.mImageView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.multiforward.MultiforwardReserveVB$mTextView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiforwardReserveVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextView textView = new TextView(MultiforwardReserveVB.this.getMContext());
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                ((LinearLayout.LayoutParams) layoutParams).topMargin = ViewUtils.dip2px(8.0f);
                textView.setTextSize(16.0f);
                textView.setText(R.string.f6r);
                textView.setGravity(1);
                return textView;
            }
        });
        this.mTextView = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h1() {
        if (QQTheme.isNowThemeIsNight()) {
            return R.drawable.ogu;
        }
        return R.drawable.ogt;
    }

    private final int i1() {
        if (QQTheme.isNowThemeIsNight()) {
            return R.drawable.ogs;
        }
        return R.drawable.ogr;
    }

    private final RelativeLayout j1() {
        return (RelativeLayout) this.mContent.getValue();
    }

    private final LinearLayout k1() {
        return (LinearLayout) this.mDescriptionView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView l1() {
        return (ImageView) this.mImageView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView m1() {
        return (TextView) this.mTextView.getValue();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<at.d, Reserve1UIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull Reserve1UIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MultiforwardUIState.ShowGetMsgErrPrompt) {
            j1().setVisibility(0);
            if (k1().getParent() == null) {
                j1().addView(k1());
            }
            if (((MultiforwardUIState.ShowGetMsgErrPrompt) state).a() == 196) {
                m1().setText(R.string.f197434k0);
                l1().setImageResource(i1());
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public RelativeLayout onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return j1();
    }
}
