package com.tencent.state.template.item;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mobileqq.R;
import com.tencent.state.data.Gender;
import com.tencent.state.data.UserCommon;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.Square;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.DressKeys;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0013H\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/template/item/TemplateAvatarItem;", "Lcom/tencent/state/map/MapPlayableItem;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "extra", "", "itemType", "", "(Lcom/tencent/state/template/data/User;Ljava/lang/Object;I)V", "defaultResourceId", "getDefaultResourceId", "()I", "getExtra", "()Ljava/lang/Object;", "isFixed", "", "()Z", "isGenderMale", "name", "", "getName", "()Ljava/lang/String;", "resource", "Lcom/tencent/state/square/data/Resource;", "getResource", "()Lcom/tencent/state/square/data/Resource;", "getUser", "()Lcom/tencent/state/template/data/User;", "getItemViewLocation", "Landroid/graphics/Rect;", "getUnitType", "resetDefault", "", "updateDressKey", "dressKey", "updateGender", "isMale", "updateResource", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateAvatarItem extends MapPlayableItem {
    private final Object extra;
    private final boolean isFixed;
    private final User user;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RelationType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RelationType.FRIEND.ordinal()] = 1;
            iArr[RelationType.STRANGER.ordinal()] = 2;
        }
    }

    public /* synthetic */ TemplateAvatarItem(User user, Object obj, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i16 & 2) != 0 ? null : obj, (i16 & 4) != 0 ? 1 : i3);
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public int getDefaultResourceId() {
        return getIsGenderMale() ? R.drawable.i9f : R.drawable.i9e;
    }

    public final Object getExtra() {
        return this.extra;
    }

    @Override // com.tencent.state.map.MapItem
    public Rect getItemViewLocation() {
        Table table;
        Point bubbleCoordinate;
        int x16 = getLocation().getX();
        int y16 = getLocation().getY();
        int centerY = getLocation().getCenterY();
        SitDownInfo sitDown = this.user.getSitDown();
        return new Rect(x16, Math.min(y16, (centerY - ((sitDown == null || (table = sitDown.getTable()) == null || (bubbleCoordinate = table.getBubbleCoordinate()) == null) ? 0 : bubbleCoordinate.y)) - ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 50)), getLocation().getX() + getLocation().getWidth(), getLocation().getY() + getLocation().getHeight());
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: getName */
    public String getTroopName() {
        return this.user.getInfo().getNick();
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: getResource */
    public Resource getUserResource() {
        SitDownInfo sitDown = this.user.getSitDown();
        if (sitDown != null) {
            return sitDown.getResource();
        }
        return null;
    }

    @Override // com.tencent.state.map.MapItem
    public int getUnitType() {
        RelationType relationType = this.user.getRelationType();
        if (relationType != null) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[relationType.ordinal()];
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 2) {
                return 2;
            }
        }
        return -1;
    }

    public final User getUser() {
        return this.user;
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: isGenderMale */
    public boolean getIsGenderMale() {
        return this.user.getInfo().getGender() == Gender.MALE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
    
        r1 = com.tencent.state.square.data.SquareItemKt.copyResource(r1, (r21 & 1) != 0 ? r1.getActionId() : 0, (r21 & 2) != 0 ? r1.getDynamic() : null, (r21 & 4) != 0 ? r1.getStatic() : null, (r21 & 8) != 0 ? r1.getShowSize() : null, (r21 & 16) != 0 ? r1.getRecordSize() : null, (r21 & 32) != 0 ? r1.getIsDefault() : false, (r21 & 64) != 0 ? r1.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r1.getActionType() : 0, (r21 & 256) != 0 ? r1.getActionStyle() : 0, (r21 & 512) != 0 ? r1.getFilament() : null);
     */
    @Override // com.tencent.state.map.MapPlayableItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resetDefault() {
        Resource copyResource;
        SitDownInfo sitDown = this.user.getSitDown();
        if (sitDown != null) {
            Resource resource = sitDown.getResource();
            Resource resetDefault = (resource == null || copyResource == null) ? null : copyResource.resetDefault();
            sitDown.setResource(resetDefault);
        }
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateDressKey(String dressKey) {
        Resource resource;
        FilamentResource filament;
        DressKeys userDressKey;
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        SitDownInfo sitDown = this.user.getSitDown();
        if (sitDown == null || (resource = sitDown.getResource()) == null || (filament = resource.getFilament()) == null || (userDressKey = filament.getUserDressKey()) == null) {
            return;
        }
        userDressKey.setOwner(dressKey);
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateGender(boolean isMale) {
        Gender gender;
        UserCommon info = this.user.getInfo();
        if (isMale) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }
        info.setGender(gender);
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateResource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        SitDownInfo sitDown = this.user.getSitDown();
        if (sitDown != null) {
            sitDown.setResource(resource);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateAvatarItem(User user, Object obj, int i3) {
        super(i3, user.getUin(), false, CommonDataKt.getLocation(user));
        Intrinsics.checkNotNullParameter(user, "user");
        this.user = user;
        this.extra = obj;
        this.isFixed = true;
    }
}
