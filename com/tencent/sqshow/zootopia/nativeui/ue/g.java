package com.tencent.sqshow.zootopia.nativeui.ue;

import b94.d;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/g;", "Lcom/tencent/sqshow/zootopia/nativeui/ue/s;", "Lqu4/c;", "colorInfo", "", "a", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "c", "", "hexColor", "b", "d", "Lqu4/c;", "mCurrentModifyColorInfo", "Ljava/lang/String;", "mCurrentHexColor", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g implements s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private qu4.c mCurrentModifyColorInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mCurrentHexColor = "";

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.s
    public void a(qu4.c colorInfo) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        this.mCurrentModifyColorInfo = bj3.a.i(colorInfo);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.s
    public void b(String hexColor) {
        Intrinsics.checkNotNullParameter(hexColor, "hexColor");
        this.mCurrentHexColor = hexColor;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.s
    public void c(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        b94.d avatarDressController;
        qu4.c pb5;
        Intrinsics.checkNotNullParameter(channel, "channel");
        qu4.c cVar = this.mCurrentModifyColorInfo;
        if (cVar == null || (avatarDressController = channel.getAvatarDressController()) == null || (pb5 = avatarDressController.pb()) == null) {
            return;
        }
        if (r94.a.e(cVar, pb5)) {
            QLog.i("AvatarColorController_", 1, "resetColorInfoToCurrentModify color info not change!");
            return;
        }
        b94.d avatarDressController2 = channel.getAvatarDressController();
        if (avatarDressController2 != null) {
            d.a.f(avatarDressController2, cVar, false, null, 6, null);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.s
    /* renamed from: d, reason: from getter */
    public String getMCurrentHexColor() {
        return this.mCurrentHexColor;
    }
}
