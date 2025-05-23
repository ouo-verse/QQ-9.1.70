package com.tencent.mobileqq.guild.home.schedule.delegates;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.schedule.models.ErrorItem;
import com.tencent.mobileqq.guild.home.schedule.models.d;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J4\u0010\u0012\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/ScheduleErrorDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "items", "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", "", "l", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getAction", "()Lkotlin/jvm/functions/Function0;", "action", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ScheduleErrorDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends d>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/ScheduleErrorDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "E", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "l", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "errorView", "<init>", "(Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QUIEmptyState errorView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull QUIEmptyState errorView) {
            super(errorView);
            Intrinsics.checkNotNullParameter(errorView, "errorView");
            this.errorView = errorView;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QUIEmptyState getErrorView() {
            return this.errorView;
        }
    }

    public ScheduleErrorDelegate(@NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ScheduleErrorDelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            this$0.action.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(parent.getContext()).setHalfScreenState(false).setAutoCenter(false).setImageType(13);
        String string = parent.getContext().getString(R.string.f152871ak);
        Intrinsics.checkNotNullExpressionValue(string, "parent.context.getString(R.string.guild_reload)");
        QUIEmptyState build = imageType.setButton(string, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.delegates.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScheduleErrorDelegate.m(ScheduleErrorDelegate.this, view);
            }
        }).setBackgroundColorType(0).build();
        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        build.setGravity(17);
        ViewExtKt.f(build, ViewUtils.dpToPx(154.0f));
        return new a(build);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends d> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return items.get(position) instanceof ErrorItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends d> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        d dVar = items.get(position);
        if ((holder instanceof a) && (dVar instanceof ErrorItem)) {
            if (((ErrorItem) dVar).getResult() == -101) {
                a aVar = (a) holder;
                aVar.getErrorView().setImageView(5);
                aVar.getErrorView().setTitle("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u540e\u91cd\u8bd5");
            } else {
                a aVar2 = (a) holder;
                aVar2.getErrorView().setImageView(13);
                aVar2.getErrorView().setTitle("\u52a0\u8f7d\u5931\u8d25");
            }
        }
    }
}
