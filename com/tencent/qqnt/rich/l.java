package com.tencent.qqnt.rich;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.rich.part.MarkdownPart;
import com.tencent.qqnt.rich.part.StreamPart;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\r\u001a\u00020\fJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/rich/l;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/rich/m;", "richHelper", "Lcom/tencent/qqnt/rich/k;", "extParam", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/rich/part/a;", "Lkotlin/collections/ArrayList;", "c", "Lcom/tencent/android/androidbypass/richui/c;", "a", "Lcom/tencent/qqnt/rich/d;", "b", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class l {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.android.androidbypass.richui.c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.android.androidbypass.richui.c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new f();
    }

    @Nullable
    public d b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return i.f362001a;
    }

    @NotNull
    public ArrayList<com.tencent.qqnt.rich.part.a> c(@NotNull Context context, @NotNull m richHelper, @NotNull k extParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, this, context, richHelper, extParam);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(richHelper, "richHelper");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        ArrayList<com.tencent.qqnt.rich.part.a> arrayList = new ArrayList<>();
        arrayList.add(new MarkdownPart(context, richHelper, extParam, this));
        arrayList.add(new StreamPart(context, richHelper, extParam, this));
        return arrayList;
    }
}
