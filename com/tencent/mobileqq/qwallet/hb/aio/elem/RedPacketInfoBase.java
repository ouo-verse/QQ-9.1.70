package com.tencent.mobileqq.qwallet.hb.aio.elem;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.widget.AnimationView;

/* loaded from: classes16.dex */
public class RedPacketInfoBase implements Parcelable {
    public static final Parcelable.Creator<RedPacketInfoBase> CREATOR = new a();
    public static final String ICON_DEF = "icon_def";
    public static final String ICON_DRAW = "icon_draw";
    public static final String ICON_EMOJI = "icon_emoji";
    public static final String ICON_KSONG = "icon_ksong";
    public static final String ICON_SP = "icon_sp";
    public static final String ICON_TXT = "icon_txt";
    public static final String ICON_VIDEO = "icon_video";
    public static final String ICON_VOICE = "icon_voice";
    public AnimationView.AnimationInfo animInfo;
    public Bundle attribute;
    public String background;
    public String backgroundStatic;
    public int bigAnimId;
    public int channel;
    public Bitmap corner;
    public Bitmap icon;
    public boolean isCache;
    public int isHideTitle;
    public String outerSkinId;
    public String resPath;
    public int skinFrom;
    public int skinId;
    public int skinType;
    public AnimationView.AnimationInfo specailBackgroundAnimInfo;
    public Bitmap specialBackground;
    public String templateId;
    public String title;
    public int type;

    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<RedPacketInfoBase> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedPacketInfoBase createFromParcel(Parcel parcel) {
            return new RedPacketInfoBase(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RedPacketInfoBase[] newArray(int i3) {
            return new RedPacketInfoBase[i3];
        }
    }

    public RedPacketInfoBase() {
        this.channel = -1;
        this.attribute = new Bundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.skinType);
        parcel.writeInt(this.skinId);
        parcel.writeString(this.outerSkinId);
        parcel.writeInt(this.skinFrom);
        parcel.writeInt(this.channel);
        parcel.writeInt(this.bigAnimId);
        parcel.writeString(this.templateId);
        parcel.writeParcelable(this.corner, i3);
        parcel.writeParcelable(this.icon, i3);
        parcel.writeParcelable(this.specialBackground, i3);
        parcel.writeString(this.title);
        parcel.writeInt(this.isHideTitle);
        parcel.writeString(this.resPath);
        parcel.writeBundle(this.attribute);
        parcel.writeInt(this.isCache ? 1 : 0);
    }

    protected RedPacketInfoBase(Parcel parcel) {
        this.channel = -1;
        this.attribute = new Bundle();
        this.type = parcel.readInt();
        this.skinType = parcel.readInt();
        this.skinId = parcel.readInt();
        this.outerSkinId = parcel.readString();
        this.skinFrom = parcel.readInt();
        this.channel = parcel.readInt();
        this.bigAnimId = parcel.readInt();
        this.templateId = parcel.readString();
        this.corner = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.icon = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.specialBackground = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.title = parcel.readString();
        this.isHideTitle = parcel.readInt();
        this.resPath = parcel.readString();
        this.attribute = parcel.readBundle();
        this.isCache = parcel.readInt() == 1;
    }
}
