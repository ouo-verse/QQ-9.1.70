package com.tencent.trpcprotocol.qqexpand.entrance.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Entrance$EntranceGetRsp extends MessageMicro<Entrance$EntranceGetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"res", "ctrl", "banner_mgr", "entrance_mgr"}, new Object[]{null, null, null, null}, Entrance$EntranceGetRsp.class);
    public Entrance$Result res = new MessageMicro<Entrance$Result>() { // from class: com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance$Result
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "msg"}, new Object[]{0, ""}, Entrance$Result.class);
        public final PBEnumField code = PBField.initEnum(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f381597msg = PBField.initString("");
    };
    public Entrance$GetCtrl ctrl = new MessageMicro<Entrance$GetCtrl>() { // from class: com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance$GetCtrl
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"allow_force_fresh", "get_interval_ms"}, new Object[]{Boolean.FALSE, 0}, Entrance$GetCtrl.class);
        public final PBBoolField allow_force_fresh = PBField.initBool(false);
        public final PBUInt32Field get_interval_ms = PBField.initUInt32(0);
    };
    public Entrance$BannerManager banner_mgr = new MessageMicro<Entrance$BannerManager>() { // from class: com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance$BannerManager
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"can_show", "title", "icon_url", "jump_url"}, new Object[]{Boolean.FALSE, "", "", ""}, Entrance$BannerManager.class);
        public final PBBoolField can_show = PBField.initBool(false);
        public final PBStringField title = PBField.initString("");
        public final PBStringField icon_url = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    };
    public Entrance$EntranceManager entrance_mgr = new MessageMicro<Entrance$EntranceManager>() { // from class: com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance$EntranceManager
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"can_show", "entrances", "show_mode", "may_know_card_count"}, new Object[]{Boolean.FALSE, null, 0, 0}, Entrance$EntranceManager.class);
        public final PBBoolField can_show = PBField.initBool(false);
        public final PBRepeatMessageField<Entrance$EntranceInfo> entrances = PBField.initRepeatMessage(Entrance$EntranceInfo.class);
        public final PBEnumField show_mode = PBField.initEnum(0);
        public final PBUInt32Field may_know_card_count = PBField.initUInt32(0);
    };
}
