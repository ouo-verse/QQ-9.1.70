package com.tencent.mobileqq.troop.troopnotification.render.parser;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000bH\u0016J6\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\t\u001a\u00020\bH\u0016J6\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\t\u001a\u00020\u000bH\u0016Jn\u0010!\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\u001a\u001a\u00020\u000226\u0010 \u001a2\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00040\u001bH\u0004\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "Landroid/widget/Button;", "btn", "", "l", "", tl.h.F, "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "g", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "i", "d", "b", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "data", "", "c", "a", "button", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser$a;", "clickData", NodeProps.ON_CLICK, "j", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class TroopNotificationBaseButtonParser implements com.tencent.mobileqq.troop.troopnotification.render.parser.a {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "type", "b", "transData", "toast", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String transData;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String toast;

        public a(@NotNull String type, @NotNull String transData, @NotNull String toast) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(transData, "transData");
            Intrinsics.checkNotNullParameter(toast, "toast");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, type, transData, toast);
                return;
            }
            this.type = type;
            this.transData = transData;
            this.toast = toast;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.toast;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.transData;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.type, aVar.type) && Intrinsics.areEqual(this.transData, aVar.transData) && Intrinsics.areEqual(this.toast, aVar.toast)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.type.hashCode() * 31) + this.transData.hashCode()) * 31) + this.toast.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "ClickData(type=" + this.type + ", transData=" + this.transData + ", toast=" + this.toast + ")";
        }
    }

    public TroopNotificationBaseButtonParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function2 onClick, com.tencent.qqnt.notification.f msg2, String type, String transData, String toast, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(transData, "$transData");
        Intrinsics.checkNotNullParameter(toast, "$toast");
        onClick.invoke(msg2, new a(type, transData, toast));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l(Button btn) {
        if (btn != null) {
            btn.setVisibility(8);
        }
        if (btn != null) {
            btn.setOnClickListener(null);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean a(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Button f16 = f(viewHolder);
        if (f16 == null) {
            return false;
        }
        return j(msg2, wildcardValue, data, f16, new Function2<com.tencent.qqnt.notification.f, a, Unit>(this) { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser$parse$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ TroopNotificationBaseButtonParser this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.notification.f fVar, TroopNotificationBaseButtonParser.a aVar) {
                invoke2(fVar, aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.notification.f msg3, @NotNull TroopNotificationBaseButtonParser.a clickData) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) msg3, (Object) clickData);
                    return;
                }
                Intrinsics.checkNotNullParameter(msg3, "msg");
                Intrinsics.checkNotNullParameter(clickData, "clickData");
                com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this.z(this.this$0.i(), msg3, clickData);
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            l(f(viewHolder));
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean c(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Button g16 = g(viewHolder);
        if (g16 == null) {
            return false;
        }
        return j(msg2, wildcardValue, data, g16, new Function2<com.tencent.qqnt.notification.f, a, Unit>(this) { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser$parse$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TroopNotificationBaseButtonParser this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopnotification.render.vh.list.a.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.notification.f fVar, TroopNotificationBaseButtonParser.a aVar) {
                invoke2(fVar, aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.notification.f msg3, @NotNull TroopNotificationBaseButtonParser.a clickData) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) msg3, (Object) clickData);
                    return;
                }
                Intrinsics.checkNotNullParameter(msg3, "msg");
                Intrinsics.checkNotNullParameter(clickData, "clickData");
                com.tencent.mobileqq.troop.troopnotification.render.vh.list.a.this.A(this.this$0.i(), msg3, clickData);
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void d(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            l(g(viewHolder));
        }
    }

    @Nullable
    public abstract Button f(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder);

    @Nullable
    public abstract Button g(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder);

    @NotNull
    public abstract String h();

    @NotNull
    public abstract GroupNotifyOperateType i();

    protected final boolean j(@NotNull final com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull Button button, @NotNull final Function2<? super com.tencent.qqnt.notification.f, ? super a, Unit> onClick) {
        Map map;
        final String str;
        String str2;
        String str3;
        boolean z16;
        String obj;
        String obj2;
        Object e16;
        String obj3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, msg2, wildcardValue, data, button, onClick)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        if (msg2.e()) {
            return false;
        }
        String str4 = null;
        if (wildcardValue instanceof Map) {
            map = (Map) wildcardValue;
        } else {
            map = null;
        }
        if (map == null) {
            QLog.e(h(), 1, "parse: not find button data, wildcardValue=" + wildcardValue + ", data=" + data);
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
        if (QLog.isColorLevel()) {
            QLog.d(h(), 2, "parse: text=" + str4 + ", transData=" + str + ", type=" + str3);
        }
        if (str4 != null && str4.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            button.setVisibility(0);
            button.setText(str4);
            final String str5 = str3;
            final String str6 = str2;
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopNotificationBaseButtonParser.k(Function2.this, msg2, str5, str, str6, view);
                }
            });
        } else {
            button.setVisibility(8);
        }
        return true;
    }
}
