package com.tencent.mobileqq.activity.home.chats.anim;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.anim.IUnitedAnimSetter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.chats.main.vm.usecase.click.c;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/anim/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/c;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "invoke", "", PushClientConstants.TAG_CLASS_NAME, "", "a", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/anim/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.chats.anim.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/activity/home/chats/anim/a$b", "Lcom/tencent/mobileqq/app/anim/IUnitedAnimSetter;", "Landroid/content/Intent;", "intent", "", "beforeStartActivity", "afterStartActivity", "afterFinishActivity", "", "a", "Ljava/lang/String;", "getComponentName", "()Ljava/lang/String;", "setComponentName", "(Ljava/lang/String;)V", "componentName", "", "b", "Z", "isSubclassOfQBaseActivity", "()Z", "setSubclassOfQBaseActivity", "(Z)V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements IUnitedAnimSetter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String componentName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isSubclassOfQBaseActivity;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f182872d;

        b(Context context) {
            this.f182872d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) context);
            } else {
                this.componentName = "";
            }
        }

        @Override // com.tencent.mobileqq.app.anim.IUnitedAnimSetter
        public void afterFinishActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.anim.IUnitedAnimSetter
        public void afterStartActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            QLog.d("UnitedAnimUseCase", 1, "use united enter anim, isSubclassOfQBaseActivity=" + this.isSubclassOfQBaseActivity + " className=" + this.componentName);
            if (!this.isSubclassOfQBaseActivity) {
                Context context = this.f182872d;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.mobileqq.app.anim.b.c("aio", (Activity) context);
            }
            ((QBaseActivity) this.f182872d).setUnitedAnimSetter(null);
        }

        @Override // com.tencent.mobileqq.app.anim.IUnitedAnimSetter
        public void beforeStartActivity(@NotNull Intent intent) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            ComponentName component = intent.getComponent();
            String str2 = null;
            if (component != null) {
                str = component.getClassName();
            } else {
                str = null;
            }
            if (str == null) {
                str = "(null)";
            }
            this.componentName = str;
            a aVar = a.this;
            ComponentName component2 = intent.getComponent();
            if (component2 != null) {
                str2 = component2.getClassName();
            }
            if (aVar.a(str2)) {
                this.isSubclassOfQBaseActivity = true;
                com.tencent.mobileqq.app.anim.b.a(intent, "aio");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21673);
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

    public final boolean a(@Nullable String className) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) className)).booleanValue();
        }
        if (className == null) {
            return false;
        }
        try {
            return QBaseActivity.class.isAssignableFrom(Class.forName(className));
        } catch (Throwable th5) {
            QLog.w("UnitedAnimUseCase", 1, "[isSubclassOfQBaseActivity] class=" + className + " exc=" + th5);
            return false;
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.c
    public void invoke(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Context context = params.c().getContext();
        if (context instanceof QBaseActivity) {
            ((QBaseActivity) context).setUnitedAnimSetter(new b(context));
        }
    }
}
