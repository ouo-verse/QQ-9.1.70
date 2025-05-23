package com.tencent.mobileqq.guild.inbox.centerpanel.assistant;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/a;", "Landroid/text/method/LinkMovementMethod;", "Landroid/widget/TextView;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/Spannable;", "buffer", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends LinkMovementMethod {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static a f226126b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/a$a;", "", "Landroid/text/method/MovementMethod;", "a", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/a;", "sInstance", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/a;", "b", "()Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/a;", "c", "(Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/a;)V", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MovementMethod a() {
            if (b() == null) {
                c(new a());
            }
            return b();
        }

        @Nullable
        public final a b() {
            return a.f226126b;
        }

        public final void c(@Nullable a aVar) {
            a.f226126b = aVar;
        }

        Companion() {
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(@Nullable TextView widget, @Nullable Spannable buffer, @Nullable MotionEvent event) {
        Intrinsics.checkNotNull(event);
        int action = event.getAction();
        if (action == 0 || action == 1) {
            int x16 = (int) event.getX();
            int y16 = (int) event.getY();
            Intrinsics.checkNotNull(widget);
            int totalPaddingLeft = x16 - widget.getTotalPaddingLeft();
            int totalPaddingTop = y16 - widget.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + widget.getScrollX();
            int scrollY = totalPaddingTop + widget.getScrollY();
            Layout layout = widget.getLayout();
            int lineForVertical = layout.getLineForVertical(scrollY);
            if (lineForVertical >= layout.getLineCount() - 1 && layout.getLineWidth(lineForVertical) < scrollX) {
                return false;
            }
        }
        return super.onTouchEvent(widget, buffer, event);
    }
}
