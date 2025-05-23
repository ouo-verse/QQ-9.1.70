package com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.NickBlockInject;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.AIONickComponentV2;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.block.AIONickIconSimpleBlock;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\"\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020(\u00a2\u0006\u0004\b6\u00107J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J&\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\nH\u0002J\u001c\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004J*\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u001c2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u001f\u001a\u00020\bR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010+R\u0016\u0010-\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010.R\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0014008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/b;", "", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "payloads", "", "g", "", "b", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "newIconData", h.F, "", "troopUin", "memberUin", "i", "iconDataList", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", "block", "k", "rowIconData", "e", "", "f", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "realIconDate", "d", "j", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/AIONickComponentV2;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/AIONickComponentV2;", "parentComponent", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "componentRootView", "Ljava/lang/String;", "mMemberUin", "mTroopUin", "Ljava/util/List;", "nickIconData", "", "Ljava/util/Map;", "nickBlocks", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/d;", "nickIconRepo", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/AIONickComponentV2;Landroid/content/Context;Landroid/widget/LinearLayout;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIONickComponentV2 parentComponent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout componentRootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mMemberUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTroopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> nickIconData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> nickBlocks;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d nickIconRepo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7318b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f191385d;

        public C7318b(List list) {
            this.f191385d = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f191385d.indexOf(Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) t16).a()))), Integer.valueOf(this.f191385d.indexOf(Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) t17).a()))));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62695);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull AIONickComponentV2 parentComponent, @NotNull Context context, @NotNull LinearLayout componentRootView) {
        Intrinsics.checkNotNullParameter(parentComponent, "parentComponent");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(componentRootView, "componentRootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, parentComponent, context, componentRootView);
            return;
        }
        this.parentComponent = parentComponent;
        this.context = context;
        this.componentRootView = componentRootView;
        this.mMemberUin = "";
        this.mTroopUin = "";
        this.nickIconData = new ArrayList();
        this.nickBlocks = new LinkedHashMap();
        this.nickIconRepo = new d(this);
    }

    private final void b(com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        AIOMsgItem aIOMsgItem;
        if (msgItem instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) msgItem;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null) {
            Iterator<T> it = this.nickBlocks.values().iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a) it.next()).i((AIOMsgItem) msgItem, payloads);
            }
        }
    }

    private final void c(List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> iconDataList) {
        Unit unit;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.componentRootView.removeAllViews();
        for (com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b bVar : iconDataList) {
            int a16 = bVar.a();
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a aVar = this.nickBlocks.get(Integer.valueOf(a16));
            if (aVar != null) {
                linkedHashMap.put(Integer.valueOf(a16), aVar);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a a17 = NickBlockInject.f191343a.a(a16, this.context, this.componentRootView);
                if (a17 == null) {
                    a17 = new AIONickIconSimpleBlock(bVar, this.context, this.componentRootView);
                }
                a17.a(this.parentComponent);
                linkedHashMap.put(Integer.valueOf(a16), a17);
            }
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a aVar2 = (com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a) linkedHashMap.get(Integer.valueOf(a16));
            if (aVar2 != null) {
                aVar2.q(bVar);
            }
            k((com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a) linkedHashMap.get(Integer.valueOf(a16)));
        }
        this.nickBlocks = linkedHashMap;
    }

    private final List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> e(List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> rowIconData) {
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> sortedWith;
        boolean z16;
        List<Integer> f16 = f();
        ArrayList arrayList = new ArrayList();
        for (Object obj : rowIconData) {
            com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) obj;
            if (bVar != null && f16.contains(Integer.valueOf(bVar.a())) && bVar.b() > NetConnInfoCenter.getServerTime()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new C7318b(f16));
        return sortedWith;
    }

    private final List<Integer> f() {
        return com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.config.a.f191394a.c();
    }

    private final boolean g(com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        AIOMsgItem aIOMsgItem;
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(AIOMsgItemPayloadType.NICK_ICON_DATA) != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("AIONickIconComponent", 2, "[handlePayload] NICK_ICON_DATA");
                }
                if (msgItem instanceof AIOMsgItem) {
                    aIOMsgItem = (AIOMsgItem) msgItem;
                } else {
                    aIOMsgItem = null;
                }
                if (aIOMsgItem != null) {
                    AIOMsgItem aIOMsgItem2 = (AIOMsgItem) msgItem;
                    List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> c06 = aIOMsgItem2.c0();
                    if (c06 == null) {
                        c06 = new ArrayList<>();
                    }
                    d(aIOMsgItem2, payloads, c06);
                }
                return true;
            }
        }
        b(msgItem, payloads);
        return true;
    }

    private final boolean h(List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> newIconData) {
        if (newIconData.size() != this.nickIconData.size()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : newIconData) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual((com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) obj, this.nickIconData.get(i3))) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    private final boolean i(String troopUin, String memberUin, List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> newIconData) {
        if (Intrinsics.areEqual(troopUin, this.mTroopUin) && Intrinsics.areEqual(memberUin, this.mMemberUin) && h(newIconData)) {
            return false;
        }
        this.mTroopUin = troopUin;
        this.mMemberUin = memberUin;
        this.nickIconData = newIconData;
        return true;
    }

    private final void k(com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a block) {
        ViewGroup viewGroup;
        if (block == null) {
            return;
        }
        View n3 = block.n();
        if (n3 == null && (n3 = block.b()) == null) {
            return;
        }
        ViewParent parent = n3.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(n3);
        }
        this.componentRootView.addView(n3);
    }

    public final void a(@NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        AIOMsgItem aIOMsgItem;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem, (Object) payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (g(msgItem, payloads)) {
            return;
        }
        if (msgItem instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) msgItem;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null) {
            AIOMsgItem aIOMsgItem2 = (AIOMsgItem) msgItem;
            List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> c06 = aIOMsgItem2.c0();
            List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> list = c06;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                c06 = ((IAIONickIconServiceApi) QRoute.api(IAIONickIconServiceApi.class)).getStaticIconDataList();
            }
            d(aIOMsgItem2, payloads, c06);
            this.nickIconRepo.a(aIOMsgItem2, payloads);
        }
    }

    public final void d(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads, @NotNull List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> realIconDate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msgItem, payloads, realIconDate);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Intrinsics.checkNotNullParameter(realIconDate, "realIconDate");
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> e16 = e(realIconDate);
        if (i(String.valueOf(msgItem.getMsgRecord().peerUin), String.valueOf(msgItem.getMsgRecord().senderUin), e16)) {
            c(e16);
        }
        b(msgItem, payloads);
    }

    public final void j() {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Iterator<T> it = this.nickBlocks.values().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a) it.next()).k();
        }
        this.mMemberUin = "";
        this.mTroopUin = "";
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> list = this.nickIconData;
        if (list instanceof ArrayList) {
            arrayList = (ArrayList) list;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
