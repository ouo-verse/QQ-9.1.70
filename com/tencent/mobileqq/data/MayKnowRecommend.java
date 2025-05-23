package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.pymk.PYMKBusiData;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xc26$AddFriendSource;
import tencent.im.oidb.oidb_0xc26$BusiData;
import tencent.im.oidb.oidb_0xc26$Color;
import tencent.im.oidb.oidb_0xc26$Label;
import tencent.im.oidb.oidb_0xc26$MayKnowPerson;
import tencent.im.oidb.oidb_0xc26$MultiReason;
import tencent.im.oidb.oidb_0xc26$QzoneMediaInfo;
import tencent.im.oidb.oidb_0xc26$UndecidePerson;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111$AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111$Color;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111$Label;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111$MayKnowPerson;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MayKnowRecommend extends Entity implements Serializable, Cloneable {
    public static final int INVALID_ADDFRIEND_SOURCE = -1;
    private static final int SOURCEID_FROM_CONTACT = 102;
    public static final int TAB_ID_FOR_MAY_KNOW_RECOMMEND = 23;
    private static final String TAG = "MayKnowRecommend";
    private static final long serialVersionUID = 1;
    public byte[] additive;
    public short age;
    public byte[] algBuffer;

    @notColumn
    public boolean bHighLight;

    @notColumn
    public List<PYMKBusiData> busiDataList;
    public byte[] busiInfoListByte;
    public String category;
    public String city;
    public String country;
    public int friendStatus;
    public boolean hasQZoneUpdate;

    @notColumn
    public List<MediaInfo> mediaInfos;
    public String mediaInfosPacked;
    public String mobile_name;

    @notColumn
    public List<MayKnowRecommendLabel> msgLabel;
    public byte[] msgLabelByte;
    public String nick;
    public String province;
    public int qZoneFeedsCnt;
    public String qZoneJumpUrl;
    public String recommendReason;
    public String remark;

    @Deprecated
    public String richBuffer;
    public byte[] richSingature;

    @notColumn
    public RichStatus richStatus;
    public String strToken;
    public int timestamp;
    public String traceId;
    public String transInfo;
    public String uin;
    public short gender = 255;
    public int addFriendsource = -1;
    public int addFriendSubSource = -1;
    public long cardDisplayTimestamp = 0;
    public int tabID = 23;
    public int sourceId = 0;
    public int isVerify = 0;
    public int dataSource = 1;
    public String multiReason = "";

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class MayKnowRecommendLabel extends RecommendLabel {
    }

    @NonNull
    public static List<MayKnowRecommendLabel> convert0xc26ToMayKnowRecommendLabel(List<oidb_0xc26$Label> list) {
        int i3;
        int i16;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (int i17 = 0; i17 < list.size(); i17++) {
                MayKnowRecommendLabel mayKnowRecommendLabel = new MayKnowRecommendLabel();
                if (list.get(i17).has()) {
                    oidb_0xc26$Label oidb_0xc26_label = list.get(i17).get();
                    if (oidb_0xc26_label.bytes_name.has()) {
                        mayKnowRecommendLabel.bytes_name = oidb_0xc26_label.bytes_name.get().toStringUtf8();
                    }
                    if (oidb_0xc26_label.uint32_label_type.has()) {
                        mayKnowRecommendLabel.uint32_label_type = oidb_0xc26_label.uint32_label_type.get();
                    }
                    if (oidb_0xc26_label.edging_color.has()) {
                        i16 = Color.rgb(oidb_0xc26_label.edging_color.get().uint32_r.get(), oidb_0xc26_label.edging_color.get().uint32_g.get(), oidb_0xc26_label.edging_color.get().uint32_b.get());
                    } else {
                        i16 = 0;
                    }
                    if (oidb_0xc26_label.text_color.has()) {
                        i3 = Color.rgb(oidb_0xc26_label.text_color.get().uint32_r.get(), oidb_0xc26_label.text_color.get().uint32_g.get(), oidb_0xc26_label.text_color.get().uint32_b.get());
                    } else {
                        i3 = 0;
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                mayKnowRecommendLabel.edging_color = i16;
                mayKnowRecommendLabel.text_color = i3;
                arrayList.add(mayKnowRecommendLabel);
            }
        }
        return arrayList;
    }

    @NonNull
    public static List<MediaInfo> convert0xc26ToMayKnowRecommendMeidaInfos(List<oidb_0xc26$QzoneMediaInfo> list) {
        int i3;
        boolean z16;
        String str;
        String str2;
        String str3;
        int i16;
        String str4;
        String str5;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (int i17 = 0; i17 < list.size(); i17++) {
                String str6 = "";
                if (list.get(i17).has()) {
                    oidb_0xc26$QzoneMediaInfo oidb_0xc26_qzonemediainfo = list.get(i17).get();
                    if (oidb_0xc26_qzonemediainfo.type.has()) {
                        i16 = oidb_0xc26_qzonemediainfo.type.get();
                    } else {
                        i16 = 0;
                    }
                    if (!oidb_0xc26_qzonemediainfo.pic_url.has()) {
                        str4 = "";
                    } else {
                        str4 = oidb_0xc26_qzonemediainfo.pic_url.get();
                    }
                    if (!oidb_0xc26_qzonemediainfo.text.has()) {
                        str5 = "";
                    } else {
                        str5 = oidb_0xc26_qzonemediainfo.text.get();
                    }
                    if (oidb_0xc26_qzonemediainfo.report_data.has()) {
                        str6 = oidb_0xc26_qzonemediainfo.report_data.get();
                    }
                    if (oidb_0xc26_qzonemediainfo.has_pic.has()) {
                        z16 = oidb_0xc26_qzonemediainfo.has_pic.get();
                    } else {
                        z16 = false;
                    }
                    str3 = str6;
                    i3 = i16;
                    str = str4;
                    str2 = str5;
                } else {
                    i3 = 0;
                    z16 = false;
                    str = "";
                    str2 = str;
                    str3 = str2;
                }
                arrayList.add(new MediaInfo(i3, str, str2, str3, z16));
            }
        }
        return arrayList;
    }

    private static List<oidb_0xc26$Label> convertPushLabelTo0xc26Label(List<SubMsgType0x111$Label> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (SubMsgType0x111$Label subMsgType0x111$Label : list) {
                oidb_0xc26$Label oidb_0xc26_label = new oidb_0xc26$Label();
                oidb_0xc26_label.setHasFlag(true);
                if (subMsgType0x111$Label.bytes_name.has()) {
                    oidb_0xc26_label.bytes_name.set(subMsgType0x111$Label.bytes_name.get());
                }
                if (subMsgType0x111$Label.edging_color.has()) {
                    SubMsgType0x111$Color subMsgType0x111$Color = subMsgType0x111$Label.edging_color.get();
                    oidb_0xc26$Color oidb_0xc26_color = new oidb_0xc26$Color();
                    oidb_0xc26_color.uint32_b.set(subMsgType0x111$Color.uint32_b.get());
                    oidb_0xc26_color.uint32_g.set(subMsgType0x111$Color.uint32_g.get());
                    oidb_0xc26_color.uint32_r.set(subMsgType0x111$Color.uint32_r.get());
                    oidb_0xc26_label.edging_color.set(oidb_0xc26_color);
                }
                if (subMsgType0x111$Label.text_color.has()) {
                    SubMsgType0x111$Color subMsgType0x111$Color2 = subMsgType0x111$Label.text_color.get();
                    oidb_0xc26$Color oidb_0xc26_color2 = new oidb_0xc26$Color();
                    oidb_0xc26_color2.uint32_b.set(subMsgType0x111$Color2.uint32_b.get());
                    oidb_0xc26_color2.uint32_g.set(subMsgType0x111$Color2.uint32_g.get());
                    oidb_0xc26_color2.uint32_r.set(subMsgType0x111$Color2.uint32_r.get());
                    oidb_0xc26_label.text_color.set(oidb_0xc26_color2);
                }
                if (subMsgType0x111$Label.uint32_label_type.has()) {
                    oidb_0xc26_label.uint32_label_type.set(subMsgType0x111$Label.uint32_label_type.get());
                }
                arrayList.add(oidb_0xc26_label);
            }
            return arrayList;
        }
        return null;
    }

    @Nullable
    public static MayKnowRecommend convertServerDataToLocal(int i3, int i16, String str, String str2, oidb_0xc26$MayKnowPerson oidb_0xc26_mayknowperson) {
        String str3;
        String str4;
        String str5;
        int i17;
        String str6;
        String str7;
        String str8;
        int i18;
        String str9;
        byte[] bArr;
        int i19;
        boolean z16;
        String str10;
        byte[] bArr2;
        int i26;
        String str11;
        String str12;
        String str13;
        if (!oidb_0xc26_mayknowperson.uint64_uin.has()) {
            str3 = "";
        } else {
            str3 = String.valueOf(oidb_0xc26_mayknowperson.uint64_uin.get());
        }
        byte[] bArr3 = null;
        if (TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "covServerDataToLocal, uint64_uin is null");
            }
            return null;
        }
        MayKnowRecommend mayKnowRecommend = new MayKnowRecommend();
        mayKnowRecommend.traceId = str;
        mayKnowRecommend.transInfo = str2;
        mayKnowRecommend.tabID = i16;
        mayKnowRecommend.uin = str3;
        if (!oidb_0xc26_mayknowperson.bytes_nick.has()) {
            str4 = "";
        } else {
            str4 = oidb_0xc26_mayknowperson.bytes_nick.get().toStringUtf8();
        }
        mayKnowRecommend.nick = str4;
        if (!oidb_0xc26_mayknowperson.bytes_remark.has()) {
            str5 = "";
        } else {
            str5 = oidb_0xc26_mayknowperson.bytes_remark.get().toStringUtf8();
        }
        mayKnowRecommend.remark = str5;
        int i27 = 0;
        if (oidb_0xc26_mayknowperson.uint32_age.has()) {
            i17 = oidb_0xc26_mayknowperson.uint32_age.get();
        } else {
            i17 = 0;
        }
        mayKnowRecommend.age = (short) i17;
        if (!oidb_0xc26_mayknowperson.bytes_country.has()) {
            str6 = "";
        } else {
            str6 = oidb_0xc26_mayknowperson.bytes_country.get().toStringUtf8();
        }
        mayKnowRecommend.country = str6;
        if (!oidb_0xc26_mayknowperson.bytes_province.has()) {
            str7 = "";
        } else {
            str7 = oidb_0xc26_mayknowperson.bytes_province.get().toStringUtf8();
        }
        mayKnowRecommend.province = str7;
        if (!oidb_0xc26_mayknowperson.bytes_city.has()) {
            str8 = "";
        } else {
            str8 = oidb_0xc26_mayknowperson.bytes_city.get().toStringUtf8();
        }
        mayKnowRecommend.city = str8;
        int i28 = -1;
        if (oidb_0xc26_mayknowperson.uint32_gender.has()) {
            i18 = oidb_0xc26_mayknowperson.uint32_gender.get();
        } else {
            i18 = -1;
        }
        mayKnowRecommend.gender = (short) i18;
        if (!oidb_0xc26_mayknowperson.bytes_catelogue.has()) {
            str9 = "";
        } else {
            str9 = oidb_0xc26_mayknowperson.bytes_catelogue.get().toStringUtf8();
        }
        mayKnowRecommend.category = str9;
        if (oidb_0xc26_mayknowperson.bytes_alghrithm.has()) {
            bArr = oidb_0xc26_mayknowperson.bytes_alghrithm.get().toByteArray();
        } else {
            bArr = null;
        }
        mayKnowRecommend.algBuffer = bArr;
        if (oidb_0xc26_mayknowperson.uint32_qzone.has()) {
            i19 = oidb_0xc26_mayknowperson.uint32_qzone.get();
        } else {
            i19 = 0;
        }
        if (i19 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        mayKnowRecommend.hasQZoneUpdate = z16;
        if (!oidb_0xc26_mayknowperson.bytes_reason.has()) {
            str10 = "";
        } else {
            str10 = oidb_0xc26_mayknowperson.bytes_reason.get().toStringUtf8();
        }
        mayKnowRecommend.recommendReason = str10;
        if (oidb_0xc26_mayknowperson.bytes_richbuffer.has()) {
            bArr2 = oidb_0xc26_mayknowperson.bytes_richbuffer.get().toByteArray();
        } else {
            bArr2 = null;
        }
        mayKnowRecommend.richSingature = bArr2;
        oidb_0xc26$AddFriendSource oidb_0xc26_addfriendsource = oidb_0xc26_mayknowperson.msg_android_source.get();
        if (oidb_0xc26_mayknowperson.bytes_additive.has()) {
            bArr3 = oidb_0xc26_mayknowperson.bytes_additive.get().toByteArray();
        }
        mayKnowRecommend.additive = bArr3;
        if (oidb_0xc26_addfriendsource.uint32_source.has()) {
            i26 = oidb_0xc26_addfriendsource.uint32_source.get();
        } else {
            i26 = -1;
        }
        mayKnowRecommend.addFriendsource = i26;
        if (oidb_0xc26_addfriendsource.uint32_sub_source.has()) {
            i28 = oidb_0xc26_addfriendsource.uint32_sub_source.get();
        }
        mayKnowRecommend.addFriendSubSource = i28;
        mayKnowRecommend.timestamp = i3;
        if (!oidb_0xc26_mayknowperson.bytes_mobile_name.has()) {
            str11 = "";
        } else {
            str11 = oidb_0xc26_mayknowperson.bytes_mobile_name.get().toStringUtf8();
        }
        mayKnowRecommend.mobile_name = str11;
        if (!oidb_0xc26_mayknowperson.str_token.has()) {
            str12 = "";
        } else {
            str12 = oidb_0xc26_mayknowperson.str_token.get();
        }
        mayKnowRecommend.strToken = str12;
        mayKnowRecommend.sourceId = oidb_0xc26_mayknowperson.uint32_sourceid.get();
        if (oidb_0xc26_mayknowperson.bytes_mobile_name.has() && QLog.isColorLevel()) {
            QLog.i(TAG, 1, "covServerDataToLocal, mobile_name: " + mayKnowRecommend.mobile_name + "  uin: " + str3);
        }
        if (oidb_0xc26_mayknowperson.rpt_msg_labels.has()) {
            List<oidb_0xc26$Label> list = oidb_0xc26_mayknowperson.rpt_msg_labels.get();
            if (list != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(oidb_0xc26_mayknowperson.rpt_msg_labels.computeSize(1));
                try {
                    CodedOutputStreamMicro newInstance = CodedOutputStreamMicro.newInstance(byteArrayOutputStream);
                    oidb_0xc26_mayknowperson.rpt_msg_labels.writeTo(newInstance, 1);
                    newInstance.flush();
                    mayKnowRecommend.msgLabelByte = byteArrayOutputStream.toByteArray();
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "covServerDataToLocal, rpt_msg_labels error: " + e16.toString());
                    }
                }
                mayKnowRecommend.msgLabel = convert0xc26ToMayKnowRecommendLabel(list);
            } else {
                mayKnowRecommend.msgLabel = new ArrayList();
            }
        }
        parseBusiInfo(oidb_0xc26_mayknowperson, mayKnowRecommend);
        if (oidb_0xc26_mayknowperson.qzone_feeds_cnt.has()) {
            i27 = oidb_0xc26_mayknowperson.qzone_feeds_cnt.get();
        }
        mayKnowRecommend.qZoneFeedsCnt = i27;
        if (oidb_0xc26_mayknowperson.qzone_media_infos.has()) {
            List<oidb_0xc26$QzoneMediaInfo> list2 = oidb_0xc26_mayknowperson.qzone_media_infos.get();
            if (list2 != null) {
                mayKnowRecommend.mediaInfos = convert0xc26ToMayKnowRecommendMeidaInfos(list2);
            } else {
                mayKnowRecommend.mediaInfos = new ArrayList();
            }
        }
        if (!oidb_0xc26_mayknowperson.qzone_jump_url.has()) {
            str13 = "";
        } else {
            str13 = oidb_0xc26_mayknowperson.qzone_jump_url.get();
        }
        mayKnowRecommend.qZoneJumpUrl = str13;
        mayKnowRecommend.multiReason = "";
        if (oidb_0xc26_mayknowperson.multi_reason.has()) {
            mayKnowRecommend.multiReason = parseMultiReason(oidb_0xc26_mayknowperson.multi_reason.get());
        }
        return mayKnowRecommend;
    }

    public static ArrayList<MayKnowRecommend> covServerDataToLocal(List<oidb_0xc26$MayKnowPerson> list, int i3) {
        return covServerDataToLocal(list, i3, 23, "", "");
    }

    public static ArrayList<MayKnowRecommend> covServerPushDataToLocal(List<SubMsgType0x111$MayKnowPerson> list, long j3) {
        String str;
        String str2;
        String str3;
        int i3;
        String str4;
        String str5;
        String str6;
        int i16;
        String str7;
        byte[] bArr;
        int i17;
        String str8;
        byte[] bArr2;
        int i18;
        List<oidb_0xc26$Label> convertPushLabelTo0xc26Label;
        if (list == null) {
            return new ArrayList<>();
        }
        ArrayList<MayKnowRecommend> arrayList = new ArrayList<>();
        for (SubMsgType0x111$MayKnowPerson subMsgType0x111$MayKnowPerson : list) {
            String str9 = "";
            if (!subMsgType0x111$MayKnowPerson.uint64_uin.has()) {
                str = "";
            } else {
                str = String.valueOf(subMsgType0x111$MayKnowPerson.uint64_uin.get());
            }
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "covServerDataToLocal, uint64_uin is null");
                }
            } else {
                MayKnowRecommend mayKnowRecommend = new MayKnowRecommend();
                mayKnowRecommend.tabID = 23;
                mayKnowRecommend.uin = str;
                if (!subMsgType0x111$MayKnowPerson.bytes_nick.has()) {
                    str2 = "";
                } else {
                    str2 = subMsgType0x111$MayKnowPerson.bytes_nick.get().toStringUtf8();
                }
                mayKnowRecommend.nick = str2;
                if (!subMsgType0x111$MayKnowPerson.bytes_remark.has()) {
                    str3 = "";
                } else {
                    str3 = subMsgType0x111$MayKnowPerson.bytes_remark.get().toStringUtf8();
                }
                mayKnowRecommend.remark = str3;
                boolean z16 = false;
                if (subMsgType0x111$MayKnowPerson.uint32_age.has()) {
                    i3 = subMsgType0x111$MayKnowPerson.uint32_age.get();
                } else {
                    i3 = 0;
                }
                mayKnowRecommend.age = (short) i3;
                if (!subMsgType0x111$MayKnowPerson.bytes_country.has()) {
                    str4 = "";
                } else {
                    str4 = subMsgType0x111$MayKnowPerson.bytes_country.get().toStringUtf8();
                }
                mayKnowRecommend.country = str4;
                if (!subMsgType0x111$MayKnowPerson.bytes_province.has()) {
                    str5 = "";
                } else {
                    str5 = subMsgType0x111$MayKnowPerson.bytes_province.get().toStringUtf8();
                }
                mayKnowRecommend.province = str5;
                if (!subMsgType0x111$MayKnowPerson.bytes_city.has()) {
                    str6 = "";
                } else {
                    str6 = subMsgType0x111$MayKnowPerson.bytes_city.get().toStringUtf8();
                }
                mayKnowRecommend.city = str6;
                int i19 = -1;
                if (subMsgType0x111$MayKnowPerson.uint32_gender.has()) {
                    i16 = subMsgType0x111$MayKnowPerson.uint32_gender.get();
                } else {
                    i16 = -1;
                }
                mayKnowRecommend.gender = (short) i16;
                if (!subMsgType0x111$MayKnowPerson.bytes_catelogue.has()) {
                    str7 = "";
                } else {
                    str7 = subMsgType0x111$MayKnowPerson.bytes_catelogue.get().toStringUtf8();
                }
                mayKnowRecommend.category = str7;
                byte[] bArr3 = null;
                if (subMsgType0x111$MayKnowPerson.bytes_alghrithm.has()) {
                    bArr = subMsgType0x111$MayKnowPerson.bytes_alghrithm.get().toByteArray();
                } else {
                    bArr = null;
                }
                mayKnowRecommend.algBuffer = bArr;
                if (subMsgType0x111$MayKnowPerson.uint32_qzone.has()) {
                    i17 = subMsgType0x111$MayKnowPerson.uint32_qzone.get();
                } else {
                    i17 = 0;
                }
                if (i17 != 0) {
                    z16 = true;
                }
                mayKnowRecommend.hasQZoneUpdate = z16;
                if (!subMsgType0x111$MayKnowPerson.bytes_reason.has()) {
                    str8 = "";
                } else {
                    str8 = subMsgType0x111$MayKnowPerson.bytes_reason.get().toStringUtf8();
                }
                mayKnowRecommend.recommendReason = str8;
                if (subMsgType0x111$MayKnowPerson.bytes_richbuffer.has()) {
                    bArr2 = subMsgType0x111$MayKnowPerson.bytes_richbuffer.get().toByteArray();
                } else {
                    bArr2 = null;
                }
                mayKnowRecommend.richSingature = bArr2;
                SubMsgType0x111$AddFriendSource subMsgType0x111$AddFriendSource = subMsgType0x111$MayKnowPerson.msg_android_source.get();
                if (subMsgType0x111$MayKnowPerson.bytes_additive.has()) {
                    bArr3 = subMsgType0x111$MayKnowPerson.bytes_additive.get().toByteArray();
                }
                mayKnowRecommend.additive = bArr3;
                if (subMsgType0x111$AddFriendSource.uint32_source.has()) {
                    i18 = subMsgType0x111$AddFriendSource.uint32_source.get();
                } else {
                    i18 = -1;
                }
                mayKnowRecommend.addFriendsource = i18;
                if (subMsgType0x111$AddFriendSource.uint32_sub_source.has()) {
                    i19 = subMsgType0x111$AddFriendSource.uint32_sub_source.get();
                }
                mayKnowRecommend.addFriendSubSource = i19;
                mayKnowRecommend.timestamp = (int) (j3 / 1000);
                mayKnowRecommend.cardDisplayTimestamp = 0L;
                if (subMsgType0x111$MayKnowPerson.bytes_mobile_name.has()) {
                    str9 = subMsgType0x111$MayKnowPerson.bytes_mobile_name.get().toStringUtf8();
                }
                mayKnowRecommend.mobile_name = str9;
                if (subMsgType0x111$MayKnowPerson.bytes_mobile_name.has() && QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "covServerDataToLocal, mobile_name: " + mayKnowRecommend.mobile_name + "  uin: " + str);
                }
                if (subMsgType0x111$MayKnowPerson.rpt_msg_labels.has() && (convertPushLabelTo0xc26Label = convertPushLabelTo0xc26Label(subMsgType0x111$MayKnowPerson.rpt_msg_labels.get())) != null) {
                    PBRepeatMessageField pBRepeatMessageField = new PBRepeatMessageField(oidb_0xc26$Label.class);
                    pBRepeatMessageField.addAll(convertPushLabelTo0xc26Label);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(pBRepeatMessageField.computeSize(1));
                    try {
                        CodedOutputStreamMicro newInstance = CodedOutputStreamMicro.newInstance(byteArrayOutputStream);
                        subMsgType0x111$MayKnowPerson.rpt_msg_labels.writeTo(newInstance, 1);
                        newInstance.flush();
                        mayKnowRecommend.msgLabelByte = byteArrayOutputStream.toByteArray();
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 1, "covServerPushDataToLocal, rpt_msg_labels error: " + e16.toString());
                        }
                    }
                    mayKnowRecommend.msgLabel = convert0xc26ToMayKnowRecommendLabel(convertPushLabelTo0xc26Label);
                }
                arrayList.add(mayKnowRecommend);
            }
        }
        return arrayList;
    }

    public static ArrayList<UndeciedPersonRecommend> covServerVerifyUndeciedDataToLocal(List<oidb_0xc26$UndecidePerson> list, int i3, int i16) {
        String str;
        String str2;
        String str3;
        int i17;
        int i18;
        List<oidb_0xc26$Label> list2;
        if (list == null) {
            return new ArrayList<>();
        }
        ArrayList<UndeciedPersonRecommend> arrayList = new ArrayList<>();
        for (oidb_0xc26$UndecidePerson oidb_0xc26_undecideperson : list) {
            String str4 = "";
            if (!oidb_0xc26_undecideperson.uint64_uin.has()) {
                str = "";
            } else {
                str = String.valueOf(oidb_0xc26_undecideperson.uint64_uin.get());
            }
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "covServerVerifyUndeciedDataToLocal, uint64_uin is null");
                }
            } else {
                UndeciedPersonRecommend undeciedPersonRecommend = new UndeciedPersonRecommend();
                undeciedPersonRecommend.tabID = i16;
                undeciedPersonRecommend.uin = str;
                if (!oidb_0xc26_undecideperson.bytes_nick.has()) {
                    str2 = "";
                } else {
                    str2 = oidb_0xc26_undecideperson.bytes_nick.get().toStringUtf8();
                }
                undeciedPersonRecommend.nick = str2;
                if (!oidb_0xc26_undecideperson.bytes_remark.has()) {
                    str3 = "";
                } else {
                    str3 = oidb_0xc26_undecideperson.bytes_remark.get().toStringUtf8();
                }
                undeciedPersonRecommend.remark = str3;
                if (oidb_0xc26_undecideperson.uint32_age.has()) {
                    i17 = oidb_0xc26_undecideperson.uint32_age.get();
                } else {
                    i17 = 0;
                }
                undeciedPersonRecommend.age = (short) i17;
                int i19 = -1;
                if (oidb_0xc26_undecideperson.uint32_gender.has()) {
                    i18 = oidb_0xc26_undecideperson.uint32_gender.get();
                } else {
                    i18 = -1;
                }
                undeciedPersonRecommend.gender = (short) i18;
                if (oidb_0xc26_undecideperson.bytes_reason.has()) {
                    str4 = oidb_0xc26_undecideperson.bytes_reason.get().toStringUtf8();
                }
                undeciedPersonRecommend.recommendReason = str4;
                undeciedPersonRecommend.isVerify = 1;
                undeciedPersonRecommend.verifyTimeStamps = oidb_0xc26_undecideperson.uint32_time.get();
                undeciedPersonRecommend.verifyType = oidb_0xc26_undecideperson.uint32_reqtype.get();
                oidb_0xc26$AddFriendSource oidb_0xc26_addfriendsource = oidb_0xc26_undecideperson.msg_source.get();
                if (oidb_0xc26_addfriendsource.uint32_source.has()) {
                    i19 = oidb_0xc26_addfriendsource.uint32_source.get();
                }
                undeciedPersonRecommend.verifyFriendSource = i19;
                if (oidb_0xc26_undecideperson.rpt_msg_labels.has() && (list2 = oidb_0xc26_undecideperson.rpt_msg_labels.get()) != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(oidb_0xc26_undecideperson.rpt_msg_labels.computeSize(1));
                    try {
                        CodedOutputStreamMicro newInstance = CodedOutputStreamMicro.newInstance(byteArrayOutputStream);
                        oidb_0xc26_undecideperson.rpt_msg_labels.writeTo(newInstance, 1);
                        newInstance.flush();
                        undeciedPersonRecommend.msgLabelByte = byteArrayOutputStream.toByteArray();
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 1, "covServerVerifyUndeciedDataToLocal, rpt_msg_labels error: " + e16.toString());
                        }
                    }
                    undeciedPersonRecommend.msgLabel = convert0xc26ToMayKnowRecommendLabel(list2);
                }
                arrayList.add(undeciedPersonRecommend);
            }
        }
        return arrayList;
    }

    private static void parseBusiInfo(oidb_0xc26$MayKnowPerson oidb_0xc26_mayknowperson, MayKnowRecommend mayKnowRecommend) {
        mayKnowRecommend.busiDataList = new ArrayList();
        if (oidb_0xc26_mayknowperson.busi_info.has()) {
            List<oidb_0xc26$BusiData> list = oidb_0xc26_mayknowperson.busi_info.get();
            if (list != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(oidb_0xc26_mayknowperson.busi_info.computeSize(1));
                try {
                    CodedOutputStreamMicro newInstance = CodedOutputStreamMicro.newInstance(byteArrayOutputStream);
                    oidb_0xc26_mayknowperson.busi_info.writeTo(newInstance, 1);
                    newInstance.flush();
                    mayKnowRecommend.busiInfoListByte = byteArrayOutputStream.toByteArray();
                } catch (IOException e16) {
                    QLog.e(TAG, 1, "parseBusiInfo error: " + e16);
                }
                Iterator<oidb_0xc26$BusiData> it = list.iterator();
                while (it.hasNext()) {
                    mayKnowRecommend.busiDataList.add(PYMKBusiData.convertToPYMKBusiData(it.next()));
                }
            }
            if (!mayKnowRecommend.busiDataList.isEmpty()) {
                QLog.i(TAG, 1, "parseBusiInfo, uin" + mayKnowRecommend.uin + " busiDataList size: " + mayKnowRecommend.busiDataList.size());
            }
        }
    }

    private static String parseMultiReason(List<oidb_0xc26$MultiReason> list) {
        if (list != null && list.size() > 1) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                oidb_0xc26$MultiReason oidb_0xc26_multireason = list.get(i3);
                if (oidb_0xc26_multireason.reason.has()) {
                    sb5.append(oidb_0xc26_multireason.reason.get().toStringUtf8());
                    if (i3 < list.size() - 1) {
                        sb5.append(APLogFileUtil.SEPARATOR_LOG);
                    }
                }
            }
            return sb5.toString();
        }
        return "";
    }

    private void readBusiInfo() {
        byte[] bArr = this.busiInfoListByte;
        if (bArr != null && bArr.length > 0) {
            CodedInputStreamMicro newInstance = CodedInputStreamMicro.newInstance(bArr);
            PBRepeatMessageField initRepeatMessage = PBField.initRepeatMessage(oidb_0xc26$BusiData.class);
            while (!newInstance.isAtEnd()) {
                try {
                    newInstance.readTag();
                    initRepeatMessage.readFrom(newInstance);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "readBusiInfo, error: " + e16);
                    }
                }
            }
            this.busiDataList = new ArrayList();
            Iterator it = initRepeatMessage.get().iterator();
            while (it.hasNext()) {
                this.busiDataList.add(PYMKBusiData.convertToPYMKBusiData((oidb_0xc26$BusiData) it.next()));
            }
        }
    }

    public String getDisplayName() {
        if (!TextUtils.isEmpty(this.remark)) {
            return this.remark;
        }
        if (!TextUtils.isEmpty(this.nick)) {
            return this.nick;
        }
        return this.uin;
    }

    public String getMultiReason() {
        if (!TextUtils.isEmpty(this.multiReason)) {
            return this.multiReason;
        }
        if (!TextUtils.isEmpty(this.recommendReason)) {
            return this.recommendReason;
        }
        return "";
    }

    @Nullable
    public String getRecommendName() {
        if (!TextUtils.isEmpty(this.remark)) {
            return this.remark;
        }
        return null;
    }

    public RichStatus getRichStatus() {
        if (this.richStatus == null) {
            this.richStatus = RichStatus.parseStatus(this.richSingature);
        }
        return this.richStatus;
    }

    public byte[] getToken() {
        if (TextUtils.isEmpty(this.strToken)) {
            return null;
        }
        return this.strToken.getBytes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        byte[] bArr = this.msgLabelByte;
        if (bArr != null && bArr.length > 0) {
            CodedInputStreamMicro newInstance = CodedInputStreamMicro.newInstance(bArr);
            PBRepeatMessageField initRepeatMessage = PBField.initRepeatMessage(oidb_0xc26$Label.class);
            while (!newInstance.isAtEnd()) {
                try {
                    newInstance.readTag();
                    initRepeatMessage.readFrom(newInstance);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "postRead, error: " + e16.toString());
                    }
                }
            }
            this.msgLabel = convert0xc26ToMayKnowRecommendLabel(initRepeatMessage.get());
        }
        readBusiInfo();
        if (!TextUtils.isEmpty(this.mediaInfosPacked)) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.mediaInfosPacked);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                    arrayList.add(new MediaInfo(jSONObject.optInt("mediaType"), jSONObject.optString("picUrl"), jSONObject.optString("text"), jSONObject.optString("reportData"), jSONObject.optBoolean("hasPic")));
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            this.mediaInfos = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        super.prewrite();
        List<MediaInfo> list = this.mediaInfos;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (MediaInfo mediaInfo : this.mediaInfos) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mediaType", mediaInfo.getMediaType());
                    jSONObject.put("picUrl", mediaInfo.getPicUrl());
                    jSONObject.put("text", mediaInfo.getText());
                    jSONObject.put("reportData", mediaInfo.getReportData());
                    jSONObject.put("hasPic", mediaInfo.getHasPic());
                    jSONArray.mo162put(jSONObject);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            this.mediaInfosPacked = jSONArray.toString();
        }
    }

    public String toString() {
        int size;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MayKnowRecommend:{");
        sb5.append(this.uin);
        sb5.append(",");
        List<MayKnowRecommendLabel> list = this.msgLabel;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        sb5.append(" ,");
        sb5.append(this.cardDisplayTimestamp);
        sb5.append(",media:");
        sb5.append(this.mediaInfos);
        sb5.append(" qzone:");
        sb5.append(this.qZoneFeedsCnt);
        sb5.append("}");
        return sb5.toString();
    }

    public static ArrayList<MayKnowRecommend> covServerDataToLocal(List<oidb_0xc26$MayKnowPerson> list, int i3, int i16, String str, String str2) {
        if (list == null) {
            return new ArrayList<>();
        }
        ArrayList<MayKnowRecommend> arrayList = new ArrayList<>();
        Iterator<oidb_0xc26$MayKnowPerson> it = list.iterator();
        while (it.hasNext()) {
            MayKnowRecommend convertServerDataToLocal = convertServerDataToLocal(i3, i16, str, str2, it.next());
            if (convertServerDataToLocal != null) {
                arrayList.add(convertServerDataToLocal);
            }
        }
        return arrayList;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MayKnowRecommend m171clone() {
        try {
            MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) super.clone();
            if (this.mediaInfos != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<MediaInfo> it = this.mediaInfos.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().copyData());
                }
                mayKnowRecommend.mediaInfos = arrayList;
            }
            if (this.msgLabel != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<MayKnowRecommendLabel> it5 = this.msgLabel.iterator();
                while (it5.hasNext()) {
                    arrayList2.add((MayKnowRecommendLabel) it5.next().m173clone());
                }
                mayKnowRecommend.msgLabel = arrayList2;
            }
            if (this.busiDataList != null) {
                ArrayList arrayList3 = new ArrayList();
                Iterator<PYMKBusiData> it6 = this.busiDataList.iterator();
                while (it6.hasNext()) {
                    arrayList3.add(it6.next().m213clone());
                }
                mayKnowRecommend.busiDataList = arrayList3;
            }
            return mayKnowRecommend;
        } catch (CloneNotSupportedException e16) {
            QLog.w(TAG, 1, "clone error " + e16);
            return this;
        }
    }
}
