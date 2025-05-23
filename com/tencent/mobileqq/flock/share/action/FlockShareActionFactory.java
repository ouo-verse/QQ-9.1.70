package com.tencent.mobileqq.flock.share.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/flock/share/action/FlockShareActionFactory;", "", "", "actionId", "Lcom/tencent/mobileqq/flock/share/action/f;", "a", "", "Lkotlin/Function0;", "b", "Ljava/util/Map;", "actionMap", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockShareActionFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FlockShareActionFactory f210413a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Function0<f>> actionMap;

    static {
        Map<Integer, Function0<f>> mutableMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49148);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f210413a = new FlockShareActionFactory();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(2, FlockShareActionFactory$actionMap$1.INSTANCE), TuplesKt.to(72, FlockShareActionFactory$actionMap$2.INSTANCE), TuplesKt.to(3, FlockShareActionFactory$actionMap$3.INSTANCE), TuplesKt.to(9, FlockShareActionFactory$actionMap$4.INSTANCE), TuplesKt.to(10, FlockShareActionFactory$actionMap$5.INSTANCE));
        actionMap = mutableMapOf;
    }

    FlockShareActionFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final f a(int actionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, actionId);
        }
        Function0<f> function0 = actionMap.get(Integer.valueOf(actionId));
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }
}
