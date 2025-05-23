package com.tencent.mobileqq.activity.home.chats.biz.guild;

import android.graphics.Rect;
import android.view.View;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001BT\u0012K\u0010\u0019\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\u0004\b \u0010!JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016R\\\u0010\u0019\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/e;", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "oldRect", "d", "Lkotlin/jvm/functions/Function3;", "getOnLayoutCallback", "()Lkotlin/jvm/functions/Function3;", "onLayoutCallback", "e", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e implements View.OnLayoutChangeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<View, Rect, Rect, Unit> onLayoutCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Rect rect;

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull Function3<? super View, ? super Rect, ? super Rect, Unit> onLayoutCallback) {
        Intrinsics.checkNotNullParameter(onLayoutCallback, "onLayoutCallback");
        this.onLayoutCallback = onLayoutCallback;
        this.rect = new Rect(0, 0, 0, 0);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@NotNull View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Rect rect = new Rect(left, top, right, bottom);
        if (!Intrinsics.areEqual(rect, this.rect)) {
            this.rect = rect;
            this.onLayoutCallback.invoke(v3, rect, new Rect(oldLeft, oldTop, oldRight, oldBottom));
        }
    }
}
