package com.tencent.mm.msgsubscription.voice;

import android.media.AudioManager;
import com.tencent.luggage.wxa.lm.h;
import com.tencent.luggage.wxa.p9.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.z8.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes9.dex */
public final class MsgSubscriptionVoicePlayHelperMM {

    /* renamed from: a, reason: collision with root package name */
    public static final MsgSubscriptionVoicePlayHelperMM f151758a = new MsgSubscriptionVoicePlayHelperMM();

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f151759b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f151760c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f151761d = new byte[0];

    /* renamed from: e, reason: collision with root package name */
    public static int f151762e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static final AudioManager f151763f;

    /* renamed from: g, reason: collision with root package name */
    public static final IListener f151764g;

    static {
        Object systemService = z.c().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        f151763f = (AudioManager) systemService;
        final b bVar = b.f146383a;
        IListener<c> iListener = new IListener<c>(bVar) { // from class: com.tencent.mm.msgsubscription.voice.MsgSubscriptionVoicePlayHelperMM$mAudioPlayerEventListener$1
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(c event) {
                byte[] bArr;
                Map map;
                LinkedHashMap linkedHashMap;
                LinkedHashMap linkedHashMap2;
                LinkedHashMap linkedHashMap3;
                Object first;
                LinkedHashMap linkedHashMap4;
                Intrinsics.checkNotNullParameter(event, "event");
                int i3 = event.f137441d.f137442a;
                if (i3 == 2 || i3 == 4 || i3 == 5) {
                    bArr = MsgSubscriptionVoicePlayHelperMM.f151761d;
                    synchronized (bArr) {
                        map = MsgSubscriptionVoicePlayHelperMM.f151760c;
                        Long l3 = (Long) map.get(event.f137441d.f137444c);
                        com.tencent.luggage.wxa.qb.c.b(event.f137441d.f137444c);
                        if (l3 != null) {
                            linkedHashMap4 = MsgSubscriptionVoicePlayHelperMM.f151759b;
                            linkedHashMap4.remove(l3);
                        }
                        w.d("MicroMsg.MsgSubscriptionVoicePlayer", "[player event] action[" + event.f137441d.f137442a + "]  id[" + l3 + ']');
                        linkedHashMap = MsgSubscriptionVoicePlayHelperMM.f151759b;
                        if (linkedHashMap.entrySet().size() <= 0) {
                            MsgSubscriptionVoicePlayHelperMM.f151758a.e();
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("[player event] play next audio, waiting to play size[");
                            linkedHashMap2 = MsgSubscriptionVoicePlayHelperMM.f151759b;
                            sb5.append(linkedHashMap2.size());
                            sb5.append(']');
                            w.d("MicroMsg.MsgSubscriptionVoicePlayer", sb5.toString());
                            linkedHashMap3 = MsgSubscriptionVoicePlayHelperMM.f151759b;
                            Set entrySet = linkedHashMap3.entrySet();
                            Intrinsics.checkNotNullExpressionValue(entrySet, "urlsToPlay.entries");
                            first = CollectionsKt___CollectionsKt.first(entrySet);
                            Intrinsics.checkNotNullExpressionValue(first, "urlsToPlay.entries.first()");
                            Map.Entry entry = (Map.Entry) first;
                            MsgSubscriptionVoicePlayHelperMM msgSubscriptionVoicePlayHelperMM = MsgSubscriptionVoicePlayHelperMM.f151758a;
                            Object value = entry.getValue();
                            Intrinsics.checkNotNullExpressionValue(value, "first.value");
                            Object key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "first.key");
                            msgSubscriptionVoicePlayHelperMM.a((String) value, ((Number) key).longValue());
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    return false;
                }
                return false;
            }
        };
        f151764g = iListener;
        iListener.alive();
    }

    public final void d() {
        AudioManager audioManager = f151763f;
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
        if ((streamVolume * 1.0f) / streamMaxVolume < 0.4d) {
            if (f151762e == -1) {
                f151762e = streamVolume;
            }
            audioManager.setStreamVolume(3, (int) (streamMaxVolume * 0.4d), 5);
        }
    }

    public final void e() {
        int i3 = f151762e;
        if (i3 != -1) {
            f151763f.setStreamVolume(3, i3, 4);
            f151762e = -1;
        }
    }

    public final void b(String url, long j3) {
        Intrinsics.checkNotNullParameter(url, "url");
        synchronized (f151761d) {
            w.d("MicroMsg.MsgSubscriptionVoicePlayer", "[play] id[" + j3 + "]  url[" + url + ']');
            LinkedHashMap linkedHashMap = f151759b;
            if (linkedHashMap.isEmpty()) {
                linkedHashMap.put(Long.valueOf(j3), url);
                f151758a.a(url, j3);
            } else {
                linkedHashMap.put(Long.valueOf(j3), url);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046 A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0016, B:7:0x001c, B:10:0x0030, B:12:0x003a, B:17:0x0046, B:18:0x004c), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(long j3) {
        String str;
        boolean z16;
        synchronized (f151761d) {
            f151759b.remove(Long.valueOf(j3));
            Iterator it = f151760c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Number) entry.getValue()).longValue() == j3) {
                    str = (String) entry.getKey();
                    break;
                }
            }
            if (str != null && str.length() != 0) {
                z16 = false;
                if (!z16) {
                    com.tencent.luggage.wxa.qb.c.j(str);
                    com.tencent.luggage.wxa.qb.c.b(str);
                }
                Unit unit = Unit.INSTANCE;
            }
            z16 = true;
            if (!z16) {
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void a(String str, long j3) {
        w.d("MicroMsg.MsgSubscriptionVoicePlayer", "[innerPlay] id[" + j3 + "]  url[" + str + ']');
        com.tencent.luggage.wxa.qb.b bVar = new com.tencent.luggage.wxa.qb.b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(f151758a.hashCode());
        String it = com.tencent.luggage.wxa.qb.c.a(sb5.toString(), h.a());
        Long valueOf = Long.valueOf(j3);
        Map map = f151760c;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        map.put(it, valueOf);
        bVar.f138564a = it;
        bVar.f138565b = str;
        bVar.f138570g = true;
        d();
        com.tencent.luggage.wxa.qb.c.b(bVar);
    }
}
