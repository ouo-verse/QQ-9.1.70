package com.tencent.robot.slash.manager;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import b54.FunctionReportArgs;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarMsgIntent;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectMsgIntent;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.slash.manager.d;
import com.tencent.robot.slash.temp.UpdateRecentUsedRecordTempMsgIntent;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import j64.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\b\b*\u0001]\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u00013B\u0017\u0012\u0006\u0010B\u001a\u00020@\u0012\u0006\u0010E\u001a\u00020C\u00a2\u0006\u0004\ba\u0010bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020$H\u0002J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+H\u0002J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010/\u001a\u00020\u0003H\u0002J\b\u00100\u001a\u00020\u0003H\u0002J\u0010\u00101\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u00102\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0010H\u0016J\b\u00106\u001a\u00020\u0003H\u0016J\u001a\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u0002072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010=\u001a\u00020\u00032\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020\u0003H\u0016J\b\u0010?\u001a\u00020\u0003H\u0016R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010IR\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010KR\u0016\u0010M\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u0017R\u0016\u0010O\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010YR\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_\u00a8\u0006d"}, d2 = {"Lcom/tencent/robot/slash/manager/DefaultSlashDialogManager;", "Lcom/tencent/robot/slash/manager/d;", "Lj64/h;", "", "E", "", "searchResult", "", "keyword", "Lcom/tencent/robot/slash/businessapi/a;", "t", "u", "Lw64/o;", "v", "convertResult", "O", "", "isDelay", "L", "J", "K", "Lcom/tencent/input/base/launch/b;", "dialogExternalProvider", "I", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "w", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "msgIntent", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/slash/temp/UpdateRecentUsedRecordTempMsgIntent;", "H", "Lcom/tencent/robot/slash/manager/SlashDialogMsgIntent$UpdateRecentUsedFunctionMsgIntent;", "G", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", "B", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lb74/a;", "itemData", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lb54/a;", "impArgs", "y", HippyTKDListViewAdapter.X, "D", "N", "g", "r", "a", "needAnim", "b", "e", "Lj64/g;", "searchContext", "f", "errorMsg", "", "errorCode", "d", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mMviContext", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/robot/slash/businessapi/c;", "mBusinessDelegate", "Lw64/o;", "mSlashDialogProvider", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "mLoadingTipsJob", "Ljava/lang/String;", "mKeyword", "mSlashState", "Z", "mProcessEndFlag", h.F, "Ljava/lang/Object;", "mCacheSearchResult", "Lj64/e;", "i", "Lj64/e;", "mSearchSession", "", "j", "Ljava/util/List;", "mSlashDialogMessageList", "k", "mMviMessageList", "com/tencent/robot/slash/manager/DefaultSlashDialogManager$b", "l", "Lcom/tencent/robot/slash/manager/DefaultSlashDialogManager$b;", "mDialogAction", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/c;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class DefaultSlashDialogManager implements d, j64.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.runtime.b mMviContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.robot.slash.businessapi.c mBusinessDelegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private o mSlashDialogProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b mLoadingTipsJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mKeyword;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mSlashState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mProcessEndFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object mCacheSearchResult;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j64.e mSearchSession;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mSlashDialogMessageList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mMviMessageList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mDialogAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/slash/manager/DefaultSlashDialogManager$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            DefaultSlashDialogManager.this.w(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public DefaultSlashDialogManager(@NotNull com.tencent.mvi.api.runtime.b mMviContext, @NotNull com.tencent.robot.slash.businessapi.c mBusinessDelegate) {
        List<String> listOf;
        List<String> listOf2;
        Intrinsics.checkNotNullParameter(mMviContext, "mMviContext");
        Intrinsics.checkNotNullParameter(mBusinessDelegate, "mBusinessDelegate");
        this.mMviContext = mMviContext;
        this.mBusinessDelegate = mBusinessDelegate;
        this.mKeyword = "";
        this.mSearchSession = new j64.e(this);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToTop.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(CommonListMsgIntent.OnItemClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogShowed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.RetryRequestMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.DismissSlashDialogMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionImpMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnDismissAnimStart.class).getQualifiedName()});
        this.mSlashDialogMessageList = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.UpdateRecentUsedFunctionMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(UpdateRecentUsedRecordTempMsgIntent.class).getQualifiedName()});
        this.mMviMessageList = listOf2;
        this.mDialogAction = new b();
        for (String str : listOf2) {
            if (str != null) {
                this.mMviContext.e().d(str, this.mDialogAction);
            }
        }
    }

    private final void A(BottomSheetDialogMsgIntent.OnDialogDismissed msgIntent) {
        com.tencent.input.base.launch.b c16;
        o oVar = this.mSlashDialogProvider;
        if (oVar != null && (c16 = oVar.c()) != null) {
            c16.a(new CommonListMsgIntent.SubmitListMsgIntent(new ArrayList(), 0, null, null, 14, null));
        }
        this.mBusinessDelegate.f(msgIntent.getRootView());
    }

    private final void B(BottomSheetDialogMsgIntent.OnDialogShowed msgIntent) {
        this.mBusinessDelegate.d(msgIntent.getRootView());
    }

    private final void C() {
        if (this.mSlashState != 4 || this.mBusinessDelegate.hideKeyboard()) {
            return;
        }
        this.mMviContext.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("SlashDialogManager", false));
    }

    private final void D() {
        QLog.i("SlashDialogManager", 1, "handleRetryClickMsgIntent");
        M(this, false, 1, null);
        N();
    }

    private final void E() {
        QLog.i("SlashDialogManager", 1, "handleSlashStateSuccess");
        Object obj = this.mCacheSearchResult;
        if (obj == null) {
            N();
            return;
        }
        String str = this.mKeyword;
        LifecycleOwner d16 = this.mMviContext.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "SlashDialogManagershowSlashDialog", Boolean.FALSE, null, null, new DefaultSlashDialogManager$handleSlashStateSuccess$1(this, obj, str, null), 12, null);
    }

    private final void F(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent msgIntent) {
        this.mBusinessDelegate.b(msgIntent.getRobotUin(), msgIntent.getRobotTinyId());
        d.a.a(this, false, 1, null);
    }

    private final void G(SlashDialogMsgIntent.UpdateRecentUsedFunctionMsgIntent msgIntent) {
        this.mBusinessDelegate.i(msgIntent.getRobotInfo(), msgIntent.getFunctionInfo(), msgIntent.getFunctionType());
    }

    private final void H(UpdateRecentUsedRecordTempMsgIntent event) {
        CommonBotInfo commonBotInfo;
        Object botInfo = event.getBotInfo();
        CommonBotFeatureInfo commonBotFeatureInfo = null;
        if (botInfo instanceof CommonBotInfo) {
            commonBotInfo = (CommonBotInfo) botInfo;
        } else {
            commonBotInfo = null;
        }
        if (commonBotInfo == null) {
            return;
        }
        Object functionInfo = event.getFunctionInfo();
        if (functionInfo instanceof CommonBotFeatureInfo) {
            commonBotFeatureInfo = (CommonBotFeatureInfo) functionInfo;
        }
        if (commonBotFeatureInfo == null) {
            return;
        }
        this.mBusinessDelegate.i(commonBotInfo, commonBotFeatureInfo, event.getFunctionType());
    }

    private final void I(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mSlashDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.b(str, this.mDialogAction);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        Job f16;
        QLog.i("SlashDialogManager", 1, "showAddTipDialog");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o v3 = v();
        if (!v3.r()) {
            v3.showDialog();
        }
        v3.c().a(SlashDialogMsgIntent.ShowEmptyState.f368547e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        Job f16;
        QLog.i("SlashDialogManager", 1, "showReloadTipDialog");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o v3 = v();
        if (!v3.r()) {
            v3.showDialog();
        }
        v3.c().a(SlashDialogMsgIntent.ShowFailedState.f368548e);
    }

    private final void L(boolean isDelay) {
        Job f16;
        QLog.i("SlashDialogManager", 1, "showLoadingTipDialog");
        if (isDelay) {
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
            if (bVar != null && (f16 = bVar.f()) != null) {
                Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            }
            LifecycleOwner d16 = this.mMviContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(d16);
            Boolean bool = Boolean.TRUE;
            this.mLoadingTipsJob = CorountineFunKt.e(lifecycleScope, "SlashDialogManagershowLoadingTipDialog", bool, null, bool, new DefaultSlashDialogManager$showLoadingTipDialog$1(this, null), 4, null);
            return;
        }
        o v3 = v();
        if (!v3.r()) {
            v3.showDialog();
        }
        v3.c().a(SlashDialogMsgIntent.ShowLoadingState.f368549e);
    }

    static /* synthetic */ void M(DefaultSlashDialogManager defaultSlashDialogManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        defaultSlashDialogManager.L(z16);
    }

    private final void N() {
        QLog.i("SlashDialogManager", 1, "startFunctionsSearch");
        this.mSlashState = 1;
        SearchSessionParams a16 = c.a.a(this.mBusinessDelegate, null, 1, null);
        if (a16 != null) {
            this.mSearchSession.h(a16);
        } else {
            QLog.e("SlashDialogManager", 1, "searchParams is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(com.tencent.robot.slash.businessapi.a convertResult) {
        Integer num;
        List listOf;
        Job f16;
        int size = convertResult.b().size();
        List<b.UIModelData> a16 = convertResult.a();
        if (a16 != null) {
            num = Integer.valueOf(a16.size());
        } else {
            num = null;
        }
        QLog.i("SlashDialogManager", 1, "submitList itemList size = " + size + " avatarItemList size = " + num);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        final o v3 = v();
        v3.c().a(SlashDialogMsgIntent.ShowNormalState.f368550e);
        v3.c().a(new CommonListMsgIntent.SubmitListMsgIntent(convertResult.b(), convertResult.getCom.tencent.mobileqq.webview.constants.QQBrowserActivityConstants.KEY_TITLE_STYLE java.lang.String(), new Runnable() { // from class: com.tencent.robot.slash.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSlashDialogManager.P(o.this);
            }
        }, null, 8, null));
        List<b.UIModelData> a17 = convertResult.a();
        if (a17 != null) {
            v3.c().a(new AvatarBarMsgIntent.SubmitList(a17));
        }
        if (v3.r()) {
            com.tencent.input.base.launch.b c16 = v3.c();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.a.f368653a);
            c16.a(new BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent(listOf));
            return;
        }
        v3.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(o this_with) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.c().a(new SlashListCouplingEffectMsgIntent.ScrollToPosition(0));
    }

    private final void Q(com.tencent.input.base.launch.b dialogExternalProvider) {
        for (String str : this.mSlashDialogMessageList) {
            if (str != null) {
                dialogExternalProvider.c(str, this.mDialogAction);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.robot.slash.businessapi.a t(Object searchResult, String keyword) {
        return this.mBusinessDelegate.j(searchResult, keyword);
    }

    private final void u() {
        o a16 = new w64.c().a(this.mBusinessDelegate.m(this.mMviContext));
        I(a16.c());
        this.mSlashDialogProvider = a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o v() {
        if (this.mSlashDialogProvider == null) {
            u();
        }
        o oVar = this.mSlashDialogProvider;
        Intrinsics.checkNotNull(oVar);
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(MsgIntent event) {
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToBottom) {
            o oVar = this.mSlashDialogProvider;
            if (oVar != null) {
                o.a.a(oVar, false, 1, null);
                return;
            }
            return;
        }
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToTop) {
            C();
            return;
        }
        if (event instanceof CommonListMsgIntent.OnItemClickMsgIntent) {
            z(((CommonListMsgIntent.OnItemClickMsgIntent) event).getItemData());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.RetryRequestMsgIntent) {
            D();
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogShowed) {
            B((BottomSheetDialogMsgIntent.OnDialogShowed) event);
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogDismissed) {
            A((BottomSheetDialogMsgIntent.OnDialogDismissed) event);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.DismissSlashDialogMsgIntent) {
            d.a.a(this, false, 1, null);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) {
            y(((SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) {
            x(((SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) event).getItemArgs());
            return;
        }
        if (event instanceof SlashDialogMsgIntent.UpdateRecentUsedFunctionMsgIntent) {
            G((SlashDialogMsgIntent.UpdateRecentUsedFunctionMsgIntent) event);
            return;
        }
        if (event instanceof UpdateRecentUsedRecordTempMsgIntent) {
            H((UpdateRecentUsedRecordTempMsgIntent) event);
        } else if (event instanceof SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) {
            F((SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) event);
        } else if (event instanceof BottomSheetDialogAdornMsgIntent.OnDismissAnimStart) {
            this.mBusinessDelegate.c();
        }
    }

    private final void x(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.e(impArgs);
    }

    private final void y(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.g(impArgs);
    }

    private final void z(b74.a itemData) {
        QLog.i("SlashDialogManager", 1, "handleItemClickMsgIntent");
        this.mBusinessDelegate.a(itemData, this.mKeyword);
        d.a.a(this, false, 1, null);
    }

    @Override // com.tencent.robot.slash.manager.d
    public boolean a() {
        o oVar = this.mSlashDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }

    @Override // com.tencent.robot.slash.manager.d
    public void b(boolean needAnim) {
        o oVar;
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.mLoadingTipsJob;
        boolean z16 = true;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        o oVar2 = this.mSlashDialogProvider;
        if (oVar2 == null || !oVar2.r()) {
            z16 = false;
        }
        if (z16 && (oVar = this.mSlashDialogProvider) != null) {
            oVar.b(needAnim);
        }
    }

    @Override // com.tencent.robot.slash.manager.d
    public void c() {
        this.mSearchSession.a();
        this.mCacheSearchResult = null;
    }

    @Override // j64.h
    public void d(@NotNull g searchContext, @NotNull String errorMsg, int errorCode) {
        Intrinsics.checkNotNullParameter(searchContext, "searchContext");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        QLog.i("SlashDialogManager", 1, "onSearchError");
        LifecycleOwner d16 = this.mMviContext.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "SlashDialogManageronSearchError", Boolean.TRUE, null, null, new DefaultSlashDialogManager$onSearchError$1(this, null), 12, null);
    }

    @Override // com.tencent.robot.slash.manager.d
    public void e() {
        this.mProcessEndFlag = true;
        this.mSlashState = 0;
    }

    @Override // j64.h
    public void f(@NotNull g searchContext, @Nullable Object searchResult) {
        Intrinsics.checkNotNullParameter(searchContext, "searchContext");
        QLog.i("SlashDialogManager", 1, "onSearchResult");
        LifecycleOwner d16 = this.mMviContext.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "SlashDialogManageronSearchResult", Boolean.TRUE, null, null, new DefaultSlashDialogManager$onSearchResult$1(this, searchResult, null), 12, null);
    }

    @Override // com.tencent.robot.slash.manager.d
    public void g(@NotNull String keyword) {
        boolean z16;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.mKeyword = keyword;
        this.mProcessEndFlag = false;
        int i3 = this.mSlashState;
        if (i3 != 0) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    QLog.e("SlashDialogManager", 1, "mActionState Error");
                    return;
                } else {
                    E();
                    return;
                }
            }
            if (keyword.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                M(this, false, 1, null);
                N();
                return;
            } else {
                d.a.a(this, false, 1, null);
                return;
            }
        }
        M(this, false, 1, null);
        N();
    }

    @Override // com.tencent.robot.slash.manager.d
    public void onDestroy() {
        QLog.i("SlashDialogManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        d.a.a(this, false, 1, null);
        c();
        o oVar = this.mSlashDialogProvider;
        if (oVar != null) {
            Q(oVar.c());
            oVar.onDestroy();
        }
        for (String str : this.mMviMessageList) {
            if (str != null) {
                this.mMviContext.e().b(str, this.mDialogAction);
            }
        }
    }

    @Override // com.tencent.robot.slash.manager.d
    public boolean r() {
        boolean z16;
        if (this.mSlashState == 1) {
            return true;
        }
        o oVar = this.mSlashDialogProvider;
        if (oVar != null) {
            z16 = oVar.r();
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }
}
