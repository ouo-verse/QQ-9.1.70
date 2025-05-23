package com.tencent.qqnt.chathistory.service;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J@\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fJ8\u0010\u0016\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fJ(\u0010\u001a\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\nJB\u0010\u001e\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cJ:\u0010\u001f\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\nJB\u0010#\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\nJ\u001d\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/chathistory/service/a;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "k", "Landroid/os/Bundle;", "c", "Landroid/content/Context;", "context", "", "chatType", "", "peerId", "nickName", "", "navigateMsgId", "navigateMsgSeq", "peerUin", "", "d", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "f", "Landroid/view/View;", "anchorView", "source", h.F, "aioRichMediaList", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picElement", "i", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "view", "a", "uin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final a f353327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "uinInfo", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.chathistory.service.a$a */
    /* loaded from: classes23.dex */
    public static final class C9521a implements IKernelGetUidInfoCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ Continuation<String> f353328a;

        /* renamed from: b */
        final /* synthetic */ long f353329b;

        C9521a(Continuation<? super String> continuation, long j3) {
            this.f353328a = continuation;
            this.f353329b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, continuation, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
        public final void onResult(HashMap<Long, String> hashMap) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap);
                return;
            }
            Continuation<String> continuation = this.f353328a;
            Result.Companion companion = Result.INSTANCE;
            if (hashMap != null) {
                str = hashMap.get(Long.valueOf(this.f353329b));
            } else {
                str = null;
            }
            continuation.resumeWith(Result.m476constructorimpl(str));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31614);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f353327a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void b(a aVar, Context context, MsgRecord msgRecord, FileElement fileElement, View view, List list, int i3, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            i3 = 0;
        }
        aVar.a(context, msgRecord, fileElement, view, list, i3);
    }

    private final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putString("Key_Browser_Bundle", "AIOService");
        return bundle;
    }

    public static /* synthetic */ void e(a aVar, Context context, int i3, String str, String str2, long j3, long j16, long j17, int i16, Object obj) {
        long j18;
        if ((i16 & 64) != 0) {
            j18 = 0;
        } else {
            j18 = j17;
        }
        aVar.d(context, i3, str, str2, j3, j16, j18);
    }

    public static /* synthetic */ void g(a aVar, Context context, int i3, String str, String str2, long j3, long j16, int i16, Object obj) {
        long j17;
        if ((i16 & 32) != 0) {
            j17 = 0;
        } else {
            j17 = j16;
        }
        aVar.f(context, i3, str, str2, j3, j17);
    }

    private final List<MsgRecord> k(List<MsgRecord> list, MsgRecord msgRecord) {
        boolean z16;
        List<MsgRecord> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        int size = list.size();
        if (size <= 10) {
            return list;
        }
        int indexOf = list.indexOf(msgRecord);
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        int i3 = size - 1;
        intRef2.element = i3;
        com.tencent.qqnt.chathistory.util.d.f354054a.a("AIOService", "originalSize " + size + "  curIndex " + indexOf + " leftIndex " + intRef.element + " rightIndex " + i3);
        while (true) {
            if (intRef.element < indexOf && l(intRef2, intRef, 10)) {
                intRef.element++;
                if (!l(intRef2, intRef, 10)) {
                    break;
                }
            }
            if (intRef2.element > indexOf && l(intRef2, intRef, 10)) {
                intRef2.element--;
                if (!l(intRef2, intRef, 10)) {
                    break;
                }
            }
        }
        List<MsgRecord> subList = list.subList(intRef.element, intRef2.element + 1);
        com.tencent.qqnt.chathistory.util.d.f354054a.a("AIOService", "fixResult " + subList.size() + " leftIndex " + intRef.element + "  rightIndex " + intRef2.element);
        return subList;
    }

    private static final boolean l(Ref.IntRef intRef, Ref.IntRef intRef2, int i3) {
        if ((intRef.element - intRef2.element) + 1 > i3) {
            return true;
        }
        return false;
    }

    public final void a(@NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable FileElement fileElement, @NotNull View view, @Nullable List<MsgRecord> aioRichMediaList, int source) {
        ArrayList arrayList;
        List<MsgRecord> k3;
        int collectionSizeOrDefault;
        ArrayList arrayList2;
        int collectionSizeOrDefault2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, msgRecord, fileElement, view, aioRichMediaList, Integer.valueOf(source));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(view, "view");
        if (fileElement == null) {
            q.e(FrameworkVM.TAG, "no elements in msg record");
            return;
        }
        if (com.tencent.qqnt.aio.element.file.util.a.f(fileElement) && !FileUtils.fileExistsAndNotEmpty(fileElement.filePath)) {
            String string = MobileQQ.sMobileQQ.getString(R.string.yqs);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(com.\u2026string.aio_file_overtime)");
            QQToast.makeText(context, 1, string, 1).show();
            return;
        }
        if (!com.tencent.qqnt.aio.element.file.util.a.g(fileElement)) {
            String string2 = MobileQQ.sMobileQQ.getString(R.string.yqr);
            Intrinsics.checkNotNullExpressionValue(string2, "sMobileQQ.getString(com.\u2026.string.aio_file_invalid)");
            QQToast.makeText(context, 1, string2, 1).show();
            return;
        }
        int d16 = com.tencent.qqnt.aio.element.file.util.a.d(fileElement);
        if (d16 != 0) {
            if (d16 != 2) {
                IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
                iRichMediaBrowserApi.enterFileBrowser(peekAppRuntime, context, new AIOMsgItem(msgRecord), source);
                return;
            }
            IRichMediaBrowserApi iRichMediaBrowserApi2 = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime2, "sMobileQQ.peekAppRuntime()");
            AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
            Bundle c16 = c();
            c16.putInt("key_source", source);
            Unit unit = Unit.INSTANCE;
            List<MsgRecord> k16 = k(aioRichMediaList, msgRecord);
            if (k16 != null) {
                List<MsgRecord> list = k16;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList3.add(new AIOMsgItem((MsgRecord) it.next()));
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = null;
            }
            iRichMediaBrowserApi2.enterVideoPreview(peekAppRuntime2, context, null, aIOMsgItem, 0L, false, false, c16, arrayList2);
            return;
        }
        if (fileElement.picThumbPath.isEmpty()) {
            String string3 = MobileQQ.sMobileQQ.getString(R.string.yqs);
            Intrinsics.checkNotNullExpressionValue(string3, "sMobileQQ.getString(com.\u2026string.aio_file_overtime)");
            QQToast.makeText(context, 1, string3, 1).show();
            return;
        }
        IRichMediaBrowserApi iRichMediaBrowserApi3 = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime3, "sMobileQQ.peekAppRuntime()");
        AIOMsgItem aIOMsgItem2 = new AIOMsgItem(msgRecord);
        Bundle c17 = c();
        c17.putInt("key_source", source);
        Unit unit2 = Unit.INSTANCE;
        if (aioRichMediaList != null && (k3 = k(aioRichMediaList, msgRecord)) != null) {
            List<MsgRecord> list2 = k3;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList4.add(new AIOMsgItem((MsgRecord) it5.next()));
            }
            arrayList = arrayList4;
        } else {
            arrayList = null;
        }
        IRichMediaBrowserApi.a.a(iRichMediaBrowserApi3, peekAppRuntime3, context, view, aIOMsgItem2, null, false, c17, arrayList, false, 256, null);
    }

    public final void d(@NotNull Context context, int chatType, @NotNull String peerId, @NotNull String nickName, long navigateMsgId, long navigateMsgSeq, long peerUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(chatType), peerId, nickName, Long.valueOf(navigateMsgId), Long.valueOf(navigateMsgSeq), Long.valueOf(peerUin));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        com.tencent.qqnt.chathistory.util.d.f354054a.a("AIOService", " chatType " + chatType + " peerId " + peerId + "  nickName" + nickName + " navigateMsgId " + navigateMsgId + "  navigateMsgSeq " + navigateMsgSeq);
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
        Bundle bundle = new Bundle();
        bundle.putLong("key_navigate_msgid", navigateMsgId);
        bundle.putLong("key_navigate_msgseq", navigateMsgSeq);
        bundle.putString("key_from", "13");
        bundle.putBoolean("key_ignore_pre_scale_chat", true);
        Unit unit = Unit.INSTANCE;
        iAIOStarterApi.navigateToAIOActivity(context, chatType, peerId, nickName, peerUin, bundle);
    }

    public final void f(@NotNull Context context, int chatType, @NotNull String peerId, @NotNull String nickName, long r152, long peerUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(chatType), peerId, nickName, Long.valueOf(r152), Long.valueOf(peerUin));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        com.tencent.qqnt.chathistory.util.d.f354054a.a("AIOService", " chatType " + chatType + " peerId " + peerId + "  nickName" + nickName + " timeStamp " + r152 + "  nickName " + nickName);
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
        Bundle bundle = new Bundle();
        bundle.putLong("key_navigate_time", r152);
        bundle.putString("key_from", "13");
        bundle.putBoolean("key_ignore_pre_scale_chat", true);
        Unit unit = Unit.INSTANCE;
        iAIOStarterApi.navigateToAIOActivity(context, chatType, peerId, nickName, peerUin, bundle);
    }

    public final void h(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull View anchorView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, msgRecord, anchorView, Integer.valueOf(i3));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        AppRuntime appRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        Bundle c16 = c();
        c16.putInt("key_source", i3);
        c16.putBoolean("key_jump_form_history", true);
        Unit unit = Unit.INSTANCE;
        iRichMediaBrowserApi.enterAIOEmotionPreview(appRuntime, context, aIOMsgItem, anchorView, c16);
    }

    public final void i(@NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable List<MsgRecord> aioRichMediaList, @NotNull View anchorView, int source, @NotNull MsgElement picElement) {
        ArrayList arrayList;
        List<MsgRecord> k3;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, msgRecord, aioRichMediaList, anchorView, Integer.valueOf(source), picElement);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(picElement, "picElement");
        AppRuntime appRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        if (aioRichMediaList != null && (k3 = k(aioRichMediaList, msgRecord)) != null) {
            List<MsgRecord> list = k3;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new AIOMsgItem((MsgRecord) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Bundle c16 = c();
        c16.putInt("key_source", source);
        c16.putBoolean("key_jump_form_history", true);
        Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
        IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, appRuntime, context, anchorView, aIOMsgItem, picElement, false, c16, arrayList, false, 256, null);
    }

    public final void j(@NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable List<MsgRecord> aioRichMediaList, @NotNull View anchorView, int source) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, msgRecord, aioRichMediaList, anchorView, Integer.valueOf(source));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        AppRuntime appRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        List<MsgRecord> k3 = k(aioRichMediaList, msgRecord);
        if (k3 != null) {
            List<MsgRecord> list = k3;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new AIOMsgItem((MsgRecord) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Bundle c16 = c();
        c16.putInt("key_source", source);
        c16.putBoolean("key_jump_form_history", true);
        Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
        iRichMediaBrowserApi.enterVideoPreview(appRuntime, context, anchorView, aIOMsgItem, 0L, false, false, c16, arrayList);
    }

    @Nullable
    public final Object m(long j3, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Unit unit;
        Object coroutine_suspended;
        IKernelService iKernelService;
        ag uixConvertService;
        HashSet<Long> hashSetOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (uixConvertService = iKernelService.getUixConvertService()) != null) {
                hashSetOf = SetsKt__SetsKt.hashSetOf(Boxing.boxLong(j3));
                uixConvertService.getUid(hashSetOf, new C9521a(safeContinuation, j3));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                safeContinuation.resumeWith(Result.m476constructorimpl(null));
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), continuation);
    }
}
