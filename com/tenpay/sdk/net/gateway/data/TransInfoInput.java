package com.tenpay.sdk.net.gateway.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$TransInfo;
import com.tenpay.sdk.net.core.log.DLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JQ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J \u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%J\t\u0010'\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f\u00a8\u0006("}, d2 = {"Lcom/tenpay/sdk/net/gateway/data/TransInfoInput;", "", "cipher", "", "tag", "", "msgNo", "publicKey", "tenpayPSKey", "retryTransParam", "(Ljava/lang/String;[BLjava/lang/String;[BLjava/lang/String;Ljava/lang/String;)V", "getCipher", "()Ljava/lang/String;", "getMsgNo", "getPublicKey", "()[B", "getRetryTransParam", "setRetryTransParam", "(Ljava/lang/String;)V", "getTag", "getTenpayPSKey", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "parseFieldToKv", "", "bean", "toMutableList", "", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$TransInfo;", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    private final byte[] publicKey;

    @SerializedName("retry_trans_param")
    @Nullable
    private String retryTransParam;

    @SerializedName("tag")
    @Nullable
    private final byte[] tag;

    @SerializedName("tenpay_pskey")
    @Nullable
    private final String tenpayPSKey;

    public TransInfoInput() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ TransInfoInput copy$default(TransInfoInput transInfoInput, String str, byte[] bArr, String str2, byte[] bArr2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = transInfoInput.cipher;
        }
        if ((i3 & 2) != 0) {
            bArr = transInfoInput.tag;
        }
        byte[] bArr3 = bArr;
        if ((i3 & 4) != 0) {
            str2 = transInfoInput.msgNo;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            bArr2 = transInfoInput.publicKey;
        }
        byte[] bArr4 = bArr2;
        if ((i3 & 16) != 0) {
            str3 = transInfoInput.tenpayPSKey;
        }
        String str6 = str3;
        if ((i3 & 32) != 0) {
            str4 = transInfoInput.retryTransParam;
        }
        return transInfoInput.copy(str, bArr3, str5, bArr4, str6, str4);
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
    public final byte[] getTag() {
        return this.tag;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMsgNo() {
        return this.msgNo;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final byte[] getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTenpayPSKey() {
        return this.tenpayPSKey;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getRetryTransParam() {
        return this.retryTransParam;
    }

    @NotNull
    public final TransInfoInput copy(@Nullable String cipher, @Nullable byte[] tag, @Nullable String msgNo, @Nullable byte[] publicKey, @Nullable String tenpayPSKey, @Nullable String retryTransParam) {
        return new TransInfoInput(cipher, tag, msgNo, publicKey, tenpayPSKey, retryTransParam);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransInfoInput)) {
            return false;
        }
        TransInfoInput transInfoInput = (TransInfoInput) other;
        if (Intrinsics.areEqual(this.cipher, transInfoInput.cipher) && Intrinsics.areEqual(this.tag, transInfoInput.tag) && Intrinsics.areEqual(this.msgNo, transInfoInput.msgNo) && Intrinsics.areEqual(this.publicKey, transInfoInput.publicKey) && Intrinsics.areEqual(this.tenpayPSKey, transInfoInput.tenpayPSKey) && Intrinsics.areEqual(this.retryTransParam, transInfoInput.retryTransParam)) {
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
    public final byte[] getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    public final String getRetryTransParam() {
        return this.retryTransParam;
    }

    @Nullable
    public final byte[] getTag() {
        return this.tag;
    }

    @Nullable
    public final String getTenpayPSKey() {
        return this.tenpayPSKey;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        String str = this.cipher;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        byte[] bArr = this.tag;
        if (bArr == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = Arrays.hashCode(bArr);
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.msgNo;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        byte[] bArr2 = this.publicKey;
        if (bArr2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = Arrays.hashCode(bArr2);
        }
        int i19 = (i18 + hashCode4) * 31;
        String str3 = this.tenpayPSKey;
        if (str3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str3.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str4 = this.retryTransParam;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i26 + i3;
    }

    public final void setRetryTransParam(@Nullable String str) {
        this.retryTransParam = str;
    }

    @NotNull
    public final List<PayGatewayProto$TransInfo> toMutableList() {
        List<PayGatewayProto$TransInfo> mutableList;
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
            PayGatewayProto$TransInfo payGatewayProto$TransInfo = new PayGatewayProto$TransInfo();
            payGatewayProto$TransInfo.key.set((String) entry2.getKey());
            Object value = entry2.getValue();
            if (value instanceof String) {
                PBBytesField pBBytesField = payGatewayProto$TransInfo.value;
                Object value2 = entry2.getValue();
                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.String");
                pBBytesField.set(ByteStringMicro.copyFromUtf8((String) value2));
            } else if (value instanceof byte[]) {
                PBBytesField pBBytesField2 = payGatewayProto$TransInfo.value;
                Object value3 = entry2.getValue();
                Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.ByteArray");
                pBBytesField2.set(ByteStringMicro.copyFrom((byte[]) value3));
            }
            arrayList.add(payGatewayProto$TransInfo);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList;
    }

    @NotNull
    public String toString() {
        return "TransInfoInput(cipher=" + this.cipher + ", tag=" + Arrays.toString(this.tag) + ", msgNo=" + this.msgNo + ", publicKey=" + Arrays.toString(this.publicKey) + ", tenpayPSKey=" + this.tenpayPSKey + ", retryTransParam=" + this.retryTransParam + ")";
    }

    public TransInfoInput(@Nullable String str, @Nullable byte[] bArr, @Nullable String str2, @Nullable byte[] bArr2, @Nullable String str3, @Nullable String str4) {
        this.cipher = str;
        this.tag = bArr;
        this.msgNo = str2;
        this.publicKey = bArr2;
        this.tenpayPSKey = str3;
        this.retryTransParam = str4;
    }

    public /* synthetic */ TransInfoInput(String str, byte[] bArr, String str2, byte[] bArr2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : bArr, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : bArr2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4);
    }
}
