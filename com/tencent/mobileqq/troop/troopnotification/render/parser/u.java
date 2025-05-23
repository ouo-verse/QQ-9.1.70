package com.tencent.mobileqq.troop.troopnotification.render.parser;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.render.TroopNotificationRender;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0012H\u0016J6\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J6\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0010\u001a\u00020\u0012H\u0016R\u001a\u0010\u0019\u001a\u00020\u000b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/u;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "titleLayout", "", "f", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "", "data", "", "e", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "d", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "b", "c", "a", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class u implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f300787a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String key;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59525);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f300787a = new u();
            key = "title";
        }
    }

    u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e(com.tencent.qqnt.notification.f msg2, Object wildcardValue, Map<String, ? extends Object> data, TroopNotificationRichTextView titleLayout) {
        List<?> list;
        if (wildcardValue instanceof List) {
            list = (List) wildcardValue;
        } else {
            list = null;
        }
        if (list == null) {
            QLog.e("TroopNotificationTitleParser", 1, "parse: not find titleData, wildcardValue=" + wildcardValue + ", data=" + data);
            return false;
        }
        titleLayout.setVisibility(0);
        List<com.tencent.mobileqq.troop.troopnotification.render.richtext.f> u16 = TroopNotificationRender.f300720a.u(list, data);
        titleLayout.setGroupTextClickable(true);
        titleLayout.setMemberTextClickable(true);
        titleLayout.t(msg2, u16);
        return true;
    }

    private final void f(TroopNotificationRichTextView titleLayout) {
        titleLayout.o();
        titleLayout.setOnClickListener(null);
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean a(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.q().setTextColor(viewHolder.r());
        viewHolder.q().setTextSize(viewHolder.s());
        boolean e16 = e(msg2, wildcardValue, data, viewHolder.q());
        if (e16) {
            viewHolder.y(msg2);
        }
        return e16;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            f(viewHolder.q());
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean c(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.t().setTextColor(viewHolder.u());
        viewHolder.t().setTextSize(viewHolder.v());
        boolean e16 = e(msg2, wildcardValue, data, viewHolder.t());
        if (e16) {
            viewHolder.z(msg2);
        }
        return e16;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void d(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            f(viewHolder.t());
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    @NotNull
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return key;
    }
}
