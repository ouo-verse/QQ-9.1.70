package com.tencent.tuxmeterqui.question.option;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.biz.qui.profileskin.widget.QUIRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.adapter.SelectGridSpaceItemDecoration;
import com.tencent.tuxmeterqui.adapter.SelectOptionAdapter;
import com.tencent.tuxmeterqui.adapter.SelectVerticalOptionAdapter;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.model.SelectOptionModel;
import com.tencent.tuxmeterqui.question.option.TuxOptionCommonView;
import com.tencent.tuxmetersdk.model.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxOptionCheckBoxView extends TuxOptionCommonView {
    static IPatchRedirector $redirector_;

    public TuxOptionCheckBoxView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void drawMultiOptions(List<SelectOptionModel> list) {
        int i3 = this.lineItems;
        if (i3 <= 0 || i3 > 3) {
            i3 = 3;
        }
        this.selectRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), i3, 1, false));
        this.selectRecyclerView.addItemDecoration(new SelectGridSpaceItemDecoration(i3, TuxUIUtils.dpToPx(getContext(), 8), TuxUIUtils.dpToPx(getContext(), 10)));
        SelectOptionAdapter selectOptionAdapter = new SelectOptionAdapter(getContext(), list);
        this.selectRecyclerView.setAdapter(selectOptionAdapter);
        selectOptionAdapter.setOnItemClickListener(new SelectOptionAdapter.OnItemClickListener(list, selectOptionAdapter) { // from class: com.tencent.tuxmeterqui.question.option.TuxOptionCheckBoxView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ SelectOptionAdapter val$selectOptionAdapter;
            final /* synthetic */ List val$selectOptions;

            {
                this.val$selectOptions = list;
                this.val$selectOptionAdapter = selectOptionAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TuxOptionCheckBoxView.this, list, selectOptionAdapter);
                }
            }

            @Override // com.tencent.tuxmeterqui.adapter.SelectOptionAdapter.OnItemClickListener
            public void onItemClick(int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i16);
                    return;
                }
                Iterator it = this.val$selectOptions.iterator();
                int i17 = 0;
                while (it.hasNext()) {
                    if (((SelectOptionModel) it.next()).isSelect()) {
                        i17++;
                    }
                }
                SelectOptionModel selectOptionModel = (SelectOptionModel) this.val$selectOptions.get(i16);
                int i18 = TuxOptionCheckBoxView.this.maxSelect;
                if (i18 > 0 && i17 >= i18 && !selectOptionModel.isSelect()) {
                    TuxOptionCheckBoxView.this.questionWarning.setVisibility(0);
                    TuxOptionCheckBoxView.this.startGoneWarning();
                    return;
                }
                boolean z16 = !selectOptionModel.isSelect();
                ((SelectOptionModel) this.val$selectOptions.get(i16)).setSelect(z16);
                this.val$selectOptionAdapter.notifyItemChanged(i16);
                TuxOptionCheckBoxView.this.drawMultiExtraTextView((SelectOptionModel) this.val$selectOptions.get(i16));
                if (z16) {
                    TuxOptionCheckBoxView.this.lastSelectedOptions.add(selectOptionModel.getOption());
                } else {
                    TuxOptionCheckBoxView.this.lastSelectedOptions.remove(selectOptionModel.getOption());
                }
                TuxOptionCheckBoxView tuxOptionCheckBoxView = TuxOptionCheckBoxView.this;
                TuxOptionCommonView.OnOptionItemClickListener onOptionItemClickListener = tuxOptionCheckBoxView.clickListener;
                if (onOptionItemClickListener != null) {
                    onOptionItemClickListener.onItemClick(tuxOptionCheckBoxView.lastSelectedOptions);
                }
            }
        });
    }

    private void drawVerticalOptions(List<SelectOptionModel> list) {
        SelectVerticalOptionAdapter selectVerticalOptionAdapter = new SelectVerticalOptionAdapter(getContext(), list, false);
        this.selectRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.selectRecyclerView.setAdapter(selectVerticalOptionAdapter);
        selectVerticalOptionAdapter.setOnItemClickListener(new SelectVerticalOptionAdapter.OnItemClickListener(list, selectVerticalOptionAdapter) { // from class: com.tencent.tuxmeterqui.question.option.TuxOptionCheckBoxView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ List val$selectOptions;
            final /* synthetic */ SelectVerticalOptionAdapter val$selectVerticalOptionAdapter;

            {
                this.val$selectOptions = list;
                this.val$selectVerticalOptionAdapter = selectVerticalOptionAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TuxOptionCheckBoxView.this, list, selectVerticalOptionAdapter);
                }
            }

            @Override // com.tencent.tuxmeterqui.adapter.SelectVerticalOptionAdapter.OnItemClickListener
            public void onItemClick(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    return;
                }
                Iterator it = this.val$selectOptions.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    if (((SelectOptionModel) it.next()).isSelect()) {
                        i16++;
                    }
                }
                SelectOptionModel selectOptionModel = (SelectOptionModel) this.val$selectOptions.get(i3);
                int i17 = TuxOptionCheckBoxView.this.maxSelect;
                if (i17 > 0 && i16 >= i17 && !selectOptionModel.isSelect()) {
                    TuxOptionCheckBoxView.this.questionWarning.setVisibility(0);
                    TuxOptionCheckBoxView.this.startGoneWarning();
                    return;
                }
                boolean z16 = !selectOptionModel.isSelect();
                ((SelectOptionModel) this.val$selectOptions.get(i3)).setSelect(z16);
                this.val$selectVerticalOptionAdapter.notifyItemChanged(i3);
                TuxOptionCheckBoxView.this.drawMultiExtraTextView((SelectOptionModel) this.val$selectOptions.get(i3));
                if (z16) {
                    TuxOptionCheckBoxView.this.lastSelectedOptions.add(selectOptionModel.getOption());
                } else {
                    TuxOptionCheckBoxView.this.lastSelectedOptions.remove(selectOptionModel.getOption());
                }
                TuxOptionCheckBoxView tuxOptionCheckBoxView = TuxOptionCheckBoxView.this;
                TuxOptionCommonView.OnOptionItemClickListener onOptionItemClickListener = tuxOptionCheckBoxView.clickListener;
                if (onOptionItemClickListener != null) {
                    onOptionItemClickListener.onItemClick(tuxOptionCheckBoxView.lastSelectedOptions);
                }
            }
        });
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169163i20, (ViewGroup) this, true);
        this.questionRequired = (TextView) inflate.findViewById(R.id.f1044263_);
        this.questionTitle = (TextView) inflate.findViewById(R.id.f1044563c);
        this.questionDesc = (TextView) inflate.findViewById(R.id.f10441639);
        this.questionTips = (TextView) inflate.findViewById(R.id.f1044363a);
        this.questionWarning = (TextView) inflate.findViewById(R.id.f1044663d);
        this.selectRecyclerView = (QUIRecyclerView) inflate.findViewById(R.id.f10440638);
        this.extraEdittext = (EditText) inflate.findViewById(R.id.f10439637);
    }

    @Override // com.tencent.tuxmeterqui.question.option.TuxOptionCommonView
    protected void updateLayoutOrViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        boolean z16 = false;
        if (this.optionQuestion.isRequired()) {
            this.questionRequired.setVisibility(0);
        } else {
            this.questionRequired.setVisibility(8);
        }
        this.questionTitle.setText(this.optionQuestion.getTitle());
        if (TextUtils.isEmpty(this.optionQuestion.getDescription())) {
            this.questionDesc.setVisibility(8);
        } else {
            this.questionDesc.setVisibility(0);
            this.questionDesc.setText(this.optionQuestion.getDescription());
        }
        this.questionTips.setVisibility(8);
        this.questionWarning.setText(String.format(getResources().getString(R.string.f236927fo), this.maxSelect + ""));
        ArrayList arrayList = new ArrayList();
        List<Option> options = this.optionQuestion.getOptions();
        for (int i3 = 0; i3 < options.size(); i3++) {
            arrayList.add(new SelectOptionModel(options.get(i3)));
            if (options.get(i3).isAddBlank() && options.get(i3).getBlankConfig() != null) {
                this.hasExtraTextForMultiByOptionID = options.get(i3).getId();
            }
        }
        if (this.lineItems == 1) {
            z16 = true;
        }
        this.isVirtualLine = z16;
        if (z16) {
            drawVerticalOptions(arrayList);
        } else {
            drawMultiOptions(arrayList);
        }
    }

    public TuxOptionCheckBoxView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxOptionCheckBoxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            initView(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
