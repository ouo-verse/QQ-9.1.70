package com.tencent.mobileqq.gamecenter.qa.model;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameQuestionUserInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String avatar;
    public String encodedUin;
    public int gender;
    public boolean isSelf;
    public String name;
    public String title;
    public long uin;

    public String toString() {
        String valueOf = String.valueOf(this.uin);
        if (!TextUtils.isEmpty(valueOf)) {
            valueOf = String.valueOf(valueOf.charAt(0));
        }
        return "GameQuestionUserInfo{uin=" + valueOf + ", name='" + this.name + "', avatar='" + this.avatar + "', gender=" + this.gender + ", title='" + this.title + "', encodedUin='" + this.encodedUin + "', isSelf='" + this.isSelf + "'}";
    }
}
