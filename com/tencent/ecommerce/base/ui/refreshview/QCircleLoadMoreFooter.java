package com.tencent.ecommerce.base.ui.refreshview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/QCircleLoadMoreFooter;", "Lcom/tencent/ecommerce/base/ui/refreshview/BaseLoadMoreFooter;", "", "isVisible", "", "setVisible", "c", "b", "a", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "footerText", "Landroid/widget/ProgressBar;", "e", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/view/View;", "f", "Landroid/view/View;", "child", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class QCircleLoadMoreFooter extends BaseLoadMoreFooter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView footerText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View child;

    public QCircleLoadMoreFooter(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.cqd, this);
        this.child = findViewById(R.id.nzo);
        this.footerText = (TextView) findViewById(R.id.oc8);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.o7n);
        this.progressBar = progressBar;
        progressBar.setVisibility(8);
        this.footerText.setText(context.getResources().getString(R.string.wnt));
    }

    public void a() {
        setVisibility(0);
        this.child.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.footerText.setText(getContext().getResources().getString(R.string.wns));
    }

    public void b() {
        setVisibility(0);
        this.child.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.footerText.setText(getContext().getResources().getString(R.string.wnt));
    }

    public void c() {
        setVisibility(0);
        this.child.setVisibility(0);
        this.progressBar.setVisibility(0);
        this.footerText.setText(getContext().getResources().getString(R.string.wnu));
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseLoadMoreFooter
    public void setVisible(boolean isVisible) {
        setVisibility(isVisible ? 0 : 8);
        this.child.setVisibility(isVisible ? 0 : 8);
    }
}
