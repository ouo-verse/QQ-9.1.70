package com.tencent.mobileqq.exportfile.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.exportfile.fragment.filelist.FileListFragment;
import com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadFragment;
import com.tencent.mobileqq.exportfile.fragment.k;
import com.tencent.mobileqq.exportfile.fragment.rootpage.view.a;
import com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.RootPageViewModel;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.richmedialist.model.FileItemInfo;
import com.tencent.mobileqq.richmedialist.model.ItemType;
import com.tencent.mobileqq.wifiphoto.api.IExportFileApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeFileType;
import com.tencent.qqnt.kernel.nativeinterface.PlatformType;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoConnectionType;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "\u6d4f\u89c8\u6587\u4ef6\u76ee\u5f55\u9875", path = "/export_file/browser_file")
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\u00030$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b6\u0010.\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/ExportFileRootFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/exportfile/fragment/w;", "", "onFileSearchBoxClick", "loadData", "Lcom/tencent/mobileqq/exportfile/fragment/rootpage/view/a;", "uiState", "handleUIState", "", "isError", "showView", "Lcom/tencent/mobileqq/richmedialist/model/FileItemInfo;", "data", "enterFileDetail", "", "elementName", "isClick", "reportBtn", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onResume", "view", "onBackClick", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lm53/d;", "binding", "Lm53/d;", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/WiFiPhotoConnectionType;", "connectListener", "Lkotlin/jvm/functions/Function1;", "emptyView", "Landroid/view/View;", "Lcom/tencent/mobileqq/exportfile/fragment/rootpage/viewmodel/RootPageViewModel;", "viewModel", "Lcom/tencent/mobileqq/exportfile/fragment/rootpage/viewmodel/RootPageViewModel;", "OPEN_FILE_DETAIL_EVENT", "Ljava/lang/String;", "Landroid/content/BroadcastReceiver;", "mOpenFileDetailEventReceiver", "Landroid/content/BroadcastReceiver;", "getMOpenFileDetailEventReceiver", "()Landroid/content/BroadcastReceiver;", "setMOpenFileDetailEventReceiver", "(Landroid/content/BroadcastReceiver;)V", "DT_PGID", "<init>", "()V", "Companion", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ExportFileRootFragment extends QPublicBaseFragment implements w {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static int instanceCnt;

    @NotNull
    private final String DT_PGID;

    @NotNull
    private final String OPEN_FILE_DETAIL_EVENT;
    private m53.d binding;

    @NotNull
    private final Function1<WiFiPhotoConnectionType, Unit> connectListener;

    @Nullable
    private View emptyView;

    @Nullable
    private BroadcastReceiver mOpenFileDetailEventReceiver;
    private RootPageViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/ExportFileRootFragment$a;", "", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.exportfile.fragment.ExportFileRootFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/exportfile/fragment/ExportFileRootFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExportFileRootFragment.this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new RootPageViewModel(ExportFileRootFragment.this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/exportfile/fragment/ExportFileRootFragment$c", "Lcom/tencent/mobileqq/exportfile/fragment/k$c;", "Landroid/view/View;", "view", "", "position", "", "onItemClick", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements k.c {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f205400b;

        c(k kVar) {
            this.f205400b = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExportFileRootFragment.this, (Object) kVar);
            }
        }

        @Override // com.tencent.mobileqq.exportfile.fragment.k.c
        public void onItemClick(@NotNull View view, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, position);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            ExportFileRootFragment.this.reportBtn("em_bas_file", true);
            m53.d dVar = ExportFileRootFragment.this.binding;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dVar = null;
            }
            Context context = dVar.getRoot().getContext();
            Intent intent = new Intent();
            k kVar = this.f205400b;
            com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a aVar = kVar.getDataList().get(position);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.DiskItem");
            intent.putExtra("key_export_file_list_file_id", ((com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.c) aVar).b());
            com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a aVar2 = kVar.getDataList().get(position);
            Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.DiskItem");
            intent.putExtra("key_export_file_list_dir_name", ((com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.c) aVar2).a());
            QPublicFragmentActivity.start(context, intent, FileListFragment.class);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.ERROR_CHECKLEGALAPP_SYS_ERROR);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ExportFileRootFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.connectListener = new Function1<WiFiPhotoConnectionType, Unit>() { // from class: com.tencent.mobileqq.exportfile.fragment.ExportFileRootFragment$connectListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ExportFileRootFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WiFiPhotoConnectionType wiFiPhotoConnectionType) {
                invoke2(wiFiPhotoConnectionType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable WiFiPhotoConnectionType wiFiPhotoConnectionType) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ExportFileRootFragment.this.loadData();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) wiFiPhotoConnectionType);
                }
            }
        };
        this.OPEN_FILE_DETAIL_EVENT = "OPEN_FILE_DETAIL_EVENT_FOR_PC_ROOT_DIR";
        this.DT_PGID = "pg_bas_computer_file";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterFileDetail(FileItemInfo data) {
        FileBridgeFileType fileBridgeFileType;
        int i3;
        if (com.tencent.mobileqq.filemanager.util.q.p(data.getLocalSavePath())) {
            Context context = getContext();
            if (context != null) {
                IExportFileApi iExportFileApi = (IExportFileApi) QRoute.api(IExportFileApi.class);
                String localSavePath = data.getLocalSavePath();
                Intrinsics.checkNotNull(localSavePath);
                iExportFileApi.browserFile(context, localSavePath);
                return;
            }
            return;
        }
        Context context2 = getContext();
        Intent intent = new Intent();
        intent.putExtra("file_id", data.getFileId());
        intent.putExtra("file_name", data.getFileName());
        intent.putExtra("file_size", data.getKFileSize());
        intent.putExtra("file_thumb", data.getIconPath());
        Object extra = data.getExtra();
        if (extra instanceof FileBridgeFileType) {
            fileBridgeFileType = (FileBridgeFileType) extra;
        } else {
            fileBridgeFileType = null;
        }
        if (fileBridgeFileType != null) {
            i3 = fileBridgeFileType.ordinal();
        } else {
            i3 = 0;
        }
        intent.putExtra("file_type", i3);
        QPublicFragmentActivity.start(context2, intent, FileDownloadFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUIState(com.tencent.mobileqq.exportfile.fragment.rootpage.view.a uiState) {
        if (uiState instanceof a.b) {
            showView(false);
            m53.d dVar = this.binding;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dVar = null;
            }
            RecyclerView.Adapter adapter = dVar.f416210c.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.exportfile.fragment.DiskAdapter");
            ((k) adapter).updateList(((a.b) uiState).a());
            return;
        }
        if (uiState instanceof a.C7514a) {
            if (((a.C7514a) uiState).a() == 100207 && isAdded()) {
                DialogHelperKt.i(this, R.string.f2318172v, R.string.zoc).setPositiveButton(R.string.f1380608j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.r
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ExportFileRootFragment.handleUIState$lambda$5(dialogInterface, i3);
                    }
                }).show();
            }
            showView(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ExportFileRootFragment$loadData$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(ExportFileRootFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onFileSearchBoxClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(ExportFileRootFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = MobileQQ.sMobileQQ.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        m53.d dVar = this$0.binding;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dVar = null;
        }
        inputMethodManager.hideSoftInputFromWindow(dVar.f416209b.getInputWidget().getWindowToken(), 0);
    }

    private final void onFileSearchBoxClick() {
        QLog.i("ExportFileRootFragment", 1, "onFileSearchBoxClick");
        reportBtn("em_bas_search_box", true);
        Bundle bundle = new Bundle();
        bundle.putString("search_pc_file_id", "");
        bundle.putSerializable("search_pc_file_list_fragment_cls", FileListFragment.class);
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startSeach(getActivity(), 22, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportBtn(String elementName, boolean isClick) {
        int i3;
        String str;
        QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
        PlatformType D = qFileBridgeService.D();
        if (D != null) {
            i3 = D.ordinal();
        } else {
            i3 = 0;
        }
        int ordinal = qFileBridgeService.E().ordinal();
        QLog.d("ExportFileRootFragment", 2, "reportBtn. isClick: " + isClick + ", computerSystem: " + i3 + ", loginMode: " + ordinal);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", this.DT_PGID);
        hashMap.put("dt_eid", elementName);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("computer_system", Integer.valueOf(i3));
        hashMap2.put("login_mode", Integer.valueOf(ordinal));
        hashMap.put("cur_pg", hashMap2);
        if (isClick) {
            str = "clck";
        } else {
            str = "imp";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    private final void showView(boolean isError) {
        m53.d dVar = null;
        if (!isError) {
            m53.d dVar2 = this.binding;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dVar = dVar2;
            }
            dVar.f416210c.setVisibility(0);
            View view = this.emptyView;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (this.emptyView == null) {
            this.emptyView = new QUIEmptyState.Builder(getContext()).setImageType(2).setTitle("\u5f53\u524d\u76ee\u5f55\u65e0\u6587\u4ef6").setDesc("\u6570\u636e\u52a0\u8f7d\u5931\u8d25").setButton("\u91cd\u8bd5", new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ExportFileRootFragment.showView$lambda$6(ExportFileRootFragment.this, view2);
                }
            }).build();
            m53.d dVar3 = this.binding;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dVar3 = null;
            }
            dVar3.getRoot().addView(this.emptyView, -1, -1);
        }
        View view2 = this.emptyView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        m53.d dVar4 = this.binding;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dVar = dVar4;
        }
        dVar.f416210c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showView$lambda$6(ExportFileRootFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadData();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    public final BroadcastReceiver getMOpenFileDetailEventReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BroadcastReceiver) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mOpenFileDetailEventReceiver;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.exportfile.fragment.w
    public void onBackClick(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.d("em_bas_back", "pg_bas_access_computer_folder", hashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(this, new b()).get(RootPageViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "override fun onCreate(sa\u2026ntFilter)\n        }\n    }");
        RootPageViewModel rootPageViewModel = (RootPageViewModel) viewModel;
        this.viewModel = rootPageViewModel;
        if (rootPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rootPageViewModel = null;
        }
        MutableLiveData<com.tencent.mobileqq.exportfile.fragment.rootpage.view.a> obtainUiState = rootPageViewModel.obtainUiState();
        final ExportFileRootFragment$onCreate$2 exportFileRootFragment$onCreate$2 = new ExportFileRootFragment$onCreate$2(this);
        obtainUiState.observeForever(new Observer() { // from class: com.tencent.mobileqq.exportfile.fragment.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExportFileRootFragment.onCreate$lambda$0(Function1.this, obj);
            }
        });
        int i3 = instanceCnt + 1;
        instanceCnt = i3;
        if (i3 == 1) {
            if (this.mOpenFileDetailEventReceiver == null) {
                this.mOpenFileDetailEventReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.exportfile.fragment.ExportFileRootFragment$onCreate$3
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ExportFileRootFragment.this);
                        }
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(@Nullable Context context, @NotNull Intent intent) {
                        String str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        str = ExportFileRootFragment.this.OPEN_FILE_DETAIL_EVENT;
                        if (Intrinsics.areEqual(str, intent.getAction())) {
                            FileItemInfo fileItemInfo = new FileItemInfo();
                            String stringExtra = intent.getStringExtra("KEY_FILE_ID");
                            Intrinsics.checkNotNull(stringExtra);
                            fileItemInfo.setFileId(stringExtra);
                            fileItemInfo.setFileName(intent.getStringExtra("KEY_FILE_NAME"));
                            fileItemInfo.setLocalSavePath(intent.getStringExtra("KEY_FILE_PATH"));
                            fileItemInfo.setKFileType(ItemType.values()[intent.getIntExtra("KEY_FILE_TYPE", 0)]);
                            fileItemInfo.setKFileSize(intent.getLongExtra("KEY_FILE_SIZE", 0L));
                            QLog.d(QPublicBaseFragment.TAG, 1, "onReceive OPEN_FILE_DETAIL_EVENT. fileid:" + fileItemInfo.getFileId() + ", fileName:" + fileItemInfo.getFileName() + ", localSavePath:" + fileItemInfo.getLocalSavePath() + ", kFileType:" + fileItemInfo.getKFileType());
                            ExportFileRootFragment.this.enterFileDetail(fileItemInfo);
                        }
                    }
                };
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(this.OPEN_FILE_DETAIL_EVENT);
            Context context = getContext();
            if (context != null) {
                context.registerReceiver(this.mOpenFileDetailEventReceiver, intentFilter);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            root = (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m53.d g16 = m53.d.g(inflater);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater)");
            this.binding = g16;
            Fragment parentFragment = getParentFragment();
            int i3 = 1;
            if (parentFragment != null) {
                com.tencent.mobileqq.exportfile.fragment.c.a(parentFragment, QFileBridgeService.f205517a.z() + "\u7684\u7535\u8111\u6587\u4ef6", true);
            }
            QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
            if (qFileBridgeService.H()) {
                loadData();
            } else {
                qFileBridgeService.L(this.connectListener);
            }
            m53.d dVar = null;
            k kVar = new k(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
            m53.d dVar2 = this.binding;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dVar2 = null;
            }
            RecyclerView recyclerView = dVar2.f416210c;
            m53.d dVar3 = this.binding;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dVar3 = null;
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(dVar3.getRoot().getContext(), 1, false));
            m53.d dVar4 = this.binding;
            if (dVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dVar4 = null;
            }
            dVar4.f416210c.setAdapter(kVar);
            kVar.k0(new c(kVar));
            DialogHelperKt.g(this);
            m53.d dVar5 = this.binding;
            if (dVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dVar5 = null;
            }
            VideoReport.setPageId(dVar5.getRoot(), "pg_bas_access_computer_folder");
            if (Intrinsics.areEqual(qFileBridgeService.I(), Boolean.TRUE)) {
                m53.d dVar6 = this.binding;
                if (dVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dVar6 = null;
                }
                dVar6.f416209b.getCancelView().setVisibility(8);
                m53.d dVar7 = this.binding;
                if (dVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dVar7 = null;
                }
                dVar7.f416209b.setEtInputHint(HardCodeUtil.qqStr(R.string.f224716jo));
                m53.d dVar8 = this.binding;
                if (dVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dVar8 = null;
                }
                dVar8.f416209b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ExportFileRootFragment.onCreateView$lambda$1(ExportFileRootFragment.this, view);
                    }
                });
                if (Intrinsics.areEqual(DeviceInfoMonitor.getModel(), "M2011J18C") || Intrinsics.areEqual(DeviceInfoMonitor.getModel(), "ALI-AN00")) {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.exportfile.fragment.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            ExportFileRootFragment.onCreateView$lambda$2(ExportFileRootFragment.this);
                        }
                    }, 500L);
                }
                reportBtn("em_bas_search_box", false);
            } else {
                m53.d dVar9 = this.binding;
                if (dVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dVar9 = null;
                }
                dVar9.f416209b.setVisibility(8);
            }
            m53.d dVar10 = this.binding;
            if (dVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dVar = dVar10;
            }
            root = dVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        QFileBridgeService.f205517a.V(this.connectListener);
        int i3 = instanceCnt - 1;
        instanceCnt = i3;
        if (i3 == 0) {
            try {
                if (this.mOpenFileDetailEventReceiver != null) {
                    Context context = getContext();
                    if (context != null) {
                        context.unregisterReceiver(this.mOpenFileDetailEventReceiver);
                    }
                    this.mOpenFileDetailEventReceiver = null;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", "pg_bas_access_computer_folder");
        com.tencent.mobileqq.wifiphoto.data.a.a(linkedHashMap);
        VideoReport.reportEvent("pgout", linkedHashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_access_computer_folder");
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        VideoReport.reportEvent("pgin", hashMap);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    public final void setMOpenFileDetailEventReceiver(@Nullable BroadcastReceiver broadcastReceiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) broadcastReceiver);
        } else {
            this.mOpenFileDetailEventReceiver = broadcastReceiver;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleUIState$lambda$5(DialogInterface dialogInterface, int i3) {
    }
}
