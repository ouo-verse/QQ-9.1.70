package com.tencent.icgame.game.live.impl.danmuku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.danmaku.inject.k;
import com.tencent.common.danmaku.inject.l;
import com.tencent.common.danmaku.inject.m;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.xweb.FileReaderHelper;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\u0005\u00a2\u0006\u0004\bC\u0010DJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J(\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\b\u0010\u0018\u001a\u00020\nH\u0016J(\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J(\u0010 \u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\nH\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u00102R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00105R\u0016\u00108\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010?\u001a\u0002048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>\u00a8\u0006F"}, d2 = {"Lcom/tencent/icgame/game/live/impl/danmuku/EsportsDanmakuView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/icgame/game/live/impl/danmuku/f;", "Landroid/view/View;", "danmakuView", "", "type", "rowCount", "Lcom/tencent/icgame/game/live/impl/danmuku/a;", "f", "", DomainData.DOMAIN_NAME, "contentHeight", "i", "", "j", "height", "p", "o", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "l", "Landroid/content/Context;", "ctx", "", FileReaderHelper.TXT_EXT, "txtColor", "priority", "a", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getView", "onStart", DKHippyEvent.EVENT_STOP, "start", "stop", "d", "Lcom/tencent/icgame/game/live/impl/danmuku/a;", "normalDanmakuManager", "", "e", "J", "normalDanmakuStartTime", "Landroid/view/TextureView;", "Landroid/view/TextureView;", "normalDanmakuTextureView", "Lcom/tencent/icgame/game/live/impl/danmuku/DanmakuRender;", "Lcom/tencent/icgame/game/live/impl/danmuku/DanmakuRender;", "danmakuRender", "", "Z", "prepared", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isStart", BdhLogUtil.LogTag.Tag_Conn, "isPause", "D", "I", "k", "()Z", "isDanmakuStart", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class EsportsDanmakuView extends FrameLayout implements f {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isPause;

    /* renamed from: D, reason: from kotlin metadata */
    private int rowCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a normalDanmakuManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long normalDanmakuStartTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextureView normalDanmakuTextureView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DanmakuRender danmakuRender;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean prepared;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isStart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/live/impl/danmuku/EsportsDanmakuView$b", "Lcom/tencent/common/danmaku/inject/l$a;", "", "p0", "p1", "", "v", "d", "i", "e", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements l.a {
        b() {
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void d(@NotNull String p06, @NotNull String p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            g.a(p06, p16);
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void e(@NotNull String p06, @NotNull String p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            g.d(p06, p16);
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void i(@NotNull String p06, @NotNull String p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            g.h(p06, p16);
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void v(@NotNull String p06, @NotNull String p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            g.a(p06, p16);
        }
    }

    static {
        com.tencent.mobileqq.danmaku.a.a();
        l.c(true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EsportsDanmakuView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final a f(View danmakuView, int type, int rowCount) {
        com.tencent.common.danmaku.inject.b m3 = com.tencent.common.danmaku.inject.b.s().t(new k() { // from class: com.tencent.icgame.game.live.impl.danmuku.d
            @Override // com.tencent.common.danmaku.inject.k
            public final com.tencent.common.danmaku.core.a a(com.tencent.common.danmaku.inject.b bVar, com.tencent.common.danmaku.core.b bVar2, Comparator comparator, com.tencent.common.danmaku.tool.f fVar, com.tencent.common.danmaku.tool.c cVar) {
                com.tencent.common.danmaku.core.a g16;
                g16 = EsportsDanmakuView.g(bVar, bVar2, comparator, fVar, cVar);
                return g16;
            }
        }).q(rowCount).n(new com.tencent.common.danmaku.inject.d() { // from class: com.tencent.icgame.game.live.impl.danmuku.e
            @Override // com.tencent.common.danmaku.inject.d
            public final com.tencent.common.danmaku.data.a a(com.tencent.common.danmaku.inject.b bVar, int i3) {
                com.tencent.common.danmaku.data.a h16;
                h16 = EsportsDanmakuView.h(bVar, i3);
                return h16;
            }
        }).l(this.danmakuRender).r(-4).p(true).m();
        Intrinsics.checkNotNullExpressionValue(m3, "newBuilder()\n           \u2026\n                .build()");
        a aVar = new a(danmakuView, m3);
        aVar.J0(true);
        aVar.I0(true);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.tencent.common.danmaku.core.a g(com.tencent.common.danmaku.inject.b bVar, com.tencent.common.danmaku.core.b bVar2, Comparator comparator, com.tencent.common.danmaku.tool.f fVar, com.tencent.common.danmaku.tool.c cVar) {
        return new com.tencent.common.danmaku.core.e(bVar, bVar2, comparator, fVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.tencent.common.danmaku.data.a h(com.tencent.common.danmaku.inject.b danmakuContext, int i3) {
        hv0.d dVar;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(danmakuContext, "danmakuContext");
                dVar = new hv0.a(danmakuContext);
            } else {
                Intrinsics.checkNotNullExpressionValue(danmakuContext, "danmakuContext");
                hv0.b bVar = new hv0.b(danmakuContext);
                bVar.A0(uu0.a.d(-2));
                dVar = bVar;
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(danmakuContext, "danmakuContext");
            hv0.c cVar = new hv0.c(danmakuContext);
            cVar.A0(0.0f);
            dVar = cVar;
        }
        return dVar;
    }

    private final int i(int contentHeight) {
        return (int) (contentHeight / (com.tencent.common.danmaku.util.d.c(uu0.a.c(12.0f)) + (2 * uu0.a.c(8.0f))));
    }

    private final float j(int contentHeight, int rowCount) {
        return (contentHeight - (rowCount * (com.tencent.common.danmaku.util.d.c(uu0.a.c(12.0f)) + (2 * uu0.a.c(8.0f))))) / BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }

    private final boolean k() {
        if (this.isStart && !this.isPause) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(EsportsDanmakuView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.prepared) {
            g.d("ICGameEsportsDanmakuView", "prepare has called");
        } else {
            this$0.prepared = true;
            this$0.rowCount = this$0.p(ut0.b.b());
        }
    }

    private final void n(int type) {
        if ((type == 1 || type == 2) && this.normalDanmakuStartTime == -1) {
            a aVar = this.normalDanmakuManager;
            if (aVar != null) {
                aVar.C0();
            }
            com.tencent.common.danmaku.util.e.b("ICGameEsportsDanmakuView", "normalDanmakuManager start");
            this.normalDanmakuStartTime = System.currentTimeMillis();
        }
    }

    private final void o() {
        if (!k()) {
            return;
        }
        View view = this.normalDanmakuTextureView;
        if (view != null) {
            removeView(view);
        }
        TextureView textureView = new TextureView(getContext());
        this.normalDanmakuTextureView = textureView;
        addView(textureView, new FrameLayout.LayoutParams(-1, -1));
        l();
        a aVar = this.normalDanmakuManager;
        if (aVar != null) {
            aVar.q0();
        }
        View view2 = this.normalDanmakuTextureView;
        if (view2 != null) {
            com.tencent.common.danmaku.util.e.c("ICGameEsportsDanmakuView", "recreate danmakuManager");
            this.normalDanmakuManager = f(view2, 1, this.rowCount);
        }
    }

    private final int p(int height) {
        com.tencent.common.danmaku.util.e.f(new b());
        int b16 = (height - uu0.a.b(8)) - uu0.a.b(8);
        com.tencent.common.danmaku.util.e.b("ICGameEsportsDanmakuView", "contentHeight: " + b16);
        int i3 = i(b16);
        float j3 = j(b16, i3);
        com.tencent.common.danmaku.util.e.b("ICGameEsportsDanmakuView", "density: " + BaseApplication.getContext().getResources().getDisplayMetrics().density);
        float f16 = (float) 2;
        int i16 = (int) (((float) 8) + (j3 / f16));
        com.tencent.common.danmaku.util.e.b("ICGameEsportsDanmakuView", "rowCount: " + i3 + "; marginTop: " + i16 + "; height: " + height + "; lineHeight: " + (com.tencent.common.danmaku.util.d.c(uu0.a.c(12.0f)) + (f16 * uu0.a.c(8.0f))));
        m p16 = com.tencent.common.danmaku.inject.b.p();
        p16.B(i3);
        p16.v(7000);
        p16.s(2.0f);
        p16.t(2.0f);
        p16.F(i16);
        p16.y(8.0f);
        p16.D(12.0f);
        p16.r(true);
        p16.E(true);
        p16.z(0.0f);
        p16.A(0.0f);
        p16.E(false);
        return i3;
    }

    @Override // com.tencent.icgame.game.live.impl.danmuku.f
    public void a(@NotNull Context ctx, @NotNull String txt, int txtColor, int priority) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(txt, "txt");
        if (!k()) {
            return;
        }
        n(1);
        a aVar = this.normalDanmakuManager;
        if (aVar != null) {
            com.tencent.common.danmaku.data.a C = aVar.C(1, new DanmakuDataBean(txt, false));
            C.v0(System.currentTimeMillis() - this.normalDanmakuStartTime);
            aVar.w(C);
        }
    }

    @Override // com.tencent.icgame.game.live.impl.danmuku.f
    public void b(@NotNull Context ctx, @NotNull String txt, int txtColor, int priority) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(txt, "txt");
        if (!k()) {
            return;
        }
        n(2);
        a aVar = this.normalDanmakuManager;
        if (aVar != null) {
            com.tencent.common.danmaku.data.a C = aVar.C(2, new DanmakuDataBean(txt, true));
            C.v0(System.currentTimeMillis() - this.normalDanmakuStartTime);
            aVar.w(C);
        }
    }

    public void l() {
        post(new Runnable() { // from class: com.tencent.icgame.game.live.impl.danmuku.c
            @Override // java.lang.Runnable
            public final void run() {
                EsportsDanmakuView.m(EsportsDanmakuView.this);
            }
        });
    }

    @Override // com.tencent.icgame.game.live.impl.danmuku.f
    public void onDestroy() {
        com.tencent.common.danmaku.util.e.c("ICGameEsportsDanmakuView", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.isStart = false;
        this.normalDanmakuStartTime = -1L;
        a aVar = this.normalDanmakuManager;
        if (aVar != null) {
            aVar.q0();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        a aVar = this.normalDanmakuManager;
        if (aVar != null) {
            aVar.k0();
        }
    }

    @Override // com.tencent.icgame.game.live.impl.danmuku.f
    public void onStart() {
        com.tencent.common.danmaku.util.e.c("ICGameEsportsDanmakuView", "onResume");
        this.isPause = false;
        o();
    }

    @Override // com.tencent.icgame.game.live.impl.danmuku.f
    public void onStop() {
        com.tencent.common.danmaku.util.e.c("ICGameEsportsDanmakuView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.isPause = true;
        this.normalDanmakuStartTime = -1L;
        a aVar = this.normalDanmakuManager;
        if (aVar != null) {
            aVar.n0();
        }
        a aVar2 = this.normalDanmakuManager;
        if (aVar2 != null) {
            aVar2.B();
        }
        a aVar3 = this.normalDanmakuManager;
        if (aVar3 != null) {
            aVar3.q0();
        }
    }

    @Override // com.tencent.icgame.game.live.impl.danmuku.f
    public void start() {
        com.tencent.common.danmaku.util.e.c("ICGameEsportsDanmakuView", "start");
        this.isStart = true;
        o();
    }

    @Override // com.tencent.icgame.game.live.impl.danmuku.f
    public void stop() {
        com.tencent.common.danmaku.util.e.c("ICGameEsportsDanmakuView", "stop");
        this.isStart = false;
        this.normalDanmakuStartTime = -1L;
        a aVar = this.normalDanmakuManager;
        if (aVar != null) {
            aVar.n0();
        }
        a aVar2 = this.normalDanmakuManager;
        if (aVar2 != null) {
            aVar2.B();
        }
        a aVar3 = this.normalDanmakuManager;
        if (aVar3 != null) {
            aVar3.q0();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EsportsDanmakuView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ EsportsDanmakuView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EsportsDanmakuView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.normalDanmakuStartTime = -1L;
        this.danmakuRender = new DanmakuRender();
        this.isPause = true;
    }

    @Override // com.tencent.icgame.game.live.impl.danmuku.f
    @NotNull
    public View getView() {
        return this;
    }
}
