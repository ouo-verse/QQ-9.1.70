package com.tencent.mobileqq.aio.input.communicationshare;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.input.communicationshare.CommunicationShareUIState;
import com.tencent.mobileqq.aio.input.communicationshare.a;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\t*\u0001!\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/aio/input/communicationshare/d;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/input/communicationshare/a;", "Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "r", "", "visibility", ReportConstant.COSTREPORT_PREFIX, "state", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "Lcom/tencent/aio/api/runtime/a;", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;", "e", "Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;", "getFetcher", "()Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;", "fetcher", "f", "I", "mCount", "com/tencent/mobileqq/aio/input/communicationshare/d$b", h.F, "Lcom/tencent/mobileqq/aio/input/communicationshare/d$b;", "mAction", "<init>", "(Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;)V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class d extends com.tencent.qqnt.aio.baseVM.a<a, CommunicationShareUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CommunicationShareBarVB fetcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/communicationshare/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.communicationshare.d$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/communicationshare/d$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                d.this.E(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54423);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull CommunicationShareBarVB fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fetcher);
        } else {
            this.fetcher = fetcher;
            this.mAction = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof MultiSelectEvent.UpdateSelectCount) {
            r();
        } else if (intent instanceof MultiSelectEvent.SetTouchBarVisibility) {
            s(((MultiSelectEvent.SetTouchBarVisibility) intent).a());
        } else if (intent instanceof AIOMsgListEvent.ListScrollStateChanged) {
            q(((AIOMsgListEvent.ListScrollStateChanged) intent).a());
        }
    }

    private final boolean m(Context context) {
        String str = null;
        if (!AppNetConnInfo.isNetSupport()) {
            Resources resources = context.getResources();
            if (resources != null) {
                str = resources.getString(R.string.f169552in);
            }
            QQToast.makeText(context, str, 0).show();
            return true;
        }
        if (!p()) {
            return false;
        }
        Resources resources2 = context.getResources();
        if (resources2 != null) {
            str = resources2.getString(R.string.f169542im);
        }
        QQToast.makeText(context, str, 0).show();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        Context context;
        Fragment c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        if (c16 == null || (context = c16.getContext()) == null || m(context)) {
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(MultiSelectEvent.UpdateCommunicationShareCount.f188676d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean p() {
        if (com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.g((com.tencent.aio.api.runtime.a) getMContext()) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(int state) {
        if (state == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MultiSelectEvent.ComputeTouchBarVisibility(this.fetcher.N()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        int g16 = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.g((com.tencent.aio.api.runtime.a) getMContext());
        this.mCount = g16;
        updateUI(new CommunicationShareUIState.UpdateSelectCount(g16));
    }

    private final void s(int visibility) {
        if (this.mCount == 0) {
            return;
        }
        updateUI(new CommunicationShareUIState.SetTouchBarVisibility(visibility));
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.UpdateSelectCount");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.SetTouchBarVisibility");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ListScrollStateChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7261a) {
            o();
        } else if (intent instanceof a.b) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.MultiSelectToBottom(((a.b) intent).a()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        this.mCount = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
        r();
    }
}
