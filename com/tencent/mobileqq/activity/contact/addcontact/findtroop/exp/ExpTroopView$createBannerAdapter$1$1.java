package com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/mobileqq/troop/exp/model/d;", "holder", "Lcom/tencent/mobileqq/troop/exp/model/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", com.tencent.luggage.wxa.c8.c.G, "", "invoke", "(Lcom/tencent/mobileqq/troop/exp/model/d;Lcom/tencent/mobileqq/troop/exp/model/c;I)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ExpTroopView$createBannerAdapter$1$1 extends Lambda implements Function3<com.tencent.mobileqq.troop.exp.model.d, com.tencent.mobileqq.troop.exp.model.c, Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ExpTroopView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpTroopView$createBannerAdapter$1$1(ExpTroopView expTroopView) {
        super(3);
        this.this$0 = expTroopView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) expTroopView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.mobileqq.troop.exp.model.c item, ExpTroopView this$0, View view) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String b16 = item.b();
        ax b17 = com.tencent.mobileqq.troop.troopcard.reborn.ktx.b.f299536a.b(b16);
        if (b17 == null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(b16, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(b16, "https://", false, 2, null);
                if (!startsWith$default2) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(b16, "tel://", false, 2, null);
                    if (startsWith$default3) {
                        String substring = b16.substring(6);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        this$0.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + substring)));
                    }
                }
            }
            QZoneHelper.reportIfIsFromQZone(b16);
            HashMap hashMap = new HashMap();
            hashMap.put("url", b16);
            ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(this$0.getContext(), hashMap);
        } else {
            b17.b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.exp.model.d dVar, com.tencent.mobileqq.troop.exp.model.c cVar, Integer num) {
        invoke(dVar, cVar, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull com.tencent.mobileqq.troop.exp.model.d holder, @NotNull final com.tencent.mobileqq.troop.exp.model.c item, int i3) {
        Map mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, holder, item, Integer.valueOf(i3));
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        holder.n(context, item.a());
        holder.l().setFocusable(true);
        int i16 = i3 + 1;
        holder.l().setContentDescription("\u5e7f\u544a" + i16);
        ImageView l3 = holder.l();
        final ExpTroopView expTroopView = this.this$0;
        l3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpTroopView$createBannerAdapter$1$1.b(com.tencent.mobileqq.troop.exp.model.c.this, expTroopView, view);
            }
        });
        ExpTroopView expTroopView2 = this.this$0;
        ImageView l16 = holder.l();
        String str = com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181104p;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("banner_index", Integer.valueOf(i16)), TuplesKt.to("jump_link", item.b()));
        ExpTroopView.J(expTroopView2, l16, null, str, mapOf, ExposurePolicy.REPORT_ALL, null, ClickPolicy.REPORT_ALL, 34, null);
    }
}
