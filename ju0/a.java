package ju0;

import android.content.Context;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import fu0.b;
import fu0.c;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<Long, List<C10613a>> f410953a = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: ju0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C10613a {

        /* renamed from: a, reason: collision with root package name */
        private final int f410954a;

        /* renamed from: b, reason: collision with root package name */
        private final IQQCmdPushCallback f410955b;
    }

    private ILiveRoom O3(long j3) {
        return ((c) qx0.a.b(c.class)).z(j3);
    }

    public void N3() {
        this.f410953a.clear();
    }

    @Override // fu0.b
    public void l(long j3) {
        this.f410953a.remove(Long.valueOf(j3));
    }

    @Override // mm4.a
    public void o2() {
        N3();
    }

    @Override // fu0.b
    public void onEnterRoom(long j3) {
        List<C10613a> list = this.f410953a.get(Long.valueOf(j3));
        if (list != null && !list.isEmpty()) {
            ILiveRoom O3 = O3(j3);
            if (O3 != null) {
                for (C10613a c10613a : list) {
                    O3.registerLivePushChannel(c10613a.f410954a, c10613a.f410955b);
                }
                this.f410953a.remove(Long.valueOf(j3));
                return;
            }
            throw new IllegalStateException("After Enter Room !! but IAudienceRoom is Null!!");
        }
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
