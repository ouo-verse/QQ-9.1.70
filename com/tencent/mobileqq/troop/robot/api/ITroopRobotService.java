package com.tencent.mobileqq.troop.robot.api;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$RobotSubscribeCategory;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x934.cmd0x934$RspBody;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopRobotService extends IRuntimeService {
    public static final String C2C_FAKE_TROOP_UIN = "1";
    public static final String ITEM_EMOJI = "emoji";
    public static final String ITEM_IMAGE = "image";
    public static final String ITEM_VOICE = "voice";
    public static final int REQ_TIME_OUT = 12000;
    public static final String ROBOT_NEWS_CLASS_ID = "robot_news_class_id";
    public static final String ROBOT_SHORT_LINK_DESCRIPTION = "robot_short_link_description";
    public static final String ROBOT_SHORT_LINK_PROCESSED = "robot_processed";
    public static final String ROBOT_SHORT_LINK_URL = "robot_short_link_url";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(int i3, cmd0x934$RspBody cmd0x934_rspbody);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(String str, String str2, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public long f298293a;

        /* renamed from: b, reason: collision with root package name */
        public long f298294b;

        public String toString() {
            return " s:" + this.f298293a + " e:" + this.f298294b;
        }
    }

    boolean checkAndProcessJumpRobotPage(Context context, String str, long j3);

    void closeTalking();

    void configRobotFromServer(JSONObject jSONObject);

    oidb_0x496$RobotSubscribeCategory findSubscribeCategory(int i3);

    String generateMoreDetailMsg(MessageRecord messageRecord);

    String getMessageKey(MessageRecord messageRecord);

    String getRobotWarning();

    boolean hasNext(MessageRecord messageRecord);

    boolean hasProcessedMoreDetail(MessageRecord messageRecord);

    boolean hasRobotNewsClassId(MessageRecord messageRecord);

    @Deprecated
    boolean isRobotSwichOn();

    boolean isRobotUin(long j3);

    boolean isRobotUin(String str);

    boolean isRobotUinNeedShowRed(AppRuntime appRuntime, String str, String str2);

    boolean isTalking();

    void onGetRobotRedInfo(AppRuntime appRuntime, long j3, ArrayList<String> arrayList);

    void preProcessMessageMoreDetail(MessageRecord messageRecord);

    byte[] readRobotConfig();

    void release(String str, String str2, String str3);

    void removeRobotUinInRed(AppRuntime appRuntime, String str);

    void report(String str, String str2, String str3, String str4, String str5, String str6);

    void reqGrayTips(long j3, long j16, String str, a aVar);

    void reqGrayTips(long j3, String str, a aVar);

    void reqGrayTipsInner(int i3, long j3, long j16, String str, a aVar);

    void saveRobotConfig(oidb_0x496$Robot oidb_0x496_robot);

    void sendContent(long j3, long j16, String str, a aVar);

    void sendContent(long j3, String str, a aVar);

    void sendContentInner(int i3, long j3, long j16, String str, a aVar);

    void setOnTalkingChangeListener(b bVar);

    void setRobotConfig(oidb_0x496$Robot oidb_0x496_robot);

    void updateConfig(boolean z16, String str);
}
