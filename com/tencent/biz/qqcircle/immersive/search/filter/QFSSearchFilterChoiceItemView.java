package com.tencent.biz.qqcircle.immersive.search.filter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import ie0.a;
import java.util.HashMap;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchFilterChoiceItemView extends QFSSearchBaseWidgetView<String> {

    /* renamed from: e, reason: collision with root package name */
    private TextView f89873e;

    /* renamed from: f, reason: collision with root package name */
    private String f89874f;

    public QFSSearchFilterChoiceItemView(@NonNull Context context) {
        super(context);
        this.f89873e = (TextView) findViewById(R.id.f52742am);
    }

    private void l0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FILTER_OPTION_TYPE, this.f89874f);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FILTER_OPTION_NAME, str);
        i.k(this, QCircleDaTongConstant.ElementId.EM_XSJ_FILTER_OPTION_ITEM, hashMap, str.hashCode());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z16) {
        int i3;
        super.dispatchSetSelected(z16);
        this.f89873e.setTypeface(Typeface.defaultFromStyle(z16 ? 1 : 0));
        TextView textView = this.f89873e;
        a f16 = a.f();
        Context context = getContext();
        if (z16) {
            i3 = R.color.qui_common_text_primary;
        } else {
            i3 = R.color.qui_common_text_secondary;
        }
        textView.setTextColor(f16.g(context, i3, 1000));
        if (z16) {
            EventCollector.getInstance().onViewClicked(this);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.grt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            this.f89873e.setVisibility(8);
            return;
        }
        this.f89873e.setText(str);
        this.f89873e.setVisibility(0);
        l0(str);
    }

    public void setTitle(String str) {
        this.f89874f = str;
    }
}
