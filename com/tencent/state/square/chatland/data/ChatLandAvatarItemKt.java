package com.tencent.state.square.chatland.data;

import android.util.Size;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.ResourceIdentify;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.InterPlaceholderInfo;
import com.tencent.state.template.data.InterReceiverInfo;
import com.tencent.state.template.data.InterResourceInfo;
import com.tencent.state.template.data.InterSenderInfo;
import com.tencent.state.template.data.PKResult;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.TableType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002\u001a\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u00a2\u0006\u0002\u0010\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"getAvatarType", "", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "getResource", "Lcom/tencent/state/square/data/Resource;", "getRichStatusId", "(Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;)Ljava/lang/Integer;", "setupPKOption", "", "roomInfo", "Lcom/tencent/state/template/data/CommonRoomInfo;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandAvatarItemKt {
    public static final int getAvatarType(ChatLandAvatarItem getAvatarType) {
        AvatarAction action;
        Resource lookFront;
        Intrinsics.checkNotNullParameter(getAvatarType, "$this$getAvatarType");
        Resource resource = getResource(getAvatarType);
        if (resource == null || !resource.getIsDefault()) {
            return (resource == null || (action = resource.getAction()) == null || (lookFront = action.getLookFront()) == null || !lookFront.getIsDefault()) ? 1 : 0;
        }
        return 2;
    }

    public static final Resource getResource(ChatLandAvatarItem getResource) {
        FilamentResource filament;
        InterResourceInfo interaction;
        InterReceiverInfo receiverInfo;
        InterPlaceholderInfo placeholder;
        Size size;
        InterResourceInfo interaction2;
        InterSenderInfo senderInfo;
        Resource interactionResource;
        FilamentResource filament2;
        Resource fixedResource;
        Table table;
        Intrinsics.checkNotNullParameter(getResource, "$this$getResource");
        SitDownInfo sitDown = getResource.getUser().getSitDown();
        if (((sitDown == null || (table = sitDown.getTable()) == null) ? null : table.getTableType()) == TableType.TABLE_TYPE_FIXED) {
            SitDownInfo sitDown2 = getResource.getUser().getSitDown();
            if (sitDown2 == null || (fixedResource = sitDown2.getFixedResource()) == null) {
                SitDownInfo sitDown3 = getResource.getUser().getSitDown();
                if (sitDown3 != null) {
                    r2 = sitDown3.getResource();
                }
            } else {
                r2 = fixedResource;
            }
            if (r2 != null && (filament2 = r2.getFilament()) != null) {
                filament2.checkOwnerDressKey(getResource.getUser().getDressKey(), getResource.getUin());
            }
            return r2;
        }
        SitDownInfo sitDown4 = getResource.getUser().getSitDown();
        r2 = sitDown4 != null ? sitDown4.getResource() : null;
        if (getResource.getUser().isSend() && (interaction2 = getResource.getUser().getInteraction()) != null && (senderInfo = interaction2.getSenderInfo()) != null && (interactionResource = senderInfo.getInteractionResource()) != null) {
            r2 = interactionResource;
        }
        if (getResource.getUser().isReceiver() && (interaction = getResource.getUser().getInteraction()) != null && (receiverInfo = interaction.getReceiverInfo()) != null && (placeholder = receiverInfo.getPlaceholder()) != null) {
            ResourceIdentify resourceIdentify = new ResourceIdentify(placeholder.getUrl(), null, null, null, 0, 30, null);
            if (r2 == null || (size = r2.getShowSize()) == null) {
                size = new Size(0, 0);
            }
            r2 = new Resource(0, null, resourceIdentify, size, null, false, null, 0, 0, null, 1011, null);
        }
        if (r2 != null && (filament = r2.getFilament()) != null) {
            filament.checkOwnerDressKey(getResource.getUser().getDressKey(), getResource.getUin());
        }
        return r2;
    }

    public static final Integer getRichStatusId(ChatLandAvatarItem getRichStatusId) {
        OnlineStatus onlineStatus;
        Intrinsics.checkNotNullParameter(getRichStatusId, "$this$getRichStatusId");
        SitDownInfo sitDown = getRichStatusId.getUser().getSitDown();
        if (sitDown == null || (onlineStatus = sitDown.getOnlineStatus()) == null) {
            return null;
        }
        return Integer.valueOf(onlineStatus.getId() == onlineStatus.getTopStatusId() ? 0 : onlineStatus.getId());
    }

    public static final void setupPKOption(ChatLandAvatarItem setupPKOption, CommonRoomInfo roomInfo) {
        String option2;
        String option1;
        Intrinsics.checkNotNullParameter(setupPKOption, "$this$setupPKOption");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        RoomThemeData theme = roomInfo.getTheme();
        if (theme != null && (option1 = theme.getOption1()) != null) {
            if (!(option1.length() > 0)) {
                option1 = null;
            }
            if (option1 != null) {
                setupPKOption.getPkOptionMap().put(PKResult.SUPPORT, option1);
            }
        }
        RoomThemeData theme2 = roomInfo.getTheme();
        if (theme2 == null || (option2 = theme2.getOption2()) == null) {
            return;
        }
        String str = option2.length() > 0 ? option2 : null;
        if (str != null) {
            setupPKOption.getPkOptionMap().put(PKResult.OPPOSE, str);
        }
    }
}
