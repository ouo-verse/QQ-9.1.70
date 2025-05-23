package com.tencent.mobileqq.troop.troopnotification.render.richtext;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.render.TroopNotificationRender;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationMemberTextParser;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ0\u0010\b\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J$\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u001a\u0010\u001b\u001a\u00020\u00178\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationMemberTextParser;", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/a;", "", "", "", "textData", "allData", "Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/f;", "a", "", "isClickable", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/notification/f;", "msg", "richText", "b", "Landroid/widget/TextView;", "textView", "Lkotlin/Function0;", "", "onGetMemberName", "c", "", "I", "getType", "()I", "type", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationMemberTextParser implements com.tencent.mobileqq.troop.troopnotification.render.richtext.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopNotificationMemberTextParser f300796a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int type;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/richtext/TroopNotificationMemberTextParser$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "name", "b", "groupUin", "c", "memberUin", "cacheGroupNick", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String groupUin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String memberUin;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String cacheGroupNick;

        public a(@NotNull String name, @NotNull String groupUin, @NotNull String memberUin, @NotNull String cacheGroupNick) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(groupUin, "groupUin");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            Intrinsics.checkNotNullParameter(cacheGroupNick, "cacheGroupNick");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, name, groupUin, memberUin, cacheGroupNick);
                return;
            }
            this.name = name;
            this.groupUin = groupUin;
            this.memberUin = memberUin;
            this.cacheGroupNick = cacheGroupNick;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.cacheGroupNick;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.groupUin;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.memberUin;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.name;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.name, aVar.name) && Intrinsics.areEqual(this.groupUin, aVar.groupUin) && Intrinsics.areEqual(this.memberUin, aVar.memberUin) && Intrinsics.areEqual(this.cacheGroupNick, aVar.cacheGroupNick)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return (((((this.name.hashCode() * 31) + this.groupUin.hashCode()) * 31) + this.memberUin.hashCode()) * 31) + this.cacheGroupNick.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "TroopMemberTextData(name=" + this.name + ", groupUin=" + this.groupUin + ", memberUin=" + this.memberUin + ", cacheGroupNick=" + this.cacheGroupNick + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59578);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f300796a = new TroopNotificationMemberTextParser();
            type = 1;
        }
    }

    TroopNotificationMemberTextParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.richtext.a
    @NotNull
    public f a(@NotNull Map<String, ? extends Object> textData, @NotNull Map<String, ? extends Object> allData) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) textData, (Object) allData);
        }
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(allData, "allData");
        String valueOf = String.valueOf(textData.get("uin"));
        Object obj = textData.get("name");
        if (obj == null || (str = obj.toString()) == null) {
            str = "";
        }
        Object obj2 = textData.get(VipFunCallConstants.KEY_GROUP);
        Object obj3 = textData.get("group_nick");
        if (obj3 == null || (str2 = obj3.toString()) == null) {
            str2 = "";
        }
        if (obj2 instanceof String) {
            Object w3 = TroopNotificationRender.f300720a.w((String) obj2, allData);
            if (w3 instanceof Map) {
                return new f(str, 1, new a(str, String.valueOf(((Map) w3).get("uin")), valueOf, str2));
            }
        }
        return new f(str, 1, new a(str, "", valueOf, str2));
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
        if (richText.a() instanceof a) {
            Object a16 = richText.a();
            com.tencent.mobileqq.troop.troopnotification.utils.d dVar = com.tencent.mobileqq.troop.troopnotification.utils.d.f300927a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            a aVar = (a) a16;
            dVar.f(context, aVar.b(), aVar.c(), msg2);
        } else if (richText.a() instanceof String) {
            com.tencent.mobileqq.troop.troopnotification.utils.d dVar2 = com.tencent.mobileqq.troop.troopnotification.utils.d.f300927a;
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            dVar2.f(context2, null, (String) richText.a(), msg2);
        }
        com.tencent.mobileqq.troop.troopnotification.report.a.f300918a.o(view.getParent() instanceof TroopNotificationDetailTextView, msg2);
        return true;
    }

    public final void c(@NotNull TextView textView, @NotNull f richText, @NotNull final Function0<Unit> onGetMemberName) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, textView, richText, onGetMemberName);
            return;
        }
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(richText, "richText");
        Intrinsics.checkNotNullParameter(onGetMemberName, "onGetMemberName");
        textView.setTag(null);
        if (richText.a() instanceof a) {
            final Object a16 = richText.a();
            a aVar = (a) a16;
            boolean z17 = true;
            if (aVar.b().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (aVar.c().length() <= 0) {
                    z17 = false;
                }
                if (z17) {
                    textView.setTag(a16);
                    final WeakReference weakReference = new WeakReference(textView);
                    TroopMemberListRepo.INSTANCE.fetchTroopMemberName(aVar.b(), aVar.c(), "TroopNotificationMemberTextParser", new Function1<TroopMemberNickInfo, Unit>(weakReference, a16, onGetMemberName) { // from class: com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationMemberTextParser$loadMemberText$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Object $memberData;
                        final /* synthetic */ Function0<Unit> $onGetMemberName;
                        final /* synthetic */ WeakReference<TextView> $textViewRef;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$textViewRef = weakReference;
                            this.$memberData = a16;
                            this.$onGetMemberName = onGetMemberName;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, weakReference, a16, onGetMemberName);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                            invoke2(troopMemberNickInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                            String d16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                                return;
                            }
                            TextView textView2 = this.$textViewRef.get();
                            if (textView2 != null && Intrinsics.areEqual(textView2.getTag(), this.$memberData)) {
                                if (troopMemberNickInfo == null || (d16 = troopMemberNickInfo.getShowName()) == null) {
                                    d16 = ((TroopNotificationMemberTextParser.a) this.$memberData).d();
                                }
                                textView2.setText(d16);
                                this.$onGetMemberName.invoke();
                            }
                        }
                    });
                    return;
                }
            }
            textView.setText(new TroopMemberNickInfo("", aVar.c(), "", "", 0, aVar.a(), "", aVar.d(), null, null, null, 1792, null).getShowNameV2());
            return;
        }
        textView.setText(richText.b());
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
        return true;
    }
}
