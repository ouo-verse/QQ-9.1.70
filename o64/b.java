package o64;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.richui.api.IRichUIViewDelegateFactoryApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o64.b;
import org.jetbrains.annotations.NotNull;
import p64.RobotStoryBoardCardData;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lo64/b;", "Landroidx/recyclerview/widget/ListAdapter;", "Lp64/a;", "Lo64/b$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "k0", "j0", "Lo64/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lo64/d;", "listener", "<init>", "(Lo64/d;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends ListAdapter<p64.a, C10890b> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lo64/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lp64/a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Lo64/b;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: o64.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public final class C10890b extends RecyclerView.ViewHolder {
        final /* synthetic */ b E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10890b(@NotNull b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(C10890b this$0, b this$1, p64.a data, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(data, "$data");
            int adapterPosition = this$0.getAdapterPosition();
            if (adapterPosition != -1) {
                this$1.listener.D(((RobotStoryBoardCardData) data).getCard(), adapterPosition);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final p64.a data) {
            ViewGroup viewGroup;
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(data instanceof RobotStoryBoardCardData)) {
                QLog.e("RobotStoryBoardAdapter", 1, "onBindData data is not RobotStoryBoardCardData");
                return;
            }
            if (!data.getExported()) {
                RobotStoryBoardCardData robotStoryBoardCardData = (RobotStoryBoardCardData) data;
                if (robotStoryBoardCardData.getCard().storyBaseInfo != null) {
                    HashMap hashMap = new HashMap();
                    String str = robotStoryBoardCardData.getCard().storyBaseInfo.title;
                    Intrinsics.checkNotNullExpressionValue(str, "data.card.storyBaseInfo.title");
                    hashMap.put("plot_title", str);
                    hashMap.put("plot_id", String.valueOf(robotStoryBoardCardData.getCard().storyBaseInfo.storyId));
                    com.tencent.mobileqq.aio.utils.b.q("em_bas_story_card", hashMap);
                    data.d(true);
                }
            }
            FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R.id.tne);
            k viewNode = ((RobotStoryBoardCardData) data).getViewNode();
            Context context = frameLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "cardContainer.context");
            View i3 = k.i(viewNode, context, ((IRichUIViewDelegateFactoryApi) QRoute.api(IRichUIViewDelegateFactoryApi.class)).getViewFactory(), null, 4, null);
            ViewParent parent = i3.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            frameLayout.removeAllViews();
            frameLayout.addView(i3);
            final b bVar = this.E;
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: o64.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.C10890b.n(b.C10890b.this, bVar, data, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull d listener) {
        super(new a());
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public p64.a getItem(int position) {
        Object item = super.getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "super.getItem(position)");
        return (p64.a) item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C10890b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        p64.a item = getItem(position);
        try {
            holder.m(item);
        } catch (Exception e16) {
            QLog.w("RobotStoryBoardAdapter", 1, "[onBindViewHolder] failed to bind card data, position: " + position + " data:" + item + " exc:" + e16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C10890b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hpc, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new C10890b(this, view);
    }
}
