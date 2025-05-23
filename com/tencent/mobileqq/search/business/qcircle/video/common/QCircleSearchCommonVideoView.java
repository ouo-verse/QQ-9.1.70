package com.tencent.mobileqq.search.business.qcircle.video.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.search.hotrank.QFSSearchHotRankView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView;
import com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a;
import com.tencent.mobileqq.search.business.qcircle.video.common.viewmodel.d;
import com.tencent.mobileqq.utils.ah;
import com.tencent.widget.HorizontalListView;
import lo2.ac;
import wo2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QCircleSearchCommonVideoView extends QCircleSearchDoubleVideoView<ac> {
    private TextView C;
    private View D;
    private ImageView E;

    public QCircleSearchCommonVideoView(Context context) {
        super(context);
    }

    private void m() {
        String titleSpans = ((ac) this.f283063e).getTitleSpans();
        if (TextUtils.isEmpty(titleSpans)) {
            this.C.setVisibility(8);
            return;
        }
        this.C.setVisibility(0);
        this.C.setText(b.a(this.C, (int) ah.Z(), titleSpans, ((ac) this.f283063e).L));
    }

    private void n() {
        ac.b bVar = (ac.b) ((ac) this.f283063e).d0();
        if (!bVar.b()) {
            this.D.setVisibility(8);
            return;
        }
        this.D.setVisibility(0);
        int a16 = bVar.a();
        if (a16 > 0) {
            int[] iArr = QFSSearchHotRankView.M;
            if (a16 <= iArr.length) {
                this.E.setVisibility(0);
                this.E.setImageResource(iArr[a16 - 1]);
                return;
            }
        }
        this.E.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    @NonNull
    protected Class<? extends a> g() {
        return d.class;
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    protected String i() {
        return "qDouble";
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    public void j() {
        super.j();
        this.C = (TextView) findViewById(R.id.title);
        View findViewById = findViewById(R.id.xbh);
        this.D = findViewById;
        this.E = (ImageView) findViewById.findViewById(R.id.xbf);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    protected no2.a k(HorizontalListView horizontalListView, mo2.a aVar, a aVar2, com.tencent.mobileqq.search.business.qcircle.video.base.a aVar3) {
        return new qo2.a(horizontalListView, aVar, aVar2, aVar3);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void d(ac acVar) {
        super.d(acVar);
        m();
        n();
    }

    public QCircleSearchCommonVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QCircleSearchCommonVideoView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
