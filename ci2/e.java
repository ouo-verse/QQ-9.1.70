package ci2;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.GProTopMsgInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelTopMsgStateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelTopMsgCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import vh2.bh;
import vh2.cc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f30967a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.qqguildsdk.manager.b f30968b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, a> f30969c = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final boolean f30970a;

        /* renamed from: b, reason: collision with root package name */
        final long f30971b;

        public a(boolean z16, long j3) {
            this.f30970a = z16;
            this.f30971b = j3;
        }
    }

    public e(GPSManagerEngine gPSManagerEngine, com.tencent.mobileqq.qqguildsdk.manager.b bVar) {
        this.f30967a = gPSManagerEngine;
        this.f30968b = bVar;
    }

    private String g(String str, String str2) {
        return str + ":" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(String str, String str2, cc ccVar, int i3, String str3) {
        IGProChannelInfo f16;
        if (i3 == 0 && (f16 = this.f30968b.f(str)) != null && f16.getTopMsgList().size() == 0) {
            this.f30969c.remove(g(str2, str));
        }
        ccVar.onResult(i3, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str, String str2, cc ccVar, int i3, String str3) {
        if (i3 == 0) {
            this.f30969c.put(g(str, str2), new a(true, SystemClock.elapsedRealtime() + 5000));
        }
        ccVar.onResult(i3, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(bh bhVar, String str, int i3, String str2, boolean z16, long j3) {
        if (i3 != 0) {
            bhVar.onResult(i3, str2, z16);
            return;
        }
        if (this.f30969c.get(str) != null) {
            this.f30969c.put(str, new a(z16, SystemClock.elapsedRealtime() + Math.max(5000L, j3 * 1000)));
        } else {
            this.f30969c.put(str, new a(z16, SystemClock.elapsedRealtime() + Math.max(5000L, j3 * 1000)));
        }
        bhVar.onResult(0, "", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(String str, String str2, cc ccVar, int i3, String str3, long j3, long j16) {
        if (i3 == 0) {
            this.f30969c.put(g(str, str2), new a(false, SystemClock.elapsedRealtime() + 5000));
        }
        ccVar.onResult(i3, str3);
    }

    public void e(IGProChannelInfo iGProChannelInfo, ArrayList<Long> arrayList, @NonNull final cc ccVar) {
        final String guildId = iGProChannelInfo.getGuildId();
        final String channelUin = iGProChannelInfo.getChannelUin();
        ArrayList<IGProTopMsg> arrayList2 = new ArrayList<>();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GProTopMsgInfo(new GProTopMsg(it.next().longValue(), 0L, 0L, 0)));
        }
        this.f30967a.pd(guildId, channelUin, arrayList2, new cc() { // from class: ci2.c
            @Override // vh2.cc
            public final void onResult(int i3, String str) {
                e.this.i(channelUin, guildId, ccVar, i3, str);
            }
        });
    }

    public void f(IGProChannelInfo iGProChannelInfo, @NonNull final cc ccVar) {
        final String guildId = iGProChannelInfo.getGuildId();
        final String channelUin = iGProChannelInfo.getChannelUin();
        this.f30967a.sd(guildId, channelUin, new cc() { // from class: ci2.a
            @Override // vh2.cc
            public final void onResult(int i3, String str) {
                e.this.j(guildId, channelUin, ccVar, i3, str);
            }
        });
    }

    public void h(IGProChannelInfo iGProChannelInfo, @NonNull final bh bhVar) {
        String guildId = iGProChannelInfo.getGuildId();
        String channelUin = iGProChannelInfo.getChannelUin();
        final String g16 = g(guildId, channelUin);
        a aVar = this.f30969c.get(g16);
        if (aVar != null) {
            if (aVar.f30971b > SystemClock.elapsedRealtime()) {
                bhVar.onResult(0, "", aVar.f30970a);
                return;
            }
        }
        this.f30967a.Ye(guildId, channelUin, new IGProGetChannelTopMsgStateCallback() { // from class: ci2.d
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelTopMsgStateCallback
            public final void onGetChannelTopMsgState(int i3, String str, boolean z16, long j3) {
                e.this.k(bhVar, g16, i3, str, z16, j3);
            }
        });
    }

    public void m(String str, String str2) {
        if (this.f30968b.f(str2) == null) {
            return;
        }
        this.f30969c.remove(g(str, str2));
    }

    public void n(IGProChannelInfo iGProChannelInfo, long j3, int i3, int i16, @NonNull final cc ccVar) {
        final String guildId = iGProChannelInfo.getGuildId();
        final String channelUin = iGProChannelInfo.getChannelUin();
        this.f30967a.Oj(guildId, channelUin, j3, i3, new IGProSetChannelTopMsgCallback() { // from class: ci2.b
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelTopMsgCallback
            public final void onSetChannelTopMsg(int i17, String str, long j16, long j17) {
                e.this.l(guildId, channelUin, ccVar, i17, str, j16, j17);
            }
        });
    }
}
