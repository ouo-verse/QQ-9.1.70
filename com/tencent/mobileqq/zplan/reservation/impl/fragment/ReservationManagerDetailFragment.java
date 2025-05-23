package com.tencent.mobileqq.zplan.reservation.impl.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.zootopia.utils.g;
import com.tencent.mobileqq.zplan.utils.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import pv4.j;
import pv4.k;
import qv4.ad;
import qv4.ay;
import qv4.bf;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J&\u0010\u001a\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R#\u0010,\u001a\n '*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R#\u0010\u0017\u001a\n '*\u0004\u0018\u00010-0-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R$\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000501j\b\u0012\u0004\u0012\u00020\u0005`28\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zplan/reservation/impl/fragment/ReservationManagerDetailFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "Hh", "initData", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Lpv4/j;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Bh", "", "isChecked", "changeListener", "Gh", "Fh", OcrConfig.CHINESE, "Lpv4/k;", DownloadInfo.spKey_Config, "Ah", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "", "getContentLayoutId", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "reserveId", "D", "Ljava/lang/Integer;", "reserveType", "E", "Lpv4/j;", "reserveItem", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/widget/FormSwitchItem;", "reserveSwitch", "Landroid/widget/LinearLayout;", "G", "Ch", "()Landroid/widget/LinearLayout;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "configSwitches", "<init>", "()V", "I", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ReservationManagerDetailFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private String reserveId;

    /* renamed from: D, reason: from kotlin metadata */
    private Integer reserveType = 0;

    /* renamed from: E, reason: from kotlin metadata */
    private j reserveItem;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy reserveSwitch;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy container;

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<FormSwitchItem> configSwitches;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/fragment/ReservationManagerDetailFragment$b", "Lcom/tencent/mobileqq/zplan/utils/y$a;", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "changeListener", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements y.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FormSwitchItem f335110b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f335111c;

        b(FormSwitchItem formSwitchItem, j jVar) {
            this.f335110b = formSwitchItem;
            this.f335111c = jVar;
        }

        @Override // com.tencent.mobileqq.zplan.utils.y.a
        public void a(CompoundButton buttonView, boolean isChecked, CompoundButton.OnCheckedChangeListener changeListener) {
            if (y.f335851a.b(ReservationManagerDetailFragment.this.getQBaseActivity(), this.f335110b, buttonView, changeListener)) {
                if (this.f335110b == ReservationManagerDetailFragment.this.Dh()) {
                    ReservationManagerDetailFragment.this.Gh(isChecked, this.f335111c, this.f335110b, changeListener);
                } else {
                    ReservationManagerDetailFragment.this.Fh(isChecked, this.f335111c, this.f335110b, changeListener);
                }
            }
        }
    }

    public ReservationManagerDetailFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FormSwitchItem>() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.ReservationManagerDetailFragment$reserveSwitch$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FormSwitchItem invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) ReservationManagerDetailFragment.this)).mContentView;
                return (FormSwitchItem) view.findViewById(R.id.qh_);
            }
        });
        this.reserveSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.ReservationManagerDetailFragment$container$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View view;
                view = ((QIphoneTitleBarFragment) ((QIphoneTitleBarFragment) ReservationManagerDetailFragment.this)).mContentView;
                return (LinearLayout) view.findViewById(R.id.plw);
            }
        });
        this.container = lazy2;
        this.configSwitches = new ArrayList<>();
    }

    private final FormSwitchItem Ah(k config) {
        FormSwitchItem formSwitchItem = new FormSwitchItem(getQBaseActivity());
        formSwitchItem.setBgType(0);
        formSwitchItem.setText(config.f427626b);
        formSwitchItem.setChecked(config.f427628d);
        return formSwitchItem;
    }

    private final CompoundButton.OnCheckedChangeListener Bh(FormSwitchItem r36, j item) {
        return y.d(getQBaseActivity(), r36, new b(r36, item));
    }

    private final LinearLayout Ch() {
        return (LinearLayout) this.container.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FormSwitchItem Dh() {
        return (FormSwitchItem) this.reserveSwitch.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(boolean isChecked, j item, FormSwitchItem r85, CompoundButton.OnCheckedChangeListener changeListener) {
        k it;
        k[] kVarArr = item.f427623f;
        Intrinsics.checkNotNullExpressionValue(kVarArr, "item.configList");
        int length = kVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                it = null;
                break;
            }
            it = kVarArr[i3];
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (g.j(it)) {
                break;
            } else {
                i3++;
            }
        }
        if (it != null) {
            it.f427628d = isChecked;
        }
        ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).R(item, new c(r85, isChecked, changeListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(boolean isChecked, j item, FormSwitchItem r56, CompoundButton.OnCheckedChangeListener changeListener) {
        if (!isChecked) {
            ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).J(item, new d(r56, changeListener));
        } else {
            ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).s0(item, false, new e(r56, isChecked, changeListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh() {
        j jVar = this.reserveItem;
        if (jVar != null) {
            Dh().setText(jVar.f427621d.f427630a);
            Dh().setOnCheckedChangeListener(null);
            Dh().setChecked(jVar.f427620c);
            FormSwitchItem Dh = Dh();
            FormSwitchItem reserveSwitch = Dh();
            Intrinsics.checkNotNullExpressionValue(reserveSwitch, "reserveSwitch");
            Dh.setOnCheckedChangeListener(Bh(reserveSwitch, jVar));
            Iterator<FormSwitchItem> it = this.configSwitches.iterator();
            while (it.hasNext()) {
                Ch().removeView(it.next());
            }
            if (jVar.f427620c) {
                zh(jVar);
            }
        }
        if (this.reserveItem == null) {
            QQToastUtil.showQQToast(1, "\u52a0\u8f7d\u51fa\u9519");
            getQBaseActivity().finish();
        }
    }

    private final void initData() {
        Bundle arguments = getArguments();
        this.reserveId = arguments != null ? arguments.getString("reserve_id") : null;
        Bundle arguments2 = getArguments();
        this.reserveType = arguments2 != null ? Integer.valueOf(arguments2.getInt("reserve_type", -1)) : null;
        QLog.i("ReservationManagerDetailFragment", 1, "onCreate reserveId:" + this.reserveId);
        MutableLiveData<ad> r06 = ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).r0();
        final Function1<ad, Unit> function1 = new Function1<ad, Unit>() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.ReservationManagerDetailFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ad adVar) {
                invoke2(adVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0033 A[LOOP:0: B:6:0x000d->B:15:0x0033, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(ad adVar) {
                j jVar;
                j jVar2;
                j[] jVarArr;
                String str;
                boolean z16;
                Integer num;
                ReservationManagerDetailFragment reservationManagerDetailFragment = ReservationManagerDetailFragment.this;
                j jVar3 = null;
                if (adVar != null && (jVarArr = adVar.f429902a) != null) {
                    int length = jVarArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        j jVar4 = jVarArr[i3];
                        String str2 = jVar4.f427619b;
                        str = reservationManagerDetailFragment.reserveId;
                        if (Intrinsics.areEqual(str2, str)) {
                            int i16 = jVar4.f427618a;
                            num = reservationManagerDetailFragment.reserveType;
                            if (num != null && i16 == num.intValue()) {
                                z16 = true;
                                if (!z16) {
                                    jVar3 = jVar4;
                                    break;
                                }
                                i3++;
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                }
                reservationManagerDetailFragment.reserveItem = jVar3;
                jVar = ReservationManagerDetailFragment.this.reserveItem;
                if (jVar != null) {
                    jVar2 = ReservationManagerDetailFragment.this.reserveItem;
                    QLog.i("ReservationManagerDetailFragment", 1, "onCreate found item:" + jVar2);
                    ReservationManagerDetailFragment.this.Hh();
                }
            }
        };
        r06.observe(this, new Observer() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationManagerDetailFragment.Eh(Function1.this, obj);
            }
        });
    }

    private final void zh(j item) {
        k[] kVarArr = item.f427623f;
        if (kVarArr != null) {
            int length = kVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                k config = kVarArr[i3];
                Intrinsics.checkNotNullExpressionValue(config, "config");
                FormSwitchItem Ah = Ah(config);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i.b(56));
                layoutParams.topMargin = i.b(10);
                if (kVarArr.length == 1) {
                    Ah.setBgType(0);
                } else if (kVarArr.length > 1) {
                    if (i3 == 0) {
                        Ah.setBgType(1);
                    } else if (i3 == kVarArr.length - 1) {
                        Ah.setBgType(3);
                    } else {
                        Ah.setBgType(2);
                    }
                }
                Ah.setOnCheckedChangeListener(Bh(Ah, item));
                Ah.setTag(config);
                Ch().addView(Ah, layoutParams);
                this.configSwitches.add(Ah);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.xc6));
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167428d92;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/fragment/ReservationManagerDetailFragment$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ay;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ay> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FormSwitchItem f335112d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f335113e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CompoundButton.OnCheckedChangeListener f335114f;

        c(FormSwitchItem formSwitchItem, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            this.f335112d = formSwitchItem;
            this.f335113e = z16;
            this.f335114f = onCheckedChangeListener;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ay result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QQToastUtil.showQQToast(5, result.f430024a);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToastUtil.showQQToast(4, R.string.xbo);
            y.e(this.f335112d, !this.f335113e, this.f335114f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/fragment/ReservationManagerDetailFragment$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<qv4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FormSwitchItem f335115d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CompoundButton.OnCheckedChangeListener f335116e;

        d(FormSwitchItem formSwitchItem, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            this.f335115d = formSwitchItem;
            this.f335116e = onCheckedChangeListener;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(qv4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QQToastUtil.showQQToast(5, R.string.xba);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToastUtil.showQQToast(4, R.string.xb_);
            y.e(this.f335115d, true, this.f335116e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/reservation/impl/fragment/ReservationManagerDetailFragment$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bf;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<bf> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FormSwitchItem f335117d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f335118e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CompoundButton.OnCheckedChangeListener f335119f;

        e(FormSwitchItem formSwitchItem, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            this.f335117d = formSwitchItem;
            this.f335118e = z16;
            this.f335119f = onCheckedChangeListener;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bf result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QQToastUtil.showQQToast(5, R.string.xc7);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToastUtil.showQQToast(5, R.string.xc5);
            y.e(this.f335117d, !this.f335118e, this.f335119f);
        }
    }
}
