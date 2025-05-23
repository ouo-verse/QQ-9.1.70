package b82;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b;
import com.tencent.mobileqq.widget.listitem.x.c;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0017\u0012\u0006\u0010\u0011\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R$\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lb82/a;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "V", "()Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "setItemView", "(Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;)V", "itemView", "l", "r", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b;Lcom/tencent/mobileqq/widget/listitem/x$c;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a<L extends x.b, R extends x.c> extends x<L, R> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private QUISingleLineListItem itemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(L l3, R r16) {
        super(l3, r16);
        Intrinsics.checkNotNullParameter(l3, "l");
        Intrinsics.checkNotNullParameter(r16, "r");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: Q */
    public QUISingleLineListItem H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        QUISingleLineListItem H = super.H(parent);
        this.itemView = H;
        return H;
    }

    /* renamed from: V, reason: from getter */
    public final QUISingleLineListItem getItemView() {
        return this.itemView;
    }
}
