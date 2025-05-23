package ah3;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 U2\u00020\u0001:\u0001VB\u000f\u0012\u0006\u0010R\u001a\u00020Q\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0004R\u001e\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b!\u0010-\"\u0004\b.\u0010/R\"\u00104\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\"\u00108\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010,\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R\u0016\u0010\u0007\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b;\u0010AR\"\u0010G\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010;\u001a\u0004\b\u001e\u0010D\"\u0004\bE\u0010FR\u001a\u0010J\u001a\u0002098\u0006X\u0086D\u00a2\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bI\u0010DR\u001a\u0010M\u001a\u0002098\u0006X\u0086D\u00a2\u0006\f\n\u0004\bK\u0010;\u001a\u0004\bL\u0010DR\u001a\u0010P\u001a\u0002098\u0006X\u0086D\u00a2\u0006\f\n\u0004\bN\u0010;\u001a\u0004\bO\u0010D\u00a8\u0006W"}, d2 = {"Lah3/g;", "Landroid/app/AlertDialog;", "Lah3/h;", "cb", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "progress", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", "realProgress", "v", DomainData.DOMAIN_NAME, "l", "Landroid/view/View;", "kotlin.jvm.PlatformType", "d", "Landroid/view/View;", "halfScreenContentView", "e", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "f", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "halfScreenFloatingView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "title", "i", "description", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "downloadButton", "", "D", "Z", "()Z", "p", "(Z)V", "isDownloading", "E", "j", "setPaused", "isPaused", UserInfo.SEX_FEMALE, "g", "setCanDownload", "canDownload", "", "G", "I", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "H", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkvEntity", "", "Ljava/lang/String;", "KEY_SHOW_REMINDER", "J", "()I", "setDownloadCount", "(I)V", "downloadCount", "K", "getWaitDownload", "waitDownload", "L", "getPauseDownload", "pauseDownload", "M", "getOnDownload", "onDownload", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "N", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class g extends ReportAlertDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private QUIButton downloadButton;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isDownloading;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isPaused;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean canDownload;

    /* renamed from: G, reason: from kotlin metadata */
    private int progress;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MMKVOptionEntity mmkvEntity;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String KEY_SHOW_REMINDER;

    /* renamed from: J, reason: from kotlin metadata */
    private int downloadCount;

    /* renamed from: K, reason: from kotlin metadata */
    private final int waitDownload;

    /* renamed from: L, reason: from kotlin metadata */
    private final int pauseDownload;

    /* renamed from: M, reason: from kotlin metadata */
    private final int onDownload;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View halfScreenContentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView halfScreenFloatingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView title;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView description;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView imageView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"ah3/g$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        public View createContentView() {
            return g.this.container;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.halfScreenContentView = LayoutInflater.from(context).inflate(R.layout.h7s, (ViewGroup) null);
        View inflate = LayoutInflater.from(context).inflate(R.layout.h7r, (ViewGroup) null);
        this.container = inflate;
        View findViewById = inflate.findViewById(R.id.bkg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "container.findViewById(R.id.dialog_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = this.container.findViewById(R.id.uhp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "container.findViewById(R.id.dialog_description)");
        this.description = (TextView) findViewById2;
        View findViewById3 = this.container.findViewById(R.id.uhs);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "container.findViewById(R.id.dialog_image)");
        this.imageView = (ImageView) findViewById3;
        View findViewById4 = this.container.findViewById(R.id.agu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "container.findViewById(R.id.btn_download)");
        this.downloadButton = (QUIButton) findViewById4;
        MMKVOptionEntity from = QMMKV.from(context, QMMKVFile.FILE_ZPLAN);
        Intrinsics.checkNotNullExpressionValue(from, "from(context, QMMKVFile.FILE_ZPLAN)");
        this.mmkvEntity = from;
        this.KEY_SHOW_REMINDER = "can_show_reminder";
        this.waitDownload = 1;
        this.pauseDownload = 2;
        this.onDownload = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void m(float progress) {
        int color = getContext().getColor(R.color.qui_button_bg_primary_pressed);
        int color2 = getContext().getColor(R.color.qui_button_bg_primary_disable);
        int i3 = (int) (168 * getContext().getResources().getDisplayMetrics().density);
        int i16 = (int) (progress * i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadii(new float[]{10.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 10.0f, 10.0f});
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(color2);
        gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 10.0f, 10.0f, 10.0f, 10.0f, 0.0f, 0.0f});
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        layerDrawable.setLayerInset(0, 0, 0, i3 - i16, 0);
        layerDrawable.setLayerInset(1, i16, 0, 0, 0);
        this.downloadButton.setBackground(layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(g this$0, h cb5, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        this$0.canDownload = false;
        if (!this$0.isDownloading) {
            this$0.q(cb5);
            this$0.isPaused = false;
        } else {
            this$0.isPaused = true;
            cb5.onClickPause();
            this$0.downloadButton.setText("\u5df2\u6682\u505c " + this$0.progress + '%');
            this$0.isDownloading = false;
            this$0.canDownload = false;
            ch3.b bVar = ch3.b.f30847a;
            bVar.e(this$0.downloadButton, this$0.onDownload);
            bVar.g(this$0.downloadButton, this$0.pauseDownload);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(final h cb5) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), 1, "\u65e0\u7f51\u7edc\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", 0).show();
            return;
        }
        if (!NetworkUtil.isWifiConnected(getContext()) && this.mmkvEntity.decodeBool(this.KEY_SHOW_REMINDER, true)) {
            QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(getContext(), 230, "\u6d41\u91cf\u7f51\u7edc\u4f53\u9a8c\u63d0\u9192", "\u5f53\u524d\u5904\u4e8e\u975eWi-Fi\u7f51\u7edc\uff0c\u7ee7\u7eed\u4e0b\u8f7d\u4f1a\u6d88\u8017\u624b\u673a\u6d41\u91cf\uff0c\u786e\u8ba4\u8981\u4e0b\u8f7d\u5417\uff1f", "\u4e0d\u518d\u63d0\u9192", false, "\u53d6\u6d88", "\u7ee7\u7eed\u4e0b\u8f7d", new DialogInterface.OnClickListener() { // from class: ah3.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.r(g.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: ah3.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.s(g.this, cb5, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: ah3.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.t(g.this, dialogInterface, i3);
                }
            });
            createDialogWithCheckBox.setCanceledOnTouchOutside(true);
            createDialogWithCheckBox.show();
            ch3.b.f30847a.k(this);
            return;
        }
        this.canDownload = true;
        u(cb5);
        QLog.d("DownloadDialog", 1, "immediate download");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(g this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mmkvEntity.encodeBool(this$0.KEY_SHOW_REMINDER, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(g this$0, h cb5, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        this$0.canDownload = true;
        this$0.u(cb5);
        ch3.b bVar = ch3.b.f30847a;
        bVar.j(this$0, "download");
        bVar.l(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(g this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canDownload = false;
        ch3.b bVar = ch3.b.f30847a;
        bVar.j(this$0, "cancel");
        bVar.l(this$0);
    }

    private final void u(h cb5) {
        this.downloadCount++;
        cb5.a();
        this.isDownloading = true;
        if (this.downloadCount == 1) {
            ch3.b.f30847a.e(this.downloadButton, this.waitDownload);
        } else {
            ch3.b.f30847a.e(this.downloadButton, this.pauseDownload);
        }
        ch3.b.f30847a.g(this.downloadButton, this.onDownload);
    }

    /* renamed from: g, reason: from getter */
    public final boolean getCanDownload() {
        return this.canDownload;
    }

    /* renamed from: h, reason: from getter */
    public final int getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsDownloading() {
        return this.isDownloading;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsPaused() {
        return this.isPaused;
    }

    public final void l() {
        this.downloadButton.setText("\u7acb\u5373\u4e0b\u8f7d");
        this.isDownloading = false;
        this.isPaused = false;
        this.canDownload = false;
        this.progress = 0;
    }

    public final void n(@NotNull final h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.downloadButton.setOnClickListener(new View.OnClickListener() { // from class: ah3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.o(g.this, cb5, view);
            }
        });
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(savedInstanceState);
        setContentView(this.halfScreenContentView);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) this.halfScreenContentView.findViewById(R.id.f66753bh);
        this.halfScreenFloatingView = qUSHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setQUSDragFloatController(new b());
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: ah3.b
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    g.k(g.this);
                }
            });
        }
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 80;
        }
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.title.setText("\u8d44\u6e90\u66f4\u65b0");
        this.description.setText("\u672c\u6b21\u66f4\u65b0\u7ea660M\uff0c\u66f4\u65b0\u540e\u53ef\u4f7f\u7528\u634f\u8138\u3001\u62cd\u540c\u6b3e\u7b49\u529f\u80fd");
        this.title.setVisibility(0);
        this.description.setVisibility(0);
        this.imageView.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/innovate/zplan/ztp_display_image.png", URLDrawable.URLDrawableOptions.obtain()));
        this.imageView.setVisibility(0);
        this.downloadButton.setText("\u7acb\u5373\u4e0b\u8f7d");
        this.isDownloading = false;
        this.isPaused = false;
        this.progress = 0;
        ch3.b.f30847a.e(this.downloadButton, this.waitDownload);
    }

    public final void p(boolean z16) {
        this.isDownloading = z16;
    }

    public final void v(float realProgress) {
        int i3 = (int) (100 * realProgress);
        QUIButton qUIButton = this.downloadButton;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append('%');
        qUIButton.setText(sb5.toString());
        this.progress = i3;
        if (i3 > 0) {
            m(realProgress);
        }
    }
}
