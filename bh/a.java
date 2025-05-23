package bh;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.bean.QZoneDragonListBadgeInfo;
import com.qzone.reborn.feedx.bean.QZoneDragonThreeLayerBadgeInfo;
import com.qzone.reborn.feedx.bean.QZoneDragonUserInfo;
import com.qzone.reborn.util.i;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0006R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010\"\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010#\u00a8\u0006'"}, d2 = {"Lbh/a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "ownerAnimLevel", "", "o", "containerWidth", "Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "e", "a", "c", "dragonWidth", "i", "level", "d", DomainData.DOMAIN_NAME, "isPraise", "l", "k", "j", "b", "", "g", h.F, "f", "I", "mMasterDragonLevel", UserInfo.SEX_FEMALE, "mMaxLevelRate", "mMinLevelRate", "Ljava/lang/Integer;", "mBadgeDefaultWidth", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28389a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mMasterDragonLevel = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static float mMaxLevelRate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static float mMinLevelRate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Integer mBadgeDefaultWidth;

    a() {
    }

    private final int a(int containerWidth, QZoneDragonUserInfo userInfo) {
        FeedResourceInfo bottom;
        QZoneDragonThreeLayerBadgeInfo threeLayerBadge = userInfo.getThreeLayerBadge();
        return i(containerWidth, (threeLayerBadge == null || (bottom = threeLayerBadge.getBottom()) == null) ? 0 : bottom.getResWidthFromUrl());
    }

    private final int c(int containerWidth, QZoneDragonUserInfo userInfo) {
        FeedResourceInfo fusionBadge = userInfo.getFusionBadge();
        return i(containerWidth, fusionBadge != null ? fusionBadge.getResWidthFromUrl() : 0);
    }

    private final int d(int containerWidth, int level) {
        int L0 = g.f53821a.b().L0();
        int i3 = level > L0 ? L0 : level;
        if (i3 < 1) {
            i3 = 1;
        }
        float g16 = ((((i3 * 1.0f) - 1) / (L0 - 1)) * (g() - h())) + h();
        RFWLog.d("QZoneFeedDragonManager", RFWLog.DEV, "calculateDragonWidth, rate: " + g16 + ", level: " + level);
        return (int) (containerWidth * g16);
    }

    private final int e(int containerWidth, QZoneDragonUserInfo userInfo) {
        List<FeedResourceInfo> list;
        QZoneDragonListBadgeInfo listBadge = userInfo.getListBadge();
        int i3 = 0;
        if (listBadge != null && (list = listBadge.getList()) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                i3 += ((FeedResourceInfo) it.next()).getResWidthFromUrl();
            }
        }
        return i(containerWidth, i3);
    }

    private final boolean m(BusinessFeedData feedData) {
        return i.b().d("GUEST_DRAGON_ANIM_" + ef.b.a(feedData), true);
    }

    private final void o(int ownerAnimLevel) {
        mMasterDragonLevel = ownerAnimLevel;
        i.b().o("KEY_MASTER_DRAGON_LEVEL", ownerAnimLevel);
    }

    public final int b(int containerWidth, QZoneDragonUserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        int badgeType = userInfo.getBadgeType();
        if (badgeType == QZoneDragonUserInfo.BadgeType.BADGE_TYPE_LIST.getType()) {
            return e(containerWidth, userInfo);
        }
        if (badgeType == QZoneDragonUserInfo.BadgeType.BADGE_TYPE_THREE_LAYER.getType()) {
            return a(containerWidth, userInfo);
        }
        if (badgeType == QZoneDragonUserInfo.BadgeType.BADGE_TYPE_FUSION.getType()) {
            return c(containerWidth, userInfo);
        }
        return d(containerWidth, userInfo.getGrade());
    }

    public final int f() {
        if (mBadgeDefaultWidth == null) {
            mBadgeDefaultWidth = Integer.valueOf(ViewUtils.f352270a.a(g.f53821a.b().D0()));
        }
        Integer num = mBadgeDefaultWidth;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final float g() {
        if (mMaxLevelRate == 0.0f) {
            mMaxLevelRate = g.f53821a.b().H0();
        }
        return mMaxLevelRate;
    }

    public final float h() {
        if (mMinLevelRate == 0.0f) {
            mMinLevelRate = g.f53821a.b().I0();
        }
        return mMinLevelRate;
    }

    public final int j() {
        if (mMasterDragonLevel < 0) {
            mMasterDragonLevel = i.b().g("KEY_MASTER_DRAGON_LEVEL", 0);
        }
        return mMasterDragonLevel;
    }

    public final void k(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        i.b().l("GUEST_DRAGON_ANIM_" + ef.b.a(feedData), false);
    }

    private final int i(int containerWidth, int dragonWidth) {
        if (dragonWidth == 0) {
            return f();
        }
        int g16 = (int) (containerWidth * g());
        return dragonWidth < g16 ? dragonWidth : g16;
    }

    public final boolean l(BusinessFeedData feedData, boolean isPraise) {
        if (feedData != null && !ef.b.h(feedData)) {
            CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
            if ((cellFeedCommInfo != null ? cellFeedCommInfo.extendInfo : null) != null) {
                try {
                    String str = cellFeedCommInfo.extendInfo.get("shimmerAnimation");
                    if (str != null && new JSONObject(str).optBoolean("guest_anim_enable", false)) {
                        if (isPraise) {
                            return f28389a.m(feedData);
                        }
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public final boolean n(BusinessFeedData feedData) {
        if (feedData != null && ef.b.h(feedData)) {
            CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
            if ((cellFeedCommInfo != null ? cellFeedCommInfo.extendInfo : null) != null) {
                try {
                    String str = cellFeedCommInfo.extendInfo.get("shimmerAnimation");
                    if (str != null) {
                        int optInt = new JSONObject(str).optInt("owner_anim_level", 0);
                        a aVar = f28389a;
                        if (optInt > aVar.j()) {
                            aVar.o(optInt);
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }
}
