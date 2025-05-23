package com.tencent.qqguild.directmessage.aio.input;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/GuildC2CPermissions;", "", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "I", "getPermission", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "ADMIN", "SPEAK_THRESHOLD", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public enum GuildC2CPermissions {
    ADMIN(1),
    SPEAK_THRESHOLD(2);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int permission;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/GuildC2CPermissions$a;", "", "", "permissions", "", "a", "c", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqguild.directmessage.aio.input.GuildC2CPermissions$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int permissions) {
            GuildC2CPermissions guildC2CPermissions = GuildC2CPermissions.ADMIN;
            if ((permissions & guildC2CPermissions.getPermission()) == guildC2CPermissions.getPermission()) {
                return true;
            }
            return false;
        }

        public final boolean b(int permissions) {
            GuildC2CPermissions guildC2CPermissions = GuildC2CPermissions.SPEAK_THRESHOLD;
            if ((permissions & guildC2CPermissions.getPermission()) == guildC2CPermissions.getPermission()) {
                return true;
            }
            return false;
        }

        public final boolean c(int permissions) {
            if (!a(permissions) && b(permissions)) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    GuildC2CPermissions(int i3) {
        this.permission = i3;
    }

    public final int getPermission() {
        return this.permission;
    }
}
