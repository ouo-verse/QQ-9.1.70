package k74;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.ipc.annotation.RemoteCallBack;
import com.tencent.mobileqq.zplan.ipc.annotation.SyncMethod;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b4\u00105J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R&\u0010!\u001a\u0006\u0012\u0002\b\u00030\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010#\u001a\u0004\b\u0017\u0010$\"\u0004\b%\u0010&R$\u0010-\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010)\u001a\u0004\b\u0006\u0010*\"\u0004\b+\u0010,R\"\u00103\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010/\u001a\u0004\b\r\u00100\"\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lk74/e;", "", "", "methodDescriptor", "", "i", "a", "Z", tl.h.F, "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "isSync", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "name", "c", "l", "description", "d", "f", "o", "returnDescription", "Ljava/lang/Class;", "Ljava/lang/Class;", "g", "()Ljava/lang/Class;", "p", "(Ljava/lang/Class;)V", "returnType", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "()Ljava/lang/reflect/Method;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/reflect/Method;)V", "method", "Lk74/h;", "Lk74/h;", "()Lk74/h;", "j", "(Lk74/h;)V", "callback", "", "I", "()I", "k", "(I)V", "callbackIndex", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isSync;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public String description;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public String returnDescription;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Class<?> returnType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Method method;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private h callback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int callbackIndex = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ+\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lk74/e$a;", "", "", "Ljava/lang/Class;", PushClientConstants.TAG_PARAM_TYPES, "Lk74/e;", "methodToken", "", "b", "([Ljava/lang/Class;Lk74/e;)Ljava/lang/String;", "Ljava/lang/reflect/Method;", "method", "a", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k74.e$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(Class<?>[] paramTypes, e methodToken) {
            String str = "";
            if (paramTypes == null) {
                return "";
            }
            int i3 = -1;
            for (Class<?> cls : paramTypes) {
                str = str + ';' + cls.getName();
                i3++;
                if (cls.isInterface()) {
                    Annotation[] annotations = cls.getAnnotations();
                    Intrinsics.checkNotNullExpressionValue(annotations, "type.annotations");
                    if (!(annotations.length == 0)) {
                        Annotation[] annotations2 = cls.getAnnotations();
                        Intrinsics.checkNotNullExpressionValue(annotations2, "type.annotations");
                        for (Annotation annotation : annotations2) {
                            if (annotation instanceof RemoteCallBack) {
                                methodToken.j(h.INSTANCE.a(cls));
                                methodToken.k(i3);
                            }
                        }
                    }
                }
            }
            return str;
        }

        public final e a(Method method) {
            Annotation annotation;
            Intrinsics.checkNotNullParameter(method, "method");
            e eVar = new e();
            eVar.m(method);
            Class<?>[] paramTypes = method.getParameterTypes();
            Class<?> retTypes = method.getReturnType();
            method.getParameterAnnotations();
            Annotation[] methodAnnotations = method.getAnnotations();
            Intrinsics.checkNotNullExpressionValue(paramTypes, "paramTypes");
            String b16 = b(paramTypes, eVar);
            Intrinsics.checkNotNullExpressionValue(methodAnnotations, "methodAnnotations");
            int length = methodAnnotations.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    annotation = null;
                    break;
                }
                annotation = methodAnnotations[i3];
                if (annotation instanceof SyncMethod) {
                    break;
                }
                i3++;
            }
            boolean z16 = annotation != null;
            if (z16) {
                QLog.d("MethodToken", 1, method + " is sync");
            }
            Intrinsics.checkNotNullExpressionValue(retTypes, "retTypes");
            eVar.p(retTypes);
            if (!Intrinsics.areEqual(l74.a.l(retTypes), Void.class) || z16) {
                eVar.q(true);
            }
            String name = retTypes.getName();
            Intrinsics.checkNotNullExpressionValue(name, "retTypes.name");
            eVar.o(name);
            eVar.l(method.getName() + ';' + eVar.f() + b16);
            String name2 = method.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "method.name");
            eVar.n(name2);
            return eVar;
        }

        Companion() {
        }
    }

    /* renamed from: a, reason: from getter */
    public final h getCallback() {
        return this.callback;
    }

    /* renamed from: b, reason: from getter */
    public final int getCallbackIndex() {
        return this.callbackIndex;
    }

    public final String c() {
        String str = this.description;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("description");
        return null;
    }

    public final Method d() {
        Method method = this.method;
        if (method != null) {
            return method;
        }
        Intrinsics.throwUninitializedPropertyAccessException("method");
        return null;
    }

    public final String e() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final String f() {
        String str = this.returnDescription;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("returnDescription");
        return null;
    }

    public final Class<?> g() {
        Class<?> cls = this.returnType;
        if (cls != null) {
            return cls;
        }
        Intrinsics.throwUninitializedPropertyAccessException("returnType");
        return null;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsSync() {
        return this.isSync;
    }

    public final boolean i(String methodDescriptor) {
        Intrinsics.checkNotNullParameter(methodDescriptor, "methodDescriptor");
        return Intrinsics.areEqual(c(), methodDescriptor);
    }

    public final void j(h hVar) {
        this.callback = hVar;
    }

    public final void k(int i3) {
        this.callbackIndex = i3;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void m(Method method) {
        Intrinsics.checkNotNullParameter(method, "<set-?>");
        this.method = method;
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.returnDescription = str;
    }

    public final void p(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.returnType = cls;
    }

    public final void q(boolean z16) {
        this.isSync = z16;
    }
}
