package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.util.z;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HotWordTipsContainer extends LinearLayout implements View.OnClickListener {
    private RelativeLayout C;
    private LinearLayout D;
    private View E;
    private TextView F;
    private TextView G;

    /* renamed from: d, reason: collision with root package name */
    private final String f97696d;

    /* renamed from: e, reason: collision with root package name */
    private final String f97697e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f97698f;

    /* renamed from: h, reason: collision with root package name */
    a f97699h;

    /* renamed from: i, reason: collision with root package name */
    private HotWordSearchEntryDataModel f97700i;

    /* renamed from: m, reason: collision with root package name */
    protected Context f97701m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem);
    }

    public HotWordTipsContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f97696d = QCircleSkinHelper.SKIN_DEFAULT_MODE_TAG;
        this.f97697e = QCircleSkinHelper.SKIN_DARK_MODE_TAG;
        this.f97698f = new String[]{"https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_1@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_2@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_3@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_4@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_5@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_6@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_7@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_8@3x.png"};
        this.f97700i = null;
        this.f97701m = context;
        setOrientation(1);
    }

    private void a(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        if (this.D != null && hotSearchItem != null && !TextUtils.isEmpty(hotSearchItem.rightIconUrl)) {
            URLImageView uRLImageView = (URLImageView) this.D.findViewById(R.id.f166793ia2);
            ColorDrawable colorDrawable = new ColorDrawable();
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                colorDrawable.setColor(this.f97701m.getResources().getColor(R.color.akc));
            } else {
                colorDrawable.setColor(this.f97701m.getResources().getColor(R.color.akb));
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = colorDrawable;
            URLDrawable drawable = URLDrawable.getDrawable(hotSearchItem.rightIconUrl, obtain);
            if (drawable.getStatus() != 1) {
                drawable.startDownload();
            }
            uRLImageView.setVisibility(0);
            uRLImageView.setImageDrawable(drawable);
        }
    }

    private String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            Color.parseColor(str);
            return str;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("HotWordTipsContainer", 2, "getValidColor " + e16);
            }
            return str2;
        }
    }

    private void c(int i3, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        HotWordSearchEntryDataModel.HotSearchItem hotSearchItem2;
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null && hotSearchItem != null) {
            URLImageView uRLImageView = (URLImageView) relativeLayout.findViewById(R.id.la9);
            uRLImageView.setVisibility(8);
            if (i3 == 10 && (hotSearchItem2 = UniteSearchActivity.f282686d0) != null && TextUtils.equals(hotSearchItem2.title, hotSearchItem.title) && !HotWordSearchEntryModel.J(this.f97700i.G) && !TextUtils.isEmpty(this.f97700i.G.hotWordGifUrl)) {
                Context context = getContext();
                HotWordSearchEntryDataModel.GIFInfo gIFInfo = this.f97700i.G;
                HotWordSearchEntryModel.I(context, uRLImageView, gIFInfo.hotWordGifUrl, gIFInfo.hotWordGifUrlNight, null);
            }
        }
    }

    private void d(int i3, boolean z16, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        if (this.E != null && hotSearchItem != null) {
            this.G.setText(String.valueOf(i3 + 1));
            String b16 = b(hotSearchItem.indexTextColor, "#777777");
            String b17 = b(hotSearchItem.indexBgColor, "#00000000");
            this.E.setBackgroundColor(Color.parseColor(b17));
            if (z16) {
                this.G.setTextColor(Color.parseColor("#5F6062"));
                if (!TextUtils.equals(b17, "#00000000")) {
                    this.G.setTextColor(-1);
                    return;
                }
                return;
            }
            this.G.setTextColor(Color.parseColor(b16));
        }
    }

    private void e(int i3, URLImageView uRLImageView, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        if (hotSearchItem != null && uRLImageView != null) {
            uRLImageView.setVisibility(0);
            this.G.setVisibility(8);
            this.E.setVisibility(8);
            String str = hotSearchItem.imgUrl;
            if (TextUtils.isEmpty(str)) {
                String[] strArr = this.f97698f;
                if (i3 < strArr.length) {
                    str = strArr[i3];
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
                    str = str.replace(QCircleSkinHelper.SKIN_DEFAULT_MODE_TAG, QCircleSkinHelper.SKIN_DARK_MODE_TAG);
                }
                uRLImageView.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
            layoutParams.setMargins(x.c(getContext(), 2.0f), 0, 0, 0);
            this.F.setLayoutParams(layoutParams);
        }
    }

    private void f(int i3, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        if (hotSearchItem == null) {
            return;
        }
        TextView textView = (TextView) this.C.findViewById(R.id.f107326a4);
        textView.setVisibility(0);
        textView.setText(hotSearchItem.detailText);
        RelativeLayout relativeLayout = (RelativeLayout) this.C.findViewById(R.id.f75803zy);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        int c16 = x.c(getContext(), 12.0f);
        this.D.setPadding(0, 0, 0, 0);
        layoutParams.height = x.c(getContext(), 20.0f);
        if (i3 % 2 == 0) {
            textView.setPadding(c16, 0, 0, 0);
            layoutParams.setMargins(c16, c16, c16, 0);
        } else {
            layoutParams.setMargins(0, c16, c16, 0);
        }
        relativeLayout.setLayoutParams(layoutParams);
        e(i3, (URLImageView) relativeLayout.findViewById(R.id.y4w), hotSearchItem);
        this.G.setVisibility(8);
        this.E.setVisibility(8);
    }

    private void g() {
        this.E.setVisibility(8);
        this.G.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.F.setLayoutParams(layoutParams);
    }

    private void h(HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        TextView textView = this.F;
        if (textView != null && hotSearchItem != null) {
            textView.setText(hotSearchItem.title);
            if (!TextUtils.isEmpty(hotSearchItem.titleTextColor)) {
                this.F.setTextColor(Color.parseColor(hotSearchItem.titleTextColor));
            }
        }
    }

    public void i(HotWordSearchEntryDataModel hotWordSearchEntryDataModel, int i3) {
        int i16;
        removeAllViews();
        this.f97700i = hotWordSearchEntryDataModel;
        if (hotWordSearchEntryDataModel != null && hotWordSearchEntryDataModel.s() != null) {
            int i17 = 2;
            if (this.f97700i.s().size() >= 2) {
                new ArrayList();
                int size = (this.f97700i.s().size() / 2) * 2;
                boolean isInNightMode = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
                int i18 = 0;
                while (i18 < size) {
                    LinearLayout linearLayout = new LinearLayout(this.f97701m);
                    int i19 = -2;
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    linearLayout.setOrientation(0);
                    super.addView(linearLayout);
                    if (z.d()) {
                        i16 = 1;
                    } else {
                        i16 = i17;
                    }
                    int i26 = 0;
                    while (i26 < i16) {
                        i18 += i26;
                        HotWordSearchEntryDataModel.HotSearchItem hotSearchItem = this.f97700i.s().get(i18);
                        this.C = (RelativeLayout) LayoutInflater.from(this.f97701m).inflate(R.layout.f168781aq3, (ViewGroup) null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, i19);
                        layoutParams.weight = 1.0f;
                        this.C.setLayoutParams(layoutParams);
                        linearLayout.addView(this.C);
                        LinearLayout linearLayout2 = (LinearLayout) this.C.findViewById(R.id.d8w);
                        this.D = linearLayout2;
                        linearLayout2.setVisibility(0);
                        this.F = (TextView) this.D.findViewById(R.id.jpf);
                        this.G = (TextView) this.D.findViewById(R.id.dje);
                        this.E = this.D.findViewById(R.id.djc);
                        c(i3, hotSearchItem);
                        h(hotSearchItem);
                        if (!z.e()) {
                            a(hotSearchItem);
                        }
                        d(i18, isInNightMode, hotSearchItem);
                        int i27 = hotSearchItem.type;
                        if (i27 != 7) {
                            if (i27 == 8) {
                                f(i18, hotSearchItem);
                            }
                        } else {
                            g();
                        }
                        this.C.setTag(hotSearchItem);
                        this.C.setOnClickListener(this);
                        if (z.e()) {
                            int dip2px = ViewUtils.dip2px(4.0f);
                            setPadding(0, 0, dip2px, dip2px);
                            this.C.findViewById(R.id.f75803zy).getLayoutParams().height = ViewUtils.dpToPx(32.0f);
                            this.F.setTextColor(AppCompatResources.getColorStateList(this.f97701m, R.color.qui_common_text_primary));
                            this.F.setTextSize(1, 17.0f);
                            URLImageView uRLImageView = (URLImageView) this.C.findViewById(R.id.f166793ia2);
                            uRLImageView.setImageDrawable(AppCompatResources.getDrawable(this.f97701m, R.drawable.qui_chevron_right_icon_secondary_01));
                            uRLImageView.setAlpha(0.7f);
                            uRLImageView.setVisibility(0);
                            int dpToPx = ViewUtils.dpToPx(7.5f);
                            uRLImageView.getLayoutParams().height = dpToPx;
                            uRLImageView.getLayoutParams().width = dpToPx;
                            ((TextView) this.C.findViewById(R.id.f107326a4)).setTextColor(AppCompatResources.getColorStateList(this.f97701m, R.color.qui_common_text_secondary_selector));
                            this.C.setBackgroundResource(R.drawable.kfw);
                        } else if (z.d()) {
                            setPadding(0, 0, ViewUtils.dip2px(16.0f), 0);
                            this.C.findViewById(R.id.f75803zy).getLayoutParams().height = ViewUtils.dpToPx(32.0f);
                            this.F.setTextColor(AppCompatResources.getColorStateList(this.f97701m, R.color.qui_common_text_primary_selector));
                            this.F.setTextSize(1, 17.0f);
                            ((TextView) this.C.findViewById(R.id.f107326a4)).setTextColor(AppCompatResources.getColorStateList(this.f97701m, R.color.qui_common_text_secondary_selector));
                        }
                        i26++;
                        i19 = -2;
                    }
                    i18++;
                    i17 = 2;
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = this.f97699h;
        if (aVar != null) {
            aVar.a((HotWordSearchEntryDataModel.HotSearchItem) view.getTag());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnTipsClickListener(a aVar) {
        this.f97699h = aVar;
    }
}
