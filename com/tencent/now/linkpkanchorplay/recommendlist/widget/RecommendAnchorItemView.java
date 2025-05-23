package com.tencent.now.linkpkanchorplay.recommendlist.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.mobileqq.R;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.base.LinkPKHeadImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import e55.d;
import java.util.HashMap;
import u0.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RecommendAnchorItemView extends FrameLayout {
    private b C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private LinkPKHeadImageView f338421d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f338422e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f338423f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f338424h;

    /* renamed from: i, reason: collision with root package name */
    private Button f338425i;

    /* renamed from: m, reason: collision with root package name */
    private e55.a f338426m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (RecommendAnchorItemView.this.C != null) {
                RecommendAnchorItemView.this.C.a(RecommendAnchorItemView.this.f338426m);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void a(e55.a aVar);
    }

    public RecommendAnchorItemView(@NonNull Context context) {
        super(context);
        this.f338421d = null;
        this.f338422e = null;
        this.f338423f = null;
        this.f338424h = null;
        this.f338425i = null;
        this.f338426m = null;
        this.C = null;
        this.D = false;
        e();
    }

    private void f() {
        u0.a.h().c("https://dlied5.qq.com/now/qq-live/images/pk-living.png", this.f338422e, new a.c(0, true, true));
    }

    private void g(e55.a aVar) {
        d[] dVarArr = aVar.f395731c;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = aVar.f395731c;
                if (i3 < dVarArr2.length) {
                    String str = dVarArr2[i3].f395740a;
                    if (!TextUtils.isEmpty(str) && str.equals(getContext().getString(R.string.f1358402j))) {
                        this.f338424h.setVisibility(0);
                        this.f338424h.setText(str);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void c(int i3, int i16) {
        e55.a aVar;
        String str;
        String str2;
        if (this.f338425i != null && (aVar = this.f338426m) != null) {
            if (i3 == 0) {
                str = "em_qqlive_lp_recommend_anchor_invite";
            } else if (i3 == 1) {
                str = "em_qqlive_lppk_recommend_anchor_invite";
            } else {
                if (i3 == 2 || i3 == 3) {
                    str2 = "em_qqlive_lp_invite";
                    long j3 = aVar.f395729a.f395736b;
                    HashMap hashMap = new HashMap();
                    hashMap.put("qqlive_lp_anchor_id", String.valueOf(j3));
                    hashMap.put("qqlive_lp_tj_anchor_postition", String.valueOf(i16));
                    com.tencent.report.a.f364907a.d(this.f338425i, true, null, str2, hashMap);
                }
                if (i3 == 4) {
                    str = "em_qqlive_pwpk_recommend_anchor_invite";
                } else {
                    str = "";
                }
            }
            str2 = str;
            long j36 = aVar.f395729a.f395736b;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("qqlive_lp_anchor_id", String.valueOf(j36));
            hashMap2.put("qqlive_lp_tj_anchor_postition", String.valueOf(i16));
            com.tencent.report.a.f364907a.d(this.f338425i, true, null, str2, hashMap2);
        }
    }

    public void d(int i3, int i16) {
        String str;
        if (this.f338426m == null) {
            return;
        }
        if (i3 == 1) {
            str = "em_qqlive_lp_recommend_anchor";
        } else if (i3 == 3) {
            str = "em_qqlive_lppk_recommend_anchor";
        } else if (i3 == 5) {
            str = "em_qqlive_pwpk_recommend_anchor";
        } else {
            str = "";
        }
        String str2 = str;
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_anchor_id", String.valueOf(this.f338426m.f395729a.f395735a));
        hashMap.put("qqlive_lp_tj_anchor_postition", String.valueOf(i16));
        com.tencent.report.a.f364907a.a(this, true, null, str2, hashMap);
    }

    public void e() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fey, (ViewGroup) this, true);
        this.f338421d = (LinkPKHeadImageView) inflate.findViewById(R.id.a2o);
        this.f338422e = (ImageView) inflate.findViewById(R.id.yko);
        this.f338423f = (TextView) inflate.findViewById(R.id.sop);
        this.f338424h = (TextView) inflate.findViewById(R.id.vf8);
        this.f338425i = (Button) inflate.findViewById(R.id.f83134ir);
        f();
        this.f338421d.f(false);
        this.f338425i.setOnClickListener(new a());
    }

    @RequiresApi(api = 28)
    public void setData(e55.a aVar) {
        this.f338426m = aVar;
        if (aVar == null) {
            return;
        }
        this.f338423f.setText("");
        this.f338421d.setImageDrawable(null);
        this.f338424h.setVisibility(8);
        if (!TextUtils.isEmpty(aVar.f395729a.f395738d)) {
            int b16 = UIUtil.b(this.f338421d.getContext(), 32.0f);
            ImageLoader.getInstance().displayImage(aVar.f395729a.f395738d, new ImageViewAware(this.f338421d), fn3.b.a(), new ImageSize(b16, b16), null, null);
        }
        if (!TextUtils.isEmpty(aVar.f395729a.f395737c)) {
            this.f338423f.setText(aVar.f395729a.f395737c);
        }
        g(aVar);
    }

    public void setIsLiving(boolean z16) {
        int i3;
        String str;
        int i16;
        ImageView imageView = this.f338422e;
        int i17 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        Button button = this.f338425i;
        if (z16) {
            str = "\u53d1\u8d77\u9080\u8bf7";
        } else {
            str = "\u6682\u65e0\u5f00\u64ad";
        }
        button.setText(str);
        this.f338425i.setClickable(z16);
        Button button2 = this.f338425i;
        if (z16) {
            i16 = -1;
        } else {
            i16 = 2063597567;
        }
        button2.setTextColor(i16);
        Button button3 = this.f338425i;
        if (z16) {
            i17 = R.drawable.jct;
        }
        button3.setBackgroundResource(i17);
    }

    public void setIsReportedVisible(boolean z16) {
        this.D = z16;
    }

    public void setOnInviteClickListener(b bVar) {
        this.C = bVar;
    }

    public RecommendAnchorItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338421d = null;
        this.f338422e = null;
        this.f338423f = null;
        this.f338424h = null;
        this.f338425i = null;
        this.f338426m = null;
        this.C = null;
        this.D = false;
        e();
    }

    public RecommendAnchorItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338421d = null;
        this.f338422e = null;
        this.f338423f = null;
        this.f338424h = null;
        this.f338425i = null;
        this.f338426m = null;
        this.C = null;
        this.D = false;
        e();
    }
}
