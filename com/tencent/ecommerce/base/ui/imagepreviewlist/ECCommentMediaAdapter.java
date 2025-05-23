package com.tencent.ecommerce.base.ui.imagepreviewlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002-.Bo\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000b0\u001a\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0!\u0012!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000b0\u001a\u0012\b\b\u0002\u0010)\u001a\u00020\u000f\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007R0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@CX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R/\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R/\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001fR\u0014\u0010)\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECCommentMediaAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECCommentMediaAdapter$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "position", "getItemViewType", "holder", "", "l0", "getItemCount", "", "", "thumbnailUrls", "setData", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "n0", "(Ljava/util/List;)V", BdhLogUtil.LogTag.Tag_Conn, "I", "itemCountMax", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "D", "Lkotlin/jvm/functions/Function1;", "onDelete", "Lkotlin/Function0;", "E", "Lkotlin/jvm/functions/Function0;", "onAdd", UserInfo.SEX_FEMALE, "onMediaClick", "G", "Ljava/lang/String;", "defaultAddBtnText", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "H", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECCommentMediaAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int itemCountMax;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function1<Integer, Unit> onDelete;

    /* renamed from: E, reason: from kotlin metadata */
    private final Function0<Unit> onAdd;

    /* renamed from: F, reason: from kotlin metadata */
    private final Function1<Integer, Unit> onMediaClick;

    /* renamed from: G, reason: from kotlin metadata */
    private final String defaultAddBtnText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<String> thumbnailUrls;

    /* JADX WARN: Multi-variable type inference failed */
    public ECCommentMediaAdapter(int i3, Function1<? super Integer, Unit> function1, Function0<Unit> function0, Function1<? super Integer, Unit> function12, String str) {
        List<String> emptyList;
        this.itemCountMax = i3;
        this.onDelete = function1;
        this.onAdd = function0;
        this.onMediaClick = function12;
        this.defaultAddBtnText = str;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.thumbnailUrls = emptyList;
    }

    private final void n0(List<String> list) {
        List<String> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        this.thumbnailUrls = mutableList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.thumbnailUrls.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        String sb5;
        if (holder.getItemViewType() == 1) {
            if (this.thumbnailUrls.isEmpty()) {
                sb5 = this.defaultAddBtnText;
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.thumbnailUrls.size());
                sb6.append('/');
                sb6.append(this.itemCountMax);
                sb5 = sb6.toString();
            }
            holder.m(sb5, new Function0<Unit>() { // from class: com.tencent.ecommerce.base.ui.imagepreviewlist.ECCommentMediaAdapter$onBindViewHolder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List list;
                    int i3;
                    Function0 function0;
                    list = ECCommentMediaAdapter.this.thumbnailUrls;
                    int size = list.size();
                    i3 = ECCommentMediaAdapter.this.itemCountMax;
                    if (size < i3) {
                        function0 = ECCommentMediaAdapter.this.onAdd;
                        function0.invoke();
                    } else {
                        i.f101155b.c(R.string.wei, ECToastIcon.ICON_DEFAULT, 0);
                    }
                }
            });
            return;
        }
        int i3 = position - 1;
        holder.l(i3, this.thumbnailUrls.get(i3), this.onDelete, this.onMediaClick);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate;
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            inflate = from.inflate(R.layout.f167326cp4, parent, false);
        } else {
            inflate = from.inflate(R.layout.f167324cp2, parent, false);
        }
        return new a(inflate, viewType);
    }

    public final void setData(List<String> thumbnailUrls) {
        n0(thumbnailUrls);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\\\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\t0\u00062!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\t0\u0006J\u001c\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECCommentMediaAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "index", "", "url", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "onDelete", NodeProps.ON_CLICK, "l", "tip", "Lkotlin/Function0;", "onAdd", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "I", "viewType", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final int viewType;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.base.ui.imagepreviewlist.ECCommentMediaAdapter$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public static final class ViewOnClickListenerC1036a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function1 f101157d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f101158e;

            ViewOnClickListenerC1036a(Function1 function1, int i3) {
                this.f101157d = function1;
                this.f101158e = i3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f101157d.invoke(Integer.valueOf(this.f101158e));
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes32.dex */
        public static final class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function1 f101159d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f101160e;

            b(Function1 function1, int i3) {
                this.f101159d = function1;
                this.f101160e = i3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f101159d.invoke(Integer.valueOf(this.f101160e));
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes32.dex */
        public static final class c implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function0 f101161d;

            c(Function0 function0) {
                this.f101161d = function0;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f101161d.invoke();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(View view, int i3) {
            super(view);
            this.viewType = i3;
        }

        public final void m(String tip, Function0<Unit> onAdd) {
            if (this.viewType == 1) {
                TextView textView = (TextView) this.itemView.findViewById(R.id.o_m);
                if (tip.length() == 0) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(tip);
                    textView.setVisibility(0);
                }
                this.itemView.setOnClickListener(new c(onAdd));
                return;
            }
            throw new IllegalStateException("\u7c7b\u578b\u9519\u8bef\uff01".toString());
        }

        public final void l(int index, String url, Function1<? super Integer, Unit> onDelete, Function1<? super Integer, Unit> onClick) {
            if (this.viewType == 0) {
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.o0z);
                QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(this.itemView.getContext(), url, imageView, new IECImageLoader.ImageLoaderOption(196, 196, 0, null, null, null, false, false, null, 508, null));
                imageView.setOnClickListener(new ViewOnClickListenerC1036a(onClick, index));
                View findViewById = this.itemView.findViewById(R.id.ntf);
                if (findViewById != null) {
                    findViewById.setOnClickListener(new b(onDelete, index));
                    return;
                }
                return;
            }
            throw new IllegalStateException("\u7c7b\u578b\u9519\u8bef\uff01".toString());
        }
    }
}
