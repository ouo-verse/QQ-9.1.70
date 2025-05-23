package com.tencent.mobileqq.aio.msglist.holder.component.template.business;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/a;", "", "url", "", "f", "isHttps", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/f;", "parseParams", "", "b", "g", "", "chatType", "d", "scene", "isMiniGame", "shareOrigin", "e", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/e$a;", "", "", "appName", "viewName", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.business.e$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a(@Nullable String appName, @Nullable String viewName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appName, (Object) viewName)).booleanValue();
            }
            if (Intrinsics.areEqual(appName, "com.tencent.miniapp_01") && Intrinsics.areEqual(viewName, "view_8C8E89B49BE609866298ADDFF2DBABA4")) {
                return true;
            }
            return false;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(f parseParams) {
        String str;
        Integer intOrNull;
        boolean z16;
        JSONObject jSONObject = new JSONObject(parseParams.d());
        String c16 = c(jSONObject.optString("preview"), false);
        if (c16 == null) {
            c16 = "";
        }
        jSONObject.put("preview", c16);
        String c17 = c(jSONObject.optString("url"), false);
        if (c17 == null) {
            str = "";
        } else {
            str = c17;
        }
        int optInt = jSONObject.optInt("scene", 0);
        String businessType = jSONObject.optString("businessType", "");
        int optInt2 = jSONObject.optInt("appType", 0);
        Intrinsics.checkNotNullExpressionValue(businessType, "businessType");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(businessType);
        if ((intOrNull == null || intOrNull.intValue() != 1) && optInt2 != 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        jSONObject.put("url", e(str, optInt, z16, jSONObject.optInt("shareOrigin", 0), parseParams));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "originData.toString()");
        parseParams.g(jSONObject2);
    }

    private final String c(String url, boolean isHttps) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        boolean startsWith$default5;
        if (!Intrinsics.areEqual(url, "local")) {
            if (url != null && url.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "miniapp://", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "res:", false, 2, null);
                    if (!startsWith$default2 && !f(url)) {
                        startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url, "m.q.qq.com", false, 2, null);
                        if (!startsWith$default3) {
                            startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(url, "http:", false, 2, null);
                            if (!startsWith$default4) {
                                startsWith$default5 = StringsKt__StringsJVMKt.startsWith$default(url, "https:", false, 2, null);
                                if (!startsWith$default5) {
                                    if (isHttps) {
                                        return "https://" + url;
                                    }
                                    return "http://" + url;
                                }
                                return url;
                            }
                            return url;
                        }
                        return "https://" + url;
                    }
                    return url;
                }
                return url;
            }
            return url;
        }
        return url;
    }

    private final String d(int chatType) {
        switch (chatType) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 5:
            case 6:
            default:
                return "c2c";
            case 3:
            case 4:
                return VipFunCallConstants.KEY_GROUP;
            case 7:
                return WadlProxyConsts.CHANNEL;
        }
    }

    private final String e(String url, int scene, boolean isMiniGame, int shareOrigin, f parseParams) {
        Integer num;
        Long l3;
        int i3;
        String str;
        List listOf;
        boolean startsWith$default;
        boolean contains$default;
        String joinToString$default;
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        Map mapOf4;
        String replace$default;
        String str2;
        String str3;
        MsgRecord msgRecord;
        MsgRecord msgRecord2;
        ITemplateMsgApi iTemplateMsgApi = (ITemplateMsgApi) QRoute.api(ITemplateMsgApi.class);
        TemplateMsgItem e16 = parseParams.e();
        if (e16 != null && (msgRecord2 = e16.getMsgRecord()) != null) {
            num = Integer.valueOf(msgRecord2.chatType);
        } else {
            num = null;
        }
        int convertMsgRecordChatType = iTemplateMsgApi.convertMsgRecordChatType(num);
        TemplateMsgItem e17 = parseParams.e();
        if (e17 != null && (msgRecord = e17.getMsgRecord()) != null) {
            l3 = Long.valueOf(msgRecord.peerUin);
        } else {
            l3 = null;
        }
        if (scene != 0) {
            i3 = scene;
        } else {
            i3 = 1007;
            if (convertMsgRecordChatType != -1 && convertMsgRecordChatType > 2) {
                i3 = 1008;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (convertMsgRecordChatType != -1) {
            if (convertMsgRecordChatType <= 2) {
                str3 = "scene=1007";
            } else {
                str3 = "scene=1008";
            }
            arrayList.add(str3);
            if (convertMsgRecordChatType == 3) {
                arrayList.add("_gid=" + l3);
            }
            if (convertMsgRecordChatType == 3 || convertMsgRecordChatType == 4) {
                arrayList.add("_sessionid=" + l3);
                arrayList.add("_sessiontype=" + convertMsgRecordChatType);
            }
        }
        boolean z16 = false;
        if (isMiniGame) {
            String d16 = d(convertMsgRecordChatType);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "3402_2_1"), TuplesKt.to(2, "3402_1_1"));
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "3402_2_2"), TuplesKt.to(2, "3402_1_2"));
            mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "3402_2_6"), TuplesKt.to(2, "3402_1_6"));
            mapOf4 = MapsKt__MapsKt.mapOf(TuplesKt.to(VipFunCallConstants.KEY_GROUP, mapOf), TuplesKt.to("c2c", mapOf2), TuplesKt.to(WadlProxyConsts.CHANNEL, mapOf3));
            replace$default = StringsKt__StringsJVMKt.replace$default(url, "via=", "pre_via=", false, 4, (Object) null);
            Map map = (Map) mapOf4.get(d16);
            if (map != null && (str2 = (String) map.get(Integer.valueOf(shareOrigin))) != null) {
                arrayList.add("via=" + str2);
            }
            str = replace$default;
        } else {
            str = url;
        }
        if (!arrayList.isEmpty()) {
            String str4 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
            if (contains$default) {
                str4 = ContainerUtils.FIELD_DELIMITER;
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
            str = ((Object) str) + str4 + joinToString$default;
        }
        String str5 = "miniapp://open/" + i3 + "?url=" + URLEncoder.encode(str, "UTF-8");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://m.q.qq.com/a/", "http://m.q.qq.com/a/", "mqqapi://microapp/open", "mqqapi://miniapp/open", "mqqapi://miniapp/adopen"});
        List list = listOf;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, (String) it.next(), false, 2, null);
                if (startsWith$default) {
                    z16 = true;
                    break;
                }
            }
        }
        if (z16) {
            return str5;
        }
        return str;
    }

    private final boolean f(String url) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, ImageContentType.IMAGE_PREFIX, false, 2, null);
        if (startsWith$default) {
            return true;
        }
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "res:", false, 2, null);
        if (startsWith$default2) {
            return true;
        }
        return false;
    }

    private final void g(f parseParams) {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject(parseParams.d());
        boolean z16 = false;
        if (jSONObject.optInt("businessType", 0) == 2) {
            z16 = true;
        }
        if (z16) {
            str = "\u5fae\u4fe1\u5c0f\u7a0b\u5e8f";
        } else {
            str = SoLoad.BIZ_TRTC_QQMINI;
        }
        if (z16) {
            str2 = "https://static-res.qq.com/static-res/ark/template/demo/template_icon_wx_miniapp.png";
        } else {
            str2 = "https://static-res.qq.com/static-res/ark/template/demo/template_icon_miniapp.png";
        }
        jSONObject.put("tag", str);
        jSONObject.put("tagIcon", str2);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "originData.toString()");
        parseParams.g(jSONObject2);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.template.business.a
    public boolean a(@NotNull f parseParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parseParams)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parseParams, "parseParams");
        try {
        } catch (Throwable th5) {
            QLog.e("TemMsg.OldMini", 1, "doProcessUrl exception:" + Log.getStackTraceString(th5));
        }
        if (!INSTANCE.a(parseParams.a(), parseParams.f())) {
            return false;
        }
        b(parseParams);
        g(parseParams);
        return false;
    }
}
