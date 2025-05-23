package com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.timi.game.liveroom.impl.room.bottombtn.ConfigWrapper;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class trpcRoomGlobalConfig$GetBottomConfigRsp extends MessageMicro<trpcRoomGlobalConfig$GetBottomConfigRsp> {
    public static final String SP_KEY = "GetBottomConfigRsp";
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"retcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "outer_item", "inner_item", "version"}, new Object[]{0, "", null, null, 0}, trpcRoomGlobalConfig$GetBottomConfigRsp.class);
    private a listener;
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public trpcRoomGlobalConfig$BottomItem outer_item = new trpcRoomGlobalConfig$BottomItem();
    public final PBRepeatMessageField<trpcRoomGlobalConfig$BottomItem> inner_item = PBField.initRepeatMessage(trpcRoomGlobalConfig$BottomItem.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field roomType = PBField.initUInt32(0);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface a {
    }

    public void updateInnerIconRedPoint(boolean z16, int i3) {
        this.inner_item.get().get(i3).showRedPoint.set(z16);
        ConfigWrapper.putIntoSp(this);
        for (int i16 = 0; i16 < this.inner_item.get().size(); i16++) {
            this.inner_item.get().get(i16).showRedPoint.get();
        }
    }

    public void updateOuterIconRedPoint(boolean z16) {
        this.outer_item.showRedPoint.set(z16);
        ConfigWrapper.putIntoSp(this);
    }

    public void setOnInnerRedPointChangeListener(a aVar) {
    }
}
