package com.tencent.mobileqq.qqshop.publicaccount.setting;

import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.proto.MsgSwitchPB$QuerySwitchReq;
import com.tencent.mobileqq.qqshop.proto.MsgSwitchPB$QuerySwitchRsp;
import com.tencent.mobileqq.qqshop.proto.MsgSwitchPB$SetSwitchReq;
import com.tencent.mobileqq.qqshop.proto.MsgSwitchPB$SetSwitchRsp;
import com.tencent.mobileqq.qqshop.proto.MsgSwitchPB$SwitchItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002JF\u0010\u000f\u001a\u00020\r2>\u0010\u000e\u001a:\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007J\u0014\u0010\u0010\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/setting/c;", "", "", "Lcom/tencent/mobileqq/qqshop/proto/MsgSwitchPB$SwitchItem;", "switchDataList", "Lcom/tencent/mobileqq/qqshop/publicaccount/setting/c$a;", "b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "switchItems", "", "receiver", "d", "c", "<init>", "()V", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f274649a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/setting/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "type", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "title", "tip", "d", "Z", "()Z", "e", "(Z)V", h.f248218g, "getReportFlag", "reportFlag", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tip;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isOpen;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String reportFlag;

        public a(int i3, @NotNull String title, @NotNull String tip, boolean z16, @NotNull String reportFlag) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(tip, "tip");
            Intrinsics.checkNotNullParameter(reportFlag, "reportFlag");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), title, tip, Boolean.valueOf(z16), reportFlag);
                return;
            }
            this.type = i3;
            this.title = title;
            this.tip = tip;
            this.isOpen = z16;
            this.reportFlag = reportFlag;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.tip;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.title;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.type;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.isOpen;
        }

        public final void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.isOpen = z16;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.type == aVar.type && Intrinsics.areEqual(this.title, aVar.title) && Intrinsics.areEqual(this.tip, aVar.tip) && this.isOpen == aVar.isOpen && Intrinsics.areEqual(this.reportFlag, aVar.reportFlag)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            int hashCode = ((((this.type * 31) + this.title.hashCode()) * 31) + this.tip.hashCode()) * 31;
            boolean z16 = this.isOpen;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.reportFlag.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "SwitchItem(type=" + this.type + ", title=" + this.title + ", tip=" + this.tip + ", isOpen=" + this.isOpen + ", reportFlag=" + this.reportFlag + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/setting/c$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qqshop/proto/MsgSwitchPB$SetSwitchRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements o<MsgSwitchPB$SetSwitchRsp> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull MsgSwitchPB$SetSwitchRsp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
            } else {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QLog.e("QQShopSettingViewModel", 1, "requestSetSwitch success");
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("QQShopSettingViewModel", 1, "requestSetSwitch onFail error " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/setting/c$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qqshop/proto/MsgSwitchPB$QuerySwitchRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.setting.c$c, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8428c implements o<MsgSwitchPB$QuerySwitchRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, List<a>, Unit> f274655a;

        /* JADX WARN: Multi-variable type inference failed */
        C8428c(Function2<? super Boolean, ? super List<a>, Unit> function2) {
            this.f274655a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull MsgSwitchPB$QuerySwitchRsp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Function2<Boolean, List<a>, Unit> function2 = this.f274655a;
            Boolean bool = Boolean.TRUE;
            c cVar = c.f274649a;
            List<MsgSwitchPB$SwitchItem> list = rsp.items.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.items.get()");
            function2.invoke(bool, cVar.b(list));
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f274655a.invoke(Boolean.FALSE, null);
            QLog.e("QQShopSettingViewModel", 1, "PublicOfficeConfig update PA conf error " + errMsg);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f274649a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<a> b(List<MsgSwitchPB$SwitchItem> switchDataList) {
        ArrayList arrayList = new ArrayList();
        for (MsgSwitchPB$SwitchItem msgSwitchPB$SwitchItem : switchDataList) {
            int i3 = msgSwitchPB$SwitchItem.switch_type.get();
            String str = msgSwitchPB$SwitchItem.title.get();
            Intrinsics.checkNotNullExpressionValue(str, "switchDataItem.title.get()");
            String str2 = msgSwitchPB$SwitchItem.tip.get();
            Intrinsics.checkNotNullExpressionValue(str2, "switchDataItem.tip.get()");
            boolean z16 = msgSwitchPB$SwitchItem.is_open.get();
            String str3 = msgSwitchPB$SwitchItem.report_flag.get();
            Intrinsics.checkNotNullExpressionValue(str3, "switchDataItem.report_flag.get()");
            arrayList.add(new a(i3, str, str2, z16, str3));
        }
        return arrayList;
    }

    public final void c(@NotNull List<a> switchItems) {
        PBRepeatField<Integer> pBRepeatField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) switchItems);
            return;
        }
        Intrinsics.checkNotNullParameter(switchItems, "switchItems");
        b bVar = new b();
        MsgSwitchPB$SetSwitchReq msgSwitchPB$SetSwitchReq = new MsgSwitchPB$SetSwitchReq();
        msgSwitchPB$SetSwitchReq.open_ids.set(new ArrayList());
        msgSwitchPB$SetSwitchReq.close_ids.set(new ArrayList());
        for (a aVar : switchItems) {
            if (aVar.d()) {
                pBRepeatField = msgSwitchPB$SetSwitchReq.open_ids;
            } else {
                pBRepeatField = msgSwitchPB$SetSwitchReq.close_ids;
            }
            pBRepeatField.add(Integer.valueOf(aVar.c()));
        }
        QRouteApi api = QRoute.api(IQWalletServletApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletServletApi::class.java)");
        IQWalletServletApi.a.a((IQWalletServletApi) api, "trpc.qqshop.officalplatform.Msgswitch", "SetSwitch", msgSwitchPB$SetSwitchReq, (MessageMicro) MsgSwitchPB$SetSwitchRsp.class.newInstance(), false, false, false, bVar, 112, null);
    }

    public final void d(@NotNull Function2<? super Boolean, ? super List<a>, Unit> receiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) receiver);
            return;
        }
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        C8428c c8428c = new C8428c(receiver);
        MessageMicro<MsgSwitchPB$QuerySwitchReq> messageMicro = new MessageMicro<MsgSwitchPB$QuerySwitchReq>() { // from class: com.tencent.mobileqq.qqshop.proto.MsgSwitchPB$QuerySwitchReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"special_query"}, new Object[]{0}, MsgSwitchPB$QuerySwitchReq.class);
            public final PBRepeatField<Integer> special_query = PBField.initRepeat(PBEnumField.__repeatHelper__);
        };
        QRouteApi api = QRoute.api(IQWalletServletApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletServletApi::class.java)");
        IQWalletServletApi.a.a((IQWalletServletApi) api, "trpc.qqshop.officalplatform.Msgswitch", "QuerySwitch", messageMicro, (MessageMicro) MsgSwitchPB$QuerySwitchRsp.class.newInstance(), false, false, false, c8428c, 112, null);
    }
}
