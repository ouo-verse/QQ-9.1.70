package com.qzone.feed.utils;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/qzone/feed/utils/f;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0007J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0017R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0017R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0017\u00a8\u0006*"}, d2 = {"Lcom/qzone/feed/utils/f$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feed", "", "srvPara", "i", tl.h.F, "srvParaInput", "c", "e", "appId", "f", "b", "Lcom/tencent/mobileqq/dt/api/b;", "g", "Landroid/content/Context;", "context", "data", "", "a", "d", "COMMENT_IS_NOT_JU_BAO_SRV_PARA", "Ljava/lang/String;", "COMMENT_REPLY_SRV_PARA", "COMMON_SRV_PARA", "FEEDS_BLOG_INFORM_APP_ID", "FEEDS_GROUP_ALBUM_APP_ID", "FEEDS_MESSAGE_INFORM_APP_ID", "FEEDS_PHOTO_INFORM_APP_ID", "FEEDS_SHAI_SHAI_INFORM_APP_ID", "FEEDS_SHARE_INFORM_APP_ID", "FEEDS_SHUO_SHUO_INFORM_APP_ID", "FEEDS_VIDEO_STORY_INFORM_APP_ID", "GROUP_ALBUM_CONTENT_FEED_PARA", "GROUP_ALBUM_CONTENT_LAYER_PARA", "LAYER_INFORM_APP_ID", "PHOTO_GROUP_ALBUM_APP_ID", "SHUO_SHUO_COMMENT_REPLY_APP_ID", "USER_INFORM_APP_ID", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.feed.utils.f$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(BusinessFeedData feed, String srvParaInput) {
            String replace$default;
            String L = QZoneFeedUtil.L(feed.getIdInfo().cellId);
            Intrinsics.checkNotNullExpressionValue(L, "getTextForUrl(feed.idInfo.cellId)");
            replace$default = StringsKt__StringsJVMKt.replace$default(srvParaInput, "{cid}", L, false, 4, (Object) null);
            return replace$default;
        }

        private final String c(String srvParaInput, BusinessFeedData feed) {
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

        private final String h(BusinessFeedData feed) {
            String replace$default;
            String str = "|batchid:{batchid}|qunid:{qunid}|feedid:{feedid}";
            if (feed.getFeedCommInfo().feedsid != null) {
                String str2 = feed.getFeedCommInfo().feedsid;
                Intrinsics.checkNotNull(str2);
                str = StringsKt__StringsJVMKt.replace$default("|batchid:{batchid}|qunid:{qunid}|feedid:{feedid}", "{feedid}", str2, false, 4, (Object) null);
            }
            String str3 = str;
            if (feed.getPictureInfo() != null) {
                CellPictureInfo pictureInfo = feed.getPictureInfo();
                Intrinsics.checkNotNull(pictureInfo);
                str3 = StringsKt__StringsJVMKt.replace$default(str3, "{batchid}", String.valueOf(pictureInfo.batchId), false, 4, (Object) null);
            }
            String str4 = str3;
            CellGroupAlbumInfo cellGroupAlbumInfo = feed.cellGroupAlbumInfo;
            if (cellGroupAlbumInfo == null || cellGroupAlbumInfo.groupId == null) {
                return str4;
            }
            Intrinsics.checkNotNull(cellGroupAlbumInfo);
            String str5 = cellGroupAlbumInfo.groupId;
            Intrinsics.checkNotNull(str5);
            replace$default = StringsKt__StringsJVMKt.replace$default(str4, "{qunid}", str5, false, 4, (Object) null);
            return replace$default;
        }

        private final String i(BusinessFeedData feed, String srvPara) {
            String replace$default;
            if (feed.getPictureInfo() != null) {
                String L = QZoneFeedUtil.L(feed.getPictureInfo().albumid);
                Intrinsics.checkNotNullExpressionValue(L, "getTextForUrl(feed.pictureInfo.albumid)");
                replace$default = StringsKt__StringsJVMKt.replace$default(srvPara, "{pid}", L, false, 4, (Object) null);
                StringBuilder sb5 = new StringBuilder("");
                ArrayList<PictureItem> pics = feed.getPictureInfo().pics;
                if (pics != null) {
                    Intrinsics.checkNotNullExpressionValue(pics, "pics");
                    sb5.append("{");
                    Iterator<PictureItem> it = feed.getPictureInfo().pics.iterator();
                    while (it.hasNext()) {
                        PictureItem next = it.next();
                        if (!TextUtils.isEmpty(next.sloc)) {
                            sb5.append(next.sloc);
                            sb5.append(",");
                        } else {
                            sb5.append(next.lloc);
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

        @JvmStatic
        public final void a(Context context, com.tencent.mobileqq.dt.api.b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (context != null) {
                ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, data);
            }
        }

        @JvmStatic
        public final void d(com.tencent.mobileqq.dt.api.b data, BusinessFeedData feed) {
            String str;
            String replace$default;
            String f16;
            Intrinsics.checkNotNullParameter(data, "data");
            if (feed == null) {
                return;
            }
            CellUserInfo cellUserInfo = feed.cellUserInfo;
            if (cellUserInfo != null && cellUserInfo.getUser() != null) {
                str = String.valueOf(feed.cellUserInfo.getUser().uin);
                data.n(str);
            } else {
                str = "";
            }
            replace$default = StringsKt__StringsJVMKt.replace$default("pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}", "{own_uin}", str, false, 4, (Object) null);
            int i3 = feed.getFeedCommInfo().appid;
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 202) {
                        if (i3 == 311) {
                            data.i("10190");
                            f16 = f(c(replace$default, feed), "311");
                        } else if (i3 == 334) {
                            data.i("10194");
                            f16 = f(c(replace$default, feed), "334");
                        } else if (i3 == 406) {
                            data.i("10196");
                            f16 = f(c(replace$default, feed), PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE);
                        } else if (i3 != 6100 && i3 != 2020014) {
                            if (i3 == 422) {
                                data.i("100661");
                                String i16 = i(feed, replace$default);
                                data.m(i16 + h(feed));
                                CellGroupAlbumInfo cellGroupAlbumInfo = feed.cellGroupAlbumInfo;
                                data.r(cellGroupAlbumInfo != null ? cellGroupAlbumInfo.groupId : null);
                                f16 = i16;
                            } else if (i3 != 423) {
                                data.i("10061");
                                f16 = f(c(replace$default, feed), String.valueOf(feed.getFeedCommInfo().appid));
                            }
                        }
                    }
                    data.i("10193");
                    f16 = f(c(replace$default, feed), ThemeReporter.FROM_NIGHT);
                }
                data.i("10072");
                f16 = i(feed, replace$default);
            } else {
                data.i("10192");
                f16 = f(c(replace$default, feed), "2");
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
    }

    @JvmStatic
    public static final void a(Context context, com.tencent.mobileqq.dt.api.b bVar) {
        INSTANCE.a(context, bVar);
    }

    @JvmStatic
    public static final void b(com.tencent.mobileqq.dt.api.b bVar, BusinessFeedData businessFeedData) {
        INSTANCE.d(bVar, businessFeedData);
    }

    @JvmStatic
    public static final com.tencent.mobileqq.dt.api.b c() {
        return INSTANCE.g();
    }
}
