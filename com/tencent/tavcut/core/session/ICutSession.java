package com.tencent.tavcut.core.session;

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
import com.tencent.tavcut.core.operator.d;
import com.tencent.tavcut.core.render.builder.light.Constants;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.TextPlaceInfo;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
import sd4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0004H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\tH&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H&J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\fH&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u0018H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u0018H&J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"H&J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"H&J\"\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020'2\b\b\u0002\u0010#\u001a\u00020\"H&J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H&J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J\u001a\u0010,\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"H&J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H&J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010.\u001a\u00020\fH&J\u0018\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010.\u001a\u00020\fH&J&\u00106\u001a\b\u0012\u0004\u0012\u00020 05\"\b\b\u0000\u00102*\u0002012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003H&J\u0010\u00107\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H&J\"\u0010>\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u00182\b\u0010=\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020?H&J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010@\u001a\u00020?H&J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\"H&J\u0018\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u0002082\u0006\u0010F\u001a\u00020EH&J\u001a\u0010J\u001a\u00020\u00042\u0006\u0010G\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010HH&J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010G\u001a\u00020EH&J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020KH&J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010L\u001a\u00020KH&J\b\u0010P\u001a\u00020OH&J\u0010\u0010S\u001a\u00020\u00042\u0006\u0010R\u001a\u00020QH&J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010R\u001a\u00020QH&J\u001e\u0010X\u001a\b\u0012\u0004\u0012\u00020\"0W2\u0006\u0010U\u001a\u00020E2\u0006\u0010V\u001a\u00020EH&J\u001a\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010U\u001a\u00020E2\u0006\u0010V\u001a\u00020EH&J\u0018\u0010\\\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u0001052\u0006\u0010[\u001a\u00020\"H&J\n\u0010]\u001a\u0004\u0018\u00010\u0002H&J\b\u0010^\u001a\u00020\u0004H&J \u0010b\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u00182\u0006\u0010`\u001a\u00020\u00182\u0006\u0010a\u001a\u00020\u0018H&J\b\u0010c\u001a\u00020\u0004H&J\b\u0010d\u001a\u00020\u0004H&J\b\u0010e\u001a\u00020\u0004H&J\u001a\u0010d\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\f2\b\b\u0002\u0010g\u001a\u00020\u0011H&J\u0010\u0010i\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u0011H&J\b\u0010j\u001a\u00020\u0011H&J\b\u0010l\u001a\u00020kH&J\u0018\u0010n\u001a\u00020\u00042\u0006\u0010I\u001a\u00020m2\u0006\u0010.\u001a\u00020\fH&J4\u0010s\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u00182\"\u0010r\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180pj\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018`qH&J\u0019\u0010u\u001a\u0004\u0018\u00010\f2\u0006\u0010t\u001a\u00020\u0018H&\u00a2\u0006\u0004\bu\u0010vJ\u0019\u0010y\u001a\f\u0012\u0006\b\u0001\u0012\u00020x\u0018\u00010wH&\u00a2\u0006\u0004\by\u0010zJ\u0010\u0010|\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u0018H&J\u0010\u0010~\u001a\u00020\u00042\u0006\u0010L\u001a\u00020}H&J\u0011\u0010\u0080\u0001\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u007fH&J\u0014\u0010\u0082\u0001\u001a\u00020\u00042\t\u0010L\u001a\u0005\u0018\u00010\u0081\u0001H&J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001H&J\u0011\u0010\u0085\u0001\u001a\u00020\u00042\u0006\u0010G\u001a\u00020EH&J\u0014\u0010\u0087\u0001\u001a\u00020E2\t\b\u0002\u0010\u0086\u0001\u001a\u00020EH&J\u0019\u0010\u0088\u0001\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010G\u001a\u00020EH&J\u0012\u0010\u008a\u0001\u001a\u00020\u00042\u0007\u0010\u0089\u0001\u001a\u00020\fH&J\u0014\u0010\u008b\u0001\u001a\u0004\u0018\u00010\fH&\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0012\u0010\u008e\u0001\u001a\u00020\f2\u0007\u0010\u008d\u0001\u001a\u000201H&J\u001d\u0010\u0093\u0001\u001a\u00020\"2\b\u0010\u0090\u0001\u001a\u00030\u008f\u00012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001H&J9\u0010\u0098\u0001\u001a\u00020\f2\u0010\u0010\u0095\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0094\u0001\u0018\u00010W2\u0007\u0010\u0096\u0001\u001a\u00020\u00182\u0006\u0010!\u001a\u00020 2\u000b\b\u0002\u0010@\u001a\u0005\u0018\u00010\u0097\u0001H&J\u001a\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020 052\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010 H&J\u000b\u0010\u009b\u0001\u001a\u0004\u0018\u00010 H&J\t\u0010\u009c\u0001\u001a\u00020\u0004H&J\u000f\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020 05H&J\f\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u0001H&J\u0019\u0010\u00a2\u0001\u001a\u00020\u00042\u000e\u0010\u00a1\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00a0\u0001H&J%\u0010\u00a5\u0001\u001a\u00020\u00042\u001a\u0010\u00a1\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00a3\u0001\u00a2\u0006\u0003\b\u00a4\u0001H&J%\u0010\u00a6\u0001\u001a\u00020\u00042\u001a\u0010\u00a1\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00a3\u0001\u00a2\u0006\u0003\b\u00a4\u0001H&J\u0015\u0010\u00a9\u0001\u001a\u00020\u00042\n\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u00a7\u0001H&\u00a8\u0006\u00aa\u0001"}, d2 = {"Lcom/tencent/tavcut/core/session/ICutSession;", "", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "player", "", "bindPlayer", "unbindPlayer", "bindCutPlayer", "unbindCutPlayer", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "LAKRenderModel", "setRenderModel", "", "needInitTemplate", "setDedaultRenderModel", "getRenderModel", "getAllInputSourceRenderModel", "", "getTotalDurationUs", "getClipAssetsDurationUs", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "inputSource", "needReloadAsset", "addInputSource", "", "sourceKey", "accessInputSource", "Lcom/google/gson/JsonObject;", "getInputSources", "Lorg/light/lightAssetKit/LightAssetDataContext;", "getLightAssetDataContext", "removeInputSource", "Lorg/light/lightAssetKit/Entity;", "entity", "", "index", "addVideoSourceEntity", "addVideoSourceEntityAfterLutFilter", "addEffect", "Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "entityType", "addClipEffect", "setTransition", "addBgm", "addHDR", "addRenderTarget", "enable", "switchEntity", "switchEntitySync", "Lorg/light/lightAssetKit/components/Component;", "T", "Lkotlin/reflect/KClass;", "clazz", "", "queryEntityByComponent", "removeEntity", "Lorg/light/lightAssetKit/components/Size;", "renderSize", "updateRenderSize", "backgroundFillMode", "backColor", Constants.PAG_FILE_PATH, "updateBackground", "Lcom/tencent/tavcut/core/session/IRenderCallback;", "callback", "addRenderCallback", "removeRenderCallback", "bgColor", "setBgColor", "", "fillScale", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "Lorg/light/lightAssetKit/enums/AudioSourceType;", "type", "updateVolume", "Lcom/tencent/tavcut/core/session/ISessionListener;", "listener", "addSessionListener", "removeSessionListener", "Lcom/tencent/tavcut/core/operator/IClipSourceOperator;", "getClipSourceOperator", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "effectNode", "addRenderNode", "removeRenderNode", HippyTKDListViewAdapter.X, "y", "Ljava/util/ArrayList;", "getEntitiesUnderPoint", "Lcom/tencent/tavcut/core/render/builder/light/model/TextPlaceInfo;", "getEditableTextUnderPoint", TemplateParser.KEY_ENTITY_ID, "getEditableTextByEntityId", "getPlayer", "release", "fontFamily", "fontStyle", "fontPath", "registerFont", HippyQQPagView.FunctionName.FLUSH, "flushWithoutDelay", "emit", "needFlushPlayer", "targetTime", "timeUs", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "getFrameDuration", "Lcom/tencent/tavcut/core/operator/d;", "getComponentOperator", "Lcom/tencent/tavcut/core/render/builder/light/Constants$ENHANCE_TYPE;", "switchPicEnhanceAbility", "templatePath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "setAssetData", "aiType", "needRenderAbility", "(Ljava/lang/String;)Ljava/lang/Boolean;", "", "Lorg/light/MaterialConfig;", "getMaterialConfig", "()[Lorg/light/MaterialConfig;", "path", "setTemplateDir", "Lorg/light/listener/OnLoadAssetListener;", "setLoadAssetListener", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "setRenderTimeListener", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "setCutStatusListener", "Lorg/light/LightAsset;", "getLightAsset", "setOriginVolume", "defaultVolume", "getOriginVolume", "setOriginVolumeForClip", "isLimited", "setMediasTotalDurationLimitationFlag", "getMediasTotalDurationLimitationFlag", "()Ljava/lang/Boolean;", HippyQQConstants.URL_COMPONENT_NAME, "componentSupportDynamicModify", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager;", "stickerTrackerManager", "Lsd4/b;", "stickerTrackerConfig", "createStickerTrackerManager", "Lcom/gyailib/library/GYTrackStickerInfo;", "stickerTrackerResult", "stickerName", "Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;", "updateTrackedStickerPosition", "rootEntity", "getAllTextEntity", "getRootEntity", "notifyReloadAsset", "getAllImageStickerEntitys", "Lorg/light/TemplateConfig;", "getMovieConfig", "Lkotlin/Function0;", "runnable", "runOnPlayerThread", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "pushCustomCommand", "pushCustomCommandSync", "Lorg/light/WatermarkConfig;", DownloadInfo.spKey_Config, "setWatermarkConfig", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface ICutSession {
    @Nullable
    InputSource accessInputSource(@NotNull String sourceKey);

    void addBgm(@NotNull Entity entity);

    void addClipEffect(@NotNull Entity entity);

    void addEffect(@NotNull Entity entity, int index);

    void addEffect(@NotNull Entity entity, @NotNull EntityNodeType entityType, int index);

    void addHDR(@NotNull Entity entity, int index);

    void addInputSource(@NotNull InputSource inputSource, boolean needReloadAsset);

    void addRenderCallback(@NotNull IRenderCallback callback);

    void addRenderNode(@NotNull BaseEffectNode effectNode);

    void addRenderTarget(@NotNull Entity entity, int index);

    void addSessionListener(@NotNull ISessionListener listener);

    void addVideoSourceEntity(@NotNull Entity entity, int index);

    void addVideoSourceEntityAfterLutFilter(@NotNull Entity entity);

    @NotNull
    IPlayer bindCutPlayer(@NotNull IPlayer player);

    void bindPlayer(@NotNull IPlayer player);

    boolean componentSupportDynamicModify(@NotNull Component component);

    int createStickerTrackerManager(@NotNull StickerTrackerManager stickerTrackerManager, @NotNull b stickerTrackerConfig);

    void emit();

    void flush();

    void flushWithoutDelay();

    void flushWithoutDelay(boolean needFlushPlayer, long targetTime);

    @NotNull
    List<Entity> getAllImageStickerEntitys();

    @Nullable
    LAKRenderModel getAllInputSourceRenderModel();

    @NotNull
    List<Entity> getAllTextEntity(@Nullable Entity rootEntity);

    long getClipAssetsDurationUs();

    @NotNull
    IClipSourceOperator getClipSourceOperator();

    @NotNull
    d getComponentOperator();

    @Nullable
    List<TextPlaceInfo> getEditableTextByEntityId(int entityId);

    @Nullable
    TextPlaceInfo getEditableTextUnderPoint(float x16, float y16);

    @NotNull
    ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16);

    long getFrameDuration();

    @Nullable
    JsonObject getInputSources();

    @Nullable
    LightAsset getLightAsset();

    @Nullable
    LightAssetDataContext getLightAssetDataContext();

    @Nullable
    MaterialConfig[] getMaterialConfig();

    @Nullable
    Boolean getMediasTotalDurationLimitationFlag();

    @Nullable
    TemplateConfig getMovieConfig();

    float getOriginVolume(float defaultVolume);

    @Nullable
    IPlayer getPlayer();

    @Nullable
    LAKRenderModel getRenderModel();

    @Nullable
    Entity getRootEntity();

    long getTotalDurationUs();

    @Nullable
    Boolean needRenderAbility(@NotNull String aiType);

    void notifyReloadAsset();

    void pushCustomCommand(@NotNull Function1<? super ICutSession, Unit> runnable);

    void pushCustomCommandSync(@NotNull Function1<? super ICutSession, Unit> runnable);

    @NotNull
    <T extends Component> List<Entity> queryEntityByComponent(@NotNull KClass<T> clazz);

    void registerFont(@NotNull String fontFamily, @NotNull String fontStyle, @NotNull String fontPath);

    void release();

    void removeEntity(@NotNull Entity entity);

    @Nullable
    InputSource removeInputSource(@NotNull String sourceKey);

    void removeRenderCallback(@NotNull IRenderCallback callback);

    void removeRenderNode(@NotNull BaseEffectNode effectNode);

    void removeSessionListener(@NotNull ISessionListener listener);

    void runOnPlayerThread(@NotNull Function0<Unit> runnable);

    void seek(long timeUs);

    void setAssetData(@NotNull String templatePath, @NotNull HashMap<String, String> assetData);

    void setBgColor(int bgColor);

    void setCutStatusListener(@Nullable ICutStatusCallback listener);

    void setDedaultRenderModel();

    void setLoadAssetListener(@NotNull OnLoadAssetListener listener);

    void setMediasTotalDurationLimitationFlag(boolean isLimited);

    void setOriginVolume(float volume);

    void setOriginVolumeForClip(int index, float volume);

    void setRenderModel(@NotNull LAKRenderModel LAKRenderModel);

    void setRenderModel(@NotNull LAKRenderModel LAKRenderModel, boolean needInitTemplate);

    void setRenderTimeListener(@NotNull IRenderTimeListener listener);

    void setTemplateDir(@NotNull String path);

    void setTransition(@NotNull Entity entity, int index);

    void setWatermarkConfig(@Nullable WatermarkConfig config);

    void switchEntity(@NotNull Entity entity, boolean enable);

    void switchEntitySync(@NotNull Entity entity, boolean enable);

    void switchPicEnhanceAbility(@NotNull Constants.ENHANCE_TYPE type, boolean enable);

    void unbindCutPlayer(@Nullable IPlayer player);

    void unbindPlayer(@Nullable IPlayer player);

    void updateBackground(int backgroundFillMode, @NotNull String backColor, @Nullable String pagFilePath);

    void updateRenderSize(@NotNull Size renderSize);

    void updateRenderSize(@NotNull Size renderSize, float fillScale);

    boolean updateTrackedStickerPosition(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, @NotNull Entity entity, @Nullable IStickerUpdateCallback callback);

    void updateVolume(float volume);

    void updateVolume(float volume, @Nullable AudioSourceType type);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void addEffect$default(ICutSession iCutSession, Entity entity, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = -1;
                }
                iCutSession.addEffect(entity, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEffect");
        }

        public static /* synthetic */ void addHDR$default(ICutSession iCutSession, Entity entity, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = -1;
                }
                iCutSession.addHDR(entity, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHDR");
        }

        public static /* synthetic */ void addInputSource$default(ICutSession iCutSession, InputSource inputSource, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                iCutSession.addInputSource(inputSource, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addInputSource");
        }

        public static /* synthetic */ void addVideoSourceEntity$default(ICutSession iCutSession, Entity entity, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = -1;
                }
                iCutSession.addVideoSourceEntity(entity, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addVideoSourceEntity");
        }

        public static /* synthetic */ void flushWithoutDelay$default(ICutSession iCutSession, boolean z16, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                iCutSession.flushWithoutDelay(z16, j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flushWithoutDelay");
        }

        public static /* synthetic */ float getOriginVolume$default(ICutSession iCutSession, float f16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    f16 = 0.0f;
                }
                return iCutSession.getOriginVolume(f16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOriginVolume");
        }

        public static /* synthetic */ void setRenderModel$default(ICutSession iCutSession, LAKRenderModel lAKRenderModel, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                iCutSession.setRenderModel(lAKRenderModel, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRenderModel");
        }

        public static /* synthetic */ boolean updateTrackedStickerPosition$default(ICutSession iCutSession, ArrayList arrayList, String str, Entity entity, IStickerUpdateCallback iStickerUpdateCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    iStickerUpdateCallback = null;
                }
                return iCutSession.updateTrackedStickerPosition(arrayList, str, entity, iStickerUpdateCallback);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTrackedStickerPosition");
        }

        public static /* synthetic */ void addEffect$default(ICutSession iCutSession, Entity entity, EntityNodeType entityNodeType, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = -1;
                }
                iCutSession.addEffect(entity, entityNodeType, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEffect");
        }
    }
}
