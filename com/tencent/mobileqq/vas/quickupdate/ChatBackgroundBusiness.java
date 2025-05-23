package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ChatBackgroundBusiness extends QQVasUpdateBusiness {
    public static final Long BID = 8L;

    public static String getIdFromPath(String str) {
        Matcher matcher = Pattern.compile("chatbg\\.[0-9]+").matcher(str);
        if (!matcher.find()) {
            return "";
        }
        return matcher.group(0).replace(VasUpdateConstants.SCID_CHATBG_PREFIX, "");
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return BID.longValue();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "chat_back_ground";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "business";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String[] getNecessaryFiles() {
        return new String[]{"aioImage"};
    }

    public String getPicturePath(int i3) {
        return getSavePath(i3) + File.separator + "aioImage";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return VasUpdateConstants.SCID_CHATBG_PREFIX + i3;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return QQVasUpdateBusiness.isEnableFileCheck(getBid());
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExists(int i3) {
        if (super.isFileExists(i3) && new File(getPicturePath(i3)).exists()) {
            return true;
        }
        return false;
    }
}
