package com.tencent.mobileqq.qqguildsdk.data;

import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "", "", "permissionType", "", "a", "", "getPermission", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface dx {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/dx$a;", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "", "permissionType", "", "a", "", "getPermission", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements dx {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f266010a = new a();

        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.dx
        public boolean a(int permissionType) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.dx
        @NotNull
        public Set<Integer> getPermission() {
            return new HashSet();
        }
    }

    boolean a(int permissionType);

    @NotNull
    Set<Integer> getPermission();
}
