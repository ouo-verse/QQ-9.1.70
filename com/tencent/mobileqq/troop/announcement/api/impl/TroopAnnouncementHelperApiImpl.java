package com.tencent.mobileqq.troop.announcement.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.troop.config.b;
import com.tencent.qphone.base.util.QLog;
import com.trunk.group_feeds.group_feeds$GroupFeedsMessage;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAnnouncementHelperApiImpl implements ITroopAnnouncementHelperApi {
    static IPatchRedirector $redirector_ = null;
    private static final String CONFIG_ID_GET_INTRO_GAP_HOUR = "101934";
    private static final String CONFIG_KEY_GET_INTRO_GAP_HOUR = "gap_hour";
    private static final String TAG = "TroopAnnouncementHelperApiImpl";
    static final String[] face_desc;
    static final int[] face_old2new;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            face_old2new = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 80, 81, 82, 83, 84, 45, 85, 44, 43, 40, 41, 86, 42, 87, 57, 88, 52, 89, 63, 64, 65, 66, 67, 53, 69, 90, 91, 74, 92, 93, 75, 76, 77, 94, 95, 15, 16, 17, 18, 19, 26, 27, 28, 29, 46, 47, 48, 49, 60, 61, 62, 68, 70, 71, 72, 73, 78, 59, 20, 21, 22, 23, 24, 25, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 50, 51, 54, 55, 56, 58, 79, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134};
            face_desc = new String[]{"\u5fae\u7b11", "\u6487\u5634", "\u8272", "\u53d1\u5446", "\u5f97\u610f", "\u6d41\u6cea", "\u5bb3\u7f9e", "\u95ed\u5634", "\u7761", "\u5927\u54ed", "\u5c34\u5c2c", "\u53d1\u6012", "\u8c03\u76ae", "\u5472\u7259", "\u60ca\u8bb6", "\u96be\u8fc7", "\u9177", "\u51b7\u6c57", "\u6293\u72c2", "\u5410", "\u5077\u7b11", "\u53ef\u7231", "\u767d\u773c", "\u50b2\u6162", "\u9965\u997f", "\u56f0", "\u60ca\u6050", "\u6d41\u6c57", "\u61a8\u7b11", "\u5927\u5175", "\u594b\u6597", "\u5492\u9a82", "\u7591\u95ee", "\u5618", "\u6655", "\u6298\u78e8", "\u8870", "\u9ab7\u9ac5", "\u6572\u6253", "\u518d\u89c1", "\u64e6\u6c57", "\u62a0\u9f3b", "\u9f13\u638c", "\u7cd7\u5927\u4e86", "\u574f\u7b11", "\u5de6\u54fc\u54fc", "\u53f3\u54fc\u54fc", "\u54c8\u6b20", "\u9119\u89c6", "\u59d4\u5c48", "\u5feb\u54ed\u4e86", "\u9634\u9669", "\u4eb2\u4eb2", "\u5413", "\u53ef\u601c", "\u83dc\u5200", "\u897f\u74dc", "\u5564\u9152", "\u7bee\u7403", "\u4e52\u4e53", "\u5496\u5561", "\u996d", "\u732a\u5934", "\u73ab\u7470", "\u51cb\u8c22", "\u793a\u7231", "\u7231\u5fc3", "\u5fc3\u788e", "\u86cb\u7cd5", "\u95ea\u7535", "\u70b8\u5f39", "\u5200", "\u8db3\u7403", "\u74e2\u866b", "\u4fbf\u4fbf", "\u6708\u4eae", "\u592a\u9633", "\u793c\u7269", "\u62e5\u62b1", "\u5f3a", "\u5f31", "\u63e1\u624b", "\u80dc\u5229", "\u62b1\u62f3", "\u52fe\u5f15", "\u62f3\u5934", "\u5dee\u52b2", "\u7231\u4f60", "NO", "OK", "\u7231\u60c5", "\u98de\u543b", "\u8df3\u8df3", "\u53d1\u6296", "\u6004\u706b", "\u8f6c\u5708", "\u78d5\u5934", "\u56de\u5934", "\u8df3\u7ef3", "\u6325\u624b", "\u6fc0\u52a8", "\u8857\u821e", "\u732e\u543b", "\u5de6\u592a\u6781", "\u53f3\u592a\u6781", "\u6f5c\u6c34", "\u656c\u793c", "\u77f3\u5316", "\u52a0\u6cb9", "\u71ac\u591c", "\u8d62\u4e86", "\u8f93\u5566", "\u706b\u70ac", "\u91d1\u724c", "\u5751\u7239", "\u4f24\u4e0d\u8d77", "\u4eb2", "\u88c1\u5224", "\u8de8\u680f"};
        }
    }

    public TroopAnnouncementHelperApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ITroopAnnouncementHelperApi.a decodeFeedItem_Stream(group_feeds$GroupFeedsMessage group_feeds_groupfeedsmessage, String str) {
        JSONObject jSONObject;
        int i3;
        ITroopAnnouncementHelperApi.a aVar;
        int i16;
        String str2 = null;
        byte[] bArr = null;
        for (group_feeds$GroupFeedsMessage.MessageContent messageContent : group_feeds_groupfeedsmessage.rpt_feeds_content.get()) {
            int i17 = messageContent.enum_content_type.get();
            if (i17 == 0) {
                bArr = messageContent.bytes_content_value.get().toByteArray();
            } else if (i17 == 14) {
                str2 = messageContent.bytes_content_value.get().toStringUtf8();
            }
        }
        boolean z16 = true;
        long j3 = 0;
        if (str2 != null) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "decodeToFeedItem--JSONException");
                }
            }
            if (jSONObject.has(ITroopAnnouncementHelperApi.CONTROL_TYPE) && jSONObject.getInt(ITroopAnnouncementHelperApi.CONTROL_TYPE) == 1) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(ITroopAnnouncementHelperApi.CONTROL_INFO);
                j3 = jSONObject2.getLong(ITroopAnnouncementHelperApi.CONTROL_INFO_FILTER_ID);
                i3 = jSONObject2.getInt("src");
                aVar = new ITroopAnnouncementHelperApi.a();
                aVar.f293918c = str;
                aVar.f293924i = bArr;
                aVar.f293925j = str2;
                aVar.f293916a = 2;
                aVar.f293927l = j3;
                aVar.f293926k = i3;
                if (!group_feeds_groupfeedsmessage.opt_uint32_ctl_flag.has()) {
                    i16 = group_feeds_groupfeedsmessage.opt_uint32_ctl_flag.get();
                } else {
                    i16 = 0;
                }
                aVar.f293928m = i16;
                if (group_feeds_groupfeedsmessage.memo_ctrl_info.has() && group_feeds_groupfeedsmessage.memo_ctrl_info.get().uint32_need_confirmation.has()) {
                    if (group_feeds_groupfeedsmessage.memo_ctrl_info.get().uint32_need_confirmation.get() != 1) {
                        z16 = false;
                    }
                    aVar.f293929n = z16;
                }
                return aVar;
            }
        }
        i3 = 0;
        aVar = new ITroopAnnouncementHelperApi.a();
        aVar.f293918c = str;
        aVar.f293924i = bArr;
        aVar.f293925j = str2;
        aVar.f293916a = 2;
        aVar.f293927l = j3;
        aVar.f293926k = i3;
        if (!group_feeds_groupfeedsmessage.opt_uint32_ctl_flag.has()) {
        }
        aVar.f293928m = i16;
        if (group_feeds_groupfeedsmessage.memo_ctrl_info.has()) {
            if (group_feeds_groupfeedsmessage.memo_ctrl_info.get().uint32_need_confirmation.get() != 1) {
            }
            aVar.f293929n = z16;
        }
        return aVar;
    }

    private ITroopAnnouncementHelperApi.a decodeToFeedItem_Memo(group_feeds$GroupFeedsMessage group_feeds_groupfeedsmessage, String str, boolean z16) {
        String str2;
        boolean z17;
        int i3;
        int i16;
        List<group_feeds$GroupFeedsMessage.MessageContent> list = group_feeds_groupfeedsmessage.rpt_feeds_content.get();
        String str3 = "";
        if (z16) {
            str2 = "";
        } else {
            str2 = "\u7fa4\u516c\u544a";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<group_feeds$GroupFeedsMessage.MessageContent> it = list.iterator();
        while (true) {
            z17 = false;
            if (!it.hasNext()) {
                break;
            }
            group_feeds$GroupFeedsMessage.MessageContent next = it.next();
            int i17 = next.enum_content_type.get();
            if (i17 == 3) {
                str3 = String.format("https://gdynamic.qpic.cn/gdynamic/%s/72", next.bytes_pic_id.get().toStringUtf8());
            } else if (i17 == 0) {
                sb5.append(next.bytes_content_value.get().toStringUtf8());
            } else if (i17 == 10) {
                str2 = next.bytes_content_value.get().toStringUtf8();
            } else if (i17 == 2 && (i16 = next.int32_face_idx.get()) >= 0) {
                try {
                    if (i16 < face_old2new.length) {
                        String str4 = face_desc[i16];
                        sb5.append('[');
                        sb5.append(str4);
                        sb5.append(']');
                    }
                } catch (Exception unused) {
                }
            }
        }
        String sb6 = sb5.toString();
        ITroopAnnouncementHelperApi.a aVar = new ITroopAnnouncementHelperApi.a();
        aVar.f293917b = str2;
        aVar.f293918c = str;
        aVar.f293919d = sb6;
        aVar.f293920e = str3;
        aVar.f293916a = 1;
        if (group_feeds_groupfeedsmessage.opt_uint32_ctl_flag.has()) {
            i3 = group_feeds_groupfeedsmessage.opt_uint32_ctl_flag.get();
        } else {
            i3 = 0;
        }
        aVar.f293928m = i3;
        if (group_feeds_groupfeedsmessage.memo_ctrl_info.has() && group_feeds_groupfeedsmessage.memo_ctrl_info.get().uint32_need_confirmation.has()) {
            if (group_feeds_groupfeedsmessage.memo_ctrl_info.get().uint32_need_confirmation.get() == 1) {
                z17 = true;
            }
            aVar.f293929n = z17;
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi
    public ITroopAnnouncementHelperApi.a decodeToFeedItem(String str, byte[] bArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ITroopAnnouncementHelperApi.a) iPatchRedirector.redirect((short) 2, this, str, bArr, Boolean.valueOf(z16));
        }
        try {
            group_feeds$GroupFeedsMessage group_feeds_groupfeedsmessage = new group_feeds$GroupFeedsMessage();
            group_feeds_groupfeedsmessage.mergeFrom(bArr);
            int i3 = group_feeds_groupfeedsmessage.enum_feeds_type.get();
            if (i3 != 5 && i3 != 19) {
                if (i3 == 22) {
                    return decodeFeedItem_Stream(group_feeds_groupfeedsmessage, str);
                }
                return null;
            }
            return decodeToFeedItem_Memo(group_feeds_groupfeedsmessage, str, z16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi
    public int getTroopIntroGapHour() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int d16 = b.f294691a.d(CONFIG_ID_GET_INTRO_GAP_HOUR, CONFIG_KEY_GET_INTRO_GAP_HOUR, Integer.MAX_VALUE);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[canGetTroopIntroOnJoin] rtn = " + d16);
        }
        return d16;
    }
}
