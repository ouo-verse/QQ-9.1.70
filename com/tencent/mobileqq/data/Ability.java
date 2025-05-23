package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.PrimaryKeyJoinColumn;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
@PrimaryKeyJoinColumn(name = "uin")
/* loaded from: classes10.dex */
public class Ability extends Entity {
    public static final int ABILITY_PHOTO = 2;
    public static final int ABILITY_VIDEO = 1;
    public int flags;

    @unique
    public String uin;

    public static boolean hasAbility(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    public void addAbility(int i3) {
        this.flags = i3 | this.flags;
    }

    public void removeAbility(int i3) {
        this.flags = (~i3) & this.flags;
    }
}
