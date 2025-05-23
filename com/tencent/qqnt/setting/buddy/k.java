package com.tencent.qqnt.setting.buddy;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SpecialCareSetting;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.be;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.setting.buddy.a;
import com.tencent.qqnt.setting.buddy.b;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 @2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001AB\u0017\u0012\u0006\u0010+\u001a\u00020\u001b\u0012\u0006\u00101\u001a\u00020,\u00a2\u0006\u0004\b>\u0010?J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J4\u0010$\u001a\u00020\u000b2*\u0010#\u001a&\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 j\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u0001`\"H\u0016R\"\u0010+\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010=\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/setting/buddy/k;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/setting/buddy/a;", "Lcom/tencent/qqnt/setting/buddy/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "Lcom/tencent/qqnt/kernel/api/m;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/qqnt/kernel/api/y;", "d2", "Lcom/tencent/qqnt/kernel/api/w;", "c2", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isTop", "o2", "isDisturb", "k2", "isBlock", "i2", "X1", "isSpecialCare", "m2", "e2", "isDelRoamMsg", "T1", "", "msg", SemanticAttributes.DbSystemValues.H2, "userIntent", "g2", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "Lkotlin/collections/HashMap;", "profiles", "onProfileSimpleChanged", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getMPeerId", "()Ljava/lang/String;", "setMPeerId", "(Ljava/lang/String;)V", "mPeerId", "", "D", "I", "getMChatType", "()I", "mChatType", "Lmqq/app/AppRuntime;", "E", "Lmqq/app/AppRuntime;", "mAppRuntime", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "mSimpleInfo", "G", "Lcom/tencent/qqnt/setting/buddy/b;", "b2", "()Lcom/tencent/qqnt/setting/buddy/b;", "mNoneValueIntent", "<init>", "(Ljava/lang/String;I)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class k extends BaseViewModel<a, b> implements IKernelProfileListener {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mPeerId;

    /* renamed from: D, reason: from kotlin metadata */
    private final int mChatType;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private AppRuntime mAppRuntime;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private UserSimpleInfo mSimpleInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/setting/buddy/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.setting.buddy.k$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k(@NotNull String mPeerId, int i3) {
        Intrinsics.checkNotNullParameter(mPeerId, "mPeerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mPeerId, i3);
            return;
        }
        this.mPeerId = mPeerId;
        this.mChatType = i3;
        this.mNoneValueIntent = b.c.f362144a;
    }

    private final void T1(boolean isDelRoamMsg) {
        w c26;
        w c27 = c2();
        if (c27 != null) {
            Contact contact = new Contact(this.mChatType, this.mPeerId, "");
            c27.clearMsgRecords(contact, new IClearMsgRecordsCallback() { // from class: com.tencent.qqnt.setting.buddy.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback
                public final void onResult(int i3, String str, long j3) {
                    k.U1(k.this, i3, str, j3);
                }
            });
            if (isDelRoamMsg && (c26 = c2()) != null) {
                c26.O(contact, new IOperateCallback() { // from class: com.tencent.qqnt.setting.buddy.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        k.W1(k.this, i3, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(k this$0, int i3, String str, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2("clearMsgRecords result: " + i3 + ", error: " + str + ", delLastSeq: " + j3);
        MutableLiveData<a> mUiState = this$0.getMUiState();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        mUiState.postValue(new a.C9696a(z16));
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.c(this$0.mPeerId, this$0.mChatType, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(k this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2("delRoamMsgRecords result: " + i3 + ", error: " + str);
    }

    private final void X1() {
        h2("clearMsgNumber start");
        w c26 = c2();
        if (c26 != null) {
            c26.setMsgRead(new Contact(this.mChatType, this.mPeerId, ""), new IOperateCallback() { // from class: com.tencent.qqnt.setting.buddy.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    k.Z1(k.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(k this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2("clearMsgNumber result: " + i3 + ", error: " + str);
    }

    private final m a2() {
        if (this.mAppRuntime == null) {
            this.mAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getBuddyService();
    }

    private final w c2() {
        if (this.mAppRuntime == null) {
            this.mAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
    }

    private final y d2() {
        if (this.mAppRuntime == null) {
            this.mAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        AppRuntime appRuntime = this.mAppRuntime;
        Intrinsics.checkNotNull(appRuntime);
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getProfileService();
    }

    private final void e2() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.mPeerId);
        h2("getUserSimpleInfo start");
        y d26 = d2();
        if (d26 != null) {
            d26.getUserSimpleInfo(false, arrayList, new IOperateCallback() { // from class: com.tencent.qqnt.setting.buddy.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    k.f2(k.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(k this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2("getUserSimpleInfo result: " + i3 + ", error: " + str);
    }

    private final void h2(String msg2) {
        QLog.i("BuddyChatSettingViewModel", 1, msg2);
    }

    private final void i2(final boolean isBlock) {
        h2("setBlock isBlock=" + isBlock);
        m a26 = a2();
        if (a26 != null) {
            a26.setBlock(this.mPeerId, isBlock, new IOperateCallback() { // from class: com.tencent.qqnt.setting.buddy.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    k.j2(k.this, isBlock, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(k this$0, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2("setBlock result: " + i3 + ", error: " + str);
        if (i3 == 0 && !z16) {
            this$0.X1();
        }
    }

    private final void k2(boolean isDisturb) {
        h2("setDisturb isDisturb=" + isDisturb);
        m a26 = a2();
        if (a26 != null) {
            a26.setMsgNotify(this.mPeerId, isDisturb, new IOperateCallback() { // from class: com.tencent.qqnt.setting.buddy.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    k.l2(k.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(k this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2("setDisturb result: " + i3 + ", error: " + str);
    }

    private final void m2(boolean isSpecialCare) {
        h2("setSpecialCare isSpecialCare=" + isSpecialCare);
        m a26 = a2();
        if (a26 != null) {
            a26.L(this.mPeerId, new SpecialCareSetting(isSpecialCare, isSpecialCare, isSpecialCare), new IOperateCallback() { // from class: com.tencent.qqnt.setting.buddy.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    k.n2(k.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(k this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2("setSpecialCare result: " + i3 + ", error: " + str);
    }

    private final void o2(boolean isTop) {
        h2("setTop isTop=" + isTop);
        m a26 = a2();
        if (a26 != null) {
            a26.setTop(this.mPeerId, isTop, new IOperateCallback() { // from class: com.tencent.qqnt.setting.buddy.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    k.p2(k.this, i3, str);
                }
            });
        }
    }

    private final void onCreate() {
        y d26 = d2();
        if (d26 != null) {
            d26.r0(this);
        }
    }

    private final void onDestroy() {
        y d26 = d2();
        if (d26 != null) {
            d26.D0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(k this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2("setTop result: " + i3 + ", error: " + str);
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: b2, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: g2, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.d) {
            onCreate();
            return;
        }
        if (userIntent instanceof b.e) {
            onDestroy();
            return;
        }
        if (userIntent instanceof b.C9697b) {
            e2();
            return;
        }
        if (userIntent instanceof b.i) {
            o2(((b.i) userIntent).a());
            return;
        }
        if (userIntent instanceof b.g) {
            k2(((b.g) userIntent).a());
            return;
        }
        if (userIntent instanceof b.f) {
            i2(((b.f) userIntent).a());
            return;
        }
        if (userIntent instanceof b.h) {
            m2(((b.h) userIntent).a());
        } else if (userIntent instanceof b.a) {
            T1(((b.a) userIntent).a());
        } else {
            h2("handleIntent un support");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public void onProfileSimpleChanged(@Nullable HashMap<String, UserSimpleInfo> profiles) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) profiles);
            return;
        }
        if (profiles != null && !profiles.isEmpty()) {
            UserSimpleInfo userSimpleInfo = profiles.get(this.mPeerId);
            if (userSimpleInfo == null) {
                h2("onProfileSimpleChanged simpleInfo == null");
                return;
            }
            this.mSimpleInfo = userSimpleInfo;
            h2("onProfileSimpleChanged simpleInfo=" + userSimpleInfo);
            getMUiState().postValue(new a.b(userSimpleInfo));
            return;
        }
        h2("onProfileSimpleChanged profiles == null");
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onSelfStatusChanged(StatusInfo statusInfo) {
        be.b(this, statusInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStatusAsyncFieldUpdate(HashMap hashMap) {
        be.c(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStatusUpdate(HashMap hashMap) {
        be.d(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStrangerRemarkChanged(HashMap hashMap) {
        be.e(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onUserDetailInfoChanged(UserDetailInfo userDetailInfo) {
        be.f(this, userDetailInfo);
    }
}
