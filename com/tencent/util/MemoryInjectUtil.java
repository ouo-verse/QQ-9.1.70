package com.tencent.util;

import com.tencent.mobileqq.injector.u;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/util/MemoryInjectUtil;", "Lcom/tencent/mobileqq/inject/m;", "", "inject", "ensureInitInject", "", "tag", "getClassName", "", "getZPlanDownloadModState", "TAG", "Ljava/lang/String;", "sMemoryInject", "Lcom/tencent/mobileqq/inject/m;", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class MemoryInjectUtil implements com.tencent.mobileqq.inject.m {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final MemoryInjectUtil INSTANCE;

    @NotNull
    private static final String TAG = "MemoryInjectUtil";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQPerf/Inject_Memory.yml", version = 1)
    @Nullable
    private static com.tencent.mobileqq.inject.m sMemoryInject;
    private static ArrayList sMemoryInject_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sMemoryInject_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(u.class);
        INSTANCE = new MemoryInjectUtil();
    }

    MemoryInjectUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ensureInitInject() {
        boolean z16;
        if (sMemoryInject == null) {
            inject();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("injected, result: ");
            if (sMemoryInject != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i(TAG, 2, sb5.toString());
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void inject() {
        sMemoryInject = (com.tencent.mobileqq.inject.m) com.tencent.mobileqq.qroute.utils.b.a(sMemoryInject_AutoGenClazzList_QAutoInjectTransform);
    }

    @Override // com.tencent.mobileqq.inject.m
    @NotNull
    public String getClassName(@Nullable String tag) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag);
        }
        ensureInitInject();
        com.tencent.mobileqq.inject.m mVar = sMemoryInject;
        if (mVar != null) {
            str = mVar.getClassName(tag);
        } else {
            str = null;
        }
        if (str == null) {
            return "Unknown";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.inject.m
    public boolean getZPlanDownloadModState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ensureInitInject();
        com.tencent.mobileqq.inject.m mVar = sMemoryInject;
        if (mVar != null) {
            return mVar.getZPlanDownloadModState();
        }
        return false;
    }
}
