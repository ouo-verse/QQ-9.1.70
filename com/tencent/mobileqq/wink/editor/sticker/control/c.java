package com.tencent.mobileqq.wink.editor.sticker.control;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\t\u001a\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R*\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010%R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010 \u001a\u0004\b(\u0010%\"\u0004\b)\u0010*R$\u0010.\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010%\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/control/c;", "", "", HippyTKDListViewAdapter.X, "", "e", "Lkotlin/Function2;", "", "callback", "g", "d", "Landroid/view/View;", "a", "Landroid/view/View;", "cursorView", "b", "cursorParent", "", "c", "I", "cursorTouchAreaScale", "Lkotlin/jvm/functions/Function2;", UserInfo.SEX_FEMALE, "cursorX", "f", "lastMoveX", "lastTranslationX", "Landroid/graphics/Rect;", tl.h.F, "Landroid/graphics/Rect;", "hitRect", "i", "Z", "isMoving", "<set-?>", "j", "getCursorEnable", "()Z", "cursorEnable", "k", "getTouchMoveable", "setTouchMoveable", "(Z)V", "touchMoveable", "l", "getInTouch", "inTouch", "<init>", "(Landroid/view/View;Landroid/view/View;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View cursorView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View cursorParent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int cursorTouchAreaScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super Float, ? super Boolean, Unit> callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float cursorX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float lastMoveX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float lastTranslationX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect hitRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isMoving;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean cursorEnable;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean touchMoveable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean inTouch;

    public c(@NotNull View cursorView, @NotNull View cursorParent, int i3) {
        Intrinsics.checkNotNullParameter(cursorView, "cursorView");
        Intrinsics.checkNotNullParameter(cursorParent, "cursorParent");
        this.cursorView = cursorView;
        this.cursorParent = cursorParent;
        this.cursorTouchAreaScale = i3;
        this.lastMoveX = -1.0f;
        this.lastTranslationX = -1.0f;
        this.hitRect = new Rect();
        cursorParent.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean c16;
                c16 = c.c(c.this, view, motionEvent);
                return c16;
            }
        });
        this.cursorEnable = true;
        this.touchMoveable = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(c this$0, View view, MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z18 = false;
        if (motionEvent.getAction() != 1 && motionEvent.getAction() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.inTouch = z16;
        if (!this$0.touchMoveable) {
            return false;
        }
        if (this$0.lastMoveX < 0.0f && motionEvent.getAction() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this$0.lastTranslationX = -1.0f;
                    }
                } else {
                    this$0.isMoving = true;
                    float d16 = this$0.d(this$0.cursorX + (motionEvent.getX() - this$0.lastMoveX));
                    if (d16 == this$0.lastTranslationX) {
                        z18 = true;
                    }
                    if (!z18) {
                        Function2<? super Float, ? super Boolean, Unit> function2 = this$0.callback;
                        if (function2 != null) {
                            function2.invoke(Float.valueOf(d16), Boolean.FALSE);
                        }
                        this$0.lastTranslationX = d16;
                    }
                }
            } else {
                if (this$0.isMoving) {
                    float min = Math.min(this$0.cursorParent.getWidth(), Math.max(0.0f, this$0.cursorView.getTranslationX()));
                    Function2<? super Float, ? super Boolean, Unit> function22 = this$0.callback;
                    if (function22 != null) {
                        function22.invoke(Float.valueOf(min), Boolean.TRUE);
                    }
                    this$0.isMoving = false;
                }
                this$0.lastMoveX = -1.0f;
                this$0.lastTranslationX = -1.0f;
                view.performClick();
            }
        } else {
            this$0.cursorView.getHitRect(this$0.hitRect);
            if (this$0.hitRect.left - (this$0.cursorView.getWidth() * this$0.cursorTouchAreaScale) > motionEvent.getX() || this$0.hitRect.right + (this$0.cursorView.getWidth() * this$0.cursorTouchAreaScale) < motionEvent.getX()) {
                return false;
            }
            this$0.cursorX = this$0.cursorView.getTranslationX();
            this$0.lastMoveX = motionEvent.getX();
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cursorView.setTranslationX(this$0.d(f16));
    }

    public final float d(float x16) {
        return Math.min(Math.max(x16, 0.0f), this.cursorParent.getWidth() - this.cursorView.getWidth());
    }

    public final void e(final float x16) {
        if (!this.cursorEnable) {
            return;
        }
        if (this.cursorParent.getWidth() != 0) {
            this.cursorView.setTranslationX(d(x16));
        } else {
            this.cursorView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.f(c.this, x16);
                }
            });
        }
    }

    public final void g(@NotNull Function2<? super Float, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }
}
