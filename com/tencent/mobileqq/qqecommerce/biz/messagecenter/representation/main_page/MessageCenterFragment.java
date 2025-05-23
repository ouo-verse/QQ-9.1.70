package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgDetailSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl.EcommerceMsgCenterImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsFragment;
import com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowCollector;
import mqq.app.Constants;
import zf2.PromotionPanelItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 N2\u00020\u0001:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0015H\u0002J$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010#\u001a\u00020\u0002H\u0016R\u0016\u0010&\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initView", "initNavBar", "Oh", "initViewModel", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/r;", "uiState", "Kh", "Lzf2/a;", "deleteMessage", "Lzf2/e;", "refuseOrReceiveMessage", "Ph", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "messageType", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "Hh", "", "Gh", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "", "", "Ih", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "contentView", "Lcom/tencent/widget/pull2refresh/XRecyclerView;", "D", "Lcom/tencent/widget/pull2refresh/XRecyclerView;", "xRecyclerView", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterPromotionPanel;", "E", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterPromotionPanel;", "promotionPanelView", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/b;", "messageCenterAdapter", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterViewModel;", "G", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterViewModel;", "viewModel", "Lhg2/a;", "H", "Lkotlin/Lazy;", "Jh", "()Lhg2/a;", "schemeManager", "Lcom/tencent/mobileqq/qqecommerce/biz/report/ECDataReportManager;", "I", "Lcom/tencent/mobileqq/qqecommerce/biz/report/ECDataReportManager;", "reportManager", "", "J", "Ljava/util/Set;", "reportedExposureMessages", "K", "Ljava/util/Map;", "mapWithUin", "", "L", "Z", "isNightModeNow", "<init>", "()V", "M", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageCenterFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup contentView;

    /* renamed from: D, reason: from kotlin metadata */
    private XRecyclerView xRecyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private MessageCenterPromotionPanel promotionPanelView;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.b messageCenterAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private MessageCenterViewModel viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy schemeManager;

    /* renamed from: I, reason: from kotlin metadata */
    private final ECDataReportManager reportManager;

    /* renamed from: J, reason: from kotlin metadata */
    private final Set<String> reportedExposureMessages;

    /* renamed from: K, reason: from kotlin metadata */
    private final Map<Object, Object> mapWithUin;

    /* renamed from: L, reason: from kotlin metadata */
    private final boolean isNightModeNow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/r;", "it", "", "a", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/r;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    static final class c<T> implements FlowCollector {
        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(r rVar, Continuation<? super Unit> continuation) {
            QLog.d("ECMsgCenter|MessageCenterFragment", 2, "operationFlow updated. " + rVar + ": isSucceed = " + rVar.getIsSucceed());
            MessageCenterFragment.this.Kh(rVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterFragment$d", "Lcom/tencent/widget/pull2refresh/XRecyclerView$RefreshCallback;", "Lcom/tencent/widget/pull2refresh/XRecyclerView;", "recyclerView", "", "isMachineRefresh", "", "startTopRefresh", "", "reqType", "startLoadMore", "endOfRefresh", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements XRecyclerView.RefreshCallback {
        d() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void endOfRefresh() {
            QLog.d("ECMsgCenter|MessageCenterFragment", 2, "endOfRefresh");
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startLoadMore(XRecyclerView recyclerView, int reqType) {
            QLog.d("ECMsgCenter|MessageCenterFragment", 2, "startLoadMore");
            MessageCenterViewModel messageCenterViewModel = MessageCenterFragment.this.viewModel;
            if (messageCenterViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                messageCenterViewModel = null;
            }
            messageCenterViewModel.S1();
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startTopRefresh(XRecyclerView recyclerView, boolean isMachineRefresh) {
            QLog.d("ECMsgCenter|MessageCenterFragment", 2, "startTopRefresh");
            MessageCenterViewModel messageCenterViewModel = MessageCenterFragment.this.viewModel;
            if (messageCenterViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                messageCenterViewModel = null;
            }
            messageCenterViewModel.U1();
        }
    }

    public MessageCenterFragment() {
        Lazy lazy;
        Map<Object, Object> mapOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<hg2.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment$schemeManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final hg2.a invoke() {
                return new hg2.a();
            }
        });
        this.schemeManager = lazy;
        this.reportManager = new ECDataReportManager();
        this.reportedExposureMessages = new LinkedHashSet();
        ECRuntimeManager.Companion companion = ECRuntimeManager.INSTANCE;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("uin", Long.valueOf(companion.e())));
        this.mapWithUin = mapOf;
        this.isNightModeNow = ThemeUtil.isNowThemeIsNight(companion.b(), false, null);
    }

    private final String Gh(MessageType messageType) {
        com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e Hh = Hh(messageType);
        if (Hh instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a) {
            String string = getString(R.string.f169657ww1, messageType.getText());
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             \u2026geType.text\n            )");
            return string;
        }
        if (Hh instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.f) {
            String string2 = getString(R.string.f169658ww2, messageType.getText());
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.ecomm\u2026e_type, messageType.text)");
            return string2;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e Hh(MessageType messageType) {
        com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e b16;
        MessageCenterViewModel messageCenterViewModel = this.viewModel;
        if (messageCenterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageCenterViewModel = null;
        }
        HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e> value = messageCenterViewModel.X1().getValue();
        if (value == null || (b16 = value.get(messageType)) == null) {
            b16 = com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.d.b();
        }
        Intrinsics.checkNotNullExpressionValue(b16, "viewModel.messageTypeToS\u2026FAULT_MESSAGE_TYPE_STATUS");
        if (b16 instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a) {
            return new com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.f(b16.getSwitchable());
        }
        if (b16 instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.f) {
            return new com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a(b16.getSwitchable());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final hg2.a Jh() {
        return (hg2.a) this.schemeManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(r uiState) {
        String string;
        if (uiState instanceof a) {
            if (uiState.getIsSucceed()) {
                QQToast.makeText(requireContext(), "\u6d88\u606f\u5220\u9664\u6210\u529f", 2).show();
                return;
            } else {
                QQToast.makeText(requireContext(), getString(R.string.wvx), 1).show();
                return;
            }
        }
        if (uiState instanceof s) {
            if (uiState.getIsSucceed()) {
                s sVar = (s) uiState;
                com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e newStatus = sVar.getNewStatus();
                if (newStatus instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a) {
                    string = getString(R.string.wvy, sVar.getType().getText());
                } else if (newStatus instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.f) {
                    string = getString(R.string.wvz, sVar.getType().getText());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                Intrinsics.checkNotNullExpressionValue(string, "when (uiState.newStatus)\u2026xt)\n                    }");
                QQToast.makeText(requireContext(), string, 2).show();
                return;
            }
            QQToast.makeText(requireContext(), getString(R.string.ww5), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(MessageCenterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        XRecyclerView xRecyclerView = this$0.xRecyclerView;
        if (xRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            xRecyclerView = null;
        }
        xRecyclerView.backToTopAtOnce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Oh() {
        String str;
        int i3 = this.isNightModeNow ? -16777216 : -1;
        ViewGroup viewGroup = this.contentView;
        XRecyclerView xRecyclerView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.ogu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.recyclerView)");
        XRecyclerView xRecyclerView2 = (XRecyclerView) findViewById;
        this.xRecyclerView = xRecyclerView2;
        if (xRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            xRecyclerView2 = null;
        }
        xRecyclerView2.setPullHeaderBgDrawable(new ColorDrawable(i3));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        MessageCenterPromotionPanel messageCenterPromotionPanel = new MessageCenterPromotionPanel(requireContext);
        messageCenterPromotionPanel.setOnPromotionViewClick(new Function1<PromotionPanelItem, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment$initXRecyclerView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PromotionPanelItem promotionPanelItem) {
                invoke2(promotionPanelItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PromotionPanelItem item) {
                hg2.a Jh;
                ECDataReportManager eCDataReportManager;
                Map map;
                Map mapOf;
                Map plus;
                Intrinsics.checkNotNullParameter(item, "item");
                Jh = MessageCenterFragment.this.Jh();
                Jh.handleOtherScheme(item.getJumpUrl());
                eCDataReportManager = MessageCenterFragment.this.reportManager;
                map = MessageCenterFragment.this.mapWithUin;
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("feature", item.getName()));
                plus = MapsKt__MapsKt.plus(map, mapOf);
                IECDataReport.a.a(eCDataReportManager, "ds_service_feature_clk", plus, false, 4, null);
            }
        });
        this.promotionPanelView = messageCenterPromotionPanel;
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.b bVar = new com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.b(requireContext2);
        bVar.x(new Function2<zf2.a, zf2.e, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment$initXRecyclerView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(zf2.a aVar, zf2.e eVar) {
                invoke2(aVar, eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(zf2.a deleteMessage, zf2.e refuseOrReceiveMessage) {
                Intrinsics.checkNotNullParameter(deleteMessage, "deleteMessage");
                Intrinsics.checkNotNullParameter(refuseOrReceiveMessage, "refuseOrReceiveMessage");
                MessageCenterFragment.this.Ph(deleteMessage, refuseOrReceiveMessage);
            }
        });
        bVar.w(new Function1<MessageItem, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment$initXRecyclerView$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageItem messageItem) {
                invoke2(messageItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessageItem item) {
                Set set;
                ECDataReportManager eCDataReportManager;
                Map map;
                Map Ih;
                Map plus;
                Set set2;
                Intrinsics.checkNotNullParameter(item, "item");
                set = MessageCenterFragment.this.reportedExposureMessages;
                if (set.contains(item.getId())) {
                    return;
                }
                eCDataReportManager = MessageCenterFragment.this.reportManager;
                map = MessageCenterFragment.this.mapWithUin;
                Ih = MessageCenterFragment.this.Ih(item);
                plus = MapsKt__MapsKt.plus(map, Ih);
                IECDataReport.a.a(eCDataReportManager, "ds_ecom_message_ark_exp", plus, false, 4, null);
                set2 = MessageCenterFragment.this.reportedExposureMessages;
                set2.add(item.getId());
            }
        });
        bVar.v(new Function2<MessageItem, Boolean, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment$initXRecyclerView$2$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(MessageItem messageItem, Boolean bool) {
                invoke(messageItem, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MessageItem item, boolean z16) {
                ECDataReportManager eCDataReportManager;
                Map map;
                Map Ih;
                Map plus;
                hg2.a Jh;
                Intrinsics.checkNotNullParameter(item, "item");
                if (z16) {
                    Jh = MessageCenterFragment.this.Jh();
                    Jh.handleWebScheme(item.getJumpUrl(), null);
                }
                eCDataReportManager = MessageCenterFragment.this.reportManager;
                map = MessageCenterFragment.this.mapWithUin;
                Ih = MessageCenterFragment.this.Ih(item);
                plus = MapsKt__MapsKt.plus(map, Ih);
                IECDataReport.a.a(eCDataReportManager, "ds_ecom_message_ark_clk", plus, false, 4, null);
            }
        });
        this.messageCenterAdapter = bVar;
        XRecyclerView xRecyclerView3 = this.xRecyclerView;
        if (xRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            xRecyclerView3 = null;
        }
        xRecyclerView3.setRefreshCallback(new d());
        XRecyclerView xRecyclerView4 = this.xRecyclerView;
        if (xRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            xRecyclerView4 = null;
        }
        RecyclerViewWithHeaderFooter recyclerView = xRecyclerView4.getRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        MessageCenterPromotionPanel messageCenterPromotionPanel2 = this.promotionPanelView;
        if (messageCenterPromotionPanel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promotionPanelView");
            messageCenterPromotionPanel2 = null;
        }
        recyclerView.addHeaderView(messageCenterPromotionPanel2);
        com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.b bVar2 = this.messageCenterAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageCenterAdapter");
            bVar2 = null;
        }
        recyclerView.setAdapter(bVar2);
        if (this.isNightModeNow) {
            str = "#121212";
        } else {
            str = "#F5F5F5";
        }
        XRecyclerView xRecyclerView5 = this.xRecyclerView;
        if (xRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
        } else {
            xRecyclerView = xRecyclerView5;
        }
        xRecyclerView.setBackgroundColor(Color.parseColor(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(final zf2.a deleteMessage, final zf2.e refuseOrReceiveMessage) {
        String str;
        String str2;
        int parseColor = this.isNightModeNow ? Color.parseColor("#282828") : -1;
        if (this.isNightModeNow) {
            str = "#8CFFFFFF";
        } else {
            str = "#999999";
        }
        int parseColor2 = Color.parseColor(str);
        boolean z16 = this.isNightModeNow;
        int i3 = z16 ? -1 : -16777216;
        if (z16) {
            str2 = "#121212";
        } else {
            str2 = "#F5F5F5";
        }
        int parseColor3 = Color.parseColor(str2);
        View inflate = LayoutInflater.from(requireContext()).inflate(R.layout.cvn, (ViewGroup) null, false);
        inflate.setBackgroundColor(parseColor);
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(requireContext());
        aVar.setContentView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.f163129og3);
        textView.setTextColor(i3);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterFragment.Qh(com.google.android.material.bottomsheet.a.this, view);
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.ogy);
        textView2.setTextColor(parseColor2);
        textView2.setText(refuseOrReceiveMessage.getType().getText());
        inflate.findViewById(R.id.ogc).setBackgroundColor(parseColor3);
        TextView textView3 = (TextView) inflate.findViewById(R.id.og9);
        textView3.setTextColor(i3);
        textView3.setText("\u5220\u9664\u6d88\u606f");
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterFragment.Rh(MessageCenterFragment.this, deleteMessage, aVar, view);
            }
        });
        boolean switchable = refuseOrReceiveMessage.getStatus().getSwitchable();
        TextView textView4 = (TextView) inflate.findViewById(R.id.ogv);
        if (switchable) {
            textView4.setVisibility(0);
            textView4.setTextColor(i3);
            textView4.setText(Gh(refuseOrReceiveMessage.getType()));
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessageCenterFragment.Sh(MessageCenterFragment.this, refuseOrReceiveMessage, aVar, view);
                }
            });
        } else {
            textView4.setVisibility(8);
        }
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(com.google.android.material.bottomsheet.a dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(MessageCenterFragment this$0, zf2.a deleteMessage, com.google.android.material.bottomsheet.a dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deleteMessage, "$deleteMessage");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        MessageCenterViewModel messageCenterViewModel = this$0.viewModel;
        if (messageCenterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageCenterViewModel = null;
        }
        messageCenterViewModel.Q1(deleteMessage.getMessageId());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(MessageCenterFragment this$0, zf2.e refuseOrReceiveMessage, com.google.android.material.bottomsheet.a dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(refuseOrReceiveMessage, "$refuseOrReceiveMessage");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        MessageCenterViewModel messageCenterViewModel = this$0.viewModel;
        if (messageCenterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageCenterViewModel = null;
        }
        messageCenterViewModel.e2(refuseOrReceiveMessage.getType(), this$0.Hh(refuseOrReceiveMessage.getType()));
        dialog.dismiss();
    }

    private final void initNavBar() {
        int parseColor = this.isNightModeNow ? Color.parseColor("#1A1A1A") : -1;
        int i3 = this.isNightModeNow ? -1 : -16777216;
        ViewGroup viewGroup = this.contentView;
        Drawable drawable = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            viewGroup = null;
        }
        NavBarCommon navBarCommon = (NavBarCommon) viewGroup.findViewById(R.id.ogl);
        ViewGroup.LayoutParams layoutParams = navBarCommon.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).topMargin = ImmersiveUtils.getStatusBarHeight(requireContext());
        navBarCommon.setLayoutParams(layoutParams);
        navBarCommon.setTitle(getString(R.string.f169659ww3));
        navBarCommon.changeBg(!this.isNightModeNow);
        navBarCommon.setBackgroundColor(parseColor);
        navBarCommon.setTitleColor(i3);
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), R.drawable.ewc);
        if (drawable2 != null) {
            DrawableCompat.setTint(drawable2, i3);
        } else {
            drawable2 = null;
        }
        navBarCommon.setRightImage(drawable2, null);
        Drawable drawable3 = ContextCompat.getDrawable(requireContext(), R.drawable.ewf);
        if (drawable3 != null) {
            DrawableCompat.setTint(drawable3, i3);
            drawable = drawable3;
        }
        navBarCommon.setRightImage2(drawable);
        navBarCommon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterFragment.Lh(MessageCenterFragment.this, view);
            }
        });
        navBarCommon.setOnItemSelectListener(new b());
    }

    private final void initView() {
        initNavBar();
        Oh();
    }

    private final void initViewModel() {
        MessageCenterModule messageCenterModule = MessageCenterModule.f263229a;
        MessageCenterViewModel messageCenterViewModel = (MessageCenterViewModel) new p(messageCenterModule.o(), messageCenterModule.j(), messageCenterModule.i()).create(MessageCenterViewModel.class);
        this.viewModel = messageCenterViewModel;
        if (messageCenterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageCenterViewModel = null;
        }
        LiveData<List<PromotionPanelItem>> b26 = messageCenterViewModel.b2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends PromotionPanelItem>, Unit> function1 = new Function1<List<? extends PromotionPanelItem>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PromotionPanelItem> list) {
                invoke2((List<PromotionPanelItem>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PromotionPanelItem> it) {
                MessageCenterPromotionPanel messageCenterPromotionPanel;
                QLog.d("ECMsgCenter|MessageCenterFragment", 2, "promotionItemList updated. size = " + it.size());
                messageCenterPromotionPanel = MessageCenterFragment.this.promotionPanelView;
                if (messageCenterPromotionPanel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promotionPanelView");
                    messageCenterPromotionPanel = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                messageCenterPromotionPanel.setDataList(it);
            }
        };
        b26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageCenterFragment.Mh(Function1.this, obj);
            }
        });
        MessageCenterViewModel messageCenterViewModel2 = this.viewModel;
        if (messageCenterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageCenterViewModel2 = null;
        }
        LiveData<HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e>> X1 = messageCenterViewModel2.X1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e>, Unit> function12 = new Function1<HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e> hashMap) {
                b bVar;
                QLog.d("ECMsgCenter|MessageCenterFragment", 2, "messageTypeToStatus updated. size = " + hashMap.size());
                Set<MessageType> keySet = hashMap.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "it.keys");
                MessageCenterFragment messageCenterFragment = MessageCenterFragment.this;
                for (MessageType type : keySet) {
                    bVar = messageCenterFragment.messageCenterAdapter;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("messageCenterAdapter");
                        bVar = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(type, "type");
                    com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e eVar = hashMap.get(type);
                    if (eVar == null) {
                        eVar = com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.d.b();
                    }
                    Intrinsics.checkNotNullExpressionValue(eVar, "it[type] ?: DEFAULT_MESSAGE_TYPE_STATUS");
                    bVar.y(type, eVar);
                }
            }
        };
        X1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageCenterFragment.Nh(Function1.this, obj);
            }
        });
        Lifecycle.State state = Lifecycle.State.STARTED;
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new MessageCenterFragment$initViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, state, null, this), 3, null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new MessageCenterFragment$initViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, state, null, this), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.cvl, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.contentView = viewGroup;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.reportedExposureMessages.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
        IECDataReport.a.a(this.reportManager, "ds_service_message_page_exp", this.mapWithUin, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Object, Object> Ih(MessageItem messageItem) {
        Map<Object, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("ark_type", Integer.valueOf(messageItem.getStyle().getValue())), TuplesKt.to(RemoteMessageConst.MSGTYPE, messageItem.getType().getText()), TuplesKt.to("activity_id", messageItem.getId()));
        return mapOf;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterFragment$b", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.widget.navbar.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View v3, int item) {
            if (item == 1) {
                FragmentActivity activity = MessageCenterFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (item == 4) {
                QPublicFragmentActivity.start(MessageCenterFragment.this.getContext(), MessageTypeSettingsFragment.class);
            } else {
                if (item != 5) {
                    return;
                }
                EcommerceMsgCenterImpl.Companion companion = EcommerceMsgCenterImpl.INSTANCE;
                Context requireContext = MessageCenterFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                companion.a(requireContext, EcommerceMsgDetailSource.MAIN_PAGE);
            }
        }
    }
}
