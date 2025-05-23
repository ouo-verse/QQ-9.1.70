package com.tencent.mobileqq.gamecenter.qa.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameQuestionFollow implements Serializable {
    public int appid;
    public boolean follow;

    /* renamed from: msg, reason: collision with root package name */
    public String f212415msg;
    public long questionId;

    public GameQuestionFollow(int i3, long j3, boolean z16) {
        this.appid = i3;
        this.questionId = j3;
        this.follow = z16;
    }

    public String toString() {
        return "GameQuestionFollow{appid=" + this.appid + ", questionId=" + this.questionId + ", follow=" + this.follow + ", msg='" + this.f212415msg + "'}";
    }
}
