package com.tencent.mobileqq.vas.avatar;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a2\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a2\u0010\u000e\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a4\u0010\u0011\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a4\u0010\u0012\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\n\u0010\u0016\u001a\u00020\n*\u00020\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "", "uin", "", "faceId", "shopSource", "useSource", "specialShapeMaskId", "", "g", "", "pendantId", "pendantDiyId", "targetId", tl.h.F, "Lcom/tencent/qqnt/avatar/fetch/c;", Const.BUNDLE_KEY_REQUEST, "b", "a", "e", "f", "c", "d", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n {
    private static final void a(QQProAvatarView qQProAvatarView, int i3, int i16, int i17, int i18, com.tencent.qqnt.avatar.fetch.c cVar) {
        int i19;
        int p16 = qQProAvatarView.p();
        String r16 = qQProAvatarView.r();
        com.tencent.mobileqq.proavatar.e o16 = qQProAvatarView.o();
        if (o16 != null) {
            i19 = o16.l();
        } else {
            i19 = 140;
        }
        com.tencent.mobileqq.avatar.utils.e eVar = new com.tencent.mobileqq.avatar.utils.e(p16, r16, i19, i3, null, i16, i17, "", "", false, i18, false, 2048, null);
        try {
            List<com.tencent.qqnt.avatar.bean.a> d16 = cVar.d();
            if (d16 instanceof ArrayList) {
                ((ArrayList) d16).add(eVar);
            } else if (TypeIntrinsics.isMutableList(d16)) {
                d16.add(eVar);
            } else {
                QLog.w("QQProAvatarView", 1, "replaceAvatarBean please loadAvatar first!!");
            }
        } catch (Exception e16) {
            QLog.w("QQProAvatarView", 1, "replaceAvatarBean e: " + e16);
        }
    }

    private static final void b(QQProAvatarView qQProAvatarView, long j3, int i3, int i16, int i17, com.tencent.qqnt.avatar.fetch.c cVar) {
        int i18;
        int p16 = qQProAvatarView.p();
        String r16 = qQProAvatarView.r();
        com.tencent.mobileqq.proavatar.e o16 = qQProAvatarView.o();
        if (o16 != null) {
            i18 = o16.l();
        } else {
            i18 = 140;
        }
        com.tencent.mobileqq.avatar.utils.f fVar = new com.tencent.mobileqq.avatar.utils.f(p16, r16, i18, j3, i3, null, i16, "", "", false, i17);
        try {
            List<com.tencent.qqnt.avatar.bean.a> d16 = cVar.d();
            if (d16 instanceof ArrayList) {
                ((ArrayList) d16).add(fVar);
            } else if (TypeIntrinsics.isMutableList(d16)) {
                d16.add(fVar);
            } else {
                QLog.w("QQProAvatarView", 1, "replaceVasPendantBean please loadAvatar first!!");
            }
        } catch (Exception e16) {
            QLog.w("QQProAvatarView", 1, "replaceVasPendantBean e: " + e16);
        }
    }

    private static final void c(com.tencent.qqnt.avatar.fetch.c cVar, String str) {
        boolean z16;
        List<com.tencent.qqnt.avatar.bean.a> d16 = cVar.d();
        Object obj = null;
        if (d16 != null) {
            Iterator<T> it = d16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((com.tencent.qqnt.avatar.bean.a) next) instanceof com.tencent.mobileqq.avatar.utils.f) {
                    obj = next;
                    break;
                }
            }
            obj = (com.tencent.qqnt.avatar.bean.a) obj;
        }
        boolean z17 = true;
        if (obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Map<String, Object> g16 = cVar.c().g();
        if (g16 instanceof HashMap) {
            HashMap hashMap = (HashMap) g16;
            if (z16 || ((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(str)) {
                z17 = false;
            }
            hashMap.put(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.valueOf(z17));
            return;
        }
        if (TypeIntrinsics.isMutableMap(g16)) {
            if (z16 || ((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(str)) {
                z17 = false;
            }
            g16.put(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.valueOf(z17));
            return;
        }
        Unit unit = Unit.INSTANCE;
    }

    public static final long d(@NotNull QQProAvatarView qQProAvatarView) {
        List<com.tencent.qqnt.avatar.bean.a> d16;
        Object obj;
        Intrinsics.checkNotNullParameter(qQProAvatarView, "<this>");
        try {
            com.tencent.qqnt.avatar.fetch.c q16 = qQProAvatarView.q();
            if (q16 != null && (d16 = q16.d()) != null) {
                Iterator<T> it = d16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((com.tencent.qqnt.avatar.bean.a) obj) instanceof com.tencent.mobileqq.avatar.utils.f) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                com.tencent.qqnt.avatar.bean.a aVar = (com.tencent.qqnt.avatar.bean.a) obj;
                if (aVar != null) {
                    return ((com.tencent.mobileqq.avatar.utils.f) aVar).j();
                }
                return 0L;
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static final void e(com.tencent.qqnt.avatar.fetch.c cVar) {
        List<com.tencent.qqnt.avatar.bean.a> d16 = cVar.d();
        if (d16 == null) {
            return;
        }
        com.tencent.qqnt.avatar.bean.a aVar = null;
        for (com.tencent.qqnt.avatar.bean.a aVar2 : d16) {
            if (aVar2 instanceof com.tencent.mobileqq.avatar.utils.e) {
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            try {
                List<com.tencent.qqnt.avatar.bean.a> d17 = cVar.d();
                if (d17 instanceof ArrayList) {
                    ((ArrayList) d17).remove(aVar);
                } else if (TypeIntrinsics.isMutableList(d17)) {
                    d17.remove(aVar);
                } else {
                    QLog.w("QQProAvatarView", 1, "removeVasAvatar please loadAvatar first!!");
                }
            } catch (Exception e16) {
                QLog.w("QQProAvatarView", 1, "removeVasAvatar e: " + e16);
            }
        }
    }

    private static final void f(com.tencent.qqnt.avatar.fetch.c cVar) {
        List<com.tencent.qqnt.avatar.bean.a> d16 = cVar.d();
        if (d16 == null) {
            return;
        }
        com.tencent.qqnt.avatar.bean.a aVar = null;
        for (com.tencent.qqnt.avatar.bean.a aVar2 : d16) {
            if (aVar2 instanceof com.tencent.mobileqq.avatar.utils.f) {
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            try {
                List<com.tencent.qqnt.avatar.bean.a> d17 = cVar.d();
                if (d17 instanceof ArrayList) {
                    ((ArrayList) d17).remove(aVar);
                } else if (TypeIntrinsics.isMutableList(d17)) {
                    d17.remove(aVar);
                } else {
                    QLog.w("QQProAvatarView", 1, "removeVasAvatar please loadAvatar first!!");
                }
            } catch (Exception e16) {
                QLog.w("QQProAvatarView", 1, "removeVasPendant e: " + e16);
            }
        }
    }

    public static final void g(@NotNull QQProAvatarView qQProAvatarView, @NotNull String uin, int i3, int i16, int i17, int i18) {
        com.tencent.mobileqq.proavatar.e eVar;
        Intrinsics.checkNotNullParameter(qQProAvatarView, "<this>");
        Intrinsics.checkNotNullParameter(uin, "uin");
        qQProAvatarView.k();
        com.tencent.mobileqq.proavatar.e o16 = qQProAvatarView.o();
        if (o16 != null) {
            eVar = o16.b();
        } else {
            eVar = null;
        }
        com.tencent.qqnt.avatar.fetch.c buildResourceFetchRequest = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(qQProAvatarView.p(), uin, eVar);
        e(buildResourceFetchRequest);
        a(qQProAvatarView, i3, i16, i17, i18, buildResourceFetchRequest);
        qQProAvatarView.z(buildResourceFetchRequest, true);
    }

    public static final void h(@NotNull QQProAvatarView qQProAvatarView, @NotNull String uin, long j3, int i3, int i16, int i17) {
        com.tencent.mobileqq.proavatar.e eVar;
        Intrinsics.checkNotNullParameter(qQProAvatarView, "<this>");
        Intrinsics.checkNotNullParameter(uin, "uin");
        qQProAvatarView.k();
        com.tencent.mobileqq.proavatar.e o16 = qQProAvatarView.o();
        if (o16 != null) {
            eVar = o16.b();
        } else {
            eVar = null;
        }
        com.tencent.qqnt.avatar.fetch.c buildResourceFetchRequest = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).buildResourceFetchRequest(qQProAvatarView.p(), uin, eVar);
        f(buildResourceFetchRequest);
        if (j3 > 0 || i3 > 0) {
            b(qQProAvatarView, j3, i3, i16, i17, buildResourceFetchRequest);
        }
        c(buildResourceFetchRequest, uin);
        qQProAvatarView.z(buildResourceFetchRequest, true);
    }
}
