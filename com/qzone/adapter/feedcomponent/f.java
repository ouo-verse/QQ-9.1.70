package com.qzone.adapter.feedcomponent;

import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_FEEDS.s_event_tag;
import NS_MOBILE_OPERATION.AudioInfo;
import NS_MOBILE_OPERATION.PicInfo;
import SWEET_NEW_PRIVILEGE.sweet_style_info_item;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.business.model.FeedHolidayCommentEvent;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCommentEssence;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellDiss;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellForwardListInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellLuckyMoney;
import com.qzone.proxy.feedcomponent.model.CellMallInfo;
import com.qzone.proxy.feedcomponent.model.CellPermissionInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellPokeLike;
import com.qzone.proxy.feedcomponent.model.CellRecommendList;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.ShootInfo;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.mobileqq.app.AppConstants;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import qzone.QzoneActivityPB$KVInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static long f41885a;

    /* renamed from: b, reason: collision with root package name */
    static Map<String, BitmapFactory.Options> f41886b = new HashMap();

    public static BusinessFeedData B(String str, String str2, int i3, int i16) {
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.feedType = i16;
        businessFeedData.getFeedCommInfo().feedskey = str;
        businessFeedData.getFeedCommInfo().ugckey = str;
        businessFeedData.getFeedCommInfo().clientkey = str;
        businessFeedData.getLocalInfo().setFake();
        businessFeedData.getFeedCommInfo().actiontype = 6;
        String X = i.H().X();
        if (!TextUtils.isEmpty(X)) {
            businessFeedData.getReferInfo().appNameReadableStr = X;
            businessFeedData.getReferInfo().appName = X;
            businessFeedData.getReferInfo().actionUrl = "mqzone://arouse/setphonetag?source=feed&version=1";
            businessFeedData.getReferInfo().actionType = 2;
            businessFeedData.getReferInfo().iconToken = "phone";
        }
        businessFeedData.getLocalInfo().canComment = true;
        businessFeedData.getLocalInfo().canLike = true;
        long j06 = i.H().j0();
        businessFeedData.getFeedCommInfo().time = System.currentTimeMillis();
        businessFeedData.getLbsInfo().location = str2;
        businessFeedData.getUser().set(j06, i.H().k0());
        if (i3 != 1) {
            businessFeedData.getPermissionInfo().permission_info = com.qzone.proxy.feedcomponent.util.m.b(i3);
            businessFeedData.getPermissionInfo().permission_visit = com.qzone.proxy.feedcomponent.util.m.a(i3);
        }
        m(businessFeedData);
        t(businessFeedData);
        return businessFeedData;
    }

    public static BitmapFactory.Options D(String str) {
        BufferedInputStream bufferedInputStream;
        if (f41886b.containsKey(str) && f41886b.get(str) != null) {
            return f41886b.get(str);
        }
        BitmapFactory.Options options = BitmapUtils.getOptions();
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                options.inJustDecodeBounds = true;
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 8192);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                BitmapFactory.decodeStream(bufferedInputStream, null, options);
                options.inJustDecodeBounds = false;
                f41886b.put(str, options);
                bufferedInputStream.close();
            } catch (Exception unused2) {
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                return options;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        }
        return options;
    }

    public static void D0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, boolean z16, int i3) {
        List<Reply> list;
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (queryWithMem.getCommentInfo().commments != null) {
            arrayList.addAll(queryWithMem.getCommentInfo().commments);
        }
        if (queryWithMem.getCommentEssence() != null && queryWithMem.getCommentEssence().commments != null) {
            arrayList.addAll(queryWithMem.getCommentEssence().commments);
        }
        if (arrayList.size() != 0) {
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                Comment comment = (Comment) arrayList.get(i16);
                String str4 = comment.commentid;
                if (str4 != null && str4.equals(str2) && (list = comment.replies) != null) {
                    for (Reply reply : list) {
                        String str5 = reply.replyId;
                        if (str5 != null && str5.equals(str3) && reply.isliked != z16) {
                            reply.isliked = z16;
                            reply.likeNum += z16 ? 1 : -1;
                            reply.showLikeIcon = true;
                            Log.d("ReplyLike", "onReplyLike," + dVar + " change like to " + z16);
                        }
                    }
                }
            }
        }
        d(queryWithMem);
        dVar.l(queryWithMem, null, true);
    }

    public static void E0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, boolean z16, int i3, String str4, String str5, boolean z17, int i16) {
        List<Reply> list;
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (queryWithMem.getCommentInfo().commments != null) {
            arrayList.addAll(queryWithMem.getCommentInfo().commments);
        }
        if (queryWithMem.getCommentEssence() != null && queryWithMem.getCommentEssence().commments != null) {
            arrayList.addAll(queryWithMem.getCommentEssence().commments);
        }
        if (arrayList.size() != 0) {
            int size = arrayList.size();
            for (int i17 = 0; i17 < size; i17++) {
                Comment comment = (Comment) arrayList.get(i17);
                String str6 = comment.commentid;
                if (str6 != null && str6.equals(str4) && (list = comment.replies) != null) {
                    Iterator<Reply> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Reply next = it.next();
                        String str7 = next.replyId;
                        if (str7 != null && str7.equals(str5)) {
                            if (next.isliked != z17) {
                                next.isliked = z17;
                                next.likeNum += z17 ? 1 : -1;
                                next.showLikeIcon = true;
                                Log.d("ReplyLike", "onReplyLikeResult, " + dVar + "change like to " + z17);
                            }
                        }
                    }
                }
            }
        }
        dVar.l(queryWithMem, null, true);
    }

    public static void G0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, String str4, String str5, int i3, int i16, int i17, String str6) {
        C0(dVar, str, str2, z16, str3, str4, str5, i3, i16, i17, str6);
    }

    public static boolean H(int i3, int i16) {
        if (h.b("QZoneSetting", "fakeLongPicEnabled", 1) == 1) {
            return com.qzone.proxy.feedcomponent.util.g.c(i3, i16);
        }
        return i3 * 5 <= i16;
    }

    public static void H0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, int i3) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        CellPermissionInfo permissionInfo = queryWithMem.getPermissionInfo();
        permissionInfo.permission_info = str2;
        permissionInfo.permission_visit = i3;
        permissionInfo.permission_mask = 1;
        dVar.l(queryWithMem, null, true);
    }

    private static boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath() + AppConstants.SDCARD_IMG_FAVORITE_SUFFIX);
    }

    public static void I0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, int i3) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        CellFeedCommInfo feedCommInfo = queryWithMem.getFeedCommInfo();
        if (feedCommInfo != null) {
            feedCommInfo.ugcRight = i3;
        }
        dVar.l(queryWithMem, null, true);
    }

    private static boolean J() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f41885a > 1000) {
            f41885a = currentTimeMillis;
            return false;
        }
        f41885a = currentTimeMillis;
        return true;
    }

    public static void K(com.qzone.proxy.feedcomponent.manager.d dVar, String str) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        queryWithMem.cellAlbumEntrance.isPending = true;
        dVar.l(queryWithMem, null, true);
    }

    public static void L(com.qzone.proxy.feedcomponent.manager.d dVar, boolean z16, String str, String str2) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        CellAlbumEntrance cellAlbumEntrance = queryWithMem.cellAlbumEntrance;
        cellAlbumEntrance.isPending = false;
        if (z16) {
            cellAlbumEntrance.guideButton = str2;
            cellAlbumEntrance.button_actiontype = -1;
        } else {
            cellAlbumEntrance.button_actiontype = 60;
            cellAlbumEntrance.guideButton = cellAlbumEntrance.guideButtonOri;
        }
        dVar.l(queryWithMem, null, true);
    }

    private static int M0(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return i3;
        }
    }

    public static String N0(String str) {
        char charAt;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length && ((charAt = str.charAt(i16)) == ' ' || charAt == '\r' || charAt == '\n' || charAt == '\t'); i16++) {
            if (charAt == '\n') {
                i3 = i16 + 1;
            }
        }
        int i17 = length - 1;
        while (true) {
            if (i17 < 0) {
                break;
            }
            char charAt2 = str.charAt(i17);
            if (charAt2 != ' ' && charAt2 != '\r' && charAt2 != '\n' && charAt2 != '\t') {
                length = i17 + 1;
                break;
            }
            i17--;
        }
        return str.substring(i3, length);
    }

    static void P0(BusinessFeedData businessFeedData) {
        CellForwardListInfo cellForwardInfo = businessFeedData.getCellForwardInfo();
        if (cellForwardInfo != null && !cellForwardInfo.isforward) {
            cellForwardInfo.isforward = true;
            cellForwardInfo.num++;
            User user = new User();
            user.set(i.H().j0(), i.H().k0());
            cellForwardInfo.fwdmans.add(0, user);
            return;
        }
        if (cellForwardInfo == null) {
            CellForwardListInfo cellForwardListInfo = new CellForwardListInfo();
            cellForwardListInfo.isforward = true;
            cellForwardListInfo.num = 1;
            User user2 = new User();
            user2.set(i.H().j0(), i.H().k0());
            cellForwardListInfo.fwdmans.add(0, user2);
            businessFeedData.cellForwardInfo = cellForwardListInfo;
        }
    }

    static void S(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, String str4, int i3, int i16, int i17) {
        T(dVar, str, str2, z16, str3, str4, i3, i16, i17, "", null);
    }

    public static void U(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, int i3) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (queryWithMem.getCommentInfo().commments != null) {
            arrayList.addAll(queryWithMem.getCommentInfo().commments);
        }
        if (queryWithMem.getCommentEssence() != null && queryWithMem.getCommentEssence().commments != null) {
            arrayList.addAll(queryWithMem.getCommentEssence().commments);
        }
        if (arrayList.size() != 0) {
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                Comment comment = (Comment) arrayList.get(i16);
                String str3 = comment.commentid;
                if (str3 != null && str3.equals(str2) && comment.isliked != z16) {
                    comment.isliked = z16;
                    comment.likeNum += z16 ? 1 : -1;
                    comment.isMyCommentPraise = true;
                    comment.needShowPraiseButton = true;
                    Log.d("CommentLike", "onCommentLike," + dVar + " change like to " + z16);
                }
            }
        }
        d(queryWithMem);
        dVar.l(queryWithMem, null, true);
    }

    public static void V(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, boolean z16, int i3, String str4, boolean z17, int i16) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (queryWithMem.getCommentInfo().commments != null) {
            arrayList.addAll(queryWithMem.getCommentInfo().commments);
        }
        if (queryWithMem.getCommentEssence() != null && queryWithMem.getCommentEssence().commments != null) {
            arrayList.addAll(queryWithMem.getCommentEssence().commments);
        }
        if (arrayList.size() != 0) {
            int size = arrayList.size();
            int i17 = 0;
            while (true) {
                if (i17 >= size) {
                    break;
                }
                Comment comment = (Comment) arrayList.get(i17);
                String str5 = comment.commentid;
                if (str5 == null || !str5.equals(str4)) {
                    i17++;
                } else if (comment.isliked != z17) {
                    comment.isliked = z17;
                    comment.likeNum += z17 ? 1 : -1;
                    comment.needShowPraiseButton = true;
                }
            }
        }
        Log.d("CommentLike", "onCommentLikeResult, " + dVar + "change like to " + z17);
        dVar.l(queryWithMem, null, true);
    }

    public static void X(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, String str4, int i3, int i16) {
        R(dVar, str, str2, z16, str3, str4, i3, i16);
    }

    public static void Y(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, int i3) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        boolean z16 = queryWithMem.getFeedCommInfo().appid == 334;
        g(queryWithMem, str2, queryWithMem.getCommentInfo(), i3, z16);
        h(str2, queryWithMem.getCommentEssence(), i3, z16);
        d(queryWithMem);
        dVar.l(queryWithMem, null, true);
    }

    public static void Z(com.qzone.proxy.feedcomponent.manager.d dVar, String str, int i3, int i16) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem != null) {
            if ((i3 > 0 || queryWithMem.feedType == 2) && queryWithMem.getFeedCommInfo().needAdvReport() && !J()) {
                i.H().d(queryWithMem.getOperationInfo().cookie, 7, i16, i3, 0, 1, true, queryWithMem.getFeedCommInfo().isInstalled, null, null, 0L, false, false, null, false, queryWithMem);
            }
        }
    }

    public static boolean a(BusinessFeedData businessFeedData, List<Comment> list, String str, String str2, PictureItem pictureItem, ArrayList<String> arrayList, Map<String, String> map, int i3) {
        int hashCode;
        boolean z16;
        boolean z17;
        QzoneBarrageEffectData.BarrageEffectInfo fromJson;
        Comment comment = new Comment();
        comment.time = (int) (System.currentTimeMillis() / 1000);
        comment.isFake = true;
        comment.isTempData = true;
        comment.comment = str;
        comment.fakeUniKey = str2;
        comment.replyNum = 0;
        comment.replies = null;
        comment.extendInfo = map;
        String str3 = comment.uniKey;
        if (str3 != null) {
            hashCode = str3.hashCode();
        } else {
            hashCode = str2 == null ? -1 : str2.hashCode();
        }
        comment.commentAreaCacheKey = Integer.valueOf(hashCode);
        if (map != null && map.containsKey("cmt_poke_emoji")) {
            comment.pokeLikeEmotion = map.get("cmt_poke_emoji");
        }
        if (map != null && map.containsKey("cmt_poke_count")) {
            try {
                comment.pokeLikeCount = Integer.parseInt(map.get("cmt_poke_count"));
                if (businessFeedData != null) {
                    if (businessFeedData.cellPokeLike == null) {
                        businessFeedData.cellPokeLike = new CellPokeLike();
                    }
                    businessFeedData.cellPokeLike.count += comment.pokeLikeCount;
                }
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        if (map != null && map.containsKey("private_barrage_data") && (fromJson = QzoneBarrageEffectData.BarrageEffectInfo.fromJson(map.get("private_barrage_data"))) != null && fromJson.f51896id > 0) {
            if (comment.bybass_extendInfo == null) {
                comment.bybass_extendInfo = new HashMap();
            }
            comment.bybass_extendInfo.put(UNIVERSAL_MALL_QUAL.value, fromJson.toJceData());
        }
        User user = new User();
        comment.user = user;
        user.set(i.H().j0(), i.H().k0());
        comment.user.vipCommentInfo = ch.j.d();
        comment.commentType = i3;
        d.a(comment);
        d.d(comment);
        if (pictureItem != null) {
            pictureItem.piccategory = 1;
            ArrayList<PictureItem> arrayList2 = new ArrayList<>();
            arrayList2.add(pictureItem);
            comment.pictureItems = arrayList2;
            z16 = true;
        } else {
            z16 = false;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (comment.commentPictureItems == null) {
                comment.commentPictureItems = new ArrayList<>();
            }
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                String str4 = arrayList.get(i16);
                if (!TextUtils.isEmpty(str4)) {
                    BitmapFactory.Options D = D(str4);
                    PictureItem pictureItem2 = new PictureItem();
                    if (z16) {
                        pictureItem2.piccategory = 1;
                    } else {
                        pictureItem2.piccategory = 2;
                    }
                    PictureUrl pictureUrl = new PictureUrl();
                    pictureItem2.currentUrl = pictureUrl;
                    pictureUrl.url = str4;
                    pictureUrl.imageUrl = PictureUrl.calculateImageUrl(str4);
                    PictureUrl pictureUrl2 = pictureItem2.currentUrl;
                    pictureUrl2.width = D.outWidth;
                    pictureUrl2.height = D.outHeight;
                    pictureItem2.bigUrl = pictureUrl2;
                    pictureItem2.originUrl = pictureUrl2;
                    pictureItem2.localFileUrl = str4;
                    E(pictureItem2);
                    comment.commentPictureItems.add(pictureItem2);
                }
            }
        }
        if (list.size() > 0) {
            for (int i17 = 0; i17 < list.size(); i17++) {
                if (list.get(i17).fakeUniKey.equals(comment.fakeUniKey)) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (z17) {
            return false;
        }
        list.add(comment);
        return true;
    }

    public static void a0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3) {
        ArrayList<Comment> arrayList;
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        CellCommentInfo commentInfo = queryWithMem.getCommentInfo();
        ArrayList<Comment> arrayList2 = commentInfo.commments;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            commentInfo = queryWithMem.getOriginalInfoSafe().getCommentInfo();
        }
        i(str2, str3, commentInfo);
        CellCommentEssence commentEssence = queryWithMem.getCommentEssence();
        if ((commentEssence == null || (arrayList = commentEssence.commments) == null || arrayList.isEmpty()) && queryWithMem.getOriginalInfoSafe() != null) {
            commentEssence = queryWithMem.getOriginalInfoSafe().getCommentEssence();
        }
        j(str2, str3, commentEssence);
        d(queryWithMem);
        dVar.l(queryWithMem, null, true);
    }

    public static boolean b(BusinessFeedData businessFeedData, List<Comment> list, User user, String str, String str2, String str3, HashMap<String, List<Reply>> hashMap, boolean z16, Map<String, String> map) {
        List<Reply> arrayList;
        boolean z17;
        Reply reply = new Reply();
        User user2 = new User();
        reply.user = user2;
        user2.set(i.H().j0(), i.H().k0());
        reply.user.vipCommentInfo = ch.j.d();
        reply.content = str;
        reply.isFake = true;
        reply.isTempData = true;
        reply.targetUser = user;
        reply.fakeUinKey = str3;
        reply.extendInfo = map;
        reply.date = (int) (System.currentTimeMillis() / 1000);
        Comment comment = null;
        if (z16 && list != null && list.isEmpty()) {
            Comment comment2 = new Comment();
            comment2.time = (int) (System.currentTimeMillis() / 1000);
            comment2.isFake = true;
            comment2.commentid = str2;
            if (!TextUtils.isEmpty(businessFeedData.getCellSummary().summary)) {
                comment2.comment = businessFeedData.getCellSummary().summary;
                comment2.user = user;
                comment2.commentPictureItems = businessFeedData.getCellSummary().summarypic;
                comment2.commentid = str2;
                ArrayList arrayList2 = new ArrayList();
                comment2.replies = arrayList2;
                arrayList2.add(reply);
                comment2.replyNum = 1;
            } else {
                comment2.comment = str;
                comment2.commentid = str2;
                comment2.replyNum = 0;
                comment2.replies = null;
                User user3 = new User();
                comment2.user = user3;
                user3.set(i.H().j0(), i.H().k0());
            }
            d.a(comment2);
            d.d(comment2);
            list.add(comment2);
            businessFeedData.getCommentInfo().commentNum++;
        } else {
            if (!TextUtils.isEmpty(str2) && list != null) {
                Iterator<Comment> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Comment next = it.next();
                    if (str2.equals(next.commentid)) {
                        comment = next;
                        break;
                    }
                }
            }
            if (comment != null) {
                List<Reply> list2 = comment.replies;
                if (list2 != null && list2.size() > 0) {
                    for (int i3 = 0; i3 < comment.replies.size(); i3++) {
                        if (comment.replies.get(i3).fakeUinKey.equals(reply.fakeUinKey)) {
                            z17 = true;
                            break;
                        }
                    }
                }
                z17 = false;
                if (z17) {
                    return false;
                }
                ArrayList arrayList3 = new ArrayList();
                List<Reply> list3 = comment.replies;
                if (list3 != null) {
                    arrayList3.addAll(list3);
                }
                arrayList3.add(reply);
                comment.replies = arrayList3;
                comment.replyNum++;
            } else if (hashMap != null) {
                if (hashMap.containsKey(str2)) {
                    arrayList = hashMap.get(str2);
                } else {
                    arrayList = new ArrayList<>();
                    hashMap.put(str2, arrayList);
                }
                arrayList.add(reply);
            }
        }
        return true;
    }

    public static void b0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, int i3, int i16) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem != null) {
            if ((i3 > 0 || queryWithMem.feedType == 2) && queryWithMem.getFeedCommInfo().needAdvReport() && !J()) {
                i.H().d(queryWithMem.getOperationInfo().cookie, 24, i16, i3, 0, 1, true, queryWithMem.getFeedCommInfo().isInstalled, null, null, 0L, false, false, null, false, queryWithMem);
            }
        }
    }

    public static void c0(com.qzone.proxy.feedcomponent.manager.d dVar, String str) {
        dVar.z("client_key='" + str + "'", true);
    }

    public static CellBottomRecomm e(s_event_tag s_event_tagVar) {
        CellBottomRecomm cellBottomRecomm = new CellBottomRecomm();
        cellBottomRecomm.anonymity = CellBottomRecomm.TYPE_EVENT_TAG;
        cellBottomRecomm.title = s_event_tagVar.show_txt;
        cellBottomRecomm.summary = s_event_tagVar.show_desc;
        if (!TextUtils.isEmpty(s_event_tagVar.f24992id)) {
            cellBottomRecomm.actionurl = "mqzone://arouse/eventtagpage?eventtag=" + s_event_tagVar.f24992id;
        }
        cellBottomRecomm.iconToken = "label";
        PictureItem pictureItem = new PictureItem();
        PictureUrl pictureUrl = new PictureUrl();
        pictureItem.currentUrl = pictureUrl;
        pictureUrl.url = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/bottomrecom_topic.png";
        pictureUrl.imageUrl = PictureUrl.calculateImageUrl("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/bottomrecom_topic.png");
        cellBottomRecomm.picinfo = pictureItem;
        return cellBottomRecomm;
    }

    public static CellBottomRecomm f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            CellBottomRecomm cellBottomRecomm = new CellBottomRecomm();
            cellBottomRecomm.title = jSONObject.optString("title");
            cellBottomRecomm.summary = jSONObject.optString("summary");
            cellBottomRecomm.actionurl = jSONObject.optString("jump_url");
            cellBottomRecomm.actiontype = jSONObject.optInt("action_type");
            cellBottomRecomm.buttontext = jSONObject.optString(AppDownloadCallback.BUTTON_TXT);
            String optString = jSONObject.optString("icon_url");
            if (!TextUtils.isEmpty(optString)) {
                PictureItem pictureItem = new PictureItem();
                PictureUrl pictureUrl = new PictureUrl();
                pictureItem.currentUrl = pictureUrl;
                pictureUrl.url = optString;
                pictureUrl.imageUrl = PictureUrl.calculateImageUrl(optString);
                cellBottomRecomm.picinfo = pictureItem;
            }
            return cellBottomRecomm;
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.j("FakeDataHelper2", "createCellBottomRecomm: failed", th5);
            return null;
        }
    }

    public static void g0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2) {
        Pair<CellPictureInfo, Boolean> m3;
        Object obj;
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null || (m3 = com.qzone.proxy.feedcomponent.util.d.m(queryWithMem)) == null || (obj = m3.first) == null || ((CellPictureInfo) obj).pics == null) {
            return;
        }
        ArrayList<PictureItem> arrayList = ((CellPictureInfo) obj).pics;
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            PictureItem pictureItem = arrayList.get(i3);
            if (pictureItem != null && pictureItem.lloc.equals(str2)) {
                arrayList.remove(i3);
                break;
            }
            i3++;
        }
        if (arrayList.size() > 0) {
            d(queryWithMem);
            dVar.l(queryWithMem, null, true);
            return;
        }
        dVar.z("feed_key='" + queryWithMem.getFeedCommInfo().feedskey + "'", true);
    }

    public static void h0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        dVar.z("feed_key='" + queryWithMem.getFeedCommInfo().feedskey + "'", true);
    }

    public static void i0(com.qzone.proxy.feedcomponent.manager.d dVar, String str) {
        dVar.z("client_key='" + str + "'", true);
    }

    public static void j0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, boolean z16, boolean z17) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        if (queryWithMem.getDissInfo().dissed == z16) {
            dVar.l(queryWithMem, null, z17);
            return;
        }
        queryWithMem.getDissInfoV2().dissed = z16;
        if (z16) {
            queryWithMem.getDissInfoV2().dissCount++;
        } else {
            CellDiss dissInfoV2 = queryWithMem.getDissInfoV2();
            dissInfoV2.dissCount--;
        }
        dVar.l(queryWithMem, null, z17);
    }

    public static void k0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        BusinessFeedData queryWithMem2 = dVar.queryWithMem(y(str2), str2, null);
        if (queryWithMem != null && queryWithMem.getFeedCommInfo().appid != 6600) {
            P0(queryWithMem);
            d(queryWithMem);
            dVar.l(queryWithMem, null, true);
        }
        if (queryWithMem2 == null || queryWithMem == null || queryWithMem.getFeedCommInfo().appid == 6600) {
            return;
        }
        P0(queryWithMem2);
        d(queryWithMem2);
        dVar.l(queryWithMem2, null, true);
    }

    static void m(BusinessFeedData businessFeedData) {
        User user = businessFeedData.getUser();
        QzoneVipInfo vipInfo = VipComponentProxy.f50997g.getServiceInterface().getVipInfo("" + i.H().j0());
        if (vipInfo == null) {
            return;
        }
        user.vip = vipInfo.getVipType();
        user.vipLevel = vipInfo.getVipLevel();
        user.isAnnualVip = vipInfo.isAnnualVip() ? (byte) 1 : (byte) 0;
        user.personalizedYellowVipUrl = vipInfo.getPersonalizedYellowVipUrl();
        user.vipShowType = (byte) -1;
        user.isCustomDiamond = vipInfo.isCustomDiamond();
        user.customDiamondUrl = vipInfo.getCustomDiamondUrl();
        CellMallInfo cellMallInfo = businessFeedData.cellMallInfo;
        if (cellMallInfo == null) {
            cellMallInfo = new CellMallInfo();
        }
        if (cellMallInfo.cellQQUionVip == null) {
            cellMallInfo.cellQQUionVip = new CellMallInfo.CellQQUionVip();
        }
        cellMallInfo.cellQQUionVip.iVip = vipInfo.isQQUnionVip() ? 1 : 0;
        cellMallInfo.cellQQUionVip.iLevel = vipInfo.getQQUnionVipLevel();
        cellMallInfo.cellQQUionVip.strUid = String.valueOf(i.H().j0());
    }

    public static void m0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(z(str, str2), str, str2);
        if (queryWithMem == null) {
            return;
        }
        queryWithMem.hasHighFive = true;
        queryWithMem.isFakeHighFive = true;
        dVar.l(queryWithMem, null, z16);
    }

    public static void n0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, boolean z16, boolean z17, int i3, CustomPraiseData customPraiseData, int i16, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        if (queryWithMem.getLikeInfo().isLiked == z16 && i16 < 0) {
            dVar.l(queryWithMem, null, z17);
        } else {
            Q0(dVar, str, z16, z17, i3, customPraiseData, i16, polymorphicPraiseEmotionData);
        }
    }

    public static void p0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, boolean z16, int i3, int i16, CustomPraiseData customPraiseData) {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        PictureItem pictureItem;
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null || (pictureInfo = queryWithMem.getPictureInfo()) == null || (arrayList = pictureInfo.pics) == null || arrayList.size() <= i3 || (pictureItem = arrayList.get(i3)) == null) {
            return;
        }
        pictureItem.isLike = z16;
        d(queryWithMem);
        dVar.l(queryWithMem, null, false);
    }

    static void t(BusinessFeedData businessFeedData) {
        User user = businessFeedData.getUser();
        sweet_style_info_item loveVipInfo = VipComponentProxy.f50997g.getServiceInterface().getLoveVipInfo("" + i.H().j0());
        if (loveVipInfo == null) {
            return;
        }
        CellMallInfo cellMallInfo = businessFeedData.cellMallInfo;
        if (cellMallInfo == null) {
            cellMallInfo = new CellMallInfo();
        }
        if (cellMallInfo.cellSweetVip == null) {
            cellMallInfo.cellSweetVip = new CellMallInfo.CellSweetVip();
        }
        cellMallInfo.cellSweetVip.iLevel = Long.valueOf(loveVipInfo.level);
        CellMallInfo.CellSweetVip cellSweetVip = cellMallInfo.cellSweetVip;
        cellSweetVip.iconPicUrl = loveVipInfo.pic_url;
        String str = loveVipInfo.jump_url;
        cellSweetVip.iconJumpUrl = str;
        cellSweetVip.extendMap = loveVipInfo.map_ext;
        if (user.isSweetVip != 0) {
            user.isSweetVip = (TextUtils.isEmpty(str) || TextUtils.isEmpty(loveVipInfo.pic_url)) ? 0 : 1;
        }
    }

    public static void u0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, List<String> list, HashMap<String, PicInfo> hashMap, ArrayList<AudioInfo> arrayList) {
        BusinessFeedData A = A(str, "");
        ArrayList<com.qzone.proxy.feedcomponent.model.AudioInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<AudioInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AudioInfo next = it.next();
                com.qzone.proxy.feedcomponent.model.AudioInfo audioInfo = new com.qzone.proxy.feedcomponent.model.AudioInfo();
                audioInfo.audioKey = next.playkey;
                audioInfo.audioTime = next.time;
                arrayList2.add(audioInfo);
            }
            A.setAudioInfo(arrayList2);
        }
        x(A, "", "", str2, list, 0L);
        dVar.w(A);
        FakeShuoShuoDataCacheHelper.f(A);
        dVar.notify(2, new Object[0]);
    }

    public static void v0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, boolean z16, boolean z17) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        CellRecommendList cellRecommendListSafe = queryWithMem.getCellRecommendListSafe();
        cellRecommendListSafe.isRecommended = z16;
        ArrayList<CellRecommendList.RecommendMan> arrayList = cellRecommendListSafe.recommendMans;
        int i3 = 0;
        if (z16) {
            User user = new User();
            user.uin = i.H().j0();
            user.nickName = i.H().k0();
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    if (arrayList.get(i16).user.uin == i.H().j0()) {
                        return;
                    }
                }
            } else {
                arrayList = new ArrayList<>();
                cellRecommendListSafe.recommendMans = arrayList;
            }
            arrayList.add(0, new CellRecommendList.RecommendMan(user));
            cellRecommendListSafe.num++;
        } else if (arrayList != null) {
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i3).user.uin == i.H().j0()) {
                    arrayList.remove(i3);
                    cellRecommendListSafe.num--;
                    break;
                }
                i3++;
            }
        }
        d(queryWithMem);
        dVar.l(queryWithMem, null, z17);
    }

    public static void y0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3) {
        com.qzone.proxy.feedcomponent.b.a("FakeDataHelper", "onRedBonusFeed ");
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null || queryWithMem.getCellLuckyMoney() == null || queryWithMem.getCellLuckyMoney().isGeted) {
            return;
        }
        queryWithMem.getCellLuckyMoney().isGeted = true;
        queryWithMem.getCellLuckyMoney().num++;
        ArrayList<User> arrayList = queryWithMem.getCellLuckyMoney().luckyMoneyMen;
        User user = new User();
        user.uin = i.H().j0();
        user.nickName = i.H().k0();
        ArrayList<User> arrayList2 = new ArrayList<>();
        arrayList2.add(user);
        if (arrayList != null) {
            User[] userArr = new User[(arrayList.size() + 1) % 15];
            arrayList2.addAll(arrayList);
        }
        queryWithMem.getCellLuckyMoney().luckyMoneyMen = arrayList2;
        dVar.l(queryWithMem, null, true);
    }

    public static String z(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append("ugc_key=?");
        }
        if (!TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(sb5)) {
                sb5.append(" AND ");
            }
            sb5.append("feed_key=?");
        }
        return sb5.toString();
    }

    public static void d0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3) {
        dVar.notify(24, str, str2, str3);
    }

    public static void e0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2) {
        dVar.u(String.format("%s = ? OR %s = ?", QZoneResult.UGC_KEY, "client_key"), new String[]{str, str2}, true);
    }

    public static void f0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2) {
        dVar.u(String.format("%s = ? AND %s = ?", QZoneResult.UGC_KEY, "client_key"), new String[]{str, str2}, true);
    }

    public static void v(CellPictureInfo cellPictureInfo, List list) {
        for (int i3 = 0; i3 < cellPictureInfo.pics.size(); i3++) {
            Object obj = list.get(i3);
            if (q.b().q(obj)) {
                if (((ShuoshuoVideoInfo) q.b().j(obj)) == null) {
                    return;
                }
                cellPictureInfo.setVideoPicMix(true);
                PictureItem pictureItem = cellPictureInfo.pics.get(i3);
                pictureItem.videodata = q.b().a(obj);
                pictureItem.videoflag = 1;
            }
        }
    }

    public static String y(String str) {
        return z(str, null);
    }

    public static void E(PictureItem pictureItem) {
        if (pictureItem == null || TextUtils.isEmpty(pictureItem.localFileUrl)) {
            return;
        }
        if (!pictureItem.localFileUrl.toLowerCase().endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) && !pictureItem.localFileUrl.endsWith("_qzonegif") && !I(pictureItem.localFileUrl)) {
            if (pictureItem.localFileUrl.toLowerCase().endsWith(".jpg")) {
                pictureItem.type = 1;
                return;
            } else {
                if (pictureItem.localFileUrl.toLowerCase().endsWith(".png")) {
                    pictureItem.type = 3;
                    return;
                }
                return;
            }
        }
        pictureItem.type = 2;
        pictureItem.isAutoPlayGif = true;
    }

    static boolean F(BusinessFeedData businessFeedData, int i3) {
        return businessFeedData != null && (businessFeedData.getFeedCommInfo().needAdvReport() || businessFeedData.isBrandUgcAdvFeeds()) && ((i3 >= 0 && i3 != 2 && businessFeedData.feedType == 4097) || ((i3 == 2 && businessFeedData.feedType == 2) || ((i3 == 7 && businessFeedData.isCanvasAd()) || (i3 == 3 && businessFeedData.feedType == 4098))));
    }

    private static void O0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getLikeInfoV2() == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        CellLikeInfo likeInfo = businessFeedData.getLikeInfo();
        likeInfo.likeNum--;
    }

    static void d(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            businessFeedData.feedInfo = "";
        }
    }

    static void i(String str, String str2, CellCommentInfo cellCommentInfo) {
        ArrayList<Comment> arrayList;
        Comment comment;
        List<Reply> list;
        if (cellCommentInfo == null || (arrayList = cellCommentInfo.commments) == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<Comment> arrayList2 = cellCommentInfo.commments;
        if (!TextUtils.isEmpty(str)) {
            Iterator<Comment> it = arrayList2.iterator();
            while (it.hasNext()) {
                comment = it.next();
                if (str.equals(comment.commentid)) {
                    break;
                }
            }
        }
        comment = null;
        if (comment == null || (list = comment.replies) == null || list.isEmpty() || str2 == null) {
            return;
        }
        ArrayList<Reply> arrayList3 = new ArrayList(comment.replies);
        for (Reply reply : arrayList3) {
            if (str2.equals(reply.replyId) || str2.equals(reply.fakeUinKey)) {
                comment.replyNum--;
                int i3 = cellCommentInfo.realCount;
                if (i3 > 0) {
                    cellCommentInfo.realCount = i3 - 1;
                }
                arrayList3.remove(reply);
                comment.replies = arrayList3;
            }
        }
        comment.replies = arrayList3;
    }

    static void j(String str, String str2, CellCommentEssence cellCommentEssence) {
        ArrayList<Comment> arrayList;
        Comment comment;
        List<Reply> list;
        if (cellCommentEssence == null || (arrayList = cellCommentEssence.commments) == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<Comment> arrayList2 = cellCommentEssence.commments;
        if (!TextUtils.isEmpty(str)) {
            Iterator<Comment> it = arrayList2.iterator();
            while (it.hasNext()) {
                comment = it.next();
                if (str.equals(comment.commentid)) {
                    break;
                }
            }
        }
        comment = null;
        if (comment == null || (list = comment.replies) == null || list.isEmpty() || str2 == null) {
            return;
        }
        ArrayList<Reply> arrayList3 = new ArrayList(comment.replies);
        for (Reply reply : arrayList3) {
            if (str2.equals(reply.replyId) || str2.equals(reply.fakeUinKey)) {
                comment.replyNum--;
                arrayList3.remove(reply);
                break;
            }
        }
        comment.replies = arrayList3;
    }

    public static void l0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, int i3, int i16, int i17, boolean z16) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null || i17 == 1 || !F(queryWithMem, i17) || J()) {
            return;
        }
        i.H().d(queryWithMem.getOperationInfo().cookie, z16 ? 37 : 6, i16, i3, 0, 0, true, queryWithMem.getFeedCommInfo().isInstalled, null, null, 0L, false, false, null, false, queryWithMem);
    }

    public static void q0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, ArrayList<User> arrayList, boolean z16) {
        BusinessFeedData queryWithMem;
        CellPictureInfo pictureInfo;
        if (arrayList == null || arrayList.isEmpty() || (queryWithMem = dVar.queryWithMem(y(str), str, null)) == null || (pictureInfo = queryWithMem.getPictureInfo()) == null) {
            return;
        }
        ArrayList<User> arrayList2 = pictureInfo.facemans;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            User user = arrayList.get(i3);
            int c16 = c(arrayList2, user);
            if (z16) {
                if (arrayList2.size() >= 30) {
                    break;
                }
                if (c16 < 0) {
                    arrayList2.add(0, user);
                    queryWithMem.getPictureInfo().faceman_num++;
                }
            } else if (c16 >= 0) {
                arrayList2.remove(c16);
                queryWithMem.getPictureInfo().faceman_num--;
            }
        }
        dVar.l(queryWithMem, null, true);
    }

    public static void u(BusinessFeedData businessFeedData, VideoInfo videoInfo, Object obj) {
        String str;
        if (obj != null) {
            str = q.b().d(obj);
        } else {
            str = "";
        }
        businessFeedData.getRemarkInfo().remark = str;
    }

    public static void w(BusinessFeedData businessFeedData, Object obj) {
        if (obj == null || TextUtils.isEmpty(q.b().d(obj))) {
            return;
        }
        CellBottomRecomm cellBottomRecomm = new CellBottomRecomm();
        cellBottomRecomm.title = "\u6b63\u5728\u4e0a\u4f20\u5230" + q.b().e(obj) + "\u00b7" + q.b().d(obj);
        cellBottomRecomm.buttonIconUrl = i.H().b0();
        cellBottomRecomm.iconToken = "qui_image";
        PictureItem pictureItem = new PictureItem();
        PictureUrl pictureUrl = new PictureUrl();
        pictureItem.currentUrl = pictureUrl;
        pictureUrl.url = q.b().r(obj);
        PictureUrl pictureUrl2 = pictureItem.currentUrl;
        pictureUrl2.imageUrl = PictureUrl.calculateImageUrl(pictureUrl2.url);
        cellBottomRecomm.picinfo = pictureItem;
        businessFeedData.setCellBottomRecomm(cellBottomRecomm);
    }

    public static BusinessFeedData A(String str, String str2) {
        return B(str, str2, 1, 4097);
    }

    private static boolean G(Map<String, String> map) {
        int i3;
        if (map == null || map.size() <= 0) {
            return false;
        }
        String str = map.get("is_from_comment_float");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            com.qzone.proxy.feedcomponent.b.d("FakeDataHelper2", "isFromCommentFloat", e16);
            i3 = 0;
        }
        return i3 == 1;
    }

    static boolean g(BusinessFeedData businessFeedData, String str, CellCommentInfo cellCommentInfo, int i3, boolean z16) {
        ArrayList<Comment> arrayList;
        CellPokeLike cellPokeLike;
        int i16;
        int i17;
        if (cellCommentInfo != null && (arrayList = cellCommentInfo.commments) != null && !arrayList.isEmpty() && !TextUtils.isEmpty(str)) {
            ArrayList<Comment> arrayList2 = cellCommentInfo.commments;
            int size = arrayList2.size();
            for (int i18 = 0; i18 < size; i18++) {
                Comment comment = arrayList2.get(i18);
                if (!str.equals(comment.commentid) && !str.equals(comment.fakeUniKey)) {
                    if (z16 && TextUtils.isEmpty(comment.commentid) && comment.time == i3) {
                        arrayList2.remove(comment);
                        cellCommentInfo.commentNum--;
                        cellCommentInfo.commments = arrayList2;
                        return true;
                    }
                } else {
                    arrayList2.remove(comment);
                    cellCommentInfo.commentNum--;
                    cellCommentInfo.commments = arrayList2;
                    int i19 = cellCommentInfo.realCount;
                    if (i19 > 0) {
                        cellCommentInfo.realCount = i19 - 1;
                    }
                    if (businessFeedData != null && (cellPokeLike = businessFeedData.cellPokeLike) != null && (i16 = comment.pokeLikeCount) > 0 && (i17 = cellPokeLike.count) >= i16) {
                        cellPokeLike.count = i17 - i16;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    static boolean h(String str, CellCommentEssence cellCommentEssence, int i3, boolean z16) {
        ArrayList<Comment> arrayList;
        if (cellCommentEssence != null && (arrayList = cellCommentEssence.commments) != null && !arrayList.isEmpty() && !TextUtils.isEmpty(str)) {
            ArrayList<Comment> arrayList2 = cellCommentEssence.commments;
            int size = arrayList2.size();
            for (int i16 = 0; i16 < size; i16++) {
                Comment comment = arrayList2.get(i16);
                if (!str.equals(comment.commentid) && !str.equals(comment.fakeUniKey)) {
                    if (z16 && TextUtils.isEmpty(comment.commentid) && comment.time == i3) {
                        arrayList2.remove(comment);
                        cellCommentEssence.commentNum--;
                        cellCommentEssence.commments = arrayList2;
                        return true;
                    }
                } else {
                    arrayList2.remove(comment);
                    cellCommentEssence.commentNum--;
                    cellCommentEssence.commments = arrayList2;
                    return true;
                }
            }
        }
        return false;
    }

    public static void k(BusinessFeedData businessFeedData, Map<String, String> map) {
        if (businessFeedData == null) {
            return;
        }
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        feedCommInfo.operatemask |= 1024;
        if (map != null) {
            feedCommInfo.appid = M0(map.get(QZonePublishMoodRequest.KEY_APPID_FOR_CLIENT_FAKE_FEED), 0);
            if (TextUtils.equals(map.get("keyIsSyncWechat"), "true")) {
                oo.b.f423230a.e().add(feedCommInfo.clientkey);
            }
        }
    }

    public static void n(BusinessFeedData businessFeedData, Map<String, String> map, Map<String, String> map2) {
        if (businessFeedData == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.put("is_feeds_long_pics_browsing_mode", map.get("is_feeds_long_pics_browsing_mode"));
        }
        if (map2 != null && map2.containsKey("feed_res")) {
            hashMap.put("feed_res", map2.get("feed_res"));
        }
        businessFeedData.getFeedCommInfo().extendInfo = hashMap;
    }

    public static void r0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo != null) {
            videoInfo.isFakeFeed = false;
        }
        dVar.l(businessFeedData, null, true);
        dVar.notify(10, businessFeedData);
        String j3 = com.qzone.reborn.util.i.b().j(com.qzone.common.business.service.d.INSTANCE.b(str), "");
        if (!TextUtils.isEmpty(j3)) {
            QzoneActivityPB$KVInfo qzoneActivityPB$KVInfo = new QzoneActivityPB$KVInfo();
            qzoneActivityPB$KVInfo.key.set(QZonePublishMoodRequest.KEY_INFO_HOLIDAY_PUBLISH, true);
            qzoneActivityPB$KVInfo.val.set(j3, true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(qzoneActivityPB$KVInfo);
            com.qzone.common.business.service.d.e().k(LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO, ef.b.a(businessFeedData), arrayList);
            return;
        }
        com.qzone.common.business.service.d.e().j(LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO, ef.b.a(businessFeedData));
    }

    public static void t0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, List<String> list, List<String> list2, List<Point> list3, String str3, int i3) {
        BusinessFeedData B = B(str, "", 0, i3);
        r(B, "", "", list, list3, 0L, null);
        int min = Math.min(list.size(), list2.size());
        for (int i16 = 0; i16 < min; i16++) {
            B.getPictureInfo().pics.get(i16).luckyMoneyDesc = list2.get(i16);
        }
        CellSummary cellSummary = new CellSummary();
        cellSummary.displayStr = str3;
        cellSummary.summary = str3;
        CellLuckyMoney cellLuckyMoney = new CellLuckyMoney();
        cellLuckyMoney.luckyMoneyPayId = str2;
        B.setCellLuckyMoney(cellLuckyMoney);
        B.setCellSummary(cellSummary);
        B.setPermissionInfo(null);
        B.setFakeRedPocketFeed(true);
        dVar.w(B);
        FakeShuoShuoDataCacheHelper.f(B);
        dVar.notify(2, new Object[0]);
    }

    public static void o0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, boolean z16, int i3, int i16, int i17) {
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null || i17 == 1) {
            return;
        }
        if (i16 != 0) {
            boolean z17 = !z16;
            if (queryWithMem.getLikeInfo().isLiked == z17) {
                dVar.l(queryWithMem, null, true);
            } else {
                Q0(dVar, str, z17, true, 0, null, 0, null);
            }
        }
        if (!F(queryWithMem, i17) || J()) {
            return;
        }
        i.H().d(queryWithMem.getOperationInfo().cookie, 5, i16, i3, 0, !z16 ? 1 : 0, true, queryWithMem.getFeedCommInfo().isInstalled, null, null, 0L, false, false, null, false, queryWithMem);
    }

    public static void x(BusinessFeedData businessFeedData, String str, String str2, String str3, List<String> list, long j3) {
        if (list != null && !list.isEmpty()) {
            CellPictureInfo cellPictureInfo = new CellPictureInfo();
            int min = Math.min(list.size(), 9);
            cellPictureInfo.pics = new ArrayList<>(min);
            long j16 = j3;
            for (int i3 = 0; i3 < min; i3++) {
                String str4 = list.get(i3);
                if (!TextUtils.isEmpty(str4)) {
                    BitmapFactory.Options h16 = !URLUtil.isNetworkUrl(str4) ? q.b().h(str4) : null;
                    PictureItem pictureItem = new PictureItem();
                    PictureUrl pictureUrl = new PictureUrl();
                    pictureItem.currentUrl = pictureUrl;
                    pictureUrl.url = str4;
                    pictureUrl.imageUrl = PictureUrl.calculateImageUrl(str4);
                    pictureItem.audio_summary = str3;
                    if (h16 != null) {
                        PictureUrl pictureUrl2 = pictureItem.currentUrl;
                        pictureUrl2.width = h16.outWidth;
                        pictureUrl2.height = h16.outHeight;
                        if ("image/gif".equalsIgnoreCase(h16.outMimeType)) {
                            pictureItem.currentUrl.pictureType = 2;
                            pictureItem.type = 2;
                            pictureItem.isAutoPlayGif = true;
                        }
                        if (H(h16.outWidth, h16.outHeight)) {
                            pictureItem.setChangtuFlag(true);
                        }
                    }
                    PictureUrl pictureUrl3 = pictureItem.currentUrl;
                    pictureItem.bigUrl = pictureUrl3;
                    pictureItem.originUrl = pictureUrl3;
                    pictureItem.localFileUrl = str4;
                    if (min > 1) {
                        pictureItem.pivotXRate = 0.5f;
                        pictureItem.pivotYRate = 0.5f;
                    } else {
                        pictureItem.pivotXRate = 0.5f;
                        pictureItem.pivotYRate = 0.0f;
                    }
                    j16++;
                    pictureItem.clientFakeKey = i.H().j0() + "_" + j16 + "_" + businessFeedData.getFeedCommInfo().clientkey;
                    cellPictureInfo.pics.add(pictureItem);
                }
            }
            cellPictureInfo.uploadnum = list.size();
            businessFeedData.setPictureInfo(cellPictureInfo);
            if (businessFeedData.isBabyAlbumFeed() || businessFeedData.isTravelAlbumFeed() || businessFeedData.isIndividualAlbumData()) {
                cellPictureInfo.actiontype = 32;
                cellPictureInfo.albumshowmask |= 2;
            }
        }
        businessFeedData.getTitleInfo().title = str;
        businessFeedData.getCellSummary().summary = str2;
        businessFeedData.getRemarkInfo().remark = "";
    }

    public static void x0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, long j3, int i3) {
        com.qzone.proxy.feedcomponent.b.a("FakeDataHelper", "onRedBonusFeed ");
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null || queryWithMem.getCellRedBonusSafe().payMoney == j3) {
            return;
        }
        if (j3 != 0) {
            if (!queryWithMem.getCellRedBonus().isPayed) {
                queryWithMem.getCellRedBonus().isPayed = true;
                queryWithMem.getCellRedBonus().payMenNum++;
            }
            queryWithMem.getCellRedBonus().payNum++;
            queryWithMem.getCellRedBonus().payTotalAccount += j3 - queryWithMem.getCellRedBonus().payMoney;
            queryWithMem.getCellRedBonus().payMoney = j3;
        }
        if (F(queryWithMem, i3)) {
            i.H().e(queryWithMem.getOperationInfo().cookie, 38, 0, 0, null, 0, 0, true, false);
        }
        dVar.l(queryWithMem, null, true);
    }

    public static long C(Map<String, String> map) {
        if (map == null) {
            return 0L;
        }
        String str = map.get("capturetime");
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Q0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, boolean z16, boolean z17, int i3, CustomPraiseData customPraiseData, int i16, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData) {
        CustomPraiseData g16;
        User user;
        BusinessFeedData queryWithMem = dVar.queryWithMem(y(str), str, null);
        if (queryWithMem == null) {
            return;
        }
        queryWithMem.getLikeInfo().isLiked = z16;
        ArrayList<CellLikeInfo.LikeMan> arrayList = queryWithMem.getLikeInfo().likeMans;
        int i17 = 0;
        if (z16) {
            if (queryWithMem.isGDTAdvFeed()) {
                if (queryWithMem.getCellDecorateInfo() != null && queryWithMem.getCellDecorateInfo().cellCustomPraise != null && queryWithMem.feedType == 4097) {
                    g16 = com.qzone.proxy.feedcomponent.service.a.b().c(queryWithMem.getCellDecorateInfo().cellCustomPraise);
                    if (!queryWithMem.isGDTAdvFeed()) {
                        if (g16 != null && g16.itemId > 0) {
                            CellDecorateInfo cellDecorateInfo = queryWithMem.getCellDecorateInfo();
                            if (cellDecorateInfo == null) {
                                cellDecorateInfo = new CellDecorateInfo();
                            }
                            cellDecorateInfo.cellCustomPraise = g16.toCellCustomPraise();
                            cellDecorateInfo.cellPolymorphicPraise = null;
                            queryWithMem.cellDecorateInfo = cellDecorateInfo;
                        } else {
                            CellDecorateInfo cellDecorateInfo2 = queryWithMem.cellDecorateInfo;
                            if (cellDecorateInfo2 != null) {
                                cellDecorateInfo2.cellCustomPraise = null;
                                if (i16 < 0) {
                                    cellDecorateInfo2.cellPolymorphicPraise = null;
                                }
                            }
                        }
                    }
                    user = new User();
                    user.uin = i.H().j0();
                    user.nickName = i.H().k0();
                    if (arrayList == null) {
                        int size = arrayList.size();
                        int i18 = 0;
                        while (true) {
                            if (i18 >= size) {
                                break;
                            }
                            CellLikeInfo.LikeMan likeMan = arrayList.get(i18);
                            if (likeMan.user.uin != i.H().j0()) {
                                i18++;
                            } else {
                                if (i16 < 0 || polymorphicPraiseEmotionData == null) {
                                    return;
                                }
                                PolymorphicPraiseEmotionData polymorphicPraiseEmotionData2 = likeMan.polymorphicPraiseData;
                                if (polymorphicPraiseEmotionData2 != null && polymorphicPraiseEmotionData2.iItemId == polymorphicPraiseEmotionData.iItemId && polymorphicPraiseEmotionData2.pokeCombo == polymorphicPraiseEmotionData.pokeCombo) {
                                    return;
                                }
                                arrayList.remove(i18);
                                if (queryWithMem.getLikeInfo().likeNum > 0) {
                                    CellLikeInfo likeInfo = queryWithMem.getLikeInfo();
                                    likeInfo.likeNum--;
                                }
                            }
                        }
                    } else {
                        arrayList = new ArrayList<>();
                        queryWithMem.getLikeInfo().likeMans = arrayList;
                    }
                    if (i16 < 0 && polymorphicPraiseEmotionData != null) {
                        arrayList.add(0, new CellLikeInfo.LikeMan(user, 3, null, polymorphicPraiseEmotionData));
                        CellDecorateInfo cellDecorateInfo3 = queryWithMem.getCellDecorateInfo();
                        if (cellDecorateInfo3 == null) {
                            cellDecorateInfo3 = new CellDecorateInfo();
                        }
                        cellDecorateInfo3.cellPolymorphicPraise = polymorphicPraiseEmotionData.toCellPolymorphicPraise();
                        queryWithMem.cellDecorateInfo = cellDecorateInfo3;
                    } else {
                        arrayList.add(0, new CellLikeInfo.LikeMan(user, (g16 != null || g16.itemId <= 0) ? 0 : 2, g16));
                    }
                    queryWithMem.getLikeInfo().likeNum++;
                }
                g16 = null;
                if (!queryWithMem.isGDTAdvFeed()) {
                }
                user = new User();
                user.uin = i.H().j0();
                user.nickName = i.H().k0();
                if (arrayList == null) {
                }
                if (i16 < 0) {
                }
                arrayList.add(0, new CellLikeInfo.LikeMan(user, (g16 != null || g16.itemId <= 0) ? 0 : 2, g16));
                queryWithMem.getLikeInfo().likeNum++;
            } else {
                if (i16 < 0) {
                    g16 = QzoneCustomPraiseService.i().g();
                    if (queryWithMem.getUser().customPraiseData != null) {
                        g16 = queryWithMem.getUser().customPraiseData;
                    }
                    if (!queryWithMem.isGDTAdvFeed()) {
                    }
                    user = new User();
                    user.uin = i.H().j0();
                    user.nickName = i.H().k0();
                    if (arrayList == null) {
                    }
                    if (i16 < 0) {
                    }
                    arrayList.add(0, new CellLikeInfo.LikeMan(user, (g16 != null || g16.itemId <= 0) ? 0 : 2, g16));
                    queryWithMem.getLikeInfo().likeNum++;
                }
                g16 = null;
                if (!queryWithMem.isGDTAdvFeed()) {
                }
                user = new User();
                user.uin = i.H().j0();
                user.nickName = i.H().k0();
                if (arrayList == null) {
                }
                if (i16 < 0) {
                }
                arrayList.add(0, new CellLikeInfo.LikeMan(user, (g16 != null || g16.itemId <= 0) ? 0 : 2, g16));
                queryWithMem.getLikeInfo().likeNum++;
            }
        } else if (arrayList != null) {
            while (true) {
                if (i17 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i17).user.uin == i.H().j0()) {
                    arrayList.remove(i17);
                    O0(queryWithMem);
                    break;
                }
                i17++;
            }
        }
        d(queryWithMem);
        dVar.l(queryWithMem, null, z17);
    }

    public static void l(BusinessFeedData businessFeedData, Map<String, byte[]> map) {
        if (businessFeedData == null || map == null) {
            return;
        }
        businessFeedData.getCellSummary().fontInfo = CellSummary.CommFontInfo.crate(map);
    }

    public static void o(BusinessFeedData businessFeedData, Map<String, String> map) {
        if (businessFeedData == null || map == null) {
            return;
        }
        if (businessFeedData.getCellSummary().mapExt == null) {
            businessFeedData.getCellSummary().mapExt = new HashMap();
        }
        String str = map.get("diy_font_id");
        if (!TextUtils.isEmpty(str)) {
            businessFeedData.getCellSummary().mapExt.put("diy_font_id", str);
        }
        String str2 = map.get("diy_font_type");
        if (!TextUtils.isEmpty(str2)) {
            businessFeedData.getCellSummary().mapExt.put("diy_font_type", str2);
        }
        String str3 = map.get("diy_font_url");
        if (!TextUtils.isEmpty(str3)) {
            businessFeedData.getCellSummary().mapExt.put("diy_font_url", str3);
        }
        String str4 = map.get("sparkle_json");
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        businessFeedData.getCellSummary().mapExt.put("sparkle_json", str4);
    }

    public static void s(BusinessFeedData businessFeedData, Map<String, String> map) {
        if (businessFeedData == null || map == null) {
            return;
        }
        ShootInfo shootInfo = new ShootInfo();
        shootInfo.shoot_time = C(map);
        shootInfo.shoot_location = map.get("geo_idname");
        shootInfo.iconToken = "qui_location";
        businessFeedData.getRemarkInfo().shoot_info = shootInfo;
    }

    static void B0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, String str4, User user, String str5, boolean z16, Map<String, String> map) {
        ArrayList<Comment> arrayList;
        CellCommentInfo commentInfo;
        Comment comment;
        BusinessFeedData queryWithMem = dVar.queryWithMem(z(str, str5), str, str5);
        if (queryWithMem == null) {
            return;
        }
        ArrayList<Comment> arrayList2 = new ArrayList<>();
        CellCommentInfo commentInfo2 = queryWithMem.getOriginalInfoSafe().getCommentInfo();
        ArrayList<Comment> arrayList3 = commentInfo2.commments;
        if (arrayList3 == null || arrayList3.isEmpty() || queryWithMem.feedType == 2) {
            commentInfo2 = queryWithMem.getCommentInfo();
        }
        ArrayList<Comment> arrayList4 = commentInfo2.commments;
        if (arrayList4 != null) {
            arrayList2.addAll(arrayList4);
        }
        if (arrayList2.isEmpty() && (commentInfo = queryWithMem.getOriginalInfoSafe().getCommentInfo()) != null && (comment = commentInfo.mainComment) != null && !TextUtils.isEmpty(comment.commentid)) {
            arrayList2.add(commentInfo.mainComment);
            if (!arrayList2.isEmpty()) {
                arrayList2.get(0).commentPictureItems = queryWithMem.getCellSummary().summarypic;
            }
        }
        if (b(queryWithMem, arrayList2, user, str4, str3, str2, null, z16, map)) {
            commentInfo2.commments = arrayList2;
            int i3 = commentInfo2.realCount;
            if (i3 > 0) {
                commentInfo2.realCount = i3 + 1;
            }
            ArrayList<Comment> arrayList5 = new ArrayList<>();
            CellCommentEssence commentEssence = queryWithMem.getOriginalInfoSafe() != null ? queryWithMem.getOriginalInfoSafe().getCommentEssence() : null;
            if (commentEssence == null || (arrayList = commentEssence.commments) == null || arrayList.isEmpty() || queryWithMem.feedType == 2) {
                commentEssence = queryWithMem.getCommentEssence();
            }
            if (commentEssence != null) {
                ArrayList<Comment> arrayList6 = commentEssence.commments;
                if (arrayList6 != null) {
                    arrayList5.addAll(arrayList6);
                }
                if (!b(queryWithMem, arrayList5, user, str4, str3, str2, null, z16, map)) {
                    return;
                } else {
                    commentEssence.commments = arrayList5;
                }
            }
            d(queryWithMem);
            dVar.l(queryWithMem, null, true);
        }
    }

    static void Q(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, String str4, PictureItem pictureItem, boolean z16, ArrayList<String> arrayList, Map<String, String> map) {
        CellCommentInfo commentInfo;
        CellCommentEssence commentEssence;
        ArrayList<Comment> arrayList2;
        BusinessFeedData queryWithMem = dVar.queryWithMem(z(str, str4), str, str4);
        com.qzone.proxy.feedcomponent.b.i("FakeDataHelper", "onCommentFeed content:" + str3 + " ugckey:" + str + " fakeUniKey:" + str2 + " Feed:" + queryWithMem);
        if (queryWithMem == null) {
            return;
        }
        if (z16) {
            commentInfo = queryWithMem.getOriginalInfoSafe().getCommentInfo();
            ArrayList<Comment> arrayList3 = commentInfo.commments;
            if (arrayList3 == null || arrayList3.isEmpty()) {
                commentInfo = queryWithMem.getCommentInfo();
            }
            if (queryWithMem.hasHighFive) {
                queryWithMem.hasHighFive = false;
            }
        } else {
            commentInfo = queryWithMem.getCommentInfo();
        }
        if (queryWithMem.feedType != 12290) {
            ArrayList<Comment> arrayList4 = new ArrayList<>();
            ArrayList<Comment> arrayList5 = commentInfo.commments;
            if (arrayList5 != null) {
                arrayList4.addAll(arrayList5);
            }
            if (!a(queryWithMem, arrayList4, str3, str2, pictureItem, arrayList, map, 0)) {
                return;
            } else {
                commentInfo.commments = arrayList4;
            }
        }
        commentInfo.commentNum++;
        if (commentInfo.realCount > 0 || G(map)) {
            commentInfo.realCount++;
        }
        ArrayList<Comment> arrayList6 = new ArrayList<>();
        if (z16) {
            commentEssence = queryWithMem.getOriginalInfoSafe() != null ? queryWithMem.getOriginalInfoSafe().getCommentEssence() : null;
            if (commentEssence == null || (arrayList2 = commentEssence.commments) == null || arrayList2.isEmpty()) {
                commentEssence = queryWithMem.getCommentEssence();
            }
        } else {
            commentEssence = queryWithMem.getCommentEssence();
        }
        CellCommentEssence cellCommentEssence = commentEssence;
        if (cellCommentEssence != null) {
            ArrayList<Comment> arrayList7 = cellCommentEssence.commments;
            if (arrayList7 != null) {
                arrayList6.addAll(arrayList7);
            }
            if (!a(queryWithMem, arrayList6, str3, str2, pictureItem, arrayList, map, 1)) {
                return;
            }
            cellCommentEssence.commments = arrayList6;
            cellCommentEssence.commentNum++;
        }
        commentInfo.commentNumInfoFoldText = null;
        d(queryWithMem);
        dVar.l(queryWithMem, null, true);
    }

    public static void w0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, long j3) {
        x0(dVar, str, str2, str3, j3, -1);
    }

    static int c(ArrayList<User> arrayList, User user) {
        if (arrayList == null || user == null) {
            return -1;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            User user2 = arrayList.get(i3);
            if (user2 != null && user2.uin == user.uin) {
                return i3;
            }
        }
        return -1;
    }

    public static void s0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, List<String> list, VideoInfo videoInfo, String str3, Integer num, Map<String, String> map, ArrayList arrayList, s_event_tag s_event_tagVar, int i3, Map<String, byte[]> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, Map<String, String> map6) {
        CellBottomRecomm f16;
        BusinessFeedData B = B(str, str3, num.intValue(), i3);
        String N0 = N0(str2);
        s(B, map);
        B.setVideoInfo(videoInfo);
        l(B, map2);
        o(B, map);
        n(B, map4, map);
        if (arrayList != null) {
            CellDynamicAlbum cellDynamicAlbum = new CellDynamicAlbum();
            cellDynamicAlbum.layerTitle = q.b().g(arrayList.get(0));
            cellDynamicAlbum.layerText = arrayList.size() + "\u4e2a\u7cbe\u5f69\u77ac\u95f4";
            cellDynamicAlbum.opmask = CellDynamicAlbum.OPMASK;
            cellDynamicAlbum.buttonText = "\u64ad\u653e\u5f71\u96c6";
            B.setCellDynamicAlbum(cellDynamicAlbum);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(list.get(0));
            p(B, "", N0, arrayList2, 0L, null, map3);
        } else {
            q(B, "", N0, list, 0L, null, map3, map4);
        }
        if (s_event_tagVar != null) {
            B.setCellBottomRecomm(e(s_event_tagVar));
        }
        if (map5 != null && (f16 = f(map5.get("recomBottom"))) != null) {
            B.setCellBottomRecomm(f16);
        }
        k(B, map6);
        dVar.w(B);
        FakeShuoShuoDataCacheHelper.f(B);
        dVar.notify(2, B);
    }

    public static void J0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, List list, String str2, long j3, Object obj, int i3, Map<String, String> map, Map<String, String> map2) {
        String str3;
        BusinessFeedData B = B(str, str2, 1, i3);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Object obj2 : list) {
            arrayList.add(q.b().l(obj2));
            hashMap.put(q.b().l(obj2), q.b().k(obj2));
        }
        if (list.size() > 0) {
            str3 = q.b().f(list.get(0));
        } else {
            str3 = "";
        }
        s(B, map);
        o(B, map2);
        p(B, "", str3, arrayList, j3, obj, hashMap);
        w(B, obj);
        k(B, map2);
        if (B != null && B.getRemarkInfoV2() != null) {
            B.getRemarkInfoV2().remark = null;
        }
        dVar.w(B);
        FakeShuoShuoDataCacheHelper.f(B);
        dVar.notify(7, new Object[0]);
    }

    public static void N(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, int i3, int i16) {
        R(dVar, str, str2, z16, str3, null, i3, i16);
    }

    public static void p(BusinessFeedData businessFeedData, String str, String str2, List<String> list, long j3, Object obj, Map<String, String> map) {
        String str3;
        if (list != null && !list.isEmpty()) {
            CellPictureInfo cellPictureInfo = new CellPictureInfo();
            int min = Math.min(list.size(), 9);
            cellPictureInfo.pics = new ArrayList<>(min);
            if (obj != null) {
                cellPictureInfo.albumname = q.b().d(obj);
                if (q.b().o(obj)) {
                    cellPictureInfo.individualAlbum = true;
                }
            }
            long j16 = j3;
            for (int i3 = 0; i3 < min; i3++) {
                String str4 = list.get(i3);
                if (!TextUtils.isEmpty(str4)) {
                    BitmapFactory.Options h16 = !URLUtil.isNetworkUrl(str4) ? q.b().h(str4) : null;
                    PictureItem pictureItem = new PictureItem();
                    PictureUrl pictureUrl = new PictureUrl();
                    pictureItem.currentUrl = pictureUrl;
                    pictureUrl.url = str4;
                    pictureUrl.imageUrl = PictureUrl.calculateImageUrl(str4);
                    if (h16 != null) {
                        PictureUrl pictureUrl2 = pictureItem.currentUrl;
                        pictureUrl2.width = h16.outWidth;
                        pictureUrl2.height = h16.outHeight;
                        if ("image/gif".equalsIgnoreCase(h16.outMimeType)) {
                            pictureItem.currentUrl.pictureType = 2;
                            pictureItem.type = 2;
                            pictureItem.isAutoPlayGif = true;
                        }
                        if (H(h16.outWidth, h16.outHeight)) {
                            pictureItem.setChangtuFlag(true);
                        }
                    }
                    PictureUrl pictureUrl3 = pictureItem.currentUrl;
                    pictureItem.bigUrl = pictureUrl3;
                    pictureItem.originUrl = pictureUrl3;
                    pictureItem.localFileUrl = str4;
                    if (min > 1) {
                        pictureItem.pivotXRate = 0.5f;
                        pictureItem.pivotYRate = 0.5f;
                    } else {
                        pictureItem.pivotXRate = 0.5f;
                        pictureItem.pivotYRate = 0.0f;
                    }
                    if (map != null) {
                        String str5 = map.get(str4);
                        if ("1".equals(str5)) {
                            pictureItem.setCirclePanorama();
                        } else if ("2".equals(str5)) {
                            pictureItem.setBallPanorama();
                        }
                    }
                    j16++;
                    pictureItem.clientFakeKey = i.H().j0() + "_" + j16 + "_" + businessFeedData.getFeedCommInfo().clientkey;
                    cellPictureInfo.pics.add(pictureItem);
                }
            }
            cellPictureInfo.uploadnum = list.size();
            businessFeedData.setPictureInfo(cellPictureInfo);
            if (businessFeedData.isBabyAlbumFeed() || businessFeedData.isTravelAlbumFeed() || businessFeedData.isIndividualAlbumData()) {
                cellPictureInfo.actiontype = 32;
                cellPictureInfo.albumshowmask |= 2;
            }
            str3 = q.b().d(obj);
            if (obj != null && !TextUtils.isEmpty(str3)) {
                cellPictureInfo.balbum = true;
                if (q.b().c(obj) != 1) {
                    businessFeedData.getPermissionInfo().permission_info = q.b().m(obj);
                    businessFeedData.getPermissionInfo().permission_visit = q.b().c(obj);
                }
                businessFeedData.getTitleInfo().title = str;
                businessFeedData.getCellSummary().summary = str2;
                businessFeedData.getRemarkInfo().remark = str3;
            }
        }
        str3 = "";
        businessFeedData.getTitleInfo().title = str;
        businessFeedData.getCellSummary().summary = str2;
        businessFeedData.getRemarkInfo().remark = str3;
    }

    public static void r(BusinessFeedData businessFeedData, String str, String str2, List<String> list, List<Point> list2, long j3, Object obj) {
        String str3;
        if (list != null && !list.isEmpty()) {
            CellPictureInfo cellPictureInfo = new CellPictureInfo();
            int min = Math.min(list.size(), 9);
            cellPictureInfo.pics = new ArrayList<>(min);
            if (obj != null) {
                cellPictureInfo.albumname = q.b().d(obj);
                if (q.b().o(obj)) {
                    cellPictureInfo.individualAlbum = true;
                }
            }
            int i3 = 0;
            long j16 = j3;
            while (i3 < min) {
                String str4 = list.get(i3);
                Point point = (list2 == null || list2.size() <= i3) ? null : list2.get(i3);
                if (!TextUtils.isEmpty(str4)) {
                    BitmapFactory.Options h16 = URLUtil.isNetworkUrl(str4) ? null : q.b().h(str4);
                    PictureItem pictureItem = new PictureItem();
                    PictureUrl pictureUrl = new PictureUrl();
                    pictureItem.currentUrl = pictureUrl;
                    pictureUrl.url = str4;
                    pictureUrl.imageUrl = PictureUrl.calculateImageUrl(str4);
                    if (h16 != null) {
                        PictureUrl pictureUrl2 = pictureItem.currentUrl;
                        pictureUrl2.width = h16.outWidth;
                        pictureUrl2.height = h16.outHeight;
                        if ("image/gif".equalsIgnoreCase(h16.outMimeType)) {
                            pictureItem.currentUrl.pictureType = 2;
                            pictureItem.type = 2;
                        }
                        if (H(h16.outWidth, h16.outHeight)) {
                            pictureItem.setChangtuFlag(true);
                        }
                    }
                    if (point != null) {
                        PictureUrl pictureUrl3 = pictureItem.currentUrl;
                        pictureUrl3.width = point.x;
                        pictureUrl3.height = point.y;
                    }
                    PictureUrl pictureUrl4 = pictureItem.currentUrl;
                    pictureItem.bigUrl = pictureUrl4;
                    pictureItem.originUrl = pictureUrl4;
                    pictureItem.localFileUrl = str4;
                    if (min > 1) {
                        pictureItem.pivotXRate = 0.5f;
                        pictureItem.pivotYRate = 0.5f;
                    } else {
                        pictureItem.pivotXRate = 0.5f;
                        pictureItem.pivotYRate = 0.0f;
                    }
                    j16++;
                    pictureItem.clientFakeKey = i.H().j0() + "_" + j16 + "_" + businessFeedData.getFeedCommInfo().clientkey;
                    cellPictureInfo.pics.add(pictureItem);
                }
                i3++;
            }
            cellPictureInfo.uploadnum = list.size();
            businessFeedData.setPictureInfo(cellPictureInfo);
            if (businessFeedData.isBabyAlbumFeed() || businessFeedData.isTravelAlbumFeed() || businessFeedData.isIndividualAlbumData()) {
                cellPictureInfo.actiontype = 32;
                cellPictureInfo.albumshowmask |= 2;
            }
            str3 = q.b().d(obj);
            if (obj != null && !TextUtils.isEmpty(str3)) {
                cellPictureInfo.balbum = true;
                if (q.b().c(obj) != 1) {
                    businessFeedData.getPermissionInfo().permission_info = q.b().m(obj);
                    businessFeedData.getPermissionInfo().permission_visit = q.b().c(obj);
                }
                businessFeedData.getTitleInfo().title = str;
                businessFeedData.getCellSummary().summary = str2;
                businessFeedData.getRemarkInfo().remark = str3;
            }
        }
        str3 = "";
        businessFeedData.getTitleInfo().title = str;
        businessFeedData.getCellSummary().summary = str2;
        businessFeedData.getRemarkInfo().remark = str3;
    }

    public static void M(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, PictureItem pictureItem, ArrayList<String> arrayList, Map<String, String> map) {
        Q(dVar, str, str2, str3, null, pictureItem, false, arrayList, map);
    }

    public static void W(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, String str4, PictureItem pictureItem, Map<String, String> map) {
        Q(dVar, str, str2, str3, str4, pictureItem, true, null, map);
    }

    public static void z0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, String str4, User user, Map<String, String> map) {
        B0(dVar, str, str2, str3, str4, user, null, false, map);
    }

    public static void F0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, String str3, String str4, User user, String str5, Map<String, String> map) {
        B0(dVar, str, str2, str3, str4, user, str5, true, map);
    }

    public static void O(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, int i3, int i16, int i17) {
        S(dVar, str, str2, z16, str3, null, i3, i16, i17);
    }

    static void R(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, String str4, int i3, int i16) {
        S(dVar, str, str2, z16, str3, str4, i3, i16, -1);
    }

    public static void L0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, List list, String str2, long j3, Object obj, int i3, Map<String, String> map, int i16, Map<String, String> map2, Map<String, byte[]> map3, s_event_tag s_event_tagVar, HashMap<String, String> hashMap) {
        int i17 = 1;
        if (obj == null && map != null) {
            try {
                i17 = Integer.parseInt(map.get("shuoshuo_priv"));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        BusinessFeedData B = B(str, str2, i17, i3);
        ArrayList arrayList = new ArrayList();
        String str3 = "";
        for (Object obj2 : list) {
            if (q.b().p(obj2)) {
                Object i18 = q.b().i(obj2);
                arrayList.add(q.b().l(i18));
                if (TextUtils.isEmpty(str3)) {
                    str3 = q.b().f(i18);
                }
            } else {
                ShuoshuoVideoInfo shuoshuoVideoInfo = (ShuoshuoVideoInfo) q.b().j(obj2);
                arrayList.add(shuoshuoVideoInfo.mCoverUrl);
                if (TextUtils.isEmpty(str3)) {
                    str3 = shuoshuoVideoInfo.mDescription;
                }
            }
        }
        if (arrayList.size() != list.size()) {
            com.qzone.proxy.feedcomponent.b.c("FakeDataHelper", "onUploadVideoPic, some media has no path!");
            return;
        }
        B.setMixFake(i16);
        s(B, map);
        o(B, map2);
        l(B, map3);
        p(B, "", str3, arrayList, j3, obj, hashMap);
        v(B.getPictureInfo(), list);
        w(B, obj);
        k(B, map2);
        if (B.getRemarkInfoV2() != null) {
            B.getRemarkInfoV2().remark = null;
        }
        if (s_event_tagVar != null) {
            B.setCellBottomRecomm(e(s_event_tagVar));
        }
        dVar.w(B);
        FakeShuoShuoDataCacheHelper.f(B);
        dVar.notify(7, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void q(BusinessFeedData businessFeedData, String str, String str2, List<String> list, long j3, Object obj, Map<String, String> map, Map<String, String> map2) {
        String str3;
        String str4;
        int i3;
        int i16;
        int i17;
        boolean z16;
        List<String> list2 = list;
        Map<String, String> map3 = map;
        if (list2 != null && !list.isEmpty()) {
            CellPictureInfo cellPictureInfo = new CellPictureInfo();
            CellPictureInfo cellPictureInfo2 = new CellPictureInfo();
            int min = Math.min(list.size(), 9);
            if (map2 != null) {
                str4 = map2.get("is_feeds_long_pics_browsing_mode");
                if (str4.equals("1")) {
                    i3 = 1;
                    cellPictureInfo.pics = new ArrayList<>(i3);
                    cellPictureInfo2.pics = new ArrayList<>(min);
                    if (obj != null) {
                        cellPictureInfo.albumname = q.b().d(obj);
                        cellPictureInfo2.albumname = q.b().d(obj);
                        if (q.b().o(obj)) {
                            cellPictureInfo.individualAlbum = true;
                            cellPictureInfo2.individualAlbum = true;
                        }
                    }
                    long j16 = j3;
                    i16 = 0;
                    while (i16 < min) {
                        String str5 = list2.get(i16);
                        if (!TextUtils.isEmpty(str5)) {
                            BitmapFactory.Options h16 = !URLUtil.isNetworkUrl(str5) ? q.b().h(str5) : null;
                            PictureItem pictureItem = new PictureItem();
                            PictureUrl pictureUrl = new PictureUrl();
                            pictureItem.currentUrl = pictureUrl;
                            pictureUrl.url = str5;
                            pictureUrl.imageUrl = PictureUrl.calculateImageUrl(str5);
                            if (h16 != null) {
                                PictureUrl pictureUrl2 = pictureItem.currentUrl;
                                pictureUrl2.width = h16.outWidth;
                                pictureUrl2.height = h16.outHeight;
                                if ("image/gif".equalsIgnoreCase(h16.outMimeType)) {
                                    pictureItem.currentUrl.pictureType = 2;
                                    pictureItem.type = 2;
                                    z16 = 1;
                                    pictureItem.isAutoPlayGif = true;
                                } else {
                                    z16 = 1;
                                }
                                i17 = z16;
                                if (H(h16.outWidth, h16.outHeight)) {
                                    pictureItem.setChangtuFlag(z16);
                                    i17 = z16;
                                }
                            } else {
                                i17 = 1;
                            }
                            PictureUrl pictureUrl3 = pictureItem.currentUrl;
                            pictureItem.bigUrl = pictureUrl3;
                            pictureItem.originUrl = pictureUrl3;
                            pictureItem.localFileUrl = str5;
                            if (min > i17) {
                                pictureItem.pivotXRate = 0.5f;
                                pictureItem.pivotYRate = 0.5f;
                            } else {
                                pictureItem.pivotXRate = 0.5f;
                                pictureItem.pivotYRate = 0.0f;
                            }
                            if (map3 != null) {
                                String str6 = map3.get(str5);
                                if ("1".equals(str6)) {
                                    pictureItem.setCirclePanorama();
                                } else if ("2".equals(str6)) {
                                    pictureItem.setBallPanorama();
                                }
                            }
                            j16++;
                            pictureItem.clientFakeKey = i.H().j0() + "_" + j16 + "_" + businessFeedData.getFeedCommInfo().clientkey;
                            cellPictureInfo2.pics.add(pictureItem);
                            if (i16 < i3) {
                                if (str4.equals("1")) {
                                    pictureItem.pivotXRate = 0.5f;
                                    pictureItem.pivotYRate = 0.0f;
                                    pictureItem.fakeLongPic = 1;
                                    pictureItem.isAutoPlayGif = false;
                                }
                                cellPictureInfo.pics.add(pictureItem);
                                i16++;
                                list2 = list;
                                map3 = map;
                            }
                        }
                        i16++;
                        list2 = list;
                        map3 = map;
                    }
                    cellPictureInfo.uploadnum = list.size();
                    cellPictureInfo2.uploadnum = list.size();
                    businessFeedData.setPictureInfo(cellPictureInfo);
                    businessFeedData.setLongPicsCellPictureInfo(cellPictureInfo2);
                    if (!businessFeedData.isBabyAlbumFeed() || businessFeedData.isTravelAlbumFeed() || businessFeedData.isIndividualAlbumData()) {
                        cellPictureInfo.actiontype = 32;
                        cellPictureInfo2.actiontype = 32;
                        cellPictureInfo.albumshowmask |= 2;
                        cellPictureInfo2.albumshowmask |= 2;
                    }
                    str3 = q.b().d(obj);
                    if (obj != null && !TextUtils.isEmpty(str3)) {
                        cellPictureInfo.balbum = true;
                        cellPictureInfo2.balbum = true;
                        if (q.b().c(obj) != 1) {
                            businessFeedData.getPermissionInfo().permission_info = q.b().m(obj);
                            businessFeedData.getPermissionInfo().permission_visit = q.b().c(obj);
                        }
                        businessFeedData.getTitleInfo().title = str;
                        businessFeedData.getCellSummary().summary = str2;
                        businessFeedData.getRemarkInfo().remark = str3;
                    }
                }
            } else {
                str4 = "0";
            }
            i3 = min;
            cellPictureInfo.pics = new ArrayList<>(i3);
            cellPictureInfo2.pics = new ArrayList<>(min);
            if (obj != null) {
            }
            long j162 = j3;
            i16 = 0;
            while (i16 < min) {
            }
            cellPictureInfo.uploadnum = list.size();
            cellPictureInfo2.uploadnum = list.size();
            businessFeedData.setPictureInfo(cellPictureInfo);
            businessFeedData.setLongPicsCellPictureInfo(cellPictureInfo2);
            if (!businessFeedData.isBabyAlbumFeed()) {
            }
            cellPictureInfo.actiontype = 32;
            cellPictureInfo2.actiontype = 32;
            cellPictureInfo.albumshowmask |= 2;
            cellPictureInfo2.albumshowmask |= 2;
            str3 = q.b().d(obj);
            if (obj != null) {
                cellPictureInfo.balbum = true;
                cellPictureInfo2.balbum = true;
                if (q.b().c(obj) != 1) {
                }
                businessFeedData.getTitleInfo().title = str;
                businessFeedData.getCellSummary().summary = str2;
                businessFeedData.getRemarkInfo().remark = str3;
            }
        }
        str3 = "";
        businessFeedData.getTitleInfo().title = str;
        businessFeedData.getCellSummary().summary = str2;
        businessFeedData.getRemarkInfo().remark = str3;
    }

    public static void K0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, List list, VideoInfo videoInfo, String str2, long j3, Object obj, int i3, Map<String, String> map, Map<String, String> map2) {
        String str3;
        BusinessFeedData B = B(str, str2, 1, i3);
        B.setVideoInfo(videoInfo);
        if (videoInfo != null && videoInfo.isTranscoding) {
            B.getLocalInfo().setHalfReal();
        }
        s(B, map);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(q.b().l(it.next()));
            }
        }
        if (videoInfo != null) {
            str3 = videoInfo.desc;
        } else {
            str3 = "";
        }
        p(B, "", str3, arrayList, j3, obj, null);
        u(B, videoInfo, obj);
        o(B, map2);
        w(B, obj);
        k(B, map2);
        if (B.getRemarkInfoV2() != null) {
            B.getRemarkInfoV2().remark = null;
        }
        dVar.w(B);
        FakeShuoShuoDataCacheHelper.f(B);
        dVar.notify(8, new Object[0]);
    }

    static void C0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, String str4, String str5, int i3, int i16, int i17, String str6) {
        boolean z17;
        boolean z18;
        BusinessFeedData queryWithMem = dVar.queryWithMem(z(str, str4), str, str4);
        if (queryWithMem == null) {
            return;
        }
        if (F(queryWithMem, i17)) {
            int i18 = (queryWithMem.isGDTAdvFeed() && i17 == 3) ? i3 + 1 : i3;
            if (J()) {
                return;
            } else {
                i.H().d(queryWithMem.getOperationInfo().cookie, 24, i16, i18, 0, 0, true, queryWithMem.getFeedCommInfo().isInstalled, null, null, 0L, false, false, null, false, queryWithMem);
            }
        }
        ArrayList<Comment> arrayList = queryWithMem.getCommentInfo().commments;
        if (arrayList == null) {
            arrayList = queryWithMem.getOriginalInfoSafe().getCommentInfo().commments;
            z17 = true;
        } else {
            z17 = false;
        }
        if (arrayList != null && arrayList.size() != 0) {
            int size = arrayList.size();
            int i19 = 0;
            while (true) {
                if (i19 >= size) {
                    break;
                }
                Comment comment = arrayList.get(i19);
                String str7 = comment.commentid;
                if (str7 == null || !str7.equals(str3)) {
                    i19++;
                } else {
                    List<Reply> list = comment.replies;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList2 = new ArrayList(comment.replies);
                        int size2 = arrayList2.size();
                        int i26 = 0;
                        while (true) {
                            if (i26 >= size2) {
                                break;
                            }
                            Reply reply = (Reply) arrayList2.get(i26);
                            String str8 = reply.fakeUinKey;
                            if (str8 == null || !str8.equals(str2)) {
                                i26++;
                            } else if (z16) {
                                reply.isFake = false;
                                reply.replyId = str5;
                                reply.replyLikeKey = str6;
                            } else {
                                arrayList2.remove(reply);
                                comment.replies = arrayList2;
                                comment.replyNum--;
                                if (arrayList2.isEmpty() && comment.isFake) {
                                    arrayList.remove(comment);
                                    if (!z17) {
                                        queryWithMem.getCommentInfo().commentNum--;
                                    } else {
                                        queryWithMem.getOriginalInfoSafe().getCommentInfo().commentNum--;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        ArrayList<Comment> arrayList3 = queryWithMem.getCommentEssence() != null ? queryWithMem.getCommentEssence().commments : null;
        if (arrayList3 != null || queryWithMem.getOriginalInfoSafe() == null || queryWithMem.getOriginalInfoSafe().getCommentEssence() == null) {
            z18 = false;
        } else {
            arrayList3 = queryWithMem.getOriginalInfoSafe().getCommentEssence().commments;
            z18 = true;
        }
        if (arrayList3 != null && arrayList3.size() != 0) {
            int size3 = arrayList3.size();
            int i27 = 0;
            while (true) {
                if (i27 >= size3) {
                    break;
                }
                Comment comment2 = arrayList3.get(i27);
                String str9 = comment2.commentid;
                if (str9 == null || !str9.equals(str3)) {
                    i27++;
                } else {
                    List<Reply> list2 = comment2.replies;
                    if (list2 != null && list2.size() > 0) {
                        ArrayList arrayList4 = new ArrayList(comment2.replies);
                        int size4 = arrayList4.size();
                        int i28 = 0;
                        while (true) {
                            if (i28 >= size4) {
                                break;
                            }
                            Reply reply2 = (Reply) arrayList4.get(i28);
                            String str10 = reply2.fakeUinKey;
                            if (str10 == null || !str10.equals(str2)) {
                                i28++;
                            } else if (z16) {
                                reply2.isFake = false;
                                reply2.replyId = str5;
                            } else {
                                arrayList4.remove(reply2);
                                comment2.replies = arrayList4;
                                comment2.replyNum--;
                                if (arrayList4.isEmpty() && comment2.isFake) {
                                    arrayList.remove(comment2);
                                    if (!z18) {
                                        queryWithMem.getCommentEssence().commentNum--;
                                    } else {
                                        queryWithMem.getOriginalInfoSafe().getCommentEssence().commentNum--;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        dVar.l(queryWithMem, null, true);
    }

    public static void A0(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, String str4, int i3, int i16, int i17, String str5) {
        C0(dVar, str, str2, z16, str3, null, str4, i3, i16, i17, str5);
    }

    public static void P(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, int i3, int i16, int i17, String str4, Map<String, String> map) {
        T(dVar, str, str2, z16, str3, null, i3, i16, i17, str4, map);
    }

    static void T(com.qzone.proxy.feedcomponent.manager.d dVar, String str, String str2, boolean z16, String str3, String str4, int i3, int i16, int i17, String str5, Map<String, String> map) {
        ArrayList<Comment> arrayList;
        String str6;
        String str7;
        BusinessFeedData queryWithMem = dVar.queryWithMem(z(str, str4), str, str4);
        com.qzone.proxy.feedcomponent.b.i("FakeDataHelper", "onCommentFeedResult succ:" + z16 + " retCode:" + i16 + " ugckey:" + str + " fakeUniKey:" + str2 + " Feed:" + queryWithMem);
        if (queryWithMem == null || i17 == 1) {
            return;
        }
        if (F(queryWithMem, i17) && !J()) {
            i.H().d(queryWithMem.getOperationInfo().cookie, 7, i16, i3, 0, 0, true, queryWithMem.getFeedCommInfo().isInstalled, null, null, 0L, false, false, null, false, queryWithMem);
        }
        if (!z16 && queryWithMem.feedType == 12290) {
            queryWithMem.getCommentInfo().commentNum--;
        }
        ArrayList<Comment> arrayList2 = queryWithMem.getCommentInfo().commments;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int size = arrayList2.size();
            int i18 = 0;
            while (true) {
                if (i18 >= size) {
                    break;
                }
                Comment comment = arrayList2.get(i18);
                String str8 = comment.fakeUniKey;
                if (str8 == null || !str8.equals(str2)) {
                    i18++;
                } else if (z16) {
                    comment.commentid = str3;
                    comment.commentLikekey = str5;
                    comment.isFake = false;
                } else {
                    arrayList2.remove(comment);
                    queryWithMem.getCommentInfo().commments = arrayList2;
                    queryWithMem.getCommentInfo().commentNum--;
                }
            }
            queryWithMem.getCommentInfo().deleteRepeatComment(str3);
        }
        ArrayList<Comment> arrayList3 = queryWithMem.getOriginalInfoSafe().getCommentInfo().commments;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            int i19 = 0;
            while (true) {
                if (i19 >= size2) {
                    break;
                }
                Comment comment2 = arrayList3.get(i19);
                String str9 = comment2.fakeUniKey;
                if (str9 == null || !str9.equals(str2)) {
                    i19++;
                } else if (z16) {
                    comment2.commentid = str3;
                    comment2.isFake = false;
                } else {
                    arrayList3.remove(comment2);
                    queryWithMem.getOriginalInfoSafe().getCommentInfo().commments = arrayList3;
                    queryWithMem.getOriginalInfoSafe().getCommentInfo().commentNum--;
                }
            }
            queryWithMem.getOriginalInfoSafe().getCommentInfo().deleteRepeatComment(str3);
        }
        if (queryWithMem.getCommentEssence() != null) {
            ArrayList<Comment> arrayList4 = queryWithMem.getCommentEssence().commments;
            if (arrayList4 != null && !arrayList4.isEmpty()) {
                int size3 = arrayList4.size();
                int i26 = 0;
                while (true) {
                    if (i26 >= size3) {
                        break;
                    }
                    Comment comment3 = arrayList4.get(i26);
                    if (comment3 == null || (str7 = comment3.fakeUniKey) == null || !str7.equals(str2)) {
                        i26++;
                    } else if (z16) {
                        comment3.commentid = str3;
                        comment3.commentLikekey = str5;
                        comment3.isFake = false;
                    } else {
                        arrayList4.remove(comment3);
                        queryWithMem.getCommentEssence().commments = arrayList4;
                        queryWithMem.getCommentEssence().commentNum--;
                    }
                }
                queryWithMem.getCommentEssence().deleteRepeatComment(str3);
            }
            if (queryWithMem.getOriginalInfoSafe() != null && queryWithMem.getOriginalInfoSafe().getCommentEssence() != null && (arrayList = queryWithMem.getOriginalInfoSafe().getCommentEssence().commments) != null && !arrayList.isEmpty()) {
                int size4 = arrayList.size();
                int i27 = 0;
                while (true) {
                    if (i27 >= size4) {
                        break;
                    }
                    Comment comment4 = arrayList.get(i27);
                    if (comment4 == null || (str6 = comment4.fakeUniKey) == null || !str6.equals(str2)) {
                        i27++;
                    } else if (z16) {
                        comment4.commentid = str3;
                        comment4.isFake = false;
                    } else {
                        arrayList.remove(comment4);
                        queryWithMem.getOriginalInfoSafe().getCommentEssence().commments = arrayList;
                        queryWithMem.getOriginalInfoSafe().getCommentEssence().commentNum--;
                    }
                }
                queryWithMem.getOriginalInfoSafe().getCommentEssence().deleteRepeatComment(str3);
            }
        }
        if (queryWithMem.getFeedCommInfoV2() != null && map != null) {
            FeedHolidayCommentEvent.updateFeedCommExtendInfo(str3, queryWithMem, map);
        }
        dVar.l(queryWithMem, null, true);
    }
}
