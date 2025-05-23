package com.tencent.mobileqq.profilecard.processor;

import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCard.AddFrdSrcInfo;
import SummaryCard.BindPhoneInfo;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import SummaryCard.TCoverInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.ProfileColor;
import com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.extendfriend.GetExtendFriendInfo$RspBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo$schoolInfo;
import com.tencent.pb.personal.PersonalInfo$ReqBody;
import com.tencent.pb.profilecard.SummaryCardBusiEntry$Label;
import com.tencent.pb.profilecard.SummaryCardBusiEntry$comm;
import com.tencent.pb.profilecard.SummaryCardBusiEntry$ui_info;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class DefaultProfileBusinessProcessor extends AbsProfileBusinessProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_PROFILE_SHOW_MUSIC_DNA_SWITCH = "profile_show_music_dna_switch_908_115428226";
    private static final String TAG = "DefaultProfileBusinessProcessor";
    private ProfileLocationCodes profileLocationCodes;

    public DefaultProfileBusinessProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void handleGetDetailInfoInner1(ByteBuffer byteBuffer, short s16, short s17, Long l3, Card card, ProfileLocationCodes profileLocationCodes) {
        if (s16 != 20002) {
            if (s16 != 20009) {
                if (s16 != 20011) {
                    if (s16 != 20019) {
                        if (s16 != 20037) {
                            if (s16 != 20041) {
                                if (s16 != 20043) {
                                    if (s16 != 24002) {
                                        if (s16 != 24008) {
                                            if (s16 != 27037) {
                                                if (s16 != 20021) {
                                                    if (s16 != 20022) {
                                                        if (s16 != 20031) {
                                                            if (s16 == 20032) {
                                                                int i3 = byteBuffer.getInt();
                                                                int i16 = byteBuffer.getInt();
                                                                int i17 = byteBuffer.getInt();
                                                                profileLocationCodes.gotLocation = true;
                                                                profileLocationCodes.locCountryCode = ProfileCodecUtils.decodeRemoteCode(i3);
                                                                profileLocationCodes.locProvinceCode = ProfileCodecUtils.decodeRemoteCode(i16);
                                                                profileLocationCodes.locCityCode = ProfileCodecUtils.decodeRemoteCode(i17);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        long j3 = byteBuffer.getInt();
                                                        card.lBirthday = j3;
                                                        if (j3 == 0) {
                                                            card.constellation = 0;
                                                            return;
                                                        } else {
                                                            card.constellation = Utils.r((int) ((65280 & j3) >> 8), (int) (j3 & 255));
                                                            return;
                                                        }
                                                    }
                                                    card.constellation = byteBuffer.get();
                                                    return;
                                                }
                                                byte[] bArr = new byte[s17];
                                                byteBuffer.get(bArr);
                                                card.strSchool = new String(bArr);
                                                return;
                                            }
                                            card.iProfession = byteBuffer.getInt();
                                            return;
                                        }
                                        byte[] bArr2 = new byte[s17];
                                        byteBuffer.get(bArr2);
                                        card.strCompany = new String(bArr2);
                                        return;
                                    }
                                    int i18 = byteBuffer.getInt();
                                    int i19 = byteBuffer.getInt();
                                    int i26 = byteBuffer.getInt();
                                    profileLocationCodes.gotHometown = true;
                                    profileLocationCodes.homeCountryCode = ProfileCodecUtils.decodeRemoteCode(i18);
                                    profileLocationCodes.homeProvinceCode = ProfileCodecUtils.decodeRemoteCode(i19);
                                    profileLocationCodes.homeCityCode = ProfileCodecUtils.decodeRemoteCode(i26);
                                    return;
                                }
                                int i27 = byteBuffer.getInt();
                                profileLocationCodes.gotHometown = true;
                                profileLocationCodes.homeDistrictCode = ProfileCodecUtils.decodeRemoteCode(i27);
                                return;
                            }
                            int i28 = byteBuffer.getInt();
                            profileLocationCodes.gotLocation = true;
                            profileLocationCodes.locDistrictCode = ProfileCodecUtils.decodeRemoteCode(i28);
                            return;
                        }
                        card.age = byteBuffer.get();
                        return;
                    }
                    byte[] bArr3 = new byte[s17];
                    byteBuffer.get(bArr3);
                    card.strPersonalNote = new String(bArr3);
                    return;
                }
                byte[] bArr4 = new byte[s17];
                byteBuffer.get(bArr4);
                card.strEmail = new String(bArr4);
                return;
            }
            byte b16 = byteBuffer.get();
            if (b16 == 1) {
                card.shGender = (short) 0;
                return;
            } else if (b16 == 2) {
                card.shGender = (short) 1;
                return;
            } else {
                card.shGender = (short) -1;
                return;
            }
        }
        byte[] bArr5 = new byte[s17];
        byteBuffer.get(bArr5);
        card.strNick = new String(bArr5);
    }

    private void handleGetDetailInfoInner2(ByteBuffer byteBuffer, short s16, short s17, Long l3, Card card) {
        boolean z16;
        if (s16 != -23364) {
            if (s16 != -23196) {
                if (s16 != -23180) {
                    if (s16 != -23175) {
                        if (s16 != -23169) {
                            if (s16 != -23159) {
                                if (s16 != -20368) {
                                    if (s16 == -18335) {
                                        card.switchMetaFarm = byteBuffer.getShort();
                                        return;
                                    }
                                    return;
                                }
                                card.offlineStickyNote = byteBuffer.getShort();
                                return;
                            }
                            card.switchWeiShi = byteBuffer.getShort();
                            return;
                        }
                        card.switchLifeAchievement = byteBuffer.getShort();
                        return;
                    }
                    card.switchQQCircle = byteBuffer.getShort();
                    return;
                }
                card.switchStickyNote = byteBuffer.getShort();
                return;
            }
            card.switchMusicBox = byteBuffer.getShort();
            return;
        }
        if (byteBuffer.getShort() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        card.isShowCard = z16;
    }

    private void processProfileCardWithCover(Card card, RespSummaryCard respSummaryCard) {
        TCoverInfo tCoverInfo = respSummaryCard.stCoverInfo;
        if (tCoverInfo != null) {
            card.updateCoverData(tCoverInfo.vTagInfo);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileCardWithCover coverInfo.url=", card.getCoverData(0)[0]));
            }
        }
    }

    private void processProfileCardWithDiamonds(Card card, RespSummaryCard respSummaryCard) {
        Map<Integer, VipOpenInfo> mOpenInfo;
        VipBaseInfo vipBaseInfo = respSummaryCard.stDiamonds;
        if (vipBaseInfo != null && (mOpenInfo = vipBaseInfo.getMOpenInfo()) != null) {
            VipOpenInfo vipOpenInfo = mOpenInfo.get(101);
            if (vipOpenInfo != null) {
                if (vipOpenInfo.bOpen) {
                    card.isRedDiamond = true;
                    if ((vipOpenInfo.iVipFlag & 1) > 0) {
                        card.isSuperRedDiamond = true;
                    }
                }
                card.redLevel = vipOpenInfo.iVipLevel;
            }
            VipOpenInfo vipOpenInfo2 = mOpenInfo.get(102);
            if (vipOpenInfo2 != null) {
                if (vipOpenInfo2.bOpen) {
                    card.isYellowDiamond = true;
                    if ((vipOpenInfo2.iVipFlag & 1) > 0) {
                        card.isSuperYellowDiamond = true;
                    }
                }
                card.yellowLevel = vipOpenInfo2.iVipLevel;
            }
            VipOpenInfo vipOpenInfo3 = mOpenInfo.get(103);
            if (vipOpenInfo3 != null) {
                if (vipOpenInfo3.bOpen) {
                    card.isGreenDiamond = true;
                    if ((vipOpenInfo3.iVipFlag & 1) > 0) {
                        card.isSuperGreenDiamond = true;
                    }
                }
                card.greenLevel = vipOpenInfo3.iVipLevel;
            }
        }
    }

    private void processProfileCardWithExtendFriend(Card card, RespSummaryCard respSummaryCard) {
        String str;
        String str2;
        int i3;
        long j3;
        int i16;
        long j16;
        if (respSummaryCard.vExtendCard != null) {
            try {
                GetExtendFriendInfo$RspBody getExtendFriendInfo$RspBody = new GetExtendFriendInfo$RspBody();
                getExtendFriendInfo$RspBody.mergeFrom(respSummaryCard.vExtendCard);
                if (getExtendFriendInfo$RspBody.bytes_declaration.has()) {
                    str = getExtendFriendInfo$RspBody.bytes_declaration.get().toStringUtf8();
                } else {
                    str = null;
                }
                if (getExtendFriendInfo$RspBody.bytes_voice_url.has()) {
                    str2 = getExtendFriendInfo$RspBody.bytes_voice_url.get().toStringUtf8();
                } else {
                    str2 = null;
                }
                if (getExtendFriendInfo$RspBody.uint32_popularity.has()) {
                    i3 = getExtendFriendInfo$RspBody.uint32_popularity.get();
                } else {
                    i3 = 0;
                }
                if (getExtendFriendInfo$RspBody.uint64_update_time.has()) {
                    j3 = getExtendFriendInfo$RspBody.uint64_update_time.get();
                } else {
                    j3 = 0;
                }
                if (getExtendFriendInfo$RspBody.uint32_voice_duration.has()) {
                    i16 = getExtendFriendInfo$RspBody.uint32_voice_duration.get();
                } else {
                    i16 = 0;
                }
                PersonalInfo$ReqBody personalInfo$ReqBody = new PersonalInfo$ReqBody();
                personalInfo$ReqBody.mergeFrom(getExtendFriendInfo$RspBody.bytes_personalization.get().toByteArray());
                int i17 = personalInfo$ReqBody.fontid.get();
                int i18 = personalInfo$ReqBody.fonttype.get();
                int i19 = personalInfo$ReqBody.itemid.get();
                card.fontId = i17;
                card.fontType = i18;
                card.clothesId = i19;
                card.declaration = str;
                card.popularity = i3;
                card.voiceUrl = str2;
                card.updateTime = j3;
                card.extendFriendVoiceDuration = i16;
                if (getExtendFriendInfo$RspBody.rpt_school_info.has() && getExtendFriendInfo$RspBody.rpt_school_info.get().get(0).has()) {
                    GetExtendFriendInfo$schoolInfo getExtendFriendInfo$schoolInfo = getExtendFriendInfo$RspBody.rpt_school_info.get().get(0);
                    card.schoolId = getExtendFriendInfo$schoolInfo.str_school_id.get();
                    card.schoolName = getExtendFriendInfo$schoolInfo.str_school_name.get();
                    j16 = j3;
                    card.authState = getExtendFriendInfo$schoolInfo.uint64_state.get();
                    card.idx = getExtendFriendInfo$schoolInfo.uint32_idx.get();
                    card.category = getExtendFriendInfo$schoolInfo.uint32_category.get();
                } else {
                    j16 = j3;
                    card.schoolId = null;
                    card.schoolName = null;
                    card.authState = -1L;
                    card.idx = -1;
                    card.category = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, String.format("processProfileCardWithExtendFriend popularity=%s declaration=%s voiceUrl=%s updateTime=%s duration=%s fontId=%s fontType=%s clothesId=%s", Integer.valueOf(i3), str, str2, Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19)));
                    QLog.d(TAG, 2, String.format("processProfileCardWithExtendFriend schoolName=%s schoolId=%s authState=%s", card.schoolName, card.schoolId, Long.valueOf(card.authState)));
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
    }

    private void processProfileCardWithGetControl(Card card, RespSummaryCard respSummaryCard, long j3, String str) {
        boolean z16;
        if ((1 & j3) != 0) {
            String str2 = respSummaryCard.strShowName;
            card.strShowName = str2;
            if (TextUtils.isEmpty(str2)) {
                card.strShowName = str;
            }
        }
        if ((4 & j3) != 0) {
            card.vRichSign = respSummaryCard.vRichSign;
            card.lSignModifyTime = respSummaryCard.uSignModifyTime;
        }
        if ((65536 & j3) != 0) {
            card.vLongNickTopicInfo = respSummaryCard.vLongNickTopicInfo;
        }
        if ((j3 & 16) != 0) {
            card.lLoginDays = respSummaryCard.uLoginDays;
            card.strLoginDaysDesc = respSummaryCard.strLoginDesc;
        }
        if ((j3 & 8) != 0) {
            long j16 = respSummaryCard.lUserFlag;
            card.lUserFlag = j16;
            boolean z17 = true;
            if ((j16 & 8) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            card.allowClick = z16;
            if (!str.equals(this.appRuntime.getAccount())) {
                if ((16 & card.lUserFlag) == 0) {
                    z17 = false;
                }
                card.allowPeopleSee = z17;
            }
        }
    }

    private void processProfileCardWithHobbies(Card card, RespSummaryCard respSummaryCard) {
        int length;
        int i3;
        int i16;
        SummaryCardBusiEntry$comm summaryCardBusiEntry$comm;
        SummaryCardBusiEntry$comm summaryCardBusiEntry$comm2;
        ProfileColor profileColor;
        RespSummaryCard respSummaryCard2 = respSummaryCard;
        ArrayList arrayList = new ArrayList();
        ArrayList<byte[]> arrayList2 = respSummaryCard2.vvRespServicesBigOrder;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int i17 = 0;
            int i18 = 0;
            while (i18 < respSummaryCard2.vvRespServicesBigOrder.size()) {
                byte[] bArr = respSummaryCard2.vvRespServicesBigOrder.get(i18);
                if (bArr == null) {
                    length = i17;
                } else {
                    length = bArr.length;
                }
                if (length > 10) {
                    int i19 = 1;
                    int longData = (int) PkgTools.getLongData(bArr, 1);
                    PkgTools.getLongData(bArr, 5);
                    if (longData > 0 && 9 + longData < length) {
                        byte[] bArr2 = new byte[longData];
                        PkgTools.copyData(bArr2, i17, bArr, 9, longData);
                        SummaryCardBusiEntry$comm summaryCardBusiEntry$comm3 = new SummaryCardBusiEntry$comm();
                        try {
                            summaryCardBusiEntry$comm3.mergeFrom(bArr2);
                            int i26 = summaryCardBusiEntry$comm3.result.get();
                            ProfileSummaryHobbiesEntry profileSummaryHobbiesEntry = new ProfileSummaryHobbiesEntry();
                            if (i26 == 0) {
                                profileSummaryHobbiesEntry.strName = summaryCardBusiEntry$comm3.msg_rich_display.strName.get();
                                profileSummaryHobbiesEntry.strServiceUrl = summaryCardBusiEntry$comm3.msg_rich_display.strServiceUrl.get();
                                profileSummaryHobbiesEntry.serviceType = summaryCardBusiEntry$comm3.service.get();
                                ArrayList<ProfileSummaryHobbiesItem> arrayList3 = new ArrayList<>();
                                int i27 = i17;
                                while (i27 < summaryCardBusiEntry$comm3.msg_rich_display.rptUiList.size()) {
                                    SummaryCardBusiEntry$ui_info summaryCardBusiEntry$ui_info = summaryCardBusiEntry$comm3.msg_rich_display.rptUiList.get(i27);
                                    ProfileSummaryHobbiesItem profileSummaryHobbiesItem = new ProfileSummaryHobbiesItem();
                                    profileSummaryHobbiesItem.strTitle = summaryCardBusiEntry$ui_info.strTitle.get();
                                    profileSummaryHobbiesItem.strCoverUrl = summaryCardBusiEntry$ui_info.strCoverUrl.get();
                                    profileSummaryHobbiesItem.strJmpUrl = summaryCardBusiEntry$ui_info.strJmpUrl.get();
                                    profileSummaryHobbiesItem.strSubInfo = summaryCardBusiEntry$ui_info.strSubInfo.get();
                                    profileSummaryHobbiesItem.strDesc = summaryCardBusiEntry$ui_info.strDesc.get();
                                    profileSummaryHobbiesItem.strTitleIconUrl = summaryCardBusiEntry$ui_info.strTitleIconUrl.get();
                                    profileSummaryHobbiesItem.groupCode = summaryCardBusiEntry$ui_info.uint64_group_code.get();
                                    profileSummaryHobbiesItem.serviceType = profileSummaryHobbiesEntry.serviceType;
                                    if (i18 == 0) {
                                        if (i27 == 0) {
                                            profileSummaryHobbiesItem.service = i17;
                                        } else {
                                            profileSummaryHobbiesItem.service = i19;
                                        }
                                    }
                                    if (summaryCardBusiEntry$ui_info.rptGroupTagList.size() > 0) {
                                        ArrayList<ProfileGroupLabel> arrayList4 = new ArrayList<>();
                                        int i28 = i17;
                                        while (i28 < summaryCardBusiEntry$ui_info.rptGroupTagList.size()) {
                                            SummaryCardBusiEntry$Label summaryCardBusiEntry$Label = summaryCardBusiEntry$ui_info.rptGroupTagList.get(i28);
                                            ProfileGroupLabel profileGroupLabel = new ProfileGroupLabel();
                                            try {
                                                profileGroupLabel.strWording = summaryCardBusiEntry$Label.bytes_name.get().toStringUtf8();
                                                profileGroupLabel.type = summaryCardBusiEntry$Label.uint32_label_type.get();
                                                summaryCardBusiEntry$comm2 = summaryCardBusiEntry$comm3;
                                                profileGroupLabel.attr = summaryCardBusiEntry$Label.uint32_label_attr.get();
                                                profileColor = new ProfileColor();
                                                i3 = i18;
                                            } catch (Exception e16) {
                                                e = e16;
                                                i3 = i18;
                                            }
                                            try {
                                                profileColor.red = summaryCardBusiEntry$Label.edging_color.uint32_r.get();
                                                profileColor.green = summaryCardBusiEntry$Label.edging_color.uint32_g.get();
                                                profileColor.blue = summaryCardBusiEntry$Label.edging_color.uint32_b.get();
                                                profileGroupLabel.edgingColor = profileColor;
                                                ProfileColor profileColor2 = new ProfileColor();
                                                profileColor2.red = summaryCardBusiEntry$Label.text_color.uint32_r.get();
                                                profileColor2.green = summaryCardBusiEntry$Label.text_color.uint32_g.get();
                                                profileColor2.blue = summaryCardBusiEntry$Label.text_color.uint32_b.get();
                                                profileGroupLabel.textColor = profileColor2;
                                                arrayList4.add(profileGroupLabel);
                                                i28++;
                                                summaryCardBusiEntry$comm3 = summaryCardBusiEntry$comm2;
                                                i18 = i3;
                                            } catch (Exception e17) {
                                                e = e17;
                                                i16 = 0;
                                                QLog.e(TAG, 1, "processProfileCardWithHobbies fail.", e);
                                                respSummaryCard2 = respSummaryCard;
                                                i17 = i16;
                                                i18 = i3 + 1;
                                            }
                                        }
                                        summaryCardBusiEntry$comm = summaryCardBusiEntry$comm3;
                                        i3 = i18;
                                        profileSummaryHobbiesItem.labels = arrayList4;
                                    } else {
                                        summaryCardBusiEntry$comm = summaryCardBusiEntry$comm3;
                                        i3 = i18;
                                    }
                                    arrayList3.add(profileSummaryHobbiesItem);
                                    if (QLog.isColorLevel()) {
                                        Object[] objArr = new Object[3];
                                        i16 = 0;
                                        try {
                                            objArr[0] = profileSummaryHobbiesItem.strTitle;
                                            objArr[1] = Integer.valueOf(profileSummaryHobbiesItem.serviceType);
                                            objArr[2] = profileSummaryHobbiesItem.strJmpUrl;
                                            QLog.d(TAG, 2, String.format("HobbiesEntry Item strTitle=%s serviceType=%s strJmpUrl=%s", objArr));
                                        } catch (Exception e18) {
                                            e = e18;
                                            QLog.e(TAG, 1, "processProfileCardWithHobbies fail.", e);
                                            respSummaryCard2 = respSummaryCard;
                                            i17 = i16;
                                            i18 = i3 + 1;
                                        }
                                    }
                                    i27++;
                                    summaryCardBusiEntry$comm3 = summaryCardBusiEntry$comm;
                                    i18 = i3;
                                    i17 = 0;
                                    i19 = 1;
                                }
                                i3 = i18;
                                profileSummaryHobbiesEntry.sProfileSummaryHobbiesItem = arrayList3;
                            } else {
                                i3 = i18;
                            }
                            arrayList.add(profileSummaryHobbiesEntry);
                            if (QLog.isColorLevel()) {
                                Object[] objArr2 = new Object[3];
                                i16 = 0;
                                objArr2[0] = profileSummaryHobbiesEntry.strName;
                                objArr2[1] = profileSummaryHobbiesEntry.strServiceType;
                                objArr2[2] = profileSummaryHobbiesEntry.strServiceUrl;
                                QLog.d(TAG, 2, String.format("HobbiesEntry strName=%s strServiceType=%s strServiceUrl=%s", objArr2));
                            } else {
                                i16 = 0;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            i3 = i18;
                            i16 = i17;
                        }
                        respSummaryCard2 = respSummaryCard;
                        i17 = i16;
                        i18 = i3 + 1;
                    }
                }
                i3 = i18;
                i16 = i17;
                respSummaryCard2 = respSummaryCard;
                i17 = i16;
                i18 = i3 + 1;
            }
        }
        card.saveBigOrderEntrys(arrayList);
    }

    private void processProfileCardWithVisitingCard(Card card, RespSummaryCard respSummaryCard) {
        AddFrdSrcInfo addFrdSrcInfo = respSummaryCard.stAddFrdSrcInfo;
        if (addFrdSrcInfo != null) {
            card.addSrcName = addFrdSrcInfo.strSrcName;
            card.addSrcId = addFrdSrcInfo.uSrcId;
            card.addSubSrcId = addFrdSrcInfo.uSubSrcId;
        }
        BindPhoneInfo bindPhoneInfo = respSummaryCard.stBindPhoneInfo;
        if (bindPhoneInfo != null) {
            card.bindPhoneInfo = bindPhoneInfo.strName;
        }
        byte[] bArr = respSummaryCard.vVisitingCardInfo;
        if (bArr != null) {
            card.bCardInfo = bArr;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailRequestForLogin(List<Short> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        list.add(Short.valueOf(ProfileContants.FIELD_GET_BIRTHDAY));
        list.add(Short.valueOf(ProfileContants.FIELD_AGE));
        list.add(Short.valueOf(ProfileContants.FIELD_SEX));
        list.add(Short.valueOf(ProfileContants.FIELD_QZONE_LOCATION));
        list.add(Short.valueOf(ProfileContants.FIELD_QZONE_LOCATION_DISTRICT));
        list.add((short) -25217);
        list.add((short) -23754);
        list.add((short) -24980);
        list.add((short) -23723);
        list.add((short) 27055);
        list.add((short) -23488);
        list.add(Short.valueOf(ProfileContants.FIELD_NEW_NICKNAME));
        list.add((short) -23753);
        list.add((short) -25200);
        list.add((short) -23533);
        list.add((short) -23537);
        list.add((short) -22556);
        list.add((short) 27059);
        list.add((short) -25019);
        list.add((short) -23306);
        list.add((short) 27206);
        list.add((short) 27210);
        list.add((short) -23543);
        list.add((short) -23538);
        list.add(Short.valueOf(ProfileContants.FIELD_PC_PUSH_PHONEQQ));
        list.add(Short.valueOf(ProfileContants.FIELD_HELLO_LIVE_MESSAGE));
        list.add((short) -23502);
        list.add((short) -23461);
        list.add((short) -25188);
        list.add((short) -23282);
        list.add((short) -25155);
        list.add((short) -23456);
        list.add((short) -23366);
        list.add((short) -23364);
        list.add((short) -23322);
        list.add((short) -23326);
        list.add((short) -23325);
        list.add(Short.valueOf(ProfileContants.FIELD_DANCE_MAX_SCORE));
        list.add(Short.valueOf(ProfileContants.FIELD_SHOW_PUSH_NOTICE_SWITCH));
        list.add(Short.valueOf(ProfileContants.FIELD_AUTO_TO_TEXT_OFFLINE_FLAG));
        list.add((short) -23221);
        list.add((short) -23172);
        list.add((short) -23046);
        list.add((short) -23106);
        list.add((short) -23108);
        list.add((short) -23107);
        list.add((short) -23143);
        list.add((short) -23103);
        list.add((short) -23102);
        list.add((short) 27390);
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailResponseBegin(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        } else {
            this.profileLocationCodes = null;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLV(Bundle bundle, long j3, Card card, short s16, short s17, ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, bundle, Long.valueOf(j3), card, Short.valueOf(s16), Short.valueOf(s17), byteBuffer);
        } else {
            handleGetDetailInfoInner1(byteBuffer, s16, s17, Long.valueOf(j3), card, this.profileLocationCodes);
            handleGetDetailInfoInner2(byteBuffer, s16, s17, Long.valueOf(j3), card);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLVBegin(Bundle bundle, long j3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bundle, Long.valueOf(j3), card);
        } else {
            this.profileLocationCodes = new ProfileLocationCodes(null);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
    public void onGetProfileDetailTLVEnd(Bundle bundle, long j3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bundle, Long.valueOf(j3), card);
            return;
        }
        this.profileLocationCodes.getLocationCodes(card);
        ProfileLocationCodes profileLocationCodes = this.profileLocationCodes;
        if (profileLocationCodes.gotLocation || profileLocationCodes.gotHometown) {
            bundle.putBoolean(IProfileProtocolConst.KEY_PARSE_PROFILE_LOCATION, true);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileCard(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bundle, card, respHead, respSummaryCard);
            return;
        }
        long j3 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        int i3 = bundle.getInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE);
        long j16 = bundle.getLong(IProfileProtocolConst.PARAM_GET_CONTROL);
        String valueOf = String.valueOf(j3);
        card.iQQLevel = respSummaryCard.iLevel;
        card.strNick = respSummaryCard.strNick;
        card.shGender = respSummaryCard.bSex;
        card.uCurMulType = respSummaryCard.uCurMulType;
        card.age = respSummaryCard.bAge;
        card.lBirthday = respSummaryCard.iBirthday;
        card.strEmail = respSummaryCard.strEmail;
        card.nFaceID = respSummaryCard.iFace;
        card.strSign = respSummaryCard.strSign;
        card.strCity = respSummaryCard.strCity;
        card.strProvince = respSummaryCard.strProvince;
        card.strCountry = respSummaryCard.strCountry;
        card.strReMark = respSummaryCard.strRemark;
        card.strMobile = respSummaryCard.strMobile;
        card.strContactName = respSummaryCard.strContactName;
        card.strStatus = respSummaryCard.strStatus;
        card.strAutoRemark = respSummaryCard.strAutoRemark;
        card.vSeed = respSummaryCard.vSeed;
        card.lVisitCount = respSummaryCard.iVoteCount;
        card.lQQMasterLogindays = respSummaryCard.uQQMasterLoginDays;
        card.favoriteSource = i3;
        if (i3 == 37) {
            card.encId = bundle.getString(IProfileProtocolConst.PARAM_SEARCH_NAME);
        }
        long j17 = respSummaryCard.ulShowControl;
        card.ulShowControl = (int) j17;
        if ((j17 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        card.setFeedsShowFlag(z16);
        if ((respSummaryCard.ulShowControl & 2) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        card.setPhotoShowFlag(z17);
        if ((respSummaryCard.ulShowControl & 16) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        card.setXManFlag(z18);
        if (respSummaryCard.lCacheControl == 0) {
            z19 = false;
        }
        card.setPhotoUseCacheFlag(z19);
        card.setVipInfo(respSummaryCard.stVipInfo);
        processProfileCardWithGetControl(card, respSummaryCard, j16, valueOf);
        processProfileCardWithCover(card, respSummaryCard);
        processProfileCardWithDiamonds(card, respSummaryCard);
        processProfileCardWithHobbies(card, respSummaryCard);
        processProfileCardWithVisitingCard(card, respSummaryCard);
        processProfileCardWithExtendFriend(card, respSummaryCard);
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onRequestProfileCard(Bundle bundle, ArrayList<BusinessReqBuffer> arrayList, ArrayList<Integer> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bundle, arrayList, arrayList2);
            return;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(KEY_PROFILE_SHOW_MUSIC_DNA_SWITCH, true)) {
            arrayList.add(new BusinessReqBuffer(2, null));
        }
        arrayList.add(new BusinessReqBuffer(4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class ProfileLocationCodes {
        static IPatchRedirector $redirector_;
        public boolean gotHometown;
        public boolean gotLocation;
        public String homeCityCode;
        public String homeCountryCode;
        public String homeDistrictCode;
        public String homeProvinceCode;
        public String locCityCode;
        public String locCountryCode;
        public String locDistrictCode;
        public String locProvinceCode;

        ProfileLocationCodes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.gotLocation = false;
            this.gotHometown = false;
            this.locCountryCode = "0";
            this.locProvinceCode = "0";
            this.locCityCode = "0";
            this.locDistrictCode = "0";
            this.homeCountryCode = "0";
            this.homeProvinceCode = "0";
            this.homeCityCode = "0";
            this.homeDistrictCode = "0";
        }

        public void getLocationCodes(Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) card);
                return;
            }
            if (this.gotLocation) {
                card.strLocationCodes = this.locCountryCode + "-" + this.locProvinceCode + "-" + this.locCityCode + "-" + this.locDistrictCode;
            }
            if (this.gotHometown) {
                card.strHometownCodes = this.homeCountryCode + "-" + this.homeProvinceCode + "-" + this.homeCityCode + "-" + this.homeDistrictCode;
            }
        }

        /* synthetic */ ProfileLocationCodes(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }
    }
}
