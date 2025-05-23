package com.tencent.qqnt.pluspanel.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/pluspanel/utils/d;", "", "Landroid/view/View;", "v", "", "c", "a", "Landroid/widget/TextView;", "panelName", "", "isRobotAIO", "Landroid/widget/ImageView;", "iconImageView", "rtPanelIcon", "b", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f360701a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/pluspanel/utils/d$a", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "d", UserInfo.SEX_FEMALE, "getAlpha", "()F", "setAlpha", "(F)V", com.tencent.luggage.wxa.c8.c.f123400v, "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float alpha;

        a(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.alpha = view.getAlpha();
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3, (Object) event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            if (v3.isEnabled()) {
                int action = event.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        v3.setAlpha(this.alpha);
                        return false;
                    }
                    return false;
                }
                v3.setAlpha(this.alpha / 2.0f);
                return false;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45676);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f360701a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            if (v3 == null) {
                return;
            }
            v3.setOnTouchListener(null);
        }
    }

    public final void b(@NotNull TextView panelName, boolean isRobotAIO, @NotNull ImageView iconImageView, @Nullable View rtPanelIcon) {
        float f16;
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, panelName, Boolean.valueOf(isRobotAIO), iconImageView, rtPanelIcon);
            return;
        }
        Intrinsics.checkNotNullParameter(panelName, "panelName");
        Intrinsics.checkNotNullParameter(iconImageView, "iconImageView");
        Resources resources = panelName.getResources();
        if (resources != null && !isRobotAIO) {
            panelName.setTextColor(resources.getColor(R.color.cr5));
        }
        panelName.setTextSize(0, ViewUtils.dip2px(11.0f));
        Context context = panelName.getContext();
        if (context == null) {
            return;
        }
        if (GlobalDisplayMetricsManager.needAdjustDensity(context)) {
            f16 = 36.0f;
        } else {
            f16 = 32.5f;
        }
        int dip2px = ViewUtils.dip2px(f16);
        ViewGroup.LayoutParams layoutParams2 = iconImageView.getLayoutParams();
        layoutParams2.width = dip2px;
        layoutParams2.height = dip2px;
        iconImageView.setImageDrawable(null);
        if (rtPanelIcon != null && (layoutParams = rtPanelIcon.getLayoutParams()) != null) {
            layoutParams.height = dip2px;
            layoutParams.width = dip2px;
        }
    }

    public final void c(@NotNull View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            v3.setOnTouchListener(new a(v3));
        }
    }
}
