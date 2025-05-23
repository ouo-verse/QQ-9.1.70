package com.tencent.mobileqq.aio.msglist.holder.component.template.business;

import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u001a\u0010\rR$\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u0019\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "appName", "b", "setBizName", "bizName", "c", "f", "setViewName", "viewName", "d", "g", "dataString", "e", "setCustomTemplateString", "customTemplateString", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "()Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "setMsgItem", "(Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;)V", "msgItem", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String bizName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String viewName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String dataString;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String customTemplateString;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TemplateMsgItem msgItem;

    public f(@NotNull String appName, @NotNull String bizName, @NotNull String viewName, @NotNull String dataString, @Nullable String str, @Nullable TemplateMsgItem templateMsgItem) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        Intrinsics.checkNotNullParameter(dataString, "dataString");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appName, bizName, viewName, dataString, str, templateMsgItem);
            return;
        }
        this.appName = appName;
        this.bizName = bizName;
        this.viewName = viewName;
        this.dataString = dataString;
        this.customTemplateString = str;
        this.msgItem = templateMsgItem;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appName;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bizName;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.customTemplateString;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.dataString;
    }

    @Nullable
    public final TemplateMsgItem e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (TemplateMsgItem) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.msgItem;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (Intrinsics.areEqual(this.appName, fVar.appName) && Intrinsics.areEqual(this.bizName, fVar.bizName) && Intrinsics.areEqual(this.viewName, fVar.viewName) && Intrinsics.areEqual(this.dataString, fVar.dataString) && Intrinsics.areEqual(this.customTemplateString, fVar.customTemplateString) && Intrinsics.areEqual(this.msgItem, fVar.msgItem)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.viewName;
    }

    public final void g(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.dataString = str;
        }
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        int hashCode2 = ((((((this.appName.hashCode() * 31) + this.bizName.hashCode()) * 31) + this.viewName.hashCode()) * 31) + this.dataString.hashCode()) * 31;
        String str = this.customTemplateString;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        TemplateMsgItem templateMsgItem = this.msgItem;
        if (templateMsgItem != null) {
            i3 = templateMsgItem.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "TemplateMsgParseParams(appName=" + this.appName + ", bizName=" + this.bizName + ", viewName=" + this.viewName + ", dataString=" + this.dataString + ", customTemplateString=" + this.customTemplateString + ", msgItem=" + this.msgItem + ")";
    }

    public /* synthetic */ f(String str, String str2, String str3, String str4, String str5, TemplateMsgItem templateMsgItem, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : templateMsgItem);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, templateMsgItem, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
