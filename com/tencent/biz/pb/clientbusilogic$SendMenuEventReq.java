package com.tencent.biz.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$SendMenuEventReq extends MessageMicro<clientbusilogic$SendMenuEventReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"event"}, new Object[]{null}, clientbusilogic$SendMenuEventReq.class);
    public Event event = new Event();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Event extends MessageMicro<Event> {
        public static final int CLICK = 1;
        public static final int EVENT = 3;
        public static final int URL = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 26, 32}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "menu_key", CGNonAgeReport.EVENT_TYPE}, new Object[]{0L, "", 0}, Event.class);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBStringField menu_key = PBField.initString("");
        public final PBUInt32Field event_type = PBField.initUInt32(0);
    }
}
