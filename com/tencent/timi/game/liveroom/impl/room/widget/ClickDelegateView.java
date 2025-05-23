package com.tencent.timi.game.liveroom.impl.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/widget/ClickDelegateView;", "Landroid/view/View;", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "inputBoxView", "", "setInputBox", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "d", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ClickDelegateView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimiBaseInputView inputBoxView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClickDelegateView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        boolean z16;
        if (event == null) {
            return super.onTouchEvent(event);
        }
        int action = event.getAction();
        if (action == 2) {
            TimiBaseInputView timiBaseInputView = this.inputBoxView;
            if (timiBaseInputView != null && timiBaseInputView.getCurrentState() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        }
        if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onTouchEvent(event);
    }

    public final void setInputBox(@NotNull TimiBaseInputView inputBoxView) {
        Intrinsics.checkNotNullParameter(inputBoxView, "inputBoxView");
        this.inputBoxView = inputBoxView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClickDelegateView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ClickDelegateView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClickDelegateView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setClickable(true);
    }
}
