package ni4;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;
import nf4.e;
import nf4.h;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a extends mm4.a {
    boolean D0(boolean z16);

    h D1();

    void L();

    String M2(long j3, String str);

    void V2();

    void X2(@NonNull Context context, long j3, String str);

    e b0();

    void initRegisterDatabaseModelClass();

    si4.a l2();

    boolean n0(@NotNull String str);

    void o0();

    void openAnchorRoomPage(@NonNull Context context, int i3, String str);

    ConcurrentHashMap<String, String> s1(long j3);

    void s2(long j3);
}
