package com.tencent.biz.qqstory.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsWeiShiUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends ReportDialog implements View.OnClickListener {
    protected boolean C;
    protected Button D;
    private ImageView E;
    private View F;
    private TextView G;
    protected int H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private Context N;
    private String P;
    protected String Q;

    public a(@NonNull Context context, int i3, String str) {
        super(context, i3);
        this.C = false;
        this.H = 0;
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = null;
        this.N = context;
        this.P = str;
    }

    private void initView() {
        this.D = (Button) findViewById(R.id.agw);
        this.E = (ImageView) findViewById(R.id.dum);
        this.F = findViewById(R.id.ecv);
        this.G = (TextView) findViewById(R.id.k9d);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.D.setText(HardCodeUtil.qqStr(R.string.f172926vl3));
        Q();
        if (TextUtils.isEmpty(this.I)) {
            this.I = "https://pub.idqqimg.com/pc/misc/files/20180423/03d546703c3f49a3857c67be2e94f928.png";
        }
        this.G.setVisibility(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        URLDrawable drawable = URLDrawable.getDrawable(this.I, obtain);
        drawable.setURLDrawableListener(new C0946a(this.G));
        this.F.setBackgroundDrawable(drawable);
        int status = drawable.getStatus();
        if (status != 1) {
            if (status == 2) {
                drawable.restartDownload();
                return;
            }
            return;
        }
        this.G.setVisibility(8);
    }

    public a O(String str) {
        this.I = str;
        return this;
    }

    public a P(String str, String str2, String str3) {
        this.J = str;
        this.K = str2;
        this.L = str3;
        return this;
    }

    public void Q() {
        boolean c16 = l.c(getContext());
        if (this.C != c16) {
            this.C = c16;
            if (c16) {
                this.D.setText(HardCodeUtil.qqStr(R.string.f172927vl4));
            } else {
                this.D.setText(HardCodeUtil.qqStr(R.string.vl7));
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        N(-1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        boolean z16;
        int i16;
        int i17;
        String str;
        boolean z17;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        int i18 = 1;
        if (id5 == R.id.agw) {
            Q();
            if (TextUtils.isEmpty(this.M)) {
                if (this.C) {
                    l.d(getContext(), this.P, this.Q);
                    i17 = 0;
                } else {
                    QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.vl5), 0).show();
                    l.b(getContext(), this.P);
                    i17 = 1;
                }
                id0.a.n("weishi_share", "cover_clk", 0, 0, this.K, this.J, "weishi", this.L);
            } else {
                if (this.C) {
                    ((IVideoFeedsWeiShiUtils) QRoute.api(IVideoFeedsWeiShiUtils.class)).openWeishi(getContext(), this.M);
                    i3 = 0;
                } else {
                    QQToast.makeText(getContext(), -1, HardCodeUtil.qqStr(R.string.vl6), 0).show(getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    ((IVideoFeedsWeiShiUtils) QRoute.api(IVideoFeedsWeiShiUtils.class)).gotoWeishiDownload(getContext(), this.M);
                    i3 = 1;
                }
                Context context = this.N;
                if (context instanceof Activity) {
                    int intExtra = ((Activity) context).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
                    int intExtra2 = ((Activity) this.N).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
                    if (intExtra2 != 9 && intExtra2 != 12) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    boolean z18 = z17;
                    i16 = intExtra;
                    z16 = z18;
                } else {
                    z16 = false;
                    i16 = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (this.C) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("download", str);
                    IVideoReporter iVideoReporter = (IVideoReporter) QRoute.api(IVideoReporter.class);
                    if (!z16) {
                        i18 = 0;
                    }
                    iVideoReporter.addKanDianTagForWeishiReport(jSONObject, i18);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                if (((IVideoFeedsWeiShiUtils) QRoute.api(IVideoFeedsWeiShiUtils.class)).isWeishi(this.M)) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80092A7", "0X80092A7", 0, 0, String.valueOf(i16), "", "", ((IVideoReporter) QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, "", "", jSONObject), false);
                } else {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80092A9", "0X80092A9", 0, 0, String.valueOf(i16), "", "", ((IVideoReporter) QRoute.api(IVideoReporter.class)).videoReportBaseR5(null, null, "", "", jSONObject), false);
                }
                i17 = i3;
            }
            dismiss();
            N(i17);
        } else if (id5 == R.id.dum) {
            dismiss();
            N(-1);
            if (TextUtils.isEmpty(this.M)) {
                id0.a.n("weishi_share", "cover_close", 0, 0, this.K, this.J, "weishi", this.L);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bah);
        initView();
        setCanceledOnTouchOutside(false);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        if (TextUtils.isEmpty(this.M)) {
            id0.a.n("weishi_share", "cover_exp", 0, 0, this.K, this.J, "weishi", this.L);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqstory.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0946a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<TextView> f94505d;

        public C0946a(TextView textView) {
            this.f94505d = new WeakReference<>(textView);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            TextView textView = this.f94505d.get();
            if (textView != null) {
                textView.setVisibility(8);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    private void N(int i3) {
    }
}
