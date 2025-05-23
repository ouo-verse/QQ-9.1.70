package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.PrivacyDetailInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqmini/sdk/widget/a;", "Landroid/app/Dialog;", "", "initView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/text/SpannableString;", "spanString", "W", "P", "", "complainString", "U", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mContentTextView", "Lcom/tencent/qqmini/sdk/launcher/core/model/PrivacyDetailInfo;", "D", "Lcom/tencent/qqmini/sdk/launcher/core/model/PrivacyDetailInfo;", "mPrivacyInfo", "Landroid/content/Context;", "context", "privacyInfo", "<init>", "(Landroid/content/Context;Lcom/tencent/qqmini/sdk/launcher/core/model/PrivacyDetailInfo;)V", "E", "a", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mContentTextView;

    /* renamed from: D, reason: from kotlin metadata */
    private PrivacyDetailInfo mPrivacyInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqmini/sdk/widget/a$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkParameterIsNotNull(widget, "widget");
            a.this.R();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkParameterIsNotNull(ds5, "ds");
            ds5.setColor(Color.parseColor("#FF2D77E5"));
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqmini/sdk/widget/a$d", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class d extends ClickableSpan {
        d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkParameterIsNotNull(widget, "widget");
            a.this.S();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkParameterIsNotNull(ds5, "ds");
            ds5.setColor(Color.parseColor("#FF2D77E5"));
            ds5.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull PrivacyDetailInfo privacyInfo) {
        super(context, R.style.mini_sdk_MiniAppAuthDialog);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(privacyInfo, "privacyInfo");
        this.mPrivacyInfo = privacyInfo;
    }

    private final void P() {
        String string = getContext().getString(R.string.mini_sdk_privacy_link_complain);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.stri\u2026dk_privacy_link_complain)");
        String string2 = getContext().getString(R.string.mini_sdk_privacy_content, this.mPrivacyInfo.getPermissionName(), this.mPrivacyInfo.getPrivacyTitle(), string);
        Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(\n     \u2026 complainString\n        )");
        SpannableString spannableString = new SpannableString(string2);
        W(spannableString);
        U(spannableString, string);
        TextView textView = this.mContentTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTextView");
        }
        textView.setText(spannableString);
    }

    private final void Q() {
        View findViewById = findViewById(R.id.txt_privacy_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.txt_privacy_content)");
        TextView textView = (TextView) findViewById;
        this.mContentTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTextView");
        }
        textView.setMovementMethod(new LinkMovementMethod());
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        String str;
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        String id5 = this.mPrivacyInfo.getId();
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        QMLog.d("PrivacyMoreDialog", "onComplainClick:" + id5);
        if (context != null && !TextUtils.isEmpty(id5)) {
            try {
                str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
                Intrinsics.checkExpressionValueIsNotNull(str, "URLEncoder.encode(\n     \u2026\"UTF-8\"\n                )");
            } catch (UnsupportedEncodingException e16) {
                QMLog.e("PrivacyMoreDialog", "startComplainAndCallback, url = ");
                e16.printStackTrace();
                str = "";
            }
            String str2 = "https://support.qq.com/embed/phone/56748/new-post?appid=" + id5 + Typography.amp + "openid=$(LoginManager.getInstance().account)&avatar=" + str + "&nickname=\u6e38\u5ba2";
            Intent intent = new Intent();
            intent.putExtra("url", str2);
            intent.putExtra("title", "\u6295\u8bc9");
            Bundle bundle = new Bundle();
            bundle.putBoolean("hide_more_button", true);
            intent.putExtras(bundle);
            miniAppProxy.startBrowserActivity(context, intent);
            return;
        }
        QMLog.d("PrivacyMoreDialog", "onComplainClick but context or appId is null\uff1a" + id5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        boolean z16;
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        Intent intent = new Intent();
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        if (context != null && !TextUtils.isEmpty(this.mPrivacyInfo.getWebUrl())) {
            QMLog.d("PrivacyMoreDialog", "onPrivacyWebClick:" + this.mPrivacyInfo.getWebUrl());
            intent.putExtra("url", this.mPrivacyInfo.getWebUrl());
            intent.putExtra("title", this.mPrivacyInfo.getPrivacyTitle());
            if (miniAppProxy != null) {
                miniAppProxy.startBrowserActivity(context, intent);
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onPrivacyWebClick, fail ctx is null : ");
        if (context == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QMLog.e("PrivacyMoreDialog", sb5.toString());
    }

    private final void U(SpannableString spanString, String complainString) {
        int lastIndexOf$default;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) spanString, complainString, 0, false, 6, (Object) null);
        spanString.setSpan(new c(), lastIndexOf$default, complainString.length() + lastIndexOf$default, 18);
    }

    private final void W(SpannableString spanString) {
        int indexOf$default;
        if (this.mPrivacyInfo.getPrivacyTitle() == null) {
            return;
        }
        String privacyTitle = this.mPrivacyInfo.getPrivacyTitle();
        if (privacyTitle == null) {
            Intrinsics.throwNpe();
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spanString, privacyTitle, 0, false, 6, (Object) null);
        String privacyTitle2 = this.mPrivacyInfo.getPrivacyTitle();
        if (privacyTitle2 == null) {
            Intrinsics.throwNpe();
        }
        spanString.setSpan(new d(), indexOf$default, privacyTitle2.length() + indexOf$default, 33);
    }

    private final void initView() {
        View findViewById = findViewById(R.id.iv_back);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.iv_back)");
        findViewById.setOnClickListener(new b());
        Q();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mini_sdk_auth_more_privacy_dialog);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        initView();
    }
}
