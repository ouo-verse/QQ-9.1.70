package com.tencent.tavcut.core.render.exporter;

import android.opengl.EGLContext;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.core.render.builder.light.Constants;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002;<J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH&J,\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0006H&J8\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0006H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH&J4\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0018H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!H&J\u0016\u0010%\u001a\u00020\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H&J\u001a\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020$H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H&J\u0018\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010*\u001a\u00020\u0006H&J(\u00102\u001a\u00020\u00062\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001042\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020$H&J(\u00102\u001a\u00020\u00062\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001042\u0006\u00106\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006="}, d2 = {"Lcom/tencent/tavcut/core/render/exporter/IExporter;", "", "cancelExport", "", "enableSoftEncoder", NodeProps.ENABLED, "", AssetExtension.SCENE_EXPORT, "exportOutput", "Lcom/tencent/tavcut/core/render/exporter/ExportOutput;", "destPath", "", "templatePath", "isUE4Template", "eglContext", "Landroid/opengl/EGLContext;", "isExporting", "release", "setAIBundlePath", "agentName", "bundlePath", "setAssetData", "assetData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setErrorInterceptor", "errorInterceptor", "Lcom/tencent/tavcut/core/render/exporter/IExporter$ExportErrorInterceptor;", "setExportListener", "listener", "Lcom/tencent/tavcut/core/render/exporter/IExporter$ExportListener;", "setOriginVolume", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "setOriginVolumeForClip", "index", "", "setRenderNodes", "renderNodes", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "setRenderSyncMode", "enable", "frameRate", "setStartExportTime", "startExportTime", "Lcom/tencent/tav/coremedia/CMTime;", "switchPicEnhance", "type", "Lcom/tencent/tavcut/core/render/builder/light/Constants$ENHANCE_TYPE;", "updateTrackedStickerPosition", "stickerTrackerResult", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "stickerName", TemplateParser.KEY_ENTITY_ID, "entity", "Lorg/light/lightAssetKit/Entity;", "useSoftEncoder", "ExportErrorInterceptor", "ExportListener", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IExporter {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/tavcut/core/render/exporter/IExporter$ExportErrorInterceptor;", "", "needRetry", "", "index", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public interface ExportErrorInterceptor {
        boolean needRetry(int index);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u000b\u001a\u00020\u0003H&J(\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/tavcut/core/render/exporter/IExporter$ExportListener;", "", "onExportCancel", "", "onExportCompleted", "exportPath", "", "onExportError", "errCode", "", "errorMsg", "onExportStart", "onExporting", "progress", "", QFSEdgeItem.KEY_VIDEO_TIME, "", "audioTime", "totalTime", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public interface ExportListener {
        void onExportCancel();

        void onExportCompleted(@Nullable String exportPath);

        void onExportError(int errCode, @Nullable String errorMsg);

        void onExportStart();

        void onExporting(float progress, long videoTime, long audioTime, long totalTime);
    }

    void cancelExport();

    void enableSoftEncoder(boolean enabled);

    void export(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath);

    void export(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath, boolean isUE4Template);

    void export(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath, boolean isUE4Template, @Nullable EGLContext eglContext);

    boolean isExporting();

    void release();

    void setAIBundlePath(@NotNull String agentName, @NotNull String bundlePath);

    void setAssetData(@NotNull String templatePath, @NotNull HashMap<String, String> assetData);

    void setErrorInterceptor(@Nullable ExportErrorInterceptor errorInterceptor);

    void setExportListener(@Nullable ExportListener listener);

    void setOriginVolume(float volume);

    void setOriginVolumeForClip(int index, float volume);

    void setRenderNodes(@NotNull List<? extends BaseEffectNode> renderNodes);

    void setRenderSyncMode(boolean enable, int frameRate);

    void setStartExportTime(@NotNull CMTime startExportTime);

    void switchPicEnhance(@NotNull Constants.ENHANCE_TYPE type, boolean enable);

    boolean updateTrackedStickerPosition(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, int entityId);

    boolean updateTrackedStickerPosition(@Nullable ArrayList<GYTrackStickerInfo> stickerTrackerResult, @NotNull String stickerName, @NotNull Entity entity);

    void useSoftEncoder(boolean enabled);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void export$default(IExporter iExporter, ExportOutput exportOutput, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "/";
                }
                iExporter.export(exportOutput, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: export");
        }

        public static /* synthetic */ void setRenderSyncMode$default(IExporter iExporter, boolean z16, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 30;
                }
                iExporter.setRenderSyncMode(z16, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRenderSyncMode");
        }

        public static /* synthetic */ void export$default(IExporter iExporter, ExportOutput exportOutput, String str, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "/";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                iExporter.export(exportOutput, str, str2, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: export");
        }

        public static /* synthetic */ void export$default(IExporter iExporter, ExportOutput exportOutput, String str, String str2, boolean z16, EGLContext eGLContext, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "/";
                }
                String str3 = str2;
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                boolean z17 = z16;
                if ((i3 & 16) != 0) {
                    eGLContext = null;
                }
                iExporter.export(exportOutput, str, str3, z17, eGLContext);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: export");
        }
    }
}
