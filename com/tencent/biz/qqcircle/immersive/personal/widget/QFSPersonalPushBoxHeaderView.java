package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalPushBoxHeaderView extends QCircleBaseWidgetView<com.tencent.biz.qqcircle.immersive.personal.bean.o> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89315d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f89316e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f89317f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f89318h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends CharacterStyle {
        a() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            RFWTypefaceUtil.setNumberTypeface((Paint) textPaint, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends CharacterStyle {
        b() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            RFWTypefaceUtil.setNumberTypeface((Paint) textPaint, false);
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSPersonalPushBoxHeaderView> f89321a;

        public c(QFSPersonalPushBoxHeaderView qFSPersonalPushBoxHeaderView) {
            this.f89321a = new WeakReference<>(qFSPersonalPushBoxHeaderView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            int i3;
            int i16;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            com.tencent.biz.qqcircle.immersive.personal.bean.o data = this.f89321a.get().getData();
            if (data != null) {
                int i17 = 1;
                if (data.b().unopendPushBoxCount.get() > 0) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ROCKET_ENTER_TYPE, Integer.valueOf(i3));
                if (data.a() > 0) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOTNUM_ENTER_IF_REDDOT, Integer.valueOf(i16));
                if (!com.tencent.biz.qqcircle.immersive.utils.r.b0() || data.b().unopendPushBoxCount.get() <= 0) {
                    i17 = 0;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSHED_TAB_IF_REDDOT, Integer.valueOf(i17));
            }
            return buildElementParams;
        }
    }

    public QFSPersonalPushBoxHeaderView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f89315d = (ImageView) findViewById(R.id.f44151oe);
        this.f89316e = (ImageView) findViewById(R.id.f44281or);
        this.f89317f = (TextView) findViewById(R.id.f56022jh);
        ImageView imageView = (ImageView) findViewById(R.id.f44681pu);
        this.f89318h = imageView;
        imageView.setOnClickListener(this);
        l0();
    }

    private void l0() {
        ImageView imageView = this.f89318h;
        if (imageView == null) {
            return;
        }
        VideoReport.setElementId(imageView, QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_ENTER);
        VideoReport.setEventDynamicParams(this.f89318h, new c(this));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gk8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalPushBoxHeaderView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.o oVar, int i3) {
        String str;
        String str2;
        String str3;
        if (this.f89315d != null && this.f89316e != null && this.f89317f != null && this.f89318h != null && oVar != null) {
            setVisibility(0);
            long j3 = oVar.b().unopendPushBoxCount.get();
            oVar.d().rocket_count.get();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (j3 <= 0) {
                str = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_homepage_entrance_huojian_bg");
                str2 = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_homepage_entrance_huojian");
                str3 = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_homepage_entrance_huojian_btn");
                this.f89318h.setTag(oVar.e());
                spannableStringBuilder.append((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f194944d_));
                int length = spannableStringBuilder.length();
                String str4 = com.tencent.biz.qqcircle.f.v().t() + "";
                int length2 = str4.length() + length;
                spannableStringBuilder.append((CharSequence) str4);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(DisplayUtil.dip2px(getContext(), 18.0f)), length, length2, 33);
                spannableStringBuilder.setSpan(new a(), length, length2, 33);
            } else {
                String url = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_homepage_entrance_baoxiang_bg");
                String url2 = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_homepage_entrance_baoxiang");
                String url3 = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_homepage_entrance_baoxiang_btn");
                this.f89318h.setTag(oVar.c());
                spannableStringBuilder.append((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f196584hp));
                int length3 = spannableStringBuilder.length();
                String str5 = j3 + "";
                int length4 = str5.length() + length3;
                spannableStringBuilder.append((CharSequence) str5);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(DisplayUtil.dip2px(getContext(), 18.0f)), length3, length4, 33);
                spannableStringBuilder.setSpan(new b(), length3, length4, 33);
                spannableStringBuilder.append((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f194084ay));
                str = url;
                str2 = url2;
                str3 = url3;
            }
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str2).setTargetView(this.f89316e));
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(this.f89315d));
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str3).setTargetView(this.f89318h));
            this.f89317f.setText(spannableStringBuilder);
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f44681pu) {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), view.getTag().toString());
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
