package com.tencent.mobileqq.aio.msglist.holder.component.template.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOArkApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/i;", "", "", "c", "", "url", "", "b", "a", "Z", "isUrlCheckEnable", "()Z", "setUrlCheckEnable", "(Z)V", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/TemplateMsgWhiteUrlItem;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "globalWhiteList", "globalBlackList", "<init>", "()V", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isUrlCheckEnable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<TemplateMsgWhiteUrlItem> globalWhiteList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<TemplateMsgWhiteUrlItem> globalBlackList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.common.i$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isUrlCheckEnable = true;
        this.globalWhiteList = new ArrayList<>();
        this.globalBlackList = new ArrayList<>();
        c();
    }

    private final void c() {
        com.tencent.qqnt.aio.adapter.api.a arkPlatformConfig = ((IAIOArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOArkApi.class)).getArkPlatformConfig();
        if (arkPlatformConfig == null) {
            QLog.w("TemMsg.TemplateMsgGlobalConfig", 1, "loadFromFreesia got null");
            return;
        }
        List<String> a16 = arkPlatformConfig.a();
        if (a16 != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                TemplateMsgWhiteUrlItem a17 = l.f191934a.a((String) it.next());
                if (a17 != null) {
                    arrayList.add(a17);
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                this.globalBlackList.add((TemplateMsgWhiteUrlItem) it5.next());
            }
        }
        List<String> b16 = arkPlatformConfig.b();
        if (b16 != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it6 = b16.iterator();
            while (it6.hasNext()) {
                TemplateMsgWhiteUrlItem a18 = l.f191934a.a((String) it6.next());
                if (a18 != null) {
                    arrayList2.add(a18);
                }
            }
            Iterator it7 = arrayList2.iterator();
            while (it7.hasNext()) {
                this.globalWhiteList.add((TemplateMsgWhiteUrlItem) it7.next());
            }
        }
        TemplateMsgWhiteUrlItem a19 = l.f191934a.a("static-res.qq.com");
        if (a19 != null) {
            this.globalWhiteList.add(a19);
        }
        QLog.i("TemMsg.TemplateMsgGlobalConfig", 1, "loadFromFreesia end globalBlackList size " + this.globalBlackList.size());
    }

    public final boolean a(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.globalBlackList.isEmpty()) {
            return false;
        }
        return l.f191934a.b(url, this.globalBlackList);
    }

    public final boolean b(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.globalWhiteList.isEmpty()) {
            return false;
        }
        return l.f191934a.b(url, this.globalWhiteList);
    }
}
