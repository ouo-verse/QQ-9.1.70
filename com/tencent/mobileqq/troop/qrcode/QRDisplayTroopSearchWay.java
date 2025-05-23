package com.tencent.mobileqq.troop.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.qrcode.QRDisplayTroopSearchWay;
import com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010B%\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R$\u0010(\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay;", "", "", tl.h.F, "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "c", "Landroid/text/SpannableStringBuilder;", "f", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "i", "j", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "d", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "b", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getTroopInfo", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "g", "()Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "searchWayViewModel", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay$a;", "e", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay$a;", "()Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay$a;", "k", "(Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay$a;)V", "searchWayUpdateCallback", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/data/troop/TroopInfo;Lcom/tencent/mobileqq/troop/data/TroopInfoData;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QRDisplayTroopSearchWay {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TroopInfo troopInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TroopInfoData troopInfoData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b searchWayViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a searchWayUpdateCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay$a;", "", "", "newTroopName", "", "b", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void a();

        void b(@Nullable String newTroopName);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ClickableSpan {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopSearchWay.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
            } else {
                Intrinsics.checkNotNullParameter(widget, "widget");
                QRDisplayTroopSearchWay.this.h();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setUnderlineText(false);
            ds5.setColor(QRDisplayTroopSearchWay.this.d().getColor(R.color.qui_common_text_link));
            ds5.bgColor = 0;
        }
    }

    public QRDisplayTroopSearchWay(@Nullable Activity activity, @Nullable TroopInfo troopInfo, @Nullable TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, troopInfo, troopInfoData);
            return;
        }
        this.activity = activity;
        this.troopInfo = troopInfo;
        this.troopInfoData = troopInfoData;
        this.searchWayViewModel = c();
    }

    private final com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b c() {
        AppInterface appInterface;
        TroopInfo troopInfo;
        TroopSearchWay d16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null || (troopInfo = this.troopInfo) == null || (d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(troopInfo)) == null) {
            return null;
        }
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar = new com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b(appInterface);
        bVar.g(d16);
        bVar.f(new Function1<com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c, Unit>() { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopSearchWay$createSearchWayViewModel$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopSearchWay.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c cVar) {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                    return;
                }
                Intrinsics.checkNotNullParameter(cVar, "<name for destructuring parameter 0>");
                boolean a16 = cVar.a();
                cVar.b();
                QRDisplayTroopSearchWay.a e16 = QRDisplayTroopSearchWay.this.e();
                if (e16 != null) {
                    e16.a();
                }
                if (a16) {
                    com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                    Activity d17 = QRDisplayTroopSearchWay.this.d();
                    Activity d18 = QRDisplayTroopSearchWay.this.d();
                    if (d18 == null || (str = d18.getString(R.string.f235417bl)) == null) {
                        str = "";
                    }
                    aVar.j(d17, 0, str, 0);
                    return;
                }
                com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.b();
            }
        });
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        final TroopInfo troopInfo;
        if (this.activity == null || (troopInfo = this.troopInfo) == null) {
            return;
        }
        final TroopSearchWay d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(troopInfo);
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.b.e(this.activity, d16, com.tencent.mobileqq.troop.troopsetting.activity.c.f(this.troopInfoData), new Function1<TroopSearchWay, Unit>(troopInfo, this) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopSearchWay$handleTroopSearchWayItemClk$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TroopInfo $mTroopInfo;
            final /* synthetic */ QRDisplayTroopSearchWay this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$mTroopInfo = troopInfo;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopSearchWay.this, troopInfo, this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopSearchWay troopSearchWay) {
                invoke2(troopSearchWay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopSearchWay newOption) {
                com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) newOption);
                    return;
                }
                Intrinsics.checkNotNullParameter(newOption, "newOption");
                if (TroopSearchWay.this == newOption) {
                    return;
                }
                TroopInfo troopInfo2 = this.$mTroopInfo;
                if (troopInfo2.hasSetNewTroopHead && troopInfo2.hasSetNewTroopName) {
                    bVar = this.this$0.searchWayViewModel;
                    if (bVar != null) {
                        String str = this.$mTroopInfo.troopuin;
                        Intrinsics.checkNotNullExpressionValue(str, "mTroopInfo.troopuin");
                        bVar.c(str, newOption);
                        return;
                    }
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_new_search_way", newOption.name());
                TroopModifyBaseInfoFragment.Companion companion = TroopModifyBaseInfoFragment.INSTANCE;
                Activity d17 = this.this$0.d();
                String troopUin = this.$mTroopInfo.getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin, "mTroopInfo.troopUin");
                companion.a(d17, 22, troopUin, bundle);
            }
        });
    }

    @Nullable
    public final Activity d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.activity;
    }

    @Nullable
    public final a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.searchWayUpdateCallback;
    }

    @NotNull
    public final SpannableStringBuilder f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.activity == null) {
            return new SpannableStringBuilder("");
        }
        SpannableString spannableString = new SpannableString(this.activity.getString(R.string.f235427bm));
        spannableString.setSpan(new b(), 0, spannableString.length(), 33);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.activity.getString(R.string.f235437bn));
        spannableStringBuilder.append((CharSequence) spannableString);
        spannableStringBuilder.append((CharSequence) this.activity.getString(R.string.f235447bo));
        return spannableStringBuilder;
    }

    @Nullable
    public final TroopInfoData g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopInfoData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopInfoData;
    }

    public final void i(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (requestCode == 22 && resultCode == -1 && data != null && this.activity != null) {
            if (data.hasExtra("bundle_key_new_troop_name") && (aVar = this.searchWayUpdateCallback) != null) {
                aVar.b(data.getStringExtra("bundle_key_new_troop_name"));
            }
            if (data.hasExtra("bundle_key_new_search_way")) {
                String stringExtra = data.getStringExtra("bundle_key_new_search_way");
                if (stringExtra != null && stringExtra.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    TroopInfo troopInfo = this.troopInfo;
                    if (troopInfo != null) {
                        str = troopInfo.getTroopUin();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        TroopSearchWay valueOf = TroopSearchWay.valueOf(stringExtra);
                        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar = this.searchWayViewModel;
                        if (bVar != null) {
                            String troopUin = this.troopInfo.getTroopUin();
                            Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
                            bVar.c(troopUin, valueOf);
                        }
                    }
                }
            }
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar = this.searchWayViewModel;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void k(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.searchWayUpdateCallback = aVar;
        }
    }
}
