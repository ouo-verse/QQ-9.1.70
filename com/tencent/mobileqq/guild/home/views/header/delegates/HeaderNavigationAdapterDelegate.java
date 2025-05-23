package com.tencent.mobileqq.guild.home.views.header.delegates;

import android.util.Log;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import com.tencent.mobileqq.guild.home.views.header.delegates.BaseHeaderBarsAbsDelegate;
import com.tencent.mobileqq.guild.home.views.widget.GuildNavigatorView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u001cB\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderNavigationAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/BaseHeaderBarsAbsDelegate;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderNavigationAdapterDelegate$b;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "updateNavigatorExpand", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class HeaderNavigationAdapterDelegate extends BaseHeaderBarsAbsDelegate<GuildHomeHeaderNavigationBar, b> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f225665e = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> updateNavigatorExpand;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderNavigationAdapterDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderNavigationAdapterDelegate$b;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/BaseHeaderBarsAbsDelegate$a;", "", "guildId", "", "l", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView;", "getRootView", "()Lcom/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "G", "Ljava/lang/String;", "mGuildId", "Lkotlin/Function0;", "updateNavigatorExpand", "<init>", "(Lcom/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends BaseHeaderBarsAbsDelegate.a {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final GuildNavigatorView rootView;

        /* renamed from: G, reason: from kotlin metadata */
        private String mGuildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull GuildNavigatorView rootView, @NotNull Function0<Unit> updateNavigatorExpand) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(updateNavigatorExpand, "updateNavigatorExpand");
            this.rootView = rootView;
            rootView.setUpdateExpandStatus(updateNavigatorExpand);
        }

        public final void l(@Nullable String guildId) {
            if (guildId != null) {
                this.mGuildId = guildId;
            }
        }

        public final void m(@NotNull GuildHomeHeaderNavigationBar item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.rootView.H(item);
        }
    }

    public HeaderNavigationAdapterDelegate(@NotNull Function0<Unit> updateNavigatorExpand) {
        Intrinsics.checkNotNullParameter(updateNavigatorExpand, "updateNavigatorExpand");
        this.updateNavigatorExpand = updateNavigatorExpand;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b item, @NotNull List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildHomeHeaderNavigationBar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GuildHomeHeaderNavigationBar item, @NotNull b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.HeaderNavigationAdapterDelegate", "onBindViewHolder item:" + item);
        }
        holder.l(item.getGuildId());
        holder.m(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        GuildNavigatorView guildNavigatorView = new GuildNavigatorView(parent.getContext());
        guildNavigatorView.setColumnCount(5);
        guildNavigatorView.setRowCount(3);
        guildNavigatorView.setLayoutParams(new ViewGroup.LayoutParams(-1, GuildNavigatorView.INSTANCE.a()));
        guildNavigatorView.setNavigatorIconInItemSize(ViewUtils.f352270a.a(22.0f));
        return new b(guildNavigatorView, this.updateNavigatorExpand);
    }
}
