package com.tencent.mobileqq.guild.setting.member.oldmemberlist;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.member.oldmemberlist.a;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.mini.config.AppConst;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int H = Utils.n(115.0f, MobileQQ.sMobileQQ.getResources());
    private static final int I = Utils.n(64.0f, MobileQQ.sMobileQQ.getResources());
    public TextView C;
    public TextView D;
    public CheckBox E;
    public TextView F;
    private ImageView G;

    /* renamed from: d, reason: collision with root package name */
    private final a f234646d;

    /* renamed from: e, reason: collision with root package name */
    public View f234647e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f234648f;

    /* renamed from: h, reason: collision with root package name */
    public GuildUserAvatarView f234649h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f234650i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f234651m;

    public b(a aVar) {
        this.f234646d = aVar;
    }

    private void c() {
        CheckBox checkBox = this.E;
        if (checkBox != null && checkBox.isShown() && this.E.isEnabled()) {
            this.E.setChecked(!r0.isChecked());
        }
    }

    private boolean e(IGProUserInfo iGProUserInfo) {
        if (TextUtils.equals(ch.f(), iGProUserInfo.getTinyId()) || iGProUserInfo.getUserType() == 2) {
            return false;
        }
        if (!this.f234646d.g().p2() && !this.f234646d.g().F) {
            return false;
        }
        return true;
    }

    private void f(View view, a.C7903a c7903a) {
        if (this.f234646d.g().p2()) {
            if (c7903a.f234645b.getUserType() == 1) {
                this.C.setText(view.getResources().getString(R.string.f155951iw));
                this.C.setBackgroundColor(AppConst.COMPAT_STATUS_BAR_BACKGROUND_COLOR);
            } else {
                this.C.setText(view.getResources().getString(R.string.f156391k3));
                this.C.setBackgroundColor(-25856);
            }
        }
    }

    private void g(a.C7903a c7903a) {
        if (c7903a.f234645b.getUserOnlineState() == 1) {
            this.f234648f.setVisibility(0);
        } else {
            this.f234648f.setVisibility(8);
        }
    }

    private void h(View view, a.C7903a c7903a) {
        if (this.f234646d.g().p2()) {
            if (c7903a.f234645b.getUserType() == 2) {
                view.setTag(-3, 0);
            } else if (c7903a.f234645b.getRobotType() == 1) {
                k(view);
            } else {
                j(view);
            }
        } else if (this.f234646d.g().O1()) {
            if (c7903a.f234645b.getUserType() != 2) {
                k(view);
            } else {
                view.setTag(-3, 0);
            }
        } else {
            view.setTag(-3, 0);
        }
        if (this.f234646d.e().getCurrentUin().equals(c7903a.f234645b.getTinyId())) {
            view.setTag(-3, 0);
        }
    }

    private void i(int i3, a.C7903a c7903a, boolean z16) {
        if (this.f234646d.g().o2()) {
            this.E.setVisibility(0);
            boolean e16 = e(c7903a.f234645b);
            this.E.setEnabled(e16);
            this.f234647e.setEnabled(e16);
            if (e16) {
                this.E.setTag(Integer.valueOf(i3));
                this.E.setOnCheckedChangeListener(this);
                this.E.setChecked(z16);
                return;
            }
            this.E.setOnCheckedChangeListener(null);
            return;
        }
        this.E.setVisibility(8);
        this.f234647e.setEnabled(true);
        this.E.setOnCheckedChangeListener(null);
    }

    private void j(View view) {
        int i3 = H;
        int i16 = I;
        view.setTag(-3, Integer.valueOf(i3 + i16));
        this.C.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.D.getLayoutParams()).rightMargin = (-i16) - i3;
    }

    private void k(View view) {
        int i3 = I;
        view.setTag(-3, Integer.valueOf(i3));
        this.C.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.D.getLayoutParams()).rightMargin = -i3;
    }

    private void l(a.C7903a c7903a) {
        if (c7903a.f234645b.getRobotType() == 1) {
            this.G.setVisibility(0);
        } else {
            this.G.setVisibility(8);
        }
    }

    public void a(IGProUserInfo iGProUserInfo) {
        this.F.setVisibility(8);
    }

    public void b(int i3, String str, a.C7903a c7903a, boolean z16) {
        i(i3, c7903a, z16);
        h(this.f234647e, c7903a);
        f(this.f234647e, c7903a);
        g(c7903a);
        l(c7903a);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(bi.a(0.5f), this.f234650i.getResources().getColorStateList(R.color.qui_common_border_standard));
        this.f234650i.setBackground(gradientDrawable);
        this.f234649h.setAvatarTinyId(str, c7903a.f234645b.getTinyId());
        this.f234651m.setText(ch.d0(c7903a.f234645b));
        this.f234651m.setTag(c7903a);
        this.f234651m.setOnClickListener(this);
        a(c7903a.f234645b);
        this.C.setTag(c7903a);
        this.C.setOnClickListener(this);
        this.D.setTag(c7903a);
        this.D.setOnClickListener(this);
        this.f234647e.setTag(R.id.dq8, c7903a);
        this.f234647e.setOnClickListener(this);
    }

    public View d(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ezd, (ViewGroup) null);
        inflate.setTag(this);
        this.f234650i = (ImageView) inflate.findViewById(R.id.t1e);
        this.f234649h = (GuildUserAvatarView) inflate.findViewById(R.id.xsl);
        this.f234648f = (ImageView) inflate.findViewById(R.id.xwf);
        this.f234651m = (TextView) inflate.findViewById(R.id.xw7);
        this.C = (TextView) inflate.findViewById(R.id.xw_);
        this.D = (TextView) inflate.findViewById(R.id.xw6);
        this.E = (CheckBox) inflate.findViewById(R.id.f82074fw);
        this.F = (TextView) inflate.findViewById(R.id.xsy);
        this.G = (ImageView) inflate.findViewById(R.id.y8h);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(inflate, "em_sgrp_member_list_member_click", clickPolicy, exposurePolicy);
        ch.Y0(this.C, "em_sgrp_member_list_member_manage", clickPolicy, exposurePolicy);
        ch.Y0(this.D, "em_sgrp_member_list_member_manage_set", clickPolicy, exposurePolicy);
        ch.Y0(this.F, "em_sgrp_memberlist_otherapp_status", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
        this.f234647e = inflate;
        return inflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IGProUserInfo iGProUserInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f234646d.g().o2()) {
            c();
        } else {
            boolean z16 = true;
            int i3 = 1;
            if (view.getId() != R.id.dq8 && view.getId() != R.id.xw7 && view.getId() != R.id.xsl) {
                if (view.getId() == R.id.xw6) {
                    a.C7903a c7903a = (a.C7903a) view.getTag();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(c7903a.f234645b);
                    this.f234646d.j(arrayList);
                    HashMap hashMap = new HashMap();
                    hashMap.put("sgrp_member_op_result", 3);
                    VideoReport.reportEvent("clck", view, hashMap);
                } else if (view.getId() == R.id.xw_) {
                    a.C7903a c7903a2 = (a.C7903a) view.getTag();
                    this.f234646d.g().k2(c7903a2.f234645b);
                    HashMap hashMap2 = new HashMap();
                    IGProUserInfo iGProUserInfo2 = c7903a2.f234645b;
                    if (iGProUserInfo2 != null) {
                        if (iGProUserInfo2.getUserType() == 1) {
                            i3 = 2;
                        }
                        hashMap2.put("sgrp_member_op_result", Integer.valueOf(i3));
                        VideoReport.reportEvent("clck", this.f234647e.findViewById(R.id.xw6), hashMap2);
                    }
                }
            } else {
                a.C7903a c7903a3 = null;
                if (view.getId() == R.id.dq8) {
                    VideoReport.reportEvent("clck", view, null);
                    c7903a3 = (a.C7903a) view.getTag(R.id.dq8);
                } else {
                    View view2 = this.f234647e;
                    if (view2 != null) {
                        VideoReport.reportEvent("clck", view2, null);
                        c7903a3 = (a.C7903a) view.getTag();
                    }
                }
                if (c7903a3 != null && (iGProUserInfo = c7903a3.f234645b) != null) {
                    if (iGProUserInfo.getRobotType() != 1) {
                        z16 = false;
                    }
                    this.f234646d.k(c7903a3.f234645b, z16);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
    }
}
