package com.tencent.mobileqq.zplan.aigc.view.viewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem;
import com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitWhiteModelHolder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import uv4.az;
import uv4.bn;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b4\u00105J\u009c\u0001\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\r0\n26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\r0\nH\u0007R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u001b\u0010(\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u001b\u0010+\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001fR\u001b\u0010-\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b\u0016\u0010\u001fR\u001b\u00100\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001fR\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010)\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/viewHolder/SuitWhiteModelHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lzd3/a;", "dtReporter", "Lcom/tencent/mobileqq/zplan/aigc/data/o;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "lastItem", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "onItemClick", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onLoadBitmapSuccess", "r", "Landroid/view/View;", "E", "Landroid/view/View;", "v", "Landroid/content/Context;", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "G", "Lkotlin/Lazy;", "w", "()Landroid/widget/ImageView;", "whiteModelImage", "Landroid/widget/TextView;", "H", HippyTKDListViewAdapter.X, "()Landroid/widget/TextView;", "whiteModelName", "I", "u", "lastItemImage", "J", "getWhiteModelBG", "whiteModelBG", "K", "placeHolder", "L", "getWhiteModelPressBG", "whiteModelPressBG", "", "M", "lastClickTime", "<init>", "(Landroid/view/View;Landroid/content/Context;)V", "N", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitWhiteModelHolder extends RecyclerView.ViewHolder {
    private static final String P = "SuitWhiteModelHolder";

    /* renamed from: E, reason: from kotlin metadata */
    private final View v;

    /* renamed from: F, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy whiteModelImage;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy whiteModelName;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy lastItemImage;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy whiteModelBG;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy placeHolder;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy whiteModelPressBG;

    /* renamed from: M, reason: from kotlin metadata */
    private long lastClickTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/aigc/view/viewHolder/SuitWhiteModelHolder$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<Bitmap, Integer, Unit> f330775e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f330776f;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Bitmap, ? super Integer, Unit> function2, int i3) {
            this.f330775e = function2;
            this.f330776f = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SuitWhiteModelHolder this$0, Function2 onLoadBitmapSuccess, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(onLoadBitmapSuccess, "$onLoadBitmapSuccess");
            com.tencent.xaction.log.b.a(SuitWhiteModelHolder.P, 1, "onLoadSuccessed");
            Bitmap bitmap = Bitmap.createBitmap(this$0.w().getWidth(), this$0.w().getHeight(), Bitmap.Config.ARGB_8888);
            this$0.w().draw(new Canvas(bitmap));
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            onLoadBitmapSuccess.invoke(bitmap, Integer.valueOf(i3));
            this$0.v().setVisibility(8);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
            com.tencent.xaction.log.b.a(SuitWhiteModelHolder.P, 1, " onLoadCanceled");
            SuitWhiteModelHolder.this.v().setVisibility(0);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            com.tencent.xaction.log.b.a(SuitWhiteModelHolder.P, 1, "onLoadFialed");
            SuitWhiteModelHolder.this.v().setVisibility(0);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
            SuitWhiteModelHolder.this.v().setVisibility(0);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            ImageView w3 = SuitWhiteModelHolder.this.w();
            final SuitWhiteModelHolder suitWhiteModelHolder = SuitWhiteModelHolder.this;
            final Function2<Bitmap, Integer, Unit> function2 = this.f330775e;
            final int i3 = this.f330776f;
            w3.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.d
                @Override // java.lang.Runnable
                public final void run() {
                    SuitWhiteModelHolder.b.b(SuitWhiteModelHolder.this, function2, i3);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitWhiteModelHolder(View v3, Context context) {
        super(v3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(context, "context");
        this.v = v3;
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitWhiteModelHolder$whiteModelImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = SuitWhiteModelHolder.this.v;
                return (ImageView) view.findViewById(R.id.q2x);
            }
        });
        this.whiteModelImage = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitWhiteModelHolder$whiteModelName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = SuitWhiteModelHolder.this.v;
                return (TextView) view.findViewById(R.id.qtv);
            }
        });
        this.whiteModelName = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitWhiteModelHolder$lastItemImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = SuitWhiteModelHolder.this.v;
                return (ImageView) view.findViewById(R.id.q4g);
            }
        });
        this.lastItemImage = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitWhiteModelHolder$whiteModelBG$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = SuitWhiteModelHolder.this.v;
                return (ImageView) view.findViewById(R.id.qyu);
            }
        });
        this.whiteModelBG = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitWhiteModelHolder$placeHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = SuitWhiteModelHolder.this.v;
                return (ImageView) view.findViewById(R.id.qyx);
            }
        });
        this.placeHolder = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.SuitWhiteModelHolder$whiteModelPressBG$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = SuitWhiteModelHolder.this.v;
                return (ImageView) view.findViewById(R.id.qyv);
            }
        });
        this.whiteModelPressBG = lazy6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void s(SuitWhiteModelHolder this$0, SuitWhiteModelItem suitWhiteModelItem, Ref.ObjectRef drawable, Function2 onItemClick, int i3, Map doneReportParams, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
        Intrinsics.checkNotNullParameter(doneReportParams, "$doneReportParams");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime > 500) {
            this$0.lastClickTime = currentTimeMillis;
            if (suitWhiteModelItem == null || ((URLDrawable) drawable.element).getStatus() != 1) {
                return;
            }
            onItemClick.invoke(suitWhiteModelItem, Integer.valueOf(i3));
            VideoReport.reportEvent("dt_clck", this$0.v, doneReportParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(SuitWhiteModelHolder this$0, Function2 onLoadBitmapSuccess, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onLoadBitmapSuccess, "$onLoadBitmapSuccess");
        Bitmap bitmap = Bitmap.createBitmap(this$0.w().getWidth(), this$0.w().getHeight(), Bitmap.Config.ARGB_8888);
        this$0.w().draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        onLoadBitmapSuccess.invoke(bitmap, Integer.valueOf(i3));
    }

    private final ImageView u() {
        Object value = this.lastItemImage.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-lastItemImage>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView v() {
        Object value = this.placeHolder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-placeHolder>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView w() {
        Object value = this.whiteModelImage.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-whiteModelImage>(...)");
        return (ImageView) value;
    }

    private final TextView x() {
        Object value = this.whiteModelName.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-whiteModelName>(...)");
        return (TextView) value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.tencent.image.URLDrawable] */
    public final void r(zd3.a dtReporter, final SuitWhiteModelItem item, final int position, boolean lastItem, final Function2<? super SuitWhiteModelItem, ? super Integer, Unit> onItemClick, final Function2<? super Bitmap, ? super Integer, Unit> onLoadBitmapSuccess) {
        bn data;
        az azVar;
        Intrinsics.checkNotNullParameter(dtReporter, "dtReporter");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onLoadBitmapSuccess, "onLoadBitmapSuccess");
        if (lastItem) {
            u().setVisibility(0);
            w().setVisibility(8);
            x().setVisibility(8);
            v().setVisibility(8);
            return;
        }
        w().setVisibility(0);
        u().setVisibility(8);
        String str = null;
        String valueOf = String.valueOf(item != null ? item.getImageUrl() : null);
        if (item != null && (data = item.getData()) != null && (azVar = data.f440382g) != null) {
            str = azVar.f440277d;
        }
        x().setVisibility(0);
        x().setText(str);
        try {
            Result.Companion companion = Result.INSTANCE;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = new ColorDrawable(0);
            obtain.mLoadingDrawable = new ColorDrawable(0);
            Unit unit = Unit.INSTANCE;
            objectRef.element = URLDrawable.getDrawable(valueOf, obtain);
            w().setImageDrawable((Drawable) objectRef.element);
            v().setVisibility(8);
            com.tencent.xaction.log.b.a(P, 1, "status " + ((URLDrawable) objectRef.element).getStatus());
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (item != null) {
                linkedHashMap.put("zplan_model_id", item.getItemId());
            }
            linkedHashMap.put("dt_pgid", "pg_zplan_create_new");
            zd3.a.y(dtReporter, this.v, "em_zplan_model", linkedHashMap, null, 8, null);
            this.v.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuitWhiteModelHolder.s(SuitWhiteModelHolder.this, item, objectRef, onItemClick, position, linkedHashMap, view);
                }
            });
            if (((URLDrawable) objectRef.element).getStatus() == 1) {
                w().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.view.viewHolder.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitWhiteModelHolder.t(SuitWhiteModelHolder.this, onLoadBitmapSuccess, position);
                    }
                });
            }
            ((URLDrawable) objectRef.element).setURLDrawableListener(new b(onLoadBitmapSuccess, position));
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }
}
