package com.tencent.mobileqq.troop.troopnotification.render.parser;

import android.widget.Button;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J6\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u0005\u001a\u00020\bH\u0016R\u001a\u0010\u0018\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/h;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser;", "", tl.h.F, "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "Landroid/widget/Button;", "g", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "i", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "data", "", "a", "b", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h extends TroopNotificationBaseButtonParser {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f300760a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String key;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f300760a = new h();
            key = "cancelButton";
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser, com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean a(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        boolean a16 = super.a(msg2, wildcardValue, data, viewHolder);
        if (a16) {
            com.tencent.mobileqq.troop.troopnotification.report.a aVar = com.tencent.mobileqq.troop.troopnotification.report.a.f300918a;
            aVar.b(viewHolder.g(), msg2);
            aVar.l(msg2);
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser
    @Nullable
    public Button f(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Button) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return viewHolder.g();
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser
    @Nullable
    public Button g(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Button) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return null;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    @NotNull
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return key;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser
    @NotNull
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopNotificationCancelButtonParser";
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser
    @NotNull
    public GroupNotifyOperateType i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (GroupNotifyOperateType) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return GroupNotifyOperateType.KREFUSE;
    }
}
