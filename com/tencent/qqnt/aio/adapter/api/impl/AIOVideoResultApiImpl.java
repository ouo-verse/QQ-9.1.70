package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOVideoResultApi;
import com.tencent.qqnt.kernel.nativeinterface.AVRecordElement;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LocalAVRecordElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOVideoResultApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOVideoResultApi;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Lcom/tencent/qqnt/kernel/nativeinterface/LocalAVRecordElement;", "data", "", "addLocalAVRecordMsg", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "onMessageClick", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOVideoResultApiImpl implements IAIOVideoResultApi {
    private static final String TAG = "AIOVideoResultApiImpl";
    private static final int VIDEO_RESULT_ELEMENT_ID = 21;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLocalAVRecordMsg$lambda$0(LocalAVRecordElement data, int i3, String str) {
        Intrinsics.checkNotNullParameter(data, "$data");
        QLog.e(TAG, 1, "add local av record msg result=" + i3 + ",errMsg=" + str + ",type=" + data.type + ",time=" + data.time);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOVideoResultApi
    public void addLocalAVRecordMsg(Contact peer, final LocalAVRecordElement data) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addLocalAVRecordMsg(peer, data, new IOperateCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ab
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AIOVideoResultApiImpl.addLocalAVRecordMsg$lambda$0(LocalAVRecordElement.this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOVideoResultApi
    public void onMessageClick(Context context, AIOMsgItem msgItem) {
        AVRecordElement aVRecordElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(21);
        if (firstTypeElement == null || (aVRecordElement = firstTypeElement.avRecordElement) == null) {
            return;
        }
        int i3 = aVRecordElement.type;
        if (i3 != 27 && i3 != 28) {
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    return;
            }
        }
        tu3.b.f437488a.c(context, msgItem, i3);
    }
}
