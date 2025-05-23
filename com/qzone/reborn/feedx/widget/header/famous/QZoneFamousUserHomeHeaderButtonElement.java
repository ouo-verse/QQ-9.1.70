package com.qzone.reborn.feedx.widget.header.famous;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedx.viewmodel.w;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/feedx/widget/header/famous/QZoneFamousUserHomeHeaderButtonElement;", "Lcom/qzone/reborn/feedx/widget/header/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", HippyTKDListViewAdapter.X, "l", "Lx6/a;", "f", "Lx6/a;", "mUserInfoData", "Lcom/qzone/reborn/feedx/viewmodel/w;", tl.h.F, "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedx/viewmodel/d;", "i", "Lcom/qzone/reborn/feedx/viewmodel/d;", "mFamousUserViewModel", "Lcom/tencent/biz/qui/quibutton/QUIButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mFollowBtn", BdhLogUtil.LogTag.Tag_Conn, "mShareBtn", "D", "mManagePageBtn", "Landroid/view/View;", "containerView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFamousUserHomeHeaderButtonElement extends com.qzone.reborn.feedx.widget.header.d {

    /* renamed from: C, reason: from kotlin metadata */
    private QUIButton mShareBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private QUIButton mManagePageBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private x6.a mUserInfoData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private w mUserHomeViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.d mFamousUserViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QUIButton mFollowBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFamousUserHomeHeaderButtonElement(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(QZoneFamousUserHomeHeaderButtonElement this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.i.z().i(this$0.g());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(QZoneFamousUserHomeHeaderButtonElement this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.j z16 = ho.i.z();
        Activity g16 = this$0.g();
        w wVar = this$0.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        z16.q(g16, wVar.C2().getValue(), true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void v() {
        QUIButton qUIButton = this.mFollowBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.famous.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeHeaderButtonElement.w(QZoneFamousUserHomeHeaderButtonElement.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QZoneFamousUserHomeHeaderButtonElement this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mUserInfoData != null) {
            w wVar = this$0.mUserHomeViewModel;
            if (wVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                wVar = null;
            }
            Activity hostActivity = this$0.g();
            Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
            wVar.m3(hostActivity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x() {
        QUIButton qUIButton = this.mManagePageBtn;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagePageBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.famous.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeHeaderButtonElement.y(QZoneFamousUserHomeHeaderButtonElement.this, view);
            }
        });
        QUIButton qUIButton3 = this.mManagePageBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagePageBtn");
        } else {
            qUIButton2 = qUIButton3;
        }
        fo.c.n(qUIButton2, "em_qz_aut_manage_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(QZoneFamousUserHomeHeaderButtonElement this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.i.z().h(this$0.g());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void z() {
        com.qzone.reborn.feedx.viewmodel.d dVar = this.mFamousUserViewModel;
        QUIButton qUIButton = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFamousUserViewModel");
            dVar = null;
        }
        if (dVar.O1()) {
            QUIButton qUIButton2 = this.mShareBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                qUIButton2 = null;
            }
            qUIButton2.setText(com.qzone.util.l.a(R.string.w_8));
            QUIButton qUIButton3 = this.mShareBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                qUIButton3 = null;
            }
            qUIButton3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.famous.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneFamousUserHomeHeaderButtonElement.A(QZoneFamousUserHomeHeaderButtonElement.this, view);
                }
            });
            QUIButton qUIButton4 = this.mShareBtn;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            } else {
                qUIButton = qUIButton4;
            }
            fo.c.n(qUIButton, "em_qz_aut_yellow_manage_button");
            return;
        }
        QUIButton qUIButton5 = this.mShareBtn;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            qUIButton5 = null;
        }
        qUIButton5.setText(com.qzone.util.l.a(R.string.wbo));
        QUIButton qUIButton6 = this.mShareBtn;
        if (qUIButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            qUIButton6 = null;
        }
        qUIButton6.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.famous.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeHeaderButtonElement.B(QZoneFamousUserHomeHeaderButtonElement.this, view);
            }
        });
        QUIButton qUIButton7 = this.mShareBtn;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
        } else {
            qUIButton = qUIButton7;
        }
        fo.c.n(qUIButton, "em_qz_aut_share");
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        View findViewById = d().findViewById(R.id.f162876n34);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.biz.qui.quibutton.QUIButton");
        this.mFollowBtn = (QUIButton) findViewById;
        View findViewById2 = d().findViewById(R.id.n36);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.tencent.biz.qui.quibutton.QUIButton");
        this.mShareBtn = (QUIButton) findViewById2;
        View findViewById3 = d().findViewById(R.id.f162877n35);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.biz.qui.quibutton.QUIButton");
        this.mManagePageBtn = (QUIButton) findViewById3;
        ViewModel k3 = k(w.class);
        Intrinsics.checkNotNullExpressionValue(k3, "getViewModel(QZoneUserHomeViewModel::class.java)");
        this.mUserHomeViewModel = (w) k3;
        ViewModel k16 = k(com.qzone.reborn.feedx.viewmodel.d.class);
        Intrinsics.checkNotNullExpressionValue(k16, "getViewModel(QZoneFamousUserViewModel::class.java)");
        this.mFamousUserViewModel = (com.qzone.reborn.feedx.viewmodel.d) k16;
        w wVar = this.mUserHomeViewModel;
        w wVar2 = null;
        QUIButton qUIButton = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        if (wVar.M2()) {
            QUIButton qUIButton2 = this.mManagePageBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManagePageBtn");
                qUIButton2 = null;
            }
            qUIButton2.setVisibility(0);
            QUIButton qUIButton3 = this.mFollowBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
                qUIButton3 = null;
            }
            qUIButton3.setVisibility(8);
            QUIButton qUIButton4 = this.mShareBtn;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            } else {
                qUIButton = qUIButton4;
            }
            qUIButton.setVisibility(8);
            x();
            return;
        }
        QUIButton qUIButton5 = this.mManagePageBtn;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagePageBtn");
            qUIButton5 = null;
        }
        qUIButton5.setVisibility(8);
        QUIButton qUIButton6 = this.mFollowBtn;
        if (qUIButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qUIButton6 = null;
        }
        qUIButton6.setVisibility(0);
        QUIButton qUIButton7 = this.mShareBtn;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            qUIButton7 = null;
        }
        qUIButton7.setVisibility(0);
        v();
        z();
        w wVar3 = this.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar2 = wVar3;
        }
        MutableLiveData<x6.a> C2 = wVar2.C2();
        LifecycleOwner i3 = i();
        final Function1<x6.a, Unit> function1 = new Function1<x6.a, Unit>() { // from class: com.qzone.reborn.feedx.widget.header.famous.QZoneFamousUserHomeHeaderButtonElement$onInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(x6.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(x6.a aVar) {
                QUIButton qUIButton8;
                QUIButton qUIButton9;
                Map<String, Object> mapOf;
                QUIButton qUIButton10;
                QUIButton qUIButton11;
                QUIButton qUIButton12;
                QZoneFamousUserHomeHeaderButtonElement.this.mUserInfoData = aVar;
                QUIButton qUIButton13 = null;
                if (aVar.isFollowed) {
                    qUIButton11 = QZoneFamousUserHomeHeaderButtonElement.this.mFollowBtn;
                    if (qUIButton11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
                        qUIButton11 = null;
                    }
                    qUIButton11.setType(1);
                    qUIButton12 = QZoneFamousUserHomeHeaderButtonElement.this.mFollowBtn;
                    if (qUIButton12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
                        qUIButton12 = null;
                    }
                    qUIButton12.setText(com.qzone.util.l.a(R.string.sjk));
                } else {
                    qUIButton8 = QZoneFamousUserHomeHeaderButtonElement.this.mFollowBtn;
                    if (qUIButton8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
                        qUIButton8 = null;
                    }
                    qUIButton8.setType(0);
                    qUIButton9 = QZoneFamousUserHomeHeaderButtonElement.this.mFollowBtn;
                    if (qUIButton9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
                        qUIButton9 = null;
                    }
                    qUIButton9.setText(com.qzone.util.l.a(R.string.siv));
                }
                String str = aVar.isFollowed ? "0" : "1";
                fo.b bVar = new fo.b();
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, str));
                fo.b l3 = bVar.l(mapOf);
                qUIButton10 = QZoneFamousUserHomeHeaderButtonElement.this.mFollowBtn;
                if (qUIButton10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
                } else {
                    qUIButton13 = qUIButton10;
                }
                fo.c.o(qUIButton13, "em_qz_aut_follow_button", l3);
            }
        };
        C2.observe(i3, new Observer() { // from class: com.qzone.reborn.feedx.widget.header.famous.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFamousUserHomeHeaderButtonElement.C(Function1.this, obj);
            }
        });
    }
}
