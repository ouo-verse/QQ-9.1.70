package com.tencent.mobileqq.aio.msglist.holder.component.markdown;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.util.Patterns;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.constants.Constants;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.InlineBtnClickDispatcher;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIOMarkdownMsgItemEvent;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIOMarkdownMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.a;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.AIOInlineKeyboardPermissionChecker;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.InlineBtnCallbackClickHandler;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.InlineBtnSubscribeHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\t*\u000248\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u001c\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002j\u0002`\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u001eH\u0002J\u001c\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002j\u0002`\u0006H\u0002J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0%J\u0018\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0010H\u0016J\b\u0010+\u001a\u00020\nH\u0016J\u0010\u0010-\u001a\u00020\n2\u0006\u0010\t\u001a\u00020,H\u0016R+\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/AIOInlineBoardClickHandler;", "G", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$l;", "T", "", "msgId", "", "L", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$i;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$e;", "P", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$d;", "O", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$b;", "M", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/a$c;", "N", "", Constants.KEYS.EXPOSED_CLICK_URL_KEY, BdhLogUtil.LogTag.Tag_Req, "originPath", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", UserInfo.SEX_FEMALE, "J", "", "K", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/aio/holder/a;", "o", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/InlineBtnClickDispatcher;", "f", "Lkotlin/Lazy;", "H", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/InlineBtnClickDispatcher;", "mInlineKeyboardClickDispatcher", "com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM$d", h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM$d;", "mConfigurationChangedCallback", "com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM$c", "i", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM$c;", "mAction", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMarkdownContentComponentVM extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mInlineKeyboardClickDispatcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mConfigurationChangedCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM$a;", "", "", "FROM_TAG", "I", "PIC_STATE_VALID", "", "TAG", "Ljava/lang/String;", "UNSUPPORTED_TIPS", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIOMarkdownContentComponentVM$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM$b", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/AIOInlineBoardClickHandler;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, @NotNull InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable AIOMsgItem payload) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, ctx, btnView, btnModel, payload);
                return;
            }
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(btnView, "btnView");
            Intrinsics.checkNotNullParameter(btnModel, "btnModel");
            String d16 = btnModel.a().d();
            if (d16.length() <= 0) {
                z16 = false;
            }
            if (!z16) {
                d16 = null;
            }
            if (d16 == null) {
                d16 = "\u6682\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u6309\u94ae\uff0c\u8bf7\u5347\u7ea7\u5ba2\u6237\u7aef";
            }
            QQToast.makeText(btnView.getContext(), d16, 0).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMarkdownContentComponentVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIOMarkdownContentComponentVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIOMarkdownContentComponentVM$d", "Lcom/tencent/aio/api/runtime/emitter/b;", "Landroid/content/res/Configuration;", "configuration", "", "onConfigurationChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.aio.api.runtime.emitter.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMarkdownContentComponentVM.this);
            }
        }

        @Override // com.tencent.aio.api.runtime.emitter.b
        public void onConfigurationChanged(@NotNull Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
            } else {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                AIOMarkdownContentComponentVM.this.updateUI(AIOMarkdownMsgItemUIState.OnConfigurationChangedUIState.f190954d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61081);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMarkdownContentComponentVM() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<InlineBtnClickDispatcher<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem>>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIOMarkdownContentComponentVM$mInlineKeyboardClickDispatcher$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarkdownContentComponentVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final InlineBtnClickDispatcher<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> invoke() {
                    com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> G;
                    com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> J;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (InlineBtnClickDispatcher) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    InlineBtnClickDispatcher<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> inlineBtnClickDispatcher = new InlineBtnClickDispatcher<>(new AIOInlineKeyboardPermissionChecker());
                    AIOMarkdownContentComponentVM aIOMarkdownContentComponentVM = AIOMarkdownContentComponentVM.this;
                    inlineBtnClickDispatcher.e(0, new com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.d());
                    inlineBtnClickDispatcher.e(1, new InlineBtnCallbackClickHandler());
                    inlineBtnClickDispatcher.e(2, new com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.a());
                    G = aIOMarkdownContentComponentVM.G();
                    inlineBtnClickDispatcher.e(3, G);
                    J = aIOMarkdownContentComponentVM.J();
                    inlineBtnClickDispatcher.e(-1, J);
                    inlineBtnClickDispatcher.e(4, new InlineBtnSubscribeHandler());
                    return inlineBtnClickDispatcher;
                }
            });
            this.mInlineKeyboardClickDispatcher = lazy;
            this.mConfigurationChangedCallback = new d();
            this.mAction = new c();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof StreamMsgEvent.EndStreamAnim) {
            updateUI(new AIOMarkdownMsgItemUIState.EndStreamAnimUIState(((StreamMsgEvent.EndStreamAnim) intent).a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MsgElement F(String originPath) {
        MsgElement createPicElement = ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createPicElement(originPath, true, 0);
        PicElement picElement = createPicElement.picElement;
        if (picElement != null) {
            picElement.invalidState = 0;
        }
        return createPicElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> G() {
        return (com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b) ((IMarkdownConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownConfigApi.class)).getWhitelistedSchemeClickListener(new com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.e());
    }

    private final InlineBtnClickDispatcher<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> H() {
        return (InlineBtnClickDispatcher) this.mInlineKeyboardClickDispatcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> J() {
        return new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean L(long msgId) {
        a.C9495a c9495a;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new StreamMsgEvent.GetAnimStatus(Long.valueOf(msgId)));
        if (k3 instanceof a.C9495a) {
            c9495a = (a.C9495a) k3;
        } else {
            c9495a = null;
        }
        if (c9495a != null) {
            return c9495a.a();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M(a.b intent) {
        IMarkdownFeatureCompatApi iMarkdownFeatureCompatApi = (IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class);
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        iMarkdownFeatureCompatApi.startUrl(requireContext, intent.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N(a.c intent) {
        String a16 = intent.a();
        if (a16 != null && R(a16)) {
            QLog.d("AIOMarkdownContentComponentVM", 1, "handleImageScheme:" + a16);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String b16 = intent.b();
        if (b16 == null) {
            QLog.e("AIOMarkdownContentComponentVM", 1, "[handleClickImageSpan]: localPath is null");
            return;
        }
        LifecycleOwner d16 = ((com.tencent.aio.api.runtime.a) getMContext()).d();
        Intrinsics.checkNotNullExpressionValue(d16, "mContext.lifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getIO(), null, new AIOMarkdownContentComponentVM$handleClickImageSpan$1(this, b16, intent, peekAppRuntime, null), 2, null);
    }

    private final void O(a.d intent) {
        H().a(intent.c(), intent.b(), intent.a(), intent.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P(a.e intent) {
        ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).doSchemaAction("AIOMarkdownContentComponentVM", (com.tencent.aio.api.runtime.a) getMContext(), intent.a(), new Object[]{intent.b()});
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q(a.f intent) {
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context != null && !((IAIOJumpAction) QRoute.api(IAIOJumpAction.class)).doUrlAction(context, intent.a())) {
            QQToast.makeText(context, "\u6682\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u6309\u94ae\uff0c\u8bf7\u5347\u7ea7\u5ba2\u6237\u7aef", 0).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean R(String clickUrl) {
        boolean equals;
        boolean z16;
        boolean equals2;
        boolean z17;
        boolean equals3;
        boolean equals4;
        Uri parse = Uri.parse(clickUrl);
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        boolean z18 = false;
        if (context != null) {
            equals = StringsKt__StringsJVMKt.equals("http", parse.getScheme(), true);
            if (!equals) {
                equals4 = StringsKt__StringsJVMKt.equals("https", parse.getScheme(), true);
                if (!equals4) {
                    z16 = false;
                    boolean matches = Patterns.WEB_URL.matcher(clickUrl).matches();
                    if (z16 || !matches) {
                        equals2 = StringsKt__StringsJVMKt.equals(SchemaUtils.SCHEMA_MQQAPI, parse.getScheme(), true);
                        if (!equals2) {
                            equals3 = StringsKt__StringsJVMKt.equals("mqqguild", parse.getScheme(), true);
                            if (!equals3) {
                                z17 = false;
                                if (z17) {
                                    z18 = ((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class)).doUrlAction(context, clickUrl);
                                }
                            }
                        }
                        z17 = true;
                        if (z17) {
                        }
                    } else {
                        ((IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class)).startUrl(context, clickUrl);
                        z18 = true;
                    }
                    if (!z18) {
                        QLog.d("AIOMarkdownContentComponentVM", 1, "[handleGenericScheme]: not handle url: " + clickUrl);
                    }
                    return z18;
                }
            }
            z16 = true;
            boolean matches2 = Patterns.WEB_URL.matcher(clickUrl).matches();
            if (z16) {
            }
            equals2 = StringsKt__StringsJVMKt.equals(SchemaUtils.SCHEMA_MQQAPI, parse.getScheme(), true);
            if (!equals2) {
            }
            z17 = true;
            if (z17) {
            }
            if (!z18) {
            }
            return z18;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void S(a.i intent) {
        intent.b(((com.tencent.aio.api.runtime.a) getMContext()).d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T(a.l intent) {
        if (intent.b() != L(intent.a().getMsgId())) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new StreamMsgEvent.UpdateAnimStatus(intent.a().getMsgId(), intent.b()));
        }
    }

    @NotNull
    public final List<String> K() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(j.f352301a.a(Reflection.getOrCreateKotlinClass(StreamMsgEvent.EndStreamAnim.class)));
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            M((a.b) intent);
            return;
        }
        if (intent instanceof a.c) {
            N((a.c) intent);
            return;
        }
        if (intent instanceof a.e) {
            P((a.e) intent);
            return;
        }
        if (intent instanceof a.d) {
            O((a.d) intent);
            return;
        }
        if (intent instanceof a.f) {
            Q((a.f) intent);
            return;
        }
        if (intent instanceof a.C7302a) {
            R(((a.C7302a) intent).a());
            return;
        }
        if (intent instanceof a.i) {
            S((a.i) intent);
            return;
        }
        if (intent instanceof a.l) {
            T((a.l) intent);
            return;
        }
        boolean z16 = true;
        if (intent instanceof a.j) {
            a.j jVar = (a.j) intent;
            if (!com.tencent.mobileqq.aio.a.b((com.tencent.aio.api.runtime.a) getMContext()) && !com.tencent.mobileqq.aio.a.a((com.tencent.aio.api.runtime.a) getMContext())) {
                z16 = false;
            }
            jVar.b(z16);
            return;
        }
        if (intent instanceof a.k) {
            ((a.k) intent).a(!com.tencent.mobileqq.aio.a.a((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof a.g) {
            a.g gVar = (a.g) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMarkdownMsgItemEvent.DispatchOnBindEvent(gVar.a(), gVar.c(), gVar.b()));
        } else if (intent instanceof a.h) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMarkdownMsgItemEvent.DispatchOnRemoveEvent(((a.h) intent).a()));
        } else {
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        Iterator<T> it = K().iterator();
        while (it.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) it.next(), this.mAction);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.b.class).a(this.mConfigurationChangedCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = K().iterator();
        while (it.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) it.next(), this.mAction);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.b.class).c(this.mConfigurationChangedCallback);
    }
}
