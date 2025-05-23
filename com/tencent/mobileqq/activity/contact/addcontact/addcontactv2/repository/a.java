package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository;

import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0005R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/repository/a;", "", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/g;", "list", "", "a", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/c;", "c", "b", "Ljava/util/List;", "addContactList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f180891a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<g> addContactList;

    static {
        List<g> emptyList;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49827);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f180891a = new a();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        addContactList = emptyList;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull List<g> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "list");
            addContactList = list;
        }
    }

    public final void b() {
        List<g> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            addContactList = emptyList;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @NotNull
    public final List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> c(@NotNull AddContactDataType type) {
        Object obj;
        List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> emptyList;
        List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> c16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Iterator<T> it = addContactList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((g) obj).d().b() == type) {
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
        g gVar = (g) obj;
        if (gVar == null || (c16 = gVar.c()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return c16;
    }
}
