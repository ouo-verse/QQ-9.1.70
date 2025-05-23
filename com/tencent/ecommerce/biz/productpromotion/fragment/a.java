package com.tencent.ecommerce.biz.productpromotion.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import yj0.ECPromoteItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002$%B!\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u001c\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0007J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/productpromotion/fragment/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/productpromotion/fragment/a$b;", "", "position", "Lyj0/c;", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "", "k0", "", "promotionList", "setData", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "promotionItemList", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", "Landroid/app/Activity;", "D", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "E", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "promotionProductCallback", "<init>", "(Landroid/content/Context;Landroid/app/Activity;Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;)V", UserInfo.SEX_FEMALE, "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    public final Context context;

    /* renamed from: D, reason: from kotlin metadata */
    public final Activity activity;

    /* renamed from: E, reason: from kotlin metadata */
    private final IECSchemeCallback promotionProductCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<ECPromoteItem> promotionItemList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/productpromotion/fragment/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "itemIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "itemName", "Landroid/view/View;", "G", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/ecommerce/biz/productpromotion/fragment/a;Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView itemIcon;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView itemName;

        /* renamed from: G, reason: from kotlin metadata */
        public final View view;

        public b(View view) {
            super(view);
            this.view = view;
            this.itemIcon = (ImageView) view.findViewById(R.id.o7r);
            this.itemName = (TextView) view.findViewById(R.id.o7s);
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getItemIcon() {
            return this.itemIcon;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getItemName() {
            return this.itemName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/productpromotion/fragment/ECPromotionAdapter$onBindViewHolder$1$1$2", "com/tencent/ecommerce/biz/productpromotion/fragment/ECPromotionAdapter$$special$$inlined$with$lambda$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f103943e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ECPromoteItem f103944f;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/productpromotion/fragment/ECPromotionAdapter$onBindViewHolder$1$1$2$1", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug", "com/tencent/ecommerce/biz/productpromotion/fragment/ECPromotionAdapter$$special$$inlined$with$lambda$1$1"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.productpromotion.fragment.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1085a implements IECSchemeCallback {
            C1085a() {
            }

            @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
            public void onCallbackFinished(JSONObject data) {
                if (data.optInt("code") != 1) {
                    IECSchemeCallback iECSchemeCallback = a.this.promotionProductCallback;
                    if (iECSchemeCallback != null) {
                        iECSchemeCallback.onCallbackFinished(data);
                    }
                    a.this.activity.finish();
                }
            }
        }

        c(b bVar, ECPromoteItem eCPromoteItem) {
            this.f103943e = bVar;
            this.f103944f = eCPromoteItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.f(this.f103944f.url, new C1085a(), null, 4, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/productpromotion/fragment/a$d", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements Function1<Drawable, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f103946d;

        d(ImageView imageView) {
            this.f103946d = imageView;
        }

        public void a(Drawable drawable) {
            this.f103946d.setImageDrawable(drawable);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            a(drawable);
            return Unit.INSTANCE;
        }
    }

    public a(Context context, Activity activity, IECSchemeCallback iECSchemeCallback) {
        this.context = context;
        this.activity = activity;
        this.promotionProductCallback = iECSchemeCallback;
    }

    private final ECPromoteItem j0(int position) {
        if (getNUM_BACKGOURND_ICON() <= 0 || position < 0 || position >= getNUM_BACKGOURND_ICON()) {
            return null;
        }
        return this.promotionItemList.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.promotionItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        String str;
        ECPromoteItem j06 = j0(position);
        if (j06 != null) {
            ImageView itemIcon = holder.getItemIcon();
            IECImageLoader imageLoader = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader();
            Context context = itemIcon.getContext();
            if (fg0.a.f398587b.a()) {
                str = j06.nightImg;
            } else {
                str = j06.img;
            }
            IECImageLoader.a.a(imageLoader, context, str, null, new d(itemIcon), 4, null);
            holder.getItemName().setText(j06.msg);
            holder.view.setOnClickListener(new c(holder, j06));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Object systemService = this.context.getSystemService("layout_inflater");
        if (systemService != null) {
            return new b(((LayoutInflater) systemService).inflate(R.layout.ctd, parent, false));
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final void setData(List<ECPromoteItem> promotionList) {
        if (promotionList != null) {
            this.promotionItemList = promotionList;
            notifyDataSetChanged();
        }
    }
}
