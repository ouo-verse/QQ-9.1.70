package com.tenpay.idverify.utils;

import com.google.gson.annotations.SerializedName;
import com.qwallet.protocol.Wallet.hb.ElementPB$TransInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tenpay.sdk.net.core.log.DLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J \u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u001e"}, d2 = {"Lcom/tenpay/idverify/utils/TransInfoInput;", "", "cipher", "", "tag", "msgNo", "publicKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCipher", "()Ljava/lang/String;", "getMsgNo", "getPublicKey", "getTag", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "parseFieldToKv", "", "bean", "toMutableList", "", "Lcom/qwallet/protocol/Wallet/hb/ElementPB$TransInfo;", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class TransInfoInput {

    @SerializedName("cipher")
    @Nullable
    private final String cipher;

    @SerializedName("msgno")
    @Nullable
    private final String msgNo;

    @SerializedName("public_key")
    @Nullable
    private final String publicKey;

    @SerializedName("tag")
    @Nullable
    private final String tag;

    public TransInfoInput() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TransInfoInput copy$default(TransInfoInput transInfoInput, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = transInfoInput.cipher;
        }
        if ((i3 & 2) != 0) {
            str2 = transInfoInput.tag;
        }
        if ((i3 & 4) != 0) {
            str3 = transInfoInput.msgNo;
        }
        if ((i3 & 8) != 0) {
            str4 = transInfoInput.publicKey;
        }
        return transInfoInput.copy(str, str2, str3, str4);
    }

    private final Map<String, Object> parseFieldToKv(Object bean) {
        Map<String, Object> emptyMap;
        Map<String, Object> emptyMap2;
        if (bean == null) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            return emptyMap2;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Field[] fields = bean.getClass().getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(fields, "fields");
            for (Field field : fields) {
                if (field.isAnnotationPresent(SerializedName.class)) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        Intrinsics.checkNotNullExpressionValue(serializedName, "it.getAnnotation(Seriali\u2026s.java) ?: return@forEach");
                        String value = serializedName.value();
                        Object obj = field.get(bean);
                        if (obj != null) {
                            linkedHashMap.put(value, obj);
                        }
                    }
                }
            }
            return linkedHashMap;
        } catch (Exception e16) {
            DLog.INSTANCE.e("TransInfoInput", "parseFieldToKv error", e16);
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCipher() {
        return this.cipher;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMsgNo() {
        return this.msgNo;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPublicKey() {
        return this.publicKey;
    }

    @NotNull
    public final TransInfoInput copy(@Nullable String cipher, @Nullable String tag, @Nullable String msgNo, @Nullable String publicKey) {
        return new TransInfoInput(cipher, tag, msgNo, publicKey);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransInfoInput)) {
            return false;
        }
        TransInfoInput transInfoInput = (TransInfoInput) other;
        if (Intrinsics.areEqual(this.cipher, transInfoInput.cipher) && Intrinsics.areEqual(this.tag, transInfoInput.tag) && Intrinsics.areEqual(this.msgNo, transInfoInput.msgNo) && Intrinsics.areEqual(this.publicKey, transInfoInput.publicKey)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCipher() {
        return this.cipher;
    }

    @Nullable
    public final String getMsgNo() {
        return this.msgNo;
    }

    @Nullable
    public final String getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.cipher;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.tag;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.msgNo;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.publicKey;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i18 + i3;
    }

    @NotNull
    public final List<ElementPB$TransInfo> toMutableList() {
        List<ElementPB$TransInfo> mutableList;
        boolean z16;
        Map<String, Object> parseFieldToKv = parseFieldToKv(this);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : parseFieldToKv.entrySet()) {
            if (entry.getValue() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            ElementPB$TransInfo elementPB$TransInfo = new ElementPB$TransInfo();
            elementPB$TransInfo.key.set((String) entry2.getKey());
            Object value = entry2.getValue();
            if (value instanceof String) {
                PBBytesField pBBytesField = elementPB$TransInfo.value;
                Object value2 = entry2.getValue();
                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.String");
                pBBytesField.set(ByteStringMicro.copyFromUtf8((String) value2));
            } else if (value instanceof byte[]) {
                PBBytesField pBBytesField2 = elementPB$TransInfo.value;
                Object value3 = entry2.getValue();
                Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.ByteArray");
                pBBytesField2.set(ByteStringMicro.copyFrom((byte[]) value3));
            }
            arrayList.add(elementPB$TransInfo);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList;
    }

    @NotNull
    public String toString() {
        return "TransInfoInput(cipher=" + this.cipher + ", tag=" + this.tag + ", msgNo=" + this.msgNo + ", publicKey=" + this.publicKey + ")";
    }

    public TransInfoInput(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.cipher = str;
        this.tag = str2;
        this.msgNo = str3;
        this.publicKey = str4;
    }

    public /* synthetic */ TransInfoInput(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4);
    }
}
