package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 $2\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0003%&'B\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\"\u0010#J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001e\u0010\u000b\u001a\u00020\n2\f\u0010\b\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0016\u0010\u0010\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rJ\u0006\u0010\u0011\u001a\u00020\nR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/aw;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/music/aw$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", ReportConstant.COSTREPORT_PREFIX, "holder", "position", "", "r", "getItemCount", "", "Lcom/tencent/mobileqq/wink/editor/music/ax;", "musicInfoList", "u", "t", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/wink/editor/music/aw$a;", "e", "Lcom/tencent/mobileqq/wink/editor/music/aw$a;", "mCallback", "", "f", "Ljava/util/List;", "mTabList", "", tl.h.F, "Z", "isShowHint", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/editor/music/aw$a;)V", "i", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class aw extends RecyclerView.Adapter<c> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a mCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ax> mTabList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isShowHint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/aw$a;", "", "Lcom/tencent/mobileqq/wink/editor/music/ax;", "tabName", "Landroid/view/View;", "view", "", "position", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void b(@Nullable ax tabName, @Nullable View view, int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/aw$b;", "", "Landroid/view/View;", "v", "", "b", "", "tagName", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.aw$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable View v3, @Nullable String tagName) {
            Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, tagName);
            VideoReport.setElementParams(v3, map);
            VideoReport.setElementReuseIdentifier(v3, tagName);
        }

        public final void b(@Nullable View v3) {
            VideoReport.setElementId(v3, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CATEGORY);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010$\u001a\u00020\n\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b&\u0010'J \u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/aw$c;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/wink/editor/music/ax;", "tabInfo", "", "position", "listSize", "", "c", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setMTabName", "(Landroid/widget/TextView;)V", "mTabName", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mTabHint", "Lcom/tencent/mobileqq/wink/editor/music/aw$a;", "f", "Lcom/tencent/mobileqq/wink/editor/music/aw$a;", "mCallBack", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/music/ax;", "mTabInfo", "i", "I", "tabColorSelected", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tabColorUnSelected", "itemView", "callback", "<init>", "(Lcom/tencent/mobileqq/wink/editor/music/aw;Landroid/view/View;Lcom/tencent/mobileqq/wink/editor/music/aw$a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        final /* synthetic */ aw C;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextView mTabName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ImageView mTabHint;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private a mCallBack;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ax mTabInfo;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int tabColorSelected;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private int tabColorUnSelected;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/music/aw$c$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a implements Animation.AnimationListener {
            a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(@NotNull Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ImageView imageView = c.this.mTabHint;
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(@NotNull Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(@NotNull Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull aw awVar, @Nullable View itemView, a aVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.C = awVar;
            this.mTabName = (TextView) itemView.findViewById(R.id.f122777ev);
            this.mTabHint = (ImageView) itemView.findViewById(R.id.f122767eu);
            TextView textView = this.mTabName;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            this.mCallBack = aVar;
            this.tabColorSelected = itemView.getResources().getColor(R.color.bfp);
            this.tabColorUnSelected = itemView.getResources().getColor(R.color.bfq);
        }

        public final void c(@Nullable ax tabInfo, int position, int listSize) {
            int i3;
            if (tabInfo == null) {
                return;
            }
            this.mTabInfo = tabInfo;
            TextView textView = this.mTabName;
            if (textView != null) {
                Intrinsics.checkNotNull(textView);
                textView.setText(tabInfo.f320784b);
                TextView textView2 = this.mTabName;
                Intrinsics.checkNotNull(textView2);
                if (tabInfo.f320785c) {
                    i3 = this.tabColorSelected;
                } else {
                    i3 = this.tabColorUnSelected;
                }
                textView2.setTextColor(i3);
            }
            if (this.mTabHint != null) {
                if (this.C.isShowHint && Intrinsics.areEqual("FAKE_CATEGORY_COLLECTION_ID", tabInfo.f320783a)) {
                    ImageView imageView = this.mTabHint;
                    Intrinsics.checkNotNull(imageView);
                    imageView.setVisibility(0);
                    ImageView imageView2 = this.mTabHint;
                    Intrinsics.checkNotNull(imageView2);
                    Animation loadAnimation = AnimationUtils.loadAnimation(imageView2.getContext(), R.anim.f155067i2);
                    loadAnimation.setDuration(500L);
                    loadAnimation.setAnimationListener(new a());
                    ImageView imageView3 = this.mTabHint;
                    Intrinsics.checkNotNull(imageView3);
                    imageView3.clearAnimation();
                    ImageView imageView4 = this.mTabHint;
                    Intrinsics.checkNotNull(imageView4);
                    imageView4.startAnimation(loadAnimation);
                    this.C.isShowHint = false;
                    return;
                }
                ImageView imageView5 = this.mTabHint;
                Intrinsics.checkNotNull(imageView5);
                imageView5.setVisibility(8);
            }
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final TextView getMTabName() {
            return this.mTabName;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            TextView textView = this.mTabName;
            if (textView != null) {
                Intrinsics.checkNotNull(textView);
                if (textView.getText() != null) {
                    a aVar = this.mCallBack;
                    Intrinsics.checkNotNull(aVar);
                    aVar.b(this.mTabInfo, this.itemView, getAdapterPosition());
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    public aw(@NotNull Context mContext, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mCallback = aVar;
        this.mTabList = new LinkedList();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTabList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@Nullable c holder, int position) {
        TextView textView;
        String str;
        if (holder != null) {
            holder.c(this.mTabList.get(position), position, this.mTabList.size());
        }
        Companion companion = INSTANCE;
        if (holder != null) {
            textView = holder.getMTabName();
        } else {
            textView = null;
        }
        if (this.mTabList.get(position) != null) {
            ax axVar = this.mTabList.get(position);
            Intrinsics.checkNotNull(axVar);
            str = axVar.f320784b;
        } else {
            str = "";
        }
        companion.a(textView, str);
        EventCollector.getInstance().onRecyclerBindViewHolder(holder, position, getItemId(position));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(this.mContext).inflate(R.layout.hdl, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        c cVar = new c(this, itemView, this.mCallback);
        INSTANCE.b(cVar.getMTabName());
        return cVar;
    }

    public final void t() {
        this.isShowHint = true;
        notifyDataSetChanged();
    }

    public final void u(@NotNull List<? extends ax> musicInfoList) {
        Intrinsics.checkNotNullParameter(musicInfoList, "musicInfoList");
        this.mTabList.clear();
        this.mTabList.addAll(musicInfoList);
        notifyDataSetChanged();
    }
}
