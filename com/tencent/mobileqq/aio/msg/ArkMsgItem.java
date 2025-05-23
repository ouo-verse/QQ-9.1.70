package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IArkApi;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b#\b\u0016\u0018\u0000 92\u00020\u0001:\u0002:;B\u000f\u0012\u0006\u00106\u001a\u00020\u0010\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0001H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016R$\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010,\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00105\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b4\u0010)\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ArkMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "o2", "q2", "p2", "", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "m2", "Landroid/content/Context;", "context", "", "Y0", "Lcom/tencent/qqnt/msg/data/a;", "t2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "newMsgItem", "l", "getViewType", "d2", ICustomDataEditor.STRING_PARAM_2, "r2", "", "f1", "W0", "Lcom/tencent/qqnt/msg/data/a;", "l2", "()Lcom/tencent/qqnt/msg/data/a;", "setArkMsgModel", "(Lcom/tencent/qqnt/msg/data/a;)V", "arkMsgModel", "X0", "Lkotlin/Lazy;", "j2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "arkElement", "Ljava/lang/String;", "i2", "()Ljava/lang/String;", "u2", "(Ljava/lang/String;)V", "arkAppVersion", "Z0", "Z", ICustomDataEditor.NUMBER_PARAM_2, "()Z", "v2", "(Z)V", "isFromShot", "k2", "arkJsonString", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", ICustomDataEditor.STRING_ARRAY_PARAM_1, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class ArkMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.msg.data.a arkMsgModel;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy arkElement;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    private String arkAppVersion;

    /* renamed from: Z0, reason: from kotlin metadata */
    private boolean isFromShot;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ArkMsgItem$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.ArkMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ArkMsgItem$b;", "", "", "a", "", "b", "Z", "inited", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f190021a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static boolean inited;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57141);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f190021a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (inited) {
                    return;
                }
                inited = true;
                StopWatch i3 = new StopWatch("ArkMsgItem.initArkSdk", QLog.isColorLevel()).i();
                ((IArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IArkApi.class)).initArkEnv();
                i3.b("init ark env");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57143);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArkMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.aio.msg.ArkMsgItem$arkElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ArkMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final MsgElement invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? ArkMsgItem.this.m2(10) : (MsgElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.arkElement = lazy;
            this.arkAppVersion = "";
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
    }

    private final MsgElement j2() {
        return (MsgElement) this.arkElement.getValue();
    }

    private final boolean o2() {
        if ((getMsgRecord().chatType != 103 || isSelf()) && getMsgRecord().chatType != 106 && getMsgRecord().chatType != 114 && !p2() && getMsgRecord().chatType != 118 && getMsgRecord().chatType != 201) {
            return false;
        }
        return true;
    }

    private final boolean p2() {
        Integer num;
        int intValue;
        ArkElement arkElement;
        if (getMsgRecord().chatType == 105) {
            Iterator<MsgElement> it = getMsgRecord().elements.iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                if (next != null && (arkElement = next.arkElement) != null) {
                    num = arkElement.subElementType;
                } else {
                    num = null;
                }
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                if (intValue >= 1000) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean q2() {
        com.tencent.qqnt.msg.data.a aVar;
        if (getMsgRecord().chatType == 104 && (aVar = this.arkMsgModel) != null) {
            return Intrinsics.areEqual(aVar.b(), ((IStrangerAssistantAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAssistantAdapterApi.class)).getMiniCardAppId());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        if (context != null) {
            b.f190021a.a();
        }
        t2();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 12, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new ArkMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean d2() {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        com.tencent.qqnt.msg.data.a t26 = t2();
        String str2 = null;
        if (t26 != null) {
            str = t26.d();
        } else {
            str = null;
        }
        if (t26 != null) {
            str2 = t26.f();
        }
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return ArkAppConfigMgr.getInstance().canCollect(str, str2);
        }
        if (str == null || !a81.e.INSTANCE.i().contains(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        String n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        com.tencent.qqnt.msg.data.a aVar = this.arkMsgModel;
        if (aVar == null || aVar == null || (n3 = aVar.n()) == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (MsgExtKt.S(getMsgRecord())) {
            sb5.append(HardCodeUtil.qqStr(R.string.ypb));
            sb5.append(HardCodeUtil.qqStr(R.string.ypd));
        } else {
            sb5.append(x().toString());
            sb5.append(HardCodeUtil.qqStr(R.string.ypc));
        }
        sb5.append(n3);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "contentDesc.toString()");
        return sb6;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (getMsgRecord().msgType == 11) {
            if (q2()) {
                return 98;
            }
            if (o2()) {
                return 69;
            }
            if (isSelf()) {
                return 34;
            }
            return 35;
        }
        return super.getViewType();
    }

    @NotNull
    public final String i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.arkAppVersion;
    }

    @NotNull
    public final String k2() {
        String str;
        ArkElement arkElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        MsgElement j26 = j2();
        if (j26 != null && (arkElement = j26.arkElement) != null) {
            str = arkElement.bytesData;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        ((ArkMsgItem) newMsgItem).arkMsgModel = this.arkMsgModel;
    }

    @Nullable
    public final com.tencent.qqnt.msg.data.a l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.msg.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.arkMsgModel;
    }

    @Nullable
    public MsgElement m2(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MsgElement) iPatchRedirector.redirect((short) 9, (Object) this, type);
        }
        ArrayList<MsgElement> arrayList = getMsgRecord().elements;
        if (arrayList.isEmpty()) {
            QLog.i("ArkMsgItem", 1, "getLastTypeElement elements is empty");
            return null;
        }
        int size = arrayList.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                MsgElement msgElement = arrayList.get(size);
                boolean z16 = false;
                if (msgElement != null && msgElement.elementType == type) {
                    z16 = true;
                }
                if (z16) {
                    return msgElement;
                }
                if (i3 < 0) {
                    break;
                }
                size = i3;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArkMsgItem", 1, "getLastTypeElement not found the last ark msg");
        }
        return null;
    }

    public final boolean n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isFromShot;
    }

    public final boolean r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return a81.e.INSTANCE.m(t2(), this);
    }

    public final boolean s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return a81.e.INSTANCE.p(t2(), this);
    }

    @Nullable
    public final com.tencent.qqnt.msg.data.a t2() {
        String str;
        boolean z16;
        ArkElement arkElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.qqnt.msg.data.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        com.tencent.qqnt.msg.data.a aVar = this.arkMsgModel;
        if (aVar != null) {
            return aVar;
        }
        MsgElement j26 = j2();
        if (j26 != null && (arkElement = j26.arkElement) != null) {
            str = arkElement.bytesData;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        com.tencent.qqnt.msg.data.a aVar2 = new com.tencent.qqnt.msg.data.a();
        if (aVar2.o(k2())) {
            this.arkMsgModel = aVar2;
        } else {
            QLog.i("ArkMsgItem", 1, "[parseArkModel] parse ark model failed, msgId=" + getMsgId() + " content=" + k2());
        }
        com.tencent.mobileqq.aio.utils.k.f194164a.a(this, this.arkMsgModel);
        return this.arkMsgModel;
    }

    public final void u2(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.arkAppVersion = str;
        }
    }

    public final void v2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.isFromShot = z16;
        }
    }
}
