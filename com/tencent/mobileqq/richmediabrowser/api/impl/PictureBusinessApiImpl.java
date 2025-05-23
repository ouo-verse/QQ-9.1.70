package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.text.TextUtils;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.richmediabrowser.api.IPictureBusinessApi;
import com.tencent.mobileqq.richmediabrowser.j;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import java.io.Externalizable;

/* loaded from: classes35.dex */
public class PictureBusinessApiImpl implements IPictureBusinessApi {
    @Override // com.tencent.mobileqq.richmediabrowser.api.IPictureBusinessApi
    public String getActionDataFromStructMsg(Externalizable externalizable) {
        if (!(externalizable instanceof StructMsgForImageShare)) {
            return null;
        }
        StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) externalizable;
        if (j.d(structMsgForImageShare.mMsgActionData)) {
            if (!TextUtils.isEmpty(structMsgForImageShare.mMsg_A_ActionData) && structMsgForImageShare.mMsg_A_ActionData.indexOf("|") > 0) {
                return "comic_plugin.apk|" + structMsgForImageShare.mMsg_A_ActionData;
            }
            return structMsgForImageShare.mMsgActionData;
        }
        if (j.e(structMsgForImageShare.mMsgActionData)) {
            return structMsgForImageShare.mMsgActionData;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IPictureBusinessApi
    public String[] parseQQComicParams(Externalizable externalizable) {
        StructMsgForImageShare structMsgForImageShare;
        String str;
        if (!(externalizable instanceof StructMsgForImageShare) || (str = (structMsgForImageShare = (StructMsgForImageShare) externalizable).mMsgActionData) == null || !str.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID)) {
            return null;
        }
        String str2 = structMsgForImageShare.mMsgActionData;
        String[] split = str2.substring(str2.indexOf("|") + 1).split("\\|");
        boolean z16 = split.length >= 8 && (split[7].equals(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK) || split[7].equals("scrawl_link"));
        if (!z16 && !TextUtils.isEmpty(structMsgForImageShare.mMsg_A_ActionData)) {
            split = structMsgForImageShare.mMsg_A_ActionData.split("\\|");
            z16 = split.length >= 8 && split[7].equals(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
        }
        if (z16) {
            return split;
        }
        return null;
    }
}
