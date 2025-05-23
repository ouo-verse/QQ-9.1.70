package com.tencent.mobileqq.sharepanel.channel.param;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.channel.handler.f;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/param/a;", "Lcom/tencent/mobileqq/sharepanel/channel/handler/f;", "Landroid/content/Intent;", "a", "Landroid/content/Intent;", "b", "()Landroid/content/Intent;", "forwardIntent", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "()Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "contact", "<init>", "(Landroid/content/Intent;Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Intent forwardIntent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final SharePanelContactItem contact;

    public a(@Nullable Intent intent, @Nullable SharePanelContactItem sharePanelContactItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent, (Object) sharePanelContactItem);
        } else {
            this.forwardIntent = intent;
            this.contact = sharePanelContactItem;
        }
    }

    @Nullable
    public final SharePanelContactItem a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharePanelContactItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.contact;
    }

    @Nullable
    public final Intent b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.forwardIntent;
    }
}
