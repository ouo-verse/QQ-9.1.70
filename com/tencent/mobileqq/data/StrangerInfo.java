package com.tencent.mobileqq.data;

import android.text.TextUtils;
import android.util.Base64;
import appoint.define.appoint_define$CommonLabel;
import appoint.define.appoint_define$PublisherInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StrangerInfo extends Entity implements Serializable {
    private static final long serialVersionUID = 0;
    public int age;
    public int charm;
    public int charmLevel;
    public int chatFlag;
    public int chatupCount;
    public String constellation;
    public String distance;
    public int gender;
    public int godFlag;
    public String interestNameStr;
    public String interestTypeStr;

    @notColumn
    public boolean isNewVisitor;
    public int lableId;
    public byte[] lableMsgLast;
    public byte[] lableMsgPre;
    public int marriage;
    public String nickName;
    public int profession;
    public int pubNumber;
    public int recentVisitorTime;
    public int recommend;
    public byte[] strangerDeclare;

    @notColumn
    public String timeStr;
    public long tinyId;
    public long uin;
    public String vipInfo;

    @notColumn
    public ArrayList<String> interestNames = new ArrayList<>();

    @notColumn
    public ArrayList<Integer> interestTypes = new ArrayList<>();

    public static StrangerInfo convertFrom(appoint_define$PublisherInfo appoint_define_publisherinfo) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str;
        String str2;
        int i26;
        int i27;
        long j3;
        String str3;
        int i28;
        int i29;
        int i36;
        String str4;
        int i37;
        int i38;
        byte[] bArr;
        appoint_define$CommonLabel appoint_define_commonlabel;
        byte[] bArr2;
        byte[] bArr3;
        List<ByteStringMicro> list;
        List<Integer> list2 = null;
        if (appoint_define_publisherinfo == null) {
            return null;
        }
        StrangerInfo strangerInfo = new StrangerInfo();
        int i39 = 0;
        if (appoint_define_publisherinfo.uint32_age.has()) {
            i3 = appoint_define_publisherinfo.uint32_age.get();
        } else {
            i3 = 0;
        }
        strangerInfo.age = i3;
        if (appoint_define_publisherinfo.uint32_charm.has()) {
            i16 = appoint_define_publisherinfo.uint32_charm.get();
        } else {
            i16 = 0;
        }
        strangerInfo.charm = i16;
        if (appoint_define_publisherinfo.uint32_charm_level.has()) {
            i17 = appoint_define_publisherinfo.uint32_charm_level.get();
        } else {
            i17 = 0;
        }
        strangerInfo.charmLevel = i17;
        if (appoint_define_publisherinfo.uint32_chatflag.has()) {
            i18 = appoint_define_publisherinfo.uint32_chatflag.get();
        } else {
            i18 = 0;
        }
        strangerInfo.chatFlag = i18;
        if (appoint_define_publisherinfo.uint32_chatup_count.has()) {
            i19 = appoint_define_publisherinfo.uint32_chatup_count.get();
        } else {
            i19 = 0;
        }
        strangerInfo.chatupCount = i19;
        String str5 = "";
        if (!appoint_define_publisherinfo.str_constellation.has()) {
            str = "";
        } else {
            str = appoint_define_publisherinfo.str_constellation.get();
        }
        strangerInfo.constellation = str;
        if (!appoint_define_publisherinfo.str_distance.has()) {
            str2 = "";
        } else {
            str2 = appoint_define_publisherinfo.str_distance.get();
        }
        strangerInfo.distance = str2;
        if (appoint_define_publisherinfo.uint32_gender.has()) {
            i26 = appoint_define_publisherinfo.uint32_gender.get();
        } else {
            i26 = 0;
        }
        strangerInfo.gender = i26;
        if (appoint_define_publisherinfo.uint32_godflag.has()) {
            i27 = appoint_define_publisherinfo.uint32_godflag.get();
        } else {
            i27 = 0;
        }
        strangerInfo.godFlag = i27;
        long j16 = 0;
        if (appoint_define_publisherinfo.uint64_tinyid.has()) {
            j3 = appoint_define_publisherinfo.uint64_tinyid.get();
        } else {
            j3 = 0;
        }
        strangerInfo.tinyId = j3;
        if (!appoint_define_publisherinfo.bytes_nickname.has()) {
            str3 = "";
        } else {
            str3 = appoint_define_publisherinfo.bytes_nickname.get().toStringUtf8();
        }
        strangerInfo.nickName = str3;
        if (appoint_define_publisherinfo.uint32_marriage.has()) {
            i28 = appoint_define_publisherinfo.uint32_marriage.get();
        } else {
            i28 = 0;
        }
        strangerInfo.marriage = i28;
        if (appoint_define_publisherinfo.uint32_profession.has()) {
            i29 = appoint_define_publisherinfo.uint32_profession.get();
        } else {
            i29 = 0;
        }
        strangerInfo.profession = i29;
        if (appoint_define_publisherinfo.uint32_recent_vistor_time.has()) {
            i36 = appoint_define_publisherinfo.uint32_recent_vistor_time.get();
        } else {
            i36 = 0;
        }
        strangerInfo.recentVisitorTime = i36;
        if (!appoint_define_publisherinfo.str_vipinfo.has()) {
            str4 = "";
        } else {
            str4 = appoint_define_publisherinfo.str_vipinfo.get();
        }
        strangerInfo.vipInfo = str4;
        if (appoint_define_publisherinfo.uint32_recommend.has()) {
            i37 = appoint_define_publisherinfo.uint32_recommend.get();
        } else {
            i37 = 0;
        }
        strangerInfo.recommend = i37;
        if (appoint_define_publisherinfo.uint32_pub_number.has()) {
            i38 = appoint_define_publisherinfo.uint32_pub_number.get();
        } else {
            i38 = 0;
        }
        strangerInfo.pubNumber = i38;
        if (appoint_define_publisherinfo.uint64_friend_uin.has()) {
            j16 = appoint_define_publisherinfo.uint64_friend_uin.get();
        }
        strangerInfo.uin = j16;
        if (appoint_define_publisherinfo.bytes_stranger_declare.has()) {
            bArr = Base64.decode(appoint_define_publisherinfo.bytes_stranger_declare.get().toByteArray(), 0);
        } else {
            bArr = null;
        }
        strangerInfo.strangerDeclare = bArr;
        if (appoint_define_publisherinfo.uint32_history_flag.has() && appoint_define_publisherinfo.uint32_history_flag.get() == 1) {
            strangerInfo.isNewVisitor = false;
        } else {
            strangerInfo.isNewVisitor = true;
        }
        if (appoint_define_publisherinfo.msg_common_label.has()) {
            appoint_define_commonlabel = appoint_define_publisherinfo.msg_common_label.get();
        } else {
            appoint_define_commonlabel = null;
        }
        if (appoint_define_commonlabel != null) {
            if (appoint_define_commonlabel.uint32_lable_id.has()) {
                i39 = appoint_define_commonlabel.uint32_lable_id.get();
            }
            strangerInfo.lableId = i39;
            if (appoint_define_commonlabel.bytes_lable_msg_pre.has()) {
                bArr2 = appoint_define_commonlabel.bytes_lable_msg_pre.get().toByteArray();
            } else {
                bArr2 = null;
            }
            strangerInfo.lableMsgPre = bArr2;
            if (appoint_define_commonlabel.bytes_lable_msg_last.has()) {
                bArr3 = appoint_define_commonlabel.bytes_lable_msg_last.get().toByteArray();
            } else {
                bArr3 = null;
            }
            strangerInfo.lableMsgLast = bArr3;
            if (appoint_define_commonlabel.rpt_interst_name.has()) {
                list = appoint_define_commonlabel.rpt_interst_name.get();
            } else {
                list = null;
            }
            if (list != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator<ByteStringMicro> it = list.iterator();
                while (it.hasNext()) {
                    String stringUtf8 = it.next().toStringUtf8();
                    arrayList.add(stringUtf8);
                    jSONArray.mo162put(stringUtf8);
                }
                strangerInfo.interestNames = arrayList;
                try {
                    jSONObject.put("interestNames", jSONArray);
                    strangerInfo.interestNameStr = jSONObject.toString();
                } catch (JSONException e16) {
                    if (QLog.isDevelopLevel()) {
                        e16.printStackTrace();
                    }
                }
            }
            if (appoint_define_commonlabel.rpt_interst_type.has()) {
                list2 = appoint_define_commonlabel.rpt_interst_type.get();
            }
            if (list2 != null) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                Iterator<Integer> it5 = list2.iterator();
                while (it5.hasNext()) {
                    int intValue = it5.next().intValue();
                    arrayList2.add(Integer.valueOf(intValue));
                    jSONArray2.put(intValue);
                }
                strangerInfo.interestTypes = arrayList2;
                try {
                    jSONObject2.put("interestTypes", jSONArray2);
                    strangerInfo.interestTypeStr = jSONObject2.toString();
                } catch (JSONException e17) {
                    if (QLog.isDevelopLevel()) {
                        e17.printStackTrace();
                    }
                }
            }
        }
        int i46 = strangerInfo.recentVisitorTime;
        if (i46 > 0) {
            str5 = en.p(i46 * 1000, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        }
        strangerInfo.timeStr = str5;
        return strangerInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        super.postRead();
        int i3 = this.recentVisitorTime;
        if (i3 > 0) {
            this.timeStr = en.p(i3 * 1000, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        }
        if (!TextUtils.isEmpty(this.interestNameStr)) {
            try {
                JSONArray jSONArray = new JSONObject(this.interestNameStr).getJSONArray("interestNames");
                if (jSONArray != null) {
                    for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                        String string = jSONArray.getString(i16);
                        if (!TextUtils.isEmpty(string)) {
                            this.interestNames.add(string);
                        }
                    }
                }
            } catch (JSONException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(this.interestTypeStr)) {
            try {
                JSONArray jSONArray2 = new JSONObject(this.interestTypeStr).getJSONArray("interestTypes");
                if (jSONArray2 != null) {
                    for (int i17 = 0; i17 < jSONArray2.length(); i17++) {
                        this.interestTypes.add(Integer.valueOf(jSONArray2.getInt(i17)));
                    }
                }
            } catch (JSONException e17) {
                if (QLog.isDevelopLevel()) {
                    e17.printStackTrace();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        for (Class<?> cls = getClass(); cls != Entity.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    String name = field.getName();
                    try {
                        Object obj = field.get(this);
                        sb5.append(',');
                        sb5.append(name);
                        sb5.append('=');
                        sb5.append(obj);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return sb5.toString();
    }
}
