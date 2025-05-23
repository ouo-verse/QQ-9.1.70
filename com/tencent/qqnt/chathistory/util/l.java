package com.tencent.qqnt.chathistory.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J_\u0010\u0012\u001a\u00020\u00112\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0017J!\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0017J\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/chathistory/util/l;", "", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "elementList", "", "peerUid", "senderUid", "senderNick", "", "chatType", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/AnonymousExtInfo;", "anonymousExtInfo", "", "a", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/AnonymousExtInfo;)Ljava/lang/CharSequence;", "bytesData", "subMsgType", "d", "(Ljava/lang/String;I)Ljava/lang/String;", "c", "e", "urlString", "f", "Landroid/view/View;", "v", "", "g", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f354063a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51774);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f354063a = new l();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ CharSequence b(l lVar, List list, String str, String str2, String str3, int i3, Context context, AppRuntime appRuntime, AnonymousExtInfo anonymousExtInfo, int i16, Object obj) {
        int i17;
        AppRuntime appRuntime2;
        if ((i16 & 16) != 0) {
            i17 = 2;
        } else {
            i17 = i3;
        }
        if ((i16 & 64) != 0) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
            appRuntime2 = waitAppRuntime;
        } else {
            appRuntime2 = appRuntime;
        }
        return lVar.a(list, str, str2, str3, i17, context, appRuntime2, anonymousExtInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x007e, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r30);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CharSequence a(@Nullable List<MsgAbstractElement> elementList, @NotNull String peerUid, @NotNull String senderUid, @NotNull String senderNick, int chatType, @NotNull Context context, @NotNull AppRuntime appRuntime, @Nullable AnonymousExtInfo anonymousExtInfo) {
        List<MsgAbstractElement> filterNotNull;
        SpannableStringBuilder spannableStringBuilder;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 8;
        int i26 = 6;
        int i27 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, this, elementList, peerUid, senderUid, senderNick, Integer.valueOf(chatType), context, appRuntime, anonymousExtInfo);
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(senderUid, "senderUid");
        Intrinsics.checkNotNullParameter(senderNick, "senderNick");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        String tryParse = ((IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class)).tryParse(elementList);
        if (tryParse != null) {
            spannableStringBuilder2.append((CharSequence) tryParse);
            return spannableStringBuilder2;
        }
        if (elementList != null && filterNotNull != null) {
            for (MsgAbstractElement msgAbstractElement : filterNotNull) {
                int i28 = msgAbstractElement.elementType;
                String str = "";
                if (i28 == i26 && msgAbstractElement.index != null) {
                    Integer num = msgAbstractElement.elementSubType;
                    if (num != null && num.intValue() == i27) {
                        String str2 = msgAbstractElement.content;
                        if (str2 != null) {
                            Intrinsics.checkNotNullExpressionValue(str2, "it.content ?: \"\"");
                            str = str2;
                        }
                        spannableStringBuilder2.append((CharSequence) str);
                    } else {
                        QRouteApi api = QRoute.api(IEmojiSpanService.class);
                        Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
                        IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api;
                        Integer num2 = msgAbstractElement.elementSubType;
                        Intrinsics.checkNotNullExpressionValue(num2, "it.elementSubType");
                        int intValue = num2.intValue();
                        Integer num3 = msgAbstractElement.index;
                        Intrinsics.checkNotNullExpressionValue(num3, "it.index");
                        spannableStringBuilder2.append(IEmojiSpanService.a.a(iEmojiSpanService, intValue, num3.intValue(), 0, false, 0, 28, null));
                    }
                    spannableStringBuilder = spannableStringBuilder2;
                    i3 = i27;
                    i16 = i26;
                    i17 = i19;
                } else if (i28 == i19) {
                    if (anonymousExtInfo != null) {
                        i18 = anonymousExtInfo.anonymousFlag;
                    } else {
                        i18 = 0;
                    }
                    SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder2;
                    i3 = i27;
                    i16 = i26;
                    i17 = i19;
                    CharSequence d16 = com.tencent.qqnt.graytips.util.f.d(context, appRuntime, msgAbstractElement, msgAbstractElement.grayTiPElement, peerUid, senderUid, senderNick, chatType, 8, i18);
                    if (d16 != null && d16.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        d16 = msgAbstractElement.content;
                    }
                    spannableStringBuilder = spannableStringBuilder3;
                    if (!TextUtils.isEmpty(d16)) {
                        spannableStringBuilder.append(d16);
                    }
                } else {
                    spannableStringBuilder = spannableStringBuilder2;
                    i3 = i27;
                    i16 = i26;
                    i17 = i19;
                    if (i28 == 21) {
                        com.tencent.qqnt.aio.videochat.a aVar = com.tencent.qqnt.aio.videochat.a.f352344a;
                        Integer num4 = msgAbstractElement.elementSubType;
                        Intrinsics.checkNotNullExpressionValue(num4, "it.elementSubType");
                        int intValue2 = num4.intValue();
                        String str3 = msgAbstractElement.content;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.content");
                        CharSequence a16 = aVar.a(context, appRuntime, intValue2, str3);
                        if (!TextUtils.isEmpty(a16)) {
                            spannableStringBuilder.append(a16);
                        }
                    } else {
                        String str4 = msgAbstractElement.content;
                        if (str4 != null) {
                            Intrinsics.checkNotNullExpressionValue(str4, "it.content ?: \"\"");
                            str = str4;
                        }
                        spannableStringBuilder.append((CharSequence) str);
                    }
                }
                spannableStringBuilder2 = spannableStringBuilder;
                i19 = i17;
                i27 = i3;
                i26 = i16;
            }
        }
        return spannableStringBuilder2;
    }

    @Nullable
    public final String c(@NotNull String bytesData, int subMsgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bytesData, subMsgType);
        }
        Intrinsics.checkNotNullParameter(bytesData, "bytesData");
        if (subMsgType == 2) {
            try {
                Object obj = new JSONObject(bytesData).get(PublicAccountMessageUtilImpl.META_NAME);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject optJSONObject = ((JSONObject) obj).optJSONObject("news");
                if (optJSONObject != null) {
                    Object obj2 = optJSONObject.get("preview");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    return (String) obj2;
                }
                return null;
            } catch (JSONException e16) {
                d.f354054a.a("HistoryExt", "parse TencentDoc Icon error: " + e16);
                return null;
            }
        }
        return null;
    }

    @NotNull
    public final String d(@NotNull String bytesData, int subMsgType) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bytesData, subMsgType);
        }
        Intrinsics.checkNotNullParameter(bytesData, "bytesData");
        String docName = HardCodeUtil.qqStr(R.string.f158931qy);
        try {
        } catch (JSONException e16) {
            d.f354054a.a("HistoryExt", "parse TencentDoc Title error: " + e16);
        }
        if (subMsgType != 1) {
            if (subMsgType == 2) {
                Object obj2 = new JSONObject(bytesData).get(PublicAccountMessageUtilImpl.META_NAME);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject optJSONObject = ((JSONObject) obj2).optJSONObject("news");
                if (optJSONObject != null) {
                    Object obj3 = optJSONObject.get("title");
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                    docName = (String) obj3;
                }
                Intrinsics.checkNotNullExpressionValue(docName, "docName");
                return docName;
            }
            Intrinsics.checkNotNullExpressionValue(docName, "docName");
            return docName;
        }
        Object obj4 = new JSONObject(bytesData).get(PublicAccountMessageUtilImpl.META_NAME);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject jSONObject = (JSONObject) obj4;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("detail");
        if (optJSONObject2 != null) {
            obj = optJSONObject2.get("desc");
        } else {
            obj = null;
        }
        if (obj == null) {
            optJSONObject2 = jSONObject.optJSONObject("detail_1");
        }
        if (optJSONObject2 != null) {
            Object obj5 = optJSONObject2.get("desc");
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
            docName = (String) obj5;
        }
        Intrinsics.checkNotNullExpressionValue(docName, "docName");
        return docName;
    }

    @Nullable
    public final String e(@NotNull String bytesData, int subMsgType) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bytesData, subMsgType);
        }
        Intrinsics.checkNotNullParameter(bytesData, "bytesData");
        try {
        } catch (JSONException e16) {
            d.f354054a.a("HistoryExt", "parse TencentDoc URL error: " + e16);
        }
        if (subMsgType != 1) {
            if (subMsgType == 2) {
                Object obj2 = new JSONObject(bytesData).get(PublicAccountMessageUtilImpl.META_NAME);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject optJSONObject = ((JSONObject) obj2).optJSONObject("news");
                if (optJSONObject == null) {
                    return null;
                }
                Object obj3 = optJSONObject.get(WadlProxyConsts.KEY_JUMP_URL);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                return (String) obj3;
            }
            return null;
        }
        Object obj4 = new JSONObject(bytesData).get(PublicAccountMessageUtilImpl.META_NAME);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject jSONObject = (JSONObject) obj4;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("detail");
        if (optJSONObject2 != null) {
            obj = optJSONObject2.get("desc");
        } else {
            obj = null;
        }
        if (obj == null) {
            optJSONObject2 = jSONObject.optJSONObject("detail_1");
        }
        if (optJSONObject2 == null) {
            return null;
        }
        Object obj5 = optJSONObject2.get("qqdocurl");
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
        return (String) obj5;
    }

    @NotNull
    public final List<String> f(@NotNull String urlString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) urlString);
        }
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Pattern compile = Pattern.compile("(https?)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\"(https?)://[-A-\u2026+[-A-Za-z0-9+&@#/%=~_|]\")");
        Matcher matcher = compile.matcher(urlString);
        Intrinsics.checkNotNullExpressionValue(matcher, "urlPattern.matcher(urlString)");
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public final void g(@NotNull View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Object systemService = v3.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(v3.getWindowToken(), 0);
    }
}
