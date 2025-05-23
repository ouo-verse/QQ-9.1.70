package com.tencent.mobileqq.icgame.data.message;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LiveMessageData {
    public static final int ENTER_ROOM_MSG_TYPE = 3;
    public static final int MSG_ELEMENT_TEXT_TYPE = 1;
    public static final int NORMAL_CHAT_TEXT_MSG_TYPE = 1;
    public static final int SYSTEM_NOTICE_MESSAGE = 4;
    public int mMainRoomId;
    public String mMessageId;
    public int mMessageType;
    public LiveMsgExtInfo mMsgExtInfo;
    public String mRawTipStr;
    public int mSubRoomId;
    public SpeakerInfo mSpeakerInfo = new SpeakerInfo();
    public MsgContent msgContent = new MsgContent();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class ExtData {
        public int mId;
        public byte[] mValue;

        public ExtData() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class ImageElement {
        public String mImageUrl;

        public ImageElement() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class MsgContent {
        public ArrayList<MsgElement> mMsgElements = new ArrayList<>();
        public ArrayList<ExtData> mExtDatas = new ArrayList<>();

        public MsgContent() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class MsgElement {
        public int mElementType;
        public long mHideLogo;
        public ImageElement mImageMsg;
        public TextElement mTextMsg;

        public MsgElement() {
            this.mTextMsg = new TextElement();
            this.mImageMsg = new ImageElement();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class SpeakerInfo {
        public byte[] mBusinessData;
        public String mBusinessUid;
        public int mClientType;
        public String mLogo;
        public String mQunNick;
        public long mSpeakId;
        public String mSpeakerName;
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class TextElement {
        public byte[] mText;
        public String strText;

        public TextElement() {
        }
    }
}
