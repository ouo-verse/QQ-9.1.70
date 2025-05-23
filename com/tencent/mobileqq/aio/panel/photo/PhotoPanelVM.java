package com.tencent.mobileqq.aio.panel.photo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleEventObserver;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOPhotoPanelEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.PhotoPanelEvent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.panel.photo.PhotoPanelUIState;
import com.tencent.mobileqq.aio.panel.photo.g;
import com.tencent.mobileqq.aio.reserve2.animate.PhotoPanelDragAnimateEvent;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.album.ext.WrapLocalMediaInfoKt;
import com.tencent.mobileqq.album.media.AIOMediaRepository;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PreviewInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002JQ\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001aB\u000f\u0012\u0006\u0010C\u001a\u00020@\u00a2\u0006\u0004\b_\u0010`J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\fJ$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0014J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\u001c\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010\t\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020*H\u0002J\u0016\u0010.\u001a\u00020\u00062\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0,H\u0002J\u0010\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0012H\u0002J\u0018\u00101\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0012H\u0002J\b\u00102\u001a\u00020\u0006H\u0002J\u0012\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u000103H\u0002J\b\u00106\u001a\u00020&H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020&H\u0002J\b\u00109\u001a\u00020\u0006H\u0002J\u0019\u0010;\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020\u0006H\u0002R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010#R\u0016\u0010G\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010#R\u0016\u0010I\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010#R\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR&\u0010P\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020J0N0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u001b\u0010^\u001a\u00020[8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\\\u001a\u0004\bX\u0010]\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "L", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "a0", "info", "", HippyTKDListViewAdapter.X, "", "startPos", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Landroid/widget/ImageView;", "view", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Conn, "T", "X", "updatePanelShow", "clearReplaceInfo", "U", "y", "Y", "Z", "g0", "Lcom/tencent/mvi/base/route/MsgIntent;", "Lcom/tencent/mvi/base/route/k;", "I", "E", "K", "Lcom/tencent/mobileqq/aio/panel/photo/g$d;", "D", "", "tag", "e0", CustomImageProps.QUALITY, "c0", "d0", "O", "Landroid/content/Intent;", "result", ExifInterface.LATITUDE_SOUTH, "J", "H", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "curPanelId", "M", "(Ljava/lang/Integer;)V", "Lcom/tencent/mobileqq/aio/panel/photo/g$c;", "b0", "N", "Lcom/tencent/mobileqq/aio/panel/photo/a;", "e", "Lcom/tencent/mobileqq/aio/panel/photo/a;", "mPhotoPanel", "f", "isPanelShow", tl.h.F, "isPanelVisible", "i", "isPanelShowForCreate", "com/tencent/mobileqq/aio/panel/photo/PhotoPanelVM$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM$c;", "mActionR", "Lkotlin/Pair;", "Ljava/util/List;", "messageListR", "com/tencent/mobileqq/aio/panel/photo/PhotoPanelVM$b", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM$b;", "action", "Lcom/tencent/mobileqq/album/media/AIOMediaRepository;", "Lcom/tencent/mobileqq/album/media/AIOMediaRepository;", "repository", "Lkotlinx/coroutines/CoroutineScope;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/CoroutineScope;", "dataUpdateCoroutine", "Landroidx/lifecycle/LifecycleEventObserver;", "Lkotlin/Lazy;", "()Landroidx/lifecycle/LifecycleEventObserver;", "lifeEventObserver", "<init>", "(Lcom/tencent/mobileqq/aio/panel/photo/a;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PhotoPanelVM extends com.tencent.qqnt.aio.baseVM.a<at.c, PanelUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, c>> messageListR;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private AIOMediaRepository repository;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private CoroutineScope dataUpdateCoroutine;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy lifeEventObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mPhotoPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPanelShow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPanelVisible;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPanelShowForCreate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mActionR;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$1", f = "PhotoPanelVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends List<LocalMediaInfo>, ? extends Integer>, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPanelVM.this, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Pair<? extends List<LocalMediaInfo>, ? extends Integer> pair, Continuation<? super Unit> continuation) {
            return invoke2((Pair<? extends List<LocalMediaInfo>, Integer>) pair, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Pair pair = (Pair) this.L$0;
                    QLog.d("PhotoPanelVM", 1, "init repository");
                    PhotoPanelVM.this.updateUI(new PhotoPanelUIState.UpdateMediaInfo(null, (List) pair.getFirst(), ((Number) pair.getSecond()).intValue(), 1, null));
                    ((com.tencent.aio.api.runtime.a) PhotoPanelVM.this.getMContext()).e().h(new PhotoPanelEvent.SelectMediaChanged(PhotoPanelVM.this.repository.g()));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull Pair<? extends List<LocalMediaInfo>, Integer> pair, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) pair, (Object) continuation);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM$a;", "", "", "DATALINE_MEDIA_MAX_NUM", "I", "MEDIA_MAX_NUM", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/panel/photo/PhotoPanelVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPanelVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                PhotoPanelVM.this.E(i3);
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/panel/photo/PhotoPanelVM$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPanelVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return PhotoPanelVM.this.I(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PhotoPanelVM(@NotNull a mPhotoPanel) {
        List<Pair<String, c>> listOf;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mPhotoPanel, "mPhotoPanel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mPhotoPanel);
            return;
        }
        this.mPhotoPanel = mPhotoPanel;
        c cVar = new c();
        this.mActionR = cVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(InputEvent.GetSelectMedia.class)), cVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(InputEvent.GetAndSendSelectMedia.class)), cVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(InputEvent.GetSelectMediaInfo.class)), cVar)});
        this.messageListR = listOf;
        this.action = new b();
        this.repository = new AIOMediaRepository();
        this.dataUpdateCoroutine = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        QLog.d("PhotoPanelVM", 1, "init");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this.repository.d(), new AnonymousClass1(null)), Dispatchers.getMain()), this.dataUpdateCoroutine);
        lazy = LazyKt__LazyJVMKt.lazy(new PhotoPanelVM$lifeEventObserver$2(this));
        this.lifeEventObserver = lazy;
    }

    private final com.tencent.mvi.base.route.k B() {
        d.h hVar = new d.h(this.repository.e(), this.mPhotoPanel.m0());
        this.mPhotoPanel.w(false);
        this.repository.c();
        return hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D(g.d intent) {
        d.c cVar;
        int i3;
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(InputEvent.GetInputBarHeight.f188570d);
        if (k3 instanceof d.c) {
            cVar = (d.c) k3;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            i3 = cVar.a();
        } else {
            i3 = 0;
        }
        intent.b(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E(MsgIntent intent) {
        if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            M(((PanelStatusIntent.PanelStatusChangeIntent) intent).a());
            return;
        }
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            PanelContainerMsgIntent.OnPanelStateChangedMsgIntent onPanelStateChangedMsgIntent = (PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent;
            if (onPanelStateChangedMsgIntent.a() == 1003) {
                if (onPanelStateChangedMsgIntent.b()) {
                    X();
                    return;
                } else {
                    if (this.isPanelVisible) {
                        W(this, false, false, 3, null);
                        return;
                    }
                    return;
                }
            }
            if (this.isPanelShow && onPanelStateChangedMsgIntent.b()) {
                W(this, false, false, 3, null);
                return;
            }
            return;
        }
        if (intent instanceof PhotoPanelEvent.PhotoIconLongClick) {
            O();
            return;
        }
        if (intent instanceof AIOPhotoPanelEvent.PhotoEditSend) {
            this.mPhotoPanel.f0();
            this.mPhotoPanel.w(false);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("PhotoPanelVM", false, 2, null));
        } else if (intent instanceof PhotoPanelEvent.ClearSelectedMidia) {
            z();
            y();
        } else if (intent instanceof PhotoPanelEvent.OnAlbumResult) {
            K();
        }
    }

    private final LifecycleEventObserver F() {
        return (LifecycleEventObserver) this.lifeEventObserver.getValue();
    }

    private final com.tencent.mvi.base.route.k H() {
        int collectionSizeOrDefault;
        List<LocalMediaInfo> g16 = this.repository.g();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = g16.iterator();
        while (it.hasNext()) {
            arrayList.add(WrapLocalMediaInfoKt.j((LocalMediaInfo) it.next()));
        }
        return new d.i(arrayList, this.mPhotoPanel.m0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent intent) {
        if (intent instanceof InputEvent.GetSelectMedia) {
            return J();
        }
        if (intent instanceof InputEvent.GetAndSendSelectMedia) {
            return B();
        }
        if (intent instanceof InputEvent.GetSelectMediaInfo) {
            return H();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final com.tencent.mvi.base.route.k J() {
        QLog.d("PhotoPanelVM", 1, "getSelectedMedia");
        return new d.h(this.repository.l(), this.mPhotoPanel.m0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        ox3.a.a("PhotoPanelVM", PhotoPanelVM$handleAlbumResult$1.INSTANCE);
        S(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity().getIntent());
    }

    private final void M(Integer curPanelId) {
        if (curPanelId != null) {
            curPanelId.intValue();
        }
    }

    private final void N() {
        if (8 == C()) {
            QLog.d("PhotoPanelVM", 1, "judgeIsMyComputer");
            updateUI(PhotoPanelUIState.ShieldQuality.f193056d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O() {
        int i3;
        TabType tabType;
        int collectionSizeOrDefault;
        boolean z16;
        boolean z17;
        ox3.a.c("PhotoPanelVM", PhotoPanelVM$jumpToAlbum$1.INSTANCE);
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.j(false);
        if (e16 == 8) {
            i3 = 50;
        } else {
            i3 = 20;
        }
        aVar2.g(i3);
        if (((IAlbumApi) QRoute.api(IAlbumApi.class)).needToBlockVideo(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e())) {
            tabType = TabType.TAB_IMAGE;
        } else {
            tabType = TabType.TAB_MEDIA;
        }
        aVar2.f(tabType);
        aVar2.h(4);
        List<LocalMediaInfo> G = G();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(G, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = G.iterator();
        while (it.hasNext()) {
            arrayList.add(((LocalMediaInfo) it.next()).toSelectMediaInfo());
        }
        aVar2.b(new ArrayList(arrayList));
        if (e16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar2.d(z16);
        if (e16 != 8) {
            z17 = true;
        } else {
            z17 = false;
        }
        aVar2.m(z17);
        aVar2.l(this.mPhotoPanel.m0());
        aVar2.e(e16);
        aVar2.o(new HashMap<>(this.mPhotoPanel.H()));
        Unit unit = Unit.INSTANCE;
        Intent e17 = com.tencent.qqnt.qbasealbum.a.e(aVar, requireContext, aVar2.a(), null, null, null, 28, null);
        ((IPhotoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPhotoPanelApi.class)).fillIntentForJumpAlbum(e17, (com.tencent.aio.api.runtime.a) getMContext());
        U(true, false);
        ((com.tencent.aio.api.runtime.a) getMContext()).f().a(e17, new ActivityResultCallback() { // from class: com.tencent.mobileqq.aio.panel.photo.o
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PhotoPanelVM.P(PhotoPanelVM.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void P(PhotoPanelVM this$0, final ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ox3.a.c("PhotoPanelVM", new Function0<String>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$jumpToAlbum$2$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivityResult.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "jumpToAlbum onActivityResult resultCode: " + ActivityResult.this.getResultCode() + " data: " + (ActivityResult.this.getData() != null);
            }
        });
        this$0.y();
        if (activityResult.getResultCode() != -1) {
            this$0.mPhotoPanel.f0();
            this$0.mPhotoPanel.w(false);
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("PhotoPanelVM", false, 2, null));
            return;
        }
        this$0.S(activityResult.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(PhotoPanelVM this$0, final ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ox3.a.c("PhotoPanelVM", new Function0<String>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$jumpToPreview$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivityResult.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "jumpToPreview onActivityResult resultCode: " + ActivityResult.this.getResultCode() + " data: " + (ActivityResult.this.getData() != null);
            }
        });
        this$0.y();
        if (activityResult.getResultCode() != -1) {
            return;
        }
        this$0.S(activityResult.getData());
    }

    private final void S(Intent result) {
        final AlbumResult albumResult;
        List<LocalMediaInfo> e16;
        Object obj;
        Object obj2;
        this.mPhotoPanel.f0();
        this.mPhotoPanel.w(false);
        if (result != null) {
            albumResult = (AlbumResult) result.getParcelableExtra("ALBUM_RESULT");
        } else {
            albumResult = null;
        }
        if (albumResult != null) {
            Intrinsics.checkNotNull(result);
            result.removeExtra("ALBUM_RESULT");
        }
        ox3.a.c("PhotoPanelVM", new Function0<String>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$onAlbumResult$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlbumResult.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                List<LocalMediaInfo> e17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                AlbumResult albumResult2 = AlbumResult.this;
                Integer valueOf = (albumResult2 == null || (e17 = albumResult2.e()) == null) ? null : Integer.valueOf(e17.size());
                AlbumResult albumResult3 = AlbumResult.this;
                return "onAlbumResult selectList:" + valueOf + " needSend:" + (albumResult3 != null ? Boolean.valueOf(albumResult3.b()) : null);
            }
        });
        if (albumResult != null && (e16 = albumResult.e()) != null) {
            if (albumResult.b()) {
                BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new PhotoPanelVM$onAlbumResult$6(this, e16, albumResult, null), 3, null);
                return;
            }
            for (LocalMediaInfo localMediaInfo : e16) {
                Iterator<T> it = this.mPhotoPanel.K().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (Intrinsics.areEqual(((LocalMediaInfo) obj2).getPath(), localMediaInfo.getPath())) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) obj2;
                if (localMediaInfo2 != null) {
                    this.mPhotoPanel.v0(new g.a(localMediaInfo2));
                }
            }
            HashMap<String, String> c16 = albumResult.c();
            if (c16 != null) {
                for (String originPath : c16.keySet()) {
                    a aVar = this.mPhotoPanel;
                    Intrinsics.checkNotNullExpressionValue(originPath, "originPath");
                    String str = c16.get(originPath);
                    Intrinsics.checkNotNull(str);
                    aVar.X0(originPath, str);
                    Iterator<T> it5 = this.mPhotoPanel.K().iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            obj = it5.next();
                            if (Intrinsics.areEqual(((LocalMediaInfo) obj).getPath(), originPath)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    LocalMediaInfo localMediaInfo3 = (LocalMediaInfo) obj;
                    if (localMediaInfo3 != null) {
                        this.mPhotoPanel.v0(new g.e(localMediaInfo3));
                    }
                }
            }
            this.mPhotoPanel.w(albumResult.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        this.isPanelShow = true;
        this.isPanelVisible = true;
        this.isPanelShowForCreate = true;
    }

    private final void U(boolean updatePanelShow, boolean clearReplaceInfo) {
        ox3.a.a("PhotoPanelVM", PhotoPanelVM$onPanelHide$1.INSTANCE);
        if (updatePanelShow) {
            this.isPanelShow = false;
        }
        this.isPanelVisible = false;
        this.mPhotoPanel.t();
        if (clearReplaceInfo) {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void W(PhotoPanelVM photoPanelVM, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        photoPanelVM.U(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void X() {
        if (this.isPanelShowForCreate) {
            this.isPanelShowForCreate = false;
            Y();
            return;
        }
        ox3.a.a("PhotoPanelVM", PhotoPanelVM$onPanelShow$1.INSTANCE);
        this.isPanelShow = true;
        this.isPanelVisible = true;
        ((IAlbumApi) QRoute.api(IAlbumApi.class)).queryMediaTask(vmScope(), ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e(), new Function1<List<? extends LocalMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$onPanelShow$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPanelVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalMediaInfo> list) {
                invoke2((List<LocalMediaInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<LocalMediaInfo> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    PhotoPanelVM.this.e0(it);
                }
            }
        });
        this.mPhotoPanel.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y() {
        ((IAlbumApi) QRoute.api(IAlbumApi.class)).queryMediaFromCache(vmScope(), ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e(), new Function1<List<? extends LocalMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$onPanelShowForCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPanelVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalMediaInfo> list) {
                invoke2((List<LocalMediaInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<LocalMediaInfo> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isEmpty()) {
                    PhotoPanelVM.this.e0(it);
                }
                PhotoPanelVM.this.X();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Z() {
        Iterator<T> it = this.messageListR.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().j((String) pair.getFirst(), (com.tencent.mvi.base.route.b) pair.getSecond());
        }
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.d(jVar.a(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.PhotoIconLongClick.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(jVar.a(Reflection.getOrCreateKotlinClass(AIOPhotoPanelEvent.PhotoEditSend.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.ClearSelectedMidia.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.OnAlbumResult.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(F());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b0(g.c intent) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOReserve1CreateModelIntent("photo_panel_swipe_animation", new PhotoPanelDragAnimateEvent.AnimateEvent(intent.b(), intent.a())));
    }

    private final void c0(final boolean quality) {
        ox3.a.c("PhotoPanelVM", new Function0<String>(quality) { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVM$sendSelectMediaInfo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $quality;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$quality = quality;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, quality);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "sendSelectMediaInfo quality:" + this.$quality;
            }
        });
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new PhotoPanelVM$sendSelectMediaInfo$2(this, quality, null), 3, null);
    }

    private final void d0(LocalMediaInfo info, boolean quality) {
        ox3.a.c("PhotoPanelVM", PhotoPanelVM$sendSingleMediaInfo$1.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new PhotoPanelVM$sendSingleMediaInfo$2(this, info, quality, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(List<LocalMediaInfo> tag) {
        updateUI(new PhotoPanelUIState.UpdateMediaInfo(tag, null, 0, 6, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0() {
        Iterator<T> it = this.messageListR.iterator();
        while (it.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().a((String) ((Pair) it.next()).getFirst());
        }
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.b(jVar.a(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.PhotoIconLongClick.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIOPhotoPanelEvent.PhotoEditSend.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.ClearSelectedMidia.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.OnAlbumResult.class)), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(F());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        this.mPhotoPanel.u();
        for (LocalMediaInfo localMediaInfo : this.mPhotoPanel.K()) {
            if (com.tencent.qqnt.qbasealbum.ktx.b.j(localMediaInfo)) {
                com.tencent.qqnt.qbasealbum.ktx.b.r(localMediaInfo, false);
                localMediaInfo.setSystemMeidaStore(true);
                localMediaInfo.setPath(localMediaInfo.getPicPathBeforeEdit());
                this.mPhotoPanel.v0(new g.e(localMediaInfo));
            }
        }
    }

    private final void z() {
        this.mPhotoPanel.w(false);
        this.repository.c();
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.repository.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
    }

    @NotNull
    public final List<LocalMediaInfo> G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.repository.g();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull at.c intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof g.a) {
            this.repository.b(((g.a) intent).a());
            return;
        }
        if (intent instanceof g.f) {
            this.repository.k(((g.f) intent).a());
            return;
        }
        if (intent instanceof g.C7339g) {
            c0(((g.C7339g) intent).a());
            return;
        }
        if (intent instanceof g.e) {
            this.repository.j(((g.e) intent).a());
            return;
        }
        if (intent instanceof g.b) {
            O();
            return;
        }
        if (intent instanceof g.c) {
            b0((g.c) intent);
            return;
        }
        if (intent instanceof g.h) {
            g.h hVar = (g.h) intent;
            d0(hVar.a(), hVar.b());
        } else if (intent instanceof g.d) {
            D((g.d) intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(int startPos, @Nullable Rect rect, @Nullable ImageView view) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(startPos), rect, view);
            return;
        }
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.j(false);
        aVar2.l(this.mPhotoPanel.m0());
        if (e16 == 8) {
            i3 = 50;
        } else {
            i3 = 20;
        }
        aVar2.g(i3);
        aVar2.e(e16);
        if (e16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar2.d(z16);
        if (e16 == 8) {
            z17 = false;
        }
        aVar2.m(z17);
        aVar2.o(new HashMap<>(this.mPhotoPanel.H()));
        aVar2.c(rect);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PreviewInitBean.Companion companion2 = PreviewInitBean.INSTANCE;
        PreviewInitBean.a aVar3 = new PreviewInitBean.a();
        aVar3.b(new ArrayList<>(this.mPhotoPanel.K()));
        aVar3.d(startPos);
        aVar3.e(new ArrayList<>(G()));
        Intent g16 = com.tencent.qqnt.qbasealbum.a.g(aVar, requireContext, a16, aVar3.a(), null, 8, null);
        aVar.m(new WeakReference<>(view));
        ((IPhotoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPhotoPanelApi.class)).fillIntentForJumpPreview(g16, (com.tencent.aio.api.runtime.a) getMContext());
        U(false, false);
        ((com.tencent.aio.api.runtime.a) getMContext()).f().a(g16, new ActivityResultCallback() { // from class: com.tencent.mobileqq.aio.panel.photo.p
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PhotoPanelVM.R(PhotoPanelVM.this, (ActivityResult) obj);
            }
        });
    }

    @NotNull
    public final String a0() {
        int roundToInt;
        int roundToInt2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (G().isEmpty()) {
            return "";
        }
        Iterator<LocalMediaInfo> it = G().iterator();
        float f16 = 0.0f;
        while (it.hasNext()) {
            f16 += (float) it.next().getFileSize();
        }
        if (f16 < 1024.0f) {
            return "(1K)";
        }
        float f17 = 1024;
        float f18 = 10;
        roundToInt = MathKt__MathJVMKt.roundToInt((f16 / f17) * f18);
        float f19 = roundToInt / 10.0f;
        if (f19 >= 1024.0f) {
            roundToInt2 = MathKt__MathJVMKt.roundToInt((f19 / f17) * f18);
            return "(" + (roundToInt2 / 10.0f) + "M)";
        }
        return "(" + f19 + "K)";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        g0();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PhotoPanelEvent.PhotoPanelActive(false));
        AlbumThumbManager.Companion companion = AlbumThumbManager.INSTANCE;
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        companion.e(requireContext).d();
    }

    public final boolean x(@NotNull LocalMediaInfo info) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) info)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        int size = G().size();
        if (8 == C()) {
            i3 = 50;
        } else {
            i3 = 20;
        }
        if (size < i3) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        QLog.d("PhotoPanelVM", 1, "onCreate");
        com.tencent.mobileqq.aio.panel.photo.b bVar = com.tencent.mobileqq.aio.panel.photo.b.f193075a;
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        bVar.b(requireContext);
        Z();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PhotoPanelEvent.PhotoPanelActive(true));
        N();
    }
}
