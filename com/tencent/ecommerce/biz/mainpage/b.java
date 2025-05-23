package com.tencent.ecommerce.biz.mainpage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0014\u0010\u0013\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0011R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/mainpage/f;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "Lcom/tencent/ecommerce/biz/mainpage/d;", "i0", "getItemCount", "", "getItemId", "", "pageIteList", "setData", "Lcom/tencent/ecommerce/biz/mainpage/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/mainpage/c;", "diffCallback", "Landroidx/recyclerview/widget/AsyncListDiffer;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "D", "Ljava/lang/ref/WeakReference;", "weakReference", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends RecyclerView.Adapter<f> {

    /* renamed from: C, reason: from kotlin metadata */
    private final AsyncListDiffer<ECMainPageItem> differ;

    /* renamed from: D, reason: from kotlin metadata */
    private final WeakReference<Context> weakReference;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final c diffCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/mainpage/ECMainPageAdapter$onBindViewHolder$1$1"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.mainpage.b$b, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class ViewOnClickListenerC1059b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f102957d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECMainPageItem f102958e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/mainpage/ECMainPageAdapter$onBindViewHolder$1$1$1", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.mainpage.b$b$a */
        /* loaded from: classes31.dex */
        public static final class a implements IECSchemeCallback {
            a() {
            }

            @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
            public void onCallbackFinished(JSONObject data) {
                cg0.a.b("ECMainPageAdapter", ViewOnClickListenerC1059b.this.f102958e.dataName + ", \u56de\u5305\uff1a" + data);
            }
        }

        ViewOnClickListenerC1059b(f fVar, ECMainPageItem eCMainPageItem) {
            this.f102957d = fVar;
            this.f102958e = eCMainPageItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(this.f102958e.triggerScheme)) {
                ECScheme.c(this.f102958e.triggerScheme, new a(), null);
            } else if (this.f102958e.b() != null) {
                Class<? extends ECBaseFragment> b16 = this.f102958e.b();
                new xi0.a(b16).launch(wg0.a.a(), b16, new Bundle());
            } else {
                Function0<Unit> a16 = this.f102958e.a();
                if (a16 != null) {
                    a16.invoke();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(Context context) {
        c cVar = new c();
        this.diffCallback = cVar;
        this.differ = new AsyncListDiffer<>(this, cVar);
        this.weakReference = new WeakReference<>(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.differ.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    public final ECMainPageItem i0(int position) {
        if (this.differ.getCurrentList().size() <= 0 || position >= this.differ.getCurrentList().size()) {
            return null;
        }
        return this.differ.getCurrentList().get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f holder, int position) {
        ECMainPageItem i06 = i0(position);
        if (i06 != null) {
            holder.getButtonView().setText(i06.dataName);
            holder.getButtonView().setOnClickListener(new ViewOnClickListenerC1059b(holder, i06));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = this.weakReference.get();
        if (context == null) {
            context = wg0.a.a();
        }
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            return new f(((LayoutInflater) systemService).inflate(R.layout.cs5, parent, false));
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final void setData(List<ECMainPageItem> pageIteList) {
        this.differ.submitList(pageIteList);
    }
}
