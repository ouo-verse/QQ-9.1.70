package com.tencent.qqnt;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.api.IAIOLiteActionApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016R&\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/LiteActionOperateJumpAction;", "Lcom/tencent/mobileqq/utils/ax;", "", "K", "M", "J", "L", "b", "", "", "Lkotlin/Function0;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/Map;", "cmdActionMap", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "cc", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qq-light-business-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LiteActionOperateJumpAction extends ax {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Function0<Boolean>> cmdActionMap;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.LiteActionOperateJumpAction$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        static IPatchRedirector $redirector_;

        AnonymousClass1(Object obj) {
            super(0, obj, LiteActionOperateJumpAction.class, "openLocationShare", "openLocationShare()Z", 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(((LiteActionOperateJumpAction) this.receiver).K());
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.LiteActionOperateJumpAction$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Boolean> {
        static IPatchRedirector $redirector_;

        AnonymousClass2(Object obj) {
            super(0, obj, LiteActionOperateJumpAction.class, "openVideo", "openVideo()Z", 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(((LiteActionOperateJumpAction) this.receiver).M());
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.LiteActionOperateJumpAction$3, reason: invalid class name */
    /* loaded from: classes23.dex */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Boolean> {
        static IPatchRedirector $redirector_;

        AnonymousClass3(Object obj) {
            super(0, obj, LiteActionOperateJumpAction.class, "openGiftPanel", "openGiftPanel()Z", 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(((LiteActionOperateJumpAction) this.receiver).J());
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.LiteActionOperateJumpAction$4, reason: invalid class name */
    /* loaded from: classes23.dex */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Boolean> {
        static IPatchRedirector $redirector_;

        AnonymousClass4(Object obj) {
            super(0, obj, LiteActionOperateJumpAction.class, "openRedPacketPanel", "openRedPacketPanel()Z", 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(((LiteActionOperateJumpAction) this.receiver).L());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/LiteActionOperateJumpAction$a;", "", "", "CMD_KEY", "Ljava/lang/String;", "OPEN_GIFT_PANEL", "OPEN_LOCATION_SHARE", "OPEN_RED_PACK_PANEL", "OPEN_VIDEO", "TAG", "<init>", "()V", "qq-light-business-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.LiteActionOperateJumpAction$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29568);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiteActionOperateJumpAction(@NotNull BaseQQAppInterface app, @NotNull Context cc5) {
        super(app, cc5);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(cc5, "cc");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) cc5);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.cmdActionMap = linkedHashMap;
        linkedHashMap.put("open_sharelocation", new AnonymousClass1(this));
        linkedHashMap.put("open_video", new AnonymousClass2(this));
        linkedHashMap.put("open_gifpanel", new AnonymousClass3(this));
        linkedHashMap.put("open_redpackpay", new AnonymousClass4(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J() {
        return ((IAIOLiteActionApi) QRoute.api(IAIOLiteActionApi.class)).showGiftPanel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K() {
        return ((IAIOLiteActionApi) QRoute.api(IAIOLiteActionApi.class)).enterLocationSharePage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L() {
        return ((IAIOLiteActionApi) QRoute.api(IAIOLiteActionApi.class)).enterRedPacketPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M() {
        return ((IAIOLiteActionApi) QRoute.api(IAIOLiteActionApi.class)).startVideoCall();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r4 == true) goto L20;
     */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        String f16 = f("cmdkey");
        if (QLog.isColorLevel()) {
            QLog.i("LiteActionOperateJumpAction", 2, "doAction cmdKey: " + f16);
        }
        if (f16 != null) {
            z16 = true;
            if (f16.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (z16) {
            QLog.i("LiteActionOperateJumpAction", 2, "doAction cmdKey(" + f16 + ") is null or empty");
            return false;
        }
        Function0<Boolean> function0 = this.cmdActionMap.get(f16);
        if (function0 == null) {
            return false;
        }
        return function0.invoke().booleanValue();
    }
}
