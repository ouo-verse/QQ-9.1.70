package com.tencent.luggage.wxa.h8;

import android.graphics.PointF;
import android.util.Size;
import android.view.Surface;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.f8.m;
import com.tencent.luggage.wxa.h8.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\bB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u001a\u0010\u0019\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\b\u0010\u001cR\u001a\u0010!\u001a\u00020\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\u00020\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u001a\u0010&\u001a\u00020\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b%\u0010 \u00a8\u0006*"}, d2 = {"Lcom/tencent/luggage/wxa/h8/a;", "Lcom/tencent/luggage/wxa/h8/e;", "Lcom/tencent/luggage/wxa/h8/b;", "Lcom/tencent/luggage/wxa/h8/c;", "Lcom/tencent/luggage/wxa/h8/d;", "Landroid/view/Surface;", "previewSurface", "", "a", "Landroid/util/Size;", "size", "e", "Lcom/tencent/luggage/wxa/z7/c;", "invokeContext", "", "c", "b", "", BasicAnimation.KeyPath.ROTATION, "Landroid/graphics/PointF;", com.tencent.luggage.wxa.c8.c.G, "scale", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "livePusherBroker", "Lcom/tencent/luggage/wxa/f8/m;", "Lcom/tencent/luggage/wxa/f8/m;", "()Lcom/tencent/luggage/wxa/f8/m;", "livePusher", "Lcom/tencent/luggage/wxa/h8/a;", "g", "()Lcom/tencent/luggage/wxa/h8/a;", "deviceOrientationChangeListener", "d", h.F, "focusPositionChangeListener", "i", "gestureScaleListener", "<init>", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;Lcom/tencent/luggage/wxa/f8/m;)V", "f", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a implements e, b, c, d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LivePusherPluginHandler livePusherBroker;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m livePusher;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a deviceOrientationChangeListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a focusPositionChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a gestureScaleListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/luggage/wxa/h8/a$a;", "Lcom/tencent/luggage/wxa/h8/e$a;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "livePusherBroker", "Lcom/tencent/luggage/wxa/f8/m;", "livePusher", "Lcom/tencent/luggage/wxa/h8/a;", "b", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.wxa.h8.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion implements e.a {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.luggage.wxa.h8.e.a
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(@NotNull LivePusherPluginHandler livePusherBroker, @NotNull m livePusher) {
            Intrinsics.checkNotNullParameter(livePusherBroker, "livePusherBroker");
            Intrinsics.checkNotNullParameter(livePusher, "livePusher");
            return new a(livePusherBroker, livePusher);
        }
    }

    public a(@NotNull LivePusherPluginHandler livePusherBroker, @NotNull m livePusher) {
        Intrinsics.checkNotNullParameter(livePusherBroker, "livePusherBroker");
        Intrinsics.checkNotNullParameter(livePusher, "livePusher");
        this.livePusherBroker = livePusherBroker;
        this.livePusher = livePusher;
        this.deviceOrientationChangeListener = this;
        this.focusPositionChangeListener = this;
        this.gestureScaleListener = this;
    }

    @Override // com.tencent.luggage.wxa.h8.d
    public void a(int scale) {
    }

    @Override // com.tencent.luggage.wxa.h8.b
    public void b(int rotation) {
    }

    @Override // com.tencent.luggage.wxa.h8.e
    public void c(@NotNull com.tencent.luggage.wxa.z7.c invokeContext) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
    }

    @Override // com.tencent.luggage.wxa.h8.e
    @NotNull
    /* renamed from: g, reason: from getter and merged with bridge method [inline-methods] */
    public a f() {
        return this.deviceOrientationChangeListener;
    }

    @Override // com.tencent.luggage.wxa.h8.e
    @NotNull
    /* renamed from: h, reason: from getter and merged with bridge method [inline-methods] */
    public a d() {
        return this.focusPositionChangeListener;
    }

    @Override // com.tencent.luggage.wxa.h8.e
    @NotNull
    /* renamed from: i, reason: from getter and merged with bridge method [inline-methods] */
    public a b() {
        return this.gestureScaleListener;
    }

    @Override // com.tencent.luggage.wxa.h8.c
    public void a(@NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
    }

    @Override // com.tencent.luggage.wxa.h8.e
    public void b(@NotNull com.tencent.luggage.wxa.z7.c invokeContext) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
    }

    @Override // com.tencent.luggage.wxa.h8.e
    @NotNull
    /* renamed from: c, reason: from getter */
    public LivePusherPluginHandler getLivePusherBroker() {
        return this.livePusherBroker;
    }

    @Override // com.tencent.luggage.wxa.h8.e
    public boolean a(@NotNull com.tencent.luggage.wxa.z7.c invokeContext) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        return false;
    }

    @Override // com.tencent.luggage.wxa.h8.e
    public void a(@NotNull Surface previewSurface) {
        Intrinsics.checkNotNullParameter(previewSurface, "previewSurface");
    }

    @Override // com.tencent.luggage.wxa.h8.e
    public void a(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
    }

    @Override // com.tencent.luggage.wxa.h8.e
    @NotNull
    /* renamed from: a, reason: from getter */
    public m getLivePusher() {
        return this.livePusher;
    }

    @Override // com.tencent.luggage.wxa.h8.e
    public void e() {
    }
}
