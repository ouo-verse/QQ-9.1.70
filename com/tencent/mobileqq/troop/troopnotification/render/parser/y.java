package com.tencent.mobileqq.troop.troopnotification.render.parser;

import android.view.View;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J6\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016R\u001a\u0010\u0015\u001a\u00020\r8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/y;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "", "d", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "b", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "", "data", "", "c", "a", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class y implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f300794a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String key;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59528);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f300794a = new y();
            key = "topButton";
        }
    }

    y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder, com.tencent.qqnt.notification.f msg2, String type, String transData, String toast, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(transData, "$transData");
        Intrinsics.checkNotNullParameter(toast, "$toast");
        viewHolder.z(GroupNotifyOperateType.KIGNORE, msg2, new TroopNotificationBaseButtonParser.a(type, transData, toast));
        com.tencent.mobileqq.troop.troopnotification.report.a.f300918a.n(msg2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean a(@NotNull final com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        Map map;
        final String str;
        final String str2;
        final String str3;
        String obj;
        String obj2;
        Object e16;
        String obj3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        String str4 = null;
        if (wildcardValue instanceof Map) {
            map = (Map) wildcardValue;
        } else {
            map = null;
        }
        if (map == null) {
            QLog.e("TroopNotificationTopButtonParser", 1, "parse: not find top button data, wildcardValue=" + wildcardValue + ", data=" + data);
            return false;
        }
        Object obj4 = map.get("text");
        if (obj4 instanceof String) {
            str4 = (String) obj4;
        }
        Object obj5 = map.get("data");
        if (obj5 == null || (e16 = com.tencent.mobileqq.troop.troopnotification.utils.b.f300925a.e(obj5)) == null || (obj3 = e16.toString()) == null) {
            str = "";
        } else {
            str = obj3;
        }
        Object obj6 = map.get("toast");
        if (obj6 == null || (obj2 = obj6.toString()) == null) {
            str2 = "";
        } else {
            str2 = obj2;
        }
        Object obj7 = map.get("type");
        if (obj7 == null || (obj = obj7.toString()) == null) {
            str3 = "";
        } else {
            str3 = obj;
        }
        if (str4 == null || str4.length() == 0) {
            z16 = true;
        }
        if (z16) {
            viewHolder.k().setRightText("");
            viewHolder.k().setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    y.h(view);
                }
            });
        } else {
            viewHolder.k().setRightText(str4);
            viewHolder.k().setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    y.i(com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this, msg2, str3, str, str2, view);
                }
            });
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.k().setRightText("");
        viewHolder.k().setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y.j(view);
            }
        });
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
        return false;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void d(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
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
