package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%B\u001b\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b$\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0014J\u0018\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0014\u0010\u0012\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J \u0010\u0018\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019R\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 \u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTabBarCompatRightBtn;", "Landroid/widget/FrameLayout;", "", "d", "f", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "list", "", "c", "onFinishInflate", "", "guildId", "hasPermission", "e", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "b", "setData", "curGuildId", "Landroidx/fragment/app/Fragment;", "fragment", "", "squareCategoryId", "setParam", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar$h;", "onCurrentTabClickListener", "setOnCurrentTabClickListener", "Lx12/q;", "Lx12/q;", "binding", "Ljava/lang/String;", "Z", "hasPermissionShowSettingBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareTabBarCompatRightBtn extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private x12.q binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasPermissionShowSettingBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareTabBarCompatRightBtn(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.guildId = "";
    }

    private final boolean c(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        Object obj;
        boolean z16;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.guild.feed.feedsquare.data.l) obj).getSectionInfo().getType() == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((com.tencent.mobileqq.guild.feed.feedsquare.data.l) obj) != null) {
            return true;
        }
        return false;
    }

    private final void d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{getResources().getColor(R.color.ajr), ie0.a.f().g(getContext(), R.color.qui_common_bg_bottom_light, 1000)});
        x12.q qVar = this.binding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar = null;
        }
        qVar.f446991b.setBackground(gradientDrawable);
    }

    private final void f() {
        boolean z16;
        x12.q qVar = this.binding;
        x12.q qVar2 = null;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar = null;
        }
        if (!c(qVar.f446992c.i()) && this.hasPermissionShowSettingBtn) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("GuildFeedSquareTabBarCompatRightBtn", 1, "updateSettingBtnStatus guildId=" + this.guildId + " visible=" + z16);
        this.guildId = this.guildId;
        if (z16) {
            x12.q qVar3 = this.binding;
            if (qVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                qVar3 = null;
            }
            qVar3.f446993d.setVisibility(0);
            x12.q qVar4 = this.binding;
            if (qVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                qVar4 = null;
            }
            final FrameLayout frameLayout = qVar4.f446994e;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.settingBtn");
            final long j3 = 200;
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBarCompatRightBtn$updateSettingBtnVisible$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    String str;
                    EventCollector.getInstance().onViewClickedBefore(it);
                    frameLayout.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    QLog.i("GuildFeedSquareTabBarCompatRightBtn", 1, "onSettingBtnClick");
                    IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                    Context context = this.getContext();
                    str = this.guildId;
                    iQQGuildRouterApi.openGuildChannelManage(context, str, 1);
                    final View view = frameLayout;
                    view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBarCompatRightBtn$updateSettingBtnVisible$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
            x12.q qVar5 = this.binding;
            if (qVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                qVar2 = qVar5;
            }
            qVar2.f446992c.u(GuildFeedSquareTabBarV2.INSTANCE.c());
            return;
        }
        x12.q qVar6 = this.binding;
        if (qVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar6 = null;
        }
        qVar6.f446993d.setVisibility(8);
        x12.q qVar7 = this.binding;
        if (qVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            qVar2 = qVar7;
        }
        qVar2.f446992c.u(GuildFeedSquareTabBarV2.INSTANCE.d());
    }

    public final void b(@Nullable ViewPager2 viewPager) {
        x12.q qVar = this.binding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar = null;
        }
        qVar.f446992c.bindViewPager2(viewPager);
    }

    public final void e(@Nullable String guildId, boolean hasPermission) {
        QLog.i("GuildFeedSquareTabBarCompatRightBtn", 1, "updateSettingBtnStatus guildId=" + guildId + " hasPermission=" + hasPermission);
        this.hasPermissionShowSettingBtn = hasPermission;
        this.guildId = guildId;
        f();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        x12.q g16 = x12.q.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(this), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, this, true)");
        this.binding = g16;
        x12.q qVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        ImageView imageView = g16.f446995f;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.settingIcon");
        GuildUIUtils.d(imageView, R.drawable.guild_icon_settings, Integer.valueOf(R.color.qui_common_icon_primary));
        d();
        x12.q qVar2 = this.binding;
        if (qVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            qVar = qVar2;
        }
        ch.Y0(qVar.f446994e, "em_sgrp_forum_square_set", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    public final void setData(@NotNull List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        x12.q qVar = this.binding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar = null;
        }
        qVar.f446992c.setData(list);
        f();
    }

    public final void setOnCurrentTabClickListener(@NotNull QUIPageTabBar.h onCurrentTabClickListener) {
        Intrinsics.checkNotNullParameter(onCurrentTabClickListener, "onCurrentTabClickListener");
        x12.q qVar = this.binding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar = null;
        }
        qVar.f446992c.setOnCurrentTabClickListener(onCurrentTabClickListener);
    }

    public final void setParam(@Nullable String curGuildId, @NotNull Fragment fragment, long squareCategoryId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        x12.q qVar = this.binding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar = null;
        }
        qVar.f446992c.setParam(curGuildId, fragment, squareCategoryId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareTabBarCompatRightBtn(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.guildId = "";
    }
}
