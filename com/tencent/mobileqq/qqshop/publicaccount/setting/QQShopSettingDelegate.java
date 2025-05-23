package com.tencent.mobileqq.qqshop.publicaccount.setting;

import android.view.View;
import android.widget.Checkable;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.setting.EnumSettingGroupId;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.setting.QQShopSettingDelegate;
import com.tencent.mobileqq.qqshop.publicaccount.setting.c;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.g;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u0002\u001b\u0017B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0002J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J+\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0011\"\u00020\rH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001eR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00040 j\b\u0012\u0004\u0012\u00020\u0004`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010.\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010-\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/setting/QQShopSettingDelegate;", "Lcom/tencent/biz/pubaccount/setting/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqshop/publicaccount/setting/c$a;", "switchItem", "", "isChecked", "p", "Lcom/tencent/biz/pubaccount/accountdetail/api/IPublicAccountDetail;", "accountDetail", "o", "cardSwitch", "Lcom/tencent/mobileqq/widget/listitem/Group;", "i", "", "switchItems", "", DomainData.DOMAIN_NAME, "(Ljava/util/List;)[Lcom/tencent/mobileqq/widget/listitem/Group;", "", "uin", "name", "b", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "groups", "a", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;[Lcom/tencent/mobileqq/widget/listitem/Group;)V", "Lcom/tencent/mobileqq/qqshop/publicaccount/setting/QQShopSettingDelegate$b;", "Lcom/tencent/mobileqq/qqshop/publicaccount/setting/QQShopSettingDelegate$b;", "adapterWrapper", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "switchItemList", "c", "Lcom/tencent/biz/pubaccount/accountdetail/api/IPublicAccountDetail;", "Landroid/widget/Checkable;", "d", "Landroid/widget/Checkable;", "mDailyMessageSettingSwitch", "e", "mCardMessageSettingSwitch", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/qqshop/publicaccount/setting/c$a;", "dailySwitchItem", "l", "cardSwitchItem", "<init>", "()V", "f", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopSettingDelegate implements com.tencent.biz.pubaccount.setting.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b adapterWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<c.a> switchItemList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPublicAccountDetail accountDetail;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Checkable mDailyMessageSettingSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Checkable mCardMessageSettingSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/setting/QQShopSettingDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.setting.QQShopSettingDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\r\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/setting/QQShopSettingDelegate$b;", "", "", "a", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "c", "([Lcom/tencent/mobileqq/widget/listitem/Group;)V", "d", "", "Ljava/util/List;", "baseData", "b", "qqshopData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "baseDataReady", "qqshopDataReady", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "e", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;)V", "adapter", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Group> baseData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Group> qqshopData;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicBoolean baseDataReady;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicBoolean qqshopDataReady;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private QUIListItemAdapter adapter;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.baseData = new ArrayList();
            this.qqshopData = new ArrayList();
            this.baseDataReady = new AtomicBoolean(false);
            this.qqshopDataReady = new AtomicBoolean(false);
        }

        private final void a() {
            List plus;
            if (this.baseDataReady.get() && this.qqshopDataReady.get()) {
                plus = CollectionsKt___CollectionsKt.plus((Collection) this.baseData, (Iterable) this.qqshopData);
                QUIListItemAdapter qUIListItemAdapter = this.adapter;
                if (qUIListItemAdapter != null) {
                    Object[] array = plus.toArray(new Group[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    Group[] groupArr = (Group[]) array;
                    qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
                }
            }
        }

        public final void b(@Nullable QUIListItemAdapter qUIListItemAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qUIListItemAdapter);
            } else {
                this.adapter = qUIListItemAdapter;
            }
        }

        public final void c(@NotNull Group... groups) {
            List mutableList;
            Object obj;
            com.tencent.biz.pubaccount.setting.b bVar;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) groups);
                return;
            }
            Intrinsics.checkNotNullParameter(groups, "groups");
            mutableList = ArraysKt___ArraysKt.toMutableList(groups);
            Iterator it = mutableList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> a16 = ((Group) next).a();
                boolean z17 = false;
                if (!(a16 instanceof Collection) || !a16.isEmpty()) {
                    Iterator<T> it5 = a16.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        com.tencent.mobileqq.widget.listitem.a aVar = (com.tencent.mobileqq.widget.listitem.a) it5.next();
                        if (aVar instanceof com.tencent.biz.pubaccount.setting.b) {
                            bVar = (com.tencent.biz.pubaccount.setting.b) aVar;
                        } else {
                            bVar = null;
                        }
                        if (bVar != null && bVar.getId() == EnumSettingGroupId.ACCEPT_MSG.ordinal()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            z17 = true;
                            break;
                        }
                    }
                }
                if (z17) {
                    obj = next;
                    break;
                }
            }
            List list = mutableList;
            TypeIntrinsics.asMutableCollection(list).remove((Group) obj);
            this.baseData.addAll(list);
            this.baseDataReady.set(true);
            a();
        }

        public final void d(@NotNull Group... groups) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) groups);
                return;
            }
            Intrinsics.checkNotNullParameter(groups, "groups");
            CollectionsKt__MutableCollectionsKt.addAll(this.qqshopData, groups);
            this.qqshopDataReady.set(true);
            a();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQShopSettingDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.adapterWrapper = new b();
            this.switchItemList = new ArrayList<>();
        }
    }

    private final Group i(final c.a cardSwitch) {
        x.c.f fVar = new x.c.f(false, null);
        fVar.b(new g() { // from class: com.tencent.mobileqq.qqshop.publicaccount.setting.a
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQShopSettingDelegate.j(c.a.this, this, view);
            }
        });
        return new Group("", cardSwitch.a(), new x(new x.b.d(cardSwitch.b()), fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(final c.a cardSwitch, final QQShopSettingDelegate this$0, final View view) {
        Intrinsics.checkNotNullParameter(cardSwitch, "$cardSwitch");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof Checkable) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.setting.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QQShopSettingDelegate.k(QQShopSettingDelegate.this, cardSwitch, view, view2);
                }
            });
            if (cardSwitch.c() == 2) {
                this$0.mCardMessageSettingSwitch = (Checkable) view;
            } else if (cardSwitch.c() == 1) {
                this$0.mDailyMessageSettingSwitch = (Checkable) view;
            }
            this$0.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(QQShopSettingDelegate this$0, c.a cardSwitch, View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardSwitch, "$cardSwitch");
        Intrinsics.checkNotNullParameter(view, "$view");
        this$0.p(cardSwitch, ((Checkable) view).isChecked());
        EventCollector.getInstance().onViewClicked(view2);
    }

    private final c.a l() {
        Object obj;
        boolean z16;
        Iterator<T> it = this.switchItemList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((c.a) obj).c() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (c.a) obj;
    }

    private final c.a m() {
        Object obj;
        Iterator<T> it = this.switchItemList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                boolean z16 = true;
                if (((c.a) obj).c() != 1) {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (c.a) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Group[] n(List<c.a> switchItems) {
        Object obj;
        Object obj2;
        boolean z16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        List<c.a> list = switchItems;
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (((c.a) obj2).c() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        c.a aVar = (c.a) obj2;
        if (aVar != null) {
            arrayList.add(i(aVar));
        }
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((c.a) next).c() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        c.a aVar2 = (c.a) obj;
        if (aVar2 != null) {
            arrayList.add(i(aVar2));
        }
        Object[] array = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Group[]) array;
    }

    private final void o(IPublicAccountDetail accountDetail, boolean isChecked) {
        IPublicAccountDataManager iPublicAccountDataManager;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iPublicAccountDataManager = (IPublicAccountDataManager) peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
        } else {
            iPublicAccountDataManager = null;
        }
        if (iPublicAccountDataManager != null) {
            iPublicAccountDataManager.updateAccountDetailReceiveMsg(accountDetail, isChecked);
        }
    }

    private final void p(c.a switchItem, boolean isChecked) {
        boolean z16;
        boolean z17;
        boolean z18;
        switchItem.e(isChecked);
        c.a m3 = m();
        boolean z19 = false;
        if (m3 != null) {
            z16 = m3.d();
        } else {
            z16 = false;
        }
        c.a l3 = l();
        if (l3 != null) {
            z17 = l3.d();
        } else {
            z17 = false;
        }
        IPublicAccountDetail iPublicAccountDetail = this.accountDetail;
        if (!z16 && !z17) {
            z18 = false;
        } else {
            z18 = true;
        }
        o(iPublicAccountDetail, z18);
        if (z16 && z17) {
            z19 = true;
        }
        QLog.d("QQShopSettingDelegate", 1, "onMessageSettingChanged, isDailyChecked=" + z16 + " isCardChecked=" + z17 + " paIsChecked=" + z19);
        c.f274649a.c(this.switchItemList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        boolean z16;
        Boolean bool;
        boolean z17;
        boolean z18;
        boolean z19;
        IPublicAccountDetail iPublicAccountDetail = this.accountDetail;
        if (iPublicAccountDetail == null) {
            return;
        }
        boolean z26 = false;
        if (iPublicAccountDetail.isRecvMsg() && iPublicAccountDetail.isRecvPush()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Checkable checkable = this.mCardMessageSettingSwitch;
        if (checkable != null) {
            if (z16) {
                c.a l3 = l();
                if (l3 != null) {
                    z19 = l3.d();
                } else {
                    z19 = false;
                }
                if (z19) {
                    z18 = true;
                    checkable.setChecked(z18);
                }
            }
            z18 = false;
            checkable.setChecked(z18);
        }
        Checkable checkable2 = this.mDailyMessageSettingSwitch;
        if (checkable2 != null) {
            if (z16) {
                c.a m3 = m();
                if (m3 != null) {
                    z17 = m3.d();
                } else {
                    z17 = false;
                }
                if (z17) {
                    z26 = true;
                }
            }
            checkable2.setChecked(z26);
        }
        c.a l16 = l();
        Boolean bool2 = null;
        if (l16 != null) {
            bool = Boolean.valueOf(l16.d());
        } else {
            bool = null;
        }
        c.a m16 = m();
        if (m16 != null) {
            bool2 = Boolean.valueOf(m16.d());
        }
        QLog.d("QQShopSettingDelegate", 1, "updateUI receiveMsg=" + z16 + " cardSwitch=" + bool + " dailySwitch=" + bool2);
    }

    @Override // com.tencent.biz.pubaccount.setting.a
    public void a(@NotNull QUIListItemAdapter adapter, @NotNull Group... groups) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) adapter, (Object) groups);
            return;
        }
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.adapterWrapper.b(adapter);
        this.adapterWrapper.c((Group[]) Arrays.copyOf(groups, groups.length));
    }

    @Override // com.tencent.biz.pubaccount.setting.a
    public void b(@NotNull String uin, @NotNull String name) {
        IPublicAccountDataManager iPublicAccountDataManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) name);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iPublicAccountDataManager = (IPublicAccountDataManager) peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")) != null) {
            this.accountDetail = iPublicAccountDataManager.findAccountDetailInfoCache(uin);
            c.f274649a.d(new Function2<Boolean, List<? extends c.a>, Unit>() { // from class: com.tencent.mobileqq.qqshop.publicaccount.setting.QQShopSettingDelegate$onLoadData$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopSettingDelegate.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends c.a> list) {
                    invoke(bool.booleanValue(), (List<c.a>) list);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @Nullable List<c.a> list) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    QQShopSettingDelegate.b bVar;
                    Group[] n3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), list);
                        return;
                    }
                    if (!z16 || list == null) {
                        return;
                    }
                    arrayList = QQShopSettingDelegate.this.switchItemList;
                    arrayList.clear();
                    arrayList2 = QQShopSettingDelegate.this.switchItemList;
                    arrayList2.addAll(list);
                    bVar = QQShopSettingDelegate.this.adapterWrapper;
                    n3 = QQShopSettingDelegate.this.n(list);
                    bVar.d((Group[]) Arrays.copyOf(n3, n3.length));
                    QQShopSettingDelegate.this.q();
                }
            });
        }
    }
}
