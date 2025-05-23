package com.tencent.qqnt.chathistory.ui.document.dialog.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.document.dialog.adapter.b;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.MsgRecordExKt;
import com.tencent.qqnt.chathistory.util.j;
import com.tencent.qqnt.chathistory.util.l;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001'B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b%\u0010&J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010\u0012\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/b$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "o0", "holder", "position", "", "n0", "getItemCount", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "emptyList", "p0", "newData", "l0", "m0", "Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/c;", "listener", BdhLogUtil.LogTag.Tag_Conn, "I", "chatType", "Landroidx/lifecycle/LifecycleCoroutineScope;", "D", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "", "E", "Ljava/util/List;", "getSearchMsgItemData$chathistory_impl_release", "()Ljava/util/List;", "searchMsgItemData", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/c;ILandroidx/lifecycle/LifecycleCoroutineScope;)V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final int chatType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LifecycleCoroutineScope lifecycleScope;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<SearchMsgItem> searchMsgItemData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001c\u0010\u001a\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "searchIcon", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "msgDocIcon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "msgDocTitle", "H", "msgDocTime", "I", "msgDocName", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/document/dialog/adapter/b;Landroid/view/View;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView msgDocIcon;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView msgDocTitle;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView msgDocTime;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView msgDocName;
        final /* synthetic */ b J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.J = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) itemView);
                return;
            }
            this.itemView = itemView;
            this.msgDocIcon = (ImageView) this.itemView.findViewById(R.id.dvu);
            this.msgDocTitle = (TextView) this.itemView.findViewById(R.id.kbs);
            this.msgDocTime = (TextView) this.itemView.findViewById(R.id.kbp);
            this.msgDocName = (TextView) this.itemView.findViewById(R.id.tv_name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(SearchMsgItem item, b this$0, View it) {
            ArkElement arkElement;
            String str;
            String e16;
            Map<String, Object> mutableMapOf;
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MsgRecord msgRecord = item.msgRecord;
            if (msgRecord.msgType == 2) {
                Intrinsics.checkNotNullExpressionValue(msgRecord, "item.msgRecord");
                String l3 = ExtensionsKt.l(msgRecord);
                if (l3 != null) {
                    this$0.listener.a(l3);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(msgRecord, "item.msgRecord");
                MsgElement i3 = MsgExtKt.i(msgRecord, 10);
                if (i3 != null && (arkElement = i3.arkElement) != null && (str = arkElement.bytesData) != null && (e16 = l.f354063a.e(str, item.msgRecord.subMsgType)) != null) {
                    this$0.listener.a(e16);
                }
            }
            HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(item.msgRecord.msgType)), TuplesKt.to("number_search_results", Integer.valueOf(this$0.getNUM_BACKGOURND_ICON())));
            a16.m(it, "em_bas_search_result_entry", mutableMapOf);
            EventCollector.getInstance().onViewClicked(it);
        }

        private final void o(ImageView searchIcon, SearchMsgItem item) {
            ArkElement arkElement;
            LinkInfo linkInfo;
            String str;
            TextElement textElement;
            MsgRecord msgRecord = item.msgRecord;
            if (msgRecord.msgType == 2) {
                Intrinsics.checkNotNullExpressionValue(msgRecord, "item.msgRecord");
                MsgElement i3 = MsgExtKt.i(msgRecord, 1);
                if (i3 != null && (textElement = i3.textElement) != null) {
                    linkInfo = textElement.linkInfo;
                }
                linkInfo = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(msgRecord, "item.msgRecord");
                MsgElement i16 = MsgExtKt.i(msgRecord, 10);
                if (i16 != null && (arkElement = i16.arkElement) != null) {
                    linkInfo = arkElement.linkInfo;
                }
                linkInfo = null;
            }
            if (linkInfo != null) {
                str = linkInfo.icon;
            } else {
                str = null;
            }
            if (str != null) {
                searchIcon.setImageDrawable(URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null));
            }
        }

        public final void m(@NotNull final SearchMsgItem item) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            ImageView msgDocIcon = this.msgDocIcon;
            Intrinsics.checkNotNullExpressionValue(msgDocIcon, "msgDocIcon");
            o(msgDocIcon, item);
            this.msgDocTitle.setText(ExtensionsKt.s(item, this.J.chatType));
            this.msgDocTime.setText(j.a(item.msgTime * 1000));
            this.msgDocName.setText(ExtensionsKt.i(item));
            CharSequence text = this.msgDocName.getText();
            Intrinsics.checkNotNullExpressionValue(text, "msgDocName.text");
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                TextView msgDocName = this.msgDocName;
                Intrinsics.checkNotNullExpressionValue(msgDocName, "msgDocName");
                int i3 = this.J.chatType;
                MsgRecord msgRecord = item.msgRecord;
                Intrinsics.checkNotNullExpressionValue(msgRecord, "item.msgRecord");
                MsgRecordExKt.e(msgDocName, i3, msgRecord, this.J.lifecycleScope, 0, 8, null);
            }
            View view = this.itemView;
            final b bVar = this.J;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.dialog.adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.a.n(SearchMsgItem.this, bVar, view2);
                }
            });
        }
    }

    public b(@NotNull c listener, int i3, @NotNull LifecycleCoroutineScope lifecycleScope) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, listener, Integer.valueOf(i3), lifecycleScope);
            return;
        }
        this.listener = listener;
        this.chatType = i3;
        this.lifecycleScope = lifecycleScope;
        this.searchMsgItemData = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.searchMsgItemData.size();
    }

    public final void l0(@NotNull Collection<SearchMsgItem> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        int size = this.searchMsgItemData.size();
        this.searchMsgItemData.addAll(newData);
        notifyItemRangeInserted(size, newData.size());
    }

    public final int m0(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, position)).intValue();
        }
        return this.searchMsgItemData.get(position).msgRecord.msgType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.m(this.searchMsgItemData.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new a(this, new com.tencent.qqnt.chathistory.x2k.b(context, null, 2, null).getMContainer());
    }

    public final void p0(@NotNull Collection<SearchMsgItem> emptyList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emptyList);
            return;
        }
        Intrinsics.checkNotNullParameter(emptyList, "emptyList");
        this.searchMsgItemData.clear();
        this.searchMsgItemData.addAll(emptyList);
        notifyDataSetChanged();
    }
}
