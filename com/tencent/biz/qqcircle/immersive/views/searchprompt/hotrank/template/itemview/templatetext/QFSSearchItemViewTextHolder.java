package com.tencent.biz.qqcircle.immersive.views.searchprompt.hotrank.template.itemview.templatetext;

import aa0.b;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import ca0.a;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchItemViewTextHolder extends b<ba0.b> {
    protected final ImageView H;
    protected final TextView I;
    private final View J;
    private final TextView K;
    private final View L;

    @Keep
    public QFSSearchItemViewTextHolder(View view) {
        super(view);
        this.L = view;
        this.H = (ImageView) view.findViewById(R.id.f43831nj);
        this.I = (TextView) view.findViewById(R.id.f53482cm);
        this.J = view.findViewById(R.id.f43851nl);
        this.K = (TextView) view.findViewById(R.id.f43881no);
    }

    private void u() {
        String str = ((ba0.b) this.G).f28141a.icon.text.get();
        Integer c16 = ((ba0.b) this.G).c();
        Integer b16 = ((ba0.b) this.G).b();
        if (!str.isEmpty() && c16 != null && b16 != null) {
            this.K.setText(str);
            this.K.setTextColor(c16.intValue());
            this.J.setBackground(ad.f(b16.intValue(), 3, 17, 17));
            this.J.setVisibility(0);
            return;
        }
        this.J.setVisibility(8);
    }

    private void v(@NonNull ba0.b bVar) {
        int i3;
        View view = this.L;
        if (TextUtils.equals(bVar.d(), bVar.f28141a.text.get())) {
            i3 = this.L.getContext().getColor(R.color.cjd);
        } else {
            i3 = 0;
        }
        view.setBackgroundColor(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // aa0.b
    public void s(QFSSearchInfo qFSSearchInfo) {
        super.s(qFSSearchInfo);
        r(5108, qFSSearchInfo.f());
    }

    public void t(ba0.b bVar, int i3) {
        super.l(bVar, i3);
        a.c(this.H, bVar.f28141a.rankImg.get());
        String str = bVar.f28141a.text.get();
        this.I.setText(str);
        QLog.d("QFSSearchItemViewTextHolder", 1, "[bindData] title: " + str);
        u();
        v(bVar);
    }
}
