package com.tencent.qqnt.kernel.invorker;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.invorker.g;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \r2\u00020\u0001:\u0001/B3\u0012\u0006\u00105\u001a\u00020\u0007\u0012\n\u0010[\u001a\u0006\u0012\u0002\b\u00030Z\u0012\u0006\u0010;\u001a\u000206\u0012\u0006\u0010\\\u001a\u00020B\u0012\u0006\u0010@\u001a\u00020<\u00a2\u0006\u0004\b]\u0010^J!\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u000eH&J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0004Jd\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072B\u0010\u001c\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016H\u0004J\u001e\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0004J\\\u0010!\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072B\u0010\u001f\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000e0\u0016H\u0004J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0004J \u0010'\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0007J\u0018\u0010*\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0006\u0010,\u001a\u00020+J\u0006\u0010.\u001a\u00020-R\"\u00105\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010@\u001a\u00020<8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b!\u0010=\u001a\u0004\b>\u0010?R*\u0010H\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010O\u001a\u00020I8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR'\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0P8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010Q\u001a\u0004\bR\u0010SR'\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0P8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010Q\u001a\u0004\bU\u0010SR'\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020W0P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010Q\u001a\u0004\bX\u0010S\u00a8\u0006_"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "", "", "", tl.h.F, "(Ljava/util/List;)[Ljava/lang/Object;", "", "parasName", "g", "Lcom/tencent/qqnt/kernel/invorker/g$e;", "w", "Lcom/tencent/qqnt/kernel/invorker/g$d;", "i", "", ReportConstant.COSTREPORT_PREFIX, "r", "u", "methodName", "description", "e", "cmdHint", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "preParas", "cmds", "Lcom/tencent/qqnt/kernel/invorker/g$a;", "callInvork", "f", "Lkotlin/Function0;", "excessCall", "d", "c", "msg", "t", "", "paraInd", "cmd", "y", "result", "errMsg", "onResult", "Lcom/tencent/qqnt/kernel/invorker/i;", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernel/invorker/g$c;", "j", "a", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "setServiceName", "(Ljava/lang/String;)V", "serviceName", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "b", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "getKernelService", "()Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lcom/tencent/qqnt/kernel/invorker/f;", "Lcom/tencent/qqnt/kernel/invorker/f;", "o", "()Lcom/tencent/qqnt/kernel/invorker/f;", "notify", "Lmqq/util/WeakReference;", "Lmqq/app/AppRuntime;", "Lmqq/util/WeakReference;", "l", "()Lmqq/util/WeakReference;", "setMAppRef", "(Lmqq/util/WeakReference;)V", "mAppRef", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/api/j;", "p", "()Lcom/tencent/qqnt/kernel/api/j;", "v", "(Lcom/tencent/qqnt/kernel/api/j;)V", "serviceHandler", "", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/Map;", "methodInfos", "k", "excessMethodInfos", "Ljava/lang/reflect/Method;", DomainData.DOMAIN_NAME, Constants.Service.METHODS, "Ljava/lang/Class;", "serviceType", "app", "<init>", "(Ljava/lang/String;Ljava/lang/Class;Lcom/tencent/qqnt/kernel/api/IKernelService;Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/invorker/f;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class KBaseInvorkService implements IOperateCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final Lazy<Map<Class<?>, Method>> f359091j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String serviceName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IKernelService kernelService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f notify;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AppRuntime> mAppRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected com.tencent.qqnt.kernel.api.j serviceHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy methodInfos;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy excessMethodInfos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy methods;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR+\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService$a;", "", "", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "serviceMethods$delegate", "Lkotlin/Lazy;", "b", "()Ljava/util/Map;", "serviceMethods", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.invorker.KBaseInvorkService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<Class<?>, Method> b() {
            return (Map) KBaseInvorkService.f359091j.getValue();
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
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/kernel/invorker/KBaseInvorkService$b", "Lcom/tencent/qqnt/kernel/invorker/g$c;", "Ljava/lang/reflect/Method;", "method", "", "cmd", "", "", "preParas", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements g.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f359100a;

        b(Function0<Unit> function0) {
            this.f359100a = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.qqnt.kernel.invorker.g.c
        @NotNull
        public String a(@Nullable Method method, @NotNull String cmd, @NotNull List<? extends Object> preParas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, method, cmd, preParas);
            }
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(preParas, "preParas");
            try {
                this.f359100a.invoke();
                return "success";
            } catch (NumberFormatException e16) {
                return "error: " + e16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/kernel/invorker/KBaseInvorkService$c", "Lcom/tencent/qqnt/kernel/invorker/g$c;", "Ljava/lang/reflect/Method;", "method", "", "cmd", "", "", "preParas", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements g.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<List<? extends Object>, List<String>, Unit> f359101a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super List<? extends Object>, ? super List<String>, Unit> function2) {
            this.f359101a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.qqnt.kernel.invorker.g.c
        @NotNull
        public String a(@Nullable Method method, @NotNull String cmd, @NotNull List<? extends Object> preParas) {
            boolean z16;
            List<String> split$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, method, cmd, preParas);
            }
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(preParas, "preParas");
            try {
                if (cmd.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return "cmd is null!";
                }
                Function2<List<? extends Object>, List<String>, Unit> function2 = this.f359101a;
                split$default = StringsKt__StringsKt.split$default((CharSequence) cmd, new String[]{" "}, false, 0, 6, (Object) null);
                function2.invoke(preParas, split$default);
                return "success";
            } catch (NumberFormatException e16) {
                return "error: " + e16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/kernel/invorker/KBaseInvorkService$d", "Lcom/tencent/qqnt/kernel/invorker/g$c;", "Ljava/lang/reflect/Method;", "method", "", "cmd", "", "", "preParas", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d implements g.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<List<? extends Object>, List<String>, g.a> f359102a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ KBaseInvorkService f359103b;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super List<? extends Object>, ? super List<String>, g.a> function2, KBaseInvorkService kBaseInvorkService) {
            this.f359102a = function2;
            this.f359103b = kBaseInvorkService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2, (Object) kBaseInvorkService);
            }
        }

        @Override // com.tencent.qqnt.kernel.invorker.g.c
        @NotNull
        public String a(@Nullable Method method, @NotNull String cmd, @NotNull List<? extends Object> preParas) {
            boolean z16;
            List<String> split$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, method, cmd, preParas);
            }
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(preParas, "preParas");
            try {
                if (cmd.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return "cmd is null!";
                }
                Function2<List<? extends Object>, List<String>, g.a> function2 = this.f359102a;
                split$default = StringsKt__StringsKt.split$default((CharSequence) cmd, new String[]{" "}, false, 0, 6, (Object) null);
                g.a invoke = function2.invoke(preParas, split$default);
                if (invoke.c() == 0) {
                    Object[] h16 = this.f359103b.h(invoke.b());
                    if (method != null) {
                        method.invoke(this.f359103b.p(), Arrays.copyOf(h16, h16.length));
                        return "success";
                    }
                    return "success";
                }
                return "result:" + invoke.c() + ", errMsg: " + invoke.a();
            } catch (NumberFormatException e16) {
                return "error: " + e16;
            } catch (IllegalArgumentException e17) {
                return "error: " + e17;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/kernel/invorker/KBaseInvorkService$e", "Lcom/tencent/qqnt/kernel/invorker/g$c;", "Ljava/lang/reflect/Method;", "method", "", "cmd", "", "", "preParas", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class e implements g.c {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KBaseInvorkService.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.invorker.g.c
        @NotNull
        public String a(@Nullable Method method, @NotNull String cmd, @NotNull List<? extends Object> preParas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, method, cmd, preParas);
            }
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(preParas, "preParas");
            try {
                Object[] h16 = KBaseInvorkService.this.h(preParas);
                if (method != null) {
                    method.invoke(KBaseInvorkService.this.p(), Arrays.copyOf(h16, h16.length));
                    return "success";
                }
                return "success";
            } catch (IllegalArgumentException e16) {
                return "error: " + e16;
            }
        }
    }

    static {
        Lazy<Map<Class<?>, Method>> lazy;
        boolean endsWith$default;
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54562);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        lazy = LazyKt__LazyJVMKt.lazy(KBaseInvorkService$Companion$serviceMethods$2.INSTANCE);
        f359091j = lazy;
        if (companion.b().isEmpty()) {
            Method[] methods = IKernelService.class.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "IKernelService::class.java.methods");
            for (Method it : methods) {
                String name = it.getReturnType().getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.returnType.name");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name, "Service", false, 2, null);
                if (endsWith$default) {
                    Class<?>[] parameterTypes = it.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (parameterTypes.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Map b16 = INSTANCE.b();
                        Class<?> returnType = it.getReturnType();
                        Intrinsics.checkNotNullExpressionValue(returnType, "it.returnType");
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        b16.put(returnType, it);
                    }
                }
            }
            Map b17 = INSTANCE.b();
            Method method = a.class.getMethods()[0];
            Intrinsics.checkNotNullExpressionValue(method, "ICommonInvorkService::class.java.methods[0]");
            b17.put(a.class, method);
        }
    }

    public KBaseInvorkService(@NotNull String serviceName, @NotNull Class<?> serviceType, @NotNull IKernelService kernelService, @NotNull AppRuntime app, @NotNull f notify) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(kernelService, "kernelService");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(notify, "notify");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, serviceName, serviceType, kernelService, app, notify);
            return;
        }
        this.serviceName = serviceName;
        this.kernelService = kernelService;
        this.notify = notify;
        lazy = LazyKt__LazyJVMKt.lazy(KBaseInvorkService$methodInfos$2.INSTANCE);
        this.methodInfos = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(KBaseInvorkService$excessMethodInfos$2.INSTANCE);
        this.excessMethodInfos = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(KBaseInvorkService$methods$2.INSTANCE);
        this.methods = lazy3;
        this.mAppRef = new WeakReference<>(app);
        Method method = (Method) INSTANCE.b().get(serviceType);
        if (method != null) {
            this.serviceName = this.serviceName + "(" + method.getName() + ")";
            s();
            if (!Intrinsics.areEqual(method.getReturnType(), Boolean.TYPE)) {
                Object invoke = method.invoke(kernelService, new Object[0]);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IBaseService");
                v((com.tencent.qqnt.kernel.api.j) invoke);
                Method[] methods = serviceType.getMethods();
                Intrinsics.checkNotNullExpressionValue(methods, "serviceType.methods");
                for (Method it : methods) {
                    Map<String, Method> n3 = n();
                    String name = it.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    n3.put(name, it);
                    if (m().containsKey(it.getName())) {
                        g.d dVar = m().get(it.getName());
                        Intrinsics.checkNotNull(dVar);
                        g.d dVar2 = dVar;
                        if (dVar2.g().size() == 0) {
                            g.d.c(dVar2, null, null, 3, null);
                        }
                    } else {
                        Class<?>[] parameterTypes = it.getParameterTypes();
                        Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                        if (parameterTypes.length == 0) {
                            Map<String, g.d> m3 = m();
                            String name2 = it.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                            m3.put(name2, i());
                        }
                    }
                }
            }
            for (Map.Entry<String, g.d> entry : k().entrySet()) {
                if (entry.getValue().g().isEmpty()) {
                    g.d.c(entry.getValue(), null, null, 3, null);
                }
            }
            r();
        }
    }

    private final String g(String str, String str2) {
        return str2 + "---result: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] h(List<? extends Object> list) {
        Object[] objArr = new Object[list.size()];
        Iterator<T> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return objArr;
    }

    private final g.d i() {
        List mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new g.e(null, null, 3, null));
        return new g.d("default", mutableListOf, false, "", j());
    }

    private final Map<String, Method> n() {
        return (Map) this.methods.getValue();
    }

    private final List<String> w(List<g.e> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((g.e) it.next()).toString());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final g.d c(@NotNull String description, @NotNull String cmdHint, @NotNull Function2<? super List<? extends Object>, ? super List<String>, Unit> excessCall) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (g.d) iPatchRedirector.redirect((short) 15, this, description, cmdHint, excessCall);
        }
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(cmdHint, "cmdHint");
        Intrinsics.checkNotNullParameter(excessCall, "excessCall");
        g.d dVar = new g.d(description, new ArrayList(), true, cmdHint, new c(excessCall));
        k().put(description, dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final g.d d(@NotNull String description, @NotNull Function0<Unit> excessCall) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (g.d) iPatchRedirector.redirect((short) 14, (Object) this, (Object) description, (Object) excessCall);
        }
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(excessCall, "excessCall");
        g.d dVar = new g.d(description, new ArrayList(), false, "", new b(excessCall));
        k().put(description, dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final g.d e(@NotNull String methodName, @NotNull String description) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (g.d) iPatchRedirector.redirect((short) 12, (Object) this, (Object) methodName, (Object) description);
        }
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(description, "description");
        g.d dVar = new g.d(description, new ArrayList(), false, "", j());
        m().put(methodName, dVar);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final g.d f(@NotNull String methodName, @NotNull String description, @NotNull String cmdHint, @NotNull Function2<? super List<? extends Object>, ? super List<String>, g.a> callInvork) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (g.d) iPatchRedirector.redirect((short) 13, this, methodName, description, cmdHint, callInvork);
        }
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(cmdHint, "cmdHint");
        Intrinsics.checkNotNullParameter(callInvork, "callInvork");
        g.d dVar = new g.d(description, new ArrayList(), true, cmdHint, new d(callInvork, this));
        m().put(methodName, dVar);
        return dVar;
    }

    @NotNull
    public final g.c j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (g.c) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return new e();
    }

    @NotNull
    protected final Map<String, g.d> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Map) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return (Map) this.excessMethodInfos.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WeakReference<AppRuntime> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (WeakReference) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mAppRef;
    }

    @NotNull
    protected final Map<String, g.d> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (Map) this.methodInfos.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final f o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (f) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.notify;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
    public void onResult(int result, @NotNull String errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, result, (Object) errMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.notify.notify("IOperateCallback", result + "(" + errMsg + ")");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.qqnt.kernel.api.j p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.kernel.api.j) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        com.tencent.qqnt.kernel.api.j jVar = this.serviceHandler;
        if (jVar != null) {
            return jVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serviceHandler");
        return null;
    }

    @NotNull
    public final String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.serviceName;
    }

    public abstract void r();

    public abstract void s();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(@NotNull String name, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) name, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.notify.notify(name, msg2);
    }

    public abstract void u();

    protected final void v(@NotNull com.tencent.qqnt.kernel.api.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) jVar);
        } else {
            Intrinsics.checkNotNullParameter(jVar, "<set-?>");
            this.serviceHandler = jVar;
        }
    }

    @NotNull
    public final i x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (i) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, g.d> entry : m().entrySet()) {
            Method method = n().get(entry.getKey());
            if (method != null) {
                g.d value = entry.getValue();
                String name = method.getName();
                Intrinsics.checkNotNullExpressionValue(name, "method.name");
                arrayList.add(new h(name, value.e(), w(value.g()), value.f(), value.d()));
            }
        }
        Iterator<Map.Entry<String, g.d>> it = k().entrySet().iterator();
        while (it.hasNext()) {
            g.d value2 = it.next().getValue();
            arrayList.add(new h(value2.e(), "", w(value2.g()), value2.f(), value2.d()));
        }
        return new i(this.serviceName, arrayList);
    }

    @Nullable
    public final String y(@NotNull String methodName, int paraInd, @NotNull String cmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, this, methodName, Integer.valueOf(paraInd), cmd);
        }
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        g.d dVar = m().get(methodName);
        if (dVar != null) {
            g.e eVar = dVar.g().get(paraInd);
            Method method = n().get(methodName);
            Intrinsics.checkNotNull(method);
            String g16 = g(dVar.a(method, cmd, eVar.b()), eVar.a());
            if (g16 != null) {
                return g16;
            }
        }
        g.d dVar2 = k().get(methodName);
        if (dVar2 == null) {
            return null;
        }
        g.e eVar2 = dVar2.g().get(paraInd);
        return g(dVar2.a(null, cmd, eVar2.b()), eVar2.a());
    }
}
