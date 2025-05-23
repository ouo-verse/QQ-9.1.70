package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a implements g {

    /* renamed from: a, reason: collision with root package name */
    protected d f304096a;

    protected abstract void a(f fVar);

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onEvent(f fVar) {
        if (fVar == null) {
            return;
        }
        int i3 = fVar.f304100a;
        if (i3 != 15) {
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                case 9:
                    break;
                case 6:
                    d dVar = this.f304096a;
                    if (dVar != null) {
                        dVar.b(fVar);
                        return;
                    }
                    return;
                case 7:
                    a(fVar);
                    return;
                default:
                    return;
            }
        }
        d dVar2 = this.f304096a;
        if (dVar2 != null) {
            dVar2.a(fVar);
        }
    }
}
