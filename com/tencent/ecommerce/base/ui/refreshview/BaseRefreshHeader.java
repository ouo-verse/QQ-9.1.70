package com.tencent.ecommerce.base.ui.refreshview;

import android.content.Context;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.apiv3.data.Element;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/BaseRefreshHeader;", "Landroid/widget/RelativeLayout;", "", "d", "e", "c", "", "isSucceeded", "b", "", Element.ELEMENT_NAME_DISTANCE, "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public abstract class BaseRefreshHeader extends RelativeLayout {
    public BaseRefreshHeader(Context context) {
        super(context);
    }

    public abstract void a(float distance);

    public abstract void b(boolean isSucceeded);

    public abstract void c();

    public abstract void d();

    public abstract void e();
}
