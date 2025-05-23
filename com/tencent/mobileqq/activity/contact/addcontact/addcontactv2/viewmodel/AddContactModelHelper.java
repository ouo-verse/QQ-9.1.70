package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel;

import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002*\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactModelHelper;", "", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/f;", "", "id", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "b", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/c;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactModelHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AddContactModelHelper f180979a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50166);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f180979a = new AddContactModelHelper();
        }
    }

    AddContactModelHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> a(@NotNull List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list, @NotNull final String id5, @NotNull final AddContactDataType type) {
        List mutableList;
        List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, list, id5, type);
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c, Boolean>(id5, type) { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactModelHelper$removeItem$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $id;
            final /* synthetic */ AddContactDataType $type;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$id = id5;
                this.$type = type;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) id5, (Object) type);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.b(this.$id, this.$type));
            }
        });
        list2 = CollectionsKt___CollectionsKt.toList(mutableList);
        return list2;
    }

    @NotNull
    public final List<f> b(@NotNull List<? extends f> list, @NotNull final String id5, @NotNull final AddContactDataType type) {
        List mutableList;
        List<f> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, list, id5, type);
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<f, Boolean>(id5, type) { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactModelHelper$removeUIItem$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $id;
            final /* synthetic */ AddContactDataType $type;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$id = id5;
                this.$type = type;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) id5, (Object) type);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull f it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar = it instanceof com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c ? (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) it : null;
                boolean z16 = false;
                if (cVar != null && cVar.b(this.$id, this.$type)) {
                    z16 = true;
                }
                return Boolean.valueOf(z16);
            }
        });
        list2 = CollectionsKt___CollectionsKt.toList(mutableList);
        return list2;
    }
}
