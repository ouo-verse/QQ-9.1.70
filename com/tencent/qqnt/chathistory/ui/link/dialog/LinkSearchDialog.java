package com.tencent.qqnt.chathistory.ui.link.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
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
import com.tencent.qqnt.chathistory.ui.link.data.a;
import com.tencent.qqnt.chathistory.ui.link.data.b;
import com.tencent.qqnt.chathistory.ui.link.viewmodel.ChatHistoryLinkViewModel;
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
import r3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001^B\u000f\u0012\u0006\u0010/\u001a\u00020*\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0017J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020 H\u0016R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00105R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010&\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u00105R\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010AR\u0016\u0010V\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010AR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006_"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/dialog/LinkSearchDialog;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseChatDialogFragment;", "Lr3/e;", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/c;", "", "Kh", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/data/a;", "state", "Jh", "", "show", "Ph", "isSearch", "Gh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onActivityCreated", "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "showNow", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lq3/f;", "refreshLayout", "E6", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "j0", "Lcom/tencent/qqnt/chathistory/ui/link/viewmodel/ChatHistoryLinkViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/ui/link/viewmodel/ChatHistoryLinkViewModel;", "Ih", "()Lcom/tencent/qqnt/chathistory/ui/link/viewmodel/ChatHistoryLinkViewModel;", "viewModel", "Landroid/widget/EditText;", "D", "Landroid/widget/EditText;", "editText", "E", "Landroid/view/View;", "clearTextView", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "searchKeyWord", "G", "btnSearchCancel", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/a;", "H", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/a;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "I", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "J", "Landroid/view/ViewGroup;", "emptyViewContainer", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "K", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "L", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "M", "Lkotlin/Lazy;", "Hh", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "", "N", "mFirstPosition", "P", "mLastPosition", "Ljava/lang/Runnable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", "mShowKeyBoardTask", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/link/viewmodel/ChatHistoryLinkViewModel;)V", BdhLogUtil.LogTag.Tag_Req, "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LinkSearchDialog extends BaseChatDialogFragment implements e, com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.c {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ChatHistoryLinkViewModel viewModel;

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
    @NotNull
    private final com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a adapter;

    /* renamed from: I, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: J, reason: from kotlin metadata */
    private ViewGroup emptyViewContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: N, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: P, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Runnable mShowKeyBoardTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/dialog/LinkSearchDialog$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.link.dialog.LinkSearchDialog$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0 f353727e;

        public b(Function0 function0) {
            this.f353727e = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LinkSearchDialog.this, (Object) function0);
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
                View view2 = LinkSearchDialog.this.clearTextView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
                    view2 = null;
                }
                view2.setVisibility(8);
                LinkSearchDialog.this.searchKeyWord = null;
                com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a aVar = LinkSearchDialog.this.adapter;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                aVar.p0(emptyList, false);
            } else if (!TextUtils.equals(LinkSearchDialog.this.searchKeyWord, str)) {
                LinkSearchDialog.this.searchKeyWord = str;
                View view3 = LinkSearchDialog.this.clearTextView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
                } else {
                    view = view3;
                }
                view.setVisibility(0);
                this.f353727e.invoke();
            }
            LinkSearchDialog.this.mFirstPosition = -1;
            LinkSearchDialog.this.mLastPosition = -1;
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/chathistory/ui/link/dialog/LinkSearchDialog$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f353728d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LinkSearchDialog f353729e;

        c(RecyclerView recyclerView, LinkSearchDialog linkSearchDialog) {
            this.f353728d = recyclerView;
            this.f353729e = linkSearchDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) linkSearchDialog);
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
            RecyclerView.LayoutManager layoutManager = this.f353728d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = this.f353728d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition2 = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() + this.f353728d.getChildCount();
            if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                if (this.f353729e.mFirstPosition == -1 || this.f353729e.mLastPosition == -1) {
                    this.f353729e.mFirstPosition = findFirstVisibleItemPosition;
                    this.f353729e.mLastPosition = findFirstVisibleItemPosition2;
                    int i3 = findFirstVisibleItemPosition2 - findFirstVisibleItemPosition;
                    for (int i16 = 0; i16 < i3 && i16 < this.f353728d.getChildCount(); i16++) {
                        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager3 = this.f353728d.getLayoutManager();
                        if (layoutManager3 != null) {
                            view = layoutManager3.findViewByPosition(i16);
                        } else {
                            view = null;
                        }
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353729e.adapter.m0(i16))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353729e.adapter.getNUM_BACKGOURND_ICON())));
                        a16.o(view, "em_bas_search_result_entry", mutableMapOf, String.valueOf(i16));
                    }
                    return;
                }
                if (z16) {
                    int i17 = findFirstVisibleItemPosition - this.f353729e.mFirstPosition;
                    for (int i18 = 0; i18 < i17 && i18 < this.f353728d.getChildCount(); i18++) {
                        HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager4 = this.f353728d.getLayoutManager();
                        if (layoutManager4 != null) {
                            view5 = layoutManager4.findViewByPosition(i18);
                        } else {
                            view5 = null;
                        }
                        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353729e.adapter.m0(i18))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353729e.adapter.getNUM_BACKGOURND_ICON())));
                        a17.q(view5, "em_bas_search_result_entry", mutableMapOf5, String.valueOf(i18));
                    }
                    int i19 = findFirstVisibleItemPosition2 - this.f353729e.mLastPosition;
                    for (int i26 = 0; i26 < i19 && i26 < this.f353728d.getChildCount(); i26++) {
                        HistoryDtReportHelper a18 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager5 = this.f353728d.getLayoutManager();
                        if (layoutManager5 != null) {
                            view4 = layoutManager5.findViewByPosition(i26);
                        } else {
                            view4 = null;
                        }
                        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353729e.adapter.m0(i26))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353729e.adapter.getNUM_BACKGOURND_ICON())));
                        a18.o(view4, "em_bas_search_result_entry", mutableMapOf4, String.valueOf(i26));
                    }
                } else {
                    int i27 = this.f353729e.mFirstPosition - findFirstVisibleItemPosition;
                    for (int i28 = 0; i28 < i27 && i28 < this.f353728d.getChildCount(); i28++) {
                        HistoryDtReportHelper a19 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager6 = this.f353728d.getLayoutManager();
                        if (layoutManager6 != null) {
                            view3 = layoutManager6.findViewByPosition(i28);
                        } else {
                            view3 = null;
                        }
                        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353729e.adapter.m0(i28))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353729e.adapter.getNUM_BACKGOURND_ICON())));
                        a19.o(view3, "em_bas_search_result_entry", mutableMapOf3, String.valueOf(i28));
                    }
                    int i29 = this.f353729e.mLastPosition - findFirstVisibleItemPosition2;
                    for (int i36 = 0; i36 < i29 && i36 < this.f353728d.getChildCount(); i36++) {
                        HistoryDtReportHelper a26 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager7 = this.f353728d.getLayoutManager();
                        if (layoutManager7 != null) {
                            view2 = layoutManager7.findViewByPosition(i36);
                        } else {
                            view2 = null;
                        }
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353729e.adapter.m0(i36))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353729e.adapter.getNUM_BACKGOURND_ICON())));
                        a26.q(view2, "em_bas_search_result_entry", mutableMapOf2, String.valueOf(i36));
                    }
                }
                this.f353729e.mFirstPosition = findFirstVisibleItemPosition;
                this.f353729e.mLastPosition = findFirstVisibleItemPosition2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47329);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LinkSearchDialog(@NotNull ChatHistoryLinkViewModel viewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewModel);
            return;
        }
        this.viewModel = viewModel;
        this.adapter = new com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a(this, viewModel.M1(), LifecycleOwnerKt.getLifecycleScope(this));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.qqnt.chathistory.ui.link.dialog.LinkSearchDialog$emptyView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LinkSearchDialog.this);
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
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(LinkSearchDialog.this.getContext()).setImageType(9);
                String string = LinkSearchDialog.this.getString(R.string.zkg);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_\u2026tory_no_link_file_search)");
                QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
                LinkSearchDialog linkSearchDialog = LinkSearchDialog.this;
                build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                build.setVisibility(0);
                viewGroup = linkSearchDialog.emptyViewContainer;
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
        this.mShowKeyBoardTask = new Runnable() { // from class: com.tencent.qqnt.chathistory.ui.link.dialog.a
            @Override // java.lang.Runnable
            public final void run() {
                LinkSearchDialog.Nh(LinkSearchDialog.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Gh(boolean z16, Continuation<? super Unit> continuation) {
        List emptyList;
        Object coroutine_suspended;
        com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a aVar = this.adapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        aVar.p0(emptyList, false);
        Object sendUserIntent = this.viewModel.sendUserIntent(new b.a(!z16 ? 1 : 0, ""), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (sendUserIntent == coroutine_suspended) {
            return sendUserIntent;
        }
        return Unit.INSTANCE;
    }

    private final QUIEmptyState Hh() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(com.tencent.qqnt.chathistory.ui.link.dialog.data.a state) {
        ArrayList<SearchMsgItem> arrayList = state.a().resultItems;
        boolean z16 = state.a().hasMore;
        com.tencent.qqnt.chathistory.util.d.f354054a.a("LinkSearchDialog", " handleUI hasMore " + z16 + " " + state);
        SmartRefreshLayout smartRefreshLayout = null;
        if (state.b()) {
            if (arrayList.isEmpty()) {
                Ph(true);
            } else {
                com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a aVar = this.adapter;
                ArrayList<SearchMsgItem> arrayList2 = state.a().resultItems;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "state.result.resultItems");
                com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a.q0(aVar, arrayList2, false, 2, null);
                Ph(false);
            }
        } else {
            com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a aVar2 = this.adapter;
            ArrayList<SearchMsgItem> arrayList3 = state.a().resultItems;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "state.result.resultItems");
            aVar2.l0(arrayList3);
        }
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.x();
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout3;
        }
        smartRefreshLayout.setEnableLoadMore(z16);
    }

    private final void Kh() {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.dialog.LinkSearchDialog$initEditTextLayout$searchAction$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LinkSearchDialog.this);
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
                String str = LinkSearchDialog.this.searchKeyWord;
                if (str != null) {
                    LinkSearchDialog linkSearchDialog = LinkSearchDialog.this;
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(linkSearchDialog), null, null, new LinkSearchDialog$initEditTextLayout$searchAction$1$1$1(linkSearchDialog, str, null), 3, null);
                }
            }
        };
        View view = this.clearTextView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LinkSearchDialog.Lh(LinkSearchDialog.this, view3);
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
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                LinkSearchDialog.Mh(LinkSearchDialog.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(LinkSearchDialog this$0, View view) {
        List emptyList;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.setText("");
        com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a aVar = this$0.adapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        aVar.p0(emptyList, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(LinkSearchDialog this$0, View it) {
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
        HistoryDtReportHelper.SearchEntry searchEntry = HistoryDtReportHelper.SearchEntry.LINK;
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
    public static final void Nh(LinkSearchDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        BaseAIOUtils.o(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ph(boolean show) {
        int i3;
        QUIEmptyState Hh = Hh();
        int i16 = 0;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        Hh.setVisibility(i3);
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

    @Override // r3.e
    public void E6(@NotNull f refreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) refreshLayout);
        } else {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LinkSearchDialog$onLoadMore$1(this, null), 3, null);
        }
    }

    @NotNull
    public final ChatHistoryLinkViewModel Ih() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ChatHistoryLinkViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.viewModel;
    }

    @Override // com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.c
    public void j0(@NotNull String link) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) link);
            return;
        }
        Intrinsics.checkNotNullParameter(link, "link");
        ChatHistoryLinkViewModel chatHistoryLinkViewModel = this.viewModel;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ChatHistoryLinkViewModel.a2(chatHistoryLinkViewModel, requireContext, link, 0, 4, null);
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseChatDialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onActivityCreated(savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(-1));
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.height = -1;
            }
            WindowManager.LayoutParams attributes3 = window.getAttributes();
            if (attributes3 != null) {
                attributes3.gravity = 51;
            }
            window.getAttributes().windowAnimations = android.R.style.Animation;
        }
        ThreadManager.getUIHandler().postDelayed(this.mShowKeyBoardTask, 500L);
        Kh();
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseChatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        com.tencent.qqnt.chathistory.util.d.f354054a.a("LinkSearchDialog", "onCreate");
        LiveData obtainUiState = this.viewModel.obtainUiState();
        final Function1<com.tencent.qqnt.chathistory.ui.link.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.link.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.dialog.LinkSearchDialog$onCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LinkSearchDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.link.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.link.data.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                } else if (aVar instanceof a.d) {
                    LinkSearchDialog.this.Jh(((a.d) aVar).a());
                }
            }
        };
        obtainUiState.observe(this, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.link.dialog.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LinkSearchDialog.Oh(Function1.this, obj);
            }
        });
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
            View it = inflater.inflate(R.layout.e2p, container, false);
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
            recyclerView.addOnScrollListener(new c(recyclerView, this));
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
            smartRefreshLayout3.W(this);
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
            HistoryDtReportHelper.SearchEntry searchEntry = HistoryDtReportHelper.SearchEntry.LINK;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.qqnt.chathistory.util.d.f354054a.a("LinkSearchDialog", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LinkSearchDialog$onDestroy$1(this, null), 3, null);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dialog);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @CallSuper
    public void showNow(@NotNull FragmentManager manager, @Nullable String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) manager, (Object) tag);
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
