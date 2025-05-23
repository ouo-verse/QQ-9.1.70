package com.tencent.mobileqq.wink.picker.core.part;

import android.graphics.SurfaceTexture;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataListResult;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.render.ComposeRenderLayer;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/an;", "Lcom/tencent/biz/richframework/part/Part;", "d", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class an extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private static SurfaceTexture f324585e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private static IPlayer f324586f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private static ICutSession f324587h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static ComposeRenderLayer f324588i;

    /* renamed from: m, reason: collision with root package name */
    public static WinkEditDataListResult f324589m;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020.8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u00100R\u0014\u00103\u001a\u0002028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/an$a;", "", "", "k", "j", "i", "l", tl.h.F, "", "a", "b", "Landroid/graphics/SurfaceTexture;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "f", "()Landroid/graphics/SurfaceTexture;", "p", "(Landroid/graphics/SurfaceTexture;)V", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "mPlayer", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "d", "()Lcom/tencent/tavcut/core/render/player/IPlayer;", DomainData.DOMAIN_NAME, "(Lcom/tencent/tavcut/core/render/player/IPlayer;)V", "Lcom/tencent/tavcut/core/session/ICutSession;", "mCutSession", "Lcom/tencent/tavcut/core/session/ICutSession;", "c", "()Lcom/tencent/tavcut/core/session/ICutSession;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "mRenderLayerPlayer", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "e", "()Lcom/tencent/videocut/render/ComposeRenderLayer;", "o", "(Lcom/tencent/videocut/render/ComposeRenderLayer;)V", "Lcom/tencent/mobileqq/wink/editor/draft/b;", "result", "Lcom/tencent/mobileqq/wink/editor/draft/b;", "g", "()Lcom/tencent/mobileqq/wink/editor/draft/b;", "setResult", "(Lcom/tencent/mobileqq/wink/editor/draft/b;)V", "", "COUNT_ONE", "I", "INVALID_WIDTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.core.part.an$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            boolean b16 = b();
            AECameraPrefsUtil.c().h("SP_PRELOAD_PLAYER", false, 0);
            boolean b17 = AECameraPrefsUtil.c().b("SP_PRELOAD_PLAYER", false, 0);
            w53.b.f("WinkTavPlayerViewPart", "enablePreloadPlayer config " + b16 + " default " + b17);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enablePreloadPlayer preloadSwitch ");
            sb5.append(b17);
            w53.b.f("WinkTavPlayerViewPart", sb5.toString());
            AECameraPrefsUtil.c().h("SP_PRELOAD_PLAYER", b17, 0);
            return b17;
        }

        public final boolean b() {
            return QzoneConfig.enablePreloadPlayer(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        }

        @Nullable
        public final ICutSession c() {
            return an.f324587h;
        }

        @Nullable
        public final IPlayer d() {
            return an.f324586f;
        }

        @Nullable
        public final ComposeRenderLayer e() {
            return an.f324588i;
        }

        @Nullable
        public final SurfaceTexture f() {
            return an.f324585e;
        }

        @NotNull
        public final WinkEditDataListResult g() {
            WinkEditDataListResult winkEditDataListResult = an.f324589m;
            if (winkEditDataListResult != null) {
                return winkEditDataListResult;
            }
            Intrinsics.throwUninitializedPropertyAccessException("result");
            return null;
        }

        public final void h() {
            w53.b.f("WinkTavPlayerViewPart", "preload player  release");
            k();
            l();
            i();
            j();
        }

        public final void i() {
            w53.b.f("WinkTavPlayerViewPart", "preload player  releasePlayer");
            ICutSession c16 = c();
            if (c16 != null) {
                c16.release();
            }
            m(null);
        }

        public final void j() {
            w53.b.f("WinkTavPlayerViewPart", "preload player  releaseLayer");
            o(null);
        }

        public final void k() {
            w53.b.f("WinkTavPlayerViewPart", "preload player  releasePlayer");
            IPlayer d16 = d();
            if (d16 != null) {
                d16.release();
            }
            n(null);
        }

        public final void l() {
            w53.b.f("WinkTavPlayerViewPart", "preload player  releaseSurfaceTexture");
            SurfaceTexture f16 = f();
            if (f16 != null) {
                f16.release();
            }
            p(null);
        }

        public final void m(@Nullable ICutSession iCutSession) {
            an.f324587h = iCutSession;
        }

        public final void n(@Nullable IPlayer iPlayer) {
            an.f324586f = iPlayer;
        }

        public final void o(@Nullable ComposeRenderLayer composeRenderLayer) {
            an.f324588i = composeRenderLayer;
        }

        public final void p(@Nullable SurfaceTexture surfaceTexture) {
            an.f324585e = surfaceTexture;
        }

        Companion() {
        }
    }
}
