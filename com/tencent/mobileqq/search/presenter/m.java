package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m implements qn2.d<v, sn2.b> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f283671d;

        a(x xVar) {
            this.f283671d = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f283671d.q(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // qn2.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(v vVar, sn2.b bVar) {
        x xVar = (x) vVar;
        bVar.getMoreView().setText(xVar.getKeyword());
        bVar.getView().setOnClickListener(new a(xVar));
        if (xVar instanceof do2.k) {
            ReportController.o(null, "CliOper", "", "", "0X80061B6", "0X80061B6", 0, 0, "", "", "", "");
        }
    }
}
