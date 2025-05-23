package com.tencent.mobileqq.troop.troopidentity.view.alltags;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 32\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003456Bc\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012B\b\u0002\u0010(\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001fj\u0004\u0018\u0001`%\u00a2\u0006\u0004\b1\u00102J&\u0010\b\u001a\u00020\u00072\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dRN\u0010(\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001fj\u0004\u0018\u0001`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R'\u00100\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c$c;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "isObtainedList", "notObtainedList", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "position", "m0", "getItemCount", "holder", "l0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "D", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "reporter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "iconInfo", "", "isSelected", "Lcom/tencent/mobileqq/troop/troopidentity/view/TroopIdentityInteractiveIconClickCallback;", "E", "Lkotlin/jvm/functions/Function2;", "cb", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c$b;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "items", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/troop/troopidentity/util/a;Lkotlin/jvm/functions/Function2;)V", "G", "a", "b", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends RecyclerView.Adapter<C8815c> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopidentity.util.a reporter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final Function2<GroupIdentityInteractionTag, Boolean, Unit> cb;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<b> items;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.view.alltags.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "b", "desc", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "Ljava/util/List;", "()Ljava/util/List;", "interactiveTags", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String desc;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<GroupIdentityInteractionTag> interactiveTags;

        public b(@NotNull String title, @NotNull String desc, @NotNull List<GroupIdentityInteractionTag> interactiveTags) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(interactiveTags, "interactiveTags");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, title, desc, interactiveTags);
                return;
            }
            this.title = title;
            this.desc = desc;
            this.interactiveTags = interactiveTags;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.desc;
        }

        @NotNull
        public final List<GroupIdentityInteractionTag> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.interactiveTags;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.title, bVar.title) && Intrinsics.areEqual(this.desc, bVar.desc) && Intrinsics.areEqual(this.interactiveTags, bVar.interactiveTags)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.title.hashCode() * 31) + this.desc.hashCode()) * 31) + this.interactiveTags.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "InteractiveGroupData(title=" + this.title + ", desc=" + this.desc + ", interactiveTags=" + this.interactiveTags + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "title", "desc", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "interactiveTags", "", "l", "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/InteractiveTagGroupView;", "E", "Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/InteractiveTagGroupView;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/c;Lcom/tencent/mobileqq/troop/troopidentity/view/alltags/InteractiveTagGroupView;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.view.alltags.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public final class C8815c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final InteractiveTagGroupView rootView;
        final /* synthetic */ c F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8815c(@NotNull c cVar, InteractiveTagGroupView rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.F = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) rootView);
            } else {
                this.rootView = rootView;
            }
        }

        public final void l(@NotNull String title, @NotNull String desc, @NotNull List<GroupIdentityInteractionTag> interactiveTags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, title, desc, interactiveTags);
                return;
            }
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(interactiveTags, "interactiveTags");
            this.rootView.a(this.F.troopUin, this.F.reporter, this.F.cb);
            this.rootView.b(title, desc, interactiveTags);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57897);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull Context context, @NotNull String troopUin, @NotNull com.tencent.mobileqq.troop.troopidentity.util.a reporter, @Nullable Function2<? super GroupIdentityInteractionTag, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, troopUin, reporter, function2);
            return;
        }
        this.context = context;
        this.troopUin = troopUin;
        this.reporter = reporter;
        this.cb = function2;
        this.items = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C8815c holder, int position) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.items, position);
        b bVar = (b) orNull;
        if (bVar == null) {
            return;
        }
        holder.l(bVar.c(), bVar.a(), bVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public C8815c onCreateViewHolder(@NotNull ViewGroup parent, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (C8815c) iPatchRedirector.redirect((short) 6, (Object) this, (Object) parent, position);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        InteractiveTagGroupView interactiveTagGroupView = new InteractiveTagGroupView(this.context, null, 0, 6, null);
        interactiveTagGroupView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new C8815c(this, interactiveTagGroupView);
    }

    public final void n0(@Nullable List<GroupIdentityInteractionTag> isObtainedList, @Nullable List<GroupIdentityInteractionTag> notObtainedList) {
        Integer num;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) isObtainedList, (Object) notObtainedList);
            return;
        }
        this.items.clear();
        Integer num2 = null;
        if (isObtainedList != null) {
            num = Integer.valueOf(isObtainedList.size());
        } else {
            num = null;
        }
        if (notObtainedList != null) {
            num2 = Integer.valueOf(notObtainedList.size());
        }
        QLog.d("TroopAllIdentityAdapter", 4, "[submit] isObtainedList:" + num + ", notObtainedList:" + num2);
        boolean z17 = false;
        if (isObtainedList != null && (!isObtainedList.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.items.add(new b("\u5df2\u70b9\u4eae\u6807\u8bc6", "\u70b9\u51fb\u53ef\u4f69\u6234\u6216\u53d6\u6d88\u4f69\u6234", isObtainedList));
        }
        if (notObtainedList != null && (!notObtainedList.isEmpty())) {
            z17 = true;
        }
        if (z17) {
            this.items.add(new b("\u672a\u70b9\u4eae\u6807\u8bc6", "", notObtainedList));
        }
        notifyDataSetChanged();
    }
}
