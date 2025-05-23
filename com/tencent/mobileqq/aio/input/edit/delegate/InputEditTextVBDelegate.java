package com.tencent.mobileqq.aio.input.edit.delegate;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.AIOInputUtil;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextUIState;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate;
import com.tencent.mobileqq.aio.input.edit.delegate.g;
import com.tencent.mobileqq.aio.input.edit.delegate.o;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 i2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0002DjB\u000f\u0012\u0006\u0010Q\u001a\u00020\u0004\u00a2\u0006\u0004\bh\u0010PJ\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020,H\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u0010\n\u001a\u000201H\u0002J\u0010\u00104\u001a\u00020\u00072\u0006\u0010\n\u001a\u000203H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u0010\n\u001a\u000205H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u0010\n\u001a\u000207H\u0002J%\u0010=\u001a\u00020\u0007*\u0002092\u0017\u0010<\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00070:\u00a2\u0006\u0002\b;H\u0002J\b\u0010>\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0005H\u0016J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020\u0007H\u0016J\u0018\u0010G\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030F\u0018\u00010EH\u0016J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010J\u001a\u00020,2\u0006\u0010+\u001a\u00020IH\u0016J\b\u0010K\u001a\u00020\u0007H\u0016R\"\u0010Q\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010T\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010[\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00108R\u0014\u0010a\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010ZR\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "j", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$ReplaceTextToEditTextUIState;", "state", UserInfo.SEX_FEMALE, "p", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$PostToDoRunnableUIState;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetEnableStatusUIState;", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "hintText", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "delayTime", "O", "u", "G", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetEditTextContentUIState;", "K", ReportConstant.COSTREPORT_PREFIX, "t", "content", "r", "B", "", "position", "N", "H", "", "Landroid/text/InputFilter;", DomainData.DOMAIN_NAME, "()[Landroid/text/InputFilter;", "Y", "Lcom/tencent/mobileqq/aio/input/edit/delegate/o$a;", "stateCmd", "Landroid/os/Bundle;", "v", "y", "w", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotDrawDataUIState;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotWriteDataUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$UpdateRobotPromptFunctionDataUIState;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextUIState$SetAIBusinessFlag;", "I", "Landroid/widget/EditText;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "editAction", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "binding", "U", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "a", "", "Ljava/lang/Class;", "getObserverStates", "P", "Lcom/tencent/mvi/api/ability/d;", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/input/adorn/b;", "o", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "X", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "e", "Landroid/widget/EditText;", "mEditText", "", "f", "Ljava/lang/String;", "mInputEnableChangeReason", tl.h.F, "Landroid/os/Bundle;", "mVBReusableBundle", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextVBDelegate$b;", "i", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextVBDelegate$b;", "mImeHelper", "mRobotBusinessFlag", "mRobotCallbackDatas", "", "D", "Lkotlin/Lazy;", "T", "()Z", "isClearAllSwitchOn", "<init>", "E", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class InputEditTextVBDelegate implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.adorn.e> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Bundle mRobotCallbackDatas;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy isClearAllSwitchOn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mInputEnableChangeReason;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle mVBReusableBundle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mImeHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mRobotBusinessFlag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextVBDelegate$a;", "", "", "EMO_EXPECT_CHAR_LENGTH", "I", "EMO_LIMIT_COUNT", "", "KEY_EXIT_CLEAR_ALL", "Ljava/lang/String;", "NEW_LINE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextVBDelegate$b;", "", "", DomainData.DOMAIN_NAME, "g", "Landroid/widget/EditText;", "editText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "", "delayTime", "e", "j", "l", "Ljava/lang/ref/WeakReference;", "a", "Ljava/lang/ref/WeakReference;", "editTextRef", "Ljava/lang/Runnable;", "b", "Ljava/lang/Runnable;", "mOnWindowBeFocusedAction", "c", "mDelayShowSoftInputCallback", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "mWindowFocusChangeListener", tl.h.F, "()Landroid/widget/EditText;", "mEditText", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<EditText> editTextRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Runnable mOnWindowBeFocusedAction;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Runnable mDelayShowSoftInputCallback;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusChangeListener;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mWindowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.k
                    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                    public final void onWindowFocusChanged(boolean z16) {
                        InputEditTextVBDelegate.b.i(InputEditTextVBDelegate.b.this, z16);
                    }
                };
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j();
        }

        private final void g() {
            Runnable runnable = this.mOnWindowBeFocusedAction;
            if (runnable != null) {
                runnable.run();
            }
            this.mOnWindowBeFocusedAction = null;
        }

        private final EditText h() {
            WeakReference<EditText> weakReference = this.editTextRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(b this$0, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z16) {
                this$0.g();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.n();
        }

        private final void n() {
            Context context;
            try {
                EditText h16 = h();
                if (h16 != null && (context = h16.getContext()) != null) {
                    Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    if (!((InputMethodManager) systemService).showSoftInput(h(), 0)) {
                        QLog.e(".InputEditTextVBDelegate", 1, "showSoftInput fail");
                    }
                }
            } catch (Throwable th5) {
                QLog.i(".InputEditTextVBDelegate", 1, "[showSoftInput], " + th5);
            }
        }

        public final void d() {
            ViewTreeObserver viewTreeObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(".InputEditTextVBDelegate", 1, "[addWindowFocusListener]: addOnWindowFocusChangeListener " + this.mWindowFocusChangeListener.hashCode());
            EditText h16 = h();
            if (h16 != null && (viewTreeObserver = h16.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
            }
        }

        public final void e(long delayTime) {
            EditText h16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, delayTime);
                return;
            }
            Runnable runnable = this.mDelayShowSoftInputCallback;
            if (runnable != null && (h16 = h()) != null) {
                h16.removeCallbacks(runnable);
            }
            this.mDelayShowSoftInputCallback = new Runnable() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.m
                @Override // java.lang.Runnable
                public final void run() {
                    InputEditTextVBDelegate.b.f(InputEditTextVBDelegate.b.this);
                }
            };
            EditText h17 = h();
            if (h17 != null) {
                h17.postDelayed(this.mDelayShowSoftInputCallback, delayTime);
            }
        }

        public final void j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            EditText h16 = h();
            if (h16 != null) {
                h16.requestFocus();
                if (h16.hasWindowFocus()) {
                    n();
                } else {
                    this.mOnWindowBeFocusedAction = new Runnable() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            InputEditTextVBDelegate.b.k(InputEditTextVBDelegate.b.this);
                        }
                    };
                }
            }
        }

        public final void l() {
            EditText h16;
            ViewTreeObserver viewTreeObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            QLog.i(".InputEditTextVBDelegate", 1, "[resetState]: removeOnWindowFocusChangeListener " + this.mWindowFocusChangeListener.hashCode());
            EditText h17 = h();
            if (h17 != null && (viewTreeObserver = h17.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
            }
            Runnable runnable = this.mDelayShowSoftInputCallback;
            if (runnable != null && (h16 = h()) != null) {
                h16.removeCallbacks(runnable);
            }
            this.mOnWindowBeFocusedAction = null;
        }

        public final void m(@NotNull EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) editText);
            } else {
                Intrinsics.checkNotNullParameter(editText, "editText");
                this.editTextRef = new WeakReference<>(editText);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f189514e;

        public c(EditText editText) {
            this.f189514e = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputEditTextVBDelegate.this, (Object) editText);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) s16);
                return;
            }
            InputEditTextVBDelegate inputEditTextVBDelegate = InputEditTextVBDelegate.this;
            Editable editableText = this.f189514e.getEditableText();
            Intrinsics.checkNotNullExpressionValue(editableText, "editableText");
            inputEditTextVBDelegate.W(new g.a(editableText, this.f189514e.getSelectionStart(), this.f189514e.getLineCount()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J>\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/input/edit/delegate/InputEditTextVBDelegate$d", "Landroid/text/InputFilter;", "Landroid/text/Spanned;", "spanned", "", "start", "end", "a", "", "source", "dest", "dstart", "dend", "filter", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements InputFilter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputEditTextVBDelegate.this);
            }
        }

        private final int a(Spanned spanned, int start, int end) {
            EmoticonSpan[] emoticonSpanArr;
            if (end - start < 0 || start < 0 || spanned == null || (emoticonSpanArr = (EmoticonSpan[]) spanned.getSpans(start, end, EmoticonSpan.class)) == null) {
                return 0;
            }
            return emoticonSpanArr.length;
        }

        @Override // android.text.InputFilter
        @Nullable
        public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, source, Integer.valueOf(start), Integer.valueOf(end), dest, Integer.valueOf(dstart), Integer.valueOf(dend));
            }
            if (!(source instanceof Spanned)) {
                return null;
            }
            if (dest != null) {
                i3 = dest.length();
            } else {
                i3 = 0;
            }
            if (((i3 - (dend - dstart)) + end) - start < 1040) {
                return null;
            }
            int a16 = a(dest, 0, dstart - 1);
            int a17 = a(dest, dend, i3);
            int a18 = a((Spanned) source, start, end);
            if (a18 > 0 && a16 + a18 + a17 > 520) {
                InputEditTextVBDelegate.this.Y();
                return "";
            }
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/aio/input/edit/delegate/InputEditTextVBDelegate$e", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e implements InputFilter {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputEditTextVBDelegate.this);
            }
        }

        @Override // android.text.InputFilter
        @Nullable
        public CharSequence filter(@NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, source, Integer.valueOf(start), Integer.valueOf(end), dest, Integer.valueOf(dstart), Integer.valueOf(dend));
            }
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            int a16 = AIOEditText.INSTANCE.a() - (dest.length() - (dend - dstart));
            if (a16 <= 0) {
                if (start < end) {
                    InputEditTextVBDelegate.this.Y();
                }
                return "";
            }
            if (a16 >= end - start) {
                return null;
            }
            int i3 = a16 + start;
            if (!Character.isHighSurrogate(source.charAt(i3 - 1)) || i3 - 1 != start) {
                InputEditTextVBDelegate.this.Y();
                return source.subSequence(start, i3);
            }
            InputEditTextVBDelegate.this.Y();
            return "";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InputEditTextVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mInputEnableChangeReason = "";
        this.mVBReusableBundle = new Bundle();
        this.mImeHelper = new b();
        this.mRobotCallbackDatas = new Bundle();
        lazy = LazyKt__LazyJVMKt.lazy(InputEditTextVBDelegate$isClearAllSwitchOn$2.INSTANCE);
        this.isClearAllSwitchOn = lazy;
    }

    private final void A(CharSequence hintText) {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setHint(hintText);
    }

    private final void B(final CharSequence content) {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        l(editText, new Function1<EditText, Unit>(content) { // from class: com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate$handleInsertInSelection$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ CharSequence $content;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$content = content;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputEditTextVBDelegate.this, (Object) content);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditText editText2) {
                invoke2(editText2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditText checkEnable) {
                EditText editText2;
                EditText editText3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) checkEnable);
                    return;
                }
                Intrinsics.checkNotNullParameter(checkEnable, "$this$checkEnable");
                Editable editableText = checkEnable.getEditableText();
                editText2 = InputEditTextVBDelegate.this.mEditText;
                EditText editText4 = null;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    editText2 = null;
                }
                int selectionStart = editText2.getSelectionStart();
                editText3 = InputEditTextVBDelegate.this.mEditText;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                } else {
                    editText4 = editText3;
                }
                editableText.replace(selectionStart, editText4.getSelectionEnd(), this.$content);
            }
        });
    }

    private final void C(final InputEditTextUIState.PostToDoRunnableUIState state) {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.post(new Runnable() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.j
            @Override // java.lang.Runnable
            public final void run() {
                InputEditTextVBDelegate.E(InputEditTextUIState.PostToDoRunnableUIState.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(InputEditTextUIState.PostToDoRunnableUIState state) {
        Intrinsics.checkNotNullParameter(state, "$state");
        state.a().run();
    }

    private final void F(final InputEditTextUIState.ReplaceTextToEditTextUIState state) {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        l(editText, new Function1<EditText, Unit>() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate$handleReplaceTextToEditTextState$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputEditTextUIState.ReplaceTextToEditTextUIState.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditText editText2) {
                invoke2(editText2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditText checkEnable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) checkEnable);
                    return;
                }
                Intrinsics.checkNotNullParameter(checkEnable, "$this$checkEnable");
                Editable editableText = checkEnable.getEditableText();
                if (editableText != null) {
                    editableText.replace(InputEditTextUIState.ReplaceTextToEditTextUIState.this.c(), InputEditTextUIState.ReplaceTextToEditTextUIState.this.b(), InputEditTextUIState.ReplaceTextToEditTextUIState.this.a());
                }
            }
        });
    }

    private final void G() {
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        if (!editText.isFocusable()) {
            QLog.i(".InputEditTextVBDelegate", 1, "input isn't focusable and cannot request focus");
            return;
        }
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        editText2.requestFocus();
    }

    private final void H() {
        boolean z16;
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            editText2 = editText;
        }
        if (editText2 != null) {
            editText2.selectAll();
        }
    }

    private final void I(InputEditTextUIState.SetAIBusinessFlag state) {
        if (QLog.isColorLevel()) {
            QLog.i(".InputEditTextVBDelegate", 1, "handleSetAIBusinessFlag state.type = " + state.a());
        }
        int a16 = state.a();
        this.mRobotBusinessFlag = a16;
        if (a16 == 0) {
            CharSequence hintText = this.mRobotCallbackDatas.getCharSequence("placeHolder", "");
            Intrinsics.checkNotNullExpressionValue(hintText, "hintText");
            A(hintText);
            this.mRobotCallbackDatas.clear();
            return;
        }
        if (a16 == 1) {
            Bundle bundle = this.mRobotCallbackDatas;
            EditText editText = this.mEditText;
            EditText editText2 = null;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            bundle.putCharSequence("placeHolder", editText.getHint());
            EditText editText3 = this.mEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                editText2 = editText3;
            }
            String string = editText2.getContext().getString(R.string.f160841w4);
            Intrinsics.checkNotNullExpressionValue(string, "mEditText.context.getStr\u2026R.string.input_to_search)");
            A(string);
        }
    }

    private final void K(final InputEditTextUIState.SetEditTextContentUIState state) {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        l(editText, new Function1<EditText, Unit>() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate$handleSetEditTextContent$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputEditTextUIState.SetEditTextContentUIState.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditText editText2) {
                invoke2(editText2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditText checkEnable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) checkEnable);
                    return;
                }
                Intrinsics.checkNotNullParameter(checkEnable, "$this$checkEnable");
                checkEnable.setText(InputEditTextUIState.SetEditTextContentUIState.this.a());
                checkEnable.setSelection(checkEnable.getText().length());
            }
        });
    }

    private final void L(InputEditTextUIState.SetEnableStatusUIState state) {
        this.mInputEnableChangeReason = state.a();
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setEnabled(state.b());
    }

    private final void N(int position) {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setSelection(position);
    }

    private final void O(long delayTime) {
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        if (!editText.isFocusable()) {
            QLog.i(".InputEditTextVBDelegate", 1, "input isn't focusable and cannot invoke keyboard now");
            return;
        }
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        if (editText2.getVisibility() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(getMHost().getTag() + ".InputEditTextVBDelegate", 2, "realShowSoftInput input is invisible");
                return;
            }
            return;
        }
        if (delayTime > 0) {
            this.mImeHelper.e(delayTime);
        } else {
            this.mImeHelper.j();
        }
    }

    private final void Q(InputEditTextUIState.UpdateRobotDrawDataUIState state) {
        if (QLog.isColorLevel()) {
            QLog.i(".InputEditTextVBDelegate", 1, "handleUpdateRobotDrawData state.type = " + state.f() + ", state.styleName = " + state.e() + ", state.styleData = " + state.d() + ", state.requireName = " + state.c() + ", state.requireData = " + state.b() + ", state.callbackData = " + state.a());
        }
        int f16 = state.f();
        if (f16 != 1) {
            if (f16 != 2) {
                if (f16 == 3) {
                    this.mRobotCallbackDatas.putString("callback", state.a());
                    return;
                }
                return;
            } else {
                this.mRobotCallbackDatas.putString("require_name", state.c());
                this.mRobotCallbackDatas.putString("require_data", state.b());
                return;
            }
        }
        this.mRobotCallbackDatas.putString(QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, state.e());
        this.mRobotCallbackDatas.putString("style_Data", state.d());
    }

    private final void R(InputEditTextUIState.UpdateRobotPromptFunctionDataUIState state) {
        if (QLog.isColorLevel()) {
            QLog.i(".InputEditTextVBDelegate", 1, "handleUpdateRobotPromptFunctionData state.type = " + state.d() + ", state.template = " + state.c() + ", state.placeHolder = " + state.b() + ", state.data = " + state.a());
        }
        this.mRobotCallbackDatas.putString("item_template", state.c());
        this.mRobotCallbackDatas.putSerializable("item_data", state.a());
        if (!this.mRobotCallbackDatas.containsKey("placeHolder")) {
            Bundle bundle = this.mRobotCallbackDatas;
            EditText editText = this.mEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            bundle.putCharSequence("placeHolder", editText.getHint());
        }
        String b16 = state.b();
        if (b16 != null) {
            A(b16);
        }
    }

    private final void S(InputEditTextUIState.UpdateRobotWriteDataUIState state) {
        if (QLog.isColorLevel()) {
            QLog.i(".InputEditTextVBDelegate", 1, "handleUpdateRobotWriteData state.type = " + state.d() + ", state.template = " + state.c() + ", state.placeHolder = " + state.b() + ", state.data = " + state.a());
        }
        int d16 = state.d();
        if (d16 != 1) {
            if (d16 == 2) {
                this.mRobotCallbackDatas.putSerializable("require_template", state.c());
                this.mRobotCallbackDatas.putSerializable("require_data", state.a());
                return;
            }
            return;
        }
        this.mRobotCallbackDatas.putSerializable("item_template", state.c());
        this.mRobotCallbackDatas.putSerializable("item_data", state.a());
        if (!this.mRobotCallbackDatas.containsKey("placeHolder")) {
            Bundle bundle = this.mRobotCallbackDatas;
            EditText editText = this.mEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            bundle.putCharSequence("placeHolder", editText.getHint());
        }
        String b16 = state.b();
        if (b16 != null) {
            A(b16);
        }
    }

    private final boolean T() {
        return ((Boolean) this.isClearAllSwitchOn.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Context context = editText.getContext();
        if (context != null) {
            QQToast.makeText(context, R.string.c8h, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setFilters(n());
        editText.setEditableFactory(((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getInputQQTextBuilder());
        editText.addTextChangedListener(new c(editText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(InputEditTextVBDelegate this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        if (Intrinsics.areEqual(view, editText)) {
            QLog.i(".InputEditTextVBDelegate", 1, "mEditText focusChanged hasFocus = " + z16);
        }
    }

    private final void l(EditText editText, Function1<? super EditText, Unit> function1) {
        if (!editText.isEnabled()) {
            QLog.d(".InputEditTextVBDelegate", 1, "editText is unable now for reason=" + this.mInputEnableChangeReason + ", edit is not allowed");
            return;
        }
        function1.invoke(editText);
    }

    private final void m() {
        boolean z16;
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(".InputEditTextVBDelegate", 1, "clearAll return, text isNullOrEmpty");
            }
        } else if (T()) {
            EditText editText3 = this.mEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                editText2 = editText3;
            }
            editText2.setText("");
        }
    }

    private final InputFilter[] n() {
        return new InputFilter[]{new e(), new d()};
    }

    private final void p() {
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Editable text = editText.getText();
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        text.insert(editText2.getSelectionStart(), "\n");
    }

    private final void r(final CharSequence content) {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        l(editText, new Function1<EditText, Unit>(content) { // from class: com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextVBDelegate$handleAppendContentToEditText$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ CharSequence $content;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$content = content;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) content);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditText editText2) {
                invoke2(editText2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditText checkEnable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) checkEnable);
                } else {
                    Intrinsics.checkNotNullParameter(checkEnable, "$this$checkEnable");
                    checkEnable.append(this.$content);
                }
            }
        });
    }

    private final void s() {
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        int selectionStart = editText.getSelectionStart();
        if (selectionStart == 0) {
            return;
        }
        try {
            EditText editText3 = this.mEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                editText2 = editText3;
            }
            Editable text = editText2.getText();
            int offsetBefore = TextUtils.getOffsetBefore(text, selectionStart);
            if (selectionStart != offsetBefore) {
                text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final void t() {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setText("");
    }

    private final void u() {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.clearFocus();
    }

    private final Bundle v(o.a stateCmd) {
        com.tencent.mobileqq.aio.utils.l lVar = com.tencent.mobileqq.aio.utils.l.f194165a;
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        stateCmd.b(lVar.b(editText, this.mRobotBusinessFlag, this.mRobotCallbackDatas));
        return this.mVBReusableBundle;
    }

    private final Bundle w() {
        Bundle bundle = this.mVBReusableBundle;
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        bundle.putInt("input_line_count", editText.getLineCount());
        return bundle;
    }

    private final Bundle x() {
        String f16 = AIOInputUtil.f189159a.f(this.mRobotBusinessFlag, this.mRobotCallbackDatas);
        this.mRobotCallbackDatas.putString("callback", f16);
        Bundle bundle = this.mVBReusableBundle;
        bundle.putString("input_callback_data", f16);
        return bundle;
    }

    private final Bundle y() {
        Bundle bundle = this.mVBReusableBundle;
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        bundle.putCharSequence("input_text", editText.getText());
        return bundle;
    }

    private final void z() {
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Object systemService = editText.getContext().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        IBinder windowToken = editText2.getWindowToken();
        if (windowToken != null) {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof InputEditTextUIState.SetHintTextUIState) {
            A(((InputEditTextUIState.SetHintTextUIState) state).a());
            return;
        }
        if (state instanceof InputEditTextUIState.ShowKeyboardUIState) {
            O(((InputEditTextUIState.ShowKeyboardUIState) state).a());
            return;
        }
        if (state instanceof InputEditTextUIState.HideKeyboardUIState) {
            z();
            return;
        }
        if (state instanceof InputEditTextUIState.BackSpaceInEditTextUIState) {
            s();
            return;
        }
        if (state instanceof InputEditTextUIState.ClearEditTextFocusUIState) {
            u();
            return;
        }
        if (state instanceof InputEditTextUIState.RequestEditTextFocusUIState) {
            G();
            return;
        }
        if (state instanceof InputEditTextUIState.SetEditTextContentUIState) {
            K((InputEditTextUIState.SetEditTextContentUIState) state);
            return;
        }
        if (state instanceof InputEditTextUIState.ClearEditTextContentUIState) {
            t();
            return;
        }
        if (state instanceof InputEditTextUIState.AppendContentToEditTextUIState) {
            r(((InputEditTextUIState.AppendContentToEditTextUIState) state).a());
            return;
        }
        if (state instanceof InputEditTextUIState.ReplaceTextToEditTextUIState) {
            F((InputEditTextUIState.ReplaceTextToEditTextUIState) state);
            return;
        }
        if (state instanceof InputEditTextUIState.InsertInSelectionUIState) {
            B(((InputEditTextUIState.InsertInSelectionUIState) state).a());
            return;
        }
        if (state instanceof InputEditTextUIState.SelectAllUIState) {
            H();
            return;
        }
        if (state instanceof InputEditTextUIState.SetSelectionUIState) {
            N(((InputEditTextUIState.SetSelectionUIState) state).a());
            return;
        }
        if (state instanceof InputEditTextUIState.SetEnableStatusUIState) {
            L((InputEditTextUIState.SetEnableStatusUIState) state);
            return;
        }
        if (state instanceof InputEditTextUIState.AddNewLineUIState) {
            p();
            return;
        }
        if (state instanceof InputEditTextUIState.PostToDoRunnableUIState) {
            C((InputEditTextUIState.PostToDoRunnableUIState) state);
            return;
        }
        if (state instanceof InputEditTextUIState.UpdateRobotDrawDataUIState) {
            Q((InputEditTextUIState.UpdateRobotDrawDataUIState) state);
            return;
        }
        if (state instanceof InputEditTextUIState.UpdateRobotWriteDataUIState) {
            S((InputEditTextUIState.UpdateRobotWriteDataUIState) state);
        } else if (state instanceof InputEditTextUIState.UpdateRobotPromptFunctionDataUIState) {
            R((InputEditTextUIState.UpdateRobotPromptFunctionDataUIState) state);
        } else if (state instanceof InputEditTextUIState.SetAIBusinessFlag) {
            I((InputEditTextUIState.SetAIBusinessFlag) state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.adorn.e binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        EditText a16 = binding.a();
        this.mEditText = a16;
        b bVar = this.mImeHelper;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            a16 = null;
        }
        bVar.m(a16);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new InputEditTextVBDelegate$onViewParentPrepared$1(this, null), 2, null);
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void W(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mImeHelper.d();
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.i
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                InputEditTextVBDelegate.k(InputEditTextVBDelegate.this, view, z16);
            }
        });
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        m();
        c.a.e(this, reuseParam);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @NotNull
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bundle) iPatchRedirector.redirect((short) 9, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof o.a) {
            return v((o.a) stateCmd);
        }
        if (stateCmd instanceof o.d) {
            return y();
        }
        if (stateCmd instanceof o.b) {
            return w();
        }
        if (stateCmd instanceof o.c) {
            return x();
        }
        return this.mVBReusableBundle;
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{InputEditTextUIState.SetHintTextUIState.class, InputEditTextUIState.ShowKeyboardUIState.class, InputEditTextUIState.BackSpaceInEditTextUIState.class, InputEditTextUIState.ClearEditTextFocusUIState.class, InputEditTextUIState.RequestEditTextFocusUIState.class, InputEditTextUIState.SetEditTextContentUIState.class, InputEditTextUIState.ClearEditTextContentUIState.class, InputEditTextUIState.AppendContentToEditTextUIState.class, InputEditTextUIState.InsertInSelectionUIState.class, InputEditTextUIState.SelectAllUIState.class, InputEditTextUIState.SetSelectionUIState.class, InputEditTextUIState.AddNewLineUIState.class, InputEditTextUIState.ReplaceTextToEditTextUIState.class, InputEditTextUIState.PostToDoRunnableUIState.class, InputEditTextUIState.UpdateRobotDrawDataUIState.class, InputEditTextUIState.UpdateRobotWriteDataUIState.class, InputEditTextUIState.UpdateRobotPromptFunctionDataUIState.class, InputEditTextUIState.SetAIBusinessFlag.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mImeHelper.l();
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setOnFocusChangeListener(null);
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText3 = null;
        }
        Editable text = editText3.getText();
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            EditText editText4 = this.mEditText;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                editText2 = editText4;
            }
            l(editText2, InputEditTextVBDelegate$onDestroy$1.INSTANCE);
        }
    }
}
