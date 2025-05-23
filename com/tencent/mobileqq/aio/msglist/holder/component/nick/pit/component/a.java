package com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.AIONickComponentV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/a;", "", "Landroid/widget/LinearLayout;", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/AIONickComponentV2;", "parentComponent", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/b;", "Lkotlin/collections/ArrayList;", "b", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "getRootView", "()Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout rootView;

    public a(@NotNull Context context, @NotNull LinearLayout rootView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rootView);
        } else {
            this.context = context;
            this.rootView = rootView;
        }
    }

    private final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.rootView.addView(linearLayout);
        return linearLayout;
    }

    @NotNull
    public final ArrayList<b> b(@NotNull AIONickComponentV2 parentComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parentComponent);
        }
        Intrinsics.checkNotNullParameter(parentComponent, "parentComponent");
        ArrayList<b> arrayList = new ArrayList<>();
        arrayList.add(new b(parentComponent, this.context, a()));
        return arrayList;
    }
}
