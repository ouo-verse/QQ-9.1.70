package com.tencent.qqnt.avatar.layer;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/avatar/layer/a;", "Lcom/tencent/qqnt/avatar/layer/d;", "Landroid/graphics/Bitmap;", "Lcom/tencent/qqnt/avatar/bean/a;", "bean", "resource", "Lcom/tencent/qqnt/avatar/layer/c;", "drawConfig", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfoArray", "<init>", "(Lcom/tencent/qqnt/avatar/bean/a;Landroid/graphics/Bitmap;Lcom/tencent/qqnt/avatar/layer/c;[Lcom/tencent/qqnt/avatar/meta/info/a;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends d<Bitmap> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.qqnt.avatar.bean.a bean, @NotNull Bitmap resource, @Nullable c cVar, @Nullable com.tencent.qqnt.avatar.meta.info.a[] aVarArr) {
        super(bean, resource, cVar, aVarArr);
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(resource, "resource");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bean, resource, cVar, aVarArr);
        }
    }
}
