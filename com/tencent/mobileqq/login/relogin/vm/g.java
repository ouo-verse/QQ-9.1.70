package com.tencent.mobileqq.login.relogin.vm;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.fragment.l;
import com.tencent.mobileqq.login.u;
import com.tencent.mobileqq.loginregister.w;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import common.config.service.QzoneConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ2\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0012J\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\rR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/vm/g;", "Landroidx/lifecycle/ViewModel;", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "e2", "i2", "Lcom/tencent/mobileqq/login/account/a;", "account", "f2", "", "uin", "", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "X1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "clearHistory", "Lkotlin/Function1;", "callback", "R1", "U1", "d2", "needConfirm", "g2", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/login/relogin/vm/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "Z1", "()Landroidx/lifecycle/MutableLiveData;", "accountInfoData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "c2", "()Z", SemanticAttributes.DbSystemValues.H2, "(Z)V", "privacyState", "Lcom/tencent/mobileqq/loginregister/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/loginregister/a;", "accountChangeObserver", "<init>", "()V", "D", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.loginregister.a accountChangeObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<a> accountInfoData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean privacyState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/vm/g$a;", "", "", "KEY_DELETE_PWD_NEED_CONFIRM", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.relogin.vm.g$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23351);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.accountInfoData = new MutableLiveData<>();
            this.accountChangeObserver = new com.tencent.mobileqq.loginregister.a() { // from class: com.tencent.mobileqq.login.relogin.vm.b
                @Override // com.tencent.mobileqq.loginregister.a
                public final void accountChange() {
                    g.Q1(g.this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(com.tencent.mobileqq.login.account.a account, boolean z16, Activity activity, g this$0, final Function1 callback) {
        String str;
        com.tencent.mobileqq.login.account.a b16;
        w h16;
        Intrinsics.checkNotNullParameter(account, "$account");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        final String f16 = account.f();
        QLog.i("ReLoginAccountManageVM", 1, "deleteAccount uin=" + f16 + " clearHistory=" + z16);
        String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
        if (lastLoginUin != null && Intrinsics.areEqual(lastLoginUin, f16)) {
            MobileQQ.sMobileQQ.setLastLoginUin("");
        }
        if ((activity instanceof QBaseActivity) && (h16 = l.f242160a.h()) != null) {
            h16.h((QBaseActivity) activity, f16, z16);
        }
        List<com.tencent.mobileqq.login.account.a> f17 = com.tencent.mobileqq.login.account.d.f241848a.f();
        a value = this$0.accountInfoData.getValue();
        Object obj = null;
        if (value != null && (b16 = value.b()) != null) {
            str = b16.f();
        } else {
            str = null;
        }
        for (com.tencent.mobileqq.login.account.a aVar : f17) {
            if (Intrinsics.areEqual(aVar.f(), str)) {
                obj = aVar;
            }
        }
        if (obj == null) {
            obj = CollectionsKt___CollectionsKt.getOrNull(f17, 0);
        }
        this$0.accountInfoData.postValue(new a((com.tencent.mobileqq.login.account.a) obj, f17));
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.vm.e
            @Override // java.lang.Runnable
            public final void run() {
                g.T1(Function1.this, f16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(Function1 callback, String uin) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        callback.invoke(uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(com.tencent.mobileqq.login.account.a account, Activity activity, g this$0) {
        com.tencent.mobileqq.login.account.a aVar;
        List<com.tencent.mobileqq.login.account.a> emptyList;
        w h16;
        Intrinsics.checkNotNullParameter(account, "$account");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ReLoginAccountManageVM", 1, "deletePassword uin=" + account.f());
        account.h(false);
        MsfSdkUtils.updateSimpleAccountNotCreate(account.f(), false);
        MobileQQ.sMobileQQ.refreAccountList();
        if ((activity instanceof QBaseActivity) && (h16 = l.f242160a.h()) != null) {
            h16.l((QBaseActivity) activity, account.f());
        }
        a value = this$0.accountInfoData.getValue();
        if (value != null) {
            aVar = value.b();
        } else {
            aVar = null;
        }
        a value2 = this$0.accountInfoData.getValue();
        if (value2 == null || (emptyList = value2.a()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this$0.accountInfoData.postValue(new a(aVar, emptyList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(g this$0) {
        Object orNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<com.tencent.mobileqq.login.account.a> f16 = com.tencent.mobileqq.login.account.d.f241848a.f();
        boolean z16 = false;
        orNull = CollectionsKt___CollectionsKt.getOrNull(f16, 0);
        String c16 = j.c();
        if (c16 == null || c16.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            for (com.tencent.mobileqq.login.account.a aVar : f16) {
                if (Intrinsics.areEqual(c16, aVar.f())) {
                    orNull = aVar;
                }
            }
        }
        this$0.accountInfoData.postValue(new a((com.tencent.mobileqq.login.account.a) orNull, f16));
    }

    public final void R1(@NotNull final Activity activity, @NotNull final com.tencent.mobileqq.login.account.a account, final boolean clearHistory, @NotNull final Function1<? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, account, Boolean.valueOf(clearHistory), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.vm.d
            @Override // java.lang.Runnable
            public final void run() {
                g.S1(com.tencent.mobileqq.login.account.a.this, clearHistory, activity, this, callback);
            }
        }, 16, null, true);
    }

    public final void U1(@NotNull final Activity activity, @NotNull final com.tencent.mobileqq.login.account.a account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity, (Object) account);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.vm.f
            @Override // java.lang.Runnable
            public final void run() {
                g.W1(com.tencent.mobileqq.login.account.a.this, activity, this);
            }
        }, 16, null, true);
    }

    public final boolean X1(@NotNull String uin, int entrance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) uin, entrance)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!this.privacyState) {
            return false;
        }
        u.p(uin, entrance, false, null);
        return true;
    }

    @NotNull
    public final MutableLiveData<a> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.accountInfoData;
    }

    public final void a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.vm.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.b2(g.this);
                }
            }, 16, null, true);
        }
    }

    public final boolean c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.privacyState;
    }

    public final boolean d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        return from.decodeBool("login_delete_pwd_need_confirm", true);
    }

    public final void e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.mobileqq.login.account.d.f241848a.c(this.accountChangeObserver);
        }
    }

    public final void f2(@NotNull com.tencent.mobileqq.login.account.a account) {
        List<com.tencent.mobileqq.login.account.a> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) account);
            return;
        }
        Intrinsics.checkNotNullParameter(account, "account");
        a value = this.accountInfoData.getValue();
        if (value == null || (emptyList = value.a()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.accountInfoData.postValue(new a(account, emptyList));
        j.e(account.f());
    }

    public final void g2(boolean needConfirm) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, needConfirm);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        from.encodeBool("login_delete_pwd_need_confirm", needConfirm);
    }

    public final void h2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.privacyState = z16;
        }
    }

    public final void i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.mobileqq.login.account.d.f241848a.m(this.accountChangeObserver);
        }
    }
}
