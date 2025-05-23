package com.tencent.tuxmeterqui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qui.profileskin.widget.QUIImageView;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.model.StarOptionModel;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StarStarOptionGridAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    public List<StarOptionModel> starOptions;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class ViewHolder {
        static IPatchRedirector $redirector_;
        QUIImageView emojiImage;
        QUITextView emojiItemId;
        QUITextView emojiName;

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

    public StarStarOptionGridAdapter(List<StarOptionModel> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.starOptions = list;
        }
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i1q, (ViewGroup) null);
                viewHolder = new ViewHolder(null);
                viewHolder.emojiImage = (QUIImageView) view.findViewById(R.id.f1044763e);
                viewHolder.emojiName = (QUITextView) view.findViewById(R.id.f1045163i);
                viewHolder.emojiItemId = (QUITextView) view.findViewById(R.id.f1044863f);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            StarOptionModel starOptionModel = this.starOptions.get(i3);
            viewHolder.emojiImage.setImageDrawable(starOptionModel.getImage());
            viewHolder.emojiName.setText(starOptionModel.getOption().getText());
            viewHolder.emojiName.setTextColor(starOptionModel.getTextColor());
            viewHolder.emojiItemId.setText(starOptionModel.getOption().getId());
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
