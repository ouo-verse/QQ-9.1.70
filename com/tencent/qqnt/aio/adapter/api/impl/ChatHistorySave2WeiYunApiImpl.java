package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IChatHistorySave2WeiYunApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ChatHistorySave2WeiYunApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistorySave2WeiYunApi;", "Landroid/content/Context;", "context", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecordList", "", "chatHistorySave2WeiYun", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ChatHistorySave2WeiYunApiImpl implements IChatHistorySave2WeiYunApi {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "ChatHistorySave2WeiYunApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ChatHistorySave2WeiYunApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistorySave2WeiYunApi
    public void chatHistorySave2WeiYun(Context context, List<MsgRecord> msgRecordList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        if (msgRecordList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "empty msg list");
                return;
            }
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 2, "need QQAppInterface");
            return;
        }
        QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
        Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
        QLog.d(TAG, 2, "save msg to WeiYun");
        List<MsgRecord> list = msgRecordList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new AIOMsgItem((MsgRecord) it.next()));
        }
        WeiyunAIOUtils.i((QQAppInterface) peekAppRuntime, sTopActivity, 0, arrayList, -1);
    }
}
