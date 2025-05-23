package com.tencent.mobileqq.troop.appscenter.mvi;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.appscenter.view.TroopAppIconView;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00107\u001a\u00020\u0010\u00a2\u0006\u0004\b8\u00109J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010*\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010\u001e\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/mvi/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "appInfo", "", "canShowDeleteBtn", "isOwner", "canShowAddBtn", "isRecommendFlag", "", "l", "", "appId", "", "type", "r", "Landroid/view/View;", "E", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "p", "()Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "appIcon", "Landroid/widget/FrameLayout;", "H", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/FrameLayout;", "deleteFly", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "addFly", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "appDesc", "K", "appName", "Lcom/tencent/mobileqq/troop/appscenter/view/TroopAppIconView;", "L", "Lcom/tencent/mobileqq/troop/appscenter/view/TroopAppIconView;", "appContainer", "M", "appType", "appsItemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout container;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView appIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout deleteFly;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout addFly;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView appDesc;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView appName;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TroopAppIconView appContainer;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ImageView appType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View appsItemView) {
        super(appsItemView);
        Intrinsics.checkNotNullParameter(appsItemView, "appsItemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appsItemView);
            return;
        }
        this.rootView = appsItemView;
        View findViewById = appsItemView.findViewById(R.id.f101035u4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "appsItemView.findViewByI\u2026troop_app_item_container)");
        this.container = (LinearLayout) findViewById;
        View findViewById2 = appsItemView.findViewById(R.id.f101075u8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "appsItemView.findViewByI\u2026R.id.troop_app_item_icon)");
        this.appIcon = (ImageView) findViewById2;
        View findViewById3 = appsItemView.findViewById(R.id.f101055u6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "appsItemView.findViewByI\u2026roop_app_item_delete_fly)");
        this.deleteFly = (FrameLayout) findViewById3;
        View findViewById4 = appsItemView.findViewById(R.id.f101025u3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "appsItemView.findViewByI\u2026d.troop_app_item_add_fly)");
        this.addFly = (FrameLayout) findViewById4;
        View findViewById5 = appsItemView.findViewById(R.id.f101065u7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "appsItemView.findViewByI\u2026R.id.troop_app_item_desc)");
        this.appDesc = (TextView) findViewById5;
        View findViewById6 = appsItemView.findViewById(R.id.f101085u9);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "appsItemView.findViewByI\u2026R.id.troop_app_item_name)");
        this.appName = (TextView) findViewById6;
        View findViewById7 = appsItemView.findViewById(R.id.f101005u1);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "appsItemView.findViewByI\u2026R.id.troop_app_container)");
        this.appContainer = (TroopAppIconView) findViewById7;
        View findViewById8 = appsItemView.findViewById(R.id.f101195uj);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "appsItemView.findViewById(R.id.troop_app_type)");
        this.appType = (ImageView) findViewById8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b0, code lost:
    
        if (r(r7, r6.type) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d0, code lost:
    
        if (r(r7, r6.type) != false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(@NotNull AppDetail appInfo, boolean canShowDeleteBtn, boolean isOwner, boolean canShowAddBtn, boolean isRecommendFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, appInfo, Boolean.valueOf(canShowDeleteBtn), Boolean.valueOf(isOwner), Boolean.valueOf(canShowAddBtn), Boolean.valueOf(isRecommendFlag));
            return;
        }
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        this.appName.setText(appInfo.name);
        if (isRecommendFlag) {
            this.appDesc.setVisibility(0);
            this.appDesc.setText(appInfo.desc);
        } else {
            this.appDesc.setVisibility(8);
        }
        if (appInfo.type == 3) {
            this.appContainer.setClipCenterX(ViewUtils.dpToPx(17.0f));
            this.appContainer.setClipCenterY(ViewUtils.dpToPx(17.0f));
            this.appContainer.setClipRadius(ViewUtils.dpToPx(4.0f));
            this.appContainer.invalidate();
            this.appType.setVisibility(0);
            this.appType.setImageResource(R.drawable.n9o);
        } else {
            this.appContainer.setClear();
            this.appType.setVisibility(8);
        }
        if (canShowDeleteBtn) {
            if (!appInfo.removable) {
                if (isOwner) {
                    String str = appInfo.appId;
                    Intrinsics.checkNotNullExpressionValue(str, "appInfo.appId");
                }
            }
            this.deleteFly.setVisibility(0);
            if (canShowAddBtn) {
                if (!appInfo.removable) {
                    if (isOwner) {
                        String str2 = appInfo.appId;
                        Intrinsics.checkNotNullExpressionValue(str2, "appInfo.appId");
                    }
                }
                this.addFly.setVisibility(0);
                return;
            }
            this.addFly.setVisibility(8);
        }
        this.deleteFly.setVisibility(8);
        if (canShowAddBtn) {
        }
        this.addFly.setVisibility(8);
    }

    @NotNull
    public final FrameLayout m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.addFly;
    }

    @NotNull
    public final ImageView o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appIcon;
    }

    @NotNull
    public final LinearLayout p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.container;
    }

    @NotNull
    public final FrameLayout q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.deleteFly;
    }

    public final boolean r(@NotNull String appId, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appId, type)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (StringUtils.toLong(appId) == 10000) {
            return true;
        }
        return false;
    }
}
