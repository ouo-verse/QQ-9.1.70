package com.tencent.qqnt.aio.litebussiness.liteaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.api.IAIOEmoApi;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAInjectUtil;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAScene;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.c;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionType;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/litebussiness/liteaction/a;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/c;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAInjectUtil$a;", "extraInfo", "", "forceKey", "", "b", "d", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAScene;", "scene", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/litebussiness/liteaction/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.litebussiness.liteaction.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65562);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(LIAInjectUtil.a extraInfo, String forceKey) {
        boolean z16;
        com.tencent.aio.api.runtime.a a16 = extraInfo.a();
        Contact b16 = extraInfo.b();
        if (forceKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            forceKey = extraInfo.d().getTitle();
        }
        if (a16 != null) {
            ((IAIOEmoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoApi.class)).sendRandomPicEmotionMsgFromAIO(forceKey, a16);
        } else if (b16 != null) {
            IAIOEmoApi.a.b((IAIOEmoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoApi.class), forceKey, b16, null, 4, null);
        } else {
            QLog.d("LiteGameClickProcessor", 1, "[doSendRandomEmoAction] err when aioContext and contact is null!");
        }
    }

    static /* synthetic */ void c(a aVar, LIAInjectUtil.a aVar2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        aVar.b(aVar2, str);
    }

    private final void d(LIAInjectUtil.a extraInfo) {
        com.tencent.aio.api.runtime.a a16 = extraInfo.a();
        Contact b16 = extraInfo.b();
        Bundle bundle = new Bundle();
        if (a16 != null) {
            String j3 = a16.g().r().c().j();
            bundle.putLong(ProtocolDownloaderConstants.HEADER_FRIEND_UIN, ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUinFromUid(j3));
            bundle.putString("peer_uid", j3);
        } else if (b16 != null) {
            IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class);
            String str = b16.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
            bundle.putLong(ProtocolDownloaderConstants.HEADER_FRIEND_UIN, iUixConvertAdapterApi.getUinFromUid(str));
            bundle.putString("peer_uid", b16.peerUid);
        } else {
            QLog.d("LiteGameClickProcessor", 1, "[doTeamUpAction] err when aioContext and contact is null!");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LiteGameClickProcessor", 1, "[doTeamUpAction] extraInfo=" + bundle);
        }
        IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) QRoute.api(IAIOJumpAction.class);
        Activity topActivity = Foreground.getTopActivity();
        Intrinsics.checkNotNullExpressionValue(topActivity, "getTopActivity()");
        iAIOJumpAction.openBrowserWithParam(topActivity, "https://h5.qun.qq.com/h5/qun-wangzhe-team-up/home?_wv=1&_wwv=8193&_disableWVQuit=1", bundle);
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.c
    public boolean a(@Nullable View view, @NotNull LIAScene scene, @NotNull LIAInjectUtil.a extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, scene, extraInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (extraInfo.d().getType() != LiteActionType.KGAMEPARTNER.ordinal()) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LiteGameClickProcessor", 1, "[LiteGameClickProcessor] scene=" + scene + ", mode=" + extraInfo.d());
        }
        int a16 = extraInfo.d().a();
        if (a16 != 0) {
            if (a16 != 1) {
                if (a16 != 2) {
                    b(extraInfo, "\u5f00\u9ed1");
                } else {
                    d(extraInfo);
                }
            } else {
                b(extraInfo, "\u5f00\u9ed1");
            }
        } else {
            c(this, extraInfo, null, 2, null);
        }
        return true;
    }
}
