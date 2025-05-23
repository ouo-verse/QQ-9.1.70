package com.qzone.reborn.albumx.qzonex.part.editalbum;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.au;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/editalbum/QZAlbumxEditLoverTimePart;", "Lcom/qzone/reborn/base/k;", "", "loverTime", "P9", "dateString", "", "U9", "R9", "Landroid/view/View;", "view", "O9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvLoverTime", "e", "Landroid/view/View;", "tvLoverTimeContainer", "Lnc/au;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "Q9", "()Lnc/au;", "vm", "", tl.h.F, "Ljava/lang/Integer;", "selectedYear", "i", "selectedMonth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "selectedDay", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxEditLoverTimePart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvLoverTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View tvLoverTimeContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Integer selectedYear;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Integer selectedMonth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Integer selectedDay;

    public QZAlbumxEditLoverTimePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<au>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditLoverTimePart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final au invoke() {
                return (au) QZAlbumxEditLoverTimePart.this.getViewModel(au.class);
            }
        });
        this.vm = lazy;
    }

    private final void O9(View view) {
        fo.c.o(view, "em_qz_change_love_date", new fo.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final au Q9() {
        return (au) this.vm.getValue();
    }

    private final void R9() {
        if (this.selectedYear == null || this.selectedMonth == null || this.selectedDay == null) {
            Calendar calendar = Calendar.getInstance();
            this.selectedYear = Integer.valueOf(calendar.get(1));
            this.selectedMonth = Integer.valueOf(calendar.get(2) + 1);
            this.selectedDay = Integer.valueOf(calendar.get(5));
        }
        com.tencent.mobileqq.widget.selectorview.a aVar = new com.tencent.mobileqq.widget.selectorview.a(getContext());
        aVar.j(false);
        Integer num = this.selectedYear;
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Integer num2 = this.selectedMonth;
        Intrinsics.checkNotNull(num2);
        int intValue2 = num2.intValue();
        Integer num3 = this.selectedDay;
        Intrinsics.checkNotNull(num3);
        aVar.E(intValue, intValue2, num3.intValue());
        aVar.k(com.qzone.util.l.a(R.string.f1345595));
        if (aVar.e() == null) {
            aVar.i(new b(aVar));
        }
        aVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QZAlbumxEditLoverTimePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U9(String dateString) {
        if (dateString.length() != 8) {
            QZLog.e("QZAlbumxEditLoverTimePart", "Invalid date format");
            return;
        }
        try {
            String substring = dateString.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            this.selectedYear = Integer.valueOf(Integer.parseInt(substring));
            String substring2 = dateString.substring(4, 6);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            this.selectedMonth = Integer.valueOf(Integer.parseInt(substring2));
            String substring3 = dateString.substring(6, 8);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            this.selectedDay = Integer.valueOf(Integer.parseInt(substring3));
        } catch (NumberFormatException unused) {
            QZLog.e("QZAlbumxEditLoverTimePart", "Invalid date format");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.m3q);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxEditLoverTimePart.S9(QZAlbumxEditLoverTimePart.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026          }\n            }");
            this.tvLoverTimeContainer = findViewById;
            View findViewById2 = findViewById.findViewById(R.id.njc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "tvLoverTimeContainer.findViewById(R.id.tv_name)");
            this.tvLoverTime = (TextView) findViewById2;
            View view = this.tvLoverTimeContainer;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLoverTimeContainer");
                view = null;
            }
            view.setVisibility(8);
            View view3 = this.tvLoverTimeContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLoverTimeContainer");
            } else {
                view2 = view3;
            }
            O9(view2);
        }
        LiveData<CommonAlbumEditInitBean> M1 = Q9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CommonAlbumEditInitBean, Unit> function1 = new Function1<CommonAlbumEditInitBean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.QZAlbumxEditLoverTimePart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonAlbumEditInitBean commonAlbumEditInitBean) {
                invoke2(commonAlbumEditInitBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommonAlbumEditInitBean commonAlbumEditInitBean) {
                View view4;
                TextView textView;
                String P9;
                View view5;
                if (commonAlbumEditInitBean != null && com.qzone.reborn.albumx.qzonex.utils.c.f53402a.f(commonAlbumEditInitBean.getAlbumInfo())) {
                    TextView textView2 = null;
                    if (commonAlbumEditInitBean.getAlbumInfo().getQzAlbumType() != 11) {
                        view5 = QZAlbumxEditLoverTimePart.this.tvLoverTimeContainer;
                        if (view5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tvLoverTimeContainer");
                            view5 = null;
                        }
                        view5.setVisibility(8);
                    } else {
                        view4 = QZAlbumxEditLoverTimePart.this.tvLoverTimeContainer;
                        if (view4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tvLoverTimeContainer");
                            view4 = null;
                        }
                        view4.setVisibility(0);
                    }
                    textView = QZAlbumxEditLoverTimePart.this.tvLoverTime;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvLoverTime");
                    } else {
                        textView2 = textView;
                    }
                    P9 = QZAlbumxEditLoverTimePart.this.P9(commonAlbumEditInitBean.getAlbumInfo().getLoverAlbum().getFallInLoveTime());
                    textView2.setText(P9);
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.editalbum.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxEditLoverTimePart.T9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String P9(String loverTime) {
        if (loverTime == null || loverTime.length() == 0) {
            String string = getContext().getString(R.string.je7);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026upplementary_information)");
            return string;
        }
        U9(loverTime);
        if (this.selectedYear != null && this.selectedMonth != null && this.selectedDay != null) {
            String string2 = getContext().getResources().getString(R.string.f1345797, this.selectedYear, this.selectedMonth, this.selectedDay);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026lectedMonth, selectedDay)");
            return string2;
        }
        String string3 = getContext().getString(R.string.je7);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026upplementary_information)");
        return string3;
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/editalbum/QZAlbumxEditLoverTimePart$b", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QActionSheet.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.a f53051e;

        b(com.tencent.mobileqq.widget.selectorview.a aVar) {
            this.f53051e = aVar;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            QZAlbumxEditLoverTimePart.this.selectedYear = Integer.valueOf(this.f53051e.D());
            QZAlbumxEditLoverTimePart.this.selectedMonth = Integer.valueOf(this.f53051e.B());
            QZAlbumxEditLoverTimePart.this.selectedDay = Integer.valueOf(this.f53051e.A());
            QZAlbumxEditLoverTimePart.this.Q9().A2(com.qzone.reborn.albumx.qzonex.utils.k.f53414a.d(QZAlbumxEditLoverTimePart.this.selectedYear, QZAlbumxEditLoverTimePart.this.selectedMonth, QZAlbumxEditLoverTimePart.this.selectedDay));
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
