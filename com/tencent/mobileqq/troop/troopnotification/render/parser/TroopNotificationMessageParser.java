package com.tencent.mobileqq.troop.troopnotification.render.parser;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.render.TroopNotificationRender;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationDetailTextView;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J6\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016JY\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0013\u001a\u00020\u00122#\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0014R\u001a\u0010\u001f\u001a\u00020\r8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationMessageParser;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "", "d", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "b", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "", "data", "", "c", "a", "Landroid/view/ViewGroup;", "messageLayout", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationRichTextView;", "onCreateRichText", "e", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationMessageParser implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopNotificationMessageParser f300741a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String key;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f300741a = new TroopNotificationMessageParser();
            key = "message";
        }
    }

    TroopNotificationMessageParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean a(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return e(msg2, wildcardValue, data, viewHolder.j(), new Function1<Integer, TroopNotificationRichTextView>() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationMessageParser$parse$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TroopNotificationRichTextView invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final TroopNotificationRichTextView invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this.x(i3) : (TroopNotificationRichTextView) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.j().removeAllViews();
        viewHolder.j().setVisibility(8);
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean c(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return e(msg2, wildcardValue, data, viewHolder.q(), new Function1<Integer, TroopNotificationRichTextView>() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationMessageParser$parse$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopnotification.render.vh.list.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TroopNotificationRichTextView invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final TroopNotificationRichTextView invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.mobileqq.troop.troopnotification.render.vh.list.a.this.y(i3) : (TroopNotificationRichTextView) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void d(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.q().removeAllViews();
        viewHolder.q().setVisibility(8);
    }

    public final boolean e(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull ViewGroup messageLayout, @NotNull Function1<? super Integer, ? extends TroopNotificationRichTextView> onCreateRichText) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, msg2, wildcardValue, data, messageLayout, onCreateRichText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(messageLayout, "messageLayout");
        Intrinsics.checkNotNullParameter(onCreateRichText, "onCreateRichText");
        List list = wildcardValue instanceof List ? (List) wildcardValue : null;
        if (list == null) {
            QLog.e("TroopNotificationMessageParser", 1, "parse: not find messageData, wildcardValue=" + wildcardValue + ", data=" + data);
            return false;
        }
        messageLayout.removeAllViews();
        messageLayout.setVisibility(0);
        for (Object obj : list) {
            if (obj instanceof List) {
                List<com.tencent.mobileqq.troop.troopnotification.render.richtext.f> u16 = TroopNotificationRender.f300720a.u((List) obj, data);
                TroopNotificationRichTextView invoke = onCreateRichText.invoke(Integer.valueOf(i3));
                if (invoke != null) {
                    invoke.t(msg2, u16);
                    messageLayout.addView(invoke);
                    ViewGroup.LayoutParams layoutParams = invoke.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.tencent.mobileqq.util.x.c(invoke.getContext(), 2.0f);
                    }
                }
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                Object obj2 = map.get("prefix");
                if (obj2 == null || (str = obj2.toString()) == null) {
                    str = "";
                }
                Object obj3 = map.get("text");
                if (obj3 instanceof List) {
                    List<com.tencent.mobileqq.troop.troopnotification.render.richtext.f> u17 = TroopNotificationRender.f300720a.u((List) obj3, data);
                    TroopNotificationRichTextView invoke2 = onCreateRichText.invoke(Integer.valueOf(i3));
                    TroopNotificationDetailTextView troopNotificationDetailTextView = invoke2 instanceof TroopNotificationDetailTextView ? (TroopNotificationDetailTextView) invoke2 : null;
                    if (troopNotificationDetailTextView != null) {
                        troopNotificationDetailTextView.v(msg2, str, u17);
                        messageLayout.addView(troopNotificationDetailTextView);
                        ViewGroup.LayoutParams layoutParams3 = troopNotificationDetailTextView.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
                        if (layoutParams4 != null) {
                            layoutParams4.topMargin = com.tencent.mobileqq.util.x.c(troopNotificationDetailTextView.getContext(), 2.0f);
                        }
                    }
                } else {
                    QLog.e("TroopNotificationMessageParser", 1, "parse: line data parse error, prefix=" + str + ", richData=" + obj);
                }
            } else {
                QLog.e("TroopNotificationMessageParser", 1, "parse: line data parse error, lineData=" + obj);
            }
            i3++;
        }
        return true;
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
