package com.tencent.state.publicchat.plugin;

import android.util.Base64;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.zplan.common.utils.d;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import wx4.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0010\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u001c\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/publicchat/plugin/ReportPlugin;", "", "jumpCb", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "cryptograph", "evilUin", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lcom/tencent/state/publicchat/plugin/EvilReportParams;", "bytesToHexString", "bArray", "", "decryptKey", "encryptedKey", "doJumpReport", "uin", "contentId", "encryptOrDecryStr", "byteContent", "encryptUin", "generateCryptoGraph", "getCryptokey", "endCb", "getImpeachUrl", "getJumpUrl", "getParams", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ReportPlugin {
    private static final String AES_DECYPT_KEY = "d41d8cd98f00b204e9800998ecf8427e";
    private static final String CRYPTOGRAPH = "gen_cryptograph";
    private static final String ECB_CHIPER_ALGRITHUM = "AES/ECB/NoPadding";
    private static final String ENTRY = "impeach_entry";
    private static final String EVILUIN = "en_decrypt_evilUin";
    private static final String IMPEACH_CRYPTOKEY = "impeach_cryptokey";
    private static final String IMPEACH_TEST_URL = "https://jubaobest.qq.com/uniform_impeach/";
    private static final String IMPEACH_URL = "https://jubao.qq.com/uniform_impeach/";
    private static final String KEY_ALGRITHM = "AES";
    private static final String TAG = "ReportPlugin";
    private String cryptograph;
    private String evilUin;
    private final Function1<String, Unit> jumpCb;
    private EvilReportParams reportParams;
    private static final int AES_BLOCK_SIZE = 16;
    private static final String DECRYPT_PASSWORD = "QGrm8YAQHYEGJyk8JqAktBZ2vnxrMqxW";

    /* JADX WARN: Multi-variable type inference failed */
    public ReportPlugin(Function1<? super String, Unit> jumpCb) {
        Intrinsics.checkNotNullParameter(jumpCb, "jumpCb");
        this.jumpCb = jumpCb;
        this.evilUin = "";
        this.cryptograph = "";
        this.reportParams = new EvilReportParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String encryptUin(String uin) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(uin);
        if (!isBlank) {
            try {
                Charset forName = Charset.forName("utf-8");
                Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
                if (uin != null) {
                    byte[] bytes = uin.getBytes(forName);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    String bytesToHexString = bytesToHexString(encryptOrDecryStr(bytes));
                    if (bytesToHexString != null) {
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                        String lowerCase = bytesToHexString.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        return lowerCase;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } catch (Throwable th5) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "encryptUin error: " + th5.getMessage(), null, 4, null);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateCryptoGraph(String encryptedKey) {
        String c16 = d.c(this.reportParams.getSystem() + "_" + this.reportParams.getVersion() + "_" + this.reportParams.getScene() + "_" + decryptKey(encryptedKey));
        Intrinsics.checkNotNullExpressionValue(c16, "MD5.toMD5(sb.toString())");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        if (c16 != null) {
            String upperCase = c16.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            SquareBaseKt.getSquareLog().i(TAG, "reportPlugin: secretKey: " + upperCase);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.reportParams.getAppid());
            Intrinsics.checkNotNullExpressionValue(sb5, "StringBuilder().append(reportParams.appid)");
            sb5.append("_");
            sb5.append(this.reportParams.getAppname());
            sb5.append("_");
            sb5.append(this.reportParams.getAudioEvidence());
            sb5.append("_");
            sb5.append(this.reportParams.getBuddyflag());
            sb5.append("_");
            sb5.append(this.reportParams.getContentid());
            sb5.append("_");
            sb5.append(this.reportParams.getCryptoVersion());
            sb5.append("_");
            sb5.append(this.reportParams.getEviluin());
            sb5.append("_");
            sb5.append(this.reportParams.getEviluinType());
            sb5.append("_");
            sb5.append(this.reportParams.getFileEvidence());
            sb5.append("_");
            sb5.append(this.reportParams.getGroupid());
            sb5.append("_");
            sb5.append(this.reportParams.getImgEvidence());
            sb5.append("_");
            sb5.append(this.reportParams.getIsAnonymous());
            sb5.append("_");
            sb5.append(this.reportParams.getScene());
            sb5.append("_");
            sb5.append(this.reportParams.getSrvPara());
            sb5.append("_");
            sb5.append(this.reportParams.getSubapp());
            sb5.append("_");
            sb5.append(this.reportParams.getSystem());
            sb5.append("_");
            sb5.append(this.reportParams.getTextEvidence());
            sb5.append("_");
            sb5.append(this.reportParams.getUintype());
            sb5.append("_");
            sb5.append(this.reportParams.getUrlEvidence());
            sb5.append("_");
            sb5.append(this.reportParams.getVersion());
            sb5.append("_");
            sb5.append(this.reportParams.getVideoEvidence());
            sb5.append("_");
            sb5.append(upperCase);
            String c17 = d.c(sb5.toString());
            Intrinsics.checkNotNullExpressionValue(c17, "MD5.toMD5(\n            sb.toString()\n        )");
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
            if (c17 != null) {
                String lowerCase = c17.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final void getCryptokey(final Function1<? super String, Unit> endCb) {
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.publicchat.plugin.ReportPlugin$getCryptokey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                String impeachUrl;
                Exception e16;
                HttpURLConnection httpURLConnection;
                Function1 function1;
                String str;
                StringBuilder sb5 = new StringBuilder();
                impeachUrl = ReportPlugin.this.getImpeachUrl();
                sb5.append(impeachUrl);
                sb5.append("impeach_cryptokey");
                String sb6 = sb5.toString();
                ?? r26 = 0;
                try {
                    try {
                        URLConnection openConnection = new URL(sb6).openConnection();
                        if (!(openConnection instanceof HttpURLConnection)) {
                            openConnection = null;
                        }
                        httpURLConnection = (HttpURLConnection) openConnection;
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.setConnectTimeout(10000);
                                httpURLConnection.setRequestMethod("GET");
                                httpURLConnection.connect();
                                InputStream input = httpURLConnection.getInputStream();
                                try {
                                    d.Companion companion = wx4.d.INSTANCE;
                                    Intrinsics.checkNotNullExpressionValue(input, "input");
                                    Reader inputStreamReader = new InputStreamReader(input, Charsets.UTF_8);
                                    Map<String, String> a16 = companion.a(TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)));
                                    if (a16 == null || (str = a16.get("key")) == null) {
                                        str = "";
                                    }
                                    endCb.invoke(str);
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(input, null);
                                } catch (Throwable th5) {
                                    try {
                                        throw th5;
                                    } catch (Throwable th6) {
                                        CloseableKt.closeFinally(input, th5);
                                        throw th6;
                                    }
                                }
                            } catch (Exception e17) {
                                e16 = e17;
                                function1 = ReportPlugin.this.jumpCb;
                                function1.invoke("");
                                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ReportPlugin", "getCryptokey error " + e16, null, 4, null);
                                if (httpURLConnection == null) {
                                    return;
                                }
                                httpURLConnection.disconnect();
                            }
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        httpURLConnection = null;
                    } catch (Throwable th7) {
                        th = th7;
                        if (r26 != 0) {
                        }
                        throw th;
                    }
                    httpURLConnection.disconnect();
                } catch (Throwable th8) {
                    th = th8;
                    r26 = sb6;
                    if (r26 != 0) {
                        r26.disconnect();
                    }
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getImpeachUrl() {
        if (SquareBaseKt.getSquareCommon().isDebugVersion()) {
            return IMPEACH_TEST_URL;
        }
        return IMPEACH_URL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getJumpUrl() {
        String str = (getImpeachUrl() + ENTRY) + "?system=" + this.reportParams.getSystem() + "&version=" + this.reportParams.getVersion() + "&uintype=" + this.reportParams.getUintype() + "&eviluin=" + this.reportParams.getEviluin() + "&eviluin_type=" + this.reportParams.getEviluinType() + "&appname=" + this.reportParams.getAppname() + "&appid=" + this.reportParams.getAppid() + "&subapp=" + this.reportParams.getSubapp() + "&scene=" + this.reportParams.getScene() + "&is_anonymous=" + this.reportParams.getIsAnonymous() + "&buddyflag=" + this.reportParams.getBuddyflag() + "&groupid=" + this.reportParams.getGroupid() + "&contentid=" + this.reportParams.getContentid() + "&srv_para=" + this.reportParams.getSrvPara() + "&text_evidence=" + this.reportParams.getTextEvidence() + "&img_evidence=" + this.reportParams.getImgEvidence() + "&url_evidence=" + this.reportParams.getUrlEvidence() + "&video_evidence=" + this.reportParams.getVideoEvidence() + "&file_evidence=" + this.reportParams.getFileEvidence() + "&audio_evidence=" + this.reportParams.getAudioEvidence() + "&crypto_version=" + this.reportParams.getCryptoVersion() + "&cryptograph=" + this.reportParams.getCryptograph();
        Intrinsics.checkNotNullExpressionValue(str, "sb.toString()");
        return str;
    }

    private final String getParams(String contentId) {
        String str = "system=android&version=" + SquareBaseKt.getSquareCommon().getAppReportVersionName() + "&scene=51820004&uintype=1&contentid=" + contentId + "&eviluin=" + this.evilUin + "&eviluin_type=2&is_anonymous=0&buddyflag=0&groupid=&appname=KQQ&appid=2400002&subapp=QQzhuangtaiguangchang_groupconversation_51820004&srv_para=chatmsg:&text_evidence=&img_evidence=&video_evidence=&file_evidence=&audio_evidence=&crypto_version=4";
        if (!(!Intrinsics.areEqual(this.cryptograph, ""))) {
            return str;
        }
        return str + "&cryptograph=" + this.cryptograph;
    }

    public final void doJumpReport(final String uin, String contentId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        this.reportParams.setContentid(contentId);
        getCryptokey(new Function1<String, Unit>() { // from class: com.tencent.state.publicchat.plugin.ReportPlugin$doJumpReport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String _cryptoKey) {
                EvilReportParams evilReportParams;
                String encryptUin;
                EvilReportParams evilReportParams2;
                String generateCryptoGraph;
                Function1 function1;
                String jumpUrl;
                Intrinsics.checkNotNullParameter(_cryptoKey, "_cryptoKey");
                evilReportParams = ReportPlugin.this.reportParams;
                encryptUin = ReportPlugin.this.encryptUin(uin);
                evilReportParams.setEviluin(encryptUin);
                evilReportParams2 = ReportPlugin.this.reportParams;
                generateCryptoGraph = ReportPlugin.this.generateCryptoGraph(_cryptoKey);
                evilReportParams2.setCryptograph(generateCryptoGraph);
                function1 = ReportPlugin.this.jumpCb;
                jumpUrl = ReportPlugin.this.getJumpUrl();
                function1.invoke(jumpUrl);
            }
        });
    }

    private final String decryptKey(String encryptedKey) {
        try {
            byte[] decode = Base64.decode(encryptedKey, 0);
            Charset charset = Charsets.UTF_8;
            byte[] bytes = AES_DECYPT_KEY.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance(ECB_CHIPER_ALGRITHUM);
            cipher.init(2, secretKeySpec);
            byte[] byteDecode = cipher.doFinal(decode);
            Intrinsics.checkNotNullExpressionValue(byteDecode, "byteDecode");
            return new String(byteDecode, charset);
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "decryptKey error: " + th5.getMessage(), null, 4, null);
            return "";
        }
    }

    private final String bytesToHexString(byte[] bArray) {
        if (bArray == null) {
            return null;
        }
        if (bArray.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArray.length);
        for (byte b16 : bArray) {
            String hexString = Integer.toHexString(b16 & 255);
            Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(0xFF and bArray[i].toInt())");
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            String upperCase = hexString.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            stringBuffer.append(upperCase);
        }
        return stringBuffer.toString();
    }

    private final byte[] encryptOrDecryStr(byte[] byteContent) {
        if (byteContent != null) {
            if (!(byteContent.length == 0)) {
                try {
                    int length = byteContent.length;
                    int i3 = AES_BLOCK_SIZE;
                    if (length % i3 != 0) {
                        length += i3 - (length % i3);
                    }
                    byte[] bArr = new byte[length];
                    System.arraycopy(byteContent, 0, bArr, 0, byteContent.length);
                    Cipher cipher = Cipher.getInstance(ECB_CHIPER_ALGRITHUM);
                    String str = DECRYPT_PASSWORD;
                    Charset charset = Charsets.UTF_8;
                    if (str != null) {
                        byte[] bytes = str.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        cipher.init(1, new SecretKeySpec(bytes, "AES"));
                        return cipher.doFinal(bArr);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } catch (Exception e16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "encryOrDecryStr error: " + e16.getMessage(), null, 4, null);
                }
            }
        }
        return null;
    }
}
