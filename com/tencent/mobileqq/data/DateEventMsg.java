package com.tencent.mobileqq.data;

import android.text.TextUtils;
import appoint.define.appoint_define$AppointInfo;
import appoint.define.appoint_define$DateEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dating.e;
import com.tencent.mobileqq.dating.f;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DateEventMsg extends Entity implements Comparable<DateEventMsg> {
    public int attendIdx;
    public byte bDeleted;
    public byte bReaded;

    @notColumn
    public com.tencent.mobileqq.dating.c date_comment;

    @notColumn
    public appoint_define$AppointInfo date_info;

    @unique
    public long event_id;

    @notColumn
    boolean isInited = false;
    public String msg_content;
    public byte[] msg_date_info;
    public String msg_user_info;

    @notColumn
    public String strReadableTime;

    @notColumn
    public String strTime;

    @notColumn
    public String str_event_tips;
    public long time;
    public int type;

    @notColumn
    public e user_info;

    public static DateEventMsg convertFrom(appoint_define$DateEvent appoint_define_dateevent) {
        if (appoint_define_dateevent == null) {
            return null;
        }
        DateEventMsg dateEventMsg = new DateEventMsg();
        dateEventMsg.event_id = appoint_define_dateevent.uint64_event_id.get();
        dateEventMsg.time = appoint_define_dateevent.uint32_time.get();
        dateEventMsg.type = appoint_define_dateevent.uint32_type.get();
        dateEventMsg.attendIdx = appoint_define_dateevent.uint32_attend_idx.get();
        dateEventMsg.bDeleted = (byte) 0;
        dateEventMsg.bReaded = (byte) 0;
        if (appoint_define_dateevent.msg_user_info.has()) {
            dateEventMsg.user_info = e.a(appoint_define_dateevent.msg_user_info.get());
        } else {
            dateEventMsg.msg_user_info = null;
        }
        if (appoint_define_dateevent.msg_date_info.has()) {
            dateEventMsg.date_info = appoint_define_dateevent.msg_date_info.get();
        } else {
            dateEventMsg.date_info = null;
        }
        int i3 = dateEventMsg.type;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 || i3 == 4 || i3 == 5) {
                String str = appoint_define_dateevent.str_event_tips.get();
                dateEventMsg.str_event_tips = str;
                if (TextUtils.isEmpty(str)) {
                    int i16 = dateEventMsg.type;
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                dateEventMsg.str_event_tips = HardCodeUtil.qqStr(R.string.l9h);
                            }
                        } else {
                            dateEventMsg.str_event_tips = HardCodeUtil.qqStr(R.string.l9g);
                        }
                    } else {
                        dateEventMsg.str_event_tips = HardCodeUtil.qqStr(R.string.l9f);
                    }
                }
                f.j("DateEventMsg.convertFrom", appoint_define_dateevent.str_event_tips.get(), dateEventMsg.str_event_tips);
            }
        } else {
            if (appoint_define_dateevent.msg_comment.has()) {
                dateEventMsg.date_comment = com.tencent.mobileqq.dating.c.a(appoint_define_dateevent.msg_comment.get());
            } else {
                f.i("DateEventMsg.convertFrom", "msg_comment no value");
            }
            f.j("DateEventMsg.convertFrom", dateEventMsg.date_comment);
        }
        dateEventMsg.isInited = true;
        return dateEventMsg;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass() || this.event_id != ((DateEventMsg) obj).event_id) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x008e -> B:32:0x0091). Please report as a decompilation issue!!! */
    public void init() {
        if (this.isInited) {
            return;
        }
        this.isInited = true;
        try {
            if (TextUtils.isEmpty(this.msg_user_info)) {
                this.user_info = null;
            } else {
                this.user_info = e.e(new JSONObject(this.msg_user_info));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        byte[] bArr = this.msg_date_info;
        if (bArr != null && bArr.length != 0) {
            appoint_define$AppointInfo appoint_define_appointinfo = new appoint_define$AppointInfo();
            this.date_info = appoint_define_appointinfo;
            try {
                appoint_define_appointinfo.mergeFrom(this.msg_date_info);
            } catch (InvalidProtocolBufferMicroException e17) {
                e17.printStackTrace();
            }
        } else {
            this.date_info = null;
        }
        int i3 = this.type;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 || i3 == 4 || i3 == 5) {
                this.str_event_tips = this.msg_content;
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(this.msg_content)) {
                this.str_event_tips = "";
            } else {
                this.date_comment = com.tencent.mobileqq.dating.c.f(new JSONObject(this.msg_content));
                f.j("DateEventMsg.init", Integer.valueOf(this.type), this.date_comment, this.msg_content);
            }
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        String jSONObject;
        JSONObject c16 = e.c(this.user_info);
        String str = "";
        if (c16 == null) {
            jSONObject = "";
        } else {
            jSONObject = c16.toString();
        }
        this.msg_user_info = jSONObject;
        appoint_define$AppointInfo appoint_define_appointinfo = this.date_info;
        if (appoint_define_appointinfo != null) {
            this.msg_date_info = appoint_define_appointinfo.toByteArray();
        } else {
            this.msg_date_info = null;
        }
        int i3 = this.type;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 || i3 == 4 || i3 == 5) {
                String str2 = this.str_event_tips;
                if (str2 != null) {
                    str = str2;
                }
                this.msg_content = str;
                return;
            }
            return;
        }
        JSONObject d16 = com.tencent.mobileqq.dating.c.d(this.date_comment);
        if (d16 != null) {
            str = d16.toString();
        }
        this.msg_content = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(DateEventMsg dateEventMsg) {
        if (dateEventMsg == null) {
            return 1;
        }
        long j3 = this.event_id;
        long j16 = dateEventMsg.event_id;
        if (j3 > j16) {
            return 1;
        }
        return j3 == j16 ? 0 : -1;
    }
}
