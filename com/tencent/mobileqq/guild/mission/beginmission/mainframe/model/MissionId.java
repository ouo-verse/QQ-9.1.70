package com.tencent.mobileqq.guild.mission.beginmission.mainframe.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/model/MissionId;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes14.dex */
public @interface MissionId {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f230887a;
    public static final int ERROR_MISSION_ID = -1;
    public static final int MISSION_ID_CREATE_CHANNEL = 1;
    public static final int MISSION_ID_GUILD_MANAGE = 4;
    public static final int MISSION_ID_INVITE = 3;
    public static final int MISSION_ID_LIST_ENTER = 0;
    public static final int MISSION_ID_ROBOT = 2;
    public static final int MISSION_ID_SEND_MESSAGE = 5;
    public static final int MISSION_ID_WELCOME_ANNOUNCE = 6;
    public static final int MISSION_REPORT_ID_LIST_ENTER = 4;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/model/MissionId$a;", "", "", "missionId", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mission.beginmission.mainframe.model.MissionId$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f230887a = new Companion();

        Companion() {
        }

        public final int a(int missionId) {
            switch (missionId) {
                case 0:
                    return 4;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 1;
                case 4:
                    return 6;
                case 5:
                    return 5;
                case 6:
                    return 7;
                default:
                    throw new IllegalArgumentException("Illegal missionId");
            }
        }
    }
}
