package com.tencent.state.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.library.components.fragments.LibraryCalendarComponent;
import com.tencent.state.library.components.fragments.LibraryChatComponent;
import com.tencent.state.library.components.fragments.LibraryDebugComponent;
import com.tencent.state.library.components.fragments.LibraryEventBusComponent;
import com.tencent.state.library.components.fragments.LibraryFocusComponent;
import com.tencent.state.library.components.fragments.LibraryMsgBoxComponent;
import com.tencent.state.library.components.fragments.LibraryPublicChatComponent;
import com.tencent.state.library.components.fragments.LibraryPushComponent;
import com.tencent.state.library.components.fragments.LibraryQBookComponent;
import com.tencent.state.library.components.fragments.LibraryReportComponent;
import com.tencent.state.library.components.fragments.LibraryRoomComponent;
import com.tencent.state.library.components.fragments.LibraryRouterComponent;
import com.tencent.state.library.components.fragments.LibrarySchemeComponent;
import com.tencent.state.library.components.fragments.LibraryStrangerPrivacyComponent;
import com.tencent.state.library.components.fragments.LibraryUiComponent;
import com.tencent.state.library.publicchat.LibPublicChatOwner;
import com.tencent.state.library.tag.VasLibraryTagManager;
import com.tencent.state.publicchat.component.PublicChatCommonComponent;
import com.tencent.state.publicchat.component.PublicChatExtraActionMenuComponent;
import com.tencent.state.publicchat.component.PublicChatMsgComponent;
import com.tencent.state.publicchat.component.PublicChatUIComponent;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.VasLibraryRoomService;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryBinding;
import com.tencent.state.template.map.TemplateMapFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0014J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/library/LibraryFragment;", "Lcom/tencent/state/template/map/TemplateMapFragment;", "Lcom/tencent/state/library/LibraryMapView;", "Lcom/tencent/state/library/LibraryMapViewModel;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentLibraryBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareFragmentLibraryBinding;", "setBinding", "(Lcom/tencent/state/square/databinding/VasSquareFragmentLibraryBinding;)V", "mapView", "getMapView", "()Lcom/tencent/state/library/LibraryMapView;", "publicChatOwner", "Lcom/tencent/state/library/publicchat/LibPublicChatOwner;", "vm", "getVm", "()Lcom/tencent/state/library/LibraryMapViewModel;", "vm$delegate", "Lkotlin/Lazy;", "destroyTagManager", "", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getPageId", "", "initTagManager", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryFragment extends TemplateMapFragment<LibraryMapView, LibraryMapViewModel> {
    private static final String TAG = "LibraryFragment";
    private VasSquareFragmentLibraryBinding binding;
    private final LibPublicChatOwner publicChatOwner = new LibPublicChatOwner(this);

    /* renamed from: vm$delegate, reason: from kotlin metadata */
    private final Lazy vm;

    public LibraryFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LibraryMapViewModel>() { // from class: com.tencent.state.library.LibraryFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LibraryMapViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(LibraryFragment.this).get(LibraryMapViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this)[\u2026MapViewModel::class.java]");
                return (LibraryMapViewModel) viewModel;
            }
        });
        this.vm = lazy;
    }

    @Override // com.tencent.state.template.map.TemplateMapFragment
    protected void destroyTagManager() {
        VasLibraryTagManager.INSTANCE.clear();
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return SquareReportConst.PageId.PAGE_ID_LIBRARY_HOMEPAGE;
    }

    @Override // com.tencent.state.template.map.TemplateMapFragment, com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapFragment
    public LibraryMapViewModel getVm() {
        return (LibraryMapViewModel) this.vm.getValue();
    }

    @Override // com.tencent.state.template.map.TemplateMapFragment
    protected void initTagManager() {
        VasLibraryTagManager.INSTANCE.init();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareFragmentLibraryBinding inflate = VasSquareFragmentLibraryBinding.inflate(inflater);
        setBinding(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFragmentLibrary\u2026 binding = this\n        }");
        return inflate.getMContainer();
    }

    @Override // com.tencent.state.template.map.TemplateMapFragment, com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.template.map.TemplateMapFragment, com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    public void setBinding(VasSquareFragmentLibraryBinding vasSquareFragmentLibraryBinding) {
        this.binding = vasSquareFragmentLibraryBinding;
    }

    @Override // com.tencent.state.template.map.TemplateMapFragment, com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.map.MapFragment
    public VasSquareFragmentLibraryBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.map.MapFragment
    public LibraryMapView getMapView() {
        VasSquareFragmentLibraryBinding binding = getBinding();
        if (binding != null) {
            return binding.library;
        }
        return null;
    }

    @Override // com.tencent.state.template.map.TemplateMapFragment, com.tencent.state.map.MapFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> listOf;
        VasLibraryRoomService vasLibraryRoomService = VasLibraryRoomService.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new LibraryRoomComponent(vasLibraryRoomService), new LibraryUiComponent(), new LibraryPushComponent(), new LibraryFocusComponent(vasLibraryRoomService), new LibraryMsgBoxComponent(), new LibrarySchemeComponent(), new LibraryChatComponent(), new LibraryReportComponent(), new LibraryDebugComponent(), new LibraryStrangerPrivacyComponent(), new LibraryRouterComponent(), new LibraryQBookComponent(), new LibraryEventBusComponent(), new LibraryCalendarComponent(), new BasicServiceComponent(), new LibraryPublicChatComponent(), new PublicChatCommonComponent(this.publicChatOwner, 0, 2, null), new PublicChatMsgComponent(this.publicChatOwner), new PublicChatUIComponent(this.publicChatOwner), new PublicChatExtraActionMenuComponent()});
        return listOf;
    }
}
