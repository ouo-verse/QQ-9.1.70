package com.tencent.ecommerce.base.ui.refreshview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/DefaultRefreshHeader;", "Lcom/tencent/ecommerce/base/ui/refreshview/BaseRefreshHeader;", "", "d", "e", "c", "", "isSucceeded", "b", "", Element.ELEMENT_NAME_DISTANCE, "a", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "progressBar", "", "f", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "refreshSucceedText", h.F, "refreshFailedText", "refreshPrepareText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "refreshIdleText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public class DefaultRefreshHeader extends BaseRefreshHeader {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String refreshSucceedText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String refreshFailedText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String refreshPrepareText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String refreshIdleText;

    public DefaultRefreshHeader(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.crl, this);
        this.textView = (TextView) findViewById(R.id.oc8);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.o7n);
        this.progressBar = progressBar;
        progressBar.setVisibility(8);
        this.refreshSucceedText = context.getResources().getString(R.string.wj5);
        this.refreshFailedText = context.getResources().getString(R.string.f169601wj1);
        this.refreshPrepareText = context.getResources().getString(R.string.f169603wj3);
        this.refreshIdleText = context.getResources().getString(R.string.f169602wj2);
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void b(boolean isSucceeded) {
        String refreshFailedText;
        this.progressBar.setVisibility(8);
        this.textView.setVisibility(0);
        TextView textView = this.textView;
        if (isSucceeded) {
            refreshFailedText = getRefreshSucceedText();
        } else {
            refreshFailedText = getRefreshFailedText();
        }
        textView.setText(refreshFailedText);
        this.textView.setTextColor(getResources().getColor(R.color.f156553e3));
        setBackgroundColor(getResources().getColor(R.color.f156576l6));
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void c() {
        this.progressBar.setVisibility(8);
        this.textView.setVisibility(0);
        this.textView.setText(getRefreshIdleText());
        this.textView.setTextColor(getContext().getResources().getColor(R.color.f156575l5));
        setBackgroundColor(getContext().getResources().getColor(R.color.f7153h));
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void d() {
        this.progressBar.setVisibility(8);
        this.textView.setVisibility(0);
        this.textView.setText(getRefreshPrepareText());
        this.textView.setTextColor(getContext().getResources().getColor(R.color.f156575l5));
        setBackgroundColor(getContext().getResources().getColor(R.color.f7153h));
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void e() {
        this.progressBar.setVisibility(0);
        this.textView.setVisibility(8);
        setBackgroundColor(getContext().getResources().getColor(R.color.f7153h));
    }

    /* renamed from: f, reason: from getter */
    public String getRefreshFailedText() {
        return this.refreshFailedText;
    }

    /* renamed from: g, reason: from getter */
    public String getRefreshIdleText() {
        return this.refreshIdleText;
    }

    /* renamed from: h, reason: from getter */
    public String getRefreshPrepareText() {
        return this.refreshPrepareText;
    }

    /* renamed from: i, reason: from getter */
    public String getRefreshSucceedText() {
        return this.refreshSucceedText;
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void a(float distance) {
    }
}
