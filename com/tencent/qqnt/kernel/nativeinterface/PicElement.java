package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* loaded from: classes24.dex */
public final class PicElement implements IKernelModel {
    public String downloadIndex;
    public EmojiAD emojiAd;
    public Integer emojiFrom;
    public EmojiMall emojiMall;
    public String emojiWebUrl;
    public EmojiZPlan emojiZplan;
    public Integer fileBizId;
    public String fileName;
    public long fileSize;
    public String fileSubId;
    public String fileUuid;
    public byte[] importRichMediaContext;
    public Integer invalidState;
    public Boolean isFlashPic;
    public String md5HexStr;
    public String originImageMd5;
    public String originImageUrl;
    public boolean original;
    public int picHeight;
    public Integer picSubSubType;
    public int picSubType;
    public Integer picType;
    public int picWidth;
    public Integer progress;
    public String sourcePath;
    public int storeID;
    public String summary;
    public int templateID;
    public int thumbFileSize;
    public HashMap<Integer, String> thumbPath;
    public Integer transferStatus;

    public PicElement() {
        this.fileName = "";
        this.md5HexStr = "";
        this.fileUuid = "";
        this.fileSubId = "";
        this.originImageMd5 = "";
    }

    public String getDownloadIndex() {
        return this.downloadIndex;
    }

    public EmojiAD getEmojiAd() {
        return this.emojiAd;
    }

    public Integer getEmojiFrom() {
        return this.emojiFrom;
    }

    public EmojiMall getEmojiMall() {
        return this.emojiMall;
    }

    public String getEmojiWebUrl() {
        return this.emojiWebUrl;
    }

    public EmojiZPlan getEmojiZplan() {
        return this.emojiZplan;
    }

    public Integer getFileBizId() {
        return this.fileBizId;
    }

    public String getFileName() {
        return this.fileName;
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

    public byte[] getImportRichMediaContext() {
        return this.importRichMediaContext;
    }

    public Integer getInvalidState() {
        return this.invalidState;
    }

    public Boolean getIsFlashPic() {
        return this.isFlashPic;
    }

    public String getMd5HexStr() {
        return this.md5HexStr;
    }

    public String getOriginImageMd5() {
        return this.originImageMd5;
    }

    public String getOriginImageUrl() {
        return this.originImageUrl;
    }

    public boolean getOriginal() {
        return this.original;
    }

    public int getPicHeight() {
        return this.picHeight;
    }

    public Integer getPicSubSubType() {
        return this.picSubSubType;
    }

    public int getPicSubType() {
        return this.picSubType;
    }

    public Integer getPicType() {
        return this.picType;
    }

    public int getPicWidth() {
        return this.picWidth;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public String getSummary() {
        return this.summary;
    }

    public int getTemplateID() {
        return this.templateID;
    }

    public int getThumbFileSize() {
        return this.thumbFileSize;
    }

    public HashMap<Integer, String> getThumbPath() {
        return this.thumbPath;
    }

    public Integer getTransferStatus() {
        return this.transferStatus;
    }

    public void setDownloadIndex(String str) {
        this.downloadIndex = str;
    }

    public void setEmojiAd(EmojiAD emojiAD) {
        this.emojiAd = emojiAD;
    }

    public void setEmojiFrom(Integer num) {
        this.emojiFrom = num;
    }

    public void setEmojiMall(EmojiMall emojiMall) {
        this.emojiMall = emojiMall;
    }

    public void setEmojiWebUrl(String str) {
        this.emojiWebUrl = str;
    }

    public void setEmojiZplan(EmojiZPlan emojiZPlan) {
        this.emojiZplan = emojiZPlan;
    }

    public void setFileBizId(Integer num) {
        this.fileBizId = num;
    }

    public void setFileName(String str) {
        this.fileName = str;
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

    public void setImportRichMediaContext(byte[] bArr) {
        this.importRichMediaContext = bArr;
    }

    public void setInvalidState(Integer num) {
        this.invalidState = num;
    }

    public void setIsFlashPic(Boolean bool) {
        this.isFlashPic = bool;
    }

    public void setMd5HexStr(String str) {
        this.md5HexStr = str;
    }

    public void setOriginImageMd5(String str) {
        this.originImageMd5 = str;
    }

    public void setOriginImageUrl(String str) {
        this.originImageUrl = str;
    }

    public void setOriginal(boolean z16) {
        this.original = z16;
    }

    public void setPicHeight(int i3) {
        this.picHeight = i3;
    }

    public void setPicSubSubType(Integer num) {
        this.picSubSubType = num;
    }

    public void setPicSubType(int i3) {
        this.picSubType = i3;
    }

    public void setPicType(Integer num) {
        this.picType = num;
    }

    public void setPicWidth(int i3) {
        this.picWidth = i3;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public void setSourcePath(String str) {
        this.sourcePath = str;
    }

    public void setStoreID(int i3) {
        this.storeID = i3;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTemplateID(int i3) {
        this.templateID = i3;
    }

    public void setThumbFileSize(int i3) {
        this.thumbFileSize = i3;
    }

    public void setThumbPath(HashMap<Integer, String> hashMap) {
        this.thumbPath = hashMap;
    }

    public void setTransferStatus(Integer num) {
        this.transferStatus = num;
    }

    public String toString() {
        return "PicElement{picSubType=" + this.picSubType + ",picSubSubType=" + this.picSubSubType + ",fileName=" + this.fileName + ",fileSize=" + this.fileSize + ",picWidth=" + this.picWidth + ",picHeight=" + this.picHeight + ",original=" + this.original + ",md5HexStr=" + this.md5HexStr + ",sourcePath=" + this.sourcePath + ",thumbPath=" + this.thumbPath + ",transferStatus=" + this.transferStatus + ",progress=" + this.progress + ",picType=" + this.picType + ",invalidState=" + this.invalidState + ",fileUuid=" + this.fileUuid + ",fileSubId=" + this.fileSubId + ",thumbFileSize=" + this.thumbFileSize + ",fileBizId=" + this.fileBizId + ",downloadIndex=" + this.downloadIndex + ",summary=" + this.summary + ",emojiFrom=" + this.emojiFrom + ",emojiWebUrl=" + this.emojiWebUrl + ",emojiAd=" + this.emojiAd + ",emojiMall=" + this.emojiMall + ",emojiZplan=" + this.emojiZplan + ",originImageMd5=" + this.originImageMd5 + ",originImageUrl=" + this.originImageUrl + ",importRichMediaContext=" + this.importRichMediaContext + ",isFlashPic=" + this.isFlashPic + ",storeID=" + this.storeID + ",templateID=" + this.templateID + ",}";
    }

    public PicElement(int i3, String str, long j3, int i16, int i17, boolean z16, String str2, String str3, HashMap<Integer, String> hashMap, Integer num, Integer num2, Integer num3, Integer num4, String str4, String str5, int i18, Integer num5, String str6, String str7, Integer num6, String str8, EmojiAD emojiAD, EmojiMall emojiMall, EmojiZPlan emojiZPlan, String str9, String str10, byte[] bArr, Boolean bool, int i19) {
        this.picSubType = i3;
        this.fileName = str;
        this.fileSize = j3;
        this.picWidth = i16;
        this.picHeight = i17;
        this.original = z16;
        this.md5HexStr = str2;
        this.sourcePath = str3;
        this.thumbPath = hashMap;
        this.transferStatus = num;
        this.progress = num2;
        this.picType = num3;
        this.invalidState = num4;
        this.fileUuid = str4;
        this.fileSubId = str5;
        this.thumbFileSize = i18;
        this.fileBizId = num5;
        this.downloadIndex = str6;
        this.summary = str7;
        this.emojiFrom = num6;
        this.emojiWebUrl = str8;
        this.emojiAd = emojiAD;
        this.emojiMall = emojiMall;
        this.emojiZplan = emojiZPlan;
        this.originImageMd5 = str9;
        this.originImageUrl = str10;
        this.importRichMediaContext = bArr;
        this.isFlashPic = bool;
        this.storeID = i19;
    }
}
