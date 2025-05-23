package com.tencent.mobileqq.guild.mainframe.create.removemember.adapterdelegate;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.create.removemember.MemberData;
import com.tencent.mobileqq.guild.mainframe.create.removemember.a;
import com.tencent.mobileqq.guild.mainframe.create.removemember.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u0002$%B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b!\u0010\"J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J(\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\bH\u0014J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/removemember/adapterdelegate/MemberAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/g;", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/a;", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/adapterdelegate/MemberAdapterDelegate$b;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Landroid/widget/CompoundButton;", "buttonView", "isChecked", "onCheckedChanged", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/e;", "d", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/e;", "eventCallback", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/create/removemember/e;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MemberAdapterDelegate extends AbsListItemAdapterDelegate<MemberData, a, b> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e eventCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/removemember/adapterdelegate/MemberAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "E", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "o", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "setSelectBox", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "selectBox", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setMemberName", "(Landroid/widget/TextView;)V", "memberName", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "G", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "l", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "setAvatarView", "(Lcom/tencent/mobileqq/proavatar/QQProAvatarView;)V", "avatarView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private QUICheckBox selectBox;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView memberName;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private QQProAvatarView avatarView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f82074fw);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.select_checkbox)");
            this.selectBox = (QUICheckBox) findViewById;
            View findViewById2 = itemView.findViewById(R.id.eos);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.member_name)");
            this.memberName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f115206ve);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.user_avatar)");
            this.avatarView = (QQProAvatarView) findViewById3;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QQProAvatarView getAvatarView() {
            return this.avatarView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getMemberName() {
            return this.memberName;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final QUICheckBox getSelectBox() {
            return this.selectBox;
        }
    }

    public MemberAdapterDelegate(@NotNull e eventCallback) {
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.eventCallback = eventCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<? extends a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MemberData;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@NotNull CompoundButton buttonView, boolean isChecked) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        Object tag = buttonView.getTag();
        if (!(tag instanceof MemberData)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onClick invalid, data:" + tag;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("MemberAdapterDelegate", 1, (String) it.next(), null);
            }
        } else {
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("MemberAdapterDelegate", "onCheckedChanged, data:" + tag);
            }
            this.eventCallback.b(buttonView, ((MemberData) tag).getUin());
        }
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag();
        if (!(tag instanceof MemberData)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onClick invalid, data:" + tag + ", id:" + v3.getId();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("MemberAdapterDelegate", 1, (String) it.next(), null);
            }
        } else if (v3.getId() == R.id.b_7) {
            this.eventCallback.a(v3, ((MemberData) tag).getUin());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull MemberData item, @NotNull b holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.getSelectBox().setTag(item);
        holder.itemView.setTag(item);
        if (!Intrinsics.areEqual(holder.getAvatarView().getTag(), item.getUin())) {
            holder.getAvatarView().w(1, item.getUin());
            holder.getAvatarView().setTag(item.getUin());
        }
        holder.getMemberName().setText(item.getName());
        holder.getSelectBox().setOnCheckedChangeListener(null);
        int selectType = item.getSelectType();
        if (selectType != 1) {
            if (selectType != 2) {
                if (selectType == 3) {
                    holder.getSelectBox().setEnabled(true);
                    holder.getSelectBox().setChecked(false);
                    holder.itemView.setEnabled(true);
                }
            } else {
                holder.getSelectBox().setEnabled(true);
                holder.getSelectBox().setChecked(true);
                holder.itemView.setEnabled(true);
            }
        } else {
            holder.getSelectBox().setEnabled(false);
            holder.getSelectBox().setChecked(false);
            holder.itemView.setEnabled(false);
        }
        holder.getSelectBox().setOnCheckedChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f4c, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026mber_item, parent, false)");
        b bVar = new b(inflate);
        bVar.itemView.setOnClickListener(this);
        return bVar;
    }
}
