package oi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxAnimUtils;
import com.qzone.reborn.feedx.util.m;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumEditTextInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumMainPageInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumMyAlbumInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumNoticeInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupChatHistoryMediaSelectInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumAlbumDetailFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumEditAlbumFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumEditTextFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumFeedDetailFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumMainFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumMyAlbumFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumNoticeFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumSelectCoverFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumTaskDetailFragment;
import com.qzone.reborn.groupalbum.fragment.GroupUploadAlbumFragment;
import com.qzone.reborn.groupalbum.fragment.GroupUploadSelectAlbumFragment;
import com.qzone.reborn.groupalbum.reship.bean.GroupAIOReshipInitBean;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipInitBean;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipSelectInitBean;
import com.qzone.reborn.groupalbum.reship.fragment.GroupAIOReshipAlbumFragment;
import com.qzone.reborn.groupalbum.reship.fragment.GroupAlbumReshipFragment;
import com.qzone.reborn.groupalbum.reship.fragment.GroupAlbumReshipSelectFragment;
import com.qzone.reborn.groupalbum.selectmedia.ChatHistorySelectMediaFragment;
import com.qzone.reborn.groupalbum.upload.selectalbum.GroupUploadSelectAlbumInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.state.report.SquareReportConst;
import ho.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b2\u00103J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bJ6\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019J\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\bJ\u001e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u001dJ\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001fJ\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020!J\u0016\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020#J\u0016\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020%J\u001e\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020'J\u001e\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020)J\u0016\u0010,\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020+J\u0016\u0010.\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020-J\u001a\u0010/\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001e\u00101\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u000200\u00a8\u00064"}, d2 = {"Loi/c;", "Lho/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;", "initBean", "", "i", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", h.F, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "from", "", "lLoc", "Landroid/view/View;", "clickView", "e", "Lvh/b;", Const.BUNDLE_KEY_REQUEST, "p", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "editAlbumInitBean", "d", "a", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumEditTextInitBean;", "c", "Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean;", DomainData.DOMAIN_NAME, "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", "g", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "l", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumTaskDetailInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/groupalbum/upload/selectalbum/GroupUploadSelectAlbumInitBean;", "r", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipSelectInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumNoticeInitBean;", "k", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMyAlbumInitBean;", "j", "o", "Lcom/qzone/reborn/groupalbum/bean/init/GroupChatHistoryMediaSelectInitBean;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c implements ho.a {
    public final void a(Activity r95, int requestCode, GroupAlbumAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(r95, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(r95, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumSelectCoverFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean), r95, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void b(Activity r102, int requestCode, GroupChatHistoryMediaSelectInitBean initBean) {
        Intrinsics.checkNotNullParameter(r102, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(r102, "/qzone/holder_page").withString("public_fragment_class", ChatHistorySelectMediaFragment.class.getName()), r102, requestCode, (Bundle) null, 4, (Object) null).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void c(Activity r95, int requestCode, GroupAlbumEditTextInitBean initBean) {
        Intrinsics.checkNotNullParameter(r95, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(r95, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumEditTextFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean), r95, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void d(Activity r102, int requestCode, CommonAlbumEditInitBean editAlbumInitBean) {
        Intrinsics.checkNotNullParameter(r102, "activity");
        Intrinsics.checkNotNullParameter(editAlbumInitBean, "editAlbumInitBean");
        Navigator.withRequestCode$default(i.d(r102, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumEditAlbumFragment.class.getName()), r102, requestCode, (Bundle) null, 4, (Object) null).withParcelable("key_bundle_common_init_bean", editAlbumInitBean).request();
    }

    public final void e(Context context, BusinessFeedData feedData, int from, String lLoc, View clickView) {
        String valueOf;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (feedData.getVideoInfo() != null && !TextUtils.isEmpty(feedData.getVideoInfo().albumid)) {
            valueOf = String.valueOf(feedData.getVideoInfo().batchId);
            str = feedData.getVideoInfo().albumid;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.videoInfo.albumid");
        } else {
            valueOf = String.valueOf(feedData.cellPictureInfo.batchId);
            str = feedData.cellPictureInfo.albumid;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.cellPictureInfo.albumid");
        }
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.equals("0", valueOf)) {
            lLoc = null;
        }
        m.b("extra_key_parcelable_feed_for_detail", feedData);
        QZoneFeedxAnimUtils qZoneFeedxAnimUtils = QZoneFeedxAnimUtils.f55700a;
        QZoneBaseFeedItemView b16 = qZoneFeedxAnimUtils.b(clickView);
        AnimationParams c16 = b16 != null ? qZoneFeedxAnimUtils.c(b16) : null;
        Navigator withString = i.d(context, qZoneFeedxAnimUtils.a(context, c16)).withBoolean("fromark", false).withString("feed_id", feedData.getFeedCommInfo().feedsid).withString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, feedData.cellGroupAlbumInfo.groupId).withString("albumid", str).withString(s4.c.BATCHID, valueOf);
        if (lLoc == null) {
            lLoc = "";
        }
        withString.withString("llocid", lLoc).withInt("fromEntry", from).withString("public_fragment_class", GroupAlbumFeedDetailFragment.class.getName()).withParcelable("feed_detail_animation_params", c16 instanceof Parcelable ? c16 : null).request();
    }

    public final void g(Context context, GroupAIOReshipInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/common_upload_page").withString("public_fragment_class", GroupAIOReshipAlbumFragment.class.getName()).withParcelable("key_bundle_common_init_bean", initBean).request();
    }

    public final void h(Context context, GroupAlbumAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        z8.c.f452134a.g(initBean.getGroupId());
        zh.b.l().q(initBean.getGroupId(), null);
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumAlbumDetailFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void i(Context context, GroupAlbumMainPageInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        z8.c.f452134a.g(initBean.getGroupId());
        zh.b.l().q(initBean.getGroupId(), null);
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumMainFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void j(Context context, GroupAlbumMyAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumMyAlbumFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void k(Context context, GroupAlbumNoticeInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumNoticeFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void l(Context context, GroupAlbumReshipInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/common_upload_page").withString("public_fragment_class", GroupAlbumReshipFragment.class.getName()).withParcelable("key_bundle_common_init_bean", initBean).request();
    }

    public final void m(Context context, GroupAlbumTaskDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumTaskDetailFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void n(Context context, GroupUploadAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/common_upload_page").withString("public_fragment_class", GroupUploadAlbumFragment.class.getName()).withParcelable("key_bundle_common_init_bean", initBean).request();
    }

    public final void p(Context context, vh.b r46) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(r46, "request");
        i.d(context, "/qzone/holder_page").withBoolean("fromark", r46.getFromArk()).withString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, r46.getGroupId()).withString("albumid", r46.getAlbumId()).withString(s4.c.BATCHID, r46.getBatchId()).withString("llocid", r46.getLlocId()).withString("public_fragment_class", GroupAlbumFeedDetailFragment.class.getName()).request();
    }

    public final void q(Activity activity, int i3, GroupAlbumReshipSelectInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", GroupAlbumReshipSelectFragment.class.getName()), activity, i3, (Bundle) null, 4, (Object) null).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void r(Activity r102, int requestCode, GroupUploadSelectAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(r102, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(r102, "/qzone/holder_page").withString("public_fragment_class", GroupUploadSelectAlbumFragment.class.getName()), r102, requestCode, (Bundle) null, 4, (Object) null).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void o(Context context, BusinessFeedData feedData) {
        Map mutableMapOf;
        User user;
        CellFeedCommInfo cellFeedCommInfo;
        String str = null;
        String str2 = (feedData == null || (cellFeedCommInfo = feedData.cellFeedCommInfo) == null) ? null : cellFeedCommInfo.curlikekey;
        if (context != null && feedData != null && feedData.cellFeedCommInfo != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(IQzoneMsgApi.LIKE_KEY, str2));
            CellGroupAlbumInfo cellGroupAlbumInfo = feedData.cellGroupAlbumInfo;
            if (cellGroupAlbumInfo != null) {
                mutableMapOf.put(v4.a.QUNID, cellGroupAlbumInfo.groupId);
            }
            CellUserInfo cellUserInfo = feedData.cellUserInfo;
            if (cellUserInfo != null && (user = cellUserInfo.user) != null) {
                str = user.uid;
            }
            if (str == null) {
                str = "";
            }
            mutableMapOf.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str);
            i.r(context, g.f53821a.g().n(), mutableMapOf);
            return;
        }
        RFWLog.e("GroupAlbumNativeLauncher", RFWLog.USR, "launchLikeListH5 error, context: " + context + ", likeKey: + " + str2);
    }

    public static /* synthetic */ void f(c cVar, Context context, BusinessFeedData businessFeedData, int i3, String str, View view, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            view = null;
        }
        cVar.e(context, businessFeedData, i3, str, view);
    }
}
