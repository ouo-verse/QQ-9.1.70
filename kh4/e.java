package kh4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.l;
import com.tencent.timi.game.utils.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.RecommendProxyOuterClass$KuolieRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B\u001d\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006."}, d2 = {"Lkh4/e;", "Lcom/tencent/timi/game/ui/widget/l;", "Landroid/view/View$OnClickListener;", "", "initViews", "", "currentHeiht", "l0", "Landroid/view/View;", "e0", "Y", NodeProps.ON_DETACHED_FROM_WINDOW, "v", NodeProps.ON_CLICK, "", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "J", "Ljava/util/List;", "dataList", "Lkh4/e$a;", "K", "Lkh4/e$a;", "getItemClickListener", "()Lkh4/e$a;", "m0", "(Lkh4/e$a;)V", "itemClickListener", "L", "I", "maxContentHeight", "M", "Landroid/view/View;", "shadowView", "Landroid/widget/ScrollView;", "N", "Landroid/widget/ScrollView;", "contentRootView", "Landroid/widget/LinearLayout;", "P", "Landroid/widget/LinearLayout;", "reasonLinear", "Landroid/content/Context;", "context", "<init>", "(Ljava/util/List;Landroid/content/Context;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e extends l implements View.OnClickListener {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final List<RecommendProxyOuterClass$KuolieRoomInfo> dataList;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private a itemClickListener;

    /* renamed from: L, reason: from kotlin metadata */
    private final int maxContentHeight;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private View shadowView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private ScrollView contentRootView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private LinearLayout reasonLinear;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lkh4/e$a;", "", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "info", "Landroid/content/Context;", "context", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(@NotNull RecommendProxyOuterClass$KuolieRoomInfo info, @NotNull Context context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull List<RecommendProxyOuterClass$KuolieRoomInfo> dataList, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.dataList = dataList;
        this.maxContentHeight = fh4.b.b(450);
        setContentView(R.layout.f169118hu3);
        View findViewById = findViewById(R.id.f84014l4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.shadowView)");
        this.shadowView = findViewById;
        View findViewById2 = findViewById(R.id.u7v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.contentRootView)");
        this.contentRootView = (ScrollView) findViewById2;
        View findViewById3 = findViewById(R.id.f70663m2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.reasonLinear)");
        this.reasonLinear = (LinearLayout) findViewById3;
        initViews();
    }

    private final void initViews() {
        ScrollView scrollView = this.contentRootView;
        if (scrollView != null) {
            scrollView.setBackgroundColor(Color.parseColor("#F3101016"));
        }
        this.reasonLinear.removeAllViews();
        int b16 = fh4.b.b(50);
        for (final RecommendProxyOuterClass$KuolieRoomInfo recommendProxyOuterClass$KuolieRoomInfo : this.dataList) {
            View inflate = LayoutInflater.from(this.G).inflate(R.layout.hv9, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.xsd);
            if (textView != null) {
                textView.setText(recommendProxyOuterClass$KuolieRoomInfo.room_index.get() + "  " + recommendProxyOuterClass$KuolieRoomInfo.room_id.get());
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: kh4.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.k0(e.this, recommendProxyOuterClass$KuolieRoomInfo, view);
                }
            });
            this.reasonLinear.addView(inflate, new LinearLayout.LayoutParams(-1, b16));
        }
        this.shadowView.setOnClickListener(this);
        l0(b16 * this.dataList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(e this$0, RecommendProxyOuterClass$KuolieRoomInfo item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (!o.a()) {
            a aVar = this$0.itemClickListener;
            if (aVar != null) {
                Context context = this$0.G;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                aVar.a(item, context);
            }
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l0(int currentHeiht) {
        ViewGroup.LayoutParams layoutParams;
        if (currentHeiht > this.maxContentHeight) {
            ScrollView scrollView = this.contentRootView;
            if (scrollView != null) {
                layoutParams = scrollView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.height = this.maxContentHeight;
                ScrollView scrollView2 = this.contentRootView;
                if (scrollView2 != null) {
                    scrollView2.setLayoutParams(layoutParams);
                }
                ScrollView scrollView3 = this.contentRootView;
                if (scrollView3 != null) {
                    scrollView3.requestLayout();
                }
            }
        }
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    public View Y() {
        return this.contentRootView;
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    /* renamed from: e0, reason: from getter */
    public View getShadowView() {
        return this.shadowView;
    }

    public final void m0(@Nullable a aVar) {
        this.itemClickListener = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.a() && v3.getId() == R.id.f84014l4) {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.timi.game.ui.widget.b, android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
