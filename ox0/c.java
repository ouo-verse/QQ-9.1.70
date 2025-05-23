package ox0;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface c<T extends MessageMicro> {
    void a(T t16, FromServiceMsg fromServiceMsg);

    void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable T t16, @Nullable FromServiceMsg fromServiceMsg);
}
