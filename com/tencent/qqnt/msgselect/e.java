package com.tencent.qqnt.msgselect;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002RP\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b`\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/msgselect/e;", "", "", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/qqnt/msgselect/b;", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getClassMap", "()Ljava/util/HashMap;", "setClassMap", "(Ljava/util/HashMap;)V", "getClassMap$annotations", "()V", "classMap", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f359744a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msgselect/Inject_msgselect_processor.yml", version = 3)
    @NotNull
    private static HashMap<String, Class<b>> classMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65777);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f359744a = new e();
        HashMap<String, Class<b>> hashMap = new HashMap<>();
        classMap = hashMap;
        hashMap.put("1002", c.class);
        classMap.put("1001", com.tencent.mobileqq.jubao.d.class);
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final b a(int fromType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, fromType);
        }
        if (classMap.containsKey(String.valueOf(fromType))) {
            Class<b> cls = classMap.get(String.valueOf(fromType));
            Intrinsics.checkNotNull(cls);
            b newInstance = cls.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "classMap[fromType.toString()]!!.newInstance()");
            return newInstance;
        }
        return new a();
    }
}
