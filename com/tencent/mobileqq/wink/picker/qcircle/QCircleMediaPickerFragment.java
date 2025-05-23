package com.tencent.mobileqq.wink.picker.qcircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import b93.OutputData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.ApngImage;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QCircleOpenQzoneAlbumPageEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.WinkInitManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.event.WinkExtractCoverEvent;
import com.tencent.mobileqq.wink.event.WinkExtractCoverReceiverEvent;
import com.tencent.mobileqq.wink.event.WinkFirstVideoDialogEvent;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.QCircleInitBean;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.p;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkPerformanceHelper;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerPublishTagGuidePart;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTipsPart;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTitleBarActionPart;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopBannerPart;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001rB\u0007\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J*\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0016\u0010\u0011\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tH\u0002J$\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0002J\u0016\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dH\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0014J\b\u0010*\u001a\u00020)H\u0014J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016J\u0012\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u001a\u00105\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\tH\u0016J \u00109\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J \u0010:\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\b\u0010;\u001a\u00020\u0006H\u0014J\b\u0010<\u001a\u00020\u0006H\u0016J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tH\u0014J\b\u0010>\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?H\u0016J\u0012\u0010C\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010G\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050E0Dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050E`FH\u0016R\u001b\u0010L\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010I\u001a\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010SR\u0016\u0010Y\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010SR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010I\u001a\u0004\b`\u0010aR\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010I\u001a\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u001d\u0010n\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bk\u0010I\u001a\u0004\bl\u0010m\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Yi", "dj", "", "useVideoTemplate", "isFromQZoneMedia", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "aj", "localMediaInfoList", "Oi", "bj", "ej", "gj", "isFromTemplateColl", "jj", "Landroid/view/View;", "view", "", "elementId", "operationType", "Qi", "", "", "getReportParams", "Pi", "Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerFactory;", "Xi", "Ti", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Fh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getLogTag", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onBackEvent", "di", "hi", "fi", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "oi", "xc", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "X", "Lkotlin/Lazy;", "Zi", "()Z", "isQCircleBiz", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "Y", "Ui", "()Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "mediaPickerScene", "Lkotlinx/coroutines/CoroutineScope;", "Z", "Lkotlinx/coroutines/CoroutineScope;", "normalScope", "a0", "isFromSave", "b0", "schemaJumpInterrupted", "Ljava/util/Timer;", "c0", "Ljava/util/Timer;", SemanticAttributes.FaasTriggerValues.TIMER, "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "d0", "Wi", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "e0", "Vi", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "mediaPickerUIStateViewModel", "f0", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "pagerCallback", "g0", "Si", "()Landroid/view/View;", "bottomGapView", "<init>", "()V", "i0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerFragment extends WinkMediaPickerMainBaseFragment<QCircleInitBean> implements FragmentPager.d, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy isQCircleBiz;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerScene;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope normalScope;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isFromSave;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean schemaJumpInterrupted;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Timer timer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy nextStepHelper;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerUIStateViewModel;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FragmentPager.b pagerCallback;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bottomGapView;

    /* renamed from: h0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f324959h0 = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerFragment$a;", "", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", "qCircleInitBean", "Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerFragment;", "a", "", "MEMORY_ALBUM_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QCircleMediaPickerFragment a(@Nullable Config config, @Nullable QCircleInitBean qCircleInitBean) {
            QCircleMediaPickerFragment qCircleMediaPickerFragment = new QCircleMediaPickerFragment();
            qCircleMediaPickerFragment.setArguments(qCircleMediaPickerFragment.Eh(config, qCircleInitBean));
            return qCircleMediaPickerFragment;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/QCircleMediaPickerFragment$b", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "", "onCancelClick", "", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkMediaPickerNextStepDialogPart.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        @NotNull
        public List<LocalMediaInfo> a() {
            return QCircleMediaPickerFragment.this.Wh().getSelectedMedia();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public boolean b() {
            return QCircleMediaPickerFragment.this.Wi().isRunning.get();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public void onCancelClick() {
            QCircleMediaPickerFragment.this.Wi().f();
        }
    }

    public QCircleMediaPickerFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$isQCircleBiz$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(WinkContext.INSTANCE.d().u("QCIRCLE"));
            }
        });
        this.isQCircleBiz = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MediaPickerScene>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$mediaPickerScene$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaPickerScene invoke() {
                Intent intent;
                FragmentActivity activity = QCircleMediaPickerFragment.this.getActivity();
                Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
                MediaPickerScene mediaPickerScene = serializableExtra instanceof MediaPickerScene ? (MediaPickerScene) serializableExtra : null;
                return mediaPickerScene == null ? MediaPickerScene.STANDARD : mediaPickerScene;
            }
        });
        this.mediaPickerScene = lazy2;
        this.normalScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.d()));
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPickerNextStepHelper>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$nextStepHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMediaPickerNextStepHelper invoke() {
                return new WinkMediaPickerNextStepHelper(q.e(QCircleMediaPickerFragment.this));
            }
        });
        this.nextStepHelper = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<p>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$mediaPickerUIStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final p invoke() {
                FragmentActivity requireActivity = QCircleMediaPickerFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return q.a(requireActivity);
            }
        });
        this.mediaPickerUIStateViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$bottomGapView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = QCircleMediaPickerFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.t9q);
                }
                return null;
            }
        });
        this.bottomGapView = lazy5;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:0: B:12:0x001e->B:27:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean Oi(List<? extends LocalMediaInfo> localMediaInfoList) {
        boolean z16;
        boolean z17;
        if (localMediaInfoList.isEmpty()) {
            return false;
        }
        List<? extends LocalMediaInfo> list = localMediaInfoList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String str = ((LocalMediaInfo) it.next()).path;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    w53.b.f("QCircleMediaPickerFragment", "checkMediaFiles path empty");
                } else if (!new File(str).exists()) {
                    w53.b.f("QCircleMediaPickerFragment", "checkMediaFiles File does not exist: " + str);
                } else {
                    z17 = true;
                    if (z17) {
                        return false;
                    }
                }
                z17 = false;
                if (z17) {
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        r0 = r2;
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        r0 = r2;
        r2 = "libTemplate";
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Pi() {
        Serializable serializable;
        HashMap hashMap;
        String str;
        FragmentActivity activity;
        String str2;
        String str3;
        Intent intent;
        FragmentActivity activity2 = getActivity();
        Intent intent2 = null;
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_attrs");
        } else {
            serializable = null;
        }
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        } else {
            hashMap = null;
        }
        String str4 = "";
        if (hashMap != null) {
            String str5 = "template";
            if (hashMap.containsKey("template")) {
                str2 = (String) hashMap.get("template");
            } else if (hashMap.containsKey("libtemplate")) {
                str3 = (String) hashMap.get("libtemplate");
            } else if (hashMap.containsKey("libTemplate")) {
                str3 = (String) hashMap.get("libTemplate");
            } else {
                str5 = "music";
                if (hashMap.containsKey("music")) {
                    str2 = (String) hashMap.get("music");
                } else if (hashMap.containsKey("tag")) {
                    String str6 = (String) hashMap.get("tag");
                    if (str6 != null) {
                        str4 = str6;
                    }
                    String str7 = str4;
                    str4 = "topic";
                    str = str7;
                }
            }
            activity = getActivity();
            if (activity != null) {
                intent2 = activity.getIntent();
            }
            t53.a.a(intent2, str4, str, new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$dc5507Report$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull WinkDc5507ReportData.a dc5507Report) {
                    Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                    dc5507Report.b(1002);
                    dc5507Report.j(1);
                }
            });
        }
        str = "";
        activity = getActivity();
        if (activity != null) {
        }
        t53.a.a(intent2, str4, str, new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$dc5507Report$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull WinkDc5507ReportData.a dc5507Report) {
                Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                dc5507Report.b(1002);
                dc5507Report.j(1);
            }
        });
    }

    private final void Qi(View view, String elementId, String operationType) {
        Map<String, Object> k3 = com.tencent.mobileqq.wink.picker.report.a.k(elementId, Wh().getSelectedMedia(), new LinkedHashMap());
        if (operationType != null) {
            k3.put("xsj_operation_type", operationType);
        }
        k3.put("dt_pgid", "pg_xsj_choose_media_new_page");
        com.tencent.mobileqq.wink.picker.report.a.b(view, elementId, k3, null, true, 8, null);
        if (operationType != null) {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        }
    }

    static /* synthetic */ void Ri(QCircleMediaPickerFragment qCircleMediaPickerFragment, View view, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        qCircleMediaPickerFragment.Qi(view, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Si() {
        return (View) this.bottomGapView.getValue();
    }

    private final MediaPickerScene Ui() {
        return (MediaPickerScene) this.mediaPickerScene.getValue();
    }

    private final p Vi() {
        return (p) this.mediaPickerUIStateViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMediaPickerNextStepHelper Wi() {
        return (WinkMediaPickerNextStepHelper) this.nextStepHelper.getValue();
    }

    private final void Yi() {
        if (Zi()) {
            BuildersKt__Builders_commonKt.launch$default(this.normalScope, null, null, new QCircleMediaPickerFragment$initMemoryAlbum$1(null), 3, null);
        }
    }

    private final boolean Zi() {
        return ((Boolean) this.isQCircleBiz.getValue()).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r4 == 1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void aj(boolean useVideoTemplate, boolean isFromQZoneMedia, List<? extends LocalMediaInfo> selectedMedia) {
        String str;
        String str2;
        String str3;
        Bundle bundle;
        Serializable serializable;
        HashMap hashMap;
        String str4;
        Intent intent;
        int i3;
        boolean z16;
        if (selectedMedia == null) {
            selectedMedia = Wh().getSelectedMedia();
        }
        if (!isFromQZoneMedia && !useVideoTemplate) {
            boolean z17 = false;
            if (selectedMedia.size() <= 1) {
                List<? extends LocalMediaInfo> list = selectedMedia;
                if ((list instanceof Collection) && list.isEmpty()) {
                    i3 = 0;
                } else {
                    Iterator<T> it = list.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        if (((LocalMediaInfo) it.next()).mMediaType == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && (i3 = i3 + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                serializable = intent.getSerializableExtra("key_attrs");
            } else {
                serializable = null;
            }
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                Object obj = hashMap.get("taskid");
                if (obj != null) {
                    str4 = obj.toString();
                } else {
                    str4 = null;
                }
                z17 = Intrinsics.areEqual(str4, "qq_level_h5");
            }
            if (!z17) {
                ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).reportExperimentExport("exp_qqvideo_music_apply_optimize_new");
            }
        }
        if (useVideoTemplate) {
            str = WinkDaTongReportConstant.ElementId.EM_XSJ_AUTO_VIDEO_BUTTON;
        } else {
            str = WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON;
        }
        Map<String, Object> l3 = com.tencent.mobileqq.wink.picker.report.a.l(str, isFromQZoneMedia, selectedMedia);
        l3.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        Intent intent2 = getHostActivity().getIntent();
        if (intent2 != null) {
            str2 = intent2.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE);
        } else {
            str2 = null;
        }
        l3.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, str2);
        Intent intent3 = getHostActivity().getIntent();
        if (intent3 != null) {
            str3 = intent3.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE);
        } else {
            str3 = null;
        }
        l3.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, str3);
        com.tencent.mobileqq.wink.picker.report.a.e(null, "ev_xsj_camera_action", l3);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_MEDIA_IMPORT);
        w53.b.f("QCircleMediaPickerFragment", "performClickNextStep invoke, selectedMedia.size=" + selectedMedia.size() + ", useVideoTemplate=" + useVideoTemplate);
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (companion.d().u("ECOMMERCE")) {
            OutputData.Companion companion2 = OutputData.INSTANCE;
            Intent intent4 = getHostActivity().getIntent();
            if (intent4 != null) {
                bundle = intent4.getExtras();
            } else {
                bundle = null;
            }
            companion.d().m().k(requireActivity(), companion2.b(1L, selectedMedia, null, bundle));
        } else {
            com.tencent.mobileqq.wink.picker.h.f324861a.e(useVideoTemplate, Sh(), selectedMedia, Wh().getNeedFaceDetectWhenSelect());
            final Intent intent5 = new Intent();
            Intent intent6 = getHostActivity().getIntent();
            if (intent6 != null) {
                Intrinsics.checkNotNullExpressionValue(intent6, "intent");
                intent5.putExtras(intent6);
            }
            intent5.putExtra(QQWinkConstants.PICKER_IS_FROM_QCIRCLE_PICKER, true);
            WinkMediaPickerNextStepHelper Wi = Wi();
            Activity hostActivity = getHostActivity();
            Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
            WinkMediaPickerNextStepHelper.i(Wi, hostActivity, Nh().getLocalMediaTabType(), selectedMedia, useVideoTemplate, Ui(), null, new Function1<com.tencent.mobileqq.wink.picker.b, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$jumpToWinkEditor$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.wink.picker.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.mobileqq.wink.picker.b it5) {
                    Intrinsics.checkNotNullParameter(it5, "it");
                    Activity hostActivity2 = QCircleMediaPickerFragment.this.getHostActivity();
                    Intrinsics.checkNotNullExpressionValue(hostActivity2, "hostActivity");
                    com.tencent.mobileqq.wink.picker.g.d(hostActivity2, intent5, it5);
                }
            }, 32, null);
        }
        if (Zi() && ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_optimize_auto_music_2") && Oi(selectedMedia)) {
            bj(selectedMedia);
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$preExtractCover$callback$1] */
    private final void bj(final List<? extends LocalMediaInfo> selectedMedia) {
        Integer num;
        if (selectedMedia != null) {
            num = Integer.valueOf(selectedMedia.size());
        } else {
            num = null;
        }
        w53.b.f("QCircleMediaPickerFragment", "preExtractCover selectedMedia.size=" + num + ", ");
        final ?? r16 = new ExtractCoverHelper.a() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$preExtractCover$callback$1
            @Override // com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper.a
            public void a(@NotNull final ArrayList<byte[]> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i("QCircleMediaPickerFragment", 1, "result " + result.size());
                final Ref.IntRef intRef = new Ref.IntRef();
                final QCircleMediaPickerFragment qCircleMediaPickerFragment = QCircleMediaPickerFragment.this;
                Timer timer = TimersKt.timer(null, false);
                timer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$preExtractCover$callback$1$onFinish$$inlined$timer$default$1
                    /* JADX WARN: Code restructure failed: missing block: B:3:0x001a, code lost:
                    
                        r0 = r3.timer;
                     */
                    @Override // java.util.TimerTask, java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        Timer timer2;
                        SimpleEventBus.getInstance().dispatchEvent(new WinkExtractCoverEvent(result));
                        Ref.IntRef intRef2 = intRef;
                        int i3 = intRef2.element + 1;
                        intRef2.element = i3;
                        if (i3 >= 30 && timer2 != null) {
                            timer2.cancel();
                        }
                    }
                }, 0L, 30L);
                qCircleMediaPickerFragment.timer = timer;
            }
        };
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.k
            @Override // java.lang.Runnable
            public final void run() {
                QCircleMediaPickerFragment.cj(selectedMedia, r16);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cj(List list, QCircleMediaPickerFragment$preExtractCover$callback$1 callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            ExtractCoverHelper.f320276a.s(list, callback);
        }
    }

    private final void dj() {
        Serializable serializable;
        Intent intent;
        if (!Yh()) {
            QLog.d("QCircleMediaPickerFragment", 1, "no storage permission");
            this.schemaJumpInterrupted = true;
            return;
        }
        Activity hostActivity = getHostActivity();
        HashMap hashMap = null;
        if (hostActivity != null && (intent = hostActivity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_attrs");
        } else {
            serializable = null;
        }
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        }
        if (hashMap != null && Intrinsics.areEqual(QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, hashMap.get(QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID))) {
            if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
                QLog.d("QCircleMediaPickerFragment", 1, "camera res not ready");
            } else {
                ki(new WinkQZoneMediaListFragment());
            }
        }
    }

    private final void ej() {
        if (Ph().getAttachToWinkHome() && Vi().O1()) {
            LiveData<e93.a> Z1 = Wh().Z1();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$setBottomGapViewVisibility$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e93.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(e93.a aVar) {
                    View Si;
                    Si = QCircleMediaPickerFragment.this.Si();
                    if (Si == null) {
                        return;
                    }
                    Si.setVisibility(QCircleMediaPickerFragment.this.Wh().getSelectedMedia().isEmpty() ? 0 : 8);
                }
            };
            Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QCircleMediaPickerFragment.fj(Function1.this, obj);
                }
            });
            return;
        }
        View Si = Si();
        if (Si != null) {
            Si.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Map<String, Object> getReportParams() {
        Serializable serializable;
        MetaMaterial metaMaterial;
        String str;
        String str2;
        boolean z16;
        Serializable serializable2;
        Intent intent;
        Intent intent2;
        String stringExtra;
        Intent intent3;
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE));
        FragmentActivity activity = getActivity();
        HashMap hashMap2 = null;
        if (activity != null && (intent3 = activity.getIntent()) != null) {
            serializable = intent3.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE);
        } else {
            serializable = null;
        }
        if (serializable instanceof MetaMaterial) {
            metaMaterial = (MetaMaterial) serializable;
        } else {
            metaMaterial = null;
        }
        String str3 = "";
        if (metaMaterial == null || (str = com.tencent.mobileqq.wink.editor.c.a0(metaMaterial)) == null) {
            str = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, str);
        if (v83.e.f441245a.f()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_AUTHORIZE_MEMORIES_COLLECTION, str2);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent2 = activity2.getIntent()) != null && (stringExtra = intent2.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE)) != null) {
            str3 = stringExtra;
        }
        if (str3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, str3);
            HashMap<String, Object> params = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, str3);
        } else {
            WinkDatongCurrentParams.params.remove(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE);
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null) {
            serializable2 = intent.getSerializableExtra("key_attrs");
        } else {
            serializable2 = null;
        }
        if (serializable2 instanceof HashMap) {
            hashMap2 = (HashMap) serializable2;
        }
        if (hashMap2 != null && hashMap2.containsKey(QCircleScheme.AttrQQPublish.FROM_ENTRANCE)) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, hashMap2.get(QCircleScheme.AttrQQPublish.FROM_ENTRANCE));
        }
        return hashMap;
    }

    private final void gj() {
        getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.i
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                QCircleMediaPickerFragment.hj(QCircleMediaPickerFragment.this);
            }
        });
        Lh().T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QCircleMediaPickerFragment.ij(QCircleMediaPickerFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hj(QCircleMediaPickerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getChildFragmentManager().getBackStackEntryCount() <= 0) {
            this$0.Vi().W1(true);
        } else {
            this$0.Vi().W1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ij(QCircleMediaPickerFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Vi().W1(!bool.booleanValue());
    }

    private final void jj(final boolean isFromTemplateColl) {
        final QQCustomDialog qQCustomDialog = new QQCustomDialog(getContext(), 0);
        Window window = qQCustomDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        qQCustomDialog.setCanceledOnTouchOutside(false);
        View inflate = LayoutInflater.from(qQCustomDialog.getContext()).inflate(R.layout.f168628g43, (ViewGroup) null);
        Option picOption = Option.obtain().setTargetView((ImageView) inflate.findViewById(R.id.xhh)).setUrl("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/9030/publish_popup_img/img_popup_retain.jpg");
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(picOption, "picOption");
        qQPicLoader.e(picOption, null);
        QUIButton qUIButton = (QUIButton) inflate.findViewById(R.id.uxs);
        qUIButton.setTextColor(qUIButton.getContext().getColorStateList(R.color.czz));
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerFragment.kj(QCircleMediaPickerFragment.this, isFromTemplateColl, qQCustomDialog, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(qUIButton, "this");
        Qi(qUIButton, WinkDaTongReportConstant.ElementId.EM_XSJ_RETENTION_PANEL_OPERATE_BUTTON, "exit");
        QUIButton qUIButton2 = (QUIButton) inflate.findViewById(R.id.aoo);
        qUIButton2.setTextColor(qUIButton2.getContext().getColorStateList(R.color.czy));
        qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerFragment.lj(QQCustomDialog.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "this");
        Qi(qUIButton2, WinkDaTongReportConstant.ElementId.EM_XSJ_RETENTION_PANEL_OPERATE_BUTTON, WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_CONTINUE);
        View findViewById = inflate.findViewById(R.id.f164822az1);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerFragment.mj(QQCustomDialog.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "this");
        Qi(findViewById, WinkDaTongReportConstant.ElementId.EM_XSJ_RETENTION_PANEL_OPERATE_BUTTON, "close");
        qQCustomDialog.setContentView(inflate);
        View it = getView();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Ri(this, it, WinkDaTongReportConstant.ElementId.EM_XSJ_RETENTION_PANEL, null, 4, null);
        }
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kj(QCircleMediaPickerFragment this$0, boolean z16, QQCustomDialog this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        w53.b.f(this$0.getLogTag(), "exit dialog confirm");
        com.tencent.mobileqq.wink.picker.report.a.s(this$0.getView(), z16);
        this$0.gi();
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lj(QQCustomDialog this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mj(QQCustomDialog this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public Config Fh(@NotNull Config config) {
        Config copy;
        Intrinsics.checkNotNullParameter(config, "config");
        copy = config.copy((r34 & 1) != 0 ? config.localMediaTabType : null, (r34 & 2) != 0 ? config.initLocalMediaTab : null, (r34 & 4) != 0 ? config.initLocalDbQueryType : null, (r34 & 8) != 0 ? config.ZoneMediaTabType : null, (r34 & 16) != 0 ? config.needDragSelect : false, (r34 & 32) != 0 ? config.needScrollTimeline : false, (r34 & 64) != 0 ? config.maxSelectMediaSize : 0, (r34 & 128) != 0 ? config.startCountNum : 0, (r34 & 256) != 0 ? config.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? config.alreadySelectedMedia : null, (r34 & 1024) != 0 ? config.queryMediaFilter : null, (r34 & 2048) != 0 ? config.selectMediaFilter : c.f324971a.c(), (r34 & 4096) != 0 ? config.needShowExitDialog : false, (r34 & 8192) != 0 ? config.firstIconCamera : false, (r34 & 16384) != 0 ? config.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
        return copy;
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(@NotNull FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pagerCallback = callback;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.QVideo;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    /* renamed from: Ti, reason: merged with bridge method [inline-methods] */
    public QCircleInitBean Oh() {
        return new QCircleInitBean(false, false, null, 7, null);
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void X9(@NotNull String str, boolean z16) {
        FragmentPager.d.a.a(this, str, z16);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    /* renamed from: Xi, reason: merged with bridge method [inline-methods] */
    public QCircleMediaPickerFactory Zh() {
        return new QCircleMediaPickerFactory(Ph());
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.f324959h0.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        boolean z16 = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        assembleParts.add(new WinkMediaPickerNextStepDialogPart(new b(), z16, 2, defaultConstructorMarker));
        if (Zi()) {
            assembleParts.add(new QCircleMediaPickerTopBannerPart(z16, 1, defaultConstructorMarker));
            if (com.tencent.mobileqq.wink.picker.core.c.f324480a.c()) {
                assembleParts.add(new QCircleMediaPickerTipsPart());
                assembleParts.add(new QCircleMediaPickerTitleBarActionPart());
                assembleParts.add(new QCircleMediaPickerPublishTagGuidePart());
                assembleParts.add(new com.tencent.mobileqq.wink.picker.qcircle.part.a());
            }
        }
        return assembleParts;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        boolean z16;
        w53.b.f("QCircleMediaPickerFragment", "onNextBtnClick isFromQZoneMedia: " + isFromQZoneMedia);
        if (!Wi().isRunning.get()) {
            if (Ui() == MediaPickerScene.STANDARD_VIDEO_TEMPLATE) {
                z16 = true;
            } else {
                z16 = false;
            }
            aj(z16, isFromQZoneMedia, selectedMedia);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void fi() {
        super.fi();
        if (this.schemaJumpInterrupted) {
            dj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        if (com.tencent.mobileqq.wink.picker.core.c.f324480a.c()) {
            return R.layout.g46;
        }
        return R.layout.f168630g45;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleOpenQzoneAlbumPageEvent.class);
        arrayList.add(WinkExtractCoverReceiverEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    public String getLogTag() {
        return "QCircleMediaPickerFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void hi(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        w53.b.f("QCircleMediaPickerFragment", "onVideoTemplateClick isFromQZoneMedia: " + isFromQZoneMedia);
        if (!Wi().isRunning.get()) {
            aj(true, isFromQZoneMedia, selectedMedia);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    protected void oi(boolean isFromTemplateColl) {
        jj(isFromTemplateColl);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
        FragmentActivity activity = getActivity();
        boolean z16 = false;
        if (activity != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) activity.getClass().getName(), (CharSequence) "QQWinkIndexActivity", false, 2, (Object) null);
            if (contains$default) {
                z16 = true;
            }
        }
        cVar.k(z16);
        Yi();
        dj();
        Vi().T1(Wh().Z1());
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        try {
            return super.onBackEvent();
        } catch (Exception e16) {
            w53.b.e("QCircleMediaPickerFragment", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        boolean z16;
        WinkPerformanceHelper.Companion companion = WinkPerformanceHelper.INSTANCE;
        companion.a().i(MediaType.LOCAL_ALL.ordinal(), Yh());
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isFromSave = z16;
        Intent intent = getHostActivity().getIntent();
        companion.a().h(intent.getBooleanExtra("key_qcircle_is_peak_alive_when_entry", false), intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID));
        companion.a().d();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Wi().p();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        WinkPerformanceHelper.INSTANCE.a().e("QCircleMediaPickerFragment");
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WinkPerformanceHelper.INSTANCE.a().f();
        ApngImage.pauseAll();
        SimpleEventBus.getInstance().dispatchEvent(new WinkFirstVideoDialogEvent(2));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QCircleOpenQzoneAlbumPageEvent) {
            HashMap<String, Object> params = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_qzone_entrance_source", 2);
            ki(new WinkQZoneMediaListFragment());
            return;
        }
        if (event instanceof WinkExtractCoverReceiverEvent) {
            w53.b.f("QCircleMediaPickerFragment", "onReceiveEvent WinkExtractCoverReceiverEvent");
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WinkPerformanceHelper a16 = WinkPerformanceHelper.INSTANCE.a();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        a16.g(requireContext);
        ApngImage.resumeAll();
        SimpleEventBus.getInstance().dispatchEvent(new WinkFirstVideoDialogEvent(1));
        Pi();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        int i3;
        LiveData<String> isFirstFetchDoneLiveData;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ej();
        gj();
        FragmentActivity requireActivity = requireActivity();
        if (Ph().getAttachToWinkHome()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.tencent.mobileqq.wink.picker.report.a.o(view, requireActivity, "pg_xsj_choose_media_new_page", false, null, i3, c.f324971a.b(this).getHasBanner(), false, getReportParams(), 128, null);
        final WinkInitManager a16 = WinkInitManager.INSTANCE.a();
        a16.e(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$onViewCreated$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    QCircleMediaPickerFragment.this.Wi().q(z16);
                    ExtractCoverHelper.f320276a.N(z16);
                    a16.c();
                }
            }
        });
        WinkLocalMediaViewModel localMediaViewModel = getLocalMediaViewModel();
        if (localMediaViewModel != null && (isFirstFetchDoneLiveData = localMediaViewModel.isFirstFetchDoneLiveData()) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$onViewCreated$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    FragmentPager.b bVar;
                    bVar = QCircleMediaPickerFragment.this.pagerCallback;
                    if (bVar != null) {
                        bVar.c();
                    }
                }
            };
            isFirstFetchDoneLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QCircleMediaPickerFragment.onViewCreated$lambda$2(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }
}
