package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.OrientationMode;
import com.tencent.sqshow.zootopia.nativeui.data.sort.CombineOrderFilterData;
import com.tencent.sqshow.zootopia.nativeui.data.sort.PanelSortDialogData;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BaseDragPanelDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.PanelSortDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreViewOrientationHelper;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.am;
import n74.an;
import n74.z;
import uv4.ah;
import uv4.ar;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0003=>?B7\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0014J\b\u0010\u0019\u001a\u00020\u0004H\u0014J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010 R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00110(j\b\u0012\u0004\u0012\u00020\u0011`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010*R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020,0(j\b\u0012\u0004\u0012\u00020,`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010*R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006@"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/PanelSortDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BaseDragPanelDialogView;", "", "Y", "", "orientation", "", "W", "Ln74/z;", "binding", "b0", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Z", "a0", "Luv4/ar;", "sortType", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/PanelSortDialogView$b;", "T", "c0", "X", "e", "Landroid/view/View;", "N", "u", HippyTKDListViewAdapter.X, "o", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/c;", "J", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/c;", "mData", "K", "I", "mOriginOrderType", "", "L", "Ljava/lang/String;", "mOriginFilterValue", "M", "mCurrentOrderType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mSortItemPool", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/PanelSortDialogView$c;", "P", "mSwitchFilterItemPool", "Landroid/view/ViewGroup;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/ViewGroup;", "mRoot", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;Lcom/tencent/sqshow/zootopia/nativeui/data/sort/c;)V", BdhLogUtil.LogTag.Tag_Req, "a", "b", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PanelSortDialogView extends BaseDragPanelDialogView {

    /* renamed from: J, reason: from kotlin metadata */
    private final PanelSortDialogData mData;

    /* renamed from: K, reason: from kotlin metadata */
    private final int mOriginOrderType;

    /* renamed from: L, reason: from kotlin metadata */
    private final String mOriginFilterValue;

    /* renamed from: M, reason: from kotlin metadata */
    private int mCurrentOrderType;

    /* renamed from: N, reason: from kotlin metadata */
    private final ArrayList<b> mSortItemPool;

    /* renamed from: P, reason: from kotlin metadata */
    private final ArrayList<c> mSwitchFilterItemPool;

    /* renamed from: Q, reason: from kotlin metadata */
    private ViewGroup mRoot;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/PanelSortDialogView$b;", "", "Luv4/ar;", "data", "", "a", "", "selectedType", "c", "Ln74/am;", "Ln74/am;", "b", "()Ln74/am;", "binding", "Luv4/ar;", "mData", "<init>", "(Ln74/am;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final am binding;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private ar mData;

        public b(am binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void a(ar data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.mData = data;
            URLImageView uRLImageView = this.binding.f418671b;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.iconIgv");
            String str = data.f440217c;
            Intrinsics.checkNotNullExpressionValue(str, "data.icon");
            CommonExKt.w(uRLImageView, str, com.tencent.sqshow.zootopia.utils.q.b(R.drawable.h4a), null, 4, null);
            URLImageView uRLImageView2 = this.binding.f418671b;
            String str2 = data.f440217c;
            uRLImageView2.setVisibility(str2 == null || str2.length() == 0 ? 8 : 0);
            this.binding.f418672c.setText(data.f440216b);
        }

        /* renamed from: b, reason: from getter */
        public final am getBinding() {
            return this.binding;
        }

        public final void c(int selectedType) {
            ar arVar = this.mData;
            if (arVar == null) {
                return;
            }
            this.binding.f418673d.setVisibility(arVar.f440215a == selectedType ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/PanelSortDialogView$c;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/a;", "data", "", "b", "Ln74/an;", "a", "Ln74/an;", "d", "()Ln74/an;", "binding", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Ln74/an;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final an binding;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

        public c(an binding, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.binding = binding;
            this.channel = channel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(CombineOrderFilterData data, c this$0, View view) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String str = data.getValue().f440139b;
            Intrinsics.checkNotNullExpressionValue(str, "data.value.value");
            boolean z16 = !CommonExKt.f(str);
            this$0.binding.f418676c.setChecked(z16);
            if (z16) {
                data.getValue().f440139b = "true";
            } else {
                data.getValue().f440139b = "false";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_filter_type", Integer.valueOf(data.getFilter().f440199a));
            String str2 = data.getFilter().f440200b;
            Intrinsics.checkNotNullExpressionValue(str2, "data.filter.name");
            hashMap.put("zplan_tab_name", str2);
            ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
            RelativeLayout root = this$0.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            mReporter.e(root, "em_zplan_filter_win_btn", hashMap);
        }

        public final void b(final CombineOrderFilterData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.binding.f418675b.setText(data.getFilter().f440200b);
            String str = data.getValue().f440139b;
            Intrinsics.checkNotNullExpressionValue(str, "data.value.value");
            this.binding.f418676c.setChecked(CommonExKt.f(str));
            this.binding.f418676c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PanelSortDialogView.c.c(CombineOrderFilterData.this, this, view);
                }
            });
        }

        /* renamed from: d, reason: from getter */
        public final an getBinding() {
            return this.binding;
        }
    }

    public /* synthetic */ PanelSortDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, PanelSortDialogData panelSortDialogData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar, panelSortDialogData);
    }

    private final b T(final ar sortType) {
        final am g16 = am.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        b bVar = new b(g16);
        bVar.a(sortType);
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        aa.e(root, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PanelSortDialogView.U(ar.this, this, g16, view);
            }
        }, 50L);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ar sortType, final PanelSortDialogView this$0, am binding, View view) {
        Intrinsics.checkNotNullParameter(sortType, "$sortType");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_order_type", Integer.valueOf(sortType.f440215a));
        String str = sortType.f440216b;
        Intrinsics.checkNotNullExpressionValue(str, "sortType.name");
        hashMap.put("zplan_tab_name", str);
        ZplanViewReportHelper mReporter = this$0.getMChannel().getReporter().getMReporter();
        RelativeLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mReporter.e(root, "em_zplan_filter_win_btn", hashMap);
        this$0.mCurrentOrderType = sortType.f440215a;
        this$0.c0();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.e
            @Override // java.lang.Runnable
            public final void run() {
                PanelSortDialogView.V(PanelSortDialogView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(PanelSortDialogView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    private final void W(int orientation) {
        ViewGroup viewGroup = this.mRoot;
        ViewParent parent = viewGroup != null ? viewGroup.getParent() : null;
        if (parent == null) {
            return;
        }
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        if (orientation == 2) {
            layoutParams2.width = PortalStoreViewOrientationHelper.INSTANCE.b();
            layoutParams2.gravity = 8388693;
        } else {
            layoutParams2.width = -1;
            layoutParams2.gravity = 80;
        }
        ((ViewGroup) parent).setLayoutParams(layoutParams2);
    }

    private final void X() {
        Object obj;
        String t16 = r94.b.t(this.mData.b());
        boolean z16 = this.mOriginOrderType != this.mCurrentOrderType;
        boolean z17 = !Intrinsics.areEqual(this.mOriginFilterValue, t16);
        QLog.i("PanelSortDialogView_", 1, "confirmAndDismiss orderTypeChanged:" + z16 + ", currentFilterChanged:" + z17);
        if (z16 || z17) {
            getMChannel().getPanelSortData().f(Integer.valueOf(this.mCurrentOrderType));
            QLog.i("PanelSortDialogView_", 1, "confirmAndDismiss set currentOrderType=" + this.mCurrentOrderType);
            ArrayList arrayList = new ArrayList();
            for (ah ahVar : getMChannel().getPanelSortData().c()) {
                Iterator<T> it = this.mData.b().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((CombineOrderFilterData) obj).getValue().f440138a == ahVar.f440138a) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                CombineOrderFilterData combineOrderFilterData = (CombineOrderFilterData) obj;
                if (combineOrderFilterData != null) {
                    QLog.i("PanelSortDialogView_", 1, "filterType= " + ahVar.f440138a + ",global=" + ahVar.f440139b + ", curr=" + combineOrderFilterData.getValue().f440139b + ",");
                    if (!Intrinsics.areEqual(combineOrderFilterData.getValue().f440139b, ahVar.f440139b)) {
                        ahVar.f440139b = combineOrderFilterData.getValue().f440139b;
                        arrayList.add(ahVar);
                    }
                }
            }
            com.tencent.sqshow.zootopia.nativeui.data.sort.d dVar = new com.tencent.sqshow.zootopia.nativeui.data.sort.d(this.mCurrentOrderType, arrayList);
            QLog.i("PanelSortDialogView_", 1, "confirmAndDismiss changeInfo=" + dVar);
            getMChannel().getPanelSortData().e().setValue(dVar);
        }
    }

    private final boolean Y() {
        return getMChannel().getOrientationMode() == OrientationMode.PORTRAIT;
    }

    private final void Z(LinearLayout container) {
        this.mSwitchFilterItemPool.clear();
        for (CombineOrderFilterData combineOrderFilterData : this.mData.b()) {
            if (combineOrderFilterData.getFilter().f440202d == 1) {
                an g16 = an.g(LayoutInflater.from(getContext()));
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
                c cVar = new c(g16, getMChannel());
                cVar.b(combineOrderFilterData);
                container.addView(cVar.getBinding().getRoot(), new FrameLayout.LayoutParams(-1, (int) getContext().getResources().getDimension(R.dimen.f11424q)));
                this.mSwitchFilterItemPool.add(cVar);
                HashMap hashMap = new HashMap();
                hashMap.put("zplan_filter_type", Integer.valueOf(combineOrderFilterData.getFilter().f440199a));
                String str = combineOrderFilterData.getFilter().f440200b;
                Intrinsics.checkNotNullExpressionValue(str, "it.filter.name");
                hashMap.put("zplan_tab_name", str);
                ZplanViewReportHelper mReporter = getMChannel().getReporter().getMReporter();
                RelativeLayout root = cVar.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "itemView.binding.root");
                mReporter.g(root, "em_zplan_filter_win_btn", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
                VideoReport.setElementEndExposePolicy(cVar.getBinding().getRoot(), EndExposurePolicy.REPORT_ALL);
            }
        }
    }

    private final void a0(LinearLayout container) {
        this.mSortItemPool.clear();
        for (ar arVar : this.mData.c()) {
            b T = T(arVar);
            container.addView(T.getBinding().getRoot(), new FrameLayout.LayoutParams(-1, (int) getContext().getResources().getDimension(R.dimen.f11424q)));
            this.mSortItemPool.add(T);
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_order_type", Integer.valueOf(arVar.f440215a));
            String str = arVar.f440216b;
            Intrinsics.checkNotNullExpressionValue(str, "it.name");
            hashMap.put("zplan_tab_name", str);
            ZplanViewReportHelper mReporter = getMChannel().getReporter().getMReporter();
            RelativeLayout root = T.getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "itemView.binding.root");
            mReporter.g(root, "em_zplan_filter_win_btn", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            VideoReport.setElementEndExposePolicy(T.getBinding().getRoot(), EndExposurePolicy.REPORT_ALL);
        }
        c0();
    }

    private final void b0(z binding) {
        QLog.i("PanelSortDialogView_", 1, "initViews currentOrderType=" + this.mCurrentOrderType + " mOriginFilterValue=" + this.mOriginFilterValue);
        LinearLayout linearLayout = binding.f419475c;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.sortItemArea");
        a0(linearLayout);
        LinearLayout linearLayout2 = binding.f419474b;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.filterItemArea");
        Z(linearLayout2);
    }

    private final void c0() {
        Iterator<T> it = this.mSortItemPool.iterator();
        while (it.hasNext()) {
            ((b) it.next()).c(this.mCurrentOrderType);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BaseDragPanelDialogView
    public View N() {
        z g16 = z.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        b0(g16);
        ScrollView root = g16.getRoot();
        this.mRoot = root;
        Intrinsics.checkNotNull(root);
        return root;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void e(int orientation) {
        W(orientation);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public void o() {
        super.o();
        X();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int u() {
        int i3 = getContext().getResources().getConfiguration().orientation;
        if (!Y() && i3 == 2) {
            return PortalStoreViewOrientationHelper.INSTANCE.b();
        }
        return super.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int x() {
        int i3 = getContext().getResources().getConfiguration().orientation;
        if (Y() || i3 != 2) {
            return super.x();
        }
        return 4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelSortDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel, PanelSortDialogData mData) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(mData, "mData");
        this.mData = mData;
        this.mOriginOrderType = mData.getCurrentOrderType();
        this.mOriginFilterValue = r94.b.t(mData.b());
        this.mCurrentOrderType = mData.getCurrentOrderType();
        this.mSortItemPool = new ArrayList<>();
        this.mSwitchFilterItemPool = new ArrayList<>();
    }
}
