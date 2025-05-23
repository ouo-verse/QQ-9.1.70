package com.tencent.mobileqq.troop.homework.notice.remind.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.ColorNickTextView;
import com.tencent.mobileqq.troop.homework.notice.remind.adapter.c;
import com.tencent.mobileqq.troop.homework.notice.remind.data.RemindStatus;
import com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.g;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J.\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0014R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/adapter/c;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/troop/homework/notice/remind/data/a;", "Lcom/tencent/mobileqq/troop/homework/notice/remind/adapter/c$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "d", "holder", "", "payloads", "", "c", "", "Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g;", "e", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g;", "viewModel", "f", "I", "recyclerViewWidth", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g;I)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends AbsListItemAdapterDelegate<com.tencent.mobileqq.troop.homework.notice.remind.data.a, com.tencent.mobileqq.troop.homework.notice.remind.data.a, a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int recyclerViewWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/adapter/c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/homework/notice/remind/data/a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g;", "E", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g;", "getViewModel", "()Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g;", "viewModel", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/qqui/widget/ColorNickTextView;", "G", "Lcom/tencent/mobileqq/qqui/widget/ColorNickTextView;", "textView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final g viewModel;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final String troopUin;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ColorNickTextView textView;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.troop.homework.notice.remind.adapter.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public /* synthetic */ class C8749a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f297306a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54220);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[RemindStatus.values().length];
                try {
                    iArr[RemindStatus.STATUS_HAD_REMINDED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RemindStatus.STATUS_CHECKED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RemindStatus.STATUS_UNCHECKED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f297306a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView, @NotNull g viewModel, @NotNull String troopUin) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, itemView, viewModel, troopUin);
                return;
            }
            this.viewModel = viewModel;
            this.troopUin = troopUin;
            View findViewById = itemView.findViewById(R.id.f5q);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.name_tv)");
            this.textView = (ColorNickTextView) findViewById;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, com.tencent.mobileqq.troop.homework.notice.remind.data.a data, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.viewModel.c2(data);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final com.tencent.mobileqq.troop.homework.notice.remind.data.a data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            this.textView.setText(data.a());
            int i3 = C8749a.f297306a[data.b().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.textView.setTextColor(this.itemView.getContext().getColor(R.color.qui_common_text_primary));
                        this.textView.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.lwx));
                    }
                } else {
                    this.textView.setTextColor(this.itemView.getContext().getColor(R.color.qui_common_text_primary));
                    this.textView.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.f162613lx0));
                }
            } else {
                this.textView.setTextColor(this.itemView.getContext().getColor(R.color.qui_button_text_secondary_disable));
                this.textView.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.lwx));
            }
            this.textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.remind.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.a.n(c.a.this, data, view);
                }
            });
        }
    }

    public c(@NotNull String troopUin, @NotNull g viewModel, int i3) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, viewModel, Integer.valueOf(i3));
            return;
        }
        this.troopUin = troopUin;
        this.viewModel = viewModel;
        this.recyclerViewWidth = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.troop.homework.notice.remind.data.a item, @NotNull List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.troop.homework.notice.remind.data.a item, @NotNull a holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, item, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.m(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i07, parent, false);
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        layoutParams.width = this.recyclerViewWidth / 3;
        itemView.setLayoutParams(layoutParams);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new a(itemView, this.viewModel, this.troopUin);
    }
}
