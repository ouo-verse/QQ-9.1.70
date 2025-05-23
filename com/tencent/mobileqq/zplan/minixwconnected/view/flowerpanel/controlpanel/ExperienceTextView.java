package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.MiniHomeFlowerConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001#B%\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J,\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J0\u0010\u000f\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J*\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/ExperienceTextView;", "Landroid/widget/RelativeLayout;", "", "add", "", "value", "Lkotlin/Function1;", "", "completed", h.F, "", "", "urlList", "Landroid/graphics/drawable/Drawable;", "callback", "f", "g", "url", "e", "Lcom/tencent/image/URLDrawable;", "d", "Landroid/view/View;", "c", "preValue", "currentValue", "b", "Landroid/view/View;", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ExperienceTextView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View contentView;

    public /* synthetic */ ExperienceTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final URLDrawable d(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, option)");
        return drawable;
    }

    private final void e(String url, Function1<? super Drawable, Unit> callback) {
        if (url.length() == 0) {
            callback.invoke(null);
            return;
        }
        URLDrawable d16 = d(url);
        if (d16.getStatus() == 1) {
            callback.invoke(d16);
        } else {
            d16.setURLDrawableListener(new b(callback));
            d16.startDownload();
        }
    }

    private final void f(List<String> urlList, final Function1<? super List<? extends Drawable>, Unit> callback) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        final Map mutableMap;
        int collectionSizeOrDefault2;
        QLog.i("ExperienceTextView", 1, "drawable urlList = " + urlList);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = urlList.size();
        List<String> list = urlList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(obj, null);
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
        for (final String str : list) {
            QLog.i("ExperienceTextView", 1, "start current url = " + str);
            e(str, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.ExperienceTextView$getDrawableList$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Drawable drawable) {
                    int collectionSizeOrDefault3;
                    QLog.i("ExperienceTextView", 1, "end url = " + str);
                    mutableMap.put(str, drawable);
                    Ref.IntRef intRef2 = intRef;
                    int i3 = intRef2.element - 1;
                    intRef2.element = i3;
                    if (i3 <= 0) {
                        ArrayList arrayList2 = new ArrayList();
                        Collection<Drawable> values = mutableMap.values();
                        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(values, 10);
                        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
                        for (Drawable drawable2 : values) {
                            arrayList3.add(drawable2 != null ? Boolean.valueOf(arrayList2.add(drawable2)) : null);
                        }
                        callback.invoke(arrayList2);
                    }
                }
            });
            arrayList.add(Unit.INSTANCE);
        }
    }

    private final List<String> g(boolean add, int value) {
        String e16;
        StringBuilder sb5;
        String str;
        ArrayList arrayList = new ArrayList();
        MiniHomeFlowerConfig miniHomeFlowerConfig = MiniHomeFlowerConfig.f334654a;
        String experiencePrefixUrl = miniHomeFlowerConfig.c().getExperiencePrefixUrl();
        if (add) {
            e16 = miniHomeFlowerConfig.f();
            sb5 = new StringBuilder();
        } else {
            e16 = miniHomeFlowerConfig.e();
            sb5 = new StringBuilder();
        }
        sb5.append(experiencePrefixUrl);
        sb5.append(e16);
        arrayList.add(sb5.toString());
        String valueOf = String.valueOf(value);
        ArrayList arrayList2 = new ArrayList(valueOf.length());
        for (int i3 = 0; i3 < valueOf.length(); i3++) {
            int numericValue = Character.getNumericValue(valueOf.charAt(i3));
            if (add) {
                str = String.valueOf(numericValue);
            } else {
                str = "_" + numericValue;
            }
            arrayList2.add(Boolean.valueOf(arrayList.add(experiencePrefixUrl + str + ".png")));
        }
        return arrayList;
    }

    private final void h(boolean add, int value, final Function1<? super Integer, Unit> completed) {
        f(g(add, value), new Function1<List<? extends Drawable>, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.ExperienceTextView$setExperienceImages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Drawable> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends Drawable> drawList) {
                int collectionSizeOrDefault;
                View view;
                ImageView imageView;
                Intrinsics.checkNotNullParameter(drawList, "drawList");
                List<? extends Drawable> list = drawList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                int i3 = 0;
                int i16 = 0;
                while (it.hasNext()) {
                    i16 += ((Drawable) it.next()).getIntrinsicWidth();
                    arrayList.add(Unit.INSTANCE);
                }
                QLog.i("ExperienceTextView", 1, "totalWidth = " + i16);
                Object[] array = drawList.toArray(new Drawable[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) array);
                int i17 = 0;
                int i18 = i16;
                for (Drawable drawable : drawList) {
                    int intrinsicWidth = i18 - drawable.getIntrinsicWidth();
                    layerDrawable.setLayerInset(i3, i17, 0, intrinsicWidth, 0);
                    QLog.i("ExperienceTextView", 1, "setLayerInset index=" + i3 + ", left=" + i17 + ", right=" + intrinsicWidth);
                    i17 += drawable.getIntrinsicWidth();
                    i3++;
                    i18 = intrinsicWidth;
                }
                view = ExperienceTextView.this.contentView;
                if (view != null && (imageView = (ImageView) view.findViewById(R.id.pta)) != null) {
                    imageView.setImageDrawable(layerDrawable);
                }
                completed.invoke(Integer.valueOf(i16));
            }
        });
    }

    public final void b(int preValue, int currentValue, final Function1<? super Integer, Unit> completed) {
        Intrinsics.checkNotNullParameter(completed, "completed");
        QLog.i("ExperienceTextView", 1, "preValue value = " + preValue + "  currentValue value=" + currentValue);
        boolean z16 = currentValue > preValue;
        int abs = Math.abs(currentValue - preValue);
        if (abs == 0) {
            return;
        }
        h(z16, abs, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.ExperienceTextView$addExperience$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                completed.invoke(Integer.valueOf(i3));
            }
        });
    }

    public final View c() {
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dda, this);
        this.contentView = inflate;
        return inflate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperienceTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/ExperienceTextView$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Drawable, Unit> f334658d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Drawable, Unit> function1) {
            this.f334658d = function1;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
            this.f334658d.invoke(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            this.f334658d.invoke(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            this.f334658d.invoke(drawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
        }
    }
}
