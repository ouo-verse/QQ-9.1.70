package ho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProBlogDetailFragment;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProDetailFragment;
import com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView;
import com.qzone.reborn.feedpro.utils.QzoneFeedProAnimUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\"\u0010#J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J2\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J.\u0010\u0015\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\r\u001a\u00020\fJ.\u0010\u0016\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\r\u001a\u00020\fJ\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ0\u0010\u0019\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\r\u001a\u00020\fJ6\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\f\u00a8\u0006$"}, d2 = {"Lho/m;", "Lho/a;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "g", "a", "Landroid/app/Activity;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "from", "clickPos", "", "checkUgcKey", "d", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "view", "e", tl.h.F, "f", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", CommonConstant.KEY_UNION_ID, "clickView", "i", "", ZPlanPublishSource.FROM_SCHEME, "appId", "j", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class m implements a {
    @Deprecated(message = "\u5df2\u5e9f\u5f03, \u8001Feeds\u4e0b\u7ebf\u540e\u79fb\u9664")
    public final void d(Activity context, BusinessFeedData feedData, int from, int clickPos, boolean checkUgcKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (feedData == null) {
                QLog.e("QzoneFeedProDetailNativeLauncher", 1, "launchFeedDetailFullFunctionLegacy feedData is null");
                return;
            }
            int i3 = feedData.getFeedCommInfo().actiontype;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        yo.d.d(feedData.getFeedCommInfo().actionurl, context, null);
                        return;
                    }
                    if (i3 == 7) {
                        i.g().d(context, feedData.getFeedCommInfo().actionurl);
                        return;
                    }
                    if (i3 == 11) {
                        i.g().c(context, feedData, from);
                        return;
                    }
                    if (i3 == 22) {
                        if (feedData.getOperationInfo() == null || TextUtils.isEmpty(feedData.getOperationInfo().actionUrl)) {
                            return;
                        }
                        i.g().d(context, feedData.getOperationInfo().actionUrl);
                        return;
                    }
                    if (i3 != 50) {
                        if (i3 != 51) {
                            switch (i3) {
                                case 27:
                                case 28:
                                case 29:
                                    break;
                                default:
                                    return;
                            }
                        }
                    }
                }
                if (feedData.getOriginalInfoSafe() != null && feedData.getOriginalInfoSafe().getUser() != null) {
                    if (feedData.isBrandUgcAdvFeeds() && from == 1) {
                        com.qzone.misc.network.report.f.o(feedData);
                    }
                    h(context, feedData, null, from);
                    return;
                }
                return;
            }
            if (feedData.isBrandUgcAdvFeeds() && from == 11) {
                if (checkUgcKey) {
                    com.qzone.misc.network.report.f.p(feedData);
                } else {
                    com.qzone.misc.network.report.f.b(feedData, 1, clickPos);
                }
            }
            e(context, feedData, null, from);
        } catch (Exception e16) {
            QLog.e("QzoneFeedProDetailNativeLauncher", 1, "launchFeedDetailFullFunctionLegacy error:" + e16);
        }
    }

    public final void e(Activity activity, BusinessFeedData feedData, View view, int from) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (feedData.getFeedCommInfo().appid == 333) {
            if (feedData.getGiftInfo() == null) {
                QZLog.e("launchFeedDetailLegacy", "feedData.getGiftInfo() is null");
                return;
            } else {
                f(activity, feedData);
                return;
            }
        }
        b(activity, xd.e.q(xd.e.f447788a, feedData, null, 2, null), view, from);
    }

    public final void h(Activity activity, BusinessFeedData feedData, View view, int from) {
        BusinessFeedData businessFeedData;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (feedData.getFeedCommInfo().appid == 333) {
            if (feedData.getGiftInfo() == null) {
                QZLog.e("launchOriginFeedDetailLegacy", "feedData.getGiftInfo() is null");
                return;
            } else {
                f(activity, feedData);
                return;
            }
        }
        if (feedData.getOriginalInfo() != null) {
            businessFeedData = feedData.getOriginalInfo();
            Intrinsics.checkNotNullExpressionValue(businessFeedData, "feedData.originalInfo");
        } else {
            businessFeedData = feedData;
        }
        b(activity, xd.e.f447788a.p(businessFeedData, feedData), view, from);
    }

    public final void i(Activity context, CommonFeed feedData, CommonUnionID unionId, View clickView, int from) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("QzoneFeedProDetailNativeLauncher", 1, "launchQZoneFeedDetail");
        if (CommonFeedExtKt.isFakeFeed(feedData)) {
            QLog.e("JumpDetailUtil", 1, "fake feed cannot jump detail in feedx");
            return;
        }
        String valueOf = String.valueOf(context.hashCode());
        if (feedData != null) {
            com.qzone.reborn.feedpro.utils.b.f54315a.b("key_common_feed", valueOf, feedData);
        }
        if (unionId != null) {
            com.qzone.reborn.feedpro.utils.b.f54315a.b("key_common_union_id", valueOf, unionId);
        }
        Intent intent = new Intent();
        intent.putExtra("context_hash_code", valueOf);
        QzoneFeedProAnimUtils qzoneFeedProAnimUtils = QzoneFeedProAnimUtils.f54254a;
        QzoneBaseFeedProItemView b16 = qzoneFeedProAnimUtils.b(clickView);
        if (b16 != null) {
            AnimationParams c16 = qzoneFeedProAnimUtils.c(b16);
            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type android.os.Parcelable");
            intent.putExtra("feed_detail_animation_params", (Parcelable) c16);
        }
        if (!CommonFeedExtKt.isBlogFeed(feedData) && !CommonFeedExtKt.isHandBlogFeed(feedData)) {
            g(context, intent.getExtras());
        } else {
            a(context, intent.getExtras());
        }
    }

    public final void j(Context context, String scheme, int appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        String valueOf = String.valueOf(context.hashCode());
        Intent intent = new Intent();
        intent.putExtra("context_hash_code", valueOf);
        intent.putExtra(ChatsRevealApiImpl.KEY_JUMP_SCHEME, scheme);
        if (appId == 2) {
            a(context, intent.getExtras());
        } else {
            g(context, intent.getExtras());
        }
    }

    public final void b(Activity activity, CommonFeed feedData, View view, int from) {
        if (feedData != null && activity != null) {
            if (CommonFeedExtKt.isFakeFeed(feedData)) {
                QLog.e("QzoneFeedProDetailNativeLauncher", 1, "fake feed isn't allowed jumping to feed detail page");
                return;
            } else {
                CommonCellCommon cellCommon = feedData.getCellCommon();
                i(activity, feedData, cellCommon != null ? cellCommon.getUnionId() : null, view, from);
                return;
            }
        }
        QLog.e("QzoneFeedProDetailNativeLauncher", 1, "launchFeedDetail error, " + feedData + ", context: " + activity);
    }

    private final void a(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            return;
        }
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QzoneFeedProBlogDetailFragment.class.getName()).withAll(bundle).request();
        jo.h.f410717a.h("page_launch_feed_detail").t("LAUNCH_CLICK");
    }

    private final void g(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            return;
        }
        i.d(context, QzoneFeedProAnimUtils.f54254a.a(context, (AnimationParams) bundle.getParcelable("feed_detail_animation_params"))).withString("public_fragment_class", QzoneFeedProDetailFragment.class.getName()).withAll(bundle).request();
        jo.h.f410717a.h("page_launch_feed_detail").t("LAUNCH_CLICK");
    }

    public final void f(Activity activity, BusinessFeedData feedData) {
        if (activity == null || feedData == null) {
            return;
        }
        i.q(activity, yo.f.j(yo.f.w(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_GIFTDETAILPAGE, "https://h5.qzone.qq.com/gift/detail?_wv=2097155&uin={uin}&ugcid={ugcid}"), LoginData.getInstance().getUin()), "{ugcid}", feedData.getGiftInfo().giftBackId));
    }

    public static /* synthetic */ void c(m mVar, Activity activity, CommonFeed commonFeed, View view, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            view = null;
        }
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        mVar.b(activity, commonFeed, view, i3);
    }
}
