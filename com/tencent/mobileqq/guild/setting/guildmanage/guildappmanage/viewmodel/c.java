package com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel;

import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.bn;
import com.tencent.mobileqq.qqguildsdk.data.genc.bt;
import com.tencent.mobileqq.qqguildsdk.data.genc.ej;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.cg;
import wh2.ct;
import wh2.ef;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007JF\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\f2\u0006\u0010\b\u001a\u00020\u000fJ\u001e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/c;", "Lcom/tencent/mobileqq/mvvm/a;", "", "guildId", "", "needChannel", "needFilterClosedCategories", "Lwh2/cg;", "cb", "", "l", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "enableList", "disableList", "Lwh2/ef;", "p", "", "tag", "Lwh2/ct;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "a", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getIgpsService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "setIgpsService", "(Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;)V", "igpsService", "<init>", "()V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IGPSService igpsService;

    public c() {
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService<IGPSServi\u2026(IGPSService::class.java)");
        this.igpsService = (IGPSService) R0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(cg cb5, ArrayList it) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            IGProCategoryChannelInfoList iGProCategoryChannelInfoList = (IGProCategoryChannelInfoList) it5.next();
            QLog.i("GuildApplicationManageRepository", 1, "getGuildAppListInfo categoryType:" + iGProCategoryChannelInfoList.getCategoryType() + " closeSwitch:" + iGProCategoryChannelInfoList.getCloseSwitch());
        }
        cb5.onGetGuildHomeCategories(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String tag, Ref.ObjectRef req, ct cb5, int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("GuildApplicationManageRepository", 2, "getNavigationConfigInfo(" + tag + "): req:" + req.element + "    \nresult:" + i3 + "   errorMsg:" + str + "    resp:" + iGProGetPreviewNavigationRsp);
        ArrayList<IGProGuildNavIconTheme> iconThemes = iGProGetPreviewNavigationRsp.getIconThemes();
        Intrinsics.checkNotNullExpressionValue(iconThemes, "resp.iconThemes");
        Iterator<T> it = iconThemes.iterator();
        while (it.hasNext()) {
            QLog.i("GuildApplicationManageRepository", 2, "getNavigationConfigInfo:  iconTheme: " + ((IGProGuildNavIconTheme) it.next()));
        }
        cb5.a(i3, str, iGProGetPreviewNavigationRsp);
    }

    public final void l(long guildId, boolean needChannel, boolean needFilterClosedCategories, @NotNull final cg cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        bn bnVar = new bn();
        bnVar.e(guildId);
        bnVar.f(needChannel);
        bnVar.d(needFilterClosedCategories);
        this.igpsService.getGuildHomeCategories(bnVar, new cg() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.a
            @Override // wh2.cg
            public final void onGetGuildHomeCategories(ArrayList arrayList) {
                c.m(cg.this, arrayList);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.mobileqq.qqguildsdk.data.genc.bt, T] */
    public final void n(@NotNull final String tag, long guildId, @NotNull final ct cb5) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? btVar = new bt();
        objectRef.element = btVar;
        btVar.b(guildId);
        this.igpsService.getPreviewNavigation((bt) objectRef.element, new ct() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.b
            @Override // wh2.ct
            public final void a(int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
                c.o(tag, objectRef, cb5, i3, str, iGProGetPreviewNavigationRsp);
            }
        });
    }

    public final void p(long guildId, @NotNull ArrayList<Long> enableList, @NotNull ArrayList<Long> disableList, @NotNull ef cb5) {
        Intrinsics.checkNotNullParameter(enableList, "enableList");
        Intrinsics.checkNotNullParameter(disableList, "disableList");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ej ejVar = new ej();
        ejVar.f(guildId);
        ejVar.e(enableList);
        ejVar.d(disableList);
        this.igpsService.setChannelCategoryOrder(ejVar, cb5);
    }
}
