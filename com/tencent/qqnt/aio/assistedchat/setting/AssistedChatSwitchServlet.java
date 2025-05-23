package com.tencent.qqnt.aio.assistedchat.setting;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0012\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J0\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u001c\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0017\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/setting/AssistedChatSwitchServlet;", "Lmqq/app/MSFServlet;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", "switchList", "", "switchValue", "Lmqq/app/Packet;", "packet", "", "e", "", "uin", "d", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "Lcom/tencent/qqnt/aio/assistedchat/setting/f;", "observer", "c", "b", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "onSend", "onReceive", "Lyu3/c;", "Lkotlin/Lazy;", "a", "()Lyu3/c;", "reqWrapper", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AssistedChatSwitchServlet extends MSFServlet {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy reqWrapper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J$\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/setting/AssistedChatSwitchServlet$a;", "", "", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", "switchList", "", "switchValue", "Lcom/tencent/qqnt/aio/assistedchat/setting/f;", "observer", "", "b", "", "uin", "a", "KEY_REQ_TYPE", "Ljava/lang/String;", "KEY_SWITCH_LIST", "KEY_SWITCH_VALUE", "KEY_UIN", "REQ_TYPE_GET", "I", "REQ_TYPE_SET", "TAG", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.setting.AssistedChatSwitchServlet$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String uin, List<AssistedChatSwitch> switchList, f observer) {
            ArrayList<? extends Parcelable> arrayList;
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(switchList, "switchList");
            Intrinsics.checkNotNullParameter(observer, "observer");
            NewIntent newIntent = new NewIntent(BaseApplication.getContext(), AssistedChatSwitchServlet.class);
            newIntent.putExtra("reqType", 2);
            if (uin.length() == 0) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                uin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
                if (uin == null) {
                    uin = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(uin, "MobileQQ.sMobileQQ.peekA\u2026?.currentAccountUin ?: \"\"");
                }
            }
            newIntent.putExtra("uin", uin);
            if (switchList instanceof ArrayList) {
                arrayList = (ArrayList) switchList;
            } else {
                arrayList = new ArrayList<>(switchList);
            }
            newIntent.putParcelableArrayListExtra("switchList", arrayList);
            newIntent.setObserver(observer);
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 != null) {
                peekAppRuntime2.startServlet(newIntent);
            }
        }

        public final void b(List<AssistedChatSwitch> switchList, int switchValue, f observer) {
            ArrayList<? extends Parcelable> arrayList;
            Intrinsics.checkNotNullParameter(switchList, "switchList");
            NewIntent newIntent = new NewIntent(BaseApplication.getContext(), AssistedChatSwitchServlet.class);
            newIntent.putExtra("reqType", 1);
            if (switchList instanceof ArrayList) {
                arrayList = (ArrayList) switchList;
            } else {
                arrayList = new ArrayList<>(switchList);
            }
            newIntent.putParcelableArrayListExtra("switchList", arrayList);
            newIntent.putExtra("switchValue", switchValue);
            newIntent.setObserver(observer);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                peekAppRuntime.startServlet(newIntent);
            }
        }

        Companion() {
        }
    }

    public AssistedChatSwitchServlet() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<yu3.a>() { // from class: com.tencent.qqnt.aio.assistedchat.setting.AssistedChatSwitchServlet$reqWrapper$2
            @Override // kotlin.jvm.functions.Function0
            public final yu3.a invoke() {
                return new yu3.a();
            }
        });
        this.reqWrapper = lazy;
    }

    private final yu3.c a() {
        return (yu3.c) this.reqWrapper.getValue();
    }

    private final void b(String uin, List<AssistedChatSwitch> switchList, FromServiceMsg response, f observer) {
        if (!response.isSuccess()) {
            QLog.w("AssistedChatSwitchServlet", 1, "onReceiveGetSwitch " + response.getBusinessFailCode() + " " + response.getBusinessFailMsg());
        }
        List<com.tencent.qqnt.aio.assistedchat.model.d> c16 = a().c(uin, switchList, response);
        if (c16.isEmpty()) {
            QLog.w("AssistedChatSwitchServlet", 1, "switch item list is empty!!");
        }
        if (Intrinsics.areEqual(uin, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin())) {
            for (com.tencent.qqnt.aio.assistedchat.model.d dVar : c16) {
                e.f349447a.t(dVar.a(), dVar.c());
            }
        }
        QLog.d("AssistedChatSwitchServlet", 1, "onReceiveGetSwitch " + uin + " " + c16.size());
        if (observer != null) {
            observer.a(!c16.isEmpty(), c16);
        }
    }

    private final void c(List<AssistedChatSwitch> switchList, int switchValue, FromServiceMsg response, f observer) {
        QLog.d("AssistedChatSwitchServlet", 1, "onReceiveSetSwitch " + response.getBusinessFailCode() + " " + response.getBusinessFailMsg());
        boolean b16 = a().b(switchList, switchValue, response);
        if (!b16) {
            QLog.w("AssistedChatSwitchServlet", 1, "set switch fail, reset " + switchList + " to " + switchValue);
            Iterator<T> it = switchList.iterator();
            while (it.hasNext()) {
                e.f349447a.t((AssistedChatSwitch) it.next(), switchValue);
            }
        }
        if (observer != null) {
            observer.b(b16);
        }
    }

    private final void d(String uin, List<AssistedChatSwitch> switchList, Packet packet) {
        QLog.d("AssistedChatSwitchServlet", 1, "onSendGetSwitch " + uin + " " + switchList);
        a().d(uin, switchList, packet);
    }

    private final void e(List<AssistedChatSwitch> switchList, int switchValue, Packet packet) {
        QLog.d("AssistedChatSwitchServlet", 1, "onSendSetSwitch " + switchList + " switchValue:" + switchValue);
        a().a(switchList, switchValue, packet);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent request, FromServiceMsg response) {
        if (request != null && response != null) {
            ArrayList parcelableArrayListExtra = request.getParcelableArrayListExtra("switchList");
            if (!(parcelableArrayListExtra instanceof ArrayList)) {
                parcelableArrayListExtra = null;
            }
            if (parcelableArrayListExtra == null) {
                QLog.e("AssistedChatSwitchServlet", 1, "onReceive switchList is null");
                return;
            }
            NewIntent newIntent = request instanceof NewIntent ? (NewIntent) request : null;
            Object observer = newIntent != null ? newIntent.getObserver() : null;
            f fVar = observer instanceof f ? (f) observer : null;
            int intExtra = request.getIntExtra("reqType", 0);
            if (intExtra == 1) {
                c(parcelableArrayListExtra, request.getIntExtra("switchValue", 0), response, fVar);
                return;
            } else {
                if (intExtra != 2) {
                    return;
                }
                String stringExtra = request.getStringExtra("uin");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                b(stringExtra, parcelableArrayListExtra, response, fVar);
                return;
            }
        }
        QLog.e("AssistedChatSwitchServlet", 1, "onReceive request is null or response is null");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent request, Packet packet) {
        if (request != null && packet != null) {
            ArrayList parcelableArrayListExtra = request.getParcelableArrayListExtra("switchList");
            if (!(parcelableArrayListExtra instanceof ArrayList)) {
                parcelableArrayListExtra = null;
            }
            if (parcelableArrayListExtra == null) {
                QLog.e("AssistedChatSwitchServlet", 1, "onSend switchList is null");
                return;
            }
            int intExtra = request.getIntExtra("reqType", 0);
            if (intExtra == 1) {
                e(parcelableArrayListExtra, request.getIntExtra("switchValue", 0), packet);
                return;
            } else {
                if (intExtra != 2) {
                    return;
                }
                String stringExtra = request.getStringExtra("uin");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                d(stringExtra, parcelableArrayListExtra, packet);
                return;
            }
        }
        QLog.e("AssistedChatSwitchServlet", 1, "onSend request is null or packet is null");
    }
}
