package com.tencent.luggage.wxa.wf;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.util.Base64;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.c0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f144231a = new c();

    public final Map a(List messages) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(messages, "messages");
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "messages2Map, messages: " + messages);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(messages, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = messages.iterator();
        while (it.hasNext()) {
            arrayList.add(f144231a.a((NdefMessage) it.next()));
        }
        Pair[] pairArr = new Pair[1];
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add((List) ((Pair) it5.next()).getFirst());
        }
        pairArr[0] = TuplesKt.to("messages", arrayList2);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int i17 = 0;
            for (Object obj2 : (Iterable) ((Pair) obj).getSecond()) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                mutableMapOf.put("payload-" + i3 + '-' + i17, (ByteBuffer) obj2);
                i17 = i18;
            }
            i3 = i16;
        }
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "messages2Map, map: " + mutableMapOf);
        return mutableMapOf;
    }

    public final NdefMessage b(List textAndLanguages) {
        int collectionSizeOrDefault;
        String str;
        Intrinsics.checkNotNullParameter(textAndLanguages, "textAndLanguages");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(textAndLanguages, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = textAndLanguages.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String str2 = (String) map.get("text");
            if (str2 == null || (str = (String) map.get(IjkMediaMeta.IJKM_KEY_LANGUAGE)) == null) {
                return null;
            }
            try {
                arrayList.add(NdefRecord.createTextRecord(str, str2));
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.NdefMessageConverter", "createTextRecord failed since " + e16);
                return null;
            }
        }
        Object[] array = arrayList.toArray(new NdefRecord[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        try {
            return new NdefMessage((NdefRecord[]) array);
        } catch (Exception e17) {
            w.f("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since " + e17);
            return null;
        }
    }

    public final NdefMessage c(List uris) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(uris, "uris");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(uris, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = uris.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(NdefRecord.createUri((String) it.next()));
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.NdefMessageConverter", "createUri failed since " + e16);
                return null;
            }
        }
        Object[] array = arrayList.toArray(new NdefRecord[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        try {
            return new NdefMessage((NdefRecord[]) array);
        } catch (Exception e17) {
            w.f("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since " + e17);
            return null;
        }
    }

    public final NdefMessage a(Map messageMap) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(messageMap, "messageMap");
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, messageMap: " + messageMap);
        Object obj = messageMap.get("records");
        List list = obj instanceof List ? (List) obj : null;
        if (list == null) {
            return null;
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj2 : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Map map = (Map) obj2;
            w.a("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, index: " + i3 + ", map: " + map);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("payload-");
            sb5.append(i3);
            Object obj3 = messageMap.get(sb5.toString());
            ByteBuffer byteBuffer = obj3 instanceof ByteBuffer ? (ByteBuffer) obj3 : null;
            if (byteBuffer == null) {
                return null;
            }
            w.a("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, byteBuffer: " + byteBuffer);
            arrayList.add(f144231a.a(TuplesKt.to(map, byteBuffer)));
            i3 = i16;
        }
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, records: " + arrayList);
        try {
            Object[] array = arrayList.toArray(new NdefRecord[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new NdefMessage((NdefRecord[]) array);
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since " + e16);
            return null;
        }
    }

    public final Pair a(NdefMessage ndefMessage) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "message2MessageMap, message: " + ndefMessage);
        NdefRecord[] records = ndefMessage.getRecords();
        Intrinsics.checkNotNullExpressionValue(records, "message.records");
        ArrayList arrayList = new ArrayList(records.length);
        for (NdefRecord it : records) {
            c cVar = f144231a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(cVar.a(it));
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add((Map) ((Pair) it5.next()).getFirst());
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            arrayList3.add((ByteBuffer) ((Pair) it6.next()).getSecond());
        }
        Pair pair = TuplesKt.to(arrayList2, arrayList3);
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "message2MessageMap, messageMap: " + pair);
        return pair;
    }

    public final Pair a(NdefRecord ndefRecord) {
        Map mapOf;
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "record2RecordMap, record: " + ndefRecord);
        byte[] encode = Base64.encode(ndefRecord.getType(), 2);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(record.type, Base64.NO_WRAP)");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] encode2 = Base64.encode(ndefRecord.getId(), 2);
        Intrinsics.checkNotNullExpressionValue(encode2, "encode(record.id, Base64.NO_WRAP)");
        Charset UTF_82 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("tnf", Short.valueOf(ndefRecord.getTnf())), TuplesKt.to("type", new String(encode, UTF_8)), TuplesKt.to("id", new String(encode2, UTF_82)));
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "record2RecordMap, map: " + mapOf);
        return TuplesKt.to(mapOf, c0.a(ndefRecord.getPayload()));
    }

    public final NdefRecord a(Pair pair) {
        w.a("MicroMsg.AppBrand.NdefMessageConverter", "recordMap2Record, recordMap: " + pair);
        Map map = (Map) pair.component1();
        ByteBuffer byteBuffer = (ByteBuffer) pair.component2();
        Object obj = map.get("tnf");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        Object obj2 = map.get("type");
        String str = obj2 instanceof String ? (String) obj2 : null;
        byte[] decode = str != null ? Base64.decode(str, 2) : null;
        Object obj3 = map.get("id");
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        try {
            return new NdefRecord((short) intValue, decode, str2 != null ? Base64.decode(str2, 2) : null, com.tencent.luggage.wxa.tk.c.a(byteBuffer));
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrand.NdefMessageConverter", "recordMap2Record failed since " + e16);
            return null;
        }
    }
}
