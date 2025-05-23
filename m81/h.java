package m81;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOCenterContainerEvent;
import com.tencent.mobileqq.aio.event.AIOGestureEvent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.TitleTabEvent;
import com.tencent.mobileqq.aio.input.joinstate.GroupJoinStateIntent;
import com.tencent.mobileqq.aio.title.ab;
import com.tencent.mobileqq.aio.title.al;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.aio.title.troopguild.TroopGuildTitleTabUIState;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m81.a;
import m81.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u001f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lm81/h;", "Lcom/tencent/mobileqq/aio/title/al;", "Lm81/a;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE, "", "u", "r", "", "from", "withAnim", "o", "p", "entryMode", ReportConstant.COSTREPORT_PREFIX, "reportClick", "t", "isLeft", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "E", DomainData.DOMAIN_NAME, "m81/h$a", "f", "Lm81/h$a;", "mActionR", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h extends al<m81.a, TroopGuildTitleTabUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mActionR = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"m81/h$a", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.b {
        a() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return h.this.I(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent intent) {
        if (intent instanceof TitleTabEvent.GetTitleTabStatusEvent) {
            return m();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final k m() {
        Bundle b16 = fetchVBState(g.a.f416436a).b();
        return new m.g(b16.getBoolean("KEY_TITLE_TAB_SHOW", false), b16.getBoolean("KEY_MSG_TAB_SELECTED", false), b16.getBoolean("KEY_FEED_TAB_SELECTED", false));
    }

    private final void o(int from, boolean withAnim) {
        updateUI(new TroopGuildTitleTabUIState.SelectFeedTab(from, withAnim, 0));
    }

    private final void p() {
        updateUI(TroopGuildTitleTabUIState.SelectMsgTab.f194036d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean q(boolean isLeft) {
        if (AIOUtil.f194084a.x(((com.tencent.aio.api.runtime.a) getMContext()).g().r()) && !com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.j((com.tencent.aio.api.runtime.a) getMContext()) && !am.f194110a.j((com.tencent.aio.api.runtime.a) getMContext())) {
            Bundle b16 = fetchVBState(g.a.f416436a).b();
            boolean z16 = b16.getBoolean("KEY_MSG_TAB_SELECTED", false);
            boolean z17 = b16.getBoolean("KEY_FEED_TAB_SELECTED", false);
            if (isLeft && z16) {
                updateUI(new TroopGuildTitleTabUIState.SelectFeedTab(0, true, 2));
                return true;
            }
            if (!isLeft && z17) {
                updateUI(TroopGuildTitleTabUIState.SelectMsgTab.f194036d);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        if (AIOUtil.f194084a.x(((com.tencent.aio.api.runtime.a) getMContext()).g().r())) {
            QLog.i(FrameworkVM.TAG, 1, "[onBind]: isTroopGuild, contact: " + ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c());
            Map<String, Object> fetchGuildTroopTitleData = ((IGuildTroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildTroopApi.class)).fetchGuildTroopTitleData();
            Object obj = fetchGuildTroopTitleData.get("showRedDot");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = fetchGuildTroopTitleData.get("visiable");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue2 = ((Boolean) obj2).booleanValue();
            Object obj3 = fetchGuildTroopTitleData.get("msgTab_unselectRes");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            Object obj4 = fetchGuildTroopTitleData.get("msgTab_selectRes");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) obj4).intValue();
            Object obj5 = fetchGuildTroopTitleData.get("feedTab_unselectRes");
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
            int intValue3 = ((Integer) obj5).intValue();
            Object obj6 = fetchGuildTroopTitleData.get("feedTab_selectRes");
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
            updateUI(new TroopGuildTitleTabUIState.UpdateGuildTroopState(new ab(booleanValue, booleanValue2, intValue, intValue2, intValue3, ((Integer) obj6).intValue())));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTitleEvent.UpdateRight2IvEvent(false, false, null, 0, ""));
            return;
        }
        updateUI(new TroopGuildTitleTabUIState.UpdateGuildTroopState(new ab(false, false, 0, 0, 0, 0)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(int from, int entryMode) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent(FrameworkVM.TAG, false, 2, null));
        Fragment feedFragment = ((IGuildTroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildTroopApi.class)).getFeedFragment(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOCenterContainerEvent.ShowFragment(feedFragment, true));
        if (feedFragment == null) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new TitleTabEvent.GetFeedFragmentFailEvent(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j()));
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new TitleTabEvent.OnFeedTabSelected(from, entryMode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(boolean withAnim, boolean reportClick) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOCenterContainerEvent.HideFragment(withAnim));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new TitleTabEvent.OnMsgTabSelected(reportClick));
    }

    private final void u(boolean join) {
        if (!join) {
            updateUI(new TroopGuildTitleTabUIState.SetVisibility(false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.title.al
    public void E(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof TitleTabEvent.TroopGuildTitleEvent) {
            TitleTabEvent.TroopGuildTitleEvent troopGuildTitleEvent = (TitleTabEvent.TroopGuildTitleEvent) intent;
            updateUI(new TroopGuildTitleTabUIState.UpdateTroopGuildTab(troopGuildTitleEvent.b(), troopGuildTitleEvent.a()));
            return;
        }
        if (intent instanceof TitleTabEvent.SelectFeedTab) {
            TitleTabEvent.SelectFeedTab selectFeedTab = (TitleTabEvent.SelectFeedTab) intent;
            o(selectFeedTab.a(), selectFeedTab.b());
            return;
        }
        if (intent instanceof TitleTabEvent.SelectMsgTab) {
            p();
            return;
        }
        if (intent instanceof TitleTabEvent.SetTabVisibility) {
            updateUI(new TroopGuildTitleTabUIState.SetVisibility(((TitleTabEvent.SetTabVisibility) intent).a()));
            return;
        }
        if (intent instanceof AIOGestureEvent.LeftSwipeEvent) {
            ((AIOGestureEvent.LeftSwipeEvent) intent).b(q(true));
            return;
        }
        if (intent instanceof AIOGestureEvent.RightSwipeEvent) {
            ((AIOGestureEvent.RightSwipeEvent) intent).b(q(false));
        } else if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            updateUI(new TroopGuildTitleTabUIState.MultiSelectModeChangeState(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b(), AIOUtil.f194084a.x(((com.tencent.aio.api.runtime.a) getMContext()).g().r())));
        } else if (intent instanceof GroupJoinStateIntent.GroupJoinStateChange) {
            u(((GroupJoinStateIntent.GroupJoinStateChange) intent).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOGestureEvent.LeftSwipeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOGestureEvent.RightSwipeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.SelectFeedTab");
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.SelectMsgTab");
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.TroopGuildTitleEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.SetTabVisibility");
        hashSet.add("com.tencent.mobileqq.aio.input.joinstate.GroupJoinStateIntent.GroupJoinStateChange");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.GetTitleTabStatusEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull m81.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.FeedTabSelectEvent) {
            a.FeedTabSelectEvent feedTabSelectEvent = (a.FeedTabSelectEvent) intent;
            s(feedTabSelectEvent.getFrom(), feedTabSelectEvent.getEntryMode());
        } else if (intent instanceof a.MsgTabSelectEvent) {
            a.MsgTabSelectEvent msgTabSelectEvent = (a.MsgTabSelectEvent) intent;
            t(msgTabSelectEvent.getWithAnim(), msgTabSelectEvent.getReportClick());
        } else if (intent instanceof a.c) {
            r();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.title.al, com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.title.al, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
    }
}
