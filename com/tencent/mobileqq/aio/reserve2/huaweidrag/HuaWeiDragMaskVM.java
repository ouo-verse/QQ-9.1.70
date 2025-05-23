package com.tencent.mobileqq.aio.reserve2.huaweidrag;

import android.content.ClipData;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.DragEvent;
import androidx.activity.result.ActivityResultCallback;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.reserve2.huaweidrag.HuaweiDragUIState;
import com.tencent.mobileqq.aio.reserve2.huaweidrag.d;
import com.tencent.mobileqq.aio.utils.o;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\t*\u0001!\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0015\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/HuaWeiDragMaskVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/d;", "Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/HuaweiDragUIState;", "Lcom/tencent/mvi/base/route/g;", "Landroid/view/DragEvent;", "event", "", "blueDrawable", "grayDrawable", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/ClipData;", "clipData", "r", "Landroid/content/ClipData$Item;", "clipItem", "Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/c;", "v", "", "datas", "w", "Ljava/lang/Runnable;", "runnable", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "u", "com/tencent/mobileqq/aio/reserve2/huaweidrag/HuaWeiDragMaskVM$b", "e", "Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/HuaWeiDragMaskVM$b;", "action", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class HuaWeiDragMaskVM extends com.tencent.qqnt.aio.baseVM.a<d, HuaweiDragUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve2/huaweidrag/HuaWeiDragMaskVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve2.huaweidrag.HuaWeiDragMaskVM$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve2/huaweidrag/HuaWeiDragMaskVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HuaWeiDragMaskVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof AIOMsgListEvent.BottomLayoutHeightChange) {
                HuaWeiDragMaskVM.this.updateUI(new HuaweiDragUIState.BottomLayoutHeightChanged(((AIOMsgListEvent.BottomLayoutHeightChange) intent).a()));
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64879);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HuaWeiDragMaskVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.action = new b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p(Runnable runnable) {
        if (!((com.tencent.aio.api.runtime.a) getMContext()).i().checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE)) {
            ((com.tencent.aio.api.runtime.a) getMContext()).i().a(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, new ActivityResultCallback() { // from class: com.tencent.mobileqq.aio.reserve2.huaweidrag.b
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    HuaWeiDragMaskVM.q((Boolean) obj);
                }
            });
        } else {
            runnable.run();
        }
    }

    private final void r(ClipData clipData) {
        if (clipData != null && clipData.getItemCount() != 0) {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), Dispatchers.getIO(), null, new HuaWeiDragMaskVM$handleClipData$1(clipData, this, null), 2, null);
        }
    }

    private final void s(final DragEvent event, int blueDrawable, int grayDrawable) {
        int action = event.getAction();
        if (action != 1) {
            if (action != 3) {
                if (action != 4) {
                    if (action != 5) {
                        if (action == 6) {
                            QLog.d("HuaWeiDragMaskVM", 1, "drag ACTION_DRAG_EXITED");
                            updateUI(new HuaweiDragUIState.BackgroundColorState(blueDrawable));
                            return;
                        }
                        return;
                    }
                    updateUI(new HuaweiDragUIState.BackgroundColorState(grayDrawable));
                    return;
                }
                QLog.d("HuaWeiDragMaskVM", 1, "drag ACTION_DRAG_ENDED");
                updateUI(new HuaweiDragUIState.BackgroundColorState(0));
                return;
            }
            QLog.d("HuaWeiDragMaskVM", 1, "drag ACTION_DROP");
            updateUI(new HuaweiDragUIState.BackgroundColorState(0));
            p(new Runnable() { // from class: com.tencent.mobileqq.aio.reserve2.huaweidrag.a
                @Override // java.lang.Runnable
                public final void run() {
                    HuaWeiDragMaskVM.t(HuaWeiDragMaskVM.this, event);
                }
            });
            return;
        }
        QLog.d("HuaWeiDragMaskVM", 1, "drag ACTION_DRAG_STARTED");
        updateUI(new HuaweiDragUIState.BackgroundColorState(blueDrawable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(HuaWeiDragMaskVM this$0, DragEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.r(event.getClipData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c v(ClipData.Item clipItem) {
        String str;
        boolean equals;
        boolean equals2;
        List split$default;
        List split$default2;
        Uri uri = clipItem.getUri();
        String type = BaseApplication.getContext().getContentResolver().getType(uri);
        boolean z16 = false;
        if (type != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) type, new String[]{"/"}, false, 0, 6, (Object) null);
            if (!split$default.isEmpty()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) type, new String[]{"/"}, false, 0, 6, (Object) null);
                str = (String) split$default2.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("HuaWeiDragMaskVM", 2, "drag description.uri=" + uri + ", mimeType=" + str + "\uff0c clipItem " + clipItem + " path " + uri.getPath());
                }
                uri.getPath();
                equals = StringsKt__StringsJVMKt.equals("file", uri.getScheme(), true);
                if (equals) {
                    equals2 = StringsKt__StringsJVMKt.equals("content", uri.getScheme(), true);
                    if (equals2) {
                        if (TextUtils.equals("image", str)) {
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            return new e(0, null, uri, 2, null);
                        }
                        if (TextUtils.equals("video", str)) {
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            return new e(2, null, uri, 2, null);
                        }
                    }
                } else {
                    String path = uri.getPath();
                    if (path == null || path.length() == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        return null;
                    }
                    int k3 = c81.a.k(path);
                    if (k3 != 0) {
                        if (k3 == 2) {
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            return new e(2, null, uri, 2, null);
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        return new e(0, null, uri, 2, null);
                    }
                }
                return null;
            }
        }
        str = null;
        if (QLog.isColorLevel()) {
        }
        uri.getPath();
        equals = StringsKt__StringsJVMKt.equals("file", uri.getScheme(), true);
        if (equals) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void w(List<? extends c> datas) {
        if (QLog.isColorLevel()) {
            QLog.d("HuaWeiDragMaskVM", 1, "sendData " + datas);
        }
        String peerUid = o.a(((com.tencent.aio.api.runtime.a) getMContext()).g().r()).peerUid;
        int i3 = o.a(((com.tencent.aio.api.runtime.a) getMContext()).g().r()).chatType;
        for (c cVar : datas) {
            if (cVar instanceof e) {
                e eVar = (e) cVar;
                if (eVar.a() == 2) {
                    QRouteApi api = QRoute.api(IMsgSendHelper.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IMsgSendHelper::class.java)");
                    Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
                    IMsgSendHelper.a.b((IMsgSendHelper) api, peerUid, i3, eVar.b(), 0, false, null, 56, null);
                }
                if (eVar.a() == 0) {
                    QRouteApi api2 = QRoute.api(IMsgSendHelper.class);
                    Intrinsics.checkNotNullExpressionValue(api2, "api(IMsgSendHelper::class.java)");
                    Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
                    IMsgSendHelper.a.a((IMsgSendHelper) api2, peerUid, i3, eVar.b(), false, 0, 0.0f, 56, null);
                }
            } else if (cVar instanceof f) {
                IMsgSendHelper iMsgSendHelper = (IMsgSendHelper) QRoute.api(IMsgSendHelper.class);
                Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
                iMsgSendHelper.sendText(peerUid, i3, ((f) cVar).a());
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.BottomLayoutHeightChange");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        context.e().f(this, this.action);
        updateUI(new HuaweiDragUIState.TopPadding(((com.tencent.aio.api.runtime.a) getMContext()).g().l().getInt("key_msg_head_padding", 0)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.action);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull d intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof d.a) {
            s(((d.a) intent).a(), Color.parseColor(GameCenterVideoViewController.GRAY_MASK), Color.parseColor("#7F000000"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Boolean bool) {
    }
}
