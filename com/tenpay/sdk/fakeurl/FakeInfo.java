package com.tenpay.sdk.fakeurl;

import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ButtonInfo;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ErrDetail;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 12\u00020\u0001:\u0003123BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003Jg\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001J\u0006\u0010,\u001a\u00020)J\u0006\u0010-\u001a\u00020)J\u0006\u0010.\u001a\u00020/J\t\u00100\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019\u00a8\u00064"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeInfo;", "", BrowserPlugin.KEY_REQUEST_URL, "", "data", "Lorg/json/JSONObject;", "retCode", "", "retMsg", "title", "leftData", "Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton;", "rightData", "errorShowFlag", "Lcom/tenpay/sdk/fakeurl/FakeInfo$EnumErrorShowFlag;", "(Ljava/lang/String;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton;Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton;Lcom/tenpay/sdk/fakeurl/FakeInfo$EnumErrorShowFlag;)V", "getData", "()Lorg/json/JSONObject;", "getErrorShowFlag", "()Lcom/tenpay/sdk/fakeurl/FakeInfo$EnumErrorShowFlag;", "getLeftData", "()Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton;", "setLeftData", "(Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton;)V", "getRequestUrl", "()Ljava/lang/String;", "getRetCode", "()I", "getRetMsg", "getRightData", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", AppConstants.Key.COLUMN_IS_VALID, "shouldIntercept", "toOldFakeInfo", "Lcooperation/qwallet/plugin/FakeUrl$FakeInfo;", "toString", "Companion", "EnumErrorShowFlag", "FakeButton", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class FakeInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_ERROR_SHOW_FLAG = "err_show_flag";

    @NotNull
    private static final String KEY_LEFT_BUTTON = "lbutton";

    @NotNull
    private static final String KEY_LEFT_URL = "left_url";

    @NotNull
    private static final String KEY_RET_CODE = "retcode";

    @NotNull
    private static final String KEY_RET_MSG = "retmsg";

    @NotNull
    private static final String KEY_RIGHT_BUTTON = "rbutton";

    @NotNull
    private static final String KEY_RIGHT_URL = "returl";

    @NotNull
    private static final String KEY_TITLE = "title";

    @Nullable
    private final JSONObject data;

    @Nullable
    private final EnumErrorShowFlag errorShowFlag;

    @Nullable
    private FakeButton leftData;

    @Nullable
    private final String requestUrl;
    private final int retCode;

    @Nullable
    private final String retMsg;

    @Nullable
    private final FakeButton rightData;

    @Nullable
    private final String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeInfo$Companion;", "", "()V", "KEY_ERROR_SHOW_FLAG", "", "KEY_LEFT_BUTTON", "KEY_LEFT_URL", "KEY_RET_CODE", "KEY_RET_MSG", "KEY_RIGHT_BUTTON", "KEY_RIGHT_URL", "KEY_TITLE", "parseFrom", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "retCode", "", "errorDetail", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ErrDetail;", "url", "dataJSON", "Lorg/json/JSONObject;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final FakeInfo parseFrom(@Nullable String url, @Nullable JSONObject dataJSON) {
            CharSequence trim;
            CharSequence trim2;
            if (dataJSON == null) {
                return null;
            }
            int optInt = dataJSON.optInt("retcode", -1);
            String optString = dataJSON.optString("retmsg");
            String str = optString.length() == 0 ? null : optString;
            String optString2 = dataJSON.optString("title");
            String str2 = optString2.length() == 0 ? null : optString2;
            String optString3 = dataJSON.optString("lbutton");
            Intrinsics.checkNotNullExpressionValue(optString3, "dataJSON.optString(KEY_LEFT_BUTTON)");
            trim = StringsKt__StringsKt.trim((CharSequence) optString3);
            String obj = trim.toString();
            String optString4 = dataJSON.optString("left_url");
            FakeButton fakeButton = new FakeButton(obj, optString4 != null ? Uri.parse(optString4) : null);
            String optString5 = dataJSON.optString("rbutton");
            Intrinsics.checkNotNullExpressionValue(optString5, "dataJSON.optString(KEY_RIGHT_BUTTON)");
            trim2 = StringsKt__StringsKt.trim((CharSequence) optString5);
            String obj2 = trim2.toString();
            String optString6 = dataJSON.optString("returl");
            return new FakeInfo(url, dataJSON, optInt, str, str2, fakeButton, new FakeButton(obj2, optString6 != null ? Uri.parse(optString6) : null), EnumErrorShowFlag.INSTANCE.fromOrdinal(dataJSON.optInt(FakeInfo.KEY_ERROR_SHOW_FLAG)));
        }

        Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00aa  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final FakeInfo parseFrom(int retCode, @NotNull PayGatewayProto$ErrDetail errorDetail) {
            Uri uri;
            PayGatewayProto$ButtonInfo payGatewayProto$ButtonInfo;
            PBStringField pBStringField;
            String str;
            PayGatewayProto$ButtonInfo payGatewayProto$ButtonInfo2;
            PBStringField pBStringField2;
            PayGatewayProto$ButtonInfo payGatewayProto$ButtonInfo3;
            PBStringField pBStringField3;
            String str2;
            PayGatewayProto$ButtonInfo payGatewayProto$ButtonInfo4;
            PBStringField pBStringField4;
            Intrinsics.checkNotNullParameter(errorDetail, "errorDetail");
            List<PayGatewayProto$ButtonInfo> list = errorDetail.buttons.get();
            Uri uri2 = null;
            PayGatewayProto$ButtonInfo payGatewayProto$ButtonInfo5 = list.size() > 0 ? list.get(0) : null;
            PayGatewayProto$ButtonInfo payGatewayProto$ButtonInfo6 = list.size() > 1 ? list.get(1) : null;
            String str3 = null;
            JSONObject jSONObject = null;
            String str4 = errorDetail.retmsg.get();
            String str5 = errorDetail.title.get();
            String str6 = (payGatewayProto$ButtonInfo5 == null || (payGatewayProto$ButtonInfo4 = payGatewayProto$ButtonInfo5.get()) == null || (pBStringField4 = payGatewayProto$ButtonInfo4.text) == null) ? null : pBStringField4.get();
            if (payGatewayProto$ButtonInfo5 != null && (payGatewayProto$ButtonInfo3 = payGatewayProto$ButtonInfo5.get()) != null && (pBStringField3 = payGatewayProto$ButtonInfo3.url) != null && (str2 = pBStringField3.get()) != null) {
                if (str2.length() > 0) {
                    uri = Uri.parse(str2);
                    FakeButton fakeButton = new FakeButton(str6, uri);
                    String str7 = (payGatewayProto$ButtonInfo6 != null || (payGatewayProto$ButtonInfo2 = payGatewayProto$ButtonInfo6.get()) == null || (pBStringField2 = payGatewayProto$ButtonInfo2.text) == null) ? null : pBStringField2.get();
                    if (payGatewayProto$ButtonInfo6 != null && (payGatewayProto$ButtonInfo = payGatewayProto$ButtonInfo6.get()) != null && (pBStringField = payGatewayProto$ButtonInfo.url) != null && (str = pBStringField.get()) != null) {
                        if (str.length() > 0) {
                            uri2 = Uri.parse(str);
                        }
                    }
                    return new FakeInfo(str3, jSONObject, retCode, str4, str5, fakeButton, new FakeButton(str7, uri2), EnumErrorShowFlag.INSTANCE.fromOrdinal(errorDetail.get().err_style.get()), 3, null);
                }
            }
            uri = null;
            FakeButton fakeButton2 = new FakeButton(str6, uri);
            if (payGatewayProto$ButtonInfo6 != null) {
            }
            if (payGatewayProto$ButtonInfo6 != null) {
                if (str.length() > 0) {
                }
            }
            return new FakeInfo(str3, jSONObject, retCode, str4, str5, fakeButton2, new FakeButton(str7, uri2), EnumErrorShowFlag.INSTANCE.fromOrdinal(errorDetail.get().err_style.get()), 3, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeInfo$EnumErrorShowFlag;", "", "(Ljava/lang/String;I)V", "DEFAULT", "TOAST", "ALTER", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum EnumErrorShowFlag {
        DEFAULT,
        TOAST,
        ALTER;


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeInfo$EnumErrorShowFlag$Companion;", "", "()V", "fromOrdinal", "Lcom/tenpay/sdk/fakeurl/FakeInfo$EnumErrorShowFlag;", "value", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final EnumErrorShowFlag fromOrdinal(int value) {
                EnumErrorShowFlag enumErrorShowFlag;
                boolean z16;
                EnumErrorShowFlag[] values = EnumErrorShowFlag.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        enumErrorShowFlag = values[i3];
                        if (enumErrorShowFlag.ordinal() == value) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i3++;
                    } else {
                        enumErrorShowFlag = null;
                        break;
                    }
                }
                if (enumErrorShowFlag == null) {
                    return EnumErrorShowFlag.DEFAULT;
                }
                return enumErrorShowFlag;
            }

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\u0006\u0010\u0013\u001a\u00020\u000fJ\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton;", "", "text", "", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;)V", "getText", "()Ljava/lang/String;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", AppConstants.Key.COLUMN_IS_VALID, "toString", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class FakeButton {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final FakeButton DEFAULT_BUTTON = new FakeButton(MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(R.string.f2177361t), null);

        @Nullable
        private final String text;

        @Nullable
        private final Uri uri;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton$Companion;", "", "()V", "DEFAULT_BUTTON", "Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton;", "getDEFAULT_BUTTON", "()Lcom/tenpay/sdk/fakeurl/FakeInfo$FakeButton;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final FakeButton getDEFAULT_BUTTON() {
                return FakeButton.DEFAULT_BUTTON;
            }

            Companion() {
            }
        }

        public FakeButton(@Nullable String str, @Nullable Uri uri) {
            this.text = str;
            this.uri = uri;
        }

        public static /* synthetic */ FakeButton copy$default(FakeButton fakeButton, String str, Uri uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = fakeButton.text;
            }
            if ((i3 & 2) != 0) {
                uri = fakeButton.uri;
            }
            return fakeButton.copy(str, uri);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        @NotNull
        public final FakeButton copy(@Nullable String text, @Nullable Uri uri) {
            return new FakeButton(text, uri);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FakeButton)) {
                return false;
            }
            FakeButton fakeButton = (FakeButton) other;
            if (Intrinsics.areEqual(this.text, fakeButton.text) && Intrinsics.areEqual(this.uri, fakeButton.uri)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        @Nullable
        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            int hashCode;
            String str = this.text;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            Uri uri = this.uri;
            if (uri != null) {
                i3 = uri.hashCode();
            }
            return i16 + i3;
        }

        public final boolean isValid() {
            boolean z16;
            String str = this.text;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            return !z16;
        }

        @NotNull
        public String toString() {
            return "FakeButton(text=" + this.text + ", uri=" + this.uri + ")";
        }
    }

    public FakeInfo(@Nullable String str, @Nullable JSONObject jSONObject, int i3, @Nullable String str2, @Nullable String str3, @Nullable FakeButton fakeButton, @Nullable FakeButton fakeButton2, @Nullable EnumErrorShowFlag enumErrorShowFlag) {
        this.requestUrl = str;
        this.data = jSONObject;
        this.retCode = i3;
        this.retMsg = str2;
        this.title = str3;
        this.leftData = fakeButton;
        this.rightData = fakeButton2;
        this.errorShowFlag = enumErrorShowFlag;
    }

    public static /* synthetic */ FakeInfo copy$default(FakeInfo fakeInfo, String str, JSONObject jSONObject, int i3, String str2, String str3, FakeButton fakeButton, FakeButton fakeButton2, EnumErrorShowFlag enumErrorShowFlag, int i16, Object obj) {
        String str4;
        JSONObject jSONObject2;
        int i17;
        String str5;
        String str6;
        FakeButton fakeButton3;
        FakeButton fakeButton4;
        EnumErrorShowFlag enumErrorShowFlag2;
        if ((i16 & 1) != 0) {
            str4 = fakeInfo.requestUrl;
        } else {
            str4 = str;
        }
        if ((i16 & 2) != 0) {
            jSONObject2 = fakeInfo.data;
        } else {
            jSONObject2 = jSONObject;
        }
        if ((i16 & 4) != 0) {
            i17 = fakeInfo.retCode;
        } else {
            i17 = i3;
        }
        if ((i16 & 8) != 0) {
            str5 = fakeInfo.retMsg;
        } else {
            str5 = str2;
        }
        if ((i16 & 16) != 0) {
            str6 = fakeInfo.title;
        } else {
            str6 = str3;
        }
        if ((i16 & 32) != 0) {
            fakeButton3 = fakeInfo.leftData;
        } else {
            fakeButton3 = fakeButton;
        }
        if ((i16 & 64) != 0) {
            fakeButton4 = fakeInfo.rightData;
        } else {
            fakeButton4 = fakeButton2;
        }
        if ((i16 & 128) != 0) {
            enumErrorShowFlag2 = fakeInfo.errorShowFlag;
        } else {
            enumErrorShowFlag2 = enumErrorShowFlag;
        }
        return fakeInfo.copy(str4, jSONObject2, i17, str5, str6, fakeButton3, fakeButton4, enumErrorShowFlag2);
    }

    @JvmStatic
    @Nullable
    public static final FakeInfo parseFrom(@Nullable String str, @Nullable JSONObject jSONObject) {
        return INSTANCE.parseFrom(str, jSONObject);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getRequestUrl() {
        return this.requestUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final JSONObject getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRetCode() {
        return this.retCode;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getRetMsg() {
        return this.retMsg;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final FakeButton getLeftData() {
        return this.leftData;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final FakeButton getRightData() {
        return this.rightData;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final EnumErrorShowFlag getErrorShowFlag() {
        return this.errorShowFlag;
    }

    @NotNull
    public final FakeInfo copy(@Nullable String requestUrl, @Nullable JSONObject data, int retCode, @Nullable String retMsg, @Nullable String title, @Nullable FakeButton leftData, @Nullable FakeButton rightData, @Nullable EnumErrorShowFlag errorShowFlag) {
        return new FakeInfo(requestUrl, data, retCode, retMsg, title, leftData, rightData, errorShowFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FakeInfo)) {
            return false;
        }
        FakeInfo fakeInfo = (FakeInfo) other;
        if (Intrinsics.areEqual(this.requestUrl, fakeInfo.requestUrl) && Intrinsics.areEqual(this.data, fakeInfo.data) && this.retCode == fakeInfo.retCode && Intrinsics.areEqual(this.retMsg, fakeInfo.retMsg) && Intrinsics.areEqual(this.title, fakeInfo.title) && Intrinsics.areEqual(this.leftData, fakeInfo.leftData) && Intrinsics.areEqual(this.rightData, fakeInfo.rightData) && this.errorShowFlag == fakeInfo.errorShowFlag) {
            return true;
        }
        return false;
    }

    @Nullable
    public final JSONObject getData() {
        return this.data;
    }

    @Nullable
    public final EnumErrorShowFlag getErrorShowFlag() {
        return this.errorShowFlag;
    }

    @Nullable
    public final FakeButton getLeftData() {
        return this.leftData;
    }

    @Nullable
    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final int getRetCode() {
        return this.retCode;
    }

    @Nullable
    public final String getRetMsg() {
        return this.retMsg;
    }

    @Nullable
    public final FakeButton getRightData() {
        return this.rightData;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        String str = this.requestUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        JSONObject jSONObject = this.data;
        if (jSONObject == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = jSONObject.hashCode();
        }
        int i17 = (((i16 + hashCode2) * 31) + this.retCode) * 31;
        String str2 = this.retMsg;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.title;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        FakeButton fakeButton = this.leftData;
        if (fakeButton == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = fakeButton.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        FakeButton fakeButton2 = this.rightData;
        if (fakeButton2 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = fakeButton2.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        EnumErrorShowFlag enumErrorShowFlag = this.errorShowFlag;
        if (enumErrorShowFlag != null) {
            i3 = enumErrorShowFlag.hashCode();
        }
        return i27 + i3;
    }

    public final boolean isValid() {
        boolean z16;
        boolean z17;
        FakeButton fakeButton = this.leftData;
        if (fakeButton != null && fakeButton.isValid()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        FakeButton fakeButton2 = this.rightData;
        if (fakeButton2 != null && fakeButton2.isValid()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    public final void setLeftData(@Nullable FakeButton fakeButton) {
        this.leftData = fakeButton;
    }

    public final boolean shouldIntercept() {
        int collectionSizeOrDefault;
        String str;
        boolean contains;
        boolean contains2;
        Uri uri;
        Uri uri2;
        QWalletFakeUrlHandler.EnumFakeHost[] values = QWalletFakeUrlHandler.EnumFakeHost.values();
        ArrayList arrayList = new ArrayList();
        for (QWalletFakeUrlHandler.EnumFakeHost enumFakeHost : values) {
            if (enumFakeHost.getInterceptorCallback()) {
                arrayList.add(enumFakeHost);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((QWalletFakeUrlHandler.EnumFakeHost) it.next()).name());
        }
        FakeButton fakeButton = this.leftData;
        String str2 = null;
        if (fakeButton != null && (uri2 = fakeButton.getUri()) != null) {
            str = uri2.getHost();
        } else {
            str = null;
        }
        contains = CollectionsKt___CollectionsKt.contains(arrayList2, str);
        if (!contains) {
            FakeButton fakeButton2 = this.rightData;
            if (fakeButton2 != null && (uri = fakeButton2.getUri()) != null) {
                str2 = uri.getHost();
            }
            contains2 = CollectionsKt___CollectionsKt.contains(arrayList2, str2);
            if (!contains2) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final FakeUrl.FakeInfo toOldFakeInfo() {
        Uri uri;
        String str;
        String str2;
        Uri uri2;
        String str3;
        Uri uri3;
        Uri uri4;
        Uri uri5;
        Uri uri6;
        FakeUrl.FakeInfo fakeInfo = new FakeUrl.FakeInfo();
        FakeButton fakeButton = this.leftData;
        String str4 = null;
        if (fakeButton != null) {
            uri = fakeButton.getUri();
        } else {
            uri = null;
        }
        fakeInfo.leftUri = uri;
        FakeButton fakeButton2 = this.leftData;
        if (fakeButton2 != null && (uri6 = fakeButton2.getUri()) != null) {
            str = uri6.getHost();
        } else {
            str = null;
        }
        fakeInfo.leftHost = str;
        FakeButton fakeButton3 = this.leftData;
        if (fakeButton3 != null && (uri5 = fakeButton3.getUri()) != null) {
            str2 = uri5.toString();
        } else {
            str2 = null;
        }
        fakeInfo.leftUrl = str2;
        FakeButton fakeButton4 = this.rightData;
        if (fakeButton4 != null) {
            uri2 = fakeButton4.getUri();
        } else {
            uri2 = null;
        }
        fakeInfo.uri = uri2;
        FakeButton fakeButton5 = this.rightData;
        if (fakeButton5 != null && (uri4 = fakeButton5.getUri()) != null) {
            str3 = uri4.getHost();
        } else {
            str3 = null;
        }
        fakeInfo.host = str3;
        FakeButton fakeButton6 = this.rightData;
        if (fakeButton6 != null && (uri3 = fakeButton6.getUri()) != null) {
            str4 = uri3.toString();
        }
        fakeInfo.retUrl = str4;
        fakeInfo.reqUrl = this.requestUrl;
        fakeInfo.data = this.data;
        fakeInfo.retcode = this.retCode;
        fakeInfo.retmsg = this.retMsg;
        return fakeInfo;
    }

    @NotNull
    public String toString() {
        return "FakeInfo(requestUrl=" + this.requestUrl + ", data=" + this.data + ", retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", title=" + this.title + ", leftData=" + this.leftData + ", rightData=" + this.rightData + ", errorShowFlag=" + this.errorShowFlag + ")";
    }

    public /* synthetic */ FakeInfo(String str, JSONObject jSONObject, int i3, String str2, String str3, FakeButton fakeButton, FakeButton fakeButton2, EnumErrorShowFlag enumErrorShowFlag, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? null : jSONObject, i3, str2, str3, fakeButton, fakeButton2, enumErrorShowFlag);
    }
}
