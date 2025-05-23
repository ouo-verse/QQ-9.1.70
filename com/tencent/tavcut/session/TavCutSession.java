package com.tencent.tavcut.session;

import androidx.exifinterface.media.ExifInterface;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.FilterGroup;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.core.session.LAKTavCutSessionKt;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.model.TextPlaceInfo;
import com.tencent.tavcut.operator.ClipSourceOperator;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.render.builder.light.LightRenderChainManager;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.CustomRenderConfig;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavcut.session.TavCutSession;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipAsset;
import org.light.ClipInfo;
import org.light.MovieController;
import org.light.TimeRange;
import org.light.listener.OnLoadAssetListener;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002F;B\t\u00a2\u0006\u0006\b\u00a0\u0001\u0010\u00a1\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002JB\u0010 \u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00072\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0016\u0010\"\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050!H\u0002J\u0018\u0010#\u001a\u00020\u00052\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050!H\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0012\u0010)\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0016J\n\u0010-\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200H\u0016J\u0012\u00105\u001a\u0004\u0018\u0001002\u0006\u00104\u001a\u000203H\u0016J\u0018\u00108\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00107\u001a\u000206H\u0016J\u0018\u0010:\u001a\u00020\u00152\u0006\u00109\u001a\u0002062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010<\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00107\u001a\u000206H\u0016J\u0010\u0010=\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010>\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00107\u001a\u000206H\u0016J&\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150C\"\b\b\u0000\u0010@*\u00020?2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000AH\u0016J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u000206H\u0016J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010H\u001a\u00020GH\u0016J\"\u0010M\u001a\u00020\u00052\u0006\u0010J\u001a\u0002062\u0006\u0010K\u001a\u0002032\b\u0010L\u001a\u0004\u0018\u000103H\u0016J\u0018\u0010P\u001a\u00020\u00052\u0006\u0010H\u001a\u00020G2\u0006\u0010O\u001a\u00020NH\u0016J\u0018\u0010T\u001a\u00020\u00052\u0006\u0010Q\u001a\u0002062\u0006\u0010S\u001a\u00020RH\u0016J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010V\u001a\u00020UH\u0016J\b\u0010Y\u001a\u00020XH\u0016J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010[\u001a\u00020ZH\u0016J(\u0010_\u001a\u0012\u0012\u0004\u0012\u0002060\u001aj\b\u0012\u0004\u0012\u000206`\u001c2\u0006\u0010]\u001a\u00020N2\u0006\u0010^\u001a\u00020NH\u0016J\u001a\u0010a\u001a\u0004\u0018\u00010`2\u0006\u0010]\u001a\u00020N2\u0006\u0010^\u001a\u00020NH\u0016J\u0018\u0010b\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010C2\u0006\u0010Q\u001a\u000206H\u0016J\u001e\u0010f\u001a\u00020\u00052\f\u0010d\u001a\b\u0012\u0004\u0012\u00020c0C2\u0006\u0010e\u001a\u00020\fH\u0016J\b\u0010g\u001a\u00020\u0005H\u0016J \u0010k\u001a\u00020\u00052\u0006\u0010h\u001a\u0002032\u0006\u0010i\u001a\u0002032\u0006\u0010j\u001a\u000203H\u0016J\b\u0010l\u001a\u00020\u0005H\u0016J\b\u0010m\u001a\u00020\u0005H\u0016J\u0018\u0010p\u001a\u00020\u00052\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010CH\u0016J4\u0010u\u001a\u00020\u00052\u0006\u0010q\u001a\u0002032\"\u0010t\u001a\u001e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002030rj\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000203`sH\u0016J\u0010\u0010w\u001a\u00020\u00052\u0006\u0010V\u001a\u00020vH\u0016J6\u0010y\u001a\u00020\f2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010x\u001a\u0002032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010@\u001a\u0004\u0018\u00010\u00152\u0006\u0010x\u001a\u000203R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010zR\u0018\u0010}\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010|R\u0017\u0010\u0080\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010\u007fR\u001d\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020U0\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\\\u0010\u0082\u0001R\u0016\u0010\u0085\u0001\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b:\u0010\u0084\u0001R\u0017\u0010\u0088\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b<\u0010\u0087\u0001R\u001a\u0010\u008a\u0001\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b,\u0010\u0089\u0001R\u001b\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b>\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b8\u0010\u008f\u0001R\u001e\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b2\u0010\u0093\u0001R\u001e\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bW\u0010\u0093\u0001R\u0017\u0010\u0098\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b)\u0010\u0097\u0001R\u0017\u0010\u0099\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010wR$\u0010\u009d\u0001\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bP\u0010\u009c\u0001R\u001c\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020n0C8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b=\u0010\u009e\u0001\u00a8\u0006\u00a2\u0001"}, d2 = {"Lcom/tencent/tavcut/session/TavCutSession;", "Lcom/tencent/tavcut/session/a;", "Lpd4/a;", "Lcom/tencent/tavcut/model/Painting;", "backGround", "", "a0", "", "targetTime", "b0", BdhLogUtil.LogTag.Tag_Req, "M", "", "needFlushPlayer", "N", "V", "J", "U", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "H", "X", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "stickerTransform", "time", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "Lkotlin/collections/ArrayList;", "stickerTrackerResult", "Lcom/tencent/tavcut/session/e;", "callback", "d0", "Ljava/util/concurrent/Callable;", "I", "P", "W", "K", "Lcom/tencent/tavcut/render/player/IPlayer;", "player", "p", "l", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "g", "getRenderModel", "L", "getTotalDurationUs", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "j", "", "sourceKey", "accessInputSource", "", "index", "i", "parentEntityId", "e", "b", "f", "o", h.F, "", "T", "Lkotlin/reflect/KClass;", "clazz", "", ExifInterface.LATITUDE_SOUTH, "id", "a", "Lcom/tencent/tavcut/composition/model/component/Size;", "renderSize", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "backgroundFillMode", "backColor", Constants.PAG_FILE_PATH, "updateBackground", "", "fillScale", DomainData.DOMAIN_NAME, TemplateParser.KEY_ENTITY_ID, "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "identifyComponent", "c", "Lcom/tencent/tavcut/session/d;", "listener", "k", "Lcom/tencent/tavcut/operator/IClipSourceOperator;", "getClipSourceOperator", "Lfe4/a;", "effectNode", "d", HippyTKDListViewAdapter.X, "y", "getEntitiesUnderPoint", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "getEditableTextUnderPoint", "getEditableTextByEntityId", "Lcom/tencent/tavcut/model/ClipSource;", "clips", "modifyClipsDuration", "setClipAssetsWithCallback", "release", "fontFamily", "fontStyle", "fontPath", "registerFont", HippyQQPagView.FunctionName.FLUSH, "flushWithoutDelay", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", DownloadInfo.spKey_Config, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "templatePath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "Y", "Lorg/light/listener/OnLoadAssetListener;", "Z", "entityName", "e0", "Lcom/tencent/tavcut/render/player/IPlayer;", "Lzd4/b;", "Lzd4/b;", "playerRenderChainManager", "Lpd4/b;", "Lpd4/b;", "dataDispatcher", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "sessionListenerList", "Lcom/tencent/tavcut/operator/IClipSourceOperator;", "iClipSourceOperator", "Lcom/tencent/tavcut/operator/d;", "Lcom/tencent/tavcut/operator/d;", "iComponentOperator", "Lorg/light/listener/OnLoadAssetListener;", "loadAssetListener", "Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;", "Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;", "customRenderConfig", "Lzd4/f;", "Lzd4/f;", "renderNodeConfigurator", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "Ljava/util/LinkedList;", "lazyUpdatePlayerEvents", "lazyRenderChainEvents", "Lle4/c;", "Lle4/c;", "renderDelayTimer", "isInitFormJson", "", "Lcom/tencent/tavcut/session/TavCutSession$b;", "Ljava/util/Map;", "trackedStickerResultMap", "Ljava/util/List;", "voiceConfig", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class TavCutSession implements a, pd4.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IPlayer player;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private zd4.b playerRenderChainManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private pd4.b dataDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final IClipSourceOperator iClipSourceOperator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.tavcut.operator.d iComponentOperator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private OnLoadAssetListener loadAssetListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CustomRenderConfig customRenderConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isInitFormJson;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final List<VoiceEnum> voiceConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<com.tencent.tavcut.session.d> sessionListenerList = new CopyOnWriteArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final zd4.f renderNodeConfigurator = new zd4.f();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<Runnable> lazyUpdatePlayerEvents = new LinkedList<>();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<Runnable> lazyRenderChainEvents = new LinkedList<>();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final le4.c renderDelayTimer = new le4.c(5, new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$renderDelayTimer$1
        @Override // java.lang.Runnable
        public final void run() {
            le4.b.f414432b.a(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$renderDelayTimer$1.1
                @Override // java.lang.Runnable
                public final void run() {
                    TavCutSession.O(TavCutSession.this, false, 0L, 3, null);
                }
            });
        }
    });

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Map<String, b> trackedStickerResultMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/tavcut/session/TavCutSession$b;", "", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "a", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "b", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "setEntity", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;)V", "entity", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "setResult", "(Ljava/util/ArrayList;)V", "result", "Lcom/tencent/tavcut/session/e;", "callback", "Lcom/tencent/tavcut/session/e;", "()Lcom/tencent/tavcut/session/e;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/tavcut/session/e;)V", "stickerTrackerResult", "<init>", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Ljava/util/ArrayList;Lcom/tencent/tavcut/session/e;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Entity entity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ArrayList<GYTrackStickerInfo> result;

        public b(@NotNull Entity entity, @NotNull ArrayList<GYTrackStickerInfo> stickerTrackerResult, @Nullable com.tencent.tavcut.session.e eVar) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            Intrinsics.checkParameterIsNotNull(stickerTrackerResult, "stickerTrackerResult");
            this.entity = entity;
            this.result = stickerTrackerResult;
        }

        @Nullable
        public final com.tencent.tavcut.session.e a() {
            return null;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Entity getEntity() {
            return this.entity;
        }

        @Nullable
        public final ArrayList<GYTrackStickerInfo> c() {
            return this.result;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Lkotlin/Unit;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    static final class c<V> implements Callable<Unit> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f374456e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ HashMap f374457f;

        c(String str, HashMap hashMap) {
            this.f374456e = str;
            this.f374457f = hashMap;
        }

        @Override // java.util.concurrent.Callable
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Unit call() {
            zd4.b bVar = TavCutSession.this.playerRenderChainManager;
            if (bVar != null) {
                bVar.addAssetDataToHolder(this.f374456e, this.f374457f);
            }
            zd4.b bVar2 = TavCutSession.this.playerRenderChainManager;
            if (bVar2 != null) {
                bVar2.setAssetData(this.f374457f);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class d<V> implements Callable<Unit> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ OnLoadAssetListener f374459e;

        d(OnLoadAssetListener onLoadAssetListener) {
            this.f374459e = onLoadAssetListener;
        }

        public final void a() {
            TavCutSession.this.Z(this.f374459e);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/tavcut/session/TavCutSession$e", "Lcom/tencent/tavcut/session/b;", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "onBeforeRender", "Lcom/tencent/tav/coremedia/TextureInfo;", "textureInfo", "onRender", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class e implements com.tencent.tavcut.session.b {
        e(com.tencent.tavcut.session.e eVar) {
        }

        @Override // com.tencent.tavcut.session.b
        public void onBeforeRender(long timeStamp) {
            if (TavCutSession.this.trackedStickerResultMap.isEmpty()) {
                zd4.b bVar = TavCutSession.this.playerRenderChainManager;
                if (bVar != null) {
                    bVar.b(this);
                    return;
                }
                return;
            }
            for (Map.Entry entry : TavCutSession.this.trackedStickerResultMap.entrySet()) {
                ScreenTransform e16 = le4.e.e(((b) entry.getValue()).getEntity());
                if (e16 != null) {
                    TavCutSession tavCutSession = TavCutSession.this;
                    Entity entity = ((b) entry.getValue()).getEntity();
                    ArrayList<GYTrackStickerInfo> c16 = ((b) entry.getValue()).c();
                    if (c16 == null) {
                        Intrinsics.throwNpe();
                    }
                    tavCutSession.d0(entity, e16, timeStamp, c16, null);
                }
            }
        }

        @Override // com.tencent.tavcut.session.b
        public void onRender(long timeStamp, @NotNull TextureInfo textureInfo) {
            Intrinsics.checkParameterIsNotNull(textureInfo, "textureInfo");
        }
    }

    public TavCutSession() {
        List<VoiceEnum> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VoiceEnum[]{VoiceEnum.UNCLE, VoiceEnum.LOLI, VoiceEnum.NAUGHTY_KID, VoiceEnum.HEAVY_METAL, VoiceEnum.ETHEREAL});
        this.voiceConfig = listOf;
        zd4.e.f452395c.d(0);
        pd4.b bVar = new pd4.b();
        this.dataDispatcher = bVar;
        this.loadAssetListener = null;
        bVar.g(this);
        this.iClipSourceOperator = new ClipSourceOperator(this.dataDispatcher);
        this.iComponentOperator = new com.tencent.tavcut.operator.a(this.dataDispatcher);
    }

    private final boolean H() {
        if (this.player == null) {
            synchronized (this.lazyUpdatePlayerEvents) {
                this.lazyUpdatePlayerEvents.add(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$checkNeedLazyUpdatePlayer$$inlined$synchronized$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TavCutSession.c0(TavCutSession.this, 0L, 1, null);
                    }
                });
            }
            return true;
        }
        return false;
    }

    private final boolean I(final Callable<Unit> callback) {
        if (this.playerRenderChainManager == null) {
            synchronized (this.lazyRenderChainEvents) {
                this.lazyRenderChainEvents.add(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$checkNeedLazyUpdateRenderChain$$inlined$synchronized$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.call();
                    }
                });
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        ee4.b.b(LAKTavCutSessionKt.TAG, "++++++++++clearFlags++++++++++");
        this.dataDispatcher.H();
    }

    private final Entity K() {
        ArrayList arrayListOf;
        od4.b bVar = od4.b.f422509e;
        FilterGroup d16 = bVar.n().d();
        ScreenTransform m3 = bVar.n().m();
        EntityIdentifier a16 = bVar.n().a("\u6548\u679c\u7ec4");
        xd4.f p16 = bVar.p();
        String str = a16.name;
        if (str == null) {
            str = "";
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new IdentifyComponent(d16), new IdentifyComponent(m3), new IdentifyComponent(a16));
        return p16.a(str, arrayListOf);
    }

    private final long M() {
        ClipInfo[][] clipInfos;
        Object lastOrNull;
        Object lastOrNull2;
        TimeRange timeRange;
        zd4.b bVar = this.playerRenderChainManager;
        if (!(bVar instanceof LightRenderChainManager)) {
            return 0L;
        }
        if (bVar != null) {
            MovieController movieController = ((LightRenderChainManager) bVar).getMovieController();
            if (movieController != null && (clipInfos = movieController.getClipInfos()) != null) {
                lastOrNull = ArraysKt___ArraysKt.lastOrNull(clipInfos);
                ClipInfo[] clipInfoArr = (ClipInfo[]) lastOrNull;
                if (clipInfoArr != null) {
                    lastOrNull2 = ArraysKt___ArraysKt.lastOrNull(clipInfoArr);
                    ClipInfo clipInfo = (ClipInfo) lastOrNull2;
                    if (clipInfo == null || (timeRange = clipInfo.targetTimeRange) == null) {
                        return 0L;
                    }
                    return timeRange.startTime + timeRange.duration;
                }
                return 0L;
            }
            return 0L;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.render.builder.light.LightRenderChainManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(boolean needFlushPlayer, long targetTime) {
        IPlayer iPlayer;
        U();
        long currentTimeMillis = System.currentTimeMillis();
        ee4.b.a(LAKTavCutSessionKt.TAG, "internalFlush begin.");
        if (this.dataDispatcher.B()) {
            ee4.b.a(LAKTavCutSessionKt.TAG, "internalFlush updatePlayer.");
            J();
            b0(targetTime);
            RenderModel L = L();
            IPlayer iPlayer2 = this.player;
            if (iPlayer2 != null) {
                iPlayer2.setClipAssets(L.getClipsAssets());
            }
            R();
        } else if (this.dataDispatcher.A()) {
            ee4.b.a(LAKTavCutSessionKt.TAG, "internalFlush reloadAsset.");
            V(needFlushPlayer, targetTime);
        } else {
            ee4.b.a(LAKTavCutSessionKt.TAG, "out internalFlush updateComponent.");
            ee4.b.a(LAKTavCutSessionKt.TAG, "in internalFlush updateComponent.");
            this.dataDispatcher.j();
            if (needFlushPlayer && (iPlayer = this.player) != null) {
                iPlayer.requestRender();
            }
            R();
        }
        ee4.b.a(LAKTavCutSessionKt.TAG, "internalFlush cost: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void O(TavCutSession tavCutSession, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        tavCutSession.N(z16, j3);
    }

    private final void P(final Callable<Unit> callback) {
        if (this.playerRenderChainManager == null) {
            synchronized (this.lazyRenderChainEvents) {
                this.lazyRenderChainEvents.add(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$lazyRunRenderChainEvents$$inlined$synchronized$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.call();
                    }
                });
            }
            return;
        }
        callback.call();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        yd4.a.f450209c.a("apply_end");
        synchronized (this.sessionListenerList) {
            Iterator<T> it = this.sessionListenerList.iterator();
            while (it.hasNext()) {
                ((com.tencent.tavcut.session.d) it.next()).onRenderDataApplied();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        long j3;
        RenderModel n3 = this.dataDispatcher.n();
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            j3 = bVar.getMovieControllerDuration();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        long M = M();
        ee4.b.a(LAKTavCutSessionKt.TAG, "onRenderDataChanged duration: " + j16 + ", mediaDuration: " + M);
        synchronized (this.sessionListenerList) {
            Iterator<T> it = this.sessionListenerList.iterator();
            while (it.hasNext()) {
                ((com.tencent.tavcut.session.d) it.next()).a1(n3, j16, M);
            }
            Unit unit = Unit.INSTANCE;
        }
        zd4.b bVar2 = this.playerRenderChainManager;
        if (bVar2 != null) {
            bVar2.setRenderNodeDuration(j16);
        }
    }

    private final void U() {
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            bVar.runOnAfterApply(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$registerRenderRunnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    TavCutSession.this.Q();
                }
            });
        }
    }

    private final void V(final boolean needFlushPlayer, final long targetTime) {
        ee4.b.a(LAKTavCutSessionKt.TAG, "out reloadAssets needFlushPlayer " + needFlushPlayer);
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.post(new Function0<Unit>() { // from class: com.tencent.tavcut.session.TavCutSession$reloadAssets$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
                
                    r0 = r5.this$0.player;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    pd4.b bVar;
                    IPlayer iPlayer2;
                    pd4.b bVar2;
                    ee4.b.a(LAKTavCutSessionKt.TAG, "in reloadAssets<<<<");
                    bVar = TavCutSession.this.dataDispatcher;
                    RenderModel n3 = bVar.n();
                    zd4.b bVar3 = TavCutSession.this.playerRenderChainManager;
                    if (bVar3 != null) {
                        bVar2 = TavCutSession.this.dataDispatcher;
                        bVar3.h(bVar2.getTemplateDir(), n3, targetTime);
                    }
                    if (needFlushPlayer && iPlayer2 != null) {
                        iPlayer2.requestRender();
                    }
                    TavCutSession.this.J();
                    TavCutSession.this.R();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        synchronized (this.lazyRenderChainEvents) {
            if (!this.lazyRenderChainEvents.isEmpty()) {
                Iterator<T> it = this.lazyRenderChainEvents.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                this.lazyRenderChainEvents.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void X() {
        le4.b.f414432b.a(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$runUpdatePlayerEvents$1
            @Override // java.lang.Runnable
            public final void run() {
                LinkedList linkedList;
                LinkedList linkedList2;
                LinkedList linkedList3;
                LinkedList linkedList4;
                linkedList = TavCutSession.this.lazyUpdatePlayerEvents;
                synchronized (linkedList) {
                    linkedList2 = TavCutSession.this.lazyUpdatePlayerEvents;
                    if (!linkedList2.isEmpty()) {
                        linkedList3 = TavCutSession.this.lazyUpdatePlayerEvents;
                        Runnable runnable = (Runnable) linkedList3.peekLast();
                        if (runnable != null) {
                            runnable.run();
                        }
                        linkedList4 = TavCutSession.this.lazyUpdatePlayerEvents;
                        linkedList4.clear();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    private final void a0(Painting backGround) {
        this.dataDispatcher.N(backGround);
    }

    private final void b0(long targetTime) {
        final HashMap<String, String> hashMap;
        if (H()) {
            ee4.b.a(LAKTavCutSessionKt.TAG, "updatePlayer need lazy update.");
            return;
        }
        RenderModel n3 = this.dataDispatcher.n();
        n3.setCustomRenderConfig(this.customRenderConfig);
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            hashMap = bVar.getCurrentAssetData(this.dataDispatcher.getTemplateDir());
        } else {
            hashMap = null;
        }
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.b(this.dataDispatcher.getTemplateDir(), n3, this.isInitFormJson, targetTime, new Function2<zd4.b, RenderModel, Unit>() { // from class: com.tencent.tavcut.session.TavCutSession$updatePlayer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(zd4.b bVar2, RenderModel renderModel) {
                    invoke2(bVar2, renderModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull zd4.b renderManager, @NotNull RenderModel renderModel) {
                    OnLoadAssetListener onLoadAssetListener;
                    zd4.f fVar;
                    pd4.b bVar2;
                    pd4.b bVar3;
                    pd4.b bVar4;
                    OnLoadAssetListener onLoadAssetListener2;
                    Intrinsics.checkParameterIsNotNull(renderManager, "renderManager");
                    Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
                    TavCutSession.this.playerRenderChainManager = renderManager;
                    onLoadAssetListener = TavCutSession.this.loadAssetListener;
                    if (onLoadAssetListener != null) {
                        TavCutSession tavCutSession = TavCutSession.this;
                        onLoadAssetListener2 = tavCutSession.loadAssetListener;
                        if (onLoadAssetListener2 == null) {
                            Intrinsics.throwNpe();
                        }
                        tavCutSession.Z(onLoadAssetListener2);
                    }
                    zd4.b bVar5 = TavCutSession.this.playerRenderChainManager;
                    if (bVar5 != null) {
                        TavCutSession.y(TavCutSession.this);
                        if (hashMap != null) {
                            bVar4 = TavCutSession.this.dataDispatcher;
                            String templateDir = bVar4.getTemplateDir();
                            bVar5.addAssetDataToHolder(templateDir, hashMap);
                            TavCutSession.this.Y(templateDir, hashMap);
                        }
                    }
                    if (TavCutSession.this.playerRenderChainManager != null) {
                        for (Map.Entry entry : TavCutSession.this.trackedStickerResultMap.entrySet()) {
                            TavCutSession tavCutSession2 = TavCutSession.this;
                            ArrayList<GYTrackStickerInfo> c16 = ((TavCutSession.b) entry.getValue()).c();
                            String str = (String) entry.getKey();
                            ((TavCutSession.b) entry.getValue()).a();
                            tavCutSession2.e0(c16, str, null);
                        }
                    }
                    TavCutSession.this.W();
                    TavCutSession.this.isInitFormJson = false;
                    fVar = TavCutSession.this.renderNodeConfigurator;
                    fVar.b(renderManager);
                    bVar2 = TavCutSession.this.dataDispatcher;
                    bVar2.K(renderManager);
                    bVar3 = TavCutSession.this.dataDispatcher;
                    bVar3.O(renderModel.getTimeLines());
                    renderManager.registerTimelineObserver(new Function1<List<? extends Timeline>, Unit>() { // from class: com.tencent.tavcut.session.TavCutSession$updatePlayer$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Timeline> list) {
                            invoke2((List<Timeline>) list);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull List<Timeline> it) {
                            pd4.b bVar6;
                            Intrinsics.checkParameterIsNotNull(it, "it");
                            bVar6 = TavCutSession.this.dataDispatcher;
                            bVar6.O(it);
                        }
                    });
                    TavCutSession.this.R();
                    TavCutSession.this.Q();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c0(TavCutSession tavCutSession, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        tavCutSession.b0(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(Entity entity, ScreenTransform stickerTransform, long time, ArrayList<GYTrackStickerInfo> stickerTrackerResult, com.tencent.tavcut.session.e callback) {
        ScreenTransform copy;
        GYTrackStickerInfo d16 = le4.e.d(stickerTrackerResult, time);
        if (d16 != null) {
            if (callback != null) {
                callback.onUpdate(entity.getName(), d16);
            }
            zd4.b bVar = this.playerRenderChainManager;
            if (bVar != null) {
                int id5 = entity.getId();
                Rect a16 = le4.e.a(d16);
                Rect rect = stickerTransform.offset;
                if (rect == null) {
                    Intrinsics.throwNpe();
                }
                copy = stickerTransform.copy((r36 & 1) != 0 ? stickerTransform.entityId : null, (r36 & 2) != 0 ? stickerTransform.componentID : null, (r36 & 4) != 0 ? stickerTransform.enabled : null, (r36 & 8) != 0 ? stickerTransform.type : null, (r36 & 16) != 0 ? stickerTransform.anchor : a16, (r36 & 32) != 0 ? stickerTransform.offset : null, (r36 & 64) != 0 ? stickerTransform.pivot : null, (r36 & 128) != 0 ? stickerTransform.ePinToEdge : null, (r36 & 256) != 0 ? stickerTransform.eFixSize : null, (r36 & 512) != 0 ? stickerTransform.eEditingMode : null, (r36 & 1024) != 0 ? stickerTransform.eKeepRatio : null, (r36 & 2048) != 0 ? stickerTransform.position : null, (r36 & 4096) != 0 ? stickerTransform.rotation : null, (r36 & 8192) != 0 ? stickerTransform.scale : le4.e.b(rect, d16), (r36 & 16384) != 0 ? stickerTransform.euler : null, (r36 & 32768) != 0 ? stickerTransform.objectEnabled : null, (r36 & 65536) != 0 ? stickerTransform.version : null, (r36 & 131072) != 0 ? stickerTransform.unknownFields() : null);
                bVar.c(id5, new IdentifyComponent(copy));
            }
        }
    }

    public static final /* synthetic */ com.tencent.tavcut.session.c y(TavCutSession tavCutSession) {
        tavCutSession.getClass();
        return null;
    }

    @NotNull
    public RenderModel L() {
        return this.dataDispatcher.n();
    }

    @NotNull
    public <T> List<Entity> S(@NotNull KClass<T> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        return this.dataDispatcher.E(clazz);
    }

    @Nullable
    public final Entity T(@NotNull String entityName) {
        Intrinsics.checkParameterIsNotNull(entityName, "entityName");
        for (Entity entity : S(Reflection.getOrCreateKotlinClass(ScreenTransform.class))) {
            if (Intrinsics.areEqual(entity.getName(), entityName)) {
                return entity;
            }
        }
        return null;
    }

    public void Y(@NotNull String templatePath, @NotNull HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(assetData, "assetData");
        P(new c(templatePath, assetData));
    }

    public void Z(@NotNull OnLoadAssetListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (I(new d(listener))) {
            ee4.b.e(LAKTavCutSessionKt.TAG, "setLoadAssetListener while playerRenderChainManager is null.");
            return;
        }
        this.loadAssetListener = listener;
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            bVar.setLoadAssetListener(listener);
        }
    }

    @Override // com.tencent.tavcut.session.a
    public void a(int id5) {
        ee4.b.a(LAKTavCutSessionKt.TAG, "remove entity id: " + id5);
        this.dataDispatcher.G(id5);
    }

    @Override // com.tencent.tavcut.session.a
    @Nullable
    public InputSource accessInputSource(@NotNull String sourceKey) {
        Intrinsics.checkParameterIsNotNull(sourceKey, "sourceKey");
        return this.dataDispatcher.a(sourceKey);
    }

    @Override // com.tencent.tavcut.session.a
    @NotNull
    public Entity b(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return this.iClipSourceOperator.b(entity);
    }

    @Override // com.tencent.tavcut.session.a
    public void c(final int entityId, @NotNull final IdentifyComponent identifyComponent) {
        Intrinsics.checkParameterIsNotNull(identifyComponent, "identifyComponent");
        ee4.b.a(LAKTavCutSessionKt.TAG, "out updateComponent");
        le4.b.f414432b.a(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$updateComponent$1
            @Override // java.lang.Runnable
            public final void run() {
                pd4.b bVar;
                ee4.b.a(LAKTavCutSessionKt.TAG, "updateComponent start<<<<<<");
                if (identifyComponent.getData() instanceof TimeOffset) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("updateComponent timeOffset: ");
                    Object data = identifyComponent.getData();
                    if (data != null) {
                        sb5.append(((TimeOffset) data).duration);
                        ee4.b.a(LAKTavCutSessionKt.TAG, sb5.toString());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.TimeOffset");
                    }
                }
                bVar = TavCutSession.this.dataDispatcher;
                bVar.M(entityId, identifyComponent);
                ee4.b.a(LAKTavCutSessionKt.TAG, "updateComponent end<<<<<<");
            }
        });
    }

    @Override // com.tencent.tavcut.session.a
    public void d(@NotNull fe4.a effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        this.renderNodeConfigurator.a(effectNode);
    }

    @Override // com.tencent.tavcut.session.a
    @NotNull
    public Entity e(int parentEntityId, @NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return pd4.b.c(this.dataDispatcher, entity, parentEntityId, 0, 4, null);
    }

    public boolean e0(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String entityName, @Nullable com.tencent.tavcut.session.e callback) {
        Intrinsics.checkParameterIsNotNull(entityName, "entityName");
        Entity T = T(entityName);
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            bVar.i(new e(callback));
        }
        if (stickerTrackerResult != null && !stickerTrackerResult.isEmpty()) {
            if (T != null) {
                this.trackedStickerResultMap.put(T.getName(), new b(T, stickerTrackerResult, callback));
                return true;
            }
            return true;
        }
        if (this.trackedStickerResultMap.containsKey(entityName)) {
            this.trackedStickerResultMap.remove(entityName);
            return true;
        }
        return true;
    }

    @Override // com.tencent.tavcut.session.a
    @NotNull
    public Entity f(@NotNull Entity entity, int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return this.iClipSourceOperator.f(entity, index);
    }

    @Override // com.tencent.tavcut.session.a
    public void flush() {
        this.renderDelayTimer.a();
    }

    @Override // com.tencent.tavcut.session.a
    public void flushWithoutDelay() {
        le4.b.f414432b.a(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$flushWithoutDelay$1
            @Override // java.lang.Runnable
            public final void run() {
                TavCutSession.O(TavCutSession.this, true, 0L, 2, null);
            }
        });
    }

    @Override // com.tencent.tavcut.session.a
    public void g(@NotNull RenderModel renderModel) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        this.dataDispatcher.u(renderModel);
        this.dataDispatcher.k();
        if (od4.a.f422504b.a()) {
            this.dataDispatcher.L(this.voiceConfig);
        }
    }

    @Override // com.tencent.tavcut.session.a
    @NotNull
    /* renamed from: getClipSourceOperator, reason: from getter */
    public IClipSourceOperator getIClipSourceOperator() {
        return this.iClipSourceOperator;
    }

    @Override // com.tencent.tavcut.session.a
    @Nullable
    public List<TextPlaceInfo> getEditableTextByEntityId(int entityId) {
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            return bVar.getEditableTextByEntityId(entityId);
        }
        return null;
    }

    @Override // com.tencent.tavcut.session.a
    @Nullable
    public TextPlaceInfo getEditableTextUnderPoint(float x16, float y16) {
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            return bVar.getEditableTextUnderPoint(x16, y16);
        }
        return null;
    }

    @Override // com.tencent.tavcut.session.a
    @NotNull
    public ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16) {
        ArrayList<Integer> entitiesUnderPoint;
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null && (entitiesUnderPoint = bVar.getEntitiesUnderPoint(x16, y16)) != null) {
            return entitiesUnderPoint;
        }
        return new ArrayList<>();
    }

    @Override // com.tencent.tavcut.session.a
    @Nullable
    public RenderModel getRenderModel() {
        return this.dataDispatcher.q();
    }

    @Override // com.tencent.tavcut.session.a
    public long getTotalDurationUs() {
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            return iPlayer.getDurationUs();
        }
        return 0L;
    }

    @Override // com.tencent.tavcut.session.a
    @NotNull
    public Entity h(@NotNull Entity entity, int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return this.dataDispatcher.b(entity, this.dataDispatcher.r(), index);
    }

    @Override // com.tencent.tavcut.session.a
    @NotNull
    public Entity i(@NotNull Entity entity, int index) {
        Object firstOrNull;
        int r16;
        Object firstOrNull2;
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(FilterGroup.class)));
        Entity entity2 = (Entity) firstOrNull;
        if (entity2 == null) {
            e(this.dataDispatcher.r(), K());
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(FilterGroup.class)));
            entity2 = (Entity) firstOrNull2;
        }
        if (entity2 != null) {
            r16 = entity2.getId();
        } else {
            r16 = this.dataDispatcher.r();
        }
        return this.dataDispatcher.b(entity, r16, index);
    }

    @Override // com.tencent.tavcut.session.a
    public void j(@NotNull InputSource inputSource) {
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        this.dataDispatcher.f(inputSource);
    }

    @Override // com.tencent.tavcut.session.a
    public void k(@NotNull com.tencent.tavcut.session.d listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        synchronized (this.sessionListenerList) {
            CopyOnWriteArrayList<com.tencent.tavcut.session.d> copyOnWriteArrayList = this.sessionListenerList;
            if (!(!copyOnWriteArrayList.contains(listener))) {
                copyOnWriteArrayList = null;
            }
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.add(listener);
            }
        }
    }

    @Override // com.tencent.tavcut.session.a
    public void l(@Nullable IPlayer player) {
        if (player == null || Intrinsics.areEqual(this.player, player)) {
            this.player = null;
        }
    }

    @Override // pd4.a
    public void m(@Nullable List<? extends VoiceEnum> config) {
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            bVar.setVoiceChangerConfig(config);
        }
    }

    @Override // com.tencent.tavcut.session.a
    public void n(@NotNull Size renderSize, float fillScale) {
        Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
        RenderModel n3 = this.dataDispatcher.n();
        if (n3 != null) {
            a0(Painting.copy$default(n3.getPainting(), renderSize, null, null, null, null, Float.valueOf(fillScale), null, 94, null));
        }
    }

    @Override // com.tencent.tavcut.session.a
    @NotNull
    public Entity o(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        ee4.b.a(LAKTavCutSessionKt.TAG, "add BGM Entity id: " + entity.getId());
        for (IdentifyComponent identifyComponent : entity.getComponents()) {
            if (identifyComponent.getData() instanceof TimeOffset) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("addBgm timeOffset: ");
                Object data = identifyComponent.getData();
                if (data != null) {
                    sb5.append(((TimeOffset) data).duration);
                    ee4.b.a(LAKTavCutSessionKt.TAG, sb5.toString());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.TimeOffset");
                }
            }
        }
        return pd4.b.c(this.dataDispatcher, entity, this.dataDispatcher.r(), 0, 4, null);
    }

    @Override // com.tencent.tavcut.session.a
    public void p(@NotNull IPlayer player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.player = player;
        X();
    }

    @Override // com.tencent.tavcut.session.a
    public void q(@NotNull Size renderSize) {
        Painting painting;
        float f16;
        Intrinsics.checkParameterIsNotNull(renderSize, "renderSize");
        RenderModel n3 = this.dataDispatcher.n();
        if (n3 == null || (painting = n3.getPainting()) == null) {
            painting = new Painting(null, null, null, null, null, null, null, 127, null);
        }
        Integer num = renderSize.width;
        if (num == null) {
            Intrinsics.throwNpe();
        }
        int intValue = num.intValue();
        Integer num2 = renderSize.height;
        if (num2 == null) {
            Intrinsics.throwNpe();
        }
        if (intValue > num2.intValue()) {
            f16 = 1000.0f;
        } else {
            f16 = 0.0f;
        }
        a0(Painting.copy$default(painting, renderSize, null, null, null, null, Float.valueOf(f16), null, 94, null));
    }

    @Override // com.tencent.tavcut.session.a
    public void registerFont(@NotNull String fontFamily, @NotNull String fontStyle, @NotNull String fontPath) {
        Intrinsics.checkParameterIsNotNull(fontFamily, "fontFamily");
        Intrinsics.checkParameterIsNotNull(fontStyle, "fontStyle");
        Intrinsics.checkParameterIsNotNull(fontPath, "fontPath");
        de4.a.f393661b.b(fontFamily, fontStyle, fontPath);
    }

    @Override // com.tencent.tavcut.session.a
    public void release() {
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.release();
        }
        zd4.b bVar = this.playerRenderChainManager;
        if (bVar != null) {
            bVar.release();
        }
        synchronized (this.lazyRenderChainEvents) {
            this.lazyRenderChainEvents.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // pd4.a
    public void setClipAssetsWithCallback(@NotNull final List<ClipSource> clips, final boolean modifyClipsDuration) {
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        le4.b.f414432b.a(new Runnable() { // from class: com.tencent.tavcut.session.TavCutSession$setClipAssetsWithCallback$1
            @Override // java.lang.Runnable
            public final void run() {
                if (TavCutSession.this.playerRenderChainManager instanceof LightRenderChainManager) {
                    RenderModel L = TavCutSession.this.L();
                    List<ClipAsset> a16 = com.tencent.tavcut.render.builder.light.a.a(clips);
                    zd4.b bVar = TavCutSession.this.playerRenderChainManager;
                    if (bVar != null) {
                        ((LightRenderChainManager) bVar).E(a16, L.getPainting().pagPath, modifyClipsDuration);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.render.builder.light.LightRenderChainManager");
                }
            }
        });
    }

    @Override // com.tencent.tavcut.session.a
    public void updateBackground(int backgroundFillMode, @NotNull String backColor, @Nullable String pagFilePath) {
        Intrinsics.checkParameterIsNotNull(backColor, "backColor");
        RenderModel n3 = this.dataDispatcher.n();
        if (n3 != null) {
            Painting painting = n3.getPainting();
            BackgroundFillMode fromValue = BackgroundFillMode.INSTANCE.fromValue(backgroundFillMode);
            if (fromValue == null) {
                Intrinsics.throwNpe();
            }
            if (pagFilePath == null) {
                pagFilePath = "";
            }
            a0(Painting.copy$default(painting, null, null, fromValue, pagFilePath, backColor, null, null, 99, null));
        }
    }
}
