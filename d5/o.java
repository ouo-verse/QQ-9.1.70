package d5;

import android.content.Intent;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface o<T> {
    void a();

    void b(Message message);

    void c(m<T> mVar, int i3);

    void d(k<T> kVar, int i3, int i16);

    void destroy();

    void init();

    boolean onActivityResult(int i3, int i16, Intent intent);

    void onPause();
}
