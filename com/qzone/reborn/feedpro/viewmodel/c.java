package com.qzone.reborn.feedpro.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011R4\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00160\u00150\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/c;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/qzone/reborn/feedpro/part/a;", "lifecycleCallback", "", "Q1", "T1", "R1", "", "M1", "L1", "Lcom/qzone/reborn/feedpro/viewmodel/b;", "state", "S1", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "action", "", "index", "P1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "setFeedsData", "(Landroidx/lifecycle/MutableLiveData;)V", "feedsData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "O1", "setLoadingState", "loadingState", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "lifecycleCallbacks", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class c extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<UIStateData<List<CommonFeed>>> feedsData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<b> loadingState = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private List<com.qzone.reborn.feedpro.part.a> lifecycleCallbacks = new ArrayList();

    public final void L1() {
        Iterator<T> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            ((com.qzone.reborn.feedpro.part.a) it.next()).c9();
        }
    }

    public final String M1() {
        return String.valueOf(this.contextHashCode);
    }

    public final MutableLiveData<UIStateData<List<CommonFeed>>> N1() {
        return this.feedsData;
    }

    public final MutableLiveData<b> O1() {
        return this.loadingState;
    }

    public final void P1(CommonFeed commonFeed, String action, int index) {
        Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
        Intrinsics.checkNotNullParameter(action, "action");
        switch (action.hashCode()) {
            case -1660473388:
                if (!action.equals(QzoneDataUpdateAction.UPDATE_REPLY)) {
                    return;
                }
                ze.a.a().initOrUpdateGlobalState((ze.a) new zd.a(M1(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellComment()), true);
                return;
            case -1642851002:
                if (!action.equals(QzoneDataUpdateAction.LIKE_FEED)) {
                    return;
                }
                break;
            case -1480275146:
                if (!action.equals(QzoneDataUpdateAction.DELETE_REPLY)) {
                    return;
                }
                ze.a.a().initOrUpdateGlobalState((ze.a) new zd.a(M1(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellComment()), true);
                return;
            case -1054359637:
                if (!action.equals(QzoneDataUpdateAction.DELETE_COMMENT)) {
                    return;
                }
                ze.a.a().initOrUpdateGlobalState((ze.a) new zd.a(M1(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellComment()), true);
                return;
            case -250063476:
                if (!action.equals(QzoneDataUpdateAction.ADD_REPLY)) {
                    return;
                }
                ze.a.a().initOrUpdateGlobalState((ze.a) new zd.a(M1(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellComment()), true);
                return;
            case 63048833:
                if (!action.equals(QzoneDataUpdateAction.ADD_COMMENT)) {
                    return;
                }
                ze.a.a().initOrUpdateGlobalState((ze.a) new zd.a(M1(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellComment()), true);
                return;
            case 1227244148:
                if (action.equals(QzoneDataUpdateAction.MODIFY_PERMISSION)) {
                    ze.a.a().initOrUpdateGlobalState((ze.a) new zd.d(CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellPermission()), true);
                    return;
                }
                return;
            case 1868788937:
                if (!action.equals(QzoneDataUpdateAction.UPDATE_COMMENT)) {
                    return;
                }
                ze.a.a().initOrUpdateGlobalState((ze.a) new zd.a(M1(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellComment()), true);
                return;
            case 2067715832:
                if (action.equals(QzoneDataUpdateAction.FORWARD_FEED)) {
                    ze.a.a().initOrUpdateGlobalState((ze.a) new zd.b(M1(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellForwardInfo(), Boolean.TRUE), true);
                    return;
                }
                return;
            case 2086921933:
                if (!action.equals(QzoneDataUpdateAction.UNLIKE_FEED)) {
                    return;
                }
                break;
            default:
                return;
        }
        ze.a.a().initOrUpdateGlobalState((ze.a) new zd.c(M1(), CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed.getCellLike()), true);
    }

    public final void Q1(com.qzone.reborn.feedpro.part.a lifecycleCallback) {
        Intrinsics.checkNotNullParameter(lifecycleCallback, "lifecycleCallback");
        this.lifecycleCallbacks.add(lifecycleCallback);
    }

    public final void S1(b state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.loadingState.postValue(state);
    }

    public final void T1(com.qzone.reborn.feedpro.part.a lifecycleCallback) {
        Intrinsics.checkNotNullParameter(lifecycleCallback, "lifecycleCallback");
        this.lifecycleCallbacks.remove(lifecycleCallback);
    }

    public void R1() {
    }
}
