package com.tencent.tuxmeterqui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.model.SelectOptionModel;
import ie0.a;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SelectOptionGridAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private final int primaryColor;
    private final String selectOptionItemCopy;
    private final List<SelectOptionModel> selectOptions;
    private final int textColor;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class ViewHolder {
        static IPatchRedirector $redirector_;
        QUITextView optionID;
        QUITextView optionName;
        QUITextView optionNameCopy;

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

    public SelectOptionGridAdapter(Context context, List<SelectOptionModel> list, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, hashMap);
            return;
        }
        this.selectOptions = list;
        this.selectOptionItemCopy = pickLongestEvery(list);
        this.primaryColor = a.f().g(context, R.color.qui_common_brand_standard, 1000);
        this.textColor = a.f().g(context, R.color.qui_common_text_primary, 1000);
    }

    private static String pickLongestEvery(List<SelectOptionModel> list) {
        int size = list.size();
        String str = "";
        for (int i3 = 0; i3 < size; i3++) {
            String text = list.get(i3).getOption().getText();
            if (text.getBytes().length > str.getBytes().length) {
                str = text;
            }
        }
        return str;
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i26, (ViewGroup) null);
                viewHolder = new ViewHolder(null);
                viewHolder.optionName = (QUITextView) view.findViewById(R.id.f10478649);
                viewHolder.optionID = (QUITextView) view.findViewById(R.id.f1048464e);
                viewHolder.optionNameCopy = (QUITextView) view.findViewById(R.id.f1048164b);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SelectOptionModel selectOptionModel = this.selectOptions.get(i3);
            viewHolder.optionID.setText(selectOptionModel.getOption().getId());
            viewHolder.optionName.setText(selectOptionModel.getOption().getText());
            viewHolder.optionNameCopy.setText(this.selectOptionItemCopy);
            if (selectOptionModel.isSelect()) {
                viewHolder.optionName.setBackgroundResource(R.drawable.lxv);
                viewHolder.optionName.setTextColor(this.primaryColor);
            } else {
                viewHolder.optionName.setBackgroundResource(R.drawable.lxy);
                viewHolder.optionName.setTextColor(this.textColor);
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }
}
