package com.tencent.biz.qqcircle.immersive.views.search.simpleitem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StSearchSmallItem;
import ie0.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchSmallItemResultItemView extends QFSSearchBaseWidgetView<FeedCloudRead$StSearchSmallItem> implements View.OnClickListener {
    private static final int C = ViewUtils.dpToPx(10.0f);
    private static final int D = ViewUtils.dpToPx(4.0f);
    private static final int E = ViewUtils.dpToPx(4.0f);

    /* renamed from: e, reason: collision with root package name */
    private final ImageView f91199e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f91200f;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f91201h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f91202i;

    /* renamed from: m, reason: collision with root package name */
    private int f91203m;

    public QFSSearchSmallItemResultItemView(@NonNull Context context) {
        super(context);
        this.f91199e = (ImageView) findViewById(R.id.f54082e9);
        this.f91200f = (TextView) findViewById(R.id.f54122ec);
        this.f91201h = (TextView) findViewById(R.id.f54072e8);
        TextView textView = (TextView) findViewById(R.id.f54102ea);
        this.f91202i = textView;
        setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void l0(FeedCloudRead$StSearchSmallItem feedCloudRead$StSearchSmallItem, int i3) {
        String n06 = n0();
        if (!TextUtils.isEmpty(n06) && this.f91202i.getVisibility() != 8) {
            i.k(this.f91202i, n06, o0(feedCloudRead$StSearchSmallItem, i3, true), feedCloudRead$StSearchSmallItem.hashCode());
        }
    }

    private Bitmap m0(String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, C);
        int i3 = D;
        textView.setPadding(i3, 0, i3, 0);
        textView.setTextColor(a.f().g(getContext(), R.color.qui_common_text_secondary, 1000));
        textView.setBackground(a.f().k(getContext(), R.color.qui_common_fill_standard_primary, 2.0f, 1000));
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i16 = E;
        layoutParams.leftMargin = i16;
        linearLayout.addView(textView, layoutParams);
        linearLayout.setDrawingCacheEnabled(true);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        linearLayout.layout(0, 0, textView.getMeasuredWidth() + i16, textView.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getDrawingCache());
        linearLayout.destroyDrawingCache();
        return createBitmap;
    }

    @Nullable
    private String n0() {
        int i3 = this.f91203m;
        if (i3 != 0) {
            if (i3 != 2) {
                return null;
            }
            return QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCTS_BUY_BUTTON;
        }
        return "em_xsj_publish_button";
    }

    private Map<String, Object> o0(FeedCloudRead$StSearchSmallItem feedCloudRead$StSearchSmallItem, int i3, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(i3));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, feedCloudRead$StSearchSmallItem.report.attachInfo.get());
        hashMap.put("xsj_operation_activity_id", QCircleDaTongConstant.ElementParamValue.XSJ_SEARCH_RESULT_PAGE);
        return hashMap;
    }

    @Nullable
    private String p0() {
        int i3 = this.f91203m;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return QCircleDaTongConstant.ElementId.EM_XSJ_MINI_APP_CARD;
                }
                return QCircleDaTongConstant.ElementId.EM_XSJ_RELATED_GOODS_CARD;
            }
            return QCircleDaTongConstant.ElementId.EM_XSJ_GAME_CARD;
        }
        return QCircleDaTongConstant.ElementId.EM_XSJ_PUBLISHER_USE_CARD;
    }

    private void q0(FeedCloudRead$StSearchSmallItem feedCloudRead$StSearchSmallItem, int i3) {
        String p06 = p0();
        if (TextUtils.isEmpty(p06)) {
            return;
        }
        i.k(this, p06, o0(feedCloudRead$StSearchSmallItem, i3, false), feedCloudRead$StSearchSmallItem.hashCode());
    }

    private void r0() {
        String str = getData().scheme.get();
        if (!TextUtils.isEmpty(str)) {
            QCircleSchemeLauncher.f(getContext(), str);
        } else {
            QLog.w("QFSSearchSmallItemResultItemView", 1, "#jumpToBrowsePage: url is empty");
        }
    }

    private void s0() {
        String str = getData().button_scheme.get();
        if (!TextUtils.isEmpty(str)) {
            QCircleSchemeLauncher.f(getContext(), str);
        } else {
            QLog.w("QFSSearchSmallItemResultItemView", 1, "#jumpToMakePage: url is empty");
        }
    }

    private void u0(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f91202i.setVisibility(8);
        } else {
            this.f91202i.setText(str);
            this.f91202i.setVisibility(0);
        }
    }

    private void v0(String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder(str);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb5);
            int length = str.length();
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    spannableStringBuilder.setSpan(new ImageSpan(getContext(), m0(str2)), length, str2.length() + length, 34);
                    length += str2.length();
                }
            }
            this.f91201h.setText(spannableStringBuilder);
            return;
        }
        this.f91201h.setText(str);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$StSearchSmallItem feedCloudRead$StSearchSmallItem, int i3) {
        this.f91200f.setText(feedCloudRead$StSearchSmallItem.title.get());
        String str = feedCloudRead$StSearchSmallItem.subtitle.get();
        if (TextUtils.isEmpty(str)) {
            this.f91201h.setVisibility(8);
        } else {
            this.f91201h.setVisibility(0);
            v0(str, feedCloudRead$StSearchSmallItem.tags.get());
        }
        ColorDrawable colorDrawable = new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton));
        Option obtain = Option.obtain();
        obtain.setTargetView(this.f91199e);
        obtain.setUrl(feedCloudRead$StSearchSmallItem.icon.get());
        obtain.setFailDrawable(colorDrawable);
        obtain.setLoadingDrawable(colorDrawable);
        obtain.setRequestWidth(this.f91199e.getWidth());
        obtain.setRequestHeight(this.f91199e.getHeight());
        QCircleFeedPicLoader.g().loadImage(obtain);
        u0(feedCloudRead$StSearchSmallItem.button_text.get());
        q0(feedCloudRead$StSearchSmallItem, i3);
        l0(feedCloudRead$StSearchSmallItem, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f91202i) {
            s0();
            EventCollector.getInstance().onViewClicked(this.f91202i);
        } else {
            r0();
            EventCollector.getInstance().onViewClicked(this);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setSource(int i3) {
        this.f91203m = i3;
    }
}
