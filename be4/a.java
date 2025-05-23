package be4;

import ae4.MediaBuilderOutput;
import ae4.a;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.render.exception.CalledFromWrongThreadException;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderScene;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVComposition;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007\u00a8\u0006\u000f"}, d2 = {"Lbe4/a;", "", "", "templateDir", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "Lcom/tencent/tavcut/composition/model/component/Size;", "size", "", "Lfe4/a;", "renderNodes", "Lbe4/b;", "a", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28346a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001f\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lbe4/a$a;", "Lbe4/b;", "", "c", "Lae4/c;", "a", "Lcom/tencent/tavkit/composition/TAVComposition;", "tavComposition", "Lcom/tencent/tavcut/composition/model/component/Size;", "size", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "b", "", "atTimeMs", "Landroid/graphics/Bitmap;", "getCoverAtTime", "release", "Lae4/c;", "mediaBuilderOutput", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "tavSourceImageGenerator", "", "Ljava/lang/String;", "getTemplateDir", "()Ljava/lang/String;", "templateDir", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "d", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "getRenderModel", "()Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "e", "Lcom/tencent/tavcut/composition/model/component/Size;", "getSize", "()Lcom/tencent/tavcut/composition/model/component/Size;", "", "Lfe4/a;", "f", "Ljava/util/List;", "getRenderNodes", "()Ljava/util/List;", "renderNodes", "<init>", "(Ljava/lang/String;Lcom/tencent/tavcut/rendermodel/RenderModel;Lcom/tencent/tavcut/composition/model/component/Size;Ljava/util/List;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: be4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0124a implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private MediaBuilderOutput mediaBuilderOutput;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private TAVSourceImageGenerator tavSourceImageGenerator;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String templateDir;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RenderModel renderModel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Size size;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<fe4.a> renderNodes;

        /* JADX WARN: Multi-variable type inference failed */
        public C0124a(@NotNull String templateDir, @NotNull RenderModel renderModel, @NotNull Size size, @Nullable List<? extends fe4.a> list) {
            Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
            Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
            Intrinsics.checkParameterIsNotNull(size, "size");
            this.templateDir = templateDir;
            this.renderModel = renderModel;
            this.size = size;
            this.renderNodes = list;
        }

        private final MediaBuilderOutput a() {
            RenderModel copy;
            com.tencent.tavcut.render.builder.light.b bVar = com.tencent.tavcut.render.builder.light.b.f374379a;
            String str = this.templateDir;
            copy = r3.copy((r32 & 1) != 0 ? r3.renderScene : RenderScene.COVER, (r32 & 2) != 0 ? r3.root : null, (r32 & 4) != 0 ? r3.inputSources : null, (r32 & 8) != 0 ? r3.painting : null, (r32 & 16) != 0 ? r3.clipsAssets : null, (r32 & 32) != 0 ? r3.modifyClipsDuration : false, (r32 & 64) != 0 ? r3.seekTolerance : 0, (r32 & 128) != 0 ? r3.properties : null, (r32 & 256) != 0 ? r3.audioAssets : null, (r32 & 512) != 0 ? r3.timeLines : null, (r32 & 1024) != 0 ? r3.maxDuration : 0L, (r32 & 2048) != 0 ? r3.componentLevel : 0, (r32 & 4096) != 0 ? r3.voiceChangerConfig : null, (r32 & 8192) != 0 ? this.renderModel.customRenderConfig : null);
            return a.C0030a.a(bVar, str, copy, false, false, 12, null);
        }

        private final TAVSourceImageGenerator b(TAVComposition tavComposition, Size size) {
            float f16;
            Integer num = size.width;
            float f17 = 0.0f;
            if (num != null) {
                f16 = num.intValue();
            } else {
                f16 = 0.0f;
            }
            Integer num2 = size.height;
            if (num2 != null) {
                f17 = num2.intValue();
            }
            TAVSourceImageGenerator tAVSourceImageGenerator = new TAVSourceImageGenerator(tavComposition, new CGSize(f16, f17));
            tAVSourceImageGenerator.getAssetImageGenerator().setForceUseFbo(true);
            return tAVSourceImageGenerator;
        }

        private final void c() {
            Thread currentThread = Thread.currentThread();
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
            if (!Intrinsics.areEqual(currentThread, mainLooper.getThread())) {
                MediaBuilderOutput mediaBuilderOutput = this.mediaBuilderOutput;
                if (mediaBuilderOutput != null) {
                    return;
                }
                if (mediaBuilderOutput == null) {
                    mediaBuilderOutput = a();
                }
                this.mediaBuilderOutput = mediaBuilderOutput;
                if (mediaBuilderOutput != null) {
                    List<fe4.a> list = this.renderNodes;
                    if (list != null) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            mediaBuilderOutput.getRenderChainManager().d((fe4.a) it.next());
                        }
                    }
                    TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
                    if (tAVSourceImageGenerator == null) {
                        tAVSourceImageGenerator = b(mediaBuilderOutput.getComposition(), this.size);
                    }
                    this.tavSourceImageGenerator = tAVSourceImageGenerator;
                    return;
                }
                return;
            }
            throw new CalledFromWrongThreadException("Only work tread can access cover");
        }

        @Override // be4.b
        @Nullable
        public Bitmap getCoverAtTime(long atTimeMs) {
            c();
            TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
            if (tAVSourceImageGenerator != null) {
                return tAVSourceImageGenerator.generateThumbnailAtTimeSync(CMTime.fromMs(atTimeMs));
            }
            return null;
        }

        @Override // be4.b
        public void release() {
            AssetImageGenerator assetImageGenerator;
            zd4.b renderChainManager;
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
    }

    a() {
    }

    @JvmStatic
    @NotNull
    public static final b a(@NotNull String templateDir, @NotNull RenderModel renderModel, @NotNull Size size, @Nullable List<? extends fe4.a> renderNodes) {
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(size, "size");
        return new C0124a(templateDir, renderModel, size, renderNodes);
    }
}
