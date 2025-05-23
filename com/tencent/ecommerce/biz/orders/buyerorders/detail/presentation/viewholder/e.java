package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.util.DateFormat;
import com.tencent.ecommerce.biz.util.ECViewUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\tR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\tR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\tR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\tR\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u000fR\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\tR\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\tR\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "o", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "orderIdTv", UserInfo.SEX_FEMALE, "copyOrderIdTv", "Landroidx/constraintlayout/widget/Group;", "G", "Landroidx/constraintlayout/widget/Group;", "snapshotGroup", "H", "orderCreateTimeTv", "I", "contactPhoneGroup", "J", "contactPhoneTv", "K", "payInfoGroup", "L", "payTypeTv", "M", "payTimeTv", "N", "orderNoteGroup", "P", "orderNoteTitleTv", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "orderNoteTv", BdhLogUtil.LogTag.Tag_Req, "orderSellerNoteGroup", ExifInterface.LATITUDE_SOUTH, "orderSellerNoteTitleTv", "T", "orderSellerNoteTv", "Landroid/view/View;", "U", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "V", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "orderDetailListListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.DetailInfoData> {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView orderIdTv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView copyOrderIdTv;

    /* renamed from: G, reason: from kotlin metadata */
    private Group snapshotGroup;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView orderCreateTimeTv;

    /* renamed from: I, reason: from kotlin metadata */
    private Group contactPhoneGroup;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView contactPhoneTv;

    /* renamed from: K, reason: from kotlin metadata */
    private Group payInfoGroup;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView payTypeTv;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView payTimeTv;

    /* renamed from: N, reason: from kotlin metadata */
    private Group orderNoteGroup;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView orderNoteTitleTv;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView orderNoteTv;

    /* renamed from: R, reason: from kotlin metadata */
    private Group orderSellerNoteGroup;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView orderSellerNoteTitleTv;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView orderSellerNoteTv;

    /* renamed from: U, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: V, reason: from kotlin metadata */
    private final com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a orderDetailListListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f.DetailInfoData f103361e;

        a(f.DetailInfoData detailInfoData) {
            this.f103361e = detailInfoData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.orderDetailListListener.f(this.f103361e.orderId);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f.DetailInfoData f103363e;

        b(f.DetailInfoData detailInfoData) {
            this.f103363e = detailInfoData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.orderDetailListListener.l(this.f103363e.orderId);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(View view, com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a aVar) {
        super(view);
        this.rootView = view;
        this.orderDetailListListener = aVar;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    public void m() {
        View view = this.rootView;
        this.orderIdTv = (TextView) view.findViewById(R.id.o5i);
        this.copyOrderIdTv = (TextView) view.findViewById(R.id.o5g);
        this.snapshotGroup = (Group) view.findViewById(R.id.f163111od0);
        this.orderCreateTimeTv = (TextView) view.findViewById(R.id.o5e);
        this.contactPhoneGroup = (Group) view.findViewById(R.id.nui);
        this.contactPhoneTv = (TextView) view.findViewById(R.id.nuk);
        this.payInfoGroup = (Group) view.findViewById(R.id.o6a);
        this.payTypeTv = (TextView) view.findViewById(R.id.o6j);
        this.payTimeTv = (TextView) view.findViewById(R.id.o6h);
        this.orderNoteGroup = (Group) view.findViewById(R.id.o5l);
        this.orderNoteTitleTv = (TextView) view.findViewById(R.id.o5m);
        this.orderNoteTv = (TextView) view.findViewById(R.id.o5n);
        this.orderSellerNoteGroup = (Group) view.findViewById(R.id.o5p);
        this.orderSellerNoteTitleTv = (TextView) view.findViewById(R.id.o5q);
        this.orderSellerNoteTv = (TextView) view.findViewById(R.id.o5r);
        Group group = this.snapshotGroup;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapshotGroup");
        }
        ECViewUtilKt.b(group, R.id.f163112od1, R.id.ocy, R.id.ocz);
        Group group2 = this.contactPhoneGroup;
        if (group2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactPhoneGroup");
        }
        ECViewUtilKt.b(group2, R.id.nuj, R.id.nuk);
        Group group3 = this.payInfoGroup;
        if (group3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payInfoGroup");
        }
        ECViewUtilKt.b(group3, R.id.o6i, R.id.o6j, R.id.o6g, R.id.o6h);
        Group group4 = this.orderNoteGroup;
        if (group4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderNoteGroup");
        }
        ECViewUtilKt.b(group4, R.id.o5m, R.id.o5n);
        Group group5 = this.orderSellerNoteGroup;
        if (group5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderSellerNoteGroup");
        }
        ECViewUtilKt.b(group5, R.id.o5q, R.id.o5r);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(f.DetailInfoData data) {
        TextView textView = this.orderIdTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderIdTv");
        }
        textView.setText(data.orderId);
        TextView textView2 = this.copyOrderIdTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("copyOrderIdTv");
        }
        textView2.setOnClickListener(new a(data));
        if (data.getShowSnapshot()) {
            Group group = this.snapshotGroup;
            if (group == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snapshotGroup");
            }
            group.setVisibility(0);
            Group group2 = this.snapshotGroup;
            if (group2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snapshotGroup");
            }
            group2.setOnClickListener(new b(data));
        } else {
            Group group3 = this.snapshotGroup;
            if (group3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snapshotGroup");
            }
            group3.setVisibility(8);
        }
        TextView textView3 = this.orderCreateTimeTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderCreateTimeTv");
        }
        com.tencent.ecommerce.biz.util.d dVar = com.tencent.ecommerce.biz.util.d.f104866a;
        long j3 = data.orderCreateTimestampMs;
        DateFormat dateFormat = DateFormat.YMD_HMS;
        textView3.setText(dVar.a(j3, dateFormat));
        if (data.contactPhone.length() > 0) {
            Group group4 = this.contactPhoneGroup;
            if (group4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactPhoneGroup");
            }
            group4.setVisibility(0);
            TextView textView4 = this.contactPhoneTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactPhoneTv");
            }
            textView4.setText(data.contactPhone);
        } else {
            Group group5 = this.contactPhoneGroup;
            if (group5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactPhoneGroup");
            }
            group5.setVisibility(8);
        }
        PayType payType = data.payType;
        if (data.enableShowPayDetail && payType != null) {
            Group group6 = this.payInfoGroup;
            if (group6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payInfoGroup");
            }
            group6.setVisibility(0);
            TextView textView5 = this.payTypeTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payTypeTv");
            }
            textView5.setText(this.rootView.getContext().getString(payType.nameResId));
            TextView textView6 = this.payTimeTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payTimeTv");
            }
            textView6.setText(dVar.a(data.payTimestampMs, dateFormat));
        } else {
            Group group7 = this.payInfoGroup;
            if (group7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payInfoGroup");
            }
            group7.setVisibility(8);
        }
        if (data.orderNote.length() > 0) {
            Group group8 = this.orderNoteGroup;
            if (group8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderNoteGroup");
            }
            group8.setVisibility(0);
            TextView textView7 = this.orderNoteTitleTv;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderNoteTitleTv");
            }
            textView7.setText(data.orderNoteTitle);
            TextView textView8 = this.orderNoteTv;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderNoteTv");
            }
            textView8.setText(data.orderNote);
        } else {
            Group group9 = this.orderNoteGroup;
            if (group9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderNoteGroup");
            }
            group9.setVisibility(8);
        }
        if (data.orderNoteFromSeller.length() > 0) {
            Group group10 = this.orderSellerNoteGroup;
            if (group10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderSellerNoteGroup");
            }
            group10.setVisibility(0);
            TextView textView9 = this.orderSellerNoteTv;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderSellerNoteTv");
            }
            textView9.setText(data.orderNoteFromSeller);
            return;
        }
        Group group11 = this.orderSellerNoteGroup;
        if (group11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderSellerNoteGroup");
        }
        group11.setVisibility(8);
    }
}
