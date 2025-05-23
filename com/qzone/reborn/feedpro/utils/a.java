package com.qzone.reborn.feedpro.utils;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/a;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0007J\u001a\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016R\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0016R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0016R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0016\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/a$a;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feed", "", "srvPara", tl.h.F, "srvParaInput", "c", "e", "appId", "f", "b", "Lcom/tencent/mobileqq/dt/api/b;", "g", "Landroid/content/Context;", "context", "data", "", "a", "d", "COMMENT_IS_NOT_JU_BAO_SRV_PARA", "Ljava/lang/String;", "COMMENT_REPLY_SRV_PARA", "COMMON_SRV_PARA", "FEEDS_BLOG_INFORM_APP_ID", "FEEDS_GROUP_ALBUM_APP_ID", "FEEDS_MESSAGE_INFORM_APP_ID", "FEEDS_PHOTO_INFORM_APP_ID", "FEEDS_SHAI_SHAI_INFORM_APP_ID", "FEEDS_SHARE_INFORM_APP_ID", "FEEDS_SHUO_SHUO_INFORM_APP_ID", "FEEDS_VIDEO_STORY_INFORM_APP_ID", "GROUP_ALBUM_CONTENT_FEED_PARA", "GROUP_ALBUM_CONTENT_LAYER_PARA", "LAYER_INFORM_APP_ID", "PHOTO_GROUP_ALBUM_APP_ID", "SHUO_SHUO_COMMENT_REPLY_APP_ID", "USER_INFORM_APP_ID", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(CommonFeed feed, String srvParaInput) {
            String str;
            String replace$default;
            CommonCellCommon cellCommon;
            if (feed == null || (cellCommon = feed.getCellCommon()) == null || (str = cellCommon.getCellId()) == null) {
                str = "0";
            }
            String L = QZoneFeedUtil.L(str);
            Intrinsics.checkNotNullExpressionValue(L, "getTextForUrl(feed?.cellCommon?.cellId?: \"0\")");
            replace$default = StringsKt__StringsJVMKt.replace$default(srvParaInput, "{cid}", L, false, 4, (Object) null);
            return replace$default;
        }

        private final String c(String srvParaInput, CommonFeed feed) {
            return b(feed, e(srvParaInput));
        }

        private final String e(String srvParaInput) {
            String replace$default;
            replace$default = StringsKt__StringsJVMKt.replace$default(srvParaInput, "{pid}", "0", false, 4, (Object) null);
            return replace$default;
        }

        private final String f(String srvParaInput, String appId) {
            String replace$default;
            replace$default = StringsKt__StringsJVMKt.replace$default(srvParaInput, "{qzone_appid}", appId, false, 4, (Object) null);
            return replace$default;
        }

        @JvmStatic
        public final void a(Context context, com.tencent.mobileqq.dt.api.b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (context != null) {
                ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, data);
            }
        }

        @JvmStatic
        public final void d(com.tencent.mobileqq.dt.api.b data, CommonFeed feed) {
            String str;
            String replace$default;
            String f16;
            String num;
            CommonUser user;
            Intrinsics.checkNotNullParameter(data, "data");
            if (feed == null) {
                return;
            }
            CommonCellUserInfo cellUserInfo = feed.getCellUserInfo();
            String str2 = "";
            if (cellUserInfo == null || (user = cellUserInfo.getUser()) == null || user.getUin() == null) {
                str = "";
            } else {
                CommonCellUserInfo cellUserInfo2 = feed.getCellUserInfo();
                Intrinsics.checkNotNull(cellUserInfo2);
                CommonUser user2 = cellUserInfo2.getUser();
                Intrinsics.checkNotNull(user2);
                String valueOf = String.valueOf(user2.getUin());
                data.n(valueOf);
                str = valueOf;
            }
            replace$default = StringsKt__StringsJVMKt.replace$default("pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}", "{own_uin}", str, false, 4, (Object) null);
            CommonCellCommon cellCommon = feed.getCellCommon();
            Integer valueOf2 = cellCommon != null ? Integer.valueOf(cellCommon.getAppId()) : null;
            if (valueOf2 != null && valueOf2.intValue() == 311) {
                data.i("10190");
                f16 = f(c(replace$default, feed), "311");
            } else if (valueOf2 != null && valueOf2.intValue() == 2) {
                data.i("10192");
                f16 = f(c(replace$default, feed), "2");
            } else {
                boolean z16 = false;
                if (((valueOf2 != null && valueOf2.intValue() == 202) || (valueOf2 != null && valueOf2.intValue() == 6100)) || (valueOf2 != null && valueOf2.intValue() == 2020014)) {
                    data.i("10193");
                    f16 = f(c(replace$default, feed), ThemeReporter.FROM_NIGHT);
                } else if (valueOf2 != null && valueOf2.intValue() == 334) {
                    data.i("10194");
                    f16 = f(c(replace$default, feed), "334");
                } else {
                    if ((valueOf2 != null && valueOf2.intValue() == 4) || (valueOf2 != null && valueOf2.intValue() == 423)) {
                        z16 = true;
                    }
                    if (z16) {
                        data.i("10072");
                        f16 = h(feed, replace$default);
                    } else if (valueOf2 != null && valueOf2.intValue() == 406) {
                        data.i("10196");
                        f16 = f(c(replace$default, feed), PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE);
                    } else {
                        data.i("10061");
                        String c16 = c(replace$default, feed);
                        CommonCellCommon cellCommon2 = feed.getCellCommon();
                        if (cellCommon2 != null && (num = Integer.valueOf(cellCommon2.getAppId()).toString()) != null) {
                            str2 = num;
                        }
                        f16 = f(c16, str2);
                    }
                }
            }
            data.v(f16);
        }

        @JvmStatic
        public final com.tencent.mobileqq.dt.api.b g() {
            com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
            bVar.o(2);
            bVar.j("0");
            bVar.s(0);
            return bVar;
        }

        Companion() {
        }

        private final String h(CommonFeed feed, String srvPara) {
            String replace$default;
            if (feed != null && feed.getCellMedia() != null) {
                CommonCellMedia cellMedia = feed.getCellMedia();
                Intrinsics.checkNotNull(cellMedia);
                String L = QZoneFeedUtil.L(cellMedia.getAlbumId());
                Intrinsics.checkNotNullExpressionValue(L, "getTextForUrl(feed.cellMedia!!.albumId)");
                replace$default = StringsKt__StringsJVMKt.replace$default(srvPara, "{pid}", L, false, 4, (Object) null);
                StringBuilder sb5 = new StringBuilder("");
                CommonCellMedia cellMedia2 = feed.getCellMedia();
                Intrinsics.checkNotNull(cellMedia2);
                List<CommonMedia> mediaItems = cellMedia2.getMediaItems();
                if (mediaItems != null) {
                    sb5.append("{");
                    for (CommonMedia commonMedia : mediaItems) {
                        CommonImage image = commonMedia.getImage();
                        if (!TextUtils.isEmpty(image != null ? image.getSloc() : null)) {
                            CommonImage image2 = commonMedia.getImage();
                            sb5.append(image2 != null ? image2.getSloc() : null);
                            sb5.append(",");
                        } else {
                            CommonImage image3 = commonMedia.getImage();
                            sb5.append(image3 != null ? image3.getLloc() : null);
                            sb5.append(",");
                        }
                    }
                    sb5.deleteCharAt(sb5.length() - 1);
                    sb5.append("}");
                }
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "cidBuilder.toString()");
                srvPara = StringsKt__StringsJVMKt.replace$default(replace$default, "{cid}", sb6, false, 4, (Object) null);
            }
            return f(srvPara, "4");
        }
    }
}
