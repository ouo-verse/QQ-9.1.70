package com.tencent.mobileqq.troop.troopnotification.vm.processor;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/vm/processor/d;", "", "", "getTitle", "", "getCategory", "", "Lcom/tencent/qqnt/notification/f;", "notificationList", "", "b", "c", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        @NotNull
        public static List<com.tencent.qqnt.notification.f> a(@NotNull d dVar, @NotNull List<com.tencent.qqnt.notification.f> notificationList) {
            Intrinsics.checkNotNullParameter(notificationList, "notificationList");
            return notificationList;
        }
    }

    @NotNull
    List<com.tencent.qqnt.notification.f> a(@NotNull List<com.tencent.qqnt.notification.f> notificationList);

    boolean b(@NotNull List<com.tencent.qqnt.notification.f> notificationList);

    boolean c(@NotNull List<com.tencent.qqnt.notification.f> notificationList);

    int getCategory();

    @NotNull
    String getTitle();
}
