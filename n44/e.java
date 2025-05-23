package n44;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.adapterdelegates.RobotMyServiceCardDelegate;
import com.tencent.robot.profile.data.RobotProfileMyServiceData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ,2\u00020\u0001:\u0003-./B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J*\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Ln44/e;", "Ln44/f;", "", QCircleDaTongConstant.ElementParamValue.PYMK_FOLD, "", "t", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/robot/profile/data/g;", "data", "", "position", "", "", "payload", "r", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "moreServiceLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "serviceTextView", h.F, "moreServiceText", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "moreServiceArrow", "Lcom/tencent/robot/profile/data/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/profile/data/k;", "itemData", "Ln44/e$c;", BdhLogUtil.LogTag.Tag_Conn, "Ln44/e$c;", "adapter", "D", "Z", "isFolded", "<init>", "()V", "E", "a", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends f {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c adapter = new c();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFolded = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup moreServiceLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView serviceTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView moreServiceText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView moreServiceArrow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotProfileMyServiceData itemData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Ln44/e$a;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ItemDecoration {

        /* renamed from: e, reason: collision with root package name */
        private static int f418332e = ViewUtils.dip2px(12.0f);

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.top = f418332e;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\f\rB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000e"}, d2 = {"Ln44/e$c;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/robot/profile/data/k$b;", "", "items", "", "isFolded", "", "k0", "<init>", "()V", "I", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<RobotProfileMyServiceData.RobotService> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Ln44/e$c$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/robot/profile/data/k$b;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        private static final class b extends DiffUtil.ItemCallback<RobotProfileMyServiceData.RobotService> {
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull RobotProfileMyServiceData.RobotService oldItem, @NotNull RobotProfileMyServiceData.RobotService newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull RobotProfileMyServiceData.RobotService oldItem, @NotNull RobotProfileMyServiceData.RobotService newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                if (oldItem == newItem) {
                    return true;
                }
                return false;
            }
        }

        public c() {
            super(new b());
            this.f236209m.c(new RobotMyServiceCardDelegate());
        }

        public final void k0(@NotNull List<RobotProfileMyServiceData.RobotService> items, boolean isFolded) {
            int coerceAtMost;
            Intrinsics.checkNotNullParameter(items, "items");
            if (isFolded) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(items.size(), 3);
                super.setItems(items.subList(0, coerceAtMost));
            } else {
                super.setItems(items);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t(!this$0.isFolded);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void t(boolean fold) {
        String string;
        float f16;
        QLog.d("robot.profile.RobotMyServiceSection", 4, "setFolded fold:" + fold + " " + this.itemData);
        this.isFolded = fold;
        c cVar = this.adapter;
        RobotProfileMyServiceData robotProfileMyServiceData = this.itemData;
        Intrinsics.checkNotNull(robotProfileMyServiceData);
        cVar.k0(robotProfileMyServiceData.h(), this.isFolded);
        TextView textView = this.moreServiceText;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreServiceText");
            textView = null;
        }
        if (this.isFolded) {
            string = getRootView().getContext().getString(R.string.f222456dk);
        } else {
            string = getRootView().getContext().getString(R.string.f222366db);
        }
        textView.setText(string);
        ImageView imageView2 = this.moreServiceArrow;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreServiceArrow");
            imageView2 = null;
        }
        if (this.isFolded) {
            f16 = 0.0f;
        } else {
            f16 = 180.0f;
        }
        imageView2.setRotation(f16);
        ImageView imageView3 = this.moreServiceArrow;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreServiceArrow");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(getRootView().getContext(), R.drawable.qui_chevron_down_icon_secondary));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f7730440);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026le_my_services_text_view)");
        this.serviceTextView = (TextView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.f166320zf1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Fl\u2026R.id.more_service_layout)");
        this.moreServiceLayout = (ViewGroup) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.f166321zf2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.more_service_text)");
        this.moreServiceText = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.f166319zf0);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.more_service_arrow)");
        this.moreServiceArrow = (ImageView) findViewById4;
        RecyclerView recyclerView = (RecyclerView) containerView.findViewById(R.id.ebs);
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getRootView().getContext(), 1, false));
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.robot.profile.data.g data, int position, @Nullable List<Object> payload) {
        Boolean bool;
        int i3;
        boolean z16;
        String title;
        List<RobotProfileMyServiceData.RobotService> h16;
        List<RobotProfileMyServiceData.RobotService> h17;
        this.itemData = (RobotProfileMyServiceData) data;
        View rootView = getRootView();
        RobotProfileMyServiceData robotProfileMyServiceData = this.itemData;
        String str = null;
        if (robotProfileMyServiceData != null && (h17 = robotProfileMyServiceData.h()) != null) {
            bool = Boolean.valueOf(h17.isEmpty());
        } else {
            bool = null;
        }
        rootView.setVisibility(8);
        boolean z17 = false;
        if (((View) au.a(bool, rootView)) == null) {
            rootView.setVisibility(0);
        }
        getRootView().setBackgroundColor(getRootView().getContext().getColor(R.color.qui_common_bg_bottom_light));
        t(true);
        ViewGroup viewGroup = this.moreServiceLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreServiceLayout");
            viewGroup = null;
        }
        RobotProfileMyServiceData robotProfileMyServiceData2 = this.itemData;
        if (robotProfileMyServiceData2 != null && (h16 = robotProfileMyServiceData2.h()) != null) {
            i3 = h16.size();
        } else {
            i3 = 0;
        }
        if (i3 <= 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        viewGroup.setVisibility(8);
        if (((View) au.a(valueOf, viewGroup)) == null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.moreServiceLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreServiceLayout");
            viewGroup2 = null;
        }
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: n44.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.s(e.this, view);
            }
        });
        TextView textView = this.moreServiceText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreServiceText");
            textView = null;
        }
        textView.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_secondary));
        TextView textView2 = this.serviceTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceTextView");
            textView2 = null;
        }
        textView2.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_primary));
        TextView textView3 = this.serviceTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceTextView");
            textView3 = null;
        }
        RobotProfileMyServiceData robotProfileMyServiceData3 = this.itemData;
        if (robotProfileMyServiceData3 != null && (title = robotProfileMyServiceData3.getTitle()) != null) {
            if (title.length() == 0) {
                z17 = true;
            }
            if (z17) {
                String string = getRootView().getContext().getString(R.string.f223136fe);
                Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getStri\u2026robot_service_my_service)");
                str = string;
            } else {
                str = title;
            }
        }
        textView3.setText(str);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("robot.profile.RobotMyServiceSection", "bindData " + this.itemData);
        }
    }
}
