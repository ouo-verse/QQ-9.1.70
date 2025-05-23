package az;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Laz/b;", "Laz/a;", "", "O", "", "e", "", "g", "doOnDestroy", "pid", "hasFollowed", "F0", "D0", "E0", "Lzy/a;", "i", "Lzy/a;", "followChangeEventReceiver", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private zy.a followChangeEventReceiver;

    public final void D0() {
        zy.a aVar = new zy.a(this);
        wz.b.b().d(aVar);
        this.followChangeEventReceiver = aVar;
    }

    public final void E0() {
        wz.b b16 = wz.b.b();
        zy.a aVar = this.followChangeEventReceiver;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followChangeEventReceiver");
            aVar = null;
        }
        b16.d(aVar);
    }

    public final void F0(String pid, boolean hasFollowed) {
        xy.a adapter;
        List<yy.c> dataList;
        Intrinsics.checkNotNullParameter(pid, "pid");
        zy.c x06 = x0();
        if (x06 == null || (adapter = x06.getAdapter()) == null || (dataList = adapter.getDataList()) == null) {
            return;
        }
        int i3 = 0;
        for (yy.c cVar : dataList) {
            int i16 = i3 + 1;
            if (Intrinsics.areEqual(cVar.a().oper.PID, pid)) {
                cVar.b().g(hasFollowed ? 2 : 3);
                zy.c x07 = x0();
                if (x07 != null) {
                    x07.P0(i3);
                }
            }
            i3 = i16;
        }
    }

    @Override // zy.b
    public boolean O() {
        return false;
    }

    @Override // az.a
    public void doOnDestroy() {
        super.doOnDestroy();
        E0();
    }

    @Override // zy.b
    public String e() {
        return "message_fans";
    }

    @Override // az.a
    public void g() {
        super.g();
        D0();
    }
}
