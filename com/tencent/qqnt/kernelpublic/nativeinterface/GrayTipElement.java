package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GrayTipElement implements Serializable {
    public AioOperateGrayTipElement aioOpGrayTipElement;
    public BlockGrayTipElement blockGrayTipElement;
    public BuddyGrayElement buddyElement;
    public EmojiReplyElement emojiReplyElement;
    public EssenceElement essenceElement;
    public FeedMsgElement feedMsgElement;
    public FileReceiptElement fileReceiptElement;
    public GroupGrayElement groupElement;
    public JsonGrayElement jsonGrayTipElement;
    public LocalGrayTipElement localGrayTipElement;
    public ProclamationElement proclamationElement;
    public RevokeElement revokeElement;
    long serialVersionUID = 1;
    public int subElementType;
    public WalletGrayTipElement walletGrayTipElement;
    public XmlElement xmlElement;

    public GrayTipElement() {
    }

    public AioOperateGrayTipElement getAioOpGrayTipElement() {
        return this.aioOpGrayTipElement;
    }

    public BlockGrayTipElement getBlockGrayTipElement() {
        return this.blockGrayTipElement;
    }

    public BuddyGrayElement getBuddyElement() {
        return this.buddyElement;
    }

    public EmojiReplyElement getEmojiReplyElement() {
        return this.emojiReplyElement;
    }

    public EssenceElement getEssenceElement() {
        return this.essenceElement;
    }

    public FeedMsgElement getFeedMsgElement() {
        return this.feedMsgElement;
    }

    public FileReceiptElement getFileReceiptElement() {
        return this.fileReceiptElement;
    }

    public GroupGrayElement getGroupElement() {
        return this.groupElement;
    }

    public JsonGrayElement getJsonGrayTipElement() {
        return this.jsonGrayTipElement;
    }

    public LocalGrayTipElement getLocalGrayTipElement() {
        return this.localGrayTipElement;
    }

    public ProclamationElement getProclamationElement() {
        return this.proclamationElement;
    }

    public RevokeElement getRevokeElement() {
        return this.revokeElement;
    }

    public int getSubElementType() {
        return this.subElementType;
    }

    public WalletGrayTipElement getWalletGrayTipElement() {
        return this.walletGrayTipElement;
    }

    public XmlElement getXmlElement() {
        return this.xmlElement;
    }

    public String toString() {
        return "GrayTipElement{subElementType=" + this.subElementType + ",revokeElement=" + this.revokeElement + ",proclamationElement=" + this.proclamationElement + ",emojiReplyElement=" + this.emojiReplyElement + ",groupElement=" + this.groupElement + ",buddyElement=" + this.buddyElement + ",feedMsgElement=" + this.feedMsgElement + ",essenceElement=" + this.essenceElement + ",xmlElement=" + this.xmlElement + ",fileReceiptElement=" + this.fileReceiptElement + ",localGrayTipElement=" + this.localGrayTipElement + ",blockGrayTipElement=" + this.blockGrayTipElement + ",aioOpGrayTipElement=" + this.aioOpGrayTipElement + ",jsonGrayTipElement=" + this.jsonGrayTipElement + ",walletGrayTipElement=" + this.walletGrayTipElement + ",}";
    }

    public GrayTipElement(int i3, RevokeElement revokeElement, ProclamationElement proclamationElement, EmojiReplyElement emojiReplyElement, GroupGrayElement groupGrayElement, BuddyGrayElement buddyGrayElement, FeedMsgElement feedMsgElement, EssenceElement essenceElement, XmlElement xmlElement, FileReceiptElement fileReceiptElement, LocalGrayTipElement localGrayTipElement, BlockGrayTipElement blockGrayTipElement, AioOperateGrayTipElement aioOperateGrayTipElement, JsonGrayElement jsonGrayElement, WalletGrayTipElement walletGrayTipElement) {
        this.subElementType = i3;
        this.revokeElement = revokeElement;
        this.proclamationElement = proclamationElement;
        this.emojiReplyElement = emojiReplyElement;
        this.groupElement = groupGrayElement;
        this.buddyElement = buddyGrayElement;
        this.feedMsgElement = feedMsgElement;
        this.essenceElement = essenceElement;
        this.xmlElement = xmlElement;
        this.fileReceiptElement = fileReceiptElement;
        this.localGrayTipElement = localGrayTipElement;
        this.blockGrayTipElement = blockGrayTipElement;
        this.aioOpGrayTipElement = aioOperateGrayTipElement;
        this.jsonGrayTipElement = jsonGrayElement;
        this.walletGrayTipElement = walletGrayTipElement;
    }
}
