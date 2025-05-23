package com.tencent.state.square.chatland.data;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.R;
import com.tencent.state.publicchat.data.CommonKt;
import com.tencent.state.square.Square;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.template.data.PKResult;
import com.tencent.state.template.data.User;
import com.tencent.state.template.item.TemplateAvatarItem;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "Lcom/tencent/state/template/item/TemplateAvatarItem;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "appId", "", "(Lcom/tencent/state/template/data/User;I)V", "getAppId", "()I", "defaultResourceId", "getDefaultResourceId", "pkOptionMap", "", "Lcom/tencent/state/template/data/PKResult;", "", "getPkOptionMap", "()Ljava/util/Map;", "resource", "Lcom/tencent/state/square/data/Resource;", "getResource", "()Lcom/tencent/state/square/data/Resource;", "getItemViewLocation", "Landroid/graphics/Rect;", "ingInteraction", "", "toUserIdentifier", "Lcom/tencent/state/square/record/UserIdentifier;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandAvatarItem extends TemplateAvatarItem {
    private static final int MAX_BUBBLE_HEIGHT_DP = 80;
    private final int appId;
    private final Map<PKResult, String> pkOptionMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandAvatarItem(User user, int i3) {
        super(user, new ChatLandAvatarExtra(false, null, null, 7, null), 10);
        Intrinsics.checkNotNullParameter(user, "user");
        this.appId = i3;
        this.pkOptionMap = new LinkedHashMap();
    }

    @Override // com.tencent.state.map.MapItem
    public int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.state.template.item.TemplateAvatarItem, com.tencent.state.map.MapPlayableItem
    public int getDefaultResourceId() {
        return getIsMale() ? R.drawable.i9f : R.drawable.i9e;
    }

    @Override // com.tencent.state.template.item.TemplateAvatarItem, com.tencent.state.map.MapItem
    public Rect getItemViewLocation() {
        return new Rect(getLocation().getX(), getLocation().getY() - ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 80), getLocation().getX() + getLocation().getWidth(), getLocation().getY() + getLocation().getHeight());
    }

    public final Map<PKResult, String> getPkOptionMap() {
        return this.pkOptionMap;
    }

    @Override // com.tencent.state.template.item.TemplateAvatarItem, com.tencent.state.map.MapPlayableItem
    public Resource getResource() {
        return ChatLandAvatarItemKt.getResource(this);
    }

    public final boolean ingInteraction() {
        return getUser().getInteraction() != null;
    }

    public final UserIdentifier toUserIdentifier() {
        return new UserIdentifier(getUser().getUin(), Integer.valueOf(CommonKt.toPB(getUser().getInfo().getGender())));
    }
}
