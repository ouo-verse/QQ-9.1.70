package ho;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProMoodListFragment;
import com.qzone.reborn.feedpro.fragment.QzoneFriendFeedProFragment;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellOrigin;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lho/n;", "Lho/a;", "Landroid/content/Context;", "context", "", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "b", "Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "initBean", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class n implements a {
    public final void c(Context context, QZoneMoodListInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (context == null) {
            return;
        }
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QzoneFeedProMoodListFragment.class.getName()).withLong("key_uin", initBean.getUin()).withString("key_nickname", initBean.getNickName()).withString("refer", initBean.getRefer()).withParcelable("qzone_route_bean", initBean).request();
        jo.h.f410717a.h("page_launch_mood_list").t("LAUNCH_CLICK");
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        i.d(context, "/qzone/friend_feed_pro").withString("public_fragment_class", QzoneFriendFeedProFragment.class.getName()).request();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (r7 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Context context, CommonFeed feedData) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        String str;
        CommonCellCommon cellCommon;
        String str2;
        CommonUser user;
        boolean z16;
        String str3;
        boolean z17;
        boolean startsWith$default;
        boolean startsWith$default2;
        if (context == null || feedData == null) {
            return;
        }
        boolean z18 = true;
        QLog.d("QzoneFeedProNativeLauncher", 1, "[launchLikeListH5] jump to like list h5 page");
        String url = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_LIKELIST_PAGE, QzoneConfig.DefaultValue.DEFAULT_LIKELIST_PAGE_URL);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "{unikey}", false, 2, (Object) null);
        if (contains$default) {
            CommonCellCommon cellCommon2 = feedData.getCellCommon();
            String curLikeKey = cellCommon2 != null ? cellCommon2.getCurLikeKey() : null;
            if (curLikeKey != null) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(curLikeKey, "http://", false, 2, null);
                if (startsWith$default2) {
                    z16 = true;
                    if (!z16) {
                        if (curLikeKey != null) {
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(curLikeKey, "https://", false, 2, null);
                            if (startsWith$default) {
                                z17 = true;
                            }
                        }
                        z17 = false;
                    }
                    curLikeKey = URLEncoder.encode(curLikeKey);
                    str3 = curLikeKey;
                    if (str3 != null && str3.length() != 0) {
                        z18 = false;
                    }
                    if (!z18) {
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        url = StringsKt__StringsJVMKt.replace$default(url, "{unikey}", str3, false, 4, (Object) null);
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            curLikeKey = URLEncoder.encode(curLikeKey);
            str3 = curLikeKey;
            if (str3 != null) {
                z18 = false;
            }
            if (!z18) {
            }
        }
        String url2 = url;
        Intrinsics.checkNotNullExpressionValue(url2, "url");
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url2, (CharSequence) "{uin}", false, 2, (Object) null);
        if (contains$default2) {
            Intrinsics.checkNotNullExpressionValue(url2, "url");
            url2 = StringsKt__StringsJVMKt.replace$default(url2, "{uin}", String.valueOf(LoginData.getInstance().getUin()), false, 4, (Object) null);
        }
        String url3 = url2;
        Intrinsics.checkNotNullExpressionValue(url3, "url");
        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) url3, (CharSequence) "{hostuin}", false, 2, (Object) null);
        if (contains$default3) {
            CommonCellUserInfo cellUserInfo = feedData.getCellUserInfo();
            if (cellUserInfo == null || (user = cellUserInfo.getUser()) == null || (str2 = user.getUin()) == null) {
                str2 = "0";
            }
            Intrinsics.checkNotNullExpressionValue(url3, "url");
            url3 = StringsKt__StringsJVMKt.replace$default(url3, "{hostuin}", str2, false, 4, (Object) null);
        }
        String url4 = url3;
        Intrinsics.checkNotNullExpressionValue(url4, "url");
        contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) url4, (CharSequence) "{appid}", false, 2, (Object) null);
        if (contains$default4) {
            CommonCellOrigin cellOrigin = feedData.getCellOrigin();
            if (cellOrigin == null || (cellCommon = cellOrigin.getCellCommon()) == null || (str = Integer.valueOf(cellCommon.getAppId()).toString()) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(url4, "url");
            url4 = StringsKt__StringsJVMKt.replace$default(url4, "{appid}", str, false, 4, (Object) null);
        }
        yo.d.c(url4, context);
    }
}
