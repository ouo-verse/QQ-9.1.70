package com.qzone.business.gift.business.model;

import NS_MOBILE_TEMPLATE_GIFT.s_gift_card;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GiftCard implements Parcelable {

    /* renamed from: d, reason: collision with root package name */
    public String f44505d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f44506e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f44507f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f44508h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f44509i = "";

    /* renamed from: m, reason: collision with root package name */
    public boolean f44510m = true;
    public String C = "";
    public String D = "";
    public String E = "";
    public String F = "";
    public String G = "";
    public String H = "";
    public String I = "";
    public String J = "";
    public String K = "";

    public s_gift_card a() {
        s_gift_card s_gift_cardVar = new s_gift_card();
        s_gift_cardVar.pic_baseurl = this.f44505d;
        s_gift_cardVar.pic_background = this.f44506e;
        s_gift_cardVar.pic_65 = this.f44507f;
        s_gift_cardVar.pic_100 = this.f44508h;
        s_gift_cardVar.pic_big = this.f44509i;
        s_gift_cardVar.btn_reply = this.f44510m;
        s_gift_cardVar.btn_pic_reply = this.C;
        s_gift_cardVar.btn_pic_1 = this.D;
        s_gift_cardVar.btn_link_1 = this.E;
        s_gift_cardVar.btn_pic_2 = this.F;
        s_gift_cardVar.btn_link_2 = this.G;
        s_gift_cardVar.word_name = this.H;
        s_gift_cardVar.word_desc = this.I;
        s_gift_cardVar.word_msg = this.J;
        s_gift_cardVar.card_url = this.K;
        return s_gift_cardVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
