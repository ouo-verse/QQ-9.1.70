package e8;

import com.tencent.mobileqq.music.SongInfo;
import e8.e;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface c {
    void a();

    void b();

    void c(String str, String str2, String str3, String str4, String str5, String str6);

    void clear();

    void d(List<SongInfo> list, int i3, int i16, long j3, int i17, int i18);

    void e(String str, String str2, String str3, String str4, String str5);

    e.a f();

    void g(e eVar);

    e.a getCurrentState();

    void h();

    void i(SongInfo songInfo, String str, String str2, String str3);

    void init();

    void j(int i3, int i16, int i17);

    void k(List<SongInfo> list, int i3, int i16, long j3, int i17, int i18);

    void l(SongInfo songInfo);

    void m(SongInfo songInfo);

    void n(List<SongInfo> list, int i3, int i16, long j3, int i17);

    void o(e eVar);

    void pauseMusic();

    void release();

    void setPlayMode(int i3);
}
