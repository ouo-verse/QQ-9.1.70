package com.qzone.reborn.intimate.block;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.m;
import com.qzone.reborn.intimate.bean.QZIntimateSettingItemBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.widget.QZIntimateFeedListHeaderView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.h;
import nk.i;
import nk.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J$\u0010&\u001a\u0006\u0012\u0002\b\u00030%2\b\u0010\"\u001a\u0004\u0018\u00010!2\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H\u0014R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/intimate/block/QZoneIntimateFeedListHeaderBlock;", "Lcom/qzone/reborn/base/m;", "", "r0", "x0", "q0", "o0", "", "B0", "s0", "D0", "t0", "E0", "C0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Lnk/h;", "viewModel", "u0", "Lnk/i;", "v0", "Lnk/p;", "w0", "p0", "A0", "z0", "y0", "I0", "F0", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Lcom/qzone/reborn/intimate/widget/QZIntimateFeedListHeaderView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/intimate/widget/QZIntimateFeedListHeaderView;", "feedListHeaderView", BdhLogUtil.LogTag.Tag_Conn, "Lnk/h;", "migrationViewModel", "D", "Lnk/i;", "resourceViewModel", "E", "Lnk/p;", "settingViewModel", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "spaceId", "<init>", "(Landroid/os/Bundle;)V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateFeedListHeaderBlock extends m {

    /* renamed from: C, reason: from kotlin metadata */
    private h migrationViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private i resourceViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private p settingViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private String spaceId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZIntimateFeedListHeaderView feedListHeaderView;

    public QZoneIntimateFeedListHeaderBlock(Bundle bundle) {
        super(bundle);
        this.spaceId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean r0() {
        return com.qzone.reborn.a.g(com.qzone.reborn.a.f52169a, "exp__space_clock_in_remind2", false, 2, null) && com.qzone.reborn.util.i.b().d("CAN_SHOW_INTIMATE_CHECK_IN_REMIND", true);
    }

    private final boolean x0() {
        p pVar = this.settingViewModel;
        if (!(pVar != null && pVar.S1())) {
            return false;
        }
        p pVar2 = this.settingViewModel;
        if (pVar2 != null && pVar2.O1("signin_notice_switch")) {
            return true;
        }
        QLog.i("QZoneIntimateFeedListHeaderBlock", 1, "not include check in remind setting");
        return false;
    }

    public final boolean A0() {
        p pVar = this.settingViewModel;
        Boolean valueOf = pVar != null ? Boolean.valueOf(pVar.Z1("signin_notice_switch")) : null;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.booleanValue();
    }

    public final void B0() {
        com.qzone.reborn.util.i.b().l("CAN_SHOW_INTIMATE_AT_SYNC_GUIDE", false);
    }

    public final void C0() {
        com.qzone.reborn.util.i.b().l("CAN_SHOW_INTIMATE_CHECK_IN_REMIND", false);
    }

    public final void D0() {
        com.qzone.reborn.util.i.b().p("INTIMATE_TRANSFER_DATA_GUIDE_CLOSE_TIMES", com.qzone.reborn.util.i.b().h("INTIMATE_TRANSFER_DATA_GUIDE_CLOSE_TIMES", 0L) + 1);
    }

    public final void E0() {
        com.qzone.reborn.util.i.b().l("CAN_SHOW_INTIMATE_TRANSFER_DATA_UNDERWAY", false);
    }

    public final void F0() {
        MutableLiveData<ij.c> O1;
        if (mk.d.f416875a.L()) {
            QLog.i("QZoneIntimateFeedListHeaderBlock", 1, "has check before, this space don't have job");
            QZIntimateFeedListHeaderView qZIntimateFeedListHeaderView = this.feedListHeaderView;
            if (qZIntimateFeedListHeaderView != null) {
                qZIntimateFeedListHeaderView.A0();
                return;
            }
            return;
        }
        h hVar = this.migrationViewModel;
        if (hVar == null || (O1 = hVar.O1()) == null) {
            return;
        }
        Fragment parentFragment = getParentFragment();
        final Function1<ij.c, Unit> function1 = new Function1<ij.c, Unit>() { // from class: com.qzone.reborn.intimate.block.QZoneIntimateFeedListHeaderBlock$startMigrationDataObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ij.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
            
                r0 = r1.this$0.feedListHeaderView;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(ij.c cVar) {
                QZIntimateFeedListHeaderView qZIntimateFeedListHeaderView2;
                if (cVar == null || qZIntimateFeedListHeaderView2 == null) {
                    return;
                }
                qZIntimateFeedListHeaderView2.V0(cVar);
            }
        };
        O1.observe(parentFragment, new Observer() { // from class: com.qzone.reborn.intimate.block.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateFeedListHeaderBlock.H0(Function1.this, obj);
            }
        });
    }

    public final void I0() {
        MutableLiveData<List<QZIntimateSettingItemBean>> P1;
        p pVar = this.settingViewModel;
        if (pVar == null || (P1 = pVar.P1()) == null) {
            return;
        }
        Fragment parentFragment = getParentFragment();
        final Function1<List<QZIntimateSettingItemBean>, Unit> function1 = new Function1<List<QZIntimateSettingItemBean>, Unit>() { // from class: com.qzone.reborn.intimate.block.QZoneIntimateFeedListHeaderBlock$startSettingObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<QZIntimateSettingItemBean> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
            
                r4 = r3.this$0.feedListHeaderView;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(List<QZIntimateSettingItemBean> list) {
                Object obj;
                QZIntimateFeedListHeaderView qZIntimateFeedListHeaderView;
                List<QZIntimateSettingItemBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(list, "list");
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (TextUtils.equals("signin_notice_switch", ((QZIntimateSettingItemBean) obj).getKey())) {
                            break;
                        }
                    }
                }
                if (((QZIntimateSettingItemBean) obj) == null || qZIntimateFeedListHeaderView == null) {
                    return;
                }
                qZIntimateFeedListHeaderView.A0();
            }
        };
        P1.observe(parentFragment, new Observer() { // from class: com.qzone.reborn.intimate.block.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateFeedListHeaderBlock.J0(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        int i3 = o0() ? 2 : -1;
        Intrinsics.checkNotNull(viewGroup);
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup!!.context");
        QZIntimateFeedListHeaderView qZIntimateFeedListHeaderView = new QZIntimateFeedListHeaderView(context, this, i3);
        this.feedListHeaderView = qZIntimateFeedListHeaderView;
        Intrinsics.checkNotNull(qZIntimateFeedListHeaderView);
        qZIntimateFeedListHeaderView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        QZIntimateFeedListHeaderView qZIntimateFeedListHeaderView2 = this.feedListHeaderView;
        Intrinsics.checkNotNull(qZIntimateFeedListHeaderView2);
        return qZIntimateFeedListHeaderView2;
    }

    public final boolean o0() {
        return com.qzone.reborn.util.i.b().d("CAN_SHOW_INTIMATE_AT_SYNC_GUIDE", true) && com.qzone.reborn.util.i.b().h("MASTER_USER_ENTER_INTIMATE_SPACE_TIMES", 0L) > 0;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        FragmentActivity activity;
        Intent intent;
        Bundle extras;
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || (activity = parentFragment.getActivity()) == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean");
        this.spaceId = ((QZoneIntimateMainPageInitBean) serializable).getSpaceId();
    }

    public final boolean p0() {
        return r0() && x0();
    }

    public final boolean q0() {
        return o0() || s0() || t0() || r0();
    }

    public final boolean s0() {
        return com.qzone.reborn.util.i.b().h("INTIMATE_TRANSFER_DATA_GUIDE_CLOSE_TIMES", 0L) < 3;
    }

    public final boolean t0() {
        return com.qzone.reborn.util.i.b().d("CAN_SHOW_INTIMATE_TRANSFER_DATA_UNDERWAY", true);
    }

    public final void u0(h viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.migrationViewModel = viewModel;
    }

    public final void v0(i viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.resourceViewModel = viewModel;
    }

    public final void w0(p viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.settingViewModel = viewModel;
    }

    public final void y0() {
        if (TextUtils.isEmpty(this.spaceId)) {
            return;
        }
        i iVar = this.resourceViewModel;
        if (TextUtils.isEmpty(iVar != null ? iVar.getMigrateAuthUrl() : null)) {
            return;
        }
        i iVar2 = this.resourceViewModel;
        String migrateAuthUrl = iVar2 != null ? iVar2.getMigrateAuthUrl() : null;
        ho.i.q(getContext(), migrateAuthUrl + "&space_id=" + this.spaceId);
    }

    public final void z0() {
        p pVar = this.settingViewModel;
        if (pVar != null) {
            pVar.T1("signin_notice_switch", this.spaceId, "true");
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
