package kt3;

import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface d {
    void a(int i3, long j3);

    void b(int i3);

    void c(int i3, int i16, int i17, h hVar);

    void d(int i3, long j3, boolean z16, boolean z17, int i16);

    void e(int i3, long j3, List<QAdVideoItem> list);

    void f(int i3);

    Object g(int i3, String str, Object obj);

    void h(int i3, long j3);

    void i(int i3, long j3, long j16);

    void j(boolean z16, com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g gVar);

    void l(int i3, int i16, int i17, h hVar);

    void m(int i3, long j3);

    void onAdCountDown(int i3, long j3, long j16);

    void onAdCountDownStart(int i3, long j3, long j16);

    void onWarnerTipClick(int i3);
}
