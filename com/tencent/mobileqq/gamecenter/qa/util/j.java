package com.tencent.mobileqq.gamecenter.qa.util;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameReportApi;
import com.tencent.mobileqq.gamecenter.data.GameReportExtraData;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.gamecenter.qa.util.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/j;", "", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0007R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/j$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/gamecenter/data/i;", WadlProxyConsts.EXTRA_DATA, "", "f", "", "c", "metaList", "e", "arkElementData", "g", "reserved2", tl.h.F, "robotUin", "", "d", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "chatItem", ViewStickEventHelper.IS_SHOW, "i", "ARK_META_DATA", "Ljava/lang/String;", "ARK_META_LIST", "ARK_META_REPORT", "ARK_META_REPORT_ADTAG", "KEY_EVENT_SHARE", "KEY_MINI_APP", "SCENE_RECENT", "TAG", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.util.j$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String c(MsgRecord msgRecord) {
            boolean z16;
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            boolean z17 = false;
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                MsgElement msgElement = arrayList.get(0);
                if (msgElement.elementType == 10) {
                    try {
                        String str = msgElement.arkElement.bytesData;
                        if (str == null || str.length() == 0) {
                            z17 = true;
                        }
                        if (!z17) {
                            return e(new JSONObject(msgElement.arkElement.bytesData).optString(PublicAccountMessageUtilImpl.META_NAME));
                        }
                    } catch (Exception e16) {
                        QLog.e("GameRobotUtil", 1, "getAdTagFromMsgRecord, exception=", e16);
                    }
                }
            }
            return "";
        }

        private final String e(String metaList) {
            List emptyList;
            List emptyList2;
            int indexOf$default;
            boolean z16;
            boolean z17;
            if (TextUtils.isEmpty(metaList)) {
                return "";
            }
            try {
                JSONObject optJSONObject = new JSONObject(metaList).optJSONObject(TtmlNode.TAG_METADATA);
                if (optJSONObject == null) {
                    return "";
                }
                String report = optJSONObject.optString("report");
                Intrinsics.checkNotNullExpressionValue(report, "report");
                List<String> split = new Regex(ContainerUtils.FIELD_DELIMITER).split(report, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                for (String str : (String[]) array) {
                    List<String> split2 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str, 0);
                    if (!split2.isEmpty()) {
                        ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    Object[] array2 = emptyList2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    if (((String[]) array2).length == 2) {
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, (Object) null);
                        String substring = str.substring(0, indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        if (Intrinsics.areEqual("adtag", substring)) {
                            String substring2 = str.substring(indexOf$default + 1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                            return substring2;
                        }
                    }
                }
                return "";
            } catch (JSONException e16) {
                QLog.e("GameRobotUtil", 1, "parseArkAdtag, exception=", e16);
                return "";
            }
        }

        private final void f(MsgRecord msgRecord, GameReportExtraData extraData) {
            Object orNull;
            String str;
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            if (arrayList != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
                MsgElement msgElement = (MsgElement) orNull;
                if (msgElement != null && msgElement.elementType == 10) {
                    Companion companion = j.INSTANCE;
                    ArkElement arkElement = msgElement.arkElement;
                    if (arkElement != null) {
                        str = arkElement.bytesData;
                    } else {
                        str = null;
                    }
                    companion.g(str, extraData);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:10:0x0011, B:13:0x0020, B:17:0x002f, B:20:0x0039, B:23:0x0040, B:24:0x004e, B:26:0x0054, B:32:0x0066, B:34:0x006f, B:39:0x007b, B:41:0x0093, B:42:0x009b, B:44:0x00a1, B:50:0x00b2, B:51:0x00c2, B:53:0x00d6, B:60:0x00be, B:63:0x00e1, B:28:0x0060), top: B:9:0x0011 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void g(String arkElementData, GameReportExtraData extraData) {
            boolean z16;
            JSONObject optJSONObject;
            boolean z17;
            boolean z18;
            List emptyList;
            boolean z19;
            if (arkElementData != null && arkElementData.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            try {
                JSONObject optJSONObject2 = new JSONObject(arkElementData).optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
                if (optJSONObject2 == null) {
                    return;
                }
                Iterator keys = optJSONObject2.keys();
                String str = null;
                if (!keys.hasNext()) {
                    keys = null;
                }
                if (keys != null) {
                    str = (String) keys.next();
                }
                if (str == null || (optJSONObject = optJSONObject2.optJSONObject(str)) == null) {
                    return;
                }
                String reserved1 = optJSONObject.optString("ark_reserved1");
                Intrinsics.checkNotNullExpressionValue(reserved1, "reserved1");
                int i3 = 0;
                while (true) {
                    if (i3 < reserved1.length()) {
                        if (!Character.isDigit(reserved1.charAt(i3))) {
                            z17 = false;
                            break;
                        }
                        i3++;
                    } else {
                        z17 = true;
                        break;
                    }
                }
                if (z17) {
                    String reserved3 = optJSONObject.optString("ark_reserved3");
                    if (reserved3 != null && reserved3.length() != 0) {
                        z18 = false;
                        if (z18) {
                            Intrinsics.checkNotNullExpressionValue(reserved3, "reserved3");
                            List<String> split = new Regex("\\+").split(reserved3, 0);
                            if (!split.isEmpty()) {
                                ListIterator<String> listIterator = split.listIterator(split.size());
                                while (listIterator.hasPrevious()) {
                                    if (listIterator.previous().length() == 0) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (!z19) {
                                        emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                        break;
                                    }
                                }
                            }
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            Object[] array = emptyList.toArray(new String[0]);
                            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            String[] strArr = (String[]) array;
                            if (strArr.length == 2) {
                                extraData.p(strArr[0]);
                                extraData.o(strArr[1]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    z18 = true;
                    if (z18) {
                    }
                } else {
                    h(optJSONObject.optString("ark_reserved2"), extraData);
                }
            } catch (Exception e16) {
                QLog.e("GameRobotUtil", 1, "parseExtraFromArkEle fail. e=", e16);
            }
        }

        private final void h(String reserved2, GameReportExtraData extraData) {
            boolean z16;
            String valueOf;
            if (reserved2 != null && reserved2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            try {
                byte[] decode = Base64.decode(reserved2, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(reserved2, Base64.DEFAULT)");
                String str = new String(decode, Charsets.UTF_8);
                if (QLog.isDevelopLevel()) {
                    QLog.i("GameRobotUtil", 4, "parseReserved2ToReportData: reserved2=" + str);
                }
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("botpushevent");
                if (optJSONObject == null) {
                    return;
                }
                long optLong = optJSONObject.optLong("push_task_id");
                String str2 = null;
                if (optLong == 0) {
                    valueOf = null;
                } else {
                    valueOf = String.valueOf(optLong);
                }
                extraData.o(valueOf);
                long optLong2 = optJSONObject.optLong("event_id");
                if (optLong2 != 0) {
                    str2 = String.valueOf(optLong2);
                }
                extraData.l(str2);
            } catch (IllegalArgumentException e16) {
                QLog.e("GameRobotUtil", 1, "parseReserved2ToReportData: base64 decode fail, content=" + reserved2, e16);
            } catch (JSONException e17) {
                QLog.e("GameRobotUtil", 1, "parseReserved2ToReportData: parse json fail, content=" + reserved2, e17);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(final com.tencent.qqnt.chats.core.adapter.itemdata.g chatItem, final boolean z16) {
            Intrinsics.checkNotNullParameter(chatItem, "$chatItem");
            if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
                ArrayList<Long> arrayList = new ArrayList<>();
                arrayList.add(Long.valueOf(chatItem.s().msgId));
                ((IMsgService) QRoute.api(IMsgService.class)).getMsgsByMsgId(new Contact(chatItem.s().chatType, chatItem.s().peerUid, ""), arrayList, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.qa.util.i
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i3, String str, ArrayList arrayList2) {
                        j.Companion.k(com.tencent.qqnt.chats.core.adapter.itemdata.g.this, z16, i3, str, arrayList2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(com.tencent.qqnt.chats.core.adapter.itemdata.g chatItem, boolean z16, int i3, String str, ArrayList msgList) {
            String str2;
            String str3;
            String str4;
            MsgRecord msgRecord;
            Intrinsics.checkNotNullParameter(chatItem, "$chatItem");
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            GameReportExtraData gameReportExtraData = new GameReportExtraData();
            if (i3 == 0 && msgList.size() > 0 && (msgRecord = (MsgRecord) msgList.get(0)) != null) {
                Companion companion = j.INSTANCE;
                str2 = companion.c(msgRecord);
                companion.f(msgRecord, gameReportExtraData);
            } else {
                str2 = "";
            }
            if (chatItem.x().b() > 0) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            gameReportExtraData.k("61402");
            gameReportExtraData.m(String.valueOf(chatItem.l()));
            gameReportExtraData.n(str3);
            if (QLog.isDevelopLevel()) {
                QLog.i("GameRobotUtil", 4, "reportRobotRecentList: extraData=" + gameReportExtraData);
            }
            IGameReportApi iGameReportApi = (IGameReportApi) QRoute.api(IGameReportApi.class);
            if (z16) {
                str4 = "209040";
            } else {
                str4 = "209041";
            }
            iGameReportApi.reportRobot(str4, str2, gameReportExtraData);
        }

        @JvmStatic
        public final boolean d(@Nullable String robotUin) {
            return ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).isGameRobot(robotUin);
        }

        @JvmStatic
        public final void i(@NotNull final com.tencent.qqnt.chats.core.adapter.itemdata.g chatItem, final boolean isShow) {
            Intrinsics.checkNotNullParameter(chatItem, "chatItem");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.util.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.Companion.j(com.tencent.qqnt.chats.core.adapter.itemdata.g.this, isShow);
                }
            }, 32, null, false);
        }

        Companion() {
        }
    }
}
