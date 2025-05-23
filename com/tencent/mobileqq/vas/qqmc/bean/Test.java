package com.tencent.mobileqq.vas.qqmc.bean;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/bean/TestBean;", "Lcom/tencent/freesia/IConfigData;", "hello", "", "(Ljava/lang/String;)V", "getHello", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.tencent.mobileqq.vas.qqmc.bean.TestBean, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class Test implements IConfigData {

    @SerializedName("hello")
    @NotNull
    private final String hello;

    public Test() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Test copy$default(Test test, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = test.hello;
        }
        return test.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getHello() {
        return this.hello;
    }

    @NotNull
    public final Test copy(@NotNull String hello) {
        Intrinsics.checkNotNullParameter(hello, "hello");
        return new Test(hello);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof Test) && Intrinsics.areEqual(this.hello, ((Test) other).hello)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getHello() {
        return this.hello;
    }

    public int hashCode() {
        return this.hello.hashCode();
    }

    @NotNull
    public String toString() {
        return "Test(hello='" + this.hello + "')";
    }

    public Test(@NotNull String hello) {
        Intrinsics.checkNotNullParameter(hello, "hello");
        this.hello = hello;
    }

    public /* synthetic */ Test(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "no" : str);
    }
}
