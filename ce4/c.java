package ce4;

import ae4.MediaBuilderOutput;
import android.opengl.EGLContext;
import android.util.Log;
import ce4.b;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavcut.core.render.exporter.MovieExporter;
import com.tencent.tavcut.render.exporter.ExportOutput;
import com.tencent.tavcut.rendermodel.CustomRenderConfig;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderScene;
import com.tencent.tavcut.rendermodel.entity.Entity;
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
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.PerformanceMonitor;
import org.light.listener.OnLoadAssetListener;
import tl.h;
import zd4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\bI\u0010JJ>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J,\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0016\u0010\u001d\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0012\u0010 \u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010!\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J(\u0010\"\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J3\u0010$\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0000\u00a2\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020\rH\u0016R(\u00100\u001a\u0016\u0012\u0004\u0012\u00020,\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010-0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010CR\u0016\u0010F\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010ER\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020,0?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010AR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010H\u00a8\u0006K"}, d2 = {"Lce4/c;", "Lce4/b;", "Lcom/tencent/tavcut/render/exporter/ExportOutput;", "exportOutput", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "", "destPath", "templatePath", "", "isUE4Template", "Landroid/opengl/EGLContext;", "eglContext", "", h.F, "Lcom/tencent/tavkit/composition/TAVComposition;", "composition", "Lcom/tencent/tav/core/ExportConfig;", "exportConfig", "i", "Lcom/tencent/tav/core/AssetExportSession;", SessionDbHelper.SESSION_ID, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "outputPath", "Ljava/io/File;", "l", "", "Lfe4/a;", "renderNodes", "setRenderNodes", "Lce4/b$c;", "listener", "a", "c", "b", "destFile", "j", "(Lcom/tencent/tavkit/composition/TAVComposition;Ljava/io/File;Lcom/tencent/tav/core/ExportConfig;Landroid/opengl/EGLContext;)V", "assetExportSession", "k", "(Lcom/tencent/tav/core/AssetExportSession;Ljava/lang/String;)V", "cancelExport", DomainData.DOMAIN_NAME, "", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "Ljava/util/ArrayList;", "Lcom/gyailib/library/GYTrackStickerInfo;", "Ljava/util/Map;", "trackedStickerResultMap", "Lce4/b$c;", "exportListener", "Lcom/tencent/tav/core/AssetExportSession;", "exportSession", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "canceled", "e", "exporting", "Lzd4/b;", "f", "Lzd4/b;", "exportRenderChainManager", "", "g", "Ljava/util/List;", "Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;", "Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;", "customRenderConfig", "Z", "enableSoftEncoder", "entityTree", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "<init>", "(Lcom/tencent/tavcut/rendermodel/RenderModel;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c implements ce4.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Entity, ArrayList<GYTrackStickerInfo>> trackedStickerResultMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private b.c exportListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile AssetExportSession exportSession;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean canceled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean exporting;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private zd4.b exportRenderChainManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final List<fe4.a> renderNodes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CustomRenderConfig customRenderConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean enableSoftEncoder;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private List<Entity> entityTree;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final RenderModel renderModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\b\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"ce4/c$b", "Lorg/light/listener/OnLoadAssetListener;", "", "p0", "", "OnLoadAssetError", "Ljava/util/HashMap;", "", "OnAssetProcessing", "", "OnAssetDurationChange", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class b implements OnLoadAssetListener {
        b() {
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long p06) {
            ee4.b.a(MovieExporter.TAG, String.valueOf(p06));
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetProcessing(@Nullable HashMap<String, String> p06) {
            String str;
            if (p06 != null) {
                str = p06.toString();
            } else {
                str = null;
            }
            ee4.b.a(MovieExporter.TAG, str);
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int p06) {
            b.c cVar = c.this.exportListener;
            if (cVar != null) {
                cVar.onExportError(-1001, "on load asset error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", SessionDbHelper.SESSION_ID, "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "index", "", "needRetry"}, k = 3, mv = {1, 1, 16})
    /* renamed from: ce4.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0187c implements AssetExportSession.ErrorInterceptor {
        C0187c() {
        }

        @Override // com.tencent.tav.core.AssetExportSession.ErrorInterceptor
        public final boolean needRetry(AssetExportSession session, int i3) {
            c.e(c.this);
            ee4.b.b(MovieExporter.TAG, "encode failed needRetry: " + ((Object) null) + " enableSoftEncoder: " + c.this.enableSoftEncoder);
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual((Object) null, bool) && c.this.enableSoftEncoder) {
                c cVar = c.this;
                Intrinsics.checkExpressionValueIsNotNull(session, "session");
                cVar.m(session);
            }
            return Intrinsics.areEqual((Object) null, bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class d implements AssetExportSession.ExportCallbackHandler {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f30763b;

        d(File file) {
            this.f30763b = file;
        }

        @Override // com.tencent.tav.core.AssetExportSession.ExportCallbackHandler
        public final void handlerCallback(AssetExportSession assetExportSession) {
            c cVar = c.this;
            Intrinsics.checkExpressionValueIsNotNull(assetExportSession, "assetExportSession");
            String absolutePath = this.f30763b.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "destFile.absolutePath");
            cVar.k(assetExportSession, absolutePath);
        }
    }

    public c(@NotNull RenderModel renderModel) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        this.renderModel = renderModel;
        this.trackedStickerResultMap = new LinkedHashMap();
        this.canceled = new AtomicBoolean(false);
        this.exporting = new AtomicBoolean(false);
        this.renderNodes = new ArrayList();
        this.entityTree = new ArrayList();
    }

    public static final /* synthetic */ b.InterfaceC0186b e(c cVar) {
        cVar.getClass();
        return null;
    }

    private final void h(ExportOutput exportOutput, RenderModel renderModel, String destPath, String templatePath, boolean isUE4Template, EGLContext eglContext) {
        RenderModel copy;
        if (renderModel.getRoot() == null) {
            b.c cVar = this.exportListener;
            if (cVar != null) {
                cVar.onExportError(-1, "RenderModel not complete");
                return;
            }
            return;
        }
        zd4.b bVar = this.exportRenderChainManager;
        if (bVar != null) {
            bVar.release();
        }
        ae4.a a16 = ae4.b.f25939a.a(e.f452395c.b());
        copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : RenderScene.EXPORTER, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : null, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : null, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : 0L, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : this.customRenderConfig);
        MediaBuilderOutput a17 = a16.a(templatePath, copy, false, isUE4Template);
        if (a17 == null) {
            b.c cVar2 = this.exportListener;
            if (cVar2 != null) {
                cVar2.onExportError(-1, "BuildRenderChainManager failed");
                return;
            }
            return;
        }
        this.exportRenderChainManager = a17.getRenderChainManager();
        a17.getComposition().setRenderSize(exportOutput.getOutputSize());
        for (fe4.a aVar : this.renderNodes) {
            zd4.b bVar2 = this.exportRenderChainManager;
            if (bVar2 != null) {
                bVar2.d(aVar);
            }
        }
        zd4.b bVar3 = this.exportRenderChainManager;
        if (bVar3 != null) {
            bVar3.setLoadAssetListener(new b());
        }
        i(a17.getComposition(), destPath, exportOutput.e(), eglContext);
    }

    private final void i(TAVComposition composition, String destPath, ExportConfig exportConfig, EGLContext eglContext) {
        ee4.b.a(MovieExporter.TAG, "export: " + composition.getDuration());
        File l3 = l(destPath);
        if (l3 == null) {
            b.c cVar = this.exportListener;
            if (cVar != null) {
                cVar.onExportError(-103, "Failed to create output file");
                return;
            }
            return;
        }
        j(composition, l3, exportConfig, eglContext);
    }

    private final File l(String outputPath) {
        File file = new File(outputPath);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (Exception e16) {
            ee4.b.c(MovieExporter.TAG, "export: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(AssetExportSession session) {
        session.setMuxerCreator(new a());
        session.setVideoEncoder(new FFmpegVideoEncoder());
        ExportConfig exportConfig = session.getExportConfig();
        Intrinsics.checkExpressionValueIsNotNull(exportConfig, "session.exportConfig");
        exportConfig.setAudioChannelCount(1);
        exportConfig.setHighProfile(false);
        exportConfig.setEnableBFrame(false);
        exportConfig.reset();
    }

    @Override // ce4.b
    public void a(@Nullable b.c listener) {
        this.exportListener = listener;
    }

    @Override // ce4.b
    public void b(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath, boolean isUE4Template) {
        Intrinsics.checkParameterIsNotNull(exportOutput, "exportOutput");
        Intrinsics.checkParameterIsNotNull(destPath, "destPath");
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        h(exportOutput, this.renderModel, destPath, templatePath, isUE4Template, null);
    }

    @Override // ce4.b
    public void c(@NotNull ExportOutput exportOutput, @NotNull String destPath, @NotNull String templatePath) {
        Intrinsics.checkParameterIsNotNull(exportOutput, "exportOutput");
        Intrinsics.checkParameterIsNotNull(destPath, "destPath");
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        b(exportOutput, destPath, templatePath, false);
    }

    @Override // ce4.b
    public void cancelExport() {
        if (this.exporting.compareAndSet(true, false)) {
            this.canceled.set(true);
            AssetExportSession assetExportSession = this.exportSession;
            if (assetExportSession != null) {
                assetExportSession.cancelExport();
            }
        }
    }

    public final void j(@NotNull TAVComposition composition, @NotNull File destFile, @NotNull ExportConfig exportConfig, @Nullable EGLContext eglContext) {
        Intrinsics.checkParameterIsNotNull(composition, "composition");
        Intrinsics.checkParameterIsNotNull(destFile, "destFile");
        Intrinsics.checkParameterIsNotNull(exportConfig, "exportConfig");
        AssetExportSession assetExportSession = this.exportSession;
        if (assetExportSession != null) {
            assetExportSession.cancelExport();
        }
        Integer num = null;
        this.exportSession = null;
        TAVCompositionBuilder tAVCompositionBuilder = new TAVCompositionBuilder(composition);
        tAVCompositionBuilder.setVideoTracksMerge(false);
        TAVSource source = tAVCompositionBuilder.buildSource();
        Intrinsics.checkExpressionValueIsNotNull(source, "source");
        this.exportSession = new AssetExportSession(source.getAsset(), exportConfig);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("export called. newSession: ");
        AssetExportSession assetExportSession2 = this.exportSession;
        if (assetExportSession2 != null) {
            num = Integer.valueOf(assetExportSession2.hashCode());
        }
        sb5.append(num);
        ee4.b.e(MovieExporter.TAG, sb5.toString());
        if (eglContext != null) {
            RenderContextParams renderContextParams = new RenderContextParams();
            renderContextParams.putParam("share_context", eglContext);
            AssetExportSession assetExportSession3 = this.exportSession;
            if (assetExportSession3 != null) {
                assetExportSession3.setRenderContextParams(renderContextParams);
            }
        }
        AssetExportSession assetExportSession4 = this.exportSession;
        if (assetExportSession4 != null) {
            CMTime cMTime = CMTime.CMTimeZero;
            Asset asset = source.getAsset();
            Intrinsics.checkExpressionValueIsNotNull(asset, "source.asset");
            assetExportSession4.setTimeRange(new CMTimeRange(cMTime, asset.getDuration()));
        }
        AssetExportSession assetExportSession5 = this.exportSession;
        if (assetExportSession5 != null) {
            assetExportSession5.setAudioMix(source.getAudioMix());
        }
        AssetExportSession assetExportSession6 = this.exportSession;
        if (assetExportSession6 != null) {
            assetExportSession6.setOutputFilePath(destFile.getAbsolutePath());
        }
        AssetExportSession assetExportSession7 = this.exportSession;
        if (assetExportSession7 != null) {
            assetExportSession7.setOutputFileType(MovieExporter.FILE_TYPE);
        }
        AssetExportSession assetExportSession8 = this.exportSession;
        if (assetExportSession8 != null) {
            assetExportSession8.setVideoComposition(source.getVideoComposition());
        }
        AssetExportSession assetExportSession9 = this.exportSession;
        if (assetExportSession9 != null) {
            assetExportSession9.setErrorInterceptor(new C0187c());
        }
        AssetExportSession assetExportSession10 = this.exportSession;
        if (assetExportSession10 != null) {
            assetExportSession10.exportAsynchronouslyWithCompletionHandler(new d(destFile));
        }
    }

    public final void k(@NotNull AssetExportSession assetExportSession, @NotNull String destPath) {
        b.c cVar;
        b.c cVar2;
        Integer num;
        Intrinsics.checkParameterIsNotNull(assetExportSession, "assetExportSession");
        Intrinsics.checkParameterIsNotNull(destPath, "destPath");
        if (!Intrinsics.areEqual(assetExportSession, this.exportSession)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleExportSessionStatus session not match return. session: ");
            sb5.append(assetExportSession.hashCode());
            sb5.append(" thisSession: ");
            AssetExportSession assetExportSession2 = this.exportSession;
            if (assetExportSession2 != null) {
                num = Integer.valueOf(assetExportSession2.hashCode());
            } else {
                num = null;
            }
            sb5.append(num);
            ee4.b.j(MovieExporter.TAG, sb5.toString());
            return;
        }
        AssetExportSession.AssetExportSessionStatus status = assetExportSession.getStatus();
        if (status != null) {
            int i3 = ce4.d.f30764a[status.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        if (i3 == 5) {
                            ee4.b.e(MovieExporter.TAG, "export cancel");
                            if (this.canceled.compareAndSet(true, false) && (cVar2 = this.exportListener) != null) {
                                cVar2.onExportCancel();
                            }
                            this.exporting.set(false);
                            n();
                            return;
                        }
                        return;
                    }
                    ee4.b.e(MovieExporter.TAG, "export error");
                    b.c cVar3 = this.exportListener;
                    if (cVar3 != null) {
                        cVar3.onExportError(assetExportSession.getErrCode(), TAVReportUtils.buildExportErrorMsg("error code " + assetExportSession.getErrCode() + ": TavKit export error", assetExportSession));
                    }
                    this.exporting.set(false);
                    n();
                    return;
                }
                ee4.b.e(MovieExporter.TAG, "export progress finished");
                b.c cVar4 = this.exportListener;
                if (cVar4 != null) {
                    cVar4.onExportCompleted(destPath);
                }
                Log.e("VideoExportManager", "onExportCompleted report :" + PerformanceMonitor.getPerformanceData());
                this.exporting.set(false);
                n();
                return;
            }
            if (!this.canceled.get() && this.exporting.compareAndSet(false, true) && (cVar = this.exportListener) != null) {
                cVar.onExportStart();
            }
            b.c cVar5 = this.exportListener;
            if (cVar5 != null) {
                cVar5.onExporting(assetExportSession.getProgress());
            }
        }
    }

    public void n() {
        synchronized (this) {
            zd4.b bVar = this.exportRenderChainManager;
            if (bVar != null) {
                bVar.release();
            }
            this.exportRenderChainManager = null;
            this.exportListener = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // ce4.b
    public void setRenderNodes(@NotNull List<? extends fe4.a> renderNodes) {
        Intrinsics.checkParameterIsNotNull(renderNodes, "renderNodes");
        this.renderNodes.clear();
        this.renderNodes.addAll(renderNodes);
    }
}
