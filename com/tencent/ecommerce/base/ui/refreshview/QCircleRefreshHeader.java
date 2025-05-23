package com.tencent.ecommerce.base.ui.refreshview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/QCircleRefreshHeader;", "Lcom/tencent/ecommerce/base/ui/refreshview/BaseRefreshHeader;", "", "c", "d", "e", "", "isSucceeded", "b", "", Element.ELEMENT_NAME_DISTANCE, "a", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tipsIv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class QCircleRefreshHeader extends BaseRefreshHeader {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ImageView iconIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView tipsIv;

    public QCircleRefreshHeader(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.cth, (ViewGroup) this, true);
        this.iconIv = (ImageView) findViewById(R.id.o0x);
        this.tipsIv = (TextView) findViewById(R.id.occ);
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void b(boolean isSucceeded) {
        this.iconIv.setImageResource(R.drawable.bjy);
        this.tipsIv.setText(isSucceeded ? R.string.wj5 : R.string.f169601wj1);
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void c() {
        this.iconIv.setImageResource(R.drawable.bjy);
        this.tipsIv.setText(R.string.f169602wj2);
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void d() {
        this.iconIv.setImageResource(R.drawable.bjy);
        this.tipsIv.setText(R.string.f169603wj3);
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void e() {
        this.iconIv.setImageResource(R.drawable.bjy);
        this.tipsIv.setText(R.string.f169604wj4);
    }

    @Override // com.tencent.ecommerce.base.ui.refreshview.BaseRefreshHeader
    public void a(float distance) {
    }
}
