package com.tencent.mobileqq.notification.modularize.business;

import android.content.Intent;
import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/business/a;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "", ZPlanPublishSource.FROM_SCHEME, "k", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushComponent", "Landroid/content/Intent;", "b", "", "j", "<init>", "()V", "c", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a extends BaseJumpScheme {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/business/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.notification.modularize.business.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes8.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59339);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String k(String scheme) {
        String replace$default;
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        QLog.d("AudioRoomScheme", 2, "before modify scheme: " + scheme);
        replace$default = StringsKt__StringsJVMKt.replace$default(scheme, "mqqapi://now/audioroom", "mqqapi://now/openroom", false, 4, (Object) null);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) replace$default, (CharSequence) ISchemeApi.KEY_IOS_SRC_TYPE, false, 2, (Object) null);
        if (!contains$default) {
            replace$default = replace$default + "&src_type=app";
        }
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) replace$default, (CharSequence) "version", false, 2, (Object) null);
        if (!contains$default2) {
            replace$default = replace$default + "&version=1";
        }
        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) replace$default, (CharSequence) "fromid", false, 2, (Object) null);
        if (!contains$default3) {
            replace$default = replace$default + "&fromid=10026";
        }
        contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) replace$default, (CharSequence) "roomtype", false, 2, (Object) null);
        if (!contains$default4) {
            replace$default = replace$default + "&roomtype=10001";
        }
        QLog.d("AudioRoomScheme", 2, "after modify: " + replace$default);
        return replace$default;
    }

    @Override // com.tencent.mobileqq.notification.modularize.BaseJumpScheme
    @NotNull
    protected Intent b(@NotNull f pushComponent) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pushComponent);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pushComponent.jumpScheme, "mqqapi://now/audioroom", false, 2, null);
        if (startsWith$default) {
            pushComponent.jumpScheme = k(pushComponent.jumpScheme);
        }
        return f(pushComponent);
    }

    @Override // com.tencent.mobileqq.notification.modularize.BaseJumpScheme
    protected boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
