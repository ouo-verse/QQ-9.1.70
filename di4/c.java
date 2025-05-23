package di4;

import ag4.h;
import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Ldi4/c;", "Ljf4/a;", "", ZPlanPublishSource.FROM_SCHEME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Llf4/a;", "launchGameCallback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c implements jf4.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(boolean z16) {
        QLog.d("GameRoomHandlerImpl", 1, "ensureInitWithCallback " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(lf4.a aVar, int i3) {
        l.i("GameRoomHandlerImpl", "launchGame: result == " + i3);
        if (i3 != -3) {
            if (i3 != -2) {
                if (i3 != -1) {
                    if (i3 != 2) {
                        if (aVar != null) {
                            aVar.onFailed();
                            return;
                        }
                        return;
                    } else {
                        QLog.d("GameRoomHandlerImpl", 1, "launchGameScheme ACTION_JUMP_USER_CONFIRM");
                        if (aVar != null) {
                            aVar.onSuccess();
                            return;
                        }
                        return;
                    }
                }
                QLog.d("GameRoomHandlerImpl", 1, "launchGameScheme ACTION_JUMP_USER_CANCEL");
                if (aVar != null) {
                    aVar.onUserCancel();
                    return;
                }
                return;
            }
            QLog.d("GameRoomHandlerImpl", 1, "launchGameScheme ACTION_JUMP_NOT_ALLOWED");
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        QLog.d("GameRoomHandlerImpl", 1, "launchGameScheme ACTION_JUMP_ERROR");
        if (aVar != null) {
            aVar.onFailed();
        }
    }

    @Override // jf4.a
    public void a(@NotNull String scheme, @Nullable Activity activity, @Nullable final lf4.a launchGameCallback) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: di4.a
            @Override // hi4.a
            public final void a(boolean z16) {
                c.d(z16);
            }
        });
        if (!((h) mm4.b.b(h.class)).v2(activity, 101, false, false, "", "", "", null)) {
            if (launchGameCallback != null) {
                launchGameCallback.b();
                return;
            }
            return;
        }
        nm4.a.c(scheme, activity, new SchemeUtil.c() { // from class: di4.b
            @Override // com.tencent.timi.game.scheme.tools.SchemeUtil.c
            public final void onResult(int i3) {
                c.e(lf4.a.this, i3);
            }
        });
    }
}
