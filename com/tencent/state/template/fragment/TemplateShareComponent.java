package com.tencent.state.template.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.invite.ISelectFriendCallback;
import com.tencent.state.template.service.ITemplateShareService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/template/fragment/TemplateShareComponent;", "Lcom/tencent/state/template/fragment/TemplateBaseComponent;", "shareService", "Lcom/tencent/state/template/service/ITemplateShareService;", "(Lcom/tencent/state/template/service/ITemplateShareService;)V", "reporter", "Lcom/tencent/state/square/IReporter;", "selectFriendCallback", "Lcom/tencent/state/square/invite/ISelectFriendCallback;", "getShareService", "()Lcom/tencent/state/template/service/ITemplateShareService;", "doShare", "", "from", "", "sceneType", "getServiceProvider", "Lcom/tencent/state/IVasBaseServiceProvider;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "reportShareEvent", "uin", "", "isTroop", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateShareComponent extends TemplateBaseComponent {
    private static final String TAG = "TemplateShareComponent";
    private IReporter reporter;
    private ISelectFriendCallback selectFriendCallback;
    private final ITemplateShareService shareService;

    public TemplateShareComponent(ITemplateShareService shareService) {
        Intrinsics.checkNotNullParameter(shareService, "shareService");
        this.shareService = shareService;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
    }

    private final IVasBaseServiceProvider getServiceProvider() {
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            return (BasicServiceComponent) VasBaseLifecycleFragment.getComponent$default(fragment, BasicServiceComponent.class, null, null, 6, null);
        }
        return null;
    }

    public final void doShare(int from, int sceneType) {
        ISquareBaseMessageService messageService;
        IVasBaseServiceProvider serviceProvider = getServiceProvider();
        ISelectFriendCallback iSelectFriendCallback = this.selectFriendCallback;
        if (iSelectFriendCallback != null && serviceProvider != null) {
            serviceProvider.deleteSelectFriendCallback(iSelectFriendCallback);
        }
        TemplateShareComponent$doShare$2 templateShareComponent$doShare$2 = new TemplateShareComponent$doShare$2(this, serviceProvider, from, sceneType);
        if (serviceProvider != null) {
            serviceProvider.addSelectFriendCallback(templateShareComponent$doShare$2);
        }
        Unit unit = Unit.INSTANCE;
        this.selectFriendCallback = templateShareComponent$doShare$2;
        if (getActivity() == null || serviceProvider == null || (messageService = serviceProvider.getMessageService()) == null) {
            return;
        }
        messageService.openMiniSelectPage(getFragment(), 1002, false, true, "\u8054\u7cfb\u4eba");
    }

    public final ITemplateShareService getShareService() {
        return this.shareService;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        IVasBaseServiceProvider serviceProvider;
        Intrinsics.checkNotNullParameter(f16, "f");
        ISelectFriendCallback iSelectFriendCallback = this.selectFriendCallback;
        if (iSelectFriendCallback != null && (serviceProvider = getServiceProvider()) != null) {
            serviceProvider.deleteSelectFriendCallback(iSelectFriendCallback);
        }
        this.selectFriendCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportShareEvent(String uin, boolean isTroop, int from, int sceneType) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_friend_or_group", Integer.valueOf(isTroop ? 1 : 0)), TuplesKt.to("zplan_other_user_qq", uin), TuplesKt.to(SquareReportConst.Key.KEY_SHARE_FROM, Integer.valueOf(from)), TuplesKt.to("zplan_event_source_parameters", Integer.valueOf(sceneType)));
        this.reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_DESKMATE_SHARE, mutableMapOf);
    }
}
