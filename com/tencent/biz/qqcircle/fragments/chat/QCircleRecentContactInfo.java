package com.tencent.biz.qqcircle.fragments.chat;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.videochat.a;
import com.tencent.qqnt.emotion.constant.b;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.graytips.util.f;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleRecentContactInfo implements QCircleRecentDataInterface {

    @NonNull
    private final RecentContactInfo mRecentContactInfo;

    public QCircleRecentContactInfo(@NonNull RecentContactInfo recentContactInfo) {
        this.mRecentContactInfo = recentContactInfo;
    }

    private String getShowNickName(@NonNull RecentContactInfo recentContactInfo) {
        if (recentContactInfo.getAnonymousFlag() != null && recentContactInfo.getAnonymousFlag().intValue() != 0) {
            return "";
        }
        if (!TextUtils.isEmpty(recentContactInfo.getSendRemarkName())) {
            return recentContactInfo.getSendRemarkName();
        }
        if (!TextUtils.isEmpty(recentContactInfo.getSendMemberName())) {
            return recentContactInfo.getSendMemberName();
        }
        if (!TextUtils.isEmpty(recentContactInfo.getSendNickName())) {
            return recentContactInfo.getSendNickName();
        }
        if (recentContactInfo.getSenderUin() == 0) {
            return "";
        }
        return String.valueOf(recentContactInfo.getSenderUin());
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public long getContactId() {
        return this.mRecentContactInfo.getContactId();
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public String getDataString() {
        return "QCircleRecentContactInfo{titleName =" + getTitleName() + ", uin=" + getRecentUserUin() + ", uid=" + getRecentUserUid() + ", contactId=" + getContactId() + ", unCont=" + getUnreadNum() + ", displayTime=" + getDisplayTime() + '}';
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public long getDisplayTime() {
        return this.mRecentContactInfo.getMsgTime();
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public String getExtraInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public byte[] getGiftInfo() {
        return new byte[0];
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public CharSequence getLastMsg(Context context) {
        int i3;
        ArrayList<MsgAbstractElement> abstractContent = this.mRecentContactInfo.getAbstractContent();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (abstractContent != null && abstractContent.size() > 0) {
            Iterator<MsgAbstractElement> it = abstractContent.iterator();
            while (it.hasNext()) {
                MsgAbstractElement next = it.next();
                if (next != null) {
                    int elementType = next.getElementType();
                    int intValue = next.getElementSubType().intValue();
                    if (elementType == 6 && next.getIndex() != null) {
                        if (intValue == 5) {
                            spannableStringBuilder.append((CharSequence) next.getContent());
                        } else {
                            spannableStringBuilder.append(((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).createEmojiSpanText(intValue, next.getIndex().intValue(), 0, false, b.b()));
                        }
                    } else if (elementType == 8) {
                        if (this.mRecentContactInfo.getAnonymousFlag() != null) {
                            i3 = this.mRecentContactInfo.getAnonymousFlag().intValue();
                        } else {
                            i3 = 0;
                        }
                        spannableStringBuilder.append(f.d(context, MobileQQ.sMobileQQ.peekAppRuntime(), next, next.getGrayTiPElement(), this.mRecentContactInfo.getPeerUid(), this.mRecentContactInfo.getSenderUid(), getShowNickName(this.mRecentContactInfo), this.mRecentContactInfo.getChatType(), 8, i3));
                    } else if (elementType == 21) {
                        CharSequence a16 = a.f352344a.a(context, QCircleServiceImpl.getAppRunTime(), intValue, next.getContent());
                        if (!TextUtils.isEmpty(a16)) {
                            spannableStringBuilder.append(a16);
                        }
                    } else if (elementType == 3) {
                        spannableStringBuilder.append((CharSequence) next.getContent()).append((CharSequence) next.getFileName());
                    } else {
                        spannableStringBuilder.append((CharSequence) next.getContent());
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public MessageRecord getMessageRecord() {
        return null;
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public CharSequence getMsgExtraInfo() {
        return null;
    }

    public RecentContactInfo getRecentContactInfo() {
        return this.mRecentContactInfo;
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public String getRecentUserUid() {
        return this.mRecentContactInfo.getPeerUid();
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public String getRecentUserUin() {
        return String.valueOf(this.mRecentContactInfo.getPeerUin());
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public String getShowTime() {
        return HostStaticInvokeHelper.getMsgDateTime(this.mRecentContactInfo.getMsgTime() * 1000);
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public String getTitleName() {
        String peerName = this.mRecentContactInfo.getPeerName();
        if (TextUtils.isEmpty(peerName)) {
            return String.valueOf(this.mRecentContactInfo.getPeerUin());
        }
        return peerName;
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public int getUnreadNum() {
        return (int) this.mRecentContactInfo.getUnreadCnt();
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public void update() {
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface
    public void setGiftInfo(byte[] bArr) {
    }
}
