package com.qzone.reborn.feedx.part.userhome;

import com.qzone.reborn.feedx.part.ch;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends ch {
    @Override // com.qzone.reborn.feedx.part.ch
    public void S9(Object obj) {
        if (!(obj instanceof x6.a)) {
            QLog.e(getLogTag(), 1, "not BusinessUserInfoData");
            return;
        }
        x6.a aVar = (x6.a) obj;
        this.f55102h = aVar;
        if (y6.b.f(aVar.uin)) {
            int i3 = aVar.relationShip;
            if (i3 == 0) {
                ca();
                return;
            }
            if (i3 == 3 || i3 == 4) {
                X9();
            } else if (i3 != 5 && i3 != 6) {
                T9();
            } else {
                aa();
            }
        }
    }

    @Override // com.qzone.reborn.feedx.part.ch, com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneFamousUserGuestBtnGroupPart";
    }
}
