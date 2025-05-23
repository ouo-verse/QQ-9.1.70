package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ShareLocationElement;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u0000 \f2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0001H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/LocationShareMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "getViewType", "", "f1", "Landroid/content/Context;", "context", "", "Y0", "newMsgItem", "l", "Lcom/tencent/aio/data/msglist/a;", "target", "Lkotlin/Pair;", "", "o", "", "getChangePayload", "g2", "W0", "Z", "j2", "()Z", "k2", "(Z)V", "isSharingLocation", "X0", "Lkotlin/Lazy;", "i2", "()Ljava/lang/String;", "msgText", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class LocationShareMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String Z0;

    /* renamed from: W0, reason: from kotlin metadata */
    private boolean isSharingLocation;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/LocationShareMsgItem$a;", "", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.LocationShareMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57189);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
            Z0 = "LocationShareMsgItem";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationShareMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
            return;
        }
        this.isSharingLocation = msgRecord.isOnlineMsg;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.aio.msg.LocationShareMsgItem$msgText$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationShareMsgItem.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                ShareLocationElement shareLocationElement;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MsgElement firstTypeElement = LocationShareMsgItem.this.getFirstTypeElement(28);
                if (firstTypeElement == null || (shareLocationElement = firstTypeElement.shareLocationElement) == null) {
                    return null;
                }
                return shareLocationElement.text;
            }
        });
        this.msgText = lazy;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        } else {
            super.Y0(context);
            Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 5, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new LocationShareMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        try {
            if (isSelf()) {
                return HardCodeUtil.qqStr(R.string.ypb) + i2();
            }
            CharSequence x16 = x();
            return ((Object) x16) + i2();
        } catch (Exception unused) {
            QLog.e(Z0, 1, "content desc error");
            return "";
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        Object changePayload = super.getChangePayload(target);
        try {
            if (changePayload instanceof Map) {
                hashMap.putAll((Map) changePayload);
            }
        } catch (Exception e16) {
            QLog.e(Z0, 1, e16, new Object[0]);
            if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                throw e16;
            }
        }
        if (!(target instanceof LocationShareMsgItem)) {
            QLog.i(Z0, 1, "getChangePayload  target is not LocationShareItem, " + target);
            return hashMap;
        }
        if (((LocationShareMsgItem) target).isSharingLocation != this.isSharingLocation) {
            hashMap.put(AIOMsgItemPayloadType.LOCATION_SHARE_PAYLOAD, a.v.f192675a);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 77;
        }
        return 78;
    }

    @Nullable
    public final String i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (String) this.msgText.getValue();
    }

    public final boolean j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isSharingLocation;
    }

    public final void k2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isSharingLocation = z16;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        LocationShareMsgItem locationShareMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        if (newMsgItem instanceof LocationShareMsgItem) {
            locationShareMsgItem = (LocationShareMsgItem) newMsgItem;
        } else {
            locationShareMsgItem = null;
        }
        if (locationShareMsgItem != null) {
            locationShareMsgItem.isSharingLocation = this.isSharingLocation;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Pair) iPatchRedirector.redirect((short) 10, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if ((target instanceof LocationShareMsgItem) && ((LocationShareMsgItem) target).isSharingLocation != this.isSharingLocation) {
            return new Pair<>(Boolean.FALSE, "isSharingLocation");
        }
        return super.o(target);
    }
}
