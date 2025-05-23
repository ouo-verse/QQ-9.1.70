package com.tencent.mobileqq.aio.background;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.background.FullBackgroundUIState;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoSource;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00018\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001BB\u0007\u00a2\u0006\u0004\bA\u0010\"J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u000f\u0010!\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b#\u0010\"R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010@\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/aio/background/FullBackgroundVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/background/FullBackgroundMviIntent;", "Lcom/tencent/mobileqq/aio/background/FullBackgroundUIState;", "Lcom/tencent/mvi/base/route/g;", "", UserInfo.SEX_FEMALE, "J", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "G", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "stop", HippyTKDListViewAdapter.X, "Landroid/view/View;", "view", "toRemove", "B", BdhLogUtil.LogTag.Tag_Conn, "isShotMode", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "y", "r", "()V", "K", "", "", "e", "Ljava/util/List;", "mViewTypeList", "f", "Z", "w", "()Z", "H", "(Z)V", "showWatermark", "", h.F, "Ljava/lang/String;", "watermarkText", "Lcom/tencent/mobileqq/aio/background/g;", "i", "Lcom/tencent/mobileqq/aio/background/g;", "groupListener", "com/tencent/mobileqq/aio/background/FullBackgroundVM$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/background/FullBackgroundVM$b;", "mAction", "Lcom/tencent/qqnt/kernel/api/s;", "Lkotlin/Lazy;", "v", "()Lcom/tencent/qqnt/kernel/api/s;", "groupService", "<init>", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class FullBackgroundVM extends com.tencent.qqnt.aio.baseVM.a<FullBackgroundMviIntent, FullBackgroundUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Boolean> E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> mViewTypeList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showWatermark;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String watermarkText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g groupListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/background/FullBackgroundVM$a;", "", "", "waterMarkSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "waterMarkSwitch", "", "GROUP_CLASS_EXT_TYPE_QQ_WORK", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.background.FullBackgroundVM$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) FullBackgroundVM.E.getValue()).booleanValue();
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/background/FullBackgroundVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FullBackgroundVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                FullBackgroundVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32436);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(FullBackgroundVM$Companion$waterMarkSwitch$2.INSTANCE);
        E = lazy;
    }

    public FullBackgroundVM() {
        List<Integer> listOf;
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 3, 5});
            this.mViewTypeList = listOf;
            this.mAction = new b();
            lazy = LazyKt__LazyJVMKt.lazy(FullBackgroundVM$groupService$2.INSTANCE);
            this.groupService = lazy;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A(Bitmap bitmap) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.GetWatermarkBitmap(bitmap));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(View view, boolean toRemove) {
        if (!(view instanceof com.tencent.qqnt.aio.api.b)) {
            QLog.i("FullBackgroundVM", 1, "[handleUpdateAIOBackground]: view is not instance of IAIOBackgroudnView");
            return;
        }
        com.tencent.qqnt.aio.api.b bVar = (com.tencent.qqnt.aio.api.b) view;
        int type = bVar.type();
        if (this.mViewTypeList.contains(Integer.valueOf(type))) {
            QLog.i("FullBackgroundVM", 1, "[handleUpdateAIOBackground]: update fullbackgroundView, current viewType is " + type);
            bVar.setAdapterNavigationBarImmersive(C() ^ true);
            updateUI(new FullBackgroundUIState.UpdateAIOBackgroundView(view, toRemove));
            return;
        }
        QLog.i("FullBackgroundVM", 1, "[handleUpdateAIOBackground]: remove fullbackgroundView, current viewType is " + type);
        updateUI(FullBackgroundUIState.RemoveAIOBackgroundView.f188196d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean C() {
        return ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getBoolean("key_is_forward_aio", false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean D() {
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof FullBackgroundMviIntent.UpdateAIOBackground) {
            FullBackgroundMviIntent.UpdateAIOBackground updateAIOBackground = (FullBackgroundMviIntent.UpdateAIOBackground) intent;
            B(updateAIOBackground.b(), updateAIOBackground.a());
        } else if (intent instanceof FullBackgroundMviIntent.AIOBackgroundPlayEvent) {
            x(((FullBackgroundMviIntent.AIOBackgroundPlayEvent) intent).a());
        } else if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            z(((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
        } else if (intent instanceof FullBackgroundMviIntent.UpdateNavigationBg) {
            updateUI(new FullBackgroundUIState.SetImmersiveBottomDrawable(((FullBackgroundMviIntent.UpdateNavigationBg) intent).a()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
    }

    private final void G() {
        s v3;
        if (!D()) {
            return;
        }
        g gVar = this.groupListener;
        if (gVar != null && (v3 = v()) != null) {
            v3.x0(gVar);
        }
        this.groupListener = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
    }

    private final void q() {
        if (!D()) {
            return;
        }
        g gVar = new g(this);
        this.groupListener = gVar;
        s v3 = v();
        if (v3 != null) {
            v3.D(gVar);
        }
    }

    private final void s() {
        if (!D()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.background.d
            @Override // java.lang.Runnable
            public final void run() {
                FullBackgroundVM.t(FullBackgroundVM.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(final FullBackgroundVM this$0) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Result.Companion companion = Result.INSTANCE;
            s v3 = this$0.v();
            if (v3 != null) {
                v3.getGroupDetailInfo(Long.parseLong(((com.tencent.aio.api.runtime.a) this$0.getMContext()).g().r().c().j()), GroupInfoSource.KAIO, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.background.e
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        FullBackgroundVM.u(i3, str);
                    }
                });
            }
            QRouteApi api = QRoute.api(INtTroopMemberApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(INtTroopMemberApi::class.java)");
            INtTroopMemberApi.a.a((INtTroopMemberApi) api, ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g().r().c().j(), MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid(), false, true, "FullBackgroundVM", new Function1<com.tencent.qqnt.aio.adapter.troop.a, Unit>() { // from class: com.tencent.mobileqq.aio.background.FullBackgroundVM$getGroupAndMemberInfo$1$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FullBackgroundVM.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.aio.adapter.troop.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.qqnt.aio.adapter.troop.a nickInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) nickInfo);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(nickInfo, "nickInfo");
                    QLog.i("FullBackgroundVM", 1, "fetchTroopMemberName name=" + com.tencent.qqnt.aio.utils.b.c(com.tencent.qqnt.aio.adapter.troop.a.f(nickInfo, false, false, 3, null)));
                    FullBackgroundVM.this.watermarkText = com.tencent.qqnt.aio.adapter.troop.a.f(nickInfo, false, false, 3, null);
                    FullBackgroundVM.this.K();
                }
            }, 4, null);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("FullBackgroundVM", 1, "getGroupAndMemberInfo error: " + m479exceptionOrNullimpl.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(int i3, String str) {
        QLog.i("FullBackgroundVM", 1, "getGroupDetailInfo result: " + i3 + ", error: " + str);
    }

    private final s v() {
        return (s) this.groupService.getValue();
    }

    private final void x(boolean stop) {
        updateUI(new FullBackgroundUIState.UpdateAIOBackgroundPlayEvent(stop));
    }

    private final void z(boolean isShotMode) {
        if (isShotMode) {
            updateUI(FullBackgroundUIState.PushShotWatermarkBitmap.f188195d);
        }
    }

    public final void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.showWatermark = z16;
        }
    }

    public final void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.showWatermark && !TextUtils.isEmpty(this.watermarkText)) {
            updateUI(new FullBackgroundUIState.UpdateAIOWatermark(this.watermarkText + "@QQ\u5de5\u4f5c\u7fa4"));
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.background.FullBackgroundMviIntent.UpdateAIOBackground");
        hashSet.add("com.tencent.mobileqq.aio.background.FullBackgroundMviIntent.AIOBackgroundPlayEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.background.FullBackgroundMviIntent.UpdateNavigationBg");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        r();
        super.onDestroy();
        J();
        G();
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.showWatermark = false;
        this.watermarkText = null;
        updateUI(FullBackgroundUIState.RemoveAIOWatermark.f188197d);
    }

    public final boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.showWatermark;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull FullBackgroundMviIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof FullBackgroundMviIntent.PushShotWaterMarkBitmap) {
            A(((FullBackgroundMviIntent.PushShotWaterMarkBitmap) intent).a());
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        F();
        q();
        if (INSTANCE.b()) {
            s();
        }
    }
}
