package com.tencent.luggage.wxa.f8;

import android.graphics.Point;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.luggage.wxa.a8.x;
import com.tencent.luggage.wxa.ag.h;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\rB\u000f\u0012\u0006\u00103\u001a\u000201\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\n0\nJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0000H\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0011\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020\u0006H\u0016R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00102R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00104R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00106\u00a8\u00069"}, d2 = {"Lcom/tencent/luggage/wxa/f8/q;", "Lcom/tencent/luggage/wxa/ag/h;", "Lcom/tencent/luggage/wxa/ag/j;", "Lcom/tencent/luggage/wxa/a8/x;", "Lcom/tencent/luggage/wxa/ag/j$a;", "onPlayListener", "", "b", "Lcom/tencent/luggage/wxa/f8/m;", "l", "Landroid/view/Surface;", "surface", "", "a", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "width", "height", "i", "k", "Landroid/graphics/Point;", "e", "Lcom/tencent/luggage/wxa/kj/v;", "pageView", "Lcom/tencent/luggage/wxa/ag/h$a;", "onVideoPositionGotCallback", DomainData.DOMAIN_NAME, "isPlaying", "o", "Lcom/tencent/luggage/wxa/ag/j$b;", "getType", "", "getKey", "d", "()Ljava/lang/Integer;", "getVideoWidth", "getVideoHeight", "c", "Lcom/tencent/luggage/wxa/if/r;", "g", "start", "pause", "release", "j", "isAutoPlay", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "f", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "pluginHandler", "I", "pendingPlayEvent", "Lcom/tencent/luggage/wxa/ag/j$a;", "<init>", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class q implements com.tencent.luggage.wxa.ag.h, com.tencent.luggage.wxa.ag.j, x {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f125509e = "MicroMsg.AppBrand.LivePusherOriginVideoContainer";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LivePusherPluginHandler pluginHandler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int pendingPlayEvent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j.a onPlayListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "value", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b<T> implements ValueCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.a f125514b;

        public b(h.a aVar) {
            this.f125514b = aVar;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceiveValue(String str) {
            com.tencent.luggage.wxa.tn.w.d(q.f125509e, "getVideoPositionAsync, value: " + str);
            try {
                q.this.pluginHandler.updatePosition(new com.tencent.luggage.wxa.xa.h(str));
                this.f125514b.a(q.this.pluginHandler.getPositionX(), q.this.pluginHandler.getPositionY());
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.f(q.f125509e, "getVideoPositionAsync, updatePosition fail since " + e16);
                this.f125514b.a(q.this.pluginHandler.getPositionX(), q.this.pluginHandler.getPositionY());
            }
        }
    }

    public q(@NotNull LivePusherPluginHandler pluginHandler) {
        Intrinsics.checkNotNullParameter(pluginHandler, "pluginHandler");
        this.pluginHandler = pluginHandler;
        pluginHandler.setOnPlayListener(this);
        this.pendingPlayEvent = -1;
    }

    private final void b(j.a onPlayListener) {
        switch (this.pendingPlayEvent) {
            case 0:
                onPlayListener.f(this);
                break;
            case 1:
                onPlayListener.d(this);
                break;
            case 2:
                onPlayListener.a((com.tencent.luggage.wxa.ag.j) this, true);
                break;
            case 3:
                onPlayListener.a((com.tencent.luggage.wxa.ag.j) this, false);
                break;
            case 4:
                onPlayListener.g(this);
                break;
            case 5:
                onPlayListener.b(this);
                break;
            case 6:
                onPlayListener.c(this);
                break;
            case 7:
                onPlayListener.a(this);
                break;
        }
        this.pendingPlayEvent = -1;
    }

    @Override // com.tencent.luggage.wxa.ag.j
    public boolean c() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ag.j
    @Nullable
    public Integer d() {
        Integer originPageViewId = this.pluginHandler.getOriginPageViewId();
        com.tencent.luggage.wxa.tn.w.a(f125509e, "getOriginPageViewId, originPageViewId: " + originPageViewId);
        return originPageViewId;
    }

    @Override // com.tencent.luggage.wxa.ag.h
    @NotNull
    public Point e() {
        return new Point(this.pluginHandler.getPositionX(), this.pluginHandler.getPositionY());
    }

    @Override // com.tencent.luggage.wxa.a8.x
    public void f() {
        Unit unit;
        j.a aVar = this.onPlayListener;
        if (aVar != null) {
            aVar.a(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.pendingPlayEvent = 7;
        }
    }

    @Override // com.tencent.luggage.wxa.ag.j
    @NotNull
    public com.tencent.luggage.wxa.p004if.r g() {
        return t21.b.a(com.tencent.luggage.wxa.p004if.g.f130201b, false, false, 3, null);
    }

    @Override // com.tencent.luggage.wxa.ag.j
    @NotNull
    public String getKey() {
        String key = this.pluginHandler.getKey();
        com.tencent.luggage.wxa.tn.w.a(f125509e, "getKey, key: " + key);
        Intrinsics.checkNotNullExpressionValue(key, "pluginHandler.key.also {\u2026Key, key: $it\")\n        }");
        return key;
    }

    @Override // com.tencent.luggage.wxa.ag.j
    @NotNull
    public j.b getType() {
        return j.b.LivePusher;
    }

    @Override // com.tencent.luggage.wxa.ag.j
    public int getVideoHeight() {
        return -1;
    }

    @Override // com.tencent.luggage.wxa.ag.j
    public int getVideoWidth() {
        return -1;
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public int i() {
        return this.pluginHandler.getHtmlWidth();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public boolean isPlaying() {
        m adapter = this.pluginHandler.getAdapter();
        if (adapter != null) {
            return adapter.isPushing();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.a8.x
    public void j() {
        Unit unit;
        j.a aVar = this.onPlayListener;
        if (aVar != null) {
            aVar.f(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.pendingPlayEvent = 0;
        }
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public int k() {
        return this.pluginHandler.getHtmlHeight();
    }

    @Nullable
    public final m l() {
        return this.pluginHandler.getAdapter();
    }

    public final Surface m() {
        return this.pluginHandler.getSurface();
    }

    public boolean o() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.a8.x
    public void onPause() {
        Unit unit;
        j.a aVar = this.onPlayListener;
        if (aVar != null) {
            aVar.g(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.pendingPlayEvent = 4;
        }
    }

    @Override // com.tencent.luggage.wxa.a8.x
    public void onStop() {
        Unit unit;
        j.a aVar = this.onPlayListener;
        if (aVar != null) {
            aVar.c(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.pendingPlayEvent = 6;
        }
    }

    @Override // com.tencent.luggage.wxa.ag.j
    public void pause() {
        this.pluginHandler.pauseExternal();
    }

    @Override // com.tencent.luggage.wxa.ag.j
    public void release() {
        this.pluginHandler.releaseExternal();
    }

    @Override // com.tencent.luggage.wxa.ag.j
    public void start() {
        this.pluginHandler.startExternal();
    }

    public final boolean a(@Nullable Surface surface) {
        return this.pluginHandler.setSurface(surface);
    }

    public final boolean a(int width, int height) {
        return this.pluginHandler.setSurfaceSize(width, height);
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public void a(@NotNull com.tencent.luggage.wxa.kj.v pageView, @NotNull h.a onVideoPositionGotCallback) {
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(onVideoPositionGotCallback, "onVideoPositionGotCallback");
        com.tencent.luggage.wxa.ei.j jsRuntime = pageView.getJsRuntime();
        if (jsRuntime == null) {
            com.tencent.luggage.wxa.tn.w.f(f125509e, "getVideoPositionAsync, jsRuntime is null");
            onVideoPositionGotCallback.a(this.pluginHandler.getPositionX(), this.pluginHandler.getPositionY());
            return;
        }
        jsRuntime.evaluateJavascript("document.querySelector('embed[embed-id=" + this.pluginHandler.getId() + "]').getBoundingClientRect().toJSON()", new b(onVideoPositionGotCallback));
    }

    @Override // com.tencent.luggage.wxa.ag.j
    public void a(@Nullable j.a onPlayListener) {
        this.onPlayListener = onPlayListener;
        if (onPlayListener != null) {
            b(onPlayListener);
        }
    }

    @Override // com.tencent.luggage.wxa.a8.x
    public void a(boolean isAutoPlay) {
        Unit unit;
        j.a aVar = this.onPlayListener;
        if (aVar != null) {
            aVar.a(this, isAutoPlay);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.pendingPlayEvent = isAutoPlay ? 2 : 3;
        }
    }

    @Override // com.tencent.luggage.wxa.a8.x
    public void b() {
        Unit unit;
        j.a aVar = this.onPlayListener;
        if (aVar != null) {
            aVar.d(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.pendingPlayEvent = 1;
        }
    }

    @Override // com.tencent.luggage.wxa.a8.x
    public void a() {
        Unit unit;
        j.a aVar = this.onPlayListener;
        if (aVar != null) {
            aVar.b(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.pendingPlayEvent = 5;
        }
    }

    @Override // com.tencent.luggage.wxa.ag.h
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public q h() {
        return this;
    }
}
