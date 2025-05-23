package com.tencent.mobileqq.pushdialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.data.e;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\rB\u001f\b\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b$\u0010%J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u001aR\u001a\u0010 \u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010#\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/pushdialog/NTHttpMqqJumper;", "", "", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "", WadlProxyConsts.KEY_JUMP_URL, h.F, "Lcom/tencent/aio/data/AIOSession;", SessionDbHelper.SESSION_ID, "i", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/app/QQAppInterface;", "b", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "c", "Ljava/lang/String;", "mJumpUrl", "d", "Lcom/tencent/aio/data/AIOSession;", "", "()Z", "isHttpSchema$annotations", "()V", "isHttpSchema", "e", "isJubaoLink$annotations", "isJubaoLink", "f", "isMqqSchema$annotations", "isMqqSchema", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class NTHttpMqqJumper {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QQAppInterface mApp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mJumpUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOSession session;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/pushdialog/NTHttpMqqJumper$a;", "", "", "HTTPS_PREFIX", "Ljava/lang/String;", "HTTP_PREFIX", "JUBAO_PREFIX", "MQQ_PREFIX", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pushdialog.NTHttpMqqJumper$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public NTHttpMqqJumper(@Nullable Context context, @Nullable QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) qQAppInterface);
        } else {
            this.mContext = context;
            this.mApp = qQAppInterface;
        }
    }

    private final boolean d() {
        boolean startsWith$default;
        boolean startsWith$default2;
        String str = this.mJumpUrl;
        Intrinsics.checkNotNull(str);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "http://", false, 2, null);
        if (!startsWith$default) {
            String str2 = this.mJumpUrl;
            Intrinsics.checkNotNull(str2);
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
            String lowerCase2 = str2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(lowerCase2, "https://", false, 2, null);
            if (!startsWith$default2) {
                return false;
            }
        }
        return true;
    }

    private final boolean e() {
        boolean startsWith$default;
        String str = this.mJumpUrl;
        Intrinsics.checkNotNull(str);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "mqq://jubao.qq.com", false, 2, null);
        return startsWith$default;
    }

    private final boolean f() {
        boolean startsWith$default;
        String str = this.mJumpUrl;
        Intrinsics.checkNotNull(str);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "mqq://", false, 2, null);
        return startsWith$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|(1:(3:10|11|12)(2:29|30))(2:31|(2:49|50)(2:38|(2:40|41)(4:42|(1:44)|45|(1:47)(1:48))))|13|14|(6:16|(2:19|17)|20|21|(1:23)|24)|26|27))|53|6|7|(0)(0)|13|14|(0)|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0041, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01b1, code lost:
    
        com.tencent.qphone.base.util.QLog.e("HttpMqqJumper", 1, "openMoreOptions safetyReport error" + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010b A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:11:0x0039, B:14:0x00ff, B:16:0x010b, B:17:0x0124, B:19:0x012a, B:21:0x0138, B:23:0x016a, B:24:0x0188, B:42:0x0092, B:44:0x00a0, B:45:0x00be), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(Continuation<? super Unit> continuation) {
        NTHttpMqqJumper$violationReport$1 nTHttpMqqJumper$violationReport$1;
        Object coroutine_suspended;
        int i3;
        AIOSession aIOSession;
        String valueOf;
        String uinCode;
        NTHttpMqqJumper nTHttpMqqJumper;
        e eVar;
        int collectionSizeOrDefault;
        if (continuation instanceof NTHttpMqqJumper$violationReport$1) {
            nTHttpMqqJumper$violationReport$1 = (NTHttpMqqJumper$violationReport$1) continuation;
            int i16 = nTHttpMqqJumper$violationReport$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTHttpMqqJumper$violationReport$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTHttpMqqJumper$violationReport$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTHttpMqqJumper$violationReport$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        String str = (String) nTHttpMqqJumper$violationReport$1.L$2;
                        valueOf = (String) nTHttpMqqJumper$violationReport$1.L$1;
                        NTHttpMqqJumper nTHttpMqqJumper2 = (NTHttpMqqJumper) nTHttpMqqJumper$violationReport$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        nTHttpMqqJumper = nTHttpMqqJumper2;
                        uinCode = str;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QQAppInterface qQAppInterface = this.mApp;
                    Intrinsics.checkNotNull(qQAppInterface);
                    ag uixConvertService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getUixConvertService();
                    if ((this.mContext instanceof QBaseActivity) && (aIOSession = this.session) != null && this.mApp != null && uixConvertService != null) {
                        Intrinsics.checkNotNull(aIOSession);
                        valueOf = String.valueOf(uixConvertService.z0(aIOSession.c().j()));
                        if (TextUtils.isEmpty(valueOf)) {
                            return Unit.INSTANCE;
                        }
                        String j3 = NewReportPlugin.j(valueOf, NewReportPlugin.p(2));
                        if (QLog.isColorLevel()) {
                            QLog.i("HttpMqqJumper", 2, "openMoreOptions uin:" + valueOf + " uinCode:" + j3);
                        }
                        AIOSession aIOSession2 = this.session;
                        Intrinsics.checkNotNull(aIOSession2);
                        AIOContact c16 = aIOSession2.c();
                        Flow<e> msgList = ((IMsgService) QRoute.api(IMsgService.class)).getMsgList(new Contact(c16.a(), c16.b(), c16.c()), 0L, 10, true);
                        nTHttpMqqJumper$violationReport$1.L$0 = this;
                        nTHttpMqqJumper$violationReport$1.L$1 = valueOf;
                        nTHttpMqqJumper$violationReport$1.L$2 = j3;
                        nTHttpMqqJumper$violationReport$1.label = 1;
                        Object first = FlowKt.first(msgList, nTHttpMqqJumper$violationReport$1);
                        if (first == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        uinCode = j3;
                        nTHttpMqqJumper = this;
                        obj = first;
                    } else {
                        return Unit.INSTANCE;
                    }
                }
                String str2 = valueOf;
                eVar = (e) obj;
                if (eVar.a().size() > 0) {
                    String currentAccountUin = nTHttpMqqJumper.mApp.getCurrentAccountUin();
                    ArrayList<com.tencent.qqnt.msg.d> a16 = eVar.a();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = a16.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((com.tencent.qqnt.msg.d) it.next()).a());
                    }
                    String reportMsgOrg = NewReportPlugin.t(str2, currentAccountUin, 25004, 10, arrayList);
                    Intrinsics.checkNotNullExpressionValue(reportMsgOrg, "reportMsgOrg");
                    Regex regex = new Regex(str2);
                    Intrinsics.checkNotNullExpressionValue(uinCode, "uinCode");
                    String replace = regex.replace(reportMsgOrg, uinCode);
                    AIOSession aIOSession3 = nTHttpMqqJumper.session;
                    Intrinsics.checkNotNull(aIOSession3);
                    Bundle I = NewReportPlugin.I(str2, aIOSession3.c().e());
                    if (QLog.isColorLevel()) {
                        QLog.i("HttpMqqJumper", 2, "openMoreOptions safetyReport reportMsgOrg: " + reportMsgOrg + "  reportMsg: " + replace);
                    }
                    Lifecycle lifecycle = ((QBaseActivity) nTHttpMqqJumper.mContext).getLifecycle();
                    Intrinsics.checkNotNullExpressionValue(lifecycle, "mContext.lifecycle");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getMain(), null, new NTHttpMqqJumper$violationReport$2(nTHttpMqqJumper, str2, uinCode, replace, I, null), 2, null);
                }
                return Unit.INSTANCE;
            }
        }
        nTHttpMqqJumper$violationReport$1 = new NTHttpMqqJumper$violationReport$1(this, continuation);
        Object obj2 = nTHttpMqqJumper$violationReport$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTHttpMqqJumper$violationReport$1.label;
        if (i3 == 0) {
        }
        String str22 = valueOf;
        eVar = (e) obj2;
        if (eVar.a().size() > 0) {
        }
        return Unit.INSTANCE;
    }

    public final void g() {
        ax c16;
        String replace$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mContext != null && !TextUtils.isEmpty(this.mJumpUrl)) {
            Intent intent = null;
            if (e()) {
                String str = this.mJumpUrl;
                Intrinsics.checkNotNull(str);
                replace$default = StringsKt__StringsJVMKt.replace$default(str, "mqq://", "https://", false, 4, (Object) null);
                this.mJumpUrl = replace$default;
                Context context = this.mContext;
                if (context instanceof FragmentActivity) {
                    Lifecycle lifecycle = ((FragmentActivity) context).getLifecycle();
                    Intrinsics.checkNotNullExpressionValue(lifecycle, "mContext.lifecycle");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new NTHttpMqqJumper$jump$1(this, null), 3, null);
                }
            } else if (d()) {
                intent = new Intent(this.mContext, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", this.mJumpUrl);
            } else if (f()) {
                QQAppInterface qQAppInterface = this.mApp;
                if (qQAppInterface != null && (c16 = bi.c(qQAppInterface, this.mContext, this.mJumpUrl)) != null) {
                    c16.z();
                    c16.b();
                    return;
                }
                return;
            }
            if (intent != null) {
                this.mContext.startActivity(intent);
            }
        }
    }

    @NotNull
    public final NTHttpMqqJumper h(@Nullable String jumpUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (NTHttpMqqJumper) iPatchRedirector.redirect((short) 5, (Object) this, (Object) jumpUrl);
        }
        this.mJumpUrl = jumpUrl;
        return this;
    }

    @NotNull
    public final NTHttpMqqJumper i(@Nullable AIOSession session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (NTHttpMqqJumper) iPatchRedirector.redirect((short) 6, (Object) this, (Object) session);
        }
        this.session = session;
        return this;
    }
}
