package com.tencent.av.zplan;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dx.GAudioZPlanStatus;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/av/zplan/e;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/av/zplan/e$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/av/e;", "gAudioFriends", "", "c", "", "a", "Ldx/a;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.av.zplan.e$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int a(@Nullable ArrayList<com.tencent.av.e> gAudioFriends) {
            int i3 = 0;
            if (gAudioFriends != null && gAudioFriends.size() != 0) {
                Iterator<com.tencent.av.e> it = gAudioFriends.iterator();
                while (it.hasNext()) {
                    GAudioZPlanStatus gAudioZPlanStatus = it.next().f73726z;
                    if (gAudioZPlanStatus != null && gAudioZPlanStatus.getStatus() == 1) {
                        i3++;
                    }
                }
                return i3;
            }
            QLog.i("ZPlanUtils", 2, "countMemberInSmallHome gAudioFriends empty");
            return 0;
        }

        @JvmStatic
        @Nullable
        public final GAudioZPlanStatus b(@Nullable ArrayList<com.tencent.av.e> gAudioFriends) {
            String str;
            String str2;
            String str3;
            if (gAudioFriends != null && gAudioFriends.size() != 0) {
                Iterator<com.tencent.av.e> it = gAudioFriends.iterator();
                GAudioZPlanStatus gAudioZPlanStatus = null;
                while (it.hasNext()) {
                    com.tencent.av.e next = it.next();
                    GAudioZPlanStatus gAudioZPlanStatus2 = next.f73726z;
                    if (gAudioZPlanStatus2 != null && gAudioZPlanStatus2.getStatus() != 0 && !TextUtils.isEmpty(next.f73726z.getTargetUin()) && !TextUtils.isEmpty(next.f73726z.getTimeStamp())) {
                        GAudioZPlanStatus gAudioZPlanStatus3 = next.f73726z;
                        if (gAudioZPlanStatus3 != null) {
                            str2 = gAudioZPlanStatus3.toString();
                        } else {
                            str2 = null;
                        }
                        QLog.i("ZPlanUtils", 2, "getTargetJumpSmallHomeUin valid gAudioFriend is " + str2);
                        try {
                            if (Long.parseLong(next.f73726z.getTimeStamp()) < Long.MAX_VALUE && !TextUtils.isEmpty(next.f73726z.getTargetUin())) {
                                gAudioZPlanStatus = next.f73726z;
                            }
                            if (gAudioZPlanStatus != null) {
                                str3 = gAudioZPlanStatus.toString();
                            } else {
                                str3 = null;
                            }
                            QLog.i("ZPlanUtils", 2, "getTargetJumpSmallHomeUin gAudioStatus is " + str3);
                        } catch (Exception e16) {
                            QLog.i("ZPlanUtils", 2, "getTargetJumpSmallHomeUin gAudioFriends parse exception : " + e16);
                        }
                    } else {
                        GAudioZPlanStatus gAudioZPlanStatus4 = next.f73726z;
                        if (gAudioZPlanStatus4 != null) {
                            str = gAudioZPlanStatus4.toString();
                        } else {
                            str = null;
                        }
                        QLog.i("ZPlanUtils", 2, "getTargetJumpSmallHomeUin invalid gAudioFriend is " + str);
                    }
                }
                QLog.i("ZPlanUtils", 2, "getTargetJumpSmallHomeUin target uin " + gAudioZPlanStatus);
                return gAudioZPlanStatus;
            }
            QLog.i("ZPlanUtils", 2, "getTargetJumpSmallHomeUin gAudioFriends empty");
            return null;
        }

        @JvmStatic
        public final boolean c(@Nullable ArrayList<com.tencent.av.e> gAudioFriends) {
            if (gAudioFriends != null && gAudioFriends.size() != 0) {
                Iterator<com.tencent.av.e> it = gAudioFriends.iterator();
                while (it.hasNext()) {
                    GAudioZPlanStatus gAudioZPlanStatus = it.next().f73726z;
                    if (gAudioZPlanStatus != null && gAudioZPlanStatus.getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            QLog.i("ZPlanUtils", 2, "hasMemberInSmallHome gAudioFriends empty");
            return false;
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final int a(@Nullable ArrayList<com.tencent.av.e> arrayList) {
        return INSTANCE.a(arrayList);
    }

    @JvmStatic
    @Nullable
    public static final GAudioZPlanStatus b(@Nullable ArrayList<com.tencent.av.e> arrayList) {
        return INSTANCE.b(arrayList);
    }

    @JvmStatic
    public static final boolean c(@Nullable ArrayList<com.tencent.av.e> arrayList) {
        return INSTANCE.c(arrayList);
    }
}
