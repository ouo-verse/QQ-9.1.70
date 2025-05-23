package com.tencent.tuxmeterqui.question.star;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.adapter.TextStarOptionGridAdapter;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.model.StarOptionModel;
import com.tencent.tuxmetersdk.model.Option;
import ie0.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxStarTextViewView extends TuxStarCommonView {
    static IPatchRedirector $redirector_;
    private TextView centerText;
    private int lastPosition;
    private TextView leftText;
    private TextView rightText;
    private View starAnchorView;
    private List<StarOptionModel> starOptions;
    private GridView textListView;

    public TuxStarTextViewView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void drawTextView(List<Option> list) {
        String str;
        GradientDrawable gradientDrawable = new GradientDrawable();
        int dpToPx = TuxUIUtils.dpToPx(getContext(), 6);
        int g16 = a.f().g(getContext(), R.color.qui_common_brand_standard, 1000);
        a.f().g(getContext(), R.color.qui_common_text_secondary, 1000);
        int g17 = a.f().g(getContext(), R.color.qui_common_text_primary, 1000);
        int g18 = a.f().g(getContext(), R.color.qui_common_fill_standard_primary, 1000);
        a.f().g(getContext(), R.color.qui_common_text_white, 1000);
        gradientDrawable.setColor(g16);
        float f16 = dpToPx;
        gradientDrawable.setCornerRadius(f16);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(g18);
        gradientDrawable2.setCornerRadius(f16);
        this.starOptions = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.starOptions.add(new StarOptionModel(gradientDrawable2, g17, list.get(i3)));
        }
        int size = this.starOptions.size();
        if (size >= 2) {
            this.starAnchorView.setVisibility(0);
            this.leftText.setText(this.starOptions.get(0).getOption().getText());
            int i16 = size - 1;
            this.rightText.setText(this.starOptions.get(i16).getOption().getText());
            int i17 = 0;
            while (true) {
                if (i17 < size) {
                    if (i17 > 0 && i17 < i16) {
                        String id5 = this.starOptions.get(i17).getOption().getId();
                        str = this.starOptions.get(i17).getOption().getText();
                        if (!TextUtils.isEmpty(str) && !str.equals(id5)) {
                            break;
                        }
                    }
                    i17++;
                } else {
                    str = "";
                    break;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                this.centerText.setVisibility(0);
                this.centerText.setText(str);
            } else {
                this.centerText.setVisibility(8);
            }
        } else {
            this.starAnchorView.setVisibility(8);
        }
        this.textListView.setNumColumns(this.starOptions.size());
        this.textListView.setAdapter((ListAdapter) new TextStarOptionGridAdapter(getContext(), this.starOptions));
        this.textListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.tuxmeterqui.question.star.TuxStarTextViewView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxStarTextViewView.this);
                }
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i18, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i18, j3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i18), Long.valueOf(j3));
                } else if (TuxStarTextViewView.this.lastPosition != i18) {
                    TuxStarTextViewView.this.lastPosition = i18;
                    for (int i19 = 0; i19 < TuxStarTextViewView.this.starOptions.size(); i19++) {
                        if (i19 != i18) {
                            ((StarOptionModel) TuxStarTextViewView.this.starOptions.get(i19)).setSelect(false);
                        } else {
                            ((StarOptionModel) TuxStarTextViewView.this.starOptions.get(i19)).setSelect(true);
                            TuxStarTextViewView tuxStarTextViewView = TuxStarTextViewView.this;
                            tuxStarTextViewView.selectOption = ((StarOptionModel) tuxStarTextViewView.starOptions.get(i19)).getOption();
                            ((TextStarOptionGridAdapter) TuxStarTextViewView.this.textListView.getAdapter()).notifyDataSetChanged();
                            TuxStarTextViewView tuxStarTextViewView2 = TuxStarTextViewView.this;
                            if (tuxStarTextViewView2.clickListener != null) {
                                tuxStarTextViewView2.updateQuestionRequired();
                                String addQueryParameterToUri = TuxUIUtils.addQueryParameterToUri(TuxStarTextViewView.this.resource.getUrlOfParam(), TuxStarCommonView.STAR_OPTION_ID, (i18 + 1) + "");
                                TuxStarTextViewView tuxStarTextViewView3 = TuxStarTextViewView.this;
                                tuxStarTextViewView3.clickListener.onItemClick(tuxStarTextViewView3.selectOption, addQueryParameterToUri);
                            }
                        }
                    }
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i18, j3);
            }
        });
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169167i24, (ViewGroup) this, true);
        this.questionRequired = (TextView) inflate.findViewById(R.id.f1044263_);
        this.questionTitle = (TextView) inflate.findViewById(R.id.f1044563c);
        this.questionDesc = (TextView) inflate.findViewById(R.id.f10441639);
        this.textListView = (GridView) inflate.findViewById(R.id.f1049464o);
        this.starAnchorView = inflate.findViewById(R.id.f1049364n);
        this.leftText = (TextView) inflate.findViewById(R.id.f1045263j);
        this.centerText = (TextView) inflate.findViewById(R.id.f10438636);
        this.rightText = (TextView) inflate.findViewById(R.id.f10477648);
    }

    @Override // com.tencent.tuxmeterqui.question.star.TuxStarCommonView
    public void mockQuestionSelect(Option option) {
        List<StarOptionModel> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) option);
            return;
        }
        if (option != null && (list = this.starOptions) != null) {
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (this.starOptions.get(i3).getOption().getId().equals(option.getId())) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                this.lastPosition = i3;
                for (int i16 = 0; i16 < this.starOptions.size(); i16++) {
                    if (i16 != i3) {
                        this.starOptions.get(i16).setSelect(false);
                    } else {
                        this.starOptions.get(i16).setSelect(true);
                        this.selectOption = this.starOptions.get(i16).getOption();
                        ((TextStarOptionGridAdapter) this.textListView.getAdapter()).notifyDataSetChanged();
                        if (this.clickListener != null) {
                            updateQuestionRequired();
                            this.clickListener.onItemClick(this.selectOption, TuxUIUtils.addQueryParameterToUri(this.resource.getUrlOfParam(), TuxStarCommonView.STAR_OPTION_ID, (i3 + 1) + ""));
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.tuxmeterqui.question.star.TuxStarCommonView
    protected void updateLayoutOrViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        updateQuestionRequired();
        this.questionTitle.setText(this.starQuestion.getTitle());
        if (TextUtils.isEmpty(this.starQuestion.getDescription())) {
            this.questionDesc.setVisibility(8);
        } else {
            this.questionDesc.setVisibility(0);
            this.questionDesc.setText(this.starQuestion.getDescription());
        }
        drawTextView(this.starQuestion.getOptions());
    }

    public TuxStarTextViewView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxStarTextViewView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.lastPosition = -1;
            initView(context);
        }
    }
}
