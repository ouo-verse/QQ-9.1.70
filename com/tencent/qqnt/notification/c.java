package com.tencent.qqnt.notification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJF\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n26\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u000eJP\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u000726\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016R&\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010!R#\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0 0#8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/notification/c;", "", "", "b", "", "category", h.F, "", "f", "", "Lcom/tencent/qqnt/notification/f;", "dataList", "a", "msg", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "onRemove", "g", "newMsg", "needFilterUnDeal", "onUpdate", "i", "", "oldestUnreadSeq", "k", "d", "c", "", "toString", "", "", "Ljava/util/Map;", "notificationMap", "", "e", "()Ljava/util/Map;", "data", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, List<f>> notificationMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/notification/c$a;", "", "", "b", "", "Lcom/tencent/qqnt/notification/f;", "dataList", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.c$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final f c(@Nullable List<f> dataList, @NotNull f old, @NotNull f r95) {
            int indexOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (f) iPatchRedirector.redirect((short) 2, this, dataList, old, r95);
            }
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r95, "new");
            if (dataList == null || (indexOf = dataList.indexOf(old)) < 0) {
                return null;
            }
            if (r95.c() != old.c()) {
                f a16 = r95.a(old.c());
                dataList.set(indexOf, a16);
                return a16;
            }
            dataList.set(indexOf, r95);
            return r95;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b() {
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62385);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.notificationMap = new LinkedHashMap();
        }
    }

    public static /* synthetic */ void j(c cVar, f fVar, boolean z16, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        cVar.i(fVar, z16, function2);
    }

    public final void a(int category, @NotNull List<f> dataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, category, (Object) dataList);
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        INSTANCE.b();
        List<f> list = this.notificationMap.get(Integer.valueOf(category));
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(dataList);
        this.notificationMap.put(Integer.valueOf(category), list);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            INSTANCE.b();
            this.notificationMap.clear();
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            INSTANCE.b();
            Iterator<Map.Entry<Integer, List<f>>> it = this.notificationMap.entrySet().iterator();
            while (it.hasNext()) {
                List<f> value = it.next().getValue();
                ArrayList arrayList = new ArrayList();
                for (f fVar : value) {
                    if (fVar.f()) {
                        arrayList.add(fVar);
                    }
                }
                value.removeAll(arrayList);
            }
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            INSTANCE.b();
            List<f> list = this.notificationMap.get(1);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (f fVar : list) {
                if (!d.f359818a.a(fVar.j())) {
                    arrayList.add(fVar);
                }
            }
            list.removeAll(arrayList);
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @NotNull
    public final Map<Integer, List<f>> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            INSTANCE.b();
            return this.notificationMap;
        }
        return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Iterator<Map.Entry<Integer, List<f>>> it = this.notificationMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final void g(@NotNull f msg2, @NotNull Function2<? super Integer, ? super f, Unit> onRemove) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) msg2, (Object) onRemove);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(onRemove, "onRemove");
        INSTANCE.b();
        for (Map.Entry<Integer, List<f>> entry : this.notificationMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            List<f> value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            for (f fVar : value) {
                if (fVar.j().seq == msg2.j().seq) {
                    arrayList.add(fVar);
                    onRemove.invoke(Integer.valueOf(intValue), fVar);
                }
            }
            value.removeAll(arrayList);
        }
    }

    public final void h(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            INSTANCE.b();
            this.notificationMap.put(Integer.valueOf(category), new ArrayList());
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, category);
    }

    public final void i(@NotNull f newMsg, boolean needFilterUnDeal, @NotNull Function2<? super Integer, ? super f, Unit> onUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, newMsg, Boolean.valueOf(needFilterUnDeal), onUpdate);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsg, "newMsg");
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        INSTANCE.b();
        for (Map.Entry<Integer, List<f>> entry : this.notificationMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            List<f> value = entry.getValue();
            for (f fVar : value) {
                if (fVar.j().seq == newMsg.j().seq) {
                    INSTANCE.c(value, fVar, newMsg);
                    onUpdate.invoke(Integer.valueOf(intValue), fVar);
                }
            }
        }
        if (needFilterUnDeal) {
            d();
        }
    }

    public final void k(long oldestUnreadSeq) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            INSTANCE.b();
            Iterator<Map.Entry<Integer, List<f>>> it = this.notificationMap.entrySet().iterator();
            while (it.hasNext()) {
                for (f fVar : it.next().getValue()) {
                    if (fVar.j().seq <= oldestUnreadSeq) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    fVar.o(z16);
                }
            }
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, oldestUnreadSeq);
    }

    @NotNull
    public String toString() {
        Integer num;
        Integer num2;
        Integer num3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        List<f> list = this.notificationMap.get(0);
        Integer num4 = null;
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        List<f> list2 = this.notificationMap.get(1);
        if (list2 != null) {
            num2 = Integer.valueOf(list2.size());
        } else {
            num2 = null;
        }
        List<f> list3 = this.notificationMap.get(2);
        if (list3 != null) {
            num3 = Integer.valueOf(list3.size());
        } else {
            num3 = null;
        }
        List<f> list4 = this.notificationMap.get(-1000);
        if (list4 != null) {
            num4 = Integer.valueOf(list4.size());
        }
        return "TroopNotificationCacheInfo(all=" + num + ", undeal=" + num2 + ", exit=" + num3 + ", doubt=" + num4 + ")";
    }
}
