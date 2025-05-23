package k12;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.guild.r;
import com.tencent.mobileqq.guild.t;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GetGiftListRsp;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$SendGiftRsp;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$UniBalanceFromAdminRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements k12.c {

    /* renamed from: a, reason: collision with root package name */
    private k12.b f411395a = new k12.b();

    /* renamed from: b, reason: collision with root package name */
    private final t f411396b;

    public a(t tVar) {
        this.f411396b = tVar;
    }

    private void h(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("GiftDataController", 1, "getCoins fail authKey is empty!");
        } else {
            l12.a.a().b(str, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(byte[] bArr) {
        giftList$UniBalanceFromAdminRsp giftlist_unibalancefromadminrsp = new giftList$UniBalanceFromAdminRsp();
        try {
            giftlist_unibalancefromadminrsp.mergeFrom(bArr);
            this.f411396b.updateCoins(giftlist_unibalancefromadminrsp.balance.get(), giftlist_unibalancefromadminrsp.rechargeUrl.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(byte[] bArr) {
        giftList$SendGiftRsp giftlist_sendgiftrsp = new giftList$SendGiftRsp();
        try {
            giftlist_sendgiftrsp.mergeFrom(bArr);
            int i3 = giftlist_sendgiftrsp.ret.get();
            if (i3 == -9992) {
                this.f411396b.toRechargePanel(IVasNativePayManager.TITLE_GOLD_NOT_ENOUGH);
            } else if (i3 != 0) {
                this.f411396b.toastSendError();
                Log.e("GiftDataController", "handleSendGiftError:" + giftlist_sendgiftrsp.ret.get());
            } else {
                this.f411396b.closeGiftPanel();
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(byte[] bArr, m12.a aVar, String str) {
        giftList$GetGiftListRsp giftlist_getgiftlistrsp = new giftList$GetGiftListRsp();
        try {
            giftlist_getgiftlistrsp.mergeFrom(bArr);
            if (!giftlist_getgiftlistrsp.attachInfo.equals(this.f411395a.a()) && !TextUtils.isEmpty(this.f411395a.a())) {
                if (this.f411395a.b().size() == giftlist_getgiftlistrsp.total.get()) {
                    return;
                }
                this.f411395a.b().addAll(giftlist_getgiftlistrsp.giftList.get());
                giftlist_getgiftlistrsp.giftList.set(this.f411395a.b());
            }
            aVar.d(str, giftlist_getgiftlistrsp);
            this.f411395a.f(giftlist_getgiftlistrsp);
            m(giftlist_getgiftlistrsp);
            l();
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    private void l() {
        this.f411396b.updateGiftPanel(this.f411395a.b());
    }

    private void m(giftList$GetGiftListRsp giftlist_getgiftlistrsp) {
        if (giftlist_getgiftlistrsp.giftList.has()) {
            for (giftList$GroupGiftItem giftlist_groupgiftitem : giftlist_getgiftlistrsp.giftList.get()) {
                if (giftlist_groupgiftitem.thumbnail.has()) {
                    URLDrawable.getDrawable(giftlist_groupgiftitem.thumbnail.get(), (URLDrawable.URLDrawableOptions) null);
                }
                if (giftlist_groupgiftitem.backgroundImage.has()) {
                    URLDrawable.getDrawable(giftlist_groupgiftitem.backgroundImage.get(), (URLDrawable.URLDrawableOptions) null);
                }
            }
        }
    }

    private void n(String str, m12.a aVar) {
        l12.b.a().b(str, this.f411395a.a(), new C10627a(aVar, str));
    }

    private void o(long j3, long j16, int i3, int i16, long j17, long j18, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("GiftDataController", 1, "sendGift fail authKey is empty!");
        } else {
            l12.c.a().b(j3, j16, i3, i16, j17, j18, str);
            l12.c.a().c(j3, j16, i3, i16, j17, j18, str, new c());
        }
    }

    @Override // k12.c
    public List<giftList$GroupGiftItem> b(String str) {
        if (this.f411395a.b().size() != 0) {
            return this.f411395a.b();
        }
        this.f411395a.f(m12.a.b().a(str));
        if (this.f411395a.b().size() > 0) {
            return this.f411395a.b();
        }
        preLoadGiftData(str);
        return null;
    }

    @Override // k12.c
    public long c() {
        return this.f411395a.c();
    }

    @Override // k12.c
    public void d(String str) {
        if (this.f411395a.b().size() == 0 || this.f411395a.d()) {
            n(str, m12.a.b());
        }
    }

    @Override // k12.c
    public void getCoins() {
        if (this.f411396b.getGiftPanelAction() != null) {
            h(this.f411396b.getGiftPanelAction().c());
        }
    }

    @Override // k12.c
    public void preLoadGiftData(String str) {
        m12.a b16 = m12.a.b();
        if (b16.c(str)) {
            this.f411395a.e("");
            n(str, b16);
        } else {
            giftList$GetGiftListRsp a16 = b16.a(str);
            this.f411395a.f(a16);
            m(a16);
        }
    }

    @Override // k12.c
    public com.tencent.mobileqq.qqgift.data.service.c a(long j3, int i3) {
        com.tencent.mobileqq.qqgift.data.service.c cVar = new com.tencent.mobileqq.qqgift.data.service.c();
        cVar.f264862c = i3;
        if (this.f411396b.getGiftPanelAction() != null) {
            cVar.f264860a = this.f411396b.getGiftPanelAction().a();
        }
        cVar.f264861b = j3;
        if (this.f411396b.getGiftPanelAction() != null) {
            r giftPanelAction = this.f411396b.getGiftPanelAction();
            cVar.f264870k.put("key_req_msg", l12.c.a().b(giftPanelAction.a(), j3, i3, 0, giftPanelAction.getChannelId(), giftPanelAction.getGroupId(), giftPanelAction.c()));
            cVar.f264870k.put(IYunGameConstant.KEY_AUTH_KEY, giftPanelAction.c());
            cVar.f264870k.put("channelID", String.valueOf(giftPanelAction.getChannelId()));
            cVar.f264870k.put("guildID", String.valueOf(giftPanelAction.getGroupId()));
        }
        return cVar;
    }

    @Override // k12.c
    public void sendGift(long j3, int i3, int i16) {
        if (this.f411396b.getGiftPanelAction() != null) {
            r giftPanelAction = this.f411396b.getGiftPanelAction();
            o(giftPanelAction.a(), j3, i3, i16, giftPanelAction.getChannelId(), giftPanelAction.getGroupId(), giftPanelAction.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: k12.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10627a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ m12.a f411397d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f411398e;

        C10627a(m12.a aVar, String str) {
            this.f411397d = aVar;
            this.f411398e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && i3 == 0 && obj != null) {
                a.this.k((byte[]) obj, this.f411397d, this.f411398e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements BusinessObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && i3 == 0 && obj != null) {
                a.this.i((byte[]) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c implements BusinessObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && i3 == 0 && obj != null) {
                a.this.j((byte[]) obj);
            }
        }
    }
}
