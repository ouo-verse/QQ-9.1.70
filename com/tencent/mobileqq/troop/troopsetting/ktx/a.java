package com.tencent.mobileqq.troop.troopsetting.ktx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.o;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019JF\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J:\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/ktx/a;", "", "Landroid/content/Context;", "context", "", "tag", "nBgType", "Landroid/view/View;", "itemView", "", "title", "", "info", "", "bShowArrow", "", "b", "a", "c", ViewStickEventHelper.IS_SHOW, "e", "Landroid/widget/TextView;", "textView", "d", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f301140a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60174);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f301140a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable Context context, @Nullable View itemView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) itemView);
            return;
        }
        if (itemView != null && context != null) {
            View findViewById = itemView.findViewById(R.id.title);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.i_f);
            if (findViewById2 != null && !TextUtils.isEmpty(textView.getText())) {
                int measureText = (int) textView.getPaint().measureText(textView.getText().toString());
                ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                ((RelativeLayout.LayoutParams) layoutParams).leftMargin = measureText + Utils.n(30.0f, context.getResources());
            }
        }
    }

    public final void b(@Nullable Context context, int tag, int nBgType, @Nullable View itemView, @Nullable String title, @Nullable CharSequence info, boolean bShowArrow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(tag), Integer.valueOf(nBgType), itemView, title, info, Boolean.valueOf(bShowArrow));
        } else {
            if (itemView == null) {
                return;
            }
            c(context, tag, nBgType, itemView, title, bShowArrow);
        }
    }

    public final void c(@Nullable Context context, int tag, int nBgType, @NotNull View itemView, @Nullable String title, boolean bShowArrow) {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(tag), Integer.valueOf(nBgType), itemView, title, Boolean.valueOf(bShowArrow));
            return;
        }
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        TextView textView = null;
        if (bShowArrow) {
            itemView.setTag(Integer.valueOf(tag));
        } else {
            itemView.setTag(null);
        }
        if (nBgType == 4) {
            itemView.setBackgroundColor(Color.parseColor("#00000000"));
        } else {
            if (context != null) {
                resources = context.getResources();
            } else {
                resources = null;
            }
            itemView.setBackgroundDrawable(o.g(resources, nBgType, false));
        }
        itemView.getBackground().setAlpha(255);
        View findViewById = itemView.findViewById(R.id.title);
        if (findViewById instanceof TextView) {
            textView = (TextView) findViewById;
        }
        if (textView != null) {
            if (TextUtils.isEmpty(title)) {
                textView.setText("");
                textView.setVisibility(8);
            } else {
                textView.setText(title);
                textView.setVisibility(0);
            }
        }
        e(tag, itemView, bShowArrow);
    }

    public final void d(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textView);
            return;
        }
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setBackground(null);
        textView.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        textView.setLayoutParams(layoutParams);
    }

    public final void e(int tag, @Nullable View itemView, boolean isShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(tag), itemView, Boolean.valueOf(isShow));
            return;
        }
        if (itemView == null) {
            return;
        }
        if (33 == tag) {
            isShow = false;
        }
        ImageView imageView = (ImageView) itemView.findViewById(R.id.f164472yw);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
            if (!isShow) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }
}
