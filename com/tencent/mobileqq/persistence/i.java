package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i extends OGAbstractDao {
    public i() {
        this.columnLen = 117;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public Entity cursor2Entity(Entity entity, Cursor cursor, boolean z16, NoColumnErrorHandler noColumnErrorHandler) {
        NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) entity;
        if (noColumnErrorHandler == null) {
            nearbyPeopleCard.tinyId = cursor.getLong(cursor.getColumnIndex("tinyId"));
            nearbyPeopleCard.uin = cursor.getString(cursor.getColumnIndex("uin"));
            nearbyPeopleCard.nowId = cursor.getLong(cursor.getColumnIndex("nowId"));
            nearbyPeopleCard.nowUserType = cursor.getInt(cursor.getColumnIndex("nowUserType"));
            nearbyPeopleCard.strRemark = cursor.getString(cursor.getColumnIndex("strRemark"));
            nearbyPeopleCard.nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            nearbyPeopleCard.gender = (byte) cursor.getShort(cursor.getColumnIndex("gender"));
            nearbyPeopleCard.age = cursor.getInt(cursor.getColumnIndex("age"));
            nearbyPeopleCard.birthday = cursor.getInt(cursor.getColumnIndex("birthday"));
            nearbyPeopleCard.sign = cursor.getString(cursor.getColumnIndex("sign"));
            nearbyPeopleCard.constellation = (byte) cursor.getShort(cursor.getColumnIndex(LpReport_UserInfo_dc02148.CONSTELLATION));
            nearbyPeopleCard.distance = cursor.getString(cursor.getColumnIndex(Element.ELEMENT_NAME_DISTANCE));
            nearbyPeopleCard.timeDiff = cursor.getString(cursor.getColumnIndex("timeDiff"));
            nearbyPeopleCard.aioDistanceAndTime = cursor.getString(cursor.getColumnIndex("aioDistanceAndTime"));
            nearbyPeopleCard.likeCount = cursor.getInt(cursor.getColumnIndex(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT));
            nearbyPeopleCard.likeCountInc = cursor.getInt(cursor.getColumnIndex("likeCountInc"));
            nearbyPeopleCard.oldPhotoCount = cursor.getInt(cursor.getColumnIndex("oldPhotoCount"));
            nearbyPeopleCard.dateInfo = cursor.getBlob(cursor.getColumnIndex("dateInfo"));
            nearbyPeopleCard.ulShowControl = cursor.getLong(cursor.getColumnIndex("ulShowControl"));
            nearbyPeopleCard.xuanYan = cursor.getBlob(cursor.getColumnIndex("xuanYan"));
            nearbyPeopleCard.maritalStatus = (byte) cursor.getShort(cursor.getColumnIndex("maritalStatus"));
            nearbyPeopleCard.job = cursor.getInt(cursor.getColumnIndex("job"));
            nearbyPeopleCard.company = cursor.getString(cursor.getColumnIndex(IProfileProtocolConst.KEY_COMPANY));
            nearbyPeopleCard.college = cursor.getString(cursor.getColumnIndex(IProfileProtocolConst.KEY_COLLEGE));
            nearbyPeopleCard.hometownCountry = cursor.getString(cursor.getColumnIndex("hometownCountry"));
            nearbyPeopleCard.hometownProvice = cursor.getString(cursor.getColumnIndex("hometownProvice"));
            nearbyPeopleCard.hometownCity = cursor.getString(cursor.getColumnIndex("hometownCity"));
            nearbyPeopleCard.hometownDistrict = cursor.getString(cursor.getColumnIndex("hometownDistrict"));
            nearbyPeopleCard.vCookies = cursor.getBlob(cursor.getColumnIndex("vCookies"));
            nearbyPeopleCard.bVoted = (byte) cursor.getShort(cursor.getColumnIndex("bVoted"));
            nearbyPeopleCard.feedPreviewTime = cursor.getLong(cursor.getColumnIndex("feedPreviewTime"));
            nearbyPeopleCard.qzoneFeed = cursor.getString(cursor.getColumnIndex("qzoneFeed"));
            nearbyPeopleCard.qzoneName = cursor.getString(cursor.getColumnIndex("qzoneName"));
            nearbyPeopleCard.qzonePicUrl_1 = cursor.getString(cursor.getColumnIndex("qzonePicUrl_1"));
            nearbyPeopleCard.qzonePicUrl_2 = cursor.getString(cursor.getColumnIndex("qzonePicUrl_2"));
            nearbyPeopleCard.qzonePicUrl_3 = cursor.getString(cursor.getColumnIndex("qzonePicUrl_3"));
            nearbyPeopleCard.isPhotoUseCache = 1 == cursor.getShort(cursor.getColumnIndex("isPhotoUseCache"));
            nearbyPeopleCard.vSeed = cursor.getBlob(cursor.getColumnIndex("vSeed"));
            nearbyPeopleCard.vTempChatSig = cursor.getBlob(cursor.getColumnIndex("vTempChatSig"));
            nearbyPeopleCard.vGroupList = cursor.getBlob(cursor.getColumnIndex("vGroupList"));
            nearbyPeopleCard.nearbyInfo = cursor.getBlob(cursor.getColumnIndex("nearbyInfo"));
            nearbyPeopleCard.vActivityList = cursor.getBlob(cursor.getColumnIndex("vActivityList"));
            nearbyPeopleCard.lUserFlag = cursor.getLong(cursor.getColumnIndex("lUserFlag"));
            nearbyPeopleCard.iIsGodFlag = cursor.getInt(cursor.getColumnIndex("iIsGodFlag"));
            nearbyPeopleCard.strGodJumpUrl = cursor.getString(cursor.getColumnIndex("strGodJumpUrl"));
            nearbyPeopleCard.mHeartNum = cursor.getInt(cursor.getColumnIndex("mHeartNum"));
            nearbyPeopleCard.switchQzone = 1 == cursor.getShort(cursor.getColumnIndex("switchQzone"));
            nearbyPeopleCard.switchHobby = 1 == cursor.getShort(cursor.getColumnIndex("switchHobby"));
            nearbyPeopleCard.uiShowControl = cursor.getLong(cursor.getColumnIndex("uiShowControl"));
            nearbyPeopleCard.userFlag = cursor.getLong(cursor.getColumnIndex("userFlag"));
            nearbyPeopleCard.busiEntry = cursor.getString(cursor.getColumnIndex("busiEntry"));
            nearbyPeopleCard.godFlag = 1 == cursor.getShort(cursor.getColumnIndex("godFlag"));
            nearbyPeopleCard.nLastGameFlag = cursor.getInt(cursor.getColumnIndex("nLastGameFlag"));
            nearbyPeopleCard.strProfileUrl = cursor.getString(cursor.getColumnIndex("strProfileUrl"));
            nearbyPeopleCard.lastUpdateNickTime = cursor.getLong(cursor.getColumnIndex("lastUpdateNickTime"));
            nearbyPeopleCard.favoriteSource = cursor.getInt(cursor.getColumnIndex("favoriteSource"));
            nearbyPeopleCard.switchGiftVisible = cursor.getLong(cursor.getColumnIndex("switchGiftVisible"));
            nearbyPeopleCard.vGiftInfo = cursor.getBlob(cursor.getColumnIndex("vGiftInfo"));
            nearbyPeopleCard.sayHelloFlag = cursor.getInt(cursor.getColumnIndex("sayHelloFlag"));
            nearbyPeopleCard.charm = cursor.getLong(cursor.getColumnIndex("charm"));
            nearbyPeopleCard.charmLevel = cursor.getInt(cursor.getColumnIndex("charmLevel"));
            nearbyPeopleCard.nextThreshold = cursor.getInt(cursor.getColumnIndex("nextThreshold"));
            nearbyPeopleCard.curThreshold = cursor.getInt(cursor.getColumnIndex("curThreshold"));
            nearbyPeopleCard.profPercent = cursor.getInt(cursor.getColumnIndex("profPercent"));
            nearbyPeopleCard.taskFinished = cursor.getInt(cursor.getColumnIndex("taskFinished"));
            nearbyPeopleCard.taskTotal = cursor.getInt(cursor.getColumnIndex("taskTotal"));
            nearbyPeopleCard.hiWanInfo = cursor.getString(cursor.getColumnIndex("hiWanInfo"));
            nearbyPeopleCard.commonLabelString = cursor.getString(cursor.getColumnIndex("commonLabelString"));
            nearbyPeopleCard.tagFlag = cursor.getLong(cursor.getColumnIndex("tagFlag"));
            nearbyPeopleCard.tagInfo = cursor.getString(cursor.getColumnIndex("tagInfo"));
            nearbyPeopleCard.picInfo = cursor.getString(cursor.getColumnIndex("picInfo"));
            nearbyPeopleCard.videoDetails = cursor.getString(cursor.getColumnIndex("videoDetails"));
            nearbyPeopleCard.strFreshNewsInfo = cursor.getString(cursor.getColumnIndex("strFreshNewsInfo"));
            nearbyPeopleCard.strHotChatInfo = cursor.getString(cursor.getColumnIndex("strHotChatInfo"));
            nearbyPeopleCard.uRoomid = cursor.getLong(cursor.getColumnIndex("uRoomid"));
            nearbyPeopleCard.strVoteLimitedNotice = cursor.getString(cursor.getColumnIndex("strVoteLimitedNotice"));
            nearbyPeopleCard.bHaveVotedCnt = cursor.getShort(cursor.getColumnIndex("bHaveVotedCnt"));
            nearbyPeopleCard.bAvailVoteCnt = cursor.getShort(cursor.getColumnIndex("bAvailVoteCnt"));
            nearbyPeopleCard.collegeId = cursor.getLong(cursor.getColumnIndex("collegeId"));
            nearbyPeopleCard.videoHeadFlag = 1 == cursor.getShort(cursor.getColumnIndex("videoHeadFlag"));
            nearbyPeopleCard.bVideoHeadUrl = cursor.getString(cursor.getColumnIndex("bVideoHeadUrl"));
            nearbyPeopleCard.faceScoreWordingColor = cursor.getInt(cursor.getColumnIndex("faceScoreWordingColor"));
            nearbyPeopleCard.faceScoreWording = cursor.getString(cursor.getColumnIndex("faceScoreWording"));
            nearbyPeopleCard.faceScoreTailWordingColor = cursor.getInt(cursor.getColumnIndex("faceScoreTailWordingColor"));
            nearbyPeopleCard.faceScoreTailWording = cursor.getString(cursor.getColumnIndex("faceScoreTailWording"));
            nearbyPeopleCard.faceScoreIconUrl = cursor.getString(cursor.getColumnIndex("faceScoreIconUrl"));
            nearbyPeopleCard.entryAbility = cursor.getInt(cursor.getColumnIndex("entryAbility"));
            nearbyPeopleCard.strLevelType = cursor.getString(cursor.getColumnIndex("strLevelType"));
            nearbyPeopleCard.maskMsgFlag = cursor.getInt(cursor.getColumnIndex("maskMsgFlag"));
            nearbyPeopleCard.isForbidSendMsg = 1 == cursor.getShort(cursor.getColumnIndex("isForbidSendMsg"));
            nearbyPeopleCard.isForbidSendGiftMsg = 1 == cursor.getShort(cursor.getColumnIndex("isForbidSendGiftMsg"));
            nearbyPeopleCard.disableSendMsgBtnTips = cursor.getString(cursor.getColumnIndex("disableSendMsgBtnTips"));
            nearbyPeopleCard.disableSendGiftBtnTips = cursor.getString(cursor.getColumnIndex("disableSendGiftBtnTips"));
            nearbyPeopleCard.isForbidSendMsgForTribar = 1 == cursor.getShort(cursor.getColumnIndex("isForbidSendMsgForTribar"));
            nearbyPeopleCard.isForbidSendGiftMsgForTribar = 1 == cursor.getShort(cursor.getColumnIndex("isForbidSendGiftMsgForTribar"));
            nearbyPeopleCard.disableSendMsgBtnTipsForTribar = cursor.getString(cursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
            nearbyPeopleCard.disableSendGiftBtnTipsForTribar = cursor.getString(cursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
            nearbyPeopleCard.highScoreNum = cursor.getInt(cursor.getColumnIndex("highScoreNum"));
            nearbyPeopleCard.mHasStory = 1 == cursor.getShort(cursor.getColumnIndex("mHasStory"));
            nearbyPeopleCard.mQQStoryData = cursor.getBlob(cursor.getColumnIndex("mQQStoryData"));
            nearbyPeopleCard.isSendMsgBtnDownloadAppOpen = 1 == cursor.getShort(cursor.getColumnIndex("isSendMsgBtnDownloadAppOpen"));
            nearbyPeopleCard.sendMsgBtnDownloadAppTips = cursor.getString(cursor.getColumnIndex("sendMsgBtnDownloadAppTips"));
            nearbyPeopleCard.addPicBtnDownloadAppTips = cursor.getString(cursor.getColumnIndex("addPicBtnDownloadAppTips"));
            nearbyPeopleCard.tribeAppDownloadPageUrl = cursor.getString(cursor.getColumnIndex("tribeAppDownloadPageUrl"));
            nearbyPeopleCard.nearbyNowDataBytes = cursor.getBlob(cursor.getColumnIndex("nearbyNowDataBytes"));
            nearbyPeopleCard.guideAppNowTip = cursor.getString(cursor.getColumnIndex("guideAppNowTip"));
            nearbyPeopleCard.guideAppNowTipLeftBtn = cursor.getString(cursor.getColumnIndex("guideAppNowTipLeftBtn"));
            nearbyPeopleCard.guideAppNowTipRightBtnInstalled = cursor.getString(cursor.getColumnIndex("guideAppNowTipRightBtnInstalled"));
            nearbyPeopleCard.guideAppNowTipRightBtnNotInstalled = cursor.getString(cursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled"));
            nearbyPeopleCard.guideAppNowPackage = cursor.getString(cursor.getColumnIndex("guideAppNowPackage"));
            nearbyPeopleCard.guideAppNowJumpUri = cursor.getString(cursor.getColumnIndex("guideAppNowJumpUri"));
            nearbyPeopleCard.guideAppNowDownloadUrl = cursor.getString(cursor.getColumnIndex("guideAppNowDownloadUrl"));
            nearbyPeopleCard.guideVerifiedDialogTitle = cursor.getString(cursor.getColumnIndex("guideVerifiedDialogTitle"));
            nearbyPeopleCard.guideVerifiedDialogRightBtnText = cursor.getString(cursor.getColumnIndex("guideVerifiedDialogRightBtnText"));
            nearbyPeopleCard.firstOfficialMsg = cursor.getString(cursor.getColumnIndex("firstOfficialMsg"));
            nearbyPeopleCard.unverifyGrayTips = cursor.getString(cursor.getColumnIndex("unverifyGrayTips"));
            nearbyPeopleCard.isVerified = 1 == cursor.getShort(cursor.getColumnIndex("isVerified"));
        } else {
            int columnIndex = cursor.getColumnIndex("tinyId");
            if (columnIndex == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("tinyId", Long.TYPE));
            } else {
                nearbyPeopleCard.tinyId = cursor.getLong(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("uin");
            if (columnIndex2 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
            } else {
                nearbyPeopleCard.uin = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("nowId");
            if (columnIndex3 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("nowId", Long.TYPE));
            } else {
                nearbyPeopleCard.nowId = cursor.getLong(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("nowUserType");
            if (columnIndex4 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("nowUserType", Integer.TYPE));
            } else {
                nearbyPeopleCard.nowUserType = cursor.getInt(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("strRemark");
            if (columnIndex5 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strRemark", String.class));
            } else {
                nearbyPeopleCard.strRemark = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("nickname");
            if (columnIndex6 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("nickname", String.class));
            } else {
                nearbyPeopleCard.nickname = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("gender");
            if (columnIndex7 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("gender", Byte.TYPE));
            } else {
                nearbyPeopleCard.gender = (byte) cursor.getShort(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("age");
            if (columnIndex8 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Integer.TYPE));
            } else {
                nearbyPeopleCard.age = cursor.getInt(columnIndex8);
            }
            int columnIndex9 = cursor.getColumnIndex("birthday");
            if (columnIndex9 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("birthday", Integer.TYPE));
            } else {
                nearbyPeopleCard.birthday = cursor.getInt(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex("sign");
            if (columnIndex10 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("sign", String.class));
            } else {
                nearbyPeopleCard.sign = cursor.getString(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex(LpReport_UserInfo_dc02148.CONSTELLATION);
            if (columnIndex11 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(LpReport_UserInfo_dc02148.CONSTELLATION, Byte.TYPE));
            } else {
                nearbyPeopleCard.constellation = (byte) cursor.getShort(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex(Element.ELEMENT_NAME_DISTANCE);
            if (columnIndex12 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(Element.ELEMENT_NAME_DISTANCE, String.class));
            } else {
                nearbyPeopleCard.distance = cursor.getString(columnIndex12);
            }
            int columnIndex13 = cursor.getColumnIndex("timeDiff");
            if (columnIndex13 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("timeDiff", String.class));
            } else {
                nearbyPeopleCard.timeDiff = cursor.getString(columnIndex13);
            }
            int columnIndex14 = cursor.getColumnIndex("aioDistanceAndTime");
            if (columnIndex14 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("aioDistanceAndTime", String.class));
            } else {
                nearbyPeopleCard.aioDistanceAndTime = cursor.getString(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT);
            if (columnIndex15 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, Integer.TYPE));
            } else {
                nearbyPeopleCard.likeCount = cursor.getInt(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("likeCountInc");
            if (columnIndex16 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("likeCountInc", Integer.TYPE));
            } else {
                nearbyPeopleCard.likeCountInc = cursor.getInt(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex("oldPhotoCount");
            if (columnIndex17 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("oldPhotoCount", Integer.TYPE));
            } else {
                nearbyPeopleCard.oldPhotoCount = cursor.getInt(columnIndex17);
            }
            int columnIndex18 = cursor.getColumnIndex("dateInfo");
            if (columnIndex18 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("dateInfo", byte[].class));
            } else {
                nearbyPeopleCard.dateInfo = cursor.getBlob(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("ulShowControl");
            if (columnIndex19 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("ulShowControl", Long.TYPE));
            } else {
                nearbyPeopleCard.ulShowControl = cursor.getLong(columnIndex19);
            }
            int columnIndex20 = cursor.getColumnIndex("xuanYan");
            if (columnIndex20 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("xuanYan", byte[].class));
            } else {
                nearbyPeopleCard.xuanYan = cursor.getBlob(columnIndex20);
            }
            int columnIndex21 = cursor.getColumnIndex("maritalStatus");
            if (columnIndex21 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("maritalStatus", Byte.TYPE));
            } else {
                nearbyPeopleCard.maritalStatus = (byte) cursor.getShort(columnIndex21);
            }
            int columnIndex22 = cursor.getColumnIndex("job");
            if (columnIndex22 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("job", Integer.TYPE));
            } else {
                nearbyPeopleCard.job = cursor.getInt(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex(IProfileProtocolConst.KEY_COMPANY);
            if (columnIndex23 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(IProfileProtocolConst.KEY_COMPANY, String.class));
            } else {
                nearbyPeopleCard.company = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex(IProfileProtocolConst.KEY_COLLEGE);
            if (columnIndex24 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(IProfileProtocolConst.KEY_COLLEGE, String.class));
            } else {
                nearbyPeopleCard.college = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("hometownCountry");
            if (columnIndex25 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownCountry", String.class));
            } else {
                nearbyPeopleCard.hometownCountry = cursor.getString(columnIndex25);
            }
            int columnIndex26 = cursor.getColumnIndex("hometownProvice");
            if (columnIndex26 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownProvice", String.class));
            } else {
                nearbyPeopleCard.hometownProvice = cursor.getString(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex("hometownCity");
            if (columnIndex27 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownCity", String.class));
            } else {
                nearbyPeopleCard.hometownCity = cursor.getString(columnIndex27);
            }
            int columnIndex28 = cursor.getColumnIndex("hometownDistrict");
            if (columnIndex28 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownDistrict", String.class));
            } else {
                nearbyPeopleCard.hometownDistrict = cursor.getString(columnIndex28);
            }
            int columnIndex29 = cursor.getColumnIndex("vCookies");
            if (columnIndex29 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("vCookies", byte[].class));
            } else {
                nearbyPeopleCard.vCookies = cursor.getBlob(columnIndex29);
            }
            int columnIndex30 = cursor.getColumnIndex("bVoted");
            if (columnIndex30 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("bVoted", Byte.TYPE));
            } else {
                nearbyPeopleCard.bVoted = (byte) cursor.getShort(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex("feedPreviewTime");
            if (columnIndex31 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPreviewTime", Long.TYPE));
            } else {
                nearbyPeopleCard.feedPreviewTime = cursor.getLong(columnIndex31);
            }
            int columnIndex32 = cursor.getColumnIndex("qzoneFeed");
            if (columnIndex32 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneFeed", String.class));
            } else {
                nearbyPeopleCard.qzoneFeed = cursor.getString(columnIndex32);
            }
            int columnIndex33 = cursor.getColumnIndex("qzoneName");
            if (columnIndex33 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneName", String.class));
            } else {
                nearbyPeopleCard.qzoneName = cursor.getString(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex("qzonePicUrl_1");
            if (columnIndex34 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_1", String.class));
            } else {
                nearbyPeopleCard.qzonePicUrl_1 = cursor.getString(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex("qzonePicUrl_2");
            if (columnIndex35 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_2", String.class));
            } else {
                nearbyPeopleCard.qzonePicUrl_2 = cursor.getString(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex("qzonePicUrl_3");
            if (columnIndex36 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_3", String.class));
            } else {
                nearbyPeopleCard.qzonePicUrl_3 = cursor.getString(columnIndex36);
            }
            int columnIndex37 = cursor.getColumnIndex("isPhotoUseCache");
            if (columnIndex37 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
            } else {
                nearbyPeopleCard.isPhotoUseCache = 1 == cursor.getShort(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex("vSeed");
            if (columnIndex38 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("vSeed", byte[].class));
            } else {
                nearbyPeopleCard.vSeed = cursor.getBlob(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex("vTempChatSig");
            if (columnIndex39 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("vTempChatSig", byte[].class));
            } else {
                nearbyPeopleCard.vTempChatSig = cursor.getBlob(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex("vGroupList");
            if (columnIndex40 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("vGroupList", byte[].class));
            } else {
                nearbyPeopleCard.vGroupList = cursor.getBlob(columnIndex40);
            }
            int columnIndex41 = cursor.getColumnIndex("nearbyInfo");
            if (columnIndex41 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("nearbyInfo", byte[].class));
            } else {
                nearbyPeopleCard.nearbyInfo = cursor.getBlob(columnIndex41);
            }
            int columnIndex42 = cursor.getColumnIndex("vActivityList");
            if (columnIndex42 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("vActivityList", byte[].class));
            } else {
                nearbyPeopleCard.vActivityList = cursor.getBlob(columnIndex42);
            }
            int columnIndex43 = cursor.getColumnIndex("lUserFlag");
            if (columnIndex43 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("lUserFlag", Long.TYPE));
            } else {
                nearbyPeopleCard.lUserFlag = cursor.getLong(columnIndex43);
            }
            int columnIndex44 = cursor.getColumnIndex("iIsGodFlag");
            if (columnIndex44 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("iIsGodFlag", Integer.TYPE));
            } else {
                nearbyPeopleCard.iIsGodFlag = cursor.getInt(columnIndex44);
            }
            int columnIndex45 = cursor.getColumnIndex("strGodJumpUrl");
            if (columnIndex45 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strGodJumpUrl", String.class));
            } else {
                nearbyPeopleCard.strGodJumpUrl = cursor.getString(columnIndex45);
            }
            int columnIndex46 = cursor.getColumnIndex("mHeartNum");
            if (columnIndex46 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeartNum", Integer.TYPE));
            } else {
                nearbyPeopleCard.mHeartNum = cursor.getInt(columnIndex46);
            }
            int columnIndex47 = cursor.getColumnIndex("switchQzone");
            if (columnIndex47 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("switchQzone", Boolean.TYPE));
            } else {
                nearbyPeopleCard.switchQzone = 1 == cursor.getShort(columnIndex47);
            }
            int columnIndex48 = cursor.getColumnIndex("switchHobby");
            if (columnIndex48 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("switchHobby", Boolean.TYPE));
            } else {
                nearbyPeopleCard.switchHobby = 1 == cursor.getShort(columnIndex48);
            }
            int columnIndex49 = cursor.getColumnIndex("uiShowControl");
            if (columnIndex49 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uiShowControl", Long.TYPE));
            } else {
                nearbyPeopleCard.uiShowControl = cursor.getLong(columnIndex49);
            }
            int columnIndex50 = cursor.getColumnIndex("userFlag");
            if (columnIndex50 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("userFlag", Long.TYPE));
            } else {
                nearbyPeopleCard.userFlag = cursor.getLong(columnIndex50);
            }
            int columnIndex51 = cursor.getColumnIndex("busiEntry");
            if (columnIndex51 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("busiEntry", String.class));
            } else {
                nearbyPeopleCard.busiEntry = cursor.getString(columnIndex51);
            }
            int columnIndex52 = cursor.getColumnIndex("godFlag");
            if (columnIndex52 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("godFlag", Boolean.TYPE));
            } else {
                nearbyPeopleCard.godFlag = 1 == cursor.getShort(columnIndex52);
            }
            int columnIndex53 = cursor.getColumnIndex("nLastGameFlag");
            if (columnIndex53 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("nLastGameFlag", Integer.TYPE));
            } else {
                nearbyPeopleCard.nLastGameFlag = cursor.getInt(columnIndex53);
            }
            int columnIndex54 = cursor.getColumnIndex("strProfileUrl");
            if (columnIndex54 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strProfileUrl", String.class));
            } else {
                nearbyPeopleCard.strProfileUrl = cursor.getString(columnIndex54);
            }
            int columnIndex55 = cursor.getColumnIndex("lastUpdateNickTime");
            if (columnIndex55 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("lastUpdateNickTime", Long.TYPE));
            } else {
                nearbyPeopleCard.lastUpdateNickTime = cursor.getLong(columnIndex55);
            }
            int columnIndex56 = cursor.getColumnIndex("favoriteSource");
            if (columnIndex56 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("favoriteSource", Integer.TYPE));
            } else {
                nearbyPeopleCard.favoriteSource = cursor.getInt(columnIndex56);
            }
            int columnIndex57 = cursor.getColumnIndex("switchGiftVisible");
            if (columnIndex57 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("switchGiftVisible", Long.TYPE));
            } else {
                nearbyPeopleCard.switchGiftVisible = cursor.getLong(columnIndex57);
            }
            int columnIndex58 = cursor.getColumnIndex("vGiftInfo");
            if (columnIndex58 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("vGiftInfo", byte[].class));
            } else {
                nearbyPeopleCard.vGiftInfo = cursor.getBlob(columnIndex58);
            }
            int columnIndex59 = cursor.getColumnIndex("sayHelloFlag");
            if (columnIndex59 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("sayHelloFlag", Integer.TYPE));
            } else {
                nearbyPeopleCard.sayHelloFlag = cursor.getInt(columnIndex59);
            }
            int columnIndex60 = cursor.getColumnIndex("charm");
            if (columnIndex60 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("charm", Long.TYPE));
            } else {
                nearbyPeopleCard.charm = cursor.getLong(columnIndex60);
            }
            int columnIndex61 = cursor.getColumnIndex("charmLevel");
            if (columnIndex61 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("charmLevel", Integer.TYPE));
            } else {
                nearbyPeopleCard.charmLevel = cursor.getInt(columnIndex61);
            }
            int columnIndex62 = cursor.getColumnIndex("nextThreshold");
            if (columnIndex62 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("nextThreshold", Integer.TYPE));
            } else {
                nearbyPeopleCard.nextThreshold = cursor.getInt(columnIndex62);
            }
            int columnIndex63 = cursor.getColumnIndex("curThreshold");
            if (columnIndex63 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("curThreshold", Integer.TYPE));
            } else {
                nearbyPeopleCard.curThreshold = cursor.getInt(columnIndex63);
            }
            int columnIndex64 = cursor.getColumnIndex("profPercent");
            if (columnIndex64 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("profPercent", Integer.TYPE));
            } else {
                nearbyPeopleCard.profPercent = cursor.getInt(columnIndex64);
            }
            int columnIndex65 = cursor.getColumnIndex("taskFinished");
            if (columnIndex65 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("taskFinished", Integer.TYPE));
            } else {
                nearbyPeopleCard.taskFinished = cursor.getInt(columnIndex65);
            }
            int columnIndex66 = cursor.getColumnIndex("taskTotal");
            if (columnIndex66 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("taskTotal", Integer.TYPE));
            } else {
                nearbyPeopleCard.taskTotal = cursor.getInt(columnIndex66);
            }
            int columnIndex67 = cursor.getColumnIndex("hiWanInfo");
            if (columnIndex67 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("hiWanInfo", String.class));
            } else {
                nearbyPeopleCard.hiWanInfo = cursor.getString(columnIndex67);
            }
            int columnIndex68 = cursor.getColumnIndex("commonLabelString");
            if (columnIndex68 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("commonLabelString", String.class));
            } else {
                nearbyPeopleCard.commonLabelString = cursor.getString(columnIndex68);
            }
            int columnIndex69 = cursor.getColumnIndex("tagFlag");
            if (columnIndex69 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("tagFlag", Long.TYPE));
            } else {
                nearbyPeopleCard.tagFlag = cursor.getLong(columnIndex69);
            }
            int columnIndex70 = cursor.getColumnIndex("tagInfo");
            if (columnIndex70 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("tagInfo", String.class));
            } else {
                nearbyPeopleCard.tagInfo = cursor.getString(columnIndex70);
            }
            int columnIndex71 = cursor.getColumnIndex("picInfo");
            if (columnIndex71 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("picInfo", String.class));
            } else {
                nearbyPeopleCard.picInfo = cursor.getString(columnIndex71);
            }
            int columnIndex72 = cursor.getColumnIndex("videoDetails");
            if (columnIndex72 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("videoDetails", String.class));
            } else {
                nearbyPeopleCard.videoDetails = cursor.getString(columnIndex72);
            }
            int columnIndex73 = cursor.getColumnIndex("strFreshNewsInfo");
            if (columnIndex73 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strFreshNewsInfo", String.class));
            } else {
                nearbyPeopleCard.strFreshNewsInfo = cursor.getString(columnIndex73);
            }
            int columnIndex74 = cursor.getColumnIndex("strHotChatInfo");
            if (columnIndex74 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strHotChatInfo", String.class));
            } else {
                nearbyPeopleCard.strHotChatInfo = cursor.getString(columnIndex74);
            }
            int columnIndex75 = cursor.getColumnIndex("uRoomid");
            if (columnIndex75 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uRoomid", Long.TYPE));
            } else {
                nearbyPeopleCard.uRoomid = cursor.getLong(columnIndex75);
            }
            int columnIndex76 = cursor.getColumnIndex("strVoteLimitedNotice");
            if (columnIndex76 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strVoteLimitedNotice", String.class));
            } else {
                nearbyPeopleCard.strVoteLimitedNotice = cursor.getString(columnIndex76);
            }
            int columnIndex77 = cursor.getColumnIndex("bHaveVotedCnt");
            if (columnIndex77 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("bHaveVotedCnt", Short.TYPE));
            } else {
                nearbyPeopleCard.bHaveVotedCnt = cursor.getShort(columnIndex77);
            }
            int columnIndex78 = cursor.getColumnIndex("bAvailVoteCnt");
            if (columnIndex78 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("bAvailVoteCnt", Short.TYPE));
            } else {
                nearbyPeopleCard.bAvailVoteCnt = cursor.getShort(columnIndex78);
            }
            int columnIndex79 = cursor.getColumnIndex("collegeId");
            if (columnIndex79 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("collegeId", Long.TYPE));
            } else {
                nearbyPeopleCard.collegeId = cursor.getLong(columnIndex79);
            }
            int columnIndex80 = cursor.getColumnIndex("videoHeadFlag");
            if (columnIndex80 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("videoHeadFlag", Boolean.TYPE));
            } else {
                nearbyPeopleCard.videoHeadFlag = 1 == cursor.getShort(columnIndex80);
            }
            int columnIndex81 = cursor.getColumnIndex("bVideoHeadUrl");
            if (columnIndex81 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("bVideoHeadUrl", String.class));
            } else {
                nearbyPeopleCard.bVideoHeadUrl = cursor.getString(columnIndex81);
            }
            int columnIndex82 = cursor.getColumnIndex("faceScoreWordingColor");
            if (columnIndex82 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
            } else {
                nearbyPeopleCard.faceScoreWordingColor = cursor.getInt(columnIndex82);
            }
            int columnIndex83 = cursor.getColumnIndex("faceScoreWording");
            if (columnIndex83 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreWording", String.class));
            } else {
                nearbyPeopleCard.faceScoreWording = cursor.getString(columnIndex83);
            }
            int columnIndex84 = cursor.getColumnIndex("faceScoreTailWordingColor");
            if (columnIndex84 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
            } else {
                nearbyPeopleCard.faceScoreTailWordingColor = cursor.getInt(columnIndex84);
            }
            int columnIndex85 = cursor.getColumnIndex("faceScoreTailWording");
            if (columnIndex85 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreTailWording", String.class));
            } else {
                nearbyPeopleCard.faceScoreTailWording = cursor.getString(columnIndex85);
            }
            int columnIndex86 = cursor.getColumnIndex("faceScoreIconUrl");
            if (columnIndex86 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreIconUrl", String.class));
            } else {
                nearbyPeopleCard.faceScoreIconUrl = cursor.getString(columnIndex86);
            }
            int columnIndex87 = cursor.getColumnIndex("entryAbility");
            if (columnIndex87 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("entryAbility", Integer.TYPE));
            } else {
                nearbyPeopleCard.entryAbility = cursor.getInt(columnIndex87);
            }
            int columnIndex88 = cursor.getColumnIndex("strLevelType");
            if (columnIndex88 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strLevelType", String.class));
            } else {
                nearbyPeopleCard.strLevelType = cursor.getString(columnIndex88);
            }
            int columnIndex89 = cursor.getColumnIndex("maskMsgFlag");
            if (columnIndex89 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("maskMsgFlag", Integer.TYPE));
            } else {
                nearbyPeopleCard.maskMsgFlag = cursor.getInt(columnIndex89);
            }
            int columnIndex90 = cursor.getColumnIndex("isForbidSendMsg");
            if (columnIndex90 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
            } else {
                nearbyPeopleCard.isForbidSendMsg = 1 == cursor.getShort(columnIndex90);
            }
            int columnIndex91 = cursor.getColumnIndex("isForbidSendGiftMsg");
            if (columnIndex91 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
            } else {
                nearbyPeopleCard.isForbidSendGiftMsg = 1 == cursor.getShort(columnIndex91);
            }
            int columnIndex92 = cursor.getColumnIndex("disableSendMsgBtnTips");
            if (columnIndex92 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendMsgBtnTips", String.class));
            } else {
                nearbyPeopleCard.disableSendMsgBtnTips = cursor.getString(columnIndex92);
            }
            int columnIndex93 = cursor.getColumnIndex("disableSendGiftBtnTips");
            if (columnIndex93 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendGiftBtnTips", String.class));
            } else {
                nearbyPeopleCard.disableSendGiftBtnTips = cursor.getString(columnIndex93);
            }
            int columnIndex94 = cursor.getColumnIndex("isForbidSendMsgForTribar");
            if (columnIndex94 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
            } else {
                nearbyPeopleCard.isForbidSendMsgForTribar = 1 == cursor.getShort(columnIndex94);
            }
            int columnIndex95 = cursor.getColumnIndex("isForbidSendGiftMsgForTribar");
            if (columnIndex95 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
            } else {
                nearbyPeopleCard.isForbidSendGiftMsgForTribar = 1 == cursor.getShort(columnIndex95);
            }
            int columnIndex96 = cursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
            if (columnIndex96 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
            } else {
                nearbyPeopleCard.disableSendMsgBtnTipsForTribar = cursor.getString(columnIndex96);
            }
            int columnIndex97 = cursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
            if (columnIndex97 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
            } else {
                nearbyPeopleCard.disableSendGiftBtnTipsForTribar = cursor.getString(columnIndex97);
            }
            int columnIndex98 = cursor.getColumnIndex("highScoreNum");
            if (columnIndex98 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("highScoreNum", Integer.TYPE));
            } else {
                nearbyPeopleCard.highScoreNum = cursor.getInt(columnIndex98);
            }
            int columnIndex99 = cursor.getColumnIndex("mHasStory");
            if (columnIndex99 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mHasStory", Boolean.TYPE));
            } else {
                nearbyPeopleCard.mHasStory = 1 == cursor.getShort(columnIndex99);
            }
            int columnIndex100 = cursor.getColumnIndex("mQQStoryData");
            if (columnIndex100 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mQQStoryData", byte[].class));
            } else {
                nearbyPeopleCard.mQQStoryData = cursor.getBlob(columnIndex100);
            }
            int columnIndex101 = cursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
            if (columnIndex101 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
            } else {
                nearbyPeopleCard.isSendMsgBtnDownloadAppOpen = 1 == cursor.getShort(columnIndex101);
            }
            int columnIndex102 = cursor.getColumnIndex("sendMsgBtnDownloadAppTips");
            if (columnIndex102 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
            } else {
                nearbyPeopleCard.sendMsgBtnDownloadAppTips = cursor.getString(columnIndex102);
            }
            int columnIndex103 = cursor.getColumnIndex("addPicBtnDownloadAppTips");
            if (columnIndex103 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("addPicBtnDownloadAppTips", String.class));
            } else {
                nearbyPeopleCard.addPicBtnDownloadAppTips = cursor.getString(columnIndex103);
            }
            int columnIndex104 = cursor.getColumnIndex("tribeAppDownloadPageUrl");
            if (columnIndex104 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("tribeAppDownloadPageUrl", String.class));
            } else {
                nearbyPeopleCard.tribeAppDownloadPageUrl = cursor.getString(columnIndex104);
            }
            int columnIndex105 = cursor.getColumnIndex("nearbyNowDataBytes");
            if (columnIndex105 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("nearbyNowDataBytes", byte[].class));
            } else {
                nearbyPeopleCard.nearbyNowDataBytes = cursor.getBlob(columnIndex105);
            }
            int columnIndex106 = cursor.getColumnIndex("guideAppNowTip");
            if (columnIndex106 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTip", String.class));
            } else {
                nearbyPeopleCard.guideAppNowTip = cursor.getString(columnIndex106);
            }
            int columnIndex107 = cursor.getColumnIndex("guideAppNowTipLeftBtn");
            if (columnIndex107 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipLeftBtn", String.class));
            } else {
                nearbyPeopleCard.guideAppNowTipLeftBtn = cursor.getString(columnIndex107);
            }
            int columnIndex108 = cursor.getColumnIndex("guideAppNowTipRightBtnInstalled");
            if (columnIndex108 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipRightBtnInstalled", String.class));
            } else {
                nearbyPeopleCard.guideAppNowTipRightBtnInstalled = cursor.getString(columnIndex108);
            }
            int columnIndex109 = cursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled");
            if (columnIndex109 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipRightBtnNotInstalled", String.class));
            } else {
                nearbyPeopleCard.guideAppNowTipRightBtnNotInstalled = cursor.getString(columnIndex109);
            }
            int columnIndex110 = cursor.getColumnIndex("guideAppNowPackage");
            if (columnIndex110 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowPackage", String.class));
            } else {
                nearbyPeopleCard.guideAppNowPackage = cursor.getString(columnIndex110);
            }
            int columnIndex111 = cursor.getColumnIndex("guideAppNowJumpUri");
            if (columnIndex111 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowJumpUri", String.class));
            } else {
                nearbyPeopleCard.guideAppNowJumpUri = cursor.getString(columnIndex111);
            }
            int columnIndex112 = cursor.getColumnIndex("guideAppNowDownloadUrl");
            if (columnIndex112 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowDownloadUrl", String.class));
            } else {
                nearbyPeopleCard.guideAppNowDownloadUrl = cursor.getString(columnIndex112);
            }
            int columnIndex113 = cursor.getColumnIndex("guideVerifiedDialogTitle");
            if (columnIndex113 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideVerifiedDialogTitle", String.class));
            } else {
                nearbyPeopleCard.guideVerifiedDialogTitle = cursor.getString(columnIndex113);
            }
            int columnIndex114 = cursor.getColumnIndex("guideVerifiedDialogRightBtnText");
            if (columnIndex114 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("guideVerifiedDialogRightBtnText", String.class));
            } else {
                nearbyPeopleCard.guideVerifiedDialogRightBtnText = cursor.getString(columnIndex114);
            }
            int columnIndex115 = cursor.getColumnIndex("firstOfficialMsg");
            if (columnIndex115 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("firstOfficialMsg", String.class));
            } else {
                nearbyPeopleCard.firstOfficialMsg = cursor.getString(columnIndex115);
            }
            int columnIndex116 = cursor.getColumnIndex("unverifyGrayTips");
            if (columnIndex116 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("unverifyGrayTips", String.class));
            } else {
                nearbyPeopleCard.unverifyGrayTips = cursor.getString(columnIndex116);
            }
            int columnIndex117 = cursor.getColumnIndex("isVerified");
            if (columnIndex117 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isVerified", Boolean.TYPE));
            } else {
                nearbyPeopleCard.isVerified = 1 == cursor.getShort(columnIndex117);
            }
        }
        return nearbyPeopleCard;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public void entity2ContentValues(Entity entity, ContentValues contentValues) {
        NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) entity;
        contentValues.put("tinyId", Long.valueOf(nearbyPeopleCard.tinyId));
        contentValues.put("uin", nearbyPeopleCard.uin);
        contentValues.put("nowId", Long.valueOf(nearbyPeopleCard.nowId));
        contentValues.put("nowUserType", Integer.valueOf(nearbyPeopleCard.nowUserType));
        contentValues.put("strRemark", nearbyPeopleCard.strRemark);
        contentValues.put("nickname", nearbyPeopleCard.nickname);
        contentValues.put("gender", Byte.valueOf(nearbyPeopleCard.gender));
        contentValues.put("age", Integer.valueOf(nearbyPeopleCard.age));
        contentValues.put("birthday", Integer.valueOf(nearbyPeopleCard.birthday));
        contentValues.put("sign", nearbyPeopleCard.sign);
        contentValues.put(LpReport_UserInfo_dc02148.CONSTELLATION, Byte.valueOf(nearbyPeopleCard.constellation));
        contentValues.put(Element.ELEMENT_NAME_DISTANCE, nearbyPeopleCard.distance);
        contentValues.put("timeDiff", nearbyPeopleCard.timeDiff);
        contentValues.put("aioDistanceAndTime", nearbyPeopleCard.aioDistanceAndTime);
        contentValues.put(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, Integer.valueOf(nearbyPeopleCard.likeCount));
        contentValues.put("likeCountInc", Integer.valueOf(nearbyPeopleCard.likeCountInc));
        contentValues.put("oldPhotoCount", Integer.valueOf(nearbyPeopleCard.oldPhotoCount));
        contentValues.put("dateInfo", nearbyPeopleCard.dateInfo);
        contentValues.put("ulShowControl", Long.valueOf(nearbyPeopleCard.ulShowControl));
        contentValues.put("xuanYan", nearbyPeopleCard.xuanYan);
        contentValues.put("maritalStatus", Byte.valueOf(nearbyPeopleCard.maritalStatus));
        contentValues.put("job", Integer.valueOf(nearbyPeopleCard.job));
        contentValues.put(IProfileProtocolConst.KEY_COMPANY, nearbyPeopleCard.company);
        contentValues.put(IProfileProtocolConst.KEY_COLLEGE, nearbyPeopleCard.college);
        contentValues.put("hometownCountry", nearbyPeopleCard.hometownCountry);
        contentValues.put("hometownProvice", nearbyPeopleCard.hometownProvice);
        contentValues.put("hometownCity", nearbyPeopleCard.hometownCity);
        contentValues.put("hometownDistrict", nearbyPeopleCard.hometownDistrict);
        contentValues.put("vCookies", nearbyPeopleCard.vCookies);
        contentValues.put("bVoted", Byte.valueOf(nearbyPeopleCard.bVoted));
        contentValues.put("feedPreviewTime", Long.valueOf(nearbyPeopleCard.feedPreviewTime));
        contentValues.put("qzoneFeed", nearbyPeopleCard.qzoneFeed);
        contentValues.put("qzoneName", nearbyPeopleCard.qzoneName);
        contentValues.put("qzonePicUrl_1", nearbyPeopleCard.qzonePicUrl_1);
        contentValues.put("qzonePicUrl_2", nearbyPeopleCard.qzonePicUrl_2);
        contentValues.put("qzonePicUrl_3", nearbyPeopleCard.qzonePicUrl_3);
        contentValues.put("isPhotoUseCache", Boolean.valueOf(nearbyPeopleCard.isPhotoUseCache));
        contentValues.put("vSeed", nearbyPeopleCard.vSeed);
        contentValues.put("vTempChatSig", nearbyPeopleCard.vTempChatSig);
        contentValues.put("vGroupList", nearbyPeopleCard.vGroupList);
        contentValues.put("nearbyInfo", nearbyPeopleCard.nearbyInfo);
        contentValues.put("vActivityList", nearbyPeopleCard.vActivityList);
        contentValues.put("lUserFlag", Long.valueOf(nearbyPeopleCard.lUserFlag));
        contentValues.put("iIsGodFlag", Integer.valueOf(nearbyPeopleCard.iIsGodFlag));
        contentValues.put("strGodJumpUrl", nearbyPeopleCard.strGodJumpUrl);
        contentValues.put("mHeartNum", Integer.valueOf(nearbyPeopleCard.mHeartNum));
        contentValues.put("switchQzone", Boolean.valueOf(nearbyPeopleCard.switchQzone));
        contentValues.put("switchHobby", Boolean.valueOf(nearbyPeopleCard.switchHobby));
        contentValues.put("uiShowControl", Long.valueOf(nearbyPeopleCard.uiShowControl));
        contentValues.put("userFlag", Long.valueOf(nearbyPeopleCard.userFlag));
        contentValues.put("busiEntry", nearbyPeopleCard.busiEntry);
        contentValues.put("godFlag", Boolean.valueOf(nearbyPeopleCard.godFlag));
        contentValues.put("nLastGameFlag", Integer.valueOf(nearbyPeopleCard.nLastGameFlag));
        contentValues.put("strProfileUrl", nearbyPeopleCard.strProfileUrl);
        contentValues.put("lastUpdateNickTime", Long.valueOf(nearbyPeopleCard.lastUpdateNickTime));
        contentValues.put("favoriteSource", Integer.valueOf(nearbyPeopleCard.favoriteSource));
        contentValues.put("switchGiftVisible", Long.valueOf(nearbyPeopleCard.switchGiftVisible));
        contentValues.put("vGiftInfo", nearbyPeopleCard.vGiftInfo);
        contentValues.put("sayHelloFlag", Integer.valueOf(nearbyPeopleCard.sayHelloFlag));
        contentValues.put("charm", Long.valueOf(nearbyPeopleCard.charm));
        contentValues.put("charmLevel", Integer.valueOf(nearbyPeopleCard.charmLevel));
        contentValues.put("nextThreshold", Integer.valueOf(nearbyPeopleCard.nextThreshold));
        contentValues.put("curThreshold", Integer.valueOf(nearbyPeopleCard.curThreshold));
        contentValues.put("profPercent", Integer.valueOf(nearbyPeopleCard.profPercent));
        contentValues.put("taskFinished", Integer.valueOf(nearbyPeopleCard.taskFinished));
        contentValues.put("taskTotal", Integer.valueOf(nearbyPeopleCard.taskTotal));
        contentValues.put("hiWanInfo", nearbyPeopleCard.hiWanInfo);
        contentValues.put("commonLabelString", nearbyPeopleCard.commonLabelString);
        contentValues.put("tagFlag", Long.valueOf(nearbyPeopleCard.tagFlag));
        contentValues.put("tagInfo", nearbyPeopleCard.tagInfo);
        contentValues.put("picInfo", nearbyPeopleCard.picInfo);
        contentValues.put("videoDetails", nearbyPeopleCard.videoDetails);
        contentValues.put("strFreshNewsInfo", nearbyPeopleCard.strFreshNewsInfo);
        contentValues.put("strHotChatInfo", nearbyPeopleCard.strHotChatInfo);
        contentValues.put("uRoomid", Long.valueOf(nearbyPeopleCard.uRoomid));
        contentValues.put("strVoteLimitedNotice", nearbyPeopleCard.strVoteLimitedNotice);
        contentValues.put("bHaveVotedCnt", Short.valueOf(nearbyPeopleCard.bHaveVotedCnt));
        contentValues.put("bAvailVoteCnt", Short.valueOf(nearbyPeopleCard.bAvailVoteCnt));
        contentValues.put("collegeId", Long.valueOf(nearbyPeopleCard.collegeId));
        contentValues.put("videoHeadFlag", Boolean.valueOf(nearbyPeopleCard.videoHeadFlag));
        contentValues.put("bVideoHeadUrl", nearbyPeopleCard.bVideoHeadUrl);
        contentValues.put("faceScoreWordingColor", Integer.valueOf(nearbyPeopleCard.faceScoreWordingColor));
        contentValues.put("faceScoreWording", nearbyPeopleCard.faceScoreWording);
        contentValues.put("faceScoreTailWordingColor", Integer.valueOf(nearbyPeopleCard.faceScoreTailWordingColor));
        contentValues.put("faceScoreTailWording", nearbyPeopleCard.faceScoreTailWording);
        contentValues.put("faceScoreIconUrl", nearbyPeopleCard.faceScoreIconUrl);
        contentValues.put("entryAbility", Integer.valueOf(nearbyPeopleCard.entryAbility));
        contentValues.put("strLevelType", nearbyPeopleCard.strLevelType);
        contentValues.put("maskMsgFlag", Integer.valueOf(nearbyPeopleCard.maskMsgFlag));
        contentValues.put("isForbidSendMsg", Boolean.valueOf(nearbyPeopleCard.isForbidSendMsg));
        contentValues.put("isForbidSendGiftMsg", Boolean.valueOf(nearbyPeopleCard.isForbidSendGiftMsg));
        contentValues.put("disableSendMsgBtnTips", nearbyPeopleCard.disableSendMsgBtnTips);
        contentValues.put("disableSendGiftBtnTips", nearbyPeopleCard.disableSendGiftBtnTips);
        contentValues.put("isForbidSendMsgForTribar", Boolean.valueOf(nearbyPeopleCard.isForbidSendMsgForTribar));
        contentValues.put("isForbidSendGiftMsgForTribar", Boolean.valueOf(nearbyPeopleCard.isForbidSendGiftMsgForTribar));
        contentValues.put("disableSendMsgBtnTipsForTribar", nearbyPeopleCard.disableSendMsgBtnTipsForTribar);
        contentValues.put("disableSendGiftBtnTipsForTribar", nearbyPeopleCard.disableSendGiftBtnTipsForTribar);
        contentValues.put("highScoreNum", Integer.valueOf(nearbyPeopleCard.highScoreNum));
        contentValues.put("mHasStory", Boolean.valueOf(nearbyPeopleCard.mHasStory));
        contentValues.put("mQQStoryData", nearbyPeopleCard.mQQStoryData);
        contentValues.put("isSendMsgBtnDownloadAppOpen", Boolean.valueOf(nearbyPeopleCard.isSendMsgBtnDownloadAppOpen));
        contentValues.put("sendMsgBtnDownloadAppTips", nearbyPeopleCard.sendMsgBtnDownloadAppTips);
        contentValues.put("addPicBtnDownloadAppTips", nearbyPeopleCard.addPicBtnDownloadAppTips);
        contentValues.put("tribeAppDownloadPageUrl", nearbyPeopleCard.tribeAppDownloadPageUrl);
        contentValues.put("nearbyNowDataBytes", nearbyPeopleCard.nearbyNowDataBytes);
        contentValues.put("guideAppNowTip", nearbyPeopleCard.guideAppNowTip);
        contentValues.put("guideAppNowTipLeftBtn", nearbyPeopleCard.guideAppNowTipLeftBtn);
        contentValues.put("guideAppNowTipRightBtnInstalled", nearbyPeopleCard.guideAppNowTipRightBtnInstalled);
        contentValues.put("guideAppNowTipRightBtnNotInstalled", nearbyPeopleCard.guideAppNowTipRightBtnNotInstalled);
        contentValues.put("guideAppNowPackage", nearbyPeopleCard.guideAppNowPackage);
        contentValues.put("guideAppNowJumpUri", nearbyPeopleCard.guideAppNowJumpUri);
        contentValues.put("guideAppNowDownloadUrl", nearbyPeopleCard.guideAppNowDownloadUrl);
        contentValues.put("guideVerifiedDialogTitle", nearbyPeopleCard.guideVerifiedDialogTitle);
        contentValues.put("guideVerifiedDialogRightBtnText", nearbyPeopleCard.guideVerifiedDialogRightBtnText);
        contentValues.put("firstOfficialMsg", nearbyPeopleCard.firstOfficialMsg);
        contentValues.put("unverifyGrayTips", nearbyPeopleCard.unverifyGrayTips);
        contentValues.put("isVerified", Boolean.valueOf(nearbyPeopleCard.isVerified));
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public String getCreateTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nowId INTEGER ,nowUserType INTEGER ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,sign TEXT ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB ,guideAppNowTip TEXT ,guideAppNowTipLeftBtn TEXT ,guideAppNowTipRightBtnInstalled TEXT ,guideAppNowTipRightBtnNotInstalled TEXT ,guideAppNowPackage TEXT ,guideAppNowJumpUri TEXT ,guideAppNowDownloadUrl TEXT ,guideVerifiedDialogTitle TEXT ,guideVerifiedDialogRightBtnText TEXT ,firstOfficialMsg TEXT ,unverifyGrayTips TEXT ,isVerified INTEGER)";
    }
}
