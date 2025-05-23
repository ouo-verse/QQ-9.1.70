package h6;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.proxy.feedcomponent.ViewSectionType;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends a {

    /* renamed from: f, reason: collision with root package name */
    private final View.OnClickListener f404428f;

    public d(Context context, NormalAbsFeedView normalAbsFeedView) {
        super(context, normalAbsFeedView);
        this.f404428f = new View.OnClickListener() { // from class: h6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.i(view);
            }
        };
    }

    private View g() {
        Context context = getContext();
        BusinessFeedData businessFeedData = this.mFeedData;
        if (context == null || businessFeedData == null || !businessFeedData.isGDTAdvFeed() || TextUtils.isEmpty(GdtAdFeedUtil.getDescription(this.mFeedData))) {
            return null;
        }
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = AreaConst.MARGIN_LEFT;
        layoutParams.rightMargin = AreaConst.MARGIN_RIGHT;
        layoutParams.topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        textView.setLayoutParams(layoutParams);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(2);
        textView.setText(GdtAdFeedUtil.getDescription(this.mFeedData));
        textView.setTextColor(i.H().p1() ? -1 : -16777216);
        textView.setBackgroundColor(0);
        textView.setTextSize(1, 16.0f);
        textView.setIncludeFontPadding(false);
        textView.setOnClickListener(this.f404428f);
        return textView;
    }

    private View h() {
        LayoutInflater from;
        View inflate;
        if (getContext() == null || (from = LayoutInflater.from(getContext())) == null || (inflate = from.inflate(R.layout.f168002ed2, (ViewGroup) null)) == null) {
            return null;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.vmu);
        if (textView != null) {
            textView.setText(GdtAdFeedUtil.getSubtitle(this.mFeedData));
            textView.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000));
            textView.setOnClickListener(this.f404428f);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.vmt);
        if (textView2 != null) {
            textView2.setText(GdtAdFeedUtil.getDescription(this.mFeedData));
            textView2.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000));
            textView2.setOnClickListener(this.f404428f);
        }
        URLImageView uRLImageView = (URLImageView) inflate.findViewById(R.id.vms);
        if (uRLImageView != null) {
            String ipImageForCrossAd = GdtAdFeedUtil.getIpImageForCrossAd(this.mFeedData);
            if (!TextUtils.isEmpty(ipImageForCrossAd)) {
                uRLImageView.setImageDrawable(URLDrawable.getDrawable(ipImageForCrossAd, URLDrawable.URLDrawableOptions.obtain()));
            }
            uRLImageView.setOnClickListener(this.f404428f);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        e();
        g gVar = this.onFeedElementClickListener;
        if (gVar != null) {
            gVar.onClick(view, FeedElement.SUMMARY, this.feedPosition, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // h6.a
    protected ViewSectionType d() {
        return ViewSectionType.GDT_DESCRIPTION;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public boolean haveMultipleViews() {
        return false;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (GdtAdFeedUtil.isCrossAd(this.mFeedData)) {
            return h();
        }
        return g();
    }
}
