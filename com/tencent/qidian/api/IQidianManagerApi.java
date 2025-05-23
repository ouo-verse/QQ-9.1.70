package com.tencent.qidian.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes22.dex */
public interface IQidianManagerApi extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(boolean z16, HashMap<String, Object> hashMap);
    }

    void addQidianShareAction(Context context, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList);

    void addShowUin(String str, String str2);

    void clearQidianCache();

    boolean filterQidianMasterSearch(Friends friends, int i3);

    String getShowUin(String str);

    boolean isCrmMaster(int i3);

    boolean isCrmMasterUin(String str);

    boolean isEmanMsg(MessageRecord messageRecord);

    boolean isNeedClickReply(String str, String str2, String str3);

    boolean isQidianAio(String str);

    boolean isQidianExt(int i3);

    boolean isQidianMaster(int i3);

    boolean isQidianMaster(String str);

    void requestQidianTroopShareInfo(AppInterface appInterface, String str, String str2, a aVar);

    void shareToQidianOrQiye(Activity activity, int i3, String str, String str2, String str3, String str4, String str5, int i16, boolean z16);

    void updateQidianAccountType(int i3, String str);

    void updateQidianAccountType(Friends friends);

    void updateQidianAccountType(Friends[] friendsArr);
}
