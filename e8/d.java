package e8;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.qzone.personalize.music.model.UserMusicInfo;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface d {
    void a(View view, List<BroadcastMusicInfo> list, boolean z16, int i3, byte b16, byte b17, int i16, int i17, byte b18);

    Intent b(long j3, String str);

    Intent c(String str);

    Intent d(String str);

    Intent e(long j3, String str);

    Intent f(long j3, String str, String str2);

    View g(Context context, long j3, int i3);

    void h(View view, List<UserMusicInfo> list, boolean z16, int i3, byte b16, byte b17, int i16, int i17, byte b18);

    Intent i(long j3);

    View j(Context context, b bVar);

    Intent k(long j3, String str);
}
