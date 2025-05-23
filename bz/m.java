package bz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yy.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lbz/m;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lyy/c;", "", "e", "data", "d", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvSectionName", "tvSectionNum", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivSectionArrow", tl.h.F, "Lyy/c;", AppConstants.Key.COLUMN_MSG_DATA, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class m extends BaseViewHolder<yy.c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvSectionName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvSectionNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivSectionArrow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private yy.c msgData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ViewGroup parent) {
        super(parent, R.layout.d16);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View findViewById = this.itemView.findViewById(R.id.p7r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_msg_section_name)");
        this.tvSectionName = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.p7s);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_msg_section_num)");
        this.tvSectionNum = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.p4i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_msg_section_arrow)");
        this.ivSectionArrow = (ImageView) findViewById3;
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: bz.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.c(m.this, view);
            }
        });
        if (e00.b.b()) {
            this.ivSectionArrow.setImageResource(R.drawable.odi);
        } else {
            this.ivSectionArrow.setImageResource(R.drawable.gju);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(m this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
    }

    private final void e() {
        c.C11639c d16;
        c.C11639c d17;
        this.tvSectionNum.setVisibility(8);
        yy.c cVar = this.msgData;
        Integer num = null;
        c.C11639c d18 = cVar != null ? cVar.d() : null;
        if (d18 != null) {
            d18.d(0);
        }
        yy.c cVar2 = this.msgData;
        String b16 = (cVar2 == null || (d17 = cVar2.d()) == null) ? null : d17.b();
        if (b16 == null) {
            b16 = "";
        }
        xy.h hVar = xy.h.f449023a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        yy.c cVar3 = this.msgData;
        if (cVar3 != null && (d16 = cVar3.d()) != null) {
            num = Integer.valueOf(d16.a());
        }
        hVar.f(context, "from_section", b16, num);
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void bindData(yy.c data) {
        c.C11639c d16;
        c.C11639c d17;
        super.bindData(data);
        this.msgData = data;
        Integer num = null;
        this.tvSectionName.setText((data == null || (d17 = data.d()) == null) ? null : d17.b());
        yy.c cVar = this.msgData;
        if (cVar != null && (d16 = cVar.d()) != null) {
            num = Integer.valueOf(d16.c());
        }
        if (num != null && num.intValue() > 0) {
            this.tvSectionNum.setVisibility(0);
            this.tvSectionNum.setText(num.toString());
        } else {
            this.tvSectionNum.setVisibility(8);
        }
    }
}
