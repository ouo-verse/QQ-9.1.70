package com.tencent.mobileqq.guild.robot.components.auth;

import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final RobotAuthorizeAddInfo.ClassInfo f232098a;

    /* renamed from: b, reason: collision with root package name */
    private final List<RobotAuthorizeAddInfo.Permission> f232099b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f232100c;

    public a(RobotAuthorizeAddInfo.ClassInfo classInfo, List<RobotAuthorizeAddInfo.Permission> list) {
        this.f232098a = classInfo;
        this.f232099b = list;
    }

    public RobotAuthorizeAddInfo.ClassInfo a() {
        return this.f232098a;
    }

    public List<RobotAuthorizeAddInfo.Permission> b() {
        return this.f232099b;
    }

    public boolean c() {
        return this.f232100c;
    }

    public void d(boolean z16) {
        this.f232100c = z16;
    }
}
