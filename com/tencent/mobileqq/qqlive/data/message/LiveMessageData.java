package com.tencent.mobileqq.qqlive.data.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import sq3.b;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveMessageData {
    static IPatchRedirector $redirector_ = null;
    public static final int ENTER_ROOM_MSG_TYPE = 3;
    public static final int MSG_ELEMENT_TEXT_TYPE = 1;
    public static final int NORMAL_CHAT_TEXT_MSG_TYPE = 1;
    public static final int SYSTEM_NOTICE_MESSAGE = 4;
    public int mMainRoomId;
    public String mMessageId;
    public int mMessageType;
    public LiveMsgExtInfo mMsgExtInfo;
    public String mRawTipStr;
    public SpeakerInfo mSpeakerInfo;
    public int mSubRoomId;
    public MsgContent msgContent;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class ExtData {
        static IPatchRedirector $redirector_;
        public int mId;
        public byte[] mValue;

        public ExtData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveMessageData.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class ImageElement {
        static IPatchRedirector $redirector_;
        public String mImageUrl;

        public ImageElement() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveMessageData.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class MsgContent {
        static IPatchRedirector $redirector_;
        public ArrayList<ExtData> mExtDatas;
        public ArrayList<MsgElement> mMsgElements;

        public MsgContent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveMessageData.this);
            } else {
                this.mMsgElements = new ArrayList<>();
                this.mExtDatas = new ArrayList<>();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class MsgElement {
        static IPatchRedirector $redirector_;
        public int mElementType;
        public long mHideLogo;
        public ImageElement mImageMsg;
        public TextElement mTextMsg;

        public MsgElement() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveMessageData.this);
            } else {
                this.mTextMsg = new TextElement();
                this.mImageMsg = new ImageElement();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class SpeakerInfo {
        static IPatchRedirector $redirector_;
        public byte[] mBusinessData;
        public String mBusinessUid;
        public int mClientType;
        public String mLogo;
        public String mQunNick;
        public long mSpeakId;
        public String mSpeakerName;

        public SpeakerInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static SpeakerInfo from(b bVar) {
            SpeakerInfo speakerInfo = new SpeakerInfo();
            speakerInfo.mSpeakId = bVar.f434233a;
            speakerInfo.mSpeakerName = bVar.f434238f;
            speakerInfo.mLogo = new String(bVar.f434241i, Charset.forName("UTF-8"));
            speakerInfo.mClientType = bVar.f434237e;
            speakerInfo.mBusinessUid = bVar.f434243k;
            speakerInfo.mBusinessData = bVar.f434240h;
            return speakerInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class TextElement {
        static IPatchRedirector $redirector_;
        public byte[] mText;
        public String strText;

        public TextElement() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveMessageData.this);
            }
        }
    }

    public LiveMessageData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSpeakerInfo = new SpeakerInfo();
            this.msgContent = new MsgContent();
        }
    }
}
