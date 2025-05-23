package cooperation.qzone.model;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import NS_MOBILE_COVER_DATE.feeds_cover;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CoverCacheData implements Parcelable {
    public static final Parcelable.Creator<CoverCacheData> CREATOR = new Parcelable.Creator<CoverCacheData>() { // from class: cooperation.qzone.model.CoverCacheData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CoverCacheData[] newArray(int i3) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CoverCacheData createFromParcel(Parcel parcel) {
            CoverCacheData coverCacheData = new CoverCacheData();
            if (parcel != null) {
                coverCacheData.uin = parcel.readLong();
                coverCacheData.coverId = parcel.readString();
                coverCacheData.type = parcel.readString();
                coverCacheData.local_url = parcel.readString();
                coverCacheData.urls = parcel.readHashMap(getClass().getClassLoader());
                coverCacheData.packageInfo = (PackageInfo) parcel.readParcelable(getClass().getClassLoader());
                coverCacheData.gameCoverInfo = (GameCoverInfo) parcel.readParcelable(getClass().getClassLoader());
                coverCacheData.photoWall = parcel.readArrayList(getClass().getClassLoader());
                coverCacheData.isJigsawOpen = parcel.readInt();
                coverCacheData.mapExtInfo = parcel.readHashMap(getClass().getClassLoader());
                coverCacheData.backupMapExtInfo = parcel.readHashMap(getClass().getClassLoader());
                coverCacheData.alian = parcel.readInt();
            }
            return coverCacheData;
        }
    };
    public HashMap<String, String> backupMapExtInfo;
    public GameCoverInfo gameCoverInfo;
    public PackageInfo packageInfo;
    public long uin = 0;
    public String coverId = "";
    public String type = "";
    public String local_url = "";
    public HashMap<String, String> urls = new HashMap<>();
    public ArrayList<Map<Integer, String>> photoWall = new ArrayList<>();
    public HashMap<String, String> mapExtInfo = new HashMap<>();
    public int isJigsawOpen = 0;
    public int alian = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class GameCoverInfo implements Parcelable {
        public static final Parcelable.Creator<GameCoverInfo> CREATOR = new Parcelable.Creator<GameCoverInfo>() { // from class: cooperation.qzone.model.CoverCacheData.GameCoverInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GameCoverInfo[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GameCoverInfo createFromParcel(Parcel parcel) {
                GameCoverInfo gameCoverInfo = new GameCoverInfo();
                if (parcel != null) {
                    gameCoverInfo.xCoordLU = parcel.readDouble();
                    gameCoverInfo.yCoordLU = parcel.readDouble();
                    gameCoverInfo.xCoordRD = parcel.readDouble();
                    gameCoverInfo.yCoordRD = parcel.readDouble();
                    gameCoverInfo.jmpUrl = parcel.readString();
                    gameCoverInfo.schema = parcel.readString();
                    gameCoverInfo.jmpType = parcel.readInt();
                }
                return gameCoverInfo;
            }
        };
        public double xCoordLU = 0.0d;
        public double yCoordLU = 0.0d;
        public double xCoordRD = 0.0d;
        public double yCoordRD = 0.0d;
        public String jmpUrl = "";
        public String schema = "";
        public int jmpType = 0;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeDouble(this.xCoordLU);
            parcel.writeDouble(this.yCoordLU);
            parcel.writeDouble(this.xCoordRD);
            parcel.writeDouble(this.yCoordRD);
            parcel.writeString(this.jmpUrl);
            parcel.writeString(this.schema);
            parcel.writeInt(this.jmpType);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class PackageInfo implements Parcelable {
        public static final Parcelable.Creator<PackageInfo> CREATOR = new Parcelable.Creator<PackageInfo>() { // from class: cooperation.qzone.model.CoverCacheData.PackageInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PackageInfo[] newArray(int i3) {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PackageInfo createFromParcel(Parcel parcel) {
                PackageInfo packageInfo = new PackageInfo();
                if (parcel != null) {
                    packageInfo.prePic = parcel.readString();
                    packageInfo.PackageUrl = parcel.readString();
                    packageInfo.md5 = parcel.readString();
                    packageInfo.weather = parcel.readInt();
                    packageInfo.daytime = parcel.readInt();
                    packageInfo.coverStyle = parcel.readInt();
                    packageInfo.degrade_pic = parcel.readString();
                }
                return packageInfo;
            }
        };
        public String PackageUrl;
        public String degrade_pic;
        public String md5;
        public String prePic;
        public int weather;
        public int daytime = 0;
        public int coverStyle = -1;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.prePic);
            parcel.writeString(this.PackageUrl);
            parcel.writeString(this.md5);
            parcel.writeInt(this.weather);
            parcel.writeInt(this.daytime);
            parcel.writeInt(this.coverStyle);
            parcel.writeString(this.degrade_pic);
        }
    }

    public static CoverCacheData createFromResponse(long j3, feeds_cover feeds_coverVar) {
        if (feeds_coverVar == null) {
            return null;
        }
        CoverCacheData coverCacheData = new CoverCacheData();
        coverCacheData.uin = j3;
        coverCacheData.coverId = feeds_coverVar.f24972id;
        coverCacheData.type = feeds_coverVar.type;
        coverCacheData.isJigsawOpen = feeds_coverVar.photoWallCombinePic;
        Map<String, String> map = feeds_coverVar.MulRelsotionUrl;
        if (map != null) {
            coverCacheData.urls.putAll(map);
        }
        if (feeds_coverVar.packageInfo != null) {
            PackageInfo packageInfo = new PackageInfo();
            coverCacheData.packageInfo = packageInfo;
            CoverPackageInfo coverPackageInfo = feeds_coverVar.packageInfo;
            packageInfo.prePic = coverPackageInfo.prePic;
            packageInfo.PackageUrl = coverPackageInfo.PackageUrl;
            packageInfo.md5 = coverPackageInfo.md5;
            packageInfo.weather = coverPackageInfo.weather;
            packageInfo.daytime = coverPackageInfo.daytime;
            packageInfo.coverStyle = coverPackageInfo.coverStyle;
        }
        if (feeds_coverVar.gameCoverInfo != null) {
            GameCoverInfo gameCoverInfo = new GameCoverInfo();
            coverCacheData.gameCoverInfo = gameCoverInfo;
            NS_MOBILE_COVER_DATE.GameCoverInfo gameCoverInfo2 = feeds_coverVar.gameCoverInfo;
            gameCoverInfo.xCoordLU = gameCoverInfo2.xCoordLU;
            gameCoverInfo.yCoordLU = gameCoverInfo2.yCoordLU;
            gameCoverInfo.xCoordRD = gameCoverInfo2.xCoordRD;
            gameCoverInfo.yCoordRD = gameCoverInfo2.yCoordRD;
            gameCoverInfo.jmpUrl = gameCoverInfo2.jmpUrl;
            gameCoverInfo.schema = gameCoverInfo2.schema;
            gameCoverInfo.jmpType = gameCoverInfo2.jmpType;
        }
        ArrayList<Map<Integer, String>> arrayList = feeds_coverVar.vecUrls;
        if (arrayList != null && arrayList.size() > 0) {
            coverCacheData.photoWall.addAll(feeds_coverVar.vecUrls);
        }
        Map<String, String> map2 = feeds_coverVar.mapExtInfo;
        if (map2 != null) {
            coverCacheData.mapExtInfo.putAll(map2);
        }
        return coverCacheData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isVideoCover() {
        if (!QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER.equals(this.type) && !QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER.equals(this.type)) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.uin);
        parcel.writeString(this.coverId);
        parcel.writeString(this.type);
        parcel.writeString(this.local_url);
        parcel.writeMap(this.urls);
        parcel.writeParcelable(this.packageInfo, i3);
        parcel.writeParcelable(this.gameCoverInfo, i3);
        parcel.writeList(this.photoWall);
        parcel.writeInt(this.isJigsawOpen);
        parcel.writeMap(this.mapExtInfo);
        parcel.writeMap(this.backupMapExtInfo);
        parcel.writeInt(this.alian);
    }

    public static CoverCacheData createFromResponse(long j3, mobile_sub_get_cover_rsp mobile_sub_get_cover_rspVar) {
        if (mobile_sub_get_cover_rspVar == null) {
            return null;
        }
        CoverCacheData coverCacheData = new CoverCacheData();
        coverCacheData.uin = j3;
        coverCacheData.type = mobile_sub_get_cover_rspVar.type;
        coverCacheData.isJigsawOpen = mobile_sub_get_cover_rspVar.photoWallCombinePic;
        Map<String, String> map = mobile_sub_get_cover_rspVar.MulRelsotionUrl;
        if (map != null) {
            coverCacheData.urls.putAll(map);
        }
        if (mobile_sub_get_cover_rspVar.packageInfo != null) {
            PackageInfo packageInfo = new PackageInfo();
            coverCacheData.packageInfo = packageInfo;
            CoverPackageInfo coverPackageInfo = mobile_sub_get_cover_rspVar.packageInfo;
            packageInfo.prePic = coverPackageInfo.prePic;
            packageInfo.PackageUrl = coverPackageInfo.PackageUrl;
            packageInfo.md5 = coverPackageInfo.md5;
            packageInfo.weather = coverPackageInfo.weather;
            packageInfo.daytime = coverPackageInfo.daytime;
            packageInfo.coverStyle = coverPackageInfo.coverStyle;
        }
        ArrayList<Map<Integer, String>> arrayList = mobile_sub_get_cover_rspVar.vecUrls;
        if (arrayList != null && arrayList.size() > 0) {
            coverCacheData.photoWall.addAll(mobile_sub_get_cover_rspVar.vecUrls);
        }
        return coverCacheData;
    }
}
