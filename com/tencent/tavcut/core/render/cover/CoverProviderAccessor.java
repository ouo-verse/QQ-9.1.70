package com.tencent.tavcut.core.render.cover;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.builder.IMediaBuilder;
import com.tencent.tavcut.core.render.builder.MediaBuilderOutput;
import com.tencent.tavcut.core.render.builder.light.LightMediaBuilder;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.RenderScene;
import com.tencent.tavcut.core.render.exception.CalledFromWrongThreadException;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVComposition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J^\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/tavcut/core/render/cover/CoverProviderAccessor;", "", "()V", "TAG", "", "accessCoverProvider", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "templateDir", "renderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "size", "Lorg/light/lightAssetKit/components/Size;", "renderNodes", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "assetData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "CoverProvider", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class CoverProviderAccessor {
    public static final CoverProviderAccessor INSTANCE = new CoverProviderAccessor();
    private static final String TAG = "CoverProviderAccessor";

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012(\b\u0002\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\r\u00a2\u0006\u0002\u0010\u000eJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J&\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020&0(H\u0016J,\u0010)\u001a\u00020&2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020&0(H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0016R1\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006."}, d2 = {"Lcom/tencent/tavcut/core/render/cover/CoverProviderAccessor$CoverProvider;", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "templateDir", "", "renderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "size", "Lorg/light/lightAssetKit/components/Size;", "renderNodes", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "assetData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;Lorg/light/lightAssetKit/components/Size;Ljava/util/List;Ljava/util/HashMap;)V", "getAssetData", "()Ljava/util/HashMap;", "mediaBuilderOutput", "Lcom/tencent/tavcut/core/render/builder/MediaBuilderOutput;", "getRenderModel", "()Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "getRenderNodes", "()Ljava/util/List;", "getSize", "()Lorg/light/lightAssetKit/components/Size;", "tavSourceImageGenerator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "getTemplateDir", "()Ljava/lang/String;", "buildRenderChainManager", "buildTavSourceImageGenerator", "tavComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "getCoverAtTime", "Landroid/graphics/Bitmap;", "atTimeMs", "", "getCoverAtTimeAsync", "", "callback", "Lkotlin/Function1;", "getCoverAtTimesAsync", "getRenderChainManagerAndInit", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "init", "release", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class CoverProvider implements ICoverProvider {

        @Nullable
        private final HashMap<String, String> assetData;
        private MediaBuilderOutput mediaBuilderOutput;

        @NotNull
        private final LAKRenderModel renderModel;

        @Nullable
        private final List<BaseEffectNode> renderNodes;

        @NotNull
        private final Size size;
        private TAVSourceImageGenerator tavSourceImageGenerator;

        @NotNull
        private final String templateDir;

        /* JADX WARN: Multi-variable type inference failed */
        public CoverProvider(@NotNull String templateDir, @NotNull LAKRenderModel renderModel, @NotNull Size size, @Nullable List<? extends BaseEffectNode> list, @Nullable HashMap<String, String> hashMap) {
            Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
            Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
            Intrinsics.checkParameterIsNotNull(size, "size");
            this.templateDir = templateDir;
            this.renderModel = renderModel;
            this.size = size;
            this.renderNodes = list;
            this.assetData = hashMap;
        }

        private final MediaBuilderOutput buildRenderChainManager() {
            LAKRenderModel copy;
            boolean z16;
            LightMediaBuilder lightMediaBuilder = LightMediaBuilder.INSTANCE;
            String str = this.templateDir;
            copy = r3.copy((r37 & 1) != 0 ? r3.renderScene : RenderScene.COVER, (r37 & 2) != 0 ? r3.root : null, (r37 & 4) != 0 ? r3.jsonData : null, (r37 & 8) != 0 ? r3.inputSources : null, (r37 & 16) != 0 ? r3.painting : null, (r37 & 32) != 0 ? r3.clipsAssets : null, (r37 & 64) != 0 ? r3.modifyClipsDuration : false, (r37 & 128) != 0 ? r3.seekTolerance : 0, (r37 & 256) != 0 ? r3.properties : null, (r37 & 512) != 0 ? r3.audioAssets : null, (r37 & 1024) != 0 ? r3.timeLines : null, (r37 & 2048) != 0 ? r3.maxDuration : 0L, (r37 & 4096) != 0 ? r3.componentLevel : 0, (r37 & 8192) != 0 ? r3.voiceChangerConfig : null, (r37 & 16384) != 0 ? r3.customRenderConfig : null, (r37 & 32768) != 0 ? r3.exportMode : false, (r37 & 65536) != 0 ? r3.stickerValue : null, (r37 & 131072) != 0 ? this.renderModel.watermarkConfig : null);
            if (this.renderModel.getJsonData() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            return IMediaBuilder.DefaultImpls.buildComposition$default(lightMediaBuilder, str, copy, z16, false, null, this.assetData, 24, null);
        }

        private final TAVSourceImageGenerator buildTavSourceImageGenerator(TAVComposition tavComposition, Size size) {
            TAVSourceImageGenerator tAVSourceImageGenerator = new TAVSourceImageGenerator(tavComposition, new CGSize(size.width, size.height));
            tAVSourceImageGenerator.getAssetImageGenerator().setForceUseFbo(true);
            return tAVSourceImageGenerator;
        }

        private final void init() {
            Thread currentThread = Thread.currentThread();
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
            if (!Intrinsics.areEqual(currentThread, mainLooper.getThread())) {
                MediaBuilderOutput mediaBuilderOutput = this.mediaBuilderOutput;
                if (mediaBuilderOutput != null) {
                    return;
                }
                if (mediaBuilderOutput == null) {
                    mediaBuilderOutput = buildRenderChainManager();
                }
                this.mediaBuilderOutput = mediaBuilderOutput;
                if (mediaBuilderOutput != null) {
                    List<BaseEffectNode> list = this.renderNodes;
                    if (list != null) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            mediaBuilderOutput.getRenderChainManager().addRenderNode((BaseEffectNode) it.next());
                        }
                    }
                    TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
                    if (tAVSourceImageGenerator == null) {
                        tAVSourceImageGenerator = buildTavSourceImageGenerator(mediaBuilderOutput.getComposition(), this.size);
                    }
                    this.tavSourceImageGenerator = tAVSourceImageGenerator;
                    return;
                }
                return;
            }
            throw new CalledFromWrongThreadException("Only work tread can access cover");
        }

        @Nullable
        public final HashMap<String, String> getAssetData() {
            return this.assetData;
        }

        @Override // com.tencent.tavcut.core.render.cover.ICoverProvider
        @Nullable
        public Bitmap getCoverAtTime(long atTimeMs) {
            init();
            try {
                TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
                if (tAVSourceImageGenerator == null) {
                    return null;
                }
                return tAVSourceImageGenerator.generateThumbnailAtTimeSync(CMTime.fromMs(atTimeMs));
            } catch (Exception e16) {
                TavLogger.e(CoverProviderAccessor.TAG, "getCoverAtTime " + atTimeMs + " exception: " + e16.getMessage());
                return null;
            }
        }

        @Override // com.tencent.tavcut.core.render.cover.ICoverProvider
        public void getCoverAtTimeAsync(long atTimeMs, @NotNull Function1<? super Bitmap, Unit> callback) {
            ArrayList arrayListOf;
            Intrinsics.checkParameterIsNotNull(callback, "callback");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(atTimeMs));
            getCoverAtTimesAsync(arrayListOf, callback);
        }

        @Override // com.tencent.tavcut.core.render.cover.ICoverProvider
        public void getCoverAtTimesAsync(@NotNull List<Long> atTimeMs, @NotNull final Function1<? super Bitmap, Unit> callback) {
            Intrinsics.checkParameterIsNotNull(atTimeMs, "atTimeMs");
            Intrinsics.checkParameterIsNotNull(callback, "callback");
            init();
            ArrayList arrayList = new ArrayList();
            Iterator<Long> it = atTimeMs.iterator();
            while (it.hasNext()) {
                CMTime fromMs = CMTime.fromMs(it.next().longValue());
                Intrinsics.checkExpressionValueIsNotNull(fromMs, "CMTime.fromMs(time)");
                arrayList.add(fromMs);
            }
            TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
            if (tAVSourceImageGenerator != null) {
                tAVSourceImageGenerator.generateThumbnailAtTimes(arrayList, new AssetImageGenerator.ImageGeneratorListener() { // from class: com.tencent.tavcut.core.render.cover.CoverProviderAccessor$CoverProvider$getCoverAtTimesAsync$1
                    @Override // com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener
                    public final void onCompletion(@NotNull CMTime cMTime, @Nullable Bitmap bitmap, @Nullable CMTime cMTime2, @NotNull AssetImageGenerator.AssetImageGeneratorResult generatorResult) {
                        Intrinsics.checkParameterIsNotNull(cMTime, "<anonymous parameter 0>");
                        Intrinsics.checkParameterIsNotNull(generatorResult, "generatorResult");
                        if (generatorResult == AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded) {
                            Function1.this.invoke(bitmap);
                        } else {
                            Function1.this.invoke(null);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.tavcut.core.render.cover.ICoverProvider
        @Nullable
        public IRenderChainManager getRenderChainManagerAndInit() {
            init();
            MediaBuilderOutput mediaBuilderOutput = this.mediaBuilderOutput;
            if (mediaBuilderOutput != null) {
                return mediaBuilderOutput.getRenderChainManager();
            }
            return null;
        }

        @NotNull
        public final LAKRenderModel getRenderModel() {
            return this.renderModel;
        }

        @Nullable
        public final List<BaseEffectNode> getRenderNodes() {
            return this.renderNodes;
        }

        @NotNull
        public final Size getSize() {
            return this.size;
        }

        @NotNull
        public final String getTemplateDir() {
            return this.templateDir;
        }

        @Override // com.tencent.tavcut.core.render.cover.ICoverProvider
        public void release() {
            AssetImageGenerator assetImageGenerator;
            IRenderChainManager renderChainManager;
            MediaBuilderOutput mediaBuilderOutput = this.mediaBuilderOutput;
            if (mediaBuilderOutput != null && (renderChainManager = mediaBuilderOutput.getRenderChainManager()) != null) {
                renderChainManager.release();
            }
            TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
            if (tAVSourceImageGenerator != null && (assetImageGenerator = tAVSourceImageGenerator.getAssetImageGenerator()) != null) {
                assetImageGenerator.release();
            }
            this.mediaBuilderOutput = null;
            this.tavSourceImageGenerator = null;
        }

        public /* synthetic */ CoverProvider(String str, LAKRenderModel lAKRenderModel, Size size, List list, HashMap hashMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, lAKRenderModel, size, (i3 & 8) != 0 ? null : list, (i3 & 16) != 0 ? null : hashMap);
        }
    }

    CoverProviderAccessor() {
    }

    @JvmStatic
    @NotNull
    public static final ICoverProvider accessCoverProvider(@NotNull String templateDir, @NotNull LAKRenderModel renderModel, @NotNull Size size, @Nullable List<? extends BaseEffectNode> renderNodes, @Nullable HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(size, "size");
        return new CoverProvider(templateDir, renderModel, size, renderNodes, assetData);
    }

    public static /* synthetic */ ICoverProvider accessCoverProvider$default(String str, LAKRenderModel lAKRenderModel, Size size, List list, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            size = new Size(720, 1280);
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        if ((i3 & 16) != 0) {
            hashMap = null;
        }
        return accessCoverProvider(str, lAKRenderModel, size, list, hashMap);
    }
}
