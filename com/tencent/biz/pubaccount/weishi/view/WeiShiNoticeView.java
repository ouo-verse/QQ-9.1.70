package com.tencent.biz.pubaccount.weishi.view;

import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WeiShiNoticeView extends LinearLayout {
    private LinearLayout C;
    private ImageView D;
    ArrayList<RoundImageView> E;

    /* renamed from: d, reason: collision with root package name */
    private Context f82428d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f82429e;

    /* renamed from: f, reason: collision with root package name */
    private RoundImageView f82430f;

    /* renamed from: h, reason: collision with root package name */
    private RoundImageView f82431h;

    /* renamed from: i, reason: collision with root package name */
    private RoundImageView f82432i;

    /* renamed from: m, reason: collision with root package name */
    private int f82433m;

    public WeiShiNoticeView(Context context) {
        super(context);
        this.E = new ArrayList<>();
        this.f82428d = context;
    }

    private void e(int i3, String str) {
        if (this.E.size() > i3) {
            RoundImageView roundImageView = this.E.get(i3);
            if (!TextUtils.isEmpty(str)) {
                Drawable drawable = this.f82428d.getResources().getDrawable(R.drawable.f__);
                WSPicLoader.g().x(roundImageView, str, drawable, drawable, "avatar" + i3);
            } else {
                roundImageView.setImageResource(R.drawable.f__);
            }
            roundImageView.setVisibility(0);
        }
    }

    private void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            Drawable drawable = this.f82428d.getResources().getDrawable(R.drawable.d7y);
            WSPicLoader.g().x(this.D, str, drawable, drawable, "banner");
        } else {
            this.D.setImageResource(R.drawable.d7y);
        }
    }

    public int b() {
        return this.f82433m;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        d();
    }

    public void a(stNotificationRsp stnotificationrsp, String str) {
        if (stnotificationrsp == null) {
            c();
            return;
        }
        this.f82433m = stnotificationrsp.type;
        setVisibility(0);
        WSReportDc00898.t(6, this.f82433m, stnotificationrsp.cid);
        com.tencent.biz.pubaccount.weishi.recommend.a.p("gzh_exposure", this.f82433m, 0, stnotificationrsp.cid, stnotificationrsp.trace_id, str);
        if (this.f82433m == 6) {
            f(stnotificationrsp.imgurl);
            this.D.setVisibility(0);
            this.C.setVisibility(8);
            return;
        }
        this.D.setVisibility(8);
        this.C.setVisibility(0);
        if (!TextUtils.isEmpty(stnotificationrsp.text)) {
            this.f82429e.setTextColor(-16777216);
            this.f82429e.setText(stnotificationrsp.text);
        }
        ArrayList<stSimpleMetaPerson> arrayList = stnotificationrsp.persons;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            stSimpleMetaPerson stsimplemetaperson = arrayList.get(i3);
            if (stsimplemetaperson != null && !TextUtils.isEmpty(stsimplemetaperson.avatar)) {
                e(i3, stsimplemetaperson.avatar);
            }
        }
        x.i("813", "mAvatar1 :" + this.f82430f.getVisibility());
        x.i("813", "mAvatar2 :" + this.f82431h.getVisibility());
        x.i("813", "mAvatar3 :" + this.f82432i.getVisibility());
    }

    public void c() {
        setVisibility(8);
    }

    public WeiShiNoticeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = new ArrayList<>();
        this.f82428d = context;
    }

    private void d() {
        RoundImageView roundImageView = (RoundImageView) findViewById(R.id.a2y);
        this.f82430f = roundImageView;
        roundImageView.setBorderColor(Color.parseColor("#c1c1c1"));
        this.f82430f.setBorderWidth(1);
        RoundImageView roundImageView2 = (RoundImageView) findViewById(R.id.a2z);
        this.f82431h = roundImageView2;
        roundImageView2.setBorderColor(Color.parseColor("#c1c1c1"));
        this.f82431h.setBorderWidth(1);
        RoundImageView roundImageView3 = (RoundImageView) findViewById(R.id.f164541a30);
        this.f82432i = roundImageView3;
        roundImageView3.setBorderColor(Color.parseColor("#c1c1c1"));
        this.f82432i.setBorderWidth(1);
        this.f82430f.setVisibility(8);
        this.f82431h.setVisibility(8);
        this.f82432i.setVisibility(8);
        this.E.add(this.f82430f);
        this.E.add(this.f82431h);
        this.E.add(this.f82432i);
        this.C = (LinearLayout) findViewById(R.id.ly7);
        ImageView imageView = (ImageView) findViewById(R.id.ly6);
        this.D = imageView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int i3 = (ScreenUtil.SCREEN_WIDTH * 120) / 750;
        if (i3 > 0) {
            layoutParams.height = i3;
            this.D.setLayoutParams(layoutParams);
        }
        this.f82429e = (TextView) findViewById(R.id.f167045k82);
    }
}
