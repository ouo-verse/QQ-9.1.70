package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Ticket implements Parcelable {
    public static final Parcelable.Creator<Ticket> CREATOR = new Parcelable.Creator<Ticket>() { // from class: oicq.wlogin_sdk.request.Ticket.2
        @Override // android.os.Parcelable.Creator
        public Ticket createFromParcel(Parcel parcel) {
            return new Ticket(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Ticket[] newArray(int i3) {
            return new Ticket[i3];
        }
    };
    private static final int EXPIRE_FIELD = 65535;
    private static final int MAX_PSKEY_SIZE = 200;
    public long _create_time;
    public long _expire_time;
    public Map<String, Long> _pskey_expire;
    public Map<String, byte[]> _pskey_map;
    public Map<String, Long> _pt4token_expire;
    public Map<String, byte[]> _pt4token_map;
    public byte[] _sig;
    public byte[] _sig_key;
    public int _type;

    public Ticket() {
        this._pskey_map = new HashMap();
        this._pskey_expire = new HashMap();
        this._pt4token_map = new HashMap();
        this._pt4token_expire = new HashMap();
    }

    private String __getPskey(String str, Map<String, byte[]> map, Map<String, Long> map2) {
        Long l3;
        util.LOGI("__getPskey get domain " + str + " pskey or pt4token", "");
        if (map == null) {
            return null;
        }
        byte[] bArr = map.get(str);
        if (bArr == null) {
            util.LOGI("__getPskey get domain " + str + " pskey or pt4token null", "");
            return null;
        }
        if (map2 != null && (l3 = map2.get(str)) != null && l3.longValue() <= u.e()) {
            util.LOGI("__getPskey delete domain " + str + " expired pskey or pt4token expire time " + l3, "");
            map2.remove(str);
            map.remove(str);
            return null;
        }
        String str2 = new String(bArr);
        util.LOGI("__getPskey get domain " + str + " pskey or pt4token len " + str2.length() + " " + str2.substring(0, 5) + "***" + str2.substring(str2.length() - 5, str2.length()), "");
        return str2;
    }

    public static int calPsBufLength(Map<String, byte[]> map) {
        int i3 = 2;
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            i3 = i3 + 2 + entry.getKey().length() + 2 + entry.getValue().length + 2 + 8;
        }
        return i3;
    }

    private String getPskeyOrPt4tokenContent() {
        String str = "";
        for (String str2 : this._pskey_map.keySet()) {
            str = str + str2 + ":" + util.getMaskBytes(this._pskey_map.get(str2), 3, 3) + "|";
        }
        return str;
    }

    public static boolean isPskeyExpired(long j3) {
        return isTicketExpired(j3);
    }

    public static boolean isPskeyStorageExpired(long j3) {
        long e16 = u.e();
        util.LOGI("isPskeyStorageExpired expireTime:" + j3 + "|current: " + e16, "");
        if (e16 > j3 + 86400) {
            return true;
        }
        return false;
    }

    public static boolean isPt4TokenExpired(long j3) {
        return isTicketExpired(j3);
    }

    public static boolean isSkeyExpired(long j3) {
        return isTicketExpired(j3);
    }

    public static boolean isTicketExpired(long j3) {
        long e16 = u.e();
        if (e16 > j3) {
            return true;
        }
        if (j3 > 86400 + e16) {
            util.LOGI("time for system may be  modified manually expireTime " + j3 + " current " + e16, "");
            return true;
        }
        return false;
    }

    public static void limitMapSize(int i3, Map<String, byte[]> map, Map<String, Long> map2, int i16) {
        oicq.wlogin_sdk.report.c.a aVar;
        if (i3 > i16) {
            aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_ALARM, "pskey_net_to_much", "");
            aVar.f422861g.put("size", String.valueOf(i3));
            util.LOGI("limitMapSize net domainCnt=" + i3, "");
            map.clear();
        } else if (map.size() + i3 > i16) {
            oicq.wlogin_sdk.report.c.a aVar2 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_ALARM, "pskey_mix_to_much", i3 + "," + map.size());
            aVar2.f422861g.put("size", String.valueOf(map.size() + i3));
            StringBuilder sb5 = new StringBuilder("limitMapSize mix  domainCnt=");
            sb5.append(i3);
            sb5.append(",localKeyMap=");
            sb5.append(map.size());
            ArrayList arrayList = new ArrayList(map2.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, Long>>() { // from class: oicq.wlogin_sdk.request.Ticket.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
                    return Long.compare(entry.getValue().longValue(), entry2.getValue().longValue());
                }
            });
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb5.append(",rm key=");
                sb5.append((String) entry.getKey());
                sb5.append(",expire=");
                sb5.append(entry.getValue());
                map.remove(entry.getKey());
                if (map.size() <= i16 - i3) {
                    break;
                }
            }
            util.LOGI(sb5.toString(), "");
            aVar = aVar2;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.f422858d = true;
            aVar.f422859e = true;
            oicq.wlogin_sdk.report.c.b.a(aVar);
        }
    }

    public static byte[] packPsBuf(Map<String, byte[]> map, long j3, Map<String, Long> map2) {
        long j16;
        int max = Math.max(calPsBufLength(map), 4096);
        util.LOGI("packPsBuf mapSize=" + map.size() + ",bufLen=" + max, "");
        ByteBuffer allocate = ByteBuffer.allocate(max);
        allocate.putShort((short) map.size());
        for (String str : map.keySet()) {
            allocate.putShort((short) str.length());
            allocate.put(str.getBytes());
            byte[] bArr = map.get(str);
            allocate.putShort((short) bArr.length);
            allocate.put(bArr);
            allocate.putShort((short) -1);
            Long l3 = map2.get(str);
            if (l3 != null) {
                j16 = l3.longValue();
            } else {
                j16 = 86400 + j3;
            }
            allocate.putLong(j16);
        }
        allocate.flip();
        byte[] bArr2 = new byte[allocate.limit()];
        allocate.get(bArr2);
        return bArr2;
    }

    public static void parsePsBuf(byte[] bArr, long j3, Map<String, byte[]> map, Map<String, Long> map2, boolean z16) {
        Object valueOf;
        int buf_to_int16;
        int buf_to_int162;
        int buf_to_int163;
        int buf_to_int164;
        long j16;
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ps_buf ");
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        util.LOGI(sb5.toString(), "");
        if (bArr != null) {
            int i3 = 2;
            if (bArr.length > 2) {
                long e16 = u.e();
                int buf_to_int165 = util.buf_to_int16(bArr, 0);
                util.LOGI("domainCnt " + buf_to_int165, "");
                int i16 = 0;
                while (i16 < buf_to_int165) {
                    int i17 = i3 + 2;
                    if (bArr.length >= i17 && bArr.length >= (buf_to_int162 = i17 + (buf_to_int16 = util.buf_to_int16(bArr, i3)))) {
                        String str2 = new String(bArr, i17, buf_to_int16);
                        int i18 = buf_to_int162 + 2;
                        if (bArr.length >= i18 && bArr.length >= (buf_to_int164 = i18 + (buf_to_int163 = util.buf_to_int16(bArr, buf_to_int162)))) {
                            byte[] bArr2 = new byte[buf_to_int163];
                            System.arraycopy(bArr, i18, bArr2, 0, buf_to_int163);
                            int i19 = buf_to_int164 + 2;
                            if (bArr.length > i19 && util.buf_to_int16(bArr, buf_to_int164) == 65535) {
                                j16 = util.buf_to_int64(bArr, i19);
                                buf_to_int164 = i19 + 8;
                            } else {
                                j16 = j3 + 86400;
                            }
                            if (j16 > e16) {
                                map.put(str2, bArr2);
                                map2.put(str2, Long.valueOf(j16));
                            }
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str2);
                            if (z16) {
                                str = " pskey:";
                            } else {
                                str = " pt4Token:";
                            }
                            sb6.append(str);
                            sb6.append(buf_to_int163);
                            sb6.append(",expire: ");
                            sb6.append(j16);
                            util.LOGI(sb6.toString(), "");
                            i16++;
                            i3 = buf_to_int164;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static void parseSvrPs(byte[] bArr, long j3, Map<String, byte[]> map, Map<String, Long> map2, Map<String, byte[]> map3, Map<String, Long> map4) {
        ByteBuffer byteBuffer;
        long j16 = j3;
        util.LOGI("pskeyMap " + map.size() + ", tokenMap " + map3.size() + " create time:" + j16, "");
        if (bArr != null && bArr.length > 2) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            short s16 = wrap.getShort();
            try {
                limitMapSize(s16, map, map2, 200);
                limitMapSize(s16, map3, map4, 200);
            } catch (Exception e16) {
                util.printException(e16, "");
            }
            int i3 = 0;
            while (i3 < s16) {
                byte[] bArr2 = new byte[wrap.getShort()];
                wrap.get(bArr2);
                String str = new String(bArr2);
                int i16 = wrap.getShort();
                byte[] bArr3 = new byte[i16];
                wrap.get(bArr3);
                int i17 = wrap.getShort();
                byte[] bArr4 = new byte[i17];
                wrap.get(bArr4);
                short s17 = s16;
                int i18 = i3;
                long j17 = j16 + 86400;
                if (i16 > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("parseSvrPs add domain ");
                    sb5.append(str);
                    byteBuffer = wrap;
                    sb5.append(" pskey len ");
                    sb5.append(i16);
                    sb5.append(" ");
                    sb5.append(j17);
                    util.LOGI(sb5.toString(), "");
                    map.put(str, bArr3);
                    map2.put(str, Long.valueOf(j17));
                } else {
                    byteBuffer = wrap;
                }
                if (i17 > 0) {
                    String str2 = new String(bArr4);
                    util.LOGI("parseSvrPs add domain " + str + " pt4token len " + i17 + " " + j17 + " " + str2.substring(0, 5) + "***" + str2.substring(str2.length() - 5), "");
                    map3.put(str, bArr4);
                    map4.put(str, Long.valueOf(j17));
                }
                util.LOGI(str + " pskey:" + i16 + " pt4token " + i17 + " expire: " + j17, "");
                i3 = i18 + 1;
                s16 = s17;
                j16 = j3;
                wrap = byteBuffer;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        if (4096 == this._type) {
            return "skey:" + util.getMaskBytes(this._sig, 2, 2);
        }
        return "";
    }

    public String getPSkey(String str) {
        return __getPskey(str, this._pskey_map, this._pskey_expire);
    }

    public String getPt4Token(String str) {
        util.LOGI("getPt4Token get domain " + str + " pt4token", "");
        return __getPskey(str, this._pt4token_map, this._pt4token_expire);
    }

    public void readFromParcel(Parcel parcel) {
        this._type = parcel.readInt();
        this._sig = parcel.createByteArray();
        this._sig_key = parcel.createByteArray();
        this._create_time = parcel.readLong();
        this._expire_time = parcel.readLong();
        this._pskey_map = parcel.readHashMap(Map.class.getClassLoader());
        this._pt4token_map = parcel.readHashMap(Map.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this._type);
        parcel.writeByteArray(this._sig);
        parcel.writeByteArray(this._sig_key);
        parcel.writeLong(this._create_time);
        parcel.writeLong(this._expire_time);
        parcel.writeMap(this._pskey_map);
        parcel.writeMap(this._pt4token_map);
    }

    public Ticket(int i3, byte[] bArr, byte[] bArr2, long j3, long j16) {
        this._pskey_map = new HashMap();
        this._pskey_expire = new HashMap();
        this._pt4token_map = new HashMap();
        this._pt4token_expire = new HashMap();
        this._type = i3;
        this._sig = bArr == null ? new byte[0] : (byte[]) bArr.clone();
        this._sig_key = bArr2 == null ? new byte[0] : (byte[]) bArr2.clone();
        this._create_time = j3;
        this._expire_time = j16;
    }

    public Ticket(int i3, byte[] bArr, byte[] bArr2, long j3, byte[] bArr3) {
        this._pskey_map = new HashMap();
        this._pskey_expire = new HashMap();
        this._pt4token_map = new HashMap();
        this._pt4token_expire = new HashMap();
        this._type = i3;
        this._sig = bArr == null ? new byte[0] : (byte[]) bArr.clone();
        this._sig_key = bArr2 == null ? new byte[0] : (byte[]) bArr2.clone();
        this._create_time = j3;
        this._expire_time = 86400 + j3;
        parsePsBuf(bArr3, j3, this._pskey_map, this._pskey_expire, true);
    }

    public Ticket(int i3, byte[] bArr, byte[] bArr2, long j3, byte[] bArr3, byte[] bArr4) {
        this._pskey_map = new HashMap();
        this._pskey_expire = new HashMap();
        this._pt4token_map = new HashMap();
        this._pt4token_expire = new HashMap();
        this._type = i3;
        this._sig = bArr == null ? new byte[0] : (byte[]) bArr.clone();
        this._sig_key = bArr2 == null ? new byte[0] : (byte[]) bArr2.clone();
        this._create_time = j3;
        this._expire_time = 86400 + j3;
        parsePsBuf(bArr3, j3, this._pskey_map, this._pskey_expire, true);
        parsePsBuf(bArr4, this._create_time, this._pt4token_map, this._pt4token_expire, false);
    }

    Ticket(Parcel parcel) {
        this._pskey_map = new HashMap();
        this._pskey_expire = new HashMap();
        this._pt4token_map = new HashMap();
        this._pt4token_expire = new HashMap();
        readFromParcel(parcel);
    }
}
