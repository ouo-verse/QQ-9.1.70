package com.tencent.mobileqq.zplan.reservation.impl.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.reservation.impl.fragment.ReservationManageFragment;
import com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanUserCenterEmptyView;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import qv4.ad;
import tj3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\r\u001a\u00020\fH\u0014R#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0019\u001a\n \u000f*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/reservation/impl/fragment/ReservationManageFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "uh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "", "getContentLayoutId", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "xh", "()Landroid/widget/LinearLayout;", "switchContainer", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "D", "wh", "()Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "emptyView", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ReservationManageFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy switchContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy emptyView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/fragment/ReservationManageFragment$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ad;", "result", "", "c", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements e<ad> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View view) {
            a.C11293a.a((tj3.a) vb3.a.f441346a.a(tj3.a.class), 0, 0, null, 6, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ad result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ReservationManageFragment.this.xh().setVisibility(8);
            ReservationManageFragment.this.wh().setVisibility(0);
            ReservationManageFragment.this.wh().setText(R.string.xtq);
            ReservationManageFragment.this.wh().setMode(ZPlanUserCenterEmptyView.MODE.MODE_NO_NETWORK, true, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReservationManageFragment.a.b(view);
                }
            });
        }
    }

    public ReservationManageFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.ReservationManageFragment$switchContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) ReservationManageFragment.this)).mContentView;
                return (LinearLayout) view.findViewById(R.id.plw);
            }
        });
        this.switchContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanUserCenterEmptyView>() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.ReservationManageFragment$emptyView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanUserCenterEmptyView invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) ReservationManageFragment.this)).mContentView;
                return (ZPlanUserCenterEmptyView) view.findViewById(R.id.prg);
            }
        });
        this.emptyView = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FormSimpleItem uh() {
        FormSimpleItem formSimpleItem = new FormSimpleItem(getQBaseActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i.b(56));
        layoutParams.topMargin = i.b(10);
        formSimpleItem.setLayoutParams(layoutParams);
        formSimpleItem.setBgType(0);
        formSimpleItem.setFocusable(false);
        return formSimpleItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZPlanUserCenterEmptyView wh() {
        return (ZPlanUserCenterEmptyView) this.emptyView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout xh() {
        return (LinearLayout) this.switchContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.xc6));
        vb3.a aVar = vb3.a.f441346a;
        MutableLiveData<ad> r06 = ((tj3.a) aVar.a(tj3.a.class)).r0();
        final ReservationManageFragment$doOnCreateView$1 reservationManageFragment$doOnCreateView$1 = new ReservationManageFragment$doOnCreateView$1(this);
        r06.observe(this, new Observer() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationManageFragment.vh(Function1.this, obj);
            }
        });
        ((tj3.a) aVar.a(tj3.a.class)).i(0, 0, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167429d93;
    }
}
