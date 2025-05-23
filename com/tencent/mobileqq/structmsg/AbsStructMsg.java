package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.an;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.s;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.realname.RealNameSource;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class AbsStructMsg implements Externalizable, g {
    static IPatchRedirector $redirector_;
    public static final String DEFAULT_MSG_BRIEF;
    public static final String PA_DEFAULT_MSG_BRIEF;
    public static int SOURCE_ACCOUNT_TYPE_PA;
    public String adverKey;
    public int adverSign;
    public String currentAccountUin;
    public int dynamicMsgMergeIndex;
    public String dynamicMsgMergeKey;
    public boolean forceDoNotCompress;
    public int forwardID;
    public int fwFlag;
    public String index;
    public String index_name;
    public String index_type;
    public String mAlgorithmIds;
    public String mArticleIds;
    public String mBirthReminder;
    public String mCommentText;
    public String mCommonData;
    public String mCompatibleText;
    public String mCreateTime;
    public boolean mEmptyMsgBriefModified;
    public String mExtraData;
    public String mFileName;
    public long mFileSize;
    int mFlag;
    public String mInnerUniqIds;
    public String mMergeSeq;
    public String mMsgAction;
    public String mMsgActionData;
    public String mMsgBrief;
    public String mMsgOldText;
    public int mMsgServiceID;
    public int mMsgTemplateID;
    public String mMsgUrl;
    public String mMsg_A_ActionData;
    public String mMsg_I_ActionData;
    public String mNeedRound;
    public String mOrangeWord;
    public int mPromotionMenuDestructiveIndex;
    public String mPromotionMenus;
    public String mPromotionMsg;
    public int mPromotionType;
    public String mQQStoryExtra;
    public String mQidianBulkTaskId;
    public String mQzoneExtraMsg;
    public String mResid;
    public String mSType;
    public long mSortKey;
    public String mSourceThirdName;
    public String mStrategyIds;
    public int mTSum;
    public String mTagName;
    public String mTribeShortVideoExtra;
    int mVersion;
    public MessageRecord message;
    public int messageVersion;
    public long msgId;
    public int multiMsgFlag;
    public long parentUniseq;
    public String readInjoy;
    public String reportEventFolderStatusValue;
    public String rijAlbumActionData;
    public int sourceAccoutType;
    public String source_puin;
    public String templateIDForPortal;
    public String uin;
    public int uinType;
    public long uniseq;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements XmlSerializer {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        XmlSerializer f290315a;

        public a(XmlSerializer xmlSerializer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsStructMsg.this, (Object) xmlSerializer);
            } else {
                this.f290315a = xmlSerializer;
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (XmlSerializer) iPatchRedirector.redirect((short) 16, this, str, str2, str3);
            }
            return this.f290315a.attribute(str, str2, str3);
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            } else {
                this.f290315a.cdsect(str);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            } else {
                this.f290315a.comment(str);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
            } else {
                this.f290315a.docdecl(str);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                this.f290315a.endDocument();
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (XmlSerializer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2);
            }
            return this.f290315a.endTag(str, str2);
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            } else {
                this.f290315a.entityRef(str);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void flush() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this);
            } else {
                this.f290315a.flush();
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public int getDepth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.f290315a.getDepth();
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public boolean getFeature(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
            }
            return this.f290315a.getFeature(str);
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.f290315a.getName();
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public String getNamespace() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.f290315a.getNamespace();
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public String getPrefix(String str, boolean z16) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16));
            }
            return this.f290315a.getPrefix(str, z16);
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public Object getProperty(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            return this.f290315a.getProperty(str);
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            } else {
                this.f290315a.ignorableWhitespace(str);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            } else {
                this.f290315a.processingInstruction(str);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void setFeature(String str, boolean z16) throws IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            } else {
                this.f290315a.setFeature(str, z16);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.f290315a.setOutput(outputStream, str);
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) outputStream, (Object) str);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f290315a.setPrefix(str, str2);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, obj);
            } else {
                this.f290315a.setProperty(str, obj);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) bool);
            } else {
                this.f290315a.startDocument(str, bool);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (XmlSerializer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
            }
            return this.f290315a.startTag(str, str2);
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public XmlSerializer text(@NonNull String str) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (XmlSerializer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            }
            try {
                return this.f290315a.text(s.c(str, false));
            } catch (Exception unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("StructMsg", 4, "XmlSerializer . text  IllegalArgumentException\u3002\u3002\u3002\u3002\u3002");
                }
                return this.f290315a.text("");
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.f290315a.setOutput(writer);
            } else {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) writer);
            }
        }

        @Override // org.xmlpull.v1.XmlSerializer
        public XmlSerializer text(char[] cArr, int i3, int i16) throws IOException, IllegalArgumentException, IllegalStateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.f290315a.text(cArr, i3, i16) : (XmlSerializer) iPatchRedirector.redirect((short) 19, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75470);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        DEFAULT_MSG_BRIEF = HardCodeUtil.qqStr(R.string.j0k);
        PA_DEFAULT_MSG_BRIEF = HardCodeUtil.qqStr(R.string.j0j);
        SOURCE_ACCOUNT_TYPE_PA = 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsStructMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mMsgTemplateID = -1;
        this.mMsgServiceID = -1;
        this.mMsgAction = "web";
        this.mMsgActionData = null;
        this.mMsg_A_ActionData = null;
        this.mMsg_I_ActionData = null;
        this.mMsgUrl = null;
        this.mMsgBrief = null;
        this.mEmptyMsgBriefModified = false;
        this.mCommentText = null;
        this.readInjoy = "QQ\u770b\u70b9";
        this.templateIDForPortal = "";
        this.mQzoneExtraMsg = null;
        this.mMsgOldText = null;
        this.mCompatibleText = "";
        this.fwFlag = 0;
        this.mVersion = 1;
        this.mResid = null;
        this.mFileName = null;
        this.mTSum = 0;
        this.mFileSize = 0L;
        this.multiMsgFlag = 0;
        this.mSType = null;
        this.mPromotionType = 0;
        this.mPromotionMsg = "";
        this.mPromotionMenus = "";
        this.mPromotionMenuDestructiveIndex = -1;
        this.dynamicMsgMergeKey = "";
        this.dynamicMsgMergeIndex = -1;
        this.source_puin = "";
        this.sourceAccoutType = 0;
        this.mSourceThirdName = null;
        this.msgId = 0L;
        this.mExtraData = null;
        this.mCreateTime = null;
        this.mTagName = null;
        this.mArticleIds = null;
        this.mOrangeWord = null;
        this.mAlgorithmIds = null;
        this.mStrategyIds = null;
        this.reportEventFolderStatusValue = null;
        this.mInnerUniqIds = null;
        this.mQQStoryExtra = null;
        this.mTribeShortVideoExtra = null;
        this.mNeedRound = null;
        this.mQidianBulkTaskId = null;
        this.mCommonData = null;
        this.mMergeSeq = null;
        this.mSortKey = 0L;
        this.rijAlbumActionData = null;
        this.mBirthReminder = null;
        this.forceDoNotCompress = AppSetting.B();
    }

    public static View getExceptionView(Context context, View view, an anVar, Bundle bundle, int i3) {
        return getExceptionView(context, view, anVar, bundle, context.getResources().getString(i3));
    }

    public static View getInCompatibleView(Context context, View view, String str) {
        if (view != null && (view instanceof RelativeLayout)) {
            ((RelativeLayout) view).removeAllViews();
        } else {
            view = new RelativeLayout(context);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view;
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(Color.parseColor("#000000"));
        int h16 = BaseChatItemLayout.h();
        int g16 = BaseChatItemLayout.g();
        relativeLayout.setBackgroundResource(R.drawable.f160240dy);
        textView.setPadding(h16, BaseChatItemLayout.W, g16, BaseChatItemLayout.f178043a0);
        relativeLayout.addView(textView, new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout;
    }

    public static View getVersionExceptionView(Context context, View view, an anVar, Bundle bundle) {
        return getExceptionView(context, view, anVar, bundle, R.string.f171483f94);
    }

    public boolean LayoutEquals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, obj)).booleanValue();
        }
        return super.equals(obj);
    }

    public void addFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        int i16 = this.mFlag;
        if ((i16 & i3) == i3) {
            return;
        }
        this.mFlag = i3 | i16;
    }

    public abstract byte[] getBytes();

    public abstract View getPreDialogView(Context context, View view);

    public abstract String getSourceName();

    public abstract View getSourceView(Context context, View view);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.widget.LinearLayout, android.view.View] */
    public View getView(Context context, View view, an anVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, anVar, bundle);
        }
        if (view == 0) {
            view = new LinearLayout(context);
            view.setOrientation(1);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(BaseChatItemLayout.f178058p0, -2);
            } else {
                layoutParams.width = BaseChatItemLayout.f178058p0;
                layoutParams.height = -2;
            }
            view.setLayoutParams(layoutParams);
        }
        return view;
    }

    public final String getXml() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toXml(byteArrayOutputStream, "UTF-8");
        try {
            return byteArrayOutputStream.toString("UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public final byte[] getXmlBytes() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toXml(byteArrayOutputStream, "UTF-8");
        if (QLog.isDevelopLevel()) {
            try {
                str = byteArrayOutputStream.toString("UTF-8");
            } catch (UnsupportedEncodingException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, e16.getMessage(), e16);
                }
                str = null;
            }
            QLog.d("StructMsg", 4, "Obj[" + System.identityHashCode(this) + "]getXmlBytes xmlStr:" + str);
        }
        int i3 = !isForceDoNotCompress() ? 1 : 0;
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 != 0) {
            byteArray = k.a(byteArray);
        }
        int length = byteArray.length;
        byte[] bArr = new byte[length + 1];
        bArr[0] = (byte) i3;
        System.arraycopy(byteArray, 0, bArr, 1, length);
        return bArr;
    }

    public boolean hasFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3)).booleanValue();
        }
        if ((this.mFlag & i3) == i3) {
            return true;
        }
        return false;
    }

    public boolean hasTSum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.mTSum > 0) {
            return true;
        }
        return false;
    }

    public boolean isForceDoNotCompress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseMsgAttrubutes(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jVar);
            return;
        }
        if (jVar == null) {
            return;
        }
        String a16 = jVar.a("templateID");
        if (!TextUtils.isEmpty(a16)) {
            this.mMsgTemplateID = Integer.parseInt(a16);
        }
        this.mMsgUrl = jVar.a("url");
        this.mMsgAction = jVar.a("action");
        this.mMsgActionData = jVar.a(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
        this.mMsg_A_ActionData = jVar.a(PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA);
        this.mMsg_I_ActionData = jVar.a(PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA);
        this.rijAlbumActionData = jVar.a("rijAlbumActionData");
        this.mQzoneExtraMsg = jVar.a("qzFloatExtra");
        String a17 = jVar.a("fwflag");
        if (!TextUtils.isEmpty(a17)) {
            try {
                this.fwFlag = Integer.parseInt(a17);
            } catch (NumberFormatException unused) {
            }
        }
        String a18 = jVar.a("flag");
        if (!TextUtils.isEmpty(a18)) {
            try {
                this.mFlag = Integer.parseInt(a18);
            } catch (NumberFormatException unused2) {
            }
        }
        String a19 = jVar.a("serviceID");
        if (!TextUtils.isEmpty(a19)) {
            this.mMsgServiceID = Integer.parseInt(a19);
        }
        this.mMsgBrief = jVar.a("brief");
        this.mResid = jVar.a("m_resid");
        this.mFileName = jVar.a("m_fileName");
        String a26 = jVar.a("tSum");
        if (!TextUtils.isEmpty(a26)) {
            this.mTSum = Integer.parseInt(a26);
        }
        String a27 = jVar.a("m_fileSize");
        if (!TextUtils.isEmpty(a27)) {
            try {
                this.mFileSize = Long.parseLong(a27);
            } catch (NumberFormatException unused3) {
            }
        }
        String a28 = jVar.a("promotionType");
        this.mPromotionMsg = jVar.a("promotionMsg");
        this.mPromotionMenus = jVar.a("promotionMenus");
        String a29 = jVar.a("promotionMenuDestructiveIndex");
        try {
            if (!TextUtils.isEmpty(a28)) {
                this.mPromotionType = Integer.parseInt(a28);
            }
            if (!TextUtils.isEmpty(a29)) {
                this.mPromotionMenuDestructiveIndex = Integer.parseInt(a29);
            }
        } catch (NumberFormatException unused4) {
        }
        String a36 = jVar.a("sourcePublicUin");
        this.source_puin = a36;
        if (a36 == null) {
            this.source_puin = "";
        }
        String a37 = jVar.a(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        this.mSourceThirdName = a37;
        if (a37 == null) {
            this.mSourceThirdName = "";
        }
        String a38 = jVar.a("sourceMsgId");
        try {
            if (!TextUtils.isEmpty(a38)) {
                this.msgId = Long.parseLong(a38);
            }
        } catch (NumberFormatException unused5) {
        }
        this.mSType = jVar.a("sType");
        String a39 = jVar.a("accostType");
        try {
            if (!TextUtils.isEmpty(a39)) {
                this.sourceAccoutType = Integer.parseInt(a39);
            }
        } catch (NumberFormatException unused6) {
        }
        String a46 = jVar.a("adverSign");
        try {
            if (!TextUtils.isEmpty(a46)) {
                this.adverSign = Integer.parseInt(a46);
            }
        } catch (NumberFormatException unused7) {
        }
        this.adverKey = jVar.a("adverKey");
        this.index = jVar.a("index");
        this.index_name = jVar.a("index_name");
        this.index_type = jVar.a("index_type");
        this.mExtraData = jVar.a(WadlProxyConsts.EXTRA_DATA);
        this.mCreateTime = jVar.a(WadlProxyConsts.CREATE_TIME);
        this.mTagName = jVar.a("tagName");
        this.mArticleIds = jVar.a("articleIds");
        this.mOrangeWord = jVar.a("orangeWord");
        this.mAlgorithmIds = jVar.a("algorithmIds");
        this.mStrategyIds = jVar.a("strategyIds");
        this.reportEventFolderStatusValue = jVar.a("reportEventFolderStatusValue");
        this.mQidianBulkTaskId = jVar.a("qf_task_id");
        this.mInnerUniqIds = jVar.a("uuids");
        this.mQQStoryExtra = jVar.a("qqstoryExtra");
        this.mTribeShortVideoExtra = jVar.a("qqtribeVideoInfoExtra");
        this.mNeedRound = jVar.a("needRoundView");
        this.mCommonData = jVar.a("msgCommonData");
        this.mMergeSeq = jVar.a("mergeSeq");
        String a47 = jVar.a("sortKey");
        try {
            if (!TextUtils.isEmpty(a47)) {
                this.mSortKey = Long.parseLong(a47);
            }
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
        int i3 = this.mMsgServiceID;
        if ((i3 == 142 || i3 == 500) && TextUtils.isEmpty(this.mExtraData) && !TextUtils.isEmpty(this.mMsgActionData)) {
            try {
                this.mExtraData = new JSONObject(this.mMsgActionData).getString("push_ext_data");
            } catch (Exception e17) {
                e17.getStackTrace();
            }
        }
        this.mBirthReminder = jVar.a("birthReminderMsg");
    }

    public void removeFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mFlag = (~i3) & this.mFlag;
        }
    }

    public void setFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mFlag = i3;
        }
    }

    protected abstract void toXml(ByteArrayOutputStream byteArrayOutputStream, String str);

    public static View getExceptionView(Context context, View view, an anVar, Bundle bundle, String str) {
        Resources resources = context.getResources();
        if (view != null && (view instanceof RelativeLayout)) {
            ((RelativeLayout) view).removeAllViews();
        } else {
            view = new RelativeLayout(context);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#777777"));
        int f16 = BaseAIOUtils.f(15.0f, resources);
        int f17 = BaseAIOUtils.f(7.5f, resources);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setBackgroundResource(R.drawable.f160240dy);
        relativeLayout2.setPadding(f16, f17, f16, f17);
        relativeLayout2.addView(textView);
        relativeLayout2.setId(R.id.j4s);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsStructMsg(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        this.mMsgTemplateID = -1;
        this.mMsgServiceID = -1;
        this.mMsgAction = "web";
        this.mMsgActionData = null;
        this.mMsg_A_ActionData = null;
        this.mMsg_I_ActionData = null;
        this.mMsgUrl = null;
        this.mMsgBrief = null;
        this.mEmptyMsgBriefModified = false;
        this.mCommentText = null;
        this.readInjoy = "QQ\u770b\u70b9";
        this.templateIDForPortal = "";
        this.mQzoneExtraMsg = null;
        this.mMsgOldText = null;
        this.mCompatibleText = "";
        this.fwFlag = 0;
        this.mVersion = 1;
        this.mResid = null;
        this.mFileName = null;
        this.mTSum = 0;
        this.mFileSize = 0L;
        this.multiMsgFlag = 0;
        this.mSType = null;
        this.mPromotionType = 0;
        this.mPromotionMsg = "";
        this.mPromotionMenus = "";
        this.mPromotionMenuDestructiveIndex = -1;
        this.dynamicMsgMergeKey = "";
        this.dynamicMsgMergeIndex = -1;
        this.source_puin = "";
        this.sourceAccoutType = 0;
        this.mSourceThirdName = null;
        this.msgId = 0L;
        this.mExtraData = null;
        this.mCreateTime = null;
        this.mTagName = null;
        this.mArticleIds = null;
        this.mOrangeWord = null;
        this.mAlgorithmIds = null;
        this.mStrategyIds = null;
        this.reportEventFolderStatusValue = null;
        this.mInnerUniqIds = null;
        this.mQQStoryExtra = null;
        this.mTribeShortVideoExtra = null;
        this.mNeedRound = null;
        this.mQidianBulkTaskId = null;
        this.mCommonData = null;
        this.mMergeSeq = null;
        this.mSortKey = 0L;
        this.rijAlbumActionData = null;
        this.mBirthReminder = null;
        this.forceDoNotCompress = AppSetting.B();
        this.mMsgTemplateID = 1;
        this.mMsgServiceID = 1;
        this.mMsgAction = "web";
        this.mMsgActionData = "";
        this.mMsgUrl = bundle.getString("detail_url");
        this.mQzoneExtraMsg = bundle.getString(AppConstants.Key.SHARE_REQ_QZONE_MSG);
        this.mMsg_A_ActionData = "";
        this.mCommentText = bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        String string = bundle.getString("source_puin");
        this.source_puin = string;
        if (string == null || string.equals("")) {
            this.source_puin = bundle.getString("struct_uin");
        }
        if (this.source_puin == null) {
            this.source_puin = "";
        }
        if (this.msgId == 0) {
            try {
                this.msgId = Long.parseLong(bundle.getString("strurt_msgid"));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsStructMsg(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar);
            return;
        }
        this.mMsgTemplateID = -1;
        this.mMsgServiceID = -1;
        this.mMsgAction = "web";
        this.mMsgActionData = null;
        this.mMsg_A_ActionData = null;
        this.mMsg_I_ActionData = null;
        this.mMsgUrl = null;
        this.mMsgBrief = null;
        this.mEmptyMsgBriefModified = false;
        this.mCommentText = null;
        this.readInjoy = "QQ\u770b\u70b9";
        this.templateIDForPortal = "";
        this.mQzoneExtraMsg = null;
        this.mMsgOldText = null;
        this.mCompatibleText = "";
        this.fwFlag = 0;
        this.mVersion = 1;
        this.mResid = null;
        this.mFileName = null;
        this.mTSum = 0;
        this.mFileSize = 0L;
        this.multiMsgFlag = 0;
        this.mSType = null;
        this.mPromotionType = 0;
        this.mPromotionMsg = "";
        this.mPromotionMenus = "";
        this.mPromotionMenuDestructiveIndex = -1;
        this.dynamicMsgMergeKey = "";
        this.dynamicMsgMergeIndex = -1;
        this.source_puin = "";
        this.sourceAccoutType = 0;
        this.mSourceThirdName = null;
        this.msgId = 0L;
        this.mExtraData = null;
        this.mCreateTime = null;
        this.mTagName = null;
        this.mArticleIds = null;
        this.mOrangeWord = null;
        this.mAlgorithmIds = null;
        this.mStrategyIds = null;
        this.reportEventFolderStatusValue = null;
        this.mInnerUniqIds = null;
        this.mQQStoryExtra = null;
        this.mTribeShortVideoExtra = null;
        this.mNeedRound = null;
        this.mQidianBulkTaskId = null;
        this.mCommonData = null;
        this.mMergeSeq = null;
        this.mSortKey = 0L;
        this.rijAlbumActionData = null;
        this.mBirthReminder = null;
        this.forceDoNotCompress = AppSetting.B();
        parseMsgAttrubutes(jVar);
    }
}
