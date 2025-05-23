package com.tencent.mobileqq.util;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.login.GatewayVerify$ReqBody;
import tencent.im.login.GatewayVerify$ReqCommonInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00019B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J!\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u0012\u001a\u00020\u0010H\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0007J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0002H\u0007J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0002H\u0007J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0007J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0002H\u0007J\u0012\u0010$\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0007J$\u0010%\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\b\u0010&\u001a\u0004\u0018\u00010\u0002J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'2\b\u0010&\u001a\u0004\u0018\u00010\u0002J.\u00102\u001a\u0004\u0018\u0001012\b\u0010+\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010.2\b\b\u0001\u00100\u001a\u00020\u0015J\u001a\u00103\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u00106\u001a\u00020!2\u0006\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0002\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/util/LoginUtil;", "", "", "rawAgreementText", "Landroid/widget/TextView;", "textView", "Landroid/widget/CheckBox;", "checkBox", "", "l", "htmlStr", "", tl.h.F, "(Ljava/lang/String;)[Ljava/lang/String;", "g", "uinEncrypt", "Ltencent/im/login/GatewayVerify$ReqBody;", "c", "b", "reqBody", "r", "", "hintTextSize", "stringId", "Landroid/text/SpannableString;", "d", HippyControllerProps.STRING, "e", "Landroid/view/View;", "anchorView", "key", "t", ReportConstant.COSTREPORT_PREFIX, "", "i", "uin", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "jsData", "", "Lcom/tencent/mobileqq/bean/AccountInfo;", "j", "k", "text", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/util/LoginUtil$a;", "spanClickListener", "color", "", "f", "o", "countryCode", "phoneNum", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class LoginUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LoginUtil f306390a = new LoginUtil();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/util/LoginUtil$a;", "", "", "url", "", NodeProps.ON_CLICK, "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void onClick(@NotNull String url);
    }

    LoginUtil() {
    }

    @JvmStatic
    @NotNull
    public static final GatewayVerify$ReqBody b() {
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        f306390a.r(gatewayVerify$ReqBody);
        gatewayVerify$ReqBody.setHasFlag(true);
        return gatewayVerify$ReqBody;
    }

    @JvmStatic
    @NotNull
    public static final GatewayVerify$ReqBody c(@Nullable String uinEncrypt) {
        boolean z16;
        QLog.d("LoginUtil", 1, "createUinEncryptReqBody");
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        if (uinEncrypt != null && uinEncrypt.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            gatewayVerify$ReqBody.msg_req_mask_qq_login.bytes_encrypt_uin_info.set(Utils.D(uinEncrypt));
            gatewayVerify$ReqBody.msg_req_mask_qq_login.setHasFlag(true);
        }
        f306390a.r(gatewayVerify$ReqBody);
        gatewayVerify$ReqBody.setHasFlag(true);
        return gatewayVerify$ReqBody;
    }

    @JvmStatic
    @NotNull
    public static final SpannableString d(int hintTextSize, int stringId) {
        String qqStr = HardCodeUtil.qqStr(stringId);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(stringId)");
        return e(hintTextSize, qqStr);
    }

    @JvmStatic
    @NotNull
    public static final SpannableString e(int hintTextSize, @NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new AbsoluteSizeSpan(hintTextSize, false), 0, spannableString.length(), 33);
        return spannableString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0004, code lost:
    
        r9 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r9, new java.lang.String[]{com.tencent.mobileqq.tianshu.ui.RedTouch.NEWLINE_CHAR}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String g(String rawAgreementText) {
        List split$default;
        if (rawAgreementText == null || split$default == null || split$default.size() < 2) {
            return null;
        }
        return (String) split$default.get(0);
    }

    private final String[] h(String htmlStr) {
        List split$default;
        List split$default2;
        List split$default3;
        QLog.i("LoginUtil", 2, "htmlString = " + htmlStr);
        if (TextUtils.isEmpty(htmlStr)) {
            return null;
        }
        Intrinsics.checkNotNull(htmlStr);
        split$default = StringsKt__StringsKt.split$default((CharSequence) htmlStr, new String[]{"<a href=\""}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            QLog.i("LoginUtil", 2, "args1[" + i3 + "] = " + strArr[i3]);
        }
        if (strArr.length == 2) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) strArr[1], new String[]{"\">"}, false, 0, 6, (Object) null);
            Object[] array2 = split$default2.toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr2 = (String[]) array2;
            int length2 = strArr2.length;
            for (int i16 = 0; i16 < length2; i16++) {
                QLog.i("LoginUtil", 2, "args2[" + i16 + "] = " + strArr2[i16]);
            }
            if (strArr2.length == 2) {
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) strArr2[1], new String[]{"</a></font>"}, false, 0, 6, (Object) null);
                Object[] array3 = split$default3.toArray(new String[0]);
                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr3 = (String[]) array3;
                int length3 = strArr3.length;
                for (int i17 = 0; i17 < length3; i17++) {
                    QLog.i("LoginUtil", 2, "args3[" + i17 + "] = " + strArr3[i17]);
                }
                if (strArr3.length != 2) {
                    return null;
                }
                String str = strArr2[0];
                String str2 = strArr3[0];
                QLog.i("LoginUtil", 1, "text = " + str2 + ", url = " + str);
                return new String[]{str2, str};
            }
            return null;
        }
        return null;
    }

    @JvmStatic
    public static final boolean i(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool("qq_login" + key, false);
    }

    private final void l(String rawAgreementText, TextView textView, CheckBox checkBox) {
        String trimIndent;
        String str;
        trimIndent = StringsKt__IndentKt.trimIndent("\n             " + l.c() + "\n             " + HardCodeUtil.qqStr(R.string.f216535yk) + "\n             ");
        List<RichTextHelper.RichTextData> b16 = l.b(checkBox);
        String[] h16 = h(rawAgreementText);
        if (h16 != null) {
            String str2 = h16[0];
            b16.add(new RichTextHelper.RichTextData(str2, l.d(h16[1]), (View.OnClickListener) null));
            str = trimIndent + str2 + " ";
        } else {
            str = trimIndent + HardCodeUtil.qqStr(R.string.f216575yo);
        }
        PrivacyPolicyHelper.initPrivacyPolicyTextView(textView, str, b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(View view) {
        return true;
    }

    @JvmStatic
    public static final boolean p(@Nullable String uin) {
        if (TextUtils.isEmpty(uin)) {
            return false;
        }
        Intrinsics.checkNotNull(uin);
        if (uin.length() < 5) {
            QLog.e("LoginUtil", 1, "Uin invalid, uin:" + uin);
            return false;
        }
        for (int i3 = 0; i3 < uin.length(); i3++) {
            if (!Character.isDigit(uin.charAt(i3))) {
                QLog.e("LoginUtil", 1, "Uin invalid, uin:" + uin);
                return false;
            }
        }
        return true;
    }

    private final void r(GatewayVerify$ReqBody reqBody) {
        GatewayVerify$ReqCommonInfo gatewayVerify$ReqCommonInfo = new GatewayVerify$ReqCommonInfo();
        gatewayVerify$ReqCommonInfo.bool_req_support_diff_passwd_can_verify.set(true);
        gatewayVerify$ReqCommonInfo.bool_req_passwd_err_support_identity_verify.set(true);
        gatewayVerify$ReqCommonInfo.bool_not_realname_forbid_login_low_version.set(true);
        reqBody.msg_req_common_info.set(gatewayVerify$ReqCommonInfo);
    }

    @JvmStatic
    public static final void s(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool("qq_login" + key, true);
    }

    @JvmStatic
    public static final void t(@NotNull View anchorView, @NotNull String key) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(key, "key");
        if (i(key)) {
            return;
        }
        com.tencent.mobileqq.widget.tip.a.r(anchorView.getContext()).S(anchorView).o0(HardCodeUtil.qqStr(R.string.f200864t_)).k0(0).R(0).i0(16.0f, -14.5f).W(ResourcesCompat.getColor(anchorView.getContext().getResources(), R.color.qui_common_bg_bottom_dark, null)).p0(ResourcesCompat.getColor(anchorView.getContext().getResources(), R.color.qui_common_text_allwhite_primary, null)).j0(10.0f, 10.0f, 10.0f, 10.0f).q0(14.0f).s0();
        s(key);
    }

    @Nullable
    public final CharSequence f(@Nullable String text, @NotNull Context context, @Nullable final a spanClickListener, @ColorInt int color) {
        Spanned fromHtml;
        Intrinsics.checkNotNullParameter(context, "context");
        if (TextUtils.isEmpty(text)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(text, 0);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n            Html.fromH\u2026ML_MODE_LEGACY)\n        }");
        } else {
            fromHtml = Html.fromHtml(text);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n            Html.fromHtml(text)\n        }");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        URLSpan[] urls = (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(urls, "urls");
        for (URLSpan uRLSpan : urls) {
            int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
            int spanFlags = spannableStringBuilder.getSpanFlags(uRLSpan);
            final String url = uRLSpan.getURL();
            URLSpan uRLSpan2 = new URLSpan(url) { // from class: com.tencent.mobileqq.util.LoginUtil$getHtmlSpannedStr$noUnderlineUrlSpan$1
                @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(@NotNull View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    String url2 = com.tencent.mobileqq.loginregister.z.h(getURL());
                    if (QLog.isColorLevel()) {
                        QLog.d("LoginUtil", 1, "getHtmlSpannedStr unbind_wording : ", url2);
                    }
                    LoginUtil.a aVar = LoginUtil.a.this;
                    if (aVar != null) {
                        Intrinsics.checkNotNullExpressionValue(url2, "url");
                        aVar.onClick(url2);
                    } else {
                        l.e(widget.getContext(), url2);
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NotNull TextPaint ds5) {
                    Intrinsics.checkNotNullParameter(ds5, "ds");
                    ds5.setUnderlineText(false);
                }
            };
            spannableStringBuilder.removeSpan(uRLSpan);
            spannableStringBuilder.setSpan(uRLSpan2, spanStart, spanEnd, spanFlags);
        }
        ForegroundColorSpan[] colorSpans = (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), ForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(colorSpans, "colorSpans");
        for (ForegroundColorSpan foregroundColorSpan : colorSpans) {
            int spanStart2 = spannableStringBuilder.getSpanStart(foregroundColorSpan);
            int spanEnd2 = spannableStringBuilder.getSpanEnd(foregroundColorSpan);
            int spanFlags2 = spannableStringBuilder.getSpanFlags(foregroundColorSpan);
            spannableStringBuilder.removeSpan(foregroundColorSpan);
            spannableStringBuilder.setSpan(foregroundColorSpan, spanStart2, spanEnd2, spanFlags2);
            BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color);
            spannableStringBuilder.removeSpan(backgroundColorSpan);
            spannableStringBuilder.setSpan(backgroundColorSpan, spanStart2, spanEnd2, spanFlags2);
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(context.getResources().getColor(R.color.qui_common_text_link_selector));
            spannableStringBuilder.removeSpan(foregroundColorSpan2);
            spannableStringBuilder.setSpan(foregroundColorSpan2, spanStart2, spanEnd2, spanFlags2);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final List<AccountInfo> j(@Nullable String jsData) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(jsData)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONObject(jsData).getJSONArray("remainAccountsInfo");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String string = jSONObject.getString("bytesEncryptUin");
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(new AccountInfo(jSONObject.getString("nick"), jSONObject.getString("maskUin"), HexUtil.hexStr2Bytes(string), jSONObject.getString(PhotoCategorySummaryInfo.AVATAR_URL), "", null));
                }
            }
        } catch (JSONException e16) {
            QLog.d("LoginUtil", 1, "getUnbindReturnAccountData error : " + e16);
        }
        return arrayList;
    }

    @NotNull
    public final List<AccountInfo> k(@Nullable String jsData) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(jsData)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONObject(jsData).getJSONArray("unboundedAccountsInfo");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String string = jSONObject.getString("bytesEncryptUin");
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(new AccountInfo(jSONObject.getString("nick"), jSONObject.getString("maskUin"), HexUtil.hexStr2Bytes(string), jSONObject.getString(PhotoCategorySummaryInfo.AVATAR_URL), "", null));
                }
            }
        } catch (JSONException e16) {
            QLog.d("LoginUtil", 1, "getUnbindReturnAccountData error : " + e16);
        }
        return arrayList;
    }

    public final void m(@Nullable String rawAgreementText, @Nullable TextView textView, @Nullable CheckBox checkBox) {
        PrivacyPolicyHelper.expandCheckBoxTouchDelegate(checkBox);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (textView != null) {
            textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.util.au
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean n3;
                    n3 = LoginUtil.n(view);
                    return n3;
                }
            });
        }
        l(rawAgreementText, textView, checkBox);
    }

    public final void o(@Nullable String rawAgreementText, @Nullable TextView textView) {
        String g16 = g(rawAgreementText);
        if (textView != null) {
            textView.setText(g16);
        }
    }

    public final boolean q(@NotNull String countryCode, @NotNull String phoneNum) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(phoneNum, "phoneNum");
        int length = phoneNum.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = phoneNum.charAt(i3);
            if (Intrinsics.compare((int) charAt, 48) < 0 || Intrinsics.compare((int) charAt, 57) > 0) {
                return false;
            }
        }
        if (TextUtils.equals(countryCode, "86")) {
            if (phoneNum.length() != 11) {
                return false;
            }
        } else if (phoneNum.length() <= 0) {
            return false;
        }
        return true;
    }
}
