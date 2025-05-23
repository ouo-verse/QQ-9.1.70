package com.tencent.qqnt.chathistory.ui.link.dialog.adaptar;

import android.content.Context;
import android.text.TextUtils;
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
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.MsgRecordExKt;
import com.tencent.qqnt.chathistory.x2k.d;
import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\b\u0000\u0018\u0000 )2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002*\u0012B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b'\u0010(J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u001e\u0010\u0013\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0015\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0!8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/a$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "o0", "holder", "position", "", "n0", "getItemCount", "m0", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "emptyList", "", "b", "p0", "newData", "l0", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/c;", "listener", BdhLogUtil.LogTag.Tag_Conn, "I", "chatType", "Landroidx/lifecycle/LifecycleCoroutineScope;", "D", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "", "E", "Ljava/util/List;", "getDatas$chathistory_impl_release", "()Ljava/util/List;", "datas", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/c;ILandroidx/lifecycle/LifecycleCoroutineScope;)V", UserInfo.SEX_FEMALE, "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final C9541a F;

    /* renamed from: C */
    private final int chatType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LifecycleCoroutineScope lifecycleScope;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<SearchMsgItem> datas;

    /* renamed from: m */
    @NotNull
    private final c listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.a$a */
    /* loaded from: classes23.dex */
    private static final class C9541a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ C9541a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        C9541a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0019\u001a\n \u0010*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "title", "G", QQWinkConstants.TAB_SUBTITLE, "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "ivIcon", "I", "tvTime", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/link/dialog/adaptar/a;Landroid/view/View;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F */
        private final TextView title;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView com.tencent.mobileqq.wink.api.QQWinkConstants.TAB_SUBTITLE java.lang.String;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView ivIcon;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView tvTime;
        final /* synthetic */ a J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.J = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) itemView);
                return;
            }
            this.itemView = itemView;
            this.title = (TextView) this.itemView.findViewById(R.id.k4v);
            this.com.tencent.mobileqq.wink.api.QQWinkConstants.TAB_SUBTITLE java.lang.String = (TextView) this.itemView.findViewById(R.id.f1056566l);
            this.ivIcon = (ImageView) this.itemView.findViewById(R.id.drx);
            this.tvTime = (TextView) this.itemView.findViewById(R.id.k4u);
        }

        public static final void n(a this$0, b this$1, SearchMsgItem data, View it) {
            Map<String, Object> mutableMapOf;
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(data, "$data");
            c cVar = this$0.listener;
            if (cVar != null) {
                cVar.j0(this$1.title.getText().toString());
            }
            HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_message_type", Integer.valueOf(data.msgRecord.msgType)), TuplesKt.to("number_search_results", Integer.valueOf(this$0.getNUM_BACKGOURND_ICON())));
            a16.m(it, "em_bas_search_result_entry", mutableMapOf);
            EventCollector.getInstance().onViewClicked(it);
        }

        private final CharSequence o(SearchMsgItem r56) {
            String p16 = en.p(r56.msgTime * 1000, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
            Intrinsics.checkNotNullExpressionValue(p16, "getRecentMessageDateTime\u2026yyyy-MM-dd\"\n            )");
            return p16;
        }

        public final void m(@NotNull final SearchMsgItem data) {
            boolean z16;
            String str;
            TextElement textElement;
            LinkInfo linkInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            this.title.setText(ExtensionsKt.s(data, this.J.chatType));
            this.tvTime.setText(o(data));
            this.com.tencent.mobileqq.wink.api.QQWinkConstants.TAB_SUBTITLE java.lang.String.setText(ExtensionsKt.i(data));
            CharSequence text = this.com.tencent.mobileqq.wink.api.QQWinkConstants.TAB_SUBTITLE java.lang.String.getText();
            Intrinsics.checkNotNullExpressionValue(text, "subTitle.text");
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                TextView subTitle = this.com.tencent.mobileqq.wink.api.QQWinkConstants.TAB_SUBTITLE java.lang.String;
                Intrinsics.checkNotNullExpressionValue(subTitle, "subTitle");
                int i3 = this.J.chatType;
                MsgRecord msgRecord = data.msgRecord;
                Intrinsics.checkNotNullExpressionValue(msgRecord, "data.msgRecord");
                MsgRecordExKt.e(subTitle, i3, msgRecord, this.J.lifecycleScope, 0, 8, null);
            }
            View view = this.itemView;
            final a aVar = this.J;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.dialog.adaptar.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.b.n(a.this, this, data, view2);
                }
            });
            MsgRecord msgRecord2 = data.msgRecord;
            Intrinsics.checkNotNullExpressionValue(msgRecord2, "data.msgRecord");
            MsgElement n3 = ExtensionsKt.n(msgRecord2, 1);
            if (n3 != null && (textElement = n3.textElement) != null && (linkInfo = textElement.linkInfo) != null) {
                str = linkInfo.icon;
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                this.ivIcon.setImageResource(R.drawable.mpn);
                return;
            }
            URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(iconUrl, options)");
            this.ivIcon.setImageDrawable(drawable);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47622);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            F = new C9541a(null);
        }
    }

    public a(@NotNull c listener, int i3, @NotNull LifecycleCoroutineScope lifecycleScope) {
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
        this.datas = new ArrayList();
    }

    public static /* synthetic */ void q0(a aVar, Collection collection, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.p0(collection, z16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.datas.size();
    }

    public final void l0(@NotNull Collection<SearchMsgItem> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        int size = this.datas.size();
        this.datas.addAll(newData);
        notifyItemRangeInserted(size, newData.size());
    }

    public final int m0(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, position)).intValue();
        }
        return this.datas.get(position).msgRecord.msgType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0 */
    public void onBindViewHolder(@NotNull b holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.m(this.datas.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0 */
    public b onCreateViewHolder(@NotNull ViewGroup r46, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) r46, viewType);
        }
        Intrinsics.checkNotNullParameter(r46, "parent");
        Context context = r46.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new b(this, new d(context, null, 2, null).getMContainer());
    }

    public final void p0(@NotNull Collection<SearchMsgItem> emptyList, boolean b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, emptyList, Boolean.valueOf(b16));
            return;
        }
        Intrinsics.checkNotNullParameter(emptyList, "emptyList");
        this.datas.clear();
        this.datas.addAll(emptyList);
        notifyDataSetChanged();
    }
}
