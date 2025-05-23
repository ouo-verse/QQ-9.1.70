package com.tencent.mobileqq.aio.utils;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/ao;", "", "Lcom/tencent/mobileqq/aio/title/ae;", "info", "Landroid/widget/ImageView;", "view", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "", "d", "", "needAnim", "b", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ao {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ao f194112a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f194112a = new ao();
        }
    }

    ao() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(com.tencent.mobileqq.aio.title.ae aeVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        aeVar.a().a();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d(com.tencent.mobileqq.aio.title.ae info, ImageView view, Drawable iconDrawable) {
        Pair<String, Drawable> b16 = info.a().b(view.getContext(), iconDrawable);
        if (!TextUtils.isEmpty(b16.getFirst())) {
            com.tencent.mobileqq.aio.title.ac a16 = info.a();
            Resources resources = view.getContext().getResources();
            String first = b16.getFirst();
            Intrinsics.checkNotNull(first);
            a16.f(resources, view, first, b16.getSecond());
            return;
        }
        view.setImageDrawable(null);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (b16.getSecond().getIntrinsicWidth() > 0) {
            layoutParams.width = b16.getSecond().getIntrinsicWidth();
        } else {
            layoutParams.width = -2;
        }
        view.setLayoutParams(layoutParams);
        view.setScaleType(ImageView.ScaleType.FIT_CENTER);
        view.setImageDrawable(b16.getSecond());
    }

    public final void b(@Nullable final com.tencent.mobileqq.aio.title.ae info, @NotNull ImageView view, boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, info, view, Boolean.valueOf(needAnim));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (info != null && info.a().c()) {
            ColorDrawable colorDrawable = new ColorDrawable(0);
            if (!TextUtils.isEmpty(info.b()) && info.c() == 1) {
                info.a().f(view.getContext().getResources(), view, info.b(), colorDrawable);
            } else if (info.c() == 0) {
                d(info, view, colorDrawable);
            }
            view.setAlpha(info.a().d());
            view.setContentDescription(info.d());
            if (!needAnim) {
                view.setVisibility(0);
            } else {
                if (view.getVisibility() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    view.setVisibility(0);
                    AIOUtil.f194084a.H(view);
                }
            }
            info.a().e();
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.utils.an
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ao.c(com.tencent.mobileqq.aio.title.ae.this, view2);
                }
            });
            int i3 = (int) ((5 * view.getContext().getResources().getDisplayMetrics().density) + 0.5f);
            AIOUtil.f194084a.e(view, i3, i3, i3, i3);
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(null);
    }
}
