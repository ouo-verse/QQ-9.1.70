package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.input.at.utils.j;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorAtUseCaseMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R,\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0015\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/d;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/a;", "", "k", "j", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "Landroid/view/View;", h.F, "Landroid/view/View;", "mAnchorView", "Lze1/b;", "i", "Lze1/b;", "mAtPanel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/base/api/runtime/a;", "()Lcom/tencent/base/api/runtime/a;", "l", "(Lcom/tencent/base/api/runtime/a;)V", "mContext", "", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAnchorView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ze1.b mAtPanel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public com.tencent.base.api.runtime.a<zl1.a> mContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/d$a", "Lye1/c;", "", "select", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "member", "", "selectCount", "triggerType", "", "e", "isFinishSelection", "dismissFlag", "", "selectedMembers", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends ye1.c {
        a() {
        }

        @Override // ye1.a
        public void d(boolean isFinishSelection, int dismissFlag, @NotNull List<? extends IGProUserInfo> selectedMembers) {
            Intrinsics.checkNotNullParameter(selectedMembers, "selectedMembers");
            QLog.d(d.this.h(), 2, "members=" + selectedMembers);
            d.this.i().e().h(new SimplifiedFeedEditorGlobalMsgIntent.OverwriteCloseIntent(d.this.h(), null, false, 4, null));
            if (!selectedMembers.isEmpty()) {
                d.this.i().e().h(new GuildFeedEditTextMsgIntent.ReplyTextByAt(selectedMembers));
            } else {
                d.this.i().e().h(GuildFeedEditTextMsgIntent.ShowKeyboard.f221846d);
            }
        }

        @Override // ye1.a
        public void e(boolean select, @NotNull String guildId, @NotNull IGProUserInfo member, int selectCount, int triggerType) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(member, "member");
            if (d.this.mAtPanel != null) {
                ze1.b bVar = d.this.mAtPanel;
                Intrinsics.checkNotNull(bVar);
                if (!bVar.h()) {
                    ze1.b bVar2 = d.this.mAtPanel;
                    Intrinsics.checkNotNull(bVar2);
                    bVar2.dismiss();
                }
            }
        }
    }

    public d() {
        super(null, 1, null);
    }

    private final void j() {
        String h16 = i().h().h();
        String a16 = i().h().a();
        Activity f16 = i().f();
        Context context = i().c().getContext();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ze1.b bVar = (ze1.b) j.a(new xe1.b(h16, a16, 7, f16, context, (AppInterface) peekAppRuntime, 1, xe1.b.h("pg_sgrp_forum_short_editor", "")));
        this.mAtPanel = bVar;
        if (bVar != null) {
            bVar.f("");
        }
        ze1.b bVar2 = this.mAtPanel;
        if (bVar2 != null) {
            bVar2.k(new a());
        }
    }

    private final void k() {
        c.a aVar;
        zl1.a h16 = i().h();
        Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
        if (zl1.b.c(h16) == 7) {
            return;
        }
        if (this.mAtPanel == null) {
            j();
        }
        i().e().h(new SimplifiedFeedEditorGlobalMsgIntent.HideAllPanelAndKeyboard(h()));
        if (this.mAnchorView == null) {
            k k3 = i().e().k(FeedEditorAtUseCaseMsgIntent.GetAnchorView.f222388d);
            View view = null;
            if (k3 instanceof c.a) {
                aVar = (c.a) k3;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                view = aVar.getAnchorView();
            }
            this.mAnchorView = view;
        }
        ze1.b bVar = this.mAtPanel;
        if (bVar != null) {
            bVar.j("", this.mAnchorView);
            bVar.i(this.mAnchorView);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedEditorAtUseCaseMsgIntent.OpenAtPanel) {
            k();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    /* renamed from: e */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.b(context, reuse);
        l(context);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorAtUseCaseMsgIntent.OpenAtPanel");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @NotNull
    protected String h() {
        return "FeedEditor.AtUseCase";
    }

    @NotNull
    public final com.tencent.base.api.runtime.a<zl1.a> i() {
        com.tencent.base.api.runtime.a<zl1.a> aVar = this.mContext;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    public final void l(@NotNull com.tencent.base.api.runtime.a<zl1.a> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mContext = aVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        super.onDestroy();
        ze1.b bVar = this.mAtPanel;
        if (bVar != null) {
            j.d(bVar);
        }
    }
}
