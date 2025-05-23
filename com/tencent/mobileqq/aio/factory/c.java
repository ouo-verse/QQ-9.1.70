package com.tencent.mobileqq.aio.factory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aio.api.refreshLoad.HeadFooterViewHolder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/c;", "Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "b", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "type", "<init>", "(ILandroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
final class c extends HeadFooterViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    public c(int i3, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) context);
        } else {
            this.context = context;
        }
    }

    private final Drawable m(Context context) {
        Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(context, 2);
        if (loadingDrawable != null) {
            int b16 = com.tencent.aio.base.tool.a.INSTANCE.b(context, 24);
            loadingDrawable.setBounds(0, 0, b16, b16);
            return loadingDrawable;
        }
        return null;
    }

    @Override // com.tencent.aio.api.refreshLoad.HeadFooterViewHolder
    @NotNull
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        FrameLayout frameLayout = new FrameLayout(this.context);
        com.tencent.aio.base.tool.b bVar = com.tencent.aio.base.tool.b.f69219a;
        Context context = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FrameLayout.LayoutParams a16 = bVar.a(context, -1, 45);
        a16.gravity = 80;
        frameLayout.setLayoutParams(a16);
        ImageView imageView = new ImageView(this.context);
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        imageView.setImageDrawable(m(context2));
        FrameLayout.LayoutParams a17 = bVar.a(this.context, 24, 24);
        a17.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(imageView, a17);
        return frameLayout;
    }
}
