package fh;

import android.text.TextUtils;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.state.report.SquareReportConst;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import gf.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016JD\u0010\u0010\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016JD\u0010\u0012\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lfh/b;", "Lgf/e;", "", "y3", "Landroid/view/View;", "view", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "", "w5", "elementId", "reuseIdentifier", "k5", "", "", "params", "f9", "dynamicParam", Constants.EMULATOR_INFO, "d", "Ljava/lang/String;", "getDtPageId", "()Ljava/lang/String;", "dtPageId", "<init>", "(Ljava/lang/String;)V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String dtPageId;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J \u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lfh/b$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "", "f", "feedData", "", "", "e", "c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "b", "a", "", "d", "VAL_IS_ATOMIZE_PUBLISH", "I", "VAL_NOT_ATOMIZE_PUBLISH", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fh.b$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, Object> a(BusinessFeedData businessFeedData) {
            int i3;
            int i16;
            VideoInfo videoInfo;
            CellUserInfo cellUserInfo;
            User user;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String l3 = (businessFeedData == null || (cellUserInfo = businessFeedData.cellUserInfo) == null || (user = cellUserInfo.user) == null) ? null : Long.valueOf(user.uin).toString();
            if (l3 != null) {
                linkedHashMap.put("framer_uin", l3);
            }
            String a16 = businessFeedData != null ? ef.b.a(businessFeedData) : null;
            if (a16 != null) {
                linkedHashMap.put("feedid", a16);
            }
            String str = (businessFeedData == null || (videoInfo = businessFeedData.getVideoInfo()) == null) ? null : videoInfo.videoId;
            if (str != null) {
                linkedHashMap.put("video_id", str);
            }
            FeedPictureInfo[] feedPictureInfoArr = businessFeedData != null ? businessFeedData.pics : null;
            if (feedPictureInfoArr != null) {
                ArrayList arrayList = new ArrayList();
                int length = feedPictureInfoArr.length;
                for (int i17 = 0; i17 < length; i17++) {
                    FeedPictureInfo feedPictureInfo = feedPictureInfoArr[i17];
                    if (feedPictureInfo != null && feedPictureInfo.l()) {
                        arrayList.add(feedPictureInfo);
                    }
                }
                i16 = arrayList.size();
                i3 = feedPictureInfoArr.length - i16;
            } else {
                i3 = 0;
                i16 = 0;
            }
            if (i3 == 0 && i16 == 0 && !TextUtils.isEmpty(str)) {
                i16 = 1;
            }
            linkedHashMap.put("video_number", Integer.valueOf(i16));
            linkedHashMap.put("pic_cnt", Integer.valueOf(i3));
            if (Intrinsics.areEqual(businessFeedData != null ? Boolean.valueOf(businessFeedData.isQQVideoFeeds()) : null, Boolean.TRUE)) {
                linkedHashMap.put("qq_is_atomize_publish", 1);
            } else {
                linkedHashMap.put("qq_is_atomize_publish", 0);
            }
            if (businessFeedData != null) {
                linkedHashMap.put("sourcetype", Integer.valueOf(b.INSTANCE.d(businessFeedData)));
            }
            return linkedHashMap;
        }

        public final Map<String, Object> b(CommonFeed feedData) {
            Object obj;
            Object bizId;
            CommonUser user;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (feedData == null) {
                return linkedHashMap;
            }
            if (xd.c.u(feedData)) {
                linkedHashMap.put("open_visit_state", "0");
            } else {
                linkedHashMap.put("open_visit_state", "1");
            }
            CommonCellUserInfo cellUserInfo = feedData.getCellUserInfo();
            if (cellUserInfo != null && (user = cellUserInfo.getUser()) != null) {
                linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, user.getUid());
                linkedHashMap.put("touin", user.getUin());
                linkedHashMap.put("framer_uin", user.getUin());
            }
            linkedHashMap.put("qq_is_atomize_publish", 0);
            linkedHashMap.put("sourcetype", 0);
            linkedHashMap.put("feedid", CommonFeedExtKt.getFeedUniqueKey(feedData));
            CommonCellCommon cellCommon = feedData.getCellCommon();
            Object obj2 = "";
            if (cellCommon == null) {
                obj = "";
            } else {
                obj = Integer.valueOf(cellCommon.getAppId());
            }
            linkedHashMap.put("appid", obj);
            CommonCellCommon cellCommon2 = feedData.getCellCommon();
            if (cellCommon2 != null && (bizId = cellCommon2.getBizId()) != null) {
                obj2 = bizId;
            }
            linkedHashMap.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, obj2);
            return linkedHashMap;
        }

        @JvmStatic
        public final Map<String, Object> c(BusinessFeedData feedData) {
            Object obj;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (feedData == null) {
                return linkedHashMap;
            }
            CellIntimateSpaceInfo cellIntimateSpaceInfo = feedData.cellIntimateSpaceInfo;
            if (cellIntimateSpaceInfo != null) {
                linkedHashMap.put("close_friend_space_id", cellIntimateSpaceInfo.spaceId);
                linkedHashMap.put("close_friend_space_type", Integer.valueOf(cellIntimateSpaceInfo.spaceType));
            } else {
                linkedHashMap.put("close_friend_space_id", "-1");
                linkedHashMap.put("close_friend_space_type", "-1");
            }
            if (ef.b.h(feedData)) {
                linkedHashMap.put("open_visit_state", "0");
            } else {
                linkedHashMap.put("open_visit_state", "1");
            }
            CellUserInfo cellUserInfo = feedData.cellUserInfo;
            if ((cellUserInfo != null ? cellUserInfo.getUser() : null) != null) {
                User user = feedData.cellUserInfo.getUser();
                linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, user.uid);
                linkedHashMap.put("touin", Long.valueOf(user.uin));
                linkedHashMap.put("framer_uin", Long.valueOf(user.uin));
            }
            if (feedData.isQQVideoFeeds()) {
                linkedHashMap.put("qq_is_atomize_publish", 1);
            } else {
                linkedHashMap.put("qq_is_atomize_publish", 0);
            }
            linkedHashMap.put("sourcetype", Integer.valueOf(d(feedData)));
            String a16 = ef.b.a(feedData);
            Object obj2 = "";
            if (a16 == null) {
                a16 = "";
            }
            linkedHashMap.put("feedid", a16);
            CellFeedCommInfo feedCommInfo = feedData.getFeedCommInfo();
            if (feedCommInfo == null) {
                obj = "";
            } else {
                obj = Integer.valueOf(feedCommInfo.appid);
            }
            linkedHashMap.put("appid", obj);
            CellFeedCommInfo feedCommInfo2 = feedData.getFeedCommInfo();
            if (feedCommInfo2 != null) {
                obj2 = Integer.valueOf(feedCommInfo2.bizId);
            }
            linkedHashMap.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, obj2);
            return linkedHashMap;
        }

        public final int d(BusinessFeedData businessFeedData) {
            Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
            return businessFeedData.isQCircleShareCardFeed() ? 1 : 0;
        }

        @JvmStatic
        public final Map<String, Object> e(BusinessFeedData feedData) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (ef.b.h(feedData)) {
                linkedHashMap.put("open_visit_state", 0);
                linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, LoginData.getInstance().getUid());
            } else {
                linkedHashMap.put("open_visit_state", 1);
                linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, "");
            }
            if ((feedData != null ? feedData.getUser() : null) != null) {
                linkedHashMap.put("touin", Long.valueOf(feedData.getUser().uin));
                linkedHashMap.put("is_authentication_space", 0);
                linkedHashMap.put("authentication_account", Long.valueOf(feedData.getUser().uin));
            }
            return linkedHashMap;
        }

        Companion() {
        }

        public final boolean f(BusinessFeedData businessFeedData) {
            if (businessFeedData == null) {
                return false;
            }
            return businessFeedData.isShuoShuoSingleVideoExcludeForward();
        }
    }

    public b(String dtPageId) {
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        this.dtPageId = dtPageId;
    }

    @JvmStatic
    public static final Map<String, Object> b(BusinessFeedData businessFeedData) {
        return INSTANCE.c(businessFeedData);
    }

    @Override // gf.e
    public void G3(View view, String elementId, String reuseIdentifier, BusinessFeedData businessFeedData, final Map<String, ? extends Object> dynamicParam) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (view == null) {
            return;
        }
        fo.b bVar = new fo.b();
        bVar.h(new IDynamicParams() { // from class: fh.a
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map c16;
                c16 = b.c(dynamicParam, str);
                return c16;
            }
        });
        bVar.i(reuseIdentifier);
        fo.c.o(view, elementId, bVar);
    }

    @Override // gf.e
    public void f9(View view, String elementId, String reuseIdentifier, Map<String, ? extends Object> params, BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (view != null && INSTANCE.f(businessFeedData)) {
            fo.b bVar = new fo.b();
            bVar.l(params);
            bVar.i(reuseIdentifier);
            fo.c.o(view, elementId, bVar);
        }
    }

    @Override // gf.e
    public void k5(View view, String elementId, String reuseIdentifier, BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (view != null && INSTANCE.f(businessFeedData)) {
            fo.b bVar = new fo.b();
            bVar.i(reuseIdentifier);
            fo.c.o(view, elementId, bVar);
        }
    }

    @Override // gf.e
    /* renamed from: y3, reason: from getter */
    public String getDtPageId() {
        return this.dtPageId;
    }

    @Override // gf.e
    public void w5(View view, BusinessFeedData businessFeedData) {
        if (view == null) {
            return;
        }
        Companion companion = INSTANCE;
        if (companion.f(businessFeedData)) {
            Map<String, Object> a16 = companion.a(businessFeedData);
            fo.b bVar = new fo.b();
            bVar.l(a16);
            bVar.i(ef.b.a(businessFeedData));
            fo.c.o(view, "em_qz_feed", bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map c(Map map, String str) {
        return map;
    }
}
