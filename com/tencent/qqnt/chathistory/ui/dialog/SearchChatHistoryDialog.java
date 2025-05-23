package com.tencent.qqnt.chathistory.ui.dialog;

import android.app.Dialog;
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
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.aio.utils.o;
import com.tencent.qqnt.chathistory.api.IMsgMigrationApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseChatDialogFragment;
import com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog;
import com.tencent.qqnt.chathistory.ui.dialog.retrieval.RetrievalHelper;
import com.tencent.qqnt.chathistory.ui.menu.data.a;
import com.tencent.qqnt.chathistory.ui.menu.data.b;
import com.tencent.qqnt.chathistory.ui.menu.viewmodel.ChatHistorySearchViewModel;
import com.tencent.qqnt.chathistory.util.l;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0002wxB\u000f\u0012\u0006\u00104\u001a\u000201\u00a2\u0006\u0004\bt\u0010uJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u001a\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0017J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.H\u0016R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010:R\u0018\u0010N\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010GR\u0016\u0010S\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010GR\u0016\u0010V\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010GR\u001b\u0010^\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001b\u0010a\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010[\u001a\u0004\b`\u0010]R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010URD\u0010o\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0013\u0012\u00110(\u00a2\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(l\u0012\u0004\u0012\u00020\u00050h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010r\u00a8\u0006y"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseChatDialogFragment;", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/d;", "", "Ih", "", "Nh", "Lcom/tencent/qqnt/chathistory/ui/menu/data/a$b;", "state", "Mh", "show", "Wh", "isSearch", "Jh", "isPageIn", "Uh", "clickSearch", "Sh", "Lcom/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog$b;", "listener", "Vh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onActivityCreated", "Landroid/app/Dialog;", "onCreateDialog", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "dismissAllowingStateLoss", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "showNow", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/chathistory/ui/menu/data/model/b;", "data", "i4", "Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;", "chatHistoryViewModel", "Landroid/widget/EditText;", "D", "Landroid/widget/EditText;", "editText", "E", "Landroid/view/View;", "clearTextView", UserInfo.SEX_FEMALE, "btnSearchCancel", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;", "G", "Lcom/tencent/qqnt/chathistory/ui/dialog/adapter/a;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "I", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "smartRefreshLayout", "J", "searchDialog", "K", "Lcom/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog$b;", "dismissListener", "", "L", "mFirstPosition", "M", "mLastPosition", "N", "Z", "needShowMsgMigrationTip", "P", MessageRoamJsPlugin.USERTYPE, "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Kh", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", BdhLogUtil.LogTag.Tag_Req, "Lh", "msgMigrationTipEmptyView", "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/RetrievalHelper;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/RetrievalHelper;", "retrievalHelper", "T", "isNowPageIn", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "save", "keyWord", "U", "Lkotlin/jvm/functions/Function2;", "searchAction", "Ljava/lang/Runnable;", "V", "Ljava/lang/Runnable;", "mShowKeyBoardTask", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;)V", "W", "a", "b", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class SearchChatHistoryDialog extends BaseChatDialogFragment implements com.tencent.qqnt.chathistory.ui.dialog.adapter.d {
    static IPatchRedirector $redirector_;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ChatHistorySearchViewModel chatHistoryViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private EditText editText;

    /* renamed from: E, reason: from kotlin metadata */
    private View clearTextView;

    /* renamed from: F, reason: from kotlin metadata */
    private View btnSearchCancel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chathistory.ui.dialog.adapter.a adapter;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: I, reason: from kotlin metadata */
    private SmartRefreshLayout smartRefreshLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private View searchDialog;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private b dismissListener;

    /* renamed from: L, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: M, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean needShowMsgMigrationTip;

    /* renamed from: P, reason: from kotlin metadata */
    private int userType;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgMigrationTipEmptyView;

    /* renamed from: S, reason: from kotlin metadata */
    private RetrievalHelper retrievalHelper;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isNowPageIn;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Function2<Boolean, String, Unit> searchAction;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Runnable mShowKeyBoardTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog$b;", "", "", "onDismiss", "", "chatType", "", "peerId", "", "msgId", "msgSeq", ICustomDataEditor.NUMBER_PARAM_9, "onBackPressed", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface b {
        void n9(int chatType, @NotNull String peerId, long msgId, long msgSeq);

        void onBackPressed();

        void onDismiss();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements TextWatcher {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchChatHistoryDialog.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) s16);
                return;
            }
            SearchChatHistoryDialog.Th(SearchChatHistoryDialog.this, false, 1, null);
            SearchChatHistoryDialog.this.mFirstPosition = -1;
            SearchChatHistoryDialog.this.mLastPosition = -1;
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog$d", "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/b;", "", "searchWord", "", "a", "b", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements com.tencent.qqnt.chathistory.ui.dialog.retrieval.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchChatHistoryDialog.this);
            }
        }

        @Override // com.tencent.qqnt.chathistory.ui.dialog.retrieval.b
        public void a(@NotNull String searchWord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) searchWord);
                return;
            }
            Intrinsics.checkNotNullParameter(searchWord, "searchWord");
            EditText editText = SearchChatHistoryDialog.this.editText;
            EditText editText2 = null;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                editText = null;
            }
            editText.setText(searchWord);
            EditText editText3 = SearchChatHistoryDialog.this.editText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
            } else {
                editText2 = editText3;
            }
            editText2.setSelection(searchWord.length());
        }

        @Override // com.tencent.qqnt.chathistory.ui.dialog.retrieval.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            o oVar = o.f352309a;
            Context requireContext = SearchChatHistoryDialog.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            EditText editText = SearchChatHistoryDialog.this.editText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                editText = null;
            }
            oVar.c(requireContext, editText);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f353411d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SearchChatHistoryDialog f353412e;

        e(RecyclerView recyclerView, SearchChatHistoryDialog searchChatHistoryDialog) {
            this.f353411d = recyclerView;
            this.f353412e = searchChatHistoryDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) searchChatHistoryDialog);
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
            RecyclerView.LayoutManager layoutManager = this.f353411d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = this.f353411d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition2 = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() + this.f353411d.getChildCount();
            if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                if (this.f353412e.mFirstPosition == -1 || this.f353412e.mLastPosition == -1) {
                    this.f353412e.mFirstPosition = findFirstVisibleItemPosition;
                    this.f353412e.mLastPosition = findFirstVisibleItemPosition2;
                    int i3 = findFirstVisibleItemPosition2 - findFirstVisibleItemPosition;
                    for (int i16 = 0; i16 < i3 && i16 < this.f353411d.getChildCount(); i16++) {
                        if (this.f353412e.adapter.getItemViewType(i16) == 0) {
                            HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                            RecyclerView.LayoutManager layoutManager3 = this.f353411d.getLayoutManager();
                            if (layoutManager3 != null) {
                                view = layoutManager3.findViewByPosition(i16);
                            } else {
                                view = null;
                            }
                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353412e.adapter.n0(i16))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353412e.adapter.o0().size())));
                            a16.o(view, "em_bas_search_result_entry", mutableMapOf, String.valueOf(i16));
                        }
                    }
                    return;
                }
                if (z16) {
                    int i17 = findFirstVisibleItemPosition - this.f353412e.mFirstPosition;
                    for (int i18 = 0; i18 < i17 && i18 < this.f353411d.getChildCount(); i18++) {
                        HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager4 = this.f353411d.getLayoutManager();
                        if (layoutManager4 != null) {
                            view5 = layoutManager4.findViewByPosition(i18);
                        } else {
                            view5 = null;
                        }
                        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353412e.adapter.n0(i18))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353412e.adapter.o0().size())));
                        a17.q(view5, "em_bas_search_result_entry", mutableMapOf5, String.valueOf(i18));
                    }
                    int i19 = findFirstVisibleItemPosition2 - this.f353412e.mLastPosition;
                    for (int i26 = 0; i26 < i19 && i26 < this.f353411d.getChildCount(); i26++) {
                        HistoryDtReportHelper a18 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager5 = this.f353411d.getLayoutManager();
                        if (layoutManager5 != null) {
                            view4 = layoutManager5.findViewByPosition(i26);
                        } else {
                            view4 = null;
                        }
                        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353412e.adapter.n0(i26))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353412e.adapter.o0().size())));
                        a18.o(view4, "em_bas_search_result_entry", mutableMapOf4, String.valueOf(i26));
                    }
                } else {
                    int i27 = this.f353412e.mFirstPosition - findFirstVisibleItemPosition;
                    for (int i28 = 0; i28 < i27 && i28 < this.f353411d.getChildCount(); i28++) {
                        HistoryDtReportHelper a19 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager6 = this.f353411d.getLayoutManager();
                        if (layoutManager6 != null) {
                            view3 = layoutManager6.findViewByPosition(i28);
                        } else {
                            view3 = null;
                        }
                        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353412e.adapter.n0(i28))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353412e.adapter.o0().size())));
                        a19.o(view3, "em_bas_search_result_entry", mutableMapOf3, String.valueOf(i28));
                    }
                    int i29 = this.f353412e.mLastPosition - findFirstVisibleItemPosition2;
                    for (int i36 = 0; i36 < i29 && i36 < this.f353411d.getChildCount(); i36++) {
                        HistoryDtReportHelper a26 = HistoryDtReportHelper.INSTANCE.a();
                        RecyclerView.LayoutManager layoutManager7 = this.f353411d.getLayoutManager();
                        if (layoutManager7 != null) {
                            view2 = layoutManager7.findViewByPosition(i36);
                        } else {
                            view2 = null;
                        }
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.f353412e.adapter.n0(i36))), TuplesKt.to("number_search_results", Integer.valueOf(this.f353412e.adapter.o0().size())));
                        a26.q(view2, "em_bas_search_result_entry", mutableMapOf2, String.valueOf(i36));
                    }
                }
                this.f353412e.mFirstPosition = findFirstVisibleItemPosition;
                this.f353412e.mLastPosition = findFirstVisibleItemPosition2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38922);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchChatHistoryDialog(@NotNull ChatHistorySearchViewModel chatHistoryViewModel) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(chatHistoryViewModel, "chatHistoryViewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryViewModel);
            return;
        }
        this.chatHistoryViewModel = chatHistoryViewModel;
        this.adapter = new com.tencent.qqnt.chathistory.ui.dialog.adapter.a(this, chatHistoryViewModel, LifecycleOwnerKt.getLifecycleScope(this));
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog$emptyView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchChatHistoryDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIEmptyState invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(SearchChatHistoryDialog.this.getContext()).setImageType(9).setBackgroundColorType(0);
                String qqStr = HardCodeUtil.qqStr(R.string.zko);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.chat_history_search_empty)");
                QUIEmptyState build = backgroundColorType.setTitle(qqStr).build();
                build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                build.setVisibility(0);
                return build;
            }
        });
        this.emptyView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new SearchChatHistoryDialog$msgMigrationTipEmptyView$2(this));
        this.msgMigrationTipEmptyView = lazy2;
        this.searchAction = new Function2<Boolean, String, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog$searchAction$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog$searchAction$1$1", f = "SearchChatHistoryDialog.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog$searchAction$1$1, reason: invalid class name */
            /* loaded from: classes23.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $keyword;
                final /* synthetic */ boolean $save;
                int label;
                final /* synthetic */ SearchChatHistoryDialog this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SearchChatHistoryDialog searchChatHistoryDialog, String str, boolean z16, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = searchChatHistoryDialog;
                    this.$keyword = str;
                    this.$save = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, searchChatHistoryDialog, str, Boolean.valueOf(z16), continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass1(this.this$0, this.$keyword, this.$save, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    ChatHistorySearchViewModel chatHistorySearchViewModel;
                    RetrievalHelper retrievalHelper;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.Jh(true);
                            chatHistorySearchViewModel = this.this$0.chatHistoryViewModel;
                            b.c cVar = new b.c(this.$keyword);
                            this.label = 1;
                            if (chatHistorySearchViewModel.sendUserIntent(cVar, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (this.$save) {
                            retrievalHelper = this.this$0.retrievalHelper;
                            if (retrievalHelper == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
                                retrievalHelper = null;
                            }
                            retrievalHelper.h(this.$keyword);
                        }
                        return Unit.INSTANCE;
                    }
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchChatHistoryDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull String keyword) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), keyword);
                } else {
                    Intrinsics.checkNotNullParameter(keyword, "keyword");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(SearchChatHistoryDialog.this), null, null, new AnonymousClass1(SearchChatHistoryDialog.this, keyword, z16, null), 3, null);
                }
            }
        };
        this.mShowKeyBoardTask = new Runnable() { // from class: com.tencent.qqnt.chathistory.ui.dialog.b
            @Override // java.lang.Runnable
            public final void run() {
                SearchChatHistoryDialog.Qh(SearchChatHistoryDialog.this);
            }
        };
    }

    private final boolean Ih() {
        Long longOrNull;
        w msgService;
        Integer curChatImportStatusByUin;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(HistoryDtReportHelper.INSTANCE.a().d(this.chatHistoryViewModel));
        boolean z16 = false;
        if (longOrNull == null) {
            QLog.d("BaseChatHistoryDialog", 1, "checkMsgImportNotFinish:: uin is null");
            return false;
        }
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null && (msgService = i3.getMsgService()) != null && (curChatImportStatusByUin = msgService.getCurChatImportStatusByUin(longOrNull.longValue(), this.chatHistoryViewModel.M1())) != null && curChatImportStatusByUin.intValue() == 1) {
            z16 = true;
        }
        QLog.d("BaseChatHistoryDialog", 1, "checkMsgImportNotFinish:: result = " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(boolean isSearch) {
        List<com.tencent.qqnt.chathistory.ui.menu.data.model.b> emptyList;
        com.tencent.qqnt.chathistory.ui.dialog.adapter.a aVar = this.adapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        aVar.q0(emptyList, false);
        this.chatHistoryViewModel.S1(isSearch);
    }

    private final QUIEmptyState Kh() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    private final QUIEmptyState Lh() {
        return (QUIEmptyState) this.msgMigrationTipEmptyView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(a.b state) {
        com.tencent.qqnt.chathistory.util.d.f354054a.a("BaseChatHistoryDialog", "handleUI " + state.a().g().size());
        com.tencent.qqnt.chathistory.ui.menu.data.model.a a16 = state.a();
        if (!a16.h()) {
            if (a16.g().isEmpty()) {
                Wh(true);
            } else {
                Wh(false);
            }
            this.adapter.q0(a16.g(), a16.f());
            if (!this.isNowPageIn) {
                Uh(true);
                return;
            }
            return;
        }
        this.adapter.m0(a16.g(), a16.f());
    }

    private final void Nh() {
        View view = this.clearTextView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SearchChatHistoryDialog.Oh(SearchChatHistoryDialog.this, view3);
            }
        });
        EditText editText = this.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        editText.addTextChangedListener(new c());
        editText.setImeOptions(3);
        a aVar = new a(new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog$initEditTextLayout$2$search$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchChatHistoryDialog.this);
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
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SearchChatHistoryDialog.this.Sh(true);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        editText.setOnEditorActionListener(aVar);
        editText.setOnKeyListener(aVar);
        editText.requestFocus();
        editText.setSaveEnabled(false);
        View view3 = this.btnSearchCancel;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSearchCancel");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                SearchChatHistoryDialog.Ph(SearchChatHistoryDialog.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(SearchChatHistoryDialog this$0, View view) {
        List<com.tencent.qqnt.chathistory.ui.menu.data.model.b> emptyList;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.setText("");
        com.tencent.qqnt.chathistory.ui.dialog.adapter.a aVar = this$0.adapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        aVar.q0(emptyList, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(SearchChatHistoryDialog this$0, View it) {
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
        HistoryDtReportHelper.SearchEntry searchEntry = HistoryDtReportHelper.SearchEntry.MENU;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_search_activation"), TuplesKt.to("touin", companion.a().d(this$0.chatHistoryViewModel)), TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("aio_type", Integer.valueOf(this$0.chatHistoryViewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this$0.chatHistoryViewModel.N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_cancel_search_button", mutableMapOf2);
        HistoryDtReportHelper a17 = companion.a();
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_search_results"), TuplesKt.to("touin", companion.a().d(this$0.chatHistoryViewModel)), TuplesKt.to("search_entry_source", Integer.valueOf(searchEntry.ordinal())), TuplesKt.to("aio_type", Integer.valueOf(this$0.chatHistoryViewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this$0.chatHistoryViewModel.N1()));
        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf3));
        a17.m(it, "em_bas_cancel_search_button", mutableMapOf4);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(SearchChatHistoryDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        BaseAIOUtils.o(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh(boolean clickSearch) {
        String str;
        boolean z16;
        List<com.tencent.qqnt.chathistory.ui.menu.data.model.b> emptyList;
        EditText editText = this.editText;
        RetrievalHelper retrievalHelper = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text != null) {
            str = text.toString();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            View view = this.clearTextView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
                view = null;
            }
            view.setVisibility(8);
            com.tencent.qqnt.chathistory.ui.dialog.adapter.a aVar = this.adapter;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            aVar.q0(emptyList, false);
            com.tencent.qqnt.chathistory.util.d.f354054a.a("BaseChatHistoryDialog", "setEmptyUI");
            RetrievalHelper retrievalHelper2 = this.retrievalHelper;
            if (retrievalHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
            } else {
                retrievalHelper = retrievalHelper2;
            }
            retrievalHelper.g().setVisibility(0);
            Kh().setVisibility(8);
            Lh().setVisibility(8);
            Jh(true);
            Uh(false);
            return;
        }
        View view2 = this.clearTextView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearTextView");
            view2 = null;
        }
        view2.setVisibility(0);
        RetrievalHelper retrievalHelper3 = this.retrievalHelper;
        if (retrievalHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
        } else {
            retrievalHelper = retrievalHelper3;
        }
        retrievalHelper.g().setVisibility(8);
        this.searchAction.invoke(Boolean.valueOf(clickSearch), str);
    }

    static /* synthetic */ void Th(SearchChatHistoryDialog searchChatHistoryDialog, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        searchChatHistoryDialog.Sh(z16);
    }

    private final void Uh(boolean isPageIn) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        SmartRefreshLayout smartRefreshLayout = null;
        if (isPageIn != this.isNowPageIn) {
            this.isNowPageIn = true;
            HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
            HistoryDtReportHelper a16 = companion.a();
            SmartRefreshLayout smartRefreshLayout2 = this.smartRefreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smartRefreshLayout");
            } else {
                smartRefreshLayout = smartRefreshLayout2;
            }
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(this.chatHistoryViewModel)), TuplesKt.to("search_entry_source", Integer.valueOf(HistoryDtReportHelper.SearchEntry.MENU.ordinal())), TuplesKt.to("aio_type", Integer.valueOf(this.chatHistoryViewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this.chatHistoryViewModel.N1()));
            a16.u(smartRefreshLayout, "pg_bas_search_results", mutableMapOf2);
            return;
        }
        this.isNowPageIn = false;
        HistoryDtReportHelper.Companion companion2 = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a17 = companion2.a();
        SmartRefreshLayout smartRefreshLayout3 = this.smartRefreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartRefreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout3;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion2.a().d(this.chatHistoryViewModel)), TuplesKt.to("search_entry_source", Integer.valueOf(HistoryDtReportHelper.SearchEntry.MENU.ordinal())), TuplesKt.to("aio_type", Integer.valueOf(this.chatHistoryViewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this.chatHistoryViewModel.N1()));
        a17.x(smartRefreshLayout, "pg_bas_search_results", mutableMapOf);
    }

    private final void Wh(boolean show) {
        int i3;
        int i16;
        int i17 = 0;
        if (this.needShowMsgMigrationTip) {
            Kh().setVisibility(8);
            QUIEmptyState Lh = Lh();
            if (show) {
                QRouteApi api = QRoute.api(IMsgMigrationApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IMsgMigrationApi::class.java)");
                IMsgMigrationApi.a.a((IMsgMigrationApi) api, "0X800C4DE", this.userType, 0, null, null, null, null, 124, null);
                i16 = 0;
            } else {
                i16 = 8;
            }
            Lh.setVisibility(i16);
        } else {
            QUIEmptyState Kh = Kh();
            if (show) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            Kh.setVisibility(i3);
        }
        SmartRefreshLayout smartRefreshLayout = this.smartRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartRefreshLayout");
            smartRefreshLayout = null;
        }
        if (show) {
            i17 = 8;
        }
        smartRefreshLayout.setVisibility(i17);
    }

    public void Vh(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            this.dismissListener = listener;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        b bVar = this.dismissListener;
        if (bVar != null) {
            bVar.onDismiss();
        }
        if (this.dismissListener == null) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.dialog.adapter.d
    public void i4(@NotNull com.tencent.qqnt.chathistory.ui.menu.data.model.b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.dismissListener != null) {
            o oVar = o.f352309a;
            EditText editText = this.editText;
            EditText editText2 = null;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                editText = null;
            }
            Context context = editText.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "editText.context");
            EditText editText3 = this.editText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
            } else {
                editText2 = editText3;
            }
            oVar.c(context, editText2);
            b bVar = this.dismissListener;
            if (bVar != null) {
                bVar.n9(this.chatHistoryViewModel.M1(), this.chatHistoryViewModel.N1(), data.g().msgId, data.g().msgSeq);
                return;
            }
            return;
        }
        String O1 = this.chatHistoryViewModel.O1();
        if (TextUtils.isEmpty(O1)) {
            QLog.e("BaseChatHistoryDialog", 1, "modelName " + this.chatHistoryViewModel.O1() + " is Error !!");
            O1 = data.g().senderNick;
        }
        com.tencent.qqnt.chathistory.service.a aVar = com.tencent.qqnt.chathistory.service.a.f353327a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        int M1 = this.chatHistoryViewModel.M1();
        String N1 = this.chatHistoryViewModel.N1();
        if (O1 == null) {
            O1 = "";
        }
        com.tencent.qqnt.chathistory.service.a.e(aVar, requireContext, M1, N1, O1, data.g().msgId, data.g().msgSeq, 0L, 64, null);
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseChatDialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onActivityCreated(savedInstanceState);
        Nh();
        ThreadManager.getUIHandler().postDelayed(this.mShowKeyBoardTask, 100L);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Dialog) iPatchRedirector.redirect((short) 5, (Object) this, (Object) savedInstanceState);
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new com.tencent.qqnt.chathistory.ui.base.a(requireContext, getTheme(), new Function0<Boolean>() { // from class: com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog$onCreateDialog$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchChatHistoryDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                SearchChatHistoryDialog.b bVar;
                SearchChatHistoryDialog.b bVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bVar = SearchChatHistoryDialog.this.dismissListener;
                if (bVar != null) {
                    bVar.onBackPressed();
                }
                bVar2 = SearchChatHistoryDialog.this.dismissListener;
                return Boolean.valueOf(bVar2 != null);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int i3;
        boolean z16;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Map<String, Object> mutableMapOf;
        View view;
        Integer dataImportUserLevel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null && (dataImportUserLevel = e16.getDataImportUserLevel()) != null) {
                i3 = dataImportUserLevel.intValue();
            } else {
                i3 = 0;
            }
            this.userType = i3;
            if ((i3 == 2 || i3 == 3) && Ih()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.needShowMsgMigrationTip = z16;
            this.adapter.p0(z16, this.userType);
            QLog.i("BaseChatHistoryDialog", 1, "import old DbMsg status, userType=" + this.userType + ", needShowMsgMigrationTip=" + this.needShowMsgMigrationTip);
            RelativeLayout relativeLayout = new RelativeLayout(inflater.getContext());
            relativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(relativeLayout.getContext());
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            QUISearchBar qUISearchBar = new QUISearchBar(linearLayout.getContext());
            qUISearchBar.updateStyle(2);
            QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
            Intrinsics.checkNotNullExpressionValue(inputWidget, "inputWidget");
            this.editText = inputWidget;
            ImageView clearView = qUISearchBar.getClearView();
            Intrinsics.checkNotNullExpressionValue(clearView, "clearView");
            this.clearTextView = clearView;
            TextView cancelView = qUISearchBar.getCancelView();
            Intrinsics.checkNotNullExpressionValue(cancelView, "cancelView");
            this.btnSearchCancel = cancelView;
            linearLayout.addView(qUISearchBar, new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(60.0f)));
            View view2 = new View(linearLayout.getContext());
            view2.setBackgroundResource(R.drawable.qui_common_border_light_bg);
            linearLayout.addView(view2, new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(0.5f)));
            Context context = linearLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.retrievalHelper = new RetrievalHelper(context, new d());
            FrameLayout frameLayout = new FrameLayout(linearLayout.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(frameLayout.getContext());
            RecyclerView recyclerView = new RecyclerView(smartRefreshLayout.getContext());
            recyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            recyclerView.setLayoutManager(new LinearLayoutManager(smartRefreshLayout.getContext()));
            recyclerView.setAdapter(this.adapter);
            this.recyclerView = recyclerView;
            recyclerView.addOnScrollListener(new e(recyclerView, this));
            smartRefreshLayout.addView(recyclerView);
            this.smartRefreshLayout = smartRefreshLayout;
            smartRefreshLayout.a(false);
            smartRefreshLayout.setEnableLoadMore(false);
            smartRefreshLayout.P(false);
            smartRefreshLayout.setEnableOverScrollDrag(true);
            frameLayout.addView(smartRefreshLayout);
            ViewParent parent = Kh().getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(Kh());
            }
            View Kh = Kh();
            Kh.setVisibility(8);
            frameLayout.addView(Kh);
            ViewParent parent2 = Lh().getParent();
            if (parent2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) parent2;
            } else {
                viewGroup2 = null;
            }
            if (viewGroup2 != null) {
                viewGroup2.removeView(Lh());
            }
            View Lh = Lh();
            Lh.setVisibility(8);
            frameLayout.addView(Lh);
            RetrievalHelper retrievalHelper = this.retrievalHelper;
            if (retrievalHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
                retrievalHelper = null;
            }
            frameLayout.addView(retrievalHelper.g(), -1, -1);
            linearLayout.addView(frameLayout);
            relativeLayout.addView(linearLayout);
            d.Companion companion = com.tencent.aio.base.tool.d.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), companion.a(requireContext), relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
            this.searchDialog = relativeLayout;
            HistoryDtReportHelper.Companion companion2 = HistoryDtReportHelper.INSTANCE;
            HistoryDtReportHelper a16 = companion2.a();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            View view3 = this.searchDialog;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchDialog");
                view3 = null;
            }
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion2.a().d(this.chatHistoryViewModel)), TuplesKt.to("search_entry_source", Integer.valueOf(HistoryDtReportHelper.SearchEntry.MENU.ordinal())), TuplesKt.to("aio_type", Integer.valueOf(this.chatHistoryViewModel.M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, this.chatHistoryViewModel.N1()));
            a16.v(requireActivity, view3, "pg_bas_search_activation", mutableMapOf);
            view = this.searchDialog;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchDialog");
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        EditText editText = this.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        editText.getText().clear();
        this.chatHistoryViewModel.T1();
        Jh(false);
        this.dismissListener = null;
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
        View view;
        Map<String, Object> mutableMapOf;
        View view2;
        Map<String, Object> mutableMapOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        RetrievalHelper retrievalHelper = this.retrievalHelper;
        if (retrievalHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
            retrievalHelper = null;
        }
        RecyclerView.LayoutManager layoutManager = retrievalHelper.g().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        RetrievalHelper retrievalHelper2 = this.retrievalHelper;
        if (retrievalHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
            retrievalHelper2 = null;
        }
        RecyclerView.LayoutManager layoutManager2 = retrievalHelper2.g().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstVisibleItemPosition2 = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition();
        RetrievalHelper retrievalHelper3 = this.retrievalHelper;
        if (retrievalHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
            retrievalHelper3 = null;
        }
        int childCount = (findFirstVisibleItemPosition2 + retrievalHelper3.g().getChildCount()) - findFirstVisibleItemPosition;
        for (int i3 = 0; i3 < childCount; i3++) {
            RetrievalHelper retrievalHelper4 = this.retrievalHelper;
            if (retrievalHelper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
                retrievalHelper4 = null;
            }
            if (i3 >= retrievalHelper4.g().getChildCount()) {
                break;
            }
            HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
            RetrievalHelper retrievalHelper5 = this.retrievalHelper;
            if (retrievalHelper5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
                retrievalHelper5 = null;
            }
            RecyclerView.LayoutManager layoutManager3 = retrievalHelper5.g().getLayoutManager();
            if (layoutManager3 != null) {
                view2 = layoutManager3.findViewByPosition(i3);
            } else {
                view2 = null;
            }
            Pair[] pairArr = new Pair[1];
            RetrievalHelper retrievalHelper6 = this.retrievalHelper;
            if (retrievalHelper6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retrievalHelper");
                retrievalHelper6 = null;
            }
            pairArr[0] = TuplesKt.to("number_search_history_displays", Integer.valueOf(retrievalHelper6.f().c()));
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr);
            a16.q(view2, "em_bas_search_history", mutableMapOf2, String.valueOf(i3));
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager4 = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager4, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstVisibleItemPosition3 = ((LinearLayoutManager) layoutManager4).findFirstVisibleItemPosition();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RecyclerView.LayoutManager layoutManager5 = recyclerView2.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager5, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstVisibleItemPosition4 = ((LinearLayoutManager) layoutManager5).findFirstVisibleItemPosition();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        int childCount2 = (findFirstVisibleItemPosition4 + recyclerView3.getChildCount()) - findFirstVisibleItemPosition3;
        for (int i16 = 0; i16 < childCount2; i16++) {
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            if (i16 >= recyclerView4.getChildCount()) {
                break;
            }
            if (this.adapter.getItemViewType(i16) == 0) {
                HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                RecyclerView recyclerView5 = this.recyclerView;
                if (recyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView5 = null;
                }
                RecyclerView.LayoutManager layoutManager6 = recyclerView5.getLayoutManager();
                if (layoutManager6 != null) {
                    view = layoutManager6.findViewByPosition(i16);
                } else {
                    view = null;
                }
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(this.adapter.n0(i16))), TuplesKt.to("number_search_results", Integer.valueOf(this.adapter.o0().size())));
                a17.q(view, "em_bas_search_result_entry", mutableMapOf, String.valueOf(i16));
            }
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LiveData obtainUiState = this.chatHistoryViewModel.obtainUiState();
        final Function1<com.tencent.qqnt.chathistory.ui.menu.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.menu.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchChatHistoryDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.menu.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.menu.data.a state) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) state);
                    return;
                }
                if (state instanceof a.b) {
                    SearchChatHistoryDialog searchChatHistoryDialog = SearchChatHistoryDialog.this;
                    Intrinsics.checkNotNullExpressionValue(state, "state");
                    searchChatHistoryDialog.Mh((a.b) state);
                } else if (state instanceof a.C9544a) {
                    com.tencent.qqnt.chathistory.util.d.f354054a.a("BaseChatHistoryDialog", "empty cache (first created)");
                }
            }
        };
        obtainUiState.observe(this, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.dialog.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchChatHistoryDialog.Rh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.dialog.adapter.d
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SearchChatHistoryDialog$onLoadMore$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @CallSuper
    public void showNow(@NotNull FragmentManager manager, @Nullable String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) manager, (Object) tag);
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
