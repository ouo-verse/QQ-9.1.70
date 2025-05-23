package com.tencent.robot.discoveryv2.common.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.discover.fragment.RobotDiscoverySearchFragment;
import com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel;
import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.search.c;
import com.tencent.robot.discoveryv2.common.search.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00162\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/search/RobotSearchEntryViewModel;", "Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "Lcom/tencent/robot/discoveryv2/common/repository/core/d;", "Lcom/tencent/robot/discoveryv2/common/search/d;", "Lcom/tencent/robot/discoveryv2/common/search/c;", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "loadState", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/robot/discoveryv2/common/search/c$a;", "intent", "Z1", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "fragment", "Landroid/graphics/Bitmap;", "W1", "", "getLogTag", "Q1", "X1", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSearchEntryViewModel extends BaseRobotViewModel<com.tencent.robot.discoveryv2.common.repository.core.d, d, c> {
    private final Bitmap W1(QIphoneTitleBarFragment fragment) {
        Bitmap bitmap = null;
        if (fragment == null || fragment.quiSecNavBar == null || !fragment.useQUISecNavBar()) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(fragment.quiSecNavBar.getWidth(), fragment.quiSecNavBar.getHeight(), Bitmap.Config.ARGB_4444);
            fragment.quiSecNavBar.draw(new Canvas(bitmap));
            return bitmap;
        } catch (Throwable th5) {
            QLog.e("RobotDiscoveryFragment", 1, "captureNavBarImage| " + th5);
            return bitmap;
        }
    }

    private final void Z1(c.OnSearchBarClick intent) {
        Activity activity;
        String str;
        Intent intent2;
        if (intent.getContext() == null) {
            return;
        }
        Context context = intent.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null || (intent2 = activity.getIntent()) == null || (str = intent2.getStringExtra("param_uin")) == null) {
            str = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("troop_uin", str);
        bundle.putInt("scene_id", 0);
        RobotDiscoverySearchFragment.INSTANCE.a(intent.getContext(), bundle, W1(intent.getFragment()));
    }

    private final void a2(LoadState loadState) {
        int i3;
        MutableLiveData<d> P1 = P1();
        if (com.tencent.robot.discoveryv2.common.data.c.a(loadState)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        P1.setValue(new d.UpdateSearchBarVisibility(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object b2(RobotSearchEntryViewModel robotSearchEntryViewModel, LoadState loadState, Continuation continuation) {
        robotSearchEntryViewModel.a2(loadState);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel
    public void Q1() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(M1().b(), new RobotSearchEntryViewModel$registerNotification$1(this)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public void O1(@NotNull c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.OnSearchBarClick) {
            Z1((c.OnSearchBarClick) intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "TroopRobotSearchEntryViewModel";
    }
}
