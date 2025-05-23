package com.tencent.mobileqq.wink.picker.utils;

import com.google.gson.JsonObject;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tavcut.core.dataprocessor.EntityNodeType;
import com.tencent.tavcut.core.manager.StickerTrackerManager;
import com.tencent.tavcut.core.operator.IClipSourceOperator;
import com.tencent.tavcut.core.render.builder.light.Constants;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.TextPlaceInfo;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.IRenderCallback;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.tavcut.core.session.IStickerUpdateCallback;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.MaterialConfig;
import org.light.TemplateConfig;
import org.light.WatermarkConfig;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.enums.AudioSourceType;
import org.light.listener.OnLoadAssetListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0012\u0012\u0007\u0010\u00ae\u0001\u001a\u00020\u0002\u00a2\u0006\u0006\b\u00af\u0001\u0010\u00b0\u0001J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J#\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J\u0019\u0010\u001c\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\u001b\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0096\u0001J\u0011\u0010%\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H\u0096\u0001J\u0011\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&H\u0096\u0001J\u0019\u0010-\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0096\u0001J\t\u0010.\u001a\u00020\tH\u0096\u0001J\t\u0010/\u001a\u00020\tH\u0096\u0001J\t\u00100\u001a\u00020\tH\u0096\u0001J\u001b\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u000202H\u0096\u0001J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000704H\u0096\u0001J\u000b\u00107\u001a\u0004\u0018\u000106H\u0096\u0001J\u0019\u00109\u001a\b\u0012\u0004\u0012\u00020\u0007042\b\u00108\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010:\u001a\u000202H\u0096\u0001J\t\u0010<\u001a\u00020;H\u0096\u0001J\t\u0010>\u001a\u00020=H\u0096\u0001J\u0019\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u0001042\u0006\u0010?\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010E\u001a\u0004\u0018\u00010@2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020BH\u0096\u0001J\u001f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000e0F2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020BH\u0096\u0001J\t\u0010H\u001a\u000202H\u0096\u0001J\u000b\u0010J\u001a\u0004\u0018\u00010IH\u0096\u0001J\u000b\u0010L\u001a\u0004\u0018\u00010KH\u0096\u0001J\u000b\u0010N\u001a\u0004\u0018\u00010MH\u0096\u0001J\u001a\u0010Q\u001a\f\u0012\u0006\b\u0001\u0012\u00020P\u0018\u00010OH\u0096\u0001\u00a2\u0006\u0004\bQ\u0010RJ\u0012\u0010S\u001a\u0004\u0018\u00010\u0013H\u0096\u0001\u00a2\u0006\u0004\bS\u0010TJ\u000b\u0010V\u001a\u0004\u0018\u00010UH\u0096\u0001J\u0013\u0010X\u001a\u00020B2\b\b\u0002\u0010W\u001a\u00020BH\u0096\u0001J\u000b\u0010Y\u001a\u0004\u0018\u00010\"H\u0096\u0001J\u000b\u0010Z\u001a\u0004\u0018\u000106H\u0096\u0001J\u000b\u0010[\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\\\u001a\u000202H\u0096\u0001J\u001a\u0010^\u001a\u0004\u0018\u00010\u00132\u0006\u0010]\u001a\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b^\u0010_J\t\u0010`\u001a\u00020\tH\u0096\u0001J\"\u0010d\u001a\u00020\t2\u0017\u0010c\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0a\u00a2\u0006\u0002\bbH\u0096\u0001J\"\u0010e\u001a\u00020\t2\u0017\u0010c\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0a\u00a2\u0006\u0002\bbH\u0096\u0001J'\u0010i\u001a\b\u0012\u0004\u0012\u00020\u000704\"\b\b\u0000\u0010f*\u00020&2\f\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00000gH\u0096\u0001J!\u0010m\u001a\u00020\t2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u0003H\u0096\u0001J\t\u0010n\u001a\u00020\tH\u0096\u0001J\u0011\u0010o\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010p\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010q\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\u0011\u0010r\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J\u0011\u0010s\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\u0017\u0010u\u001a\u00020\t2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\t0tH\u0096\u0001J\u0011\u0010w\u001a\u00020\t2\u0006\u0010v\u001a\u000202H\u0096\u0001J5\u0010|\u001a\u00020\t2\u0006\u0010x\u001a\u00020\u00032\"\u0010{\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030yj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`zH\u0096\u0001J\u0011\u0010~\u001a\u00020\t2\u0006\u0010}\u001a\u00020\u000eH\u0096\u0001J\u0014\u0010\u0080\u0001\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u007fH\u0096\u0001J\n\u0010\u0081\u0001\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u0083\u0001\u001a\u00020\t2\u0007\u0010\u001e\u001a\u00030\u0082\u0001H\u0096\u0001J\u0013\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\u0013H\u0096\u0001J\u0013\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020BH\u0096\u0001J\u001b\u0010\u0088\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0007\u0010\u0086\u0001\u001a\u00020BH\u0096\u0001J\u0013\u0010\u008a\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u000206H\u0096\u0001J\u001e\u0010\u008a\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u0002062\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u0013H\u0096\u0001J\u0013\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u001e\u001a\u00030\u008c\u0001H\u0096\u0001J\u0013\u0010\u008f\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u0003H\u0096\u0001J\u001a\u0010\u0090\u0001\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u0016\u0010\u0093\u0001\u001a\u00020\t2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0096\u0001J\u001b\u0010\u0095\u0001\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0007\u0010\u0094\u0001\u001a\u00020\u0013H\u0096\u0001J\u001b\u0010\u0096\u0001\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0007\u0010\u0094\u0001\u001a\u00020\u0013H\u0096\u0001J\u001d\u0010\u0099\u0001\u001a\u00020\t2\b\u0010\u0098\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u0013H\u0096\u0001J\u0014\u0010\u009a\u0001\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0001J\u0014\u0010\u009b\u0001\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0001J'\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010\u009c\u0001\u001a\u00020\u000e2\u0007\u0010\u009d\u0001\u001a\u00020\u00032\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J\u0014\u0010\u00a2\u0001\u001a\u00020\t2\b\u0010\u00a1\u0001\u001a\u00030\u00a0\u0001H\u0096\u0001J\u001d\u0010\u00a2\u0001\u001a\u00020\t2\b\u0010\u00a1\u0001\u001a\u00030\u00a0\u00012\u0007\u0010\u00a3\u0001\u001a\u00020BH\u0096\u0001J:\u0010\u00a8\u0001\u001a\u00020\u00132\u0010\u0010\u00a5\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00a4\u0001\u0018\u00010F2\u0007\u0010\u00a6\u0001\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u000b\b\u0002\u0010\u0017\u001a\u0005\u0018\u00010\u00a7\u0001H\u0096\u0001J\u0013\u0010\u00a9\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020BH\u0096\u0001J\u001f\u0010\u00a9\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020B2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u00aa\u0001H\u0096\u0001J\t\u0010\u00ab\u0001\u001a\u00020\tH\u0016R\u0017\u0010\u00ae\u0001\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001\u00a8\u0006\u00b1\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/utils/a;", "Ljava/io/Closeable;", "Lcom/tencent/tavcut/core/session/ICutSession;", "", "sourceKey", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "accessInputSource", "Lorg/light/lightAssetKit/Entity;", "entity", "", "addBgm", "addClipEffect", "Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "entityType", "", "index", "addEffect", "addHDR", "inputSource", "", "needReloadAsset", "addInputSource", "Lcom/tencent/tavcut/core/session/IRenderCallback;", "callback", "addRenderCallback", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "effectNode", "addRenderNode", "addRenderTarget", "Lcom/tencent/tavcut/core/session/ISessionListener;", "listener", "addSessionListener", "addVideoSourceEntity", "addVideoSourceEntityAfterLutFilter", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "player", "bindCutPlayer", "bindPlayer", "Lorg/light/lightAssetKit/components/Component;", HippyQQConstants.URL_COMPONENT_NAME, "componentSupportDynamicModify", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager;", "stickerTrackerManager", "Lsd4/b;", "stickerTrackerConfig", "createStickerTrackerManager", "emit", HippyQQPagView.FunctionName.FLUSH, "flushWithoutDelay", "needFlushPlayer", "", "targetTime", "", "getAllImageStickerEntitys", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "getAllInputSourceRenderModel", "rootEntity", "getAllTextEntity", "getClipAssetsDurationUs", "Lcom/tencent/tavcut/core/operator/IClipSourceOperator;", "getClipSourceOperator", "Lcom/tencent/tavcut/core/operator/d;", "getComponentOperator", TemplateParser.KEY_ENTITY_ID, "Lcom/tencent/tavcut/core/render/builder/light/model/TextPlaceInfo;", "getEditableTextByEntityId", "", HippyTKDListViewAdapter.X, "y", "getEditableTextUnderPoint", "Ljava/util/ArrayList;", "getEntitiesUnderPoint", "getFrameDuration", "Lcom/google/gson/JsonObject;", "getInputSources", "Lorg/light/LightAsset;", "getLightAsset", "Lorg/light/lightAssetKit/LightAssetDataContext;", "getLightAssetDataContext", "", "Lorg/light/MaterialConfig;", "getMaterialConfig", "()[Lorg/light/MaterialConfig;", "getMediasTotalDurationLimitationFlag", "()Ljava/lang/Boolean;", "Lorg/light/TemplateConfig;", "getMovieConfig", "defaultVolume", "getOriginVolume", "getPlayer", "getRenderModel", "getRootEntity", "getTotalDurationUs", "aiType", "needRenderAbility", "(Ljava/lang/String;)Ljava/lang/Boolean;", "notifyReloadAsset", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "runnable", "pushCustomCommand", "pushCustomCommandSync", "T", "Lkotlin/reflect/KClass;", "clazz", "queryEntityByComponent", "fontFamily", "fontStyle", "fontPath", "registerFont", "release", "removeEntity", "removeInputSource", "removeRenderCallback", "removeRenderNode", "removeSessionListener", "Lkotlin/Function0;", "runOnPlayerThread", "timeUs", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "templatePath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "setAssetData", "bgColor", "setBgColor", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "setCutStatusListener", "setDedaultRenderModel", "Lorg/light/listener/OnLoadAssetListener;", "setLoadAssetListener", "isLimited", "setMediasTotalDurationLimitationFlag", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setOriginVolume", "setOriginVolumeForClip", "LAKRenderModel", "setRenderModel", "needInitTemplate", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "setRenderTimeListener", "path", "setTemplateDir", "setTransition", "Lorg/light/WatermarkConfig;", DownloadInfo.spKey_Config, "setWatermarkConfig", "enable", "switchEntity", "switchEntitySync", "Lcom/tencent/tavcut/core/render/builder/light/Constants$ENHANCE_TYPE;", "type", "switchPicEnhanceAbility", "unbindCutPlayer", "unbindPlayer", "backgroundFillMode", "backColor", Constants.PAG_FILE_PATH, "updateBackground", "Lorg/light/lightAssetKit/components/Size;", "renderSize", "updateRenderSize", "fillScale", "Lcom/gyailib/library/GYTrackStickerInfo;", "stickerTrackerResult", "stickerName", "Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;", "updateTrackedStickerPosition", "updateVolume", "Lorg/light/lightAssetKit/enums/AudioSourceType;", "close", "d", "Lcom/tencent/tavcut/core/session/ICutSession;", "cutSession", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements Closeable, ICutSession {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession cutSession;

    public a(@NotNull ICutSession cutSession) {
        Intrinsics.checkNotNullParameter(cutSession, "cutSession");
        this.cutSession = cutSession;
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public InputSource accessInputSource(@NotNull String sourceKey) {
        Intrinsics.checkNotNullParameter(sourceKey, "sourceKey");
        return this.cutSession.accessInputSource(sourceKey);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addBgm(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.addBgm(entity);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addClipEffect(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.addClipEffect(entity);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addEffect(@NotNull Entity entity, int index) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.addEffect(entity, index);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addHDR(@NotNull Entity entity, int index) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.addHDR(entity, index);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addInputSource(@NotNull InputSource inputSource, boolean needReloadAsset) {
        Intrinsics.checkNotNullParameter(inputSource, "inputSource");
        this.cutSession.addInputSource(inputSource, needReloadAsset);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addRenderCallback(@NotNull IRenderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.cutSession.addRenderCallback(callback);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addRenderNode(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkNotNullParameter(effectNode, "effectNode");
        this.cutSession.addRenderNode(effectNode);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addRenderTarget(@NotNull Entity entity, int index) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.addRenderTarget(entity, index);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addSessionListener(@NotNull ISessionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cutSession.addSessionListener(listener);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addVideoSourceEntity(@NotNull Entity entity, int index) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.addVideoSourceEntity(entity, index);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addVideoSourceEntityAfterLutFilter(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.addVideoSourceEntityAfterLutFilter(entity);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public IPlayer bindCutPlayer(@NotNull IPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return this.cutSession.bindCutPlayer(player);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void bindPlayer(@NotNull IPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.cutSession.bindPlayer(player);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cutSession.release();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public boolean componentSupportDynamicModify(@NotNull Component component) {
        Intrinsics.checkNotNullParameter(component, "component");
        return this.cutSession.componentSupportDynamicModify(component);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public int createStickerTrackerManager(@NotNull StickerTrackerManager stickerTrackerManager, @NotNull sd4.b stickerTrackerConfig) {
        Intrinsics.checkNotNullParameter(stickerTrackerManager, "stickerTrackerManager");
        Intrinsics.checkNotNullParameter(stickerTrackerConfig, "stickerTrackerConfig");
        return this.cutSession.createStickerTrackerManager(stickerTrackerManager, stickerTrackerConfig);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void emit() {
        this.cutSession.emit();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void flush() {
        this.cutSession.flush();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void flushWithoutDelay() {
        this.cutSession.flushWithoutDelay();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public List<Entity> getAllImageStickerEntitys() {
        return this.cutSession.getAllImageStickerEntitys();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public LAKRenderModel getAllInputSourceRenderModel() {
        return this.cutSession.getAllInputSourceRenderModel();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public List<Entity> getAllTextEntity(@Nullable Entity rootEntity) {
        return this.cutSession.getAllTextEntity(rootEntity);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public long getClipAssetsDurationUs() {
        return this.cutSession.getClipAssetsDurationUs();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    /* renamed from: getClipSourceOperator */
    public IClipSourceOperator getIClipSourceOperator() {
        return this.cutSession.getIClipSourceOperator();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    /* renamed from: getComponentOperator */
    public com.tencent.tavcut.core.operator.d getIComponentOperator() {
        return this.cutSession.getIComponentOperator();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public List<TextPlaceInfo> getEditableTextByEntityId(int entityId) {
        return this.cutSession.getEditableTextByEntityId(entityId);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public TextPlaceInfo getEditableTextUnderPoint(float x16, float y16) {
        return this.cutSession.getEditableTextUnderPoint(x16, y16);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16) {
        return this.cutSession.getEntitiesUnderPoint(x16, y16);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public long getFrameDuration() {
        return this.cutSession.getFrameDuration();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public JsonObject getInputSources() {
        return this.cutSession.getInputSources();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public LightAsset getLightAsset() {
        return this.cutSession.getLightAsset();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public LightAssetDataContext getLightAssetDataContext() {
        return this.cutSession.getLightAssetDataContext();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public MaterialConfig[] getMaterialConfig() {
        return this.cutSession.getMaterialConfig();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public Boolean getMediasTotalDurationLimitationFlag() {
        return this.cutSession.getMediasTotalDurationLimitationFlag();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public TemplateConfig getMovieConfig() {
        return this.cutSession.getMovieConfig();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public float getOriginVolume(float defaultVolume) {
        return this.cutSession.getOriginVolume(defaultVolume);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public IPlayer getPlayer() {
        return this.cutSession.getPlayer();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public LAKRenderModel getRenderModel() {
        return this.cutSession.getRenderModel();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public Entity getRootEntity() {
        return this.cutSession.getRootEntity();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public long getTotalDurationUs() {
        return this.cutSession.getTotalDurationUs();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public Boolean needRenderAbility(@NotNull String aiType) {
        Intrinsics.checkNotNullParameter(aiType, "aiType");
        return this.cutSession.needRenderAbility(aiType);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void notifyReloadAsset() {
        this.cutSession.notifyReloadAsset();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void pushCustomCommand(@NotNull Function1<? super ICutSession, Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.cutSession.pushCustomCommand(runnable);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void pushCustomCommandSync(@NotNull Function1<? super ICutSession, Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.cutSession.pushCustomCommandSync(runnable);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @NotNull
    public <T extends Component> List<Entity> queryEntityByComponent(@NotNull KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.cutSession.queryEntityByComponent(clazz);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void registerFont(@NotNull String fontFamily, @NotNull String fontStyle, @NotNull String fontPath) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontStyle, "fontStyle");
        Intrinsics.checkNotNullParameter(fontPath, "fontPath");
        this.cutSession.registerFont(fontFamily, fontStyle, fontPath);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void release() {
        this.cutSession.release();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void removeEntity(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.removeEntity(entity);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    @Nullable
    public InputSource removeInputSource(@NotNull String sourceKey) {
        Intrinsics.checkNotNullParameter(sourceKey, "sourceKey");
        return this.cutSession.removeInputSource(sourceKey);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void removeRenderCallback(@NotNull IRenderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.cutSession.removeRenderCallback(callback);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void removeRenderNode(@NotNull BaseEffectNode effectNode) {
        Intrinsics.checkNotNullParameter(effectNode, "effectNode");
        this.cutSession.removeRenderNode(effectNode);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void removeSessionListener(@NotNull ISessionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cutSession.removeSessionListener(listener);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void runOnPlayerThread(@NotNull Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.cutSession.runOnPlayerThread(runnable);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void seek(long timeUs) {
        this.cutSession.seek(timeUs);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setAssetData(@NotNull String templatePath, @NotNull HashMap<String, String> assetData) {
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        Intrinsics.checkNotNullParameter(assetData, "assetData");
        this.cutSession.setAssetData(templatePath, assetData);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setBgColor(int bgColor) {
        this.cutSession.setBgColor(bgColor);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setCutStatusListener(@Nullable ICutStatusCallback listener) {
        this.cutSession.setCutStatusListener(listener);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setDedaultRenderModel() {
        this.cutSession.setDedaultRenderModel();
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setLoadAssetListener(@NotNull OnLoadAssetListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cutSession.setLoadAssetListener(listener);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setMediasTotalDurationLimitationFlag(boolean isLimited) {
        this.cutSession.setMediasTotalDurationLimitationFlag(isLimited);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setOriginVolume(float volume) {
        this.cutSession.setOriginVolume(volume);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setOriginVolumeForClip(int index, float volume) {
        this.cutSession.setOriginVolumeForClip(index, volume);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setRenderModel(@NotNull LAKRenderModel LAKRenderModel) {
        Intrinsics.checkNotNullParameter(LAKRenderModel, "LAKRenderModel");
        this.cutSession.setRenderModel(LAKRenderModel);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setRenderTimeListener(@NotNull IRenderTimeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cutSession.setRenderTimeListener(listener);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setTemplateDir(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.cutSession.setTemplateDir(path);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setTransition(@NotNull Entity entity, int index) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.setTransition(entity, index);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setWatermarkConfig(@Nullable WatermarkConfig config) {
        this.cutSession.setWatermarkConfig(config);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void switchEntity(@NotNull Entity entity, boolean enable) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.switchEntity(entity, enable);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void switchEntitySync(@NotNull Entity entity, boolean enable) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.cutSession.switchEntitySync(entity, enable);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void switchPicEnhanceAbility(@NotNull Constants.ENHANCE_TYPE type, boolean enable) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.cutSession.switchPicEnhanceAbility(type, enable);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void unbindCutPlayer(@Nullable IPlayer player) {
        this.cutSession.unbindCutPlayer(player);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void unbindPlayer(@Nullable IPlayer player) {
        this.cutSession.unbindPlayer(player);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateBackground(int backgroundFillMode, @NotNull String backColor, @Nullable String pagFilePath) {
        Intrinsics.checkNotNullParameter(backColor, "backColor");
        this.cutSession.updateBackground(backgroundFillMode, backColor, pagFilePath);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateRenderSize(@NotNull Size renderSize) {
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        this.cutSession.updateRenderSize(renderSize);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public boolean updateTrackedStickerPosition(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, @NotNull Entity entity, @Nullable IStickerUpdateCallback callback) {
        Intrinsics.checkNotNullParameter(stickerName, "stickerName");
        Intrinsics.checkNotNullParameter(entity, "entity");
        return this.cutSession.updateTrackedStickerPosition(stickerTrackerResult, stickerName, entity, callback);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateVolume(float volume) {
        this.cutSession.updateVolume(volume);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void addEffect(@NotNull Entity entity, @NotNull EntityNodeType entityType, int index) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        this.cutSession.addEffect(entity, entityType, index);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void flushWithoutDelay(boolean needFlushPlayer, long targetTime) {
        this.cutSession.flushWithoutDelay(needFlushPlayer, targetTime);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void setRenderModel(@NotNull LAKRenderModel LAKRenderModel, boolean needInitTemplate) {
        Intrinsics.checkNotNullParameter(LAKRenderModel, "LAKRenderModel");
        this.cutSession.setRenderModel(LAKRenderModel, needInitTemplate);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateRenderSize(@NotNull Size renderSize, float fillScale) {
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        this.cutSession.updateRenderSize(renderSize, fillScale);
    }

    @Override // com.tencent.tavcut.core.session.ICutSession
    public void updateVolume(float volume, @Nullable AudioSourceType type) {
        this.cutSession.updateVolume(volume, type);
    }
}
