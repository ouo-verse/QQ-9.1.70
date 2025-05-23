package com.tencent.robot.aio.bottombar.picture;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.PhotoPanelEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.album.ext.WrapLocalMediaInfoKt;
import com.tencent.mobileqq.album.media.AIOMediaRepository;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.camera.api.ICameraBusinessAPI;
import com.tencent.qqnt.camera.data.CameraReq;
import com.tencent.qqnt.doutu.event.DoutuEvent;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.robot.aio.bottombar.event.RobotBottomBarEvent;
import com.tencent.robot.aio.bottombar.picture.RobotPictureBarUIState;
import com.tencent.robot.aio.bottombar.picture.d;
import com.tencent.robot.aio.pluspanel.RobotPickerCustomization;
import com.tencent.robot.aio.pluspanel.RobotPreviewCustomization;
import com.tencent.robot.aio.pluspanel.processor.RobotPlusPanelEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007*\u000248\b\u0007\u0018\u0000 C2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\u0018\u0010'\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\nH\u0016R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\bR\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R&\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002080=0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/robot/aio/bottombar/picture/d;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "I", "w", "", "E", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "", "r", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "u", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", "Lcom/tencent/mobileqq/aio/event/RobotMsgIntent$OnTakePhoto;", "result", "B", "Landroid/content/Intent;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", "y", "", "mode", "add", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "G", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", HippyTKDListViewAdapter.X, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/album/media/AIOMediaRepository;", "e", "Lcom/tencent/mobileqq/album/media/AIOMediaRepository;", "repository", "Lkotlinx/coroutines/CoroutineScope;", "f", "Lkotlinx/coroutines/CoroutineScope;", "dataUpdateCoroutine", h.F, "modeStateFlag", "com/tencent/robot/aio/bottombar/picture/RobotPictureBarVM$b", "i", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarVM$b;", "mAction", "com/tencent/robot/aio/bottombar/picture/RobotPictureBarVM$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarVM$c;", "mActionR", "", "Lkotlin/Pair;", "", "Ljava/util/List;", "messageListR", "<init>", "()V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPictureBarVM extends com.tencent.qqnt.aio.baseVM.a<d, RobotPictureBarUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, c>> messageListR;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AIOMediaRepository repository = new AIOMediaRepository();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CoroutineScope dataUpdateCoroutine = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int modeStateFlag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mActionR;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.robot.aio.bottombar.picture.RobotPictureBarVM$1", f = "RobotPictureBarVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.robot.aio.bottombar.picture.RobotPictureBarVM$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends List<LocalMediaInfo>, ? extends Integer>, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Pair<? extends List<LocalMediaInfo>, ? extends Integer> pair, Continuation<? super Unit> continuation) {
            return invoke2((Pair<? extends List<LocalMediaInfo>, Integer>) pair, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            j e16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RobotPictureBarVM robotPictureBarVM = RobotPictureBarVM.this;
                robotPictureBarVM.updateUI(new RobotPictureBarUIState.AddPicItem(robotPictureBarVM.repository.g()));
                com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) RobotPictureBarVM.this.getSafetyContext();
                if (aVar != null && (e16 = aVar.e()) != null) {
                    e16.h(new PhotoPanelEvent.OnPictureNumberAboveInputChanged(RobotPictureBarVM.this.repository.h()));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull Pair<? extends List<LocalMediaInfo>, Integer> pair, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/bottombar/picture/RobotPictureBarVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotPictureBarVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/bottombar/picture/RobotPictureBarVM$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return RobotPictureBarVM.this.I(intent);
        }
    }

    public RobotPictureBarVM() {
        List<Pair<String, c>> listOf;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this.repository.d(), new AnonymousClass1(null)), Dispatchers.getMain()), this.dataUpdateCoroutine);
        this.mAction = new b();
        c cVar = new c();
        this.mActionR = cVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(InputEvent.RobotGetSelectMediaInfo.class)), cVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(RobotBottomBarEvent.class)), cVar)});
        this.messageListR = listOf;
    }

    private final void A(Intent intent) {
        List<LocalMediaInfo> e16;
        AlbumResult albumResult = (AlbumResult) intent.getParcelableExtra("ALBUM_RESULT");
        if (albumResult != null) {
            intent.removeExtra("ALBUM_RESULT");
        }
        if (albumResult != null && (e16 = albumResult.e()) != null) {
            ArrayList arrayList = new ArrayList();
            for (LocalMediaInfo localMediaInfo : e16) {
                arrayList.add(WrapLocalMediaInfoKt.j(localMediaInfo));
                this.repository.b(localMediaInfo);
            }
        }
    }

    private final void B(RobotMsgIntent.OnTakePhoto result) {
        if (result.b() != 17002 && !Intrinsics.areEqual("RobotPictureBarVM", result.c())) {
            return;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo(false, 1, null);
        localMediaInfo.setMMediaType(0);
        localMediaInfo.setPath(result.a());
        localMediaInfo.setThumbnailPath(result.d());
        this.repository.b(localMediaInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        ts.a f16;
        if (!r()) {
            return;
        }
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        int h16 = 9 - this.repository.h();
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.j(true);
        aVar2.g(h16);
        aVar2.f(TabType.TAB_IMAGE);
        aVar2.h(4);
        aVar2.e(e16);
        aVar2.d(false);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar3 = new PickerInitBean.a();
        aVar3.b("\u786e\u5b9a");
        Intent d16 = aVar.d(requireContext, a16, aVar3.a(), RobotPickerCustomization.class, RobotPreviewCustomization.class);
        ((IPhotoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPhotoPanelApi.class)).fillIntentForJumpAlbum(d16, (com.tencent.aio.api.runtime.a) getMContext());
        com.tencent.aio.api.runtime.a aVar4 = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar4 != null && (f16 = aVar4.f()) != null) {
            f16.a(d16, new ActivityResultCallback() { // from class: com.tencent.robot.aio.bottombar.picture.e
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    RobotPictureBarVM.D(RobotPictureBarVM.this, (ActivityResult) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(RobotPictureBarVM this$0, ActivityResult activityResult) {
        Intent data;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
            this$0.A(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof PhotoPanelEvent.ClearSelectedMidia) {
            s();
            return;
        }
        if (intent instanceof RobotMsgIntent.OnTakePhoto) {
            B((RobotMsgIntent.OnTakePhoto) intent);
            return;
        }
        if (intent instanceof RobotPlusPanelEvent.OnClickPicture) {
            C();
            return;
        }
        if (intent instanceof RobotPlusPanelEvent.OnClickCamera) {
            F();
            return;
        }
        if (intent instanceof AIOMsgListEvent.InputToolBarChanged) {
            if (v()) {
                if (((AIOMsgListEvent.InputToolBarChanged) intent).a()) {
                    z();
                    return;
                } else {
                    H();
                    return;
                }
            }
            return;
        }
        if (y(intent)) {
            if (v()) {
                H();
            } else {
                z();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        if (!r()) {
            return;
        }
        ((ICameraBusinessAPI) QRoute.api(ICameraBusinessAPI.class)).startCameraAndCallback((com.tencent.aio.api.runtime.a) getMContext(), new CameraReq(null, 1, null), 17002, "RobotPictureBarVM", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        j e16;
        j e17;
        Iterator<T> it = this.messageListR.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
            if (aVar != null && (e17 = aVar.e()) != null) {
                e17.j((String) pair.getFirst(), (com.tencent.mvi.base.route.b) pair.getSecond());
            }
        }
        com.tencent.aio.api.runtime.a aVar2 = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar2 != null && (e16 = aVar2.e()) != null) {
            e16.f(this, this.mAction);
        }
    }

    private final void H() {
        updateUI(RobotPictureBarUIState.ShowPictures.f366929d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent intent) {
        if (intent instanceof InputEvent.RobotGetSelectMediaInfo) {
            return w();
        }
        return new j54.a();
    }

    private final void p(int mode, boolean add) {
        if (QLog.isColorLevel()) {
            QLog.i("RobotPictureBarVM", 2, "addModeOrClear mode:" + mode + " add:" + mode);
        }
        if (add) {
            q(mode);
        } else {
            t(mode);
        }
    }

    private final void q(int mode) {
        this.modeStateFlag = (mode & 59) | this.modeStateFlag;
    }

    private final boolean r() {
        if (this.repository.h() >= 9) {
            updateUI(new RobotPictureBarUIState.NotifyOverMaxSelectedSize(9));
            return false;
        }
        return true;
    }

    private final void s() {
        updateUI(RobotPictureBarUIState.HidePictures.f366927d);
        this.repository.c();
    }

    private final void t(int mode) {
        this.modeStateFlag = (~(mode & 59)) & this.modeStateFlag;
    }

    private final void u(LocalMediaInfo info) {
        this.repository.k(info);
        if (this.repository.h() == 0) {
            updateUI(RobotPictureBarUIState.HidePictures.f366927d);
        }
    }

    private final boolean v() {
        if ((this.modeStateFlag & 59) == 0) {
            return true;
        }
        return false;
    }

    private final k w() {
        int collectionSizeOrDefault;
        List<LocalMediaInfo> g16 = this.repository.g();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = g16.iterator();
        while (it.hasNext()) {
            arrayList.add(WrapLocalMediaInfoKt.j((LocalMediaInfo) it.next()));
        }
        return new d.i(arrayList, false);
    }

    private final boolean y(MsgIntent intent) {
        QLog.i("RobotPictureBarVM", 1, "handleShowStateEvent intent =  " + intent);
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            p(4, ((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent).b());
        } else if (intent instanceof AIOMsgListEvent.AddAvatarAreaView) {
            p(16, true);
        } else if (intent instanceof AIOMsgListEvent.RemoveAvatarAreaView) {
            p(16, false);
        } else if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            p(2, ((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
        } else if (intent instanceof DoutuEvent.OnShowOrHideDoutuEvent) {
            p(8, ((DoutuEvent.OnShowOrHideDoutuEvent) intent).a());
        } else if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            p(1, ((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
        } else {
            if (!(intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged)) {
                return false;
            }
            p(32, ((FullScreenMsgIntent.OnFullScreenModeChanged) intent).a());
        }
        return true;
    }

    private final void z() {
        updateUI(RobotPictureBarUIState.HidePictures.f366927d);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.robot.aio.bottombar.picture.RobotBottomPictureEvent.OnCameraResult");
        hashSet.add("com.tencent.mobileqq.aio.event.PhotoPanelEvent.ClearSelectedMidia");
        hashSet.add("com.tencent.robot.aio.pluspanel.processor.RobotPlusPanelEvent.OnClickPicture");
        hashSet.add("com.tencent.robot.aio.pluspanel.processor.RobotPlusPanelEvent.OnClickCamera");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.InputToolBarChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.RobotMsgIntent.OnTakePhoto");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        G();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        j e16;
        j e17;
        super.onDestroy();
        s();
        Iterator<T> it = this.messageListR.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
            if (aVar != null && (e17 = aVar.e()) != null) {
                e17.a((String) pair.getFirst());
            }
        }
        com.tencent.aio.api.runtime.a aVar2 = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar2 != null && (e16 = aVar2.e()) != null) {
            e16.i(this, this.mAction);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull d intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.ClearSinglePictureInfo) {
            u(((d.ClearSinglePictureInfo) intent).getInfo());
        }
    }
}
