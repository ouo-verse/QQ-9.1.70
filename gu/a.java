package gu;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.utils.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends EffectPendantBase {
    public static final String[] N = {"params.dat"};
    public final ConcurrentHashMap<String, Integer> J;
    public String K;
    public int L;
    private int M;

    public a(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.J = new ConcurrentHashMap<>();
        this.K = null;
        this.L = 0;
        this.M = 0;
        this.G = N;
    }

    private void e0(EffectPendantBase.a aVar) {
        VideoMaterial videoMaterial = aVar.f73387a;
        if (videoMaterial != null && !videoMaterial.needFaceInfo()) {
            PendantItem u16 = u();
            String T = T(u16);
            aVar.f73387a = VideoMaterial.loadLightAsset(T);
            aVar.f73389c = u16;
            aVar.f73388b = T;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.EffectConfigBase
    public List<PendantItem> F(int i3, String str) {
        List<PendantItem> F = super.F(i3, str);
        ArrayList arrayList = new ArrayList();
        if (F != null && F.size() > 0) {
            for (PendantItem pendantItem : F) {
                if (pendantItem != null) {
                    arrayList.add(pendantItem);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.f73315d, 2, "parse, cid[" + i3 + "], config[" + str + "], size[" + arrayList.size() + "]");
        }
        return arrayList;
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase
    public int U() {
        return 3004;
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase
    public EffectPendantBase.a W(int i3, int i16) {
        if (this.M == 3002) {
            b0(0L, "getVideoPendant");
        }
        EffectPendantBase.a W = super.W(i3, i16);
        if (W != null && W.f73389c != null) {
            e0(W);
            W.f73389c.extraParam = Integer.valueOf(this.L);
        }
        return W;
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase, com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: Z */
    public boolean L(long j3, PendantItem pendantItem) {
        EffectMutexManager effectMutexManager;
        boolean L = super.L(j3, pendantItem);
        if (!d0() && L && pendantItem != null && !TextUtils.isEmpty(pendantItem.getId()) && !TextUtils.equals("0", pendantItem.getId()) && (effectMutexManager = (EffectMutexManager) this.f73316e.B(12)) != null) {
            effectMutexManager.m(3004, pendantItem.getId());
        }
        return L;
    }

    public void b0(long j3, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f73315d, 4, "clearMuteFlag, muteFlag[" + this.M + "], from[" + str + "], cur[" + this.K + "], value[" + this.L + "]");
        }
        int i3 = this.M;
        if (i3 == 3003 || i3 == 3005) {
            M(j3, this.K);
        }
        this.M = 0;
    }

    public int c0(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str)) {
            num = this.J.get(str);
        } else {
            num = null;
        }
        if (num == null) {
            return 50;
        }
        return num.intValue();
    }

    @Override // com.tencent.av.business.manager.EffectMutexManager.a
    public void d(int i3, String str) {
        long d16 = e.d();
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f73315d, 4, "MuteByOthers, fromMuteKey[" + i3 + "], seq[" + d16 + "], data[" + str + "]");
        }
        if (i3 != 3004) {
            if (i3 == 3002) {
                L(d16, null);
                this.M = 3002;
            } else if (i3 != 3003 && i3 == 3005) {
                this.M = 3005;
                L(d16, null);
            }
        }
    }

    public boolean d0() {
        int i3 = this.M;
        if (i3 != 3002 && i3 != 3003) {
            return false;
        }
        return true;
    }

    public void f0(String str, int i3, boolean z16) {
        if (d0()) {
            return;
        }
        if (!TextUtils.equals(str, this.K) || i3 != this.L) {
            this.K = str;
            this.L = i3;
            if (!TextUtils.isEmpty(str)) {
                this.J.put(this.K, Integer.valueOf(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.EffectConfigBase, com.tencent.av.business.manager.a
    public void h(String str, boolean z16) {
        super.h(str, z16);
        if (z16) {
            long d16 = e.d();
            this.K = null;
            this.L = 50;
            L(d16, null);
        } else {
            PendantItem u16 = u();
            if (u16 == null) {
                this.K = null;
                this.L = 50;
            } else {
                this.K = u16.getId();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.f73315d, 2, "onDestroyUI, peerUin[" + str + "], quit[" + z16 + "], item[" + u() + "]");
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public int r() {
        return 591;
    }
}
