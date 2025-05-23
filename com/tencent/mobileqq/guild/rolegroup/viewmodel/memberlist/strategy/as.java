package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import java.util.List;
import jy1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\u0010\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0015\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010(\u001a\u0004\b\u001e\u0010)\"\u0004\b*\u0010+R\u001a\u00100\u001a\u00020-8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\b\u0018\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/as;", "", "", "count", "", "isForce", "", "a", "", "text", tl.h.F, "", "userListToAdd", "userListToRemove", "Ljy1/a$a;", "callback", "g", "Ljy1/a;", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "b", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "i", "(Ljava/lang/Object;)V", "cookie", "d", "Z", "f", "()Z", "k", "(Z)V", "isRequesting", "e", "j", "isDataEnd", "I", "()I", "l", "(I)V", "totalCount", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "ioDispatcher", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class as {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object cookie;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isDataEnd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int totalCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HandlerDispatcher ioDispatcher;

    public as(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
        this.ioDispatcher = HandlerDispatcherKt.from$default(new Handler(ThreadManagerV2.getQQCommonThreadLooper()), null, 1, null);
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Object getCookie() {
        return this.cookie;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: c, reason: from getter */
    public final HandlerDispatcher getIoDispatcher() {
        return this.ioDispatcher;
    }

    /* renamed from: d, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsDataEnd() {
        return this.isDataEnd;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsRequesting() {
        return this.isRequesting;
    }

    public void g(@NotNull List<String> userListToAdd, @NotNull List<String> userListToRemove, @NotNull a.InterfaceC10621a callback) {
        Intrinsics.checkNotNullParameter(userListToAdd, "userListToAdd");
        Intrinsics.checkNotNullParameter(userListToRemove, "userListToRemove");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public void h(@NotNull String text, boolean isForce) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public final void i(@Nullable Object obj) {
        this.cookie = obj;
    }

    public final void j(boolean z16) {
        this.isDataEnd = z16;
    }

    public final void k(boolean z16) {
        this.isRequesting = z16;
    }

    public final void l(int i3) {
        this.totalCount = i3;
    }

    public void a(int count, boolean isForce) {
    }
}
