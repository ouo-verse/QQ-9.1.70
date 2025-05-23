package com.qzone.reborn.albumx.qzonex.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wa.QZAlbumxParentFamilyBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0016\u0010&\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u0016\u0010(\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\u001bR\u0016\u0010*\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00105\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R$\u00107\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010-\u001a\u0004\b)\u0010/\"\u0004\b6\u00101R$\u0010=\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00109\u001a\u0004\b,\u0010:\"\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/aa;", "", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", "isVisible", "y", "Landroid/view/View;", "a", "Landroid/view/View;", "containerView", "Landroid/widget/LinearLayout;", "b", "Landroid/widget/LinearLayout;", "selectBarView", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "timeSelectItem", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivBirthdayIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvBirthdaySelectText", "f", "tvBirthdaySelectAfterText", "g", "tvBirthdaySelectTime", tl.h.F, "identitySelectItem", "i", "ivIdentityIcon", "j", "tvIdentitySelectText", "k", "tvIdentitySelectAfterText", "l", "tvIdentitySelectPerson", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Integer;", "o", "()Ljava/lang/Integer;", HippyTKDListViewAdapter.X, "(Ljava/lang/Integer;)V", "selectedYear", DomainData.DOMAIN_NAME, "w", "selectedMonth", "u", "selectedDay", "Lwa/b;", "Lwa/b;", "()Lwa/b;", "v", "(Lwa/b;)V", "selectedFamilyBean", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View containerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LinearLayout selectBarView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private FrameLayout timeSelectItem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBirthdayIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvBirthdaySelectText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvBirthdaySelectAfterText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView tvBirthdaySelectTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout identitySelectItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivIdentityIcon;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private TextView tvIdentitySelectText;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private TextView tvIdentitySelectAfterText;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView tvIdentitySelectPerson;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Integer selectedYear;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Integer selectedMonth;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Integer selectedDay;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxParentFamilyBean selectedFamilyBean;

    public aa(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.containerView = containerView;
    }

    private final void p() {
        Context context = this.containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        QZAlbumxParentingSelectIdentityDialog qZAlbumxParentingSelectIdentityDialog = new QZAlbumxParentingSelectIdentityDialog(context, this.selectedFamilyBean);
        qZAlbumxParentingSelectIdentityDialog.b0(new b());
        qZAlbumxParentingSelectIdentityDialog.show();
    }

    private final void q() {
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
        aVar.k(com.qzone.util.l.a(R.string.f134609_));
        if (aVar.e() == null) {
            aVar.i(new c(aVar));
        }
        aVar.m();
    }

    private final void r() {
        if (this.selectBarView != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.containerView.findViewById(R.id.mod);
        FrameLayout frameLayout = null;
        LinearLayout linearLayout = (LinearLayout) (viewStub != null ? viewStub.inflate() : null);
        this.selectBarView = linearLayout;
        if (linearLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        View findViewById = linearLayout.findViewById(R.id.mgj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "selectBarView!!.findView\u2026R.id.ll_time_select_item)");
        this.timeSelectItem = (FrameLayout) findViewById;
        LinearLayout linearLayout2 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout2);
        View findViewById2 = linearLayout2.findViewById(R.id.kuf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "selectBarView!!.findView\u2026Id(R.id.iv_birthday_icon)");
        this.ivBirthdayIcon = (ImageView) findViewById2;
        LinearLayout linearLayout3 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout3);
        View findViewById3 = linearLayout3.findViewById(R.id.ni7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "selectBarView!!.findView\u2026.tv_birthday_select_text)");
        this.tvBirthdaySelectText = (TextView) findViewById3;
        LinearLayout linearLayout4 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout4);
        View findViewById4 = linearLayout4.findViewById(R.id.ni6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "selectBarView!!.findView\u2026rthday_select_after_text)");
        this.tvBirthdaySelectAfterText = (TextView) findViewById4;
        LinearLayout linearLayout5 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout5);
        View findViewById5 = linearLayout5.findViewById(R.id.ni8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "selectBarView!!.findView\u2026.tv_birthday_select_time)");
        this.tvBirthdaySelectTime = (TextView) findViewById5;
        LinearLayout linearLayout6 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout6);
        View findViewById6 = linearLayout6.findViewById(R.id.mg9);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "selectBarView!!.findView\u2026.ll_identity_select_item)");
        this.identitySelectItem = (FrameLayout) findViewById6;
        LinearLayout linearLayout7 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout7);
        View findViewById7 = linearLayout7.findViewById(R.id.l8z);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "selectBarView!!.findView\u2026Id(R.id.iv_identity_icon)");
        this.ivIdentityIcon = (ImageView) findViewById7;
        LinearLayout linearLayout8 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout8);
        View findViewById8 = linearLayout8.findViewById(R.id.f162956nj1);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "selectBarView!!.findView\u2026.tv_identity_select_text)");
        this.tvIdentitySelectText = (TextView) findViewById8;
        LinearLayout linearLayout9 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout9);
        View findViewById9 = linearLayout9.findViewById(R.id.niz);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "selectBarView!!.findView\u2026entity_select_after_text)");
        this.tvIdentitySelectAfterText = (TextView) findViewById9;
        LinearLayout linearLayout10 = this.selectBarView;
        Intrinsics.checkNotNull(linearLayout10);
        View findViewById10 = linearLayout10.findViewById(R.id.f162955nj0);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "selectBarView!!.findView\u2026v_identity_select_person)");
        this.tvIdentitySelectPerson = (TextView) findViewById10;
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView = this.ivBirthdayIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBirthdayIcon");
            imageView = null;
        }
        a16.m(imageView, this.containerView.getResources().getColor(R.color.qui_common_icon_secondary));
        com.tencent.mobileqq.qzone.picload.c a17 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView2 = this.ivIdentityIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIdentityIcon");
            imageView2 = null;
        }
        a17.m(imageView2, this.containerView.getResources().getColor(R.color.qui_common_icon_secondary));
        FrameLayout frameLayout2 = this.timeSelectItem;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeSelectItem");
            frameLayout2 = null;
        }
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aa.s(aa.this, view);
            }
        });
        FrameLayout frameLayout3 = this.identitySelectItem;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("identitySelectItem");
            frameLayout3 = null;
        }
        frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aa.t(aa.this, view);
            }
        });
        FrameLayout frameLayout4 = this.timeSelectItem;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeSelectItem");
            frameLayout4 = null;
        }
        fo.c.n(frameLayout4, "em_qz_add_baby_birthday");
        FrameLayout frameLayout5 = this.identitySelectItem;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("identitySelectItem");
        } else {
            frameLayout = frameLayout5;
        }
        fo.c.n(frameLayout, "em_qz_choose_my_identity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(aa this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(aa this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* renamed from: l, reason: from getter */
    public final Integer getSelectedDay() {
        return this.selectedDay;
    }

    /* renamed from: m, reason: from getter */
    public final QZAlbumxParentFamilyBean getSelectedFamilyBean() {
        return this.selectedFamilyBean;
    }

    /* renamed from: n, reason: from getter */
    public final Integer getSelectedMonth() {
        return this.selectedMonth;
    }

    /* renamed from: o, reason: from getter */
    public final Integer getSelectedYear() {
        return this.selectedYear;
    }

    public final void u(Integer num) {
        this.selectedDay = num;
    }

    public final void v(QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean) {
        this.selectedFamilyBean = qZAlbumxParentFamilyBean;
    }

    public final void w(Integer num) {
        this.selectedMonth = num;
    }

    public final void x(Integer num) {
        this.selectedYear = num;
    }

    public final void y(boolean isVisible) {
        if (isVisible) {
            r();
            LinearLayout linearLayout = this.selectBarView;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout2 = this.selectBarView;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(8);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/aa$b", "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$b;", "", "onCancel", "Lwa/b;", "selectedBean", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZAlbumxParentingSelectIdentityDialog.b {
        b() {
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void a(QZAlbumxParentFamilyBean selectedBean) {
            QLog.i("QZAlbumxParentingSelectBarView", 1, "onConfirm  selectedFamilyBean=" + aa.this.getSelectedFamilyBean() + ", afterSelectedBean=" + selectedBean);
            aa.this.v(selectedBean);
            if (aa.this.getSelectedFamilyBean() != null) {
                QZAlbumxParentFamilyBean selectedFamilyBean = aa.this.getSelectedFamilyBean();
                Intrinsics.checkNotNull(selectedFamilyBean);
                if (TextUtils.isEmpty(selectedFamilyBean.getName())) {
                    return;
                }
                TextView textView = aa.this.tvIdentitySelectPerson;
                TextView textView2 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvIdentitySelectPerson");
                    textView = null;
                }
                QZAlbumxParentFamilyBean selectedFamilyBean2 = aa.this.getSelectedFamilyBean();
                Intrinsics.checkNotNull(selectedFamilyBean2);
                textView.setText(selectedFamilyBean2.getName());
                ImageView imageView = aa.this.ivIdentityIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivIdentityIcon");
                    imageView = null;
                }
                imageView.setVisibility(8);
                TextView textView3 = aa.this.tvIdentitySelectText;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvIdentitySelectText");
                    textView3 = null;
                }
                textView3.setVisibility(8);
                TextView textView4 = aa.this.tvIdentitySelectAfterText;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvIdentitySelectAfterText");
                    textView4 = null;
                }
                textView4.setVisibility(0);
                TextView textView5 = aa.this.tvIdentitySelectPerson;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvIdentitySelectPerson");
                } else {
                    textView2 = textView5;
                }
                textView2.setVisibility(0);
            }
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void onCancel() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/aa$c", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements QActionSheet.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.a f53436e;

        c(com.tencent.mobileqq.widget.selectorview.a aVar) {
            this.f53436e = aVar;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            aa.this.x(Integer.valueOf(this.f53436e.D()));
            aa.this.w(Integer.valueOf(this.f53436e.B()));
            aa.this.u(Integer.valueOf(this.f53436e.A()));
            TextView textView = aa.this.tvBirthdaySelectTime;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvBirthdaySelectTime");
                textView = null;
            }
            textView.setText(aa.this.containerView.getResources().getString(R.string.f134619a, aa.this.getSelectedYear(), aa.this.getSelectedMonth(), aa.this.getSelectedDay()));
            ImageView imageView = aa.this.ivBirthdayIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivBirthdayIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
            TextView textView3 = aa.this.tvBirthdaySelectText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvBirthdaySelectText");
                textView3 = null;
            }
            textView3.setVisibility(8);
            TextView textView4 = aa.this.tvBirthdaySelectAfterText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvBirthdaySelectAfterText");
                textView4 = null;
            }
            textView4.setVisibility(0);
            TextView textView5 = aa.this.tvBirthdaySelectTime;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvBirthdaySelectTime");
            } else {
                textView2 = textView5;
            }
            textView2.setVisibility(0);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
