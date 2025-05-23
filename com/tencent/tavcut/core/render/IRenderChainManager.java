package com.tencent.tavcut.core.render;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.core.dataprocessor.EntityNodeType;
import com.tencent.tavcut.core.render.builder.light.Constants;
import com.tencent.tavcut.core.render.builder.light.model.CustomRenderConfig;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.TextPlaceInfo;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.tavcut.core.render.builder.light.model.type.VoiceEnum;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.IRenderCallback;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipAsset;
import org.light.LightAsset;
import org.light.MaterialConfig;
import org.light.TemplateConfig;
import org.light.callback.ExternalRenderCallback;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.Size;
import org.light.listener.OnClipAssetListener;
import org.light.listener.OnLoadAssetListener;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000bH&J \u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0010H&J0\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100$\"\b\b\u0000\u0010%*\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0'H&J\n\u0010(\u001a\u0004\u0018\u00010\u0010H&J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020*0$H&J\b\u0010+\u001a\u00020,H&J0\u0010-\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b2\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010$2\u0006\u00100\u001a\u00020\u0012H&J\u001a\u00101\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H&J\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u0012062\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H&J\n\u00107\u001a\u0004\u0018\u000108H&J\n\u00109\u001a\u0004\u0018\u00010:H&J\u0017\u0010;\u001a\f\u0012\u0006\b\u0001\u0012\u00020=\u0018\u00010<H&\u00a2\u0006\u0002\u0010>J\u000f\u0010?\u001a\u0004\u0018\u00010\u001dH&\u00a2\u0006\u0002\u0010@J\n\u0010A\u001a\u0004\u0018\u00010BH&J\b\u0010C\u001a\u00020,H&J\u0012\u0010D\u001a\u0002032\b\b\u0002\u0010E\u001a\u000203H&J\b\u0010F\u001a\u00020,H&J\n\u0010G\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u0003H&J\u0017\u0010J\u001a\u0004\u0018\u00010\u001d2\u0006\u0010K\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020\u0007H&J\"\u0010N\u001a\u00020\u00072\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00070PH&J\"\u0010Q\u001a\u00020\u00072\u0018\u0010O\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0$\u0012\u0004\u0012\u00020\u00070RH&J\b\u0010T\u001a\u00020\u0007H&J$\u0010U\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010V\u001a\u0004\u0018\u00010W2\b\b\u0002\u0010X\u001a\u00020,H&J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0010H&J\u0010\u0010Z\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010[\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H&J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H&J0\u0010a\u001a\u00020\u00072&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000bH&J\u0012\u0010b\u001a\u00020\u00072\b\u0010c\u001a\u0004\u0018\u00010dH&J\u0012\u0010e\u001a\u00020\u00072\b\u0010f\u001a\u0004\u0018\u00010gH&J\u0010\u0010h\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u001dH&J\u0018\u0010j\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u00052\u0006\u0010l\u001a\u00020\u0005H&J\u0010\u0010m\u001a\u00020\u00072\u0006\u0010c\u001a\u00020nH&J\u0010\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u001dH&J\u0010\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u000203H&J\u0018\u0010s\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010r\u001a\u000203H&J\u0010\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020,H&J\u0018\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u0012H&J\u0010\u0010y\u001a\u00020\u00072\u0006\u0010c\u001a\u00020zH&J\u0012\u0010{\u001a\u00020\u00072\b\u0010|\u001a\u0004\u0018\u00010}H&J\u0019\u0010~\u001a\u00020\u00072\u000f\u0010\u007f\u001a\u000b\u0012\u0005\u0012\u00030\u0080\u0001\u0018\u00010$H&J\u001b\u0010\u0081\u0001\u001a\u00020\u00072\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010w\u001a\u00020\u001dH&J\u0019\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0013\u0010\u0085\u0001\u001a\u00020\u00072\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H&J\u0013\u0010\u0088\u0001\u001a\u00020\u00072\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H&J\u0011\u0010\u0089\u0001\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0003H&\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/tavcut/core/render/IRenderChainManager;", "", "accessInputSource", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "key", "", "addAssetDataToHolder", "", "templateDir", "assetData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "addEntity", "entityNodeType", "Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "entityToAdd", "Lorg/light/lightAssetKit/Entity;", "index", "", "addExternalRenderCallback", "externalRenderCallback", "Lorg/light/callback/ExternalRenderCallback;", "addRenderCallback", "callback", "Lcom/tencent/tavcut/core/session/IRenderCallback;", "addRenderNode", "effectNode", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "componentSupportDynamicModify", "", HippyQQConstants.URL_COMPONENT_NAME, "Lorg/light/lightAssetKit/components/Component;", "emit", "entitySupportDynamicAdd", "entity", "findEntitiesByComponent", "", "T", "componentClass", "Lkotlin/reflect/KClass;", "findMultiMediaEntity", "getClipAssets", "Lorg/light/ClipAsset;", "getClipAssetsDuration", "", "getCurrentAssetData", "getEditableTextByEntityId", "Lcom/tencent/tavcut/core/render/builder/light/model/TextPlaceInfo;", TemplateParser.KEY_ENTITY_ID, "getEditableTextUnderPoint", HippyTKDListViewAdapter.X, "", "y", "getEntitiesUnderPoint", "Ljava/util/ArrayList;", "getLightAsset", "Lorg/light/LightAsset;", "getLightAssetContext", "Lorg/light/lightAssetKit/LightAssetDataContext;", "getMaterialConfig", "", "Lorg/light/MaterialConfig;", "()[Lorg/light/MaterialConfig;", "getMediasTotalDurationLimitationFlag", "()Ljava/lang/Boolean;", "getMovieConfig", "Lorg/light/TemplateConfig;", "getMovieControllerDuration", "getOriginVolume", "defaultVolume", "getPlayerDuration", "getRootEntity", "isInputSourceAdded", "inputSource", "needRenderAbility", "aiType", "(Ljava/lang/String;)Ljava/lang/Boolean;", "notifyDurationChange", "registerDurationObserver", "observer", "Lkotlin/Function2;", "registerTimelineObserver", "Lkotlin/Function1;", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "release", "reloadAsset", "lakRenderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "targetTime", "removeEntity", "removeExternalRenderCallback", "removeRenderCallback", "removeRenderNode", "runOnAfterApply", "runnable", "Ljava/lang/Runnable;", "runOnBeforeApply", "setAssetData", "setClipAssetListener", "listener", "Lorg/light/listener/OnClipAssetListener;", "setCustomRenderConfig", "customRenderConfig", "Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "setIsUseTemplateTime", "isUseTemplateTime", "setLightAIModelPath", "agentName", "bundlePath", "setLoadAssetListener", "Lorg/light/listener/OnLoadAssetListener;", "setMediasTotalDurationLimitationFlag", "isLimited", "setOriginVolume", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setOriginVolumeForClip", "setRenderNodeDuration", "duration", "setRenderSyncMode", "enable", "frameRate", "setRenderTimeListener", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "setRenderTimeRange", "renderTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "setVoiceChangerConfig", DownloadInfo.spKey_Config, "Lcom/tencent/tavcut/core/render/builder/light/model/type/VoiceEnum;", "switchPicEnhanceAbility", "type", "Lcom/tencent/tavcut/core/render/builder/light/Constants$ENHANCE_TYPE;", "updateComponent", "updatePropertyLayout", "size", "Lorg/light/lightAssetKit/components/Size;", "updateRenderSize", "updateResource", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IRenderChainManager {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ float getOriginVolume$default(IRenderChainManager iRenderChainManager, float f16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    f16 = 0.0f;
                }
                return iRenderChainManager.getOriginVolume(f16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOriginVolume");
        }

        public static /* synthetic */ void reloadAsset$default(IRenderChainManager iRenderChainManager, String str, LAKRenderModel lAKRenderModel, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    j3 = -1;
                }
                iRenderChainManager.reloadAsset(str, lAKRenderModel, j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadAsset");
        }
    }

    @Nullable
    InputSource accessInputSource(@NotNull String key);

    void addAssetDataToHolder(@NotNull String templateDir, @NotNull HashMap<String, String> assetData);

    void addEntity(@NotNull EntityNodeType entityNodeType, @NotNull Entity entityToAdd, int index);

    void addExternalRenderCallback(@NotNull String key, @Nullable ExternalRenderCallback externalRenderCallback);

    void addRenderCallback(@NotNull IRenderCallback callback);

    void addRenderNode(@NotNull BaseEffectNode effectNode);

    boolean componentSupportDynamicModify(@NotNull Component component);

    void emit();

    boolean entitySupportDynamicAdd(@NotNull Entity entity);

    @NotNull
    <T extends Component> List<Entity> findEntitiesByComponent(@Nullable Entity entity, @NotNull KClass<T> componentClass);

    @Nullable
    Entity findMultiMediaEntity();

    @NotNull
    List<ClipAsset> getClipAssets();

    long getClipAssetsDuration();

    @Nullable
    HashMap<String, String> getCurrentAssetData(@NotNull String templateDir);

    @Nullable
    List<TextPlaceInfo> getEditableTextByEntityId(int entityId);

    @Nullable
    TextPlaceInfo getEditableTextUnderPoint(float x16, float y16);

    @NotNull
    ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16);

    @Nullable
    LightAsset getLightAsset();

    @Nullable
    LightAssetDataContext getLightAssetContext();

    @Nullable
    MaterialConfig[] getMaterialConfig();

    @Nullable
    Boolean getMediasTotalDurationLimitationFlag();

    @Nullable
    TemplateConfig getMovieConfig();

    long getMovieControllerDuration();

    float getOriginVolume(float defaultVolume);

    long getPlayerDuration();

    @Nullable
    Entity getRootEntity();

    boolean isInputSourceAdded(@NotNull InputSource inputSource);

    @Nullable
    Boolean needRenderAbility(@NotNull String aiType);

    void notifyDurationChange();

    void registerDurationObserver(@NotNull Function2<? super Long, ? super Long, Unit> observer);

    void registerTimelineObserver(@NotNull Function1<? super List<Timeline>, Unit> observer);

    void release();

    void reloadAsset(@NotNull String templateDir, @Nullable LAKRenderModel lakRenderModel, long targetTime);

    void removeEntity(@NotNull Entity entity);

    void removeExternalRenderCallback(@NotNull String key);

    void removeRenderCallback(@NotNull IRenderCallback callback);

    void removeRenderNode(@NotNull BaseEffectNode effectNode);

    void runOnAfterApply(@NotNull Runnable runnable);

    void runOnBeforeApply(@NotNull Runnable runnable);

    void setAssetData(@Nullable HashMap<String, String> assetData);

    void setClipAssetListener(@Nullable OnClipAssetListener listener);

    void setCustomRenderConfig(@Nullable CustomRenderConfig customRenderConfig);

    void setIsUseTemplateTime(boolean isUseTemplateTime);

    void setLightAIModelPath(@NotNull String agentName, @NotNull String bundlePath);

    void setLoadAssetListener(@NotNull OnLoadAssetListener listener);

    void setMediasTotalDurationLimitationFlag(boolean isLimited);

    void setOriginVolume(float volume);

    void setOriginVolumeForClip(int index, float volume);

    void setRenderNodeDuration(long duration);

    void setRenderSyncMode(boolean enable, int frameRate);

    void setRenderTimeListener(@NotNull IRenderTimeListener listener);

    void setRenderTimeRange(@Nullable CMTimeRange renderTimeRange);

    void setVoiceChangerConfig(@Nullable List<? extends VoiceEnum> config);

    void switchPicEnhanceAbility(@NotNull Constants.ENHANCE_TYPE type, boolean enable);

    void updateComponent(int entityId, @NotNull Component component);

    void updatePropertyLayout(@NotNull Size size);

    void updateRenderSize(@NotNull Size size);

    void updateResource(@NotNull InputSource inputSource);
}
