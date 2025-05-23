package com.qzone.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AlbumVipOpenArea extends View {
    private TextView C;
    private TextView D;
    private long E;
    private long F;

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f60145d;

    /* renamed from: e, reason: collision with root package name */
    private AsyncImageView f60146e;

    /* renamed from: f, reason: collision with root package name */
    private AsyncImageView f60147f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f60148h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f60149i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f60150m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f60151d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f60152e;

        a(ViewGroup viewGroup, RelativeLayout relativeLayout) {
            this.f60151d = viewGroup;
            this.f60152e = relativeLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f60151d != null) {
                this.f60152e.setVisibility(8);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AlbumVipOpenArea(Context context) {
        super(context);
        this.E = 0L;
        this.F = 0L;
    }

    public void c(ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.f11986780);
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        if (bundle == null) {
            return;
        }
        long j3 = bundle.getLong("USED_COUNT");
        long j16 = bundle.getLong("BOUGHT_COUNT") + bundle.getLong("FREE_COUNT") + j3;
        this.F = j16;
        this.E = j3;
        if (this.f60145d == null) {
            a(viewGroup);
        }
        relativeLayout.setVisibility(0);
        this.f60145d.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/hz-xctq/bianzu-3.png");
        this.f60146e.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/hz-xctq/bianzu-12.png");
        this.f60147f.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/hz-xctq/rectangle-8beifen.png");
        this.f60146e.setOnClickListener(new a(viewGroup, relativeLayout));
        if (LoginData.getInstance().isQzoneVip()) {
            this.C.setText("\u7eed\u8d39");
            this.f60150m.setVisibility(8);
            this.D.setVisibility(8);
            this.f60148h.setText("\u9ec4\u94bb\u5c0a\u4eab\u539f\u56fe\u4e0a\u4f20\u65e0\u9650\u5236");
            return;
        }
        this.C.setText("\u5f00\u901a");
        if (j3 == 0) {
            this.f60148h.setText("\u9ec4\u94bb\u5c0a\u4eab\u89c6\u9891\u4e0a\u4f20\u7279\u6743");
            this.D.setVisibility(0);
            this.D.setText("\u539f\u753b\u4e0a\u4f20\uff0c\u8d85\u5927\u89c6\u9891\u4e0a\u4f20");
            this.f60150m.setVisibility(8);
            return;
        }
        this.f60148h.setText("\u9ec4\u94bb\u5c0a\u4eab\u539f\u56fe\u4e0a\u4f20\u65e0\u9650\u5236");
        this.f60150m.setVisibility(0);
        this.D.setVisibility(8);
        this.f60149i.setText(j3 + " / " + j16);
    }

    public boolean b(int i3, int i16) {
        if (i3 != 3 || LoginData.getInstance().isQzoneVip()) {
            return true;
        }
        long j3 = this.E;
        long j16 = this.F;
        return j3 < j16 && i16 > 0 && j3 + ((long) i16) <= j16;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ((RelativeLayout) viewGroup.findViewById(R.id.f11986780)).setVisibility(8);
        this.f60145d = (AsyncImageView) viewGroup.findViewById(R.id.f1196677g);
        this.f60146e = (AsyncImageView) viewGroup.findViewById(R.id.f1196777h);
        this.f60147f = (AsyncImageView) viewGroup.findViewById(R.id.f1197377n);
        this.f60148h = (TextView) viewGroup.findViewById(R.id.f1197977t);
        this.f60149i = (TextView) viewGroup.findViewById(R.id.f1197077k);
        this.f60150m = (LinearLayout) viewGroup.findViewById(R.id.f1196977j);
        this.C = (TextView) viewGroup.findViewById(R.id.f1197477o);
        this.D = (TextView) viewGroup.findViewById(R.id.f1197277m);
    }
}
