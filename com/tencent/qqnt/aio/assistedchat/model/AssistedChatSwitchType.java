package com.tencent.qqnt.aio.assistedchat.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0014B\u0019\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000ej\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "defValue", "Z", "getDefValue", "()Z", "bindChatType", "getBindChatType", "<init>", "(Ljava/lang/String;IZZ)V", "CREATOR", "a", "AUTO_POLISH", "AUTO_TOPIC_RECOMMEND", "AI_SERVICE", "REPLY_SUGGESTION", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatSwitchType implements Parcelable {
    private static final /* synthetic */ AssistedChatSwitchType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AssistedChatSwitchType AI_SERVICE;
    public static final AssistedChatSwitchType AUTO_POLISH;
    public static final AssistedChatSwitchType AUTO_TOPIC_RECOMMEND;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final AssistedChatSwitchType REPLY_SUGGESTION;
    private final boolean bindChatType;
    private final boolean defValue;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion implements Parcelable.Creator<AssistedChatSwitchType> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AssistedChatSwitchType createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AssistedChatSwitchType) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return AssistedChatSwitchType.values()[parcel.readInt()];
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AssistedChatSwitchType[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AssistedChatSwitchType[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new AssistedChatSwitchType[size];
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ AssistedChatSwitchType[] $values() {
        return new AssistedChatSwitchType[]{AUTO_POLISH, AUTO_TOPIC_RECOMMEND, AI_SERVICE, REPLY_SUGGESTION};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50964);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        AUTO_POLISH = new AssistedChatSwitchType("AUTO_POLISH", 0, true, true);
        AUTO_TOPIC_RECOMMEND = new AssistedChatSwitchType("AUTO_TOPIC_RECOMMEND", 1, true, true);
        AI_SERVICE = new AssistedChatSwitchType("AI_SERVICE", 2, false, false);
        REPLY_SUGGESTION = new AssistedChatSwitchType("REPLY_SUGGESTION", 3, true, true);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    AssistedChatSwitchType(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.defValue = z16;
            this.bindChatType = z17;
        }
    }

    public static AssistedChatSwitchType valueOf(String str) {
        return (AssistedChatSwitchType) Enum.valueOf(AssistedChatSwitchType.class, str);
    }

    public static AssistedChatSwitchType[] values() {
        return (AssistedChatSwitchType[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean getBindChatType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.bindChatType;
    }

    public final boolean getDefValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.defValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, flags);
        } else {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(ordinal());
        }
    }
}
