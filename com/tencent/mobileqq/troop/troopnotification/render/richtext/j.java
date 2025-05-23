package com.tencent.mobileqq.troop.troopnotification.render.richtext;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J0\u0010\b\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0015\u001a\u00020\u00118\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/j;", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/a;", "", "", "", "textData", "allData", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/f;", "a", "", "isClickable", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/notification/f;", "msg", "richText", "b", "", "I", "getType", "()I", "type", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class j implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f300825a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int type;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f300825a = new j();
            type = 3;
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.richtext.a
    @NotNull
    public f a(@NotNull Map<String, ? extends Object> textData, @NotNull Map<String, ? extends Object> allData) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) textData, (Object) allData);
        }
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(allData, "allData");
        Object obj = textData.get("time");
        if (obj instanceof Long) {
            l3 = (Long) obj;
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() > 0) {
            return new f(com.tencent.mobileqq.troop.troopnotification.utils.b.f300925a.g(l3.longValue() * 1000), 3, null);
        }
        return new f("", 3, null);
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.richtext.a
    public boolean b(@NotNull View view, @NotNull com.tencent.qqnt.notification.f msg2, @NotNull f richText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, view, msg2, richText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(richText, "richText");
        return false;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.richtext.a
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return type;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.richtext.a
    public boolean isClickable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
