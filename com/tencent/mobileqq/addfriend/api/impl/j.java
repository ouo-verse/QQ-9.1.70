package com.tencent.mobileqq.addfriend.api.impl;

import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.addfriend.api.a;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.AccountInfo;
import com.tencent.qqnt.kernel.nativeinterface.AddBuddyReq;
import com.tencent.qqnt.kernel.nativeinterface.AddBuddyRsp;
import com.tencent.qqnt.kernel.nativeinterface.BuddyInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.BuddySettingReq;
import com.tencent.qqnt.kernel.nativeinterface.BuddySettingRsp;
import com.tencent.qqnt.kernel.nativeinterface.BuddyTagRsp;
import com.tencent.qqnt.kernel.nativeinterface.IAddBuddyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IBuddySettingCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetBuddyInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetBuddyTagCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSmartInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryUinSafetyFlagCallback;
import com.tencent.qqnt.kernel.nativeinterface.OpenidAccInfo;
import com.tencent.qqnt.kernel.nativeinterface.SmartReq;
import com.tencent.qqnt.kernel.nativeinterface.SmartRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/impl/j;", "Lcom/tencent/qqnt/remote/c;", "", "callFrom", "Lcom/tencent/qqnt/remote/d;", "toNTMsg", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "p", "k", "toNtMsg", "r", "t", "", "result", "errMsg", "", "rsp", "", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernel/api/f;", "o", "b", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/remote/b;", "response", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a", "Lcom/tencent/mobileqq/addfriend/api/impl/a;", "Lcom/tencent/mobileqq/addfriend/api/impl/a;", "mNTCoder", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class j implements com.tencent.qqnt.remote.c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile a mNTCoder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/impl/j$a;", "", "", "KEY_REQUEST_TIME", "Ljava/lang/String;", "SERVICE_ID", "TAG", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.api.impl.j$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20773);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mNTCoder = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(com.tencent.qqnt.remote.d toNtMsg, j this$0, String callFrom) {
        boolean z16;
        Intrinsics.checkNotNullParameter(toNtMsg, "$toNtMsg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callFrom, "$callFrom");
        String b16 = toNtMsg.b();
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendNTServiceImpl", 2, "sendToNTKernel: " + b16);
        }
        a.Companion companion = com.tencent.mobileqq.addfriend.api.a.INSTANCE;
        if (Intrinsics.areEqual(b16, companion.b())) {
            z16 = this$0.t(callFrom, toNtMsg);
        } else if (Intrinsics.areEqual(b16, companion.c())) {
            z16 = this$0.r(callFrom, toNtMsg);
        } else if (Intrinsics.areEqual(b16, companion.a())) {
            z16 = this$0.k(callFrom, toNtMsg);
        } else if (Intrinsics.areEqual(b16, companion.d())) {
            z16 = this$0.p(callFrom, toNtMsg);
        } else if (Intrinsics.areEqual(b16, companion.g())) {
            z16 = this$0.v(callFrom, toNtMsg);
        } else if (Intrinsics.areEqual(b16, companion.f())) {
            z16 = this$0.m(callFrom, toNtMsg);
        } else {
            z16 = false;
        }
        if (!z16) {
            this$0.z(toNtMsg, new com.tencent.qqnt.remote.b(companion.h(), companion.i(), toNtMsg.c(), toNtMsg.d(), toNtMsg.b()));
        }
    }

    private final boolean k(String callFrom, final com.tencent.qqnt.remote.d toNTMsg) {
        AddBuddyReq g16 = this.mNTCoder.g(toNTMsg);
        if (g16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendNTServiceImpl", 2, "addFriend req: " + g16);
            }
            toNTMsg.a().putLong("KEY_REQUEST_TIME", System.currentTimeMillis());
            com.tencent.qqnt.kernel.api.f o16 = o();
            if (o16 != null) {
                byte[] bytes = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                o16.addBuddy(callFrom, g16, bytes, new IAddBuddyCallback() { // from class: com.tencent.mobileqq.addfriend.api.impl.e
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IAddBuddyCallback
                    public final void onResult(int i3, String str, byte[] bArr, AddBuddyReq addBuddyReq, AddBuddyRsp addBuddyRsp) {
                        j.l(j.this, toNTMsg, i3, str, bArr, addBuddyReq, addBuddyRsp);
                    }
                });
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(j this$0, com.tencent.qqnt.remote.d toNTMsg, int i3, String errMsg, byte[] bArr, AddBuddyReq addBuddyReq, AddBuddyRsp addBuddyRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toNTMsg, "$toNTMsg");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.x(i3, errMsg, toNTMsg, addBuddyRsp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0033, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m(String callFrom, final com.tencent.qqnt.remote.d toNTMsg) {
        Integer intOrNull;
        String string = toNTMsg.a().getString("uin");
        String string2 = toNTMsg.a().getString("extra");
        int i3 = 0;
        if (!StringUtil.isEmpty(string) && !StringUtil.isEmpty(string2)) {
            AccountInfo accountInfo = new AccountInfo();
            OpenidAccInfo openidAccInfo = new OpenidAccInfo();
            openidAccInfo.openid = string;
            if (string2 != null && intOrNull != null) {
                i3 = intOrNull.intValue();
            }
            openidAccInfo.appid = i3;
            accountInfo.openid = openidAccInfo;
            com.tencent.qqnt.kernel.api.f o16 = o();
            if (o16 != null) {
                byte[] bytes = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                o16.requestInfoByAccount(callFrom, accountInfo, bytes, new IGetBuddyInfoCallback() { // from class: com.tencent.mobileqq.addfriend.api.impl.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetBuddyInfoCallback
                    public final void onResult(int i16, String str, byte[] bArr, AccountInfo accountInfo2, BuddyInfoRsp buddyInfoRsp) {
                        j.n(j.this, toNTMsg, i16, str, bArr, accountInfo2, buddyInfoRsp);
                    }
                });
            }
            return true;
        }
        QLog.i("AddFriendNTServiceImpl", 1, "getInfoByOpenID openId " + string + " or uid " + string2 + " empty");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(j this$0, com.tencent.qqnt.remote.d toNTMsg, int i3, String errMsg, byte[] bArr, AccountInfo accountInfo, BuddyInfoRsp buddyInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toNTMsg, "$toNTMsg");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.x(i3, errMsg, toNTMsg, buddyInfoRsp);
    }

    private final com.tencent.qqnt.kernel.api.f o() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getAddOrDelBuddyService();
        }
        return null;
    }

    private final boolean p(String callFrom, final com.tencent.qqnt.remote.d toNTMsg) {
        SmartReq j3 = this.mNTCoder.j(toNTMsg);
        com.tencent.qqnt.kernel.api.f o16 = o();
        if (o16 != null) {
            byte[] bytes = "".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            o16.getSmartInfo(callFrom, j3, bytes, new IGetSmartInfoCallback() { // from class: com.tencent.mobileqq.addfriend.api.impl.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetSmartInfoCallback
                public final void onResult(int i3, String str, byte[] bArr, SmartReq smartReq, SmartRsp smartRsp) {
                    j.q(j.this, toNTMsg, i3, str, bArr, smartReq, smartRsp);
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(j this$0, com.tencent.qqnt.remote.d toNTMsg, int i3, String errMsg, byte[] bArr, SmartReq smartReq, SmartRsp smartRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toNTMsg, "$toNTMsg");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.x(i3, errMsg, toNTMsg, smartRsp);
    }

    private final boolean r(String callFrom, final com.tencent.qqnt.remote.d toNtMsg) {
        AccountInfo h16 = this.mNTCoder.h(toNtMsg);
        com.tencent.qqnt.kernel.api.f o16 = o();
        if (o16 != null) {
            byte[] bytes = "".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            o16.queryUinSafetyFlag(callFrom, h16, bytes, new IQueryUinSafetyFlagCallback() { // from class: com.tencent.mobileqq.addfriend.api.impl.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryUinSafetyFlagCallback
                public final void onResult(int i3, String str, byte[] bArr, AccountInfo accountInfo, int i16) {
                    j.s(j.this, toNtMsg, i3, str, bArr, accountInfo, i16);
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(j this$0, com.tencent.qqnt.remote.d toNtMsg, int i3, String errMsg, byte[] bArr, AccountInfo accountInfo, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toNtMsg, "$toNtMsg");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.x(i3, errMsg, toNtMsg, Integer.valueOf(i16));
    }

    private final boolean t(String callFrom, final com.tencent.qqnt.remote.d toNTMsg) {
        BuddySettingReq i3 = this.mNTCoder.i(toNTMsg);
        if (i3 != null) {
            toNTMsg.a().putLong("KEY_REQUEST_TIME", System.currentTimeMillis());
            com.tencent.qqnt.kernel.api.f o16 = o();
            if (o16 != null) {
                byte[] bytes = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                o16.getBuddySetting("AddFriendNTServiceImpl", i3, bytes, new IBuddySettingCallback() { // from class: com.tencent.mobileqq.addfriend.api.impl.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IBuddySettingCallback
                    public final void onResult(int i16, String str, byte[] bArr, BuddySettingReq buddySettingReq, BuddySettingRsp buddySettingRsp) {
                        j.u(j.this, toNTMsg, i16, str, bArr, buddySettingReq, buddySettingRsp);
                    }
                });
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(j this$0, com.tencent.qqnt.remote.d toNTMsg, int i3, String errMsg, byte[] bArr, BuddySettingReq buddySettingReq, BuddySettingRsp buddySettingRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toNTMsg, "$toNTMsg");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.x(i3, errMsg, toNTMsg, buddySettingRsp);
    }

    private final boolean v(String callFrom, final com.tencent.qqnt.remote.d toNTMsg) {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.uin = Long.valueOf(toNTMsg.a().getLong("uin"));
        accountInfo.uid = toNTMsg.a().getString("uid");
        Long l3 = accountInfo.uin;
        if (l3 != null && 0 == l3.longValue() && StringUtil.isEmpty(accountInfo.uid)) {
            QLog.i("AddFriendNTServiceImpl", 1, "getUserTag uin:" + accountInfo.uid + " or uid:" + accountInfo.uid + " invalid");
            return false;
        }
        com.tencent.qqnt.kernel.api.f o16 = o();
        if (o16 != null) {
            byte[] bytes = "".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            o16.getAddBuddyRequestTag(callFrom, accountInfo, bytes, new IGetBuddyTagCallback() { // from class: com.tencent.mobileqq.addfriend.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetBuddyTagCallback
                public final void onResult(int i3, String str, byte[] bArr, AccountInfo accountInfo2, BuddyTagRsp buddyTagRsp) {
                    j.w(j.this, toNTMsg, i3, str, bArr, accountInfo2, buddyTagRsp);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(j this$0, com.tencent.qqnt.remote.d toNTMsg, int i3, String errMsg, byte[] bArr, AccountInfo accountInfo, BuddyTagRsp buddyTagRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toNTMsg, "$toNTMsg");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.x(i3, errMsg, toNTMsg, buddyTagRsp);
    }

    private final void x(final int result, final String errMsg, final com.tencent.qqnt.remote.d toNtMsg, final Object rsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.addfriend.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                j.y(com.tencent.qqnt.remote.d.this, result, errMsg, rsp, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(com.tencent.qqnt.remote.d toNtMsg, int i3, String errMsg, Object obj, j this$0) {
        Intrinsics.checkNotNullParameter(toNtMsg, "$toNtMsg");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendNTServiceImpl", 2, "handleNTCallback cmd: " + toNtMsg.b() + " result: " + i3 + TokenParser.SP + errMsg);
        }
        com.tencent.qqnt.remote.b bVar = new com.tencent.qqnt.remote.b(i3, errMsg, toNtMsg.c(), toNtMsg.d(), toNtMsg.b());
        bVar.e(obj);
        this$0.z(toNtMsg, bVar);
    }

    @Override // com.tencent.qqnt.remote.c
    public void a(@NotNull final String callFrom, @NotNull final com.tencent.qqnt.remote.d toNtMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) callFrom, (Object) toNtMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(toNtMsg, "toNtMsg");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.addfriend.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                j.A(com.tencent.qqnt.remote.d.this, this, callFrom);
            }
        };
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.qqnt.remote.c
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "friend.add.service";
    }

    public void z(@NotNull com.tencent.qqnt.remote.d request, @NotNull com.tencent.qqnt.remote.b response) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) response);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BusinessHandler businessHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            businessHandler = appInterface.getBusinessHandler(Reflection.getOrCreateKotlinClass(NTAddFriendHandler.class).getQualifiedName());
        }
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler");
        ((NTAddFriendHandler) businessHandler).F2(request, response);
    }
}
