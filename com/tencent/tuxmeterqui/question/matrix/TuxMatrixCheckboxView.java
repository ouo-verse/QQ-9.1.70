package com.tencent.tuxmeterqui.question.matrix;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.SubTitle;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxMatrixCheckboxView extends TuxMatrixCommonView {
    private View matrixNoLine;
    private TextView matrixNoTips;
    private RelativeLayout matrixNoView;
    private RelativeLayout matrixQuestionView;
    private LinearLayout questionContainer;
    private LinearLayout titleContainer;

    public TuxMatrixCheckboxView(@NonNull Context context) {
        this(context, null);
    }

    private void drawMatrixStyle(List<SubTitle> list, List<Option> list2) {
        this.titleContainer.setVisibility(0);
        this.titleContainer.removeAllViews();
        this.questionContainer.removeAllViews();
        LayoutInflater from = LayoutInflater.from(getContext());
        Iterator<Option> it = list2.iterator();
        while (it.hasNext()) {
            this.titleContainer.addView(createTitleText(from, it.next().getText()));
        }
        for (SubTitle subTitle : list) {
            if (!isNoInSelectOption(subTitle.getId())) {
                TuxMatrixItemView tuxMatrixItemView = new TuxMatrixItemView(getContext());
                tuxMatrixItemView.updateView(subTitle, list2, this.maxSelect, this.resource);
                tuxMatrixItemView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                tuxMatrixItemView.setClickListener(new OnMatrixItemClickListener() { // from class: com.tencent.tuxmeterqui.question.matrix.TuxMatrixCheckboxView.2
                    @Override // com.tencent.tuxmeterqui.question.matrix.OnMatrixItemClickListener
                    public void onItemClick(SubTitle subTitle2, List<Option> list3) {
                        TuxMatrixCheckboxView.this.selectHashMap.put(subTitle2, list3);
                        OnMatrixItemClickListener onMatrixItemClickListener = TuxMatrixCheckboxView.this.clickListener;
                        if (onMatrixItemClickListener != null) {
                            onMatrixItemClickListener.onItemClick(subTitle2, list3);
                        }
                    }

                    @Override // com.tencent.tuxmeterqui.question.matrix.OnMatrixItemClickListener
                    public void onLimitClick(SubTitle subTitle2, int i3) {
                        TuxMatrixCheckboxView.this.questionWarning.setVisibility(0);
                        TuxMatrixCheckboxView.this.startGoneWarning();
                        OnMatrixItemClickListener onMatrixItemClickListener = TuxMatrixCheckboxView.this.clickListener;
                        if (onMatrixItemClickListener != null) {
                            onMatrixItemClickListener.onLimitClick(subTitle2, i3);
                        }
                    }
                });
                this.questionContainer.addView(tuxMatrixItemView);
            }
        }
    }

    private void drawNoView() {
        this.matrixQuestionView.setVisibility(8);
        this.matrixNoView.setVisibility(0);
        if (this.linkReferQuestionNumber > 0) {
            this.matrixNoTips.setText(String.format(getResources().getString(R.string.f236887fk), Integer.valueOf(this.linkReferQuestionNumber), Integer.valueOf(this.linkReferQuestionNumber)));
        }
    }

    private void drawOptionStyle(List<SubTitle> list, List<Option> list2) {
        this.titleContainer.setVisibility(8);
        this.titleContainer.removeAllViews();
        this.questionContainer.removeAllViews();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            SubTitle subTitle = list.get(i3);
            if (!isNoInSelectOption(subTitle.getId())) {
                TuxMatrixOptionItemView tuxMatrixOptionItemView = new TuxMatrixOptionItemView(getContext());
                tuxMatrixOptionItemView.updateView(subTitle, list2, this.maxSelect, this.resource);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i3 > 0) {
                    layoutParams.setMargins(0, TuxUIUtils.dpToPx(getContext(), 8), 0, 0);
                }
                tuxMatrixOptionItemView.setLayoutParams(layoutParams);
                tuxMatrixOptionItemView.setClickListener(new OnMatrixItemClickListener() { // from class: com.tencent.tuxmeterqui.question.matrix.TuxMatrixCheckboxView.1
                    @Override // com.tencent.tuxmeterqui.question.matrix.OnMatrixItemClickListener
                    public void onItemClick(SubTitle subTitle2, List<Option> list3) {
                        TuxMatrixCheckboxView.this.selectHashMap.put(subTitle2, list3);
                        OnMatrixItemClickListener onMatrixItemClickListener = TuxMatrixCheckboxView.this.clickListener;
                        if (onMatrixItemClickListener != null) {
                            onMatrixItemClickListener.onItemClick(subTitle2, list3);
                        }
                    }

                    @Override // com.tencent.tuxmeterqui.question.matrix.OnMatrixItemClickListener
                    public void onLimitClick(SubTitle subTitle2, int i16) {
                        TuxMatrixCheckboxView.this.questionWarning.setVisibility(0);
                        TuxMatrixCheckboxView.this.startGoneWarning();
                        OnMatrixItemClickListener onMatrixItemClickListener = TuxMatrixCheckboxView.this.clickListener;
                        if (onMatrixItemClickListener != null) {
                            onMatrixItemClickListener.onLimitClick(subTitle2, i16);
                        }
                    }
                });
                this.questionContainer.addView(tuxMatrixOptionItemView);
            }
        }
    }

    private void drawQuestionView() {
        this.matrixQuestionView.setVisibility(0);
        this.matrixNoView.setVisibility(8);
        List<SubTitle> subTitles = this.question.getSubTitles();
        List<Option> options = this.question.getOptions();
        if (subTitles != null && !subTitles.isEmpty() && options != null && !options.isEmpty()) {
            if (isOptionStyle()) {
                drawOptionStyle(subTitles, options);
            } else if (isMatrixStyle()) {
                drawMatrixStyle(subTitles, options);
            }
        }
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.i1y, (ViewGroup) this, true);
        this.questionRequired = (TextView) inflate.findViewById(R.id.f1044263_);
        this.questionTitle = (TextView) inflate.findViewById(R.id.f1044563c);
        this.questionDesc = (TextView) inflate.findViewById(R.id.f10441639);
        this.questionTips = (TextView) inflate.findViewById(R.id.f1044363a);
        this.questionWarning = (TextView) inflate.findViewById(R.id.f1044663d);
        this.titleContainer = (LinearLayout) inflate.findViewById(R.id.f1046863z);
        this.questionContainer = (LinearLayout) inflate.findViewById(R.id.f1046063r);
        this.matrixQuestionView = (RelativeLayout) inflate.findViewById(R.id.f1046163s);
        this.matrixNoView = (RelativeLayout) inflate.findViewById(R.id.f1045763o);
        this.matrixNoTips = (TextView) inflate.findViewById(R.id.f1045663n);
        this.matrixNoLine = inflate.findViewById(R.id.f1045563m);
    }

    @Override // com.tencent.tuxmeterqui.question.matrix.TuxMatrixCommonView
    protected void updateItemViews() {
        boolean hasReferQuestion = hasReferQuestion();
        boolean isEmpty = this.linkReferOptionSets.isEmpty();
        if (hasReferQuestion && isEmpty) {
            drawNoView();
        } else {
            drawQuestionView();
        }
    }

    @Override // com.tencent.tuxmeterqui.question.matrix.TuxMatrixCommonView
    protected void updateLayoutOrViews() {
        if (this.question.isRequired()) {
            this.questionRequired.setVisibility(0);
        } else {
            this.questionRequired.setVisibility(8);
        }
        this.questionTitle.setText(this.question.getTitle());
        if (TextUtils.isEmpty(this.question.getDescription())) {
            this.questionDesc.setVisibility(8);
        } else {
            this.questionDesc.setVisibility(0);
            this.questionDesc.setText(this.question.getDescription());
        }
        this.questionTips.setVisibility(8);
        this.questionWarning.setText(String.format(getResources().getString(R.string.f236927fo), this.maxSelect + ""));
        boolean hasReferQuestion = hasReferQuestion();
        boolean isEmpty = this.linkReferOptionSets.isEmpty();
        if (hasReferQuestion && isEmpty) {
            drawNoView();
        } else {
            drawQuestionView();
        }
    }

    public TuxMatrixCheckboxView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TuxMatrixCheckboxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView(context);
    }
}
