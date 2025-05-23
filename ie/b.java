package ie;

import android.content.Context;
import android.widget.ImageView;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerRouteBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLike;
import ho.i;
import java.util.ArrayList;
import kotlin.Metadata;
import xd.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J6\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lie/b;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeedInfo", "Landroid/content/Context;", "context", "", "a", "forwardFeed", "Landroid/widget/ImageView;", "clickView", "", "index", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f407555a = new b();

    b() {
    }

    private final void a(CommonFeed commonFeedInfo, Context context) {
        CommonFeed copyFeed;
        String str;
        CommonUser user;
        CommonUnionID unionId;
        if (commonFeedInfo == null || (copyFeed = CommonFeedKt.copyFeed(commonFeedInfo)) == null) {
            return;
        }
        ArrayList<CommonMedia> H = je.a.H(copyFeed);
        QzoneFeedProLayerRouteBean qzoneFeedProLayerRouteBean = new QzoneFeedProLayerRouteBean();
        qzoneFeedProLayerRouteBean.o(je.a.p(H));
        qzoneFeedProLayerRouteBean.y(je.a.n(qzoneFeedProLayerRouteBean, H));
        qzoneFeedProLayerRouteBean.x(String.valueOf(context != null ? context.hashCode() : 0));
        CommonCellCommon cellCommon = copyFeed.getCellCommon();
        if (cellCommon == null || (str = cellCommon.getCurLikeKey()) == null) {
            str = "";
        }
        qzoneFeedProLayerRouteBean.C(str);
        qzoneFeedProLayerRouteBean.m(0);
        com.qzone.reborn.feedpro.utils.b bVar = com.qzone.reborn.feedpro.utils.b.f54315a;
        bVar.b("key_common_feed", String.valueOf(context != null ? context.hashCode() : 0), copyFeed);
        CommonCellCommon cellCommon2 = copyFeed.getCellCommon();
        if (cellCommon2 != null && (unionId = cellCommon2.getUnionId()) != null) {
            bVar.b("key_common_union_id", String.valueOf(context != null ? context.hashCode() : 0), unionId);
        }
        CommonCellUserInfo cellUserInfo = copyFeed.getCellUserInfo();
        if (cellUserInfo != null && (user = cellUserInfo.getUser()) != null) {
            bVar.b("key_common_user", String.valueOf(context != null ? context.hashCode() : 0), user);
        }
        i.i().c(context, qzoneFeedProLayerRouteBean, copyFeed);
    }

    public final void b(CommonFeed commonFeedInfo, CommonFeed forwardFeed, Context context, ImageView clickView, int index) {
        CommonFeed copyFeed;
        String str;
        String str2;
        String str3;
        CommonCellCommon cellCommon;
        String curLikeKey;
        CommonUser user;
        CommonUnionID unionId;
        CommonFeed copyFeed2;
        CommonCellCommon cellCommon2;
        CommonUser user2;
        if (commonFeedInfo == null || (copyFeed = CommonFeedKt.copyFeed(commonFeedInfo)) == null) {
            return;
        }
        if (c.t(copyFeed)) {
            a(copyFeed, context);
            return;
        }
        ArrayList<CommonMedia> H = je.a.H(copyFeed);
        QzoneFeedProLayerRouteBean qzoneFeedProLayerRouteBean = new QzoneFeedProLayerRouteBean();
        CommonCellUserInfo cellUserInfo = copyFeed.getCellUserInfo();
        String str4 = "";
        if (cellUserInfo == null || (user2 = cellUserInfo.getUser()) == null || (str = user2.getUin()) == null) {
            str = "";
        }
        qzoneFeedProLayerRouteBean.D(str);
        qzoneFeedProLayerRouteBean.w(CommonFeedExtKt.isAlbumFeed(copyFeed));
        CommonCellLike cellLike = copyFeed.getCellLike();
        qzoneFeedProLayerRouteBean.B(cellLike != null ? cellLike.liked : false);
        CommonCellLike cellLike2 = copyFeed.getCellLike();
        qzoneFeedProLayerRouteBean.A(cellLike2 != null ? cellLike2.num : 0);
        CommonCellComment cellComment = copyFeed.getCellComment();
        qzoneFeedProLayerRouteBean.z(cellComment != null ? cellComment.getNum() : 0);
        CommonCellMedia cellMedia = copyFeed.getCellMedia();
        if (cellMedia == null || (str2 = cellMedia.getAlbumId()) == null) {
            str2 = "";
        }
        qzoneFeedProLayerRouteBean.j(str2);
        CommonCellMedia cellMedia2 = copyFeed.getCellMedia();
        if (cellMedia2 == null || (str3 = cellMedia2.getAlbumName()) == null) {
            str3 = "";
        }
        qzoneFeedProLayerRouteBean.k(str3);
        qzoneFeedProLayerRouteBean.o(je.a.p(H));
        qzoneFeedProLayerRouteBean.y(je.a.n(qzoneFeedProLayerRouteBean, H));
        qzoneFeedProLayerRouteBean.x(String.valueOf(context != null ? context.hashCode() : 0));
        if (forwardFeed == null ? !((cellCommon = copyFeed.getCellCommon()) == null || (curLikeKey = cellCommon.getCurLikeKey()) == null) : !((cellCommon2 = forwardFeed.getCellCommon()) == null || (curLikeKey = cellCommon2.getCurLikeKey()) == null)) {
            str4 = curLikeKey;
        }
        qzoneFeedProLayerRouteBean.C(str4);
        qzoneFeedProLayerRouteBean.l(clickView);
        qzoneFeedProLayerRouteBean.m(index);
        com.qzone.reborn.feedpro.utils.b bVar = com.qzone.reborn.feedpro.utils.b.f54315a;
        bVar.b("key_common_feed", String.valueOf(context != null ? context.hashCode() : 0), copyFeed);
        if (forwardFeed != null && (copyFeed2 = CommonFeedKt.copyFeed(forwardFeed)) != null) {
            bVar.b("key_common_forward_feed", String.valueOf(context != null ? context.hashCode() : 0), copyFeed2);
        }
        CommonCellCommon cellCommon3 = copyFeed.getCellCommon();
        if (cellCommon3 != null && (unionId = cellCommon3.getUnionId()) != null) {
            bVar.b("key_common_union_id", String.valueOf(context != null ? context.hashCode() : 0), unionId);
        }
        CommonCellUserInfo cellUserInfo2 = copyFeed.getCellUserInfo();
        if (cellUserInfo2 != null && (user = cellUserInfo2.getUser()) != null) {
            bVar.b("key_common_user", String.valueOf(context != null ? context.hashCode() : 0), user);
        }
        if (CommonFeedExtKt.isAlbumFeed(copyFeed)) {
            i.i().a(context, qzoneFeedProLayerRouteBean, copyFeed);
        } else {
            i.i().b(context, qzoneFeedProLayerRouteBean, copyFeed);
        }
    }
}
