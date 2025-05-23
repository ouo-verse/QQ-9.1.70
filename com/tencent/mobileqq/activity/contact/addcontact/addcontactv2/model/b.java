package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/b;", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;", "a", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;", "b", "()Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;", "titleItem", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/c;", "Ljava/util/List;", "()Ljava/util/List;", "dataItems", "<init>", "(Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;Ljava/util/List;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e titleItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> dataItems;

    public b(@NotNull e titleItem, @NotNull List<c> dataItems) {
        Intrinsics.checkNotNullParameter(titleItem, "titleItem");
        Intrinsics.checkNotNullParameter(dataItems, "dataItems");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) titleItem, (Object) dataItems);
        } else {
            this.titleItem = titleItem;
            this.dataItems = dataItems;
        }
    }

    @NotNull
    public final List<c> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.dataItems;
    }

    @NotNull
    public final e b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.titleItem;
    }
}
