package com.tencent.robot.at.manager;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import b54.FunctionReportArgs;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.at.manager.RobotAtDialogManager$mDialogAction$2;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.slash.manager.b;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import j64.e;
import j64.g;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\b*\u0001X\u0018\u0000 \u00112\u00020\u0001:\u0001.B\u0017\u0012\u0006\u00105\u001a\u000203\u0012\u0006\u00109\u001a\u000206\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010!\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010!\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020+H\u0002J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020\tH\u0016J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0004H\u0016R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010J\u001a\u00020\t8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\b?\u0010G\"\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010S\u001a\u00020N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR#\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010P\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010P\u001a\u0004\bZ\u0010[\u00a8\u0006_"}, d2 = {"Lcom/tencent/robot/at/manager/RobotAtDialogManager;", "Lcom/tencent/robot/slash/manager/b;", "", "robotUin", "", "E", "", "Lb74/a;", "itemData", "", "showDialogHint", UserInfo.SEX_FEMALE, "", "keyword", "showDialogIfNotShowed", BdhLogUtil.LogTag.Tag_Conn, "itemDataList", "l", "", "searchResult", HippyTKDListViewAdapter.X, "D", "Lcom/tencent/robot/slash/businessapi/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/input/base/launch/b;", "externalProvider", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "r", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$OnTitleRobotClickMsgIntent;", "msgIntent", "y", "Lb54/a;", "impArgs", "t", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogShowed;", "v", "Lcom/tencent/robot/widget/bottomdialog/BottomSheetDialogMsgIntent$OnDialogDismissed;", "u", "Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent$OnItemClickMsgIntent;", "w", "d", "a", DomainData.DOMAIN_NAME, "dismissDialog", "c", "destroy", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mMviContext", "Lcom/tencent/robot/slash/businessapi/c;", "b", "Lcom/tencent/robot/slash/businessapi/c;", "mBusinessDelegate", "Lw64/o;", "Lw64/o;", "mRobotAtDialogProvider", "Ljava/lang/String;", "mCurrentKeyword", "e", "mRobotUin", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "mFilterResultJob", "g", "Z", "()Z", "B", "(Z)V", "isWaitingSearchResult", h.F, "Ljava/lang/Object;", "mCachedResult", "Lj64/e;", "i", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lj64/e;", "mSearchSession", "j", "p", "()Ljava/util/List;", "mDialogMessageList", "com/tencent/robot/at/manager/RobotAtDialogManager$mDialogAction$2$a", "k", "o", "()Lcom/tencent/robot/at/manager/RobotAtDialogManager$mDialogAction$2$a;", "mDialogAction", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAtDialogManager implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.runtime.b mMviContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mBusinessDelegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private o mRobotAtDialogProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile String mCurrentKeyword;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mRobotUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job mFilterResultJob;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isWaitingSearchResult;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object mCachedResult;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mSearchSession;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mDialogMessageList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mDialogAction;

    public RobotAtDialogManager(@NotNull com.tencent.mvi.api.runtime.b mMviContext, @NotNull c mBusinessDelegate) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(mMviContext, "mMviContext");
        Intrinsics.checkNotNullParameter(mBusinessDelegate, "mBusinessDelegate");
        this.mMviContext = mMviContext;
        this.mBusinessDelegate = mBusinessDelegate;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<e>() { // from class: com.tencent.robot.at.manager.RobotAtDialogManager$mSearchSession$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/robot/at/manager/RobotAtDialogManager$mSearchSession$2$a", "Lj64/h;", "Lj64/g;", "searchContext", "", "searchResult", "", "f", "", "errorMsg", "", "errorCode", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements j64.h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ RobotAtDialogManager f367483a;

                a(RobotAtDialogManager robotAtDialogManager) {
                    this.f367483a = robotAtDialogManager;
                }

                @Override // j64.h
                public void d(@NotNull g searchContext, @NotNull String errorMsg, int errorCode) {
                    Intrinsics.checkNotNullParameter(searchContext, "searchContext");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    QLog.e("RobotAtDialogManager", 1, "[onSearchError]: " + errorMsg + ", code=" + errorCode);
                    this.f367483a.x(null);
                }

                @Override // j64.h
                public void f(@NotNull g searchContext, @Nullable Object searchResult) {
                    Intrinsics.checkNotNullParameter(searchContext, "searchContext");
                    QLog.i("RobotAtDialogManager", 1, "[onSearchResult]");
                    this.f367483a.x(searchResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                return new e(new a(RobotAtDialogManager.this));
            }
        });
        this.mSearchSession = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends String>>() { // from class: com.tencent.robot.at.manager.RobotAtDialogManager$mDialogMessageList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends String> invoke() {
                List<? extends String> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{u64.c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToTop.class)), u64.c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.OnScrollToBottom.class)), u64.c.c(Reflection.getOrCreateKotlinClass(CommonListMsgIntent.OnItemClickMsgIntent.class)), u64.c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogShowed.class)), u64.c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class)), u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionImpMsgIntent.class)), u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnReportFunctionClickMsgIntent.class)), u64.c.c(Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent.class))});
                return listOf;
            }
        });
        this.mDialogMessageList = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RobotAtDialogManager$mDialogAction$2.a>() { // from class: com.tencent.robot.at.manager.RobotAtDialogManager$mDialogAction$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/at/manager/RobotAtDialogManager$mDialogAction$2$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements com.tencent.mvi.base.route.a {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RobotAtDialogManager f367482d;

                a(RobotAtDialogManager robotAtDialogManager) {
                    this.f367482d = robotAtDialogManager;
                }

                @Override // com.tencent.mvi.base.route.a
                public void call(@NotNull MsgIntent i3) {
                    Intrinsics.checkNotNullParameter(i3, "i");
                    this.f367482d.r(i3);
                }

                @Override // com.tencent.mvi.base.route.a
                public boolean sticky() {
                    return a.C9235a.a(this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotAtDialogManager.this);
            }
        });
        this.mDialogAction = lazy3;
    }

    private final void A(com.tencent.input.base.launch.b externalProvider) {
        for (String str : p()) {
            if (str != null) {
                externalProvider.b(str, o());
            }
        }
    }

    private final void C(String keyword, boolean showDialogIfNotShowed) {
        B(true);
        Job job = this.mFilterResultJob;
        Job job2 = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner d16 = this.mMviContext.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e16 = CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "RobotAtDialogManagerfilterSearchResult", Boolean.FALSE, null, Boolean.TRUE, new RobotAtDialogManager$startFilterSearchResultJob$1(this, keyword, showDialogIfNotShowed, null), 4, null);
        if (e16 != null) {
            job2 = e16.a();
        }
        this.mFilterResultJob = job2;
    }

    private final void D(Object searchResult) {
        LifecycleOwner d16 = this.mMviContext.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mMviContext.lifecycleOwner");
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(d16);
        Boolean bool = Boolean.FALSE;
        CorountineFunKt.e(lifecycleScope, "RobotAtDialogManager.onSearchResult", bool, null, bool, new RobotAtDialogManager$startHandleSearchResultJob$1(this, searchResult, null), 4, null);
    }

    private final void E(long robotUin) {
        SearchSessionParams k3 = this.mBusinessDelegate.k(Long.valueOf(robotUin));
        if (k3 != null) {
            q().h(k3);
        } else {
            QLog.e("RobotAtDialogManager", 1, "startRobotFunctionSearch error");
        }
    }

    private final void F(List<? extends b74.a> itemData, boolean showDialogHint) {
        boolean z16;
        List listOf;
        List<? extends b74.a> list = itemData;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            dismissDialog();
            return;
        }
        z();
        o oVar = this.mRobotAtDialogProvider;
        if (oVar != null) {
            oVar.c().a(new CommonListMsgIntent.SubmitListMsgIntent(itemData, 0, null, null, 14, null));
            if (showDialogHint && !oVar.r()) {
                oVar.showDialog();
                return;
            }
            com.tencent.input.base.launch.b c16 = oVar.c();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent.a.f368653a);
            c16.a(new BottomSheetDialogAdornMsgIntent.UpdateLayoutMsgIntent(listOf));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void G(RobotAtDialogManager robotAtDialogManager, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        robotAtDialogManager.F(list, z16);
    }

    private final void H(com.tencent.input.base.launch.b externalProvider) {
        for (String str : p()) {
            if (str != null) {
                externalProvider.c(str, o());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String keyword, boolean showDialogIfNotShowed, List<? extends b74.a> itemDataList) {
        this.mCurrentKeyword = keyword;
        if (!showDialogIfNotShowed) {
            o oVar = this.mRobotAtDialogProvider;
            boolean z16 = false;
            if (oVar != null && oVar.r()) {
                z16 = true;
            }
            if (!z16) {
                return;
            }
        }
        F(itemDataList, showDialogIfNotShowed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.robot.slash.businessapi.a m(Object searchResult, String keyword) {
        if (!getIsWaitingSearchResult()) {
            return null;
        }
        return this.mBusinessDelegate.j(searchResult, keyword);
    }

    private final RobotAtDialogManager$mDialogAction$2.a o() {
        return (RobotAtDialogManager$mDialogAction$2.a) this.mDialogAction.getValue();
    }

    private final List<String> p() {
        return (List) this.mDialogMessageList.getValue();
    }

    private final e q() {
        return (e) this.mSearchSession.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(MsgIntent event) {
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToBottom) {
            o oVar = this.mRobotAtDialogProvider;
            if (oVar != null) {
                oVar.b(false);
                return;
            }
            return;
        }
        if (event instanceof BottomSheetDialogAdornMsgIntent.OnScrollToTop) {
            this.mMviContext.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotAtDialogManager", false));
            return;
        }
        if (event instanceof CommonListMsgIntent.OnItemClickMsgIntent) {
            w((CommonListMsgIntent.OnItemClickMsgIntent) event);
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogShowed) {
            v((BottomSheetDialogMsgIntent.OnDialogShowed) event);
            return;
        }
        if (event instanceof BottomSheetDialogMsgIntent.OnDialogDismissed) {
            u((BottomSheetDialogMsgIntent.OnDialogDismissed) event);
            return;
        }
        if (event instanceof SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) {
            t(((SlashDialogMsgIntent.OnReportFunctionImpMsgIntent) event).getItemArgs());
        } else if (event instanceof SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) {
            s(((SlashDialogMsgIntent.OnReportFunctionClickMsgIntent) event).getItemArgs());
        } else if (event instanceof SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) {
            y((SlashTitleMsgIntent.OnTitleRobotClickMsgIntent) event);
        }
    }

    private final void s(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.e(impArgs);
    }

    private final void t(FunctionReportArgs impArgs) {
        this.mBusinessDelegate.g(impArgs);
    }

    private final void u(BottomSheetDialogMsgIntent.OnDialogDismissed msgIntent) {
        com.tencent.input.base.launch.b c16;
        List emptyList;
        o oVar = this.mRobotAtDialogProvider;
        if (oVar != null && (c16 = oVar.c()) != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            c16.a(new CommonListMsgIntent.SubmitListMsgIntent(emptyList, 0, null, null, 14, null));
        }
        this.mBusinessDelegate.f(msgIntent.getRootView());
    }

    private final void v(BottomSheetDialogMsgIntent.OnDialogShowed msgIntent) {
        this.mBusinessDelegate.d(msgIntent.getRootView());
    }

    private final void w(CommonListMsgIntent.OnItemClickMsgIntent event) {
        this.mBusinessDelegate.a(event.getItemData(), this.mCurrentKeyword);
        dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Object searchResult) {
        if (!getIsWaitingSearchResult()) {
            QLog.i("RobotAtDialogManager", 1, "[handleSearchResult]: dialog is cancelled");
        } else {
            D(searchResult);
        }
    }

    private final void y(SlashTitleMsgIntent.OnTitleRobotClickMsgIntent msgIntent) {
        this.mBusinessDelegate.b(msgIntent.getRobotUin(), msgIntent.getRobotTinyId());
        dismissDialog();
    }

    private final void z() {
        if (this.mRobotAtDialogProvider != null) {
            return;
        }
        QLog.i("RobotAtDialogManager", 1, "prepareDialog");
        o a16 = new w64.c().a(this.mBusinessDelegate.m(this.mMviContext));
        A(a16.c());
        this.mRobotAtDialogProvider = a16;
    }

    public void B(boolean z16) {
        this.isWaitingSearchResult = z16;
    }

    @Override // com.tencent.robot.slash.manager.b
    public boolean a() {
        o oVar = this.mRobotAtDialogProvider;
        if (oVar != null) {
            return oVar.r();
        }
        return false;
    }

    @Override // com.tencent.robot.slash.manager.b
    public void c() {
        q().a();
        this.mCachedResult = null;
    }

    @Override // com.tencent.robot.slash.manager.b
    public void d(@NotNull String keyword, @NotNull String robotUin) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        QLog.d("RobotAtDialogManager", 4, "[searchAndWaitResultToShow]: keyword=" + keyword);
        Job job = this.mFilterResultJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        z();
        B(true);
        if (this.mCachedResult != null && TextUtils.equals(robotUin, this.mRobotUin)) {
            n(keyword, true);
            return;
        }
        this.mCurrentKeyword = keyword;
        this.mRobotUin = robotUin;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(robotUin);
        if (longOrNull != null) {
            E(longOrNull.longValue());
        }
    }

    @Override // com.tencent.robot.slash.manager.b
    public void destroy() {
        QLog.i("RobotAtDialogManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mCurrentKeyword = null;
        this.mRobotUin = null;
        this.mCachedResult = null;
        c();
        dismissDialog();
        o oVar = this.mRobotAtDialogProvider;
        if (oVar != null) {
            H(oVar.c());
            oVar.onDestroy();
        }
        this.mRobotAtDialogProvider = null;
    }

    @Override // com.tencent.robot.slash.manager.b
    public void dismissDialog() {
        QLog.d("RobotAtDialogManager", 4, "[dismissDialog]: current Keyword=" + this.mCurrentKeyword);
        B(false);
        Job job = this.mFilterResultJob;
        o oVar = null;
        if (job != null) {
            if (!job.isActive()) {
                job = null;
            }
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        this.mFilterResultJob = null;
        o oVar2 = this.mRobotAtDialogProvider;
        if (oVar2 != null) {
            if (oVar2.r()) {
                oVar = oVar2;
            }
            if (oVar != null) {
                oVar.b(false);
            }
        }
    }

    @Override // com.tencent.robot.slash.manager.b
    /* renamed from: e, reason: from getter */
    public boolean getIsWaitingSearchResult() {
        return this.isWaitingSearchResult;
    }

    public void n(@NotNull String keyword, boolean showDialogIfNotShowed) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (this.mCachedResult == null) {
            QLog.i("RobotAtDialogManager", 1, "[filterSearchResult]:no result");
        } else {
            C(keyword, showDialogIfNotShowed);
        }
    }
}
