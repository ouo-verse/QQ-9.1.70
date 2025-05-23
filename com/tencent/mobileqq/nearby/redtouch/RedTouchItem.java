package com.tencent.mobileqq.nearby.redtouch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x6cd$MessageRec;
import tencent.im.oidb.cmd0x6cd$RedpointInfo;
import tencent.im.oidb.cmd0x6cd$RepointExtraInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RedTouchItem implements Serializable {
    private static final long serialVersionUID = 0;
    public byte[] bytes;
    public String configVersion;
    public int count;
    public long curSeq;
    public long fromId;
    public String icon;
    public int lastRecvTime;
    public int redtouchType;
    public int taskId;
    public String tips;
    public long receiveTime = 0;
    public int validTimeRemained = 0;
    public boolean unReadFlag = true;
    public int passThroughLevel = 0;
    public List<RedTouchItemExtMsg> extMsgs = new ArrayList();
    public boolean isClosed = false;

    public static RedTouchItem getRedTouchItem(cmd0x6cd$RedpointInfo cmd0x6cd_redpointinfo) {
        int i3;
        long j3;
        int i16;
        long j16;
        int i17;
        int i18;
        cmd0x6cd$RepointExtraInfo cmd0x6cd_repointextrainfo;
        long j17;
        int i19;
        byte[] bArr;
        int i26;
        String str;
        byte[] bArr2;
        if (cmd0x6cd_redpointinfo == null || !cmd0x6cd_redpointinfo.uint32_taskid.has() || !cmd0x6cd_redpointinfo.uint64_cur_seq.has()) {
            return null;
        }
        RedTouchItem redTouchItem = new RedTouchItem();
        if (cmd0x6cd_redpointinfo.uint32_taskid.has()) {
            i3 = cmd0x6cd_redpointinfo.uint32_taskid.get();
        } else {
            i3 = 0;
        }
        redTouchItem.taskId = i3;
        if (cmd0x6cd_redpointinfo.uint64_cur_seq.has()) {
            j3 = cmd0x6cd_redpointinfo.uint64_cur_seq.get();
        } else {
            j3 = 0;
        }
        redTouchItem.curSeq = j3;
        if (cmd0x6cd_redpointinfo.enum_redpoint_type.has()) {
            i16 = cmd0x6cd_redpointinfo.enum_redpoint_type.get();
        } else {
            i16 = 0;
        }
        redTouchItem.redtouchType = i16;
        if (cmd0x6cd_redpointinfo.uint64_from_id.has()) {
            j16 = cmd0x6cd_redpointinfo.uint64_from_id.get();
        } else {
            j16 = 0;
        }
        redTouchItem.fromId = j16;
        if (cmd0x6cd_redpointinfo.uint32_last_recv_time.has()) {
            i17 = cmd0x6cd_redpointinfo.uint32_last_recv_time.get();
        } else {
            i17 = 0;
        }
        redTouchItem.lastRecvTime = i17;
        if (cmd0x6cd_redpointinfo.int32_remained_time.has()) {
            i18 = cmd0x6cd_redpointinfo.int32_remained_time.get();
        } else {
            i18 = 0;
        }
        redTouchItem.validTimeRemained = i18;
        redTouchItem.receiveTime = System.currentTimeMillis();
        redTouchItem.configVersion = cmd0x6cd_redpointinfo.str_config_version.get();
        if (cmd0x6cd_redpointinfo.msg_redpoint_extra_info.has()) {
            cmd0x6cd_repointextrainfo = cmd0x6cd_redpointinfo.msg_redpoint_extra_info.get();
        } else {
            cmd0x6cd_repointextrainfo = null;
        }
        if (cmd0x6cd_repointextrainfo != null) {
            if (cmd0x6cd_repointextrainfo.uint32_count.has()) {
                i26 = cmd0x6cd_repointextrainfo.uint32_count.get();
            } else {
                i26 = 0;
            }
            redTouchItem.count = i26;
            String str2 = "";
            if (!cmd0x6cd_repointextrainfo.str_icon_url.has()) {
                str = "";
            } else {
                str = cmd0x6cd_repointextrainfo.str_icon_url.get();
            }
            redTouchItem.icon = str;
            if (cmd0x6cd_repointextrainfo.str_tips.has()) {
                str2 = cmd0x6cd_repointextrainfo.str_tips.get();
            }
            redTouchItem.tips = str2;
            if (cmd0x6cd_repointextrainfo.bytes_data.has()) {
                bArr2 = cmd0x6cd_repointextrainfo.bytes_data.get().toByteArray();
            } else {
                bArr2 = null;
            }
            redTouchItem.bytes = bArr2;
        }
        if (cmd0x6cd_redpointinfo.rpt_msg_unread_msg.has() && cmd0x6cd_redpointinfo.rpt_msg_unread_msg.get().size() > 0) {
            for (cmd0x6cd$MessageRec cmd0x6cd_messagerec : cmd0x6cd_redpointinfo.rpt_msg_unread_msg.get()) {
                RedTouchItemExtMsg redTouchItemExtMsg = new RedTouchItemExtMsg();
                if (cmd0x6cd_messagerec.uint64_seq.has()) {
                    j17 = cmd0x6cd_messagerec.uint64_seq.get();
                } else {
                    j17 = 0;
                }
                redTouchItemExtMsg.seq = j17;
                if (cmd0x6cd_messagerec.uint32_time.has()) {
                    i19 = cmd0x6cd_messagerec.uint32_time.get();
                } else {
                    i19 = 0;
                }
                redTouchItemExtMsg.time = i19;
                if (cmd0x6cd_messagerec.bytes_content.has()) {
                    bArr = cmd0x6cd_messagerec.bytes_content.get().toByteArray();
                } else {
                    bArr = null;
                }
                redTouchItemExtMsg.bytesData = bArr;
                redTouchItem.extMsgs.add(redTouchItemExtMsg);
            }
        }
        return redTouchItem;
    }

    public String toString() {
        return "RedTouchItem{hash=" + hashCode() + ", taskId=" + this.taskId + ", curSeq=" + this.curSeq + ", redtouchType=" + this.redtouchType + ", count=" + this.count + ", icon='" + this.icon + "', tips='" + this.tips + "', fromId=" + this.fromId + ", lastRecvTime=" + this.lastRecvTime + ", receiveTime=" + this.receiveTime + ", validTimeRemained=" + this.validTimeRemained + ", unReadFlag=" + this.unReadFlag + ", passThroughLevel=" + this.passThroughLevel + ", configVersion='" + this.configVersion + "'}";
    }
}
