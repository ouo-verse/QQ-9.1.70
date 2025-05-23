package com.qzone.proxy.feedcomponent.util;

import NS_FASHION_FEEDS_TAG_PROTO.GetPicTagBinRspNode;
import NS_FASHION_FEEDS_TAG_PROTO.PicTagInfo;
import NS_FASHION_FEEDS_TAG_PROTO.TagInfo;
import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import NS_MOBILE_FEEDS.cell_decorate;
import NS_MOBILE_FEEDS.cell_detail_content;
import NS_MOBILE_FEEDS.cell_feeds_deco;
import NS_MOBILE_FEEDS.cell_left_thumb;
import NS_MOBILE_FEEDS.cell_link;
import NS_MOBILE_FEEDS.cell_music;
import NS_MOBILE_FEEDS.cell_pic;
import NS_MOBILE_FEEDS.cell_qboss_psv_adv;
import NS_MOBILE_FEEDS.cell_text;
import NS_MOBILE_FEEDS.cell_video;
import NS_MOBILE_FEEDS.cnst.ADV_PRIORITY;
import NS_MOBILE_FEEDS.cnst.ALLOW_TX_ADV_PLATFROM_CINEMA;
import NS_MOBILE_FEEDS.cnst.COMM_MALL_INSERT_FEED;
import NS_MOBILE_FEEDS.cnst.FEEDSKIN;
import NS_MOBILE_FEEDS.guide_button;
import NS_MOBILE_FEEDS.s_audio;
import NS_MOBILE_FEEDS.s_commment;
import NS_MOBILE_FEEDS.s_gift_item;
import NS_MOBILE_FEEDS.s_imgcrop;
import NS_MOBILE_FEEDS.s_likeman;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_FEEDS.s_reply;
import NS_MOBILE_FEEDS.s_user;
import NS_MOBILE_FEEDS.s_videoremark;
import NS_MOBILE_FEEDS.s_videourl;
import NS_MOBILE_FEEDS.stPhotoTag;
import NS_MOBILE_FEEDS.st_pic_text;
import NS_MOBILE_MATERIAL.CustomTrackUgcDeco;
import NS_MOBILE_MATERIAL.FeedSkin;
import NS_MOBILE_MATERIAL.ShuoShuoUgcDeco;
import NS_MOBILE_MATERIAL.UgcCustomTrack;
import NS_QMALL_COVER.ActYellowDiamond;
import NS_QMALL_COVER.FeedQzmallDeco;
import NS_QMALL_COVER.QzmallCustomPassivePraise;
import NS_QMALL_COVER.QzmallCustomPraise;
import NS_QMALL_COVER.QzmallCustomVip;
import NS_QMALL_COVER.QzmallFeedAvatar;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.AudioInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellQbossPsvAdv;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.FriendBirthdayGift;
import com.qzone.proxy.feedcomponent.model.GuideButton;
import com.qzone.proxy.feedcomponent.model.MusicInfo;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.TextInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.publish.ui.model.QzoneVipCommentIconInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qzone.model.FaceData;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {
    public static void c(com.qzone.proxy.feedcomponent.model.l lVar, User user) {
        cell_feeds_deco cell_feeds_decoVar;
        ActYellowDiamond actYellowDiamond;
        QzmallFeedAvatar qzmallFeedAvatar;
        int i3;
        QzmallCustomPassivePraise qzmallCustomPassivePraise;
        int i16;
        int i17;
        QzmallCustomPraise qzmallCustomPraise;
        QzmallCustomVip qzmallCustomVip;
        if (lVar == null || (cell_feeds_decoVar = lVar.f50367n0) == null || cell_feeds_decoVar.decoration == null) {
            return;
        }
        FeedQzmallDeco feedQzmallDeco = (FeedQzmallDeco) com.qzone.adapter.feedcomponent.i.H().u(FeedQzmallDeco.class, cell_feeds_decoVar.decoration);
        if (feedQzmallDeco != null && (qzmallCustomVip = feedQzmallDeco.stCustomVip) != null && qzmallCustomVip.iItemId != 0) {
            user.personalizedYellowVipUrl = qzmallCustomVip.strSrcUrl;
            user.customType = qzmallCustomVip.eCustomVipType;
            user.hostCustomIconUrl = qzmallCustomVip.strMasterJumpUrl;
            user.guestCustomIconUrl = qzmallCustomVip.strGuestJumpUrl;
        }
        if (feedQzmallDeco != null && (qzmallCustomPraise = feedQzmallDeco.stCustomPraise) != null && qzmallCustomPraise.iItemId != -1) {
            user.customPraiseData = CustomPraiseData.createFromResponse(qzmallCustomPraise);
            QzoneCustomPraiseService.i().m(user.customPraiseData);
        }
        if (feedQzmallDeco != null && (qzmallCustomPassivePraise = feedQzmallDeco.stCustomPassivePraise) != null && (i16 = qzmallCustomPassivePraise.iItemId) != 0) {
            user.personalizedPassivePraiseUrl = qzmallCustomPassivePraise.strFullScreenUrl;
            user.personalizedPassivePraiseId = i16;
            user.personalizedPassivePraiseType = qzmallCustomPassivePraise.iType;
            try {
            } catch (Exception unused) {
                com.qzone.proxy.feedcomponent.b.c("FeedDataConvertHelper", " @cmData qzmallDeco actionid erro");
            }
            if (!TextUtils.isEmpty(qzmallCustomPassivePraise.strCmShowActionId)) {
                com.qzone.proxy.feedcomponent.b.e("FeedDataConvertHelper", " @cmData qzmallDeco actionid =" + feedQzmallDeco.stCustomPassivePraise.strCmShowActionId);
                i17 = Integer.parseInt(feedQzmallDeco.stCustomPassivePraise.strCmShowActionId);
                user.cmPraiseActionid = i17;
            }
            i17 = 0;
            user.cmPraiseActionid = i17;
        } else {
            user.personalizedPassivePraiseId = -1;
        }
        if (feedQzmallDeco != null && (qzmallFeedAvatar = feedQzmallDeco.stFeedAvatar) != null && (i3 = qzmallFeedAvatar.iItemId) != 0) {
            user.avatarDecorationId = i3;
            user.avatarDecorationType = qzmallFeedAvatar.eAvatarType;
            String str = qzmallFeedAvatar.strAvatarUrl;
            user.feedAvatarDecorationUrl = str;
            user.feedAvatarDecorationImageUrl = PictureUrl.calculateImageUrl(str);
            user.feedAvatarDecorationJumpUrl = feedQzmallDeco.stFeedAvatar.strAvatarJumpUrl;
        } else {
            user.avatarDecorationId = -1;
        }
        if (feedQzmallDeco == null || (actYellowDiamond = feedQzmallDeco.stYellowDiamond) == null) {
            return;
        }
        user.isCustomDiamond = actYellowDiamond.iTenYearUser != 0;
        user.customDiamondUrl = actYellowDiamond.strPicZip;
    }

    public static GuideButton h(guide_button guide_buttonVar) {
        GuideButton guideButton = new GuideButton();
        guideButton.buttonTitle = guide_buttonVar.button_title;
        guideButton.actionUrl = guide_buttonVar.action_url;
        guideButton.picUrl = guide_buttonVar.pic_url;
        return guideButton;
    }

    public static ArrayList<TagInfo> k(s_picdata s_picdataVar) {
        GetPicTagBinRspNode getPicTagBinRspNode;
        PicTagInfo picTagInfo;
        try {
            if (!s_picdataVar.binaryExtInfo.containsKey("fashion_tag_info") || (getPicTagBinRspNode = (GetPicTagBinRspNode) com.qzone.adapter.feedcomponent.i.H().u(GetPicTagBinRspNode.class, s_picdataVar.binaryExtInfo.get("fashion_tag_info"))) == null || (picTagInfo = getPicTagBinRspNode.stPicTagInfo) == null) {
                return null;
            }
            return picTagInfo.vecTagInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void u(User user, User user2) {
        if (user != null) {
            user2.personalizedYellowVipUrl = user.personalizedYellowVipUrl;
            user2.customType = user.customType;
            user2.hostCustomIconUrl = user.hostCustomIconUrl;
            user2.guestCustomIconUrl = user.guestCustomIconUrl;
            user2.customPraiseData = user.customPraiseData;
            user2.personalizedPassivePraiseUrl = user.personalizedPassivePraiseUrl;
            user2.personalizedPassivePraiseId = user.personalizedPassivePraiseId;
            user2.personalizedPassivePraiseType = user.personalizedPassivePraiseType;
            user2.avatarDecorationId = user.avatarDecorationId;
            user2.avatarDecorationType = user.avatarDecorationType;
            user2.feedAvatarDecorationUrl = user.feedAvatarDecorationUrl;
            user2.feedAvatarDecorationImageUrl = user.feedAvatarDecorationImageUrl;
            user2.feedAvatarDecorationJumpUrl = user.feedAvatarDecorationJumpUrl;
            user2.isCustomDiamond = user.isCustomDiamond;
            user2.customDiamondUrl = user.customDiamondUrl;
        }
    }

    public static QzoneCustomTrackData a(cell_decorate cell_decorateVar) {
        Map<String, byte[]> map;
        CustomTrackUgcDeco customTrackUgcDeco;
        UgcCustomTrack ugcCustomTrack;
        int i3;
        if (cell_decorateVar == null || (map = cell_decorateVar.mapInfoData) == null || !map.containsKey(COMM_MALL_INSERT_FEED.value) || (customTrackUgcDeco = (CustomTrackUgcDeco) com.qzone.adapter.feedcomponent.i.H().u(CustomTrackUgcDeco.class, cell_decorateVar.mapInfoData.get(COMM_MALL_INSERT_FEED.value))) == null || (ugcCustomTrack = customTrackUgcDeco.stUgcCustomTrack) == null || (i3 = ugcCustomTrack.iItemId) == -1 || i3 == 0) {
            return null;
        }
        return QzoneCustomTrackData.customtrackreadFromUgcBuffer(0L, ugcCustomTrack);
    }

    public static FeedSkinData b(cell_decorate cell_decorateVar) {
        Map<String, byte[]> map;
        FeedSkin feedSkin;
        if (cell_decorateVar == null || (map = cell_decorateVar.mapInfoData) == null || !map.containsKey(FEEDSKIN.value)) {
            return null;
        }
        FeedSkinData feedSkinData = new FeedSkinData();
        ShuoShuoUgcDeco shuoShuoUgcDeco = (ShuoShuoUgcDeco) com.qzone.adapter.feedcomponent.i.H().u(ShuoShuoUgcDeco.class, cell_decorateVar.mapInfoData.get(FEEDSKIN.value));
        if (shuoShuoUgcDeco != null && (feedSkin = shuoShuoUgcDeco.stFeedSkin) != null) {
            if (!TextUtils.isEmpty(feedSkin.strAndBgUrl)) {
                feedSkinData.sPicUrl = feedSkin.strAndBgUrl;
                feedSkinData.sSkinId = feedSkin.iItemId + "";
                int i3 = feedSkin.iType;
                if (i3 == 0) {
                    feedSkinData.nSkinType = 364;
                } else if (i3 == 1) {
                    feedSkinData.nSkinType = QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE;
                } else {
                    com.qzone.proxy.feedcomponent.b.c("feedskin", "getting error feed skin type " + feedSkin);
                    return null;
                }
                feedSkinData.strBgColor = feedSkin.strBgColor;
                feedSkinData.strGradientColorBegin = feedSkin.strGradientColorBegin;
                feedSkinData.strGradientColorEnd = feedSkin.strGradientColorEnd;
                feedSkinData.strFrameZip = feedSkin.strFrameZip;
                feedSkinData.iFrameRate = feedSkin.iFrameRate;
                feedSkinData.lv10Numbers = feedSkin.lv10Numbers;
            }
            feedSkinData.iNewFeedSkin = 1;
        } else {
            feedSkinData.iNewFeedSkin = 1;
        }
        return feedSkinData;
    }

    public static ArrayList<Object> f(cell_detail_content cell_detail_contentVar) {
        ArrayList<byte[]> arrayList;
        Object obj;
        Object obj2 = null;
        if (cell_detail_contentVar == null || (arrayList = cell_detail_contentVar.detail_content) == null || arrayList.size() <= 0) {
            return null;
        }
        ArrayList<byte[]> arrayList2 = cell_detail_contentVar.detail_content;
        ArrayList<Object> arrayList3 = new ArrayList<>();
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            UniAttribute uniAttribute = new UniAttribute();
            uniAttribute.setEncodeName("utf8");
            uniAttribute.decode(arrayList2.get(i3));
            if (uniAttribute.containsKey("enum_cell_text")) {
                cell_text cell_textVar = (cell_text) uniAttribute.get("enum_cell_text");
                obj = obj2;
                if (cell_textVar != null) {
                    TextInfo textInfo = new TextInfo();
                    textInfo.isLink = false;
                    textInfo.text = cell_textVar.data;
                    obj = textInfo;
                }
            } else if (uniAttribute.containsKey("enum_cell_pic")) {
                cell_pic cell_picVar = (cell_pic) uniAttribute.get("enum_cell_pic");
                obj = obj2;
                if (cell_picVar != null) {
                    ArrayList<s_picdata> arrayList4 = cell_picVar.picdata;
                    obj = obj2;
                    if (arrayList4 != null) {
                        obj = obj2;
                        if (arrayList4.size() > 0) {
                            obj = m(cell_picVar.picdata.get(0));
                        }
                    }
                }
            } else if (uniAttribute.containsKey("enum_cell_link")) {
                cell_link cell_linkVar = (cell_link) uniAttribute.get("enum_cell_link");
                obj = obj2;
                if (cell_linkVar != null) {
                    TextInfo textInfo2 = new TextInfo();
                    textInfo2.isLink = true;
                    textInfo2.text = cell_linkVar.data;
                    textInfo2.url = cell_linkVar.url;
                    textInfo2.post = cell_linkVar.post;
                    obj = textInfo2;
                }
            } else if (uniAttribute.containsKey("enum_cell_music")) {
                obj = j((cell_music) uniAttribute.get("enum_cell_music"));
            } else {
                obj = obj2;
                if (uniAttribute.containsKey("enum_cell_video")) {
                    obj = s((cell_video) uniAttribute.get("enum_cell_video"));
                }
            }
            if (obj != null) {
                arrayList3.add(obj);
            }
            i3++;
            obj2 = obj;
        }
        return arrayList3;
    }

    public static AudioInfo d(s_audio s_audioVar) {
        if (s_audioVar == null) {
            return null;
        }
        return new AudioInfo(s_audioVar.audiokey, s_audioVar.audiotime, s_audioVar.errormessge);
    }

    public static Comment e(s_commment s_commmentVar, String str) {
        if (s_commmentVar == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.feedKey = str;
        comment.commentid = s_commmentVar.commentid;
        comment.time = s_commmentVar.date;
        comment.replyNum = s_commmentVar.replynum;
        comment.user = q(s_commmentVar.user);
        comment.comment = s_commmentVar.content;
        comment.extendInfo = s_commmentVar.extendInfo;
        comment.bybass_extendInfo = s_commmentVar.binaryExtInfo;
        comment.audioInfo = d(s_commmentVar.audio);
        comment.refer = s_commmentVar.refer;
        comment.isDeleted = s_commmentVar.isDeleted;
        comment.isCanJubao = (s_commmentVar.displayflag & 2) != 0;
        if (s_commmentVar.replys != null) {
            comment.replies = new ArrayList();
            for (int i3 = 0; i3 < s_commmentVar.replys.size(); i3++) {
                comment.replies.add(p(s_commmentVar.replys.get(i3)));
            }
        }
        ArrayList<s_picdata> arrayList = s_commmentVar.picdata;
        if (arrayList != null && arrayList.size() > 0) {
            comment.pictureItems = new ArrayList<>();
            for (int i16 = 0; i16 < s_commmentVar.picdata.size(); i16++) {
                comment.pictureItems.add(m(s_commmentVar.picdata.get(i16)));
            }
        }
        ArrayList<s_picdata> arrayList2 = s_commmentVar.commentpic;
        if (arrayList2 != null && arrayList2.size() > 0) {
            comment.commentPictureItems = new ArrayList<>();
            for (int i17 = 0; i17 < s_commmentVar.commentpic.size(); i17++) {
                comment.commentPictureItems.add(m(s_commmentVar.commentpic.get(i17)));
            }
        }
        comment.floor = s_commmentVar.floor;
        comment.isPrivate = s_commmentVar.isPrivate == 1;
        comment.extendInfo = s_commmentVar.extendInfo;
        comment.bybass_extendInfo = s_commmentVar.binaryExtInfo;
        comment.isliked = s_commmentVar.isliked == 1;
        comment.likeNum = s_commmentVar.likeNum;
        comment.commentLikekey = s_commmentVar.commentLikekey;
        comment.isStickTop = s_commmentVar.isStickTop == 1;
        int i18 = s_commmentVar.displayflag;
        boolean z16 = (i18 & 1) != 0;
        comment.isNeedShrink = z16;
        comment.displayflag = i18;
        if (z16) {
            comment.displayReplyNum = s_commmentVar.iDisplayReplyNum;
        } else {
            comment.displayReplyNum = -1;
        }
        ArrayList<s_likeman> arrayList3 = s_commmentVar.likemans;
        if (arrayList3 != null && arrayList3.size() > 0) {
            comment.likeMen = new ArrayList<>();
            for (int i19 = 0; i19 < s_commmentVar.likemans.size(); i19++) {
                CellLikeInfo.LikeMan likeMan = new CellLikeInfo.LikeMan();
                s_likeman s_likemanVar = s_commmentVar.likemans.get(i19);
                User q16 = q(s_likemanVar.user);
                likeMan.user = q16;
                if (q16 != null) {
                    q16.superLike = s_likemanVar.superflag;
                }
                likeMan.likeType = s_likemanVar.superflag;
                comment.likeMen.add(likeMan);
            }
        }
        comment.needShowPraiseButton = (s_commmentVar.displayflag & 4) != 0;
        comment.pokeLikeCount = s_commmentVar.pokeLikeCount;
        comment.pokeLikeEmotion = s_commmentVar.pokeLikeEmotion;
        return comment;
    }

    public static FriendBirthdayGift g(s_gift_item s_gift_itemVar) {
        if (s_gift_itemVar == null) {
            return null;
        }
        FriendBirthdayGift friendBirthdayGift = new FriendBirthdayGift();
        String str = s_gift_itemVar.giftname;
        friendBirthdayGift.giftname = str;
        friendBirthdayGift.gifttype = s_gift_itemVar.gifttype;
        friendBirthdayGift.giftid = s_gift_itemVar.giftid;
        friendBirthdayGift.giftdesc = s_gift_itemVar.giftdesc;
        friendBirthdayGift.giftbackid = s_gift_itemVar.giftbackid;
        friendBirthdayGift.actiontype = s_gift_itemVar.actiontype;
        friendBirthdayGift.actionurl = s_gift_itemVar.actionurl;
        friendBirthdayGift.moreflag = s_gift_itemVar.moreflag;
        friendBirthdayGift.istiming = s_gift_itemVar.istiming;
        friendBirthdayGift.sendtime = s_gift_itemVar.sendtime;
        friendBirthdayGift.giftviewname = str;
        if (!TextUtils.isEmpty(str) && s_gift_itemVar.giftname.length() > 4) {
            friendBirthdayGift.giftviewname = s_gift_itemVar.giftname.substring(0, 4) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        Map<Integer, String> map = s_gift_itemVar.gifturl;
        if (map != null && map.size() > 0) {
            friendBirthdayGift.gifturl = new HashMap();
            friendBirthdayGift.giftImageUrl = new HashMap();
            Iterator<Integer> it = s_gift_itemVar.gifturl.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                String str2 = s_gift_itemVar.gifturl.get(Integer.valueOf(intValue));
                if (!TextUtils.isEmpty(str2)) {
                    friendBirthdayGift.giftImageUrl.put(Integer.valueOf(intValue), PictureUrl.calculateImageUrl(str2));
                    friendBirthdayGift.gifturl.put(Integer.valueOf(intValue), str2);
                }
            }
        }
        return friendBirthdayGift;
    }

    public static CellLeftThumb i(cell_left_thumb cell_left_thumbVar, boolean z16) {
        if (cell_left_thumbVar == null) {
            return null;
        }
        CellLeftThumb cellLeftThumb = new CellLeftThumb();
        cellLeftThumb.setMediaType(cell_left_thumbVar.mediatype);
        cellLeftThumb.setActionType(cell_left_thumbVar.actiontype);
        cellLeftThumb.setActionUrl(cell_left_thumbVar.actionturl);
        cellLeftThumb.setSummary(cell_left_thumbVar.summary);
        cellLeftThumb.setTitle(cell_left_thumbVar.title);
        cellLeftThumb.setUsePost(cell_left_thumbVar.usepost == 1);
        cellLeftThumb.setPostDatas(cell_left_thumbVar.postparams);
        cellLeftThumb.setPicActionType(cell_left_thumbVar.pic_actiontype);
        cellLeftThumb.setPicActionUrl(cell_left_thumbVar.pic_actionurl);
        cellLeftThumb.setPictureItem(m(cell_left_thumbVar.picdata));
        cellLeftThumb.setUser(q(cell_left_thumbVar.user));
        cellLeftThumb.calculateMembers(z16);
        cellLeftThumb.setExtendInfo(cell_left_thumbVar.mapExt);
        return cellLeftThumb;
    }

    public static MusicInfo j(cell_music cell_musicVar) {
        if (cell_musicVar == null) {
            return null;
        }
        MusicInfo musicInfo = new MusicInfo();
        musicInfo.musicId = cell_musicVar.musicid;
        musicInfo.musicUrl = cell_musicVar.musicurl;
        musicInfo.coverUrl = new PictureUrl(cell_musicVar.coverurl, cell_musicVar.width, cell_musicVar.height);
        musicInfo.title = cell_musicVar.title;
        musicInfo.musictime = cell_musicVar.musictime;
        musicInfo.musicMid = cell_musicVar.musicMId;
        musicInfo.musicNUrl = cell_musicVar.musicMUrl;
        return musicInfo;
    }

    public static PicText l(st_pic_text st_pic_textVar) {
        if (st_pic_textVar == null) {
            return null;
        }
        PicText picText = new PicText();
        picText.pictureItem = m(st_pic_textVar.picinfo);
        if (st_pic_textVar.userlist != null) {
            picText.userList = new ArrayList<>();
            Iterator<s_user> it = st_pic_textVar.userlist.iterator();
            while (it.hasNext()) {
                picText.userList.add(q(it.next()));
            }
        }
        picText.summary = st_pic_textVar.summary;
        picText.title = st_pic_textVar.title;
        picText.actionType = st_pic_textVar.actiontype;
        picText.actionUrl = st_pic_textVar.actionurl;
        picText.postFix = st_pic_textVar.postfix;
        picText.playurl = st_pic_textVar.playurl;
        picText.descBeforeClick = st_pic_textVar.desc_before_click;
        picText.descPostClick = st_pic_textVar.desc_after_click;
        picText.strHeader = st_pic_textVar.strHeader;
        return picText;
    }

    public static PictureItem m(s_picdata s_picdataVar) {
        if (s_picdataVar == null) {
            return null;
        }
        PictureItem pictureItem = new PictureItem();
        pictureItem.picname = s_picdataVar.picname;
        pictureItem.albumId = s_picdataVar.albumid;
        pictureItem.sloc = s_picdataVar.sloc;
        pictureItem.lloc = s_picdataVar.lloc;
        pictureItem.type = s_picdataVar.type;
        pictureItem.busi_param = s_picdataVar.busi_param;
        pictureItem.opsynflag = s_picdataVar.opsynflag;
        pictureItem.isIndependentUgc = s_picdataVar.isIndependentUgc;
        pictureItem.isLike = s_picdataVar.ismylike;
        pictureItem.clientFakeKey = s_picdataVar.clientkey;
        pictureItem.flag = s_picdataVar.flag;
        pictureItem.piccategory = s_picdataVar.piccategory;
        pictureItem.opmask = s_picdataVar.opmask;
        pictureItem.viewCount = s_picdataVar.view_cnt;
        s_imgcrop s_imgcropVar = s_picdataVar.cropinfo;
        if (s_imgcropVar != null) {
            pictureItem.pivotXRate = ((float) s_imgcropVar.centerx_scale) / 100.0f;
            pictureItem.pivotYRate = ((float) s_imgcropVar.centery_scale) / 100.0f;
        }
        pictureItem.uploadTime = s_picdataVar.uUploadTime;
        pictureItem.modifytime = s_picdataVar.modifytime;
        pictureItem.desc = s_picdataVar.desc;
        pictureItem.isAutoPlayGif = s_picdataVar.isAutoPlayGif;
        Map<Integer, s_picurl> map = s_picdataVar.photourl;
        if (map != null) {
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                s_picurl s_picurlVar = s_picdataVar.photourl.get(Integer.valueOf(intValue));
                String str = s_picurlVar.url;
                if (str != null && str.length() != 0) {
                    if (intValue == 0) {
                        pictureItem.originUrl = n(s_picurlVar);
                    } else if (intValue == 1) {
                        pictureItem.bigUrl = n(s_picurlVar);
                    } else if (intValue == 11) {
                        pictureItem.currentUrl = n(s_picurlVar);
                    } else if (intValue == 14) {
                        pictureItem.downloadUrl = n(s_picurlVar);
                    }
                }
            }
        }
        ArrayList<stPhotoTag> arrayList = s_picdataVar.photoTag;
        if (arrayList != null) {
            pictureItem.photoTag = arrayList;
        }
        pictureItem.videoflag = s_picdataVar.videoflag;
        pictureItem.videodata = s(s_picdataVar.videodata);
        pictureItem.isCover = s_picdataVar.isCoverPic;
        pictureItem.luckyMoneyDesc = s_picdataVar.luckyMoneyDesc;
        pictureItem.musicInfo = j(s_picdataVar.musicdata);
        pictureItem.audio_summary = s_picdataVar.audio_summary;
        pictureItem.faceLists = FaceData.toFaceDataList(s_picdataVar.facelist, s_picdataVar.albumid, s_picdataVar.uploadUin);
        pictureItem.vecTagInfo = k(s_picdataVar);
        Map<String, String> map2 = s_picdataVar.mapExtern;
        if (map2 != null) {
            pictureItem.miniGameBgUrl = map2.get("mini_program_game_bg_url");
        }
        return pictureItem;
    }

    public static PictureUrl n(s_picurl s_picurlVar) {
        if (s_picurlVar == null) {
            return null;
        }
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.width = s_picurlVar.width;
        pictureUrl.height = s_picurlVar.height;
        String str = s_picurlVar.url;
        pictureUrl.url = str;
        pictureUrl.imageUrl = PictureUrl.calculateImageUrl(str);
        pictureUrl.enlargeRate = s_picurlVar.enlarge_rate;
        pictureUrl.size = s_picurlVar.size;
        pictureUrl.md5 = s_picurlVar.md5;
        return pictureUrl;
    }

    public static CellQbossPsvAdv o(cell_qboss_psv_adv cell_qboss_psv_advVar) {
        if (cell_qboss_psv_advVar == null) {
            return null;
        }
        CellQbossPsvAdv cellQbossPsvAdv = new CellQbossPsvAdv();
        cellQbossPsvAdv.mediatype = cell_qboss_psv_advVar.mediatype;
        cellQbossPsvAdv.picdata = m(cell_qboss_psv_advVar.picdata);
        cellQbossPsvAdv.title = cell_qboss_psv_advVar.title;
        cellQbossPsvAdv.summary = cell_qboss_psv_advVar.summary;
        cellQbossPsvAdv.countDownTime = cell_qboss_psv_advVar.countDownTime;
        cellQbossPsvAdv.backgd_picdata = m(cell_qboss_psv_advVar.backgd_picdata);
        cellQbossPsvAdv.psvAdvType = cell_qboss_psv_advVar.psvAdvType;
        cellQbossPsvAdv.markType = cell_qboss_psv_advVar.markType;
        cellQbossPsvAdv.btnText = cell_qboss_psv_advVar.btnText;
        cellQbossPsvAdv.actiontype = cell_qboss_psv_advVar.actiontype;
        cellQbossPsvAdv.actionurl = cell_qboss_psv_advVar.actionurl;
        cellQbossPsvAdv.float_picdata = m(cell_qboss_psv_advVar.float_picdata);
        Map<String, String> map = cell_qboss_psv_advVar.extendinfo;
        if (map != null && map.size() > 0) {
            cellQbossPsvAdv.extendinfo = new HashMap();
            for (Map.Entry<String, String> entry : cell_qboss_psv_advVar.extendinfo.entrySet()) {
                cellQbossPsvAdv.extendinfo.put(entry.getKey(), entry.getValue());
            }
        }
        return cellQbossPsvAdv;
    }

    public static Reply p(s_reply s_replyVar) {
        if (s_replyVar == null) {
            return null;
        }
        Reply reply = new Reply();
        reply.content = s_replyVar.content;
        reply.date = s_replyVar.date;
        reply.refer = s_replyVar.refer;
        reply.replyId = s_replyVar.replyid;
        reply.user = q(s_replyVar.user);
        reply.targetUser = q(s_replyVar.target);
        reply.audioInfo = d(s_replyVar.audio);
        reply.isDeleted = s_replyVar.isDeleted;
        reply.extendInfo = s_replyVar.extendInfo;
        int i3 = s_replyVar.displayflag;
        reply.isCanJubao = (i3 & 2) != 0;
        reply.isliked = s_replyVar.isliked == 1;
        reply.likeNum = s_replyVar.likeNum;
        reply.replyLikeKey = s_replyVar.replyLikeKey;
        reply.showLikeIcon = (i3 & 4) != 0;
        ArrayList<s_likeman> arrayList = s_replyVar.likemans;
        if (arrayList != null && arrayList.size() > 0) {
            reply.likeMen = new ArrayList<>();
            for (int i16 = 0; i16 < s_replyVar.likemans.size(); i16++) {
                CellLikeInfo.LikeMan likeMan = new CellLikeInfo.LikeMan();
                s_likeman s_likemanVar = s_replyVar.likemans.get(i16);
                User q16 = q(s_likemanVar.user);
                likeMan.user = q16;
                if (q16 != null) {
                    q16.superLike = s_likemanVar.superflag;
                }
                likeMan.likeType = s_likemanVar.superflag;
                reply.likeMen.add(likeMan);
            }
        }
        return reply;
    }

    public static User q(s_user s_userVar) {
        if (s_userVar == null) {
            return null;
        }
        User user = new User();
        user.from = s_userVar.from;
        user.uin = s_userVar.uin;
        user.nickName = s_userVar.nickname;
        user.timestamp = s_userVar.timestamp;
        user.uinKey = s_userVar.uinkey;
        user.logo = s_userVar.logo;
        user.vip = s_userVar.vip;
        user.vipLevel = s_userVar.level;
        String str = s_userVar.qzonedesc;
        if (str != null) {
            try {
                user.qzoneDesc = URLDecoder.decode(str, "UTF-8");
            } catch (Exception e16) {
                e16.printStackTrace();
                user.qzoneDesc = s_userVar.qzonedesc;
            }
        }
        user.descToken = s_userVar.qzonedesc_token;
        user.isOwner = s_userVar.is_owner;
        user.opMask = s_userVar.operation_mask;
        user.uid = s_userVar.uid;
        user.talkId = s_userVar.talk_id;
        user.portrait_id = s_userVar.portrait_id;
        user.is_own = s_userVar.is_own;
        user.isFamousWhite = s_userVar.isFamousWhite;
        user.isQzoneUser = s_userVar.isQzoneUser;
        user.eUserTypeReport = s_userVar.eUserTypeReport;
        user.isAnnualVip = s_userVar.isAnnualVip;
        user.isNickNameFlash = s_userVar.isSetNickGlint;
        user.isSweetVip = s_userVar.isSweetVip;
        combine_diamond_info combine_diamond_infoVar = s_userVar.stuCombineDiamondInfo;
        if (combine_diamond_infoVar != null) {
            user.comDiamondType = combine_diamond_infoVar.iShowType;
            user.comDiamondLevel = combine_diamond_infoVar.iVipLevel;
            user.isComDiamondAnnualVip = combine_diamond_infoVar.isAnnualVip;
            user.isAnnualVipEver = combine_diamond_infoVar.isAnnualVipEver;
        }
        star_info star_infoVar = s_userVar.stuStarInfo;
        if (star_infoVar != null) {
            user.starStatus = star_infoVar.iStarStatus;
            user.starLevel = star_infoVar.iStarLevel;
            user.isStarAnnualVip = star_infoVar.isAnnualVip;
            user.isHighStarVip = star_infoVar.isHighStarVip;
        }
        user.isSafeModeUser = s_userVar.isSafeModeUser;
        user.actiontype = s_userVar.actiontype;
        user.actionurl = s_userVar.actionurl;
        user.vipShowType = s_userVar.vipShowType;
        user.underNicknameDesc = s_userVar.under_nickname_desc;
        user.visitorCount = s_userVar.uVisitorCount;
        user.isCmtVerifyOpen = s_userVar.isCmtVerifyOpen;
        user.fansCount = s_userVar.uFansCount;
        String str2 = s_userVar.descicon;
        user.descicon = str2;
        user.desciconImageUrl = PictureUrl.calculateImageUrl(str2);
        user.famousSpaceMedal = UserMedal.createFamousSpaceMedal(s_userVar);
        user.curUserType = s_userVar.iCurUserType;
        user.displayflag = s_userVar.displayflag;
        user.sex = s_userVar.sex;
        user.isPrivateMode = s_userVar.isPrivateMode;
        String str3 = s_userVar.avatarRecomBar;
        if (str3 != null) {
            try {
                user.avatarRecomBar = URLDecoder.decode(str3, "UTF-8");
            } catch (Exception e17) {
                e17.printStackTrace();
                user.avatarRecomBar = s_userVar.avatarRecomBar;
            }
        }
        user.age = s_userVar.age;
        user.isVideoCircleVUser = s_userVar.isVideoCircleVUser;
        user.uFeedsCount = s_userVar.uFeedsCount;
        user.vipCommentInfo = QzoneVipCommentIconInfo.a(s_userVar.tmall_deco);
        com.qzone.adapter.feedcomponent.i.H().O2(user);
        return user;
    }

    public static VideoInfo t(cell_video cell_videoVar, boolean z16) {
        long longValue;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int networkType;
        s_videourl s_videourlVar;
        String str;
        if (cell_videoVar == null) {
            return null;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.videoId = cell_videoVar.videoid;
        videoInfo.actionType = cell_videoVar.actiontype;
        videoInfo.nativeLikeUrl = cell_videoVar.video_webview_url;
        videoInfo.videoType = cell_videoVar.videotype;
        videoInfo.playType = cell_videoVar.playtype;
        videoInfo.videoShowType = cell_videoVar.video_show_type;
        long j3 = cell_videoVar.videotime;
        videoInfo.videoTime = j3;
        videoInfo.videoSource = cell_videoVar.video_source;
        videoInfo.sloc = cell_videoVar.sloc;
        videoInfo.lloc = cell_videoVar.lloc;
        videoInfo.advDelayTime = cell_videoVar.adv_delay_time;
        videoInfo.videoStatus = cell_videoVar.videostatus;
        videoInfo.showVideoTime = VideoInfo.getShownTimeFromNumeric(j3);
        videoInfo.toast = cell_videoVar.toast;
        videoInfo.videoplaycnt = cell_videoVar.videoplaycnt;
        videoInfo.isOnWifiPlay = cell_videoVar.isOnWifiPlay;
        videoInfo.autoRefreshSecond = cell_videoVar.auto_refresh_second;
        videoInfo.hasSetPlayOnWifi = cell_videoVar.isHadSetPlayOnWifi;
        videoInfo.videoForm = cell_videoVar.video_form;
        videoInfo.videoClickType = cell_videoVar.video_click_type;
        videoInfo.videoHeaderDesc = cell_videoVar.header_desc;
        videoInfo.albumid = cell_videoVar.albumid;
        videoInfo.anonymity = cell_videoVar.anonymity;
        videoInfo.videoDesc = cell_videoVar.video_desc;
        videoInfo.mAfterLayerJumpUrl = cell_videoVar.afterLayerJumpUrl;
        int i29 = cell_videoVar.actiontype;
        if (i29 == 2 || i29 == 3 || i29 == 4 || i29 == 13 || i29 == 19) {
            videoInfo.videoUrl = new VideoUrl(cell_videoVar.actionurl);
        }
        if (videoInfo.playType != 0 || i29 == 45) {
            videoInfo.videoUrl = new VideoUrl(cell_videoVar.videourl);
        }
        videoInfo.actionUrl = cell_videoVar.actionurl;
        Map<Integer, s_videourl> map = cell_videoVar.videourls;
        boolean z17 = true;
        if (map != null) {
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                s_videourl s_videourlVar2 = cell_videoVar.videourls.get(Integer.valueOf(intValue));
                String str2 = s_videourlVar2.url;
                if (str2 != null && str2.length() != 0) {
                    try {
                        s_videourlVar2.url = URLDecoder.decode(s_videourlVar2.url, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                    } catch (Exception | OutOfMemoryError unused2) {
                        return null;
                    }
                    if (intValue == 0) {
                        videoInfo.videoUrl = new VideoUrl(s_videourlVar2.url, s_videourlVar2.videoprior);
                    } else if (intValue == 1) {
                        videoInfo.highBrUrl = new VideoUrl(s_videourlVar2.url, s_videourlVar2.videoprior);
                    } else if (intValue == 2) {
                        videoInfo.lowBrUrl = new VideoUrl(s_videourlVar2.url, s_videourlVar2.videoprior);
                    } else if (intValue == 3) {
                        videoInfo.originVideoUrl = new VideoUrl(s_videourlVar2.url, s_videourlVar2.videoprior);
                    } else if (intValue == 4) {
                        videoInfo.h265NormalUrl = new VideoUrl(s_videourlVar2.url, s_videourlVar2.videoprior);
                    } else if (intValue == 5) {
                        videoInfo.downloadVideoUrl = new VideoUrl(s_videourlVar2.url, s_videourlVar2.videoprior);
                    }
                }
            }
            if (z16 && cell_videoVar.videourls.size() > 0 && cell_videoVar.videourls.size() >= (networkType = FeedGlobalEnv.g().getNetworkType()) && networkType > 0 && (s_videourlVar = cell_videoVar.videourls.get(Integer.valueOf(networkType))) != null && (str = s_videourlVar.url) != null && str.length() != 0) {
                try {
                    String decode = URLDecoder.decode(s_videourlVar.url, "UTF-8");
                    s_videourlVar.url = decode;
                    videoInfo.videoUrl = new VideoUrl(decode, s_videourlVar.videoprior);
                    videoInfo.originVideoUrl = new VideoUrl(s_videourlVar.url, s_videourlVar.videoprior);
                } catch (UnsupportedEncodingException | Exception | OutOfMemoryError unused3) {
                }
            }
        }
        if (cell_videoVar.video_rate_list != null) {
            videoInfo.videoRateList = new ArrayList<>(cell_videoVar.video_rate_list.size());
            Iterator<s_videourl> it5 = cell_videoVar.video_rate_list.iterator();
            while (it5.hasNext()) {
                s_videourl next = it5.next();
                videoInfo.videoRateList.add(new VideoUrl(next.url, next.videoprior, next.videorate));
            }
        }
        videoInfo.currentVideoRate = cell_videoVar.cur_video_rate;
        Map<Integer, s_picurl> map2 = cell_videoVar.gaussPicUrl;
        if (map2 != null) {
            Iterator<Integer> it6 = map2.keySet().iterator();
            while (it6.hasNext()) {
                int intValue2 = it6.next().intValue();
                s_picurl s_picurlVar = cell_videoVar.gaussPicUrl.get(Integer.valueOf(intValue2));
                String str3 = s_picurlVar.url;
                if (str3 != null && str3.length() != 0) {
                    try {
                        s_picurlVar.url = URLDecoder.decode(s_picurlVar.url, "UTF-8");
                    } catch (UnsupportedEncodingException unused4) {
                    } catch (Exception | OutOfMemoryError unused5) {
                        return null;
                    }
                    if (intValue2 != 11 && intValue2 != 12) {
                        switch (intValue2) {
                        }
                    }
                    String str4 = s_picurlVar.url;
                    videoInfo.gauseBackgroudUrl = str4;
                    videoInfo.gauseBackgroudImageUrl = PictureUrl.calculateImageUrl(str4);
                }
            }
        }
        Map<Integer, s_picurl> map3 = cell_videoVar.coverurl;
        if (map3 != null) {
            Iterator<Integer> it7 = map3.keySet().iterator();
            while (it7.hasNext()) {
                int intValue3 = it7.next().intValue();
                s_picurl s_picurlVar2 = cell_videoVar.coverurl.get(Integer.valueOf(intValue3));
                String str5 = s_picurlVar2.url;
                if (str5 != null && str5.length() != 0) {
                    try {
                        s_picurlVar2.url = URLDecoder.decode(s_picurlVar2.url, "UTF-8");
                    } catch (UnsupportedEncodingException unused6) {
                    } catch (Exception | OutOfMemoryError unused7) {
                        return null;
                    }
                    if (intValue3 == 0) {
                        videoInfo.originUrl = n(s_picurlVar2);
                    } else if (intValue3 != 1) {
                        switch (intValue3) {
                            case 11:
                                videoInfo.currentUrl = n(s_picurlVar2);
                                break;
                            case 12:
                                videoInfo.coverUrl = n(s_picurlVar2);
                                break;
                            case 13:
                                videoInfo.dynamicCoverUrl = n(s_picurlVar2);
                                break;
                        }
                    } else {
                        videoInfo.bigUrl = n(s_picurlVar2);
                    }
                }
            }
            if (videoInfo.coverUrl == null) {
                videoInfo.coverUrl = videoInfo.currentUrl;
            }
            PictureUrl pictureUrl = videoInfo.coverUrl;
            if (pictureUrl != null) {
                TextUtils.isEmpty(pictureUrl.url);
            }
            PictureUrl pictureUrl2 = videoInfo.coverUrl;
            if (pictureUrl2 != null && (i27 = pictureUrl2.width) > 0 && (i28 = pictureUrl2.height) > 0) {
                videoInfo.width = i27;
                videoInfo.height = i28;
            } else {
                PictureUrl pictureUrl3 = videoInfo.currentUrl;
                if (pictureUrl3 != null && (i19 = pictureUrl3.width) > 0 && (i26 = pictureUrl3.height) > 0) {
                    videoInfo.width = i19;
                    videoInfo.height = i26;
                } else {
                    PictureUrl pictureUrl4 = videoInfo.bigUrl;
                    if (pictureUrl4 != null && (i17 = pictureUrl4.width) > 0 && (i18 = pictureUrl4.height) > 0) {
                        videoInfo.width = i17;
                        videoInfo.height = i18;
                    } else {
                        PictureUrl pictureUrl5 = videoInfo.originUrl;
                        if (pictureUrl5 != null && (i3 = pictureUrl5.width) > 0 && (i16 = pictureUrl5.height) > 0) {
                            videoInfo.width = i3;
                            videoInfo.height = i16;
                        }
                    }
                }
            }
        }
        Map<String, String> map4 = cell_videoVar.extendinfo;
        if (map4 != null) {
            String str6 = map4.get("org_video_size");
            try {
                videoInfo.originVideoSize = TextUtils.isEmpty(str6) ? 0L : Long.valueOf(str6).longValue();
            } catch (Exception unused8) {
                videoInfo.originVideoSize = 0L;
            }
            String str7 = cell_videoVar.extendinfo.get("videotime_in_qzone");
            try {
                if (TextUtils.isEmpty(str7)) {
                    longValue = videoInfo.videoTime;
                } else {
                    longValue = Long.valueOf(str7).longValue();
                }
                videoInfo.validVideoTime = longValue;
            } catch (Exception unused9) {
                videoInfo.validVideoTime = -1L;
            }
            long j16 = videoInfo.validVideoTime;
            if (j16 > 0 && j16 < videoInfo.videoTime) {
                videoInfo.validVideoTimeDesc = r(j16);
            }
            String str8 = cell_videoVar.extendinfo.get("write_from");
            try {
                videoInfo.writeFrom = TextUtils.isEmpty(str8) ? 0 : Integer.valueOf(str8).intValue();
            } catch (Exception unused10) {
            }
            String str9 = cell_videoVar.extendinfo.get("get_recomm_after_play");
            try {
                videoInfo.isGetRecommAfterPlay = TextUtils.isEmpty(str9) ? 0 : Integer.valueOf(str9).intValue();
            } catch (Exception unused11) {
            }
            String str10 = cell_videoVar.extendinfo.get(ALLOW_TX_ADV_PLATFROM_CINEMA.value);
            try {
                if (TextUtils.isEmpty(str10) || Integer.valueOf(str10).intValue() != 1) {
                    z17 = false;
                }
                videoInfo.allowShowPasterVideoAdv = z17;
            } catch (Exception unused12) {
            }
            String str11 = cell_videoVar.extendinfo.get(ADV_PRIORITY.value);
            if (str11 != null) {
                try {
                    if (!str11.isEmpty()) {
                        videoInfo.advPriority = str11.split(",");
                    }
                } catch (Exception unused13) {
                }
            }
            videoInfo.mOpenFullScreen = "1".equals(cell_videoVar.extendinfo.get("open_full_screen"));
            try {
                videoInfo.scrollToNextDelayTime = Integer.parseInt(cell_videoVar.extendinfo.get("after_paster_adv_play_time"));
            } catch (NumberFormatException unused14) {
            }
            com.qzone.proxy.feedcomponent.model.c.a(videoInfo, cell_videoVar.extendinfo);
        }
        if (cell_videoVar.videoremark != null) {
            VideoInfo.VideoRemark videoRemark = new VideoInfo.VideoRemark();
            videoInfo.videoRemark = videoRemark;
            s_videoremark s_videoremarkVar = cell_videoVar.videoremark;
            videoRemark.iconurl = s_videoremarkVar.iconurl;
            videoRemark.icondesc = s_videoremarkVar.icondesc;
            videoRemark.remark = s_videoremarkVar.remark;
            videoRemark.actiontype = s_videoremarkVar.actiontype;
            videoRemark.actionurl = s_videoremarkVar.actionurl;
            videoRemark.orgwebsite = s_videoremarkVar.orgwebsite;
        }
        videoInfo.videoMaxPlaytime = cell_videoVar.video_max_playtime;
        return videoInfo;
    }

    public static VideoInfo s(cell_video cell_videoVar) {
        if (cell_videoVar == null) {
            return null;
        }
        return t(cell_videoVar, false);
    }

    static String r(long j3) {
        if (j3 < 60000) {
            return (j3 / 1000) + "\u79d2";
        }
        if (j3 < 7200000) {
            return (j3 / 60000) + "\u5206\u949f";
        }
        return (j3 / 7200000) + "\u5c0f\u65f6";
    }
}
