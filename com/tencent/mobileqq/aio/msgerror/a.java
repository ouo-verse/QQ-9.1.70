package com.tencent.mobileqq.aio.msgerror;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.aio.msgerror.GroupMemberStrangerMsgSendErrorCallback;
import com.tencent.qqnt.aio.msgerror.b;
import com.tencent.qqnt.aio.msgerror.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002RP\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b`\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msgerror/a;", "", "", "chatType", "Lcom/tencent/qqnt/aio/msgerror/c;", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getClassMap", "()Ljava/util/HashMap;", "setClassMap", "(Ljava/util/HashMap;)V", "getClassMap$annotations", "()V", "classMap", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f190338a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msgerror/Inject_msgerror_callback.yml", version = 3)
    @NotNull
    private static HashMap<String, Class<c>> classMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f190338a = new a();
        HashMap<String, Class<c>> hashMap = new HashMap<>();
        classMap = hashMap;
        hashMap.put("100", GroupMemberStrangerMsgSendErrorCallback.class);
        classMap.put("2", b.class);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final c a(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        }
        if (classMap.containsKey(String.valueOf(chatType))) {
            Class<c> cls = classMap.get(String.valueOf(chatType));
            Intrinsics.checkNotNull(cls);
            c newInstance = cls.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "classMap[chatType.toString()]!!.newInstance()");
            return newInstance;
        }
        return new com.tencent.qqnt.aio.msgerror.a();
    }
}
