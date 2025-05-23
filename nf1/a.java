package nf1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.RoundRectImageView;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
    public RoundRectImageView E;
    public TextView F;
    public TextView G;
    public ImageView H;
    public ShadowFrameLayout I;
    public IGProAppInfo J;
    b K;

    public a(View view, b bVar) {
        super(view);
        this.K = bVar;
        this.E = (RoundRectImageView) view.findViewById(R.id.f164379vi);
        this.F = (TextView) view.findViewById(R.id.stq);
        this.G = (TextView) view.findViewById(R.id.stf);
        this.H = (ImageView) view.findViewById(R.id.sts);
        this.I = (ShadowFrameLayout) view.findViewById(R.id.stc);
        ch.Y0(view, "em_sgrp_select_sub_channel", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }

    @RequiresApi(api = 21)
    public void l(IGProAppInfo iGProAppInfo) {
        this.J = iGProAppInfo;
        this.E.setCornerRadiusAndMode(ViewUtils.dpToPx(9.0f), 1);
        if (TextUtils.isEmpty(this.J.getIconUrl())) {
            this.E.setImageDrawable(null);
        } else {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = ViewUtils.dip2px(52.0f);
            obtain.mRequestHeight = ViewUtils.dip2px(52.0f);
            this.E.setImageDrawable(URLDrawable.getDrawable(this.J.getIconUrl(), obtain));
        }
        if (GuildThemeManager.f235286a.b()) {
            this.E.setForeground(new ColorDrawable(Color.parseColor("#19000000")));
        } else {
            this.E.setForeground(null);
        }
        if (!TextUtils.isEmpty(this.J.getAppName())) {
            this.F.setText(this.J.getAppName());
        } else {
            this.F.setText("");
        }
        if (!TextUtils.isEmpty(this.J.getAppDescription())) {
            this.G.setText(this.J.getAppDescription());
        } else {
            this.G.setText("");
        }
        ShadowFrameLayout shadowFrameLayout = this.I;
        shadowFrameLayout.setShadowColor(shadowFrameLayout.getResources().getColorStateList(R.color.guild_skin_card_bg_shadow));
        this.H.setOnClickListener(this);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        qf1.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == this.itemView.getId()) {
            b bVar2 = this.K;
            if (bVar2 != null && bVar2.D != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("sgrp_sub_appchannel_id", Long.valueOf(this.J.getAppId()));
                VideoReport.reportEvent("clck", this.itemView, hashMap);
                this.K.D.Ha(this.J);
            }
        } else if (id5 == R.id.sts && (bVar = this.K) != null && (aVar = bVar.D) != null) {
            aVar.Sg(this.J);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
