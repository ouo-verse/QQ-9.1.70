package com.tencent.state.square.data;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import com.tencent.state.data.Gender;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.mayknow.MayKnowUser;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2 = {"Lcom/tencent/state/square/data/SquareRecommendUserItem;", "Lcom/tencent/state/map/MapPlayableItem;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/square/mayknow/MayKnowUser;", "location", "Lcom/tencent/state/map/Location;", "userResource", "Lcom/tencent/state/square/data/Resource;", "dressKey", "", "(Lcom/tencent/state/square/mayknow/MayKnowUser;Lcom/tencent/state/map/Location;Lcom/tencent/state/square/data/Resource;Ljava/lang/String;)V", "getDressKey", "()Ljava/lang/String;", "setDressKey", "(Ljava/lang/String;)V", "isFixed", "", "()Z", "isGenderMale", "name", "getName", "resource", "getResource", "()Lcom/tencent/state/square/data/Resource;", "getUser", "()Lcom/tencent/state/square/mayknow/MayKnowUser;", "getUserResource", "setUserResource", "(Lcom/tencent/state/square/data/Resource;)V", "getItemViewLocation", "Landroid/graphics/Rect;", "resetDefault", "", "toItemViewLocation", "toString", "updateDressKey", "updateGender", "isMale", "updateResource", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareRecommendUserItem extends MapPlayableItem {
    private String dressKey;
    private final boolean isFixed;
    private final String name;
    private final MayKnowUser user;
    private Resource userResource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareRecommendUserItem(MayKnowUser user, Location location, Resource resource, String str) {
        super(8, String.valueOf(user.getUin()), false, location);
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(location, "location");
        this.user = user;
        this.userResource = resource;
        this.dressKey = str;
        this.isFixed = true;
        String nick = user.getNick();
        this.name = nick == null ? getUin() : nick;
    }

    private final Rect toItemViewLocation() {
        Application app = SquareBase.INSTANCE.getApp();
        int width = getLocation().getWidth() + ViewExtensionsKt.calPx(app, 0);
        int height = getLocation().getHeight() + ViewExtensionsKt.dip((Context) app, 100);
        int x16 = getLocation().getX() - ((width / 2) - (getLocation().getWidth() / 2));
        int y16 = getLocation().getY() - ViewExtensionsKt.dip((Context) app, 30);
        return new Rect(x16, y16, width + x16, height + y16);
    }

    public final String getDressKey() {
        return this.dressKey;
    }

    @Override // com.tencent.state.map.MapItem
    public Rect getItemViewLocation() {
        return toItemViewLocation();
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public String getName() {
        return this.name;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: getResource, reason: from getter */
    public Resource getUserResource() {
        return this.userResource;
    }

    public final MayKnowUser getUser() {
        return this.user;
    }

    public final Resource getUserResource() {
        return this.userResource;
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: isGenderMale */
    public boolean getIsMale() {
        Integer gender = this.user.getGender();
        return gender != null && gender.intValue() == Gender.MALE.ordinal();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        r0 = com.tencent.state.square.data.SquareItemKt.copyResource(r0, (r21 & 1) != 0 ? r0.getActionId() : 0, (r21 & 2) != 0 ? r0.getDynamic() : null, (r21 & 4) != 0 ? r0.getStatic() : null, (r21 & 8) != 0 ? r0.getShowSize() : null, (r21 & 16) != 0 ? r0.getRecordSize() : null, (r21 & 32) != 0 ? r0.getIsDefault() : false, (r21 & 64) != 0 ? r0.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r0.getActionType() : 0, (r21 & 256) != 0 ? r0.getActionStyle() : 0, (r21 & 512) != 0 ? r0.getFilament() : null);
     */
    @Override // com.tencent.state.map.MapPlayableItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resetDefault() {
        Resource copyResource;
        Resource resource = this.userResource;
        Resource resetDefault = (resource == null || copyResource == null) ? null : copyResource.resetDefault();
        this.userResource = resetDefault;
    }

    public final void setDressKey(String str) {
        this.dressKey = str;
    }

    public final void setUserResource(Resource resource) {
        this.userResource = resource;
    }

    public String toString() {
        return "SquareRecommendUserItem(user:" + this.user + ",location:" + getLocation() + ",userResource:" + this.userResource + ",dressKey:" + this.dressKey + ")";
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateDressKey(String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateResource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.userResource = resource;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateGender(boolean isMale) {
    }
}
