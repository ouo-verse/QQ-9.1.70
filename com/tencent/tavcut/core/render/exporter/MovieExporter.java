package com.tencent.tavcut.core.render.exporter;

import android.opengl.EGLContext;
import android.text.TextUtils;
import android.util.Log;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.RenderConfig;
import com.tencent.tavcut.core.render.builder.IMediaBuilder;
import com.tencent.tavcut.core.render.builder.MediaBuildFactory;
import com.tencent.tavcut.core.render.builder.MediaBuilderOutput;
import com.tencent.tavcut.core.render.builder.light.Constants;
import com.tencent.tavcut.core.render.builder.light.LightSDKUtils;
import com.tencent.tavcut.core.render.builder.light.model.CustomRenderConfig;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.RenderScene;
import com.tencent.tavcut.core.render.exporter.IExporter;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.IRenderCallback;
import com.tencent.tavcut.core.utils.c;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.report.TAVReportUtils;
import com.tencent.tavkit.tavffmpeg.FFmpegVideoEncoder;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.PerformanceMonitor;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.Vec3;
import org.light.listener.OnClipAssetListener;
import org.light.listener.OnLoadAssetListener;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u0000 g2\u00020\u0001:\u0001gB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010\f\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0016J>\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\t2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0002J \u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J(\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\tH\u0016J2\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J1\u0010%\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0000\u00a2\u0006\u0002\b4J,\u0010%\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u0002032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u001d\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0000\u00a2\u0006\u0002\b7J\b\u00108\u001a\u00020\tH\u0002J\b\u00109\u001a\u00020\tH\u0016J\u0012\u0010:\u001a\u0004\u0018\u0001012\u0006\u0010;\u001a\u00020)H\u0002J\u0010\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020\u0014H\u0002J\u001a\u0010>\u001a\u0004\u0018\u00010\u001e2\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020AH\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010\u001e2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020#H\u0016J\u0018\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020)H\u0016J4\u0010G\u001a\u00020#2\u0006\u0010*\u001a\u00020)2\"\u0010H\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0Ij\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)`JH\u0016J\u000e\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020\u000bJ\u0012\u0010M\u001a\u00020#2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010N\u001a\u00020#2\b\u0010L\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010O\u001a\u00020#2\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020#2\u0006\u0010S\u001a\u00020A2\u0006\u0010P\u001a\u00020QH\u0016J\u0016\u0010T\u001a\u00020#2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180UH\u0016J\u0018\u0010V\u001a\u00020#2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020AH\u0016J\u0010\u0010Y\u001a\u00020#2\u0006\u0010Z\u001a\u00020\u001aH\u0016J\u0018\u0010[\u001a\u00020#2\u0006\u0010\\\u001a\u00020]2\u0006\u0010W\u001a\u00020\tH\u0016J&\u0010^\u001a\u00020#2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J(\u0010d\u001a\u00020\t2\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010e\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0016J(\u0010d\u001a\u00020\t2\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010e\u001a\u00020)2\u0006\u0010f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006h"}, d2 = {"Lcom/tencent/tavcut/core/render/exporter/MovieExporter;", "Lcom/tencent/tavcut/core/render/exporter/IExporter;", "renderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "customRenderConfig", "Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "(Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;)V", "(Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;)V", "canceled", "", "clipAssetListener", "Lorg/light/listener/OnClipAssetListener;", "enableSoftEncoder", "errorInterceptor", "Lcom/tencent/tavcut/core/render/exporter/IExporter$ExportErrorInterceptor;", "exportListener", "Lcom/tencent/tavcut/core/render/exporter/IExporter$ExportListener;", "exportRenderChainManager", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "exportSession", "Lcom/tencent/tav/core/AssetExportSession;", "exporting", "renderNodes", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "startCMTimeExport", "Lcom/tencent/tav/coremedia/CMTime;", "kotlin.jvm.PlatformType", "trackedStickerResultMap", "", "Lorg/light/lightAssetKit/Entity;", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "useSoftEncoder", "cancelExport", "", NodeProps.ENABLED, AssetExtension.SCENE_EXPORT, "exportOutput", "Lcom/tencent/tavcut/core/render/exporter/ExportOutput;", "destPath", "", "templatePath", "isUE4Template", "eglContext", "Landroid/opengl/EGLContext;", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "destFile", "Ljava/io/File;", "exportConfig", "Lcom/tencent/tav/core/ExportConfig;", "export$lib_tavcut_debug", "handleExportSessionStatus", "assetExportSession", "handleExportSessionStatus$lib_tavcut_debug", "isCanceled", "isExporting", "newOutputFile", "outputPath", "onErrorIntercept", SessionDbHelper.SESSION_ID, "queryEntity", "rootEntity", TemplateParser.KEY_ENTITY_ID, "", "queryEntityByEntityId", "release", "setAIBundlePath", "agentName", "bundlePath", "setAssetData", "assetData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setClipAssetListener", "listener", "setErrorInterceptor", "setExportListener", "setOriginVolume", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "setOriginVolumeForClip", "index", "setRenderNodes", "", "setRenderSyncMode", "enable", "frameRate", "setStartExportTime", "startExportTime", "switchPicEnhance", "type", "Lcom/tencent/tavcut/core/render/builder/light/Constants$ENHANCE_TYPE;", "updateStickerPosition", "stickerTransform", "Lorg/light/lightAssetKit/components/ScreenTransform;", "time", "", "stickerTrackerResult", "updateTrackedStickerPosition", "stickerName", "entity", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class MovieExporter implements IExporter {

    @NotNull
    public static final String FILE_TYPE = "MP4";
    private static final int SOFT_EXPORT_AUDIO_COUNT = 1;

    @NotNull
    public static final String TAG = "MovieExporter";
    private boolean canceled;
    private OnClipAssetListener clipAssetListener;
    private CustomRenderConfig customRenderConfig;
    private boolean enableSoftEncoder;
    private IExporter.ExportErrorInterceptor errorInterceptor;
    private IExporter.ExportListener exportListener;
    private IRenderChainManager exportRenderChainManager;
    private AssetExportSession exportSession;
    private boolean exporting;
    private final LAKRenderModel renderModel;
    private final List<BaseEffectNode> renderNodes;
    private CMTime startCMTimeExport;
    private final Map<Entity, ArrayList<GYTrackStickerInfo>> trackedStickerResultMap;
    private boolean useSoftEncoder;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AssetExportSession.AssetExportSessionStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting.ordinal()] = 1;
            iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted.ordinal()] = 2;
            iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed.ordinal()] = 3;
            iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusUnknown.ordinal()] = 4;
            iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled.ordinal()] = 5;
        }
    }

    public MovieExporter(@NotNull LAKRenderModel renderModel) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        this.renderModel = renderModel;
        this.trackedStickerResultMap = new LinkedHashMap();
        this.renderNodes = new ArrayList();
        this.startCMTimeExport = CMTime.CMTimeZero;
    }

    static /* synthetic */ void export$default(MovieExporter movieExporter, ExportOutput exportOutput, LAKRenderModel lAKRenderModel, String str, String str2, boolean z16, EGLContext eGLContext, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 32) != 0) {
            eGLContext = null;
        }
        movieExporter.export(exportOutput, lAKRenderModel, str, str2, z17, eGLContext);
    }

    public static /* synthetic */ void export$lib_tavcut_debug$default(MovieExporter movieExporter, TAVComposition tAVComposition, File file, ExportConfig exportConfig, EGLContext eGLContext, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            eGLContext = null;
        }
        movieExporter.export$lib_tavcut_debug(tAVComposition, file, exportConfig, eGLContext);
    }

    private final synchronized boolean isCanceled() {
        return this.canceled;
    }

    private final File newOutputFile(String outputPath) {
        File file = new File(outputPath);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (Exception e16) {
            TavLogger.e(TAG, "export: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onErrorIntercept(AssetExportSession session) {
        session.setMuxerCreator(new FFmpegMuxerCreator());
        session.setVideoEncoder(new FFmpegVideoEncoder());
        ExportConfig exportConfig = session.getExportConfig();
        Intrinsics.checkExpressionValueIsNotNull(exportConfig, "session.exportConfig");
        exportConfig.setAudioChannelCount(1);
        exportConfig.setHighProfile(false);
        exportConfig.setEnableBFrame(false);
        exportConfig.setAudioEncodeAsync(Boolean.FALSE);
        exportConfig.reset();
    }

    private final Entity queryEntity(Entity rootEntity, int entityId) {
        if (rootEntity.getId() == entityId) {
            return rootEntity;
        }
        Intrinsics.checkExpressionValueIsNotNull(rootEntity.getChildren(), "rootEntity.children");
        if (!r0.isEmpty()) {
            List<Entity> children = rootEntity.getChildren();
            Intrinsics.checkExpressionValueIsNotNull(children, "rootEntity.children");
            for (Entity it : children) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if (it.getId() == entityId) {
                    return it;
                }
                Entity queryEntity = queryEntity(it, entityId);
                if (queryEntity != null) {
                    return queryEntity;
                }
            }
            return null;
        }
        return null;
    }

    private final Entity queryEntityByEntityId(int entityId) {
        Entity entity;
        Log.i(TAG, "queryEntityByEntityId " + entityId);
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            entity = iRenderChainManager.getRootEntity();
        } else {
            entity = null;
        }
        if (entity == null) {
            return null;
        }
        return queryEntity(entity, entityId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStickerPosition(ScreenTransform stickerTransform, long time, ArrayList<GYTrackStickerInfo> stickerTrackerResult) {
        GYTrackStickerInfo e16 = c.e(stickerTrackerResult, time);
        if (e16 != null) {
            Log.v(TAG, "export updateStickerPosition: x:" + Float.valueOf(e16.f35992x) + ",y: " + Float.valueOf(e16.f35993y) + ",width: " + Float.valueOf(e16.f35991w) + ", height:" + Float.valueOf(e16.f35990h) + ", time:" + time);
            stickerTransform.setAnchor(c.b(e16));
            stickerTransform.setScale(new Vec3(1.0f, 1.0f, 1.0f));
            stickerTransform.setOffset(c.a(e16));
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void cancelExport() {
        if (!isExporting()) {
            return;
        }
        synchronized (this) {
            this.canceled = true;
            AssetExportSession assetExportSession = this.exportSession;
            if (assetExportSession != null) {
                assetExportSession.cancelExport();
            }
            this.exporting = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void enableSoftEncoder(boolean enabled) {
        this.enableSoftEncoder = enabled;
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void export(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath) {
        Intrinsics.checkParameterIsNotNull(exportOutput, "exportOutput");
        Intrinsics.checkParameterIsNotNull(destPath, "destPath");
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        export(exportOutput, destPath, templatePath, false);
    }

    public final void export$lib_tavcut_debug(@NotNull TAVComposition composition, @NotNull final File destFile, @NotNull ExportConfig exportConfig, @Nullable EGLContext eglContext) {
        Intrinsics.checkParameterIsNotNull(composition, "composition");
        Intrinsics.checkParameterIsNotNull(destFile, "destFile");
        Intrinsics.checkParameterIsNotNull(exportConfig, "exportConfig");
        AssetExportSession assetExportSession = this.exportSession;
        if (assetExportSession != null) {
            assetExportSession.cancelExport();
        }
        this.exportSession = null;
        TAVCompositionBuilder tAVCompositionBuilder = new TAVCompositionBuilder(composition);
        tAVCompositionBuilder.setVideoTracksMerge(false);
        TAVSource source = tAVCompositionBuilder.buildSource();
        Intrinsics.checkExpressionValueIsNotNull(source, "source");
        this.exportSession = new AssetExportSession(source.getAsset(), exportConfig);
        if (eglContext != null) {
            RenderContextParams renderContextParams = new RenderContextParams();
            renderContextParams.putParam("share_context", eglContext);
            AssetExportSession assetExportSession2 = this.exportSession;
            if (assetExportSession2 != null) {
                assetExportSession2.setRenderContextParams(renderContextParams);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("export start Time:");
        CMTime startCMTimeExport = this.startCMTimeExport;
        Intrinsics.checkExpressionValueIsNotNull(startCMTimeExport, "startCMTimeExport");
        sb5.append(startCMTimeExport.getTimeUs());
        TavLogger.e(TAG, sb5.toString());
        AssetExportSession assetExportSession3 = this.exportSession;
        if (assetExportSession3 != null) {
            CMTime cMTime = this.startCMTimeExport;
            Asset asset = source.getAsset();
            Intrinsics.checkExpressionValueIsNotNull(asset, "source.asset");
            assetExportSession3.setTimeRange(new CMTimeRange(cMTime, asset.getDuration()));
        }
        AssetExportSession assetExportSession4 = this.exportSession;
        if (assetExportSession4 != null) {
            assetExportSession4.setAudioMix(source.getAudioMix());
        }
        AssetExportSession assetExportSession5 = this.exportSession;
        if (assetExportSession5 != null) {
            assetExportSession5.setOutputFilePath(destFile.getAbsolutePath());
        }
        AssetExportSession assetExportSession6 = this.exportSession;
        if (assetExportSession6 != null) {
            assetExportSession6.setOutputFileType(FILE_TYPE);
        }
        AssetExportSession assetExportSession7 = this.exportSession;
        if (assetExportSession7 != null) {
            assetExportSession7.setVideoComposition(source.getVideoComposition());
        }
        AssetExportSession assetExportSession8 = this.exportSession;
        if (assetExportSession8 != null) {
            assetExportSession8.setErrorInterceptor(new AssetExportSession.ErrorInterceptor() { // from class: com.tencent.tavcut.core.render.exporter.MovieExporter$export$5
                @Override // com.tencent.tav.core.AssetExportSession.ErrorInterceptor
                public final boolean needRetry(AssetExportSession session, int i3) {
                    IExporter.ExportErrorInterceptor exportErrorInterceptor;
                    Boolean bool;
                    boolean z16;
                    boolean z17;
                    exportErrorInterceptor = MovieExporter.this.errorInterceptor;
                    if (exportErrorInterceptor != null) {
                        bool = Boolean.valueOf(exportErrorInterceptor.needRetry(i3));
                    } else {
                        bool = null;
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("encode failed needRetry: ");
                    sb6.append(bool);
                    sb6.append(" enableSoftEncoder: ");
                    z16 = MovieExporter.this.enableSoftEncoder;
                    sb6.append(z16);
                    TavLogger.e(MovieExporter.TAG, sb6.toString());
                    Boolean bool2 = Boolean.TRUE;
                    if (Intrinsics.areEqual(bool, bool2)) {
                        z17 = MovieExporter.this.enableSoftEncoder;
                        if (z17) {
                            MovieExporter movieExporter = MovieExporter.this;
                            Intrinsics.checkExpressionValueIsNotNull(session, "session");
                            movieExporter.onErrorIntercept(session);
                        }
                    }
                    return Intrinsics.areEqual(bool, bool2);
                }
            });
        }
        if (this.useSoftEncoder) {
            AssetExportSession assetExportSession9 = this.exportSession;
            if (assetExportSession9 == null) {
                Intrinsics.throwNpe();
            }
            onErrorIntercept(assetExportSession9);
        }
        AssetExportSession assetExportSession10 = this.exportSession;
        if (assetExportSession10 != null) {
            assetExportSession10.exportAsynchronouslyWithCompletionHandler(new AssetExportSession.ExportCallbackHandler() { // from class: com.tencent.tavcut.core.render.exporter.MovieExporter$export$6
                @Override // com.tencent.tav.core.AssetExportSession.ExportCallbackHandler
                public final void handlerCallback(AssetExportSession assetExportSession11) {
                    MovieExporter movieExporter = MovieExporter.this;
                    Intrinsics.checkExpressionValueIsNotNull(assetExportSession11, "assetExportSession");
                    String absolutePath = destFile.getAbsolutePath();
                    Intrinsics.checkExpressionValueIsNotNull(absolutePath, "destFile.absolutePath");
                    movieExporter.handleExportSessionStatus$lib_tavcut_debug(assetExportSession11, absolutePath);
                }
            });
        }
    }

    public final void handleExportSessionStatus$lib_tavcut_debug(@NotNull AssetExportSession assetExportSession, @NotNull String destPath) {
        IExporter.ExportListener exportListener;
        Intrinsics.checkParameterIsNotNull(assetExportSession, "assetExportSession");
        Intrinsics.checkParameterIsNotNull(destPath, "destPath");
        AssetExportSession.AssetExportSessionStatus status = assetExportSession.getStatus();
        if (status != null) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        if (i3 == 5) {
                            TavLogger.i(TAG, "export cancel");
                            if (isCanceled()) {
                                synchronized (this) {
                                    this.canceled = false;
                                    Unit unit = Unit.INSTANCE;
                                }
                                IExporter.ExportListener exportListener2 = this.exportListener;
                                if (exportListener2 != null) {
                                    exportListener2.onExportCancel();
                                }
                            }
                            synchronized (this) {
                                this.exporting = false;
                                Unit unit2 = Unit.INSTANCE;
                            }
                            release();
                            return;
                        }
                        return;
                    }
                    TavLogger.i(TAG, "export error");
                    IExporter.ExportListener exportListener3 = this.exportListener;
                    if (exportListener3 != null) {
                        exportListener3.onExportError(assetExportSession.getErrCode(), TAVReportUtils.buildExportErrorMsg("error code " + assetExportSession.getErrCode() + ": TavKit export error", assetExportSession));
                    }
                    synchronized (this) {
                        this.exporting = false;
                        Unit unit3 = Unit.INSTANCE;
                    }
                    release();
                    return;
                }
                TavLogger.i(TAG, "export progress finished");
                IExporter.ExportListener exportListener4 = this.exportListener;
                if (exportListener4 != null) {
                    exportListener4.onExportCompleted(destPath);
                }
                Log.e("VideoExportManager", "onExportCompleted report :" + PerformanceMonitor.getPerformanceData());
                synchronized (this) {
                    this.exporting = false;
                    Unit unit4 = Unit.INSTANCE;
                }
                release();
                return;
            }
            if (!isExporting() && (exportListener = this.exportListener) != null) {
                exportListener.onExportStart();
            }
            IExporter.ExportListener exportListener5 = this.exportListener;
            if (exportListener5 != null) {
                exportListener5.onExporting(assetExportSession.getProgress(), assetExportSession.getVideoTime(), assetExportSession.getAudioTime(), assetExportSession.getTotalTime());
            }
            synchronized (this) {
                this.exporting = true;
                Unit unit5 = Unit.INSTANCE;
            }
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public synchronized boolean isExporting() {
        return this.exporting;
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void release() {
        synchronized (this) {
            IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
            if (iRenderChainManager != null) {
                iRenderChainManager.release();
            }
            this.exportRenderChainManager = null;
            this.exportListener = null;
            this.clipAssetListener = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setAIBundlePath(@NotNull String agentName, @NotNull String bundlePath) {
        Intrinsics.checkParameterIsNotNull(agentName, "agentName");
        Intrinsics.checkParameterIsNotNull(bundlePath, "bundlePath");
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setLightAIModelPath(agentName, bundlePath);
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setAssetData(@NotNull String templatePath, @NotNull HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(assetData, "assetData");
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.addAssetDataToHolder(templatePath, assetData);
        }
        IRenderChainManager iRenderChainManager2 = this.exportRenderChainManager;
        if (iRenderChainManager2 != null) {
            iRenderChainManager2.setAssetData(assetData);
        }
    }

    public final void setClipAssetListener(@NotNull OnClipAssetListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.clipAssetListener = listener;
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setClipAssetListener(listener);
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setErrorInterceptor(@Nullable IExporter.ExportErrorInterceptor errorInterceptor) {
        this.errorInterceptor = errorInterceptor;
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setExportListener(@Nullable IExporter.ExportListener listener) {
        this.exportListener = listener;
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setOriginVolume(float volume) {
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setOriginVolume(volume);
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setOriginVolumeForClip(int index, float volume) {
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setOriginVolumeForClip(index, volume);
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setRenderNodes(@NotNull List<? extends BaseEffectNode> renderNodes) {
        Intrinsics.checkParameterIsNotNull(renderNodes, "renderNodes");
        this.renderNodes.clear();
        this.renderNodes.addAll(renderNodes);
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setRenderSyncMode(boolean enable, int frameRate) {
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.setRenderSyncMode(enable, frameRate);
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void setStartExportTime(@NotNull CMTime startExportTime) {
        Intrinsics.checkParameterIsNotNull(startExportTime, "startExportTime");
        this.startCMTimeExport = startExportTime;
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void switchPicEnhance(@NotNull Constants.ENHANCE_TYPE type, boolean enable) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.switchPicEnhanceAbility(type, enable);
        }
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public boolean updateTrackedStickerPosition(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, @NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(stickerName, "stickerName");
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.addRenderCallback(new IRenderCallback() { // from class: com.tencent.tavcut.core.render.exporter.MovieExporter$updateTrackedStickerPosition$1
                @Override // com.tencent.tavcut.core.session.IRenderCallback
                public void onBeforeRender(long timeStamp) {
                    Map map;
                    Map map2;
                    IRenderChainManager iRenderChainManager2;
                    IRenderChainManager iRenderChainManager3;
                    map = MovieExporter.this.trackedStickerResultMap;
                    if (map.isEmpty()) {
                        iRenderChainManager3 = MovieExporter.this.exportRenderChainManager;
                        if (iRenderChainManager3 != null) {
                            iRenderChainManager3.removeRenderCallback(this);
                            return;
                        }
                        return;
                    }
                    map2 = MovieExporter.this.trackedStickerResultMap;
                    for (Map.Entry entry : map2.entrySet()) {
                        ScreenTransform g16 = c.g((Entity) entry.getKey());
                        if (g16 != null) {
                            MovieExporter movieExporter = MovieExporter.this;
                            Object value = entry.getValue();
                            if (value == null) {
                                Intrinsics.throwNpe();
                            }
                            movieExporter.updateStickerPosition(g16, timeStamp, (ArrayList) value);
                        }
                    }
                    iRenderChainManager2 = MovieExporter.this.exportRenderChainManager;
                    if (iRenderChainManager2 != null) {
                        iRenderChainManager2.emit();
                    }
                }

                @Override // com.tencent.tavcut.core.session.IRenderCallback
                public void onRender(long timeStamp, @NotNull TextureInfo textureInfo) {
                    Intrinsics.checkParameterIsNotNull(textureInfo, "textureInfo");
                }
            });
        }
        if (stickerTrackerResult != null && !stickerTrackerResult.isEmpty()) {
            this.trackedStickerResultMap.put(entity, stickerTrackerResult);
            return true;
        }
        if (!this.trackedStickerResultMap.containsKey(entity)) {
            return true;
        }
        this.trackedStickerResultMap.remove(entity);
        return true;
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void useSoftEncoder(boolean enabled) {
        this.useSoftEncoder = enabled;
    }

    static /* synthetic */ void export$default(MovieExporter movieExporter, TAVComposition tAVComposition, String str, ExportConfig exportConfig, EGLContext eGLContext, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            eGLContext = null;
        }
        movieExporter.export(tAVComposition, str, exportConfig, eGLContext);
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void export(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath, boolean isUE4Template) {
        Intrinsics.checkParameterIsNotNull(exportOutput, "exportOutput");
        Intrinsics.checkParameterIsNotNull(destPath, "destPath");
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        export(exportOutput, this.renderModel, destPath, templatePath, isUE4Template, null);
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public void export(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath, boolean isUE4Template, @Nullable EGLContext eglContext) {
        Intrinsics.checkParameterIsNotNull(exportOutput, "exportOutput");
        Intrinsics.checkParameterIsNotNull(destPath, "destPath");
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        export(exportOutput, this.renderModel, destPath, templatePath, isUE4Template, eglContext);
    }

    private final void export(ExportOutput exportOutput, LAKRenderModel renderModel, String destPath, String templatePath, boolean isUE4Template, EGLContext eglContext) {
        LAKRenderModel copy;
        IExporter.ExportListener exportListener;
        boolean z16 = !TextUtils.isEmpty(renderModel.getJsonData());
        if (Intrinsics.areEqual("", renderModel.getJsonData())) {
            TavLogger.e(TAG, "export renderModel jsonData is empty)");
        }
        IRenderChainManager iRenderChainManager = this.exportRenderChainManager;
        if (iRenderChainManager != null) {
            iRenderChainManager.release();
        }
        if (!z16 && !LightSDKUtils.INSTANCE.isTemplateJsonExist(templatePath) && (exportListener = this.exportListener) != null) {
            exportListener.onExportError(-5, "template json file not exist");
        }
        IMediaBuilder mediaBuilder = MediaBuildFactory.INSTANCE.getMediaBuilder(RenderConfig.INSTANCE.getRenderType());
        copy = renderModel.copy((r37 & 1) != 0 ? renderModel.renderScene : RenderScene.EXPORTER, (r37 & 2) != 0 ? renderModel.root : null, (r37 & 4) != 0 ? renderModel.jsonData : null, (r37 & 8) != 0 ? renderModel.inputSources : null, (r37 & 16) != 0 ? renderModel.painting : null, (r37 & 32) != 0 ? renderModel.clipsAssets : null, (r37 & 64) != 0 ? renderModel.modifyClipsDuration : false, (r37 & 128) != 0 ? renderModel.seekTolerance : 0, (r37 & 256) != 0 ? renderModel.properties : null, (r37 & 512) != 0 ? renderModel.audioAssets : null, (r37 & 1024) != 0 ? renderModel.timeLines : null, (r37 & 2048) != 0 ? renderModel.maxDuration : 0L, (r37 & 4096) != 0 ? renderModel.componentLevel : 0, (r37 & 8192) != 0 ? renderModel.voiceChangerConfig : null, (r37 & 16384) != 0 ? renderModel.customRenderConfig : this.customRenderConfig, (r37 & 32768) != 0 ? renderModel.exportMode : false, (r37 & 65536) != 0 ? renderModel.stickerValue : null, (r37 & 131072) != 0 ? renderModel.watermarkConfig : null);
        MediaBuilderOutput buildComposition$default = IMediaBuilder.DefaultImpls.buildComposition$default(mediaBuilder, templatePath, copy, z16, isUE4Template, this.clipAssetListener, null, 32, null);
        if (buildComposition$default != null && buildComposition$default.getDurationUs() != 0) {
            IRenderChainManager renderChainManager = buildComposition$default.getRenderChainManager();
            this.exportRenderChainManager = renderChainManager;
            OnClipAssetListener onClipAssetListener = this.clipAssetListener;
            if (onClipAssetListener != null && renderChainManager != null) {
                renderChainManager.setClipAssetListener(onClipAssetListener);
            }
            buildComposition$default.getComposition().setRenderSize(exportOutput.getOutputSize());
            for (BaseEffectNode baseEffectNode : this.renderNodes) {
                IRenderChainManager iRenderChainManager2 = this.exportRenderChainManager;
                if (iRenderChainManager2 != null) {
                    iRenderChainManager2.addRenderNode(baseEffectNode);
                }
            }
            IRenderChainManager iRenderChainManager3 = this.exportRenderChainManager;
            if (iRenderChainManager3 != null) {
                iRenderChainManager3.setLoadAssetListener(new OnLoadAssetListener() { // from class: com.tencent.tavcut.core.render.exporter.MovieExporter$export$3
                    @Override // org.light.listener.OnLoadAssetListener
                    public void OnAssetDurationChange(long p06) {
                        TavLogger.d(MovieExporter.TAG, "OnAssetDurationChange time: " + p06);
                    }

                    @Override // org.light.listener.OnLoadAssetListener
                    public void OnAssetProcessing(@Nullable HashMap<String, String> p06) {
                        String str;
                        if (p06 != null) {
                            str = p06.toString();
                        } else {
                            str = null;
                        }
                        TavLogger.d(MovieExporter.TAG, str);
                    }

                    @Override // org.light.listener.OnLoadAssetListener
                    public void OnLoadAssetError(int p06) {
                        IExporter.ExportListener exportListener2;
                        exportListener2 = MovieExporter.this.exportListener;
                        if (exportListener2 != null) {
                            exportListener2.onExportError(-1001, "on load asset error");
                        }
                    }
                });
            }
            export(buildComposition$default.getComposition(), destPath, exportOutput.convertToExportConfig(), eglContext);
            return;
        }
        IExporter.ExportListener exportListener2 = this.exportListener;
        if (exportListener2 != null) {
            exportListener2.onExportError(buildComposition$default == null ? -1 : -4, "BuildRenderChainManager failed");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovieExporter(@NotNull LAKRenderModel renderModel, @Nullable CustomRenderConfig customRenderConfig) {
        this(renderModel);
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        this.customRenderConfig = customRenderConfig;
    }

    @Override // com.tencent.tavcut.core.render.exporter.IExporter
    public boolean updateTrackedStickerPosition(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, int entityId) {
        Intrinsics.checkParameterIsNotNull(stickerName, "stickerName");
        Entity queryEntityByEntityId = queryEntityByEntityId(entityId);
        if (queryEntityByEntityId != null) {
            return updateTrackedStickerPosition(stickerTrackerResult, stickerName, queryEntityByEntityId);
        }
        return false;
    }

    private final void export(TAVComposition composition, String destPath, ExportConfig exportConfig, EGLContext eglContext) {
        TavLogger.d(TAG, "export: " + composition.getDuration());
        File newOutputFile = newOutputFile(destPath);
        if (newOutputFile == null) {
            IExporter.ExportListener exportListener = this.exportListener;
            if (exportListener != null) {
                exportListener.onExportError(-103, "Failed to create output file");
                return;
            }
            return;
        }
        export$lib_tavcut_debug(composition, newOutputFile, exportConfig, eglContext);
    }
}
