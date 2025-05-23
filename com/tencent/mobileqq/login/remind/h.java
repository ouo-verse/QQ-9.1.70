package com.tencent.mobileqq.login.remind;

import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.Button;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GatewayVerify$Button;
import tencent.im.login.GatewayVerify$RspBody;
import tencent.im.login.GatewayVerify$RspTipsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ$\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/login/remind/h;", "", "", "tlvData", "Ltencent/im/login/GatewayVerify$RspBody;", "g", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "loginResult", "Lcom/tencent/mobileqq/login/remind/h$b;", "loginCallback", "Landroid/app/Dialog;", "c", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e", "<init>", "()V", "a", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f242571a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0019\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/login/remind/h$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface$OnClickListener;", "()Landroid/content/DialogInterface$OnClickListener;", "setListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "listener", "<init>", "(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private DialogInterface.OnClickListener listener;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/login/remind/h$a$a;", "", "Ltencent/im/login/GatewayVerify$Button;", "button", "Lcom/tencent/mobileqq/login/remind/h$b;", "loginCallback", "Lcom/tencent/mobileqq/login/remind/h$a;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/Button;", "j", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.login.remind.h$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes15.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    return;
                }
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void g(b loginCallback, DialogInterface dialogInterface, int i3) {
                Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
                loginCallback.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void h(b loginCallback, String str, DialogInterface dialogInterface, int i3) {
                Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
                loginCallback.c(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void i(b loginCallback, DialogInterface dialogInterface, int i3) {
                Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
                loginCallback.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void k(b loginCallback, DialogInterface dialogInterface, int i3) {
                Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
                loginCallback.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void l(String url, b loginCallback, DialogInterface dialogInterface, int i3) {
                Intrinsics.checkNotNullParameter(url, "$url");
                Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
                if (Intrinsics.areEqual(url, "native://continue_login")) {
                    loginCallback.b();
                } else {
                    loginCallback.c(url);
                }
            }

            @Nullable
            public final a f(@Nullable GatewayVerify$Button button, @NotNull final b loginCallback) {
                String str;
                boolean z16;
                int i3;
                final String str2;
                a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) button, (Object) loginCallback);
                }
                Intrinsics.checkNotNullParameter(loginCallback, "loginCallback");
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (button == null) {
                    return null;
                }
                if (button.str_text.has()) {
                    str = button.str_text.get();
                } else {
                    str = null;
                }
                if (str == null) {
                    return null;
                }
                boolean z17 = true;
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return null;
                }
                if (button.uint32_action.has()) {
                    i3 = button.uint32_action.get();
                } else {
                    i3 = 0;
                }
                if (button.str_jump_url.has()) {
                    str2 = button.str_jump_url.get();
                } else {
                    str2 = null;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return null;
                        }
                        aVar = new a(str, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.e
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i16) {
                                h.a.Companion.i(h.b.this, dialogInterface, i16);
                            }
                        }, defaultConstructorMarker);
                    } else {
                        if (str2 == null) {
                            return null;
                        }
                        if (str2.length() != 0) {
                            z17 = false;
                        }
                        if (z17) {
                            return null;
                        }
                        return new a(str, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.d
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i16) {
                                h.a.Companion.h(h.b.this, str2, dialogInterface, i16);
                            }
                        }, defaultConstructorMarker);
                    }
                } else {
                    aVar = new a(str, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.c
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            h.a.Companion.g(h.b.this, dialogInterface, i16);
                        }
                    }, defaultConstructorMarker);
                }
                return aVar;
            }

            @Nullable
            public final a j(@Nullable Button button, @NotNull final b loginCallback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) button, (Object) loginCallback);
                }
                Intrinsics.checkNotNullParameter(loginCallback, "loginCallback");
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (button == null) {
                    return null;
                }
                String str = button.wording;
                Intrinsics.checkNotNullExpressionValue(str, "button.wording");
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                final String str2 = button.url;
                Intrinsics.checkNotNullExpressionValue(str2, "button.url");
                if (TextUtils.isEmpty(str2)) {
                    return new a(str, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.f
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            h.a.Companion.k(h.b.this, dialogInterface, i3);
                        }
                    }, defaultConstructorMarker);
                }
                return new a(str, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        h.a.Companion.l(str2, loginCallback, dialogInterface, i3);
                    }
                }, defaultConstructorMarker);
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23384);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public /* synthetic */ a(String str, DialogInterface.OnClickListener onClickListener, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, onClickListener);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, this, str, onClickListener, defaultConstructorMarker);
        }

        @NotNull
        public final DialogInterface.OnClickListener a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (DialogInterface.OnClickListener) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.listener;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.text;
        }

        a(String str, DialogInterface.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) onClickListener);
            } else {
                this.text = str;
                this.listener = onClickListener;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/login/remind/h$b;", "", "", "a", "b", "", "url", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void a();

        void b();

        void c(@NotNull String url);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23389);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f242571a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(List buttonHolders, DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(buttonHolders, "$buttonHolders");
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        ((a) buttonHolders.get(2)).a().onClick(dialog1, i3);
        try {
            dialog1.dismiss();
        } catch (Exception unused) {
            QLog.e("LoginDialogUtil", 1, "dismiss dialog error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(List buttonHolders, DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(buttonHolders, "$buttonHolders");
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        ((a) buttonHolders.get(2)).a().onClick(dialog1, i3);
        try {
            dialog1.dismiss();
        } catch (Exception unused) {
            QLog.e("LoginDialogUtil", 1, "dismiss dialog error");
        }
    }

    private final GatewayVerify$RspBody g(byte[] tlvData) {
        if (tlvData == null) {
            QLog.d("LoginDialogUtil", 1, "parseRspBody tlvData is null");
            return null;
        }
        try {
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(tlvData);
            return gatewayVerify$RspBody;
        } catch (Exception e16) {
            QLog.e("LoginDialogUtil", 1, "parseRspBody error: ", e16);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0071 A[Catch: Exception -> 0x0161, TryCatch #0 {Exception -> 0x0161, blocks: (B:13:0x0035, B:15:0x003b, B:20:0x0049, B:22:0x0053, B:23:0x005e, B:25:0x0065, B:30:0x0071, B:32:0x0078, B:33:0x0081, B:35:0x0087, B:38:0x0095, B:43:0x0099, B:45:0x009f, B:47:0x00a6, B:49:0x00ac, B:50:0x0145, B:52:0x00f4, B:54:0x0111, B:55:0x0128, B:57:0x012e, B:60:0x015a), top: B:12:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078 A[Catch: Exception -> 0x0161, TryCatch #0 {Exception -> 0x0161, blocks: (B:13:0x0035, B:15:0x003b, B:20:0x0049, B:22:0x0053, B:23:0x005e, B:25:0x0065, B:30:0x0071, B:32:0x0078, B:33:0x0081, B:35:0x0087, B:38:0x0095, B:43:0x0099, B:45:0x009f, B:47:0x00a6, B:49:0x00ac, B:50:0x0145, B:52:0x00f4, B:54:0x0111, B:55:0x0128, B:57:0x012e, B:60:0x015a), top: B:12:0x0035 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Dialog c(@Nullable QBaseActivity qBaseActivity, @NotNull LoginResult loginResult, @NotNull b loginCallback) {
        boolean z16;
        boolean z17;
        QQCustomDialog createCustomDialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Dialog) iPatchRedirector.redirect((short) 2, this, qBaseActivity, loginResult, loginCallback);
        }
        Intrinsics.checkNotNullParameter(loginResult, "loginResult");
        Intrinsics.checkNotNullParameter(loginCallback, "loginCallback");
        if (qBaseActivity == null) {
            return null;
        }
        try {
            String str = loginResult.rspInfo.tipsContent;
            if (str != null) {
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    String str2 = loginResult.rspInfo.tipsTitle;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = BaseApplication.getContext().getString(R.string.f172151nv4);
                    }
                    String str3 = str2;
                    ArrayList<Button> arrayList = loginResult.rspInfo.msgButton;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z17 = false;
                        if (!z17) {
                            QLog.w("LoginDialogUtil", 1, "buttons is empty");
                            return null;
                        }
                        final ArrayList arrayList2 = new ArrayList();
                        Iterator<Button> it = arrayList.iterator();
                        while (it.hasNext()) {
                            a j3 = a.INSTANCE.j(it.next(), loginCallback);
                            if (j3 != null) {
                                arrayList2.add(j3);
                            }
                        }
                        if (arrayList2.isEmpty()) {
                            QLog.w("LoginDialogUtil", 1, "buttonHolders is empty");
                            return null;
                        }
                        if (arrayList2.size() > 2) {
                            createCustomDialog = DialogUtil.createVerticalThreeBtnDialog(qBaseActivity, 0, str3, str, ((a) arrayList2.get(0)).b(), ((a) arrayList2.get(1)).b(), ((a) arrayList2.get(2)).b(), ((a) arrayList2.get(0)).a(), ((a) arrayList2.get(1)).a(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.a
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    h.d(arrayList2, dialogInterface, i3);
                                }
                            });
                            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createVerticalThreeBtnDi\u2026 }\n                    })");
                        } else {
                            createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230, str3, str, "", "", (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
                            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026l, null\n                )");
                            if (arrayList2.size() > 0) {
                                createCustomDialog.setNegativeButton(((a) arrayList2.get(0)).b(), ((a) arrayList2.get(0)).a());
                            }
                            if (arrayList2.size() > 1) {
                                createCustomDialog.setPositiveButton(((a) arrayList2.get(1)).b(), ((a) arrayList2.get(1)).a());
                            }
                        }
                        createCustomDialog.setMessageWithoutAutoLink(LoginUtil.f306390a.f(str, qBaseActivity, null, qBaseActivity.getResources().getColor(R.color.f156896el)));
                        return createCustomDialog;
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
            }
            QLog.w("LoginDialogUtil", 1, "content is empty");
            return null;
        } catch (Exception e16) {
            QLog.e("LoginDialogUtil", 1, "buildDialogFromTlvData", e16);
            return null;
        }
    }

    @Nullable
    public final Dialog e(@Nullable QBaseActivity activity, @Nullable byte[] tlvData, @NotNull b loginCallback) {
        List<GatewayVerify$Button> list;
        QQCustomDialog createCustomDialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Dialog) iPatchRedirector.redirect((short) 3, this, activity, tlvData, loginCallback);
        }
        Intrinsics.checkNotNullParameter(loginCallback, "loginCallback");
        if (activity == null) {
            return null;
        }
        try {
            GatewayVerify$RspBody g16 = g(tlvData);
            if (g16 == null) {
                return null;
            }
            GatewayVerify$RspTipsInfo gatewayVerify$RspTipsInfo = g16.msg_rsp_tips_info.get();
            int i3 = gatewayVerify$RspTipsInfo.uint32_scene_id.get();
            if (i3 != 5) {
                QLog.e("LoginDialogUtil", 1, "sceneId=" + i3);
                return null;
            }
            String str = gatewayVerify$RspTipsInfo.str_content.get();
            String str2 = gatewayVerify$RspTipsInfo.str_title.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (gatewayVerify$RspTipsInfo.msg_buttons.has()) {
                    list = gatewayVerify$RspTipsInfo.msg_buttons.get();
                } else {
                    QLog.d("LoginDialogUtil", 1, "use left_button and right_button");
                    ArrayList arrayList = new ArrayList();
                    GatewayVerify$Button gatewayVerify$Button = gatewayVerify$RspTipsInfo.msg_left_button;
                    Intrinsics.checkNotNullExpressionValue(gatewayVerify$Button, "rspTipsInfo.msg_left_button");
                    arrayList.add(gatewayVerify$Button);
                    GatewayVerify$Button gatewayVerify$Button2 = gatewayVerify$RspTipsInfo.msg_right_button;
                    Intrinsics.checkNotNullExpressionValue(gatewayVerify$Button2, "rspTipsInfo.msg_right_button");
                    arrayList.add(gatewayVerify$Button2);
                    list = arrayList;
                }
                if (list != null && !list.isEmpty()) {
                    final ArrayList arrayList2 = new ArrayList();
                    Iterator<GatewayVerify$Button> it = list.iterator();
                    while (it.hasNext()) {
                        a f16 = a.INSTANCE.f(it.next(), loginCallback);
                        if (f16 != null) {
                            arrayList2.add(f16);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        QLog.e("LoginDialogUtil", 1, "buttonHolders is empty");
                        return null;
                    }
                    if (arrayList2.size() > 2) {
                        createCustomDialog = DialogUtil.createVerticalThreeBtnDialog(activity, 0, str2, str, ((a) arrayList2.get(0)).b(), ((a) arrayList2.get(1)).b(), ((a) arrayList2.get(2)).b(), ((a) arrayList2.get(0)).a(), ((a) arrayList2.get(1)).a(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.b
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i16) {
                                h.f(arrayList2, dialogInterface, i16);
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createVerticalThreeBtnDi\u2026      }\n                }");
                    } else {
                        createCustomDialog = DialogUtil.createCustomDialog(activity, 230, str2, str, "", "", (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
                        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026l, null\n                )");
                        if (arrayList2.size() > 0) {
                            createCustomDialog.setNegativeButton(((a) arrayList2.get(0)).b(), ((a) arrayList2.get(0)).a());
                        }
                        if (arrayList2.size() > 1) {
                            createCustomDialog.setPositiveButton(((a) arrayList2.get(1)).b(), ((a) arrayList2.get(1)).a());
                        }
                    }
                    createCustomDialog.setMessageWithoutAutoLink(LoginUtil.f306390a.f(str, activity, null, activity.getResources().getColor(R.color.f156896el)));
                    return createCustomDialog;
                }
                QLog.e("LoginDialogUtil", 1, "buttons is empty");
                return null;
            }
            QLog.e("LoginDialogUtil", 1, "content:" + str + ", title:" + str2);
            return null;
        } catch (Exception e16) {
            QLog.e("LoginDialogUtil", 1, "buildDialogFromTlvData", e16);
            return null;
        }
    }
}
