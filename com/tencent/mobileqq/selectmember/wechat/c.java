package com.tencent.mobileqq.selectmember.wechat;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.wxshare.f;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\nj\b\u0012\u0004\u0012\u00020\u0003`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/selectmember/wechat/c;", "Lcom/tencent/mobileqq/selectmember/wechat/b;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/selectmember/wechat/a;", "clz", "b", "Landroid/content/Intent;", "intent", "", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "wxShareOptions", "<init>", "()V", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "AutoInjectYml/Business/SelectMember/Inject_WXShare_Option.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? extends a>> f286068c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> wxShareOptions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R8\u0010\t\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00060\u0005j\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006`\b8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/selectmember/wechat/c$a;", "", "", "TAG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/selectmember/wechat/a;", "Lkotlin/collections/ArrayList;", "sInjectOptions", "Ljava/util/ArrayList;", "<init>", "()V", "qq-selectmember-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectmember.wechat.c$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19324);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<? extends a>> arrayList = new ArrayList<>();
        f286068c = arrayList;
        arrayList.add(f.class);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.wxShareOptions = new ArrayList<>();
        Iterator<Class<? extends a>> it = f286068c.iterator();
        while (it.hasNext()) {
            a b16 = b(it.next());
            if (b16 != null) {
                this.wxShareOptions.add(b16);
            }
        }
        QLog.i("WxShareOrganizer", 1, "wxShareOptions init size " + this.wxShareOptions.size());
    }

    private final a b(Class<? extends a> clz) {
        if (clz == null) {
            QLog.e("WxShareOrganizer", 1, "createOptions: processorClz == null");
            return null;
        }
        try {
            return clz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e16) {
            QLog.e("WxShareOrganizer", 1, "createOptions exception:" + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.selectmember.wechat.b
    public void a(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra("forward_type", Integer.MAX_VALUE);
        Iterator<a> it = this.wxShareOptions.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.b(intExtra)) {
                next.a(intent);
                return;
            }
        }
        QLog.e("WxShareOrganizer", 1, "doShare error nothing match, forwardType:" + intExtra);
    }
}
