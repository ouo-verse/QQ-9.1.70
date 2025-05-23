package ij1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareLiveRoomItemData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareMediaRoomItemData;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ag;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCapsule;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendCardPosAdvertise;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSysPromptDigest;
import fh1.FeedAudioLiveInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import vh2.af;
import wh2.ad;

/* compiled from: P */
/* loaded from: classes13.dex */
public class g extends b<GProStFeed> {
    private List<String> C;
    private FeedAudioLiveInfo D;
    private boolean E;
    private boolean F;

    /* renamed from: h, reason: collision with root package name */
    private GuildTaskProgressState f407811h;

    /* renamed from: i, reason: collision with root package name */
    private GProCapsule f407812i;

    /* renamed from: m, reason: collision with root package name */
    private String f407813m;

    public g(GProStFeed gProStFeed) {
        super(gProStFeed);
        this.E = false;
        this.F = false;
        if (gProStFeed != null) {
            v(new FeedAudioLiveInfo().a(gProStFeed.poster.channelUserInfo.voiceLiveInfo));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B(CountDownLatch countDownLatch, AtomicBoolean atomicBoolean) {
        GProRecommendCardPosAdvertise T;
        try {
            com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
            if (c16 != null && (T = c16.T(((GProStFeed) this.f407799e).recommendCard.data)) != null && T.getAdContentType() != 0) {
                f(m(), T);
                atomicBoolean.set(true);
            }
        } catch (Exception e16) {
            QLog.e("GuildGproFeedBlockData", 1, e16, new Object[0]);
        }
        countDownLatch.countDown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C(CountDownLatch countDownLatch, AtomicBoolean atomicBoolean) {
        GuildScheduleInfo f16 = c.f(((GProStFeed) this.f407799e).recommendCard.data);
        if (f16 != null) {
            f(m(), f16);
            atomicBoolean.set(true);
        }
        countDownLatch.countDown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D(CountDownLatch countDownLatch, AtomicBoolean atomicBoolean) {
        GProSysPromptDigest decodeGProSysPromptDigest = IGProDataApi.INSTANCE.a().decodeGProSysPromptDigest(((GProStFeed) this.f407799e).recommendCard.data);
        if (decodeGProSysPromptDigest != null) {
            f(m(), decodeGProSysPromptDigest);
            atomicBoolean.set(true);
        }
        countDownLatch.countDown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F(final CountDownLatch countDownLatch, final AtomicBoolean atomicBoolean) {
        ((IGPSService) ch.R0(IGPSService.class)).fetchLiveRoomInfo(new ag.a().i(((GProStFeed) this.f407799e).recommendCard.data).e(), new af() { // from class: ij1.f
            @Override // vh2.af
            public final void a(int i3, String str, List list, List list2, int i16) {
                g.this.t(atomicBoolean, countDownLatch, i3, str, list, list2, i16);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G(final CountDownLatch countDownLatch, final AtomicBoolean atomicBoolean) {
        com.tencent.mobileqq.qqguildsdk.data.genc.q qVar = new com.tencent.mobileqq.qqguildsdk.data.genc.q();
        qVar.l(((GProStFeed) this.f407799e).recommendCard.data);
        ((IGPSService) ch.R0(IGPSService.class)).fetchAudioLiveChannelUserList(qVar, new ad() { // from class: ij1.e
            @Override // wh2.ad
            public final void a(int i3, String str, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
                g.this.u(atomicBoolean, countDownLatch, i3, str, iGProAudioLiveUserListRsp);
            }
        });
    }

    private boolean j(int i3, List<ILiveRoomInfo> list) {
        if (i3 != 0 || list.isEmpty() || TextUtils.isEmpty(list.get(0).getRoomId()) || "0".equals(list.get(0).getRoomId())) {
            return false;
        }
        return true;
    }

    private static boolean k(int i3, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
        if (i3 == 0 && iGProAudioLiveUserListRsp != null && iGProAudioLiveUserListRsp.getChannelMemberInfo() != null && !TextUtils.isEmpty(iGProAudioLiveUserListRsp.getChannelMemberInfo().getChannleId()) && !"0".equals(iGProAudioLiveUserListRsp.getChannelMemberInfo().getChannleId())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void t(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, int i3, String str, List list, List list2, int i16) {
        if (j(i3, list)) {
            GuildFeedSquareLiveRoomItemData guildFeedSquareLiveRoomItemData = new GuildFeedSquareLiveRoomItemData(String.valueOf(((GProStFeed) this.f407799e).channelInfo.sign.guildId), (ILiveRoomInfo) list.get(0));
            if (TextUtils.isEmpty(guildFeedSquareLiveRoomItemData.getChannelId()) || guildFeedSquareLiveRoomItemData.getChannelId().equals("0")) {
                guildFeedSquareLiveRoomItemData.g(String.valueOf(((GProStFeed) this.f407799e).channelInfo.sign.channelId));
            }
            f(m(), guildFeedSquareLiveRoomItemData);
            atomicBoolean.set(true);
        } else {
            QLog.e("GuildGproFeedBlockData", 1, "transFormRecommendLiveCard error, feed id:" + ((GProStFeed) this.f407799e).idd);
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void u(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, int i3, String str, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
        if (k(i3, iGProAudioLiveUserListRsp)) {
            f(m(), GuildFeedSquareMediaRoomItemData.h(String.valueOf(((GProStFeed) this.f407799e).channelInfo.sign.guildId), iGProAudioLiveUserListRsp.getChannelMemberInfo()));
            atomicBoolean.set(true);
        } else {
            QLog.e("GuildGproFeedBlockData", 1, "transFormRecommendMediaCard error, feed id:" + ((GProStFeed) this.f407799e).idd);
        }
        countDownLatch.countDown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public boolean A() {
        int i3;
        String str;
        boolean await;
        T t16 = this.f407799e;
        if (t16 == 0 || (i3 = ((GProStFeed) t16).recommendCard.cardType) <= 0 || this.f407798d.containsKey(m())) {
            return true;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (i3 == 1) {
            G(countDownLatch, atomicBoolean);
        } else if (i3 == 2) {
            F(countDownLatch, atomicBoolean);
        } else if (i3 == 3) {
            C(countDownLatch, atomicBoolean);
        } else if (i3 == 4) {
            B(countDownLatch, atomicBoolean);
        } else if (i3 == 5) {
            D(countDownLatch, atomicBoolean);
        } else {
            countDownLatch.countDown();
        }
        try {
            await = countDownLatch.await(200L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            if (QLog.isDevelopLevel()) {
                str = "syncTransFormRecommendCard parseFinish:false";
            }
        } catch (Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GuildGproFeedBlockData", 4, "syncTransFormRecommendCard parseFinish:false");
            }
            throw th5;
        }
        if (QLog.isDevelopLevel()) {
            str = "syncTransFormRecommendCard parseFinish:" + await;
            QLog.d("GuildGproFeedBlockData", 4, str);
        }
        return atomicBoolean.get();
    }

    @Override // ij1.b
    @NonNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public g clone() throws CloneNotSupportedException {
        return (g) super.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String m() {
        int i3;
        T t16 = this.f407799e;
        if (t16 != 0) {
            i3 = ((GProStFeed) t16).recommendCard.cardType;
        } else {
            i3 = 0;
        }
        return "recommend_card_" + i3;
    }

    public GProCapsule n() {
        return this.f407812i;
    }

    public List<String> o() {
        List<String> list = this.C;
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    public GuildTaskProgressState p() {
        return this.f407811h;
    }

    public boolean q() {
        return this.E;
    }

    public boolean r() {
        return this.F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean s() {
        int i3;
        T t16 = this.f407799e;
        if (t16 != 0) {
            i3 = ((GProStFeed) t16).recommendCard.cardType;
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "GuildGproFeedBlockData{mTaskProgressState=" + this.f407811h + ", mMessageCapsuleData=" + this.f407812i + ", feedTag='" + this.f407813m + "', highLightWord=" + this.C + ", feedAudioLiveInfo=" + this.D + '}';
    }

    public void v(FeedAudioLiveInfo feedAudioLiveInfo) {
        this.D = feedAudioLiveInfo;
    }

    public void w(GProCapsule gProCapsule) {
        this.f407812i = gProCapsule;
    }

    public void x(boolean z16) {
        this.E = z16;
    }

    public void y(boolean z16) {
        this.F = z16;
    }

    public void z(GuildTaskProgressState guildTaskProgressState) {
        this.f407811h = guildTaskProgressState;
    }

    public g(GProStFeed gProStFeed, String str) {
        this(gProStFeed);
        this.f407813m = str;
    }

    public g(GProStFeed gProStFeed, String str, List<String> list) {
        this(gProStFeed);
        this.f407813m = str;
        this.C = list;
    }

    public g E() {
        return this;
    }
}
