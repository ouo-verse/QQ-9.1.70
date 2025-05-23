package com.tencent.mobileqq.activity.guild;

import android.text.TextUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.base.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends e {
    @Override // com.tencent.mobileqq.guild.message.base.e
    public boolean a(MessageRecord messageRecord) {
        ArrayList<AtTroopMemberInfo> troopMemberInfoFromExtrJson;
        if (messageRecord == null) {
            return false;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST);
        if (!TextUtils.isEmpty(extInfoFromExtStr) && (troopMemberInfoFromExtrJson = MessageForText.getTroopMemberInfoFromExtrJson(extInfoFromExtStr)) != null) {
            Iterator<AtTroopMemberInfo> it = troopMemberInfoFromExtrJson.iterator();
            while (it.hasNext()) {
                if (it.next().flag == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.base.e
    public ArrayList<AtTroopMemberInfo> b(String str) {
        return MessageForText.getTroopMemberInfoFromExtrJson(str);
    }
}
