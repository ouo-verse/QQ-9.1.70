package com.tencent.tuxmeterqui.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.model.StarOptionModel;
import ie0.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TextStarOptionGridAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private GradientDrawable leavegd;
    private GradientDrawable selectgd;
    public List<StarOptionModel> starOptions;
    private int textColor;
    private int textWhiteColor;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class ViewHolder {
        static IPatchRedirector $redirector_;
        QUITextView numberItemId;
        QUITextView numberTitle;

        ViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ ViewHolder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }

    public TextStarOptionGridAdapter(Context context, List<StarOptionModel> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) list);
            return;
        }
        this.starOptions = list;
        this.selectgd = new GradientDrawable();
        int dpToPx = TuxUIUtils.dpToPx(context, 6);
        int g16 = a.f().g(context, R.color.qui_common_brand_standard, 1000);
        this.textColor = a.f().g(context, R.color.qui_common_text_primary, 1000);
        int g17 = a.f().g(context, R.color.qui_common_fill_standard_primary, 1000);
        this.textWhiteColor = a.f().g(context, R.color.qui_common_text_white, 1000);
        this.selectgd.setColor(g16);
        float f16 = dpToPx;
        this.selectgd.setCornerRadius(f16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.leavegd = gradientDrawable;
        gradientDrawable.setColor(g17);
        this.leavegd.setCornerRadius(f16);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.starOptions.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.starOptions.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i1r, (ViewGroup) null);
                viewHolder = new ViewHolder(null);
                viewHolder.numberTitle = (QUITextView) view.findViewById(R.id.f10473644);
                viewHolder.numberItemId = (QUITextView) view.findViewById(R.id.f10472643);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            StarOptionModel starOptionModel = this.starOptions.get(i3);
            if (starOptionModel.isSelect()) {
                viewHolder.numberTitle.setBackground(this.selectgd);
                viewHolder.numberTitle.setTextColor(this.textWhiteColor);
            } else {
                viewHolder.numberTitle.setBackground(this.leavegd);
                viewHolder.numberTitle.setTextColor(this.textColor);
            }
            viewHolder.numberTitle.setText(starOptionModel.getOption().getId());
            viewHolder.numberItemId.setText(starOptionModel.getOption().getId());
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
