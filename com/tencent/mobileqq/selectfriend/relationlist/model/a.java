package com.tencent.mobileqq.selectfriend.relationlist.model;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.d;
import com.tencent.mobileqq.selectfriend.relationlist.vm.ListType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J,\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0016J,\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\bH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/vm/ListType;", "b", "", "fromNet", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "", "callback", "d", "Lcom/tencent/mobileqq/selectfriend/relationlist/d;", "c", "sharedNode", "Landroid/graphics/drawable/Drawable;", "a", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public abstract Drawable a(@NotNull SharedNode sharedNode);

    @NotNull
    public abstract ListType b();

    public void c(boolean fromNet, @NotNull Function1<? super List<d>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(fromNet), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            callback.invoke(new ArrayList());
        }
    }

    public void d(boolean fromNet, @NotNull Function1<? super List<SharedNode>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(fromNet), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            callback.invoke(new ArrayList());
        }
    }
}
