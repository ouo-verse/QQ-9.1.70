package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/AddContactItemDeleteEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "id", "", "type", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "(Ljava/lang/String;Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class AddContactItemDeleteEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String id;

    @NotNull
    private final AddContactDataType type;

    public AddContactItemDeleteEvent(@NotNull String id5, @NotNull AddContactDataType type) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) id5, (Object) type);
        } else {
            this.id = id5;
            this.type = type;
        }
    }

    @NotNull
    public final String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.id;
    }

    @NotNull
    public final AddContactDataType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AddContactDataType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.type;
    }
}
