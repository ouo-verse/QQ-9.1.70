package com.tencent.mobileqq.troop.troopidentity.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityAppTag;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityTitleInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "", "<init>", "()V", "a", "b", "c", "d", "e", "Lcom/tencent/mobileqq/troop/troopidentity/view/c$a;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c$b;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c$c;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c$d;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c$e;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/c$a;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "", "a", "Z", "isSet", "()Z", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "iconInfo", "<init>", "(ZLcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSet;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GroupIdentityAppTag iconInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z16, @NotNull GroupIdentityAppTag iconInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(iconInfo, "iconInfo");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), iconInfo);
            } else {
                this.isSet = z16;
                this.iconInfo = iconInfo;
            }
        }

        @NotNull
        public final GroupIdentityAppTag a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (GroupIdentityAppTag) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.iconInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/c$b;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "selectedHonorIcon", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final GroupIdentityInteractionTag selectedHonorIcon;

        public b(@Nullable GroupIdentityInteractionTag groupIdentityInteractionTag) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupIdentityInteractionTag);
            } else {
                this.selectedHonorIcon = groupIdentityInteractionTag;
            }
        }

        @Nullable
        public final GroupIdentityInteractionTag a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GroupIdentityInteractionTag) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.selectedHonorIcon;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/c$c;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "a", "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "()Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "memberRankItem", "<init>", "(Lcom/tencent/mobileqq/troop/troopmemberlevel/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.view.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8816c extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.mobileqq.troop.troopmemberlevel.a memberRankItem;

        public C8816c(@Nullable com.tencent.mobileqq.troop.troopmemberlevel.a aVar) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.memberRankItem = aVar;
            }
        }

        @Nullable
        public final com.tencent.mobileqq.troop.troopmemberlevel.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.troop.troopmemberlevel.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.memberRankItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u0004\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/c$d;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityTitleInfo;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "titleList", "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "()Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "newRankItem", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/troop/troopmemberlevel/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<GroupIdentityTitleInfo> titleList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.mobileqq.troop.troopmemberlevel.a newRankItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull List<GroupIdentityTitleInfo> titleList, @Nullable com.tencent.mobileqq.troop.troopmemberlevel.a aVar) {
            super(null);
            Intrinsics.checkNotNullParameter(titleList, "titleList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) titleList, (Object) aVar);
            } else {
                this.titleList = titleList;
                this.newRankItem = aVar;
            }
        }

        @Nullable
        public final com.tencent.mobileqq.troop.troopmemberlevel.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.troop.troopmemberlevel.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.newRankItem;
        }

        @NotNull
        public final List<GroupIdentityTitleInfo> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.titleList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/c$e;", "Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "", "a", "Z", "()Z", "isVisible", "<init>", "(Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class e extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isVisible;

        public e(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.isVisible = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isVisible;
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
