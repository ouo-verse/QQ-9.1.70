package com.qwallet.authorize.phone;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.qwallet.authorize.AuthorizePhoneData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u001b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qwallet/authorize/phone/d;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/qwallet/authorize/AuthorizePhoneData;", "Lcom/qwallet/authorize/phone/i;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "p0", "holder", "position", "", "l0", "Lkotlin/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onDeletePhone", "<init>", "(Lkotlin/jvm/functions/Function1;)V", BdhLogUtil.LogTag.Tag_Conn, "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class d extends ListAdapter<AuthorizePhoneData, i> {

    @NotNull
    private static final a D = new a();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<AuthorizePhoneData, Unit> onDeletePhone;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qwallet/authorize/phone/d$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qwallet/authorize/AuthorizePhoneData;", "oldItem", "newItem", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class a extends DiffUtil.ItemCallback<AuthorizePhoneData> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull AuthorizePhoneData oldItem, @NotNull AuthorizePhoneData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull AuthorizePhoneData oldItem, @NotNull AuthorizePhoneData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem == newItem) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull Function1<? super AuthorizePhoneData, Unit> onDeletePhone) {
        super(D);
        Intrinsics.checkNotNullParameter(onDeletePhone, "onDeletePhone");
        this.onDeletePhone = onDeletePhone;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(i holder, final d this$0, final AuthorizePhoneData authorizePhoneData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(holder.itemView.getContext(), 230, (String) null, "\u786e\u5b9a\u5220\u9664\u624b\u673a\u53f7", "\u53d6\u6d88", "\u786e\u8ba4", new DialogInterface.OnClickListener() { // from class: com.qwallet.authorize.phone.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.n0(d.this, authorizePhoneData, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qwallet.authorize.phone.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.o0(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(holde\u2026ner { dialog, which -> })");
        createCustomDialog.show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(d this$0, AuthorizePhoneData authorizePhoneData, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<AuthorizePhoneData, Unit> function1 = this$0.onDeletePhone;
        Intrinsics.checkNotNullExpressionValue(authorizePhoneData, "authorizePhoneData");
        function1.invoke(authorizePhoneData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final i holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final AuthorizePhoneData authorizePhoneData = getItem(position);
        Intrinsics.checkNotNullExpressionValue(authorizePhoneData, "authorizePhoneData");
        holder.m(authorizePhoneData);
        holder.getDeleteBtn().setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.authorize.phone.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.m0(i.this, this, authorizePhoneData, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public i onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hhz, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new i(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(DialogInterface dialogInterface, int i3) {
    }
}
