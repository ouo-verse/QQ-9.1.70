package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTemplateCarouselInfo;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudRead$StTemplateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u0002:\u0002\u000f\u0010B!\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u00101\u001a\u0004\u0018\u000100\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105B\u0011\b\u0016\u0012\u0006\u0010/\u001a\u00020.\u00a2\u0006\u0004\b4\u00106B\u001b\b\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u00101\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\b4\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00069"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/widget/QFSPersonalTemplateCarouselView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", "e", "Landroid/view/View;", "iv", "", "token", "", "isToken", "f", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/t;", "info", "d", "a", "b", "Lcom/tencent/biz/qqcircle/immersive/personal/widget/a;", "listener", "setOnTemplateClickListener", "c", "v", NodeProps.ON_CLICK, "Landroid/view/View;", "templateCarouselView", "Lcom/tencent/biz/qqcircle/widgets/RoundImageView;", "Lcom/tencent/biz/qqcircle/widgets/RoundImageView;", "ivCover", "ivAvatar", tl.h.F, "viewSwitch", "i", "llBottom", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "tvTitle", BdhLogUtil.LogTag.Tag_Conn, "tvSubtitle", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "ivPublish", "E", "Lcom/tencent/biz/qqcircle/immersive/personal/widget/a;", "templateListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", UserInfo.SEX_FEMALE, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalTemplateCarouselView extends FrameLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView tvSubtitle;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView ivPublish;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private a templateListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View templateCarouselView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundImageView ivCover;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundImageView ivAvatar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View viewSwitch;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View llBottom;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/widget/QFSPersonalTemplateCarouselView$b;", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "loadState", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "Landroid/view/View;", "d", "Landroid/view/View;", "iv", "", "e", "Ljava/lang/String;", "token", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View iv;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String token;

        public b(@NotNull View iv5, @NotNull String token) {
            Intrinsics.checkNotNullParameter(iv5, "iv");
            Intrinsics.checkNotNullParameter(token, "token");
            this.iv = iv5;
            this.token = token;
            iv5.setTag(token);
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState loadState, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(option, "option");
            if (Intrinsics.areEqual(this.iv.getTag(), this.token) && loadState == LoadState.STATE_SUCCESS) {
                View view = this.iv;
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(new BitmapDrawable(option.getResultBitMap()));
                } else {
                    view.setBackground(new BitmapDrawable(option.getResultBitMap()));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalTemplateCarouselView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.gn_, this);
        e();
    }

    private final void a(QFSPersonalTemplateCarouselInfo info) {
        int i3;
        FeedCloudRead$StTemplateInfo templateInfo;
        PBStringField pBStringField;
        String str;
        RoundImageView roundImageView;
        RoundImageView roundImageView2 = this.ivAvatar;
        if (roundImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivAvatar");
            roundImageView2 = null;
        }
        if (info.getIsLogo()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        roundImageView2.setVisibility(i3);
        if (info.getIsLogo() && (templateInfo = info.getTemplateInfo()) != null && (pBStringField = templateInfo.QQLogo) != null && (str = pBStringField.get()) != null) {
            RoundImageView roundImageView3 = this.ivAvatar;
            if (roundImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivAvatar");
                roundImageView = null;
            } else {
                roundImageView = roundImageView3;
            }
            g(this, roundImageView, str, false, 4, null);
        }
    }

    private final void b(QFSPersonalTemplateCarouselInfo info) {
        RoundImageView roundImageView = this.ivCover;
        if (roundImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            roundImageView = null;
        }
        g(this, roundImageView, info.getCoverUrl(), false, 4, null);
    }

    private final void d(QFSPersonalTemplateCarouselInfo info) {
        TextView textView = this.tvTitle;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        textView.setText(info.getTitle());
        TextView textView3 = this.tvSubtitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        } else {
            textView2 = textView3;
        }
        textView2.setText(info.getSubtitle());
    }

    private final void e() {
        View findViewById = findViewById(R.id.f93945ay);
        findViewById.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026kListener(this)\n        }");
        this.templateCarouselView = findViewById;
        View findViewById2 = findViewById(R.id.duw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_cover)");
        this.ivCover = (RoundImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_avatar)");
        this.ivAvatar = (RoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.yqw);
        findViewById4.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<View>(R.id.\u2026kListener(this)\n        }");
        this.viewSwitch = findViewById4;
        View it = findViewById(R.id.ecw);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        f(it, "qvideo_skin_profile_publish_bg", true);
        Intrinsics.checkNotNullExpressionValue(it, "findViewById<View>(R.id.\u2026BLISH_BG, true)\n        }");
        this.llBottom = it;
        View findViewById5 = findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f167057me2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_subtitle)");
        this.tvSubtitle = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.y7b);
        ImageView it5 = (ImageView) findViewById7;
        Intrinsics.checkNotNullExpressionValue(it5, "it");
        f(it5, "qvideo_profile_publish_btn", true);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<ImageView>(\u2026LISH_BTN, true)\n        }");
        this.ivPublish = it5;
    }

    private final void f(View iv5, String token, boolean isToken) {
        if (isToken) {
            token = QCircleSkinHelper.getInstance().getUrl(token);
        }
        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
        Option url = Option.obtain().setUrl(token);
        Intrinsics.checkNotNullExpressionValue(token, "url");
        g16.loadImage(url, new b(iv5, token));
    }

    static /* synthetic */ void g(QFSPersonalTemplateCarouselView qFSPersonalTemplateCarouselView, View view, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        qFSPersonalTemplateCarouselView.f(view, str, z16);
    }

    public final void c(@NotNull QFSPersonalTemplateCarouselInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        b(info);
        a(info);
        d(info);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.yqw) {
            a aVar2 = this.templateListener;
            if (aVar2 != null) {
                aVar2.j8();
            }
        } else if (id5 == R.id.f93945ay && (aVar = this.templateListener) != null) {
            aVar.M6();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setOnTemplateClickListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.templateListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSPersonalTemplateCarouselView(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSPersonalTemplateCarouselView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
