package com.tencent.mobileqq.guild.rolegroup.bindpermission.actions;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000bH&J4\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\b\u001a\u00020\u0007H&J\"\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u0014H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/z;", "", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/PermissionSwitchStatus;", "a", "type", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/w;", "callback", "", "c", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/x;", "d", "", "", "addRoles", "removeRoles", "b", "", "cookieCache", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/y;", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface z {
    @NotNull
    PermissionSwitchStatus a(@NotNull IGPSService service);

    void b(@NotNull IGPSService service, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull w callback);

    void c(@NotNull IGPSService service, @NotNull PermissionSwitchStatus type, @NotNull w callback);

    void d(@NotNull IGPSService service, @NotNull x callback);

    void e(@NotNull IGPSService service, @Nullable byte[] cookieCache, @NotNull y callback);
}
