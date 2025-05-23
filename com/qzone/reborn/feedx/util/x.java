package com.qzone.reborn.feedx.util;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.reborn.feedx.presenter.QZoneFeedBottomGuideBarContentPresenter;
import com.qzone.reborn.feedx.presenter.QZoneFeedCommentPresenter;
import com.qzone.reborn.feedx.presenter.aq;
import com.qzone.reborn.feedx.presenter.ar;
import com.qzone.reborn.feedx.presenter.au;
import com.qzone.reborn.feedx.presenter.bl;
import com.qzone.reborn.groupalbum.section.feed.GroupAlbumFeedMorePicPresenter;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedx/util/x;", "", "", "pageType", "", "f", "", "Ljava/lang/Class;", "Lvg/a;", "a", "c", "e", "d", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", tl.h.F, "i", "b", "g", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f55790a = new x();

    x() {
    }

    @JvmStatic
    public static final boolean f(int pageType) {
        if (pageType == 1 || pageType == 3 || pageType == 5 || pageType == 4 || pageType == 12) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00c3, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Class<? extends vg.a>> a(int pageType) {
        ArrayList arrayList = new ArrayList();
        switch (pageType) {
            case 1:
                arrayList.add(QZoneFeedCommentPresenter.class);
                arrayList.add(com.qzone.reborn.feedx.presenter.n.class);
                arrayList.add(QZoneFeedBottomGuideBarContentPresenter.class);
                arrayList.add(au.class);
                arrayList.add(bh.c.class);
                arrayList.add(ah.c.class);
                arrayList.add(zg.c.class);
                break;
            case 2:
                arrayList.add(au.class);
                arrayList.add(bh.c.class);
                arrayList.add(ah.c.class);
                break;
            case 3:
            case 12:
                arrayList.add(aq.class);
                arrayList.add(com.qzone.reborn.feedx.presenter.p.class);
                arrayList.add(QZoneFeedCommentPresenter.class);
                arrayList.add(com.qzone.reborn.feedx.presenter.n.class);
                arrayList.add(bl.class);
                arrayList.add(au.class);
                arrayList.add(bh.c.class);
                arrayList.add(ah.c.class);
                arrayList.add(zg.c.class);
                break;
            case 4:
                arrayList.add(QZoneFeedCommentPresenter.class);
                arrayList.add(com.qzone.reborn.feedx.presenter.n.class);
                arrayList.add(au.class);
                arrayList.add(bh.c.class);
                arrayList.add(ah.c.class);
                break;
            case 5:
                arrayList.add(QZoneFeedCommentPresenter.class);
                arrayList.add(com.qzone.reborn.feedx.presenter.n.class);
                arrayList.add(QZoneFeedBottomGuideBarContentPresenter.class);
                arrayList.add(au.class);
                arrayList.add(ar.class);
                arrayList.add(bh.c.class);
                arrayList.add(ah.c.class);
                arrayList.add(zg.c.class);
                break;
            case 6:
                arrayList.add(QZoneFeedCommentPresenter.class);
                arrayList.add(tg.a.class);
                arrayList.add(tg.g.class);
                break;
            case 7:
                arrayList.add(tg.g.class);
                break;
            case 8:
                break;
            case 9:
                arrayList.add(QZoneFeedCommentPresenter.class);
                arrayList.add(com.qzone.reborn.groupalbum.section.feed.a.class);
                arrayList.add(com.qzone.reborn.groupalbum.section.feed.l.class);
                arrayList.add(com.qzone.reborn.groupalbum.section.feed.o.class);
                break;
            case 10:
                arrayList.add(com.qzone.reborn.groupalbum.section.feed.l.class);
                arrayList.add(com.qzone.reborn.groupalbum.section.feed.e.class);
                arrayList.add(GroupAlbumFeedMorePicPresenter.class);
                break;
            case 11:
            default:
                arrayList.add(QZoneFeedCommentPresenter.class);
                arrayList.add(com.qzone.reborn.feedx.presenter.n.class);
                arrayList.add(au.class);
                break;
        }
    }

    public final boolean c(int pageType) {
        if (pageType != 2 && pageType != 7 && pageType != 8 && pageType != 10) {
            return false;
        }
        return true;
    }

    public final boolean d(int pageType) {
        if (pageType != 9 && pageType != 10 && pageType != 11) {
            return false;
        }
        return true;
    }

    public final boolean e(int pageType) {
        if (pageType != 6 && pageType != 7) {
            return false;
        }
        return true;
    }

    public final boolean g(int pageType) {
        if (pageType != 3 && pageType != 12) {
            return false;
        }
        return true;
    }

    public final boolean i(BusinessFeedData feedData) {
        return (feedData == null || ef.b.f(feedData) || ef.b.d(feedData)) ? false : true;
    }

    public final int b(BusinessFeedData feedData) {
        boolean z16 = false;
        if (feedData != null && ef.b.f(feedData)) {
            z16 = true;
        }
        if (!z16) {
            return R.drawable.qui_like_filled;
        }
        mk.d dVar = mk.d.f416875a;
        CellIntimateSpaceInfo cellIntimateSpaceInfo = feedData.cellIntimateSpaceInfo;
        if (dVar.y(cellIntimateSpaceInfo != null ? Integer.valueOf(cellIntimateSpaceInfo.spaceType) : null)) {
            return R.drawable.qui_heart_filled;
        }
        CellIntimateSpaceInfo cellIntimateSpaceInfo2 = feedData.cellIntimateSpaceInfo;
        if (dVar.w(cellIntimateSpaceInfo2 != null ? Integer.valueOf(cellIntimateSpaceInfo2.spaceType) : null)) {
            return R.drawable.qui_brother_filled_qzone;
        }
        CellIntimateSpaceInfo cellIntimateSpaceInfo3 = feedData.cellIntimateSpaceInfo;
        if (dVar.H(cellIntimateSpaceInfo3 != null ? Integer.valueOf(cellIntimateSpaceInfo3.spaceType) : null)) {
            return R.drawable.qui_sister_filled_qzone;
        }
        CellIntimateSpaceInfo cellIntimateSpaceInfo4 = feedData.cellIntimateSpaceInfo;
        return dVar.t(cellIntimateSpaceInfo4 != null ? Integer.valueOf(cellIntimateSpaceInfo4.spaceType) : null) ? R.drawable.qui_homie_filled_qzone : R.drawable.qui_like_filled;
    }

    public final boolean h(BusinessFeedData feedData) {
        if (feedData == null) {
            return false;
        }
        if (ef.b.i(feedData)) {
            return (feedData.getIdInfo() == null || TextUtils.isEmpty(feedData.getIdInfo().cellId)) ? false : true;
        }
        return true;
    }
}
