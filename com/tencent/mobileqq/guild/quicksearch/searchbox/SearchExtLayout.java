package com.tencent.mobileqq.guild.quicksearch.searchbox;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchExtLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "extDataList", "", "isInDelete", "", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/h;", "f", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/h;", "searchExtAdapter", "", tl.h.F, "Ljava/util/List;", "i", "Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SearchExtLayout extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private h searchExtAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SearchBarExtData> extDataList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInDelete;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchExtLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void C(@Nullable List<? extends SearchBarExtData> extDataList, boolean isInDelete) {
        boolean z16;
        this.extDataList.clear();
        List<? extends SearchBarExtData> list = extDataList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.extDataList.addAll(list);
        }
        this.isInDelete = isInDelete;
        D();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        if (r4 == (r9.extDataList.size() - 1)) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D() {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (this.extDataList.isEmpty()) {
            arrayList.add(new SpaceData(bi.a(10.0f)));
            arrayList.add(new b());
        } else {
            int i3 = 0;
            for (Object obj : this.extDataList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                SearchBarExtData searchBarExtData = (SearchBarExtData) obj;
                if (this.isInDelete) {
                    z16 = true;
                }
                z16 = false;
                if (searchBarExtData instanceof SearchBarExtData.GuildMemberExtData) {
                    arrayList.add(new SpaceData(bi.a(10.0f)));
                    arrayList.add(new GuildMemberData((SearchBarExtData.GuildMemberExtData) searchBarExtData, z16));
                } else if (searchBarExtData instanceof SearchBarExtData.DateExtData) {
                    arrayList.add(new SpaceData(bi.a(10.0f)));
                    arrayList.add(new TextData(((SearchBarExtData.DateExtData) searchBarExtData).a(), z16));
                }
                i3 = i16;
            }
            arrayList.add(new SpaceData(bi.a(3.0f)));
        }
        this.searchExtAdapter.setItems(arrayList);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchExtLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SearchExtLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchExtLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.extDataList = new ArrayList();
        setOverScrollMode(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        this.searchExtAdapter = new h();
        setItemAnimator(null);
        setAdapter(this.searchExtAdapter);
        D();
    }
}
