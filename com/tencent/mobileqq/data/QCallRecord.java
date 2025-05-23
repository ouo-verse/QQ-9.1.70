package com.tencent.mobileqq.data;

import android.text.TextUtils;
import android.text.format.DateFormat;
import com.tencent.imcore.message.an;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QCallRecord extends Entity {
    private static final int Kilo = 1000;
    public static int TYPE_DATE = 0;
    public static int TYPE_REALRECORD = 1;
    public static final int VERSION_CODE = 1;
    public int contactId;
    public String friendUin;
    public int isVideo;
    public int issend;
    public byte[] msgData;
    public String senderuin;
    public int state;
    public String talkTime;
    public long time;
    public int type;
    public int uinType;
    public long uniseq;
    public int versionCode;

    public QCallRecord() {
        this(TYPE_REALRECORD);
    }

    public void createMessageUniseq() {
        long j3 = (int) this.time;
        this.uniseq = j3;
        if (j3 == 0) {
            this.uniseq = (int) (System.currentTimeMillis() / 1000);
        }
        this.uniseq = (this.uniseq << 32) | Math.abs(new Random().nextInt());
    }

    public int getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.time * 1000);
        return calendar.get(5);
    }

    public String getDateString() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(this.time * 1000);
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return HardCodeUtil.qqStr(R.string.q8g);
        }
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) + 1 == calendar2.get(6)) {
            return HardCodeUtil.qqStr(R.string.q8e);
        }
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) > calendar2.get(6) - 7) {
            switch (calendar.get(7)) {
                case 1:
                    return HardCodeUtil.qqStr(R.string.q89);
                case 2:
                    return HardCodeUtil.qqStr(R.string.q8b);
                case 3:
                    return HardCodeUtil.qqStr(R.string.q8a);
                case 4:
                    return HardCodeUtil.qqStr(R.string.q8c);
                case 5:
                    return HardCodeUtil.qqStr(R.string.q8f);
                case 6:
                    return HardCodeUtil.qqStr(R.string.q8i);
                case 7:
                    return HardCodeUtil.qqStr(R.string.q8d);
            }
        }
        return new SimpleDateFormat("yy-MM-dd").format(date);
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return getTableName(this.friendUin, this.uinType);
    }

    public String getTalkTimeMinute() {
        int i3;
        int i16;
        String str = "";
        if (TextUtils.isEmpty(this.talkTime)) {
            return "";
        }
        String str2 = this.talkTime;
        int i17 = 0;
        if (this.uinType == 3000) {
            long parseLong = Long.parseLong(str2);
            if (parseLong > 0) {
                long j3 = parseLong % 60;
                long j16 = parseLong / 60;
                long j17 = j16 / 60;
                long j18 = j16 % 60;
                if (j17 > 0) {
                    str2 = String.format(Locale.CHINA, "%02d:%02d:%02d", Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j3));
                } else {
                    str2 = String.format(Locale.CHINA, "%02d:%02d", Long.valueOf(j18), Long.valueOf(j3));
                }
            } else {
                str2 = QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT;
            }
        }
        if (str2 == null || str2.equals("") || str2.split(":").length < 2) {
            return "";
        }
        String[] split = str2.split(":");
        if (split.length == 2) {
            i16 = Integer.parseInt(split[0]);
            i3 = Integer.parseInt(split[1]);
        } else if (split.length == 3) {
            i17 = Integer.parseInt(split[0]);
            i16 = Integer.parseInt(split[1]);
            i3 = Integer.parseInt(split[2]);
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (i17 != 0) {
            str = "" + i17 + HardCodeUtil.qqStr(R.string.q8_);
        }
        if (i16 != 0) {
            str = str + i16 + HardCodeUtil.qqStr(R.string.q8h);
        }
        return str + i3 + HardCodeUtil.qqStr(R.string.q88);
    }

    public String getTime() {
        return DateFormat.getTimeFormat(BaseApplication.getContext()).format(new Date(this.time * 1000));
    }

    public boolean isMissCall() {
        if (this.uinType != 3000) {
            if (this.issend == 0) {
                int i3 = this.state;
                if (12 == i3 || 10 == i3 || 6 == i3) {
                    return true;
                }
                return false;
            }
            return false;
        }
        if (this.issend == 0 && this.state == 2) {
            return true;
        }
        return false;
    }

    public boolean isSender() {
        if (this.issend == 1) {
            return true;
        }
        return false;
    }

    public boolean isVideo() {
        if (this.isVideo == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "QCallRecord [state=" + this.state + ", time=" + this.time + ", talkTime=" + this.talkTime + ", type=" + this.type + ", friendUin=" + this.friendUin + ", uinType=" + this.uinType + ", uniseq=" + this.uniseq + ", issend=" + this.issend + ", msgData=" + Arrays.toString(this.msgData) + ", senderuin=" + this.senderuin + ", isVideo=" + this.isVideo + "]";
    }

    public QCallRecord(int i3) {
        int i16 = TYPE_REALRECORD;
        this.issend = 1;
        this.versionCode = 1;
        this.contactId = -1;
        this.type = i3;
        if (i3 == i16) {
            createMessageUniseq();
        }
    }

    public static String getTableName(String str, int i3) {
        return "qc_" + i3 + "_" + an.a(str);
    }
}
