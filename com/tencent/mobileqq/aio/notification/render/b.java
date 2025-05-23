package com.tencent.mobileqq.aio.notification.render;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.BoxShadow;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p81.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/render/b;", "Lcom/tencent/mobileqq/aio/notification/render/d;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroidx/viewbinding/ViewBinding;", "b", "Landroid/content/Context;", "context", "", "c", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "uiModel", "viewBinding", "", "isExpandDialogState", "isMultiFoldMode", "", "a", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f193007a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54832);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f193007a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.render.d
    public void a(@NotNull IAIONotificationUIModel uiModel, @NotNull ViewBinding viewBinding, boolean isExpandDialogState, boolean isMultiFoldMode) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uiModel, viewBinding, Boolean.valueOf(isExpandDialogState), Boolean.valueOf(isMultiFoldMode));
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        IAIONotificationUIModel.b bVar = (IAIONotificationUIModel.b) uiModel;
        h hVar = (h) viewBinding;
        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
        ImageView imageView = hVar.f425747f;
        Intrinsics.checkNotNullExpressionValue(imageView, "view.aioNotificationIcon");
        aIONotificationUIUtils.S(imageView, uiModel.b());
        hVar.f425746e.setText(bVar.f());
        hVar.f425746e.setTextColor(hVar.getRoot().getContext().getColorStateList(R.color.qui_common_text_primary));
        ImageView imageView2 = hVar.f425743b;
        Intrinsics.checkNotNullExpressionValue(imageView2, "view.aioNotificationAction");
        aIONotificationUIUtils.N(imageView2, bVar.c(), bVar, isExpandDialogState, isMultiFoldMode);
        TextView textView = hVar.f425744c;
        Intrinsics.checkNotNullExpressionValue(textView, "view.aioNotificationActionText");
        String d16 = bVar.d();
        int e16 = bVar.e();
        if (!isExpandDialogState && !isMultiFoldMode) {
            z16 = false;
        } else {
            z16 = true;
        }
        aIONotificationUIUtils.Q(textView, d16, e16, bVar, z16);
    }

    @Override // com.tencent.mobileqq.aio.notification.render.d
    @NotNull
    public ViewBinding b(@NotNull ViewGroup container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewBinding) iPatchRedirector.redirect((short) 3, (Object) this, (Object) container);
        }
        Intrinsics.checkNotNullParameter(container, "container");
        h g16 = h.g(LayoutInflater.from(container.getContext()), container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026ontainer, false\n        )");
        Context context = container.getContext();
        ViewUtils viewUtils = ViewUtils.f352270a;
        g16.f425745d.addView(new BoxShadow(context, viewUtils.a(9.0f), viewUtils.a(8.0f), Color.argb(7, 0, 0, 0)));
        return g16;
    }

    @Override // com.tencent.mobileqq.aio.notification.render.d
    public float c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimension(R.dimen.f158721nb);
    }
}
