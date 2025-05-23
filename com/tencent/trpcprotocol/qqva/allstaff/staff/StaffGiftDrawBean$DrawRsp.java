package com.tencent.trpcprotocol.qqva.allstaff.staff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class StaffGiftDrawBean$DrawRsp extends MessageMicro<StaffGiftDrawBean$DrawRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"RetCode", "Msg", "state", "FreeCoins", "GiftName"}, new Object[]{0, "", 0, 0, ""}, StaffGiftDrawBean$DrawRsp.class);
    public final PBInt32Field RetCode = PBField.initInt32(0);
    public final PBStringField Msg = PBField.initString("");
    public final PBEnumField state = PBField.initEnum(0);
    public final PBInt32Field FreeCoins = PBField.initInt32(0);
    public final PBStringField GiftName = PBField.initString("");

    public boolean isAlreadyDraw() {
        if (this.RetCode.get() == -2992) {
            return true;
        }
        return false;
    }

    public boolean isNotRemained() {
        if (this.RetCode.get() == -2997) {
            return true;
        }
        return false;
    }

    public boolean isNotValid() {
        if (this.RetCode.get() == -3000) {
            return true;
        }
        return false;
    }

    public boolean isPumpCoin() {
        if (isWin() && this.state.get() == 3) {
            return true;
        }
        return false;
    }

    public boolean isPumpGift() {
        if (isWin() && this.state.get() == 4) {
            return true;
        }
        return false;
    }

    public boolean isWin() {
        if (this.RetCode.get() == 0) {
            return true;
        }
        return false;
    }
}
