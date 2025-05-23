package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0xa28.oidb_0xa28$Achievement;
import tencent.im.oidb.cmd0xa28.oidb_0xa28$Profile;
import tencent.im.oidb.cmd0xa28.oidb_0xa28$RoleInfo;
import tencent.im.oidb.cmd0xa28.oidb_0xa28$RspBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class KplCard extends Entity {
    public String bgUrl;
    public String commonInfo;
    public String gameLevel;
    public String gameNick;
    public int gender;
    public long mvpLevel;
    public String qqNick;

    @notColumn
    public List<KplRoleInfo> roleList;
    public long round;
    public String sRoleList;
    public String score;
    public long superLevel;

    @unique
    public String uin;

    public static KplCard parseProto(oidb_0xa28$RspBody oidb_0xa28_rspbody, String str) {
        long j3;
        long j16;
        String str2;
        KplCard kplCard = new KplCard();
        kplCard.uin = str;
        oidb_0xa28$Profile oidb_0xa28_profile = oidb_0xa28_rspbody.msg_profile_info.get();
        kplCard.gameNick = oidb_0xa28_profile.bytes_game_nick.get().toStringUtf8();
        kplCard.qqNick = oidb_0xa28_profile.bytes_qq_nick.get().toStringUtf8();
        kplCard.gender = oidb_0xa28_profile.uint32_gender.get();
        kplCard.gameLevel = oidb_0xa28_profile.bytes_game_level.get().toStringUtf8();
        kplCard.commonInfo = oidb_0xa28_profile.bytes_common_info.get().toStringUtf8();
        kplCard.bgUrl = oidb_0xa28_profile.str_bg_url.get();
        oidb_0xa28$Achievement oidb_0xa28_achievement = oidb_0xa28_rspbody.msg_game_info.msg_achieve_info;
        long j17 = 0;
        if (oidb_0xa28_achievement.uint64_mvp_level.has()) {
            j3 = oidb_0xa28_achievement.uint64_mvp_level.get();
        } else {
            j3 = 0;
        }
        kplCard.mvpLevel = j3;
        if (oidb_0xa28_achievement.uint64_super.has()) {
            j16 = oidb_0xa28_achievement.uint64_super.get();
        } else {
            j16 = 0;
        }
        kplCard.superLevel = j16;
        if (oidb_0xa28_achievement.bytes_score.has()) {
            str2 = oidb_0xa28_achievement.bytes_score.get().toStringUtf8();
        } else {
            str2 = "";
        }
        kplCard.score = str2;
        if (oidb_0xa28_achievement.uint64_round.has()) {
            j17 = oidb_0xa28_achievement.uint64_round.get();
        }
        kplCard.round = j17;
        List<oidb_0xa28$RoleInfo> list = oidb_0xa28_rspbody.msg_game_info.msg_role_list.get();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<oidb_0xa28$RoleInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(KplRoleInfo.parseProtoResp(it.next()));
        }
        kplCard.roleList = arrayList;
        kplCard.saveListAsString();
        return kplCard;
    }

    public void saveListAsString() {
        JSONArray jSONArray = new JSONArray();
        Iterator<KplRoleInfo> it = this.roleList.iterator();
        while (it.hasNext()) {
            String jsonString = it.next().toJsonString();
            if (!TextUtils.isEmpty(jsonString)) {
                jSONArray.mo162put(jsonString);
            }
        }
        this.sRoleList = jSONArray.toString();
    }

    public void transStringToList() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.sRoleList);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                KplRoleInfo parseJsonString = KplRoleInfo.parseJsonString(jSONArray.getString(i3));
                if (parseJsonString != null) {
                    arrayList.add(parseJsonString);
                }
            }
            this.roleList = arrayList;
        } catch (JSONException e16) {
            QLog.e("KplCard", 1, "transStringToList exception:");
            e16.printStackTrace();
        }
    }
}
