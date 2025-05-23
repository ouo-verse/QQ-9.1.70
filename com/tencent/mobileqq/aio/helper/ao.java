package com.tencent.mobileqq.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\b\b*\u0001\u001a\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/ao;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "c", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "g", "", "", "list", tl.h.F, "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "com/tencent/mobileqq/aio/helper/ao$b", "Lcom/tencent/mobileqq/aio/helper/ao$b;", "action", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class ao implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/ao$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.ao$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/ao$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ao.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                ao.this.g(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ao() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.action = new b();
        }
    }

    private final void c() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().f(this, this.action);
    }

    private final void e() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().i(this, this.action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(MsgIntent intent) {
        if (intent instanceof AIOMsgSendEvent.OnMsgSendSuccessEvent) {
            h(((AIOMsgSendEvent.OnMsgSendSuccessEvent) intent).c().b());
        }
    }

    private final void h(final List<Object> list) {
        if (list.isEmpty()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.an
            @Override // java.lang.Runnable
            public final void run() {
                ao.i(list);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(List list) {
        com.tencent.mobileqq.aio.msg.data.a aVar;
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(list, "$list");
        if (list.size() == 1) {
            Object obj = list.get(0);
            if (obj instanceof com.tencent.mobileqq.aio.msg.data.a) {
                aVar = (com.tencent.mobileqq.aio.msg.data.a) obj;
            } else {
                aVar = null;
            }
            if (aVar != null && aVar.a() == 6) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Object obj2 = list.get(0);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.data.AIOMsgElement");
                AIOElementType.b c16 = ((com.tencent.mobileqq.aio.msg.data.a) obj2).c();
                if (c16.v() == 1 || c16.v() == 2) {
                    if (c16.v() == 2) {
                        str = "0X800BCCC";
                    } else {
                        str = "0X800BBD5";
                    }
                    String str2 = str;
                    ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(null, "", "", str2, str2, c16.e(), 0, "", "", "", "");
                }
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 44;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnMsgSendSuccessEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MsgSendHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
        } else {
            Intrinsics.checkNotNullParameter(param, "param");
            this.param = param;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
        } else {
            if (state != 0) {
                if (state == 12) {
                    e();
                    return;
                }
                return;
            }
            c();
        }
    }
}
