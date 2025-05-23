package a42;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.icgame.room.clearscreen.ICGameClearScreenView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ComponentEvent(eventList = {ClearScreenStateChangeEvent.class, DispatchTouchEvent.class})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"La42/c;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView;", "t", "Landroid/view/ViewGroup$LayoutParams;", "f", "", "k", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "u", "v", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends SingleUIComponent<ICGameClearScreenView> {

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"a42/c$a", "Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$c;", "", "isClearScreenState", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements ICGameClearScreenView.c {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.clearscreen.ICGameClearScreenView.c
        public void a(boolean isClearScreenState) {
            c.this.getComponentContext().w0(new ClearScreenStateChangeEvent(isClearScreenState));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"a42/c$b", "Lcom/tencent/mobileqq/icgame/room/clearscreen/ICGameClearScreenView$d;", "Landroid/view/MotionEvent;", "ev", "", "onDispatchTouchEvent", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements ICGameClearScreenView.d {
        b() {
        }

        @Override // com.tencent.mobileqq.icgame.room.clearscreen.ICGameClearScreenView.d
        public void onDispatchTouchEvent(@NotNull MotionEvent ev5) {
            Intrinsics.checkNotNullParameter(ev5, "ev");
            h22.a aVar = c.this.qqLiveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            if (aVar.p()) {
                c.this.getComponentContext().w0(new DispatchTouchEvent(ev5));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent, com.tencent.mobileqq.icgame.framework.component.i
    @Nullable
    public ViewGroup.LayoutParams f() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.xcw;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public ICGameClearScreenView n() {
        ICGameClearScreenView iCGameClearScreenView = new ICGameClearScreenView(getComponentContext().getContext(), R.id.xcv);
        iCGameClearScreenView.setOnClearScreenStateChangeListener(new a());
        iCGameClearScreenView.setOnDispatchTouchEventListener(new b());
        return iCGameClearScreenView;
    }

    public final boolean u() {
        return p().getIsClearScreenState();
    }

    public final boolean v() {
        if (p().getScrollState() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
