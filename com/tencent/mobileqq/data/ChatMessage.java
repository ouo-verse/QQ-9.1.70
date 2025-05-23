package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.notColumn;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class ChatMessage extends MessageRecord {
    public static final int AIO_MARGIN_MSG_TYPE_DIFF = 1;
    public static final int AIO_MARGIN_MSG_TYPE_SAME = 0;
    public boolean hasPlayedDui;
    public boolean isAioAnimChecked;
    public boolean isDui;
    public boolean isFirstMsg;
    public boolean isFlowMessage;
    public boolean isShowQWalletPubAd;
    public boolean mIsParsed;
    private boolean mIsSentByXG;

    @Deprecated
    public CharSequence mMessageSource;
    public boolean mMsgAnimFlag;
    public long mMsgAnimTime;

    @Deprecated
    public boolean mNeedGrayTips;
    public boolean mNeedTimeStamp;
    public boolean mPendantAnimatable;

    @notColumn
    private int mViewHeight;
    public boolean mAnimFlag = false;
    public boolean mNewAnimFlag = false;
    public boolean isShowQIMStyleGroup = false;
    public boolean isShowQimStyleAvater = false;
    public boolean isShowTIMStyleGroup = false;
    public boolean isShowTimStyleAvater = false;

    @notColumn
    public Object redDotInfo = null;
    public int fakeSenderType = 0;
    private boolean isNeedCombine = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doParse();

    public ChatMsgRedDotInfo getChatMsgRedDotInfo() {
        if (this.redDotInfo == null) {
            this.redDotInfo = new ChatMsgRedDotInfo();
        }
        return (ChatMsgRedDotInfo) this.redDotInfo;
    }

    public String getSummaryMsg() {
        return this.f203106msg;
    }

    public int getViewHeight() {
        return this.mViewHeight;
    }

    public boolean isFollowMessage() {
        return this.isFlowMessage;
    }

    public boolean isNeedCombine() {
        return this.isNeedCombine;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean isSend() {
        int i3 = this.fakeSenderType;
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2 || this.isMultiMsg) {
            return false;
        }
        return super.isSend();
    }

    public boolean isSentByXG() {
        return this.mIsSentByXG;
    }

    public boolean isSupportReply() {
        return false;
    }

    public boolean needShowTimeStamp() {
        return true;
    }

    public void parse() {
        if (!this.mIsParsed) {
            synchronized (this) {
                if (!this.mIsParsed) {
                    doParse();
                    this.mIsParsed = true;
                }
            }
        }
    }

    public void reParse() {
        if (!this.mIsParsed) {
            return;
        }
        this.mIsParsed = false;
        parse();
    }

    public void setIsNeedCombine(boolean z16) {
        this.isNeedCombine = z16;
    }

    public void setIsSentByXG(boolean z16) {
        this.mIsSentByXG = z16;
    }

    public void setViewHeight(int i3) {
        this.mViewHeight = i3;
    }
}
