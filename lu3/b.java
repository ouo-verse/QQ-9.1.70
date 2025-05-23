package lu3;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B\u0019\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0010\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006*"}, d2 = {"Llu3/b;", "Landroid/app/Dialog;", "", "N", "", "layoutResID", "setContentView", "dismiss", "", "titleStr", ExifInterface.LATITUDE_SOUTH, "url", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "text", "Landroid/content/DialogInterface$OnClickListener;", "listener", "P", BdhLogUtil.LogTag.Tag_Req, "O", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "tipsText", "Landroid/widget/Button;", "D", "Landroid/widget/Button;", "leftBtn", "E", "rightBtn", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "closeBtn", "G", "retainBg", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;I)V", "H", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class b extends ReportDialog {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private TextView tipsText;

    /* renamed from: D, reason: from kotlin metadata */
    private Button leftBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView rightBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView closeBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView retainBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Llu3/b$a;", "", "Landroid/content/Context;", "context", "", "rewardUrl", "", "a", "PNG_DIALOG_CLOSE_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: lu3.b$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(@Nullable Context context, @Nullable String rewardUrl) {
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            if (miniAppProxy != null) {
                miniAppProxy.getDrawable(context, "https://minigame.gtimg.cn/game/static/letsgo/mini_game_va_retain_close_icon.png", 0, 0, null, true);
                miniAppProxy.getDrawable(context, rewardUrl, 0, 0, null, true);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* renamed from: lu3.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class ViewOnClickListenerC10746b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f415570e;

        ViewOnClickListenerC10746b(DialogInterface.OnClickListener onClickListener) {
            this.f415570e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f415570e;
            if (onClickListener != null) {
                onClickListener.onClick(b.this, 0);
            }
            if (b.this.isShowing()) {
                b.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f415572e;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f415572e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f415572e;
            if (onClickListener != null) {
                onClickListener.onClick(b.this, 0);
            }
            if (b.this.isShowing()) {
                b.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f415574e;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f415574e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f415574e;
            if (onClickListener != null) {
                onClickListener.onClick(b.this, 1);
            }
            if (b.this.isShowing()) {
                b.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Window window = super.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
        }
    }

    private final void N() {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy != null) {
            ((ImageView) findViewById(com.tencent.qqmini.minigame.R.id.mini_game_va_retain_close_btn)).setImageDrawable(miniAppProxy.getDrawable(getContext(), "https://minigame.gtimg.cn/game/static/letsgo/mini_game_va_retain_close_icon.png", 0, 0, null, true));
        }
    }

    public final void O(@Nullable DialogInterface.OnClickListener listener) {
        ImageView imageView = this.closeBtn;
        if (imageView != null) {
            imageView.setOnClickListener(new ViewOnClickListenerC10746b(listener));
        }
    }

    @NotNull
    public final b P(@Nullable String text, @Nullable DialogInterface.OnClickListener listener) {
        Button button = this.leftBtn;
        if (button != null) {
            button.setText(text);
        }
        Button button2 = this.leftBtn;
        if (button2 != null) {
            button2.setOnClickListener(new c(listener));
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b Q(@Nullable String url) {
        boolean z16;
        ImageView imageView;
        MiniAppProxy miniAppProxy;
        Drawable drawable;
        boolean isBlank;
        if (url != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(url);
            if (!isBlank) {
                z16 = false;
                if (!z16 && (imageView = this.retainBg) != null) {
                    miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                    if (miniAppProxy == null) {
                        drawable = miniAppProxy.getDrawable(getContext(), url, ViewUtils.dpToPx(442.0f), ViewUtils.dpToPx(266.0f), null);
                    } else {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                }
                return this;
            }
        }
        z16 = true;
        if (!z16) {
            miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            if (miniAppProxy == null) {
            }
            imageView.setImageDrawable(drawable);
        }
        return this;
    }

    @NotNull
    public final b R(@Nullable String text, @Nullable DialogInterface.OnClickListener listener) {
        TextView textView = this.rightBtn;
        if (textView != null) {
            textView.setText(text);
        }
        TextView textView2 = this.rightBtn;
        if (textView2 != null) {
            textView2.setBackground(new a());
        }
        TextView textView3 = this.rightBtn;
        if (textView3 != null) {
            textView3.setOnClickListener(new d(listener));
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b S(@Nullable String titleStr) {
        boolean z16;
        boolean isBlank;
        if (titleStr != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(titleStr);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    TextView textView = this.tipsText;
                    if (textView != null) {
                        textView.setVisibility(4);
                    }
                } else {
                    TextView textView2 = this.tipsText;
                    if (textView2 != null) {
                        textView2.setText(titleStr);
                    }
                    TextView textView3 = this.tipsText;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                }
                return this;
            }
        }
        z16 = true;
        if (!z16) {
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th5) {
            QMLog.e("YunGameDownloadRetainDialog", "dismiss throw:", th5);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        this.tipsText = (TextView) findViewById(com.tencent.qqmini.minigame.R.id.mini_game_va_retain_text);
        this.retainBg = (ImageView) findViewById(com.tencent.qqmini.minigame.R.id.mini_game_va_retain_bg);
        this.leftBtn = (Button) findViewById(com.tencent.qqmini.minigame.R.id.mini_game_va_retain_left_btn);
        this.rightBtn = (TextView) findViewById(com.tencent.qqmini.minigame.R.id.mini_game_va_retain_right_btn);
        this.closeBtn = (ImageView) findViewById(com.tencent.qqmini.minigame.R.id.mini_game_va_retain_close_btn);
        N();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }
}
