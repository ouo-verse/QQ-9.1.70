package com.tencent.mobileqq.aio.msglist.holder.component.markdown;

import android.content.Context;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.part.InlineKeyboardPart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.rich.k;
import com.tencent.qqnt.rich.l;
import com.tencent.qqnt.rich.m;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/e;", "Lcom/tencent/qqnt/rich/l;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/rich/m;", "richHelper", "Lcom/tencent/qqnt/rich/k;", "extParam", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/rich/part/a;", "Lkotlin/collections/ArrayList;", "c", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends l {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.rich.l
    @NotNull
    public ArrayList<com.tencent.qqnt.rich.part.a> c(@NotNull Context context, @NotNull m richHelper, @NotNull k extParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, this, context, richHelper, extParam);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(richHelper, "richHelper");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        ArrayList<com.tencent.qqnt.rich.part.a> c16 = super.c(context, richHelper, extParam);
        c16.add(new InlineKeyboardPart(context, richHelper, extParam, this));
        return c16;
    }
}
