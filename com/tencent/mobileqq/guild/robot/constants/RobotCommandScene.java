package com.tencent.mobileqq.guild.robot.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes14.dex */
public @interface RobotCommandScene {
    public static final int DIRECT_MESSAGE_AIO = 2;
    public static final int GUILD_AIO = 1;
}
