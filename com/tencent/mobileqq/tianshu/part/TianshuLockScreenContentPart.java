package com.tencent.mobileqq.tianshu.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.bean.TianshuLockScreenBean;
import com.tencent.mobileqq.tianshu.utils.a;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010\u001cR\u0016\u00103\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001d\u0010<\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/tianshu/part/TianshuLockScreenContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "initData", "C9", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "looping", "D9", NotificationCompat.GROUP_KEY_SILENT, "A9", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStop", "onPartDestroy", "onPartResume", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "backgroundImageView", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "backButton", "f", "voiceButton", h.F, "voiceImage", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "i", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "actionButton", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "tvTitle", BdhLogUtil.LogTag.Tag_Conn, "tvDes", "D", "leftIcon", "E", "bgTitle", UserInfo.SEX_FEMALE, "Z", "isSilent", "Lcom/tencent/mobileqq/tianshu/bean/TianshuLockScreenBean;", "G", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/tianshu/bean/TianshuLockScreenBean;", "initBean", "<init>", "()V", "H", "a", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TianshuLockScreenContentPart extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView tvDes;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView leftIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView bgTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isSilent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy initBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView backgroundImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout backButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout voiceButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView voiceImage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUIButton actionButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tianshu/part/TianshuLockScreenContentPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianshu.part.TianshuLockScreenContentPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/tianshu/part/TianshuLockScreenContentPart$b", "Lcom/tencent/mobileqq/tianshu/utils/a$a;", "", "url", "filePath", "", "a", "b", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements a.InterfaceC8652a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TianshuLockScreenContentPart.this);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.utils.a.InterfaceC8652a
        public void a(@NotNull String url, @Nullable String filePath) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) filePath);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            if (filePath != null) {
                TianshuLockScreenContentPart tianshuLockScreenContentPart = TianshuLockScreenContentPart.this;
                Uri ringUri = Uri.fromFile(new File(filePath));
                Intrinsics.checkNotNullExpressionValue(ringUri, "ringUri");
                TianshuLockScreenBean B9 = tianshuLockScreenContentPart.B9();
                if (B9 != null) {
                    z16 = B9.m();
                } else {
                    z16 = false;
                }
                tianshuLockScreenContentPart.D9(ringUri, z16);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.utils.a.InterfaceC8652a
        public void b(@NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            Uri ringUri = RingtoneManager.getDefaultUri(2);
            TianshuLockScreenContentPart tianshuLockScreenContentPart = TianshuLockScreenContentPart.this;
            Intrinsics.checkNotNullExpressionValue(ringUri, "ringUri");
            tianshuLockScreenContentPart.D9(ringUri, true);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TianshuLockScreenContentPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TianshuLockScreenBean>() { // from class: com.tencent.mobileqq.tianshu.part.TianshuLockScreenContentPart$initBean$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TianshuLockScreenContentPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final TianshuLockScreenBean invoke() {
                    Intent intent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TianshuLockScreenBean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Activity activity = TianshuLockScreenContentPart.this.getActivity();
                    TianshuLockScreenBean tianshuLockScreenBean = (activity == null || (intent = activity.getIntent()) == null) ? null : (TianshuLockScreenBean) intent.getParcelableExtra("init_bean");
                    if (tianshuLockScreenBean instanceof TianshuLockScreenBean) {
                        return tianshuLockScreenBean;
                    }
                    return null;
                }
            });
            this.initBean = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A9(boolean silent) {
        Context context;
        int i3;
        ImageView imageView = this.voiceImage;
        Drawable drawable = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceImage");
            imageView = null;
        }
        if (!silent) {
            context = getContext();
            if (context != null) {
                i3 = R.drawable.qui_voice_mute_icon_white;
                drawable = context.getDrawable(i3);
            }
        } else {
            context = getContext();
            if (context != null) {
                i3 = R.drawable.qui_voice_high_icon_white;
                drawable = context.getDrawable(i3);
            }
        }
        imageView.setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TianshuLockScreenBean B9() {
        return (TianshuLockScreenBean) this.initBean.getValue();
    }

    private final void C9() {
        String str;
        boolean z16;
        String str2;
        ArrayList arrayListOf;
        if (this.isSilent) {
            QLog.d("TianshuLockScreenContentPart", 1, "playRing fail, on silent");
            return;
        }
        QLog.d("TianshuLockScreenContentPart", 1, "playRing");
        TianshuLockScreenBean B9 = B9();
        if (B9 != null) {
            str = B9.l();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Uri ringUri = RingtoneManager.getDefaultUri(2);
            Intrinsics.checkNotNullExpressionValue(ringUri, "ringUri");
            D9(ringUri, true);
            return;
        }
        TianshuLockScreenBean B92 = B9();
        if (B92 == null || (str2 = B92.l()) == null) {
            str2 = "";
        }
        a aVar = a.f293183a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str2);
        aVar.c(arrayListOf, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9(Uri uri, boolean looping) {
        try {
            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                AudioUtil.p(uri, looping, false);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final void E9(float volume) {
        QLog.d("TianshuLockScreenContentPart", 1, "setVolume volume:" + volume);
        MediaPlayer mediaPlayer = AudioUtil.f306881c;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume, volume);
        }
    }

    private final void initData() {
        TianshuLockScreenBean B9 = B9();
        if (B9 != null) {
            TextView textView = this.tvDes;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvDes");
                textView = null;
            }
            textView.setText(B9.f());
            TextView textView2 = this.tvTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
                textView2 = null;
            }
            textView2.setText(B9.k());
            QUIButton qUIButton = this.actionButton;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionButton");
                qUIButton = null;
            }
            qUIButton.setText(B9.b());
            TextView textView3 = this.bgTitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgTitle");
                textView3 = null;
            }
            textView3.setText(B9.e());
            Option url = Option.obtain().setUrl(B9.j());
            ImageView imageView = this.leftIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftIcon");
                imageView = null;
            }
            Option leftOption = url.setTargetView(imageView);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(leftOption, "leftOption");
            qQPicLoader.e(leftOption, null);
            Option url2 = Option.obtain().setUrl(B9.c());
            ImageView imageView2 = this.backgroundImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                imageView2 = null;
            }
            Option option = url2.setTargetView(imageView2);
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        }
        A9(this.isSilent);
        C9();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            Intent intent = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.button_back) {
                Activity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else if (num != null && num.intValue() == R.id.v8y) {
                boolean z16 = !this.isSilent;
                this.isSilent = z16;
                if (z16) {
                    E9(0.0f);
                } else {
                    E9(1.0f);
                }
                A9(this.isSilent);
            } else if (num != null && num.intValue() == R.id.tiu) {
                Activity activity2 = getActivity();
                if (activity2 != null) {
                    TianshuLockScreenBean B9 = B9();
                    if (B9 != null) {
                        intent = B9.a();
                    }
                    activity2.startActivity(intent);
                }
                Activity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.finish();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.dcy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.image_background)");
        this.backgroundImageView = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.button_back);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.button_back)");
        this.backButton = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.v8y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.fl_voice)");
        this.voiceButton = (FrameLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.xiy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.image_voice)");
        this.voiceImage = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.tiu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.button_action)");
        this.actionButton = (QUIButton) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f107316a3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.tv_des)");
        this.tvDes = (TextView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.e7j);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.left_icon)");
        this.leftIcon = (ImageView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.t6i);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.bg_title)");
        this.bgTitle = (TextView) findViewById9;
        FrameLayout frameLayout = this.backButton;
        String str = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(this);
        FrameLayout frameLayout2 = this.voiceButton;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceButton");
            frameLayout2 = null;
        }
        frameLayout2.setOnClickListener(this);
        QUIButton qUIButton = this.actionButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        QUIButton qUIButton2 = this.actionButton;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionButton");
            qUIButton2 = null;
        }
        TianshuLockScreenBean B9 = B9();
        if (B9 != null) {
            str = B9.b();
        }
        qUIButton2.setText(str);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            AudioUtil.s();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        if (!this.isSilent) {
            E9(1.0f);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartStop(activity);
            E9(0.0f);
        }
    }
}
