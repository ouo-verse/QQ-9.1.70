package com.tencent.mobileqq.aio.title.right1;

import android.content.Context;
import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.ScaleAIOEvent;
import com.tencent.mobileqq.aio.event.ZPlanMsgEvent;
import com.tencent.mobileqq.aio.title.af;
import com.tencent.mobileqq.aio.title.al;
import com.tencent.mobileqq.aio.title.right1.Right1UIState;
import com.tencent.mobileqq.aio.title.right1.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
import com.tencent.qqnt.aio.adapter.api.ITitleRight1IvApi;
import com.tencent.qqnt.aio.utils.AIOExpandFullScreenSwitch;
import com.tencent.qqnt.aio.utils.o;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/aio/title/right1/c;", "Lcom/tencent/mobileqq/aio/title/al;", "Lcom/tencent/mobileqq/aio/title/right1/a;", "Lcom/tencent/mobileqq/aio/title/right1/Right1UIState;", "", "isSelectMode", "", "o", "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight1IvEvent;", "intent", "p", "", "type", "", "data", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/event/ZPlanMsgEvent$ShowBubbleTipEvent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "v", "u", "r", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mvi/base/route/MsgIntent;", "E", DomainData.DOMAIN_NAME, "f", "Z", "mIsSelectedMode", h.F, "mShowFullScreenBtn", "Lcom/tencent/mobileqq/aio/title/af;", "i", "Lcom/tencent/mobileqq/aio/title/af;", "mLastData", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends al<a, Right1UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectedMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mShowFullScreenBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private af mLastData;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mLastData = new af(false, false, null, null, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        boolean z16 = false;
        this.mIsSelectedMode = false;
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        if (com.tencent.mobileqq.aio.a.d((com.tencent.aio.api.runtime.a) getMContext()) && AIOExpandFullScreenSwitch.f352242a.a() && (e16 == 1 || e16 == 2)) {
            z16 = true;
        }
        this.mShowFullScreenBtn = z16;
        if (z16) {
            u();
        } else {
            v();
        }
    }

    private final void m(ZPlanMsgEvent.ShowBubbleTipEvent intent) {
        updateUI(new Right1UIState.ShowBubbleTipUIState(intent.a()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(boolean isSelectMode) {
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context == null) {
            return;
        }
        this.mIsSelectedMode = isSelectMode;
        AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
        boolean z16 = true;
        if (c16.e() != 2 && c16.e() != 1) {
            z16 = false;
        }
        if (!isSelectMode) {
            updateUI(new Right1UIState.UpdateDataUIState(this.mLastData));
        } else if (z16) {
            updateUI(new Right1UIState.UpdateDataUIState(new af(false, true, ResourcesCompat.getDrawable(context.getResources(), R.drawable.qui_search_icon_navigation_02, context.getTheme()), "\u641c\u7d22", 7)));
        } else {
            updateUI(new Right1UIState.UpdateDataUIState(new af(false, false, null, "", 7)));
        }
    }

    private final void p(AIOTitleEvent.UpdateRight1IvEvent intent) {
        String a16;
        if (intent.a() == null) {
            a16 = HardCodeUtil.qqStr(R.string.f170301yu2);
        } else {
            a16 = intent.a();
        }
        af afVar = new af(intent.c(), intent.e(), intent.d(), a16, intent.b());
        if (intent.b() != 8 && intent.b() != 9) {
            this.mLastData = afVar;
        }
        if (this.mIsSelectedMode) {
            return;
        }
        if (intent.b() == 9) {
            updateUI(new Right1UIState.UpdateDataUIState(this.mLastData));
        } else {
            updateUI(new Right1UIState.UpdateDataUIState(afVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
        FragmentActivity requireActivity = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
        ((IChatHistoryApi) QRoute.api(IChatHistoryApi.class)).showSearchDialogFragment(requireActivity, 1001, c16.e(), c16.j());
    }

    private final void r() {
        v();
        this.mShowFullScreenBtn = false;
    }

    private final void s(int type, Object data) {
        if (type == 5 && !this.mShowFullScreenBtn) {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.Boolean");
            updateUI(new Right1UIState.UpdateRedPointUIState(((Boolean) data).booleanValue()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t() {
        Unit unit;
        if (com.tencent.mobileqq.aio.panel.c.f193019a.a((com.tencent.aio.api.runtime.a) getMContext())) {
            QLog.i(FrameworkVM.TAG, 1, "[onRight1IvClick]: hideKeyboard");
            FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
            if (activity != null) {
                o.f352309a.a(activity);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QLog.i(FrameworkVM.TAG, 1, "[onRight1IvClick]: hideKeyboard fail");
            }
        }
        if (this.mIsSelectedMode) {
            q();
            return;
        }
        if (this.mShowFullScreenBtn) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ExternalCommIntent("expand_full_screen", new Bundle()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.ExpandFullScreenClickEvent.f188485d);
            QLog.d(FrameworkVM.TAG, 1, "onExpandFullScreenClick");
        } else {
            ((ITitleRight1IvApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITitleRight1IvApi.class)).onRight1IvClick((com.tencent.aio.api.runtime.a) getMContext(), AIOUtil.f194084a.n(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.Right1IvClickEvent.f188499d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        af afVar = new af(false, true, ((com.tencent.aio.api.runtime.a) getMContext()).c().getResources().getDrawable(R.drawable.qui_zoom_out_nav_secondary), HardCodeUtil.qqStr(R.string.f170300yu1), 1);
        this.mLastData = afVar;
        updateUI(new Right1UIState.UpdateDataUIState(afVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        af afVar = new af(false, true, ((IAIOTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTitleApi.class)).getRight1Bg((com.tencent.aio.api.runtime.a) getMContext()), HardCodeUtil.qqStr(R.string.f170301yu2), 1);
        this.mLastData = afVar;
        updateUI(new Right1UIState.UpdateDataUIState(afVar));
    }

    @Override // com.tencent.mobileqq.aio.title.al
    public void E(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            o(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
            return;
        }
        if (intent instanceof AIOTitleEvent.UpdateRight1IvEvent) {
            p((AIOTitleEvent.UpdateRight1IvEvent) intent);
            return;
        }
        if (intent instanceof AIOTitleEvent.TitleResponseEvent) {
            AIOTitleEvent.TitleResponseEvent titleResponseEvent = (AIOTitleEvent.TitleResponseEvent) intent;
            s(titleResponseEvent.b(), titleResponseEvent.a());
        } else if (intent instanceof ZPlanMsgEvent.ShowBubbleTipEvent) {
            m((ZPlanMsgEvent.ShowBubbleTipEvent) intent);
        } else if (intent instanceof ScaleAIOEvent.SwitchToFullScreen) {
            r();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateRight1IvEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.TitleResponseEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.ZPlanMsgEvent.ShowBubbleTipEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.ScaleAIOEvent.SwitchToFullScreen");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            l();
        } else if (intent instanceof a.C7364a) {
            t();
        }
    }
}
