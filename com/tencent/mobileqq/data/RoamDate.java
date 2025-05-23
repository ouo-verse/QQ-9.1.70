package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.FAIL, columnNames = "uin, date")
/* loaded from: classes10.dex */
public class RoamDate extends Entity {
    public static final int LOCAL_INDEX_00 = 0;
    public static final int LOCAL_INDEX_01 = 1;
    public static final int LOCAL_INDEX_10 = 2;
    public static final int LOCAL_INDEX_11 = 3;
    public static final int SERVER_INDEX_00 = 0;
    public static final int SERVER_INDEX_01 = 1;
    public static final int SERVER_INDEX_10 = 2;
    public static final int SERVER_INDEX_11 = 3;
    private static final String TABLE_NAME = "MessageRoamDate";
    public String date;

    @notColumn
    public long[] lastMsgTime;
    public byte[] lastMsgTimeData;
    public long locindex;

    @notColumn
    public long[] random;
    public byte[] randomData;
    public long serindex;
    public String uin;

    public RoamDate() {
        long[] jArr;
        long[] jArr2;
        this.lastMsgTime = new long[31];
        int i3 = 0;
        while (true) {
            jArr = this.lastMsgTime;
            if (i3 >= jArr.length) {
                break;
            }
            jArr[i3] = 0;
            i3++;
        }
        this.lastMsgTimeData = new byte[jArr.length * 8];
        int i16 = 0;
        while (true) {
            byte[] bArr = this.lastMsgTimeData;
            if (i16 >= bArr.length) {
                break;
            }
            bArr[i16] = 0;
            i16++;
        }
        this.random = new long[31];
        int i17 = 0;
        while (true) {
            jArr2 = this.random;
            if (i17 >= jArr2.length) {
                break;
            }
            jArr2[i17] = 0;
            i17++;
        }
        this.randomData = new byte[jArr2.length * 8];
        int i18 = 0;
        while (true) {
            byte[] bArr2 = this.randomData;
            if (i18 >= bArr2.length) {
                return;
            }
            bArr2[i18] = 0;
            i18++;
        }
    }

    private long bytes2Long(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 56) + ((bArr[i3 + 1] & 255) << 48) + ((bArr[i3 + 2] & 255) << 40) + ((bArr[i3 + 3] & 255) << 32) + ((bArr[i3 + 4] & 255) << 24) + ((bArr[i3 + 5] & 255) << 16) + ((bArr[i3 + 6] & 255) << 8) + ((bArr[i3 + 7] & 255) << 0);
    }

    private int getOneBit(int i3, int i16) {
        if ((i3 & (1 << (31 - i16))) != 0) {
            return 1;
        }
        return 0;
    }

    private int getTwoBits(long j3, int i3) {
        return (int) ((j3 >> (62 - (i3 * 2))) & 3);
    }

    private void long2Bytes(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 56);
        bArr[i3 + 1] = (byte) (j3 >> 48);
        bArr[i3 + 2] = (byte) (j3 >> 40);
        bArr[i3 + 3] = (byte) (j3 >> 32);
        bArr[i3 + 4] = (byte) (j3 >> 24);
        bArr[i3 + 5] = (byte) (j3 >> 16);
        bArr[i3 + 6] = (byte) (j3 >> 8);
        bArr[i3 + 7] = (byte) (j3 >> 0);
    }

    private void makeSerIndex(int i3, int i16) {
        int days = getDays();
        for (int i17 = 0; i17 < i16 && i17 < days; i17++) {
            if (getOneBit(i3, i17) == 0) {
                setSerTwoBits(1, i17);
            } else {
                setSerTwoBits(2, i17);
            }
        }
        while (i16 < days) {
            setSerTwoBits(0, i16);
            i16++;
        }
    }

    private void setLocTwoBits(int i3, int i16) {
        long j3 = i3;
        int i17 = 62 - (i16 * 2);
        this.locindex = ((~(3 << i17)) & this.locindex) | (j3 << i17);
    }

    private void setSerTwoBits(int i3, int i16) {
        long j3 = i3;
        int i17 = 62 - (i16 * 2);
        this.serindex = ((~(3 << i17)) & this.serindex) | (j3 << i17);
    }

    public void clearLocState() {
        this.locindex = 0L;
    }

    public void clearSerState() {
        this.serindex = 0L;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoamDate roamDate = (RoamDate) obj;
        String str = this.uin;
        if (str == null) {
            if (roamDate.uin != null) {
                return false;
            }
        } else if (!str.equals(roamDate.uin)) {
            return false;
        }
        String str2 = this.date;
        if (str2 == null) {
            if (roamDate.date != null) {
                return false;
            }
        } else if (!str2.equals(roamDate.date)) {
            return false;
        }
        return true;
    }

    public int getDays() {
        String[] split = this.date.split("-");
        return getDays(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue());
    }

    public long getLastMsgTime(int i3) {
        if (i3 >= 0 && i3 < getDays()) {
            return this.lastMsgTime[i3];
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("day must [0 - ");
        sb5.append(getDays() - 1);
        sb5.append("]");
        throw new IllegalArgumentException(sb5.toString());
    }

    public int getLocState(int i3) {
        if (i3 >= 0 && i3 < getDays()) {
            return getTwoBits(this.locindex, i3);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("day must [0 - ");
        sb5.append(getDays() - 1);
        sb5.append("]");
        throw new IllegalArgumentException(sb5.toString());
    }

    public int getMonth() {
        return Integer.valueOf(this.date.split("-")[1]).intValue();
    }

    public long getRandom(int i3) {
        if (i3 >= 0 && i3 < getDays()) {
            return this.random[i3];
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("day must [0 - ");
        sb5.append(getDays() - 1);
        sb5.append("]");
        throw new IllegalArgumentException(sb5.toString());
    }

    public int getSerState(int i3) {
        if (i3 >= 0 && i3 < getDays()) {
            return getTwoBits(this.serindex, i3);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("day must [0 - ");
        sb5.append(getDays() - 1);
        sb5.append("]");
        throw new IllegalArgumentException(sb5.toString());
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return TABLE_NAME;
    }

    public int getYear() {
        return Integer.valueOf(this.date.split("-")[0]).intValue();
    }

    public int hashCode() {
        int hashCode;
        String str = this.uin;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode + 31) * 31;
        String str2 = this.date;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            long[] jArr = this.lastMsgTime;
            if (i16 >= jArr.length) {
                break;
            }
            jArr[i16] = bytes2Long(this.lastMsgTimeData, i17);
            i16++;
            i17 += 8;
        }
        int i18 = 0;
        while (true) {
            long[] jArr2 = this.random;
            if (i3 < jArr2.length) {
                jArr2[i3] = bytes2Long(this.randomData, i18);
                i3++;
                i18 += 8;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            long[] jArr = this.lastMsgTime;
            if (i16 >= jArr.length) {
                break;
            }
            long2Bytes(this.lastMsgTimeData, i17, jArr[i16]);
            i16++;
            i17 += 8;
        }
        int i18 = 0;
        while (true) {
            long[] jArr2 = this.random;
            if (i3 < jArr2.length) {
                long2Bytes(this.randomData, i18, jArr2[i3]);
                i3++;
                i18 += 8;
            } else {
                return;
            }
        }
    }

    public void setLastMsgTime(int i3, long j3) {
        if (i3 >= 0 && i3 < getDays()) {
            this.lastMsgTime[i3] = j3;
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("day must [0 - ");
        sb5.append(getDays() - 1);
        sb5.append("]");
        throw new IllegalArgumentException(sb5.toString());
    }

    public void setLocState(int i3, int i16) {
        if (i3 >= 0 && i3 < getDays() && i16 >= 0 && i16 <= 3) {
            setLocTwoBits(i16, i3);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("day must [0 - ");
        sb5.append(getDays() - 1);
        sb5.append("], state must [0 - 3]");
        throw new IllegalArgumentException(sb5.toString());
    }

    public void setRandom(int i3, long j3) {
        if (i3 >= 0 && i3 < getDays()) {
            this.random[i3] = j3;
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("day must [0 - ");
        sb5.append(getDays() - 1);
        sb5.append("]");
        throw new IllegalArgumentException(sb5.toString());
    }

    public void setSerState(int i3, int i16) {
        if (i3 >= 0 && i3 < getDays() && i16 >= 0 && i16 <= 3) {
            setSerTwoBits(i16, i3);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("day must [0 - ");
        sb5.append(getDays() - 1);
        sb5.append("], state must [0 - 3]");
        throw new IllegalArgumentException(sb5.toString());
    }

    public void setSerindex(int i3, int i16) {
        makeSerIndex(i3, i16);
    }

    public String toString() {
        return "uin = " + this.uin + ", date = " + this.date + ", serindex = " + this.serindex + ", locindex = " + this.locindex + ", lastMsgTime = " + Arrays.toString(this.lastMsgTime) + ", random = " + Arrays.toString(this.random);
    }

    public static int getDays(int i3, int i16) {
        return i16 != 2 ? (i16 == 4 || i16 == 6 || i16 == 9 || i16 == 11) ? 30 : 31 : ((i3 % 4 != 0 || i3 % 100 == 0) && i3 % 400 != 0) ? 28 : 29;
    }

    public RoamDate(String str, String str2) {
        this();
        this.uin = str;
        this.date = str2;
    }

    public RoamDate(String str, String str2, int i3, int i16) {
        this();
        this.uin = str;
        this.date = str2;
        makeSerIndex(i3, i16);
    }
}
