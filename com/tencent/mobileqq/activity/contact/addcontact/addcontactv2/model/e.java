package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/f;", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "c", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "b", "()Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "dataType", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "title", "<init>", "(Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AddContactDataType dataType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull AddContactDataType dataType, @NotNull String title) {
        super(1, null);
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        Intrinsics.checkNotNullParameter(title, "title");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dataType, (Object) title);
        } else {
            this.dataType = dataType;
            this.title = title;
        }
    }

    @NotNull
    public final AddContactDataType b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AddContactDataType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataType;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.title;
    }
}
