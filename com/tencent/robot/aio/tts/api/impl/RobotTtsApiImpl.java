package com.tencent.robot.aio.tts.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.TtsResBody$MsgTTSInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import com.tencent.robot.aio.tts.api.IRobotTtsApi;
import com.tencent.robot.aio.tts.api.impl.RobotTtsApiImpl;
import com.tencent.robot.api.IRobotProfileInfoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0002J*\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\nH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0012\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J(\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/aio/tts/api/impl/RobotTtsApiImpl;", "Lcom/tencent/robot/aio/tts/api/IRobotTtsApi;", "", "robotUin", "getOldVersionLocalPickTtsId", "ttsId", "", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "ttsList", "getTtsNameByTtsId", "Lkotlin/Function2;", "", "", "callback", "getLatestRobotTtsId", "clearOldVersionLocalPickTtsId", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTTSList;", "robotTTsList", "calculateCurrentTtsId", "calculateCurrentTtsName", "", "msgRandom", "msgSeq", "msgTime", "streamGroupId", "createAutoTtsMsgBytes", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotTtsApiImpl implements IRobotTtsApi {

    @NotNull
    private static final String KEY_TTS_ID = "key_pick_tts_id_";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLatestRobotTtsId$lambda$0(Function2 callback, RobotTtsApiImpl this$0, String robotUin, int i3, String str, GroupRobotProfile groupRobotProfile) {
        RobotTTSList robotTTSList;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Integer valueOf = Integer.valueOf(i3);
        if (groupRobotProfile != null) {
            robotTTSList = groupRobotProfile.ttsList;
        } else {
            robotTTSList = null;
        }
        callback.invoke(valueOf, this$0.calculateCurrentTtsId(robotUin, robotTTSList));
    }

    private final String getOldVersionLocalPickTtsId(String robotUin) {
        boolean z16;
        String str;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString(KEY_TTS_ID + str + "_" + robotUin, "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(\"${K\u2026rrentUin}_$robotUin\", \"\")");
        return decodeString;
    }

    private final String getTtsNameByTtsId(String ttsId, List<TtsInfo> ttsList) {
        boolean z16;
        Object obj;
        String str;
        boolean z17 = false;
        if (ttsId != null && ttsId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        List<TtsInfo> list = ttsList;
        if (list == null || list.isEmpty()) {
            z17 = true;
        }
        if (z17) {
            return "";
        }
        Iterator<T> it = ttsList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TtsInfo ttsInfo = (TtsInfo) next;
            if (ttsInfo != null) {
                obj = ttsInfo.ttsId;
            }
            if (Intrinsics.areEqual(obj, ttsId)) {
                obj = next;
                break;
            }
        }
        TtsInfo ttsInfo2 = (TtsInfo) obj;
        if (ttsInfo2 == null || (str = ttsInfo2.ttsName) == null) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "it.ttsName ?: \"\"");
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r2 == true) goto L46;
     */
    @Override // com.tencent.robot.aio.tts.api.IRobotTtsApi
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String calculateCurrentTtsId(@Nullable String robotUin, @Nullable RobotTTSList robotTTsList) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        boolean z19;
        boolean z26 = true;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || robotTTsList == null) {
            return "";
        }
        String str2 = robotTTsList.pickTtsId;
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            String str3 = robotTTsList.pickTtsId;
            Intrinsics.checkNotNullExpressionValue(str3, "robotTTsList.pickTtsId");
            return str3;
        }
        String oldVersionLocalPickTtsId = getOldVersionLocalPickTtsId(robotUin);
        if (oldVersionLocalPickTtsId.length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            ArrayList<TtsInfo> arrayList = robotTTsList.ttsList;
            if (arrayList != null) {
                if (!arrayList.isEmpty()) {
                    for (TtsInfo ttsInfo : arrayList) {
                        if (ttsInfo != null) {
                            str = ttsInfo.ttsId;
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str, oldVersionLocalPickTtsId)) {
                            z19 = true;
                            break;
                        }
                    }
                }
                z19 = false;
            }
            z26 = false;
            if (z26) {
                return oldVersionLocalPickTtsId;
            }
        }
        String str4 = robotTTsList.defaultTtsId;
        if (str4 == null) {
            return "";
        }
        return str4;
    }

    @Override // com.tencent.robot.aio.tts.api.IRobotTtsApi
    @NotNull
    public String calculateCurrentTtsName(@Nullable String robotUin, @Nullable RobotTTSList robotTTsList) {
        boolean z16;
        boolean z17;
        String qqStr;
        boolean z18 = false;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && robotTTsList != null) {
            String ttsNameByTtsId = getTtsNameByTtsId(robotTTsList.pickTtsId, robotTTsList.ttsList);
            if (ttsNameByTtsId.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                ttsNameByTtsId = getTtsNameByTtsId(getOldVersionLocalPickTtsId(robotUin), robotTTsList.ttsList);
            }
            if (ttsNameByTtsId.length() == 0) {
                z18 = true;
            }
            if (z18) {
                if (TextUtils.isEmpty(robotTTsList.pickTtsId)) {
                    qqStr = getTtsNameByTtsId(robotTTsList.defaultTtsId, robotTTsList.ttsList);
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f223616gp);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "{\n                HardCo\u2026timbre_vas)\n            }");
                }
                return qqStr;
            }
            return ttsNameByTtsId;
        }
        return "";
    }

    @Override // com.tencent.robot.aio.tts.api.IRobotTtsApi
    public void clearOldVersionLocalPickTtsId(@Nullable String robotUin) {
        boolean z16;
        String str;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.removeKey(KEY_TTS_ID + str + "_" + robotUin);
    }

    @Override // com.tencent.robot.aio.tts.api.IRobotTtsApi
    @NotNull
    public String createAutoTtsMsgBytes(long msgRandom, long msgSeq, long msgTime, int streamGroupId) {
        TtsResBody$MsgTTSInfo ttsResBody$MsgTTSInfo = new TtsResBody$MsgTTSInfo();
        ttsResBody$MsgTTSInfo.msg_rand.set(msgRandom);
        ttsResBody$MsgTTSInfo.msg_nt_seq.set(msgSeq);
        ttsResBody$MsgTTSInfo.msg_time.set(msgTime);
        ttsResBody$MsgTTSInfo.stream_group_id.set(streamGroupId);
        String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(ttsResBody$MsgTTSInfo.toByteArray(), 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(msgTTSInf\u2026ay(), Base64Util.NO_WRAP)");
        return encodeToString;
    }

    @Override // com.tencent.robot.aio.tts.api.IRobotTtsApi
    public void getLatestRobotTtsId(@NotNull final String robotUin, @NotNull final Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfoFromServer(robotUin, null, new IGetGroupRobotProfileCallback() { // from class: c34.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                RobotTtsApiImpl.getLatestRobotTtsId$lambda$0(Function2.this, this, robotUin, i3, str, groupRobotProfile);
            }
        });
    }
}
