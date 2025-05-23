package com.tencent.sqshow.zootopia.nativeui.ue;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import s94.FaceControlPointData;
import s94.FaceInfoSyncData;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H'J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H'J\b\u0010\u001b\u001a\u00020\u0002H&J\b\u0010\u001c\u001a\u00020\u0018H&J\b\u0010\u001d\u001a\u00020\bH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/t;", "", "Lqu4/j;", "g", "e", tl.h.F, "Lcom/tencent/sqshow/zootopia/nativeui/ue/r;", "listener", "", "a", "Ls94/a;", "controlData", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "j", "", "slotId", "Lm94/h;", "cb", "b", "i", "faceInfoData", "k", "Ls94/b;", "", "addToHistory", "c", "d", "f", "j1", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface t {
    void a(r listener);

    void b(int slotId, m94.h cb5);

    void c(FaceInfoSyncData faceInfoData, boolean addToHistory);

    qu4.j d();

    qu4.j e();

    boolean f();

    qu4.j g();

    qu4.j h();

    void i(int slotId, m94.h cb5);

    void j(FaceControlPointData controlData, com.tencent.sqshow.zootopia.nativeui.data.j channel);

    void j1();

    void k(int slotId, qu4.j faceInfoData);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static /* synthetic */ void a(t tVar, int i3, m94.h hVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    hVar = m94.b.f416465a;
                }
                tVar.b(i3, hVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToLastDress");
        }

        public static /* synthetic */ void b(t tVar, int i3, m94.h hVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    hVar = m94.b.f416465a;
                }
                tVar.i(i3, hVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToNextDress");
        }
    }
}
