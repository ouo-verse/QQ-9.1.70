package com.tencent.mobileqq.aio.robot.titlebar.modellist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.kernel.nativeinterface.ModelDisableStyle;
import java.util.List;
import k81.RobotAIModelData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/ModelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/ModelAdapter$ModelViewHolder;", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/b;", "callback", "", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "holder", "position", "l0", "getItemCount", "", "Lk81/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "Lp81/b;", BdhLogUtil.LogTag.Tag_Conn, "Lp81/b;", "binding", "D", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/b;", "<init>", "(Ljava/util/List;)V", "ModelViewHolder", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ModelAdapter extends RecyclerView.Adapter<ModelViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private p81.b binding;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private b callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<RobotAIModelData> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/ModelAdapter$ModelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lk81/a;", "data", "Lp81/b;", "binding", "Lkotlin/Function0;", "", "linkClick", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ModelViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(@NotNull RobotAIModelData data, @Nullable p81.b binding, @NotNull final Function0<Unit> linkClick) {
            TextView textView;
            TextView textView2;
            int i3;
            TextView textView3;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(linkClick, "linkClick");
            TextView textView4 = null;
            if (binding != null) {
                textView = binding.f425715c;
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setText(data.getTitle());
            }
            if (binding != null) {
                textView2 = binding.f425714b;
            } else {
                textView2 = null;
            }
            if (textView2 != null) {
                textView2.setText(data.getDesc());
            }
            if (data.getDisableStyle() == ModelDisableStyle.KMDSDISABLED) {
                a aVar = a.f193664a;
                String desc = data.getDesc();
                if (binding != null) {
                    textView4 = binding.f425714b;
                }
                aVar.b(desc, textView4, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.modellist.ModelAdapter$ModelViewHolder$setData$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String url) {
                        boolean startsWith$default;
                        boolean startsWith$default2;
                        Intrinsics.checkNotNullParameter(url, "url");
                        linkClick.invoke();
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                        if (!startsWith$default) {
                            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
                            if (!startsWith$default2) {
                                IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) QRoute.api(IAIOJumpAction.class);
                                Context context = this.itemView.getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                                iAIOJumpAction.doUrlAction(context, url);
                                return;
                            }
                        }
                        IAIOJumpAction iAIOJumpAction2 = (IAIOJumpAction) QRoute.api(IAIOJumpAction.class);
                        Context context2 = this.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                        iAIOJumpAction2.openBrowser(context2, url);
                    }
                });
            }
            if (data.getDisableStyle() == ModelDisableStyle.KMDSENABLE) {
                i3 = R.color.qui_common_text_primary;
            } else {
                i3 = R.color.qui_common_text_tertiary;
            }
            if (binding != null && (textView3 = binding.f425715c) != null) {
                textView3.setTextColor(ie0.a.f().g(this.itemView.getContext(), i3, 1000));
            }
        }
    }

    public ModelAdapter(@NotNull List<RobotAIModelData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(RobotAIModelData data, ModelAdapter this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (data.getDisableStyle() != ModelDisableStyle.KMDSDISABLED) {
            if (data.getIsSelected()) {
                b bVar = this$0.callback;
                if (bVar != null) {
                    bVar.a(i3, this$0.dataList.get(i3));
                }
            } else {
                b bVar2 = this$0.callback;
                if (bVar2 != null) {
                    bVar2.b(i3, this$0.dataList.get(i3));
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ModelViewHolder holder, final int position) {
        ImageView imageView;
        p81.b bVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= 0 && position < this.dataList.size()) {
            final RobotAIModelData robotAIModelData = this.dataList.get(position);
            holder.l(robotAIModelData, this.binding, new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.modellist.ModelAdapter$onBindViewHolder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    b bVar2;
                    List list;
                    bVar2 = ModelAdapter.this.callback;
                    if (bVar2 != null) {
                        int i3 = position;
                        list = ModelAdapter.this.dataList;
                        bVar2.a(i3, (RobotAIModelData) list.get(position));
                    }
                }
            });
            p81.b bVar2 = this.binding;
            if (bVar2 != null) {
                imageView = bVar2.f425716d;
            } else {
                imageView = null;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (robotAIModelData.getIsSelected() && (bVar = this.binding) != null) {
                bVar.f425716d.setVisibility(0);
                bVar.f425716d.setImageDrawable(ie0.a.f().o(BaseApplication.getContext(), R.drawable.qui_check, R.color.qui_common_icon_aio_toolbar_active, 1001));
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.modellist.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ModelAdapter.m0(RobotAIModelData.this, this, position, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public ModelViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        p81.b g16 = p81.b.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        this.binding = g16;
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new ModelViewHolder(root);
    }

    public final void o0(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }
}
