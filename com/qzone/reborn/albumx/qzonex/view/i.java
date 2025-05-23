package com.qzone.reborn.albumx.qzonex.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010 \u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018\"\u0004\b\u001f\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/i;", "", "", tl.h.F, "g", "", "isVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "a", "Landroid/view/View;", "containerView", "Landroid/widget/RelativeLayout;", "b", "Landroid/widget/RelativeLayout;", "selectBarView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "tvSelectTimeText", "", "d", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "selectedYear", "e", "k", "selectedMonth", "j", "selectedDay", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View containerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout selectBarView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private TextView tvSelectTimeText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Integer selectedYear;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Integer selectedMonth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Integer selectedDay;

    public i(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.containerView = containerView;
    }

    private final void g() {
        Integer num = this.selectedYear;
        Integer num2 = this.selectedMonth;
        Integer num3 = this.selectedDay;
        if (num == null || num2 == null || num3 == null) {
            Calendar calendar = Calendar.getInstance();
            Integer valueOf = Integer.valueOf(calendar.get(1));
            num2 = Integer.valueOf(calendar.get(2) + 1);
            num3 = Integer.valueOf(calendar.get(5));
            num = valueOf;
        }
        com.tencent.mobileqq.widget.selectorview.a aVar = new com.tencent.mobileqq.widget.selectorview.a(this.containerView.getContext());
        aVar.j(false);
        aVar.E(num.intValue(), num2.intValue(), num3.intValue());
        aVar.k(com.qzone.util.l.a(R.string.f1345595));
        if (aVar.e() == null) {
            aVar.i(new a(aVar));
        }
        aVar.m();
        fo.c.f("em_qz_love_date_confirm", "pg_qz_album_create", this.tvSelectTimeText);
    }

    private final void h() {
        if (this.selectBarView != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.containerView.findViewById(R.id.moc);
        RelativeLayout relativeLayout = (RelativeLayout) (viewStub != null ? viewStub.inflate() : null);
        this.selectBarView = relativeLayout;
        if (relativeLayout == null) {
            return;
        }
        this.tvSelectTimeText = relativeLayout != null ? (TextView) relativeLayout.findViewById(R.id.nkd) : null;
        RelativeLayout relativeLayout2 = this.selectBarView;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.i(i.this, view);
                }
            });
        }
        fo.c.n(this.selectBarView, "em_qz_change_love_date");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* renamed from: d, reason: from getter */
    public final Integer getSelectedDay() {
        return this.selectedDay;
    }

    /* renamed from: e, reason: from getter */
    public final Integer getSelectedMonth() {
        return this.selectedMonth;
    }

    /* renamed from: f, reason: from getter */
    public final Integer getSelectedYear() {
        return this.selectedYear;
    }

    public final void j(Integer num) {
        this.selectedDay = num;
    }

    public final void k(Integer num) {
        this.selectedMonth = num;
    }

    public final void l(Integer num) {
        this.selectedYear = num;
    }

    public final void m(boolean isVisible) {
        if (isVisible) {
            h();
            RelativeLayout relativeLayout = this.selectBarView;
            if (relativeLayout == null) {
                return;
            }
            relativeLayout.setVisibility(0);
            return;
        }
        RelativeLayout relativeLayout2 = this.selectBarView;
        if (relativeLayout2 == null) {
            return;
        }
        relativeLayout2.setVisibility(8);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/i$a", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements QActionSheet.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.a f53475e;

        a(com.tencent.mobileqq.widget.selectorview.a aVar) {
            this.f53475e = aVar;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            i.this.l(Integer.valueOf(this.f53475e.D()));
            i.this.k(Integer.valueOf(this.f53475e.B()));
            i.this.j(Integer.valueOf(this.f53475e.A()));
            TextView textView = i.this.tvSelectTimeText;
            if (textView != null) {
                textView.setText(i.this.containerView.getResources().getString(R.string.f1345797, i.this.getSelectedYear(), i.this.getSelectedMonth(), i.this.getSelectedDay()));
            }
            fo.c.d("em_qz_love_date_confirm", "pg_qz_album_create", i.this.tvSelectTimeText);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
