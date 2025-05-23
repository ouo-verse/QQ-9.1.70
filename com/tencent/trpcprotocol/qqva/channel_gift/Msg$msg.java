package com.tencent.trpcprotocol.qqva.channel_gift;

import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Msg$msg extends MessageMicro<Msg$msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 56, 66, 74, 80, 88, 98, 106}, new String[]{"giftid", "giftname", "recvuin", "recvnickname", "senduin", "sendnickname", "price", "orderid", "bgimage", "tianquanid", "level", LayoutAttrDefine.PADDING_TOP, "reserve_info"}, new Object[]{0L, "", 0L, "", 0L, "", 0L, "", "", 0L, 0, "", null}, Msg$msg.class);
    public final PBInt64Field giftid = PBField.initInt64(0);
    public final PBStringField giftname = PBField.initString("");
    public final PBInt64Field recvuin = PBField.initInt64(0);
    public final PBStringField recvnickname = PBField.initString("");
    public final PBInt64Field senduin = PBField.initInt64(0);
    public final PBStringField sendnickname = PBField.initString("");
    public final PBInt64Field price = PBField.initInt64(0);
    public final PBStringField orderid = PBField.initString("");
    public final PBStringField bgimage = PBField.initString("");
    public final PBInt64Field tianquanid = PBField.initInt64(0);
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBStringField padding_top = PBField.initString("");
    public Msg$ReserveInfo reserve_info = new Msg$ReserveInfo();

    public String getGiftMsg() {
        if (TextUtils.isEmpty(this.sendnickname.get()) || TextUtils.isEmpty(this.giftname.get()) || TextUtils.isEmpty(this.recvnickname.get())) {
            return "";
        }
        String str = this.sendnickname.get() + "\u9001" + this.giftname.get() + "\u7ed9" + this.recvnickname.get();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return "";
        }
        String currentUin = waitAppRuntime.getCurrentUin();
        String selfTinyId = ((IGPSService) waitAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (currentUin.equals(String.valueOf(this.recvuin.get())) || selfTinyId.equals(String.valueOf(this.recvuin.get()))) {
            return this.sendnickname.get() + "\u9001" + this.giftname.get() + "\u7ed9\u6211";
        }
        return str;
    }
}
