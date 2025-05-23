package com.tencent.mobileqq.troop.api;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IDiscussionService extends IRuntimeService {
    Object findDiscussionInfoByID(String str);

    Object findDiscussionInfoByID(String str, boolean z16);

    @Nullable
    String getDiscUinByTroopUin(String str);

    Object getDiscussList();

    int getDiscussionManager_COLLECT_MAX_Value();

    Object getDiscussionMemberInfo(String str, String str2);

    Object getDiscussionMemberInfoListByUin(String str);

    Object getDiscussionMemberInfoMapByUin(String str);

    Object getDiscussionMemberMapByUins(String[] strArr);

    String getDiscussionMemberName(String str, String str2);

    String getDiscussionMemberNickName(AppRuntime appRuntime, String str, String str2);

    int getDiscussionMemberNum(String str);

    String getDiscussionName(Context context, String str);

    String getDiscussionName(String str);

    int getFavoriteCount();

    void saveTroopAndDiscUinMap(String str, String str2);
}
