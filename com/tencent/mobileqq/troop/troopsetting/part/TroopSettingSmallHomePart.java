package com.tencent.mobileqq.troop.troopsetting.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingSmallHomePart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "I9", "", "troopUin", "J9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "e", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Lcom/tencent/mobileqq/widget/listitem/x;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "troopSmallConfig", "<init>", "()V", tl.h.F, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingSmallHomePart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group[] groups;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<?, ?> troopSmallConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingSmallHomePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingSmallHomePart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingSmallHomePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.groups = new Group[0];
        }
    }

    private final void I9() {
        Long l3;
        if (((IZootopiaApi) QRoute.api(IZootopiaApi.class)).shouldHideSmallHomeEntry()) {
            QLog.i("TroopSmallHomePart", 1, "shouldHideSmallHomeEntry");
            return;
        }
        ISimpleUIUtil iSimpleUIUtil = (ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class);
        String currentThemeId = ThemeUtil.getCurrentThemeId();
        Intrinsics.checkNotNullExpressionValue(currentThemeId, "getCurrentThemeId()");
        if (iSimpleUIUtil.isThemeSimpleUI(currentThemeId)) {
            QLog.i("TroopSmallHomePart", 1, "is simpleUI");
            return;
        }
        TroopInfoData T2 = B9().T2();
        com.tencent.mobileqq.widget.listitem.x<?, ?> xVar = null;
        try {
            String str = T2.troopUin;
            Intrinsics.checkNotNullExpressionValue(str, "mTroopInfoData.troopUin");
            l3 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            QLog.e("TroopSmallHomePart", 1, "parse troopUin error " + T2.troopUin);
            l3 = null;
        }
        if (l3 == null) {
            return;
        }
        String string = getContext().getString(R.string.f2068259c);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026troop_setting_small_home)");
        com.tencent.mobileqq.widget.listitem.x<?, ?> xVar2 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, false, 6, null));
        xVar2.p(false);
        this.troopSmallConfig = xVar2;
        J9(l3.longValue());
        Group[] groupArr = new Group[1];
        String string2 = getContext().getResources().getString(R.string.f2068259c);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026troop_setting_small_home)");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        com.tencent.mobileqq.widget.listitem.x<?, ?> xVar3 = this.troopSmallConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSmallConfig");
        } else {
            xVar = xVar3;
        }
        aVarArr[0] = xVar;
        groupArr[0] = new Group(string2, aVarArr);
        this.groups = groupArr;
    }

    private final void J9(long troopUin) {
        ((IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class)).getSmallHomeGroupSetting(troopUin, new TroopSettingSmallHomePart$updateSmallHomeState$1(this));
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groups;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            I9();
        }
    }
}
