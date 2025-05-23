package com.tencent.mobileqq.vas.bubble.drawable.shoot;

import android.os.Handler;
import android.os.HandlerThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 #2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018J\u001e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0002J\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00150$J\u0006\u0010&\u001a\u00020\tR\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00150$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00150.j\b\u0012\u0004\u0012\u00020\u0015`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00100R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00103R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00104R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u00104\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010A\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010F\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u00103\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010I\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u00103\u001a\u0004\bG\u0010C\"\u0004\bH\u0010E\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/c;", "", "", "meters", DomainData.DOMAIN_NAME, "pixels", "p", "radians", "r", "", "g", "Lorg/jbox2d/dynamics/BodyDef;", "bodyDef", "j", "i", "Lorg/jbox2d/collision/shapes/Shape;", "box", "Lorg/jbox2d/dynamics/FixtureDef;", h.F, "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/g;", CanvasView.ACTION_RECT, "Lorg/jbox2d/dynamics/Body;", "f", ReportConstant.COSTREPORT_PREFIX, "", "width", "height", "e", "dirX", "dirY", "c", "Ljava/lang/Runnable;", "runnable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "animTime", "k", "Ljava/util/concurrent/ConcurrentHashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lorg/jbox2d/dynamics/World;", "a", "Lorg/jbox2d/dynamics/World;", "realWorld", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "rectBodyMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "boundsBodyList", "d", "I", UserInfo.SEX_FEMALE, "lastTime", "getPixelsPerMeter", "()F", "setPixelsPerMeter", "(F)V", "pixelsPerMeter", "Landroid/os/Handler;", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "handler", "getVelocityIterations", "()I", "setVelocityIterations", "(I)V", "velocityIterations", "getPositionIterations", "setPositionIterations", "positionIterations", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final HandlerThread f308885l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final c f308886m;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private World realWorld;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler handler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<XARect, Body> rectBodyMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Body> boundsBodyList = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float lastTime = -1.0f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float pixelsPerMeter = 50.0f;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int velocityIterations = 8;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int positionIterations = 3;

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("physical");
        f308885l = baseHandlerThread;
        f308886m = new c();
        baseHandlerThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, XARect rect, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rect, "$rect");
        try {
            Body f18 = this$0.f(rect);
            if (f18 != null) {
                f18.setAwake(true);
                f18.applyLinearImpulse(new Vec2(f16, f17), f18.getPosition());
            }
        } catch (Exception e16) {
            QLog.e("PhysicalWorld", 1, "addBody error : ", e16);
        }
    }

    private final Body f(XARect rect) {
        World world = this.realWorld;
        if (world == null || rect.getW() == 0 || rect.getH() == 0) {
            return null;
        }
        Body body = this.rectBodyMap.get(rect);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position.set(p(rect.getX() + (rect.getW() / 2.0f)), p(rect.getY() + (rect.getH() / 2.0f)));
        if (body != null) {
            world.destroyBody(body);
        }
        Body createBody = world.createBody(bodyDef);
        if (createBody == null) {
            return null;
        }
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(p(rect.getW() / 2), p(rect.getH() / 2));
        createBody.createFixture(h(polygonShape));
        this.rectBodyMap.put(rect, createBody);
        return createBody;
    }

    private final void g() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.STATIC;
        j(bodyDef);
        i(bodyDef);
    }

    private final FixtureDef h(Shape box) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = box;
        fixtureDef.density = 0.3f;
        fixtureDef.friction = 0.0f;
        fixtureDef.restitution = 0.3f;
        return fixtureDef;
    }

    private final void i(BodyDef bodyDef) {
        World world = this.realWorld;
        if (world == null) {
            return;
        }
        PolygonShape polygonShape = new PolygonShape();
        float p16 = p(this.pixelsPerMeter);
        polygonShape.setAsBox(p16, p(this.height));
        FixtureDef h16 = h(polygonShape);
        bodyDef.position.set(-p16, 0.0f);
        Body createBody = world.createBody(bodyDef);
        createBody.createFixture(h16);
        bodyDef.position.set(p(this.width + p16), 0.0f);
        Body createBody2 = world.createBody(bodyDef);
        createBody2.createFixture(h16);
        this.boundsBodyList.add(createBody);
        this.boundsBodyList.add(createBody2);
    }

    private final void j(BodyDef bodyDef) {
        World world = this.realWorld;
        if (world == null) {
            return;
        }
        PolygonShape polygonShape = new PolygonShape();
        float p16 = p(this.width);
        float p17 = p(this.pixelsPerMeter);
        polygonShape.setAsBox(p16, p17);
        FixtureDef h16 = h(polygonShape);
        bodyDef.position.set(0.0f, -p17);
        Body createBody = world.createBody(bodyDef);
        if (createBody == null) {
            return;
        }
        createBody.createFixture(h16);
        bodyDef.position.set(0.0f, p(this.height + p17));
        Body createBody2 = world.createBody(bodyDef);
        if (createBody2 == null) {
            return;
        }
        createBody2.createFixture(h16);
        this.boundsBodyList.add(createBody);
        this.boundsBodyList.add(createBody2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(c this$0, float f16) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        World world = this$0.realWorld;
        if (world == null || f16 <= this$0.lastTime) {
            return;
        }
        this$0.lastTime = f16;
        try {
            world.step(0.016666668f, this$0.velocityIterations, this$0.positionIterations);
        } catch (Exception e16) {
            QLog.e(IBubbleManager.INSTANCE.b(), 1, "doFrame : error = " + e16);
        }
        for (Map.Entry<XARect, Body> entry : this$0.rectBodyMap.entrySet()) {
            XARect key = entry.getKey();
            Body value = entry.getValue();
            if (key.getAlpha() == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                key.k(this$0.n(value.getPosition().f423649x) - (key.getW() / 2));
                key.l(this$0.n(value.getPosition().f423650y) - (key.getH() / 2.0f));
                key.j(this$0.r(value.getAngle()) % 360.0f);
            }
        }
    }

    private final float n(float meters) {
        return meters * this.pixelsPerMeter;
    }

    private final float p(float pixels) {
        return pixels / this.pixelsPerMeter;
    }

    private final float r(float radians) {
        return (radians / 3.14f) * 180.0f;
    }

    private final void s() {
        boolean z16;
        World world = this.realWorld;
        if (world != null && world.isLocked()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        try {
            this.width = 0;
            this.height = 0;
            for (Body body : this.boundsBodyList) {
                World world2 = this.realWorld;
                if (world2 != null) {
                    world2.destroyBody(body);
                }
            }
            for (Map.Entry<XARect, Body> entry : this.rectBodyMap.entrySet()) {
                World world3 = this.realWorld;
                if (world3 != null) {
                    world3.destroyBody(entry.getValue());
                }
            }
            this.boundsBodyList.clear();
            this.rectBodyMap.clear();
            this.realWorld = null;
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            QLog.e("PhysicalWorld", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        } catch (Exception e16) {
            QLog.e("PhysicalWorld", 1, e16, new Object[0]);
        }
    }

    public final void c(@NotNull final XARect rect, final float dirX, final float dirY) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        q(new Runnable() { // from class: com.tencent.mobileqq.vas.bubble.drawable.shoot.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(c.this, rect, dirX, dirY);
            }
        });
    }

    public final void e(int width, int height) {
        if (this.width == width && this.height == height && (!this.boundsBodyList.isEmpty())) {
            return;
        }
        this.handler = new Handler(f308885l.getLooper());
        this.realWorld = new World(new Vec2(0.0f, 98.0f));
        for (Body body : this.boundsBodyList) {
            World world = this.realWorld;
            if (world != null) {
                world.destroyBody(body);
            }
        }
        this.boundsBodyList.clear();
        this.width = width;
        this.height = height;
        g();
    }

    public final void k(final float animTime) {
        q(new Runnable() { // from class: com.tencent.mobileqq.vas.bubble.drawable.shoot.a
            @Override // java.lang.Runnable
            public final void run() {
                c.l(c.this, animTime);
            }
        });
    }

    @NotNull
    public final ConcurrentHashMap<XARect, Body> m() {
        return this.rectBodyMap;
    }

    public final void o() {
        this.handler = null;
        World world = this.realWorld;
        boolean z16 = false;
        if (world != null && !world.isLocked()) {
            z16 = true;
        }
        if (z16) {
            s();
        }
    }

    public final void q(@NotNull Runnable runnable) {
        Handler handler;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (f308885l.isAlive() && (handler = this.handler) != null) {
            handler.post(runnable);
        }
    }
}
