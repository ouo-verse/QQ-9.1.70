package oj;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.proxy.feedcomponent.model.CellLbsInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.CellTitleInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.GpsInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.intimate.bean.QZoneIntimateUserBean;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.util.ArrayUtils;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import ef.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$GetSpaceMainPageHeadRsp;
import qzone.QZIntimateSpaceReader$PartnerInfo;
import qzone.QZIntimateSpaceReader$RelationIcon;
import qzone.QZIntimateSpaceReader$StClientFeed;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseCommon$StUserAccountBaseMate;
import qzone.QZoneBaseCommon$StUserAccountEntry;
import qzone.QZoneBaseMeta$StCellBottomRecomm;
import qzone.QZoneBaseMeta$StComment;
import qzone.QZoneBaseMeta$StFeed;
import qzone.QZoneBaseMeta$StFeedCellComment;
import qzone.QZoneBaseMeta$StFeedCellCommon;
import qzone.QZoneBaseMeta$StFeedCellLBS;
import qzone.QZoneBaseMeta$StFeedCellLike;
import qzone.QZoneBaseMeta$StFeedCellMedia;
import qzone.QZoneBaseMeta$StFeedCellSummary;
import qzone.QZoneBaseMeta$StFeedCellTitle;
import qzone.QZoneBaseMeta$StFeedCellUserInfo;
import qzone.QZoneBaseMeta$StGPS;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StLBS;
import qzone.QZoneBaseMeta$StLikeMan;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;
import qzone.QZoneBaseMeta$StReply;
import qzone.QZoneBaseMeta$StRichMsg;
import qzone.QZoneBaseMeta$StUser;
import qzone.QZoneBaseMeta$StVideo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J0\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u001e\u0010(\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020)H\u0002J\u001a\u00101\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010/\u001a\u00020.H\u0002J$\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00142\f\u00103\u001a\b\u0012\u0004\u0012\u0002020$2\u0006\u0010/\u001a\u00020.H\u0002J\u001c\u00107\u001a\u0004\u0018\u0001042\b\u00106\u001a\u0004\u0018\u0001022\u0006\u0010/\u001a\u00020.H\u0002J&\u0010;\u001a\b\u0012\u0004\u0012\u00020:0$2\u000e\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020.H\u0002J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u0002080$2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010$H\u0002J\u0012\u0010A\u001a\u00020@2\b\u0010?\u001a\u0004\u0018\u00010>H\u0002J\u0012\u0010E\u001a\u00020D2\b\u0010C\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010I\u001a\u00020H2\b\u0010G\u001a\u0004\u0018\u00010FH\u0002J\"\u0010N\u001a\u00020M2\b\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010L\u001a\u00020\u00112\u0006\u0010/\u001a\u00020.H\u0002J\u0012\u0010R\u001a\u00020Q2\b\u0010P\u001a\u0004\u0018\u00010OH\u0002J\u0012\u0010T\u001a\u00020S2\b\u0010P\u001a\u0004\u0018\u00010OH\u0002J\u0014\u0010V\u001a\u0004\u0018\u00010\u00112\b\u0010U\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010X\u001a\u0004\u0018\u00010\u00112\b\u0010W\u001a\u0004\u0018\u00010\u00112\b\u0010U\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0$2\b\u0010Y\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010]\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020Z2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u001a\u0010^\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020Z2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002J\"\u0010b\u001a\b\u0012\u0004\u0012\u00020a0\u000e2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020_0$2\u0006\u0010/\u001a\u00020.J\u0016\u0010d\u001a\u00020a2\u0006\u0010c\u001a\u00020_2\u0006\u0010/\u001a\u00020.J\u0016\u0010e\u001a\u00020a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.J\u0018\u0010i\u001a\u00020h2\b\u0010g\u001a\u0004\u0018\u00010f2\u0006\u0010/\u001a\u00020.J\u001a\u0010m\u001a\u0004\u0018\u00010l2\b\u0010k\u001a\u0004\u0018\u00010j2\u0006\u0010/\u001a\u00020.J\u0012\u0010o\u001a\u0004\u0018\u00010j2\b\u0010n\u001a\u0004\u0018\u00010lJ\u0012\u0010q\u001a\u0004\u0018\u0001082\b\u0010p\u001a\u0004\u0018\u00010:J\u001a\u0010s\u001a\u0004\u0018\u00010:2\b\u0010r\u001a\u0004\u0018\u0001082\u0006\u0010/\u001a\u00020.J\u0018\u0010w\u001a\u00020v2\b\u0010u\u001a\u0004\u0018\u00010t2\u0006\u0010/\u001a\u00020.J \u0010x\u001a\u00020v2\b\u0010u\u001a\u0004\u0018\u00010t2\u0006\u0010L\u001a\u00020\u00112\u0006\u0010/\u001a\u00020.J$\u0010z\u001a\b\u0012\u0004\u0012\u00020v0\u000e2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020.J\u001c\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00110$2\u0006\u0010|\u001a\u00020{2\u0006\u0010~\u001a\u00020}J\u0014\u0010\u0081\u0001\u001a\u0004\u0018\u00010t2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010vJ\u0012\u0010\u0083\u0001\u001a\u00020O2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010SJ$\u0010\u0085\u0001\u001a\u00020\u00112\u000f\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.J\u0007\u0010\u0086\u0001\u001a\u00020tJ\u0007\u0010\u0087\u0001\u001a\u00020vJ\u0010\u0010\u0089\u0001\u001a\u00020v2\u0007\u0010\u0088\u0001\u001a\u00020\u0011J\u0007\u0010\u008a\u0001\u001a\u00020.J\u0019\u0010\u008d\u0001\u001a\u00020t2\u0007\u0010\u008b\u0001\u001a\u00020\u00112\u0007\u0010\u008c\u0001\u001a\u00020\u0011J\u0011\u0010\u0090\u0001\u001a\u00020t2\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001J\u0010\u0010\u0091\u0001\u001a\u00030\u008e\u00012\u0006\u0010u\u001a\u00020tJ\u001f\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110$2\u0010\u0010\u0092\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010$J\u001c\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020t0$2\r\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020t0$J\u001c\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110$2\r\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110$J\u0012\u0010\u0099\u0001\u001a\u00020\u00112\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010aJ\u0012\u0010\u009a\u0001\u001a\u00020}2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010a\u00a8\u0006\u009d\u0001"}, d2 = {"Loj/a;", "", "Lqzone/QZoneBaseMeta$StCellBottomRecomm;", "stBottomRecomm", "Lcom/qzone/proxy/feedcomponent/model/CellBottomRecomm;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lqzone/QZoneBaseMeta$StFeed;", "stFeed", "Lcom/qzone/proxy/feedcomponent/model/CellLocalInfo;", "a", "Lqzone/QZoneBaseMeta$StFeedCellMedia;", "cellMedia", "Lcom/qzone/proxy/feedcomponent/model/CellPictureInfo;", "I", "", "Lqzone/QZoneBaseMeta$StMedia;", "mediaItems", "", "albumId", AEEditorConstants.ALBUMNAME, "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "V", "stMedia", "U", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "J", "W", "Lqzone/QZoneBaseMeta$StImage;", "stImage", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", BdhLogUtil.LogTag.Tag_Req, "", "y", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "pictureItem", "", "Lqzone/QZoneBaseMeta$StPicSpecUrlEntry;", "photoUrls", "", "o", "Lqzone/QZoneBaseMeta$StPicUrl;", "stPicUrl", "X", "Lqzone/QZoneBaseMeta$StFeedCellLike;", "pbLike", "Lqzone/QZoneBaseCommon$StCommonExt;", "commonExt", "Lcom/qzone/proxy/feedcomponent/model/CellLikeInfo;", "H", "Lqzone/QZoneBaseMeta$StLikeMan;", "stLikeMen", "Lcom/qzone/proxy/feedcomponent/model/CellLikeInfo$LikeMan;", "T", "stLikeMan", ExifInterface.LATITUDE_SOUTH, "Lqzone/QZoneBaseMeta$StReply;", "stReplies", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "Y", "feedReplies", "l", "Lqzone/QZoneBaseMeta$StFeedCellLBS;", "pbLbs", "Lcom/qzone/proxy/feedcomponent/model/CellLbsInfo;", "G", "Lqzone/QZoneBaseMeta$StFeedCellSummary;", "pbSummary", "Lcom/qzone/proxy/feedcomponent/model/CellSummary;", "K", "Lqzone/QZoneBaseMeta$StFeedCellTitle;", "pbTitle", "Lcom/qzone/proxy/feedcomponent/model/CellTitleInfo;", "L", "Lqzone/QZoneBaseMeta$StFeedCellUserInfo;", "pbUserInfo", "spaceId", "Lcom/qzone/proxy/feedcomponent/model/CellUserInfo;", "M", "Lqzone/QZoneBaseMeta$StFeedCellCommon;", "pbCommonInfo", "Lcom/qzone/proxy/feedcomponent/model/CellIdInfo;", UserInfo.SEX_FEMALE, "Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;", "D", "feedskey", "t", s4.c.UGCKEY, "v", "str", "Lqzone/QZoneBaseMeta$StRichMsg;", "d0", "stRichMsg", ReportConstant.COSTREPORT_PREFIX, "r", "Lqzone/QZIntimateSpaceReader$StClientFeed;", "pbFeedList", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "E", "pbClientFeed", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lqzone/QZoneBaseMeta$StFeedCellComment;", "pbComment", "Lcom/qzone/proxy/feedcomponent/model/CellCommentInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lqzone/QZoneBaseMeta$StComment;", "stComment", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "P", "comment", "j", "feedReply", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "stReply", "Z", "Lqzone/QZoneBaseMeta$StUser;", "stUser", "Lcom/qzone/proxy/feedcomponent/model/User;", "c0", "b0", "stUserList", "a0", "Lqzone/QZIntimateSpaceReader$GetSpaceMainPageHeadRsp;", "rsp", "", "spaceType", "u", QCircleAlphaUserReporter.KEY_USER, DomainData.DOMAIN_NAME, "feedCommonInfo", "k", "richMsgItems", "N", "d", "e", "groupId", "b", "c", "uid", "nickName", "f", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateUserBean;", "bean", "i", "g", "beanList", h.F, "users", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "uidList", "p", "feedData", "w", HippyTKDListViewAdapter.X, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f423008a = new a();

    a() {
    }

    private final ArrayList<CellLikeInfo.LikeMan> T(List<QZoneBaseMeta$StLikeMan> stLikeMen, QZoneBaseCommon$StCommonExt commonExt) {
        ArrayList<CellLikeInfo.LikeMan> arrayList = new ArrayList<>();
        Iterator<QZoneBaseMeta$StLikeMan> it = stLikeMen.iterator();
        while (it.hasNext()) {
            CellLikeInfo.LikeMan S = S(it.next(), commonExt);
            if (S != null) {
                arrayList.add(S);
            }
        }
        return arrayList;
    }

    private final PictureItem U(QZoneBaseMeta$StMedia stMedia, String albumId, String albumName) {
        String str;
        PictureItem pictureItem;
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage;
        PBStringField pBStringField;
        String str2;
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage2;
        PBStringField pBStringField2;
        if (stMedia.type.get() == 0) {
            pictureItem = Q(stMedia.image);
        } else {
            PictureItem pictureItem2 = new PictureItem();
            pictureItem2.videoflag = 1;
            pictureItem2.videodata = W(stMedia, albumId, albumName);
            QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = stMedia.video;
            String str3 = "";
            if (qZoneBaseMeta$StVideo == null || (qZoneBaseMeta$StImage2 = qZoneBaseMeta$StVideo.cover) == null || (pBStringField2 = qZoneBaseMeta$StImage2.lloc) == null || (str = pBStringField2.get()) == null) {
                str = "";
            }
            pictureItem2.lloc = str;
            QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo2 = stMedia.video;
            if (qZoneBaseMeta$StVideo2 != null && (qZoneBaseMeta$StImage = qZoneBaseMeta$StVideo2.cover) != null && (pBStringField = qZoneBaseMeta$StImage.sloc) != null && (str2 = pBStringField.get()) != null) {
                str3 = str2;
            }
            pictureItem2.sloc = str3;
            pictureItem = pictureItem2;
        }
        if (pictureItem != null) {
            pictureItem.uploadTime = stMedia.upload_time.get();
        }
        if (pictureItem != null) {
            pictureItem.desc = stMedia.desc.get();
        }
        if (pictureItem != null) {
            pictureItem.uploadUid = stMedia.uploader.get();
        }
        return pictureItem == null ? new PictureItem() : pictureItem;
    }

    private final VideoInfo W(QZoneBaseMeta$StMedia stMedia, String albumId, String albumName) {
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = stMedia.video;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.albumid = albumId;
        videoInfo.albumName = albumName;
        videoInfo.videoId = qZoneBaseMeta$StVideo.f430340id.get();
        VideoUrl videoUrl = new VideoUrl();
        videoUrl.url = qZoneBaseMeta$StVideo.url.get();
        videoInfo.videoUrl = videoUrl;
        videoInfo.width = qZoneBaseMeta$StVideo.width.get();
        videoInfo.height = qZoneBaseMeta$StVideo.height.get();
        videoInfo.videoTime = qZoneBaseMeta$StVideo.video_time.get();
        PictureUrl R = R(qZoneBaseMeta$StVideo.cover.get());
        videoInfo.coverUrl = R;
        videoInfo.currentUrl = R;
        videoInfo.lloc = qZoneBaseMeta$StVideo.cover.get().lloc.get();
        videoInfo.sloc = qZoneBaseMeta$StVideo.cover.get().sloc.get();
        videoInfo.desc = stMedia.desc.get();
        videoInfo.uploadUid = stMedia.uploader.get();
        videoInfo.videoShowType = 1;
        videoInfo.playType = (byte) 1;
        return videoInfo;
    }

    private final PictureUrl X(QZoneBaseMeta$StPicUrl stPicUrl) {
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = stPicUrl.url.get();
        pictureUrl.width = stPicUrl.width.get();
        pictureUrl.height = stPicUrl.height.get();
        return pictureUrl;
    }

    private final CellLocalInfo a(QZoneBaseMeta$StFeed stFeed) {
        CellLocalInfo cellLocalInfo = new CellLocalInfo();
        cellLocalInfo.spaceId = stFeed.cell_space_info.space_id.get();
        cellLocalInfo.canLike = true;
        return cellLocalInfo;
    }

    private final List<QZoneBaseMeta$StRichMsg> d0(String str) {
        ArrayList arrayList = new ArrayList();
        QZoneBaseMeta$StRichMsg qZoneBaseMeta$StRichMsg = new QZoneBaseMeta$StRichMsg();
        qZoneBaseMeta$StRichMsg.type.set(0);
        qZoneBaseMeta$StRichMsg.content.set(str);
        arrayList.add(qZoneBaseMeta$StRichMsg);
        return arrayList;
    }

    private final void o(PictureItem pictureItem, List<QZoneBaseMeta$StPicSpecUrlEntry> photoUrls) {
        PictureUrl pictureUrl;
        for (QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry : photoUrls) {
            int i3 = qZoneBaseMeta$StPicSpecUrlEntry.spec.get();
            if (i3 == 0) {
                a aVar = f423008a;
                QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = qZoneBaseMeta$StPicSpecUrlEntry.url.get();
                Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StPicUrl, "it.url.get()");
                pictureItem.originUrl = aVar.X(qZoneBaseMeta$StPicUrl);
            } else if (i3 == 1) {
                a aVar2 = f423008a;
                QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl2 = qZoneBaseMeta$StPicSpecUrlEntry.url.get();
                Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StPicUrl2, "it.url.get()");
                pictureItem.bigUrl = aVar2.X(qZoneBaseMeta$StPicUrl2);
            } else if (i3 == 5) {
                a aVar3 = f423008a;
                QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl3 = qZoneBaseMeta$StPicSpecUrlEntry.url.get();
                Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StPicUrl3, "it.url.get()");
                pictureItem.currentUrl = aVar3.X(qZoneBaseMeta$StPicUrl3);
            } else if (i3 == 6) {
                a aVar4 = f423008a;
                QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl4 = qZoneBaseMeta$StPicSpecUrlEntry.url.get();
                Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StPicUrl4, "it.url.get()");
                pictureItem.downloadUrl = aVar4.X(qZoneBaseMeta$StPicUrl4);
            }
        }
        PictureUrl pictureUrl2 = pictureItem.currentUrl;
        if (!TextUtils.isEmpty(pictureUrl2 != null ? pictureUrl2.url : null) || (pictureUrl = pictureItem.bigUrl) == null) {
            return;
        }
        pictureItem.currentUrl = pictureUrl;
    }

    private final String r(QZoneBaseMeta$StRichMsg stRichMsg, QZoneBaseCommon$StCommonExt commonExt) {
        return "@{uin:" + mk.h.f416877a.f(stRichMsg.uid.get(), commonExt) + ",nick:" + stRichMsg.name.get() + ",who:" + stRichMsg.who.get() + "}";
    }

    private final String s(QZoneBaseMeta$StRichMsg stRichMsg, QZoneBaseCommon$StCommonExt commonExt) {
        return "{url:" + mk.h.f416877a.b(stRichMsg.url.get(), commonExt) + ",text:" + stRichMsg.content.get() + "}";
    }

    private final String t(String feedskey) {
        if (!TextUtils.isEmpty(feedskey)) {
            return feedskey;
        }
        return UUID.randomUUID().toString();
    }

    private final String v(String ugckey, String feedskey) {
        return TextUtils.isEmpty(ugckey) ? feedskey : ugckey;
    }

    private final boolean y(QZoneBaseMeta$StFeed stFeed) {
        List<QZoneBaseMeta$StMedia> list = stFeed.cell_media.media_items.get();
        return list != null && list.size() == 1 && list.get(0).type.get() == 1;
    }

    public final BusinessFeedData A(QZIntimateSpaceReader$StClientFeed pbClientFeed, QZoneBaseCommon$StCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(pbClientFeed, "pbClientFeed");
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed = pbClientFeed.feed;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StFeed, "pbClientFeed.feed");
        return B(qZoneBaseMeta$StFeed, commonExt);
    }

    public final BusinessFeedData B(QZoneBaseMeta$StFeed stFeed, QZoneBaseCommon$StCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.setCellIdInfo(F(stFeed.cell_common));
        businessFeedData.setCellFeedCommInfo(D(stFeed.cell_common));
        QZoneBaseMeta$StFeedCellUserInfo qZoneBaseMeta$StFeedCellUserInfo = stFeed.cell_user_info;
        String str = stFeed.cell_space_info.space_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "stFeed.cell_space_info.space_id.get()");
        businessFeedData.cellUserInfo = M(qZoneBaseMeta$StFeedCellUserInfo, str, commonExt);
        businessFeedData.setCellTitleInfo(L(stFeed.cell_title));
        businessFeedData.cellSummary = K(stFeed.cell_summary);
        if (y(stFeed)) {
            businessFeedData.setVideoInfo(J(stFeed.cell_media));
        } else {
            businessFeedData.setCellPictureInfo(I(stFeed.cell_media));
        }
        businessFeedData.setCellLbsInfo(G(stFeed.cell_lbs));
        businessFeedData.setCellCommentInfo(C(stFeed.cell_comment, commonExt));
        businessFeedData.setCellLikeInfo(H(stFeed.cell_like, commonExt));
        businessFeedData.setCellLocalInfo(a(stFeed));
        businessFeedData.setCellBottomRecomm(z(stFeed.cell_bottom_recomm));
        CellIntimateSpaceInfo cellIntimateSpaceInfo = new CellIntimateSpaceInfo();
        cellIntimateSpaceInfo.spaceId = stFeed.cell_space_info.space_id.get();
        cellIntimateSpaceInfo.spaceType = stFeed.cell_space_info.space_type.get();
        businessFeedData.cellIntimateSpaceInfo = cellIntimateSpaceInfo;
        return businessFeedData;
    }

    public final CellCommentInfo C(QZoneBaseMeta$StFeedCellComment pbComment, QZoneBaseCommon$StCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        if (pbComment == null) {
            return new CellCommentInfo();
        }
        CellCommentInfo cellCommentInfo = new CellCommentInfo();
        cellCommentInfo.commentNum = pbComment.num.get();
        ArrayList<Comment> arrayList = new ArrayList<>();
        Iterator<QZoneBaseMeta$StComment> it = pbComment.comments.get().iterator();
        while (it.hasNext()) {
            Comment P = P(it.next(), commonExt);
            if (P != null) {
                arrayList.add(P);
            }
        }
        cellCommentInfo.commments = arrayList;
        return cellCommentInfo;
    }

    public final List<BusinessFeedData> E(List<QZIntimateSpaceReader$StClientFeed> pbFeedList, QZoneBaseCommon$StCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(pbFeedList, "pbFeedList");
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = pbFeedList.iterator();
        while (it.hasNext()) {
            arrayList.add(f423008a.A((QZIntimateSpaceReader$StClientFeed) it.next(), commonExt));
        }
        return arrayList;
    }

    public final String N(List<QZoneBaseMeta$StRichMsg> richMsgItems, QZoneBaseCommon$StCommonExt commonExt) {
        StringBuilder sb5 = new StringBuilder();
        if (richMsgItems != null) {
            for (QZoneBaseMeta$StRichMsg qZoneBaseMeta$StRichMsg : richMsgItems) {
                int i3 = qZoneBaseMeta$StRichMsg.type.get();
                if (i3 == 0) {
                    sb5.append(qZoneBaseMeta$StRichMsg.content.get());
                } else if (i3 == 1) {
                    sb5.append(f423008a.r(qZoneBaseMeta$StRichMsg, commonExt));
                } else if (i3 == 2) {
                    sb5.append(f423008a.s(qZoneBaseMeta$StRichMsg, commonExt));
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    public final Comment P(QZoneBaseMeta$StComment stComment, QZoneBaseCommon$StCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        if (stComment == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.commentid = stComment.f430334id.get();
        comment.user = c0(stComment.user.get(), commonExt);
        comment.comment = O(this, stComment.content.get(), null, 2, null);
        comment.time = (int) stComment.time.get();
        comment.replies = Y(stComment.replys.get(), commonExt);
        comment.replyNum = (int) stComment.reply_num.get();
        comment.clientKey = stComment.client_key.get();
        return comment;
    }

    public final Reply Z(QZoneBaseMeta$StReply stReply, QZoneBaseCommon$StCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        if (stReply == null) {
            return null;
        }
        Reply reply = new Reply();
        reply.replyId = stReply.f430338id.get();
        reply.user = c0(stReply.user.get(), commonExt);
        reply.targetUser = c0(stReply.target_user.get(), commonExt);
        reply.content = O(this, stReply.content.get(), null, 2, null);
        reply.date = (int) stReply.time.get();
        reply.clientKey = stReply.client_key.get();
        return reply;
    }

    public final List<User> a0(List<QZoneBaseMeta$StUser> stUserList, QZoneBaseCommon$StCommonExt commonExt) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        if (stUserList == null) {
            return new ArrayList();
        }
        List<QZoneBaseMeta$StUser> list = stUserList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f423008a.c0((QZoneBaseMeta$StUser) it.next(), commonExt));
        }
        return arrayList;
    }

    public final User b(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        User user = new User();
        user.uid = LoginData.getInstance().getUid();
        user.uin = LoginData.getInstance().getUin();
        user.nickName = LoginData.getInstance().getSelfTroopNickName(groupId);
        return user;
    }

    public final User b0(QZoneBaseMeta$StUser stUser, String spaceId, QZoneBaseCommon$StCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        if (stUser == null) {
            return new User();
        }
        User user = new User();
        user.nickName = stUser.nick.get();
        user.uid = stUser.uid.get();
        user.feedAvatarDecorationUrl = bk.a.f28490a.e(spaceId);
        if (!TextUtils.isEmpty(stUser.uin.get())) {
            user.uin = d.k(stUser.uin.get());
        } else {
            user.uin = mk.h.f416877a.f(stUser.uid.get(), commonExt);
        }
        return user;
    }

    public final QZoneBaseCommon$StCommonExt c() {
        String uid = LoginData.getInstance().getUid();
        long uin = LoginData.getInstance().getUin();
        QZoneBaseCommon$StUserAccountBaseMate qZoneBaseCommon$StUserAccountBaseMate = new QZoneBaseCommon$StUserAccountBaseMate();
        qZoneBaseCommon$StUserAccountBaseMate.uid.set(uid);
        qZoneBaseCommon$StUserAccountBaseMate.uin.set(uin);
        QZoneBaseCommon$StUserAccountEntry qZoneBaseCommon$StUserAccountEntry = new QZoneBaseCommon$StUserAccountEntry();
        qZoneBaseCommon$StUserAccountEntry.uid.set(uid);
        qZoneBaseCommon$StUserAccountEntry.account.set(qZoneBaseCommon$StUserAccountBaseMate);
        QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = new QZoneBaseCommon$StCommonExt();
        qZoneBaseCommon$StCommonExt.map_user_account.add(qZoneBaseCommon$StUserAccountEntry);
        return qZoneBaseCommon$StCommonExt;
    }

    public final User c0(QZoneBaseMeta$StUser stUser, QZoneBaseCommon$StCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        return b0(stUser, "", commonExt);
    }

    public final QZoneBaseMeta$StUser d() {
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = new QZoneBaseMeta$StUser();
        qZoneBaseMeta$StUser.uid.set(LoginData.getInstance().getUid());
        qZoneBaseMeta$StUser.nick.set(LoginData.getInstance().getNickName(""));
        return qZoneBaseMeta$StUser;
    }

    public final User e() {
        User user = new User();
        user.uid = LoginData.getInstance().getUid();
        user.uin = LoginData.getInstance().getUin();
        user.nickName = LoginData.getInstance().getNickName("");
        return user;
    }

    public final QZoneBaseMeta$StUser f(String uid, String nickName) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = new QZoneBaseMeta$StUser();
        qZoneBaseMeta$StUser.uid.set(uid);
        qZoneBaseMeta$StUser.nick.set(nickName);
        return qZoneBaseMeta$StUser;
    }

    public final QZoneIntimateUserBean g(QZoneBaseMeta$StUser stUser) {
        Intrinsics.checkNotNullParameter(stUser, "stUser");
        QZoneIntimateUserBean qZoneIntimateUserBean = new QZoneIntimateUserBean();
        String str = stUser.uid.get();
        Intrinsics.checkNotNullExpressionValue(str, "stUser.uid.get()");
        qZoneIntimateUserBean.setUid(str);
        String str2 = stUser.nick.get();
        Intrinsics.checkNotNullExpressionValue(str2, "stUser.nick.get()");
        qZoneIntimateUserBean.setNickname(str2);
        return qZoneIntimateUserBean;
    }

    public final List<String> h(List<QZoneIntimateUserBean> beanList) {
        ArrayList arrayList = new ArrayList();
        if (ArrayUtils.isOutOfArrayIndex(0, beanList)) {
            return arrayList;
        }
        Intrinsics.checkNotNull(beanList);
        Iterator<QZoneIntimateUserBean> it = beanList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUid());
        }
        return arrayList;
    }

    public final QZoneBaseMeta$StUser i(QZoneIntimateUserBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = new QZoneBaseMeta$StUser();
        qZoneBaseMeta$StUser.uid.set(bean.getUid());
        qZoneBaseMeta$StUser.nick.set(bean.getNickname());
        return qZoneBaseMeta$StUser;
    }

    public final List<String> p(List<String> uidList) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        ArrayList arrayList = new ArrayList();
        if (uidList.isEmpty()) {
            return arrayList;
        }
        for (String str : uidList) {
            RFWLog.i("QZoneFeedDataFactory", RFWLog.USR, "uid1 is " + str);
            if (!TextUtils.equals(str, LoginData.getInstance().getUid())) {
                RFWLog.i("QZoneFeedDataFactory", RFWLog.USR, "uid is " + str);
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<QZoneBaseMeta$StUser> q(List<QZoneBaseMeta$StUser> users) {
        Intrinsics.checkNotNullParameter(users, "users");
        ArrayList arrayList = new ArrayList();
        if (users.isEmpty()) {
            return arrayList;
        }
        for (QZoneBaseMeta$StUser qZoneBaseMeta$StUser : users) {
            if (!TextUtils.equals(qZoneBaseMeta$StUser.uid.get(), LoginData.getInstance().getUid())) {
                arrayList.add(qZoneBaseMeta$StUser);
            }
        }
        return arrayList;
    }

    public final List<String> u(QZIntimateSpaceReader$GetSpaceMainPageHeadRsp rsp, int spaceType) {
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        List<QZIntimateSpaceReader$PartnerInfo> list = rsp.partners.get();
        ArrayList arrayList = new ArrayList();
        if (!mk.d.f416875a.F(Integer.valueOf(spaceType)) && !TextUtils.isEmpty(rsp.intimay_relation_icon.get())) {
            String str = rsp.intimay_relation_icon.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.intimay_relation_icon.get()");
            arrayList.add(str);
        }
        if (list.isEmpty()) {
            return arrayList;
        }
        Iterator<QZIntimateSpaceReader$PartnerInfo> it = list.iterator();
        while (it.hasNext()) {
            QZIntimateSpaceReader$RelationIcon qZIntimateSpaceReader$RelationIcon = it.next().partner_icon;
            String str2 = (qZIntimateSpaceReader$RelationIcon == null || (pBStringField = qZIntimateSpaceReader$RelationIcon.relation_icon) == null) ? null : pBStringField.get();
            if (str2 == null) {
                str2 = "";
            }
            arrayList.add(str2);
        }
        return arrayList;
    }

    public final String w(BusinessFeedData feedData) {
        ArrayList<PictureItem> arrayList;
        if (feedData == null) {
            return "";
        }
        CellPictureInfo cellPictureInfo = feedData.cellPictureInfo;
        if (cellPictureInfo != null && (arrayList = cellPictureInfo.pics) != null) {
            Intrinsics.checkNotNullExpressionValue(arrayList, "feedData.cellPictureInfo.pics");
            if ((!arrayList.isEmpty()) && !TextUtils.isEmpty(feedData.cellPictureInfo.albumid)) {
                String str = feedData.cellPictureInfo.albumid;
                Intrinsics.checkNotNullExpressionValue(str, "feedData.cellPictureInfo.albumid");
                return str;
            }
        }
        if (feedData.getVideoInfo() == null || TextUtils.isEmpty(feedData.getVideoInfo().albumid)) {
            return "";
        }
        String str2 = feedData.getVideoInfo().albumid;
        Intrinsics.checkNotNullExpressionValue(str2, "feedData.videoInfo.albumid");
        return str2;
    }

    private final CellFeedCommInfo D(QZoneBaseMeta$StFeedCellCommon pbCommonInfo) {
        if (pbCommonInfo == null) {
            return new CellFeedCommInfo();
        }
        CellFeedCommInfo cellFeedCommInfo = new CellFeedCommInfo();
        cellFeedCommInfo.bizId = pbCommonInfo.biz_id.get();
        cellFeedCommInfo.appid = pbCommonInfo.app_id.get();
        cellFeedCommInfo.subid = pbCommonInfo.sub_id.get();
        cellFeedCommInfo.time = pbCommonInfo.time.get() * 1000;
        cellFeedCommInfo.feedsid = pbCommonInfo.feed_id.get();
        cellFeedCommInfo.curlikekey = pbCommonInfo.cur_like_key.get();
        cellFeedCommInfo.clientkey = pbCommonInfo.client_key.get();
        cellFeedCommInfo.feedskey = t(pbCommonInfo.ugckey.get());
        cellFeedCommInfo.ugckey = v(pbCommonInfo.ugckey.get(), cellFeedCommInfo.feedskey);
        return cellFeedCommInfo;
    }

    private final CellIdInfo F(QZoneBaseMeta$StFeedCellCommon pbCommonInfo) {
        if (pbCommonInfo == null) {
            return new CellIdInfo();
        }
        CellIdInfo cellIdInfo = new CellIdInfo();
        cellIdInfo.cellId = pbCommonInfo.feed_id.get();
        cellIdInfo.subId = String.valueOf(pbCommonInfo.sub_id.get());
        return cellIdInfo;
    }

    private final CellLbsInfo G(QZoneBaseMeta$StFeedCellLBS pbLbs) {
        if (pbLbs == null) {
            return new CellLbsInfo();
        }
        CellLbsInfo cellLbsInfo = new CellLbsInfo();
        QZoneBaseMeta$StLBS qZoneBaseMeta$StLBS = pbLbs.lbs.get();
        QZoneBaseMeta$StGPS qZoneBaseMeta$StGPS = qZoneBaseMeta$StLBS.gps.get();
        GpsInfo gpsInfo = new GpsInfo();
        gpsInfo.latitude = (int) qZoneBaseMeta$StGPS.lat.get();
        gpsInfo.longtitude = (int) qZoneBaseMeta$StGPS.lon.get();
        gpsInfo.altitude = (int) qZoneBaseMeta$StGPS.alt.get();
        gpsInfo.gpsType = (int) qZoneBaseMeta$StGPS.e_type.get();
        cellLbsInfo.gpsInfo = gpsInfo;
        cellLbsInfo.location = qZoneBaseMeta$StLBS.location.get();
        return cellLbsInfo;
    }

    private final CellLikeInfo H(QZoneBaseMeta$StFeedCellLike pbLike, QZoneBaseCommon$StCommonExt commonExt) {
        if (pbLike == null) {
            return new CellLikeInfo();
        }
        CellLikeInfo cellLikeInfo = new CellLikeInfo();
        cellLikeInfo.likeNum = pbLike.num.get();
        cellLikeInfo.isLiked = pbLike.liked.get();
        List<QZoneBaseMeta$StLikeMan> list = pbLike.like_mans.get();
        Intrinsics.checkNotNullExpressionValue(list, "pbLike.like_mans.get()");
        cellLikeInfo.likeMans = T(list, commonExt);
        cellLikeInfo.likeNumInfoFoldTxt = pbLike.text.get();
        return cellLikeInfo;
    }

    private final CellSummary K(QZoneBaseMeta$StFeedCellSummary pbSummary) {
        if (pbSummary == null) {
            return new CellSummary();
        }
        CellSummary cellSummary = new CellSummary();
        String O = O(this, pbSummary.summary.get(), null, 2, null);
        cellSummary.summary = O;
        cellSummary.displayStr = O;
        cellSummary.isMore = pbSummary.has_more.get() ? 1 : 0;
        return cellSummary;
    }

    private final CellTitleInfo L(QZoneBaseMeta$StFeedCellTitle pbTitle) {
        if (pbTitle == null) {
            return new CellTitleInfo();
        }
        CellTitleInfo cellTitleInfo = new CellTitleInfo();
        cellTitleInfo.title = O(this, pbTitle.title.get(), null, 2, null);
        cellTitleInfo.titleUrl = pbTitle.title_url.get();
        return cellTitleInfo;
    }

    private final CellUserInfo M(QZoneBaseMeta$StFeedCellUserInfo pbUserInfo, String spaceId, QZoneBaseCommon$StCommonExt commonExt) {
        if (pbUserInfo != null && pbUserInfo.user.get() != null) {
            CellUserInfo cellUserInfo = new CellUserInfo();
            cellUserInfo.user = b0(pbUserInfo.user.get(), spaceId, commonExt);
            return cellUserInfo;
        }
        return new CellUserInfo();
    }

    private final PictureUrl R(QZoneBaseMeta$StImage stImage) {
        QZoneBaseMeta$StPicUrl g16;
        if (stImage == null || (g16 = ij.h.g(stImage)) == null) {
            return null;
        }
        return X(g16);
    }

    private final List<Reply> Y(List<QZoneBaseMeta$StReply> stReplies, QZoneBaseCommon$StCommonExt commonExt) {
        if (stReplies == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<QZoneBaseMeta$StReply> it = stReplies.iterator();
        while (it.hasNext()) {
            Reply Z = Z(it.next(), commonExt);
            if (Z != null) {
                arrayList.add(Z);
            }
        }
        return arrayList;
    }

    private final List<QZoneBaseMeta$StReply> l(List<Reply> feedReplies) {
        if (feedReplies == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Reply> it = feedReplies.iterator();
        while (it.hasNext()) {
            QZoneBaseMeta$StReply m3 = m(it.next());
            if (m3 != null) {
                arrayList.add(m3);
            }
        }
        return arrayList;
    }

    public final QZoneBaseMeta$StFeedCellCommon k(CellFeedCommInfo feedCommonInfo) {
        if (feedCommonInfo == null) {
            return new QZoneBaseMeta$StFeedCellCommon();
        }
        QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon = new QZoneBaseMeta$StFeedCellCommon();
        qZoneBaseMeta$StFeedCellCommon.biz_id.set(2);
        qZoneBaseMeta$StFeedCellCommon.app_id.set(feedCommonInfo.appid);
        qZoneBaseMeta$StFeedCellCommon.sub_id.set(feedCommonInfo.subid);
        qZoneBaseMeta$StFeedCellCommon.time.set(feedCommonInfo.time / 1000);
        qZoneBaseMeta$StFeedCellCommon.feed_id.set(feedCommonInfo.feedsid);
        qZoneBaseMeta$StFeedCellCommon.cur_like_key.set(feedCommonInfo.curlikekey);
        qZoneBaseMeta$StFeedCellCommon.client_key.set(feedCommonInfo.clientkey);
        return qZoneBaseMeta$StFeedCellCommon;
    }

    private final CellPictureInfo I(QZoneBaseMeta$StFeedCellMedia cellMedia) {
        PBRepeatMessageField<QZoneBaseMeta$StMedia> pBRepeatMessageField;
        List<QZoneBaseMeta$StMedia> list;
        if (cellMedia == null) {
            return null;
        }
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        cellPictureInfo.albumid = cellMedia.album_id.get();
        cellPictureInfo.albumname = cellMedia.album_name.get();
        cellPictureInfo.uploadnum = cellMedia.upload_num.get();
        cellPictureInfo.batchId = cellMedia.batch_id.get();
        List<QZoneBaseMeta$StMedia> list2 = cellMedia.media_items.get();
        String str = cellMedia.album_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "cellMedia.album_id.get()");
        String str2 = cellMedia.album_name.get();
        Intrinsics.checkNotNullExpressionValue(str2, "cellMedia.album_name.get()");
        cellPictureInfo.pics = V(list2, str, str2);
        PBBoolField pBBoolField = cellMedia.long_pics_browsing_mode;
        boolean z16 = false;
        if (pBBoolField != null && pBBoolField.get()) {
            z16 = true;
        }
        if (z16 && (pBRepeatMessageField = cellMedia.media_items) != null && (list = pBRepeatMessageField.get()) != null) {
            for (QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia : list) {
                ArrayList<PictureItem> pics = cellPictureInfo.pics;
                if (pics != null) {
                    Intrinsics.checkNotNullExpressionValue(pics, "pics");
                    Iterator<T> it = pics.iterator();
                    while (it.hasNext()) {
                        ((PictureItem) it.next()).fakeLongPic = 1;
                    }
                }
            }
        }
        return cellPictureInfo;
    }

    private final VideoInfo J(QZoneBaseMeta$StFeedCellMedia cellMedia) {
        if (cellMedia == null) {
            return null;
        }
        QZoneBaseMeta$StMedia stMedia = cellMedia.media_items.get().get(0);
        Intrinsics.checkNotNullExpressionValue(stMedia, "stMedia");
        String str = cellMedia.album_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "cellMedia.album_id.get()");
        String str2 = cellMedia.album_name.get();
        Intrinsics.checkNotNullExpressionValue(str2, "cellMedia.album_name.get()");
        return W(stMedia, str, str2);
    }

    private final PictureItem Q(QZoneBaseMeta$StImage stImage) {
        if (stImage == null) {
            return null;
        }
        PictureItem pictureItem = new PictureItem();
        pictureItem.picname = stImage.name.get();
        pictureItem.sloc = stImage.sloc.get();
        pictureItem.lloc = stImage.lloc.get();
        List<QZoneBaseMeta$StPicSpecUrlEntry> list = stImage.photo_url.get();
        Intrinsics.checkNotNullExpressionValue(list, "stImage.photo_url.get()");
        o(pictureItem, list);
        return pictureItem;
    }

    private final CellLikeInfo.LikeMan S(QZoneBaseMeta$StLikeMan stLikeMan, QZoneBaseCommon$StCommonExt commonExt) {
        if (stLikeMan == null) {
            return null;
        }
        CellLikeInfo.LikeMan likeMan = new CellLikeInfo.LikeMan();
        likeMan.user = c0(stLikeMan.user.get(), commonExt);
        return likeMan;
    }

    private final ArrayList<PictureItem> V(List<QZoneBaseMeta$StMedia> mediaItems, String albumId, String albumName) {
        int collectionSizeOrDefault;
        if (mediaItems == null) {
            return null;
        }
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        List<QZoneBaseMeta$StMedia> list = mediaItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(f423008a.U((QZoneBaseMeta$StMedia) it.next(), albumId, albumName));
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private final CellBottomRecomm z(QZoneBaseMeta$StCellBottomRecomm stBottomRecomm) {
        if (stBottomRecomm == null) {
            return null;
        }
        CellBottomRecomm cellBottomRecomm = new CellBottomRecomm();
        cellBottomRecomm.title = stBottomRecomm.title.get();
        cellBottomRecomm.iconToken = stBottomRecomm.icon_token.get();
        cellBottomRecomm.actionurl = stBottomRecomm.action_url.get();
        return cellBottomRecomm;
    }

    public final QZoneBaseMeta$StComment j(Comment comment) {
        if (comment == null) {
            return null;
        }
        QZoneBaseMeta$StComment qZoneBaseMeta$StComment = new QZoneBaseMeta$StComment();
        qZoneBaseMeta$StComment.f430334id.set(comment.commentid);
        qZoneBaseMeta$StComment.user.set(n(comment.user));
        qZoneBaseMeta$StComment.time.set(comment.time);
        qZoneBaseMeta$StComment.content.set(d0(comment.comment));
        qZoneBaseMeta$StComment.replys.set(l(comment.replies));
        qZoneBaseMeta$StComment.reply_num.set(comment.replyNum);
        qZoneBaseMeta$StComment.client_key.set(comment.clientKey);
        return qZoneBaseMeta$StComment;
    }

    public final QZoneBaseMeta$StReply m(Reply feedReply) {
        if (feedReply == null) {
            return null;
        }
        QZoneBaseMeta$StReply qZoneBaseMeta$StReply = new QZoneBaseMeta$StReply();
        qZoneBaseMeta$StReply.f430338id.set(feedReply.replyId);
        qZoneBaseMeta$StReply.user.set(n(feedReply.user));
        qZoneBaseMeta$StReply.content.set(d0(feedReply.content));
        qZoneBaseMeta$StReply.time.set(feedReply.date);
        qZoneBaseMeta$StReply.client_key.set(feedReply.clientKey);
        qZoneBaseMeta$StReply.target_user.set(n(feedReply.targetUser));
        return qZoneBaseMeta$StReply;
    }

    public final QZoneBaseMeta$StUser n(User user) {
        if (user == null) {
            return null;
        }
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = new QZoneBaseMeta$StUser();
        qZoneBaseMeta$StUser.uid.set(user.uid);
        qZoneBaseMeta$StUser.nick.set(user.nickName);
        return qZoneBaseMeta$StUser;
    }

    public final int x(BusinessFeedData feedData) {
        ArrayList<PictureItem> arrayList;
        if (feedData == null) {
            return 0;
        }
        CellPictureInfo cellPictureInfo = feedData.cellPictureInfo;
        if (cellPictureInfo != null && (arrayList = cellPictureInfo.pics) != null) {
            Intrinsics.checkNotNullExpressionValue(arrayList, "feedData.cellPictureInfo.pics");
            if (!arrayList.isEmpty()) {
                return feedData.cellPictureInfo.pics.size();
            }
        }
        return (feedData.getVideoInfo() == null || feedData.getVideoInfo().videoUrl == null || TextUtils.isEmpty(feedData.getVideoInfo().videoUrl.url)) ? 0 : 1;
    }

    public static /* synthetic */ String O(a aVar, List list, QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            qZoneBaseCommon$StCommonExt = null;
        }
        return aVar.N(list, qZoneBaseCommon$StCommonExt);
    }
}
