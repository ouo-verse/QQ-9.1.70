package a13;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.api.ETFontUtil;
import com.tencent.mobileqq.vas.font.drawable.ETDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"La13/b;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "<init>", "()V", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends Handler {
    public b() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message msg2) {
        ETDecoration eTDecoration;
        boolean z16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Object obj = msg2.obj;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.vas.font.drawable.DecorationHolder");
        com.tencent.mobileqq.vas.font.drawable.a aVar = (com.tencent.mobileqq.vas.font.drawable.a) obj;
        ETDrawable eTDrawable = aVar.f309162a.get();
        if (eTDrawable != null) {
            eTDecoration = eTDrawable.getDecoration();
        } else {
            eTDecoration = null;
        }
        if (eTDecoration == null) {
            return;
        }
        int i3 = msg2.what;
        if (i3 != 0) {
            if (i3 == 1) {
                if (Intrinsics.areEqual(eTDrawable.getBitmapLocker().getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String(), aVar.f309167f) && eTDrawable.getMsgId() == aVar.f309163b && eTDrawable.getDecoration() != null) {
                    ETDecoration decoration = eTDrawable.getDecoration();
                    Intrinsics.checkNotNull(decoration);
                    if (decoration.currentFrameIndex() == aVar.f309165d && Intrinsics.areEqual(eTDrawable.getFont(), aVar.f309166e.f32703d)) {
                        boolean z17 = false;
                        if (eTDrawable.getDecorRunning() && eTDrawable.getDecorRunning() && ETFontUtil.enableAnimation && !eTDrawable.getPauseAnimation()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            eTDrawable.X();
                            ETDecoration decoration2 = eTDrawable.getDecoration();
                            Intrinsics.checkNotNull(decoration2);
                            if (decoration2.nextFrame()) {
                                int frameDelay = decoration2.getFrameDelay();
                                int currentTimeMillis = (int) (System.currentTimeMillis() - aVar.f309164c);
                                if (currentTimeMillis > 0) {
                                    frameDelay -= currentTimeMillis;
                                }
                                Message obtainMessage = obtainMessage(0, com.tencent.mobileqq.vas.font.drawable.a.a(eTDrawable));
                                Intrinsics.checkNotNullExpressionValue(obtainMessage, "obtainMessage(\n         \u2026                        )");
                                if (frameDelay <= 1) {
                                    sendMessage(obtainMessage);
                                } else {
                                    sendMessageDelayed(obtainMessage, frameDelay);
                                }
                            } else {
                                eTDrawable.k0(false);
                                eTDrawable.X();
                                eTDrawable.A();
                                eTDrawable.j0(z17);
                                return;
                            }
                        }
                        z17 = z16;
                        eTDrawable.j0(z17);
                        return;
                    }
                }
                QLog.e("UpdateUIHandler", 2, "this textView reused!");
                return;
            }
            return;
        }
        eTDrawable.getCreateDecorationHandler().obtainMessage(2, com.tencent.mobileqq.vas.font.drawable.a.a(eTDrawable)).sendToTarget();
    }
}
