package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.parser.bz;
import com.tencent.mobileqq.qcircle.api.event.QFSShortVideoPositionEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J<\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ChatHistoryShortVideoApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "", "seqList", "", "convertJsonList", "Lcom/tencent/mobileqq/qcircle/api/event/QFSShortVideoPositionEvent;", "event", "", "handleShortVideoPositionEvent", "Landroid/content/Context;", "context", WadlProxyConsts.KEY_JUMP_URL, QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "source", "forwardToShortVideoLayer", "key", "obtainJumpUrlKeyVal", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$a;", "listener", "setOnHistoryShortEventListener", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "mListener", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$a;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ChatHistoryShortVideoApiImpl implements IChatHistoryShortVideoApi, SimpleEventReceiver<SimpleBaseEvent> {
    public static final String KEY_CHAT_MSG_SEQ_LIST = "chat_seq_list";
    public static final String KEY_CURRENT_MSG_SEQ = "current_msg_seq";
    public static final String KEY_DT_PAGE_ID = "xsj_custom_pgid";
    public static final String KEY_FEED_ID = "xsj_feed_id";
    public static final String KEY_GET_FEED_LIST = "getfeedlist";
    public static final String KEY_MAIN_ENTRANCE = "xsj_main_entrance";
    public static final String KEY_SUB_ENTRANCE = "xsj_sub_entrance";
    public static final String TAG = "QCHV-ChatHistoryShortVideoApiImpl";
    public static final String VAL_DT_PAGE_ID = "pg_xsj_chat_history_short_video_page";
    public static final String VAL_SUB_ENTRANCE = "video_chats";
    private IChatHistoryShortVideoApi.a mListener;

    private final String convertJsonList(List<Long> seqList) {
        JSONArray jSONArray = new JSONArray();
        if (seqList != null) {
            Iterator<T> it = seqList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Number) it.next()).longValue());
            }
        }
        return jSONArray.toString();
    }

    private final void handleShortVideoPositionEvent(QFSShortVideoPositionEvent event) {
        String str;
        if (this.mListener == null) {
            QLog.d(TAG, 1, "[handleShortVideoPositionEvent] listener should not be null.");
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Long chatSeq = event.getChatSeq();
        if (chatSeq != null) {
            str = String.valueOf(chatSeq);
        } else {
            str = "";
        }
        linkedHashMap.put(KEY_CURRENT_MSG_SEQ, str);
        IChatHistoryShortVideoApi.a aVar = this.mListener;
        Intrinsics.checkNotNull(aVar);
        aVar.a(IChatHistoryShortVideoApi.ChatHistoryShortVideoEvent.SHORT_VIDEO_EVENT_POSITION_CHANGE, linkedHashMap);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi
    public void forwardToShortVideoLayer(Context context, String jumpUrl, String entrance, List<String> source, List<Long> seqList) {
        HashMap<String, String> hashMap;
        String feedId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(seqList, "seqList");
        if ((jumpUrl.length() == 0) || source.isEmpty()) {
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        AppRuntime peekAppRuntime = mobileQQ != null ? mobileQQ.peekAppRuntime() : null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
            com.tencent.mobileqq.utils.ax a16 = new bz().a(baseQQAppInterface, context, jumpUrl, null);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = source.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.utils.ax a17 = new bz().a(baseQQAppInterface, context, (String) it.next(), null);
                if (a17 != null && (hashMap = a17.f307441f) != null && (feedId = hashMap.get("xsj_feed_id")) != null) {
                    Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
                    arrayList.add(feedId);
                }
            }
            QLog.d(TAG, 1, "[forwardToShortVideoLayer] jump action: " + a16.f307440e + " | size: " + arrayList.size() + " | seq size: " + seqList.size());
            HashMap<String, String> hashMap2 = a16.f307441f;
            if (hashMap2 != null) {
                hashMap2.put("getfeedlist", "false");
                hashMap2.put("xsj_custom_pgid", "pg_xsj_chat_history_short_video_page");
                hashMap2.put("xsj_main_entrance", entrance);
                hashMap2.put("xsj_sub_entrance", VAL_SUB_ENTRANCE);
                hashMap2.put("chat_seq_list", convertJsonList(seqList));
                com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeSourceAction(context, a16.f307440e, hashMap2, arrayList);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSShortVideoPositionEvent.class);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi
    public String obtainJumpUrlKeyVal(Context context, String jumpUrl, String key) {
        HashMap<String, String> hashMap;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(key, "key");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String str = null;
        AppRuntime peekAppRuntime = mobileQQ != null ? mobileQQ.peekAppRuntime() : null;
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            return "";
        }
        com.tencent.mobileqq.utils.ax a16 = new bz().a((BaseQQAppInterface) peekAppRuntime, context, jumpUrl, null);
        if (a16 != null && (hashMap = a16.f307441f) != null) {
            str = hashMap.get(key);
        }
        return str == null ? "" : str;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QFSShortVideoPositionEvent) {
            handleShortVideoPositionEvent((QFSShortVideoPositionEvent) event);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi
    public void setOnHistoryShortEventListener(IChatHistoryShortVideoApi.a listener) {
        try {
            if (listener != null) {
                SimpleEventBus.getInstance().registerReceiver(this);
            } else {
                SimpleEventBus.getInstance().unRegisterReceiver(this);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[setOnHistoryShortEventListener] ex: ", th5);
        }
        QLog.d(TAG, 1, "[setOnHistoryShortEventListener] listener: " + listener);
        this.mListener = listener;
    }
}
