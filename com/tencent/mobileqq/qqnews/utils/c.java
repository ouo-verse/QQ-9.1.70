package com.tencent.mobileqq.qqnews.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0003J$\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0003J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0003J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0003J\b\u0010\u0017\u001a\u00020\u0016H\u0003\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqnews/utils/c;", "", "", "uid", "", "e", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "message", "l", "articleUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "info", h.F, "d", "Lorg/json/JSONObject;", "c", "", "f", "<init>", "()V", "qqnews-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f274145a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20894);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f274145a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    private static final JSONObject c(MsgRecord message) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hide_titlebar", 1);
        if (message == null) {
            return jSONObject;
        }
        String str = null;
        try {
            nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags = new nt_im_msg_body$GeneralFlags();
            nt_im_msg_body_generalflags.mergeFrom(message.generalFlags);
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            generalflags_resvattr.mergeFrom(nt_im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
            str = generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8();
            QLog.i("QQNewsHelper", 1, "json str = " + str);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QQNewsHelper", 1, "get json str fail, exception is" + e16);
        }
        if (str != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(new JSONObject(str).optString("news_extra"));
                jSONObject2.put("hide_titlebar", 1);
                return jSONObject2;
            } catch (JSONException e17) {
                QLog.e("QQNewsHelper", 1, "opt news extra str from json fail, exception is" + e17);
            }
        }
        return jSONObject;
    }

    @JvmStatic
    private static final String d(MsgRecord message) {
        String jSONObject = c(message).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "getNewsExtraFromMsgRecord(message).toString()");
        return jSONObject;
    }

    @JvmStatic
    public static final boolean e(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        return Intrinsics.areEqual(uid, "u_8zYoRDnwjpWg91HWuO-WGA");
    }

    @JvmStatic
    private static final void f() {
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(103, "u_8zYoRDnwjpWg91HWuO-WGA", ""), new IOperateCallback() { // from class: com.tencent.mobileqq.qqnews.utils.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                c.g(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, String str) {
        QLog.i("QQNewsHelper", 1, "setMsgRead result:" + i3 + ", errMsg=" + str);
    }

    @JvmStatic
    private static final boolean h(Context context, OpenHippyInfo info, Intent intent) {
        if (context == null) {
            QLog.e("QQNewsHelper", 1, "startQQNewsHippyPage params err", "context is null");
            return false;
        }
        String str = info.bundleName;
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQNewsHelper", 1, "startQQNewsHippyPage params err", "bundleName is null");
            return false;
        }
        QLog.i("QQNewsHelper", 1, "startQQNewsHippyPage with bundleName = " + str);
        Bundle bundle = info.toBundle();
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        bundle.putInt("title_bar_style", 1);
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("params", bundle);
        QPublicFragmentActivity.start(context, intent, CommonHippyFragment.class);
        f();
        return true;
    }

    @JvmStatic
    public static final boolean i(@NotNull final Context context, @Nullable final Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(new Contact(103, "u_8zYoRDnwjpWg91HWuO-WGA", ""), 1, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.qqnews.utils.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                c.k(context, intent, i3, str, arrayList);
            }
        });
        return true;
    }

    public static /* synthetic */ boolean j(Context context, Intent intent, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            intent = null;
        }
        return i(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Context context, Intent intent, int i3, String str, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        if (!msgList.isEmpty()) {
            l(context, (MsgRecord) msgList.get(0), intent);
        } else {
            l(context, null, intent);
        }
    }

    @JvmStatic
    public static final boolean l(@NotNull Context context, @Nullable MsgRecord message, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject c16 = c(message);
        String articleUrl = c16.optString("article_url");
        boolean z16 = false;
        if (c16.optInt("is_video", 0) == 1) {
            z16 = true;
        }
        int optInt = c16.optInt("jump_type", QQNewsJumpType.DEFAULT.getValue());
        if (z16 && optInt == QQNewsJumpType.DETAIL_PAGE.getValue() && !TextUtils.isEmpty(articleUrl)) {
            Intrinsics.checkNotNullExpressionValue(articleUrl, "articleUrl");
            return m(context, articleUrl);
        }
        Bundle bundle = new Bundle();
        bundle.putString("bundleName", HippyQQConstants.ModuleName.QQ_NEWS_PUBLICACCOUNT);
        bundle.putString("framework", "react");
        if (!TextUtils.isEmpty(articleUrl)) {
            bundle.putString(OpenHippyInfo.EXTRA_KEY_ERROR_URL, articleUrl);
        }
        SerializableMap serializableMap = new SerializableMap();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("news_extra", d(message));
        serializableMap.wrapMap(hashMap);
        bundle.putSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP, serializableMap);
        bundle.putInt(OpenHippyInfo.EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE, 1);
        bundle.putString("domain", "inews.qq.com");
        return h(context, new OpenHippyInfo(bundle), intent);
    }

    @JvmStatic
    private static final boolean m(Context context, String articleUrl) {
        String addParameter = URLUtil.addParameter(articleUrl, "_wv", "16777218");
        Intrinsics.checkNotNullExpressionValue(addParameter, "addParameter(jumpUrl, \"_\u2026, newsImmersiveWebViewWV)");
        String addParameter2 = URLUtil.addParameter(addParameter, "_wwv", "8192");
        Intrinsics.checkNotNullExpressionValue(addParameter2, "addParameter(jumpUrl, \"_\u2026 newsImmersiveWebViewWWV)");
        String addParameter3 = URLUtil.addParameter(addParameter2, "bgColor", "ff000000");
        Intrinsics.checkNotNullExpressionValue(addParameter3, "addParameter(jumpUrl, \"b\u2026sImmersiveWebViewBgColor)");
        String addParameter4 = URLUtil.addParameter(addParameter3, "_cntclr", "ff000000");
        Intrinsics.checkNotNullExpressionValue(addParameter4, "addParameter(jumpUrl, \"_\u2026sImmersiveWebViewBgColor)");
        if (TextUtils.isEmpty(addParameter4)) {
            return false;
        }
        HippyUtils.gotoBrowserActivity(context, addParameter4);
        f();
        return true;
    }
}
