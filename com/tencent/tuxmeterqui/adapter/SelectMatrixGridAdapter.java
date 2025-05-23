package com.tencent.tuxmeterqui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.model.SelectOptionModel;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SelectMatrixGridAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private final HashMap<String, String> componentParams;
    private final boolean isSingle;
    private final List<SelectOptionModel> selectOptions;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class ViewHolder {
        static IPatchRedirector $redirector_;
        CheckBox checkBox;
        TextView optionID;
        FrameLayout selectCheckboxView;

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

    public SelectMatrixGridAdapter(List<SelectOptionModel> list, HashMap<String, String> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, hashMap, Boolean.valueOf(z16));
            return;
        }
        this.selectOptions = list;
        this.componentParams = hashMap;
        this.isSingle = z16;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.selectOptions.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.selectOptions.get(i3);
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i28, (ViewGroup) null);
                viewHolder = new ViewHolder(null);
                viewHolder.optionID = (TextView) view.findViewById(R.id.f1048464e);
                viewHolder.selectCheckboxView = (FrameLayout) view.findViewById(R.id.f1048064a);
                viewHolder.checkBox = (CheckBox) view.findViewById(R.id.f1047964_);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (this.isSingle) {
                viewHolder.checkBox.setButtonDrawable(R.drawable.lya);
            } else {
                viewHolder.checkBox.setButtonDrawable(R.drawable.lxq);
            }
            SelectOptionModel selectOptionModel = this.selectOptions.get(i3);
            viewHolder.optionID.setText(selectOptionModel.getOption().getId());
            if (selectOptionModel.isSelect()) {
                viewHolder.checkBox.setChecked(true);
            } else {
                viewHolder.checkBox.setChecked(false);
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
