package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class k {

    /* renamed from: d, reason: collision with root package name */
    protected final p60.b f89796d;

    /* renamed from: e, reason: collision with root package name */
    protected final QCircleTabInfo f89797e;

    /* renamed from: f, reason: collision with root package name */
    protected final int f89798f;

    /* renamed from: h, reason: collision with root package name */
    protected final String f89799h;

    public k(@NonNull p60.b bVar) {
        this.f89796d = bVar;
        QCircleTabInfo G = bVar.G();
        this.f89797e = G;
        int source = G.getSource();
        this.f89798f = source;
        this.f89799h = String.valueOf(source);
    }

    public abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public String b() {
        return "FeedLine_QFSFolderTabPipeline_" + this.f89796d.G().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MutableLiveData<QFSTabFeedViewModel.c> c() {
        QLog.d(a(), 1, "getSnapshotHolder");
        return this.f89796d.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(UIStateData<List<e30.b>> uIStateData) {
        QLog.d(a(), 1, "postFeedInMain\uff0cstate:", Integer.valueOf(uIStateData.getState()));
        this.f89796d.a(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        QFSTabFeedViewModel.c cVar = new QFSTabFeedViewModel.c();
        cVar.f86642a.clear();
        cVar.f86642a.add(bVar);
        cVar.f86645d = false;
        f(cVar);
        d(UIStateData.obtainSuccess(true).setData(false, cVar.f86642a).setFinish(false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@NonNull QFSTabFeedViewModel.c cVar) {
        QLog.d(a(), 1, "postSnapshotInMain");
        this.f89796d.c(cVar);
    }
}
