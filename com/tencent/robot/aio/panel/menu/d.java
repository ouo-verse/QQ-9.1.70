package com.tencent.robot.aio.panel.menu;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/aio/panel/menu/d;", "Lol3/b;", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class d implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/aio/panel/menu/d$a;", "Lcom/tencent/robot/aio/panel/menu/d;", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", "robotAvatar", "Lcom/tencent/robot/aio/panel/menu/c;", "e", "Lcom/tencent/robot/aio/panel/menu/c;", "a", "()Lcom/tencent/robot/aio/panel/menu/c;", "adapter", "<init>", "(Landroid/widget/ImageView;Lcom/tencent/robot/aio/panel/menu/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView robotAvatar;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c adapter;

        public a(@NotNull ImageView robotAvatar, @NotNull c adapter) {
            Intrinsics.checkNotNullParameter(robotAvatar, "robotAvatar");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.robotAvatar = robotAvatar;
            this.adapter = adapter;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final c getAdapter() {
            return this.adapter;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ImageView getRobotAvatar() {
            return this.robotAvatar;
        }
    }
}
