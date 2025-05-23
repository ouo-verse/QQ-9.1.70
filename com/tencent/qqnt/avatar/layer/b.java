package com.tencent.qqnt.avatar.layer;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/avatar/layer/b;", "Lcom/tencent/qqnt/avatar/layer/d;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/qqnt/avatar/bean/a;", "bean", "resource", "Lcom/tencent/qqnt/avatar/layer/c;", "drawConfig", "<init>", "(Lcom/tencent/qqnt/avatar/bean/a;Landroid/graphics/drawable/Drawable;Lcom/tencent/qqnt/avatar/layer/c;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends d<Drawable> {
    static IPatchRedirector $redirector_;

    public /* synthetic */ b(com.tencent.qqnt.avatar.bean.a aVar, Drawable drawable, c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, drawable, (i3 & 4) != 0 ? null : cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, drawable, cVar, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.qqnt.avatar.bean.a bean, @NotNull Drawable resource, @Nullable c cVar) {
        super(bean, resource, cVar, null, 8, null);
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(resource, "resource");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, bean, resource, cVar);
    }
}
