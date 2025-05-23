package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.weather.event.WeatherBannerTitleShowEvent;
import com.tencent.mobileqq.weather.event.WeatherScrollStateChanged;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\bE\u0010FJ\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J*\u0010\u001b\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\n2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0014J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\u0012\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#`$H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R$\u00106\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u000103028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u00109\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u000107028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00105R$\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00105R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R:\u0010D\u001a&\u0012\f\u0012\n @*\u0004\u0018\u00010\n0\n @*\u0012\u0012\f\u0012\n @*\u0004\u0018\u00010\n0\n\u0018\u00010A0?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/weather/part/ac;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Lcom/tencent/mobileqq/weather/data/o;", "bannerDataList", "v", "dataItem", "", "bannerWeight", "", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "r", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "t", "", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "d", "Ljava/lang/String;", "TAG", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mContainer", "Lcom/tencent/mobileqq/weather/data/n;", "f", "Lcom/tencent/mobileqq/weather/data/n;", "mCurrentBean", "", "Landroid/widget/ImageView;", tl.h.F, "Ljava/util/Map;", "mBannerImageMap", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "i", "mBannerDrawableMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mBannerDataItemMap", BdhLogUtil.LogTag.Tag_Conn, "I", "mPagePos", "", "kotlin.jvm.PlatformType", "", "D", "Ljava/util/Set;", "mHasExposeReportedSet", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ac extends Section<com.tencent.mobileqq.weather.data.k> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int mPagePos;

    /* renamed from: D, reason: from kotlin metadata */
    private Set<Integer> mHasExposeReportedSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.weather.data.n mCurrentBean;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, ImageView> mBannerImageMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, APNGDrawable> mBannerDrawableMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, com.tencent.mobileqq.weather.data.o> mBannerDataItemMap;

    public ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "WeatherRecommendBannerSection";
        this.mBannerImageMap = new HashMap();
        this.mBannerDrawableMap = new HashMap();
        this.mBannerDataItemMap = new HashMap();
        this.mHasExposeReportedSet = Collections.synchronizedSet(new HashSet());
    }

    private final void r() {
        for (Map.Entry<Integer, ImageView> entry : this.mBannerImageMap.entrySet()) {
            if (entry.getValue() != null && com.tencent.mobileqq.weather.util.b.d(entry.getValue()) > 0.0f) {
                u(entry.getKey().intValue());
            }
        }
    }

    private final void s() {
        if (this.mPagePos == 0) {
            QLog.d(this.TAG, 1, "dispatchEvent: WeatherBannerTitleShowEvent");
            SimpleEventBus.getInstance().dispatchEvent(new WeatherBannerTitleShowEvent(2));
        }
    }

    private final void u(int bannerWeight) {
        com.tencent.mobileqq.weather.data.o oVar;
        if (!this.mHasExposeReportedSet.contains(Integer.valueOf(bannerWeight)) && bannerWeight >= 0 && (oVar = this.mBannerDataItemMap.get(Integer.valueOf(bannerWeight))) != null) {
            com.tencent.mobileqq.weather.mvvm.h.f313416a.g(oVar, "banner" + bannerWeight);
            com.tencent.mobileqq.weather.util.report.o.f313691a.c(bannerWeight);
            this.mHasExposeReportedSet.add(Integer.valueOf(bannerWeight));
        }
    }

    private final List<com.tencent.mobileqq.weather.data.o> v(List<com.tencent.mobileqq.weather.data.o> bannerDataList) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (com.tencent.mobileqq.weather.data.o oVar : bannerDataList) {
            if (oVar.d() == 0) {
                arrayList3.add(oVar);
            } else {
                arrayList2.add(oVar);
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.tencent.mobileqq.weather.part.ab
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int w3;
                w3 = ac.w((com.tencent.mobileqq.weather.data.o) obj, (com.tencent.mobileqq.weather.data.o) obj2);
                return w3;
            }
        });
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3++;
            ((com.tencent.mobileqq.weather.data.o) it.next()).o(i3);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int w(com.tencent.mobileqq.weather.data.o oVar, com.tencent.mobileqq.weather.data.o oVar2) {
        return oVar.d() - oVar2.d();
    }

    private final void x(final com.tencent.mobileqq.weather.data.o dataItem, final int bannerWeight) {
        this.mBannerDataItemMap.put(Integer.valueOf(bannerWeight), dataItem);
        final ImageView imageView = this.mBannerImageMap.get(Integer.valueOf(bannerWeight));
        if (imageView != null) {
            GdtUIUtils.setViewRadius(imageView, 6.0f);
            this.mBannerDrawableMap.put(Integer.valueOf(bannerWeight), ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable(this.TAG, dataItem.i(), new ApngOptions()));
            imageView.setImageDrawable(this.mBannerDrawableMap.get(Integer.valueOf(bannerWeight)));
            imageView.setContentDescription("\u7cbe\u5f69\u63a8\u8350");
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ac.y(com.tencent.mobileqq.weather.data.o.this, imageView, bannerWeight, view);
                }
            });
            QLog.d(this.TAG, 2, "updateBannerView id:", Integer.valueOf(dataItem.a()), ",weight:", dataItem.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(com.tencent.mobileqq.weather.data.o dataItem, ImageView it, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dataItem, "$dataItem");
        Intrinsics.checkNotNullParameter(it, "$it");
        if (Intrinsics.areEqual(dataItem.m(), "1")) {
            com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
            Context context = it.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            gVar.P(context, dataItem.h());
        } else if (Intrinsics.areEqual(dataItem.m(), "2")) {
            com.tencent.mobileqq.weather.util.g gVar2 = com.tencent.mobileqq.weather.util.g.f313646a;
            Context context2 = it.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "it.context");
            gVar2.N(context2, dataItem.h());
        }
        com.tencent.mobileqq.weather.mvvm.h.f313416a.f(dataItem, "banner" + i3);
        if (dataItem.l() == 1186) {
            com.tencent.mobileqq.weather.util.report.o.f313691a.b(i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherScrollStateChanged.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1192976g};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, attached);
            return;
        }
        super.onAttachedChanged(attached);
        if (attached) {
            SimpleEventBus.getInstance().registerReceiver(this);
            r();
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
        QLog.d(this.TAG, 1, "attached:", Boolean.valueOf(attached));
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mHasExposeReportedSet.clear();
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            this.mContainer = (FrameLayout) containerView.findViewById(R.id.f121477bc);
            this.mBannerImageMap.put(1, containerView.findViewById(R.id.f121487bd));
            this.mBannerImageMap.put(2, containerView.findViewById(R.id.f121497be));
            this.mBannerImageMap.put(3, containerView.findViewById(R.id.f121507bf));
            this.mBannerImageMap.put(4, containerView.findViewById(R.id.f121517bg));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
        } else if (event instanceof WeatherScrollStateChanged) {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        int i3;
        List<com.tencent.mobileqq.weather.data.o> list;
        int d16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (!(data instanceof com.tencent.mobileqq.weather.data.n)) {
            return;
        }
        com.tencent.mobileqq.weather.data.n nVar = this.mCurrentBean;
        if (nVar != null) {
            if (nVar != null && nVar.d(data)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
        }
        com.tencent.mobileqq.weather.data.n nVar2 = (com.tencent.mobileqq.weather.data.n) data;
        this.mCurrentBean = nVar2;
        if (nVar2 != null) {
            i3 = nVar2.a();
        } else {
            i3 = 0;
        }
        this.mPagePos = i3;
        com.tencent.mobileqq.weather.data.n nVar3 = this.mCurrentBean;
        if (nVar3 != null) {
            list = nVar3.e();
        } else {
            list = null;
        }
        List<com.tencent.mobileqq.weather.data.o> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z17 = false;
        }
        if (z17) {
            FrameLayout frameLayout = this.mContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.mContainer;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        for (com.tencent.mobileqq.weather.data.o oVar : v(list)) {
            if (oVar.d() == 0) {
                d16 = 4;
            } else {
                d16 = oVar.d();
            }
            x(oVar, d16);
        }
        s();
    }
}
