package com.tencent.mobileqq.troop.homework.clockin.time.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/b;", "Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/d;", "", "c", "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$b;", "b", "", "", "selectItems", "", "e", "", "Ljava/util/List;", "dayCountIntList", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> dayCountIntList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/b$a;", "", "", "MAX_DAY_COUNT", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.time.repo.b$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.dayCountIntList = new ArrayList();
        for (int i3 = 1; i3 < 31; i3++) {
            this.dayCountIntList.add(Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.time.repo.d
    @NotNull
    public a.b b() {
        int indexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it = this.dayCountIntList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().intValue() + "\u5929");
        }
        arrayList.add(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        int size = this.dayCountIntList.size() - 1;
        com.tencent.mobileqq.troop.homework.clockin.time.data.a d16 = d();
        if (d16 != null && (indexOf = this.dayCountIntList.indexOf(Integer.valueOf(d16.e()))) != -1) {
            size = indexOf;
        }
        arrayList3.add(Integer.valueOf(size));
        return new a.b("\u6253\u5361\u5468\u671f", arrayList, arrayList3);
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.time.repo.d
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.troop.homework.clockin.time.data.a d16 = d();
        if (d16 != null) {
            return d16.e() + "\u5929";
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.time.repo.d
    public void e(@NotNull List<Integer> selectItems) {
        com.tencent.mobileqq.troop.homework.clockin.time.data.a d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) selectItems);
            return;
        }
        Intrinsics.checkNotNullParameter(selectItems, "selectItems");
        if ((!selectItems.isEmpty()) && selectItems.get(0).intValue() < this.dayCountIntList.size() && (d16 = d()) != null) {
            d16.h(this.dayCountIntList.get(selectItems.get(0).intValue()).intValue());
        }
    }
}
