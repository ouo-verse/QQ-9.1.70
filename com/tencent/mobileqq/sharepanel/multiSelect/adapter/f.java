package com.tencent.mobileqq.sharepanel.multiSelect.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.multiSelect.adapter.f;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "E", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/f$a;", "", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/view/View;", "d", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.adapter.f$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final Drawable c(Context context) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_light_secondary));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_standard_primary));
            LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(LinearLayout this_apply, final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            RFWIocAbilityProvider.g().getIoc(com.tencent.mobileqq.sharepanel.ioc.a.class).originView(this_apply).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.adapter.e
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    f.Companion.f(view, (com.tencent.mobileqq.sharepanel.ioc.a) obj);
                }
            }).run();
            com.tencent.mobileqq.sharepanel.ioc.f.e(com.tencent.mobileqq.sharepanel.ioc.f.f287347a, this_apply, "em_share_more_friend", null, 4, null);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(View view, com.tencent.mobileqq.sharepanel.ioc.a aVar) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            aVar.O8(context);
        }

        @NotNull
        public final View d(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            final LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setGravity(1);
            linearLayout.setOrientation(1);
            int dpToPx = ViewUtils.dpToPx(56.0f);
            FrameLayout frameLayout = new FrameLayout(context);
            int dpToPx2 = ViewUtils.dpToPx(28.0f);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_group_filled, null));
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(dpToPx2, dpToPx2, 17));
            frameLayout.setBackground(f.INSTANCE.c(context));
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(dpToPx, dpToPx));
            TextView textView = new TextView(context);
            textView.setText("\u66f4\u591a\u597d\u53cb");
            textView.setTextSize(10.0f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setMaxLines(2);
            textView.setGravity(49);
            textView.setTextColor(context.getResources().getColorStateList(R.color.qui_common_text_primary_light, null));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ViewUtils.dpToPx(6.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(textView, layoutParams);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.Companion.e(linearLayout, view);
                }
            });
            return linearLayout;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            com.tencent.mobileqq.sharepanel.ioc.f.h(com.tencent.mobileqq.sharepanel.ioc.f.f287347a, this.itemView, "em_share_more_friend", null, 4, null);
        }
    }
}
