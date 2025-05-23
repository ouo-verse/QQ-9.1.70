package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0002$\tB\u001d\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMemberMoreUserView;", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMoreUserViewBase;", "", "j", "k", "l", tl.h.F, "", "e", "b", "index", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "f", "Lcom/tencent/mobileqq/guild/media/widget/GuildMemberMoreUserView$b;", "layoutParam", "setLayoutParam", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "", "i", "Ljava/util/Map;", "mThreeAvatarViewMap", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mMoreTv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberMoreUserView extends GuildMediaMoreUserViewBase {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, GuildUserAvatarView> mThreeAvatarViewMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView mMoreTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMemberMoreUserView$b;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMemberMoreUserView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void h() {
        AppInterface appInterface;
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        QLog.i("QGMC.GuildMemberMoreUserView", 1, "[launchChannelDetailPage] guildId: " + guildID + ", channelId: " + E);
        IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        iQQGuildRouterApi.openGuildMediaChannelDetailFragment(appInterface, getContext(), guildID, E, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildMemberMoreUserView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j() {
        setVisibility(8);
    }

    private final void k() {
        setVisibility(0);
        GuildUserAvatarView guildUserAvatarView = this.mThreeAvatarViewMap.get(Integer.valueOf(this.mThreeAvatarViewMap.size() - 1));
        if (guildUserAvatarView != null) {
            guildUserAvatarView.setVisibility(8);
        }
        for (Map.Entry<Integer, GuildUserAvatarView> entry : this.mThreeAvatarViewMap.entrySet()) {
            f(entry.getKey().intValue(), entry.getValue());
        }
    }

    private final void l() {
        setVisibility(0);
        GuildUserAvatarView guildUserAvatarView = this.mThreeAvatarViewMap.get(Integer.valueOf(this.mThreeAvatarViewMap.size() - 1));
        if (guildUserAvatarView != null) {
            guildUserAvatarView.setVisibility(0);
        }
        for (Map.Entry<Integer, GuildUserAvatarView> entry : this.mThreeAvatarViewMap.entrySet()) {
            f(entry.getKey().intValue(), entry.getValue());
        }
    }

    @Override // com.tencent.mobileqq.guild.media.widget.GuildMediaMoreUserViewBase
    protected void b() {
        if (d().size() < 2) {
            j();
            return;
        }
        if (d().size() == 2) {
            k();
        } else if (d().size() == 3) {
            l();
        } else if (d().size() > 3) {
            j();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.widget.GuildMediaMoreUserViewBase
    protected int e() {
        return com.tencent.mobileqq.guild.media.core.j.c().getMaxPlayerShowRule().getMaxThumbnailShowNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.media.widget.GuildMediaMoreUserViewBase
    public void f(int index, @NotNull GuildUserAvatarView avatarView) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        if (index >= d().size()) {
            QLog.w("QGMC.GuildMediaMoreUserViewBase", 1, "[loadAvatarUrl2View] IndexOutOfBoundsException. ignored");
        } else {
            super.f(index, avatarView);
        }
    }

    public final void setLayoutParam(@NotNull b layoutParam) {
        Intrinsics.checkNotNullParameter(layoutParam, "layoutParam");
    }

    public /* synthetic */ GuildMemberMoreUserView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMemberMoreUserView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Map<Integer, GuildUserAvatarView> mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.eyt, this);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMemberMoreUserView.i(GuildMemberMoreUserView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ailPage()\n        }\n    }");
        this.mRootView = inflate;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, inflate.findViewById(R.id.w07)), TuplesKt.to(1, inflate.findViewById(R.id.w08)), TuplesKt.to(2, inflate.findViewById(R.id.w09)));
        this.mThreeAvatarViewMap = mapOf;
        this.mMoreTv = (TextView) inflate.findViewById(R.id.wqu);
    }
}
