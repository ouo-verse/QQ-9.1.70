package com.tencent.mobileqq.guild.media.thirdapp.container.vb;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.live.widget.GuildLiveFixVideoTransView;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.e;
import com.tencent.mobileqq.guild.media.thirdapp.container.vm.GuildContainerSurfaceVM;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\t*\u0001)\u0018\u0000 /2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u00010B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0003J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/f;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVB;", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "h1", "i1", "k1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerSurfaceVM;", "g1", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "Landroid/view/TextureView;", "e", "Landroid/view/TextureView;", "textureView", "f", "Landroid/widget/FrameLayout;", "textureViewLayout", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveFixVideoTransView;", tl.h.F, "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveFixVideoTransView;", "fixVideoTransView", "", "i", "I", "surfaceHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "surfaceWidth", "com/tencent/mobileqq/guild/media/thirdapp/container/vb/f$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/f$b;", "surfaceTextureListener", "<init>", "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends BaseVB<com.tencent.mobileqq.guild.media.thirdapp.container.intent.e, MviUIState, com.tencent.base.api.runtime.a<BaseParam>> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b surfaceTextureListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextureView textureView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout textureViewLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildLiveFixVideoTransView fixVideoTransView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int surfaceHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int surfaceWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vb/f$b", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        b() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVB", 1, "onSurfaceTextureAvailable width:" + width + ", height:" + height);
            f.this.surfaceWidth = width;
            f.this.surfaceHeight = height;
            f.this.sendIntent(new e.SurfaceCreated(new Surface(surfaceTexture), width, height));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surfaceTexture) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVB", 1, "[onSurfaceTextureDestroyed] ");
            f.this.sendIntent(new e.SurfaceDestroy(null, 1, null));
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVB", 1, "onSurfaceTextureSizeChanged width " + width + ", height " + height);
            if (f.this.surfaceWidth != width || f.this.surfaceHeight != height) {
                f.this.surfaceWidth = width;
                f.this.surfaceHeight = height;
                f.this.sendIntent(new e.SurfaceChanged(new Surface(surfaceTexture), width, height));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surfaceTexture) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        }
    }

    public f(@NotNull GuildOpenContainerLauncher.StartParams startParams) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        this.startParams = startParams;
        this.surfaceTextureListener = new b();
    }

    private final void h1(FrameLayout parent) {
        GuildLiveFixVideoTransView guildLiveFixVideoTransView = new GuildLiveFixVideoTransView(parent.getContext());
        this.fixVideoTransView = guildLiveFixVideoTransView;
        parent.addView(guildLiveFixVideoTransView, new FrameLayout.LayoutParams(-1, -1, 1));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void i1(FrameLayout parent) {
        TextureView textureView = new TextureView(parent.getContext());
        this.textureView = textureView;
        textureView.setId(R.id.wp_);
        TextureView textureView2 = this.textureView;
        TextureView textureView3 = null;
        if (textureView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            textureView2 = null;
        }
        parent.addView(textureView2, new FrameLayout.LayoutParams(-1, -1, 1));
        TextureView textureView4 = this.textureView;
        if (textureView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            textureView4 = null;
        }
        textureView4.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vb.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean j16;
                j16 = f.j1(f.this, view, motionEvent);
                return j16;
            }
        });
        TextureView textureView5 = this.textureView;
        if (textureView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        } else {
            textureView3 = textureView5;
        }
        textureView3.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j1(f this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RemoteWebRenderIPCServer a16 = RemoteWebRenderIPCServer.INSTANCE.a();
        String webPageId = this$0.startParams.getWebPageId();
        Intrinsics.checkNotNullExpressionValue(event, "event");
        a16.G(webPageId, event);
        return true;
    }

    private final void k1(FrameLayout parent) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVB", 1, "initTextureViewLayout");
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        this.textureViewLayout = frameLayout;
        frameLayout.setId(R.id.wpa);
        FrameLayout frameLayout2 = this.textureViewLayout;
        FrameLayout frameLayout3 = null;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureViewLayout");
            frameLayout2 = null;
        }
        frameLayout2.setBackgroundColor(-16777216);
        FrameLayout frameLayout4 = this.textureViewLayout;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureViewLayout");
            frameLayout4 = null;
        }
        parent.addView(frameLayout4, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout5 = this.textureViewLayout;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureViewLayout");
        } else {
            frameLayout3 = frameLayout5;
        }
        i1(frameLayout3);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public GuildContainerSurfaceVM createVM() {
        return new GuildContainerSurfaceVM();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerSurfaceVB", 1, "[onCreateView] ");
        ViewGroup b16 = createViewParams.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) b16;
        h1(frameLayout);
        k1(frameLayout);
        TextureView textureView = this.textureView;
        if (textureView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            return null;
        }
        return textureView;
    }
}
