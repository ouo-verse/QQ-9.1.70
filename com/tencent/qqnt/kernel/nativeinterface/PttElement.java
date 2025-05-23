package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PttElement implements IKernelModel {
    public int autoConvertText;
    public boolean canConvert2Text;
    public int duration;
    public Integer fileBizId;
    public Integer fileId;
    public String fileName;
    public String filePath;
    public long fileSize;
    public String fileSubId;
    public String fileUuid;
    public int formatType;
    public byte[] importRichMediaContext;
    public Integer invalidState;
    public String md5HexStr;
    public OtherBusinessInfo otherBusinessInfo;
    public Integer playState;
    public Integer progress;
    public int storeID;
    public String text;
    public Integer transferStatus;
    public Integer translateStatus;
    public int voiceChangeType;
    public int voiceType;
    public ArrayList<Byte> waveAmplitudes;

    public PttElement() {
        this.fileName = "";
        this.filePath = "";
        this.md5HexStr = "";
        this.waveAmplitudes = new ArrayList<>();
        this.fileSubId = "";
        this.otherBusinessInfo = new OtherBusinessInfo();
    }

    public int getAutoConvertText() {
        return this.autoConvertText;
    }

    public boolean getCanConvert2Text() {
        return this.canConvert2Text;
    }

    public int getDuration() {
        return this.duration;
    }

    public Integer getFileBizId() {
        return this.fileBizId;
    }

    public Integer getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileSubId() {
        return this.fileSubId;
    }

    public String getFileUuid() {
        return this.fileUuid;
    }

    public int getFormatType() {
        return this.formatType;
    }

    public byte[] getImportRichMediaContext() {
        return this.importRichMediaContext;
    }

    public Integer getInvalidState() {
        return this.invalidState;
    }

    public String getMd5HexStr() {
        return this.md5HexStr;
    }

    public OtherBusinessInfo getOtherBusinessInfo() {
        return this.otherBusinessInfo;
    }

    public Integer getPlayState() {
        return this.playState;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public String getText() {
        return this.text;
    }

    public Integer getTransferStatus() {
        return this.transferStatus;
    }

    public Integer getTranslateStatus() {
        return this.translateStatus;
    }

    public int getVoiceChangeType() {
        return this.voiceChangeType;
    }

    public int getVoiceType() {
        return this.voiceType;
    }

    public ArrayList<Byte> getWaveAmplitudes() {
        return this.waveAmplitudes;
    }

    public void setAutoConvertText(int i3) {
        this.autoConvertText = i3;
    }

    public void setCanConvert2Text(boolean z16) {
        this.canConvert2Text = z16;
    }

    public void setDuration(int i3) {
        this.duration = i3;
    }

    public void setFileBizId(Integer num) {
        this.fileBizId = num;
    }

    public void setFileId(Integer num) {
        this.fileId = num;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(long j3) {
        this.fileSize = j3;
    }

    public void setFileSubId(String str) {
        this.fileSubId = str;
    }

    public void setFileUuid(String str) {
        this.fileUuid = str;
    }

    public void setFormatType(int i3) {
        this.formatType = i3;
    }

    public void setImportRichMediaContext(byte[] bArr) {
        this.importRichMediaContext = bArr;
    }

    public void setInvalidState(Integer num) {
        this.invalidState = num;
    }

    public void setMd5HexStr(String str) {
        this.md5HexStr = str;
    }

    public void setOtherBusinessInfo(OtherBusinessInfo otherBusinessInfo) {
        this.otherBusinessInfo = otherBusinessInfo;
    }

    public void setPlayState(Integer num) {
        this.playState = num;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public void setStoreID(int i3) {
        this.storeID = i3;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTransferStatus(Integer num) {
        this.transferStatus = num;
    }

    public void setTranslateStatus(Integer num) {
        this.translateStatus = num;
    }

    public void setVoiceChangeType(int i3) {
        this.voiceChangeType = i3;
    }

    public void setVoiceType(int i3) {
        this.voiceType = i3;
    }

    public void setWaveAmplitudes(ArrayList<Byte> arrayList) {
        this.waveAmplitudes = arrayList;
    }

    public String toString() {
        return "PttElement{fileName=" + this.fileName + ",filePath=" + this.filePath + ",md5HexStr=" + this.md5HexStr + ",fileSize=" + this.fileSize + ",duration=" + this.duration + ",formatType=" + this.formatType + ",voiceType=" + this.voiceType + ",autoConvertText=" + this.autoConvertText + ",voiceChangeType=" + this.voiceChangeType + ",canConvert2Text=" + this.canConvert2Text + ",fileId=" + this.fileId + ",fileUuid=" + this.fileUuid + ",text=" + this.text + ",translateStatus=" + this.translateStatus + ",transferStatus=" + this.transferStatus + ",progress=" + this.progress + ",playState=" + this.playState + ",waveAmplitudes=" + this.waveAmplitudes + ",invalidState=" + this.invalidState + ",fileSubId=" + this.fileSubId + ",fileBizId=" + this.fileBizId + ",importRichMediaContext=" + this.importRichMediaContext + ",storeID=" + this.storeID + ",otherBusinessInfo=" + this.otherBusinessInfo + ",}";
    }

    public PttElement(String str, String str2, String str3, long j3, int i3, int i16, int i17, int i18, int i19, boolean z16, Integer num, String str4, String str5, Integer num2, Integer num3, Integer num4, Integer num5, ArrayList<Byte> arrayList, Integer num6, String str6, Integer num7, byte[] bArr, int i26) {
        this.fileName = "";
        this.filePath = "";
        this.md5HexStr = "";
        this.waveAmplitudes = new ArrayList<>();
        this.fileSubId = "";
        this.otherBusinessInfo = new OtherBusinessInfo();
        this.fileName = str;
        this.filePath = str2;
        this.md5HexStr = str3;
        this.fileSize = j3;
        this.duration = i3;
        this.formatType = i16;
        this.voiceType = i17;
        this.autoConvertText = i18;
        this.voiceChangeType = i19;
        this.canConvert2Text = z16;
        this.fileId = num;
        this.fileUuid = str4;
        this.text = str5;
        this.translateStatus = num2;
        this.transferStatus = num3;
        this.progress = num4;
        this.playState = num5;
        this.waveAmplitudes = arrayList;
        this.invalidState = num6;
        this.fileSubId = str6;
        this.fileBizId = num7;
        this.importRichMediaContext = bArr;
        this.storeID = i26;
    }
}
