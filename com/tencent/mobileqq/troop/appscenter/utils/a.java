package com.tencent.mobileqq.troop.appscenter.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.trooptodo.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J*\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0006H\u0002J4\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/utils/a;", "", "Landroid/content/Context;", "context", "", "url", "", "picDp", "roundDp", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/view/View;", "v", "", "bNeedBorder", "", "c", "Landroid/widget/ImageView;", "iconUrl", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/utils/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26488);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Drawable a(Context context, String url, float picDp, float roundDp) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        int dpToPx = ViewUtils.dpToPx(picDp);
        obtain.mRequestHeight = dpToPx;
        obtain.mRequestWidth = dpToPx;
        obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.qb_troop_default_app);
        obtain.mLoadingDrawable = context.getResources().getDrawable(R.drawable.qb_troop_default_app);
        try {
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (roundDp > 0.0f) {
                drawable.setTag(o.b(ViewUtils.dpToPx(picDp), ViewUtils.dpToPx(picDp), ViewUtils.dpToPx(roundDp)));
                drawable.setDecodeHandler(o.f301827j);
            }
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
                return drawable;
            }
            return drawable;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("TroopAppsCenter.AppIconUtil", 2, "getIcon url: " + url);
            return null;
        }
    }

    private final void c(View v3, boolean bNeedBorder, float roundDp) {
        if (bNeedBorder) {
            int dpToPx = ViewUtils.dpToPx(0.5f);
            v3.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(ViewUtils.dpToPx(roundDp));
            gradientDrawable.setStroke(ViewUtils.dpToPx(0.5f), Color.parseColor("#FFE5E5E5"));
            v3.setBackground(gradientDrawable);
            return;
        }
        v3.setPadding(0, 0, 0, 0);
        v3.setBackground(null);
    }

    public final void b(@Nullable Context context, @Nullable ImageView v3, @Nullable String iconUrl, float picDp, boolean bNeedBorder) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, v3, iconUrl, Float.valueOf(picDp), Boolean.valueOf(bNeedBorder));
            return;
        }
        if (context != null && v3 != null) {
            float f16 = picDp / 10;
            if (iconUrl == null || iconUrl.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                try {
                    drawable = a(context, iconUrl, picDp, f16);
                } catch (Exception e16) {
                    QLog.e("TroopAppsCenter.AppIconUtil", 1, "fetchDrawable: failed. ", e16);
                    drawable = context.getResources().getDrawable(R.drawable.qb_troop_default_app);
                }
            } else {
                drawable = context.getResources().getDrawable(R.drawable.qb_troop_default_app);
            }
            v3.setImageDrawable(drawable);
            c(v3, bNeedBorder, f16);
        }
    }
}
