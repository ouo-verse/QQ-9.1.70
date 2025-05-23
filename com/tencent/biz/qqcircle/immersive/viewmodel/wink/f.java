package com.tencent.biz.qqcircle.immersive.viewmodel.wink;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqforward.api.RecentUserBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import e40.o;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends BaseViewModel {
    private static final String E = "com.tencent.biz.qqcircle.immersive.viewmodel.wink.f";
    private int D;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<FeedCloudMeta$StFeed> f90289i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<o>> f90290m = new MutableLiveData<>();
    private List<RecentUserBean> C = new CopyOnWriteArrayList();

    public static boolean Q1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.right.ugcRight.rightFlag.get() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(List list, Context context) {
        QLog.d(E, 1, "initData... update users");
        if (list != null && !list.isEmpty()) {
            this.C.clear();
            this.C.addAll(list);
        }
        String M1 = M1();
        if (M1.equals("experiment_a")) {
            this.D = 3;
        } else if (M1.equals("experiment_b")) {
            this.D = 4;
        }
        this.f90290m.postValue(S1(this.C, context));
    }

    private List<o> S1(List<RecentUserBean> list, Context context) {
        ArrayList arrayList = new ArrayList();
        Iterator<RecentUserBean> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RecentUserBean next = it.next();
            o oVar = new o();
            if (arrayList.size() == this.D) {
                oVar.d(context.getResources().getString(R.string.f184883n3));
                oVar.e(2);
                arrayList.add(oVar);
                break;
            }
            oVar.f(next.getUin());
            oVar.d(next.getDisplayName());
            oVar.e(next.getType());
            arrayList.add(oVar);
        }
        if (arrayList.size() < this.D + 1) {
            o oVar2 = new o();
            oVar2.d(context.getResources().getString(R.string.f184883n3));
            oVar2.e(2);
            arrayList.add(oVar2);
        }
        return arrayList;
    }

    public String M1() {
        String U3 = uq3.c.U3();
        if (this.C.size() == 0) {
            QLog.d(E, 1, "no RecentUsers");
            return "";
        }
        return U3;
    }

    public MutableLiveData<List<o>> N1() {
        return this.f90290m;
    }

    public MutableLiveData<FeedCloudMeta$StFeed> O1() {
        return this.f90289i;
    }

    public void P1(final Context context, final List<RecentUserBean> list) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.viewmodel.wink.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.R1(list, context);
            }
        });
    }

    public void T1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f90289i.setValue(feedCloudMeta$StFeed);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return E;
    }
}
