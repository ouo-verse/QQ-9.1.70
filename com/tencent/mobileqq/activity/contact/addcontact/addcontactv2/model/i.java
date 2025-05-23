package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model;

import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\f\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;", "", "", "toString", "", "a", "[B", "()[B", "groupSession", "b", "d", "personSession", "c", "guildSession", "peerSession", "<init>", "([B[B[B[B)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] groupSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] personSession;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] guildSession;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] peerSession;

    public i(@NotNull byte[] groupSession, @NotNull byte[] personSession, @NotNull byte[] guildSession, @NotNull byte[] peerSession) {
        Intrinsics.checkNotNullParameter(groupSession, "groupSession");
        Intrinsics.checkNotNullParameter(personSession, "personSession");
        Intrinsics.checkNotNullParameter(guildSession, "guildSession");
        Intrinsics.checkNotNullParameter(peerSession, "peerSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, groupSession, personSession, guildSession, peerSession);
            return;
        }
        this.groupSession = groupSession;
        this.personSession = personSession;
        this.guildSession = guildSession;
        this.peerSession = peerSession;
    }

    @NotNull
    public final byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groupSession;
    }

    @NotNull
    public final byte[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.guildSession;
    }

    @NotNull
    public final byte[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.peerSession;
    }

    @NotNull
    public final byte[] d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.personSession;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "[groupSession: " + PluginBaseInfoHelper.Base64Helper.encodeToString(this.groupSession, 0) + ", personSession: " + PluginBaseInfoHelper.Base64Helper.encodeToString(this.personSession, 0) + ", guildSession: " + PluginBaseInfoHelper.Base64Helper.encodeToString(this.guildSession, 0) + ", peerSession: " + PluginBaseInfoHelper.Base64Helper.encodeToString(this.peerSession, 0) + "]";
    }
}
