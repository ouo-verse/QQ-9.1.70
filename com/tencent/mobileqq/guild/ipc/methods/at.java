package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment;
import eipc.EIPCResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ=\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/at;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "context", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class at extends AbsIpcMethod {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/ipc/methods/at$a", "Lfp1/a;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "data", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements fp1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbsIpcMethod.a f226326a;

        a(AbsIpcMethod.a aVar) {
            this.f226326a = aVar;
        }

        @Override // fp1.a
        public void a(@NotNull ArrayList<Long> data) {
            long[] longArray;
            Intrinsics.checkNotNullParameter(data, "data");
            Bundle bundle = new Bundle();
            longArray = CollectionsKt___CollectionsKt.toLongArray(data);
            bundle.putLongArray("data", longArray);
            AbsIpcMethod.a aVar = this.f226326a;
            if (aVar != null) {
                aVar.a(0, bundle);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @Nullable
    public EIPCResult a(@Nullable AbsIpcMethod.a context, @Nullable String method, @NotNull Object... arguments) {
        long[] longArray;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Object obj = arguments[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        Object fromJson = new Gson().fromJson((String) obj, (Class<Object>) Long[].class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(groupCod\u2026 Array<Long>::class.java)");
        longArray = ArraysKt___ArraysKt.toLongArray((Long[]) fromJson);
        GuildBindGroupSettingFragment.INSTANCE.c(longArray, new a(context));
        return null;
    }
}
