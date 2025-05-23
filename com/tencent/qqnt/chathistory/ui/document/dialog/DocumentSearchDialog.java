package com.tencent.qqnt.chathistory.ui.document.dialog;

import android.content.Context;
import android.content.DialogInterface;
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
import androidx.annotation.CallSuper;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseChatDialogFragment;
import com.tencent.qqnt.chathistory.ui.document.data.a;
import com.tencent.qqnt.chathistory.ui.document.data.b;
import com.tencent.qqnt.chathistory.ui.document.viewmodel.ChatHistoryDocumentViewModel;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.chathistory.util.l;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
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
import q3.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u0000 V2\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010'\u001a\u00020\"\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001b\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010-R\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00108R\u0016\u0010S\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00108\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/dialog/DocumentSearchDialog;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseChatDialogFragment;", "", "Lh", "Lcom/tencent/qqnt/chathistory/ui/document/dialog/data/a;", "state", "Kh", "", "show", "Rh", "isSearch", "Hh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onActivityCreated", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "showNow", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/chathistory/ui/document/viewmodel/ChatHistoryDocumentViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/ui/document/viewmodel/ChatHistoryDocumentViewModel;", "Jh", "()Lcom/tencent/qqnt/chathistory/ui/document/viewmodel/ChatHistoryDocumentViewModel;", "viewModel", "Landroid/widget/EditText;", "D", "Landroid/widget/EditText;", "editText", "E", "Landroid/view/View;", "clearTextView", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "searchKeyWord", "G", "btnSearchCancel", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "I", "Landroid/view/ViewGroup;", "emptyViewContainer", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "J", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/b;", "K", "Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/b;", "adapter", "Ljava/lang/Runnable;", "L", "Ljava/lang/Runnable;", "mShowKeyBoardTask", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "M", "Lkotlin/Lazy;", "Ih", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "N", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "P", "mFirstPosition", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mLastPosition", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/document/viewmodel/ChatHistoryDocumentViewModel;)V", BdhLogUtil.LogTag.Tag_Req, "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class DocumentSearchDialog extends BaseChatDialogFragment {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a R;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ChatHistoryDocumentViewModel viewModel;

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
    @NotNull
    private final com.tencent.qqnt.chathistory.ui.document.dialog.adapter.b adapter;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Runnable mShowKeyBoardTask;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: N, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: P, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mLastPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/dialog/DocumentSearchDialog$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chathistory/ui/document/dialog/DocumentSearchDialog$b", "Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/c;", "", "document", "", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.qqnt.chathistory.ui.document.dialog.adapter.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocumentSearchDialog.this);
            }
        }

        @Override // com.tencent.qqnt.chathistory.ui.document.dialog.adapter.c
        public void a(@Nullable String document) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) document);
                return;
            }
            ChatHistoryDocumentViewModel Jh = DocumentSearchDialog.this.Jh();
            Context requireContext = DocumentSearchDialog.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ChatHistoryDocumentViewModel.a2(Jh, requireContext, document, 0, 4, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0 f353499e;

        public c(Function0 function0) {
            this.f353499e = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocumentSearchDialog.this, (Object) function0);
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
                View view2 = DocumentSearchDialog.this.clearTextView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
                    view2 = null;
                }
                view2.setVisibility(8);
                DocumentSearchDialog.this.searchKeyWord = null;
                com.tencent.qqnt.chathistory.ui.document.dialog.adapter.b bVar = DocumentSearchDialog.this.adapter;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                bVar.p0(emptyList);
            } else if (!TextUtils.equals(DocumentSearchDialog.this.searchKeyWord, str)) {
                DocumentSearchDialog.this.searchKeyWord = str;
                View view3 = DocumentSearchDialog.this.clearTextView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
                } else {
                    view = view3;
                }
                view.setVisibility(0);
                this.f353499e.invoke();
            }
            DocumentSearchDialog.this.mFirstPosition = -1;
            DocumentSearchDialog.this.mLastPosition = -1;
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/chathistory/ui/document/dialog/DocumentSearchDialog$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f353500d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DocumentSearchDialog f353501e;

        d(RecyclerView recyclerView, DocumentSearchDialog documentSearchDialog) {
            this.f353500d = recyclerView;
            this.f353501e = documentSearchDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) documentSearchDialog);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 1) {
                l.f354063a.g(recyclerView);
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (dy5 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            RecyclerView.LayoutManager layoutManager = this.f353500d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = this.f353500d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition2 = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() + this.f353500d.getChildCount();
            if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                if (this.f353501e.mFirstPosition == -1 || this.f353501e.mLastPosition == -1) {
                    this.f353501e.mFirstPosition = findFirstVisibleItemPosition;
                    this.f353501e.mLastPosition = findFirstVisibleItemPosition2;
                    int i3 = findFirstVisibleItemPosition2 - findFirstVisibleItemPosition;
                    for (int i16 = 0; i16 < i3 && i16 < this.f353500d.getChildCount(); i16++) {
                        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager3 = this.f353500d.getLayoutManager();
                        if (layoutManager3 != null) {
                            view = layoutManager3.findViewByPosition(i16);
                        } else {
                            view = null;
                        }
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353501e.adapter.m0(i16))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353501e.adapter.getNUM_BACKGOURND_ICON())));
                        a16.o(view, "em_bas_search_result_entry", mutableMapOf, String.valueOf(i16));
                    }
                    return;
                }
                if (z16) {
                    int i17 = findFirstVisibleItemPosition - this.f353501e.mFirstPosition;
                    for (int i18 = 0; i18 < i17 && i18 < this.f353500d.getChildCount(); i18++) {
                        HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager4 = this.f353500d.getLayoutManager();
                        if (layoutManager4 != null) {
                            view5 = layoutManager4.findViewByPosition(i18);
                        } else {
                            view5 = null;
                        }
                        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353501e.adapter.m0(i18))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353501e.adapter.getNUM_BACKGOURND_ICON())));
                        a17.q(view5, "em_bas_search_result_entry", mutableMapOf5, String.valueOf(i18));
                    }
                    int i19 = findFirstVisibleItemPosition2 - this.f353501e.mLastPosition;
                    for (int i26 = 0; i26 < i19 && i26 < this.f353500d.getChildCount(); i26++) {
                        HistoryDtReportHelper a18 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager5 = this.f353500d.getLayoutManager();
                        if (layoutManager5 != null) {
                            view4 = layoutManager5.findViewByPosition(i26);
                        } else {
                            view4 = null;
                        }
                        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353501e.adapter.m0(i26))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353501e.adapter.getNUM_BACKGOURND_ICON())));
                        a18.o(view4, "em_bas_search_result_entry", mutableMapOf4, String.valueOf(i26));
                    }
                } else {
                    int i27 = this.f353501e.mFirstPosition - findFirstVisibleItemPosition;
                    for (int i28 = 0; i28 < i27 && i28 < this.f353500d.getChildCount(); i28++) {
                        HistoryDtReportHelper a19 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager6 = this.f353500d.getLayoutManager();
                        if (layoutManager6 != null) {
                            view3 = layoutManager6.findViewByPosition(i28);
                        } else {
                            view3 = null;
                        }
                        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353501e.adapter.m0(i28))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353501e.adapter.getNUM_BACKGOURND_ICON())));
                        a19.o(view3, "em_bas_search_result_entry", mutableMapOf3, String.valueOf(i28));
                    }
                    int i29 = this.f353501e.mLastPosition - findFirstVisibleItemPosition2;
                    for (int i36 = 0; i36 < i29 && i36 < this.f353500d.getChildCount(); i36++) {
                        HistoryDtReportHelper a26 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager7 = this.f353500d.getLayoutManager();
                        if (layoutManager7 != null) {
                            view2 = layoutManager7.findViewByPosition(i36);
                        } else {
                            view2 = null;
                        }
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353501e.adapter.m0(i36))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353501e.adapter.getNUM_BACKGOURND_ICON())));
                        a26.q(view2, "em_bas_search_result_entry", mutableMapOf2, String.valueOf(i36));
                    }
                }
                this.f353501e.mFirstPosition = findFirstVisibleItemPosition;
                this.f353501e.mLastPosition = findFirstVisibleItemPosition2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44281);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            R = new a(null);
        }
    }

    public DocumentSearchDialog(@NotNull ChatHistoryDocumentViewModel viewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewModel);
            return;
        }
        this.viewModel = viewModel;
        this.adapter = new com.tencent.qqnt.chathistory.ui.document.dialog.adapter.b(new b(), viewModel.M1(), LifecycleOwnerKt.getLifecycleScope(this));
        this.mShowKeyBoardTask = new Runnable() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.b
            @Override // java.lang.Runnable
            public final void run() {
                DocumentSearchDialog.Oh(DocumentSearchDialog.this);
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.DocumentSearchDialog$emptyView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DocumentSearchDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIEmptyState invoke() {
                ViewGroup viewGroup;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(DocumentSearchDialog.this.getContext()).setImageType(9);
                String string = DocumentSearchDialog.this.getString(R.string.zkc);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_\u2026story_no_document_search)");
                QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
                DocumentSearchDialog documentSearchDialog = DocumentSearchDialog.this;
                build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                viewGroup = documentSearchDialog.emptyViewContainer;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyViewContainer");
                    viewGroup = null;
                }
                viewGroup.addView(build);
                return build;
            }
        });
        this.emptyView = lazy;
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Hh(boolean z16, Continuation<? super Unit> continuation) {
        List emptyList;
        Object coroutine_suspended;
        com.tencent.qqnt.chathistory.ui.document.dialog.adapter.b bVar = this.adapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        bVar.p0(emptyList);
        Object sendUserIntent = this.viewModel.sendUserIntent(new b.a(!z16 ? 1 : 0, ""), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (sendUserIntent == coroutine_suspended) {
            return sendUserIntent;
        }
        return Unit.INSTANCE;
    }

    private final QUIEmptyState Ih() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(com.tencent.qqnt.chathistory.ui.document.dialog.data.a state) {
        ArrayList<SearchMsgItem> data = state.a().resultItems;
        boolean z16 = state.a().hasMore;
        com.tencent.qqnt.chathistory.util.d.f354054a.a("DocumentSearchDialog", " handleUI hasMore " + z16);
        if (state.b()) {
            if (data.isEmpty()) {
                Rh(true);
            } else {
                com.tencent.qqnt.chathistory.ui.document.dialog.adapter.b bVar = this.adapter;
                Intrinsics.checkNotNullExpressionValue(data, "data");
                bVar.p0(data);
                Rh(false);
            }
        } else {
            com.tencent.qqnt.chathistory.ui.document.dialog.adapter.b bVar2 = this.adapter;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            bVar2.l0(data);
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
        smartRefreshLayout2.setEnableLoadMore(z16);
    }

    private final void Lh() {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.DocumentSearchDialog$initEditTextLayout$searchAction$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocumentSearchDialog.this);
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
                String str = DocumentSearchDialog.this.searchKeyWord;
                if (str != null) {
                    DocumentSearchDialog documentSearchDialog = DocumentSearchDialog.this;
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(documentSearchDialog), null, null, new DocumentSearchDialog$initEditTextLayout$searchAction$1$1$1(documentSearchDialog, str, null), 3, null);
                }
            }
        };
        View view = this.clearTextView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DocumentSearchDialog.Mh(DocumentSearchDialog.this, view3);
            }
        });
        EditText editText = this.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        editText.addTextChangedListener(new c(function0));
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
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                DocumentSearchDialog.Nh(DocumentSearchDialog.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(DocumentSearchDialog this$0, View view) {
        List emptyList;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.setText("");
        com.tencent.qqnt.chathistory.ui.document.dialog.adapter.b bVar = this$0.adapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        bVar.p0(emptyList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(DocumentSearchDialog this$0, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        Map mutableMapOf3;
        Map<String, Object> mutableMapOf4;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = l.f354063a;
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        lVar.g(editText);
        this$0.dismissAllowingStateLoss();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        HistoryDtReportHelper.SearchEntry searchEntry = HistoryDtReportHelper.SearchEntry.DOCUMENT;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("pgid", "pg_bas_search_activation"), TuplesKt.to("touin", companion.a().d(this$0.viewModel)), TuplesKt.to("aio_type", Integer.valueOf(this$0.viewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this$0.viewModel.N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_cancel_search_button", mutableMapOf2);
        HistoryDtReportHelper a17 = companion.a();
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("pgid", "pg_bas_search_results"), TuplesKt.to("touin", companion.a().d(this$0.viewModel)), TuplesKt.to("aio_type", Integer.valueOf(this$0.viewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this$0.viewModel.N1()));
        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf3));
        a17.m(it, "em_bas_cancel_search_button", mutableMapOf4);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(DocumentSearchDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        BaseAIOUtils.o(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(DocumentSearchDialog this$0, f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new DocumentSearchDialog$onCreateView$1$3$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Rh(boolean show) {
        int i3;
        QUIEmptyState Ih = Ih();
        int i16 = 0;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        Ih.setVisibility(i3);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (show) {
            i16 = 8;
        }
        recyclerView.setVisibility(i16);
    }

    @NotNull
    public final ChatHistoryDocumentViewModel Jh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ChatHistoryDocumentViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.viewModel;
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseChatDialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onActivityCreated(savedInstanceState);
        ThreadManager.getUIHandler().postDelayed(this.mShowKeyBoardTask, 500L);
        Lh();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View it = inflater.inflate(R.layout.e2o, container, false);
            QUISearchBar qUISearchBar = (QUISearchBar) it.findViewById(R.id.f66413ak);
            QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
            Intrinsics.checkNotNullExpressionValue(inputWidget, "inputWidget");
            this.editText = inputWidget;
            ImageView clearView = qUISearchBar.getClearView();
            Intrinsics.checkNotNullExpressionValue(clearView, "clearView");
            this.clearTextView = clearView;
            TextView cancelView = qUISearchBar.getCancelView();
            Intrinsics.checkNotNullExpressionValue(cancelView, "cancelView");
            this.btnSearchCancel = cancelView;
            View findViewById = it.findViewById(R.id.f792849c);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ry)");
            RecyclerView recyclerView = (RecyclerView) findViewById;
            this.recyclerView = recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(it.getContext()));
            recyclerView.setAdapter(this.adapter);
            recyclerView.addOnScrollListener(new d(recyclerView, this));
            View findViewById2 = it.findViewById(R.id.f86434rn);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.smart_refresh_layout)");
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById2;
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
            smartRefreshLayout2.S(false);
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.W(new r3.e() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.a
                @Override // r3.e
                public final void E6(f fVar) {
                    DocumentSearchDialog.Ph(DocumentSearchDialog.this, fVar);
                }
            });
            View findViewById3 = it.findViewById(R.id.v7b);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.flEmptyContainer)");
            this.emptyViewContainer = (ViewGroup) findViewById3;
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
            HistoryDtReportHelper.SearchEntry searchEntry = HistoryDtReportHelper.SearchEntry.DOCUMENT;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion2.a().d(this.viewModel)), TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("aio_type", Integer.valueOf(this.viewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this.viewModel.N1()));
            a17.v(requireActivity, this, "pg_bas_search_activation", mutableMapOf);
            HistoryDtReportHelper a18 = companion2.a();
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion2.a().d(this.viewModel)), TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("aio_type", Integer.valueOf(this.viewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this.viewModel.N1()));
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
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DocumentSearchDialog$onDestroy$1(this, null), 3, null);
            super.onDestroy();
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        ThreadManager.getUIHandler().removeCallbacks(this.mShowKeyBoardTask);
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
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
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.adapter.m0(i16))), TuplesKt.to("number_search_results", Integer.valueOf(this.adapter.getNUM_BACKGOURND_ICON())));
            a16.q(view, "em_bas_search_result_entry", mutableMapOf, String.valueOf(i16));
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LiveData obtainUiState = this.viewModel.obtainUiState();
        final Function1<com.tencent.qqnt.chathistory.ui.document.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.document.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.DocumentSearchDialog$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DocumentSearchDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.document.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.document.data.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                } else if (aVar instanceof a.d) {
                    DocumentSearchDialog.this.Kh(((a.d) aVar).a());
                }
            }
        };
        obtainUiState.observe(this, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DocumentSearchDialog.Qh(Function1.this, obj);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    @CallSuper
    public void showNow(@NotNull FragmentManager manager, @Nullable String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) manager, (Object) tag);
            return;
        }
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.showNow(manager, tag);
        EditText editText = this.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.setText("");
    }
}
