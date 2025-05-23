package com.tencent.biz.qqcircle.immersive.adapter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.tab.QFSActivityTabFragment;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.biz.qqcircle.immersive.tab.QFSKuiklyFragment;
import com.tencent.biz.qqcircle.immersive.tab.mixfeed.QFSMixFeedNearByFragment;
import com.tencent.biz.qqcircle.immersive.tab.mixfeed.QFSMixFeedSubFragment;
import com.tencent.biz.qqcircle.immersive.utils.aj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$Entry;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StSubTabInfo;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class t extends FragmentStatePagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    QCircleTabInfo f84736d;

    public t(@NonNull @NotNull FragmentManager fragmentManager, int i3) {
        super(fragmentManager, i3);
    }

    private QQCircleFeedBase$StSubTabInfo d(int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        QCircleTabInfo qCircleTabInfo = this.f84736d;
        if (qCircleTabInfo == null || (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) == null) {
            return null;
        }
        PBRepeatMessageField<QQCircleFeedBase$StSubTabInfo> pBRepeatMessageField = qQCircleFeedBase$StTabInfo.subTabInfo;
        if (pBRepeatMessageField.size() <= i3) {
            return null;
        }
        return pBRepeatMessageField.get(i3);
    }

    private String e(int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        QCircleTabInfo qCircleTabInfo = this.f84736d;
        if (qCircleTabInfo != null && (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) != null) {
            PBRepeatMessageField<QQCircleFeedBase$StSubTabInfo> pBRepeatMessageField = qQCircleFeedBase$StTabInfo.subTabInfo;
            if (pBRepeatMessageField.size() <= i3) {
                return null;
            }
            QQCircleFeedBase$StSubTabInfo qQCircleFeedBase$StSubTabInfo = pBRepeatMessageField.get(i3);
            for (int i16 = 0; i16 < qQCircleFeedBase$StSubTabInfo.urlInfo.size(); i16++) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = qQCircleFeedBase$StSubTabInfo.urlInfo.get(i16);
                if (TextUtils.equals(feedCloudCommon$Entry.key.get(), "page_url")) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return null;
    }

    public void f(QCircleTabInfo qCircleTabInfo) {
        this.f84736d = qCircleTabInfo;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        QCircleTabInfo qCircleTabInfo = this.f84736d;
        if (qCircleTabInfo == null) {
            return 0;
        }
        return qCircleTabInfo.mTab.subTabInfo.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i3) {
        String e16 = e(i3);
        RFWLog.d("QFSMixFeedFragmentStatePagerAdapter", RFWLog.USR, "getItem jumpUrl: " + e16);
        if (!TextUtils.isEmpty(e16)) {
            QQCircleFeedBase$StSubTabInfo d16 = d(i3);
            if (QFSFolderTabFragment.Ph(e16)) {
                QFSActivityTabFragment qFSActivityTabFragment = new QFSActivityTabFragment(e16, this.f84736d, i3);
                qFSActivityTabFragment.ni(i3);
                qFSActivityTabFragment.ji(false);
                if (d16 != null) {
                    qFSActivityTabFragment.ii(d16.dtPgID.get());
                }
                return qFSActivityTabFragment;
            }
            if (QFSFolderTabFragment.Qh(e16)) {
                QFSKuiklyFragment qFSKuiklyFragment = new QFSKuiklyFragment(e16, this.f84736d, i3);
                qFSKuiklyFragment.ni(i3);
                qFSKuiklyFragment.ji(false);
                if (d16 != null) {
                    qFSKuiklyFragment.ii(d16.dtPgID.get());
                }
                return qFSKuiklyFragment;
            }
        }
        if (this.f84736d.mTab.subTabInfo.get(i3).sourceType.get() == 12) {
            aj ajVar = aj.f90122a;
            ajVar.b();
            return ajVar.a(this.f84736d, i3);
        }
        if (QCirclePluginUtil.isNearBy(this.f84736d, i3)) {
            return new QFSMixFeedNearByFragment(this.f84736d, i3);
        }
        return new QFSMixFeedSubFragment(this.f84736d, i3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        QCircleTabInfo qCircleTabInfo = this.f84736d;
        if (qCircleTabInfo != null && (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) != null && qQCircleFeedBase$StTabInfo.subTabInfo.size() > i3) {
            return this.f84736d.mTab.subTabInfo.get(i3).tabName.get();
        }
        return "";
    }
}
