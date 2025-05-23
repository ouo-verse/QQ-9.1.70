package com.tencent.mobileqq.nt.msgpush.troop;

import com.tencent.mobileqq.nt.msgpush.factory.e;
import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.c;
import com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/b;", "Lcom/tencent/mobileqq/nt/msgpush/factory/e;", "", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "a", "()Ljava/util/List;", "processorList", "Lcom/tencent/mobileqq/nt/msgpush/factory/d;", "c", "()Lcom/tencent/mobileqq/nt/msgpush/factory/d;", "businessDataConvertor", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f254434a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59431);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f254434a = new a(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.e
    @NotNull
    public List<f> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.a());
        arrayList.add(new com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.a());
        arrayList.add(new c());
        arrayList.add(new d());
        arrayList.add(new com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo.b());
        arrayList.add(new com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo.c());
        arrayList.add(new com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo.a());
        arrayList.add(new com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.b());
        arrayList.add(new com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo.e());
        arrayList.add(new com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo.d());
        return arrayList;
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.e
    public void b(@NotNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
        } else {
            e.a.a(this, bArr);
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.e
    @NotNull
    public com.tencent.mobileqq.nt.msgpush.factory.d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.nt.msgpush.factory.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.mobileqq.nt.msgpush.troop.a();
    }
}
