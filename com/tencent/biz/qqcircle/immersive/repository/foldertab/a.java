package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.m;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k30.e;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends k implements k30.a {

    /* renamed from: i, reason: collision with root package name */
    private QFSTabFeedViewModel.c f89766i;

    public a(@NonNull l lVar) {
        super(lVar);
    }

    @Override // k30.a
    public String E1() {
        QFSTabFeedViewModel.c cVar = this.f89766i;
        if (cVar != null) {
            return cVar.f86643b;
        }
        return "";
    }

    @Override // k30.a
    public QQCircleFeedBase$StTabInfo G() {
        return this.f89797e.mTab;
    }

    @Override // k30.a
    public boolean M(@NonNull e.a aVar) {
        QLog.d(a(), 1, "sendRspByCache feed size:" + aVar.f().size() + " | isFinish:" + aVar.g() + " | feedAttachInfo:" + aVar.e());
        if (aVar.f().size() <= 0) {
            return false;
        }
        d(UIStateData.obtainResumeCache(aVar.h(), aVar.k()).setData(false, aVar.f()).setFinish(aVar.g()));
        QCirclePeriodCollect.record(this.f89799h, QCirclePeriodCollect.PERIOD_GET_PAGE_CACHE_RSP);
        return true;
    }

    @Override // k30.a
    public void Q0(@NonNull e.a aVar) {
        String str;
        QFSTabFeedViewModel.c cVar = new QFSTabFeedViewModel.c();
        cVar.f86642a.clear();
        cVar.f86642a.addAll(aVar.f());
        cVar.f86645d = aVar.g();
        cVar.f86646e = aVar.d();
        cVar.f86644c = aVar.e();
        cVar.f86643b = aVar.i();
        cVar.f86650i = aVar.l();
        f(cVar);
        QCirclePeriodCollect.record(this.f89799h, QCirclePeriodCollect.PERIOD_REQUEST_PAGE_BY_CACHE);
        String str2 = this.f89799h;
        String str3 = "4";
        if (aVar.l()) {
            str = "4";
        } else {
            str = "2";
        }
        QCirclePeriodCollect.setState(str2, str);
        p60.b bVar = this.f89796d;
        if (!aVar.l()) {
            str3 = "2";
        }
        bVar.b(str3);
    }

    @Override // k30.a
    public boolean U() {
        QFSTabFeedViewModel.c cVar = this.f89766i;
        if (cVar != null) {
            return cVar.f86645d;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.k
    public String a() {
        return b() + "_QFSCacheDataSource";
    }

    public void g() {
        k30.e.i().e();
        k30.e.i().d();
    }

    @Override // k30.a
    public FeedCloudCommon$StCommonExt getExtInfo() {
        QFSTabFeedViewModel.c cVar = this.f89766i;
        if (cVar != null) {
            return cVar.f86646e;
        }
        return null;
    }

    public boolean h(m.a aVar, String str) {
        if (!"init".equals(aVar.f89810a)) {
            return false;
        }
        QLog.d(a(), 1, "fetchData enableUseMemCache:" + aVar.f89811b + ",enableUseProtocolCache:" + aVar.f89812c + ",actionType:" + str);
        if (TextUtils.equals("CACHE_TYPE_DISK", str)) {
            if (aVar.f89812c) {
                QLog.d(a(), 1, "fetchData from QCircleFolderDiskCacheHelper");
                if (k30.n.k().r(this)) {
                    aVar.f89812c = false;
                    return true;
                }
            }
        } else if (aVar.f89811b && k30.e.i().n(this)) {
            QLog.d(a(), 1, "fetchData from QCircleFolderCacheHelper");
            return true;
        }
        return false;
    }

    public boolean i(m.a aVar) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_folder_request_use_fast_play_feed", true) && aVar != null && aVar.f89812c && this.f89798f == 10) {
            FeedCloudMeta$StFeed a16 = aVar.a();
            if (a16 == null) {
                QLog.d(a(), 1, "fetchFromFastPlayFeed is null");
                return false;
            }
            FeedCloudMeta$StFeed d16 = k30.h.f().d();
            if (z20.f.n(a16)) {
                QLog.d(a(), 1, "fetchFromFastPlayFeed is loadMore backup feed");
                e30.b bVar = new e30.b(a16);
                bVar.p();
                e(bVar);
                p60.b bVar2 = this.f89796d;
                if (bVar2 != null) {
                    bVar2.b("9");
                }
                return true;
            }
            if (d16 != null && TextUtils.equals(d16.f398449id.get(), a16.f398449id.get())) {
                QLog.d(a(), 1, "fetchFromFastPlayFeed is disk cache feed");
                e30.b bVar3 = new e30.b(a16);
                bVar3.k(true);
                bVar3.p();
                e(bVar3);
                p60.b bVar4 = this.f89796d;
                if (bVar4 != null) {
                    bVar4.b("4");
                }
                return true;
            }
        }
        return false;
    }

    public void j(List<e30.b> list) {
        QFSTabFeedViewModel.c value = c().getValue();
        this.f89766i = value;
        if (value != null && list != null && list.size() > 0) {
            this.f89766i.f86642a.clear();
            this.f89766i.f86642a.addAll(list);
        }
    }

    public void k(String str, int i3, int i16) {
        if (TextUtils.equals(str, "CACHE_TYPE_DISK")) {
            k30.n.k().t(this, i3, i16);
        } else {
            k30.e.i().s(this, i3, i16);
        }
    }

    @Override // k30.a
    public String o0() {
        QFSTabFeedViewModel.c cVar = this.f89766i;
        if (cVar != null) {
            return cVar.f86644c;
        }
        return "";
    }

    @Override // k30.a
    public Collection<e30.b> s1() {
        QFSTabFeedViewModel.c cVar = this.f89766i;
        if (cVar != null) {
            return cVar.f86642a;
        }
        return new ArrayList();
    }
}
