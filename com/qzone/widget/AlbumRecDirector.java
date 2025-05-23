package com.qzone.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.qzone.feed.utils.AlbumRecReporter;
import com.qzone.module.feedcomponent.ui.FeedAlbumRec;
import com.qzone.util.ap;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AlbumRecDirector extends aa implements View.OnClickListener {
    private static volatile String H = "https://qzonestyle.gtimg.cn/aoi/sola/20190925142616_iXzwsiWAWd.png";
    private final View C;
    private final View D;
    private AlbumRecReporter.c E;
    private boolean F;
    private View.OnClickListener G;

    /* renamed from: d, reason: collision with root package name */
    private final AsyncImageView f60138d;

    /* renamed from: e, reason: collision with root package name */
    private final AsyncImageView f60139e;

    /* renamed from: f, reason: collision with root package name */
    private final AsyncImageView f60140f;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f60141h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f60142i;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f60143m;

    public AlbumRecDirector(View view) {
        super(view);
        this.E = AlbumRecReporter.c.f47420a;
        this.F = true;
        this.f60138d = (AsyncImageView) findViewById(R.id.m47);
        this.f60139e = (AsyncImageView) findViewById(R.id.m48);
        this.f60140f = (AsyncImageView) findViewById(R.id.m49);
        this.f60141h = (TextView) findViewById(R.id.m4b);
        this.f60142i = (TextView) findViewById(R.id.m4d);
        this.f60143m = (TextView) findViewById(R.id.m4c);
        this.C = findViewById(R.id.m4_);
        this.D = findViewById(R.id.m4a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AlbumRecReporter.c cVar) {
        if (this.E == cVar) {
            return;
        }
        this.E = cVar;
        this.F = true;
        String[] strArr = new String[3];
        int i3 = 0;
        for (String str : cVar.picUrls) {
            if (new File(str).exists()) {
                int i16 = i3 + 1;
                strArr[i3] = str;
                this.F = false;
                i3 = i16;
                if (i16 > 2) {
                    break;
                }
            } else {
                QZLog.i("AlbumRecDirector", "setAlbumInfoSync: url not exist " + str);
            }
        }
        if (this.F) {
            this.f60138d.setAsyncImage(H);
            this.f60139e.setAsyncImage(null);
            this.f60140f.setAsyncImage(null);
            this.f60142i.setText("");
            this.f60143m.setText("");
            this.D.setVisibility(8);
            this.C.setVisibility(8);
        } else {
            this.f60138d.setAsyncImage(strArr[0]);
            this.f60139e.setAsyncImage(strArr[1]);
            this.f60140f.setAsyncImage(strArr[2]);
            this.f60142i.setText(this.E.picTitle);
            this.f60143m.setText(this.E.picContent);
            if (i3 > 2) {
                this.D.setVisibility(0);
                this.C.setVisibility(0);
            } else {
                this.D.setVisibility(8);
                this.C.setVisibility(8);
            }
        }
        this.f60141h.setText(this.E.btnText);
        Drawable background = this.f60141h.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(this.E.btnColor);
            return;
        }
        QZLog.w("AlbumRecDirector", "setAlbumInfoSync: failed to set btn color " + background.getClass().getName());
    }

    public static void k() {
        H = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ALBUM_REC_FEED_EMPTY_PIC_URL, "https://qzonestyle.gtimg.cn/aoi/sola/20190925142616_iXzwsiWAWd.png");
    }

    public void e() {
        AlbumRecReporter.c cVar = this.E;
        if (cVar == null || cVar == AlbumRecReporter.c.f47420a) {
            return;
        }
        QZLog.i("AlbumRecDirector", "doClickReport: " + this.F);
        g(this.F ? 10 : this.E.reportResClick);
    }

    public void f() {
        AlbumRecReporter.c cVar = this.E;
        if (cVar == null || cVar == AlbumRecReporter.c.f47420a) {
            return;
        }
        QZLog.i("AlbumRecDirector", "doExposeReport: " + this.F);
        g(this.F ? 9 : this.E.reportResExpose);
    }

    public String h() {
        AlbumRecReporter.c cVar = this.E;
        if (cVar == null) {
            return null;
        }
        if (this.F) {
            return cVar.emptyPicSchema;
        }
        return cVar.schema;
    }

    public void i(final AlbumRecReporter.c cVar) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            j(cVar);
        } else {
            QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.widget.AlbumRecDirector.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumRecDirector.this.j(cVar);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        View.OnClickListener onClickListener = this.G;
        if (onClickListener != null) {
            if (onClickListener instanceof FeedAlbumRec) {
                FeedAlbumRec feedAlbumRec = (FeedAlbumRec) onClickListener;
                if (view == this.f60141h) {
                    i3 = 153;
                } else {
                    i3 = (view == this.f60142i || view == this.f60143m) ? 19 : 26;
                }
                ap.f59791b.e(i3, 1, feedAlbumRec.getFeedPosition(), feedAlbumRec.getLastFeedData());
            }
            this.G.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.widget.aa
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.G = onClickListener;
        if (onClickListener == null) {
            super.setOnClickListener(null);
            return;
        }
        this.f60141h.setOnClickListener(this);
        this.f60142i.setOnClickListener(this);
        this.f60143m.setOnClickListener(this);
        super.setOnClickListener(this);
    }

    private static void g(int i3) {
        LpReportInfo_pf00064.allReport(641, 4, i3);
    }
}
