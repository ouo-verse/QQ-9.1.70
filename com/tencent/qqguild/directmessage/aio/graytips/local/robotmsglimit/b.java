package com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotmsglimit/b;", "Lol3/b;", "a", "Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotmsglimit/b$a;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class b implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotmsglimit/b$a;", "Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotmsglimit/b;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "robotId", "e", "c", "robotUin", "f", "b", "robotName", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String robotId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String robotUin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String robotName;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getRobotId() {
            return this.robotId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getRobotName() {
            return this.robotName;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getRobotUin() {
            return this.robotUin;
        }
    }
}
