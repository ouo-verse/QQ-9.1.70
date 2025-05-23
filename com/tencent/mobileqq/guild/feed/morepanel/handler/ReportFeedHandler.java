package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImpeachReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImpeachRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J \u0010\t\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J0\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ReportFeedHandler;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "f", "e", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ReportFeedHandler implements x {
    private final boolean e(PanelContext<Activity, vk1.b> panelContext) {
        if (panelContext.getExtra().getInt("src_business_type") == 7) {
            return true;
        }
        return false;
    }

    private final boolean f(final PanelContext<Activity, vk1.b> panelContext) {
        if (e(panelContext)) {
            com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
            if (c16 != null) {
                GProImpeachReq gProImpeachReq = new GProImpeachReq();
                gProImpeachReq.feed.idd = panelContext.j().getFeedId();
                gProImpeachReq.impeachType = 0;
                c16.impeach(gProImpeachReq, new IGProImpeachCallback() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.z
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback
                    public final void onResult(int i3, String str, boolean z16, GProImpeachRsp gProImpeachRsp) {
                        ReportFeedHandler.g(PanelContext.this, i3, str, z16, gProImpeachRsp);
                    }
                });
            }
            return true;
        }
        ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuildFeed(panelContext.h(), panelContext.j().r(), panelContext.j().getFeedId(), String.valueOf(panelContext.j().getGuildId()), String.valueOf(panelContext.j().getChannelId()), null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final PanelContext panelContext, int i3, String str, boolean z16, GProImpeachRsp gProImpeachRsp) {
        Intrinsics.checkNotNullParameter(panelContext, "$panelContext");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ReportFeedHandler$realHandle$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(panelContext.h(), 2, R.string.f144750pm, 0).show();
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        return f(panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        return x.a.c(this, str, panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
    public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        shareActionSheet.dismiss();
        return f(panelContext);
    }
}
