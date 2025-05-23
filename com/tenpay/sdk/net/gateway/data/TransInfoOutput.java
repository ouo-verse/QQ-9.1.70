package com.tenpay.sdk.net.gateway.data;

import com.google.gson.annotations.SerializedName;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$TransInfo;
import com.tenpay.sdk.net.core.log.DLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001J\t\u0010&\u001a\u00020\nH\u00d6\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f\u00a8\u0006("}, d2 = {"Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "", "tlsCode", "", "iv", "", "tag", "cacheSeconds", "cookieSet", "", "", "(I[B[BILjava/util/List;)V", "getCacheSeconds", "()I", "setCacheSeconds", "(I)V", "getCookieSet", "()Ljava/util/List;", "setCookieSet", "(Ljava/util/List;)V", "getIv", "()[B", "setIv", "([B)V", "getTag", "setTag", "getTlsCode", "setTlsCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class TransInfoOutput {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("cache_seconds")
    private int cacheSeconds;

    @SerializedName("Set-Cookie")
    @Nullable
    private List<String> cookieSet;

    @SerializedName("iv")
    @Nullable
    private byte[] iv;

    @SerializedName("tag")
    @Nullable
    private byte[] tag;

    @SerializedName("tls_code")
    private int tlsCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u0002J(\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput$Companion;", "", "()V", "fromPb", "Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "pbTansInfoList", "", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$TransInfo;", "parseType", "fieldType", "", "tansValue", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "transferToMap", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object parseType(String fieldType, List<ByteStringMicro> tansValue) {
            Object first;
            Object first2;
            Object first3;
            if (tansValue == null) {
                return null;
            }
            switch (fieldType.hashCode()) {
                case -1808118735:
                    if (!fieldType.equals(Entry.DATA_TYPE_STRING)) {
                        return null;
                    }
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) tansValue);
                    return ((ByteStringMicro) first).toStringUtf8();
                case -1374008726:
                    if (!fieldType.equals("byte[]")) {
                        return null;
                    }
                    first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) tansValue);
                    return ((ByteStringMicro) first2).toByteArray();
                case 104431:
                    if (!fieldType.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                        return null;
                    }
                    first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) tansValue);
                    String stringUtf8 = ((ByteStringMicro) first3).toStringUtf8();
                    Intrinsics.checkNotNullExpressionValue(stringUtf8, "tansValue.first().toStringUtf8()");
                    return Integer.valueOf(Integer.parseInt(stringUtf8));
                case 2368702:
                    if (!fieldType.equals("List")) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = tansValue.iterator();
                    while (it.hasNext()) {
                        String stringUtf82 = ((ByteStringMicro) it.next()).toStringUtf8();
                        Intrinsics.checkNotNullExpressionValue(stringUtf82, "tansValueChild.toStringUtf8()");
                        arrayList.add(stringUtf82);
                    }
                    return arrayList;
                default:
                    return null;
            }
        }

        private final Map<String, List<ByteStringMicro>> transferToMap(List<PayGatewayProto$TransInfo> pbTansInfoList) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (PayGatewayProto$TransInfo payGatewayProto$TransInfo : pbTansInfoList) {
                List list = (List) linkedHashMap.get(payGatewayProto$TransInfo.key.get());
                if (list == null) {
                    list = new ArrayList();
                    String str = payGatewayProto$TransInfo.key.get();
                    Intrinsics.checkNotNullExpressionValue(str, "it.key.get()");
                    linkedHashMap.put(str, list);
                }
                ByteStringMicro byteStringMicro = payGatewayProto$TransInfo.value.get();
                Intrinsics.checkNotNullExpressionValue(byteStringMicro, "it.value.get()");
                list.add(byteStringMicro);
            }
            return linkedHashMap;
        }

        @Nullable
        public final TransInfoOutput fromPb(@NotNull List<PayGatewayProto$TransInfo> pbTansInfoList) {
            Intrinsics.checkNotNullParameter(pbTansInfoList, "pbTansInfoList");
            TransInfoOutput transInfoOutput = new TransInfoOutput(0, null, null, 0, null, 31, null);
            Map<String, List<ByteStringMicro>> transferToMap = transferToMap(pbTansInfoList);
            try {
                Field[] fields = TransInfoOutput.class.getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(fields, "fields");
                for (Field field : fields) {
                    if (field.isAnnotationPresent(SerializedName.class)) {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                        if (serializedName != null) {
                            Intrinsics.checkNotNullExpressionValue(serializedName, "field.getAnnotation(Seri\u2026s.java) ?: return@forEach");
                            List<ByteStringMicro> list = transferToMap.get(serializedName.value());
                            Companion companion = TransInfoOutput.INSTANCE;
                            String simpleName = field.getType().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName, "field.type.simpleName");
                            Object parseType = companion.parseType(simpleName, list);
                            if (parseType != null) {
                                field.set(transInfoOutput, parseType);
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                DLog.INSTANCE.w("TransInfoOutput", "fromPb error", e16);
            }
            return transInfoOutput;
        }

        Companion() {
        }
    }

    public TransInfoOutput() {
        this(0, null, null, 0, null, 31, null);
    }

    public static /* synthetic */ TransInfoOutput copy$default(TransInfoOutput transInfoOutput, int i3, byte[] bArr, byte[] bArr2, int i16, List list, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = transInfoOutput.tlsCode;
        }
        if ((i17 & 2) != 0) {
            bArr = transInfoOutput.iv;
        }
        byte[] bArr3 = bArr;
        if ((i17 & 4) != 0) {
            bArr2 = transInfoOutput.tag;
        }
        byte[] bArr4 = bArr2;
        if ((i17 & 8) != 0) {
            i16 = transInfoOutput.cacheSeconds;
        }
        int i18 = i16;
        if ((i17 & 16) != 0) {
            list = transInfoOutput.cookieSet;
        }
        return transInfoOutput.copy(i3, bArr3, bArr4, i18, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTlsCode() {
        return this.tlsCode;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final byte[] getIv() {
        return this.iv;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final byte[] getTag() {
        return this.tag;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCacheSeconds() {
        return this.cacheSeconds;
    }

    @Nullable
    public final List<String> component5() {
        return this.cookieSet;
    }

    @NotNull
    public final TransInfoOutput copy(int tlsCode, @Nullable byte[] iv5, @Nullable byte[] tag, int cacheSeconds, @Nullable List<String> cookieSet) {
        return new TransInfoOutput(tlsCode, iv5, tag, cacheSeconds, cookieSet);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransInfoOutput)) {
            return false;
        }
        TransInfoOutput transInfoOutput = (TransInfoOutput) other;
        if (this.tlsCode == transInfoOutput.tlsCode && Intrinsics.areEqual(this.iv, transInfoOutput.iv) && Intrinsics.areEqual(this.tag, transInfoOutput.tag) && this.cacheSeconds == transInfoOutput.cacheSeconds && Intrinsics.areEqual(this.cookieSet, transInfoOutput.cookieSet)) {
            return true;
        }
        return false;
    }

    public final int getCacheSeconds() {
        return this.cacheSeconds;
    }

    @Nullable
    public final List<String> getCookieSet() {
        return this.cookieSet;
    }

    @Nullable
    public final byte[] getIv() {
        return this.iv;
    }

    @Nullable
    public final byte[] getTag() {
        return this.tag;
    }

    public final int getTlsCode() {
        return this.tlsCode;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i3 = this.tlsCode * 31;
        byte[] bArr = this.iv;
        int i16 = 0;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        int i17 = (i3 + hashCode) * 31;
        byte[] bArr2 = this.tag;
        if (bArr2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = Arrays.hashCode(bArr2);
        }
        int i18 = (((i17 + hashCode2) * 31) + this.cacheSeconds) * 31;
        List<String> list = this.cookieSet;
        if (list != null) {
            i16 = list.hashCode();
        }
        return i18 + i16;
    }

    public final void setCacheSeconds(int i3) {
        this.cacheSeconds = i3;
    }

    public final void setCookieSet(@Nullable List<String> list) {
        this.cookieSet = list;
    }

    public final void setIv(@Nullable byte[] bArr) {
        this.iv = bArr;
    }

    public final void setTag(@Nullable byte[] bArr) {
        this.tag = bArr;
    }

    public final void setTlsCode(int i3) {
        this.tlsCode = i3;
    }

    @NotNull
    public String toString() {
        return "TransInfoOutput(tlsCode=" + this.tlsCode + ", iv=" + Arrays.toString(this.iv) + ", tag=" + Arrays.toString(this.tag) + ", cacheSeconds=" + this.cacheSeconds + ", cookieSet=" + this.cookieSet + ")";
    }

    public TransInfoOutput(int i3, @Nullable byte[] bArr, @Nullable byte[] bArr2, int i16, @Nullable List<String> list) {
        this.tlsCode = i3;
        this.iv = bArr;
        this.tag = bArr2;
        this.cacheSeconds = i16;
        this.cookieSet = list;
    }

    public /* synthetic */ TransInfoOutput(int i3, byte[] bArr, byte[] bArr2, int i16, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? null : bArr, (i17 & 4) != 0 ? null : bArr2, (i17 & 8) == 0 ? i16 : 0, (i17 & 16) != 0 ? null : list);
    }
}
