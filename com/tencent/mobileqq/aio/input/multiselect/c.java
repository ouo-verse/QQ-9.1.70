package com.tencent.mobileqq.aio.input.multiselect;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.input.multiselect.MultiSelectUIState;
import com.tencent.mobileqq.aio.input.multiselect.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\b*\u0002(2\b\u0007\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B\u000f\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R&\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020(0-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/aio/input/multiselect/c;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/input/multiselect/d;", "Lcom/tencent/mobileqq/aio/input/multiselect/MultiSelectUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "", "v", "w", "t", "Landroid/content/Context;", "context", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "", "visibility", HippyTKDListViewAdapter.X, "state", "p", "Lcom/tencent/aio/api/runtime/a;", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", "Lcom/tencent/mobileqq/aio/input/multiselect/a;", "e", "Lcom/tencent/mobileqq/aio/input/multiselect/a;", "getFetcher", "()Lcom/tencent/mobileqq/aio/input/multiselect/a;", "fetcher", "f", "I", "mCount", "com/tencent/mobileqq/aio/input/multiselect/c$b", h.F, "Lcom/tencent/mobileqq/aio/input/multiselect/c$b;", "mAction", "", "Lkotlin/Pair;", "", "i", "Ljava/util/List;", "mMessageList", "com/tencent/mobileqq/aio/input/multiselect/c$c", "Lcom/tencent/mobileqq/aio/input/multiselect/c$c;", "mConfigurationChangedCallback", "<init>", "(Lcom/tencent/mobileqq/aio/input/multiselect/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class c extends com.tencent.qqnt.aio.baseVM.a<d, MultiSelectUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a fetcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7276c mConfigurationChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/multiselect/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.multiselect.c$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/multiselect/c$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                c.this.E(i3);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/multiselect/c$c", "Lcom/tencent/aio/api/runtime/emitter/b;", "Landroid/content/res/Configuration;", "configuration", "", "onConfigurationChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.multiselect.c$c, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7276c implements com.tencent.aio.api.runtime.emitter.b {
        static IPatchRedirector $redirector_;

        C7276c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.runtime.emitter.b
        public void onConfigurationChanged(@NotNull Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
            } else {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56350);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull a fetcher) {
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fetcher);
            return;
        }
        this.fetcher = fetcher;
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(MultiSelectEvent.UpdateSelectCount.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(MultiSelectEvent.SetTouchBarVisibility.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.ListScrollStateChanged.class)), bVar)});
        this.mMessageList = listOf;
        this.mConfigurationChangedCallback = new C7276c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof MultiSelectEvent.UpdateSelectCount) {
            z();
        } else if (intent instanceof MultiSelectEvent.SetTouchBarVisibility) {
            x(((MultiSelectEvent.SetTouchBarVisibility) intent).a());
        } else if (intent instanceof AIOMsgListEvent.ListScrollStateChanged) {
            p(((AIOMsgListEvent.ListScrollStateChanged) intent).a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean m(Context context) {
        String str = null;
        if (w()) {
            Resources resources = context.getResources();
            if (resources != null) {
                str = resources.getString(R.string.f168862gs);
            }
            QQToast.makeText(context, str, 0).show();
            return true;
        }
        if (!com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.a((com.tencent.aio.api.runtime.a) getMContext())) {
            return false;
        }
        Resources resources2 = context.getResources();
        if (resources2 != null) {
            str = resources2.getString(R.string.f222466dl);
        }
        QQToast.makeText(context, str, 0).show();
        return true;
    }

    private final boolean n(Context context) {
        String str = null;
        if (!AppNetConnInfo.isNetSupport()) {
            Resources resources = context.getResources();
            if (resources != null) {
                str = resources.getString(R.string.f169552in);
            }
            QQToast.makeText(context, str, 0).show();
            return true;
        }
        if (!w()) {
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
    private final void p(int state) {
        if (state == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MultiSelectEvent.ComputeTouchBarVisibility(this.fetcher.N()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        if (v()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.e((com.tencent.aio.api.runtime.a) getMContext()));
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        e16.h(new CreateHelperIntent.CreateHelperRealIntent(3, new LongShotMsgIntent.SetShotMode(true), null, 4, null));
        e16.h(new LongShotMsgIntent.OnlyAddMsgList(arrayList));
        e16.h(new MultiSelectEvent.SetSelectMode(false));
        e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("MultiSelectBarVM", false));
        e16.h(new AIOMsgListEvent.LongShotModeChangeEvent("MultiSelectBarVM", true));
        e16.h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("MultiSelectBarVM", false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        if (v()) {
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(MultiSelectEvent.MultiDeleteMessageEvent.f188668d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        Context context;
        Fragment c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        if (c16 == null || (context = c16.getContext()) == null || v() || m(context)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.e((com.tencent.aio.api.runtime.a) getMContext()));
        ((IAIOFavApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFavApi.class)).multiFav(context, arrayList);
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        e16.h(new MultiSelectEvent.SetSelectMode(false));
        e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("MultiSelectBarVM", false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t() {
        Context context;
        Fragment c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        if (c16 == null || (context = c16.getContext()) == null || v() || n(context)) {
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(MultiSelectEvent.MultiForwardShowEvent.f188669d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgForwardEvent.MultiMoreClickEvent(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.e((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean v() {
        if (com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.f((com.tencent.aio.api.runtime.a) getMContext()) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean w() {
        if (com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.g((com.tencent.aio.api.runtime.a) getMContext()) == 0) {
            return true;
        }
        return false;
    }

    private final void x(int visibility) {
        if (this.mCount == 0) {
            return;
        }
        updateUI(new MultiSelectUIState.SetTouchBarVisibility(visibility));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() != 103 && ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() != 118 && ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() != 201) {
            updateUI(new MultiSelectUIState.UpdateOperation(1));
        } else {
            updateUI(new MultiSelectUIState.UpdateOperation(2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        int g16 = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.g((com.tencent.aio.api.runtime.a) getMContext());
        this.mCount = g16;
        updateUI(new MultiSelectUIState.UpdateSelectCount(g16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull d intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.C7277d) {
            t();
            return;
        }
        if (intent instanceof d.a) {
            q();
            return;
        }
        if (intent instanceof d.b) {
            r();
            return;
        }
        if (intent instanceof d.c) {
            s();
        } else if (intent instanceof d.e) {
            u();
        } else if (intent instanceof d.f) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.MultiSelectToBottom(((d.f) intent).a()));
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
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
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
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        z();
        y();
    }
}
