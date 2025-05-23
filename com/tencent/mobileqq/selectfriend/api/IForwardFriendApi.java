package com.tencent.mobileqq.selectfriend.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectfriend.model.FSLayoutData;
import com.tencent.mobileqq.selectfriend.model.b;
import com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.model.a;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007H&J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H&J<\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&J*\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000fH&JF\u0010'\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u001a\u0010&\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u0004\u0012\u00020\t0#H&JH\u0010(\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u001a\u0010&\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u0004\u0012\u00020\t0#H&J6\u0010)\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u000f2\u001a\u0010&\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u0004\u0012\u00020\t0#H&J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020%H&J&\u00100\u001a\u0012\u0012\u0004\u0012\u00020+0.j\b\u0012\u0004\u0012\u00020+`/2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0$H&J\u0010\u00101\u001a\u00020%2\u0006\u0010*\u001a\u00020+H&\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/IForwardFriendApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", "caller", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "Landroid/os/Bundle;", "fsForwardData", "", "requestCode", "", "startForwardFriendActivityForResult", "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "fsLayoutData", "Lcom/tencent/mobileqq/selectfriend/model/b;", "fsEventDelegate", "", "useRelationSectionedNodeList", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "model", "Lcom/tencent/mobileqq/selectfriend/relationlist/BaseRelationSectionedNodeList;", "getUserList", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "isShowRecentChatList", "isMatchFriendUserList", "Landroid/content/Intent;", "intent", "getRecentUserModel", "businessType", "businessSubType", "getTopayUserModel", "showRobotGroup", "getGroupdFriendModel", "shouldShowGuild", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "callback", "getFrowardAndRecent", "getRecentUserListData", "getFrowardListData", "sharedNode", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "getResultRecordFromSharedNode", "sharedNodes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getResultRecordsFromSharedNodes", "getSharedNodeFromResultRecord", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IForwardFriendApi extends QRouteApi {
    void getFrowardAndRecent(@Nullable Intent intent, boolean shouldShowGuild, boolean isShowRecentChatList, boolean isMatchFriendUserList, @NotNull Function1<? super List<SharedNode>, Unit> callback);

    void getFrowardListData(@Nullable Intent intent, boolean shouldShowGuild, @NotNull Function1<? super List<SharedNode>, Unit> callback);

    @NotNull
    a getGroupdFriendModel(boolean showRobotGroup);

    void getRecentUserListData(@Nullable Intent intent, boolean shouldShowGuild, boolean isShowRecentChatList, boolean isMatchFriendUserList, @NotNull Function1<? super List<SharedNode>, Unit> callback);

    @NotNull
    a getRecentUserModel(@NotNull Activity activity, boolean isShowRecentChatList, boolean isMatchFriendUserList, @Nullable Intent intent);

    @Nullable
    ResultRecord getResultRecordFromSharedNode(@NotNull SharedNode sharedNode);

    @NotNull
    ArrayList<ResultRecord> getResultRecordsFromSharedNodes(@NotNull List<SharedNode> sharedNodes);

    @NotNull
    SharedNode getSharedNodeFromResultRecord(@NotNull ResultRecord sharedNode);

    @NotNull
    a getTopayUserModel(int businessType, int businessSubType);

    @NotNull
    BaseRelationSectionedNodeList getUserList(@NotNull Context context, @NotNull a model);

    void startForwardFriendActivityForResult(@NotNull Activity caller, @Nullable FSForwardData<Bundle> fsForwardData, int requestCode);

    void startForwardFriendActivityForResult(@NotNull Activity caller, @Nullable FSForwardData<Bundle> fsForwardData, @Nullable FSLayoutData fsLayoutData, int requestCode);

    void startForwardFriendActivityForResult(@NotNull Activity caller, @Nullable FSForwardData<Bundle> fsForwardData, @Nullable FSLayoutData fsLayoutData, @Nullable b fsEventDelegate, int requestCode);

    void startForwardFriendActivityForResult(@NotNull Activity caller, @Nullable FSForwardData<Bundle> fsForwardData, @Nullable b fsEventDelegate, int requestCode);

    boolean useRelationSectionedNodeList();
}
