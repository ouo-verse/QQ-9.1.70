package com.tencent.biz.qqcircle.widgets.search;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import circlesearch.CircleSearchExhibition$ExtraIcon;
import circlesearch.CircleSearchExhibition$Icon;
import circlesearch.CircleSearchExhibition$StSuggestionInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import g30.b;
import ie0.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ua0.i;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSearchSuggestItemView extends QCircleBaseWidgetView<b> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private View f93867d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93868e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93869f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93870h;

    /* renamed from: i, reason: collision with root package name */
    private CircleSearchExhibition$StSuggestionInfo f93871i;

    public QFSSearchSuggestItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93868e = (TextView) findViewById(R.id.f56612l3);
        this.f93869f = (TextView) findViewById(R.id.f56302k9);
        this.f93867d = findViewById(R.id.f54742g1);
        this.f93870h = (TextView) findViewById(R.id.f56142jt);
        this.f93867d.setOnClickListener(this);
    }

    private void l0() {
        CircleSearchExhibition$StSuggestionInfo circleSearchExhibition$StSuggestionInfo = this.f93871i;
        if (circleSearchExhibition$StSuggestionInfo != null && !TextUtils.isEmpty(circleSearchExhibition$StSuggestionInfo.suggest_word.get())) {
            QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
            qFSSearchInfo.k(this.f93871i.suggest_word.get());
            qFSSearchInfo.j(1);
            qFSSearchInfo.a(this.f93871i.ext_info.mapInfo.get());
            getQCircleBaseFragment().getPartManager().broadcastMessage("qfs_search_words_auto_complete", qFSSearchInfo);
            EventCollector.getInstance().onViewClicked(this.f93868e);
        }
    }

    private boolean m0(CircleSearchExhibition$ExtraIcon circleSearchExhibition$ExtraIcon) {
        if (circleSearchExhibition$ExtraIcon != null && circleSearchExhibition$ExtraIcon.icon_type.get() == 1 && !TextUtils.isEmpty(circleSearchExhibition$ExtraIcon.text.get())) {
            return true;
        }
        return false;
    }

    private void n0(List<CircleSearchExhibition$ExtraIcon> list, Map<String, Object> map) {
        this.f93870h.setVisibility(8);
        if (list != null && !list.isEmpty()) {
            for (CircleSearchExhibition$ExtraIcon circleSearchExhibition$ExtraIcon : list) {
                if (m0(circleSearchExhibition$ExtraIcon)) {
                    this.f93870h.setText(circleSearchExhibition$ExtraIcon.text.get());
                    this.f93870h.setVisibility(0);
                    map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUG_ICON_TYPE, Integer.valueOf(circleSearchExhibition$ExtraIcon.icon_type.get()));
                    map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUG_ICON_NAME, circleSearchExhibition$ExtraIcon.text.get());
                    return;
                }
            }
        }
    }

    private void o0(CircleSearchExhibition$Icon circleSearchExhibition$Icon) {
        String str = circleSearchExhibition$Icon.text.get();
        String str2 = circleSearchExhibition$Icon.text_color.get();
        String str3 = circleSearchExhibition$Icon.background_color.get();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                int parseColor = Color.parseColor(str2);
                int parseColor2 = Color.parseColor(str3);
                this.f93869f.setVisibility(0);
                this.f93869f.setText(str);
                this.f93869f.setTextColor(parseColor);
                this.f93869f.setBackground(ad.f(parseColor2, 3, 17, 17));
                return;
            } catch (IllegalArgumentException e16) {
                QLog.w("QFSSearchSuggestItemView", 1, e16.getMessage(), e16);
                return;
            }
        }
        this.f93869f.setVisibility(8);
    }

    private void p0(int i3, @NonNull Map<String, Object> map) {
        CircleSearchExhibition$StSuggestionInfo circleSearchExhibition$StSuggestionInfo = this.f93871i;
        if (circleSearchExhibition$StSuggestionInfo == null) {
            return;
        }
        map.put("xsj_query_text", circleSearchExhibition$StSuggestionInfo.suggest_word.get());
        map.put("xsj_item_index", Integer.valueOf(i3));
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUG_TRANSFER_INFO, this.f93871i.report_data.get());
        i.k(this.f93868e, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_CONNECTIVE_CONTENT, map, this.f93871i.hashCode());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchSuggestItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(b bVar, int i3) {
        if (bVar != null && bVar.a() != null) {
            CircleSearchExhibition$StSuggestionInfo a16 = bVar.a();
            this.f93871i = a16;
            String str = a16.suggest_word.get();
            String str2 = this.f93871i.hit_key_word.get();
            int indexOf = str.indexOf(str2);
            if (indexOf < 0) {
                this.f93868e.setText(str);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(a.f().g(getContext(), R.color.qui_common_brand_standard, 1000)), indexOf, str2.length() + indexOf, 17);
                this.f93868e.setText(spannableStringBuilder);
            }
            o0(this.f93871i.icon.get());
            HashMap hashMap = new HashMap();
            n0(this.f93871i.extra_icons.get(), hashMap);
            p0(i3, hashMap);
            return;
        }
        this.f93871i = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f93867d) {
            l0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
