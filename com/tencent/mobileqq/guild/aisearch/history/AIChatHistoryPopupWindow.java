package com.tencent.mobileqq.guild.aisearch.history;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.util.cw;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u001c2\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R#\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/history/AIChatHistoryPopupWindow;", "", "Landroid/widget/PopupWindow;", "g", "Landroid/view/View;", "anchorView", "", "i", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "b", "Lkotlin/jvm/functions/Function1;", "itemClickListener", "c", "Landroid/widget/PopupWindow;", "popupWindow", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", tl.h.F, "()Landroid/view/View;", "popupView", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIChatHistoryPopupWindow {

    /* renamed from: f, reason: collision with root package name */
    private static final int f213990f = (int) cw.c(12.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Integer, Unit> itemClickListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupView;

    public AIChatHistoryPopupWindow(@NotNull Context context, @Nullable Function1<? super Integer, Unit> function1) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.itemClickListener = function1;
        lazy = LazyKt__LazyJVMKt.lazy(new AIChatHistoryPopupWindow$popupView$2(this));
        this.popupView = lazy;
    }

    private final PopupWindow g() {
        PopupWindow popupWindow = new PopupWindow(h(), -2, -2, true);
        popupWindow.setAnimationStyle(0);
        return popupWindow;
    }

    private final View h() {
        return (View) this.popupView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AIChatHistoryPopupWindow this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.itemClickListener;
        if (function1 != null) {
            function1.invoke(0);
        }
    }

    public final void i(@NotNull View anchorView) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        if (this.popupWindow == null) {
            this.popupWindow = g();
        }
        Rect rect = new Rect();
        anchorView.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        anchorView.getLocationOnScreen(iArr);
        int height = rect.bottom - (iArr[1] + anchorView.getHeight());
        int i3 = iArr[1] - rect.top;
        float fontLevel = FontSettingManager.getFontLevel() / 16.0f;
        int b16 = com.tencent.guild.aio.util.c.b(3);
        roundToInt = MathKt__MathJVMKt.roundToInt(com.tencent.guild.aio.util.c.b(20) * fontLevel);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(com.tencent.guild.aio.util.c.b(52) * fontLevel);
        int i16 = (-roundToInt) + b16;
        int i17 = (((-anchorView.getHeight()) - roundToInt2) - roundToInt) - b16;
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.guild.aisearch.history.d
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    AIChatHistoryPopupWindow.j(AIChatHistoryPopupWindow.this);
                }
            });
        }
        if (height <= roundToInt2 + roundToInt && height <= i3) {
            PopupWindow popupWindow2 = this.popupWindow;
            if (popupWindow2 != null) {
                popupWindow2.showAsDropDown(anchorView, 0, i17, 8388611);
                return;
            }
            return;
        }
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.showAsDropDown(anchorView, 0, i16, 8388611);
        }
    }
}
