package com.tencent.mobileqq.guild.main.topchannel.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.du;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u001c\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/main/topchannel/adapter/f;", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$d;", "Lcom/tencent/mobileqq/guild/main/topchannel/adapter/h;", "Lcv1/a;", "uiData", "Landroid/widget/TextView;", "textView", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "j0", "getItemCount", "", "guildId", "", "Lcom/tencent/mobileqq/guild/main/topchannel/adapter/e;", VideoTemplateParser.ITEM_LIST, "l0", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "textItemList", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "<init>", "()V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends DownToUpViewSwitcher.d<h> {

    /* renamed from: C, reason: from kotlin metadata */
    private String guildId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<TextCardItemData> textItemList = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((TextCardItemData) t16).getMsgSeq()), Long.valueOf(((TextCardItemData) t17).getMsgSeq()));
            return compareValues;
        }
    }

    private final void m0(cv1.a uiData, TextView textView) {
        boolean z16;
        boolean isEmpty = TextUtils.isEmpty(uiData.a());
        QQText c16 = uiData.c();
        boolean z17 = false;
        textView.setPadding(0, 0, 0, 0);
        if (isEmpty) {
            if (c16 != null) {
                if (c16.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                textView.setText(c16);
                textView.setTag(Long.valueOf(uiData.b()));
            }
        }
        if (!isEmpty) {
            textView.setText(uiData.a());
        }
        textView.setTag(Long.valueOf(uiData.b()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.textItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull h holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        TraceUtils.h("topCard_text_item_bind");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.textItemList, position);
        TextCardItemData textCardItemData = (TextCardItemData) orNull;
        if (textCardItemData == null) {
            return;
        }
        Logger.f235387a.d().d("Guild.MF.Sticky.TextTopCardAdapter", 1, "onBindViewHolder,  msgSeq " + textCardItemData.getMsgSeq() + ", pos: " + position);
        GuildUserAvatarView guildUserAvatarView = holder.getBinding().f442995b;
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        guildUserAvatarView.setAvatarTinyId(str, String.valueOf(textCardItemData.getTinyId()));
        cv1.a uiData = textCardItemData.getUiData();
        if (uiData != null) {
            TextView textView = holder.getBinding().f442997d;
            Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.topcardChatItemSummary");
            m0(uiData, textView);
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher.d
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public h i0(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TraceUtils.h("topCard_text_item_create");
        du g16 = du.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        TraceUtils.k();
        return new h(g16);
    }

    public final void l0(@NotNull String guildId, @NotNull List<TextCardItemData> itemList) {
        List list;
        List sortedWith;
        List list2;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        QLog.i("Guild.MF.Sticky.TextTopCardAdapter", 1, "setDataList: guildId" + guildId + " size[" + itemList.size() + "]");
        this.guildId = guildId;
        list = CollectionsKt___CollectionsKt.toList(this.textItemList);
        this.textItemList.clear();
        CopyOnWriteArrayList<TextCardItemData> copyOnWriteArrayList = this.textItemList;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(itemList, new b());
        copyOnWriteArrayList.addAll(sortedWith);
        list2 = CollectionsKt___CollectionsKt.toList(this.textItemList);
        DiffUtil.calculateDiff(new d(list, list2)).dispatchUpdatesTo(this);
    }
}
