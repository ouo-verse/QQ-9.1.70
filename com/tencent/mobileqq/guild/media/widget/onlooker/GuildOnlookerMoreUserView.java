package com.tencent.mobileqq.guild.media.widget.onlooker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.widget.GuildMediaMoreUserViewBase;
import com.tencent.mobileqq.guild.media.widget.onlooker.GuildOnlookerMoreUserView;
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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u001d\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/onlooker/GuildOnlookerMoreUserView;", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMoreUserViewBase;", "", "j", "k", "l", h.F, "", "e", "b", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "i", "mTwoAvatarLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mThreeAvatarLayout", "", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "mTwoAvatarViewMap", "D", "mThreeAvatarViewMap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOnlookerMoreUserView extends GuildMediaMoreUserViewBase {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, GuildUserAvatarView> mTwoAvatarViewMap;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, GuildUserAvatarView> mThreeAvatarViewMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mTwoAvatarLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mThreeAvatarLayout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildOnlookerMoreUserView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void h() {
        AppInterface appInterface;
        String guildID = j.a().getGuildID();
        String E = j.a().E();
        QLog.i("QGMC.GuildOnlookerMoreUserView", 1, "[launchChannelDetailPage] guildId: " + guildID + ", channelId: " + E);
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
    public static final void i(GuildOnlookerMoreUserView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j() {
        QLog.w("QGMC.GuildOnlookerMoreUserView", 1, "[updateViewWhenParamsInvalid] ");
        this.mTwoAvatarLayout.setVisibility(8);
        this.mThreeAvatarLayout.setVisibility(8);
    }

    private final void k() {
        this.mTwoAvatarLayout.setVisibility(0);
        this.mThreeAvatarLayout.setVisibility(8);
        for (Map.Entry<Integer, GuildUserAvatarView> entry : this.mTwoAvatarViewMap.entrySet()) {
            f(entry.getKey().intValue(), entry.getValue());
        }
    }

    private final void l() {
        this.mTwoAvatarLayout.setVisibility(8);
        this.mThreeAvatarLayout.setVisibility(0);
        for (Map.Entry<Integer, GuildUserAvatarView> entry : this.mThreeAvatarViewMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            GuildUserAvatarView value = entry.getValue();
            if (intValue >= e()) {
                return;
            } else {
                f(intValue, value);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.widget.GuildMediaMoreUserViewBase
    protected void b() {
        if (d().size() < 2) {
            j();
        } else if (d().size() == 2) {
            k();
        } else if (d().size() >= e()) {
            l();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.widget.GuildMediaMoreUserViewBase
    protected int e() {
        return j.c().getMaxViewerShowRule().getMaxThumbnailShowNum();
    }

    public /* synthetic */ GuildOnlookerMoreUserView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildOnlookerMoreUserView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Map<Integer, GuildUserAvatarView> mapOf;
        Map<Integer, GuildUserAvatarView> mapOf2;
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.eyw, this);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: ot1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildOnlookerMoreUserView.i(GuildOnlookerMoreUserView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ailPage()\n        }\n    }");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f112806ox);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.twoAvatarLayout)");
        this.mTwoAvatarLayout = findViewById;
        View findViewById2 = inflate.findViewById(R.id.f96805io);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.threeAvatarLayout)");
        this.mThreeAvatarLayout = findViewById2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, inflate.findViewById(R.id.vwe)), TuplesKt.to(1, inflate.findViewById(R.id.vwf)));
        this.mTwoAvatarViewMap = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(0, inflate.findViewById(R.id.vwg)), TuplesKt.to(1, inflate.findViewById(R.id.vwh)), TuplesKt.to(2, inflate.findViewById(R.id.vwi)));
        this.mThreeAvatarViewMap = mapOf2;
    }
}
