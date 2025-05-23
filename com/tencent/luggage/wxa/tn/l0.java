package com.tencent.luggage.wxa.tn;

import android.content.Context;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f141643a = new l0();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f141644b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static long f141645c = 200;

    /* renamed from: d, reason: collision with root package name */
    public static long f141646d = 1000;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f141647e = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        NOTSET,
        ON,
        OFF
    }

    public static final void a(Context context, int i3, b speakeron, int i16, boolean z16, a aVar) {
        Intrinsics.checkNotNullParameter(speakeron, "speakeron");
        if (context == null) {
            w.b("MicroMsg.PlaySoundNew", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", context, Integer.valueOf(i3), speakeron, Boolean.valueOf(z16), aVar);
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new c(context, i3, speakeron, i16, z16, aVar));
        }
    }

    public final synchronized void b(int i3) {
        if (f141647e) {
            w.d("MicroMsg.PlaySoundNew", "updateAssetPlayTime:" + i3);
            f141644b.put(Integer.valueOf(i3), Long.valueOf(w0.a()));
            a();
        }
    }

    public static final void a(Context context, int i3, b speakeron, boolean z16, a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(speakeron, "speakeron");
        a(context, i3, speakeron, -1, z16, aVar);
    }

    public final synchronized boolean a(int i3) {
        if (!f141647e) {
            return false;
        }
        HashMap hashMap = f141644b;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            Long l3 = (Long) hashMap.get(Integer.valueOf(i3));
            if (l3 == null) {
                l3 = -1L;
            }
            long longValue = l3.longValue();
            if (longValue > 0) {
                return w0.e(longValue) <= f141645c;
            }
        }
        return false;
    }

    public final void a() {
        long a16 = w0.a();
        HashMap hashMap = f141644b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (a16 - ((Number) entry.getValue()).longValue() >= f141646d) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        if (!keySet.isEmpty()) {
            Iterator it5 = keySet.iterator();
            while (it5.hasNext()) {
                int intValue = ((Number) it5.next()).intValue();
                w.d("MicroMsg.PlaySoundNew", "evictOutDateRateControlInfo:" + intValue);
                f141644b.remove(Integer.valueOf(intValue));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f141652a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f141653b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f141654c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f141655d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f141656e;

        public c(Context context, int i3, b bVar, int i16, boolean z16, a aVar) {
            this.f141652a = context;
            this.f141653b = i3;
            this.f141654c = bVar;
            this.f141655d = i16;
            this.f141656e = z16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i3;
            try {
                try {
                    String string = this.f141652a.getString(this.f141653b);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(pathId)");
                    l0 l0Var = l0.f141643a;
                    if (l0Var.a(this.f141653b)) {
                        w.b("MicroMsg.PlaySoundNew", "play asset path:" + string + " hit rateControl, ignore this play request");
                        l0Var.b(this.f141653b);
                        return;
                    }
                    w.d("MicroMsg.PlaySoundNew", "play asset path:" + string + ", pathId:" + this.f141653b + ", speakeron:" + this.f141654c + ", stream:" + this.f141655d + ", looping:" + this.f141656e);
                    ITPPlayer createTPPlayer = TPPlayerFactory.createTPPlayer(this.f141652a);
                    if (createTPPlayer == null) {
                        l0Var.b(this.f141653b);
                        return;
                    }
                    createTPPlayer.setDataSource(this.f141652a.getAssets().openFd(string));
                    if (this.f141654c != b.NOTSET && -1 == this.f141655d) {
                        TPOptionalParam tPOptionalParam = new TPOptionalParam();
                        if (this.f141654c == b.ON) {
                            i3 = 3;
                        } else {
                            i3 = 8;
                        }
                        createTPPlayer.setPlayerOptionalParam(tPOptionalParam.buildLong(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, i3));
                    } else if (this.f141655d != -1) {
                        createTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, this.f141655d));
                    }
                    createTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildInt(419, 1));
                    createTPPlayer.setLoopback(this.f141656e);
                    a aVar = new a(null);
                    createTPPlayer.setOnPreparedListener(aVar);
                    createTPPlayer.setOnInfoListener(aVar);
                    createTPPlayer.setOnPlayerStateChangeListener(aVar);
                    createTPPlayer.setOnCompletionListener(aVar);
                    createTPPlayer.setOnErrorListener(aVar);
                    createTPPlayer.prepareAsync();
                    l0Var.b(this.f141653b);
                } catch (Exception e16) {
                    w.a("MicroMsg.PlaySoundNew", e16, "", new Object[0]);
                    l0.f141643a.b(this.f141653b);
                }
            } catch (Throwable th5) {
                l0.f141643a.b(this.f141653b);
                throw th5;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener {

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ITPPlayer f141658a;

                public b(ITPPlayer iTPPlayer) {
                    this.f141658a = iTPPlayer;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ITPPlayer iTPPlayer = this.f141658a;
                        if (iTPPlayer != null) {
                            iTPPlayer.stopAsync();
                        }
                        ITPPlayer iTPPlayer2 = this.f141658a;
                        if (iTPPlayer2 != null) {
                            iTPPlayer2.release();
                        }
                    } catch (Exception e16) {
                        w.a("MicroMsg.PlaySoundNew", e16, "onError release player error", new Object[0]);
                    }
                }
            }

            public a(a aVar) {
            }

            public void onCompletion(ITPPlayer iTPPlayer) {
                w.d("MicroMsg.PlaySoundNew", "onCompletion");
                com.tencent.luggage.wxa.zp.h.f146825d.execute(new RunnableC6770a(iTPPlayer, null));
            }

            public void onError(ITPPlayer iTPPlayer, int i3, int i16, long j3, long j16) {
                w.d("MicroMsg.PlaySoundNew", "onError errType:" + i3 + " errorCode:" + i16 + ", arg:" + j3 + TokenParser.SP + j16);
                com.tencent.luggage.wxa.zp.h.f146825d.execute(new b(iTPPlayer));
            }

            public void onInfo(ITPPlayer iTPPlayer, int i3, long j3, long j16, Object obj) {
                w.d("MicroMsg.PlaySoundNew", "onInfo, what:" + i3 + TokenParser.SP + j3 + TokenParser.SP + j16 + TokenParser.SP + obj);
            }

            public void onPrepared(ITPPlayer iTPPlayer) {
                w.d("MicroMsg.PlaySoundNew", "onPrepared");
                if (iTPPlayer != null) {
                    iTPPlayer.start();
                }
            }

            public void onStateChange(int i3, int i16) {
                w.d("MicroMsg.PlaySoundNew", "onStateChange " + i3 + TokenParser.SP + i16);
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.tn.l0$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class RunnableC6770a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ITPPlayer f141657a;

                public RunnableC6770a(ITPPlayer iTPPlayer, a aVar) {
                    this.f141657a = iTPPlayer;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ITPPlayer iTPPlayer = this.f141657a;
                        if (iTPPlayer != null) {
                            iTPPlayer.stopAsync();
                        }
                        ITPPlayer iTPPlayer2 = this.f141657a;
                        if (iTPPlayer2 != null) {
                            iTPPlayer2.release();
                        }
                    } catch (Exception e16) {
                        w.a("MicroMsg.PlaySoundNew", e16, "onCompletion release player error", new Object[0]);
                    } finally {
                        com.tencent.luggage.wxa.rn.a.a(new C6771a(null));
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.tn.l0$c$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6771a extends Lambda implements Function0 {
                    public C6771a(a aVar) {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return Unit.INSTANCE;
                    }

                    public final void a() {
                    }
                }
            }
        }
    }
}
