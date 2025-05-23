package com.tencent.guild.aio.input.at.trooptag.view;

import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cp0.BottomDecorationData;
import fp0.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/view/GuildHashTagItemListView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcp0/a;", "newDataList", "", "E", "Lip0/b;", "dataChangedListener", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "f", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "panelContext", "Lfp0/b;", h.F, "Lfp0/b;", "panelStyle", "Lep0/b;", "i", "Lep0/b;", "itemAdapter", "Lcom/tencent/guild/aio/input/at/trooptag/model/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/input/at/trooptag/model/a;", "troopTagModel", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;Lfp0/b;Landroid/util/AttributeSet;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildHashTagItemListView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a panelContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b panelStyle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ep0.b itemAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.input.at.trooptag.model.a troopTagModel;

    public /* synthetic */ GuildHashTagItemListView(a aVar, b bVar, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, bVar, (i16 & 4) != 0 ? null : attributeSet, (i16 & 8) != 0 ? 0 : i3);
    }

    public final void C(@NotNull ip0.b dataChangedListener) {
        Intrinsics.checkNotNullParameter(dataChangedListener, "dataChangedListener");
        this.troopTagModel.a(dataChangedListener);
    }

    public final void D() {
        RecyclerView.ItemAnimator itemAnimator = getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        setItemAnimator(null);
    }

    public final void E(@NotNull List<? extends cp0.a> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        if (newDataList.size() > 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(newDataList);
            arrayList.add(new BottomDecorationData(this.panelStyle.getDimen().getPagerMarginBottom()));
            this.troopTagModel.m(arrayList);
            scrollToPosition(0);
            return;
        }
        this.troopTagModel.m(newDataList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHashTagItemListView(@NotNull a panelContext, @NotNull b panelStyle, @Nullable AttributeSet attributeSet, int i3) {
        super(panelContext.c(), attributeSet, i3);
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(panelStyle, "panelStyle");
        this.panelContext = panelContext;
        this.panelStyle = panelStyle;
        com.tencent.guild.aio.input.at.trooptag.model.a aVar = new com.tencent.guild.aio.input.at.trooptag.model.a();
        this.troopTagModel = aVar;
        ep0.b bVar = new ep0.b(aVar, panelStyle);
        this.itemAdapter = bVar;
        setLayoutManager(new LinearLayoutManager(panelContext.c()));
        setAdapter(bVar);
        com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b itemAnimatorListener = panelContext.getItemAnimatorListener();
        setItemAnimator(itemAnimatorListener != null ? itemAnimatorListener.a() : null);
    }
}
