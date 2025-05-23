package com.tencent.biz.pubaccount.weishi.push;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSPushVideoModel implements Parcelable {
    public static final Parcelable.Creator<WSPushVideoModel> CREATOR = new a();
    private int C;
    private int D;
    private int E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private String f81338d;

    /* renamed from: e, reason: collision with root package name */
    public String f81339e;

    /* renamed from: f, reason: collision with root package name */
    public String f81340f;

    /* renamed from: h, reason: collision with root package name */
    private String f81341h;

    /* renamed from: i, reason: collision with root package name */
    private String f81342i;

    /* renamed from: m, reason: collision with root package name */
    private String f81343m;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<WSPushVideoModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WSPushVideoModel createFromParcel(Parcel parcel) {
            return new WSPushVideoModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WSPushVideoModel[] newArray(int i3) {
            return new WSPushVideoModel[i3];
        }
    }

    public WSPushVideoModel() {
    }

    public stSimpleMetaFeed a(String str) {
        stSimpleMetaFeed stsimplemetafeed = new stSimpleMetaFeed();
        stsimplemetafeed.f25129id = str;
        stsimplemetafeed.video_url = this.f81339e;
        ArrayList<stMetaUgcImage> arrayList = new ArrayList<>();
        stMetaUgcImage stmetaugcimage = new stMetaUgcImage();
        stmetaugcimage.url = this.f81340f;
        stMetaUgcImage stmetaugcimage2 = new stMetaUgcImage();
        stmetaugcimage2.url = this.f81340f;
        arrayList.add(stmetaugcimage);
        arrayList.add(stmetaugcimage2);
        stsimplemetafeed.images = arrayList;
        stMetaUgcVideoSeg stmetaugcvideoseg = new stMetaUgcVideoSeg();
        stmetaugcvideoseg.file_id = this.f81338d;
        stmetaugcvideoseg.duration = this.E;
        stmetaugcvideoseg.height = this.C;
        stmetaugcvideoseg.width = this.D;
        stsimplemetafeed.video = stmetaugcvideoseg;
        stsimplemetafeed.video_type = 0;
        stsimplemetafeed.videoPoolType = 0;
        stFloatingLayerCardStyle stfloatinglayercardstyle = new stFloatingLayerCardStyle();
        stfloatinglayercardstyle.cardType = this.F;
        stfloatinglayercardstyle.commentHidden = false;
        stfloatinglayercardstyle.dingHidden = false;
        stfloatinglayercardstyle.shareHidden = false;
        stsimplemetafeed.floatingLayerCardStyle = stfloatinglayercardstyle;
        stsimplemetafeed.traceId = "";
        stSimpleMetaPerson stsimplemetaperson = new stSimpleMetaPerson();
        stsimplemetaperson.avatar = this.f81342i;
        stsimplemetaperson.f25130id = this.f81341h;
        stsimplemetaperson.medal = 0;
        stsimplemetaperson.nick = this.f81343m;
        stsimplemetafeed.poster = stsimplemetaperson;
        return stsimplemetafeed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f81338d);
        parcel.writeString(this.f81339e);
        parcel.writeString(this.f81340f);
        parcel.writeString(this.f81341h);
        parcel.writeString(this.f81342i);
        parcel.writeString(this.f81343m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
    }

    protected WSPushVideoModel(Parcel parcel) {
        this.f81338d = parcel.readString();
        this.f81339e = parcel.readString();
        this.f81340f = parcel.readString();
        this.f81341h = parcel.readString();
        this.f81342i = parcel.readString();
        this.f81343m = parcel.readString();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static WSPushVideoModel b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WSPushVideoModel wSPushVideoModel = new WSPushVideoModel();
        wSPushVideoModel.f81338d = jSONObject.optString("video_id");
        wSPushVideoModel.f81339e = jSONObject.optString("video_url");
        wSPushVideoModel.f81340f = jSONObject.optString("video_cover_url");
        wSPushVideoModel.f81342i = jSONObject.optString("person_avatar");
        wSPushVideoModel.f81341h = jSONObject.optString("person_id");
        wSPushVideoModel.f81343m = jSONObject.optString("person_nick");
        wSPushVideoModel.E = jSONObject.optInt("duration");
        wSPushVideoModel.D = jSONObject.optInt("video_width");
        wSPushVideoModel.C = jSONObject.optInt("video_height");
        wSPushVideoModel.F = jSONObject.optInt("card_type");
        return wSPushVideoModel;
    }
}
