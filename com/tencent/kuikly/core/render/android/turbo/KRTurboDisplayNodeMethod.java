package com.tencent.kuikly.core.render.android.turbo;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0000J\b\u0010\t\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u001d\u0010\u0016RG\u0010*\u001a'\u0012\u0015\u0012\u0013\u0018\u00010 \u00a2\u0006\f\b!\u0012\b\b\u0017\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fj\u0004\u0018\u0001`#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNodeMethod;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "a", "describeContents", "d", "I", "getType", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "type", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "name", "f", "c", "j", "method", h.F, "l", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "i", "Lkotlin/jvm/functions/Function1;", "b", "()Lkotlin/jvm/functions/Function1;", "g", "(Lkotlin/jvm/functions/Function1;)V", "callback", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRTurboDisplayNodeMethod implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String name;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String method;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String params;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNodeMethod$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNodeMethod;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNodeMethod;", "METHOD_TYPE_MODULE", "I", "METHOD_TYPE_VIEW", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayNodeMethod$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion implements Parcelable.Creator<KRTurboDisplayNodeMethod> {
        Companion() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public KRTurboDisplayNodeMethod createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new KRTurboDisplayNodeMethod(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KRTurboDisplayNodeMethod[] newArray(int size) {
            return new KRTurboDisplayNodeMethod[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KRTurboDisplayNodeMethod() {
        this.name = "";
        this.method = "";
    }

    @NotNull
    public final KRTurboDisplayNodeMethod a() {
        KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod = new KRTurboDisplayNodeMethod();
        kRTurboDisplayNodeMethod.type = this.type;
        kRTurboDisplayNodeMethod.name = this.name;
        kRTurboDisplayNodeMethod.method = this.method;
        kRTurboDisplayNodeMethod.params = this.params;
        return kRTurboDisplayNodeMethod;
    }

    @Nullable
    public final Function1<Object, Unit> b() {
        return this.callback;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public final void g(@Nullable Function1<Object, Unit> function1) {
        this.callback = function1;
    }

    public final int getType() {
        return this.type;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.method = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void l(@Nullable String str) {
        this.params = str;
    }

    public final void m(int i3) {
        this.type = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.type);
        parcel.writeString(this.name);
        parcel.writeString(this.method);
        parcel.writeString(this.params);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KRTurboDisplayNodeMethod(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.type = parcel.readInt();
        String readString = parcel.readString();
        this.name = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.method = readString2 != null ? readString2 : "";
        this.params = parcel.readString();
    }
}
