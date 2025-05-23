package com.tencent.mobileqq.guild.home.views.header.delegates;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.distribute.api.IQQGuildDistributeApi;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderGameDistribute;
import com.tencent.mobileqq.guild.home.views.header.delegates.BaseHeaderBarsAbsDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderGameDistributeAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/BaseHeaderBarsAbsDelegate;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/c;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderGameDistributeAdapterDelegate$b;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "<init>", "()V", "d", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class HeaderGameDistributeAdapterDelegate extends BaseHeaderBarsAbsDelegate<GuildHomeHeaderGameDistribute, b> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f225661d = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderGameDistributeAdapterDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderGameDistributeAdapterDelegate$b;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/BaseHeaderBarsAbsDelegate$a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends BaseHeaderBarsAbsDelegate.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b item, @NotNull List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildHomeHeaderGameDistribute;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GuildHomeHeaderGameDistribute item, @NotNull b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.NewHome.HeaderGameDistributeAdapterDelegate", 1, "onBindViewHolder item:" + item + " ");
        }
        View view = holder.itemView;
        if (!(view instanceof IDistributeButton)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        } else {
            layoutParams.width = -1;
            layoutParams.height = -2;
        }
        holder.itemView.setLayoutParams(layoutParams);
        IQQGuildDistributeApi iQQGuildDistributeApi = (IQQGuildDistributeApi) QRoute.api(IQQGuildDistributeApi.class);
        KeyEvent.Callback callback = holder.itemView;
        Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton");
        iQQGuildDistributeApi.updateGuildDistributeView((IDistributeButton) callback, item.getGameDistributeInfo(), item.getGameDistributeExtraInfo());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Object guildDistributeView = ((IQQGuildDistributeApi) QRoute.api(IQQGuildDistributeApi.class)).getGuildDistributeView(parent.getContext());
        Intrinsics.checkNotNull(guildDistributeView, "null cannot be cast to non-null type android.view.View");
        return new b((View) guildDistributeView);
    }
}
