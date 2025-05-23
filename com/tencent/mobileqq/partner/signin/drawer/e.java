package com.tencent.mobileqq.partner.signin.drawer;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.partner.signin.drawer.e;
import com.tencent.mobileqq.partner.signin.view.PartnerSignInInfoView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.m;
import com.tencent.mobileqq.utils.ViewUtils;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0003J\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J*\u0010\u001c\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/drawer/e;", "Lk61/d;", "Lf61/h;", "mutualMarkList", "", "y", "", "selectPos", "D", "B", "", "Lcom/tencent/mobileqq/partner/signin/drawer/f;", "signInInfos", "", "friendUin", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "", "w", "Landroid/view/View;", "containerView", "onInitView", "Lj61/a;", "data", "position", "", "", "payload", HippyTKDListViewAdapter.X, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "tabLayout", "Landroid/widget/TextView;", "f", "Ljava/util/List;", "tabTextViews", h.F, "Landroid/view/View;", "nextIv", "Landroidx/viewpager/widget/ViewPager;", "i", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/tencent/mobileqq/partner/signin/drawer/e$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/partner/signin/drawer/e$a;", "adapter", BdhLogUtil.LogTag.Tag_Conn, "I", "Ljava/lang/String;", "partnerUin", "<init>", "()V", "a", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends k61.d {

    /* renamed from: C, reason: from kotlin metadata */
    private int selectPos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout tabLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View nextIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewPager viewPager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private a adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<TextView> tabTextViews = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private String partnerUin = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/partner/signin/drawer/e$b", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", "position", "", "onPageSelected", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends ViewPager.SimpleOnPageChangeListener {
        b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPageSelected(int position) {
            com.tencent.mobileqq.partner.signin.b bVar;
            String str;
            List<f> e16;
            Object orNull;
            e.this.selectPos = position;
            e.this.D(position);
            m mVar = m.f306784a;
            a aVar = e.this.adapter;
            if (aVar != null && (e16 = aVar.e()) != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(e16, e.this.selectPos);
                f fVar = (f) orNull;
                if (fVar != null) {
                    bVar = fVar.a();
                    com.tencent.mobileqq.partner.signin.b bVar2 = bVar;
                    str = e.this.partnerUin;
                    if (str == null) {
                        str = "";
                    }
                    mVar.b(new m.PartnerReportData("pg_aio_swipleft", "em_bas_card_punch_card", "dt_imp", bVar2, str, "2"));
                }
            }
            bVar = null;
            com.tencent.mobileqq.partner.signin.b bVar22 = bVar;
            str = e.this.partnerUin;
            if (str == null) {
            }
            mVar.b(new m.PartnerReportData("pg_aio_swipleft", "em_bas_card_punch_card", "dt_imp", bVar22, str, "2"));
        }
    }

    private final void A(List<f> signInInfos, String friendUin) {
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.h(signInInfos);
            aVar.i(friendUin);
            aVar.notifyDataSetChanged();
        }
    }

    private final void B(final int selectPos) {
        List<f> e16;
        Object orNull;
        a aVar = this.adapter;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(e16, selectPos);
        final f fVar = (f) orNull;
        if (fVar == null) {
            return;
        }
        String b16 = fVar.b();
        View view = null;
        if (!(b16 == null || b16.length() == 0)) {
            View view2 = this.nextIv;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextIv");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            View view3 = this.mRootView;
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.partner.signin.drawer.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        e.C(f.this, this, selectPos, view4);
                    }
                });
                return;
            }
            return;
        }
        View view4 = this.nextIv;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextIv");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = this.mRootView;
        if (view5 != null) {
            view5.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void C(f cardInfo, e this$0, int i3, View view) {
        com.tencent.mobileqq.partner.signin.b bVar;
        List<f> e16;
        Object orNull;
        Intrinsics.checkNotNullParameter(cardInfo, "$cardInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.webview.util.f fVar = com.tencent.mobileqq.webview.util.f.f314875a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        String b16 = cardInfo.b();
        if (b16 == null) {
            b16 = "";
        }
        fVar.k(context, b16, new Bundle(), 0.9f);
        m mVar = m.f306784a;
        a aVar = this$0.adapter;
        if (aVar != null && (e16 = aVar.e()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(e16, i3);
            f fVar2 = (f) orNull;
            if (fVar2 != null) {
                bVar = fVar2.a();
                com.tencent.mobileqq.partner.signin.b bVar2 = bVar;
                String str = this$0.partnerUin;
                mVar.b(new m.PartnerReportData("pg_aio_swipleft", "em_bas_card_punch_card", "dt_clck", bVar2, str != null ? "" : str, "2"));
            }
        }
        bVar = null;
        com.tencent.mobileqq.partner.signin.b bVar22 = bVar;
        String str2 = this$0.partnerUin;
        mVar.b(new m.PartnerReportData("pg_aio_swipleft", "em_bas_card_punch_card", "dt_clck", bVar22, str2 != null ? "" : str2, "2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int selectPos) {
        a aVar = this.adapter;
        int i3 = 0;
        int f373114d = aVar != null ? aVar.getF373114d() : 0;
        if (selectPos < 0 || selectPos >= f373114d) {
            return;
        }
        int size = this.tabTextViews.size();
        while (i3 < size) {
            TextView textView = this.tabTextViews.get(i3);
            textView.setTextColor(ContextCompat.getColorStateList(textView.getContext(), i3 == selectPos ? R.color.qui_common_text_primary : R.color.qui_common_text_secondary));
            if (i3 == selectPos) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                textView.setTypeface(null);
            }
            i3++;
        }
        B(selectPos);
    }

    private final void y(f61.h mutualMarkList) {
        List<f> list = mutualMarkList.f397928i;
        List<f> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Map<Long, String> w3 = w(mutualMarkList);
        this.tabTextViews.clear();
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        int size = list.size();
        for (final int i3 = 0; i3 < size; i3++) {
            f fVar = list.get(i3);
            LinearLayout linearLayout2 = this.tabLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                linearLayout2 = null;
            }
            TextView textView = new TextView(linearLayout2.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.setMarginEnd(ViewUtils.dpToPx(16.0f));
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(14.0f);
            String str = w3.get(Long.valueOf(fVar.c()));
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.partner.signin.drawer.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.z(e.this, i3, view);
                }
            });
            this.tabTextViews.add(textView);
            LinearLayout linearLayout3 = this.tabLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                linearLayout3 = null;
            }
            linearLayout3.addView(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(e this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager viewPager = this$0.viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager = null;
        }
        viewPager.setCurrentItem(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.oho);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.tab_layout)");
        this.tabLayout = (LinearLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.oh9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.iv_next)");
        this.nextIv = findViewById2;
        View findViewById3 = containerView.findViewById(R.id.ohy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.view_pager)");
        ViewPager viewPager = (ViewPager) findViewById3;
        this.viewPager = viewPager;
        ViewPager viewPager2 = null;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager = null;
        }
        a aVar = new a();
        this.adapter = aVar;
        viewPager.setAdapter(aVar);
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager2 = viewPager3;
        }
        viewPager2.addOnPageChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r9 >= (r1 != null ? r1.getF373114d() : 0)) goto L25;
     */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(IntimateBaseModel data, int position, List<Object> payload) {
        String str;
        List<f> list;
        List<f> e16;
        Object orNull;
        IntimateInfo intimateInfo;
        if (data == null || (str = data.getFriendUin()) == null) {
            str = "";
        }
        this.partnerUin = str;
        com.tencent.mobileqq.partner.signin.b bVar = null;
        f61.h hVar = (data == null || (intimateInfo = data.getIntimateInfo()) == null) ? null : intimateInfo.mutualMarkList;
        if (hVar == null || (list = hVar.f397928i) == null) {
            return;
        }
        y(hVar);
        A(list, this.partnerUin);
        int i3 = this.selectPos;
        if (i3 >= 0) {
            a aVar = this.adapter;
        }
        this.selectPos = 0;
        D(this.selectPos);
        m mVar = m.f306784a;
        a aVar2 = this.adapter;
        if (aVar2 != null && (e16 = aVar2.e()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(e16, this.selectPos);
            f fVar = (f) orNull;
            if (fVar != null) {
                bVar = fVar.a();
            }
        }
        com.tencent.mobileqq.partner.signin.b bVar2 = bVar;
        String str2 = this.partnerUin;
        mVar.b(new m.PartnerReportData("pg_aio_swipleft", "em_bas_card_punch_card", "dt_imp", bVar2, str2 == null ? "" : str2, "2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\rH\u0016R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/drawer/e$a;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/partner/signin/drawer/f;", "info", "", "f", "", "getCount", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "position", "", "instantiateItem", "obj", "destroyItem", "view", "", "isViewFromObject", "getItemPosition", "", "d", "Ljava/util/List;", "e", "()Ljava/util/List;", h.F, "(Ljava/util/List;)V", "infoList", "", "Ljava/lang/String;", "getPartnerUin", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "partnerUin", "<init>", "()V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private List<f> infoList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String partnerUin;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(f info, View itemView, a this$0, View view) {
            Intrinsics.checkNotNullParameter(info, "$info");
            Intrinsics.checkNotNullParameter(itemView, "$itemView");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String b16 = info.b();
            if (b16 == null || b16.length() == 0) {
                return;
            }
            com.tencent.mobileqq.webview.util.f fVar = com.tencent.mobileqq.webview.util.f.f314875a;
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            String b17 = info.b();
            if (b17 == null) {
                b17 = "";
            }
            fVar.k(context, b17, new Bundle(), 0.9f);
            m mVar = m.f306784a;
            com.tencent.mobileqq.partner.signin.b a16 = info.a();
            String str = this$0.partnerUin;
            mVar.b(new m.PartnerReportData("pg_aio_swipleft", "em_bas_card_punch_card", "dt_clck", a16, str == null ? "" : str, "2"));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object obj) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(obj, "obj");
            if (obj instanceof View) {
                container.removeView((View) obj);
            }
        }

        public final List<f> e() {
            return this.infoList;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            List<f> list = this.infoList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return -2;
        }

        public final void h(List<f> list) {
            this.infoList = list;
        }

        public final void i(String str) {
            this.partnerUin = str;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            Object orNull;
            Intrinsics.checkNotNullParameter(container, "container");
            View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.cvv, container, false);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            itemView.setPadding(ViewUtils.dip2px(16.0f), ViewUtils.dip2px(20.0f), ViewUtils.dip2px(16.0f), ViewUtils.dip2px(20.0f));
            List<f> list = this.infoList;
            if (list != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, position);
                f fVar = (f) orNull;
                if (fVar != null) {
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    f(itemView, fVar);
                }
            }
            container.addView(itemView);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return itemView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(obj, "obj");
            return Intrinsics.areEqual(view, obj);
        }

        private final void f(final View itemView, final f info) {
            PartnerSignInInfoView partnerSignInInfoView = (PartnerSignInInfoView) itemView.findViewById(R.id.ohn);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            String str = this.partnerUin;
            partnerSignInInfoView.J0(currentAccountUin, str != null ? str : "", info.a());
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.partner.signin.drawer.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.a.g(f.this, itemView, this, view);
                }
            });
        }
    }

    private final Map<Long, String> w(f61.h mutualMarkList) {
        Map<Long, String> emptyMap;
        List<MutualMarkModel> list = mutualMarkList != null ? mutualMarkList.f397922c : null;
        if (list == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MutualMarkModel mutualMarkModel : list) {
            Long valueOf = Long.valueOf(mutualMarkModel.D);
            String str = mutualMarkModel.E;
            if (str == null) {
                str = "";
            }
            linkedHashMap.put(valueOf, str);
        }
        return linkedHashMap;
    }
}
