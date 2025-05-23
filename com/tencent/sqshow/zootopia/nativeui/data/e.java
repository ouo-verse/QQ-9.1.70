package com.tencent.sqshow.zootopia.nativeui.data;

import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.sqshow.zootopia.nativeui.data.d;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/e;", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "", "E", "Lqu4/a;", "x0", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements d {

    /* renamed from: d, reason: collision with root package name */
    public static final e f370980d = new e();

    e() {
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    /* renamed from: E */
    public boolean getMInitDataReady() {
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    public CameraKey Y() {
        return d.a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    public qu4.a x0() {
        qu4.a aVar;
        dw4.b k3 = com.tencent.sqshow.dresskey.b.f369818a.k("AvatarInitDataDefaultContainer_getInitDressInfo", false, null);
        if (k3 != null) {
            if (k3.f395116c == UEAvatarGender.MALE.getIndex()) {
                aVar = k3.f395117d;
            } else {
                aVar = k3.f395118e;
            }
            if (aVar != null) {
                return aVar;
            }
        }
        return d.a.b(this);
    }
}
