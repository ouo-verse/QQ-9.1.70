package h5;

import NS_MOBILE_TEMPLATE_GIFT.s_send_gift_item;
import com.qzone.business.gift.business.model.GiftCard;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public long f404320b;

    /* renamed from: e, reason: collision with root package name */
    public boolean f404323e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f404324f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f404327i;

    /* renamed from: k, reason: collision with root package name */
    public int f404329k;

    /* renamed from: a, reason: collision with root package name */
    public int f404319a = 1;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Long> f404321c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public String f404322d = "";

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public String f404325g = "";

    /* renamed from: h, reason: collision with root package name */
    public GiftCard f404326h = new GiftCard();

    /* renamed from: j, reason: collision with root package name */
    public String f404328j = "";

    /* renamed from: l, reason: collision with root package name */
    public String f404330l = "";

    public s_send_gift_item a() {
        s_send_gift_item s_send_gift_itemVar = new s_send_gift_item();
        s_send_gift_itemVar.giftType = this.f404319a;
        s_send_gift_itemVar.receiver = this.f404321c;
        s_send_gift_itemVar.giftItemId = this.f404320b;
        s_send_gift_itemVar.content = this.f404322d;
        s_send_gift_itemVar.isBack = this.f404323e;
        s_send_gift_itemVar.isPrivate = this.f404324f;
        s_send_gift_itemVar.url = this.f404325g;
        s_send_gift_itemVar.giftCard = this.f404326h.a();
        s_send_gift_itemVar.isTiming = this.f404327i;
        s_send_gift_itemVar.sendTime = this.f404328j;
        s_send_gift_itemVar.arch = this.f404329k;
        s_send_gift_itemVar.s_back_id = this.f404330l;
        return s_send_gift_itemVar;
    }
}
