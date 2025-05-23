package com.tencent.mobileqq.wink.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/model/TagType;", "", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "code", "I", "getCode", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "b", "TypeInterest", "TypeEvent", "TypeChallenge", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum TagType implements Parcelable {
    TypeInterest(0),
    TypeEvent(1),
    TypeChallenge(2);

    private final int code;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TagType> CREATOR = new Parcelable.Creator<TagType>() { // from class: com.tencent.mobileqq.wink.model.TagType.a
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TagType createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return TagType.INSTANCE.a(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TagType[] newArray(int size) {
            return new TagType[size];
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/model/TagType$b;", "", "", "code", "Lcom/tencent/mobileqq/wink/model/TagType;", "a", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.model.TagType$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TagType a(int code) {
            TagType tagType;
            boolean z16;
            TagType[] values = TagType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    tagType = values[i3];
                    if (tagType.getCode() == code) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    tagType = null;
                    break;
                }
            }
            if (tagType == null) {
                return TagType.TypeInterest;
            }
            return tagType;
        }

        Companion() {
        }
    }

    TagType(int i3) {
        this.code = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.code);
    }
}
