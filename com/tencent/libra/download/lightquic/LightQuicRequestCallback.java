package com.tencent.libra.download.lightquic;

import android.net.http.Headers;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.lightquic.api.IRequestCallback;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB'\u0012\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R,\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback;", "Lcom/tencent/lightquic/api/IRequestCallback;", "", "header", "", "onHeaderReceived", "", "body", "onBodyReceived", "", "errCode", "errMsg", "onRequestFinished", "stasInfo", "onRequestStats", "expectedLength", "I", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "byteArray", "[B", "Lkotlin/Function3;", "", "Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback$RequestResultCode;", "onFinished", "Lkotlin/jvm/functions/Function3;", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "Companion", "a", "RequestResultCode", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LightQuicRequestCallback implements IRequestCallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "LightQuicRequestCallback";
    private byte[] byteArray;
    private int expectedLength;
    private final Function3<Boolean, RequestResultCode, byte[], Unit> onFinished;
    private int statusCode;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback$RequestResultCode;", "", "(Ljava/lang/String;I)V", "SUCCEEED", "FAILED", "NO_COMPLETED", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public enum RequestResultCode {
        SUCCEEED,
        FAILED,
        NO_COMPLETED
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback$a;", "", "", "header", "Lkotlin/Pair;", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.libra.download.lightquic.LightQuicRequestCallback$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final Pair<Integer, Integer> a(@NotNull String header) {
            List<String> split$default;
            boolean startsWith$default;
            List split$default2;
            boolean startsWith$default2;
            List split$default3;
            CharSequence trim;
            Intrinsics.checkNotNullParameter(header, "header");
            split$default = StringsKt__StringsKt.split$default((CharSequence) header, new String[]{"\n"}, false, 0, 6, (Object) null);
            int i3 = 0;
            int i16 = 0;
            for (String str : split$default) {
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
                if (str != null) {
                    String lowerCase = str.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "http", false, 2, null);
                    if (startsWith$default) {
                        split$default2 = StringsKt__StringsKt.split$default((CharSequence) lowerCase, new String[]{" "}, false, 0, 6, (Object) null);
                        i3 = Integer.parseInt((String) split$default2.get(1));
                    } else {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(lowerCase, Headers.CONTENT_LEN, false, 2, null);
                        if (startsWith$default2) {
                            split$default3 = StringsKt__StringsKt.split$default((CharSequence) lowerCase, new String[]{":"}, false, 0, 6, (Object) null);
                            String str2 = (String) split$default3.get(1);
                            if (str2 != null) {
                                trim = StringsKt__StringsKt.trim((CharSequence) str2);
                                i16 = Integer.parseInt(trim.toString());
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LightQuicRequestCallback(@NotNull Function3<? super Boolean, ? super RequestResultCode, ? super byte[], Unit> onFinished) {
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        this.onFinished = onFinished;
        this.byteArray = new byte[0];
    }

    @Override // com.tencent.lightquic.api.IRequestCallback
    public void onBodyReceived(@NotNull byte[] body) {
        byte[] plus;
        Intrinsics.checkNotNullParameter(body, "body");
        plus = ArraysKt___ArraysJvmKt.plus(this.byteArray, body);
        this.byteArray = plus;
    }

    @Override // com.tencent.lightquic.api.IRequestCallback
    public void onHeaderReceived(@NotNull String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        Pair<Integer, Integer> a16 = INSTANCE.a(header);
        int intValue = a16.component1().intValue();
        int intValue2 = a16.component2().intValue();
        this.statusCode = intValue;
        this.expectedLength = intValue2;
        System.out.println((Object) ("got header: " + header + TokenParser.SP + intValue + TokenParser.SP + intValue2));
    }

    @Override // com.tencent.lightquic.api.IRequestCallback
    public void onRequestFinished(int errCode, @Nullable String errMsg) {
        int i3;
        if (!RFWApplication.isPublicVersion()) {
            RFWLog.i(TAG, RFWLog.USR, "download finished " + errCode + TokenParser.SP + errMsg);
        }
        if (errCode == 0 && 200 <= (i3 = this.statusCode) && 299 >= i3) {
            byte[] bArr = this.byteArray;
            int length = bArr.length;
            if (length == 0) {
                RFWLog.e(TAG, RFWLog.USR, "QUIC Download failed, no data returned");
                this.onFinished.invoke(Boolean.FALSE, RequestResultCode.FAILED, new byte[0]);
            } else if (length >= this.expectedLength) {
                this.onFinished.invoke(Boolean.TRUE, RequestResultCode.SUCCEEED, bArr);
            } else {
                RFWLog.e(TAG, RFWLog.USR, "QUIC Download failed, actual length: " + length + ", expected length: " + this.expectedLength);
                this.onFinished.invoke(Boolean.FALSE, RequestResultCode.NO_COMPLETED, this.byteArray);
            }
        } else {
            RFWLog.e(TAG, RFWLog.USR, "QUIC Download failed, status code: " + this.statusCode + ", quic error code: " + errCode + ", errMsg: " + errMsg);
            this.onFinished.invoke(Boolean.FALSE, RequestResultCode.FAILED, new byte[0]);
        }
        this.byteArray = new byte[0];
    }

    @Override // com.tencent.lightquic.api.IRequestCallback
    public void onRequestStats(@NotNull String stasInfo) {
        Intrinsics.checkNotNullParameter(stasInfo, "stasInfo");
    }
}
