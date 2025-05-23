package com.tencent.mobileqq.forward.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/forward/preview/ForwardPreViewForShareActionSheet;", "Lcom/tencent/mobileqq/forward/preview/ForwardPreView;", "Landroid/view/View;", "preView", "", "a", "Landroid/view/View$OnClickListener;", "listener", "setOnClickListenerForPreView", "Landroid/widget/EditText;", "i", "Landroid/widget/EditText;", "inputTextView", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/RelativeLayout;", "previewLayout", "Lcom/tencent/biz/qui/quibutton/QUIButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "confirmButton", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ForwardPreViewForShareActionSheet extends ForwardPreView {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QUIButton confirmButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditText inputTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout previewLayout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForwardPreViewForShareActionSheet(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ForwardPreViewForShareActionSheet this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e().putExtra("key_direct_show_uin_type", 0);
        this$0.e().putExtra("key_direct_show_uin", "1708153742");
        this$0.e().putExtra("uintype", 0);
        this$0.e().putExtra("uin", "1708153742");
        this$0.e().putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 3);
        this$0.e().putExtra("bundle_key_multi_share_fragment_config", "");
        if (this$0.b() != null) {
            ForwardBaseOption.startForwardActivityForResult(this$0.b(), this$0.e(), (Class<?>) ForwardRecentTranslucentActivity.class, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
        }
        b c16 = this$0.c();
        if (c16 != null) {
            c16.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.forward.preview.ForwardPreView
    public void a(@Nullable View preView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) preView);
            return;
        }
        setPreView(preView);
        if (preView != null) {
            this.previewLayout.addView(preView);
        }
    }

    @Override // com.tencent.mobileqq.forward.preview.ForwardPreView
    public void setOnClickListenerForPreView(@NotNull View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        View d16 = d();
        if (d16 != null) {
            d16.setOnClickListener(listener);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForwardPreViewForShareActionSheet(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ ForwardPreViewForShareActionSheet(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForwardPreViewForShareActionSheet(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.e9h, this);
        View findViewById = findViewById(R.id.f166351zj4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.multi_share_text)");
        this.inputTextView = (EditText) findViewById;
        View findViewById2 = findViewById(R.id.zit);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.multi_\u2026e_content_preview_layout)");
        this.previewLayout = (RelativeLayout) findViewById2;
        View findViewById3 = findViewById(R.id.f166349zj2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.multi_share_send_button)");
        QUIButton qUIButton = (QUIButton) findViewById3;
        this.confirmButton = qUIButton;
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.forward.preview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForwardPreViewForShareActionSheet.g(ForwardPreViewForShareActionSheet.this, view);
            }
        });
    }
}
