package com.tencent.qqnt.troop.impl;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.TroopOperationRepo;
import com.tencent.qqnt.troop.e;
import com.tencent.qqnt.troop.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b2\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b~\u0010\u007fJ;\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J7\u0010\u0013\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J-\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J!\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J/\u0010\u001e\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J;\u0010!\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J/\u0010#\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J7\u0010&\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J7\u0010(\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010'\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J9\u0010*\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J5\u0010-\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J7\u00100\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020.2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J-\u00102\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u00101\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J1\u00104\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J/\u00106\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u00105\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001JI\u0010;\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u00107\u001a\u0004\u0018\u00010\u00062\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000608j\b\u0012\u0004\u0012\u00020\u0006`92\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J=\u0010>\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u00101\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J5\u0010@\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010=\u001a\u00020?2\u0006\u0010<\u001a\u00020?2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J-\u0010B\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010A\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J=\u0010D\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0016\u0010C\u001a\u0012\u0012\u0004\u0012\u00020$08j\b\u0012\u0004\u0012\u00020$`92\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J/\u0010F\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010E\u001a\u00020?2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J-\u0010H\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010G\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J-\u0010I\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010G\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J7\u0010J\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J7\u0010M\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010K\u001a\u0004\u0018\u00010\u00062\u0006\u0010L\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J/\u0010P\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010O\u001a\u00020N2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001JA\u0010S\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0006\u0010R\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001JI\u0010W\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J/\u0010X\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0096\u0001JW\u0010]\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010Y\u001a\u0004\u0018\u00010\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u00062\b\u0010[\u001a\u0004\u0018\u00010\u00062\b\u0010\\\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J#\u0010_\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J#\u0010`\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J\u001b\u0010b\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010a\u001a\u00020?H\u0096\u0001J\u001b\u0010d\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010c\u001a\u00020$H\u0096\u0001J\u0019\u0010f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010e\u001a\u00020?H\u0096\u0001J\u001b\u0010g\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u0010H\u0096\u0001J#\u0010h\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J\u001b\u0010i\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u0010H\u0096\u0001J\u001b\u0010j\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010k\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J#\u0010l\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J\u001b\u0010m\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u0010H\u0096\u0001J#\u0010o\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u00102\u0006\u0010n\u001a\u00020$H\u0096\u0001J\u001b\u0010q\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010p\u001a\u00020?H\u0096\u0001J\u001b\u0010r\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u0010H\u0096\u0001J#\u0010t\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010s\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J#\u0010v\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010u\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u001dH\u0096\u0001J\u001b\u0010x\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010w\u001a\u00020?H\u0096\u0001J\u001b\u0010z\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010y\u001a\u00020\u0010H\u0096\u0001J\u001b\u0010|\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010{\u001a\u00020\u0010H\u0096\u0001J\u001b\u0010}\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u0010H\u0096\u0001\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopOperationRepoApiImpl;", "Lcom/tencent/qqnt/troop/ITroopOperationRepoApi;", "Lcom/tencent/qqnt/bean/a;", "createParam", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "from", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "weakAct", "Lcom/tencent/qqnt/troop/b;", "asyncCallback", "", "createGroupV2", "groupCode", "", "holdMsg", "Lcom/tencent/qqnt/troop/i;", "destroyGroup", "Lcom/tencent/qqnt/bean/JoinTroopParam;", "joinTroopParam", "Lcom/tencent/qqnt/troop/d;", "callback", "joinGroup", "continueRequest", "joinGroupForSecurityBack", "troopUin", "isAllow", "Lcom/tencent/qqnt/troop/e;", "modifyAllowMemberInvite", "question", "answer", "modifyAnswerAndQuestion", "on", "modifyEnableHistoryForNewMember", "", "gameType", "modifyGameCardSwitch", "groupName", "modifyGroupName", "groupRemark", "modifyGroupRemark", "isAllowMemberInvite", "onlyInviteJoinTroop", "modifyOnlyTroopMemberInviteJoinTroop", "Lcom/tencent/mobileqq/data/troop/b;", "troopCard", "modifyTroopData", "joinTypeOpt", "modifyTroopJoinTypeFlag", "troopLocation", "modifyTroopLocation", "msgLimitFreq", "modifyTroopMsgLimitFreq", "intro", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "prefixWords", "modifyTroopNickRule", "privilegeMask", "privilegeFlag", "modifyTroopPayToJoinFlag", "", "modifyTroopPrivilegeFlag", "opt", "modifyTroopSearchType", "selectedGameIds", "modifyTroopSelectedGameId", "timestamp", "modifyTroopShutUpTime", "allowUpload", "modifyUploadTroopAlbum", "modifyUploadTroopFile", "quitGroup", "adminUin", "can", "setAdminCanRcvJoinMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "mask", "setGroupMsgMask", "memberUid", "cmd", "setGroupMsgMaskV2_0", "op", "type", "time", "setGroupMsgMaskV2_4", "setTroopIsActive", "oldOwnerUin", "oldOwnerUid", "newOwnerUin", "newOwnerUid", "transferGroup", "open", "updateAllowMemberInviteRobotSwitch", "updateAllowMemberModifyTroopName", "account", "updateAssociatePubAccount", "value", "updateFullGroupExpansionSwitch", "cmduinFlagEx3Grocery", "updateGameCardSwitch", "updateHonorAIOSwitch", "updateInviteRobotSwitch", "updateListenTogetherState", "updateLuckyCharFlag", "updateNewTroopState", "updateRobotMemberExamine", "updateShareLocationState", "flag", "updateTogetherBusinessFlag", "aioGuildId", "updateTroopAIOGuildId", "updateTroopAutoApproval", "essentialMsgPrivilege", "updateTroopEssencePrivilege", "essenceSwitch", "updateTroopEssenceSwitch", "guidId", "updateTroopGuildId", "isLive", "updateTroopLive", TransFileControllerImpl.VALUE_USE_PRE_CONN, "updateUseClassAvatar", "updateWatchTogetherState", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopOperationRepoApiImpl implements ITroopOperationRepoApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopOperationRepo $$delegate_0;

    public TroopOperationRepoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopOperationRepo.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void createGroupV2(@NotNull com.tencent.qqnt.bean.a createParam, @Nullable LifecycleOwner owner, @NotNull String from, @NotNull WeakReference<Activity> weakAct, @Nullable com.tencent.qqnt.troop.b asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, createParam, owner, from, weakAct, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(createParam, "createParam");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(weakAct, "weakAct");
        this.$$delegate_0.createGroupV2(createParam, owner, from, weakAct, asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void destroyGroup(@Nullable String groupCode, boolean holdMsg, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, groupCode, Boolean.valueOf(holdMsg), owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.destroyGroup(groupCode, holdMsg, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void joinGroup(@NotNull JoinTroopParam joinTroopParam, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable com.tencent.qqnt.troop.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, joinTroopParam, owner, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(joinTroopParam, "joinTroopParam");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.joinGroup(joinTroopParam, owner, from, callback);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void joinGroupForSecurityBack(@NotNull JoinTroopParam joinTroopParam, boolean continueRequest, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, joinTroopParam, Boolean.valueOf(continueRequest), from);
            return;
        }
        Intrinsics.checkNotNullParameter(joinTroopParam, "joinTroopParam");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.joinGroupForSecurityBack(joinTroopParam, continueRequest, from);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyAllowMemberInvite(@Nullable String troopUin, boolean isAllow, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, Boolean.valueOf(isAllow), owner, callback);
        } else {
            this.$$delegate_0.modifyAllowMemberInvite(troopUin, isAllow, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyAnswerAndQuestion(@Nullable String troopUin, @Nullable String question, @Nullable String answer, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, question, answer, owner, callback);
        } else {
            this.$$delegate_0.modifyAnswerAndQuestion(troopUin, question, answer, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyEnableHistoryForNewMember(@Nullable String troopUin, boolean on5, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, Boolean.valueOf(on5), owner, callback);
        } else {
            this.$$delegate_0.modifyEnableHistoryForNewMember(troopUin, on5, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyGameCardSwitch(@Nullable String troopUin, int gameType, boolean on5, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUin, Integer.valueOf(gameType), Boolean.valueOf(on5), owner, callback);
        } else {
            this.$$delegate_0.modifyGameCardSwitch(troopUin, gameType, on5, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyGroupName(@Nullable String groupCode, @NotNull String groupName, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, groupCode, groupName, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.modifyGroupName(groupCode, groupName, owner, from, asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyGroupRemark(@Nullable String groupCode, @Nullable String groupRemark, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, groupCode, groupRemark, owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.modifyGroupRemark(groupCode, groupRemark, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyOnlyTroopMemberInviteJoinTroop(@Nullable LifecycleOwner owner, @Nullable String groupCode, boolean isAllowMemberInvite, boolean onlyInviteJoinTroop, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, owner, groupCode, Boolean.valueOf(isAllowMemberInvite), Boolean.valueOf(onlyInviteJoinTroop), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.modifyOnlyTroopMemberInviteJoinTroop(owner, groupCode, isAllowMemberInvite, onlyInviteJoinTroop, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopData(@Nullable String troopUin, @NotNull com.tencent.mobileqq.data.troop.b troopCard, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, troopCard, owner, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopCard, "troopCard");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.modifyTroopData(troopUin, troopCard, owner, from, callback);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopJoinTypeFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, int joinTypeOpt, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, owner, groupCode, Integer.valueOf(joinTypeOpt), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.modifyTroopJoinTypeFlag(owner, groupCode, joinTypeOpt, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopLocation(@Nullable String troopUin, @Nullable String troopLocation, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, troopUin, troopLocation, owner, callback);
        } else {
            this.$$delegate_0.modifyTroopLocation(troopUin, troopLocation, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopMsgLimitFreq(@Nullable String troopUin, int msgLimitFreq, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, troopUin, Integer.valueOf(msgLimitFreq), owner, callback);
        } else {
            this.$$delegate_0.modifyTroopMsgLimitFreq(troopUin, msgLimitFreq, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopNickRule(@Nullable String troopUin, @Nullable String intro, @NotNull ArrayList<String> prefixWords, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, troopUin, intro, prefixWords, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(prefixWords, "prefixWords");
            this.$$delegate_0.modifyTroopNickRule(troopUin, intro, prefixWords, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopPayToJoinFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, int privilegeMask, int privilegeFlag, int joinTypeOpt, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, owner, groupCode, Integer.valueOf(privilegeMask), Integer.valueOf(privilegeFlag), Integer.valueOf(joinTypeOpt), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.modifyTroopPayToJoinFlag(owner, groupCode, privilegeMask, privilegeFlag, joinTypeOpt, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopPrivilegeFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, long privilegeFlag, long privilegeMask, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, owner, groupCode, Long.valueOf(privilegeFlag), Long.valueOf(privilegeMask), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.modifyTroopPrivilegeFlag(owner, groupCode, privilegeFlag, privilegeMask, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopSearchType(@Nullable LifecycleOwner owner, @Nullable String groupCode, int opt, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, owner, groupCode, Integer.valueOf(opt), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.modifyTroopSearchType(owner, groupCode, opt, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopSelectedGameId(@Nullable LifecycleOwner owner, @Nullable String groupCode, @NotNull ArrayList<Integer> selectedGameIds, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, owner, groupCode, selectedGameIds, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(selectedGameIds, "selectedGameIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$$delegate_0.modifyTroopSelectedGameId(owner, groupCode, selectedGameIds, callback);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopShutUpTime(@Nullable String troopUin, long timestamp, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, troopUin, Long.valueOf(timestamp), owner, callback);
        } else {
            this.$$delegate_0.modifyTroopShutUpTime(troopUin, timestamp, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyUploadTroopAlbum(@Nullable LifecycleOwner owner, @Nullable String groupCode, boolean allowUpload, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, owner, groupCode, Boolean.valueOf(allowUpload), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.modifyUploadTroopAlbum(owner, groupCode, allowUpload, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyUploadTroopFile(@Nullable LifecycleOwner owner, @Nullable String groupCode, boolean allowUpload, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, owner, groupCode, Boolean.valueOf(allowUpload), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.modifyUploadTroopFile(owner, groupCode, allowUpload, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void quitGroup(@Nullable String groupCode, boolean holdMsg, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, groupCode, Boolean.valueOf(holdMsg), owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.quitGroup(groupCode, holdMsg, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setAdminCanRcvJoinMsg(@Nullable String troopUin, @Nullable String adminUin, boolean can, @Nullable LifecycleOwner owner, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, troopUin, adminUin, Boolean.valueOf(can), owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.setAdminCanRcvJoinMsg(troopUin, adminUin, can, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setGroupMsgMask(@Nullable String troopUin, @NotNull GroupMsgMask mask, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, troopUin, mask, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(mask, "mask");
            this.$$delegate_0.setGroupMsgMask(troopUin, mask, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setGroupMsgMaskV2_0(@Nullable String troopUin, @Nullable String memberUid, int cmd, int mask, @Nullable LifecycleOwner owner, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, troopUin, memberUid, Integer.valueOf(cmd), Integer.valueOf(mask), owner, asyncCallback);
        } else {
            this.$$delegate_0.setGroupMsgMaskV2_0(troopUin, memberUid, cmd, mask, owner, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setGroupMsgMaskV2_4(@Nullable String troopUin, @Nullable String memberUid, int op5, int type, int time, @Nullable LifecycleOwner owner, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, troopUin, memberUid, Integer.valueOf(op5), Integer.valueOf(type), Integer.valueOf(time), owner, asyncCallback);
        } else {
            this.$$delegate_0.setGroupMsgMaskV2_4(troopUin, memberUid, op5, type, time, owner, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setTroopIsActive(@Nullable String troopUin, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, troopUin, owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.setTroopIsActive(troopUin, owner, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void transferGroup(@Nullable String groupCode, @Nullable String oldOwnerUin, @Nullable String oldOwnerUid, @Nullable String newOwnerUin, @Nullable String newOwnerUid, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, groupCode, oldOwnerUin, oldOwnerUid, newOwnerUin, newOwnerUid, owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.transferGroup(groupCode, oldOwnerUin, oldOwnerUid, newOwnerUin, newOwnerUid, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateAllowMemberInviteRobotSwitch(@Nullable String troopUin, int open, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, troopUin, Integer.valueOf(open), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.updateAllowMemberInviteRobotSwitch(troopUin, open, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateAllowMemberModifyTroopName(@Nullable String troopUin, int open, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, troopUin, Integer.valueOf(open), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.updateAllowMemberModifyTroopName(troopUin, open, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateAssociatePubAccount(@Nullable String troopUin, long account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, troopUin, Long.valueOf(account));
        } else {
            this.$$delegate_0.updateAssociatePubAccount(troopUin, account);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateFullGroupExpansionSwitch(@Nullable String troopUin, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) troopUin, value);
        } else {
            this.$$delegate_0.updateFullGroupExpansionSwitch(troopUin, value);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateGameCardSwitch(@NotNull String troopUin, long cmduinFlagEx3Grocery) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, troopUin, Long.valueOf(cmduinFlagEx3Grocery));
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.updateGameCardSwitch(troopUin, cmduinFlagEx3Grocery);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateHonorAIOSwitch(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, troopUin, Boolean.valueOf(open));
        } else {
            this.$$delegate_0.updateHonorAIOSwitch(troopUin, open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateInviteRobotSwitch(@Nullable String troopUin, int open, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, troopUin, Integer.valueOf(open), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.updateInviteRobotSwitch(troopUin, open, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateListenTogetherState(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, troopUin, Boolean.valueOf(open));
        } else {
            this.$$delegate_0.updateListenTogetherState(troopUin, open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateLuckyCharFlag(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, troopUin, Boolean.valueOf(open));
        } else {
            this.$$delegate_0.updateLuckyCharFlag(troopUin, open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateNewTroopState(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) troopUin);
        } else {
            this.$$delegate_0.updateNewTroopState(troopUin);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateRobotMemberExamine(@Nullable String troopUin, int open, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, troopUin, Integer.valueOf(open), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.updateRobotMemberExamine(troopUin, open, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateShareLocationState(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, troopUin, Boolean.valueOf(open));
        } else {
            this.$$delegate_0.updateShareLocationState(troopUin, open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTogetherBusinessFlag(@Nullable String troopUin, boolean open, int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, troopUin, Boolean.valueOf(open), Integer.valueOf(flag));
        } else {
            this.$$delegate_0.updateTogetherBusinessFlag(troopUin, open, flag);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopAIOGuildId(@Nullable String troopUin, long aioGuildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, troopUin, Long.valueOf(aioGuildId));
        } else {
            this.$$delegate_0.updateTroopAIOGuildId(troopUin, aioGuildId);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopAutoApproval(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, troopUin, Boolean.valueOf(open));
        } else {
            this.$$delegate_0.updateTroopAutoApproval(troopUin, open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopEssencePrivilege(@Nullable String troopUin, int essentialMsgPrivilege, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, troopUin, Integer.valueOf(essentialMsgPrivilege), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.updateTroopEssencePrivilege(troopUin, essentialMsgPrivilege, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopEssenceSwitch(@Nullable String troopUin, int essenceSwitch, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, troopUin, Integer.valueOf(essenceSwitch), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.updateTroopEssenceSwitch(troopUin, essenceSwitch, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopGuildId(@Nullable String troopUin, long guidId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, troopUin, Long.valueOf(guidId));
        } else {
            this.$$delegate_0.updateTroopGuildId(troopUin, guidId);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopLive(@Nullable String troopUin, boolean isLive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, troopUin, Boolean.valueOf(isLive));
        } else {
            this.$$delegate_0.updateTroopLive(troopUin, isLive);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateUseClassAvatar(@Nullable String troopUin, boolean use) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, troopUin, Boolean.valueOf(use));
        } else {
            this.$$delegate_0.updateUseClassAvatar(troopUin, use);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateWatchTogetherState(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, troopUin, Boolean.valueOf(open));
        } else {
            this.$$delegate_0.updateWatchTogetherState(troopUin, open);
        }
    }
}
