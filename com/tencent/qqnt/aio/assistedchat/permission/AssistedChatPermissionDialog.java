package com.tencent.qqnt.aio.assistedchat.permission;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.b;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.qbasealbum.view.RoundCornerImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p81.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001%B!\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/permission/AssistedChatPermissionDialog;", "Lcom/tencent/qqnt/aio/assistedchat/permission/AssistedChatBaseDialog;", "", "Dh", "Ch", "", "position", "Bh", "Lcom/tencent/qqnt/qbasealbum/view/RoundCornerImageView;", "imageIv", "Eh", "Landroid/widget/TextView;", "titleTv", "Fh", "Landroid/content/Context;", "context", "yh", "Landroid/view/View;", "rh", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/aio/api/runtime/a;", "E", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlin/Function0;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "onAllowListener", "G", "Landroid/view/View;", "contentView", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlin/jvm/functions/Function0;)V", "H", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPermissionDialog extends AssistedChatBaseDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final Function0<Unit> onAllowListener;

    /* renamed from: G, reason: from kotlin metadata */
    private View contentView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/permission/AssistedChatPermissionDialog$a;", "", "", "ELEM_ID", "Ljava/lang/String;", "IMAGE_DARK", "IMAGE_LIGHT", "KEY_CLICK_POS", "TAG", "TITLE", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.permission.AssistedChatPermissionDialog$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/assistedchat/permission/AssistedChatPermissionDialog$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.o {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatPermissionDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AssistedChatPermissionDialog.this.Bh(0);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59825);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatPermissionDialog(@NotNull com.tencent.aio.api.runtime.a aioContext, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) function0);
        } else {
            this.aioContext = aioContext;
            this.onAllowListener = function0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(Context context, AssistedChatPermissionDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(context, 1, context.getString(R.string.cib), 0).show();
        } else {
            this$0.Bh(1);
            this$0.dismiss();
            Function0<Unit> function0 = this$0.onAllowListener;
            if (function0 != null) {
                function0.invoke();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(int position) {
        Map<String, String> mapOf;
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("click_pos", String.valueOf(position)));
        assistedChatPanelDtReporter.a("em_kl_reply_suggest_guide_pop", view, mapOf);
    }

    private final void Ch() {
        Map<String, String> mapOf;
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("click_pos", "0"));
        assistedChatPanelDtReporter.c("em_kl_reply_suggest_guide_pop", view, mapOf);
    }

    private final void Dh() {
        com.tencent.mobileqq.aio.utils.a e16;
        Map<String, Object> a16;
        QUSHalfScreenFloatingView qh5 = qh();
        if (qh5 != null) {
            if (this.aioContext.g().r().c().e() == 104) {
                ((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).setDtReportPageInfo(qh5, this.aioContext);
                return;
            }
            b.a g16 = com.tencent.mobileqq.aio.utils.b.f194119a.g();
            if (g16 != null && (e16 = g16.e()) != null && (a16 = e16.a()) != null) {
                VideoReport.setPageId(qh5, "pg_aio");
                VideoReport.setPageParams(qh5, new PageParams((Map<String, ?>) a16));
            }
        }
    }

    private final void Eh(RoundCornerImageView imageIv) {
        String str;
        imageIv.setBorder(true);
        imageIv.setColor(ContextCompat.getColor(imageIv.getContext(), R.color.qui_common_border_light));
        imageIv.setCorner(l.b(12));
        imageIv.setBorderWidth((int) l.a(0.5f));
        if (com.tencent.biz.qui.quicommon.a.b(ContextCompat.getColor(imageIv.getContext(), R.color.qui_common_bg_middle_light))) {
            str = "https://downv6.qq.com/extendfriend/assisted_chat_authorise_dark.png";
        } else {
            str = "https://downv6.qq.com/extendfriend/assisted_chat_authorise_light.png";
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        imageIv.setImageDrawable(URLDrawable.getDrawable(str, obtain));
    }

    private final void Fh(TextView titleTv) {
        Drawable drawable;
        Context context = getContext();
        if (context != null && (drawable = ContextCompat.getDrawable(context, R.drawable.ofv)) != null) {
            drawable.setBounds(0, 0, l.b(20), l.b(20));
            SpannableString spannableString = new SpannableString("\u5f00\u542f AI\u667a\u804a\uff0c\u8bdd\u9898\u56de\u590d\u66f4\u61c2\u4f60");
            spannableString.setSpan(new VerticalCenterImageSpan(drawable), 2, 3, 33);
            titleTv.setText(spannableString);
        }
    }

    private final void yh(Context context) {
        QRoute.createNavigator(context, RouterConstants.UI_ROUTE_BROWSER).withString("url", "https://rule.tencent.com/rule/abd15ee5-bbdf-402c-89d2-e10e9200cd1c").request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(AssistedChatPermissionDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.yh(context);
        this$0.Bh(2);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QUSHalfScreenFloatingView qh5 = qh();
        if (qh5 != null) {
            qh5.setOnOutsideAreaClickListener(new b());
        }
        Dh();
        Ch();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.permission.AssistedChatBaseDialog
    @NotNull
    public View rh(@NotNull final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        k g16 = k.g(LayoutInflater.from(context));
        RoundCornerImageView ivImage = g16.f425770c;
        Intrinsics.checkNotNullExpressionValue(ivImage, "ivImage");
        Eh(ivImage);
        TextView title = g16.f425772e;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Fh(title);
        ImageView onCreateContentView$lambda$3$lambda$1 = g16.f425771d;
        AIOUtil.f194084a.e(onCreateContentView$lambda$3$lambda$1, l.b(5), l.b(5), l.b(5), l.b(5));
        Intrinsics.checkNotNullExpressionValue(onCreateContentView$lambda$3$lambda$1, "onCreateContentView$lambda$3$lambda$1");
        xu3.b.b(onCreateContentView$lambda$3$lambda$1);
        onCreateContentView$lambda$3$lambda$1.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.permission.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AssistedChatPermissionDialog.zh(AssistedChatPermissionDialog.this, view);
            }
        });
        g16.f425769b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.permission.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AssistedChatPermissionDialog.Ah(context, this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026)\n            }\n        }");
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "contentBinding.root");
        this.contentView = root;
        if (root == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            return null;
        }
        return root;
    }
}
