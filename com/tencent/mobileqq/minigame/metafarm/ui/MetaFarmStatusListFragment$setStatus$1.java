package com.tencent.mobileqq.minigame.metafarm.ui;

import android.content.Intent;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmStatus;
import com.tencent.mobileqq.minigame.metafarm.network.MetaFarmSetStatusRequest;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "isSuccess", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", "invoke", "(ZLjava/lang/Integer;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmStatusListFragment$setStatus$1 extends Lambda implements Function2<Boolean, Integer, Unit> {
    final /* synthetic */ MetaFarmSetStatusRequest $request;
    final /* synthetic */ int $selectId;
    final /* synthetic */ MetaFarmStatusListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetaFarmStatusListFragment$setStatus$1(MetaFarmSetStatusRequest metaFarmSetStatusRequest, MetaFarmStatusListFragment metaFarmStatusListFragment, int i3) {
        super(2);
        this.$request = metaFarmSetStatusRequest;
        this.this$0 = metaFarmStatusListFragment;
        this.$selectId = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(MetaFarmStatusListFragment this$0, boolean z16, int i3) {
        List list;
        MetaFarmStatus metaFarmStatus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissUpdateStatusProgressDialog();
        if (z16) {
            if (i3 != 0) {
                list = this$0.listData;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        metaFarmStatus = null;
                        break;
                    }
                    MetaFarmStatus metaFarmStatus2 = (MetaFarmStatus) it.next();
                    if (metaFarmStatus2.getId() == i3) {
                        metaFarmStatus = metaFarmStatus2;
                        break;
                    }
                }
            } else {
                metaFarmStatus = new MetaFarmStatus(0, "", "");
            }
            Intent intent = new Intent();
            intent.putExtra("selectStatus", metaFarmStatus);
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.setResult(-1, intent);
            }
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        try {
            QQToast.makeText(BaseApplication.getContext(), "\u8bbe\u7f6e\u5931\u8d25!", 0).show();
        } catch (Exception e16) {
            QLog.e("MetaFarmStatusListFragment", 1, "setStatus show toast exception:", e16);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
        invoke(bool.booleanValue(), num);
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean z16, Integer num) {
        QLog.d("MetaFarmStatusListFragment", 1, "setStatus req isSuccess:" + z16 + ", statusId:" + num);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final MetaFarmStatusListFragment metaFarmStatusListFragment = this.this$0;
        final int i3 = this.$selectId;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.h
            @Override // java.lang.Runnable
            public final void run() {
                MetaFarmStatusListFragment$setStatus$1.invoke$lambda$1(MetaFarmStatusListFragment.this, z16, i3);
            }
        });
        this.$request.setListener(null);
    }
}
