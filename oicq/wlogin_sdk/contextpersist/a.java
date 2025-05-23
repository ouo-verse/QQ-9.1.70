package oicq.wlogin_sdk.contextpersist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import oicq.wlogin_sdk.persistence.c;
import oicq.wlogin_sdk.persistence.d;
import oicq.wlogin_sdk.request.WloginAllSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    public static int a(int i3, byte[] bArr, int i16, int i17, Map<Integer, tlv_t> map) {
        if (bArr.length != i16 + i17) {
            return -1;
        }
        for (int i18 = 0; i18 < i3 && i17 > 0; i18++) {
            int buf_to_int16 = util.buf_to_int16(bArr, i16);
            int i19 = i16 + 2;
            int buf_to_int162 = util.buf_to_int16(bArr, i19);
            int i26 = i19 + 2;
            int i27 = (i17 - 2) - 2;
            if (i27 < buf_to_int162) {
                return -2;
            }
            tlv_t tlv_tVar = new tlv_t(buf_to_int16);
            tlv_tVar.set_data(bArr, i26, buf_to_int162);
            map.put(new Integer(buf_to_int16), tlv_tVar);
            i16 = i26 + buf_to_int162;
            i17 = i27 - buf_to_int162;
        }
        return 0;
    }

    public static void a(Context context, TreeMap treeMap, String str) {
        try {
            if ("tk_file".equals(str)) {
                String a16 = a(context);
                if (a16 != null) {
                    util.LOGI("A1EmptyChecker:" + a16);
                    return;
                }
                for (Object obj : treeMap.keySet()) {
                    WloginAllSigInfo wloginAllSigInfo = (WloginAllSigInfo) treeMap.get(obj);
                    Iterator<Long> it = wloginAllSigInfo._tk_map.keySet().iterator();
                    while (it.hasNext()) {
                        long longValue = it.next().longValue();
                        if (wloginAllSigInfo._tk_map.get(Long.valueOf(longValue))._en_A1.length == 0) {
                            d dVar = (d) ((c) oicq.wlogin_sdk.persistence.a.a(context, "wlogin_a1_empty")).edit();
                            dVar.putString("uin", (String) obj);
                            dVar.putLong("appid", longValue);
                            dVar.putLong("timestamp", System.currentTimeMillis());
                            dVar.f422793b.commit();
                            util.LOGI("A1EmptyChecker:uin=" + obj + ",appid=" + longValue);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            util.printException(e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [oicq.wlogin_sdk.contextpersist.PersistContext] */
    @Nullable
    public static <T extends PersistContext> T a(@NonNull Context context, @NonNull String str) {
        util.LOGI("PersistProcessor deserialize mmkvKey = " + str, "");
        Map<String, String> map = oicq.wlogin_sdk.persistence.a.f422781a;
        T t16 = null;
        byte[] decodeBytes = QMMKV.from(context, QMMKVFile.FILE_WTLOGIN).decodeBytes(str, null);
        if (decodeBytes == null || decodeBytes.length == 0) {
            util.LOGI("PersistProcessor deserialize fail", "");
            return null;
        }
        try {
            t16 = (PersistContext) new ObjectInputStream(new ByteArrayInputStream(decodeBytes)).readObject();
        } catch (Throwable th5) {
            util.printThrowable(th5, "");
        }
        if (t16 == null) {
            util.LOGI("PersistProcessor deserialize fail", "");
        }
        return t16;
    }

    public static String a(Context context) {
        c cVar = (c) oicq.wlogin_sdk.persistence.a.a(context, "wlogin_a1_empty");
        String string = cVar.f422789b.getString("uin", "");
        long j3 = cVar.f422789b.getLong("appid", 0L);
        long j16 = cVar.f422789b.getLong("timestamp", 0L);
        if (TextUtils.isEmpty(string) && j3 == 0) {
            return null;
        }
        return "uin=" + string + ",appid=" + j3 + ",time=" + j16;
    }

    public static <T extends PersistContext> void a(@NonNull Context context, @NonNull T t16, @NonNull String str) {
        try {
            util.LOGI("PersistProcessor serialize mmkvKey = " + str, "");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(t16);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Map<String, String> map = oicq.wlogin_sdk.persistence.a.f422781a;
            QMMKV.from(context, QMMKVFile.FILE_WTLOGIN).encodeBytes(str, byteArray);
        } catch (Throwable th5) {
            util.printThrowable(th5, "");
        }
    }
}
