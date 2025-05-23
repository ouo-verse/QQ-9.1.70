package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.lang.reflect.Array;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u0012*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00022\u00020\u0005:\u0002\u0012\u0013B\u001d\b\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/squareup/wire/AndroidMessage;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Landroid/os/Parcelable;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "ProtoAdapterCreator", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message<M, B> implements Parcelable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0002\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/squareup/wire/AndroidMessage$Companion;", "", "()V", "newCreator", "Landroid/os/Parcelable$Creator;", "E", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final <E> Parcelable.Creator<E> newCreator(@NotNull ProtoAdapter<E> adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            return new ProtoAdapterCreator(adapter);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00028\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a2\u0006\u0002\u0010\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/squareup/wire/AndroidMessage$ProtoAdapterCreator;", "M", "Landroid/os/Parcelable$Creator;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "(Lcom/squareup/wire/ProtoAdapter;)V", "createFromParcel", "input", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Ljava/lang/Object;", "newArray", "", "size", "", "(I)[Ljava/lang/Object;", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class ProtoAdapterCreator<M> implements Parcelable.Creator<M> {
        private final ProtoAdapter<M> adapter;

        public ProtoAdapterCreator(@NotNull ProtoAdapter<M> adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.adapter = adapter;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(@NotNull Parcel input) {
            Intrinsics.checkNotNullParameter(input, "input");
            ProtoAdapter<M> protoAdapter = this.adapter;
            byte[] createByteArray = input.createByteArray();
            Intrinsics.checkNotNullExpressionValue(createByteArray, "input.createByteArray()");
            return protoAdapter.decode(createByteArray);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public M[] newArray(int size) {
            Class cls;
            KClass<?> type = this.adapter.getType();
            if (type != null) {
                cls = JvmClassMappingKt.getJavaObjectType(type);
            } else {
                cls = null;
            }
            Object newInstance = Array.newInstance((Class<?>) cls, size);
            if (newInstance != null) {
                return (M[]) ((Object[]) newInstance);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<M>");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidMessage(@NotNull ProtoAdapter<M> adapter, @NotNull ByteString unknownFields) {
        super(adapter, unknownFields);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
    }

    @JvmStatic
    @NotNull
    public static final <E> Parcelable.Creator<E> newCreator(@NotNull ProtoAdapter<E> protoAdapter) {
        return INSTANCE.newCreator(protoAdapter);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeByteArray(encode());
    }
}
