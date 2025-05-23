package com.tencent.videocut.render;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.tavcut.core.manager.StickerTrackerManager;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.StickerModel;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0004'KLMB-\u0012\u0006\u00105\u001a\u000203\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u0010F\u001a\u00020E\u0012\b\b\u0002\u0010H\u001a\u00020G\u00a2\u0006\u0004\bI\u0010JJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\u0006J,\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fJ\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ,\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\fJ&\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\"J\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\fJ*\u0010*\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0)\u0012\u0004\u0012\u00020\u00040(J\u0006\u0010+\u001a\u00020\u0004J\u0014\u0010/\u001a\u00020\u00042\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,J\u0016\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00104R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00106R\"\u0010=\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010@\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\"\u0010D\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010A0A0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010C\u00a8\u0006N"}, d2 = {"Lcom/tencent/videocut/render/ComposeRenderLayer;", "", "Lcom/tencent/videocut/model/MediaModel;", com.tencent.mobileqq.msf.service.b.f250814q, "", "l", "", "targetTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/videocut/render/ComposeRenderLayer$FlushMode;", "flushMode", DomainData.DOMAIN_NAME, "", "forceUpdate", "o", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "", "r", "needFlushPlayer", "forceFlush", "t", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager;", "stickerTrackerManager", "Lsd4/b;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "curStickerModel", "Lcom/tencent/tavcut/core/manager/a;", "callback", "k", tl.h.F, "b", "", "modelId", "c", "e", "enable", "a", "Lkotlin/Function1;", "", "j", "g", "", "Lcom/tencent/videocut/model/StickerModel;", "templateStickers", "f", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/tavcut/core/session/ICutSession;", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "Lcom/tencent/videocut/model/MediaModel;", "current", "Z", "d", "()Z", "i", "(Z)V", "needUpdateVideo", "getNeedUpdateBackGround", "setNeedUpdateBackGround", "needUpdateBackGround", "Lcom/tencent/videocut/render/i;", "kotlin.jvm.PlatformType", "Ljava/util/List;", "renderLayers", "Lcom/tencent/videocut/render/ComposeRenderLayer$RenderScene;", "renderScene", "Lcom/tencent/videocut/render/ComposeRenderLayer$RunningMode;", "runningMode", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;Lcom/tencent/videocut/model/MediaModel;Lcom/tencent/videocut/render/ComposeRenderLayer$RenderScene;Lcom/tencent/videocut/render/ComposeRenderLayer$RunningMode;)V", "FlushMode", "RenderScene", "RunningMode", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class ComposeRenderLayer {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private MediaModel current;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean needUpdateVideo;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean needUpdateBackGround;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final List<i> renderLayers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/videocut/render/ComposeRenderLayer$FlushMode;", "", "(Ljava/lang/String;I)V", "NO_FLUSH", "FLUSH", "FLUSH_WITHOUT_DELAY", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class FlushMode extends Enum<FlushMode> {
        private static final /* synthetic */ FlushMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FlushMode FLUSH;
        public static final FlushMode FLUSH_WITHOUT_DELAY;
        public static final FlushMode NO_FLUSH;

        private static final /* synthetic */ FlushMode[] $values() {
            return new FlushMode[]{NO_FLUSH, FLUSH, FLUSH_WITHOUT_DELAY};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59613);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            NO_FLUSH = new FlushMode("NO_FLUSH", 0);
            FLUSH = new FlushMode("FLUSH", 1);
            FLUSH_WITHOUT_DELAY = new FlushMode("FLUSH_WITHOUT_DELAY", 2);
            $VALUES = $values();
        }

        FlushMode(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FlushMode valueOf(String str) {
            return (FlushMode) Enum.valueOf(FlushMode.class, str);
        }

        public static FlushMode[] values() {
            return (FlushMode[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/videocut/render/ComposeRenderLayer$RenderScene;", "", "(Ljava/lang/String;I)V", "VIDEO", "PIC", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class RenderScene extends Enum<RenderScene> {
        private static final /* synthetic */ RenderScene[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RenderScene PIC;
        public static final RenderScene VIDEO;

        private static final /* synthetic */ RenderScene[] $values() {
            return new RenderScene[]{VIDEO, PIC};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59616);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            VIDEO = new RenderScene("VIDEO", 0);
            PIC = new RenderScene("PIC", 1);
            $VALUES = $values();
        }

        RenderScene(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static RenderScene valueOf(String str) {
            return (RenderScene) Enum.valueOf(RenderScene.class, str);
        }

        public static RenderScene[] values() {
            return (RenderScene[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/videocut/render/ComposeRenderLayer$RunningMode;", "", "(Ljava/lang/String;I)V", "EXPORT", "PREVIEW", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class RunningMode extends Enum<RunningMode> {
        private static final /* synthetic */ RunningMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RunningMode EXPORT;
        public static final RunningMode PREVIEW;

        private static final /* synthetic */ RunningMode[] $values() {
            return new RunningMode[]{EXPORT, PREVIEW};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59621);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EXPORT = new RunningMode("EXPORT", 0);
            PREVIEW = new RunningMode("PREVIEW", 1);
            $VALUES = $values();
        }

        RunningMode(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static RunningMode valueOf(String str) {
            return (RunningMode) Enum.valueOf(RunningMode.class, str);
        }

        public static RunningMode[] values() {
            return (RunningMode[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/render/ComposeRenderLayer$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.ComposeRenderLayer$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        public static final /* synthetic */ int[] f384100a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59623);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FlushMode.values().length];
            try {
                iArr[FlushMode.FLUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlushMode.FLUSH_WITHOUT_DELAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f384100a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59628);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ComposeRenderLayer(@NotNull ICutSession tavCutSession, @NotNull MediaModel current, @NotNull RenderScene renderScene, @NotNull RunningMode runningMode) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(renderScene, "renderScene");
        Intrinsics.checkNotNullParameter(runningMode, "runningMode");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tavCutSession, current, renderScene, runningMode);
            return;
        }
        this.tavCutSession = tavCutSession;
        this.current = current;
        this.needUpdateVideo = true;
        this.needUpdateBackGround = true;
        this.renderLayers = renderScene == RenderScene.VIDEO ? CollectionsKt__CollectionsKt.mutableListOf(new BackgroundModelRender(tavCutSession), new k(tavCutSession), new AudioModelRender(tavCutSession), new StickerRenderHelper(tavCutSession), new TemplateTextRenderHelper(tavCutSession), new BackgroundTextRenderHelper(tavCutSession), new j(tavCutSession), new c(tavCutSession), new o(tavCutSession, runningMode), new u(tavCutSession), com.tencent.mobileqq.wink.editor.hdr.a.d(tavCutSession), new n(tavCutSession), new q(tavCutSession)) : CollectionsKt__CollectionsKt.mutableListOf(new BackgroundModelRender(tavCutSession), new k(tavCutSession), new StickerRenderHelper(tavCutSession), new j(tavCutSession), new c(tavCutSession), com.tencent.mobileqq.wink.editor.hdr.a.d(tavCutSession), new TemplateTextRenderHelper(tavCutSession));
    }

    public static /* synthetic */ void p(ComposeRenderLayer composeRenderLayer, MediaModel mediaModel, FlushMode flushMode, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            flushMode = FlushMode.FLUSH_WITHOUT_DELAY;
        }
        if ((i3 & 4) != 0) {
            j3 = -1;
        }
        composeRenderLayer.n(mediaModel, flushMode, j3);
    }

    public static /* synthetic */ void q(ComposeRenderLayer composeRenderLayer, MediaModel mediaModel, FlushMode flushMode, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            flushMode = FlushMode.FLUSH_WITHOUT_DELAY;
        }
        FlushMode flushMode2 = flushMode;
        if ((i3 & 4) != 0) {
            j3 = -1;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        composeRenderLayer.o(mediaModel, flushMode2, j16, z16);
    }

    public static /* synthetic */ void u(ComposeRenderLayer composeRenderLayer, MediaModel mediaModel, boolean z16, long j3, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i3 & 4) != 0) {
            j3 = -1;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        composeRenderLayer.t(mediaModel, z18, j16, z17);
    }

    public final void a(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, enable);
            return;
        }
        for (i iVar : this.renderLayers) {
            if (iVar instanceof k) {
                ((k) iVar).i(enable);
                return;
            }
        }
    }

    @NotNull
    public final MediaModel b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (MediaModel) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.current;
    }

    @Nullable
    public final Entity c(@NotNull String modelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Entity) iPatchRedirector.redirect((short) 18, (Object) this, (Object) modelId);
        }
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        for (i iVar : this.renderLayers) {
            if (iVar instanceof StickerRenderHelper) {
                return ((StickerRenderHelper) iVar).g(modelId);
            }
        }
        return null;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.needUpdateVideo;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        for (i iVar : this.renderLayers) {
            if (iVar instanceof j) {
                ((j) iVar).B();
            }
        }
    }

    public final void f(@NotNull List<? extends StickerModel> templateStickers) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) templateStickers);
            return;
        }
        Intrinsics.checkNotNullParameter(templateStickers, "templateStickers");
        for (i iVar : this.renderLayers) {
            if (iVar instanceof TemplateTextRenderHelper) {
                ((TemplateTextRenderHelper) iVar).G(templateStickers);
                return;
            }
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        for (i iVar : this.renderLayers) {
            if (iVar instanceof TemplateTextRenderHelper) {
                ((TemplateTextRenderHelper) iVar).H();
                return;
            }
        }
    }

    public final void h(@NotNull MediaModel newModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newModel);
            return;
        }
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        if (Intrinsics.areEqual(newModel, this.current)) {
            return;
        }
        this.current = newModel;
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.needUpdateVideo = z16;
        }
    }

    public final void j(@Nullable Entity rootEntity, @NotNull Function1<? super List<Entity>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) rootEntity, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        for (i iVar : this.renderLayers) {
            if (iVar instanceof TemplateTextRenderHelper) {
                ((TemplateTextRenderHelper) iVar).I(rootEntity, callback);
                return;
            }
        }
    }

    public final void k(@NotNull StickerTrackerManager stickerTrackerManager, @NotNull sd4.b r65, @NotNull WinkStickerModel curStickerModel, @NotNull com.tencent.tavcut.core.manager.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, stickerTrackerManager, r65, curStickerModel, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(stickerTrackerManager, "stickerTrackerManager");
        Intrinsics.checkNotNullParameter(r65, "config");
        Intrinsics.checkNotNullParameter(curStickerModel, "curStickerModel");
        Intrinsics.checkNotNullParameter(callback, "callback");
        for (i iVar : this.renderLayers) {
            if (iVar instanceof StickerRenderHelper) {
                ((StickerRenderHelper) iVar).B(stickerTrackerManager, r65, curStickerModel, callback);
            }
        }
    }

    public final void l(@NotNull MediaModel r46) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) r46);
        } else {
            Intrinsics.checkNotNullParameter(r46, "newModel");
            n(r46, FlushMode.FLUSH_WITHOUT_DELAY, -1L);
        }
    }

    public final void m(@NotNull MediaModel newModel, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, newModel, Long.valueOf(j3));
        } else {
            Intrinsics.checkNotNullParameter(newModel, "newModel");
            n(newModel, FlushMode.FLUSH_WITHOUT_DELAY, j3);
        }
    }

    public final void n(@NotNull MediaModel newModel, @NotNull FlushMode flushMode, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, newModel, flushMode, Long.valueOf(j3));
            return;
        }
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(flushMode, "flushMode");
        o(newModel, flushMode, j3, false);
    }

    public final void o(@NotNull MediaModel r75, @NotNull FlushMode flushMode, long targetTime, boolean forceUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, r75, flushMode, Long.valueOf(targetTime), Boolean.valueOf(forceUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(r75, "newModel");
        Intrinsics.checkNotNullParameter(flushMode, "flushMode");
        if (!forceUpdate && Intrinsics.areEqual(r75, this.current)) {
            return;
        }
        synchronized (this) {
            for (i iVar : this.renderLayers) {
                if (!(iVar instanceof k) || this.needUpdateVideo) {
                    if (!(iVar instanceof BackgroundModelRender) || this.needUpdateBackGround) {
                        iVar.d(r75);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        this.current = r75;
        IPlayer player = this.tavCutSession.getPlayer();
        if (player != null) {
            player.setCutDurationList(com.tencent.mobileqq.wink.editor.model.a.q(r75));
        }
        int i3 = b.f384100a[flushMode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            this.tavCutSession.flushWithoutDelay(true, targetTime);
            return;
        }
        this.tavCutSession.flush();
    }

    @NotNull
    public final Map<Integer, Entity> r(@NotNull Entity rootEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Map) iPatchRedirector.redirect((short) 11, (Object) this, (Object) rootEntity);
        }
        Intrinsics.checkNotNullParameter(rootEntity, "rootEntity");
        synchronized (this) {
            ms.a.f("ComposeRenderLayer", "updateByReload --\u300brootEntity:" + rootEntity.getId() + " -> " + rootEntity);
            Map<Integer, Entity> d16 = d.d(rootEntity);
            if (d16.isEmpty()) {
                return d16;
            }
            for (i iVar : this.renderLayers) {
                if (iVar instanceof m) {
                    ((m) iVar).c(d16);
                }
            }
            return d16;
        }
    }

    public final void s(@NotNull StickerModel old, @NotNull StickerModel stickerModel) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) old, (Object) stickerModel);
            return;
        }
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(stickerModel, "new");
        Iterator<T> it = this.renderLayers.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((i) obj) instanceof TemplateTextRenderHelper) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        TemplateTextRenderHelper templateTextRenderHelper = (TemplateTextRenderHelper) obj;
        if (templateTextRenderHelper != null) {
            templateTextRenderHelper.K(old, stickerModel);
        }
        IPlayer player = this.tavCutSession.getPlayer();
        if (player != null) {
            player.requestRender();
        }
    }

    public final void t(@NotNull MediaModel r56, boolean needFlushPlayer, long targetTime, boolean forceFlush) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, r56, Boolean.valueOf(needFlushPlayer), Long.valueOf(targetTime), Boolean.valueOf(forceFlush));
            return;
        }
        Intrinsics.checkNotNullParameter(r56, "newModel");
        if (Intrinsics.areEqual(r56, this.current) && !forceFlush) {
            return;
        }
        synchronized (this) {
            for (i iVar : this.renderLayers) {
                if ((iVar instanceof k) && !this.needUpdateVideo) {
                    ms.a.a("ComposeRenderLayer", "updateWithoutDelay no needUpdateVideo ");
                } else {
                    iVar.d(r56);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        this.current = r56;
        IPlayer player = this.tavCutSession.getPlayer();
        if (player != null) {
            player.setCutDurationList(com.tencent.mobileqq.wink.editor.model.a.q(r56));
        }
        ms.a.a("ComposeRenderLayer", "updateWithoutDelay needFlushPlayer step in ");
        this.tavCutSession.flushWithoutDelay(needFlushPlayer, targetTime);
    }

    public /* synthetic */ ComposeRenderLayer(ICutSession iCutSession, MediaModel mediaModel, RenderScene renderScene, RunningMode runningMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(iCutSession, (i3 & 2) != 0 ? new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null) : mediaModel, (i3 & 4) != 0 ? RenderScene.VIDEO : renderScene, (i3 & 8) != 0 ? RunningMode.PREVIEW : runningMode);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, iCutSession, mediaModel, renderScene, runningMode, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
