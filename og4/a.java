package og4;

import android.content.Context;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jg4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements jg4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<Long, List<C10910a>> f422669a = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: og4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C10910a {

        /* renamed from: a, reason: collision with root package name */
        private final int f422670a;

        /* renamed from: b, reason: collision with root package name */
        private final IQQCmdPushCallback f422671b;

        public C10910a(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
            this.f422670a = i3;
            this.f422671b = iQQCmdPushCallback;
        }
    }

    private ILiveRoom O3(long j3) {
        return ((b) mm4.b.b(b.class)).z(j3);
    }

    @Override // jg4.a
    public void L0(long j3, int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        ILiveRoom O3 = O3(j3);
        if (O3 == null) {
            List<C10910a> list = this.f422669a.get(Long.valueOf(j3));
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new C10910a(i3, iQQCmdPushCallback));
            this.f422669a.put(Long.valueOf(j3), list);
            return;
        }
        O3.registerLivePushChannel(i3, iQQCmdPushCallback);
    }

    public void N3() {
        this.f422669a.clear();
    }

    @Override // jg4.a
    public void j3(long j3, IQQCmdPushCallback iQQCmdPushCallback) {
        ILiveRoom O3 = O3(j3);
        if (O3 != null) {
            O3.unRegisterLivePushChannel(iQQCmdPushCallback);
        }
        List<C10910a> list = this.f422669a.get(Long.valueOf(j3));
        if (list != null && !list.isEmpty()) {
            Iterator<C10910a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().f422671b == iQQCmdPushCallback) {
                    it.remove();
                }
            }
            if (list.isEmpty()) {
                this.f422669a.remove(Long.valueOf(j3));
            }
        }
    }

    @Override // jg4.a
    public void l(long j3) {
        this.f422669a.remove(Long.valueOf(j3));
    }

    @Override // mm4.a
    public void o2() {
        N3();
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
