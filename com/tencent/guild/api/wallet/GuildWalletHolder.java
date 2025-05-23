package com.tencent.guild.api.wallet;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.IWalletHbItemV2Api;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import d4.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\u000eB!\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u00a2\u0006\u0004\b \u0010!J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/api/wallet/GuildWalletHolder;", "Lcom/tencent/guild/api/wallet/a;", "Lyk2/a;", "", h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c", "", WadlProxyConsts.KEY_JUMP_URL, "e", "Landroid/view/View;", "getBackground", "Landroid/widget/TextView;", "a", "", "d", "b", "Lvk2/d;", "Lvk2/d;", "qWalletMsgModel", "Ld4/f;", "Ld4/f;", "holder", "Lvk2/e;", "Lvk2/e;", "sessionInfo", "Lyk2/a;", "subViewHolder", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "hbStateChangeListener", "<init>", "(Lvk2/d;Ld4/f;Lvk2/e;)V", "f", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildWalletHolder implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletMsgModel qWalletMsgModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final f holder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletSessionInfo sessionInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private yk2.a subViewHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> hbStateChangeListener;

    public GuildWalletHolder(@NotNull QWalletMsgModel qWalletMsgModel, @Nullable f fVar, @NotNull QWalletSessionInfo sessionInfo) {
        yk2.a subViewHolder$lambda$0;
        Intrinsics.checkNotNullParameter(qWalletMsgModel, "qWalletMsgModel");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        this.qWalletMsgModel = qWalletMsgModel;
        this.holder = fVar;
        this.sessionInfo = sessionInfo;
        if (fVar != null) {
            subViewHolder$lambda$0 = ((IViewHolderFactory) QRoute.api(IViewHolderFactory.class)).createViewHolderV2(fVar, qWalletMsgModel, sessionInfo);
            Intrinsics.checkNotNullExpressionValue(subViewHolder$lambda$0, "subViewHolder$lambda$0");
            h(subViewHolder$lambda$0);
        } else {
            subViewHolder$lambda$0 = null;
        }
        this.subViewHolder = subViewHolder$lambda$0;
        this.hbStateChangeListener = new Function0<Unit>() { // from class: com.tencent.guild.api.wallet.GuildWalletHolder$hbStateChangeListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                yk2.a aVar;
                QLog.d("GuildWalletHolder", 4, "HbStateChangeListener callback");
                aVar = GuildWalletHolder.this.subViewHolder;
                if (aVar != null) {
                    GuildWalletHolder.this.h(aVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(yk2.a aVar) {
        aVar.onCreate();
        aVar.b();
        aVar.c();
        aVar.d();
        aVar.a();
        aVar.f();
        aVar.e();
        aVar.onResume();
    }

    @Override // com.tencent.guild.api.wallet.a
    @Nullable
    public TextView a() {
        f fVar = this.holder;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // com.tencent.guild.api.wallet.a
    public void b() {
        yk2.a aVar = this.subViewHolder;
        if (aVar != null) {
            h(aVar);
        }
    }

    @Override // com.tencent.guild.api.wallet.a
    public void c(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        vk2.a.f441761a.b(this.hbStateChangeListener);
        ((IWalletHbItemV2Api) QRoute.api(IWalletHbItemV2Api.class)).handleOnClick(activity, this.qWalletMsgModel, this.sessionInfo);
    }

    @Override // com.tencent.guild.api.wallet.a
    @NotNull
    public List<String> d() {
        int collectionSizeOrDefault;
        List<Long> f16 = this.qWalletMsgModel.getHbModel().f();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(f16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = f16.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        return arrayList;
    }

    @Override // com.tencent.guild.api.wallet.a
    public void e(@NotNull Activity activity, @NotNull String jumpUrl) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        isBlank = StringsKt__StringsJVMKt.isBlank(jumpUrl);
        if (isBlank) {
            return;
        }
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doStartBrowser(activity, jumpUrl);
    }

    @Override // com.tencent.guild.api.wallet.a
    @Nullable
    public View getBackground() {
        f fVar = this.holder;
        if (fVar != null) {
            return fVar.getBackground();
        }
        return null;
    }
}
