package com.tencent.tuxmeterqui.question.star;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qui.profileskin.widget.QUIConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.adapter.StarOptionGridAdapter;
import com.tencent.tuxmeterqui.adapter.StarStarOptionGridAdapter;
import com.tencent.tuxmeterqui.config.TuxComponentParamsKey;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.model.StarOptionModel;
import com.tencent.tuxmetersdk.impl.utils.TuxQuestionUtils;
import com.tencent.tuxmetersdk.model.Option;
import ie0.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxStarStarView extends TuxStarCommonView {
    static IPatchRedirector $redirector_ = null;
    private static final int EMOJI_NUMBER = 5;
    private GridView emojiListView;
    private int lastPosition;
    private QUIConstraintLayout rootContainerView;
    private List<StarOptionModel> starOptions;

    public TuxStarStarView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void drawEmojiView(List<Option> list) {
        int size = list.size();
        if (size != 5) {
            return;
        }
        this.starOptions = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            this.starOptions.add(new StarOptionModel((Drawable) null, -1, list.get(i3)));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.emojiListView.getLayoutParams();
        marginLayoutParams.setMargins(0, TuxUIUtils.dpToPx(getContext(), 10), 0, 0);
        this.emojiListView.setLayoutParams(marginLayoutParams);
        this.emojiListView.setAdapter((ListAdapter) new StarOptionGridAdapter(getContext(), this.starOptions, this.questionConfig));
        this.emojiListView.setOnItemClickListener(new AdapterView.OnItemClickListener(size) { // from class: com.tencent.tuxmeterqui.question.star.TuxStarStarView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$size;

            {
                this.val$size = size;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxStarStarView.this, size);
                }
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i16, long j3) {
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i16, j3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i16), Long.valueOf(j3));
                } else if (TuxStarStarView.this.lastPosition != i16) {
                    TuxStarStarView.this.lastPosition = i16;
                    for (int i17 = 0; i17 < this.val$size; i17++) {
                        if (i17 != i16) {
                            ((StarOptionModel) TuxStarStarView.this.starOptions.get(i17)).setSelect(false);
                        } else {
                            ((StarOptionModel) TuxStarStarView.this.starOptions.get(i17)).setSelect(true);
                            TuxStarStarView tuxStarStarView = TuxStarStarView.this;
                            tuxStarStarView.selectOption = ((StarOptionModel) tuxStarStarView.starOptions.get(i17)).getOption();
                            ((StarOptionGridAdapter) TuxStarStarView.this.emojiListView.getAdapter()).notifyDataSetChanged();
                            TuxStarStarView tuxStarStarView2 = TuxStarStarView.this;
                            if (tuxStarStarView2.clickListener != null) {
                                tuxStarStarView2.updateQuestionRequired();
                                String addQueryParameterToUri = TuxUIUtils.addQueryParameterToUri(TuxStarStarView.this.resource.getUrlOfParam(), TuxStarCommonView.STAR_OPTION_ID, (i16 + 1) + "");
                                TuxStarStarView tuxStarStarView3 = TuxStarStarView.this;
                                tuxStarStarView3.clickListener.onItemClick(tuxStarStarView3.selectOption, addQueryParameterToUri);
                            }
                        }
                    }
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i16, j3);
            }
        });
    }

    private void drawStarView(List<Option> list) {
        int g16 = a.f().g(getContext(), R.color.qui_common_text_secondary, 1000);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int size = list.size();
            int i16 = R.drawable.ly7;
            if (i3 < size) {
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ly7);
                if (drawable != null) {
                    drawable.setColorFilter(g16, PorterDuff.Mode.SRC_IN);
                }
                arrayList.add(new StarOptionModel(drawable, g16, list.get(i3)));
                i3++;
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.emojiListView.getLayoutParams();
                marginLayoutParams.setMargins(0, TuxUIUtils.dpToPx(getContext(), 10), 0, 0);
                this.emojiListView.setLayoutParams(marginLayoutParams);
                this.emojiListView.setAdapter((ListAdapter) new StarStarOptionGridAdapter(arrayList));
                this.emojiListView.setOnItemClickListener(new AdapterView.OnItemClickListener(arrayList, i16, g16) { // from class: com.tencent.tuxmeterqui.question.star.TuxStarStarView.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$secondTextColor;
                    final /* synthetic */ int val$starImage;
                    final /* synthetic */ List val$starOptions;

                    {
                        this.val$starOptions = arrayList;
                        this.val$starImage = i16;
                        this.val$secondTextColor = g16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TuxStarStarView.this, arrayList, Integer.valueOf(i16), Integer.valueOf(g16));
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i17, long j3) {
                        EventCollector.getInstance().onItemClickBefore(adapterView, view, i17, j3);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i17), Long.valueOf(j3));
                        } else if (TuxStarStarView.this.lastPosition != i17) {
                            TuxStarStarView.this.lastPosition = i17;
                            for (int i18 = 0; i18 < this.val$starOptions.size(); i18++) {
                                ImageView imageView = (ImageView) adapterView.getChildAt(i18).findViewById(R.id.f1044763e);
                                if (i18 < i17) {
                                    imageView.setImageResource(R.drawable.ly7);
                                } else if (i18 > i17) {
                                    Drawable drawable2 = ContextCompat.getDrawable(TuxStarStarView.this.getContext(), this.val$starImage);
                                    if (drawable2 != null) {
                                        drawable2.setColorFilter(this.val$secondTextColor, PorterDuff.Mode.SRC_IN);
                                    }
                                    imageView.setImageDrawable(drawable2);
                                } else {
                                    imageView.setImageResource(R.drawable.ly7);
                                    TuxStarStarView.this.selectOption = ((StarOptionModel) adapterView.getItemAtPosition(i18)).getOption();
                                    TuxStarStarView tuxStarStarView = TuxStarStarView.this;
                                    if (tuxStarStarView.clickListener != null) {
                                        tuxStarStarView.updateQuestionRequired();
                                        String addQueryParameterToUri = TuxUIUtils.addQueryParameterToUri(TuxStarStarView.this.resource.getUrlOfParam(), TuxStarCommonView.STAR_OPTION_ID, (i17 + 1) + "");
                                        TuxStarStarView tuxStarStarView2 = TuxStarStarView.this;
                                        tuxStarStarView2.clickListener.onItemClick(tuxStarStarView2.selectOption, addQueryParameterToUri);
                                    }
                                }
                            }
                        }
                        EventCollector.getInstance().onItemClick(adapterView, view, i17, j3);
                    }
                });
                return;
            }
        }
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169166i23, (ViewGroup) this, true);
        this.rootContainerView = (QUIConstraintLayout) inflate.findViewById(R.id.f1049164l);
        this.questionRequired = (TextView) inflate.findViewById(R.id.f1044263_);
        this.questionTitle = (TextView) inflate.findViewById(R.id.f1044563c);
        this.questionDesc = (TextView) inflate.findViewById(R.id.f10441639);
        this.emojiListView = (GridView) inflate.findViewById(R.id.f1045063h);
    }

    private String parseRenderStyleWithEmojiDefault() {
        String parseStarRenderStyle = TuxQuestionUtils.parseStarRenderStyle(this.starQuestion);
        if (TextUtils.isEmpty(parseStarRenderStyle)) {
            return "emoji";
        }
        return parseStarRenderStyle;
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
                        ((StarOptionGridAdapter) this.emojiListView.getAdapter()).notifyDataSetChanged();
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
        TuxQuestionConfig.TuxUIConfig tuxUIConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String str = this.componentParams.get(TuxComponentParamsKey.STAR_OPTION_TYPE);
        if (!TuxQuestionUtils.checkIsStarStarStyle(str)) {
            str = parseRenderStyleWithEmojiDefault();
        }
        if (TuxQuestionUtils.checkIsStarStarStyle(str)) {
            TuxQuestionConfig tuxQuestionConfig = this.questionConfig;
            if (tuxQuestionConfig != null && (tuxUIConfig = tuxQuestionConfig.uiConfig) != null) {
                float f16 = tuxUIConfig.titleTextSizeSp;
                if (f16 > 0.0f) {
                    this.questionTitle.setTextSize(f16);
                }
                if (tuxUIConfig.titleTextColor != -1) {
                    this.questionTitle.setTextColor(getContext().getResources().getColorStateList(tuxUIConfig.titleTextColor));
                }
                int i3 = tuxUIConfig.titleTypeface;
                if (i3 != 1) {
                    this.questionTitle.setTypeface(null, i3);
                }
                RectF rectF = tuxUIConfig.padding;
                if (rectF != null) {
                    this.rootContainerView.setPadding(TuxUIUtils.dpToPx(getContext(), (int) rectF.left), TuxUIUtils.dpToPx(getContext(), (int) rectF.top), TuxUIUtils.dpToPx(getContext(), (int) rectF.right), TuxUIUtils.dpToPx(getContext(), (int) rectF.bottom));
                }
            }
            updateQuestionRequired();
            this.questionTitle.setText(this.starQuestion.getTitle());
            if (TextUtils.isEmpty(this.starQuestion.getDescription())) {
                this.questionDesc.setVisibility(8);
            } else {
                this.questionDesc.setVisibility(0);
                this.questionDesc.setText(this.starQuestion.getDescription());
            }
            List<Option> options = this.starQuestion.getOptions();
            int size = options.size();
            if ("emoji".equals(str) && size == 5) {
                drawEmojiView(options);
                return;
            } else {
                if ("star".equals(str)) {
                    drawStarView(options);
                    return;
                }
                return;
            }
        }
        setVisibility(8);
    }

    public TuxStarStarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxStarStarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
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
