package cooperation.qzone.UndealCount;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import cooperation.qzone.util.JceUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneCountUserInfo implements Parcelable {
    public static final Parcelable.Creator<QZoneCountUserInfo> CREATOR = new Parcelable.Creator<QZoneCountUserInfo>() { // from class: cooperation.qzone.UndealCount.QZoneCountUserInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QZoneCountUserInfo createFromParcel(Parcel parcel) {
            return new QZoneCountUserInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QZoneCountUserInfo[] newArray(int i3) {
            return new QZoneCountUserInfo[i3];
        }
    };
    public int iYellowLevel;
    public int iYellowType;
    public byte isAnnualVip;
    public String nickName;
    public PassiveFeedsPush pushData;
    public long uin;
    public ArrayList<feed_info> vec_feedInfos;

    public QZoneCountUserInfo() {
        this.vec_feedInfos = null;
    }

    private ArrayList<feed_info> getFeed_infos(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new feed_info());
        try {
            byte[] createByteArray = parcel.createByteArray();
            if (createByteArray != null && createByteArray.length != 0) {
                JceInputStream jceInputStream = new JceInputStream(createByteArray);
                jceInputStream.setServerEncoding("utf8");
                return (ArrayList) jceInputStream.read((JceInputStream) arrayList, 0, false);
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        PassiveFeedsPush passiveFeedsPush;
        QzmallCustomBubbleSkin qzmallCustomBubbleSkin;
        if (!(obj instanceof QZoneCountUserInfo)) {
            return false;
        }
        QZoneCountUserInfo qZoneCountUserInfo = (QZoneCountUserInfo) obj;
        if (this.uin != qZoneCountUserInfo.uin || this.iYellowType != qZoneCountUserInfo.iYellowType || this.isAnnualVip == qZoneCountUserInfo.isAnnualVip || this.iYellowLevel == qZoneCountUserInfo.iYellowLevel) {
            return false;
        }
        PassiveFeedsPush passiveFeedsPush2 = this.pushData;
        if (passiveFeedsPush2 != null && (passiveFeedsPush = qZoneCountUserInfo.pushData) != null) {
            QzmallCustomBubbleSkin qzmallCustomBubbleSkin2 = passiveFeedsPush2.stBubbleSkin;
            if (qzmallCustomBubbleSkin2 != null && (qzmallCustomBubbleSkin = passiveFeedsPush.stBubbleSkin) != null) {
                return TextUtils.equals(qzmallCustomBubbleSkin2.strBubbleZipUrl, qzmallCustomBubbleSkin.strBubbleZipUrl);
            }
            if (qzmallCustomBubbleSkin2 != passiveFeedsPush.stBubbleSkin) {
                return false;
            }
            return true;
        }
        if (passiveFeedsPush2 != qZoneCountUserInfo.pushData) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        byte[] encodeWup;
        parcel.writeLong(this.uin);
        parcel.writeInt(this.iYellowType);
        parcel.writeInt(this.iYellowLevel);
        parcel.writeByte(this.isAnnualVip);
        PassiveFeedsPush passiveFeedsPush = this.pushData;
        byte[] bArr = null;
        if (passiveFeedsPush == null) {
            encodeWup = null;
        } else {
            encodeWup = JceUtils.encodeWup(passiveFeedsPush);
        }
        parcel.writeByteArray(encodeWup);
        ArrayList<feed_info> arrayList = this.vec_feedInfos;
        if (arrayList != null) {
            bArr = JceUtils.encodeWup(arrayList);
        }
        parcel.writeByteArray(bArr);
        parcel.writeString(this.nickName);
    }

    protected QZoneCountUserInfo(Parcel parcel) {
        this.vec_feedInfos = null;
        this.uin = parcel.readLong();
        this.iYellowType = parcel.readInt();
        this.iYellowLevel = parcel.readInt();
        this.isAnnualVip = parcel.readByte();
        this.pushData = (PassiveFeedsPush) JceUtils.decodeWup(PassiveFeedsPush.class, parcel.createByteArray());
        this.vec_feedInfos = getFeed_infos(parcel);
        this.nickName = parcel.readString();
    }
}
