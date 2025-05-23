package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.os.Looper;
import com.qzone.business.favorite.protocol.QzoneAddFavorRequest;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.fav.NtMultiFavUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082\bJ\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOFavApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOFavApi;", "Lkotlin/Function0;", "", "block", "runOnSubThread", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "selectedText", QzoneAddFavorRequest.CMD_STRING, "", TabPreloadItem.TAB_NAME_MESSAGE, "multiFav", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOFavApiImpl implements IAIOFavApi {
    public static final String TAG = "AIOFavApiImpl";

    private final void runOnSubThread(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOFavApiImpl$runOnSubThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    block.invoke();
                }
            }, 32, null, true);
        } else {
            block.invoke();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFavApi
    public void addFav(final Context context, final AIOMsgItem msgItem, final CharSequence selectedText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOFavApiImpl$addFav$$inlined$runOnSubThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime instanceof QQAppInterface) {
                        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
                        String account = qQAppInterface.getAccount();
                        if (!(account == null || account.length() == 0)) {
                            QLog.i(AIOFavApiImpl.TAG, 1, "addFav msgType=" + AIOMsgItem.this.getMsgRecord().msgType);
                            com.tencent.qqnt.aio.fav.d a16 = com.tencent.qqnt.aio.fav.e.f349924a.a(AIOMsgItem.this.getMsgRecord().msgType);
                            if (a16 != null) {
                                a16.a(qQAppInterface, context, AIOMsgItem.this, selectedText);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(AIOFavApiImpl.TAG, 1, "addFav error, account is null");
                }
            }, 32, null, true);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            String account = qQAppInterface.getAccount();
            if (!(account == null || account.length() == 0)) {
                QLog.i(TAG, 1, "addFav msgType=" + msgItem.getMsgRecord().msgType);
                com.tencent.qqnt.aio.fav.d a16 = com.tencent.qqnt.aio.fav.e.f349924a.a(msgItem.getMsgRecord().msgType);
                if (a16 != null) {
                    a16.a(qQAppInterface, context, msgItem, selectedText);
                    return;
                }
                return;
            }
        }
        QLog.e(TAG, 1, "addFav error, account is null");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFavApi
    public void multiFav(final Context context, final List<? extends AIOMsgItem> msgList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOFavApiImpl$multiFav$$inlined$runOnSubThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.i(AIOFavApiImpl.TAG, 1, "multi fav");
                    NtMultiFavUtils.f349920a.m(context, msgList);
                }
            }, 32, null, true);
        } else {
            QLog.i(TAG, 1, "multi fav");
            NtMultiFavUtils.f349920a.m(context, msgList);
        }
    }
}
