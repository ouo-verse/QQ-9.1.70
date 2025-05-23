package com.tencent.qqnt.aio.forward.api.impl;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.forward.api.IForwardAIOApi;
import com.tencent.qqnt.forwardaio.e;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.msg.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J:\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R0\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/aio/forward/api/impl/ForwardAIOApiImpl;", "Lcom/tencent/qqnt/aio/forward/api/IForwardAIOApi;", "Landroid/view/View;", "view", "Lav3/a;", "findOnBackListener", "", "ensureId", "", "peerId", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "convertUid2UinAtStart", "", "uin", "putUinToBundle", ParseCommon.CONTAINER, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "chatType", "nick", "Landroid/os/Bundle;", "extras", "", "startAIO", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "listener", "setOnBackListener", "removeOnBackListener", "dispatchOnBack", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onBackListenerMap", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ForwardAIOApiImpl implements IForwardAIOApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "ForwardAIOApiImpl";

    @NotNull
    private final HashMap<View, av3.a> onBackListenerMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/forward/api/impl/ForwardAIOApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.forward.api.impl.ForwardAIOApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/forward/api/impl/ForwardAIOApiImpl$b", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ us.a f349956a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f349957b;

        b(us.a aVar, View view) {
            this.f349956a = aVar;
            this.f349957b = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) view);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            int i3 = data.getInt("BG_ID", R.drawable.skin_mni_aio_bg_2);
            us.a aVar = this.f349956a;
            Drawable drawable = this.f349957b.getResources().getDrawable(i3);
            Intrinsics.checkNotNullExpressionValue(drawable, "container.resources.getDrawable(resId)");
            aVar.k(drawable);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ForwardAIOApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.onBackListenerMap = new HashMap<>();
        }
    }

    private final void convertUid2UinAtStart(final String peerId, final AIOParam aioParam) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(peerId);
        ag j3 = f.j();
        if (j3 != null) {
            j3.getUin(hashSet, new IKernelGetUinInfoCallback() { // from class: com.tencent.qqnt.aio.forward.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                public final void onResult(HashMap hashMap) {
                    ForwardAIOApiImpl.convertUid2UinAtStart$lambda$4(peerId, this, aioParam, hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convertUid2UinAtStart$lambda$4(String peerId, ForwardAIOApiImpl this$0, AIOParam aioParam, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(peerId, "$peerId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        QLog.i(TAG, 1, "[addUinToBundle]: convertUin result is " + hashMap.get(peerId));
        Long l3 = (Long) hashMap.get(peerId);
        if (l3 != null) {
            this$0.putUinToBundle(l3.longValue(), aioParam);
        }
    }

    private final void ensureId(View view) {
        if (view.getId() == -1) {
            view.setId(R.id.f165270ve0);
        }
    }

    private final av3.a findOnBackListener(View view) {
        boolean z16;
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        if (this.onBackListenerMap.isEmpty()) {
            return null;
        }
        for (Map.Entry<View, av3.a> entry : this.onBackListenerMap.entrySet()) {
            if (entry.getKey().findViewById(view.getId()) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return entry.getValue();
            }
        }
        return null;
    }

    private final void putUinToBundle(final long uin, final AIOParam aioParam) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.forward.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardAIOApiImpl.putUinToBundle$lambda$5(AIOParam.this, uin);
                }
            });
        } else {
            aioParam.l().putLong("key_peerUin", uin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void putUinToBundle$lambda$5(AIOParam aioParam, long j3) {
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        aioParam.l().putLong("key_peerUin", j3);
    }

    @Override // com.tencent.qqnt.aio.forward.api.IForwardAIOApi
    public boolean dispatchOnBack(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        av3.a findOnBackListener = findOnBackListener(view);
        if (findOnBackListener != null) {
            return findOnBackListener.a(view);
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.forward.api.IForwardAIOApi
    public void removeOnBackListener(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (this.onBackListenerMap.containsKey(rootView)) {
            this.onBackListenerMap.remove(rootView);
        }
    }

    @Override // com.tencent.qqnt.aio.forward.api.IForwardAIOApi
    public void setOnBackListener(@NotNull View rootView, @NotNull av3.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onBackListenerMap.put(rootView, listener);
    }

    @Override // com.tencent.qqnt.aio.forward.api.IForwardAIOApi
    public boolean startAIO(@NotNull View container, @NotNull FragmentManager fragmentManager, int chatType, @NotNull String peerId, @NotNull String nick, @Nullable Bundle extras) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, container, fragmentManager, Integer.valueOf(chatType), peerId, nick, extras)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(nick, "nick");
        if (peerId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (nick.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                ensureId(container);
                AIOSession aIOSession = new AIOSession(new AIOContact(chatType, peerId, "", nick));
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_shield_item_touch", true);
                bundle.putBoolean("key_is_forward_aio", true);
                bundle.putInt("key_msg_head_padding", (int) container.getResources().getDimension(R.dimen.bzh));
                bundle.putBoolean("key_need_scale_aio", false);
                if (extras != null) {
                    bundle.putAll(extras);
                }
                String factoryName = e.class.getName();
                AIOParam.a i3 = new AIOParam.a().i(true);
                Intrinsics.checkNotNullExpressionValue(factoryName, "factoryName");
                AIOParam c16 = i3.e(factoryName).a(bundle).h(aIOSession).c();
                us.a c17 = com.tencent.aio.main.engine.b.f69377a.c(c16, fragmentManager, container.getId(), null);
                Drawable drawable = container.getResources().getDrawable(R.drawable.skin_mni_aio_bg_2);
                Intrinsics.checkNotNullExpressionValue(drawable, "container.resources.getD\u2026awable.skin_mni_aio_bg_2)");
                c17.k(drawable);
                c17.i("EVENT_UPDATE_BG", new b(c17, container));
                convertUid2UinAtStart(peerId, c16);
                return true;
            }
        }
        QLog.i(TAG, 2, "startAIO peerId: " + peerId + ", nick: " + nick);
        return false;
    }
}
