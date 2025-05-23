package com.tencent.mobileqq.qqshop.message;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountAttrs;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\t0\bJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0011\u001a\u00020\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010!\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010-\u001a\u00020*8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/d;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/ArkElement;", "g", "Lkotlin/Function1;", "", "callback", "j", "", "msgId", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "listener", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lorg/json/JSONObject;", "p", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "jsonObject", "", "y", "", "d", "", HippyTKDListViewAdapter.X, "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "f", "e", "i", "Lorg/json/JSONArray;", "u", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", h.F, "w", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "qqShopContact", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f274478a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            f274478a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(int i3, String str) {
        QLog.d("QQShopMsgRepository", 1, "[setMsgRead]: result=" + i3 + ", errMsg=" + str);
    }

    private final ArkElement g(MsgRecord msgRecord) {
        Object obj;
        boolean z16;
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).arkElement != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement = (MsgElement) obj;
        if (msgElement == null) {
            return null;
        }
        return msgElement.arkElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 callback, int i3, String str, ArrayList msgList) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgList);
        callback.invoke(firstOrNull);
    }

    private final Contact s() {
        return new Contact(103, "u_2ZRcriDgt2a46svnxKPPMw", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[Catch: Exception -> 0x0090, TryCatch #0 {Exception -> 0x0090, blocks: (B:3:0x0002, B:5:0x0014, B:7:0x0021, B:14:0x002e, B:17:0x0041, B:19:0x0067, B:23:0x0073), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String v(MsgRecord msgRecord) {
        generalflags$ResvAttr generalflags_resvattr;
        boolean z16;
        boolean contains$default;
        int indexOf$default;
        try {
            generalflags_resvattr = new generalflags$ResvAttr();
            generalflags_resvattr.mergeFrom(msgRecord.generalFlags);
        } catch (Exception e16) {
            QLog.w("QQShopMsgRepository", 1, "getAdvertId fail:", e16);
        }
        if (!generalflags_resvattr.bytes_oac_msg_extend.has()) {
            return null;
        }
        String stringUtf8 = generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8();
        if (stringUtf8 != null && stringUtf8.length() != 0) {
            z16 = false;
            if (!z16) {
                return null;
            }
            String oacValue = new JSONObject(stringUtf8).optString("oac_triggle");
            if (TextUtils.isEmpty(oacValue)) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(oacValue, "oacValue");
            Object[] array = new Regex(ContainerUtils.FIELD_DELIMITER).split(oacValue, 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            for (String str : (String[]) array) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "ad_id=", false, 2, (Object) null);
                if (contains$default) {
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "ad_id=", 0, false, 6, (Object) null);
                    String substring = str.substring(indexOf$default + 6);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    return substring;
                }
            }
            return null;
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void c(long msgId, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(msgId), listener);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(msgId));
        ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(s(), arrayList, listener);
    }

    public final int d(@Nullable MsgRecord msgRecord) {
        ArkElement g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgRecord)).intValue();
        }
        if (msgRecord == null || (g16 = g(msgRecord)) == null) {
            return 0;
        }
        return com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.a(g16);
    }

    @NotNull
    public final String e(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArkElement g16 = g(msgRecord);
        if (g16 == null) {
            return "";
        }
        String b16 = com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.b(g16);
        if (b16 == null) {
            return "0";
        }
        return b16;
    }

    @Nullable
    public final qq_ad_get.QQAdGetRsp.AdInfo f(@Nullable MsgRecord msgRecord) {
        ArkElement g16;
        JSONObject c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (qq_ad_get.QQAdGetRsp.AdInfo) iPatchRedirector.redirect((short) 13, (Object) this, (Object) msgRecord);
        }
        if (msgRecord == null || (g16 = g(msgRecord)) == null || (c16 = com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.c(g16)) == null) {
            return null;
        }
        return (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), c16);
    }

    public final boolean h(@NotNull MsgRecord msgRecord) {
        PublicAccountAttrs publicAccountAttrs;
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) msgRecord)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgAttributeInfo msgAttributeInfo = msgRecord.msgAttrs.get(4);
        if (msgAttributeInfo != null) {
            publicAccountAttrs = msgAttributeInfo.publicAccountAttrs;
        } else {
            publicAccountAttrs = null;
        }
        if (publicAccountAttrs == null || (l3 = publicAccountAttrs.bitmap) == null || (l3.longValue() & 12) == 0) {
            return false;
        }
        return true;
    }

    public final boolean i(@Nullable MsgRecord msgRecord) {
        ArkElement g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) msgRecord)).booleanValue();
        }
        if (msgRecord == null || (g16 = g(msgRecord)) == null || com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.d(g16) != 1) {
            return false;
        }
        return true;
    }

    public final void j(@NotNull final Function1<? super MsgRecord, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(s(), 1, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.qqshop.message.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                d.k(Function1.this, i3, str, arrayList);
            }
        });
    }

    @Nullable
    public final String l(@Nullable MsgRecord msgRecord) {
        ArkElement g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) msgRecord);
        }
        if (msgRecord == null || (g16 = g(msgRecord)) == null) {
            return null;
        }
        return com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.e(g16);
    }

    @Nullable
    public final String m(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArkElement g16 = g(msgRecord);
        if (g16 == null) {
            return null;
        }
        return com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.g(g16);
    }

    @Nullable
    public final String n(@Nullable MsgRecord msgRecord) {
        ArkElement g16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, (Object) msgRecord);
        }
        if (msgRecord == null || (g16 = g(msgRecord)) == null) {
            return null;
        }
        com.tencent.mobileqq.qqshop.message.datasource.a aVar = com.tencent.mobileqq.qqshop.message.datasource.a.f274479a;
        String h16 = aVar.h(g16);
        if (h16 != null && h16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return h16;
        }
        return aVar.i(g16);
    }

    @NotNull
    public final String o(@Nullable MsgRecord msgRecord) {
        String str;
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) msgRecord);
        }
        if (msgRecord == null) {
            return "";
        }
        JSONObject p16 = p(msgRecord);
        if (p16 != null && (optJSONObject = p16.optJSONObject("web_ext")) != null) {
            str = optJSONObject.optString("_origin");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Nullable
    public final JSONObject p(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (JSONObject) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArkElement g16 = g(msgRecord);
        if (g16 == null) {
            return null;
        }
        return com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.j(g16);
    }

    @NotNull
    public final JSONObject q(@Nullable MsgRecord msgRecord) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (JSONObject) iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgRecord);
        }
        if (msgRecord == null) {
            return new JSONObject();
        }
        JSONObject p16 = p(msgRecord);
        if (p16 != null) {
            jSONObject = p16.optJSONObject("native_ext");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return new JSONObject();
        }
        return jSONObject;
    }

    @NotNull
    public final JSONObject r(@Nullable MsgRecord msgRecord) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (JSONObject) iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgRecord);
        }
        if (msgRecord == null) {
            return new JSONObject();
        }
        JSONObject p16 = p(msgRecord);
        if (p16 != null) {
            jSONObject = p16.optJSONObject("web_ext");
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return new JSONObject();
        }
        return jSONObject;
    }

    @Nullable
    public final String t(@Nullable MsgRecord msgRecord) {
        ArkElement g16;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this, (Object) msgRecord);
        }
        if (msgRecord == null || (g16 = g(msgRecord)) == null) {
            return null;
        }
        com.tencent.mobileqq.qqshop.message.datasource.a aVar = com.tencent.mobileqq.qqshop.message.datasource.a.f274479a;
        boolean z18 = true;
        if (aVar.a(g16) < 100) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String b16 = aVar.b(g16);
            if (b16 != null && b16.length() != 0) {
                z18 = false;
            }
            if (z18) {
                return null;
            }
            return "ams_" + b16;
        }
        String v3 = v(msgRecord);
        if (v3 != null && v3.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            v3 = aVar.n(g16);
        }
        if (v3 != null && v3.length() != 0) {
            z18 = false;
        }
        if (z18) {
            return null;
        }
        return "tianshu_" + v3;
    }

    @Nullable
    public final JSONArray u(@Nullable MsgRecord msgRecord) {
        ArkElement g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (JSONArray) iPatchRedirector.redirect((short) 16, (Object) this, (Object) msgRecord);
        }
        if (msgRecord == null || (g16 = g(msgRecord)) == null) {
            return null;
        }
        return com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.l(g16);
    }

    public final boolean w(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) msgRecord)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (d(msgRecord) == 202) {
            return true;
        }
        return false;
    }

    public final boolean x(@Nullable MsgRecord msgRecord) {
        ArkElement g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) msgRecord)).booleanValue();
        }
        if (msgRecord == null || (g16 = g(msgRecord)) == null) {
            return false;
        }
        return com.tencent.mobileqq.qqshop.message.datasource.a.f274479a.k(g16);
    }

    @NotNull
    public final Map<String, String> y(@NotNull JSONObject jsonObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this, (Object) jsonObject);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator keys = jsonObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
        while (keys.hasNext()) {
            String str = (String) keys.next();
            String optString = jsonObject.optString(str);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(key)");
            hashMap.put(str, optString);
        }
        return hashMap;
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(s(), new IOperateCallback() { // from class: com.tencent.mobileqq.qqshop.message.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    d.A(i3, str);
                }
            });
        }
    }
}
