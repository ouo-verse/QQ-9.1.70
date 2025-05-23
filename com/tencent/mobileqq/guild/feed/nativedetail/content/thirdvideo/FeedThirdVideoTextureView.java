package com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.TextureView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0012\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)BA\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoTextureView;", "Landroid/view/TextureView;", "", "url", "", h.F, "e", "f", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "d", "i", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;", "webEventListener", "", "Z", "serviceDisconnected", "com/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoTextureView$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoTextureView$b;", "innerWebEventListener", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder;", "mRemoteSurfaceHolder", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "lifecycleOwnerWeakRef", "Landroidx/lifecycle/LifecycleEventObserver;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleEventObserver;", "lifeCycleObserver", "Landroid/content/Context;", "context", "viewType", "linkedWebPageId", "Lkotlin/Pair;", "", "initialSize", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/Pair;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes13.dex */
public final class FeedThirdVideoTextureView extends TextureView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c webEventListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean serviceDisconnected;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b innerWebEventListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FeedRemoteSurfaceHolder mRemoteSurfaceHolder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<LifecycleOwner> lifecycleOwnerWeakRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LifecycleEventObserver lifeCycleObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoTextureView$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;", "", "loadSucceed", "", "code", "", "msg", "onError", "", RemoteWebViewEvent.OPEN_FULL_SCREEN, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements c {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
        public void a(boolean openFullScreen) {
            c cVar = FeedThirdVideoTextureView.this.webEventListener;
            if (cVar != null) {
                cVar.a(openFullScreen);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
        public void loadSucceed() {
            QLog.i("FeedThirdVideoWebView", 1, "[loadSucceed] [" + FeedThirdVideoTextureView.this.f() + "]");
            FeedThirdVideoTextureView.this.serviceDisconnected = false;
            c cVar = FeedThirdVideoTextureView.this.webEventListener;
            if (cVar != null) {
                cVar.loadSucceed();
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
        public void onError(int code, @Nullable String msg2) {
            QLog.i("FeedThirdVideoWebView", 1, "[onError] [" + FeedThirdVideoTextureView.this.f() + "](" + code + ", " + msg2 + ")");
            FeedThirdVideoTextureView.this.serviceDisconnected = true;
            c cVar = FeedThirdVideoTextureView.this.webEventListener;
            if (cVar != null) {
                cVar.onError(code, msg2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedThirdVideoTextureView(@NotNull Context context, @NotNull String viewType, @Nullable String str, @NotNull Pair<Integer, Integer> initialSize, @Nullable c cVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        this.webEventListener = cVar;
        this.innerWebEventListener = new b();
        this.mRemoteSurfaceHolder = new FeedRemoteSurfaceHolder(this, viewType, this.innerWebEventListener, str, initialSize);
        this.lifeCycleObserver = new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.b
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                FeedThirdVideoTextureView.g(FeedThirdVideoTextureView.this, lifecycleOwner, event);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FeedThirdVideoTextureView this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            QLog.i("FeedThirdVideoWebView", 1, "[ON_RESUME] [" + this$0.f() + "], serviceDisconnected: " + this$0.serviceDisconnected + ", this:" + this$0.hashCode());
            this$0.mRemoteSurfaceHolder.x(this$0.serviceDisconnected);
            return;
        }
        if (event == Lifecycle.Event.ON_PAUSE) {
            QLog.i("FeedThirdVideoWebView", 1, "[ON_PAUSE] [" + this$0.f() + "], this:" + this$0.hashCode());
            this$0.mRemoteSurfaceHolder.w();
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            QLog.i("FeedThirdVideoWebView", 1, "[ON_DESTROY] [" + this$0.f() + "], this:" + this$0.hashCode());
            this$0.i();
        }
    }

    public final void d(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwnerWeakRef = new WeakReference<>(lifecycleOwner);
        lifecycleOwner.getLifecycle().addObserver(this.lifeCycleObserver);
    }

    @NotNull
    public final String e() {
        String url = this.mRemoteSurfaceHolder.getUrl();
        if (url == null) {
            return "";
        }
        return url;
    }

    @NotNull
    public final String f() {
        return this.mRemoteSurfaceHolder.getWebPageId();
    }

    public final void h(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mRemoteSurfaceHolder.t(url);
    }

    public final void i() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        this.mRemoteSurfaceHolder.y();
        this.mRemoteSurfaceHolder.n();
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwnerWeakRef;
        if (weakReference != null && (lifecycleOwner = weakReference.get()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifeCycleObserver);
        }
    }
}
