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
import com.tencent.tuxmeterqui.adapter.SelectOptionGridAdapter;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
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
public class TuxMatrixOptionItemView extends FrameLayout {
    public static final int MATRIX_OPTION_MAX_LINES = 3;
    private OnMatrixItemClickListener clickListener;
    private HashMap<String, String> componentParams;
    private TextView matrixItemTitle;
    private int maxSelect;
    private Resource resource;
    private ExpandableGridView selectGridView;
    private List<Option> selectedOptions;
    private SubTitle subTitle;

    public TuxMatrixOptionItemView(@NonNull Context context) {
        this(context, null);
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.i1t, (ViewGroup) this, true);
        this.matrixItemTitle = (TextView) inflate.findViewById(R.id.f1045963q);
        this.selectGridView = (ExpandableGridView) inflate.findViewById(R.id.f1045863p);
    }

    private void onMultiSelectClick(final List<SelectOptionModel> list, final SelectOptionGridAdapter selectOptionGridAdapter) {
        this.selectGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.tuxmeterqui.question.matrix.TuxMatrixOptionItemView.2
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
                if (i16 >= TuxMatrixOptionItemView.this.maxSelect && !selectOptionModel.isSelect()) {
                    if (TuxMatrixOptionItemView.this.clickListener != null) {
                        TuxMatrixOptionItemView.this.clickListener.onLimitClick(TuxMatrixOptionItemView.this.subTitle, TuxMatrixOptionItemView.this.maxSelect);
                    }
                } else {
                    ((SelectOptionModel) list.get(i3)).setSelect(!selectOptionModel.isSelect());
                    selectOptionGridAdapter.notifyDataSetChanged();
                    if (TuxMatrixOptionItemView.this.clickListener != null) {
                        TuxMatrixOptionItemView tuxMatrixOptionItemView = TuxMatrixOptionItemView.this;
                        tuxMatrixOptionItemView.selectedOptions = tuxMatrixOptionItemView.getSelectOption(list);
                        TuxMatrixOptionItemView.this.clickListener.onItemClick(TuxMatrixOptionItemView.this.subTitle, TuxMatrixOptionItemView.this.selectedOptions);
                    }
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
            }
        });
    }

    private void onSingleSelectClick(final List<SelectOptionModel> list, final SelectOptionGridAdapter selectOptionGridAdapter) {
        this.selectGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.tuxmeterqui.question.matrix.TuxMatrixOptionItemView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((SelectOptionModel) it.next()).setSelect(false);
                }
                ((SelectOptionModel) list.get(i3)).setSelect(true);
                selectOptionGridAdapter.notifyDataSetChanged();
                if (TuxMatrixOptionItemView.this.clickListener != null) {
                    TuxMatrixOptionItemView tuxMatrixOptionItemView = TuxMatrixOptionItemView.this;
                    tuxMatrixOptionItemView.selectedOptions = tuxMatrixOptionItemView.getSelectOption(list);
                    TuxMatrixOptionItemView.this.clickListener.onItemClick(TuxMatrixOptionItemView.this.subTitle, TuxMatrixOptionItemView.this.selectedOptions);
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
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            if (resource != null) {
                this.componentParams = resource.getComponentParams();
            }
            this.selectGridView.setNumColumns(3);
            this.matrixItemTitle.setText(subTitle.getText());
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < list.size(); i16++) {
                arrayList.add(new SelectOptionModel(list.get(i16)));
            }
            this.selectGridView.setVerticalSpacing(TuxUIUtils.dpToPx(getContext(), 8));
            SelectOptionGridAdapter selectOptionGridAdapter = new SelectOptionGridAdapter(getContext(), arrayList, this.componentParams);
            this.selectGridView.setAdapter((ListAdapter) selectOptionGridAdapter);
            if (z16) {
                onSingleSelectClick(arrayList, selectOptionGridAdapter);
            } else {
                onMultiSelectClick(arrayList, selectOptionGridAdapter);
            }
        }
    }

    public TuxMatrixOptionItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TuxMatrixOptionItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView(context);
    }
}
