package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.qzone.proxy.feedcomponent.model.User;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AvatarsLayoutByRowArea extends SubArea {
    private ArrayList<AvatarArea> avatarAreasList;
    private int mNumberOfAvatarsNeedToBeShown;
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int mAvatarSizeForEach = 0;

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mAvatarSizeForEach + (this.mOffsetY * (this.mNumberOfAvatarsNeedToBeShown - 1));
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mAvatarSizeForEach + (this.mOffsetX * (this.mNumberOfAvatarsNeedToBeShown - 1));
    }

    public void setAvatarSizeForEach(int i3) {
        this.mAvatarSizeForEach = i3;
        Iterator<AvatarArea> it = this.avatarAreasList.iterator();
        while (it.hasNext()) {
            it.next().setAvatarSize(i3);
        }
    }

    public void setDrawParams(int i3, int i16, int i17) {
        this.mNumberOfAvatarsNeedToBeShown = i3;
        this.mOffsetX = i16;
        this.mOffsetY = i17;
        if (i3 > 0) {
            this.avatarAreasList = new ArrayList<>(i3);
            for (int i18 = 0; i18 < this.mNumberOfAvatarsNeedToBeShown; i18++) {
                this.avatarAreasList.add(new AvatarArea());
            }
        }
    }

    public void setUsersData(ArrayList<User> arrayList, boolean z16) {
        ArrayList<AvatarArea> arrayList2;
        if (arrayList == null || arrayList.isEmpty() || (arrayList2 = this.avatarAreasList) == null || arrayList2.isEmpty() || this.avatarAreasList.size() < this.mNumberOfAvatarsNeedToBeShown || arrayList.size() < this.mNumberOfAvatarsNeedToBeShown) {
            return;
        }
        for (int i3 = 0; i3 < this.mNumberOfAvatarsNeedToBeShown; i3++) {
            AvatarArea avatarArea = this.avatarAreasList.get(i3);
            User user = arrayList.get(i3);
            if (avatarArea != null && user != null) {
                avatarArea.setUser(user, z16);
            } else {
                com.qzone.proxy.feedcomponent.b.i("AvatarsLayoutByRowArea", "avatarArea or usersList has null item , avatarAreasList:" + this.avatarAreasList + " usersList:" + arrayList);
                return;
            }
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        ArrayList<AvatarArea> arrayList;
        if (canvas == null || paint == null || (arrayList = this.avatarAreasList) == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<AvatarArea> it = this.avatarAreasList.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas, paint);
            canvas.translate(this.mOffsetX, this.mOffsetY);
        }
        int i3 = this.mNumberOfAvatarsNeedToBeShown;
        canvas.translate(this.mOffsetX * (-1.0f) * (i3 - 1), this.mOffsetY * (-1.0f) * (i3 - 1));
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
    }
}
