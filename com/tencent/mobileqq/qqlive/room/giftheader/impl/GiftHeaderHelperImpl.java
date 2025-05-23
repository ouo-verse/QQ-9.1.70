package com.tencent.mobileqq.qqlive.room.giftheader.impl;

import ai4.GiftReceiver;
import android.content.Context;
import android.view.View;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.giftheader.IGiftHeaderHelper;
import com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.GiftReceiverPersonsBar;
import com.tencent.now.od.ui.gift.ODGiftPersonsBar;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import on3.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pi2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/giftheader/impl/GiftHeaderHelperImpl;", "Lcom/tencent/mobileqq/qqlive/room/giftheader/IGiftHeaderHelper;", "Landroid/content/Context;", "context", "", "roomType", "Lpi2/a;", "getGiftHeader", "", "roomId", "Lpi2/b;", "callback", "", "setHostSelectedChangeCallback", "<init>", "()V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GiftHeaderHelperImpl implements IGiftHeaderHelper {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0011\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/giftheader/impl/GiftHeaderHelperImpl$a;", "Lpi2/a;", "", "roomId", "", "roomType", "g", "Lcom/tencent/now/od/ui/gift/a;", "f", "Landroid/view/View;", "getView", "Lpi2/b;", "callback", "", "a", "uid", "b", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "I", "mRoomType", "c", "Lcom/tencent/now/od/ui/gift/a;", "giftPersonsBar", "d", "Lpi2/b;", "seatSelectedChangeCallback", "context", "<init>", "(Landroid/content/Context;I)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements pi2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context mContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int mRoomType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.now.od.ui.gift.a giftPersonsBar;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private b seatSelectedChangeCallback;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqlive/room/giftheader/impl/GiftHeaderHelperImpl$a$a", "Lcom/tencent/now/od/ui/gift/b;", "", "uin", "", "nickName", "headUrl", "", "seatType", "startSeq", "", "a", "closeGiftPanel", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqlive.room.giftheader.impl.GiftHeaderHelperImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static final class C8371a implements com.tencent.now.od.ui.gift.b {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f271597b;

            C8371a(long j3) {
                this.f271597b = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, Long.valueOf(j3));
                }
            }

            @Override // com.tencent.now.od.ui.gift.b
            public void a(long uin, @NotNull String nickName, @NotNull String headUrl, int seatType, long startSeq) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Long.valueOf(uin), nickName, headUrl, Integer.valueOf(seatType), Long.valueOf(startSeq));
                    return;
                }
                Intrinsics.checkNotNullParameter(nickName, "nickName");
                Intrinsics.checkNotNullParameter(headUrl, "headUrl");
                HashMap<String, String> hashMap = new HashMap<>();
                a aVar = a.this;
                long j3 = this.f271597b;
                if (2 != aVar.mRoomType) {
                    long g16 = aVar.g(j3, aVar.mRoomType);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(g16);
                    hashMap.put("MikeAnchorUID", sb5.toString());
                } else {
                    y35.a aVar2 = new y35.a();
                    aVar2.f449317a = seatType;
                    aVar2.f449318b = startSeq;
                    Unit unit = Unit.INSTANCE;
                    hashMap.put("voiceGiftTransParam", PluginBaseInfoHelper.Base64Helper.encodeToString(MessageNano.toByteArray(aVar2), 0));
                    long g17 = aVar.g(j3, aVar.mRoomType);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(g17);
                    hashMap.put("AnchorUID", sb6.toString());
                }
                b bVar = a.this.seatSelectedChangeCallback;
                if (bVar != null) {
                    bVar.a(uin, nickName, headUrl, hashMap);
                }
            }

            @Override // com.tencent.now.od.ui.gift.b
            public void closeGiftPanel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    b bVar = a.this.seatSelectedChangeCallback;
                    if (bVar != null) {
                        bVar.closeGiftPanel();
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        public a(@NotNull Context context, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
                return;
            }
            this.mContext = context;
            this.mRoomType = i3;
            this.giftPersonsBar = f();
        }

        private final com.tencent.now.od.ui.gift.a f() {
            if (2 == this.mRoomType) {
                return new ODGiftPersonsBar(this.mContext);
            }
            return new GiftReceiverPersonsBar(this.mContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long g(long roomId, int roomType) {
            if (2 == roomType) {
                on3.b b16 = com.tencent.mobileqq.qqlive.room.od.component.a.f271851a.b(roomId);
                if (b16 != null) {
                    b16.a();
                }
                c a16 = on3.a.a(null);
                if (a16 == null) {
                    return 0L;
                }
                return a16.h();
            }
            GiftReceiver e16 = ai4.c.f26122a.e();
            if (e16 == null) {
                return 0L;
            }
            return e16.getUid();
        }

        @Override // pi2.a
        public void a(@NotNull b callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
            } else {
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.seatSelectedChangeCallback = callback;
            }
        }

        @Override // pi2.a
        public void b(long roomId, long uid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(roomId), Long.valueOf(uid));
                return;
            }
            if (2 == this.mRoomType) {
                on3.b b16 = com.tencent.mobileqq.qqlive.room.od.component.a.f271851a.b(roomId);
                if (b16 != null) {
                    com.tencent.now.od.ui.gift.a aVar = this.giftPersonsBar;
                    Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.now.od.ui.gift.ODGiftPersonsBar");
                    ((ODGiftPersonsBar) aVar).setData(b16);
                }
            } else {
                List<GiftReceiver> f16 = ai4.c.f26122a.f();
                if (f16 != null) {
                    com.tencent.now.od.ui.gift.a aVar2 = this.giftPersonsBar;
                    Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.room.giftheader.personsbar.view.GiftReceiverPersonsBar");
                    ((GiftReceiverPersonsBar) aVar2).setData(f16);
                }
            }
            this.giftPersonsBar.setUserSelectedCallback(new C8371a(roomId));
            this.giftPersonsBar.t0(roomId, uid);
        }

        @Override // pi2.a
        @NotNull
        public View getView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.giftPersonsBar.getView();
        }
    }

    public GiftHeaderHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.giftheader.IGiftHeaderHelper
    @Nullable
    public pi2.a getGiftHeader(@NotNull Context context, int roomType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (pi2.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, roomType);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (2 != roomType && (roomType != 0 || !(!ai4.c.f26122a.f().isEmpty()))) {
            return null;
        }
        return new a(context, roomType);
    }

    @Override // com.tencent.mobileqq.qqlive.room.giftheader.IGiftHeaderHelper
    public void setHostSelectedChangeCallback(long roomId, int roomType, @NotNull b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), Integer.valueOf(roomType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        GiftReceiver e16 = ai4.c.f26122a.e();
        if (roomType == 0 && e16 != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            long uid = e16.getUid();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(uid);
            hashMap.put("MikeAnchorUID", sb5.toString());
            callback.a(e16.getUid(), e16.getName(), e16.getAvatar(), hashMap);
        }
    }
}
