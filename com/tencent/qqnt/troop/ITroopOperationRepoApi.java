package com.tencent.qqnt.troop;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b$\bg\u0018\u00002\u00020\u0001J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J,\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H&J6\u0010\u001a\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0019H&J8\u0010\u001c\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0019H&JV\u0010!\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0019H&J6\u0010#\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0019H&J6\u0010$\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0019H&J@\u0010*\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0019H&JH\u0010.\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020'2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0019H&J.\u00101\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010)\u001a\u00020/2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&J4\u00105\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u0010\u0012\u001a\u000200H&J,\u00107\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u00106\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&J,\u00109\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u000200H&J,\u0010:\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u000200H&J,\u0010<\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010;\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&J<\u0010=\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020'2\u0006\u00103\u001a\u00020'2\u0006\u0010;\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&J<\u0010A\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020'0>j\b\u0012\u0004\u0012\u00020'`?2\u0006\u0010\u0012\u001a\u000200H&J4\u0010D\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u000200H&J.\u0010F\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010E\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&J:\u0010I\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010G\u001a\u0004\u0018\u00010\u00062\b\u0010H\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&J.\u0010K\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010J\u001a\u0002022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&J6\u0010N\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&J.\u0010O\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010M\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&J.\u0010Q\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010P\u001a\u00020'2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&JH\u0010T\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010R\u001a\u0004\u0018\u00010\u00062\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u00060>j\b\u0012\u0004\u0012\u00020\u0006`?2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&J0\u0010V\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010U\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u000100H&J6\u0010Y\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010W\u001a\u0004\u0018\u00010\u00062\u0006\u0010X\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u000200H&J6\u0010\\\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010[\u001a\u00020Z2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u000100H&J.\u0010]\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u000100H&J\"\u0010_\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&J\"\u0010a\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010`\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&J\u001a\u0010c\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010b\u001a\u000202H&J\u001a\u0010e\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010d\u001a\u00020\u0014H&J\u001a\u0010g\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u0014H&J\u001a\u0010i\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010h\u001a\u00020\u0014H&J\u0012\u0010j\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010k\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u0014H&J\u001a\u0010l\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u0014H&J\u001a\u0010m\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u0014H&J\"\u0010o\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u00142\u0006\u0010n\u001a\u00020'H&J\u001a\u0010p\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u0014H&J\u001a\u0010r\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010q\u001a\u000202H&J\u001a\u0010t\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010s\u001a\u000202H&J\u001a\u0010u\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u0014H&J\"\u0010v\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&J\u0018\u0010x\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010w\u001a\u000202H&J\u001a\u0010z\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010y\u001a\u00020'H&J\"\u0010{\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&J\"\u0010|\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&J\"\u0010}\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020'2\u0006\u0010\u0012\u001a\u000200H&\u00a8\u0006~"}, d2 = {"Lcom/tencent/qqnt/troop/ITroopOperationRepoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/bean/a;", "createParam", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "from", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "weakAct", "Lcom/tencent/qqnt/troop/b;", "asyncCallback", "", "createGroupV2", "Lcom/tencent/qqnt/bean/JoinTroopParam;", "joinTroopParam", "Lcom/tencent/qqnt/troop/d;", "callback", "joinGroup", "", "continueRequest", "joinGroupForSecurityBack", "groupCode", "groupName", "Lcom/tencent/qqnt/troop/i;", "modifyGroupName", "groupRemark", "modifyGroupRemark", "oldOwnerUin", "oldOwnerUid", "newOwnerUin", "newOwnerUid", "transferGroup", "holdMsg", "destroyGroup", "quitGroup", "troopUin", "memberUid", "", "cmd", "mask", "setGroupMsgMaskV2_0", "op", "type", "time", "setGroupMsgMaskV2_4", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "Lcom/tencent/qqnt/troop/e;", "setGroupMsgMask", "", "privilegeFlag", "privilegeMask", "modifyTroopPrivilegeFlag", "opt", "modifyTroopSearchType", "allowUpload", "modifyUploadTroopFile", "modifyUploadTroopAlbum", "joinTypeOpt", "modifyTroopJoinTypeFlag", "modifyTroopPayToJoinFlag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedGameIds", "modifyTroopSelectedGameId", "isAllowMemberInvite", "onlyInviteJoinTroop", "modifyOnlyTroopMemberInviteJoinTroop", "isAllow", "modifyAllowMemberInvite", "question", "answer", "modifyAnswerAndQuestion", "timestamp", "modifyTroopShutUpTime", "gameType", "on", "modifyGameCardSwitch", "modifyEnableHistoryForNewMember", "msgLimitFreq", "modifyTroopMsgLimitFreq", "intro", "prefixWords", "modifyTroopNickRule", "troopLocation", "modifyTroopLocation", "adminUin", "can", "setAdminCanRcvJoinMsg", "Lcom/tencent/mobileqq/data/troop/b;", "troopCard", "modifyTroopData", "setTroopIsActive", "essenceSwitch", "updateTroopEssenceSwitch", "essentialMsgPrivilege", "updateTroopEssencePrivilege", "guidId", "updateTroopGuildId", "isLive", "updateTroopLive", "open", "updateTroopAutoApproval", TransFileControllerImpl.VALUE_USE_PRE_CONN, "updateUseClassAvatar", "updateNewTroopState", "updateListenTogetherState", "updateWatchTogetherState", "updateShareLocationState", "flag", "updateTogetherBusinessFlag", "updateLuckyCharFlag", "aioGuildId", "updateTroopAIOGuildId", "account", "updateAssociatePubAccount", "updateHonorAIOSwitch", "updateInviteRobotSwitch", "cmduinFlagEx3Grocery", "updateGameCardSwitch", "value", "updateFullGroupExpansionSwitch", "updateRobotMemberExamine", "updateAllowMemberInviteRobotSwitch", "updateAllowMemberModifyTroopName", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopOperationRepoApi extends QRouteApi {
    void createGroupV2(@NotNull com.tencent.qqnt.bean.a createParam, @Nullable LifecycleOwner owner, @NotNull String from, @NotNull WeakReference<Activity> weakAct, @Nullable b asyncCallback);

    void destroyGroup(@Nullable String groupCode, boolean holdMsg, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void joinGroup(@NotNull JoinTroopParam joinTroopParam, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable d callback);

    void joinGroupForSecurityBack(@NotNull JoinTroopParam joinTroopParam, boolean continueRequest, @NotNull String from);

    void modifyAllowMemberInvite(@Nullable String troopUin, boolean isAllow, @Nullable LifecycleOwner owner, @Nullable e callback);

    void modifyAnswerAndQuestion(@Nullable String troopUin, @Nullable String question, @Nullable String answer, @Nullable LifecycleOwner owner, @Nullable e callback);

    void modifyEnableHistoryForNewMember(@Nullable String troopUin, boolean on5, @Nullable LifecycleOwner owner, @Nullable e callback);

    void modifyGameCardSwitch(@Nullable String troopUin, int gameType, boolean on5, @Nullable LifecycleOwner owner, @Nullable e callback);

    void modifyGroupName(@Nullable String groupCode, @NotNull String groupName, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void modifyGroupRemark(@Nullable String groupCode, @Nullable String groupRemark, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void modifyOnlyTroopMemberInviteJoinTroop(@Nullable LifecycleOwner owner, @Nullable String groupCode, boolean isAllowMemberInvite, boolean onlyInviteJoinTroop, @NotNull e callback);

    void modifyTroopData(@Nullable String troopUin, @NotNull com.tencent.mobileqq.data.troop.b troopCard, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable e callback);

    void modifyTroopJoinTypeFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, int joinTypeOpt, @NotNull e callback);

    void modifyTroopLocation(@Nullable String troopUin, @Nullable String troopLocation, @Nullable LifecycleOwner owner, @Nullable e callback);

    void modifyTroopMsgLimitFreq(@Nullable String troopUin, int msgLimitFreq, @Nullable LifecycleOwner owner, @Nullable e callback);

    void modifyTroopNickRule(@Nullable String troopUin, @Nullable String intro, @NotNull ArrayList<String> prefixWords, @Nullable LifecycleOwner owner, @Nullable e callback);

    void modifyTroopPayToJoinFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, int privilegeMask, int privilegeFlag, int joinTypeOpt, @NotNull e callback);

    void modifyTroopPrivilegeFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, long privilegeFlag, long privilegeMask, @NotNull e callback);

    void modifyTroopSearchType(@Nullable LifecycleOwner owner, @Nullable String groupCode, int opt, @NotNull e callback);

    void modifyTroopSelectedGameId(@Nullable LifecycleOwner owner, @Nullable String groupCode, @NotNull ArrayList<Integer> selectedGameIds, @NotNull e callback);

    void modifyTroopShutUpTime(@Nullable String troopUin, long timestamp, @Nullable LifecycleOwner owner, @Nullable e callback);

    void modifyUploadTroopAlbum(@Nullable LifecycleOwner owner, @Nullable String groupCode, boolean allowUpload, @NotNull e callback);

    void modifyUploadTroopFile(@Nullable LifecycleOwner owner, @Nullable String groupCode, boolean allowUpload, @NotNull e callback);

    void quitGroup(@Nullable String groupCode, boolean holdMsg, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void setAdminCanRcvJoinMsg(@Nullable String troopUin, @Nullable String adminUin, boolean can, @Nullable LifecycleOwner owner, @NotNull e callback);

    void setGroupMsgMask(@Nullable String troopUin, @NotNull GroupMsgMask mask, @Nullable LifecycleOwner owner, @Nullable e callback);

    void setGroupMsgMaskV2_0(@Nullable String troopUin, @Nullable String memberUid, int cmd, int mask, @Nullable LifecycleOwner owner, @Nullable i asyncCallback);

    void setGroupMsgMaskV2_4(@Nullable String troopUin, @Nullable String memberUid, int op5, int type, int time, @Nullable LifecycleOwner owner, @Nullable i asyncCallback);

    void setTroopIsActive(@Nullable String troopUin, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable e callback);

    void transferGroup(@Nullable String groupCode, @Nullable String oldOwnerUin, @Nullable String oldOwnerUid, @Nullable String newOwnerUin, @Nullable String newOwnerUid, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void updateAllowMemberInviteRobotSwitch(@Nullable String troopUin, int open, @NotNull e callback);

    void updateAllowMemberModifyTroopName(@Nullable String troopUin, int open, @NotNull e callback);

    void updateAssociatePubAccount(@Nullable String troopUin, long account);

    void updateFullGroupExpansionSwitch(@Nullable String troopUin, int value);

    void updateGameCardSwitch(@NotNull String troopUin, long cmduinFlagEx3Grocery);

    void updateHonorAIOSwitch(@Nullable String troopUin, boolean open);

    void updateInviteRobotSwitch(@Nullable String troopUin, int open, @NotNull e callback);

    void updateListenTogetherState(@Nullable String troopUin, boolean open);

    void updateLuckyCharFlag(@Nullable String troopUin, boolean open);

    void updateNewTroopState(@Nullable String troopUin);

    void updateRobotMemberExamine(@Nullable String troopUin, int open, @NotNull e callback);

    void updateShareLocationState(@Nullable String troopUin, boolean open);

    void updateTogetherBusinessFlag(@Nullable String troopUin, boolean open, int flag);

    void updateTroopAIOGuildId(@Nullable String troopUin, long aioGuildId);

    void updateTroopAutoApproval(@Nullable String troopUin, boolean open);

    void updateTroopEssencePrivilege(@Nullable String troopUin, int essentialMsgPrivilege, @NotNull e callback);

    void updateTroopEssenceSwitch(@Nullable String troopUin, int essenceSwitch, @NotNull e callback);

    void updateTroopGuildId(@Nullable String troopUin, long guidId);

    void updateTroopLive(@Nullable String troopUin, boolean isLive);

    void updateUseClassAvatar(@Nullable String troopUin, boolean use);

    void updateWatchTogetherState(@Nullable String troopUin, boolean open);
}
