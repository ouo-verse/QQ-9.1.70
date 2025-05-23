package com.tencent.luggage.wxa.p6;

import android.os.Handler;
import com.tencent.luggage.wxa.ai.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xg.j;
import com.tencent.luggage.wxa.zg.m;
import com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer;
import com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbPlayerInitLogic;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.eo.d implements i {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f137359a;

        public a(Handler handler) {
            this.f137359a = handler;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.xg.h invoke() {
            if (ThumbPlayerInitLogic.f152321a.a()) {
                w.d("MicroMsg.Video.WMPFMediaPlayerFactory", "invoke#drmPlayerCreator, create ThumbMediaPlayer");
                return new ThumbMediaPlayer(z.c());
            }
            w.d("MicroMsg.Video.WMPFMediaPlayerFactory", "invoke#generalPlayerCreator, create LuggageExoMediaPlayer");
            return new m(this.f137359a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Function0 {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.xg.h invoke() {
            if (ThumbPlayerInitLogic.f152321a.a()) {
                w.d("MicroMsg.Video.WMPFMediaPlayerFactory", "invoke#drmPlayerCreator, create ThumbMediaPlayer");
                return new ThumbMediaPlayer(z.c());
            }
            return new j();
        }
    }

    @Override // com.tencent.luggage.wxa.ai.i
    public com.tencent.luggage.wxa.xg.g a(com.tencent.luggage.wxa.z7.c cVar, Handler handler) {
        return new com.tencent.luggage.wxa.yk.a(new a(handler), new b());
    }
}
