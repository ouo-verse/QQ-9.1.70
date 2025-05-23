package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/forward/ForwardWeishiShareOption;", "Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "", "o", "", "commentMsg", "", "uinType", "toUin", "troopUin", "p", "r", "errorCode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "buildForwardAbility", "", "realForwardTo", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ForwardWeishiShareOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/forward/ForwardWeishiShareOption$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.forward.ForwardWeishiShareOption$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/forward/ForwardWeishiShareOption$b", "Lsy/a;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements sy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f210948b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f210949c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f210950d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f210951e;

        b(String str, int i3, String str2, Ref.ObjectRef<String> objectRef) {
            this.f210948b = str;
            this.f210949c = i3;
            this.f210950d = str2;
            this.f210951e = objectRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardWeishiShareOption.this, str, Integer.valueOf(i3), str2, objectRef);
            }
        }

        @Override // sy.a
        public void onFailed(int errorCode, @NotNull String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
            } else {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                ForwardWeishiShareOption.this.q(errorCode);
            }
        }

        @Override // sy.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardWeishiShareOption.this.r();
                ForwardWeishiShareOption.this.p(this.f210948b, this.f210949c, this.f210950d, this.f210951e.element);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58089);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardWeishiShareOption(@NotNull Intent intent) {
        super(intent);
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.String] */
    private final void o() {
        boolean isBlank;
        int i3 = this.mExtraData.getInt("uintype");
        ?? string = this.mExtraData.getString("uin");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? string2 = this.mExtraData.getString("troop_uin");
        objectRef.element = string2;
        boolean z16 = true;
        if (i3 == 1) {
            CharSequence charSequence = (CharSequence) string2;
            if (charSequence != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(charSequence);
                if (!isBlank) {
                    z16 = false;
                }
            }
            if (z16) {
                objectRef.element = string;
            }
        }
        String string3 = this.mExtraData.getString("forward_ark_app_meta");
        String string4 = this.mExtraData.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        QLog.i("ForwardWeishiShareOption", 2, "[realForwardTo] uinType:" + i3 + ", uin:" + ((String) string) + ", troopUin:" + objectRef.element + ", meta:" + string3);
        ((IWSManager) QRoute.api(IWSManager.class)).sendArkMsg(this.mExtraData, new b(string4, i3, string, objectRef));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(String commentMsg, int uinType, String toUin, String troopUin) {
        boolean z16;
        boolean isBlank;
        if (commentMsg != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(commentMsg);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return;
                }
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179555d = uinType;
                sessionInfo.f179557e = toUin;
                sessionInfo.f179559f = troopUin;
                com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, commentMsg);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int errorCode) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, 1, context.getString(R.string.f173102he3) + "[" + errorCode + "]", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f170969bc3, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.buildForwardAbility();
        QLog.i("ForwardWeishiShareOption", 2, "[buildForwardAbility]");
        this.mForwardAbilities.add(e.O3);
        this.mForwardAbilities.add(e.P3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        o();
        return super.realForwardTo();
    }
}
