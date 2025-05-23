package com.tencent.mobileqq.winkpublish.model;

import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import PROTO_EXT_TO_UGCSVR.Font;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.winkpublish.config.UploadLocalConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes21.dex */
public class PublishUploadParams implements Parcelable {
    public static final Parcelable.Creator<PublishUploadParams> CREATOR = new a();
    public String advJobId;
    public UploadLocalConfig config;
    public String content;
    public LbsDataV2.GpsInfo currentGps;
    public String declarationId;
    public String declarationName;
    public long deleteTime;
    public String extParam;
    public HashMap<String, String> extendParams;
    public Font fontInfo;
    public ArrayList<String> groupId;
    public LbsDataV2.PoiInfo hiddenPoi;
    public List<String> imageFiles;
    public ArrayList<String> imageList;
    public boolean isFromAIO;
    public boolean isOnlyPublishFeed;
    public boolean isTrueUpload;
    public boolean isUseHDUpload;
    public String mClientKey;
    public String mSchema;
    public int mTaskBuildType;
    public Map<String, byte[]> marksUploadMap;
    public List<LocalMediaInfo> mediaList;
    public ArrayList<ArrayList<WinkPublishMediaRecord>> mediaRecords;
    public ArrayList<MediaWrapper> mediaWrapperList;
    public String missionID;
    public String operationParams;
    public Map<String, byte[]> pasters;
    public HashMap<String, String> peituEntryAndSource;
    public int photoQuality;
    public Map<String, String> photoTagResult;
    public PicInfo picInfo;
    public LbsDataV2.PoiInfo poiInfo;
    public int priv;
    public ArrayList<String> privUinList;

    @Nullable
    public PromotionParams promotionParams;
    public String pubMusicAuthorUid;
    public long pubMusicId;
    public String pubMusicMid;
    public String pubMusicName;
    public int pubMusicScene;
    public long pubStartTime;
    public long publishTime;
    public int qcircleUpSource;
    public int qcircleUpType;
    public boolean reExport;
    public String refer;
    public HashMap<String, PicInfo> richImageMap;
    public boolean schoolIsSelected;

    @Nullable
    public String schoolName;
    public ArrayList<LabelInfo> selectedLabelInfos;
    public Map<String, String> shootParams;
    public shuoshuo_privacy shuoshuoPrivacy;
    public ShuoshuoVideoInfo shuoshuoVideoInfo;
    public Map<String, String> storedExtendInfo;
    public boolean syncQQ;
    public boolean syncQzone;
    public boolean syncWeibo;
    public String title;
    public ArrayList<String> uinId;
    public int uploadEntrance;
    public int subtype = 2;
    public boolean isVideoReady = true;
    public boolean isNeedVideoSave = false;
    public boolean hasSelectCover = false;
    public String clientTraceId = "";
    public boolean recommendTheSameCity = true;
    public boolean selectedJurisdiction = true;
    public HashMap<String, Object> datongParams = new HashMap<>();
    public ArrayList<Double> mVideoEstimateSizeList = new ArrayList<>();

    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<PublishUploadParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PublishUploadParams createFromParcel(Parcel parcel) {
            return new PublishUploadParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PublishUploadParams[] newArray(int i3) {
            return new PublishUploadParams[i3];
        }
    }

    public PublishUploadParams() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.imageFiles = parcel.createStringArrayList();
        this.mediaList = parcel.createTypedArrayList(LocalMediaInfo.CREATOR);
        this.extendParams = (HashMap) parcel.readSerializable();
        this.shuoshuoPrivacy = (shuoshuo_privacy) parcel.readSerializable();
        this.shuoshuoVideoInfo = (ShuoshuoVideoInfo) parcel.readParcelable(ShuoshuoVideoInfo.class.getClassLoader());
        this.richImageMap = (HashMap) parcel.readSerializable();
        this.poiInfo = (LbsDataV2.PoiInfo) parcel.readParcelable(LbsDataV2.PoiInfo.class.getClassLoader());
        this.hiddenPoi = (LbsDataV2.PoiInfo) parcel.readParcelable(LbsDataV2.PoiInfo.class.getClassLoader());
        boolean z46 = true;
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.syncWeibo = z16;
        if (parcel.readByte() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.syncQQ = z17;
        this.promotionParams = (PromotionParams) parcel.readParcelable(PromotionParams.class.getClassLoader());
        this.schoolName = parcel.readString();
        if (parcel.readByte() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.schoolIsSelected = z18;
        this.advJobId = parcel.readString();
        if (parcel.readByte() != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.syncQzone = z19;
        int readInt = parcel.readInt();
        this.shootParams = new HashMap(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            this.shootParams.put(parcel.readString(), parcel.readString());
        }
        this.fontInfo = (Font) parcel.readSerializable();
        this.photoQuality = parcel.readInt();
        this.publishTime = parcel.readLong();
        this.deleteTime = parcel.readLong();
        this.priv = parcel.readInt();
        this.privUinList = parcel.createStringArrayList();
        this.extParam = parcel.readString();
        this.currentGps = (LbsDataV2.GpsInfo) parcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader());
        this.operationParams = parcel.readString();
        this.uploadEntrance = parcel.readInt();
        int readInt2 = parcel.readInt();
        this.pasters = new HashMap(readInt2);
        for (int i16 = 0; i16 < readInt2; i16++) {
            this.pasters.put(parcel.readString(), parcel.createByteArray());
        }
        this.peituEntryAndSource = (HashMap) parcel.readSerializable();
        int readInt3 = parcel.readInt();
        this.marksUploadMap = new HashMap(readInt3);
        for (int i17 = 0; i17 < readInt3; i17++) {
            this.marksUploadMap.put(parcel.readString(), parcel.createByteArray());
        }
        int readInt4 = parcel.readInt();
        this.photoTagResult = new HashMap(readInt4);
        for (int i18 = 0; i18 < readInt4; i18++) {
            this.photoTagResult.put(parcel.readString(), parcel.readString());
        }
        this.subtype = parcel.readInt();
        this.refer = parcel.readString();
        this.mediaWrapperList = parcel.createTypedArrayList(MediaWrapper.CREATOR);
        this.picInfo = (PicInfo) parcel.readSerializable();
        if (parcel.readByte() != 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        this.isFromAIO = z26;
        this.imageList = parcel.createStringArrayList();
        int readInt5 = parcel.readInt();
        this.storedExtendInfo = new HashMap(readInt5);
        for (int i19 = 0; i19 < readInt5; i19++) {
            this.storedExtendInfo.put(parcel.readString(), parcel.readString());
        }
        if (parcel.readByte() != 0) {
            z27 = true;
        } else {
            z27 = false;
        }
        this.isVideoReady = z27;
        this.missionID = parcel.readString();
        this.qcircleUpSource = parcel.readInt();
        this.qcircleUpType = parcel.readInt();
        if (parcel.readByte() != 0) {
            z28 = true;
        } else {
            z28 = false;
        }
        this.isNeedVideoSave = z28;
        ArrayList<LabelInfo> arrayList = new ArrayList<>();
        this.selectedLabelInfos = arrayList;
        parcel.readList(arrayList, LabelInfo.class.getClassLoader());
        if (parcel.readByte() != 0) {
            z29 = true;
        } else {
            z29 = false;
        }
        this.hasSelectCover = z29;
        this.clientTraceId = parcel.readString();
        this.groupId = parcel.createStringArrayList();
        this.uinId = parcel.createStringArrayList();
        if (parcel.readByte() != 0) {
            z36 = true;
        } else {
            z36 = false;
        }
        this.recommendTheSameCity = z36;
        if (parcel.readByte() != 0) {
            z37 = true;
        } else {
            z37 = false;
        }
        this.selectedJurisdiction = z37;
        this.pubMusicMid = parcel.readString();
        this.pubMusicId = parcel.readLong();
        this.pubMusicName = parcel.readString();
        this.pubStartTime = parcel.readLong();
        this.mClientKey = parcel.readString();
        if (parcel.readByte() != 0) {
            z38 = true;
        } else {
            z38 = false;
        }
        this.reExport = z38;
        this.pubMusicScene = parcel.readInt();
        this.pubMusicAuthorUid = parcel.readString();
        int readInt6 = parcel.readInt();
        this.mediaRecords = new ArrayList<>();
        if (readInt6 != 0) {
            for (int i26 = 0; i26 < readInt6; i26++) {
                this.mediaRecords.add(parcel.createTypedArrayList(WinkPublishMediaRecord.CREATOR));
            }
        }
        this.config = (UploadLocalConfig) parcel.readParcelable(UploadLocalConfig.class.getClassLoader());
        if (parcel.readByte() != 0) {
            z39 = true;
        } else {
            z39 = false;
        }
        this.isUseHDUpload = z39;
        this.mSchema = parcel.readString();
        this.datongParams = (HashMap) parcel.readSerializable();
        this.mTaskBuildType = parcel.readInt();
        this.mVideoEstimateSizeList = (ArrayList) parcel.readSerializable();
        if (parcel.readByte() == 0) {
            z46 = false;
        }
        this.isTrueUpload = z46;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("title: ");
        sb5.append(this.title);
        sb5.append(" content: ");
        sb5.append(this.content);
        if (this.imageFiles != null) {
            sb5.append(" imageFiles: ");
            sb5.append(this.imageFiles);
        }
        if (this.shuoshuoPrivacy != null) {
            sb5.append(" shuoshuoPrivacy:");
            sb5.append(this.shuoshuoPrivacy.mood_permission);
        }
        sb5.append(" syncWeibo:");
        sb5.append(this.syncWeibo);
        sb5.append(" syncQQ:");
        sb5.append(this.syncQQ);
        if (this.promotionParams != null) {
            sb5.append(" promotionId:");
            sb5.append(this.promotionParams.getId());
            sb5.append(" promotionName:");
            sb5.append(this.promotionParams.getName());
        }
        sb5.append(" schoolName:");
        sb5.append(this.schoolName);
        sb5.append(" schoolIsSelected:");
        sb5.append(this.schoolIsSelected);
        sb5.append(" advJobId");
        sb5.append(this.advJobId);
        sb5.append(" photoQuality:");
        sb5.append(this.photoQuality);
        sb5.append("  publishTime;:");
        sb5.append(this.publishTime);
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeStringList(this.imageFiles);
        parcel.writeTypedList(this.mediaList);
        parcel.writeSerializable(this.extendParams);
        parcel.writeSerializable(this.shuoshuoPrivacy);
        parcel.writeParcelable(this.shuoshuoVideoInfo, i3);
        parcel.writeSerializable(this.richImageMap);
        parcel.writeParcelable(this.poiInfo, i3);
        parcel.writeParcelable(this.hiddenPoi, i3);
        parcel.writeByte(this.syncWeibo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.syncQQ ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.promotionParams, i3);
        parcel.writeString(this.schoolName);
        parcel.writeByte(this.schoolIsSelected ? (byte) 1 : (byte) 0);
        parcel.writeString(this.advJobId);
        parcel.writeByte(this.syncQzone ? (byte) 1 : (byte) 0);
        Map<String, String> map = this.shootParams;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(map.size());
            for (Map.Entry<String, String> entry : this.shootParams.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
        }
        parcel.writeSerializable(this.fontInfo);
        parcel.writeInt(this.photoQuality);
        parcel.writeLong(this.publishTime);
        parcel.writeLong(this.deleteTime);
        parcel.writeInt(this.priv);
        parcel.writeStringList(this.privUinList);
        parcel.writeString(this.extParam);
        parcel.writeParcelable(this.currentGps, i3);
        parcel.writeString(this.operationParams);
        parcel.writeInt(this.uploadEntrance);
        Map<String, byte[]> map2 = this.pasters;
        if (map2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(map2.size());
            for (Map.Entry<String, byte[]> entry2 : this.pasters.entrySet()) {
                parcel.writeString(entry2.getKey());
                parcel.writeByteArray(entry2.getValue());
            }
        }
        parcel.writeSerializable(this.peituEntryAndSource);
        Map<String, byte[]> map3 = this.marksUploadMap;
        if (map3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(map3.size());
            for (Map.Entry<String, byte[]> entry3 : this.marksUploadMap.entrySet()) {
                parcel.writeString(entry3.getKey());
                parcel.writeByteArray(entry3.getValue());
            }
        }
        Map<String, String> map4 = this.photoTagResult;
        if (map4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(map4.size());
            for (Map.Entry<String, String> entry4 : this.photoTagResult.entrySet()) {
                parcel.writeString(entry4.getKey());
                parcel.writeString(entry4.getValue());
            }
        }
        parcel.writeInt(this.subtype);
        parcel.writeString(this.refer);
        parcel.writeTypedList(this.mediaWrapperList);
        parcel.writeSerializable(this.picInfo);
        parcel.writeByte(this.isFromAIO ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.imageList);
        Map<String, String> map5 = this.storedExtendInfo;
        if (map5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(map5.size());
            for (Map.Entry<String, String> entry5 : this.storedExtendInfo.entrySet()) {
                parcel.writeString(entry5.getKey());
                parcel.writeString(entry5.getValue());
            }
        }
        parcel.writeByte(this.isVideoReady ? (byte) 1 : (byte) 0);
        parcel.writeString(this.missionID);
        parcel.writeInt(this.qcircleUpSource);
        parcel.writeInt(this.qcircleUpType);
        parcel.writeByte(this.isNeedVideoSave ? (byte) 1 : (byte) 0);
        parcel.writeList(this.selectedLabelInfos);
        parcel.writeByte(this.hasSelectCover ? (byte) 1 : (byte) 0);
        parcel.writeString(this.clientTraceId);
        parcel.writeStringList(this.groupId);
        parcel.writeStringList(this.uinId);
        parcel.writeByte(this.recommendTheSameCity ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.selectedJurisdiction ? (byte) 1 : (byte) 0);
        parcel.writeString(this.pubMusicMid);
        parcel.writeLong(this.pubMusicId);
        parcel.writeString(this.pubMusicName);
        parcel.writeLong(this.pubStartTime);
        parcel.writeString(this.mClientKey);
        parcel.writeByte(this.reExport ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.pubMusicScene);
        parcel.writeString(this.pubMusicAuthorUid);
        ArrayList<ArrayList<WinkPublishMediaRecord>> arrayList = this.mediaRecords;
        if (arrayList == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(arrayList.size());
            Iterator<ArrayList<WinkPublishMediaRecord>> it = this.mediaRecords.iterator();
            while (it.hasNext()) {
                parcel.writeTypedList(it.next());
            }
        }
        parcel.writeParcelable(this.config, i3);
        parcel.writeByte(this.isUseHDUpload ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mSchema);
        parcel.writeSerializable(this.datongParams);
        parcel.writeInt(this.mTaskBuildType);
        parcel.writeSerializable(this.mVideoEstimateSizeList);
        parcel.writeByte(this.isTrueUpload ? (byte) 1 : (byte) 0);
    }

    protected PublishUploadParams(Parcel parcel) {
        readFromParcel(parcel);
    }
}
