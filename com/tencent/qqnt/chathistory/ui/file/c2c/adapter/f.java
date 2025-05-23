package com.tencent.qqnt.chathistory.ui.file.c2c.adapter;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.file.c2c.adapter.f;
import com.tencent.qqnt.chathistory.ui.file.c2c.viewmodel.ChatHistoryFileModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.widget.C2CFileItemView;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00012B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020$\u00a2\u0006\u0004\b0\u00101J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00020\u00112\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0014\u0010\u0017\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015J\u0014\u0010\u0019\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R \u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/f$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "m0", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "q0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "s0", "holder", "position", "", "r0", "getItemCount", "n0", "", "emptyList", "t0", "newData", "l0", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", "parentViewModel", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;", "o0", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;", "listener", "Lkotlinx/coroutines/CoroutineScope;", "D", "Lkotlinx/coroutines/CoroutineScope;", "p0", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "", "E", "Ljava/util/List;", "getSearchMsgItemData$chathistory_impl_release", "()Ljava/util/List;", "searchMsgItemData", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;Lkotlinx/coroutines/CoroutineScope;)V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final d listener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b> searchMsgItemData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatHistoryFileModel parentViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/f$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/widget/C2CFileItemView;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/widget/C2CFileItemView;", "fileView", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/f;Landroid/view/View;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final C2CFileItemView fileView;
        final /* synthetic */ f G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull f fVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.G = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) itemView);
                return;
            }
            this.itemView = itemView;
            View findViewById = this.itemView.findViewById(R.id.v4z);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.fileItemView)");
            this.fileView = (C2CFileItemView) findViewById;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(f this$0, com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b item, a this$1, View it) {
            Map<String, Object> mutableMapOf;
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.o0().a(item.a(), this$1.fileView.q(), this$0.m0());
            HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(item.b().msgRecord.msgType)), TuplesKt.to("number_search_results", Integer.valueOf(this$0.getNUM_BACKGOURND_ICON())));
            a16.m(it, "em_bas_search_result_entry", mutableMapOf);
            EventCollector.getInstance().onViewClicked(it);
        }

        public final void m(@NotNull final com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            this.fileView.l(this.G.parentViewModel.M1(), item.a(), this.G.p0());
            this.fileView.setFileName(this.G.q0(item));
            C2CFileItemView c2CFileItemView = this.fileView;
            final f fVar = this.G;
            c2CFileItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.a.n(f.this, item, this, view);
                }
            });
        }
    }

    public f(@NotNull ChatHistoryFileModel parentViewModel, @NotNull d listener, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(parentViewModel, "parentViewModel");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, parentViewModel, listener, scope);
            return;
        }
        this.parentViewModel = parentViewModel;
        this.listener = listener;
        this.scope = scope;
        this.searchMsgItemData = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MsgRecord> m0() {
        int collectionSizeOrDefault;
        List<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b> list = this.searchMsgItemData;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b) it.next()).a().y());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence q0(com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b item) {
        boolean z16;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(item.b().fieldText);
        Iterator<SearchHitInfo> it = item.b().hitsInfo.iterator();
        while (it.hasNext()) {
            SearchHitInfo next = it.next();
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.context, R.color.ac5)), next.start, next.end, 17);
        }
        if (spannableStringBuilder.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            spannableStringBuilder.append((CharSequence) item.a().r());
        }
        return spannableStringBuilder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.searchMsgItemData.size();
    }

    public final void l0(@NotNull Collection<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        int size = this.searchMsgItemData.size();
        this.searchMsgItemData.addAll(newData);
        notifyItemRangeInserted(size, newData.size());
    }

    public final int n0(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, position)).intValue();
        }
        return this.searchMsgItemData.get(position).b().msgRecord.msgType;
    }

    @NotNull
    public final d o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.listener;
    }

    @NotNull
    public final CoroutineScope p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.scope;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.m(this.searchMsgItemData.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.drd, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate");
        return new a(this, inflate);
    }

    public final void t0(@NotNull Collection<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b> emptyList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) emptyList);
            return;
        }
        Intrinsics.checkNotNullParameter(emptyList, "emptyList");
        this.searchMsgItemData.clear();
        this.searchMsgItemData.addAll(emptyList);
        notifyDataSetChanged();
    }
}
