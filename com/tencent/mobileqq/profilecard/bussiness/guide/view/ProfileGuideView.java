package com.tencent.mobileqq.profilecard.bussiness.guide.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.mobileqq.profilecard.utils.ProfileUIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleRes", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideClickListener;", "closeButton", "Landroid/widget/ImageView;", "contentView", "Landroid/view/View;", "fillButton", "Landroid/widget/Button;", "fillLayout", "fillMainMsgView", "Landroid/widget/TextView;", "fillSecondaryMsgView", "updateArrow", "updateLayout", "updateMainMsgView", "initViews", "", NodeProps.ON_CLICK, "view", "setClickListener", "setFillGuide", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "setUpdateGuide", "updateProfileGuide", "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileGuideView extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ProfileGuideView";

    @Nullable
    private ProfileGuideClickListener clickListener;
    private ImageView closeButton;
    private View contentView;
    private Button fillButton;
    private View fillLayout;
    private TextView fillMainMsgView;
    private TextView fillSecondaryMsgView;
    private ImageView updateArrow;
    private View updateLayout;
    private TextView updateMainMsgView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideView$Companion;", "", "()V", "TAG", "", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18581);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileGuideView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            initViews();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private final void initViews() {
        LayoutInflater.from(getContext()).inflate(R.layout.h0g, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.content)");
        this.contentView = findViewById;
        View findViewById2 = findViewById(R.id.v5n);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fill_layout)");
        this.fillLayout = findViewById2;
        View findViewById3 = findViewById(R.id.v5o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.fill_main_msg)");
        this.fillMainMsgView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.v5p);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.fill_secondary_msg)");
        this.fillSecondaryMsgView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.v5m);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.fill_btn)");
        Button button = (Button) findViewById5;
        this.fillButton = button;
        ImageView imageView = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fillButton");
            button = null;
        }
        ProfileUIUtils.ViewAlphaOnTouchListener viewAlphaOnTouchListener = ProfileUIUtils.ALPHA_TOUCH_LISTENER;
        button.setOnTouchListener(viewAlphaOnTouchListener);
        Button button2 = this.fillButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fillButton");
            button2 = null;
        }
        button2.setOnClickListener(this);
        View findViewById6 = findViewById(R.id.f114476tf);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.update_layout)");
        this.updateLayout = findViewById6;
        if (findViewById6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
            findViewById6 = null;
        }
        findViewById6.setOnTouchListener(viewAlphaOnTouchListener);
        View view = this.updateLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
            view = null;
        }
        view.setOnClickListener(this);
        View findViewById7 = findViewById(R.id.f114486tg);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.update_main_msg)");
        this.updateMainMsgView = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.f114466te);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.update_arrow)");
        this.updateArrow = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.f165774dg4);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.img_close)");
        ImageView imageView2 = (ImageView) findViewById9;
        this.closeButton = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            imageView2 = null;
        }
        imageView2.setOnTouchListener(viewAlphaOnTouchListener);
        ImageView imageView3 = this.closeButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
        } else {
            imageView = imageView3;
        }
        imageView.setOnClickListener(this);
    }

    private final void setFillGuide(ProfileGuide profileGuide) {
        View view = this.contentView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        view.setBackgroundResource(R.drawable.ng6);
        View view3 = this.fillLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fillLayout");
            view3 = null;
        }
        int i3 = 0;
        view3.setVisibility(0);
        TextView textView = this.fillMainMsgView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fillMainMsgView");
            textView = null;
        }
        textView.setText(profileGuide.getGuideMainMsg());
        if (TextUtils.isEmpty(profileGuide.getGuideSecondaryMsg())) {
            i3 = 8;
        }
        TextView textView2 = this.fillSecondaryMsgView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fillSecondaryMsgView");
            textView2 = null;
        }
        textView2.setVisibility(i3);
        TextView textView3 = this.fillSecondaryMsgView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fillSecondaryMsgView");
            textView3 = null;
        }
        textView3.setText(profileGuide.getGuideSecondaryMsg());
        View view4 = this.updateLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
        } else {
            view2 = view4;
        }
        view2.setVisibility(8);
    }

    private final void setUpdateGuide(ProfileGuide profileGuide) {
        View view = this.contentView;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        view.setBackgroundResource(R.drawable.ng7);
        View view2 = this.fillLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fillLayout");
            view2 = null;
        }
        view2.setVisibility(8);
        View view3 = this.updateLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
            view3 = null;
        }
        view3.setVisibility(0);
        TextView textView2 = this.updateMainMsgView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateMainMsgView");
        } else {
            textView = textView2;
        }
        textView.setText(profileGuide.getGuideMainMsg());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Integer num;
        ProfileGuideClickListener profileGuideClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            if (view != null) {
                num = Integer.valueOf(view.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.v5m) {
                ProfileGuideClickListener profileGuideClickListener2 = this.clickListener;
                if (profileGuideClickListener2 != null) {
                    profileGuideClickListener2.onFillClick();
                }
            } else if (num != null && num.intValue() == R.id.f114476tf) {
                ProfileGuideClickListener profileGuideClickListener3 = this.clickListener;
                if (profileGuideClickListener3 != null) {
                    profileGuideClickListener3.onUpdateClick();
                }
            } else if (num != null && num.intValue() == R.id.f165774dg4 && (profileGuideClickListener = this.clickListener) != null) {
                profileGuideClickListener.onCloseClick();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setClickListener(@NotNull ProfileGuideClickListener clickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) clickListener);
        } else {
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.clickListener = clickListener;
        }
    }

    public final void updateProfileGuide(@NotNull ProfileGuide profileGuide) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) profileGuide);
            return;
        }
        Intrinsics.checkNotNullParameter(profileGuide, "profileGuide");
        if (profileGuide.getGuideType() == 1) {
            setFillGuide(profileGuide);
        } else if (profileGuide.getGuideType() == 2) {
            setUpdateGuide(profileGuide);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            initViews();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            initViews();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
