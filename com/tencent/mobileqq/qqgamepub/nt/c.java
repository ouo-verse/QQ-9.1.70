package com.tencent.mobileqq.qqgamepub.nt;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tenpay.realname.RealNameSource;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\"\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001a\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000bH\u0002\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/c;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "g", "", "l", "info", "", "c", "Lorg/json/JSONObject;", "contentJson", "d", "Ltencent/im/msg/nt_im_msg_general_flags_body$ResvAttr;", "j", "i", "msgExtendObj", "a", "", "b", "oacMsgExtend", h.F, "Lorg/json/JSONArray;", "sortedJson", "k", "gameExtraJson", "f", "e", "<init>", "()V", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f264672a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21633);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f264672a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final JSONObject a(JSONObject msgExtendObj) {
        JSONObject jSONObject = new JSONObject();
        try {
            Bundle e16 = com.tencent.mobileqq.qqgamepub.data.b.e(msgExtendObj.optString("oac_triggle"));
            Intrinsics.checkNotNullExpressionValue(e16, "queryParams(oacTrigggle)");
            String string = e16.getString("busi_info");
            if (string == null) {
                string = "{}";
            }
            return new JSONObject(string);
        } catch (Exception unused) {
            QLog.e("QQGameMsgParser", 2, "parseException error ");
            return jSONObject;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[Catch: Exception -> 0x0076, TryCatch #0 {Exception -> 0x0076, blocks: (B:3:0x0004, B:6:0x0024, B:10:0x002f, B:12:0x0048, B:14:0x005a, B:16:0x0073), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String b(JSONObject msgExtendObj) {
        String string;
        boolean z16;
        boolean contains$default;
        boolean contains$default2;
        try {
            Bundle e16 = com.tencent.mobileqq.qqgamepub.data.b.e(msgExtendObj.optString("oac_triggle"));
            Intrinsics.checkNotNullExpressionValue(e16, "queryParams(oacTrigggle)");
            string = e16.getString("busi_id");
        } catch (Exception unused) {
            QLog.e("QQGameMsgParser", 2, "parseException error ");
        }
        if (string != null) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) ContainerUtils.KEY_VALUE_DELIMITER, false, 2, (Object) null);
            if (contains$default2) {
                z16 = true;
                if (z16) {
                    Object[] array = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(string, 0).toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr = (String[]) array;
                    if (strArr.length == 2) {
                        String fidStr = URLDecoder.decode(strArr[1]);
                        Intrinsics.checkNotNullExpressionValue(fidStr, "fidStr");
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) fidStr, (CharSequence) ContainerUtils.KEY_VALUE_DELIMITER, false, 2, (Object) null);
                        if (contains$default) {
                            Object[] array2 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(fidStr, 0).toArray(new String[0]);
                            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            String[] strArr2 = (String[]) array2;
                            if (strArr2.length == 2) {
                                return strArr2[1];
                            }
                        }
                    }
                }
                return "";
            }
        }
        z16 = false;
        if (z16) {
        }
        return "";
    }

    private final void c(MsgRecord record, QQGameMsgInfo info) {
        ArkElement arkElement;
        info.msgType = 1;
        MsgElement i3 = MsgExtKt.i(record, 10);
        JSONObject jSONObject = null;
        if (i3 != null) {
            arkElement = i3.arkElement;
        } else {
            arkElement = null;
        }
        if (arkElement != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(arkElement.bytesData);
                try {
                    d(jSONObject2, info);
                    jSONObject = jSONObject2;
                } catch (Exception e16) {
                    e = e16;
                    jSONObject = jSONObject2;
                    QLog.e("QQGameMsgParser", 1, "ArkElementJson new JSONObject error: " + e.getMessage());
                    QLog.d("QQGameMsgParser", 2, "[parseArkViewNt] contentJson:" + jSONObject);
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        QLog.d("QQGameMsgParser", 2, "[parseArkViewNt] contentJson:" + jSONObject);
    }

    private final void d(JSONObject contentJson, QQGameMsgInfo info) {
        int i3;
        if (TextUtils.isEmpty(info.gameAppId)) {
            info.gameAppId = contentJson.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        }
        info.arkAppMinVersion = contentJson.optString("ver");
        info.arkAppName = contentJson.optString("app");
        info.arkAppView = contentJson.optString("view");
        info.arkAppConfig = contentJson.optString(DownloadInfo.spKey_Config);
        info.arkMetaList = contentJson.optString(PublicAccountMessageUtilImpl.META_NAME);
        try {
            JSONObject jSONObject = new JSONObject(info.arkMetaList);
            if (((IQQGameHelper) QRoute.api(IQQGameHelper.class)).addQQGameArkField(info.arkAppName, String.valueOf(info.uniseq), GamePubAccountHelper.s(), jSONObject) != null) {
                info.arkMetaList = jSONObject.toString();
            }
            if (!TextUtils.isEmpty(info.arkMetaList)) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("gdt").getJSONObject("adInfo").getJSONObject(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
                    info.isAdMsg = true;
                    info.adJson = jSONObject2.toString();
                } catch (Exception unused) {
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("template3");
            boolean z16 = false;
            if (optJSONObject != null) {
                z16 = optJSONObject.optBoolean("is_colorful", false);
            }
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            info.retId = i3;
        } catch (Throwable th5) {
            QLog.e("QQGameMsgParser", 1, "MessageForArkApp error =" + th5);
        }
    }

    private final void e(QQGameMsgInfo info, JSONObject gameExtraJson) {
        info.directJumpConfigs = gameExtraJson.optString("direct_jump_configs");
    }

    private final void f(QQGameMsgInfo info, JSONObject gameExtraJson) {
        String optString = gameExtraJson.optString("ext_json");
        info.extJson = optString;
        try {
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject = new JSONObject(info.extJson);
                info.desc = jSONObject.optString("desc");
                info.icon = jSONObject.optString("icon");
                info.arkWidth = jSONObject.optInt("w");
                info.arkHeight = jSONObject.optInt(h.F);
            }
        } catch (Throwable th5) {
            QLog.e("QQGameMsgParser", 1, th5, new Object[0]);
        }
    }

    @JvmStatic
    @Nullable
    public static final QQGameMsgInfo g(@Nullable MsgRecord record) {
        c cVar = f264672a;
        if (!cVar.l(record)) {
            QLog.d("QQGameMsgParser", 1, "parseMsgRecord--> validMsgType is failed:" + record);
            return null;
        }
        QQGameMsgInfo qQGameMsgInfo = new QQGameMsgInfo();
        Intrinsics.checkNotNull(record);
        qQGameMsgInfo.uniseq = record.clientSeq;
        qQGameMsgInfo.frienduin = record.peerUin + "";
        qQGameMsgInfo.msgTime = record.msgTime;
        qQGameMsgInfo.istroop = record.chatType;
        qQGameMsgInfo.msgId = record.msgId;
        cVar.i(record, qQGameMsgInfo);
        cVar.c(record, qQGameMsgInfo);
        return qQGameMsgInfo;
    }

    private final void h(MsgRecord record, String oacMsgExtend, QQGameMsgInfo info) {
        String b16 = com.tencent.mobileqq.qqgamepub.data.b.b(oacMsgExtend);
        if (!TextUtils.isEmpty(b16)) {
            info.advId = b16;
            info.paMsgid = b16;
        } else {
            QLog.i("QQGameMsgParser", 1, "[parsePaMsgIdAndAvdId] advId is empty");
            info.paMsgid = String.valueOf(((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getPubMsgId(record));
        }
    }

    private final void i(MsgRecord record, QQGameMsgInfo info) {
        int i3;
        nt_im_msg_general_flags_body$ResvAttr j3 = j(record);
        if (!j3.bytes_oac_msg_extend.has()) {
            QLog.d("QQGameMsgParser", 2, "bytes_oac_msg_extend is empty");
            return;
        }
        String stringUtf8 = j3.bytes_oac_msg_extend.get().toStringUtf8();
        QLog.i("QQGameMsgParser", 2, "parseQQGameInfo -> oacMsgExtend\uff1a" + stringUtf8);
        if (!TextUtils.isEmpty(stringUtf8)) {
            try {
                info.triggerInfo = stringUtf8;
                JSONObject jSONObject = new JSONObject(stringUtf8);
                h(record, stringUtf8, info);
                JSONObject a16 = a(jSONObject);
                if (a16 != null) {
                    i3 = a16.optInt("tianshu_footageid");
                } else {
                    i3 = 0;
                }
                info.tianshuFootageid = i3;
                info.fid = b(jSONObject);
                String optString = jSONObject.optString("game_extra");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    k(info, jSONObject2.optJSONArray("sorted_configs"));
                    f(info, jSONObject2);
                    e(info, jSONObject2);
                }
            } catch (Throwable th5) {
                QLog.d("QQGameMsgParser", 1, "get getGameMsgInfoByMsg  msg err= " + th5.getMessage());
            }
        }
    }

    private final nt_im_msg_general_flags_body$ResvAttr j(MsgRecord record) {
        nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags = new nt_im_msg_body$GeneralFlags();
        nt_im_msg_body_generalflags.mergeFrom(record.generalFlags);
        nt_im_msg_general_flags_body$ResvAttr mergeFrom = new nt_im_msg_general_flags_body$ResvAttr().mergeFrom(nt_im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
        Intrinsics.checkNotNullExpressionValue(mergeFrom, "ResvAttr().mergeFrom(gen\u2026erve.get().toByteArray())");
        return mergeFrom;
    }

    private final void k(QQGameMsgInfo info, JSONArray sortedJson) {
        if (sortedJson == null) {
            return;
        }
        info.sortedConfigs = sortedJson.toString();
        int length = sortedJson.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                if (i3 == 1) {
                    info.taskId = sortedJson.optJSONObject(i3).optString("task_id");
                }
            } else {
                info.gameAppId = sortedJson.optJSONObject(i3).optString("app_id");
            }
        }
    }

    private final boolean l(MsgRecord record) {
        if (record != null && record.msgType == 11) {
            return true;
        }
        return false;
    }
}
