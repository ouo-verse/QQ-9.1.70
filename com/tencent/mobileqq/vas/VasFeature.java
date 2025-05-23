package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/VasFeature;", "", "()V", "avatar", "Lcom/tencent/mobileqq/vas/VasFeatureProxy;", "getAvatar", "()Lcom/tencent/mobileqq/vas/VasFeatureProxy;", "bubble", "getBubble", "colorName", "getColorName", "font", "getFont", QCircleDaTongConstant.ElementParamValue.GIFT, "getGift", IndividuationUrlHelper.UrlId.PENDANT_HOME, "getPendant", "troopColorName", "getTroopColorName", "troopKeyword", "getTroopKeyword", "vipIcon", "getVipIcon", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasFeature {

    @NotNull
    public static final VasFeature INSTANCE = new VasFeature();

    @NotNull
    private static final VasFeatureProxy vipIcon = new VasFeatureProxy(ProfileVipReport.VIP_ICON_MODULE_ID);

    @NotNull
    private static final VasFeatureProxy font = new VasFeatureProxy("font");

    @NotNull
    private static final VasFeatureProxy bubble = new VasFeatureProxy("bubble");

    @NotNull
    private static final VasFeatureProxy pendant = new VasFeatureProxy(IndividuationUrlHelper.UrlId.PENDANT_HOME);

    @NotNull
    private static final VasFeatureProxy avatar = new VasFeatureProxy("avatar");

    @NotNull
    private static final VasFeatureProxy gift = new VasFeatureProxy(QCircleDaTongConstant.ElementParamValue.GIFT);

    @NotNull
    private static final VasFeatureProxy colorName = new VasFeatureProxy("color_name");

    @NotNull
    private static final VasFeatureProxy troopKeyword = new VasFeatureProxy("troop_keyword");

    @NotNull
    private static final VasFeatureProxy troopColorName = new VasFeatureProxy("troop_color_name");

    VasFeature() {
    }

    @NotNull
    public final VasFeatureProxy getAvatar() {
        return avatar;
    }

    @NotNull
    public final VasFeatureProxy getBubble() {
        return bubble;
    }

    @NotNull
    public final VasFeatureProxy getColorName() {
        return colorName;
    }

    @NotNull
    public final VasFeatureProxy getFont() {
        return font;
    }

    @NotNull
    public final VasFeatureProxy getGift() {
        return gift;
    }

    @NotNull
    public final VasFeatureProxy getPendant() {
        return pendant;
    }

    @NotNull
    public final VasFeatureProxy getTroopColorName() {
        return troopColorName;
    }

    @NotNull
    public final VasFeatureProxy getTroopKeyword() {
        return troopKeyword;
    }

    @NotNull
    public final VasFeatureProxy getVipIcon() {
        return vipIcon;
    }
}
