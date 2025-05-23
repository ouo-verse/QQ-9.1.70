package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends EffectPendantBase {
    public static final String[] J = {"params.dat"};

    public d(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.G = J;
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase
    public int U() {
        return 3005;
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase
    public EffectPendantBase.a W(int i3, int i16) {
        return super.W(i3, i16);
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase, com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: Z */
    public boolean L(long j3, PendantItem pendantItem) {
        EffectMutexManager effectMutexManager;
        boolean L = super.L(j3, pendantItem);
        if (L && pendantItem != null && !TextUtils.isEmpty(pendantItem.getId()) && !TextUtils.equals("0", pendantItem.getId()) && (effectMutexManager = (EffectMutexManager) this.f73316e.B(12)) != null) {
            effectMutexManager.m(3005, pendantItem.getId());
        }
        return L;
    }

    @Override // com.tencent.av.business.manager.EffectMutexManager.a
    public void d(int i3, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f73315d, 4, "MuteByOthers, fromMuteKey[" + i3 + "], data[" + str + "]");
        }
        if (i3 != U()) {
            L(0L, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void j(long j3, int i3, String str, String str2) {
        PendantItem u16;
        if ((i3 == 2 || i3 == 3) && (u16 = u()) != null && !TextUtils.isEmpty(u16.getId())) {
            L(j3, null);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public int r() {
        return 623;
    }
}
