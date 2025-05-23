package com.tencent.mobileqq.springhb.main;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.model.SpringH5ResourceData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0002hiB\u000f\u0012\u0006\u0010d\u001a\u00020c\u00a2\u0006\u0004\be\u0010fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003J\u000e\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\bH\u0002J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\bR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R(\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\t0$0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010 R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010 R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010 R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00100R\u0016\u0010>\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010B\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010\u0018R\u0014\u0010D\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010\u0018R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010=R\u0017\u0010H\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\bF\u0010\u0018\u001a\u0004\bG\u0010\u001aR\u0017\u0010N\u001a\u00020I8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\t0O8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR%\u0010T\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\t0$0O8F\u00a2\u0006\u0006\u001a\u0004\bS\u0010QR\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0O8F\u00a2\u0006\u0006\u001a\u0004\bU\u0010QR\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0O8F\u00a2\u0006\u0006\u001a\u0004\bW\u0010QR\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\t0O8F\u00a2\u0006\u0006\u001a\u0004\bY\u0010QR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0O8F\u00a2\u0006\u0006\u001a\u0004\b[\u0010QR$\u0010b\u001a\u00020\b2\u0006\u0010]\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", "W1", NodeProps.VISIBLE, "showWebViewBg", "j2", SemanticAttributes.DbSystemValues.H2, "f2", "d2", "e2", "i2", "b2", "Z1", "url", ICustomDataEditor.STRING_ARRAY_PARAM_2, "i", "Z", "X1", "()Z", "g2", "(Z)V", "isUrlLoadFailed", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_showWebView", BdhLogUtil.LogTag.Tag_Conn, "_showWebViewBgLiveData", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/springhb/entry/model/SpringH5ResourceData;", "D", "_h5ResourceLiveData", "E", "_videoLiveData", UserInfo.SEX_FEMALE, "_showJumpBtnLiveData", "G", "_showMuteBtnLiveData", "H", "_loadingViewLiveData", "I", "_webErrorViewLiveData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "J", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsCloseToolLoading", "K", "Lcom/tencent/mobileqq/springhb/entry/model/SpringH5ResourceData;", "h5ResourceData", "", "L", "playVideoType", "M", "Ljava/lang/String;", "fromSrc", "N", "specialId", "P", "showJumpButton", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isLoop", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "P1", "needShowLoading", "Lcom/tencent/mobileqq/springhb/main/BaseStrategy;", "T", "Lcom/tencent/mobileqq/springhb/main/BaseStrategy;", "U1", "()Lcom/tencent/mobileqq/springhb/main/BaseStrategy;", "videoStrategy", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "showWebView", "N1", "h5ResourceLiveData", "T1", "videoLiveData", "Q1", "showJumpBtnLiveData", "R1", "showMuteBtnLiveData", "O1", "loadingViewLiveData", "value", "M1", "()Ljava/lang/String;", "c2", "(Ljava/lang/String;)V", "currentUrl", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", "U", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class BrowserViewModel extends ViewModel implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showWebViewBgLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<SpringH5ResourceData, Boolean>> _h5ResourceLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _videoLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showJumpBtnLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showMuteBtnLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _loadingViewLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _webErrorViewLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean mIsCloseToolLoading;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final SpringH5ResourceData h5ResourceData;

    /* renamed from: L, reason: from kotlin metadata */
    private final int playVideoType;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final String fromSrc;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private final String specialId;

    /* renamed from: P, reason: from kotlin metadata */
    private final boolean showJumpButton;

    /* renamed from: Q, reason: from kotlin metadata */
    private final boolean isLoop;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String url;

    /* renamed from: S, reason: from kotlin metadata */
    private final boolean needShowLoading;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final BaseStrategy videoStrategy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isUrlLoadFailed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showWebView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/BrowserViewModel$a;", "", "", "ACTION_SPRING_CLOSE_TOOL_LOADING", "Ljava/lang/String;", "KEY_NEED_SHOW_LOADING", "KEY_SPRING_FROM_SRC", "KEY_SPRING_H5_RESOURCE_DATA", "KEY_SPRING_PLAY_VIDEO_TYPE", "KEY_SPRING_SHARE_DATA", "KEY_SPRING_SHOW_JUMP_VIDEO_BUTTON", "KEY_SPRING_SPECIAL_ID", "REPORT_BUSS_ID", "REPORT_MODULE_ID", "REPORT_SUBMODULE_ID", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.main.BrowserViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/BrowserViewModel$b;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroid/content/Intent;", "a", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Intent intent;

        public b(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            } else {
                this.intent = intent;
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06);
            }
            Intrinsics.checkNotNullParameter(p06, "p0");
            if (p06.isAssignableFrom(BrowserViewModel.class)) {
                return new BrowserViewModel(this.intent);
            }
            throw new IllegalArgumentException("fail to construct viewmodel for " + p06);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60737);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BrowserViewModel(@NotNull Intent intent) {
        BaseStrategy cVar;
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this._showWebView = new MutableLiveData<>();
        this._showWebViewBgLiveData = new MutableLiveData<>();
        this._h5ResourceLiveData = new MutableLiveData<>();
        this._videoLiveData = new MutableLiveData<>();
        this._showJumpBtnLiveData = new MutableLiveData<>();
        this._showMuteBtnLiveData = new MutableLiveData<>();
        this._loadingViewLiveData = new MutableLiveData<>();
        this._webErrorViewLiveData = new MutableLiveData<>();
        this.mIsCloseToolLoading = new AtomicBoolean(false);
        SpringH5ResourceData springH5ResourceData = (SpringH5ResourceData) intent.getSerializableExtra("spring_h5_resource_data");
        this.h5ResourceData = springH5ResourceData;
        int intExtra = intent.getIntExtra("spring_play_video_type", 0);
        this.playVideoType = intExtra;
        this.fromSrc = intent.getStringExtra("spring_from_src");
        this.specialId = intent.getStringExtra("spring_special_id");
        boolean booleanExtra = intent.getBooleanExtra("spring_show_video_button", true);
        this.showJumpButton = booleanExtra;
        this.isLoop = intExtra == 1;
        String stringExtra = intent.getStringExtra("url");
        this.url = stringExtra == null ? "" : stringExtra;
        this.needShowLoading = intent.getBooleanExtra("spring_need_show_loading", true);
        if (intExtra == 16) {
            cVar = new h(this);
        } else if (intExtra == 8) {
            cVar = new d(this);
        } else if (springH5ResourceData != null && W1(springH5ResourceData.filePath) && intExtra != 0) {
            if (intExtra == 1) {
                cVar = new e(this);
            } else if (intExtra != 2 && intExtra != 4) {
                cVar = new c(this);
            } else {
                cVar = new i(this, booleanExtra);
            }
        } else {
            cVar = new c(this);
        }
        this.videoStrategy = cVar;
    }

    private final boolean W1(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(BrowserViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b2();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void onCreate(LifecycleOwner owner) {
        QLog.d("SpringHb_BrowserViewModel", 2, "onCreate:");
        this._h5ResourceLiveData.postValue(new Pair<>(this.h5ResourceData, Boolean.valueOf(this.isLoop)));
        this.videoStrategy.f();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy(LifecycleOwner owner) {
        QLog.d("SpringHb_BrowserViewModel", 2, "onDestroy:");
        b2();
        this.videoStrategy.h();
    }

    @NotNull
    public final String M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.url;
    }

    @NotNull
    public final LiveData<Pair<SpringH5ResourceData, Boolean>> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this._h5ResourceLiveData;
    }

    @NotNull
    public final LiveData<Boolean> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this._loadingViewLiveData;
    }

    public final boolean P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.needShowLoading;
    }

    @NotNull
    public final LiveData<Boolean> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this._showJumpBtnLiveData;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this._showMuteBtnLiveData;
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this._showWebView;
    }

    @NotNull
    public final LiveData<Boolean> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this._videoLiveData;
    }

    @NotNull
    public final BaseStrategy U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (BaseStrategy) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.videoStrategy;
    }

    public final boolean X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isUrlLoadFailed;
    }

    public final void Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.videoStrategy.i();
            this.isUrlLoadFailed = false;
        }
    }

    public final void a2(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        this.isUrlLoadFailed = false;
        c2(url);
        this.videoStrategy.j();
    }

    public final void b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else if (this.mIsCloseToolLoading.compareAndSet(false, true)) {
            MobileQQ.sMobileQQ.sendBroadcast(new Intent("action_spring_close_tool_loading"));
        }
    }

    public final void c2(@NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) value);
        } else {
            Intrinsics.checkNotNullParameter(value, "value");
            this.url = value;
        }
    }

    public final void d2(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, visible);
        } else {
            this._showJumpBtnLiveData.postValue(Boolean.valueOf(visible));
        }
    }

    public final void e2(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, visible);
        } else {
            this._loadingViewLiveData.postValue(Boolean.valueOf(visible));
        }
    }

    public final void f2(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, visible);
        } else {
            this._showMuteBtnLiveData.postValue(Boolean.valueOf(visible));
        }
    }

    public final void g2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.isUrlLoadFailed = z16;
        }
    }

    public final void h2(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, visible);
        } else {
            this._videoLiveData.postValue(Boolean.valueOf(visible));
        }
    }

    public final void i2(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, visible);
        } else {
            this._webErrorViewLiveData.postValue(Boolean.valueOf(visible));
        }
    }

    public final void j2(boolean visible, boolean showWebViewBg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(visible), Boolean.valueOf(showWebViewBg));
            return;
        }
        this._showWebView.postValue(Boolean.valueOf(visible));
        if (visible) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.main.b
                @Override // java.lang.Runnable
                public final void run() {
                    BrowserViewModel.k2(BrowserViewModel.this);
                }
            }, 500L);
        }
        this._showWebViewBgLiveData.postValue(Boolean.valueOf(showWebViewBg));
        QLog.i("SpringHb_BrowserViewModel", 2, "setWebViewVisible");
    }
}
