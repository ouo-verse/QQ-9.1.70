package com.tencent.biz.pubaccount.weishi.verticalvideo.utils;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.pubaccount.weishi.download.WSPagDownloadUtil;
import com.tencent.biz.pubaccount.weishi.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedPlayEvent;
import com.tencent.biz.pubaccount.weishi.util.ah;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalBottomSpeedPlayController;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.s;
import com.tencent.mobileqq.R;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0003J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003J8\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0003J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u0014\u0010 \u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010'R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/utils/b;", "", "", "position", "", "f", "", "l", "Landroid/view/MotionEvent;", "event", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/WSVerticalBottomSpeedPlayController;", "speedController", "Landroid/content/Context;", "context", "", "uniCode", "k", "a", "", "speed", "b", "j", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/s;", "operationController", "i", h.F, "d", "g", "c", "I", "TOUCH_WIDTH", "Z", "e", "()Z", "setLongPress", "(Z)V", "isLongPress", UserInfo.SEX_FEMALE, "startY", "isInBottom", "isInTop", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isLongPress;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static float startY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isInBottom;

    /* renamed from: a, reason: collision with root package name */
    public static final b f82304a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int TOUCH_WIDTH = ah.b(110.0f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isInTop = true;

    b() {
    }

    @JvmStatic
    private static final void a(MotionEvent event, Context context, int uniCode, WSVerticalBottomSpeedPlayController speedController) {
        if (isInBottom) {
            if (event.getY() - startY >= 0.0f) {
                startY = event.getY();
            }
        } else if (event.getY() - startY > 40.0f) {
            isInBottom = true;
            isInTop = false;
            startY = event.getY();
            f82304a.b(context, uniCode, 1.5f);
            speedController.x("1.5", R.string.x7_);
            x.b("WSPlaySpeedHelper", "--------------- slide 1.5x");
        }
        if (isInTop) {
            if (event.getY() - startY <= 0.0f) {
                startY = event.getY();
            }
        } else if (event.getY() - startY < -40.0f) {
            isInTop = true;
            isInBottom = false;
            startY = event.getY();
            f82304a.b(context, uniCode, 2.0f);
            speedController.x(SemanticAttributes.HttpFlavorValues.HTTP_2_0, R.string.x78);
            x.b("WSPlaySpeedHelper", "--------------- slide 2x");
        }
    }

    private final void b(Context context, int uniCode, float speed) {
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(2L);
        wz.b.b().a(new WSSpeedPlayEvent(true, speed, uniCode));
    }

    private final boolean c(j item) {
        return !item.i();
    }

    private final boolean d(MotionEvent event, Context context) {
        int f16 = ah.f(context);
        float x16 = event.getX();
        int i3 = TOUCH_WIDTH;
        if (x16 >= i3 && f16 - event.getX() >= i3) {
            return false;
        }
        x.i("WSPlaySpeedHelper", "x:" + event.getX() + ", realWidth:" + f16);
        return true;
    }

    private final boolean g() {
        return u10.c.b();
    }

    @JvmStatic
    private static final boolean h(MotionEvent event, j item, Context context) {
        b bVar = f82304a;
        if (!bVar.c(item)) {
            x.i("WSPlaySpeedHelper", "onLongPress not support speed play");
            return false;
        }
        if (!bVar.d(event, context)) {
            x.i("WSPlaySpeedHelper", "onLongPress not in speed hot zone");
            return false;
        }
        if (!WSPagDownloadUtil.f()) {
            return false;
        }
        x.i("WSPlaySpeedHelper", "onLongPress start speed play");
        return true;
    }

    @JvmStatic
    public static final boolean i(MotionEvent event, j item, Context context, WSVerticalBottomSpeedPlayController speedController, s operationController, int uniCode) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(speedController, "speedController");
        Intrinsics.checkNotNullParameter(operationController, "operationController");
        if (!f82304a.g()) {
            x.i("WSPlaySpeedHelper", "onLongPress ---not hit exp");
            return false;
        }
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(10L);
        if (h(event, item, context)) {
            isLongPress = true;
            startY = event.getY();
            isInTop = true;
            isInBottom = false;
            wz.b.b().a(new WSClearModeEvent(true));
            wz.b.b().a(new WSSpeedPlayEvent(true, 2.0f, uniCode));
            speedController.w();
            speedController.x(SemanticAttributes.HttpFlavorValues.HTTP_2_0, R.string.x78);
            return true;
        }
        operationController.T();
        return false;
    }

    @JvmStatic
    private static final void j(WSVerticalBottomSpeedPlayController speedController, int uniCode) {
        l();
        isLongPress = false;
        startY = 0.0f;
        x.i("WSPlaySpeedHelper", "onSingleTapUp");
        wz.b.b().a(new WSClearModeEvent(false));
        wz.b.b().a(new WSSpeedPlayEvent(false, 2.0f, uniCode));
        speedController.u();
    }

    @JvmStatic
    public static final void k(MotionEvent event, WSVerticalBottomSpeedPlayController speedController, Context context, int uniCode) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(speedController, "speedController");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isLongPress) {
            if (!f82304a.g()) {
                x.i("WSPlaySpeedHelper", "onTouch ---not hit exp");
                return;
            }
            if (event.getAction() != 1 && event.getAction() != 3) {
                if (event.getAction() == 2) {
                    a(event, context, uniCode, speedController);
                }
            } else {
                x.b("WSPlaySpeedHelper", "itemView onTouch up");
                j(speedController, uniCode);
            }
        }
    }

    @JvmStatic
    public static final void l() {
        ai.j("is_show_speed_guide", true);
    }

    public final boolean e() {
        return isLongPress;
    }

    @JvmStatic
    public static final boolean f(long position) {
        return position > 2 && !ai.a("is_show_speed_guide", false);
    }
}
