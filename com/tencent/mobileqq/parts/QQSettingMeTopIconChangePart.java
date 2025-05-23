package com.tencent.mobileqq.parts;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0018\u0010 \u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000bR!\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeTopIconChangePart;", "Lcom/tencent/mobileqq/part/a;", "", com.tencent.luggage.wxa.c8.c.f123400v, "", "H9", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "f", "Landroid/view/View;", "topContainerBg", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "signInWord", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "backIcon", "Lcom/tencent/image/URLImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/image/URLImageView;", "signInIcon", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "signInContainer", "D", "qrcode", "E", "bottomMask", "Landroidx/lifecycle/Observer;", "", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "F9", "()Landroidx/lifecycle/Observer;", "zPlanOffsetObserver", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQSettingMeTopIconChangePart extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LinearLayout signInContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView qrcode;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View bottomMask;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy zPlanOffsetObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View topContainerBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView signInWord;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView backIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLImageView signInIcon;

    public QQSettingMeTopIconChangePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new QQSettingMeTopIconChangePart$zPlanOffsetObserver$2(this));
            this.zPlanOffsetObserver = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Observer<Float> F9() {
        return (Observer) this.zPlanOffsetObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(int alpha) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        View findViewById;
        boolean z16;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        View findViewById2;
        int i3 = 0;
        Drawable drawable7 = null;
        if (alpha <= 0) {
            I9(0);
            URLImageView uRLImageView = this.signInIcon;
            if (uRLImageView != null) {
                uRLImageView.setImageResource(R.drawable.qui_daka_icon_white);
            }
            TextView textView = this.signInWord;
            if (textView != null) {
                textView.setTextColor(ex.b(R.color.qui_common_text_allwhite_primary));
            }
            LinearLayout linearLayout = this.signInContainer;
            if (linearLayout != null) {
                drawable4 = linearLayout.getBackground();
            } else {
                drawable4 = null;
            }
            if (drawable4 != null) {
                drawable4.setAlpha(255);
            }
            View partRootView = getPartRootView();
            if (partRootView != null && (findViewById2 = partRootView.findViewById(R.id.zxq)) != null) {
                drawable5 = findViewById2.getBackground();
            } else {
                drawable5 = null;
            }
            if (drawable5 != null) {
                drawable5.setAlpha(255);
            }
            ImageView imageView = this.backIcon;
            if (imageView != null) {
                drawable6 = imageView.getBackground();
            } else {
                drawable6 = null;
            }
            if (drawable6 != null) {
                drawable6.setAlpha(255);
            }
            ImageView imageView2 = this.backIcon;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.qui_close_icon_white);
            }
            ImageView imageView3 = this.qrcode;
            if (imageView3 != null) {
                drawable7 = imageView3.getBackground();
            }
            if (drawable7 != null) {
                drawable7.setAlpha(255);
            }
            ImageView imageView4 = this.qrcode;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.qui_qrcode_icon_white);
            }
        } else {
            I9(alpha);
            int i16 = 255 - alpha;
            URLImageView uRLImageView2 = this.signInIcon;
            if (uRLImageView2 != null) {
                uRLImageView2.setImageResource(R.drawable.qui_daka);
            }
            TextView textView2 = this.signInWord;
            if (textView2 != null) {
                textView2.setTextColor(ex.b(R.color.qui_common_text_primary));
            }
            LinearLayout linearLayout2 = this.signInContainer;
            if (linearLayout2 != null) {
                drawable = linearLayout2.getBackground();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                drawable.setAlpha(i16);
            }
            View partRootView2 = getPartRootView();
            if (partRootView2 != null && (findViewById = partRootView2.findViewById(R.id.zxq)) != null) {
                drawable2 = findViewById.getBackground();
            } else {
                drawable2 = null;
            }
            if (drawable2 != null) {
                drawable2.setAlpha(i16);
            }
            ImageView imageView5 = this.backIcon;
            if (imageView5 != null) {
                drawable3 = imageView5.getBackground();
            } else {
                drawable3 = null;
            }
            if (drawable3 != null) {
                drawable3.setAlpha(i16);
            }
            ImageView imageView6 = this.backIcon;
            if (imageView6 != null) {
                imageView6.setImageResource(R.drawable.qui_close);
            }
            ImageView imageView7 = this.qrcode;
            if (imageView7 != null) {
                drawable7 = imageView7.getBackground();
            }
            if (drawable7 != null) {
                drawable7.setAlpha(i16);
            }
            ImageView imageView8 = this.qrcode;
            if (imageView8 != null) {
                imageView8.setImageResource(R.drawable.qui_qrcode);
            }
        }
        View view = this.bottomMask;
        if (view != null) {
            if (alpha > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private final void I9(int alpha) {
        View view;
        boolean z16 = false;
        if (alpha >= 0 && alpha < 256) {
            z16 = true;
        }
        if (z16 && (view = this.topContainerBg) != null) {
            view.setAlpha(alpha / 255.0f);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        LinearLayout linearLayout;
        TextView textView;
        URLImageView uRLImageView;
        ImageView imageView;
        ImageView imageView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view2 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.unm);
        } else {
            view = null;
        }
        this.topContainerBg = view;
        if (rootView != null) {
            linearLayout = (LinearLayout) rootView.findViewById(R.id.ung);
        } else {
            linearLayout = null;
        }
        this.signInContainer = linearLayout;
        if (linearLayout != null) {
            textView = (TextView) linearLayout.findViewById(R.id.unf);
        } else {
            textView = null;
        }
        this.signInWord = textView;
        LinearLayout linearLayout2 = this.signInContainer;
        if (linearLayout2 != null) {
            uRLImageView = (URLImageView) linearLayout2.findViewById(R.id.und);
        } else {
            uRLImageView = null;
        }
        this.signInIcon = uRLImageView;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f165026um4);
        } else {
            imageView = null;
        }
        this.backIcon = imageView;
        if (rootView != null) {
            imageView2 = (ImageView) rootView.findViewById(R.id.un6);
        } else {
            imageView2 = null;
        }
        this.qrcode = imageView2;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.yjw);
        }
        this.bottomMask = view2;
        I9(0);
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).T1().observe(getPartHost().getHostLifecycleOwner(), F9());
        MutableLiveData<Boolean> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f312699h0;
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeTopIconChangePart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeTopIconChangePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    QQSettingMeTopIconChangePart.this.H9(0);
                }
            }
        };
        mutableLiveData.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.bn
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeTopIconChangePart.G9(Function1.this, obj);
            }
        });
    }
}
