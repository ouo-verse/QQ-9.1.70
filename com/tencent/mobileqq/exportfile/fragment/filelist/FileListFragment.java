package com.tencent.mobileqq.exportfile.fragment.filelist;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qui.profileskin.widget.QUIImageButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.exportfile.fragment.DialogHelperKt;
import com.tencent.mobileqq.exportfile.fragment.DisconnectListenerFragment;
import com.tencent.mobileqq.exportfile.fragment.filelist.data.a;
import com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadFragment;
import com.tencent.mobileqq.exportfile.fragment.filelist.manager.FileItemInfoExtKt;
import com.tencent.mobileqq.exportfile.fragment.filelist.manager.ListViewManager;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.DirectoryItemInfo;
import com.tencent.mobileqq.richmedialist.model.DownloadState;
import com.tencent.mobileqq.richmedialist.model.FileItemInfo;
import com.tencent.mobileqq.richmedialist.model.ItemType;
import com.tencent.mobileqq.richmedialist.view.RichMediaListView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.api.IExportFileApi;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeFileType;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeType;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ThumbConfig;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 h2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017H\u0002J\u001e\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0012\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J$\u0010/\u001a\u00020\f2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u001a\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J\b\u00104\u001a\u00020\u0010H\u0016J\b\u00105\u001a\u00020\u0004H\u0016J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00102\u0006\u00107\u001a\u000206H\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016J\u0010\u0010<\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016J(\u0010B\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0015H\u0016J\u0010\u0010C\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016J\b\u0010D\u001a\u00020\u0004H\u0016R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u0014\u0010]\u001a\u00020\u00178\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\\\u0010XR$\u0010e\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListFragment;", "Lcom/tencent/mobileqq/exportfile/fragment/DisconnectListenerFragment;", "Lan2/a;", "Lan2/b;", "", "onFileSearchBoxClick", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/data/a;", "state", "Uh", "Sh", "Lh", "Th", "Landroid/view/View;", "emptyView", "Kh", "Nh", "", "show", UIJsPlugin.EVENT_SHOW_LOADING, "Mh", "Ph", "", "count", "", "size", "", "realSize", "di", "Lcom/tencent/mobileqq/richmedialist/model/FileItemInfo;", "data", "enterFileDetail", "Landroid/content/Context;", "context", "fileId", WidgetCacheLunarData.JI, "Lkotlin/Function0;", "confirmListener", "gi", "Rh", "Qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "needImmersive", "needStatusTrans", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", "itemInfo", ICustomDataEditor.STRING_ARRAY_PARAM_4, "isSelected", "T1", "Vb", "Qb", "fileItemInfo", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "imageView", "width", "height", "xf", "kf", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lm53/e;", "D", "Lm53/e;", "binding", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/manager/ListViewManager;", "E", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/manager/ListViewManager;", "listViewManager", "Lcom/tencent/mobileqq/richmedialist/view/RichMediaListView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/richmedialist/view/RichMediaListView;", "richMediaListView", "G", "Landroid/view/View;", "Landroid/app/Dialog;", "H", "Landroid/app/Dialog;", "loadingDialog", "I", "Ljava/lang/String;", "curFileId", "J", "curTitle", "K", "OPEN_FILE_DETAIL_EVENT", "Landroid/content/BroadcastReceiver;", "L", "Landroid/content/BroadcastReceiver;", "getMOpenFileDetailEventReceiver", "()Landroid/content/BroadcastReceiver;", "setMOpenFileDetailEventReceiver", "(Landroid/content/BroadcastReceiver;)V", "mOpenFileDetailEventReceiver", "<init>", "()V", "M", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileListFragment extends DisconnectListenerFragment implements an2.a, an2.b {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static int N;

    /* renamed from: D, reason: from kotlin metadata */
    private m53.e binding;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ListViewManager listViewManager;

    /* renamed from: F, reason: from kotlin metadata */
    private RichMediaListView richMediaListView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View emptyView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String curFileId;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String curTitle;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final String OPEN_FILE_DETAIL_EVENT;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private BroadcastReceiver mOpenFileDetailEventReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/FileListFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.FileListFragment$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FileListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.listViewManager = new ListViewManager();
            this.OPEN_FILE_DETAIL_EVENT = "OPEN_FILE_DETAIL_EVENT_FOR_PC_SUB_DIR";
        }
    }

    private final void Kh(View emptyView) {
        ViewGroup viewGroup;
        if (emptyView.getParent() != null && (viewGroup = (ViewGroup) emptyView.getParent()) != null) {
            viewGroup.removeView(emptyView);
        }
        m53.e eVar = this.binding;
        m53.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar = null;
        }
        eVar.f416213c.addView(emptyView, -1, -1);
        m53.e eVar3 = this.binding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar3 = null;
        }
        eVar3.f416215e.setVisibility(8);
        m53.e eVar4 = this.binding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            eVar2 = eVar4;
        }
        eVar2.f416212b.setVisibility(8);
    }

    private final void Lh() {
        if (this.listViewManager.o().isEmpty()) {
            Th();
        } else {
            this.listViewManager.j();
            ei(this, 0, "", 0L, 4, null);
        }
    }

    private final View Mh() {
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
        String string = getString(R.string.zw5);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.export_file_cur_dir_no_file)");
        return imageType.setTitle(string).build();
    }

    private final View Nh() {
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
        String string = getString(R.string.zw5);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.export_file_cur_dir_no_file)");
        QUIEmptyState.Builder title = imageType.setTitle(string);
        String string2 = getString(R.string.zw6);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.export_file_data_load_fail)");
        QUIEmptyState.Builder desc = title.setDesc(string2);
        String string3 = getString(R.string.f221236a_);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.retry)");
        return desc.setButton(string3, new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileListFragment.Oh(FileListFragment.this, view);
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(FileListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), this$0.getString(R.string.f220836_7), 0).show();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new FileListFragment$createErrorView$1$1(this$0, null), 3, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ph() {
        View view = this.emptyView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            if (view.getParent() != null) {
                View view2 = this.emptyView;
                Intrinsics.checkNotNull(view2);
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.emptyView);
                }
                m53.e eVar = this.binding;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    eVar = null;
                }
                eVar.f416215e.setVisibility(0);
            }
        }
    }

    private final void Qh(Context context) {
        final List<BaseItemInfo> o16 = this.listViewManager.o();
        if (AppNetConnInfo.isMobileConn() && !QFileBridgeService.f205517a.C()) {
            gi(context, new Function0<Unit>(o16) { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.FileListFragment$downloadAllSelected$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ List<BaseItemInfo> $checkedRecord;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                    this.$checkedRecord = o16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileListFragment.this, (Object) o16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ListViewManager listViewManager;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        listViewManager = FileListFragment.this.listViewManager;
                        listViewManager.l(this.$checkedRecord);
                    }
                }
            });
        } else {
            this.listViewManager.l(o16);
        }
    }

    private final void Rh(final String fileId) {
        if (AppNetConnInfo.isMobileConn() && !QFileBridgeService.f205517a.C()) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            gi(requireContext, new Function0<Unit>(fileId) { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.FileListFragment$downloadFile$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $fileId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$fileId = fileId;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileListFragment.this, (Object) fileId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ListViewManager listViewManager;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        listViewManager = FileListFragment.this.listViewManager;
                        listViewManager.k(this.$fileId);
                    }
                }
            });
            return;
        }
        this.listViewManager.k(fileId);
    }

    private final void Sh() {
        m53.e eVar = this.binding;
        m53.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar = null;
        }
        eVar.f416218h.setVisibility(8);
        m53.e eVar3 = this.binding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar3 = null;
        }
        eVar3.f416223m.setVisibility(0);
        m53.e eVar4 = this.binding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar4 = null;
        }
        eVar4.f416212b.setVisibility(0);
        ei(this, 0, "", 0L, 4, null);
        this.listViewManager.n(true);
        m53.e eVar5 = this.binding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar5 = null;
        }
        RichMediaListView richMediaListView = eVar5.f416215e;
        m53.e eVar6 = this.binding;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar6 = null;
        }
        int paddingLeft = eVar6.f416215e.getPaddingLeft();
        m53.e eVar7 = this.binding;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar7 = null;
        }
        int paddingTop = eVar7.f416215e.getPaddingTop();
        m53.e eVar8 = this.binding;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar8 = null;
        }
        int paddingRight = eVar8.f416215e.getPaddingRight();
        m53.e eVar9 = this.binding;
        if (eVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            eVar2 = eVar9;
        }
        richMediaListView.setPadding(paddingLeft, paddingTop, paddingRight, eVar2.f416212b.getHeight());
    }

    private final void Th() {
        m53.e eVar = this.binding;
        m53.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar = null;
        }
        eVar.f416218h.setVisibility(0);
        m53.e eVar3 = this.binding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar3 = null;
        }
        eVar3.f416223m.setVisibility(8);
        m53.e eVar4 = this.binding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar4 = null;
        }
        eVar4.f416212b.setVisibility(8);
        ei(this, 0, "", 0L, 4, null);
        this.listViewManager.n(false);
        m53.e eVar5 = this.binding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar5 = null;
        }
        RichMediaListView richMediaListView = eVar5.f416215e;
        m53.e eVar6 = this.binding;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar6 = null;
        }
        int paddingLeft = eVar6.f416215e.getPaddingLeft();
        m53.e eVar7 = this.binding;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar7 = null;
        }
        int paddingTop = eVar7.f416215e.getPaddingTop();
        m53.e eVar8 = this.binding;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            eVar2 = eVar8;
        }
        richMediaListView.setPadding(paddingLeft, paddingTop, eVar2.f416215e.getPaddingRight(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(com.tencent.mobileqq.exportfile.fragment.filelist.data.a state) {
        m53.e eVar = null;
        int i3 = 0;
        if (state instanceof a.e) {
            showLoading(false);
            m53.e eVar2 = this.binding;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                eVar = eVar2;
            }
            QUIImageButton qUIImageButton = eVar.f416218h;
            a.e eVar3 = (a.e) state;
            if (!eVar3.b()) {
                i3 = 8;
            }
            qUIImageButton.setVisibility(i3);
            if (eVar3.a().isEmpty()) {
                Kh(Mh());
                return;
            }
            Ph();
            ListViewManager listViewManager = this.listViewManager;
            listViewManager.t(listViewManager.p());
            return;
        }
        if (state instanceof a.g) {
            showLoading(false);
            Kh(Nh());
            m53.e eVar4 = this.binding;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                eVar = eVar4;
            }
            eVar.f416218h.setVisibility(4);
            return;
        }
        if (state instanceof a.b) {
            a.b bVar = (a.b) state;
            this.listViewManager.x(bVar.a(), bVar.b());
            return;
        }
        if (state instanceof a.c) {
            a.c cVar = (a.c) state;
            this.listViewManager.z(cVar.a(), cVar.b());
            return;
        }
        if (state instanceof a.C7510a) {
            a.C7510a c7510a = (a.C7510a) state;
            this.listViewManager.m(c7510a.a(), c7510a.b());
            return;
        }
        if (state instanceof a.f) {
            a.f fVar = (a.f) state;
            this.listViewManager.w(fVar.a(), fVar.b());
        } else if (state instanceof a.d) {
            a.d dVar = (a.d) state;
            this.listViewManager.u(dVar.a(), dVar.b());
        } else if (state instanceof a.h) {
            a.h hVar = (a.h) state;
            this.listViewManager.v(hVar.a(), hVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(FileListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onFileSearchBoxClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(FileItemInfo fileItemInfo, int i3, String str) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "$fileItemInfo");
        QLog.i("FileListFragment", 1, "request fileId " + fileItemInfo.getFileId() + " thumbnail, result: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(FileListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Lh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(FileListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m53.e eVar = this$0.binding;
        m53.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar = null;
        }
        TextView textView = eVar.f416225o;
        m53.e eVar3 = this$0.binding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            eVar2 = eVar3;
        }
        textView.setMaxWidth(eVar2.f416222l.getWidth() - com.tencent.qqnt.qbasealbum.ktx.d.b(24));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(FileListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.d("em_bas_back", "pg_bas_computer_file", hashMap);
        this$0.requireActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(FileListFragment this$0, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        if (QFileBridgeService.f205517a.y() == FileBridgeClientState.KFILETRANSFERING) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        hashMap.put("is_transmission_behavior", Integer.valueOf(i3));
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.d("em_bas_disconnect_link_switch", "pg_bas_computer_file", hashMap);
        DialogHelperKt.j(this$0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(FileListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.d("em_bas_multiple", "pg_bas_computer_file", hashMap);
        this$0.Sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void di(final int count, String size, final long realSize) {
        HashMap hashMap = new HashMap();
        hashMap.put("amount", Integer.valueOf(count));
        hashMap.put("file_size", Long.valueOf(realSize));
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.f("em_bas_multiple_download", "pg_bas_computer_file", hashMap);
        m53.e eVar = this.binding;
        m53.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar = null;
        }
        eVar.f416220j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileListFragment.fi(FileListFragment.this, count, realSize, view);
            }
        });
        if (count <= 0) {
            m53.e eVar3 = this.binding;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                eVar3 = null;
            }
            eVar3.f416220j.setEnabled(false);
            m53.e eVar4 = this.binding;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                eVar4 = null;
            }
            eVar4.f416220j.setText(getString(R.string.zw9));
            m53.e eVar5 = this.binding;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                eVar5 = null;
            }
            eVar5.f416220j.setContentDescription(getString(R.string.zw9));
            m53.e eVar6 = this.binding;
            if (eVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                eVar6 = null;
            }
            eVar6.f416224n.setText("");
            m53.e eVar7 = this.binding;
            if (eVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                eVar2 = eVar7;
            }
            eVar2.f416224n.setContentDescription("");
            return;
        }
        m53.e eVar8 = this.binding;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar8 = null;
        }
        eVar8.f416224n.setText(size);
        m53.e eVar9 = this.binding;
        if (eVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar9 = null;
        }
        eVar9.f416224n.setContentDescription(size);
        m53.e eVar10 = this.binding;
        if (eVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar10 = null;
        }
        eVar10.f416220j.setEnabled(true);
        String string = getString(R.string.zw_, Integer.valueOf(count));
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.expor\u2026le_download_count, count)");
        m53.e eVar11 = this.binding;
        if (eVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar11 = null;
        }
        eVar11.f416220j.setText(string);
        m53.e eVar12 = this.binding;
        if (eVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            eVar2 = eVar12;
        }
        eVar2.f416220j.setContentDescription(string);
    }

    static /* synthetic */ void ei(FileListFragment fileListFragment, int i3, String str, long j3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            j3 = 0;
        }
        fileListFragment.di(i3, str, j3);
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
    public static final void fi(FileListFragment this$0, int i3, long j3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        hashMap.put("amount", Integer.valueOf(i3));
        hashMap.put("file_size", Long.valueOf(j3));
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.d("em_bas_multiple_download", "pg_bas_computer_file", hashMap);
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this$0.Qh(requireContext);
        this$0.Th();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void gi(Context context, final Function0<Unit> confirmListener) {
        QFileBridgeService.f205517a.P(true);
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context);
        Window window = qQCustomDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = qQCustomDialog.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle(context.getString(R.string.zwi));
        qQCustomDialog.setMessage(context.getString(R.string.zwj));
        qQCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FileListFragment.hi(dialogInterface, i3);
            }
        }).setPositiveButton(context.getString(R.string.zws), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FileListFragment.ii(Function0.this, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(Function0 confirmListener, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(confirmListener, "$confirmListener");
        confirmListener.invoke();
    }

    private final void ji(Context context, final String fileId) {
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u91cd\u65b0\u4e0b\u8f7d");
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.g
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                FileListFragment.ki(FileListFragment.this, fileId, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(FileListFragment this$0, String fileId, ActionSheet confirmSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fileId, "$fileId");
        Intrinsics.checkNotNullParameter(confirmSheet, "$confirmSheet");
        if (i3 == 0) {
            this$0.Rh(fileId);
        }
        confirmSheet.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void onFileSearchBoxClick() {
        QLog.i("FileListFragment", 1, "onFileSearchBoxClick. curFileId: " + this.curFileId + ", curTitle: " + this.curTitle);
        Bundle bundle = new Bundle();
        bundle.putString("search_pc_file_id", this.curFileId);
        bundle.putString("search_pc_cur_dir_name", this.curTitle);
        bundle.putSerializable("search_pc_file_list_fragment_cls", FileListFragment.class);
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startSeach(getActivity(), 23, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading(boolean show) {
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.loadingDialog = null;
        if (show) {
            Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(requireContext(), getString(R.string.f1628621k), false);
            this.loadingDialog = showLoadingDialog;
            Intrinsics.checkNotNull(showLoadingDialog);
            showLoadingDialog.show();
        }
    }

    @Override // an2.b
    public void Qb(@NotNull BaseItemInfo itemInfo) {
        FileBridgeFileType fileBridgeFileType;
        Object obj;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) itemInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        if (itemInfo instanceof FileItemInfo) {
            FileItemInfo fileItemInfo = (FileItemInfo) itemInfo;
            enterFileDetail(fileItemInfo);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("dt_eid", "em_bas_file");
            linkedHashMap.put("dt_pgid", "pg_bas_computer_file");
            linkedHashMap.put("file_size", Long.valueOf(fileItemInfo.getKFileSize()));
            Object extra = itemInfo.getExtra();
            if (extra instanceof FileBridgeFileType) {
                fileBridgeFileType = (FileBridgeFileType) extra;
            } else {
                fileBridgeFileType = null;
            }
            if (fileBridgeFileType != null) {
                obj = Integer.valueOf(fileBridgeFileType.ordinal());
            } else {
                obj = FileBridgeFileType.KOTHER;
            }
            linkedHashMap.put("filetype", obj);
            FileItemInfo fileItemInfo2 = (FileItemInfo) itemInfo;
            if (fileItemInfo2.getDownloadState() != DownloadState.COMPLETE && !com.tencent.mobileqq.filemanager.util.q.p(fileItemInfo2.getLocalSavePath())) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            linkedHashMap.put("is_downloaded", Integer.valueOf(i3));
            com.tencent.mobileqq.wifiphoto.data.a.a(linkedHashMap);
            VideoReport.reportEvent("clck", linkedHashMap);
        }
    }

    @Override // an2.b
    public void T1(boolean isSelected, @NotNull BaseItemInfo itemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(isSelected), itemInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        this.listViewManager.y(isSelected, itemInfo.getFileId());
        List<BaseItemInfo> o16 = this.listViewManager.o();
        ArrayList arrayList = new ArrayList();
        for (Object obj : o16) {
            if (obj instanceof FileItemInfo) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += ((FileItemInfo) it.next()).getKFileSize();
        }
        String b16 = t.b(j3, FileListFragment$onCheckBoxSelect$sizeString$1.INSTANCE);
        di(o16.size(), "\u5df2\u9009 " + b16, j3);
    }

    @Override // an2.b
    public void Vb(@NotNull BaseItemInfo itemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) itemInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        if (itemInfo instanceof FileItemInfo) {
            FileItemInfo fileItemInfo = (FileItemInfo) itemInfo;
            if (fileItemInfo.getKFileType() == ItemType.NULL) {
                QLog.d("FileListFragment", 1, "onIconClick invalid file type");
            } else {
                enterFileDetail(fileItemInfo);
            }
        }
    }

    @Override // an2.a
    public void a4(@NotNull BaseItemInfo itemInfo) {
        FileBridgeNodeType fileBridgeNodeType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) itemInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        if (itemInfo instanceof DirectoryItemInfo) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("dt_eid", "em_bas_folder");
            linkedHashMap.put("dt_pgid", "pg_bas_computer_file");
            Object extra = itemInfo.getExtra();
            if (extra instanceof FileBridgeNodeType) {
                fileBridgeNodeType = (FileBridgeNodeType) extra;
            } else {
                fileBridgeNodeType = null;
            }
            if (fileBridgeNodeType == null) {
                fileBridgeNodeType = FileBridgeNodeType.KNULL;
            }
            linkedHashMap.put("folder_type", Integer.valueOf(fileBridgeNodeType.ordinal()));
            com.tencent.mobileqq.wifiphoto.data.a.a(linkedHashMap);
            VideoReport.reportEvent("clck", linkedHashMap);
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("key_export_file_list_file_id", itemInfo.getFileId());
            intent.putExtra("key_export_file_list_dir_name", ((DirectoryItemInfo) itemInfo).getFileName());
            QPublicFragmentActivity.start(context, intent, FileListFragment.class);
        }
    }

    @Override // an2.b
    public void kf(@NotNull BaseItemInfo itemInfo) {
        FileBridgeFileType fileBridgeFileType;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) itemInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        if (itemInfo instanceof FileItemInfo) {
            HashMap hashMap = new HashMap();
            Object extra = itemInfo.getExtra();
            if (extra instanceof FileBridgeFileType) {
                fileBridgeFileType = (FileBridgeFileType) extra;
            } else {
                fileBridgeFileType = null;
            }
            if (fileBridgeFileType == null) {
                fileBridgeFileType = FileBridgeFileType.KOTHER;
            }
            hashMap.put("filetype", Integer.valueOf(fileBridgeFileType.ordinal()));
            FileItemInfo fileItemInfo = (FileItemInfo) itemInfo;
            hashMap.put("file_size", Long.valueOf(fileItemInfo.getKFileSize()));
            if (fileItemInfo.getDownloadState() != DownloadState.COMPLETE && !com.tencent.mobileqq.filemanager.util.q.p(fileItemInfo.getLocalSavePath())) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            hashMap.put("is_downloaded", Integer.valueOf(i3));
            com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
            Unit unit = Unit.INSTANCE;
            com.tencent.mobileqq.wifiphoto.data.a.d(WinkDaTongReportConstant.ElementId.EM_BAS_DOWNLOAD, "pg_bas_computer_file", hashMap);
            if (FileItemInfoExtKt.d(fileItemInfo)) {
                Context context = getContext();
                if (context != null) {
                    ji(context, itemInfo.getFileId());
                    return;
                }
                return;
            }
            if (!FileItemInfoExtKt.c(fileItemInfo) && !FileItemInfoExtKt.h(fileItemInfo)) {
                Rh(itemInfo.getFileId());
                return;
            }
            QLog.d("FileListFragment", 1, "piState click fileId: " + itemInfo.getFileId());
            com.tencent.qqnt.kernel.api.p A = QFileBridgeService.f205517a.A();
            if (A != null) {
                A.cancelGet(itemInfo.getFileId());
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.exportfile.fragment.DisconnectListenerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        this.listViewManager.s(u.f205484a.b(this, this));
        MutableLiveData<com.tencent.mobileqq.exportfile.fragment.filelist.data.a> obtainUiState = this.listViewManager.r().obtainUiState();
        final FileListFragment$onCreate$1 fileListFragment$onCreate$1 = new FileListFragment$onCreate$1(this);
        obtainUiState.observeForever(new Observer() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FileListFragment.onCreate$lambda$0(Function1.this, obj);
            }
        });
        int i3 = N + 1;
        N = i3;
        if (i3 == 1) {
            if (this.mOpenFileDetailEventReceiver == null) {
                this.mOpenFileDetailEventReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.FileListFragment$onCreate$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileListFragment.this);
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
                        str = FileListFragment.this.OPEN_FILE_DETAIL_EVENT;
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
                            FileListFragment.this.enterFileDetail(fileItemInfo);
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
        View mContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            mContainer = (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m53.e g16 = m53.e.g(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
            this.binding = g16;
            m53.e eVar = null;
            if (Intrinsics.areEqual(QFileBridgeService.f205517a.I(), Boolean.TRUE)) {
                m53.e eVar2 = this.binding;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    eVar2 = null;
                }
                eVar2.f416214d.getCancelView().setVisibility(8);
                m53.e eVar3 = this.binding;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    eVar3 = null;
                }
                eVar3.f416214d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FileListFragment.Vh(FileListFragment.this, view);
                    }
                });
            } else {
                m53.e eVar4 = this.binding;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    eVar4 = null;
                }
                eVar4.f416214d.setVisibility(8);
            }
            m53.e eVar5 = this.binding;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                eVar = eVar5;
            }
            mContainer = eVar.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, mContainer);
        return mContainer;
    }

    @Override // com.tencent.mobileqq.exportfile.fragment.DisconnectListenerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onDestroy();
        MutableLiveData<com.tencent.mobileqq.exportfile.fragment.filelist.data.a> obtainUiState = this.listViewManager.r().obtainUiState();
        final FileListFragment$onDestroy$1 fileListFragment$onDestroy$1 = new FileListFragment$onDestroy$1(this);
        obtainUiState.removeObserver(new Observer() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FileListFragment.Wh(Function1.this, obj);
            }
        });
        RichMediaListView richMediaListView = this.richMediaListView;
        if (richMediaListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richMediaListView");
            richMediaListView = null;
        }
        richMediaListView.onDestroy();
        int i3 = N - 1;
        N = i3;
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

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onPause();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.mobileqq.wifiphoto.data.a.a(linkedHashMap);
        linkedHashMap.put("dt_pgid", "pg_bas_computer_file");
        VideoReport.reportEvent("pgout", linkedHashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.mobileqq.wifiphoto.data.a.a(linkedHashMap);
        linkedHashMap.put("dt_pgid", "pg_bas_computer_file");
        VideoReport.reportEvent("pgin", linkedHashMap);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        SystemBarActivityModule.setImmersiveStatus((QBaseActivity) requireActivity);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNull(requireActivity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((QBaseActivity) requireActivity2);
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setStatusBarDrawable(getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
            view.setPadding(0, RFWImmersiveUtils.getStatusBarHeight(getContext()) - 1, 0, 0);
        }
        m53.e eVar = this.binding;
        m53.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar = null;
        }
        RichMediaListView richMediaListView = eVar.f416215e;
        Intrinsics.checkNotNullExpressionValue(richMediaListView, "binding.fvFileList");
        this.richMediaListView = richMediaListView;
        if (richMediaListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richMediaListView");
            richMediaListView = null;
        }
        ListViewManager listViewManager = this.listViewManager;
        LifecycleOwner hostLifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "hostLifecycleOwner");
        richMediaListView.D(listViewManager, hostLifecycleOwner);
        Context context = getContext();
        if (context != null) {
            RichMediaListView richMediaListView2 = this.richMediaListView;
            if (richMediaListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("richMediaListView");
                richMediaListView2 = null;
            }
            richMediaListView2.F(context, ItemType.DIRECTORY, this);
            RichMediaListView richMediaListView3 = this.richMediaListView;
            if (richMediaListView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("richMediaListView");
                richMediaListView3 = null;
            }
            richMediaListView3.F(context, ItemType.FILE, this);
        }
        m53.e eVar3 = this.binding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar3 = null;
        }
        RichMediaListView richMediaListView4 = eVar3.f416215e;
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        richMediaListView4.setItemAnimator(defaultItemAnimator);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new FileListFragment$onViewCreated$3(this, null), 3, null);
        m53.e eVar4 = this.binding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar4 = null;
        }
        eVar4.f416216f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FileListFragment.ai(FileListFragment.this, view2);
            }
        });
        m53.e eVar5 = this.binding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar5 = null;
        }
        eVar5.f416217g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FileListFragment.bi(FileListFragment.this, view2);
            }
        });
        m53.e eVar6 = this.binding;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar6 = null;
        }
        eVar6.f416218h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FileListFragment.ci(FileListFragment.this, view2);
            }
        });
        m53.e eVar7 = this.binding;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar7 = null;
        }
        eVar7.f416223m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FileListFragment.Yh(FileListFragment.this, view2);
            }
        });
        Bundle arguments = getArguments();
        if (arguments == null || (a16 = arguments.getString("key_export_file_list_dir_name", null)) == null) {
            a16 = t.a(this);
        }
        this.curTitle = a16;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f224406iu);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.search_cur_dir_file)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{this.curTitle}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        m53.e eVar8 = this.binding;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar8 = null;
        }
        eVar8.f416214d.setEtInputHint(format);
        m53.e eVar9 = this.binding;
        if (eVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar9 = null;
        }
        eVar9.f416225o.setText(this.curTitle);
        m53.e eVar10 = this.binding;
        if (eVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            eVar10 = null;
        }
        eVar10.f416225o.setContentDescription(this.curTitle);
        m53.e eVar11 = this.binding;
        if (eVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            eVar2 = eVar11;
        }
        eVar2.f416225o.post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.n
            @Override // java.lang.Runnable
            public final void run() {
                FileListFragment.Zh(FileListFragment.this);
            }
        });
    }

    @Override // an2.b
    public void xf(@NotNull final FileItemInfo fileItemInfo, @NotNull RoundCornerImageView imageView, int width, int height) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, fileItemInfo, imageView, Integer.valueOf(width), Integer.valueOf(height));
            return;
        }
        Intrinsics.checkNotNullParameter(fileItemInfo, "fileItemInfo");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (!FileItemInfoExtKt.f(fileItemInfo) && !FileItemInfoExtKt.g(fileItemInfo)) {
            imageView.setImageResource(ah.f0(fileItemInfo.getFileName()));
            return;
        }
        if (TextUtils.isEmpty(fileItemInfo.getIconPath())) {
            com.tencent.qqnt.kernel.api.p A = QFileBridgeService.f205517a.A();
            if (A != null) {
                A.getThumbnail(false, fileItemInfo.getFileId(), new ThumbConfig(Integer.valueOf(width), Integer.valueOf(width), Integer.valueOf(width), 1), new IOperateCallback() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        FileListFragment.Xh(FileItemInfo.this, i3, str);
                    }
                });
                return;
            }
            return;
        }
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        String iconPath = fileItemInfo.getIconPath();
        Intrinsics.checkNotNull(iconPath);
        Context context = getContext();
        if (context != null) {
            drawable = ContextCompat.getDrawable(context, ah.f0(fileItemInfo.getFileTime()));
        } else {
            drawable = null;
        }
        iPicAIOApi.loadPic(new com.tencent.mobileqq.pic.option.a(iconPath, imageView, true, width, height, null, drawable, 32, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(DialogInterface dialogInterface, int i3) {
    }
}
