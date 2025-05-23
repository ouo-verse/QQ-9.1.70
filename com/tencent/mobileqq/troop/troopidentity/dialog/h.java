package com.tencent.mobileqq.troop.troopidentity.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.luggage.wxa.ig.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B)\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/dialog/h;", "Landroid/app/Dialog;", "Landroid/view/View;", "view", "", ExifInterface.LATITUDE_SOUTH, "", "isSelected", "a0", "b0", "initWindow", "show", "dismiss", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/troopidentity/dialog/b;", "D", "Lcom/tencent/mobileqq/troop/troopidentity/dialog/b;", "getData", "()Lcom/tencent/mobileqq/troop/troopidentity/dialog/b;", "data", "Lcom/tencent/mobileqq/troop/troopidentity/dialog/a;", "E", "Lcom/tencent/mobileqq/troop/troopidentity/dialog/a;", "getCb", "()Lcom/tencent/mobileqq/troop/troopidentity/dialog/a;", "cb", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/troop/troopidentity/dialog/b;Lcom/tencent/mobileqq/troop/troopidentity/dialog/a;)V", UserInfo.SEX_FEMALE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h extends ReportDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b data;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final a cb;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/dialog/h$a;", "", "", "BIG_ICON_BG", "Ljava/lang/String;", "LOGO_BAR", "SET_ICON_DEFAULT", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.dialog.h$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Context context, @NotNull String troopUin, @NotNull b data, @Nullable a aVar) {
        super(context, R.style.f173448dl);
        FrameLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(data, "data");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, troopUin, data, aVar);
            return;
        }
        this.troopUin = troopUin;
        this.data = data;
        this.cb = aVar;
        initWindow();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundResource(R.drawable.qui_common_overlay_dark_bg);
        View view = LayoutInflater.from(context).inflate(R.layout.g0k, (ViewGroup) frameLayout, false);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.troopidentity.dialog.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean Y;
                Y = h.Y(view2, motionEvent);
                return Y;
            }
        });
        View findViewById = view.findViewById(R.id.f166366zl0);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.Z(h.this, view2);
            }
        });
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        layoutParams = layoutParams == null ? new FrameLayout.LayoutParams(l.b(320), l.b(k.CTRL_INDEX)) : layoutParams;
        layoutParams.gravity = 17;
        view.setLayoutParams(layoutParams);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        S(view);
        frameLayout.addView(view);
        if (FontSettingManager.isFontSizeLarge()) {
            FontSettingManager.resetViewSize2Normal(context, frameLayout);
        }
        setContentView(frameLayout);
    }

    private final void S(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.zkv);
        TroopIdentityHonorUtil troopIdentityHonorUtil = TroopIdentityHonorUtil.f300410a;
        Intrinsics.checkNotNullExpressionValue(imageView, "this");
        troopIdentityHonorUtil.i(imageView, this.data.a());
        ImageView imageView2 = (ImageView) view.findViewById(R.id.zl9);
        Intrinsics.checkNotNullExpressionValue(imageView2, "this");
        troopIdentityHonorUtil.i(imageView2, "https://downv6.qq.com/extendfriend/mutual_tag_peidai.png");
        imageView2.setVisibility(8);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.f166369zl3);
        Intrinsics.checkNotNullExpressionValue(imageView3, "this");
        troopIdentityHonorUtil.i(imageView3, "https://downv6.qq.com/extendfriend/mutualmark_light.png");
        if (QQTheme.isNowThemeSimpleNight() || QQTheme.isNowThemeIsNight()) {
            imageView3.setAlpha(0.5f);
        }
        ((TextView) view.findViewById(R.id.zl7)).setText(this.data.b());
        TextView textView = (TextView) view.findViewById(R.id.zla);
        if (TextUtils.isEmpty(this.data.c())) {
            textView.setVisibility(4);
        } else {
            textView.setText(this.data.c());
        }
        ImageView imageView4 = (ImageView) view.findViewById(R.id.f102165x6);
        Intrinsics.checkNotNullExpressionValue(imageView4, "this");
        troopIdentityHonorUtil.i(imageView4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9170/qecommerce_group_qqmedalsbar_9170.png");
        TextView textView2 = (TextView) view.findViewById(R.id.f166368zl2);
        QUIButton qUIButton = (QUIButton) view.findViewById(R.id.f102115x1);
        if (this.data.e()) {
            imageView2.setVisibility(0);
            textView2.setText("\u5df2\u83b7\u5f97");
            qUIButton.setText("\u53d6\u6d88\u4f69\u6234");
            qUIButton.setType(1);
            qUIButton.setEnabled(true);
            qUIButton.setOnClickListener(null);
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h.U(h.this, view2);
                }
            });
            return;
        }
        if (this.data.d()) {
            textView2.setText("\u5df2\u83b7\u5f97");
            qUIButton.setText("\u4f69\u6234");
            qUIButton.setType(0);
            qUIButton.setEnabled(true);
            qUIButton.setOnClickListener(null);
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.dialog.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h.W(h.this, view2);
                }
            });
            return;
        }
        textView2.setText("\u672a\u83b7\u5f97");
        qUIButton.setText("\u53bb\u83b7\u5f97");
        qUIButton.setType(0);
        qUIButton.setEnabled(true);
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.X(h.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a0(false);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a0(true);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0();
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void a0(boolean isSelected) {
        a aVar = this.cb;
        if (aVar != null) {
            aVar.onSelected(isSelected);
        }
    }

    private final void b0() {
        String str;
        Long longOrNull;
        long j3;
        if (TextUtils.isEmpty(this.troopUin)) {
            return;
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str2 = this.troopUin;
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.troopUin);
        if (troopInfoFromCache != null) {
            str = troopInfoFromCache.getTroopDisplayName();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str3 = str;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        iAIOStarterApi.navigateToAIO(context, 2, str2, str3, j3, new Bundle());
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            QLog.d("TroopIdentityIconDetailDialog", 1, "dialog window is null, return");
            return;
        }
        window.setLayout(-1, -1);
        window.getAttributes().gravity = 17;
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("TroopIdentityIconDetailDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.dismiss();
            QUIImmersiveHelper.u(getWindow(), false, true);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.show();
            QUIImmersiveHelper.u(getWindow(), false, true);
        }
    }
}
