package com.tencent.mobileqq.minigame.metafarm.ui;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmStatus;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmStatusManager;
import com.tencent.mobileqq.minigame.metafarm.network.MetaFarmGetStatusListRequest;
import com.tencent.mobileqq.minigame.metafarm.ui.MetaFarmStatusListFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "isSuccess", "", "list", "", "Lcom/tencent/mobileqq/minigame/metafarm/data/MetaFarmStatus;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmStatusListFragment$getStatusList$1 extends Lambda implements Function2<Boolean, List<? extends MetaFarmStatus>, Unit> {
    final /* synthetic */ int $currentId;
    final /* synthetic */ MetaFarmGetStatusListRequest $request;
    final /* synthetic */ MetaFarmStatusListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetaFarmStatusListFragment$getStatusList$1(MetaFarmStatusListFragment metaFarmStatusListFragment, MetaFarmGetStatusListRequest metaFarmGetStatusListRequest, int i3) {
        super(2);
        this.this$0 = metaFarmStatusListFragment;
        this.$request = metaFarmGetStatusListRequest;
        this.$currentId = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(MetaFarmStatusListFragment this$0, int i3) {
        MetaFarmStatusListFragment.StatusListAdapter statusListAdapter;
        List<MetaFarmStatus> list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        statusListAdapter = this$0.statusGridAdapter;
        if (statusListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
            statusListAdapter = null;
        }
        list = this$0.listData;
        statusListAdapter.setStatusList(list, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2() {
        try {
            QQToast.makeText(BaseApplication.getContext(), "\u83b7\u53d6\u519c\u573a\u72b6\u6001\u5217\u8868\u5931\u8d25!", 0).show();
        } catch (Exception e16) {
            QLog.e("MetaFarmStatusListFragment", 1, "show toast exception:", e16);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends MetaFarmStatus> list) {
        invoke(bool.booleanValue(), (List<MetaFarmStatus>) list);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, List<MetaFarmStatus> list) {
        List list2;
        List list3;
        List list4;
        QLog.d("MetaFarmStatusListFragment", 1, "MetaFarmGetStatusListRequest req isSuccess:" + z16 + ", list:" + list);
        if (!z16) {
            list2 = this.this$0.listData;
            if (list2.isEmpty()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        MetaFarmStatusListFragment$getStatusList$1.invoke$lambda$2();
                    }
                });
            }
        } else if (list != null) {
            final MetaFarmStatusListFragment metaFarmStatusListFragment = this.this$0;
            final int i3 = this.$currentId;
            MetaFarmStatusManager.INSTANCE.saveStatusList(list);
            list3 = metaFarmStatusListFragment.listData;
            list3.clear();
            list4 = metaFarmStatusListFragment.listData;
            list4.addAll(list);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.f
                @Override // java.lang.Runnable
                public final void run() {
                    MetaFarmStatusListFragment$getStatusList$1.invoke$lambda$1$lambda$0(MetaFarmStatusListFragment.this, i3);
                }
            });
        }
        this.$request.setListener(null);
    }
}
