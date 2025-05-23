package com.tencent.qq.minibox.manager.danmaku;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.danmaku.core.DanmakuManager;
import com.tencent.common.danmaku.data.a;
import com.tencent.common.danmaku.inject.b;
import com.tencent.common.danmaku.inject.g;
import com.tencent.common.danmaku.inject.l;
import com.tencent.common.danmaku.inject.m;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qq.minibox.manager.danmaku.MiniBoxDanmakuManager;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$AppCommentInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00019B\u001f\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0007J\u0006\u0010\u0011\u001a\u00020\u0002J\u0014\u0010\u0015\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0014\u0010\"\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R4\u0010.\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030*0)j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030*`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100\u00a8\u0006:"}, d2 = {"Lcom/tencent/qq/minibox/manager/danmaku/MiniBoxDanmakuManager;", "Landroidx/lifecycle/LifecycleObserver;", "", "f", "Lcom/tencent/common/danmaku/inject/b;", h.F, "", "g", "j", "Landroid/view/View;", "e", "Lcom/tencent/common/danmaku/core/DanmakuManager;", "d", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "k", "", "Lcom/tencent/trpcprotocol/minibox/basicinfo/VMBasicInfo$AppCommentInfo;", "infos", "c", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "", "Z", "useTextureView", "Landroid/view/View;", "danmakuView", "i", "Lcom/tencent/common/danmaku/inject/b;", "danmakuContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/common/danmaku/core/DanmakuManager;", "danmakuManager", "Ljava/util/ArrayList;", "Lcom/tencent/common/danmaku/data/a;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "danmakuList", "D", "J", "startTime", "E", "lastInvalidateTime", "Landroidx/fragment/app/Fragment;", "fragmeng", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/content/Context;Landroid/widget/FrameLayout;)V", UserInfo.SEX_FEMALE, "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxDanmakuManager implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<a<?, ?>> danmakuList;

    /* renamed from: D, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: E, reason: from kotlin metadata */
    private long lastInvalidateTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean useTextureView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View danmakuView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b danmakuContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DanmakuManager danmakuManager;

    public MiniBoxDanmakuManager(@NotNull Fragment fragmeng, @NotNull Context context, @NotNull FrameLayout container) {
        Intrinsics.checkNotNullParameter(fragmeng, "fragmeng");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        this.context = context;
        this.container = container;
        this.useTextureView = true;
        this.danmakuView = e();
        this.danmakuContext = h();
        this.danmakuManager = d();
        this.danmakuList = new ArrayList<>();
        com.tencent.mobileqq.danmaku.a.a();
        l.c(true);
        j();
        f();
        fragmeng.getLifecycle().addObserver(this);
    }

    private final DanmakuManager d() {
        com.tencent.mobileqq.danmaku.a.a();
        return new DanmakuManager(this.danmakuView, this.danmakuContext);
    }

    private final View e() {
        if (this.useTextureView) {
            final Context context = this.context;
            return new TextureView(context) { // from class: com.tencent.qq.minibox.manager.danmaku.MiniBoxDanmakuManager$createDanmakuView$textureView$1
                @Override // android.view.View
                public void invalidate() {
                    super.invalidate();
                    MiniBoxDanmakuManager.this.lastInvalidateTime = System.currentTimeMillis();
                }
            };
        }
        return new SurfaceView(this.context);
    }

    private final void f() {
        this.danmakuManager.B0(false);
        View view = this.danmakuView;
        if (view instanceof SurfaceView) {
            ((SurfaceView) view).setZOrderOnTop(true);
        }
        this.danmakuView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        this.container.addView(this.danmakuView, -1, -1);
    }

    private final long g() {
        return System.currentTimeMillis() - this.startTime;
    }

    private final b h() {
        b m3 = b.s().s(new g() { // from class: ms3.a
            @Override // com.tencent.common.danmaku.inject.g
            public final long a() {
                long i3;
                i3 = MiniBoxDanmakuManager.i(MiniBoxDanmakuManager.this);
                return i3;
            }
        }).q(5).o(true).m();
        Intrinsics.checkNotNullExpressionValue(m3, "newBuilder()\n           \u2026\n                .build()");
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(MiniBoxDanmakuManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.g();
    }

    private final void j() {
        m p16 = b.p();
        p16.B(3);
        p16.D(15.0f);
        p16.v(8000);
        p16.s(0.0f);
        p16.t(0.0f);
        p16.F(10);
        p16.y(5.0f);
        p16.x(7);
        p16.r(false);
        p16.E(true);
        p16.z(0.0f);
        p16.A(0.0f);
    }

    public final void c(@NotNull List<VMBasicInfo$AppCommentInfo> infos) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        for (int i3 = 0; i3 < 21; i3++) {
            int i16 = 0;
            for (Object obj : infos) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                a<?, ?> C = this.danmakuManager.C(0, ((VMBasicInfo$AppCommentInfo) obj).get().content.get());
                C.v0((i17 * 1000) + (i3 * 15000));
                this.danmakuList.add(C);
                i16 = i17;
            }
        }
        this.danmakuManager.u(this.danmakuList);
    }

    public final void k() {
        this.startTime = System.currentTimeMillis();
        this.danmakuManager.C0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.danmakuManager.G();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.danmakuManager.m0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.danmakuManager.u0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        this.danmakuManager.m0();
    }
}
