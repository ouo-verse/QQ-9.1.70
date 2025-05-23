package com.tencent.mobileqq.qqlive.room.multichat.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    private static long a() {
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo;
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(0L);
        if (J3 == null || (anchorRoomInfo = J3.getAnchorRoomInfo()) == null || (qQLiveAnchorDataUserInfo = anchorRoomInfo.userDta) == null) {
            return 0L;
        }
        return qQLiveAnchorDataUserInfo.f271213id;
    }

    private static long b(long j3) {
        IAudienceRoom y16 = ((jg4.b) mm4.b.b(jg4.b.class)).y(j3);
        if (y16 != null && y16.getAnchorInfo() != null) {
            return y16.getAnchorInfo().getAnchorUid();
        }
        return 0L;
    }

    private static long c(long j3) {
        IAudienceRoom y16 = ((jg4.b) mm4.b.b(jg4.b.class)).y(j3);
        ILiveRoom z16 = ((jg4.b) mm4.b.b(jg4.b.class)).z(0L);
        if (z16 == null) {
            return -1L;
        }
        long enterRoomTime = z16.getEnterRoomTime();
        if (enterRoomTime == 0 && (y16 instanceof ILiveRoom)) {
            return y16.getEnterRoomTime();
        }
        return enterRoomTime;
    }

    private static String d(long j3) {
        IAudienceRoom y16 = ((jg4.b) mm4.b.b(jg4.b.class)).y(j3);
        if (y16 != null && y16.getRoomInfo() != null) {
            return y16.getRoomInfo().getProgramId();
        }
        return "";
    }

    public static ConcurrentHashMap<String, String> e(long j3) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_user_id", h() + "");
        concurrentHashMap.put("qqlive_anchor_id", a() + "");
        concurrentHashMap.put("qqlive_room_id", j3 + "");
        concurrentHashMap.put("qqlive_program_id", g() + "");
        concurrentHashMap.put("qqlive_zhibo_type", "1");
        concurrentHashMap.put("qqlive_zhibo_content", "3");
        return concurrentHashMap;
    }

    public static ConcurrentHashMap<String, String> f(long j3, LiveRoomExtraInfo liveRoomExtraInfo) {
        long j16;
        String str;
        String str2;
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_user_id", h() + "");
        concurrentHashMap.put("qqlive_anchor_id", b(j3) + "");
        concurrentHashMap.put("qqlive_room_id", j3 + "");
        concurrentHashMap.put("qqlive_program_id", d(j3) + "");
        concurrentHashMap.put("qqlive_enter_id", "" + h() + "_" + j3 + "_" + c(j3));
        concurrentHashMap.put("qqlive_zhibo_type", "1");
        concurrentHashMap.put("qqlive_zhibo_content", "3");
        if (liveRoomExtraInfo != null) {
            str = liveRoomExtraInfo.C;
            j16 = liveRoomExtraInfo.f376296m;
            str2 = liveRoomExtraInfo.E.getString("rcmd_context");
            String str3 = liveRoomExtraInfo.D;
            if (TextUtils.isEmpty(str2)) {
                str2 = str3;
            }
        } else {
            j16 = -1;
            str = "";
            str2 = str;
        }
        concurrentHashMap.put("qqlive_coming_way", str + "");
        concurrentHashMap.put("qqlive_start_source", j16 + "");
        concurrentHashMap.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, str2 + "");
        return concurrentHashMap;
    }

    private static String g() {
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(0L);
        if (J3 == null || (anchorRoomInfo = J3.getAnchorRoomInfo()) == null || (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) == null) {
            return "";
        }
        return qQLiveAnchorDataRoomInfo.programId;
    }

    private static long h() {
        LiveUserInfo selfUserInfo = ((jg4.b) mm4.b.b(jg4.b.class)).getSelfUserInfo();
        if (selfUserInfo == null) {
            return 0L;
        }
        return selfUserInfo.uid;
    }
}
