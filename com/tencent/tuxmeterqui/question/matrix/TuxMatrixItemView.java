package com.tencent.tuxmeterqui.question.matrix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.adapter.SelectMatrixGridAdapter;
import com.tencent.tuxmeterqui.model.SelectOptionModel;
import com.tencent.tuxmeterqui.view.ExpandableGridView;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Resource;
import com.tencent.tuxmetersdk.model.SubTitle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxMatrixItemView extends FrameLayout {
    private OnMatrixItemClickListener clickListener;
    private HashMap<String, String> componentParams;
    private ExpandableGridView expandableGridView;
    private TextView matrixItemTitle;
    private int maxSelect;
    private Resource resource;
    private List<Option> selectedOptions;
    private SubTitle subTitle;

    public TuxMatrixItemView(@NonNull Context context) {
        this(context, null);
    }

    private void drawMatrixView(List<SelectOptionModel> list) {
        boolean z16 = true;
        if (this.maxSelect != 1) {
            z16 = false;
        }
        SelectMatrixGridAdapter selectMatrixGridAdapter = new SelectMatrixGridAdapter(list, this.componentParams, z16);
        this.expandableGridView.setAdapter((ListAdapter) selectMatrixGridAdapter);
        if (z16) {
            onSingleSelectClick(list, selectMatrixGridAdapter);
        } else {
            onMultiSelectClick(list, selectMatrixGridAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Option> getSelectOption(List<SelectOptionModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (SelectOptionModel selectOptionModel : list) {
            if (selectOptionModel.isSelect()) {
                arrayList.add(selectOptionModel.getOption());
            }
        }
        return arrayList;
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.i1s, (ViewGroup) this, true);
        this.matrixItemTitle = (TextView) inflate.findViewById(R.id.f1045463l);
        this.expandableGridView = (ExpandableGridView) inflate.findViewById(R.id.f1045363k);
    }

    private void onMultiSelectClick(final List<SelectOptionModel> list, final SelectMatrixGridAdapter selectMatrixGridAdapter) {
        this.expandableGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.tuxmeterqui.question.matrix.TuxMatrixItemView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
                Iterator it = list.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    if (((SelectOptionModel) it.next()).isSelect()) {
                        i16++;
                    }
                }
                SelectOptionModel selectOptionModel = (SelectOptionModel) list.get(i3);
                if (TuxMatrixItemView.this.maxSelect > 0 && i16 >= TuxMatrixItemView.this.maxSelect && !selectOptionModel.isSelect()) {
                    if (TuxMatrixItemView.this.clickListener != null) {
                        TuxMatrixItemView.this.clickListener.onLimitClick(TuxMatrixItemView.this.subTitle, TuxMatrixItemView.this.maxSelect);
                    }
                } else {
                    ((SelectOptionModel) list.get(i3)).setSelect(!selectOptionModel.isSelect());
                    selectMatrixGridAdapter.notifyDataSetChanged();
                    if (TuxMatrixItemView.this.clickListener != null) {
                        TuxMatrixItemView tuxMatrixItemView = TuxMatrixItemView.this;
                        tuxMatrixItemView.selectedOptions = tuxMatrixItemView.getSelectOption(list);
                        TuxMatrixItemView.this.clickListener.onItemClick(TuxMatrixItemView.this.subTitle, TuxMatrixItemView.this.selectedOptions);
                    }
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
            }
        });
    }

    private void onSingleSelectClick(final List<SelectOptionModel> list, final SelectMatrixGridAdapter selectMatrixGridAdapter) {
        this.expandableGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.tuxmeterqui.question.matrix.TuxMatrixItemView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((SelectOptionModel) it.next()).setSelect(false);
                }
                ((SelectOptionModel) list.get(i3)).setSelect(true);
                selectMatrixGridAdapter.notifyDataSetChanged();
                if (TuxMatrixItemView.this.clickListener != null) {
                    TuxMatrixItemView tuxMatrixItemView = TuxMatrixItemView.this;
                    tuxMatrixItemView.selectedOptions = tuxMatrixItemView.getSelectOption(list);
                    TuxMatrixItemView.this.clickListener.onItemClick(TuxMatrixItemView.this.subTitle, TuxMatrixItemView.this.selectedOptions);
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
            }
        });
    }

    public void setClickListener(OnMatrixItemClickListener onMatrixItemClickListener) {
        this.clickListener = onMatrixItemClickListener;
    }

    public void updateView(SubTitle subTitle, List<Option> list, int i3, Resource resource) {
        if (subTitle != null && list != null && !list.isEmpty() && i3 > 0) {
            this.resource = resource;
            this.subTitle = subTitle;
            this.maxSelect = i3;
            if (resource != null) {
                this.componentParams = resource.getComponentParams();
            }
            this.matrixItemTitle.setText(subTitle.getText());
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < list.size(); i16++) {
                arrayList.add(new SelectOptionModel(list.get(i16)));
            }
            this.expandableGridView.setNumColumns(arrayList.size());
            drawMatrixView(arrayList);
        }
    }

    public TuxMatrixItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TuxMatrixItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.maxSelect = -1;
        initView(context);
    }
}
