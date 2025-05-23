package com.tencent.tuxmeterqui.question.matrix;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.tuxmeterqui.config.TuxComponentParamsKey;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.question.ITuxQuestionView;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import com.tencent.tuxmetersdk.model.Group;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;
import com.tencent.tuxmetersdk.model.SubTitle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class TuxMatrixCommonView extends FrameLayout implements ITuxQuestionView {
    protected static final int WARNING_GONE_TIME = 1500;
    protected OnMatrixItemClickListener clickListener;
    protected HashMap<String, String> componentParams;
    protected final Handler handler;
    protected Set<String> linkReferOptionSets;
    protected List<Option> linkReferOptions;
    protected int linkReferQuestionNumber;
    protected String matrixDisplayStyle;
    protected int maxSelect;
    protected final Runnable optionWarningGoneRunnable;
    protected Question question;
    protected TextView questionDesc;
    protected TextView questionRequired;
    protected TextView questionTips;
    protected TextView questionTitle;
    protected TextView questionWarning;
    protected Resource resource;
    protected Map<SubTitle, List<Option>> selectHashMap;
    protected int tempQuestionNumber;

    public TuxMatrixCommonView(@NonNull Context context) {
        this(context, null);
    }

    private int getForceMax(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private boolean isStyleEnable(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.equals("option") && !str.equals("matrix")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView createTitleText(LayoutInflater layoutInflater, String str) {
        TextView textView = (TextView) layoutInflater.inflate(R.layout.i1u, (ViewGroup) null, false);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        textView.setText(str);
        textView.setGravity(17);
        return textView;
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public Question getQuestion() {
        return this.question;
    }

    public int getQuestionNumber() {
        return this.tempQuestionNumber;
    }

    public List<Group> getSelectedGroups() {
        List<Option> list;
        ArrayList arrayList = new ArrayList();
        Question question = this.question;
        if (question != null && question.getSubTitles() != null) {
            for (SubTitle subTitle : this.question.getSubTitles()) {
                if (this.selectHashMap.containsKey(subTitle) && (list = this.selectHashMap.get(subTitle)) != null && !list.isEmpty()) {
                    Group group = new Group();
                    group.setId(subTitle.getId());
                    group.setText(subTitle.getText());
                    group.setOptions(new ArrayList(list));
                    arrayList.add(group);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public boolean hasAnsweredInRequired() {
        List<SubTitle> subTitles;
        List<Option> list;
        Question question = this.question;
        if (question == null || !question.isRequired() || (subTitles = this.question.getSubTitles()) == null) {
            return true;
        }
        for (SubTitle subTitle : subTitles) {
            if (this.selectHashMap.containsKey(subTitle) && ((list = this.selectHashMap.get(subTitle)) == null || list.isEmpty())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasReferQuestion() {
        if (this.question == null) {
            return false;
        }
        return !TextUtils.isEmpty(r0.getRefer());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isMatrixStyle() {
        if (TextUtils.isEmpty(this.matrixDisplayStyle)) {
            return false;
        }
        return this.matrixDisplayStyle.equals("matrix");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNoInSelectOption(String str) {
        if (!this.linkReferOptionSets.isEmpty() && this.linkReferQuestionNumber >= 0) {
            return !this.linkReferOptionSets.contains(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isOptionStyle() {
        if (TextUtils.isEmpty(this.matrixDisplayStyle)) {
            return true;
        }
        return this.matrixDisplayStyle.equals("option");
    }

    protected void parseRenderStyle() {
        try {
            String style = this.question.getStyle();
            if (!TextUtils.isEmpty(style)) {
                JSONObject jSONObject = new JSONObject(style);
                this.matrixDisplayStyle = jSONObject.optString(TuxQuestionType.MATRIX_DISPLAY_STYLE, "option");
                this.maxSelect = jSONObject.optInt("max", -1);
            }
        } catch (Exception unused) {
        }
        try {
            String str = this.componentParams.get(TuxComponentParamsKey.MATRIX_DISPLAY_TYPE);
            if (isStyleEnable(str)) {
                this.matrixDisplayStyle = str;
            }
            int forceMax = getForceMax(this.componentParams.get(TuxComponentParamsKey.OPTION_TYPE_MAX));
            if (forceMax > 0) {
                this.maxSelect = forceMax;
            }
        } catch (Exception unused2) {
        }
        if (!isStyleEnable(this.matrixDisplayStyle)) {
            this.matrixDisplayStyle = "option";
        }
        if (this.maxSelect == -1) {
            this.maxSelect = this.question.getOptionMaxCut();
        }
    }

    public void setClickListener(OnMatrixItemClickListener onMatrixItemClickListener) {
        this.clickListener = onMatrixItemClickListener;
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void setViewVisibility(boolean z16) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startGoneWarning() {
        this.handler.removeCallbacks(this.optionWarningGoneRunnable);
        this.handler.postDelayed(this.optionWarningGoneRunnable, 1500L);
    }

    protected abstract void updateItemViews();

    protected abstract void updateLayoutOrViews();

    public void updateLinkReferInfo(int i3, List<Option> list) {
        this.linkReferQuestionNumber = i3;
        this.linkReferOptions = list;
        this.linkReferOptionSets.clear();
        this.selectHashMap.clear();
        if (list != null) {
            Iterator<Option> it = list.iterator();
            while (it.hasNext()) {
                this.linkReferOptionSets.add(it.next().getId());
            }
        }
        updateItemViews();
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateView(Question question, Resource resource, TuxQuestionConfig tuxQuestionConfig) {
        this.question = question;
        setTag(question);
        this.resource = resource;
        if (resource != null) {
            this.componentParams = resource.getComponentParams();
        }
        if (this.question != null) {
            parseRenderStyle();
            updateLayoutOrViews();
        }
    }

    public TuxMatrixCommonView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TuxMatrixCommonView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.handler = new Handler();
        this.maxSelect = -1;
        this.selectHashMap = new HashMap();
        this.optionWarningGoneRunnable = new Runnable() { // from class: com.tencent.tuxmeterqui.question.matrix.TuxMatrixCommonView.1
            @Override // java.lang.Runnable
            public void run() {
                TextView textView = TuxMatrixCommonView.this.questionWarning;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
        };
        this.linkReferOptionSets = new HashSet();
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateQuestionNumber(int i3) {
    }
}
