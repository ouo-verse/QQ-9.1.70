package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.CellNegativeFeedback;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NegativeFeedbackAdapter extends BaseAdapter {
    private SelectionChangeListener changeListener;
    private int currentMode;
    private LayoutInflater inflater;
    private ArrayList<DataWithSelect> datas = new ArrayList<>();
    private int selectedCount = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class DataWithSelect {
        CellNegativeFeedback.negativeFbInfo info;
        boolean isSelected;

        public DataWithSelect(CellNegativeFeedback.negativeFbInfo negativefbinfo, boolean z16) {
            this.info = negativefbinfo;
            this.isSelected = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class GirdHolder {
        CheckBox checkBox;
        RelativeLayout itemRl;
        DataWithSelect selectData;
        TextView textView;

        GirdHolder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface SelectionChangeListener {
        void onSelectedChanged(int i3);
    }

    public NegativeFeedbackAdapter(Context context, SelectionChangeListener selectionChangeListener) {
        this.currentMode = 0;
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.changeListener = selectionChangeListener;
        this.currentMode = 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.datas.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public ArrayList<CellNegativeFeedback.negativeFbInfo> getSelectInfos() {
        ArrayList<DataWithSelect> arrayList = this.datas;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        ArrayList<CellNegativeFeedback.negativeFbInfo> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < this.datas.size(); i3++) {
            if (this.datas.get(i3).isSelected) {
                arrayList2.add(this.datas.get(i3).info);
            }
        }
        return arrayList2;
    }

    public void setData(ArrayList<CellNegativeFeedback.negativeFbInfo> arrayList, int i3) {
        this.selectedCount = 0;
        this.currentMode = i3;
        this.datas.clear();
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<CellNegativeFeedback.negativeFbInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            this.datas.add(new DataWithSelect(it.next(), false));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        final GirdHolder girdHolder;
        if (view == null) {
            view = this.inflater.inflate(com.qzone.adapter.feedcomponent.j.j(FSUploadConst.ERR_NO_LOGIN), (ViewGroup) null);
            girdHolder = new GirdHolder();
            girdHolder.itemRl = (RelativeLayout) view.findViewById(com.qzone.adapter.feedcomponent.j.O(2684));
            girdHolder.checkBox = (CheckBox) view.findViewById(com.qzone.adapter.feedcomponent.j.O(2681));
            girdHolder.textView = (TextView) view.findViewById(com.qzone.adapter.feedcomponent.j.O(2682));
            ArrayList<DataWithSelect> arrayList = this.datas;
            if (arrayList != null && arrayList.size() > 0) {
                girdHolder.selectData = this.datas.get(i3);
            }
            view.setTag(girdHolder);
        } else {
            girdHolder = (GirdHolder) view.getTag();
        }
        DataWithSelect dataWithSelect = girdHolder.selectData;
        if (dataWithSelect != null) {
            girdHolder.checkBox.setChecked(dataWithSelect.isSelected);
        }
        girdHolder.checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.NegativeFeedbackAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (view2 instanceof CheckBox) {
                    boolean isChecked = ((CheckBox) view2).isChecked();
                    if (isChecked) {
                        NegativeFeedbackAdapter.this.selectedCount++;
                    } else {
                        NegativeFeedbackAdapter negativeFeedbackAdapter = NegativeFeedbackAdapter.this;
                        negativeFeedbackAdapter.selectedCount--;
                    }
                    DataWithSelect dataWithSelect2 = girdHolder.selectData;
                    if (dataWithSelect2 != null) {
                        dataWithSelect2.isSelected = isChecked;
                    }
                    if (NegativeFeedbackAdapter.this.changeListener != null) {
                        NegativeFeedbackAdapter.this.changeListener.onSelectedChanged(NegativeFeedbackAdapter.this.selectedCount);
                    }
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        girdHolder.itemRl.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.NegativeFeedbackAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                Log.d("test", "holder.itemRl.setOnClickListener");
                if (view2 instanceof RelativeLayout) {
                    RelativeLayout relativeLayout = (RelativeLayout) view2;
                    if (relativeLayout.getChildCount() > 0 && (relativeLayout.getChildAt(0) instanceof CheckBox)) {
                        relativeLayout.getChildAt(0).performClick();
                    }
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        int i16 = this.currentMode;
        if (i16 == 1) {
            girdHolder.itemRl.setBackgroundColor(0);
            girdHolder.checkBox.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(827));
            girdHolder.textView.setTextColor(-16777216);
        } else if (i16 == 2) {
            girdHolder.itemRl.setBackgroundColor(-14211285);
            girdHolder.checkBox.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(828));
            girdHolder.textView.setTextColor(-8026747);
        }
        ArrayList<DataWithSelect> arrayList2 = this.datas;
        if (arrayList2 != null && arrayList2.size() > 0 && this.datas.get(i3) != null && this.datas.get(i3).info != null && !TextUtils.isEmpty(this.datas.get(i3).info.fb_tag_txt)) {
            girdHolder.textView.setText(this.datas.get(i3).info.fb_tag_txt);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}
