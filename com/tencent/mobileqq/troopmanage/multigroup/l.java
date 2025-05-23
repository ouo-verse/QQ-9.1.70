package com.tencent.mobileqq.troopmanage.multigroup;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\f\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0017R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/l;", "Lcom/tencent/mobileqq/troopmanage/multigroup/m;", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/f;", "model", "", "position", "itemCount", "", "l", "E", "I", "settingHolderPosition", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "settingHeader", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "settingItem", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "H", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "troopAvatar", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "troopNameView", "J", "troopMembersView", "view", "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class l extends m {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    private final int settingHolderPosition;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View settingHeader;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final View settingItem;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final QQProAvatarView troopAvatar;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView troopNameView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView troopMembersView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.settingHolderPosition = 2;
        View findViewById = view.findViewById(R.id.f102855z1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.t\u2026nage_quick_manage_header)");
        this.settingHeader = findViewById;
        View findViewById2 = view.findViewById(R.id.f102875z3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.t\u2026manage_quick_manage_item)");
        this.settingItem = findViewById2;
        View findViewById3 = view.findViewById(R.id.f102845z0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.t\u2026nage_quick_manage_avatar)");
        this.troopAvatar = (QQProAvatarView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f102885z4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.t\u2026manage_quick_manage_name)");
        this.troopNameView = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f102895z5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.t\u2026_manage_quick_manage_num)");
        this.troopMembersView = (TextView) findViewById5;
    }

    @Override // com.tencent.mobileqq.troopmanage.multigroup.m
    @SuppressLint({"SetTextI18n"})
    public void l(@NotNull com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f model, int position, int itemCount) {
        String str;
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, model, Integer.valueOf(position), Integer.valueOf(itemCount));
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        o.m(this.settingHeader, 1, true);
        if (position == itemCount - 1) {
            o.m(this.settingItem, 3, true);
        } else {
            o.m(this.settingItem, 2, true);
        }
        if (position == this.settingHolderPosition) {
            this.settingHeader.setVisibility(0);
        } else {
            this.settingHeader.setVisibility(8);
        }
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.c c17 = model.c();
        String str2 = "";
        if (c17 == null || (str = c17.a()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            this.troopAvatar.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
        } else {
            this.troopAvatar.x(4, str, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(100).a());
        }
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.c c18 = model.c();
        if (c18 != null && (c16 = c18.c()) != null) {
            str2 = c16;
        }
        this.troopNameView.setText(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(str2, 16));
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.c c19 = model.c();
        if (c19 != null) {
            i3 = c19.b();
        }
        this.troopMembersView.setText(i3 + "\u4eba");
    }

    @NotNull
    public final View m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.settingItem;
    }
}
