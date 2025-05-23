package com.tencent.tavcut.render.builder.light;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.model.TextPlaceInfo;
import com.tencent.tavcut.rendermodel.CustomRenderConfig;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavcut.session.f;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.ClipAsset;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieConfig;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TextPlaceHolder;
import org.light.TimeLine;
import org.light.TimeRange;
import org.light.VideoOutputConfig;
import org.light.listener.OnLoadAssetListener;
import org.light.utils.LightLogUtil;
import tl.h;
import zd4.a;
import zd4.b;
import zd4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0000\u0018\u0000 )2\u00020\u0001:\u0002=#B\t\u00a2\u0006\u0006\b\u00a2\u0001\u0010\u00a3\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0016\u0010\u0011\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ \u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0016J\u0006\u0010$\u001a\u00020\tJ%\u0010)\u001a\u00020\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\b\b\u0002\u0010(\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010,\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u0002J&\u00102\u001a\u00020\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u00100\u001a\u0004\u0018\u00010\u00142\u0006\u00101\u001a\u00020\u001bJ&\u00103\u001a\u00020\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u00100\u001a\u0004\u0018\u00010\u00142\u0006\u00101\u001a\u00020\u001bJ\u0018\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00122\u0006\u00106\u001a\u000205H\u0016J \u0010<\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u00122\u0006\u0010;\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\t2\u0006\u0010?\u001a\u00020>H\u0016J\u0010\u0010B\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u000fH\u0016J(\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u00120Dj\b\u0012\u0004\u0012\u00020\u0012`E2\u0006\u0010\u0018\u001a\u00020C2\u0006\u0010$\u001a\u00020CH\u0016J\u001a\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010\u0018\u001a\u00020C2\u0006\u0010$\u001a\u00020CH\u0016J\u0018\u0010I\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010-2\u0006\u00104\u001a\u00020\u0012H\u0016J\u0018\u0010L\u001a\u00020\t2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010-H\u0016J\u0012\u0010O\u001a\u00020\t2\b\u0010N\u001a\u0004\u0018\u00010MH\u0016J0\u0010S\u001a\u00020\t2&\u0010R\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010Pj\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001`QH\u0016J4\u0010T\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00142\"\u0010R\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140Pj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`QH\u0016J0\u0010U\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010Pj\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001`Q2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010X\u001a\u00020\t2\u0006\u0010W\u001a\u00020VH\u0016J\u0010\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0002H\u0016J\"\u0010]\u001a\u00020\t2\u0018\u0010\\\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0[H\u0016J\"\u0010`\u001a\u00020\t2\u0018\u0010\\\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0-\u0012\u0004\u0012\u00020\t0^H\u0016J\b\u0010a\u001a\u00020\u0002H\u0016J \u0010b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0002H\u0016J\b\u0010c\u001a\u00020\tH\u0016J\u0010\u0010d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010g\u001a\u00020\t2\u0006\u0010f\u001a\u00020eH\u0016J\u0012\u0010j\u001a\u00020\t2\b\u0010i\u001a\u0004\u0018\u00010hH\u0016R\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010rR$\u0010z\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010|R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010\u007fR\u0017\u0010\u0083\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b@\u0010\u0082\u0001R\u001b\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bb\u0010\u0085\u0001R\u0019\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\"\u0010\u0087\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R\u0019\u0010\u008e\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u0089\u0001R\u001f\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R:\u0010\u0097\u0001\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0-\u0012\u0004\u0012\u00020\t0^8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u000b\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R:\u0010\u009d\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0013\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b,\u0010\u009e\u0001R\u001c\u0010\u00a0\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0006\u0010\u009f\u0001R\u001c\u0010\u00a1\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0005\u0010\u009f\u0001\u00a8\u0006\u00a4\u0001"}, d2 = {"Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager;", "Lzd4/b;", "", "duration", "Lcom/tencent/tavkit/composition/TAVClip;", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lzd4/a;", "effectDispatcher", "", "G", DomainData.DOMAIN_NAME, "B", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Queue;", "Ljava/lang/Runnable;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "o", "", "templatePath", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", HippyTKDListViewAdapter.X, "w", "seekTolerance", "", "isUE4Template", "v", "templateDir", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/tavcut/session/b;", "callback", "i", "b", "y", "", "Lorg/light/TimeLine;", "timelines", "targetTime", "t", "([Lorg/light/TimeLine;J)V", "Lcom/tencent/tavkit/composition/TAVComposition;", "p", "", "Lorg/light/ClipAsset;", "clipAssets", "backgroundPagPath", "modifyClipsDuration", "D", "E", TemplateParser.KEY_ENTITY_ID, "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", HippyQQConstants.URL_COMPONENT_NAME, "c", "parentId", "childIndex", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "e", "a", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "g", "runnable", "runOnAfterApply", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getEntitiesUnderPoint", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "getEditableTextUnderPoint", "getEditableTextByEntityId", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", DownloadInfo.spKey_Config, "setVoiceChangerConfig", "Lcom/tencent/tav/coremedia/CMTimeRange;", "renderTimeRange", "setRenderTimeRange", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "setAssetData", "addAssetDataToHolder", "getCurrentAssetData", "Lfe4/a;", "effectNode", "d", "durationUs", "f", "Lkotlin/Function2;", "observer", "registerDurationObserver", "Lkotlin/Function1;", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "registerTimelineObserver", "getMovieControllerDuration", h.F, "release", "setRenderNodeDuration", "Lorg/light/listener/OnLoadAssetListener;", "listener", "setLoadAssetListener", "Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;", "customRenderConfig", UserInfo.SEX_FEMALE, "Lorg/light/LightEngine;", "Lorg/light/LightEngine;", "lightEngine", "Lorg/light/LightAsset;", "Lorg/light/LightAsset;", "lightAsset", "Lorg/light/MovieConfig;", "Lorg/light/MovieConfig;", "movieConfig", "Lorg/light/MovieController;", "Lorg/light/MovieController;", ReportConstant.COSTREPORT_PREFIX, "()Lorg/light/MovieController;", "setMovieController", "(Lorg/light/MovieController;)V", "movieController", "Lfe4/c;", "Lfe4/c;", "lightRenderNode", "Lge4/a;", "Lge4/a;", "lightAudioNode", "Lcom/tencent/tavcut/render/builder/light/d;", "Lcom/tencent/tavcut/render/builder/light/d;", "voiceChangerWrapper", "Lzd4/d;", "Lzd4/d;", "assetDataHolder", "Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;", "j", "J", "playerDuration", "k", "movieControllerDuration", "l", "clipAssetsDuration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "curClipAssets", "Lkotlin/jvm/functions/Function1;", "getTimelineObserver", "()Lkotlin/jvm/functions/Function1;", "setTimelineObserver", "(Lkotlin/jvm/functions/Function1;)V", "timelineObserver", "Lkotlin/jvm/functions/Function2;", "getDurationObserver", "()Lkotlin/jvm/functions/Function2;", "setDurationObserver", "(Lkotlin/jvm/functions/Function2;)V", "durationObserver", "Lzd4/a;", "Ljava/util/Queue;", "afterEventQueue", "beforeEventQueue", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class LightRenderChainManager implements zd4.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private LightEngine lightEngine;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LightAsset lightAsset;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private MovieConfig movieConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MovieController movieController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private fe4.c lightRenderNode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ge4.a lightAudioNode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private zd4.d assetDataHolder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CustomRenderConfig customRenderConfig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long playerDuration;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long movieControllerDuration;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long clipAssetsDuration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<? extends ClipAsset> curClipAssets;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private zd4.a effectDispatcher;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private static final CopyOnWriteArraySet<MovieController> f374354s = new CopyOnWriteArraySet<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final d voiceChangerWrapper = new d();

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super List<Timeline>, Unit> timelineObserver = new Function1<List<? extends Timeline>, Unit>() { // from class: com.tencent.tavcut.render.builder.light.LightRenderChainManager$timelineObserver$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<Timeline> it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Timeline> list) {
            invoke2((List<Timeline>) list);
            return Unit.INSTANCE;
        }
    };

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function2<? super Long, ? super Long, Unit> durationObserver = new Function2<Long, Long, Unit>() { // from class: com.tencent.tavcut.render.builder.light.LightRenderChainManager$durationObserver$1
        public final void invoke(long j3, long j16) {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l3, Long l16) {
            invoke(l3.longValue(), l16.longValue());
            return Unit.INSTANCE;
        }
    };

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Queue<Runnable> afterEventQueue = new LinkedList();

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Queue<Runnable> beforeEventQueue = new LinkedList();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002R&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager$a;", "", "Lorg/light/TextPlaceHolder;", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "b", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lorg/light/MovieController;", "voiceProcessorRef", "Ljava/util/concurrent/CopyOnWriteArraySet;", "c", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "voiceProcessorRef$annotations", "()V", "", "AUDIO_CHANNEL_MONO", "I", "AUDIO_SAMPLE_RATE_IN_HZ", "", "DEFAULT_FRAME_RATE", UserInfo.SEX_FEMALE, "", "LIGHT_VIDEO_SOURCE_TYPE", "Ljava/lang/String;", "SAMPLE_COUNT", "TAG", "<init>", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.tavcut.render.builder.light.LightRenderChainManager$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextPlaceInfo b(@NotNull TextPlaceHolder textPlaceHolder) {
            return new TextPlaceInfo.Builder().entityId(textPlaceHolder.entityId).fillColor(textPlaceHolder.fillColor).key(textPlaceHolder.key).text(textPlaceHolder.text).maxLength(textPlaceHolder.maxLength).layerWidth(textPlaceHolder.layerWidth).layerHeight(textPlaceHolder.layerHeight).replaceIndex(textPlaceHolder.replaceIndex).build();
        }

        @NotNull
        public final CopyOnWriteArraySet<MovieController> c() {
            return LightRenderChainManager.f374354s;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager$b;", "Lzd4/a$c;", "", "onBeforeApply", "onAfterApply", "releaseAfterAllNode", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "getReference", "()Ljava/lang/ref/WeakReference;", "reference", "renderManager", "<init>", "(Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class b implements a.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<LightRenderChainManager> reference;

        public b(@NotNull LightRenderChainManager renderManager) {
            Intrinsics.checkParameterIsNotNull(renderManager, "renderManager");
            this.reference = new WeakReference<>(renderManager);
        }

        @Override // zd4.a.c
        public void onAfterApply() {
            LightRenderChainManager lightRenderChainManager = this.reference.get();
            if (lightRenderChainManager != null) {
                lightRenderChainManager.B();
            }
        }

        @Override // zd4.a.c
        public void onBeforeApply() {
            LightRenderChainManager lightRenderChainManager = this.reference.get();
            if (lightRenderChainManager != null) {
                lightRenderChainManager.C();
            }
        }

        @Override // zd4.a.c
        public void releaseAfterAllNode() {
            LightRenderChainManager lightRenderChainManager = this.reference.get();
            if (lightRenderChainManager != null) {
                lightRenderChainManager.n();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/tavcut/render/builder/light/LightRenderChainManager$c", "Lcom/tencent/tavcut/session/f;", "", "lightContextReady", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class c implements f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f374376b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RenderModel f374377c;

        c(String str, RenderModel renderModel) {
            this.f374376b = str;
            this.f374377c = renderModel;
        }

        @Override // com.tencent.tavcut.session.f
        public void lightContextReady() {
            b.a.a(LightRenderChainManager.this, this.f374376b, this.f374377c, 0L, 4, null);
        }
    }

    public LightRenderChainManager() {
        boolean z16;
        if (e.f452395c.a().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (com.tencent.tavcut.render.builder.light.c.f374382c.b()) {
                LightLogUtil.init();
                LightLogUtil.setMinPriority(ee4.b.f396211c.d());
                de4.a.f393661b.a();
                return;
            }
            throw new IllegalStateException("so still not install, please load V8Jni and lightsdk so first");
        }
        throw new IllegalStateException("light_assets still not install, Use TavCut must install light_assets first !!!!");
    }

    private final void A(Queue<Runnable> queue) {
        if (queue.isEmpty()) {
            return;
        }
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        A(this.afterEventQueue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        A(this.beforeEventQueue);
    }

    private final void G(zd4.a effectDispatcher) {
        this.effectDispatcher = effectDispatcher;
        effectDispatcher.b(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        ee4.b.a("LightRenderChainManager", "afterAllNodeRelease");
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.resetAsset();
        }
        this.voiceChangerWrapper.a(this.movieController);
        this.movieController = null;
        LightEngine lightEngine = this.lightEngine;
        if (lightEngine != null) {
            lightEngine.release();
        }
        this.lightEngine = null;
        this.lightAsset = null;
        zd4.a aVar = this.effectDispatcher;
        if (aVar != null) {
            aVar.b(null);
        }
        this.effectDispatcher = null;
    }

    private final TAVClip q(long duration) {
        List<TAVAudioProcessorNode> listOf;
        TAVClip tAVClip = new TAVClip(new TAVEmptyResource(ie4.a.f407564a.a(duration)));
        TAVAudioConfiguration tAVAudioConfiguration = new TAVAudioConfiguration();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.lightAudioNode);
        tAVAudioConfiguration.setAudioProcessorNodes(listOf);
        tAVClip.setAudioConfiguration(tAVAudioConfiguration);
        return tAVClip;
    }

    private final TAVClip r(long duration) {
        return new TAVClip(new TAVEmptyResource(ie4.a.f407564a.a(duration)));
    }

    public static /* synthetic */ void u(LightRenderChainManager lightRenderChainManager, TimeLine[] timeLineArr, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        lightRenderChainManager.t(timeLineArr, j3);
    }

    public final void D(@NotNull List<? extends ClipAsset> clipAssets, @Nullable String backgroundPagPath, boolean modifyClipsDuration) {
        Intrinsics.checkParameterIsNotNull(clipAssets, "clipAssets");
        this.curClipAssets = clipAssets;
        ee4.b.b("LightRenderChainManager", "setClipAssets clipAssets size: " + clipAssets.size());
        Iterator<T> it = clipAssets.iterator();
        while (it.hasNext()) {
            ee4.b.b("LightRenderChainManager", "setClipAssets clipAsset duration: " + ((ClipAsset) it.next()).duration);
        }
        MovieController movieController = this.movieController;
        if (movieController != null) {
            Object[] array = clipAssets.toArray(new ClipAsset[0]);
            if (array != null) {
                movieController.setClipAssets((ClipAsset[]) array, backgroundPagPath, modifyClipsDuration);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public final void E(@NotNull List<? extends ClipAsset> clipAssets, @Nullable String backgroundPagPath, boolean modifyClipsDuration) {
        TimeLine[] timeLineArr;
        Intrinsics.checkParameterIsNotNull(clipAssets, "clipAssets");
        ee4.b.a("LightRenderChainManager", "setClipAssetsWithCallback clipAssets size: " + clipAssets.size());
        Iterator<T> it = clipAssets.iterator();
        while (it.hasNext()) {
            ee4.b.a("LightRenderChainManager", "setClipAssetsWithCallback clipAsset duration: " + ((ClipAsset) it.next()).duration);
        }
        D(clipAssets, backgroundPagPath, modifyClipsDuration);
        MovieController movieController = this.movieController;
        if (movieController == null || (timeLineArr = movieController.getTimeLines()) == null) {
            timeLineArr = new TimeLine[0];
        }
        u(this, timeLineArr, 0L, 2, null);
        this.timelineObserver.invoke(a.b(timeLineArr));
    }

    public void F(@Nullable CustomRenderConfig customRenderConfig) {
        this.customRenderConfig = customRenderConfig;
    }

    @Override // zd4.b
    public void a(int entityId) {
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.removeEntity(entityId);
        }
    }

    @Override // zd4.b
    public void addAssetDataToHolder(@NotNull String templateDir, @NotNull HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(assetData, "assetData");
        if (this.assetDataHolder == null) {
            this.assetDataHolder = new zd4.d();
        }
        zd4.d dVar = this.assetDataHolder;
        if (dVar != null) {
            dVar.c(templateDir, assetData);
        }
    }

    @Override // zd4.b
    public void b(@NotNull com.tencent.tavcut.session.b callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        fe4.c cVar = this.lightRenderNode;
        if (cVar != null) {
            cVar.g(callback);
        }
    }

    @Override // zd4.b
    public void c(int entityId, @NotNull IdentifyComponent component) {
        boolean z16;
        MovieController movieController;
        Intrinsics.checkParameterIsNotNull(component, "component");
        String dumpJson = TemplateParser.INSTANCE.dumpJson(component);
        if (dumpJson.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (movieController = this.movieController) != null) {
            movieController.updateComponent(entityId, dumpJson);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zd4.b
    public void d(@NotNull fe4.a effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        fe4.d.f398411c.a(effectNode.getClass());
        zd4.a aVar = this.effectDispatcher;
        if (aVar != null) {
            aVar.a(effectNode);
        }
    }

    @Override // zd4.b
    public void e(int parentId, int childIndex, @NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.addEntity(parentId, childIndex, TemplateParser.INSTANCE.dumpJson(entity));
        }
    }

    @Override // zd4.b
    public void f(long durationUs) {
        long max = Math.max(durationUs, this.clipAssetsDuration);
        if (max == this.playerDuration) {
            return;
        }
        this.playerDuration = max;
        this.durationObserver.invoke(Long.valueOf(max), -1L);
    }

    @Override // zd4.b
    public void g(@NotNull InputSource inputSource) {
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        String dumpInputSource = TemplateParser.INSTANCE.dumpInputSource(inputSource);
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.updateResource(dumpInputSource);
        }
    }

    @Override // zd4.b
    @Nullable
    public HashMap<String, String> getCurrentAssetData(@NotNull String templateDir) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        zd4.d dVar = this.assetDataHolder;
        if (dVar != null) {
            return dVar.b(templateDir);
        }
        return null;
    }

    @Override // zd4.b
    @Nullable
    public List<TextPlaceInfo> getEditableTextByEntityId(int entityId) {
        TextPlaceHolder[] textPlaceHolderArr;
        MovieController movieController = this.movieController;
        ArrayList arrayList = null;
        if (movieController != null) {
            textPlaceHolderArr = movieController.getTextPlaceHolderByEntityId(entityId);
        } else {
            textPlaceHolderArr = null;
        }
        if (textPlaceHolderArr != null) {
            arrayList = new ArrayList(textPlaceHolderArr.length);
            for (TextPlaceHolder it : textPlaceHolderArr) {
                Companion companion = INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                arrayList.add(companion.b(it));
            }
        }
        return arrayList;
    }

    @Override // zd4.b
    @Nullable
    public TextPlaceInfo getEditableTextUnderPoint(float x16, float y16) {
        TextPlaceHolder textPlaceHolder;
        MovieController movieController = this.movieController;
        if (movieController != null) {
            textPlaceHolder = movieController.getEditableTextUnderPoint(x16, y16);
        } else {
            textPlaceHolder = null;
        }
        if (textPlaceHolder != null) {
            return INSTANCE.b(textPlaceHolder);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        r2 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r2);
     */
    @Override // zd4.b
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16) {
        List emptyList;
        MovieController movieController = this.movieController;
        if (movieController == null || (r2 = movieController.getEntitiesUnderPoint(x16, y16)) == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArrayList<>(emptyList);
    }

    @Override // zd4.b
    public long getMovieControllerDuration() {
        return this.movieControllerDuration;
    }

    @Override // zd4.b
    public void h(@NotNull String templateDir, @NotNull RenderModel renderModel, long targetTime) {
        MovieController movieController;
        TimeLine[] timeLineArr;
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        x(templateDir, renderModel);
        CopyOnWriteArraySet<MovieController> copyOnWriteArraySet = f374354s;
        copyOnWriteArraySet.remove(this.movieController);
        zd4.c cVar = zd4.c.f452391c;
        cVar.b(this.movieConfig);
        LightEngine lightEngine = this.lightEngine;
        HashMap<String, String> hashMap = null;
        if (lightEngine != null) {
            movieController = lightEngine.setAssetForMovie(this.lightAsset);
        } else {
            movieController = null;
        }
        this.movieController = movieController;
        zd4.d dVar = this.assetDataHolder;
        if (dVar != null) {
            hashMap = dVar.b(templateDir);
        }
        setAssetData(hashMap);
        copyOnWriteArraySet.add(this.movieController);
        D(a.a(renderModel.getClipsAssets()), renderModel.getPainting().pagPath, renderModel.getModifyClipsDuration());
        MovieController movieController2 = this.movieController;
        if (movieController2 == null || (timeLineArr = movieController2.getTimeLines()) == null) {
            timeLineArr = new TimeLine[0];
        }
        t(timeLineArr, targetTime);
        cVar.c(this.movieConfig);
        this.timelineObserver.invoke(a.b(timeLineArr));
    }

    @Override // zd4.b
    public void i(@NotNull com.tencent.tavcut.session.b callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        fe4.c cVar = this.lightRenderNode;
        if (cVar != null) {
            cVar.f(callback);
        }
    }

    public final int o() {
        com.tencent.tavcut.render.builder.light.c cVar = com.tencent.tavcut.render.builder.light.c.f374382c;
        od4.b bVar = od4.b.f422509e;
        return cVar.a(bVar.o(), bVar.r(), bVar.l(), bVar.k());
    }

    @NotNull
    public final TAVComposition p(long duration) {
        List listOf;
        List listOf2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(r(duration));
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(q(duration));
        TAVComposition tAVComposition = new TAVComposition(listOf, listOf2);
        zd4.a aVar = new zd4.a();
        tAVComposition.setVideoMixEffect(aVar);
        fe4.c cVar = this.lightRenderNode;
        if (cVar == null) {
            Intrinsics.throwNpe();
        }
        aVar.a(cVar);
        G(aVar);
        return tAVComposition;
    }

    @Override // zd4.b
    public void registerDurationObserver(@NotNull Function2<? super Long, ? super Long, Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        this.durationObserver = observer;
    }

    @Override // zd4.b
    public void registerTimelineObserver(@NotNull Function1<? super List<Timeline>, Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        this.timelineObserver = observer;
    }

    @Override // zd4.b
    public void release() {
        fe4.c cVar = this.lightRenderNode;
        if (cVar != null) {
            cVar.d();
        }
        this.lightRenderNode = null;
        de4.a.f393661b.a();
        zd4.d dVar = this.assetDataHolder;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // zd4.b
    public void runOnAfterApply(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        synchronized (this.afterEventQueue) {
            this.afterEventQueue.add(runnable);
        }
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final MovieController getMovieController() {
        return this.movieController;
    }

    @Override // zd4.b
    public void setAssetData(@Nullable HashMap<String, String> assetData) {
        MovieController movieController = this.movieController;
        if (movieController != null) {
            movieController.setAssetData(assetData);
        }
    }

    @Override // zd4.b
    public void setLoadAssetListener(@NotNull OnLoadAssetListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        MovieConfig movieConfig = this.movieConfig;
        if (movieConfig == null) {
            ee4.b.b("LightRenderChainManager", "setLoadAssetListener when movieConfig is null.");
        } else if (movieConfig != null) {
            movieConfig.setLoadAssetListener(listener);
        }
    }

    @Override // zd4.b
    public void setRenderNodeDuration(long duration) {
        fe4.c cVar = this.lightRenderNode;
        if (cVar != null) {
            cVar.h(duration);
        }
    }

    @Override // zd4.b
    public void setRenderTimeRange(@Nullable CMTimeRange renderTimeRange) {
        zd4.a aVar = this.effectDispatcher;
        if (aVar != null) {
            aVar.c(renderTimeRange);
        }
    }

    @Override // zd4.b
    public void setVoiceChangerConfig(@Nullable List<? extends VoiceEnum> config) {
        this.voiceChangerWrapper.f(this.movieController, config);
    }

    public final void t(@NotNull TimeLine[] timelines, long targetTime) {
        long j3;
        Long valueOf;
        int lastIndex;
        Intrinsics.checkParameterIsNotNull(timelines, "timelines");
        MovieController movieController = this.movieController;
        long j16 = 0;
        if (movieController != null) {
            j3 = movieController.duration();
        } else {
            j3 = 0;
        }
        this.movieControllerDuration = j3;
        ArrayList arrayList = new ArrayList();
        for (TimeLine timeLine : timelines) {
            if (Intrinsics.areEqual(timeLine.type, "VideoSource")) {
                arrayList.add(timeLine);
            }
        }
        if (arrayList.isEmpty()) {
            valueOf = null;
        } else {
            TimeRange timeRange = ((TimeLine) arrayList.get(0)).range;
            valueOf = Long.valueOf(timeRange.startTime + timeRange.duration);
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    TimeRange timeRange2 = ((TimeLine) arrayList.get(i3)).range;
                    Long valueOf2 = Long.valueOf(timeRange2.startTime + timeRange2.duration);
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        Long l3 = valueOf;
        if (l3 != null) {
            j16 = l3.longValue();
        }
        this.clipAssetsDuration = j16;
        long j17 = this.movieControllerDuration;
        this.playerDuration = j17;
        this.durationObserver.invoke(Long.valueOf(j17), Long.valueOf(targetTime));
    }

    public final void v(@NotNull String templatePath, int seekTolerance, boolean isUE4Template) {
        MovieController assetForMovie;
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        VideoOutputConfig videoOutputConfig = new VideoOutputConfig(30.0f, seekTolerance);
        AudioOutputConfig audioOutputConfig = new AudioOutputConfig();
        audioOutputConfig.sampleRate = 44100;
        audioOutputConfig.sampleCount = com.tencent.tavcut.core.render.builder.light.LightRenderChainManager.AUDIO_SAMPLE_COUNT;
        boolean z16 = true;
        audioOutputConfig.channels = 1;
        RendererConfig rendererConfig = new RendererConfig(e.f452395c.a());
        if (ee4.b.f396211c.d() > 3) {
            z16 = false;
        }
        rendererConfig.enablePerfReport = z16;
        CustomRenderConfig customRenderConfig = this.customRenderConfig;
        if (customRenderConfig != null) {
            rendererConfig.enableFastSoftDecode = customRenderConfig.getEnableFastSoftDecode();
            if (customRenderConfig.getSoftDecodeThreadCount() > 0) {
                rendererConfig.softDecodeThreadCount = customRenderConfig.getSoftDecodeThreadCount();
            }
        }
        LightEngine make = LightEngine.make(videoOutputConfig, audioOutputConfig, rendererConfig);
        if (make != null) {
            this.lightEngine = make;
            MovieConfig make2 = MovieConfig.make();
            this.movieConfig = make2;
            LightEngine lightEngine = this.lightEngine;
            if (lightEngine != null) {
                lightEngine.setConfig(make2);
            }
            zd4.c cVar = zd4.c.f452391c;
            MovieConfig movieConfig = this.movieConfig;
            if (movieConfig == null) {
                Intrinsics.throwNpe();
            }
            cVar.d(movieConfig);
            cVar.b(this.movieConfig);
            HashMap<String, String> hashMap = null;
            if (!isUE4Template) {
                LightEngine lightEngine2 = this.lightEngine;
                if (lightEngine2 != null) {
                    assetForMovie = lightEngine2.setAssetForMovie(this.lightAsset);
                }
                assetForMovie = null;
            } else {
                w(templatePath);
                LightEngine lightEngine3 = this.lightEngine;
                if (lightEngine3 != null) {
                    assetForMovie = lightEngine3.setAssetForMovie(this.lightAsset);
                }
                assetForMovie = null;
            }
            this.movieController = assetForMovie;
            zd4.d dVar = this.assetDataHolder;
            if (dVar != null) {
                hashMap = dVar.b(templatePath);
            }
            setAssetData(hashMap);
            return;
        }
        throw new IllegalStateException("make lightEngine failed ");
    }

    public final void w(@NotNull String templatePath) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        ee4.b.b("LightRenderChainManager", "templatePath: " + templatePath + " default");
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null) {
            lightAsset.performFinalize();
        }
        LightAsset LoadFromString = LightAsset.LoadFromString(templatePath, od4.b.f422509e.v(), 0);
        if (LoadFromString != null) {
            this.lightAsset = LoadFromString;
            return;
        }
        throw new IllegalStateException("load lightAsset failed");
    }

    public final void x(@NotNull String templatePath, @NotNull RenderModel renderModel) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        ee4.b.b("LightRenderChainManager", "templatePath: " + templatePath);
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null) {
            lightAsset.performFinalize();
        }
        LightAsset LoadFromString = LightAsset.LoadFromString(templatePath, TemplateParser.INSTANCE.dumpJson(renderModel), 0);
        if (LoadFromString != null) {
            this.lightAsset = LoadFromString;
            return;
        }
        throw new IllegalStateException("load lightAsset failed");
    }

    public final void y() {
        LightEngine lightEngine = this.lightEngine;
        if (lightEngine != null) {
            this.lightAudioNode = new ge4.a(lightEngine);
        }
    }

    public final void z(@NotNull String templateDir, @NotNull RenderModel renderModel, boolean isUE4Template) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        this.lightRenderNode = new fe4.c(this.lightEngine, this.movieConfig, new c(templateDir, renderModel), isUE4Template);
    }
}
