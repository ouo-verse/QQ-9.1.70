package com.tencent.mobileqq.qwallet.hb.panel;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ViewKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$Promotion;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001fB\u0017\u0012\u0006\u0010c\u001a\u00020b\u0012\u0006\u0010+\u001a\u00020\r\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J%\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0014J\b\u0010\u001c\u001a\u00020\u0005H\u0014J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010+\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020:098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR,\u0010X\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0T0S0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR \u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0T0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010WR \u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070T0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010WR\u0016\u0010_\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010^\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketPanel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/qwallet/hb/b;", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "Lcom/tencent/mobileqq/qwallet/hb/panel/b;", "", "N0", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "tabData", "", "E0", "J0", "K0", "", "skinId", "L0", "hbType", "G0", "(Ljava/lang/Integer;I)V", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "Lcom/tencent/mobileqq/qwallet/a;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "O0", "M", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onShow", "onHide", "i0", "(Ljava/lang/Integer;)V", "Q5", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", SkinResFactory.SKIN_THEME_APK_SAVE_DIR, "k0", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;", "promotion", "a0", "getSessionInfo", "d", "I", "panelTheme", "e", "Lcom/tencent/mobileqq/activity/aio/p;", "f", "Lcom/tencent/mobileqq/qwallet/a;", "panelStrategy", "Lcom/tencent/mobileqq/qwallet/hb/panel/c;", tl.h.F, "Lcom/tencent/mobileqq/qwallet/hb/panel/c;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[Landroid/widget/TextView;", "bottomTabs", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "bottomTabsContainer", "Landroidx/fragment/app/DialogFragment;", "D", "Landroidx/fragment/app/DialogFragment;", "unclaimedHbDialog", "E", "previewDialog", "Landroid/content/BroadcastReceiver;", UserInfo.SEX_FEMALE, "Landroid/content/BroadcastReceiver;", "mReceiver", "Lcom/tencent/mobileqq/qwallet/hb/panel/PanelViewModel;", "G", "Lkotlin/Lazy;", "F0", "()Lcom/tencent/mobileqq/qwallet/hb/panel/PanelViewModel;", "viewModel", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/qwallet/pb/a;", "H", "Landroidx/lifecycle/Observer;", "skinsObserver", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "hbEntryObserver", "J", "bottomTabObserver", "K", "Z", "isAttached", "L", "isVisible", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes16.dex */
public final class RedPacketPanel extends ConstraintLayout implements com.tencent.mobileqq.qwallet.hb.b, a, b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View bottomTabsContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private DialogFragment unclaimedHbDialog;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private DialogFragment previewDialog;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final BroadcastReceiver mReceiver;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Observer<Pair<Integer, List<com.tencent.mobileqq.qwallet.pb.a>>> skinsObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<PanelEntryData>> hbEntryObserver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<PanelTabData>> bottomTabObserver;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isAttached;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isVisible;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int panelTheme;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private p sessionInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qwallet.a panelStrategy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView[] bottomTabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedPacketPanel(@NotNull Context context, int i3) {
        super(context, null);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.panelTheme = i3;
        this.mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qwallet.hb.panel.RedPacketPanel$mReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context2, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                QLog.i("RedPacketPanel", 1, "onReceive: action = " + action);
                if (Intrinsics.areEqual("com.tencent.mobileqq.qwallet.hb.skin.refresh", action)) {
                    RedPacketPanel.this.K0();
                }
            }
        };
        View.inflate(new ContextThemeWrapper(context, i3), R.layout.f168984hk1, this);
        c cVar = new c(this);
        this.adapter = cVar;
        View findViewById = findViewById(R.id.f223903l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.panel_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 12);
        gridLayoutManager.setSpanSizeLookup(new d(cVar));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(cVar);
        recyclerView.setItemAnimator(null);
        View findViewById2 = findViewById(R.id.f164639tb2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.bottom_tabs)");
        this.bottomTabsContainer = findViewById2;
        View findViewById3 = findViewById(R.id.f2222035);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.panel_bottom_tab_1)");
        View findViewById4 = findViewById(R.id.f2223036);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.panel_bottom_tab_2)");
        View findViewById5 = findViewById(R.id.f2224037);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.panel_bottom_tab_3)");
        this.bottomTabs = new TextView[]{(TextView) findViewById3, (TextView) findViewById4, (TextView) findViewById5};
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PanelViewModel>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.RedPacketPanel$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PanelViewModel invoke() {
                return (PanelViewModel) new ViewModelProvider(ViewKt.findFragment(RedPacketPanel.this).requireActivity()).get(PanelViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.skinsObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.panel.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RedPacketPanel.M0(RedPacketPanel.this, (Pair) obj);
            }
        };
        this.hbEntryObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.panel.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RedPacketPanel.I0(RedPacketPanel.this, (List) obj);
            }
        };
        this.bottomTabObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.panel.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RedPacketPanel.D0(RedPacketPanel.this, (List) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(RedPacketPanel this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N0();
    }

    private final boolean E0(PanelTabData tabData) {
        com.tencent.mobileqq.qwallet.a aVar;
        if (tabData == null || (aVar = this.panelStrategy) == null) {
            return false;
        }
        int type = tabData.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    return false;
                }
                return aVar.d();
            }
            return aVar.c();
        }
        return aVar.e();
    }

    private final PanelViewModel F0() {
        return (PanelViewModel) this.viewModel.getValue();
    }

    private final void G0(Integer hbType, int skinId) {
        int i3;
        if (hbType == null) {
            com.tencent.mobileqq.qwallet.a aVar = this.panelStrategy;
            if (aVar != null) {
                hbType = Integer.valueOf(aVar.f());
            } else {
                hbType = null;
            }
            if (hbType == null) {
                i3 = -1;
                m.f277567a.f(this.sessionInfo, getContext(), i3, Integer.valueOf(skinId), false);
            }
        }
        i3 = hbType.intValue();
        m.f277567a.f(this.sessionInfo, getContext(), i3, Integer.valueOf(skinId), false);
    }

    static /* synthetic */ void H0(RedPacketPanel redPacketPanel, Integer num, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            num = null;
        }
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        redPacketPanel.G0(num, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(RedPacketPanel this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("RedPacketPanel", 2, "hbEntryObserver: " + it.size());
        c cVar = this$0.adapter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        cVar.o0(it);
        this$0.N0();
    }

    private final void J0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.qwallet.hb.skin.refresh");
        try {
            getContext().registerReceiver(this.mReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e("RedPacketPanel", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0() {
        com.tencent.mobileqq.qwallet.a aVar;
        p pVar;
        QLog.d("RedPacketPanel", 1, "requestData: " + this.isAttached);
        if (!this.isAttached || (aVar = this.panelStrategy) == null || (pVar = this.sessionInfo) == null) {
            return;
        }
        if (aVar.b()) {
            F0().X1(0);
        } else {
            F0().N1();
        }
        F0().U1(pVar);
    }

    private final void L0(int skinId) {
        FragmentActivity fragmentActivity;
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            return;
        }
        if (fragmentActivity.isFinishing()) {
            QLog.d("RedPacketPanel", 2, "showSkinPreview: activity is finishing " + fragmentActivity);
            return;
        }
        SkinPreviewDialogFragment a16 = SkinPreviewDialogFragment.INSTANCE.a(0, skinId, this.panelTheme);
        a16.Jh(this);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        a16.show(supportFragmentManager, "skin_preview_dialog_fragment");
        this.previewDialog = a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(RedPacketPanel this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("RedPacketPanel", 2, "skinsObserver: displayType " + pair.getFirst() + ", list " + RedPackSkinExt.a((List) pair.getSecond()));
        this$0.adapter.p0(((Number) pair.getFirst()).intValue(), (List) pair.getSecond());
        this$0.N0();
    }

    private final void N0() {
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        List<PanelTabData> emptyList;
        Object orNull;
        int i16;
        int collectionSizeOrDefault;
        List<com.tencent.mobileqq.qwallet.pb.a> second;
        List<PanelTabData> value = F0().O1().getValue();
        if (value == null) {
            return;
        }
        Pair<Integer, List<com.tencent.mobileqq.qwallet.pb.a>> value2 = F0().getSkinRecommendVM().X1().getValue();
        if (value2 != null && (second = value2.getSecond()) != null && (!second.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        List<PanelEntryData> value3 = F0().P1().getValue();
        if (value3 != null) {
            i3 = value3.size();
        } else {
            i3 = 0;
        }
        if (i3 > 8) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            this.bottomTabsContainer.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (E0((PanelTabData) obj)) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((PanelTabData) it.next()).getName());
            }
            QLog.i("RedPacketPanel", 1, "followMode hb record entry: " + arrayList2);
            this.adapter.n0(arrayList);
            return;
        }
        c cVar = this.adapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        cVar.n0(emptyList);
        this.bottomTabsContainer.setVisibility(0);
        TextView[] textViewArr = this.bottomTabs;
        int length = textViewArr.length;
        int i17 = 0;
        int i18 = 0;
        while (i17 < length) {
            TextView textView = textViewArr[i17];
            int i19 = i18 + 1;
            orNull = CollectionsKt___CollectionsKt.getOrNull(value, i18);
            final PanelTabData panelTabData = (PanelTabData) orNull;
            boolean E0 = E0(panelTabData);
            if (E0) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            textView.setVisibility(i16);
            if (E0 && panelTabData != null) {
                textView.setText(panelTabData.getName());
                if (panelTabData.getType() == 2) {
                    com.tencent.mobileqq.qwallet.c.f("unGrabHB.entry.show", null, null, null, null, 30, null);
                }
                com.tencent.mobileqq.qwallet.k.d(textView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.RedPacketPanel$updateBottomTab$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RedPacketPanel.this.M(panelTabData);
                    }
                }, 1, null);
                QLog.i("RedPacketPanel", 1, "floatingMode hb record entry: " + i18);
            }
            i17++;
            i18 = i19;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.a
    public void M(@NotNull PanelTabData tabData) {
        Intrinsics.checkNotNullParameter(tabData, "tabData");
        int type = tabData.getType();
        if (type != 1) {
            FragmentActivity fragmentActivity = null;
            if (type != 2) {
                if (type == 3) {
                    ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644((BaseQQAppInterface) null, "skinArea.panel.click", this.sessionInfo);
                    ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doStartBrowser(getContext(), tabData.getUrl());
                    return;
                }
                return;
            }
            p pVar = this.sessionInfo;
            if (pVar == null) {
                return;
            }
            Context context = getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            }
            if (fragmentActivity == null) {
                return;
            }
            if (fragmentActivity.isFinishing()) {
                QLog.d("RedPacketPanel", 2, "showSkinPreview: activity is finishing " + fragmentActivity);
                return;
            }
            INewQWalletApi iNewQWalletApi = (INewQWalletApi) QRoute.api(INewQWalletApi.class);
            String str = pVar.f179559f;
            Intrinsics.checkNotNullExpressionValue(str, "session.troopUin");
            DialogFragment startUnclaimed = iNewQWalletApi.startUnclaimed(str);
            startUnclaimed.show(fragmentActivity.getSupportFragmentManager(), "unclaimed_dialog_fragment");
            this.unclaimedHbDialog = startUnclaimed;
            return;
        }
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doStartBrowser(getContext(), tabData.getUrl());
    }

    public final void O0(@NotNull p sessionInfo, @NotNull com.tencent.mobileqq.qwallet.a strategy, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        QLog.d("RedPacketPanel", 1, "updateSessionAndStrategy: " + sessionInfo + ", " + strategy);
        this.sessionInfo = sessionInfo;
        this.panelStrategy = strategy;
        com.tencent.mobileqq.qwallet.hb.panel.preview.f.f277592a.e(sessionInfo, strategy.f());
        ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).bindAioContext(aioContext);
        K0();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.b
    public void Q5(int skinId) {
        H0(this, null, skinId, 1, null);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.a
    public void a0(@NotNull RedPackSkin$Promotion promotion) {
        Intrinsics.checkNotNullParameter(promotion, "promotion");
        com.tencent.mobileqq.qwallet.utils.k.h(getContext(), promotion.url.get());
        if (promotion.source.get() == 1) {
            ml2.c cVar = ml2.c.f416921a;
            String str = promotion.adid.get();
            String str2 = "";
            if (str == null) {
                str = "";
            }
            String str3 = promotion.trace_info.get();
            if (str3 != null) {
                str2 = str3;
            }
            cVar.a(102, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.a
    @Nullable
    public p getSessionInfo() {
        return this.sessionInfo;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.a
    public void i0(@Nullable Integer hbType) {
        H0(this, hbType, 0, 2, null);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.a
    public void k0(@NotNull RedPackSkin$RecommendSkin skin) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        if (F0().getSkinRecommendVM().getJumpType() == 1) {
            F0().R1(getContext(), this, skin);
        } else {
            L0(RedPackSkinExt.f(skin));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Lifecycle lifecycle;
        Lifecycle lifecycle2;
        this.isAttached = true;
        super.onAttachedToWindow();
        QLog.d("RedPacketPanel", 2, "onAttachedToWindow: " + hashCode());
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner != null) {
            F0().P1().observe(lifecycleOwner, this.hbEntryObserver);
            F0().O1().observe(lifecycleOwner, this.bottomTabObserver);
            F0().getSkinRecommendVM().X1().observe(lifecycleOwner, this.skinsObserver);
        }
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner2 != null && (lifecycle2 = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle2.addObserver(F0());
        }
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner3 != null && (lifecycle = lifecycleOwner3.getLifecycle()) != null) {
            lifecycle.addObserver(F0().getSkinRecommendVM());
        }
        K0();
        J0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Lifecycle lifecycle;
        this.isAttached = false;
        super.onDetachedFromWindow();
        QLog.d("RedPacketPanel", 2, "onDetachedFromWindow: " + hashCode());
        PanelViewModel F0 = F0();
        F0.P1().removeObserver(this.hbEntryObserver);
        F0.O1().removeObserver(this.bottomTabObserver);
        F0.getSkinRecommendVM().X1().removeObserver(this.skinsObserver);
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(F0());
        }
        try {
            getContext().unregisterReceiver(this.mReceiver);
        } catch (Exception e16) {
            QLog.e("RedPacketPanel", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.b
    public void onHide() {
        try {
            com.tencent.mobileqq.qwallet.hb.panel.preview.f.f277592a.a();
            DialogFragment dialogFragment = this.unclaimedHbDialog;
            if (dialogFragment != null) {
                dialogFragment.dismissAllowingStateLoss();
            }
        } catch (IllegalStateException e16) {
            QLog.e("RedPacketPanel", 1, "onHide: dismiss previewDialog failed", e16);
        }
        this.unclaimedHbDialog = null;
        if (!this.isVisible) {
            return;
        }
        this.isVisible = false;
        QLog.d("RedPacketPanel", 1, "onHide: ");
        ApngImage.pauseByTag(26);
        try {
            DialogFragment dialogFragment2 = this.previewDialog;
            if (dialogFragment2 != null) {
                dialogFragment2.dismissAllowingStateLoss();
            }
        } catch (IllegalStateException e17) {
            QLog.e("RedPacketPanel", 1, "onHide: dismiss previewDialog failed", e17);
        }
        this.previewDialog = null;
        F0().W1();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.b
    public void onShow() {
        int i3;
        if (this.isVisible) {
            return;
        }
        this.isVisible = true;
        QLog.d("RedPacketPanel", 1, "onShow: ");
        com.tencent.mobileqq.qwallet.hb.panel.preview.f fVar = com.tencent.mobileqq.qwallet.hb.panel.preview.f.f277592a;
        p pVar = this.sessionInfo;
        com.tencent.mobileqq.qwallet.a aVar = this.panelStrategy;
        if (aVar != null) {
            i3 = aVar.f();
        } else {
            i3 = -1;
        }
        fVar.e(pVar, i3);
        ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644((BaseQQAppInterface) null, "aio.luckyplus.click", this.sessionInfo);
        ApngImage.playByTag(26);
    }
}
