package com.tencent.state.square;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareGroupInfoComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseGroupFragment;
import com.tencent.state.square.components.SquareGroupEventBusComponent;
import com.tencent.state.square.components.SquareGroupFloatingComponent;
import com.tencent.state.square.components.SquareGroupLibraryComponent;
import com.tencent.state.square.components.SquareGroupLifecycleComponent;
import com.tencent.state.square.components.SquareGroupReportComponent;
import com.tencent.state.square.components.SquareGroupServiceComponent;
import com.tencent.state.square.components.SquareGroupUiComponent;
import com.tencent.state.square.components.fragment.ChatAddUinComponent;
import com.tencent.state.square.databinding.VasSquareGroupFragmentSquareBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/SquareGroupFragment;", "Lcom/tencent/state/VasBaseGroupFragment;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareGroupFragmentSquareBinding;", "squareGroupConfig", "Lcom/tencent/state/square/SquareGroupFragmentConfig;", "getSquareGroupConfig", "()Lcom/tencent/state/square/SquareGroupFragmentConfig;", "setSquareGroupConfig", "(Lcom/tencent/state/square/SquareGroupFragmentConfig;)V", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getSubFragmentContainerId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareGroupFragment extends VasBaseGroupFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "SquareGroupFragment";
    private VasSquareGroupFragmentSquareBinding binding;
    private SquareGroupFragmentConfig squareGroupConfig = new SquareGroupFragmentConfig(null, 0, false, null, 15, null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/SquareGroupFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/tencent/state/square/SquareGroupFragment;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/SquareGroupFragmentConfig;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final SquareGroupFragment newInstance(SquareGroupFragmentConfig config) {
            boolean z16;
            boolean isBlank;
            Intrinsics.checkNotNullParameter(config, "config");
            SquareGroupFragment squareGroupFragment = new SquareGroupFragment();
            squareGroupFragment.setSquareGroupConfig(config);
            String source = config.getSource();
            if (source != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(source);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        SquareRuntime squareRuntime = SquareRuntime.INSTANCE;
                        squareRuntime.setSourceFrom(config.getSource());
                        SquareBaseKt.getSquareLog().d(SquareGroupFragment.TAG, "setSource:" + squareRuntime.getSourceFrom());
                    }
                    return squareGroupFragment;
                }
            }
            z16 = true;
            if (!z16) {
            }
            return squareGroupFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SquareGroupFragment newInstance$default(Companion companion, SquareGroupFragmentConfig squareGroupFragmentConfig, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                squareGroupFragmentConfig = new SquareGroupFragmentConfig(null, 0, false, null, 15, null);
            }
            return companion.newInstance(squareGroupFragmentConfig);
        }
    }

    public final SquareGroupFragmentConfig getSquareGroupConfig() {
        return this.squareGroupConfig;
    }

    @Override // com.tencent.state.VasBaseGroupFragment
    public int getSubFragmentContainerId() {
        return com.tencent.mobileqq.R.id.pvw;
    }

    @Override // com.tencent.state.VasBaseGroupFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareGroupFragmentSquareBinding inflate = VasSquareGroupFragmentSquareBinding.inflate(inflater);
        this.binding = inflate;
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareGroupFragmentSq\u2026 binding = this\n        }");
        return inflate.getMRv();
    }

    @Override // com.tencent.state.VasBaseGroupFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseGroupFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    public final void setSquareGroupConfig(SquareGroupFragmentConfig squareGroupFragmentConfig) {
        Intrinsics.checkNotNullParameter(squareGroupFragmentConfig, "<set-?>");
        this.squareGroupConfig = squareGroupFragmentConfig;
    }

    @Override // com.tencent.state.VasBaseGroupFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseGroupFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new SquareGroupInfoComponent(), new SquareGroupServiceComponent(), new SquareGroupUiComponent(), new SquareGroupReportComponent(), new SquareGroupLifecycleComponent(), new SquareGroupFloatingComponent(), new SquareGroupLibraryComponent(), new SquareGroupEventBusComponent(), new ChatAddUinComponent()});
        return listOf;
    }
}
