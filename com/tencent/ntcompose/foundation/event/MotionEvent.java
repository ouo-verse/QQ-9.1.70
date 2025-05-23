package com.tencent.ntcompose.foundation.event;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.event.j;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001\tBY\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\u000bR\u0017\u0010\u001b\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010(\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b+\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/ntcompose/foundation/event/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "action", "", "b", UserInfo.SEX_FEMALE, "getX", "()F", HippyTKDListViewAdapter.X, "c", "getY", "y", "d", "getPointerCount", "pointerCount", "e", "getPageX", "pageX", "f", "getPageY", "pageY", "", "Lcom/tencent/kuikly/core/base/event/j;", "g", "Ljava/util/List;", "getTouches", "()Ljava/util/List;", "touches", h.F, "Z", "isClick", "()Z", "i", "isLongPress", "<init>", "(IFFIFFLjava/util/List;ZZ)V", "j", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.ntcompose.foundation.event.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class MotionEvent {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    public static final int f339231k = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int action;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float x;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float y;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pointerCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float pageX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float pageY;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<j> touches;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isClick;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isLongPress;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ntcompose/foundation/event/a$a;", "", "Lcom/tencent/kuikly/core/base/event/k;", "e", "", "action", "Lcom/tencent/ntcompose/foundation/event/a;", "a", "ACTION_CANCEL", "I", "ACTION_DOWN", "ACTION_MOVE", "ACTION_UP", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.foundation.event.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MotionEvent a(TouchParams e16, int action) {
            Intrinsics.checkNotNullParameter(e16, "e");
            return new MotionEvent(action, e16.getX(), e16.getY(), Math.max(e16.c().size(), 1), e16.getPageX(), e16.getPageY(), e16.c(), false, false, MsgConstant.KRMFILETHUMBSIZE384, null);
        }

        Companion() {
        }
    }

    public MotionEvent(int i3, float f16, float f17, int i16, float f18, float f19, List<j> touches, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(touches, "touches");
        this.action = i3;
        this.x = f16;
        this.y = f17;
        this.pointerCount = i16;
        this.pageX = f18;
        this.pageY = f19;
        this.touches = touches;
        this.isClick = z16;
        this.isLongPress = z17;
    }

    /* renamed from: a, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((((((this.action * 31) + Float.floatToIntBits(this.x)) * 31) + Float.floatToIntBits(this.y)) * 31) + this.pointerCount) * 31) + Float.floatToIntBits(this.pageX)) * 31) + Float.floatToIntBits(this.pageY)) * 31) + this.touches.hashCode()) * 31;
        boolean z16 = this.isClick;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (floatToIntBits + i3) * 31;
        boolean z17 = this.isLongPress;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "MotionEvent(action=" + this.action + ", x=" + this.x + ", y=" + this.y + ", pointerCount=" + this.pointerCount + ", pageX=" + this.pageX + ", pageY=" + this.pageY + ", touches=" + this.touches + ", isClick=" + this.isClick + ", isLongPress=" + this.isLongPress + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MotionEvent)) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) other;
        return this.action == motionEvent.action && Float.compare(this.x, motionEvent.x) == 0 && Float.compare(this.y, motionEvent.y) == 0 && this.pointerCount == motionEvent.pointerCount && Float.compare(this.pageX, motionEvent.pageX) == 0 && Float.compare(this.pageY, motionEvent.pageY) == 0 && Intrinsics.areEqual(this.touches, motionEvent.touches) && this.isClick == motionEvent.isClick && this.isLongPress == motionEvent.isLongPress;
    }

    public /* synthetic */ MotionEvent(int i3, float f16, float f17, int i16, float f18, float f19, List list, boolean z16, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, f16, f17, i16, f18, f19, list, (i17 & 128) != 0 ? false : z16, (i17 & 256) != 0 ? false : z17);
    }
}
