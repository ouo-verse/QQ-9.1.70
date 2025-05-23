package com.tencent.mobileqq.troop.selectmember.part.search;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.search.ext.ChatUserListExt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/search/h;", "Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt$BaseChatExtAdapter;", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt$ViewHolder;", "viewHolder", "", com.tencent.luggage.wxa.c8.c.G, "data", "", "j0", "", "l0", "Landroid/content/Context;", "context", "Landroid/view/View;", "createIconView", "", "tryGrayItemOrDelete", "Lcom/tencent/mobileqq/troop/selectmember/part/search/h$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/selectmember/part/search/h$a;", "getItemClickListener", "()Lcom/tencent/mobileqq/troop/selectmember/part/search/h$a;", "m0", "(Lcom/tencent/mobileqq/troop/selectmember/part/search/h$a;)V", "itemClickListener", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h extends ChatUserListExt.BaseChatExtAdapter<com.tencent.mobileqq.troop.selectmember.bean.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a itemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/search/h$a;", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "itemData", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void a(@NotNull com.tencent.mobileqq.troop.selectmember.bean.c itemData);
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(h this$0, com.tencent.mobileqq.troop.selectmember.bean.c data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.a(data);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
    @NotNull
    protected View createIconView(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new QQProAvatarView(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void bindViewHolder(@NotNull ChatUserListExt.ViewHolder viewHolder, int pos, @NotNull final com.tencent.mobileqq.troop.selectmember.bean.c data) {
        TroopMemberInfo troopMemberInfo;
        QQProAvatarView qQProAvatarView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, viewHolder, Integer.valueOf(pos), data);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(data, "data");
        Object itemData = data.getItemData();
        if (itemData instanceof TroopMemberInfo) {
            troopMemberInfo = (TroopMemberInfo) itemData;
        } else {
            troopMemberInfo = null;
        }
        if (troopMemberInfo == null) {
            return;
        }
        viewHolder.tvName.setVisibility(8);
        View view = viewHolder.ivIcon;
        if (view instanceof QQProAvatarView) {
            qQProAvatarView = (QQProAvatarView) view;
        } else {
            qQProAvatarView = null;
        }
        if (qQProAvatarView != null) {
            qQProAvatarView.x(1, troopMemberInfo.memberuin, null);
        }
        viewHolder.itemView.setTag(data);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.k0(h.this, data, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public String getDesc(@NotNull com.tencent.mobileqq.troop.selectmember.bean.c data) {
        TroopMemberInfo troopMemberInfo;
        TroopMemberNickInfo troopMemberNickInfo;
        String showName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Object itemData = data.getItemData();
        if (itemData instanceof TroopMemberInfo) {
            troopMemberInfo = (TroopMemberInfo) itemData;
        } else {
            troopMemberInfo = null;
        }
        if (troopMemberInfo == null || (troopMemberNickInfo = troopMemberInfo.nickInfo) == null || (showName = troopMemberNickInfo.getShowName()) == null) {
            return "";
        }
        return showName;
    }

    public final void m0(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.itemClickListener = aVar;
        }
    }

    @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
    public boolean tryGrayItemOrDelete() {
        com.tencent.mobileqq.troop.selectmember.bean.c cVar;
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        int itemCount = getItemCount() - 1;
        if (itemCount >= 0) {
            cVar = getItem(itemCount);
        } else {
            cVar = null;
        }
        boolean z16 = this.mIsInDel;
        boolean tryGrayItemOrDelete = super.tryGrayItemOrDelete();
        if (cVar != null && tryGrayItemOrDelete && z16 && (aVar = this.itemClickListener) != null) {
            aVar.a(cVar);
        }
        return tryGrayItemOrDelete;
    }
}
