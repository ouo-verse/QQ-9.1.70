package ga4;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.sqshow.zootopia.aigc.view.dialog.ShoppingCartWithCounterDialogView;
import com.tencent.sqshow.zootopia.nativeui.data.sort.PanelSortDialogData;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.DressShareDialogView;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.actionsheet.AvatarActionSheetDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.detail.GoodsDetailDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.PanelDialogViewType;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.AvatarMakeFaceDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.AvatarPickColorDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.AvatarTemplateUpdateDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ColorResetDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.DressResetDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.FaceResetDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.MakeupResetDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.PanelSortDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.PortalStoreMakeFaceDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.PortalStorePickColorDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.PortalStoreShoppingCartDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.experience.ExperienceCardDialogView;
import k94.AvatarTemplateNeedUpdateData;
import k94.ColorPanelData;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l94.AvatarActionSheetDialogCustomData;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lga4/j;", "", "", "type", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Landroid/content/Context;", "context", "Lk94/c;", "customData", "", "useNewPortalStore", "Lga4/g;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f401682a = new j();

    j() {
    }

    public final g a(@PanelDialogViewType int type, com.tencent.sqshow.zootopia.nativeui.data.j channel, Context context, DialogCustomData customData, boolean useNewPortalStore) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customData, "customData");
        if (type == 1) {
            return new DressResetDialogView(context, null, 0, channel, 6, null);
        }
        if (type == 2) {
            ShoppingCartDialogView shoppingCartDialogView = new ShoppingCartDialogView(context, null, 0, channel, 6, null);
            shoppingCartDialogView.M0(customData.getTargetStoreItem());
            return shoppingCartDialogView;
        }
        if (type == 3) {
            GoodsDetailDialogView goodsDetailDialogView = new GoodsDetailDialogView(context, null, 0, channel, 6, null);
            az targetStoreItem = customData.getTargetStoreItem();
            if (targetStoreItem == null) {
                return goodsDetailDialogView;
            }
            goodsDetailDialogView.o0(targetStoreItem);
            return goodsDetailDialogView;
        }
        if (type != 4) {
            switch (type) {
                case 6:
                    AvatarActionSheetDialogCustomData actionSheetDialogData = customData.getActionSheetDialogData();
                    if (actionSheetDialogData != null) {
                        return new AvatarActionSheetDialogView(context, null, 0, channel, actionSheetDialogData, 6, null);
                    }
                    throw new IllegalStateException("ACTION_SHEET_DIALOG must fill customData");
                case 7:
                    ColorPanelData colorPanelData = customData.getColorPanelData();
                    if (colorPanelData == null) {
                        throw new IllegalStateException("AvatarPickColorDialogView must fill colorPanelData");
                    }
                    if (useNewPortalStore) {
                        return new PortalStorePickColorDialogView(context, null, 0, channel, colorPanelData, 6, null);
                    }
                    return new AvatarPickColorDialogView(context, null, 0, channel, colorPanelData, 6, null);
                case 8:
                    ExperienceCardDialogView experienceCardDialogView = new ExperienceCardDialogView(context, null, 0, channel, 6, null);
                    experienceCardDialogView.Y(customData.getDefaultSelectItemId());
                    return experienceCardDialogView;
                case 9:
                    return new MakeupResetDialogView(context, null, 0, channel, 6, null);
                default:
                    switch (type) {
                        case 16:
                            if (useNewPortalStore) {
                                return new PortalStoreMakeFaceDialogView(context, null, 0, channel, 6, null);
                            }
                            return new AvatarMakeFaceDialogView(context, null, 0, channel, 6, null);
                        case 17:
                            AttributeSet attributeSet = null;
                            int i3 = 0;
                            ColorPanelData colorPanelData2 = customData.getColorPanelData();
                            return new ColorResetDialogView(context, attributeSet, i3, channel, colorPanelData2 != null ? colorPanelData2.getSlotId() : 0, 6, null);
                        case 18:
                            AvatarTemplateNeedUpdateData avatarTemplateNeedUpdateData = customData.getAvatarTemplateNeedUpdateData();
                            if (avatarTemplateNeedUpdateData != null) {
                                return new AvatarTemplateUpdateDialogView(context, null, 0, channel, avatarTemplateNeedUpdateData, 6, null);
                            }
                            throw new IllegalStateException("AVATAR_TEMPLATE_UPDATE must fill customData");
                        case 19:
                            return new FaceResetDialogView(context, null, 0, channel, 6, null);
                        case 20:
                            return new DressShareDialogView(context, null, 0, channel, 6, null);
                        case 21:
                            ShoppingCartWithCounterDialogView shoppingCartWithCounterDialogView = new ShoppingCartWithCounterDialogView(context, null, 0, channel, 6, null);
                            shoppingCartWithCounterDialogView.Z0(customData.getTargetStoreItem());
                            return shoppingCartWithCounterDialogView;
                        case 22:
                            PortalStoreShoppingCartDialogView portalStoreShoppingCartDialogView = new PortalStoreShoppingCartDialogView(context, null, 0, channel, 6, null);
                            portalStoreShoppingCartDialogView.M0(customData.getTargetStoreItem());
                            return portalStoreShoppingCartDialogView;
                        default:
                            throw new IllegalStateException("DialogView type must in PanelDialogViewType");
                    }
            }
        }
        PanelSortDialogData panelSortDialogData = customData.getPanelSortDialogData();
        if (panelSortDialogData != null) {
            return new PanelSortDialogView(context, null, 0, channel, panelSortDialogData, 6, null);
        }
        throw new IllegalStateException("SORT_DIALOG must fill sortDialogData");
    }
}
