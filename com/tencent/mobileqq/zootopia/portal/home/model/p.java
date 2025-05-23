package com.tencent.mobileqq.zootopia.portal.home.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import fi3.aa;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B)\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0018\b\u0002\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00130$j\b\u0012\u0004\u0012\u00020\u0013`%\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0014\u0010\u0015\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00130$j\b\u0012\u0004\u0012\u00020\u0013`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/model/p;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zootopia/portal/home/model/p$b;", "Landroid/graphics/drawable/Drawable;", "m0", "holder", "", "v0", "u0", "", "url", "l0", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "o0", "Lcom/tencent/mobileqq/zootopia/portal/home/b;", "sameStyleClickListener", "t0", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "result", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "s0", "position", "q0", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "dataList", "D", "Lcom/tencent/mobileqq/zootopia/portal/home/b;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "E", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class p extends RecyclerView.Adapter<b> {
    private static float F = ViewUtils.dpToPx(12.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private final ArrayList<ZPlanTemplate> dataList;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.portal.home.b sameStyleClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/model/p$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfi3/aa;", "E", "Lfi3/aa;", "l", "()Lfi3/aa;", "binding", "<init>", "(Lfi3/aa;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final aa binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(aa binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        /* renamed from: l, reason: from getter */
        public final aa getBinding() {
            return this.binding;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/model/p$c", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "onLoadCanceled", "", "throwable", "onLoadFialed", "", "progress", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements URLDrawable.URLDrawableListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f328918e;

        c(b bVar) {
            this.f328918e = bVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable urlDrawable) {
            QLog.i("ZootopiaSameStyleAdapter", 1, "onLoadCanceled");
            p.this.o0(urlDrawable, this.f328918e);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable urlDrawable, Throwable throwable) {
            QLog.i("ZootopiaSameStyleAdapter", 1, "onLoadFialed");
            p.this.o0(urlDrawable, this.f328918e);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            QLog.i("ZootopiaSameStyleAdapter", 1, "onLoadSuccessed");
            p.this.o0(urlDrawable, this.f328918e);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable urlDrawable, int progress) {
        }
    }

    public /* synthetic */ p(Context context, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new ArrayList() : arrayList);
    }

    private final void l0(String url, b holder) {
        boolean endsWith$default;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = holder.getBinding().f398779f.getLayoutParams().width;
        obtain.mRequestHeight = holder.getBinding().f398779f.getLayoutParams().height;
        obtain.mPlayGifImage = true;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(url, ".apng", false, 2, null);
        obtain.mUseApngImage = endsWith$default;
        obtain.mFailedDrawable = m0();
        obtain.mMemoryCacheKeySuffix = "zootpiaListSameStyle";
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        holder.getBinding().f398779f.setImageDrawable(drawable);
        if (drawable.getStatus() == 1) {
            u0(holder);
            return;
        }
        v0(holder);
        ImageView imageView = holder.getBinding().f398780g;
        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
        obtain2.mRequestWidth = holder.getBinding().f398780g.getLayoutParams().width;
        obtain2.mRequestHeight = holder.getBinding().f398780g.getLayoutParams().height;
        obtain2.mPlayGifImage = true;
        Unit unit = Unit.INSTANCE;
        imageView.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/zplan/zplan_template_loading.gif", obtain2));
        drawable.startDownload();
        drawable.setURLDrawableListener(new c(holder));
    }

    private final Drawable m0() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(3.0f));
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{-1118482, -1, -1118482});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(URLDrawable urlDrawable, final b holder) {
        if (Intrinsics.areEqual(urlDrawable, holder.getBinding().f398779f.getDrawable())) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.o
                @Override // java.lang.Runnable
                public final void run() {
                    p.p0(p.this, holder);
                }
            });
        }
        if (urlDrawable != null) {
            urlDrawable.setURLDrawableListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(p this$0, b holder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.u0(holder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(p this$0, ZPlanTemplate dataInfo, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        com.tencent.mobileqq.zootopia.portal.home.b bVar = this$0.sameStyleClickListener;
        if (bVar != null) {
            bVar.ze(dataInfo);
        }
        id3.e eVar = id3.e.f407552a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        eVar.i(it, dataInfo.getId(), dataInfo.getContentType());
    }

    private final void u0(b holder) {
        holder.getBinding().f398780g.setVisibility(8);
        holder.getBinding().f398779f.setVisibility(0);
    }

    private final void v0(b holder) {
        holder.getBinding().f398780g.setVisibility(0);
        holder.getBinding().f398779f.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    public final void n0(List<ZPlanTemplate> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.dataList.clear();
        List<ZPlanTemplate> list = result;
        if (!list.isEmpty()) {
            this.dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ZPlanTemplate zPlanTemplate = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(zPlanTemplate, "dataList[position]");
        final ZPlanTemplate zPlanTemplate2 = zPlanTemplate;
        if (zPlanTemplate2 instanceof ZPlanTemplate) {
            holder.getBinding().f398779f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.r0(p.this, zPlanTemplate2, view);
                }
            });
            if (zPlanTemplate2.getContentType() == 0) {
                holder.getBinding().f398777d.setVisibility(8);
            } else {
                holder.getBinding().f398777d.setVisibility(0);
            }
            l0(zPlanTemplate2.getCoverUrl(), holder);
            holder.getBinding().f398778e.setText(zPlanTemplate2.getDisplayName());
            id3.e eVar = id3.e.f407552a;
            ImageView imageView = holder.getBinding().f398779f;
            Intrinsics.checkNotNullExpressionValue(imageView, "holder.binding.videoPreview");
            eVar.d(imageView, zPlanTemplate2.getId(), zPlanTemplate2.getContentType());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        aa g16 = aa.g(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = g16.f398775b;
        float f16 = F;
        roundCorneredRelativeLayout.setRadius(f16, f16, f16, f16);
        return new b(g16);
    }

    public final void t0(com.tencent.mobileqq.zootopia.portal.home.b sameStyleClickListener) {
        this.sameStyleClickListener = sameStyleClickListener;
    }

    public p(Context context, ArrayList<ZPlanTemplate> dataList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.context = context;
        this.dataList = dataList;
    }
}
