package com.tencent.mobileqq.springhb.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringLoongCardApi;
import com.tencent.mobileqq.springhb.entry.model.SpringH5ResourceData;
import com.tencent.mobileqq.springhb.main.BrowserViewModel;
import com.tencent.mobileqq.springhb.main.SpringHbVideoView;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0014J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0011\u001a\u00020\u0005H\u0014J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010\u001fR\u0018\u00102\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/SpringHbTranslucentBrowserActivity;", "Lcom/tencent/mobileqq/activity/QQTranslucentBrowserActivity;", "Landroid/view/View$OnClickListener;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "", "doOnPause", "onBackEvent", "doOnResume", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "onPageFinished", "doOnDestroy", "themeChangeRightNow", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "initView", "Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView;", "V2", "initViewModel", "e3", "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "a0", "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "mBrowserViewModel", "b0", "Landroid/view/View;", "mVideoLayout", "Landroid/widget/RelativeLayout;", "c0", "Landroid/widget/RelativeLayout;", "mVideoViewContainer", "d0", "Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView;", "mVideoView", "Landroid/widget/ImageView;", "e0", "Landroid/widget/ImageView;", "mVideoJumpButton", "f0", "mVideoMuteButton", "g0", "mLoadingView", "h0", "Ljava/lang/String;", "musicOpenFilePath", "i0", "musicCloseFilePath", "j0", "Z", "isVideoPauseByBg", "<init>", "()V", "k0", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringHbTranslucentBrowserActivity extends QQTranslucentBrowserActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private BrowserViewModel mBrowserViewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View mVideoLayout;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mVideoViewContainer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private SpringHbVideoView mVideoView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ImageView mVideoJumpButton;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ImageView mVideoMuteButton;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private View mLoadingView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String musicOpenFilePath;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String musicCloseFilePath;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoPauseByBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/SpringHbTranslucentBrowserActivity$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.main.SpringHbTranslucentBrowserActivity$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/springhb/main/SpringHbTranslucentBrowserActivity$b", "Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView$b;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements SpringHbVideoView.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BrowserViewModel f289360a;

        b(BrowserViewModel browserViewModel) {
            this.f289360a = browserViewModel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) browserViewModel);
            }
        }

        @Override // com.tencent.mobileqq.springhb.main.SpringHbVideoView.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f289360a.U1().k();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60784);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SpringHbTranslucentBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SpringHbVideoView V2() {
        SpringHbVideoView springHbVideoView = SpringToMainHelper.gSpringHbVideoViewCache;
        if (springHbVideoView != null) {
            SpringToMainHelper.gSpringHbVideoViewCache = null;
            QLog.i("SpringHb_SpringHbTranslucentBrowserActivity", 2, "initSpringVideoView: use cache videoView");
            return springHbVideoView;
        }
        SpringHbVideoView springHbVideoView2 = new SpringHbVideoView(this);
        QLog.i("SpringHb_SpringHbTranslucentBrowserActivity", 2, "initSpringVideoView: no cache new a videoView");
        return springHbVideoView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e3() {
        Unit unit;
        Unit unit2;
        SpringHbVideoView springHbVideoView = this.mVideoView;
        ImageView imageView = null;
        if (springHbVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            springHbVideoView = null;
        }
        boolean z16 = !springHbVideoView.c();
        SpringHbVideoView springHbVideoView2 = this.mVideoView;
        if (springHbVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            springHbVideoView2 = null;
        }
        springHbVideoView2.setMute(z16);
        if (z16) {
            if (this.musicCloseFilePath != null) {
                ImageView imageView2 = this.mVideoMuteButton;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoMuteButton");
                    imageView2 = null;
                }
                imageView2.setImageDrawable(QWalletPicHelper.getDrawableForQWallet(this.musicCloseFilePath, ApngOptions.TRANSPARENT, new Bundle()));
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                ImageView imageView3 = this.mVideoMuteButton;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoMuteButton");
                } else {
                    imageView = imageView3;
                }
                imageView.setImageResource(R.drawable.nen);
                return;
            }
            return;
        }
        if (this.musicOpenFilePath != null) {
            ImageView imageView4 = this.mVideoMuteButton;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoMuteButton");
                imageView4 = null;
            }
            imageView4.setImageDrawable(QWalletPicHelper.getDrawableForQWallet(this.musicOpenFilePath, ApngOptions.TRANSPARENT, new Bundle()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ImageView imageView5 = this.mVideoMuteButton;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoMuteButton");
            } else {
                imageView = imageView5;
            }
            imageView.setImageResource(R.drawable.neo);
        }
    }

    private final void initView() {
        View findViewById = findViewById(R.id.b9v);
        if (findViewById == null) {
            QLog.e("SpringHb_SpringHbTranslucentBrowserActivity", 1, "initView return: get content fragmentfail.");
            finish();
            return;
        }
        ViewParent parent = findViewById.getParent();
        if (!(parent instanceof ViewGroup)) {
            QLog.e("SpringHb_SpringHbTranslucentBrowserActivity", 1, "initView return: get rootView fail.");
            finish();
            return;
        }
        View view = null;
        View inflate = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.hqs, (ViewGroup) null);
        if (inflate == null) {
            QLog.e("SpringHb_SpringHbTranslucentBrowserActivity", 1, "initView return: spring_webview_video_layout inflate fail.");
            finish();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        viewGroup.addView(inflate);
        inflate.setClickable(true);
        View findViewById2 = inflate.findViewById(R.id.f87674v0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "videoLayout.findViewById\u2026ing_video_view_container)");
        this.mVideoViewContainer = (RelativeLayout) findViewById2;
        this.mVideoView = V2();
        RelativeLayout relativeLayout = this.mVideoViewContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoViewContainer");
            relativeLayout = null;
        }
        SpringHbVideoView springHbVideoView = this.mVideoView;
        if (springHbVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            springHbVideoView = null;
        }
        relativeLayout.addView(springHbVideoView, new RelativeLayout.LayoutParams(-1, -1));
        View findViewById3 = inflate.findViewById(R.id.f87644ux);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "videoLayout.findViewById\u2026d.spring_video_jump_icon)");
        this.mVideoJumpButton = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f87664uz);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "videoLayout.findViewById\u2026d.spring_video_mute_icon)");
        this.mVideoMuteButton = (ImageView) findViewById4;
        this.mVideoLayout = inflate;
        ImageView imageView = this.mVideoJumpButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoJumpButton");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.mVideoMuteButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoMuteButton");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        View loadingView = ((ISpringLoongCardApi) QRoute.api(ISpringLoongCardApi.class)).getLoadingView(this);
        Intrinsics.checkNotNullExpressionValue(loadingView, "api(ISpringLoongCardApi:\u2026ava).getLoadingView(this)");
        this.mLoadingView = loadingView;
        if (loadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            loadingView = null;
        }
        loadingView.setVisibility(8);
        View view2 = this.mLoadingView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        } else {
            view = view2;
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    private final void initViewModel() {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(this, new BrowserViewModel.b(intent)).get(BrowserViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026serViewModel::class.java)");
        BrowserViewModel browserViewModel = (BrowserViewModel) viewModel;
        getLifecycle().addObserver(browserViewModel);
        LiveData<Boolean> S1 = browserViewModel.S1();
        final SpringHbTranslucentBrowserActivity$initViewModel$1 springHbTranslucentBrowserActivity$initViewModel$1 = SpringHbTranslucentBrowserActivity$initViewModel$1.INSTANCE;
        S1.observe(this, new Observer() { // from class: com.tencent.mobileqq.springhb.main.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpringHbTranslucentBrowserActivity.W2(Function1.this, obj);
            }
        });
        LiveData<Pair<SpringH5ResourceData, Boolean>> N1 = browserViewModel.N1();
        final Function1<Pair<? extends SpringH5ResourceData, ? extends Boolean>, Unit> function1 = new Function1<Pair<? extends SpringH5ResourceData, ? extends Boolean>, Unit>() { // from class: com.tencent.mobileqq.springhb.main.SpringHbTranslucentBrowserActivity$initViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringHbTranslucentBrowserActivity.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends SpringH5ResourceData, ? extends Boolean> pair) {
                invoke2((Pair<? extends SpringH5ResourceData, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends SpringH5ResourceData, Boolean> pair) {
                ImageView imageView;
                SpringHbVideoView springHbVideoView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair);
                    return;
                }
                SpringH5ResourceData component1 = pair.component1();
                boolean booleanValue = pair.component2().booleanValue();
                QLog.d("SpringHb_SpringHbTranslucentBrowserActivity", 2, "observer: h5ResourceData = " + component1);
                if (component1 != null) {
                    SpringHbTranslucentBrowserActivity springHbTranslucentBrowserActivity = SpringHbTranslucentBrowserActivity.this;
                    String filePath = component1.filePath;
                    ImageView imageView2 = null;
                    if (filePath != null) {
                        Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                        springHbVideoView = springHbTranslucentBrowserActivity.mVideoView;
                        if (springHbVideoView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                            springHbVideoView = null;
                        }
                        String str = component1.filePath;
                        Intrinsics.checkNotNullExpressionValue(str, "h5ResourceData.filePath");
                        springHbVideoView.setVideoNativeFilePath(str, booleanValue);
                    }
                    String skipPath = component1.skipPath;
                    if (skipPath != null) {
                        Intrinsics.checkNotNullExpressionValue(skipPath, "skipPath");
                        imageView = springHbTranslucentBrowserActivity.mVideoJumpButton;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoJumpButton");
                        } else {
                            imageView2 = imageView;
                        }
                        imageView2.setImageDrawable(QWalletPicHelper.getDrawableForQWallet(component1.skipPath, ApngOptions.TRANSPARENT, new Bundle()));
                    }
                    component1.musicOpenPath = component1.musicOpenPath;
                    springHbTranslucentBrowserActivity.musicCloseFilePath = component1.musicClosePath;
                }
            }
        };
        N1.observe(this, new Observer() { // from class: com.tencent.mobileqq.springhb.main.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpringHbTranslucentBrowserActivity.Y2(Function1.this, obj);
            }
        });
        LiveData<Boolean> T1 = browserViewModel.T1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.springhb.main.SpringHbTranslucentBrowserActivity$initViewModel$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringHbTranslucentBrowserActivity.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v7, types: [android.view.View] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                SpringHbVideoView springHbVideoView;
                ?? r56;
                View view;
                SpringHbVideoView springHbVideoView2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                QLog.d("SpringHb_SpringHbTranslucentBrowserActivity", 2, "observer: vidoeLiveData visible = " + bool);
                SpringHbVideoView springHbVideoView3 = null;
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    view = SpringHbTranslucentBrowserActivity.this.mVideoLayout;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVideoLayout");
                        view = null;
                    }
                    view.setVisibility(0);
                    SpringHbTranslucentBrowserActivity.this.e3();
                    springHbVideoView2 = SpringHbTranslucentBrowserActivity.this.mVideoView;
                    if (springHbVideoView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                    } else {
                        springHbVideoView3 = springHbVideoView2;
                    }
                    springHbVideoView3.f();
                    return;
                }
                springHbVideoView = SpringHbTranslucentBrowserActivity.this.mVideoView;
                if (springHbVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                    springHbVideoView = null;
                }
                springHbVideoView.e();
                SpringHbTranslucentBrowserActivity.this.isVideoPauseByBg = false;
                r56 = SpringHbTranslucentBrowserActivity.this.mVideoLayout;
                if (r56 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoLayout");
                } else {
                    springHbVideoView3 = r56;
                }
                springHbVideoView3.setVisibility(8);
            }
        };
        T1.observe(this, new Observer() { // from class: com.tencent.mobileqq.springhb.main.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpringHbTranslucentBrowserActivity.Z2(Function1.this, obj);
            }
        });
        LiveData<Boolean> R1 = browserViewModel.R1();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.springhb.main.SpringHbTranslucentBrowserActivity$initViewModel$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringHbTranslucentBrowserActivity.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                ImageView imageView;
                ImageView imageView2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                ImageView imageView3 = null;
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    imageView2 = SpringHbTranslucentBrowserActivity.this.mVideoMuteButton;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVideoMuteButton");
                    } else {
                        imageView3 = imageView2;
                    }
                    imageView3.setVisibility(0);
                    return;
                }
                imageView = SpringHbTranslucentBrowserActivity.this.mVideoMuteButton;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoMuteButton");
                } else {
                    imageView3 = imageView;
                }
                imageView3.setVisibility(8);
            }
        };
        R1.observe(this, new Observer() { // from class: com.tencent.mobileqq.springhb.main.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpringHbTranslucentBrowserActivity.b3(Function1.this, obj);
            }
        });
        LiveData<Boolean> O1 = browserViewModel.O1();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.springhb.main.SpringHbTranslucentBrowserActivity$initViewModel$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringHbTranslucentBrowserActivity.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean visible) {
                View view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) visible);
                    return;
                }
                view = SpringHbTranslucentBrowserActivity.this.mLoadingView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
                    view = null;
                }
                Intrinsics.checkNotNullExpressionValue(visible, "visible");
                view.setVisibility(visible.booleanValue() ? 0 : 8);
            }
        };
        O1.observe(this, new Observer() { // from class: com.tencent.mobileqq.springhb.main.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpringHbTranslucentBrowserActivity.c3(Function1.this, obj);
            }
        });
        LiveData<Boolean> Q1 = browserViewModel.Q1();
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.springhb.main.SpringHbTranslucentBrowserActivity$initViewModel$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringHbTranslucentBrowserActivity.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v28, types: [android.view.View] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                View view;
                ImageView imageView;
                SpringHbVideoView springHbVideoView;
                SpringHbVideoView springHbVideoView2;
                SpringHbVideoView springHbVideoView3;
                SpringHbVideoView springHbVideoView4;
                ?? r46;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ImageView imageView2 = null;
                    if (!QQVideoPlaySDKManager.isSDKReady()) {
                        springHbVideoView3 = SpringHbTranslucentBrowserActivity.this.mVideoView;
                        if (springHbVideoView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                            springHbVideoView3 = null;
                        }
                        springHbVideoView3.e();
                        springHbVideoView4 = SpringHbTranslucentBrowserActivity.this.mVideoView;
                        if (springHbVideoView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                            springHbVideoView4 = null;
                        }
                        springHbVideoView4.g();
                        r46 = SpringHbTranslucentBrowserActivity.this.mVideoLayout;
                        if (r46 == 0) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoLayout");
                        } else {
                            imageView2 = r46;
                        }
                        imageView2.setVisibility(8);
                        return;
                    }
                    view = SpringHbTranslucentBrowserActivity.this.mVideoLayout;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVideoLayout");
                        view = null;
                    }
                    if (view.getVisibility() == 0) {
                        springHbVideoView = SpringHbTranslucentBrowserActivity.this.mVideoView;
                        if (springHbVideoView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                            springHbVideoView = null;
                        }
                        if (!springHbVideoView.d()) {
                            springHbVideoView2 = SpringHbTranslucentBrowserActivity.this.mVideoView;
                            if (springHbVideoView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                                springHbVideoView2 = null;
                            }
                            springHbVideoView2.f();
                        }
                    }
                    imageView = SpringHbTranslucentBrowserActivity.this.mVideoJumpButton;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVideoJumpButton");
                    } else {
                        imageView2 = imageView;
                    }
                    imageView2.setVisibility(0);
                }
            }
        };
        Q1.observe(this, new Observer() { // from class: com.tencent.mobileqq.springhb.main.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpringHbTranslucentBrowserActivity.d3(Function1.this, obj);
            }
        });
        SpringHbVideoView springHbVideoView = this.mVideoView;
        if (springHbVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            springHbVideoView = null;
        }
        springHbVideoView.setPlayListener(new b(browserViewModel));
        this.mBrowserViewModel = browserViewModel;
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity, com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity, com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState)).booleanValue();
        }
        boolean doOnCreate = super.doOnCreate(savedInstanceState);
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        initView();
        initViewModel();
        QLog.i("SpringHb_SpringHbTranslucentBrowserActivity", 1, "doOnCreate: ");
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity, com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        SpringHbVideoView springHbVideoView = this.mVideoView;
        if (springHbVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            springHbVideoView = null;
        }
        springHbVideoView.g();
        QLog.d("SpringHb_SpringHbTranslucentBrowserActivity", 2, "doOnDestroy...");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnPause();
        SpringHbVideoView springHbVideoView = this.mVideoView;
        SpringHbVideoView springHbVideoView2 = null;
        if (springHbVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            springHbVideoView = null;
        }
        if (springHbVideoView.d()) {
            this.isVideoPauseByBg = true;
            SpringHbVideoView springHbVideoView3 = this.mVideoView;
            if (springHbVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            } else {
                springHbVideoView2 = springHbVideoView3;
            }
            springHbVideoView2.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnResume();
        SpringHbVideoView springHbVideoView = this.mVideoView;
        SpringHbVideoView springHbVideoView2 = null;
        if (springHbVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            springHbVideoView = null;
        }
        if (springHbVideoView.getVisibility() == 0) {
            SpringHbVideoView springHbVideoView3 = this.mVideoView;
            if (springHbVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                springHbVideoView3 = null;
            }
            if (!springHbVideoView3.d() && this.isVideoPauseByBg) {
                SpringHbVideoView springHbVideoView4 = this.mVideoView;
                if (springHbVideoView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
                } else {
                    springHbVideoView2 = springHbVideoView4;
                }
                springHbVideoView2.f();
                this.isVideoPauseByBg = false;
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        MobileQQ.sMobileQQ.sendBroadcast(new Intent("action_spring_close_tool_loading"));
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            BrowserViewModel browserViewModel = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f87644ux) {
                BrowserViewModel browserViewModel2 = this.mBrowserViewModel;
                if (browserViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
                } else {
                    browserViewModel = browserViewModel2;
                }
                browserViewModel.h2(false);
            } else if (num != null && num.intValue() == R.id.f87664uz) {
                e3();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity, com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity, com.tencent.mobileqq.activity.QQBrowserActivity
    public void onPageFinished(@Nullable WebView view, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) url);
            return;
        }
        super.onPageFinished(view, url);
        QLog.i("SpringHb_SpringHbTranslucentBrowserActivity", 2, "webLoad finish url=" + url);
        BrowserViewModel browserViewModel = this.mBrowserViewModel;
        if (browserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
            browserViewModel = null;
        }
        browserViewModel.U1().i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean themeChangeRightNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }
}
