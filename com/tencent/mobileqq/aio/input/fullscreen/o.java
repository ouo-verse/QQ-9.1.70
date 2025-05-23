package com.tencent.mobileqq.aio.input.fullscreen;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.api.runtime.emitter.a;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.input.base.mvicompat.e;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputRightIconMsgEvent;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenUIState;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.aio.input.fullscreen.f;
import com.tencent.mobileqq.aio.input.fullscreen.m;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.camera.api.ICameraAPI;
import com.tencent.qqnt.camera.data.CameraReq;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\u0003\n\u0002\b\u0006*\u0002=@\b\u0007\u0018\u0000  2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u00072\u00020\b:\u0001DB\u000f\u0012\u0006\u00106\u001a\u00020\u0005\u00a2\u0006\u0004\bC\u00105J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0018\u0010(\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000fH\u0016J\b\u0010)\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u000fH\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0002H\u0016R\"\u00106\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/aio/input/fullscreen/o;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/g;", "", tl.h.F, "B", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "i", "", "showFullScreenMode", "v", "Lcom/tencent/mvi/base/route/k;", "j", ReportConstant.COSTREPORT_PREFIX, "u", "", "canSelectCount", "r", "w", "Landroid/content/Intent;", "result", "y", "o", "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "isFullScreenMode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "l", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/fullscreen/f;", "d0", "intent", "t", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "g", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "e", "Lcom/tencent/aio/api/runtime/a;", "mContext", "f", "Z", "mIsFullScreenMode", "com/tencent/mobileqq/aio/input/fullscreen/o$d", "Lcom/tencent/mobileqq/aio/input/fullscreen/o$d;", "mAction", "com/tencent/mobileqq/aio/input/fullscreen/o$e", "Lcom/tencent/mobileqq/aio/input/fullscreen/o$e;", "mActionR", "<init>", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class o implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, com.tencent.aio.api.runtime.emitter.a, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/input/fullscreen/o$a;", "", "", "MAX_PIC_NUM", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.fullscreen.o$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/aio/input/fullscreen/o$b", "Law3/a;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements aw3.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/input/fullscreen/o$c", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends com.tencent.qqnt.aio.shortcutbar.j {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f189659d;

        c(int i3) {
            this.f189659d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this, i3);
            }
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                o.this.w(this.f189659d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/fullscreen/o$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                o.this.i(i3);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/fullscreen/o$e", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return o.this.j(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55313);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public o(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mAction = new d();
        this.mActionR = new e();
    }

    private final void B() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().e(this);
    }

    private final void h() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().l(this, this.mActionR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(MsgIntent msgIntent) {
        if (msgIntent instanceof FullScreenMsgIntent.SetFullScreenMode) {
            v(((FullScreenMsgIntent.SetFullScreenMode) msgIntent).a());
            return;
        }
        if (msgIntent instanceof FullScreenMsgIntent.InsertPhoto) {
            List<com.tencent.mobileqq.aio.input.fullscreen.c> a16 = ((FullScreenMsgIntent.InsertPhoto) msgIntent).a();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            Lifecycle lifecycle = aVar.d().getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "mContext.lifecycleOwner.lifecycle");
            E(new FullScreenUIState.InsertPicUIState(a16, LifecycleKt.getCoroutineScope(lifecycle)));
            return;
        }
        if (msgIntent instanceof AIOMsgSendEvent.SendBeforeEvent) {
            v(false);
            return;
        }
        if (msgIntent instanceof FullScreenMsgIntent.GetFullScreenStatus) {
            ((FullScreenMsgIntent.GetFullScreenStatus) msgIntent).b(this.mIsFullScreenMode);
        } else if (msgIntent instanceof FullScreenMsgIntent.UpdateFullScreenAbilityMsgIntent) {
            FullScreenMsgIntent.UpdateFullScreenAbilityMsgIntent updateFullScreenAbilityMsgIntent = (FullScreenMsgIntent.UpdateFullScreenAbilityMsgIntent) msgIntent;
            E(new FullScreenUIState.UpdateFullScreenAbilityUIState(updateFullScreenAbilityMsgIntent.b(), updateFullScreenAbilityMsgIntent.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k j(MsgIntent msgIntent) {
        if (msgIntent instanceof FullScreenMsgIntent.GetFullScreenMode) {
            return s();
        }
        if (msgIntent instanceof FullScreenMsgIntent.GetInputConsumeSelectPhotoOperate) {
            return u();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void k() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(FullScreenMsgIntent.AfterCancelFullScreenMode.f189576d);
    }

    private final void l(boolean isFullScreen) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new FullScreenMsgIntent.BeforeFullScreenAnimChanged(isFullScreen));
    }

    private final void m() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
    }

    private final void n() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(FullScreenMsgIntent.OnFullScreenAnimStartMsgIntent.f189582d);
    }

    private final void o() {
        ICameraAPI iCameraAPI = (ICameraAPI) QRoute.api(ICameraAPI.class);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        iCameraAPI.startCameraAndCallback(aVar, new CameraReq(null, 1, null), new b());
    }

    private final void p() {
        com.tencent.mobileqq.aio.panel.c cVar = com.tencent.mobileqq.aio.panel.c.f193019a;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        boolean b16 = cVar.b(aVar);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar3 = null;
        }
        if (cVar.b(aVar3)) {
            com.tencent.aio.api.runtime.a aVar4 = this.mContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar4;
            }
            aVar2.e().h(new PanelContainerMsgIntent.HidePanelMsgIntent("FullScreenVM", 1001, false, 4, null));
        } else {
            com.tencent.aio.api.runtime.a aVar5 = this.mContext;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar5;
            }
            aVar2.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("FullScreenVM", 1001, false, 0, 12, null));
        }
        E(new FullScreenUIState.UpdateEmojiContentDescription(b16));
    }

    private final void q(boolean isFullScreenMode) {
        E(new FullScreenUIState.SetFullScreenModeUIState(isFullScreenMode));
        com.tencent.aio.api.runtime.a aVar = null;
        if (isFullScreenMode) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar2 = null;
            }
            aVar2.e().h(InputAtMsgIntent.DismissAtDialog.f189181d);
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar3 = null;
            }
            aVar3.e().h(new InputRightIconMsgEvent.InputRightIconChangeVisibleEvent(false));
        } else {
            com.tencent.aio.api.runtime.a aVar4 = this.mContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar4 = null;
            }
            aVar4.e().h(InputRightIconMsgEvent.UpdateRightIconVisibleEvent.f188584d);
        }
        com.tencent.aio.api.runtime.a aVar5 = this.mContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar5;
        }
        aVar.e().h(new FullScreenMsgIntent.OnFullScreenModeChanged(isFullScreenMode));
    }

    private final void r(int canSelectCount) {
        List listOf;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (activity != null) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE});
            Iterator it = listOf.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (activity.checkSelfPermission((String) it.next()) != 0) {
                    z16 = true;
                }
            }
            if (z16) {
                com.tencent.mobileqq.aio.shortcurtbar.permission.a aVar2 = com.tencent.mobileqq.aio.shortcurtbar.permission.a.f193758a;
                Object[] array = listOf.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                aVar2.a(activity, "album", (String[]) array, 2, new c(canSelectCount));
                return;
            }
            w(canSelectCount);
        }
    }

    private final com.tencent.mvi.base.route.k s() {
        return new e.a(this.mIsFullScreenMode);
    }

    private final com.tencent.mvi.base.route.k u() {
        if (getMHost().fetchVBState(m.b.f189649b).b().getInt("image_span_size") > 0) {
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            Context context = aVar.c().getContext();
            if (context != null) {
                QQToast.makeText(context, R.string.yrf, 0).show();
            }
            return new e.b(true);
        }
        return new e.b(false);
    }

    private final void v(boolean showFullScreenMode) {
        if (this.mIsFullScreenMode != showFullScreenMode) {
            this.mIsFullScreenMode = showFullScreenMode;
            com.tencent.mobileqq.aio.input.fullscreen.d.f189612a.a().set(this.mIsFullScreenMode);
            q(showFullScreenMode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int canSelectCount) {
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        com.tencent.aio.api.runtime.a aVar3 = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar2 = null;
        }
        Context requireContext = aVar2.c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar4 = new Config.a();
        aVar4.g(canSelectCount);
        aVar4.f(TabType.TAB_IMAGE);
        aVar4.h(4);
        com.tencent.aio.api.runtime.a aVar5 = this.mContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar5 = null;
        }
        aVar4.e(aVar5.g().r().c().e());
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar4.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar6 = new PickerInitBean.a();
        String qqStr = HardCodeUtil.qqStr(R.string.yrg);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.aio_input\u2026elect_pic_next_step_text)");
        aVar6.b(qqStr);
        Intent e16 = com.tencent.qqnt.qbasealbum.a.e(aVar, requireContext, a16, aVar6.a(), null, null, 24, null);
        IPhotoPanelApi iPhotoPanelApi = (IPhotoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPhotoPanelApi.class);
        com.tencent.aio.api.runtime.a aVar7 = this.mContext;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar7 = null;
        }
        iPhotoPanelApi.fillIntentForJumpAlbum(e16, aVar7);
        com.tencent.aio.api.runtime.a aVar8 = this.mContext;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar3 = aVar8;
        }
        aVar3.f().a(e16, new ActivityResultCallback() { // from class: com.tencent.mobileqq.aio.input.fullscreen.n
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                o.x(o.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(o this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() != -1) {
            QLog.e("FullScreenVM", 1, "full_screen select_pic error! " + activityResult.getResultCode());
            return;
        }
        this$0.y(activityResult.getData());
    }

    private final void y(Intent result) {
        AlbumResult albumResult;
        List<LocalMediaInfo> e16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (result != null) {
            albumResult = (AlbumResult) result.getParcelableExtra("ALBUM_RESULT");
        } else {
            albumResult = null;
        }
        if (albumResult != null && (e16 = albumResult.e()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = e16.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) it.next();
                String path = localMediaInfo.getPath();
                if (path != null && path.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    String path2 = localMediaInfo.getPath();
                    Intrinsics.checkNotNull(path2);
                    arrayList.add(new com.tencent.mobileqq.aio.input.fullscreen.c(path2, com.tencent.mobileqq.album.media.b.a(localMediaInfo), albumResult.g()));
                }
            }
            if (!(!arrayList.isEmpty())) {
                arrayList = null;
            }
            if (arrayList != null) {
                com.tencent.aio.api.runtime.a aVar2 = this.mContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    aVar = aVar2;
                }
                Lifecycle lifecycle = aVar.d().getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "mContext.lifecycleOwner.lifecycle");
                E(new FullScreenUIState.InsertPicUIState(arrayList, LifecycleKt.getCoroutineScope(lifecycle)));
            }
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void E(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) inputUIState);
        } else {
            e.a.b(this, inputUIState);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            e.a.a(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return f.class;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.SetFullScreenMode");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.InsertPhoto");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendBeforeEvent");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.GetFullScreenStatus");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.UpdateFullScreenAbilityMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.GetFullScreenMode");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.GetInputConsumeSelectPhotoOperate");
        return hashSet;
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.mIsFullScreenMode) {
            v(false);
            return true;
        }
        return a.C0623a.a(this);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        B();
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        v(false);
        com.tencent.mobileqq.aio.input.fullscreen.d.f189612a.a().set(this.mIsFullScreenMode);
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof f.d) {
            n();
            return;
        }
        if (intent instanceof f.c) {
            m();
            return;
        }
        if (intent instanceof f.a) {
            k();
            return;
        }
        if (intent instanceof f.g) {
            r(((f.g) intent).a());
            return;
        }
        if (intent instanceof f.e) {
            o();
        } else if (intent instanceof f.C7268f) {
            p();
        } else if (intent instanceof f.b) {
            l(((f.b) intent).a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        h();
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }
}
