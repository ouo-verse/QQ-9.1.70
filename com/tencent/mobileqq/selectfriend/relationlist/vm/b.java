package com.tencent.mobileqq.selectfriend.relationlist.vm;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J,\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0006H&J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0002H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/vm/b;", "", "", "fromNet", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "", "callback", "c", "Lcom/tencent/mobileqq/selectfriend/relationlist/d;", "b", "sharedNode", "Landroid/graphics/drawable/Drawable;", "a", "d", "isMultiSelect", "e", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public abstract Drawable a(@NotNull SharedNode sharedNode);

    public abstract void b(boolean fromNet, @NotNull Function1<? super List<d>, Unit> callback);

    public abstract void c(boolean fromNet, @NotNull Function1<? super List<SharedNode>, Unit> callback);

    public abstract boolean d(@Nullable SharedNode sharedNode);

    public abstract void e(@Nullable SharedNode sharedNode, boolean isMultiSelect);
}
