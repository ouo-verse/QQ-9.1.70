package com.tencent.mobileqq.data;

import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MarkFaceMessage implements Serializable {
    public static final long serialVersionUID = 102222;
    public ArrayList<MarketFaceSupportSize> apngSupportSize;
    public String backColor;
    public String copywritingContent;
    public int dwTabID;
    public String from;
    public String jumpUrl;
    public byte[] mobileparam;
    public byte[] resvAttr;
    public byte[] sbfKey;
    public byte[] sbufID;
    public ArrayList<MarketFaceSupportSize> supportSize;
    public List<Integer> voicePrintItems;
    public String volumeColor;
    public long index = 0;
    public String faceName = null;
    public int dwMSGItemType = 6;
    public int cFaceInfo = 1;
    public int wSize = 37;
    public int cSubType = 3;
    public int mediaType = 0;
    public int imageWidth = 0;
    public int imageHeight = 0;
    public boolean isReword = false;
    public int copywritingType = 0;
    public boolean shouldDisplay = false;
    public long beginTime = 0;
    public long endTime = 0;
    public StickerInfo stickerInfo = null;
    public boolean isAPNG = false;
    public boolean hasIpProduct = false;
    public boolean showIpProduct = false;

    public String toString() {
        return "MarkFaceMessage{index=" + this.index + ", faceName='" + this.faceName + "', dwMSGItemType=" + this.dwMSGItemType + ", cFaceInfo=" + this.cFaceInfo + ", wSize=" + this.wSize + ", sbufID=" + Arrays.toString(this.sbufID) + ", dwTabID=" + this.dwTabID + ", cSubType=" + this.cSubType + ", hasIpProduct=" + this.hasIpProduct + ", showIpProduct=" + this.showIpProduct + ", sbfKey=" + Arrays.toString(this.sbfKey) + ", mediaType=" + this.mediaType + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", mobileparam=" + Arrays.toString(this.mobileparam) + ", resvAttr=" + Arrays.toString(this.resvAttr) + ", isReword=" + this.isReword + ", copywritingType=" + this.copywritingType + ", copywritingContent='" + this.copywritingContent + "', jumpUrl='" + this.jumpUrl + "', shouldDisplay=" + this.shouldDisplay + ", stickerInfo=" + this.stickerInfo + '}';
    }
}
