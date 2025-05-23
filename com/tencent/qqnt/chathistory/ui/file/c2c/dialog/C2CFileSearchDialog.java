package com.tencent.qqnt.chathistory.ui.file.c2c.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.aio.base.tool.d;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseChatDialogFragment;
import com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileCategoryFragment;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.C2CFileSearchDialogViewModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.a;
import com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.b;
import com.tencent.qqnt.chathistory.ui.file.c2c.viewmodel.ChatHistoryFileModel;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001VB\u000f\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u001b\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010)R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010)R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010A\u001a\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00105R\u0016\u0010N\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u00105R\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006W"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/C2CFileSearchDialog;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseChatDialogFragment;", "Lr3/e;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/a;", "state", "", "Sh", "", NodeProps.VISIBLE, "ei", "fi", "Th", "isSearch", "Ph", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onActivityCreated", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lq3/f;", "refreshLayout", "E6", "onResume", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", "parentViewModel", "Landroid/widget/EditText;", "D", "Landroid/widget/EditText;", "editText", "E", "Landroid/view/View;", "clearTextView", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "searchKeyWord", "G", "btnSearchCancel", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "I", "Landroid/view/ViewGroup;", "emptyViewContainer", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "J", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "K", "fileCategoryLayout", "L", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/f;", "M", "Lkotlin/Lazy;", "Qh", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/f;", "adapter", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/C2CFileSearchDialogViewModel;", "N", "Rh", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/C2CFileSearchDialogViewModel;", "viewModel", "", "P", "mFirstPosition", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mLastPosition", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Runnable;", "mShowKeyBoardTask", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;)V", ExifInterface.LATITUDE_SOUTH, "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class C2CFileSearchDialog extends BaseChatDialogFragment implements r3.e {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a S;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ChatHistoryFileModel parentViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private EditText editText;

    /* renamed from: E, reason: from kotlin metadata */
    private View clearTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String searchKeyWord;

    /* renamed from: G, reason: from kotlin metadata */
    private View btnSearchCancel;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup emptyViewContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private View fileCategoryLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: P, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Runnable mShowKeyBoardTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/C2CFileSearchDialog$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0 f353602e;

        public b(Function0 function0) {
            this.f353602e = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CFileSearchDialog.this, (Object) function0);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            String str;
            boolean z16;
            List emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) s16);
                return;
            }
            View view = null;
            if (s16 != null) {
                str = s16.toString();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                View view2 = C2CFileSearchDialog.this.clearTextView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
                    view2 = null;
                }
                view2.setVisibility(8);
                C2CFileSearchDialog.this.searchKeyWord = null;
                com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f Qh = C2CFileSearchDialog.this.Qh();
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Qh.t0(emptyList);
                C2CFileSearchDialog.this.fi(true);
                C2CFileSearchDialog.this.ei(false);
            } else if (!TextUtils.equals(C2CFileSearchDialog.this.searchKeyWord, str)) {
                C2CFileSearchDialog.this.searchKeyWord = str;
                View view3 = C2CFileSearchDialog.this.clearTextView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
                } else {
                    view = view3;
                }
                view.setVisibility(0);
                this.f353602e.invoke();
            }
            C2CFileSearchDialog.this.mFirstPosition = -1;
            C2CFileSearchDialog.this.mLastPosition = -1;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/file/c2c/dialog/C2CFileSearchDialog$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f353603d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C2CFileSearchDialog f353604e;

        c(RecyclerView recyclerView, C2CFileSearchDialog c2CFileSearchDialog) {
            this.f353603d = recyclerView;
            this.f353604e = c2CFileSearchDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) c2CFileSearchDialog);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            View view;
            Map<String, Object> mutableMapOf;
            View view2;
            Map<String, Object> mutableMapOf2;
            View view3;
            Map<String, Object> mutableMapOf3;
            View view4;
            Map<String, Object> mutableMapOf4;
            View view5;
            Map<String, Object> mutableMapOf5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (dy5 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            RecyclerView.LayoutManager layoutManager = this.f353603d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = this.f353603d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition2 = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() + this.f353603d.getChildCount();
            if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                if (this.f353604e.mFirstPosition == -1 || this.f353604e.mLastPosition == -1) {
                    this.f353604e.mFirstPosition = findFirstVisibleItemPosition;
                    this.f353604e.mLastPosition = findFirstVisibleItemPosition2;
                    int i3 = findFirstVisibleItemPosition2 - findFirstVisibleItemPosition;
                    for (int i16 = 0; i16 < i3 && i16 < this.f353603d.getChildCount(); i16++) {
                        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager3 = this.f353603d.getLayoutManager();
                        if (layoutManager3 != null) {
                            view = layoutManager3.findViewByPosition(i16);
                        } else {
                            view = null;
                        }
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353604e.Qh().n0(i16))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353604e.Qh().getNUM_BACKGOURND_ICON())));
                        a16.o(view, "em_bas_search_result_entry", mutableMapOf, String.valueOf(i16));
                    }
                    return;
                }
                if (z16) {
                    int i17 = findFirstVisibleItemPosition - this.f353604e.mFirstPosition;
                    for (int i18 = 0; i18 < i17 && i18 < this.f353603d.getChildCount(); i18++) {
                        HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager4 = this.f353603d.getLayoutManager();
                        if (layoutManager4 != null) {
                            view5 = layoutManager4.findViewByPosition(i18);
                        } else {
                            view5 = null;
                        }
                        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353604e.Qh().n0(i18))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353604e.Qh().getNUM_BACKGOURND_ICON())));
                        a17.q(view5, "em_bas_search_result_entry", mutableMapOf5, String.valueOf(i18));
                    }
                    int i19 = findFirstVisibleItemPosition2 - this.f353604e.mLastPosition;
                    for (int i26 = 0; i26 < i19 && i26 < this.f353603d.getChildCount(); i26++) {
                        HistoryDtReportHelper a18 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager5 = this.f353603d.getLayoutManager();
                        if (layoutManager5 != null) {
                            view4 = layoutManager5.findViewByPosition(i26);
                        } else {
                            view4 = null;
                        }
                        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353604e.Qh().n0(i26))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353604e.Qh().getNUM_BACKGOURND_ICON())));
                        a18.o(view4, "em_bas_search_result_entry", mutableMapOf4, String.valueOf(i26));
                    }
                } else {
                    int i27 = this.f353604e.mFirstPosition - findFirstVisibleItemPosition;
                    for (int i28 = 0; i28 < i27 && i28 < this.f353603d.getChildCount(); i28++) {
                        HistoryDtReportHelper a19 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager6 = this.f353603d.getLayoutManager();
                        if (layoutManager6 != null) {
                            view3 = layoutManager6.findViewByPosition(i28);
                        } else {
                            view3 = null;
                        }
                        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353604e.Qh().n0(i28))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353604e.Qh().getNUM_BACKGOURND_ICON())));
                        a19.o(view3, "em_bas_search_result_entry", mutableMapOf3, String.valueOf(i28));
                    }
                    int i29 = this.f353604e.mLastPosition - findFirstVisibleItemPosition2;
                    for (int i36 = 0; i36 < i29 && i36 < this.f353603d.getChildCount(); i36++) {
                        HistoryDtReportHelper a26 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager7 = this.f353603d.getLayoutManager();
                        if (layoutManager7 != null) {
                            view2 = layoutManager7.findViewByPosition(i36);
                        } else {
                            view2 = null;
                        }
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353604e.Qh().n0(i36))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353604e.Qh().getNUM_BACKGOURND_ICON())));
                        a26.q(view2, "em_bas_search_result_entry", mutableMapOf2, String.valueOf(i36));
                    }
                }
                this.f353604e.mFirstPosition = findFirstVisibleItemPosition;
                this.f353604e.mLastPosition = findFirstVisibleItemPosition2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            S = new a(null);
        }
    }

    public C2CFileSearchDialog(@NotNull ChatHistoryFileModel parentViewModel) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(parentViewModel, "parentViewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parentViewModel);
            return;
        }
        this.parentViewModel = parentViewModel;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$adapter$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/chathistory/ui/file/c2c/dialog/C2CFileSearchDialog$adapter$2$a", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "file", "Landroid/view/View;", "view", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "allRichRecord", "", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes23.dex */
            public static final class a implements com.tencent.qqnt.chathistory.ui.file.c2c.adapter.d {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ C2CFileSearchDialog f353600a;

                a(C2CFileSearchDialog c2CFileSearchDialog) {
                    this.f353600a = c2CFileSearchDialog;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) c2CFileSearchDialog);
                    }
                }

                @Override // com.tencent.qqnt.chathistory.ui.file.c2c.adapter.d
                public void a(@NotNull FileItemModel file, @NotNull View view, @NotNull List<MsgRecord> allRichRecord) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, file, view, allRichRecord);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(file, "file");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(allRichRecord, "allRichRecord");
                    com.tencent.qqnt.chathistory.service.a aVar = com.tencent.qqnt.chathistory.service.a.f353327a;
                    Context requireContext = this.f353600a.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    com.tencent.qqnt.chathistory.service.a.b(aVar, requireContext, file.y(), file.q(), view, allRichRecord, 0, 32, null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CFileSearchDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f invoke() {
                ChatHistoryFileModel chatHistoryFileModel;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                chatHistoryFileModel = C2CFileSearchDialog.this.parentViewModel;
                return new com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f(chatHistoryFileModel, new a(C2CFileSearchDialog.this), LifecycleOwnerKt.getLifecycleScope(C2CFileSearchDialog.this));
            }
        });
        this.adapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<C2CFileSearchDialogViewModel>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$viewModel$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chathistory/ui/file/c2c/dialog/C2CFileSearchDialog$viewModel$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes23.dex */
            public static final class a implements ViewModelProvider.Factory {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ C2CFileSearchDialog f353605a;

                a(C2CFileSearchDialog c2CFileSearchDialog) {
                    this.f353605a = c2CFileSearchDialog;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) c2CFileSearchDialog);
                    }
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
                    ChatHistoryFileModel chatHistoryFileModel;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
                    }
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    chatHistoryFileModel = this.f353605a.parentViewModel;
                    return new C2CFileSearchDialogViewModel(chatHistoryFileModel.N1());
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CFileSearchDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final C2CFileSearchDialogViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (C2CFileSearchDialogViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                C2CFileSearchDialog c2CFileSearchDialog = C2CFileSearchDialog.this;
                return (C2CFileSearchDialogViewModel) new ViewModelProvider(c2CFileSearchDialog, new a(c2CFileSearchDialog)).get(C2CFileSearchDialogViewModel.class);
            }
        });
        this.viewModel = lazy2;
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
        this.mShowKeyBoardTask = new Runnable() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.b
            @Override // java.lang.Runnable
            public final void run() {
                C2CFileSearchDialog.Wh(C2CFileSearchDialog.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Ph(boolean z16, Continuation<? super Unit> continuation) {
        List emptyList;
        Object coroutine_suspended;
        com.tencent.qqnt.chathistory.util.d.f354054a.a("C2CFileSearchDialog", " clearSearchCache");
        com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f Qh = Qh();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Qh.t0(emptyList);
        Object sendUserIntent = Rh().sendUserIntent(new a.C9536a(!z16 ? 1 : 0, ""), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (sendUserIntent == coroutine_suspended) {
            return sendUserIntent;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f Qh() {
        return (com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C2CFileSearchDialogViewModel Rh() {
        return (C2CFileSearchDialogViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh(com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a state) {
        List<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b> b16 = state.b();
        boolean a16 = state.a();
        com.tencent.qqnt.chathistory.util.d.f354054a.a("C2CFileSearchDialog", " handleUI hasMore " + a16);
        if (state.c()) {
            if (b16.isEmpty()) {
                ei(true);
            } else {
                Qh().t0(b16);
                ei(false);
                fi(false);
            }
        } else {
            Qh().l0(b16);
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.x();
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout2 = smartRefreshLayout3;
        }
        smartRefreshLayout2.setEnableLoadMore(a16);
    }

    private final void Th() {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$initEditTextLayout$searchAction$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CFileSearchDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String str = C2CFileSearchDialog.this.searchKeyWord;
                if (str != null) {
                    C2CFileSearchDialog c2CFileSearchDialog = C2CFileSearchDialog.this;
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(c2CFileSearchDialog), null, null, new C2CFileSearchDialog$initEditTextLayout$searchAction$1$1$1(c2CFileSearchDialog, str, null), 3, null);
                }
            }
        };
        View view = this.clearTextView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                C2CFileSearchDialog.Uh(C2CFileSearchDialog.this, view3);
            }
        });
        EditText editText = this.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        editText.addTextChangedListener(new b(function0));
        editText.setImeOptions(3);
        com.tencent.qqnt.chathistory.ui.dialog.a aVar = new com.tencent.qqnt.chathistory.ui.dialog.a(function0);
        editText.setOnEditorActionListener(aVar);
        editText.setOnKeyListener(aVar);
        editText.requestFocus();
        View view3 = this.btnSearchCancel;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSearchCancel");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                C2CFileSearchDialog.Vh(C2CFileSearchDialog.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(C2CFileSearchDialog this$0, View view) {
        List emptyList;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.setText("");
        com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f Qh = this$0.Qh();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Qh.t0(emptyList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(C2CFileSearchDialog this$0, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        Map mutableMapOf3;
        Map<String, Object> mutableMapOf4;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        HistoryDtReportHelper.SearchEntry searchEntry = HistoryDtReportHelper.SearchEntry.FILE;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("pgid", "pg_bas_search_activation"), TuplesKt.to("touin", companion.a().e(1, this$0.Rh().O1())), TuplesKt.to("aio_type", 1), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this$0.Rh().O1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_cancel_search_button", mutableMapOf2);
        HistoryDtReportHelper a17 = companion.a();
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("pgid", "pg_bas_search_results"), TuplesKt.to("touin", companion.a().e(1, this$0.Rh().O1())), TuplesKt.to("aio_type", 1), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this$0.Rh().O1()));
        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf3));
        a17.m(it, "em_bas_cancel_search_button", mutableMapOf4);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(C2CFileSearchDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        BaseAIOUtils.o(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(C2CFileSearchDialog this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new C2CFileSearchDialog$onCreateView$1$2$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(C2CFileSearchDialog this$0, final TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChatHistoryFileModel chatHistoryFileModel = this$0.parentViewModel;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        chatHistoryFileModel.Q1(requireActivity, ChatHistoryFileCategoryFragment.class, new Function1<Intent, Unit>(textView) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$onViewCreated$3$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextView $this_run;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_run = textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent start) {
                ArrayList<Integer> arrayListOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) start);
                    return;
                }
                Intrinsics.checkNotNullParameter(start, "$this$start");
                start.putExtra("extra_title", this.$this_run.getText());
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2);
                start.putIntegerArrayListExtra("extra_sub_type", arrayListOf);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(C2CFileSearchDialog this$0, final TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChatHistoryFileModel chatHistoryFileModel = this$0.parentViewModel;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        chatHistoryFileModel.Q1(requireActivity, ChatHistoryFileCategoryFragment.class, new Function1<Intent, Unit>(textView) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$onViewCreated$4$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextView $this_run;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_run = textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent start) {
                ArrayList<Integer> arrayListOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) start);
                    return;
                }
                Intrinsics.checkNotNullParameter(start, "$this$start");
                start.putExtra("extra_title", this.$this_run.getText());
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(1, 15);
                start.putIntegerArrayListExtra("extra_sub_type", arrayListOf);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(C2CFileSearchDialog this$0, final TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChatHistoryFileModel chatHistoryFileModel = this$0.parentViewModel;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        chatHistoryFileModel.Q1(requireActivity, ChatHistoryFileCategoryFragment.class, new Function1<Intent, Unit>(textView) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$onViewCreated$5$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextView $this_run;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_run = textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent start) {
                ArrayList<Integer> arrayListOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) start);
                    return;
                }
                Intrinsics.checkNotNullParameter(start, "$this$start");
                start.putExtra("extra_title", this.$this_run.getText());
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(3);
                start.putIntegerArrayListExtra("extra_sub_type", arrayListOf);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(C2CFileSearchDialog this$0, final TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChatHistoryFileModel chatHistoryFileModel = this$0.parentViewModel;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        chatHistoryFileModel.Q1(requireActivity, ChatHistoryFileCategoryFragment.class, new Function1<Intent, Unit>(textView) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$onViewCreated$6$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextView $this_run;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_run = textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent start) {
                ArrayList<Integer> arrayListOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) start);
                    return;
                }
                Intrinsics.checkNotNullParameter(start, "$this$start");
                start.putExtra("extra_title", this.$this_run.getText());
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(9, 10, 11, 12, 13, 14);
                start.putIntegerArrayListExtra("extra_sub_type", arrayListOf);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(C2CFileSearchDialog this$0, final TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChatHistoryFileModel chatHistoryFileModel = this$0.parentViewModel;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        chatHistoryFileModel.Q1(requireActivity, ChatHistoryFileCategoryFragment.class, new Function1<Intent, Unit>(textView) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$onViewCreated$2$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextView $this_run;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_run = textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Intent start) {
                ArrayList<Integer> arrayListOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) start);
                    return;
                }
                Intrinsics.checkNotNullParameter(start, "$this$start");
                start.putExtra("extra_title", this.$this_run.getText());
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(4, 5, 6, 7, 8, 0);
                start.putIntegerArrayListExtra("extra_sub_type", arrayListOf);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(boolean visible) {
        int i3;
        ViewGroup viewGroup = this.emptyViewContainer;
        SmartRefreshLayout smartRefreshLayout = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyViewContainer");
            viewGroup = null;
        }
        int i16 = 0;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        if (visible) {
            i16 = 8;
        }
        smartRefreshLayout.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(boolean visible) {
        int i3;
        View view = this.fileCategoryLayout;
        SmartRefreshLayout smartRefreshLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileCategoryLayout");
            view = null;
        }
        int i16 = 0;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        if (visible) {
            i16 = 8;
        }
        smartRefreshLayout.setVisibility(i16);
    }

    @Override // r3.e
    public void E6(@NotNull q3.f refreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) refreshLayout);
        } else {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C2CFileSearchDialog$onLoadMore$1(this, null), 3, null);
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseChatDialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onActivityCreated(savedInstanceState);
        ThreadManager.getUIHandler().postDelayed(this.mShowKeyBoardTask, 500L);
        Th();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View it = inflater.inflate(R.layout.e2n, container, false);
            QUISearchBar qUISearchBar = (QUISearchBar) it.findViewById(R.id.title);
            QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
            Intrinsics.checkNotNullExpressionValue(inputWidget, "inputWidget");
            this.editText = inputWidget;
            ImageView clearView = qUISearchBar.getClearView();
            Intrinsics.checkNotNullExpressionValue(clearView, "clearView");
            this.clearTextView = clearView;
            TextView cancelView = qUISearchBar.getCancelView();
            Intrinsics.checkNotNullExpressionValue(cancelView, "cancelView");
            this.btnSearchCancel = cancelView;
            View findViewById = it.findViewById(R.id.f86434rn);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.smart_refresh_layout)");
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
            this.refreshLayout = smartRefreshLayout;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout = null;
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            smartRefreshLayout.X(new HistoryLoadMoreFooter(requireContext));
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.W(new r3.e() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.a
                @Override // r3.e
                public final void E6(q3.f fVar) {
                    C2CFileSearchDialog.Xh(C2CFileSearchDialog.this, fVar);
                }
            });
            View findViewById2 = it.findViewById(R.id.f792849c);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ry)");
            RecyclerView recyclerView = (RecyclerView) findViewById2;
            this.recyclerView = recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            recyclerView.setAdapter(Qh());
            recyclerView.addOnScrollListener(new c(recyclerView, this));
            if (this.recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            if (this.recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            View findViewById3 = it.findViewById(R.id.bwb);
            ViewGroup viewGroup = (ViewGroup) findViewById3;
            QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(it.getContext()).setImageType(9);
            String string = getString(R.string.zke);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_history_no_file_search)");
            QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
            build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(build);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<ViewGroup?>\u2026          }\n            }");
            this.emptyViewContainer = viewGroup;
            View findViewById4 = it.findViewById(R.id.f165202v53);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.file_category)");
            this.fileCategoryLayout = findViewById4;
            EditText editText = this.editText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                editText = null;
            }
            editText.setHint(R.string.f170725a14);
            d.Companion companion = com.tencent.aio.base.tool.d.INSTANCE;
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            int a16 = companion.a(requireContext2);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.setPadding(it.getPaddingLeft(), a16, it.getPaddingRight(), it.getPaddingBottom());
            Intrinsics.checkNotNullExpressionValue(it, "inflater.inflate(R.layou\u2026statusBarHeight\n        }");
            this.rootView = it;
            HistoryDtReportHelper.Companion companion2 = HistoryDtReportHelper.INSTANCE;
            HistoryDtReportHelper a17 = companion2.a();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            HistoryDtReportHelper.SearchEntry searchEntry = HistoryDtReportHelper.SearchEntry.FILE;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion2.a().e(1, Rh().O1())), TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("aio_type", 1), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, Rh().O1()));
            a17.v(requireActivity, this, "pg_bas_search_activation", mutableMapOf);
            HistoryDtReportHelper a18 = companion2.a();
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion2.a().e(1, Rh().O1())), TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("aio_type", 1), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, Rh().O1()));
            a18.v(requireActivity2, view2, "pg_bas_search_results", mutableMapOf2);
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.qqnt.chathistory.util.d.f354054a.a("C2CFileSearchDialog", " onDestroy");
        Rh().M1(new a.C9536a(1, "destory"));
        super.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
            Qh().notifyItemRangeChanged(0, Qh().getNUM_BACKGOURND_ICON());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int i3 = this.mLastPosition - this.mFirstPosition;
        for (int i16 = 0; i16 < i3; i16++) {
            RecyclerView recyclerView = this.recyclerView;
            View view = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            if (i16 >= recyclerView.getChildCount()) {
                break;
            }
            HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager != null) {
                view = layoutManager.findViewByPosition(i16);
            }
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(Qh().n0(i16))), TuplesKt.to("number_search_results", Integer.valueOf(Qh().getNUM_BACKGOURND_ICON())));
            a16.q(view, "em_bas_search_result_entry", mutableMapOf, String.valueOf(i16));
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MutableLiveData<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.b> obtainUiState = Rh().obtainUiState();
        final Function1<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.b, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.b, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CFileSearchDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.b bVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                } else if (bVar instanceof b.a) {
                    C2CFileSearchDialog.this.Sh(((b.a) bVar).a());
                }
            }
        };
        obtainUiState.observe(this, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2CFileSearchDialog.ci(Function1.this, obj);
            }
        });
        final TextView textView = (TextView) view.findViewById(R.id.f1051865b);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2CFileSearchDialog.di(C2CFileSearchDialog.this, textView, view2);
            }
        });
        final TextView textView2 = (TextView) view.findViewById(R.id.f1057266s);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2CFileSearchDialog.Yh(C2CFileSearchDialog.this, textView2, view2);
            }
        });
        final TextView textView3 = (TextView) view.findViewById(R.id.f1053365q);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2CFileSearchDialog.Zh(C2CFileSearchDialog.this, textView3, view2);
            }
        });
        final TextView textView4 = (TextView) view.findViewById(R.id.f1054165y);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2CFileSearchDialog.ai(C2CFileSearchDialog.this, textView4, view2);
            }
        });
        final TextView textView5 = (TextView) view.findViewById(R.id.f1054065x);
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2CFileSearchDialog.bi(C2CFileSearchDialog.this, textView5, view2);
            }
        });
    }
}
