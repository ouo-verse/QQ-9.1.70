package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.a;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileFavFileTabView extends QfileBaseFavFileTabView {
    protected TextView T;
    protected Drawable U;
    public View.OnClickListener V;
    protected ViewerMoreRelativeLayout W;

    /* renamed from: a0, reason: collision with root package name */
    public View.OnClickListener f206545a0;

    /* renamed from: b0, reason: collision with root package name */
    a.b f206546b0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QfileFavFileTabView.this.w()) {
                QfileFavFileTabView.this.G();
                QfileFavFileTabView.this.b0();
                if (QfileFavFileTabView.this.G.getGroupCount() > 0) {
                    QfileFavFileTabView.this.F.expandGroup(r0.G.getGroupCount() - 1);
                }
                QfileFavFileTabView.this.F.setSelection(r0.getAdapter().getCount() - 1);
                ((QfileBaseTabView) QfileFavFileTabView.this).f206606h = false;
                QfileFavFileTabView.this.M();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FavFileInfo favFileInfo;
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getTag() instanceof a.C7532a) {
                favFileInfo = (FavFileInfo) ((a.C7532a) view.getTag()).G;
            } else {
                favFileInfo = null;
            }
            if (favFileInfo != null) {
                QfileFavFileTabView qfileFavFileTabView = QfileFavFileTabView.this;
                if (view.getId() == R.id.c_5) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qfileFavFileTabView.i0(favFileInfo, z16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements a.b {
        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements ExpandableListView.OnGroupExpandListener {
        d() {
        }

        @Override // com.tencent.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i3) {
            if (i3 == QfileFavFileTabView.this.G.getGroupCount() - 1) {
                QfileFavFileTabView qfileFavFileTabView = QfileFavFileTabView.this;
                if (qfileFavFileTabView.W != null) {
                    if (!qfileFavFileTabView.T()) {
                        QfileFavFileTabView.this.W.setVisible();
                    } else {
                        QfileFavFileTabView.this.W.setGone();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements ExpandableListView.OnGroupCollapseListener {
        e() {
        }

        @Override // com.tencent.widget.ExpandableListView.OnGroupCollapseListener
        public void onGroupCollapse(int i3) {
            ViewerMoreRelativeLayout viewerMoreRelativeLayout;
            if (i3 == QfileFavFileTabView.this.G.getGroupCount() - 1 && (viewerMoreRelativeLayout = QfileFavFileTabView.this.W) != null) {
                viewerMoreRelativeLayout.setGone();
            }
        }
    }

    public QfileFavFileTabView(Context context, QfileFavFileRecordProvider qfileFavFileRecordProvider, QfileBaseFavFileTabView.d dVar) {
        super(context, qfileFavFileRecordProvider, dVar);
        this.V = new a();
        this.f206545a0 = new b();
        this.f206546b0 = new c();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected int K() {
        return 5;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected String L(FavFileInfo favFileInfo) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(favFileInfo.C);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected int N() {
        return 15;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected ob1.d O() {
        return new com.tencent.mobileqq.filemanager.activity.favfile.a(o(), this.E, o(), this.f206545a0, null, null, this.f206546b0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    public void W(int i3) {
        super.W(i3);
        if (T() && this.W.getVisibility() == 0) {
            this.W.setGone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    public void X() {
        this.F.setOnGroupExpandListener(new d());
        this.F.setOnGroupCollapseListener(new e());
        ViewerMoreRelativeLayout viewerMoreRelativeLayout = new ViewerMoreRelativeLayout(o());
        this.W = viewerMoreRelativeLayout;
        viewerMoreRelativeLayout.setOnClickListener(this.V);
        this.W.setGone();
        this.T = (TextView) this.W.findViewById(R.id.kxk);
        this.F.addFooterView(this.W);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    public void Y() {
        if (T()) {
            this.W.setGone();
        } else {
            LinkedHashMap<String, List<FavFileInfo>> linkedHashMap = this.E;
            if (linkedHashMap != null && linkedHashMap.size() != 0) {
                this.W.setVisible();
            } else {
                this.W.setGone();
            }
        }
        super.Y();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected void b0() {
        if (this.T != null && this.U == null) {
            Drawable drawable = getResources().getDrawable(R.drawable.f160545jt);
            this.U = drawable;
            this.T.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ((Animatable) this.U).start();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected void c0() {
        Object obj;
        if (this.T != null && (obj = this.U) != null) {
            ((Animatable) obj).stop();
            this.U = null;
            this.T.setCompoundDrawables(null, null, null, null);
        }
    }

    protected void h0(boolean z16) {
        ReportController.o(this.f206604e, "dc00898", "", "", "0X800AFB3", "0X800AFB3", 0, 0, "", "", "", "");
    }

    public void i0(FavFileInfo favFileInfo, boolean z16) {
        if (v() && !z16) {
            if (f.B(favFileInfo)) {
                f.F(favFileInfo);
            } else {
                f.b(favFileInfo);
                this.f206603d.G3(true);
            }
            k();
            Y();
        } else {
            if (!w()) {
                if (QLog.isColorLevel()) {
                    QLog.i(QfileBaseFavFileTabView.R, 2, "click too fast , wait a minute.");
                    return;
                }
                return;
            }
            G();
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openFavorite(this.f206603d, this.f206604e.getCurrentAccountUin(), favFileInfo.f207672d);
        }
        h0(v());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public int p() {
        return this.W.getHeight();
    }
}
