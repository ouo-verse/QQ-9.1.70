package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\tR\u001b\u0010\u001e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/model/QFSPublicAccountStaggeredItemCommentHelper;", "", "Lfeedcloud/FeedCloudMeta$StComment;", "comment", "Lqqcircle/QQCircleFeedBase$StBusiInfoCommentListData;", "b", "", "comments", "c", "", c.G, "Lfeedcloud/FeedCloudMeta$StFeed;", "selectedFeed", "", "pgId", "", "g", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "layerBean", "Le30/b;", "feedBlockData", "f", "feed", "e", "panelSource", "Lcom/tencent/biz/qqcircle/beans/QFSCommentInfo;", "a", "Lkotlin/Lazy;", "d", "()Z", "showCommentFeatEnable", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredItemCommentHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublicAccountStaggeredItemCommentHelper f86870a = new QFSPublicAccountStaggeredItemCommentHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy showCommentFeatEnable;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.QFSPublicAccountStaggeredItemCommentHelper$showCommentFeatEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_public_account_item_show_comment_feat_enable", true));
            }
        });
        showCommentFeatEnable = lazy;
    }

    QFSPublicAccountStaggeredItemCommentHelper() {
    }

    private final QQCircleFeedBase$StBusiInfoCommentListData b(FeedCloudMeta$StComment comment) {
        if (comment == null || TextUtils.isEmpty(comment.f398447id.get())) {
            return null;
        }
        QQCircleFeedBase$StBusiInfoCommentListData qQCircleFeedBase$StBusiInfoCommentListData = new QQCircleFeedBase$StBusiInfoCommentListData();
        qQCircleFeedBase$StBusiInfoCommentListData.comment.set(comment);
        return qQCircleFeedBase$StBusiInfoCommentListData;
    }

    private final FeedCloudMeta$StComment c(List<FeedCloudMeta$StComment> comments) {
        boolean z16;
        List<FeedCloudMeta$StComment> list = comments;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        for (FeedCloudMeta$StComment feedCloudMeta$StComment : comments) {
            if (!TextUtils.isEmpty(feedCloudMeta$StComment.content.get())) {
                if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4)) {
                    break;
                }
                if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 16)) {
                    return feedCloudMeta$StComment;
                }
            }
        }
        return null;
    }

    @Nullable
    public final QFSCommentInfo a(@Nullable e30.b feedBlockData, int panelSource) {
        List<FeedCloudMeta$StComment> list;
        PBStringField pBStringField;
        PBRepeatMessageField<FeedCloudMeta$StComment> pBRepeatMessageField;
        String str = null;
        if (feedBlockData == null || feedBlockData.g() == null) {
            return null;
        }
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        FeedCloudMeta$StFeed g16 = feedBlockData.g();
        qFSCommentInfo.mFeed = g16;
        qFSCommentInfo.mFeedBlockData = feedBlockData;
        qFSCommentInfo.mCmtPanelSource = panelSource;
        QFSPublicAccountStaggeredItemCommentHelper qFSPublicAccountStaggeredItemCommentHelper = f86870a;
        if (g16 != null && (pBRepeatMessageField = g16.vecComment) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        FeedCloudMeta$StComment c16 = qFSPublicAccountStaggeredItemCommentHelper.c(list);
        QQCircleFeedBase$StBusiInfoCommentListData b16 = qFSPublicAccountStaggeredItemCommentHelper.b(c16);
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        actionBean.mIsNeedShowTopAnim = true;
        QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
        if (b16 != null) {
            qCircleActionBean.mBusiInfoCommentListDataFromCommentInfo = b16;
            if (c16 != null && (pBStringField = c16.f398447id) != null) {
                str = pBStringField.get();
            }
            qCircleActionBean.mItemTopAnimationCommentId = str;
        }
        actionBean.mCommentInitBeanActionBean = qCircleActionBean;
        qFSCommentInfo.mActionBean = actionBean;
        return qFSCommentInfo;
    }

    public final boolean d() {
        return ((Boolean) showCommentFeatEnable.getValue()).booleanValue();
    }

    public final int e(@Nullable FeedCloudMeta$StFeed feed) {
        List<FeedCloudMeta$StComment> list;
        PBStringField pBStringField;
        String str;
        boolean z16;
        PBRepeatMessageField<FeedCloudMeta$StComment> pBRepeatMessageField;
        if (feed != null && (pBRepeatMessageField = feed.vecComment) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        FeedCloudMeta$StComment c16 = c(list);
        if (c16 == null || (pBStringField = c16.content) == null || (str = pBStringField.get()) == null) {
            return 0;
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        return 1;
    }

    public final boolean f(@NotNull QCircleLayerBean layerBean, @Nullable e30.b feedBlockData) {
        boolean z16;
        String str;
        String str2;
        boolean z17;
        boolean z18;
        boolean contains$default;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(layerBean, "layerBean");
        if (!d() || feedBlockData == null || feedBlockData.g() == null) {
            return false;
        }
        QCircleInitBean.QCircleActionBean actionBean = layerBean.getActionBean();
        if (actionBean != null && actionBean.mShowCommentPanel) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        FeedCloudMeta$StFeed a16 = u40.a.a();
        if (a16 != null && (pBStringField2 = a16.f398449id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        FeedCloudMeta$StFeed g16 = feedBlockData.g();
        if (g16 != null && (pBStringField = g16.f398449id) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        if (str.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return false;
        }
        if (str3.length() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return false;
        }
        if (!Intrinsics.areEqual(str3, str)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) str, false, 2, (Object) null);
            if (!contains$default) {
                QLog.d("QFSPublicAccountStaggeredItemCommentHelper", 4, "needAutoOpenCommentPanel, Not same feed id.");
                return false;
            }
        }
        QLog.d("QFSPublicAccountStaggeredItemCommentHelper", 4, "needAutoOpenCommentPanel, curFeedId:" + str3);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g(int pos, @NotNull FeedCloudMeta$StFeed selectedFeed, @Nullable String pgId) {
        String str;
        boolean z16;
        String str2;
        boolean z17;
        PBRepeatMessageField<FeedCloudMeta$StComment> pBRepeatMessageField;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(selectedFeed, "selectedFeed");
        if (!d()) {
            return false;
        }
        if (!TextUtils.equals(pgId, "pg_xsj_gzh_page")) {
            QLog.d("QFSPublicAccountStaggeredItemCommentHelper", 4, "showReplayCommentBannerImmediately, Not gzh page.");
            return false;
        }
        if (pos != 0) {
            QLog.d("QFSPublicAccountStaggeredItemCommentHelper", 4, "checkShowReplayBannerImmediately, Not first feed.");
            return false;
        }
        FeedCloudMeta$StFeed a16 = u40.a.a();
        List<FeedCloudMeta$StComment> list = null;
        if (a16 != null && (pBStringField = a16.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, selectedFeed.f398449id.get())) {
            QLog.d("QFSPublicAccountStaggeredItemCommentHelper", 4, "showReplayCommentBannerImmediately, Not same feed id.");
            return false;
        }
        if (a16 != null && (pBRepeatMessageField = a16.vecComment) != null) {
            list = pBRepeatMessageField.get();
        }
        FeedCloudMeta$StComment c16 = c(list);
        if (c16 != null) {
            PBStringField pBStringField2 = c16.content;
            if (pBStringField2 != null && (str2 = pBStringField2.get()) != null) {
                if (str2.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (!z16) {
                        return true;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        QLog.d("QFSPublicAccountStaggeredItemCommentHelper", 4, "showReplayCommentBannerImmediately, cache feed no replay comment.");
        return false;
    }
}
