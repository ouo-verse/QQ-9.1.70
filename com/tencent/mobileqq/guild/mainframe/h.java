package com.tencent.mobileqq.guild.mainframe;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\tR(\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R,\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/h;", "", "", "b", "Z", "()Z", "setWillDismissTab", "(Z)V", "getWillDismissTab$annotations", "()V", "willDismissTab", "Landroidx/lifecycle/MutableLiveData;", "Lef1/a;", "c", "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "getCloseDrawerEvent$annotations", "closeDrawerEvent", "<init>", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean willDismissTab;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f227413a = new h();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<ef1.a<Boolean>> closeDrawerEvent = new MutableLiveData<>();

    h() {
    }

    @NotNull
    public static final MutableLiveData<ef1.a<Boolean>> a() {
        return closeDrawerEvent;
    }

    public static final boolean b() {
        return willDismissTab;
    }
}
