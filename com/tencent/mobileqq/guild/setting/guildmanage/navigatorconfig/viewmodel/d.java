package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel;

import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.bs;
import com.tencent.mobileqq.qqguildsdk.data.genc.bt;
import com.tencent.mobileqq.qqguildsdk.data.genc.ea;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.cq;
import wh2.ct;
import wh2.dy;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J>\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0005\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/viewmodel/d;", "Lcom/tencent/mobileqq/mvvm/a;", "", "guildId", "Lwh2/ct;", "cb", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "iconSelectorColor", "version", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/ea;", "Lkotlin/collections/ArrayList;", "saveItems", "Lwh2/dy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lwh2/cq;", "o", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "a", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getIgpsService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "setIgpsService", "(Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;)V", "igpsService", "<init>", "()V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IGPSService igpsService;

    public d() {
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService<IGPSServi\u2026(IGPSService::class.java)");
        this.igpsService = (IGPSService) R0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Ref.ObjectRef req, ct cb5, int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("Guild.mnr.QQGuildNavigatorConfigRepository", 2, "getNavigationConfigInfo: req:" + req.element + "    \nresult:" + i3 + "   errorMsg:" + str + "    resp:" + iGProGetPreviewNavigationRsp);
        ArrayList<IGProGuildNavIconTheme> iconThemes = iGProGetPreviewNavigationRsp.getIconThemes();
        Intrinsics.checkNotNullExpressionValue(iconThemes, "resp.iconThemes");
        Iterator<T> it = iconThemes.iterator();
        while (it.hasNext()) {
            QLog.i("Guild.mnr.QQGuildNavigatorConfigRepository", 2, "getNavigationConfigInfo:  iconTheme: " + ((IGProGuildNavIconTheme) it.next()));
        }
        cb5.a(i3, str, iGProGetPreviewNavigationRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Ref.ObjectRef req, cq cb5, int i3, String str, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("Guild.mnr.QQGuildNavigatorConfigRepository", 2, "getNavigationStatus: req:" + req.element + "    \nresult:" + i3 + "   errorMsg:" + str + "   resp:" + iGProGetNavigationStatusRsp);
        cb5.a(i3, str, iGProGetNavigationStatusRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Ref.ObjectRef req, dy cb5, int i3, String str) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("Guild.mnr.QQGuildNavigatorConfigRepository", 2, "saveNavigationConfig: req:" + req.element + "    \nresult:" + i3 + "   errorMsg:" + str);
        cb5.onSaveGuildNavigation(i3, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.mobileqq.qqguildsdk.data.genc.bt, T] */
    public final void m(long guildId, @NotNull final ct cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? btVar = new bt();
        objectRef.element = btVar;
        btVar.b(guildId);
        this.igpsService.getPreviewNavigation((bt) objectRef.element, new ct() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.c
            @Override // wh2.ct
            public final void a(int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
                d.n(Ref.ObjectRef.this, cb5, i3, str, iGProGetPreviewNavigationRsp);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.mobileqq.qqguildsdk.data.genc.bs, T] */
    public final void o(long guildId, @NotNull final cq cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? bsVar = new bs();
        objectRef.element = bsVar;
        bsVar.b(guildId);
        this.igpsService.getNavigationStatus((bs) objectRef.element, new cq() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.a
            @Override // wh2.cq
            public final void a(int i3, String str, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
                d.p(Ref.ObjectRef.this, cb5, i3, str, iGProGetNavigationStatusRsp);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.mobileqq.qqguildsdk.data.genc.dy] */
    public final void q(long guildId, @NotNull String iconSelectorColor, long version, @NotNull ArrayList<ea> saveItems, @NotNull final dy cb5) {
        Intrinsics.checkNotNullParameter(iconSelectorColor, "iconSelectorColor");
        Intrinsics.checkNotNullParameter(saveItems, "saveItems");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? dyVar = new com.tencent.mobileqq.qqguildsdk.data.genc.dy();
        objectRef.element = dyVar;
        dyVar.e(guildId);
        ((com.tencent.mobileqq.qqguildsdk.data.genc.dy) objectRef.element).f(iconSelectorColor);
        ((com.tencent.mobileqq.qqguildsdk.data.genc.dy) objectRef.element).h(version);
        ((com.tencent.mobileqq.qqguildsdk.data.genc.dy) objectRef.element).g(saveItems);
        this.igpsService.saveGuidNavigation((com.tencent.mobileqq.qqguildsdk.data.genc.dy) objectRef.element, new dy() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.b
            @Override // wh2.dy
            public final void onSaveGuildNavigation(int i3, String str) {
                d.r(Ref.ObjectRef.this, cb5, i3, str);
            }
        });
    }
}
