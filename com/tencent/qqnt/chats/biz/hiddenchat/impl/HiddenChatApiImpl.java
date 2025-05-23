package com.tencent.qqnt.chats.biz.hiddenchat.impl;

import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateHiddenSessionCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentHiddenSesionInfo;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J \u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chats/biz/hiddenchat/impl/HiddenChatApiImpl;", "Lcom/tencent/qqnt/chats/biz/hiddenchat/IHiddenChatApi;", "", "uin", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/chats/data/d;", "Lkotlin/collections/ArrayList;", "hiddenChatList", "", "delHiddenChat", "uid", "", "unReadNumSwitch", "setShowUnReadNum", "Lcom/tencent/qqnt/chats/biz/hiddenchat/d;", "ntHiddenChatAsync", "", "unReadNum", "Landroid/widget/TextView;", "unReadMsg", "getShowUnReadNum", "setHiddenChat", "getAllHiddenChat", "TAG", "Ljava/lang/String;", "HIDDEN_LIST_TAG", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class HiddenChatApiImpl implements IHiddenChatApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String HIDDEN_LIST_TAG;

    @NotNull
    private final String TAG;

    public HiddenChatApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "HiddenChatApiImpl";
            this.HIDDEN_LIST_TAG = "hiddenChatStore";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delHiddenChat$lambda$2(HiddenChatApiImpl this$0, ArrayList hiddenChatListToNtList, String uin, int i3, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hiddenChatListToNtList, "$hiddenChatListToNtList");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        QLog.d(this$0.TAG, 1, "delRecentHiddenSession resultCode=" + i3 + ", errorMsg=" + str);
        if (i3 == 0) {
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026), QMMKVFile.FILE_COMMON)");
            Iterator it = hiddenChatListToNtList.iterator();
            while (it.hasNext()) {
                RecentHiddenSesionInfo recentHiddenSesionInfo = (RecentHiddenSesionInfo) it.next();
                if (recentHiddenSesionInfo.chatType == 1) {
                    str2 = this$0.HIDDEN_LIST_TAG + uin + recentHiddenSesionInfo.peerUin + "0";
                } else {
                    str2 = this$0.HIDDEN_LIST_TAG + uin + recentHiddenSesionInfo.peerUin + "1";
                }
                if (from.containsKey(str2)) {
                    from.removeKey(str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAllHiddenChat$lambda$8(HiddenChatApiImpl this$0, com.tencent.qqnt.chats.biz.hiddenchat.d ntHiddenChatAsync, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ntHiddenChatAsync, "$ntHiddenChatAsync");
        QLog.d(this$0.TAG, 1, "getAllHiddenChat resultCode = " + i3 + ", errorMsg = " + str);
        ntHiddenChatAsync.b(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getShowUnReadNum$lambda$4(HiddenChatApiImpl this$0, com.tencent.qqnt.chats.biz.hiddenchat.d ntHiddenChatAsync, int i3, TextView textView, int i16, String str, ArrayList arrayList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ntHiddenChatAsync, "$ntHiddenChatAsync");
        QLog.d(this$0.TAG, 1, "getShowUnReadNum resultCode = " + i16 + ", errorMsg = " + str);
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d(this$0.TAG, 1, "getShowUnReadNum sessionList is isNullOrEmpty");
            ntHiddenChatAsync.a(false, i3, textView);
        } else {
            if (arrayList.size() == 1) {
                QLog.d(this$0.TAG, 1, "getShowUnReadNum sessionList is normal");
                ntHiddenChatAsync.a(((RecentHiddenSesionInfo) arrayList.get(0)).isPushOnlineNotify, i3, textView);
                return;
            }
            QLog.d(this$0.TAG, 1, "getShowUnReadNum sessionList.size is not one, " + arrayList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHiddenChat$lambda$7(HiddenChatApiImpl this$0, ArrayList hiddenChatListToNtList, String uin, int i3, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hiddenChatListToNtList, "$hiddenChatListToNtList");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        QLog.d(this$0.TAG, 1, "setRecentHiddenSession resultCode=" + i3 + ", errorMsg=" + str);
        if (i3 == 0) {
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026), QMMKVFile.FILE_COMMON)");
            Iterator it = hiddenChatListToNtList.iterator();
            while (it.hasNext()) {
                RecentHiddenSesionInfo recentHiddenSesionInfo = (RecentHiddenSesionInfo) it.next();
                if (recentHiddenSesionInfo.chatType == 1) {
                    str2 = this$0.HIDDEN_LIST_TAG + uin + recentHiddenSesionInfo.peerUin + "0";
                } else {
                    str2 = this$0.HIDDEN_LIST_TAG + uin + recentHiddenSesionInfo.peerUin + "1";
                }
                if (!from.containsKey(str2)) {
                    from.encodeBool(str2, true);
                    QLog.d(this$0.TAG, 1, "setHiddenChat setMMKV noExist " + str2);
                } else {
                    QLog.d(this$0.TAG, 1, "setHiddenChat setMMKV Exist " + str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setShowUnReadNum$lambda$3(HiddenChatApiImpl this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 1, "setShowUnReadNum resultCode=" + i3 + ", errorMsg=" + str);
    }

    @Override // com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi
    public void delHiddenChat(@NotNull final String uin, @NotNull ArrayList<com.tencent.qqnt.chats.data.d> hiddenChatList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) hiddenChatList);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(hiddenChatList, "hiddenChatList");
        w e16 = f.e();
        if (e16 == null) {
            QLog.e(this.TAG, 1, "delHiddenChat kernelMsgService is null!");
            return;
        }
        final ArrayList<RecentHiddenSesionInfo> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.chats.data.d dVar : hiddenChatList) {
            arrayList.add(new RecentHiddenSesionInfo(dVar.c(), dVar.d(), dVar.a(), dVar.f(), dVar.h(), dVar.g(), dVar.b(), dVar.e()));
        }
        if (!arrayList.isEmpty()) {
            e16.delRecentHiddenSession(arrayList, new IOperateCallback() { // from class: com.tencent.qqnt.chats.biz.hiddenchat.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    HiddenChatApiImpl.delHiddenChat$lambda$2(HiddenChatApiImpl.this, arrayList, uin, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi
    public void getAllHiddenChat(@NotNull final com.tencent.qqnt.chats.biz.hiddenchat.d ntHiddenChatAsync) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) ntHiddenChatAsync);
            return;
        }
        Intrinsics.checkNotNullParameter(ntHiddenChatAsync, "ntHiddenChatAsync");
        w e16 = f.e();
        if (e16 == null) {
            QLog.e(this.TAG, 1, "getAllHiddenChat kernelMsgService is null!");
        } else {
            e16.getRecentHiddenSesionList(new IOperateHiddenSessionCallback() { // from class: com.tencent.qqnt.chats.biz.hiddenchat.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateHiddenSessionCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    HiddenChatApiImpl.getAllHiddenChat$lambda$8(HiddenChatApiImpl.this, ntHiddenChatAsync, i3, str, arrayList);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi
    public void getShowUnReadNum(@NotNull final com.tencent.qqnt.chats.biz.hiddenchat.d ntHiddenChatAsync, final int unReadNum, @Nullable final TextView unReadMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, ntHiddenChatAsync, Integer.valueOf(unReadNum), unReadMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(ntHiddenChatAsync, "ntHiddenChatAsync");
        w e16 = f.e();
        if (e16 == null) {
            QLog.e(this.TAG, 1, "getShowUnReadNum kernelMsgService is null!");
        } else {
            e16.getCurHiddenSession(new IOperateHiddenSessionCallback() { // from class: com.tencent.qqnt.chats.biz.hiddenchat.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateHiddenSessionCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    HiddenChatApiImpl.getShowUnReadNum$lambda$4(HiddenChatApiImpl.this, ntHiddenChatAsync, unReadNum, unReadMsg, i3, str, arrayList);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi
    public void setHiddenChat(@NotNull final String uin, @NotNull ArrayList<com.tencent.qqnt.chats.data.d> hiddenChatList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uin, (Object) hiddenChatList);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(hiddenChatList, "hiddenChatList");
        w e16 = f.e();
        if (e16 == null) {
            QLog.e(this.TAG, 1, "setHiddenChat kernelMsgService is null!");
            return;
        }
        final ArrayList<RecentHiddenSesionInfo> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.chats.data.d dVar : hiddenChatList) {
            arrayList.add(new RecentHiddenSesionInfo(dVar.c(), dVar.d(), dVar.a(), dVar.f(), dVar.h(), dVar.g(), dVar.b(), dVar.e()));
        }
        if (!arrayList.isEmpty()) {
            e16.setRecentHiddenSession(arrayList, new IOperateCallback() { // from class: com.tencent.qqnt.chats.biz.hiddenchat.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    HiddenChatApiImpl.setHiddenChat$lambda$7(HiddenChatApiImpl.this, arrayList, uin, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi
    public void setShowUnReadNum(@NotNull String uid, @NotNull String uin, boolean unReadNumSwitch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uid, uin, Boolean.valueOf(unReadNumSwitch));
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        w e16 = f.e();
        if (e16 == null) {
            QLog.e(this.TAG, 1, "setShowUnReadNum kernelMsgService is null!");
        } else {
            e16.setCurHiddenSession(new RecentHiddenSesionInfo(uid, uin, 1, true, unReadNumSwitch, false, 0L, 0L), new IOperateCallback() { // from class: com.tencent.qqnt.chats.biz.hiddenchat.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    HiddenChatApiImpl.setShowUnReadNum$lambda$3(HiddenChatApiImpl.this, i3, str);
                }
            });
        }
    }
}
