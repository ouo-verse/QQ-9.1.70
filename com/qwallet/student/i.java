package com.qwallet.student;

import android.app.Dialog;
import android.util.Base64;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tencent.mobileqq.qwallet.jsp.invoke.ChsiCertificationParams;
import com.tencent.mobileqq.qwallet.pb.StudentPB$VerifyCHSIWebPageReq;
import com.tencent.mobileqq.qwallet.pb.StudentPB$VerifyCHSIWebPageRsp;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LoadingUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u0002\u0010\u0014B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010-\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u0016\u0010(\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001bR\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/qwallet/student/i;", "", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "t", "", "content", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "base64Data", ReportConstant.COSTREPORT_PREFIX, "r", "url", "", "p", "Lcom/qwallet/student/ChsiCertificationFragment;", "a", "Lcom/qwallet/student/ChsiCertificationFragment;", "fragment", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "b", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "getParams", "()Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "params", "Landroid/view/View;", "c", "Landroid/view/View;", "sendLayout", "Landroid/widget/CheckBox;", "d", "Landroid/widget/CheckBox;", "sendCheckBox", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "sendTitle", "f", "sendBtn", "g", "backBtn", "Landroid/app/Dialog;", tl.h.F, "Landroid/app/Dialog;", "loadingDialog", "contentLayout", "<init>", "(Lcom/qwallet/student/ChsiCertificationFragment;Landroid/view/View;Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;)V", "i", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChsiCertificationFragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChsiCertificationParams params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View sendLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CheckBox sendCheckBox;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView sendTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View sendBtn;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View backBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/qwallet/student/i$b;", "", "Ljava/io/Closeable;", "closeable", "", "a", "", "unicodeStr", "b", "", "data", "c", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f41739a = new b();

        b() {
        }

        private final void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e16) {
                    QLog.e("ChsiCertificationVerifyVC", 2, "closeQuietly() error", e16);
                }
            }
        }

        @NotNull
        public final String b(@NotNull String unicodeStr) {
            int i3;
            boolean z16;
            Intrinsics.checkNotNullParameter(unicodeStr, "unicodeStr");
            Charset forName = Charset.forName("UTF-16");
            Matcher matcher = Pattern.compile("\\\\u([0-9a-fA-F]{4})").matcher(unicodeStr);
            StringBuffer stringBuffer = new StringBuffer();
            int i16 = 0;
            while (matcher.find(i16)) {
                int start = matcher.start();
                if (start > i16) {
                    String substring = unicodeStr.substring(i16, start);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    stringBuffer.append(substring);
                }
                String group = matcher.group(1);
                if (group != null) {
                    Integer valueOf = Integer.valueOf(group, 16);
                    String charBuffer = forName.decode(ByteBuffer.wrap(new byte[]{(byte) ((valueOf.intValue() >> 8) & 255), (byte) (valueOf.intValue() & 255)})).toString();
                    Intrinsics.checkNotNullExpressionValue(charBuffer, "charset.decode(unicodeByte).toString()");
                    int length = charBuffer.length() - 1;
                    int i17 = 0;
                    boolean z17 = false;
                    while (i17 <= length) {
                        if (!z17) {
                            i3 = i17;
                        } else {
                            i3 = length;
                        }
                        if (Intrinsics.compare((int) charBuffer.charAt(i3), 32) <= 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z17) {
                            if (!z16) {
                                z17 = true;
                            } else {
                                i17++;
                            }
                        } else {
                            if (!z16) {
                                break;
                            }
                            length--;
                        }
                    }
                    stringBuffer.append(charBuffer.subSequence(i17, length + 1).toString());
                    i16 = matcher.end();
                }
            }
            int length2 = unicodeStr.length();
            if (length2 > i16) {
                String substring2 = unicodeStr.substring(i16, length2);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                stringBuffer.append(substring2);
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "result.toString()");
            return stringBuffer2;
        }

        @Nullable
        public final byte[] c(@Nullable byte[] data) {
            GZIPOutputStream gZIPOutputStream;
            Throwable th5;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    Ref.IntRef intRef = new Ref.IntRef();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = byteArrayInputStream.read(bArr, 0, 1024);
                        intRef.element = read;
                        if (read != -1) {
                            gZIPOutputStream.write(bArr, 0, read);
                        } else {
                            gZIPOutputStream.finish();
                            gZIPOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            a(gZIPOutputStream);
                            byteArrayOutputStream.flush();
                            a(byteArrayOutputStream);
                            a(byteArrayInputStream);
                            return byteArray;
                        }
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    a(gZIPOutputStream);
                    byteArrayOutputStream.flush();
                    a(byteArrayOutputStream);
                    a(byteArrayInputStream);
                    throw th5;
                }
            } catch (Throwable th7) {
                gZIPOutputStream = null;
                th5 = th7;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/student/i$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/StudentPB$VerifyCHSIWebPageRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c implements o<StudentPB$VerifyCHSIWebPageRsp> {
        c() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull StudentPB$VerifyCHSIWebPageRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            int i3 = rsp.state.get();
            if (i3 != 1) {
                if (i3 != 3) {
                    i.this.sendTitle.setText(rsp.f278709msg.get());
                    i.this.sendCheckBox.setVisibility(8);
                    i.this.sendBtn.setVisibility(8);
                } else {
                    i.this.sendTitle.setText(rsp.f278709msg.get());
                    i.this.sendCheckBox.setVisibility(8);
                    i.this.sendBtn.setVisibility(8);
                    i.this.backBtn.setVisibility(0);
                }
            } else {
                i.this.sendLayout.setVisibility(8);
                FragmentActivity activity = i.this.fragment.getActivity();
                if (activity != null) {
                    activity.setResult(-1);
                    activity.finish();
                }
            }
            QLog.i("ChsiCertificationVerifyVC", 1, "VerifyCHSIWebPage success state=" + i3);
            Dialog dialog = i.this.loadingDialog;
            if (dialog != null) {
                dialog.hide();
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.w("ChsiCertificationVerifyVC", 1, "VerifyCHSIWebPage fail[" + errCode + "]" + errMsg);
            Dialog dialog = i.this.loadingDialog;
            if (dialog != null) {
                dialog.hide();
            }
        }
    }

    public i(@NotNull ChsiCertificationFragment fragment, @NotNull View contentLayout, @NotNull ChsiCertificationParams params) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(contentLayout, "contentLayout");
        Intrinsics.checkNotNullParameter(params, "params");
        this.fragment = fragment;
        this.params = params;
        View findViewById = contentLayout.findViewById(R.id.f8959507);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentLayout.findViewBy\u2026udent_verify_send_layout)");
        this.sendLayout = findViewById;
        View findViewById2 = contentLayout.findViewById(R.id.f8958506);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentLayout.findViewBy\u2026nt_verify_send_check_box)");
        this.sendCheckBox = (CheckBox) findViewById2;
        View findViewById3 = contentLayout.findViewById(R.id.f8960508);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentLayout.findViewBy\u2026tudent_verify_send_title)");
        this.sendTitle = (TextView) findViewById3;
        View findViewById4 = contentLayout.findViewById(R.id.f8957505);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentLayout.findViewBy\u2026.student_verify_send_btn)");
        this.sendBtn = findViewById4;
        View findViewById5 = contentLayout.findViewById(R.id.f8952500);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentLayout.findViewBy\u2026.student_verify_back_btn)");
        this.backBtn = findViewById5;
        this.sendCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qwallet.student.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                i.f(i.this, compoundButton, z16);
            }
        });
        this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.student.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.g(i.this, view);
            }
        });
        this.sendLayout.setClickable(true);
        this.sendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.student.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.h(i.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(i this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendBtn.setEnabled(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.fragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        com.tencent.mobileqq.qwallet.c.f("studentAuth.chsiBack.click", null, null, null, null, 30, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this$0.fragment.getContext(), "\u52a0\u8f7d\u4e2d", true);
        this$0.loadingDialog = showLoadingDialog;
        if (showLoadingDialog != null) {
            showLoadingDialog.show();
        }
        CustomWebView webView = this$0.fragment.getWebView();
        Intrinsics.checkNotNullExpressionValue(webView, "fragment.webView");
        this$0.t(webView);
        com.tencent.mobileqq.qwallet.c.f("studentAuth.chsiVerify.click", null, null, null, null, 30, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(String content) {
        if (content == null) {
            return;
        }
        b bVar = b.f41739a;
        String b16 = bVar.b(content);
        QLog.i("ChsiCertificationVerifyVC", 1, "content.size=" + b16.length());
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        byte[] bytes = b16.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] encode = Base64.encode(bVar.c(bytes), 0);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(gzipData, Base64.DEFAULT)");
        String str = new String(encode, Charsets.UTF_8);
        QLog.i("ChsiCertificationVerifyVC", 1, "final.size=" + str.length());
        s(str);
    }

    private final void s(String base64Data) {
        StudentPB$VerifyCHSIWebPageReq studentPB$VerifyCHSIWebPageReq = new StudentPB$VerifyCHSIWebPageReq();
        studentPB$VerifyCHSIWebPageReq.token.set(this.params.getToken());
        studentPB$VerifyCHSIWebPageReq.source_code.set(base64Data);
        c cVar = new c();
        pl2.n nVar = pl2.n.f426457a;
        IQWalletServletApi iQWalletServletApi = (IQWalletServletApi) QRoute.api(IQWalletServletApi.class);
        Object newInstance = StudentPB$VerifyCHSIWebPageRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        iQWalletServletApi.sendGatewayRequest("trpc.campus.verification.Student", "VerifyCHSIWebPage", studentPB$VerifyCHSIWebPageReq, (MessageMicro) newInstance, true, false, false, cVar);
    }

    private final void t(WebView view) {
        QLog.i("ChsiCertificationVerifyVC", 1, "startDownload");
        try {
            view.evaluateJavascript("document.documentElement.outerHTML", new ValueCallback() { // from class: com.qwallet.student.g
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    i.u(i.this, (String) obj);
                }
            });
        } catch (Exception e16) {
            QLog.i("ChsiCertificationVerifyVC", 1, "startDownload error:", e16);
            Dialog dialog = this.loadingDialog;
            if (dialog != null) {
                dialog.hide();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final i this$0, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.excute(new Runnable() { // from class: com.qwallet.student.h
            @Override // java.lang.Runnable
            public final void run() {
                i.v(i.this, str);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(i this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q(str);
    }

    public final boolean p(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!Pattern.compile(this.params.getSuccessURL()).matcher(url).find()) {
            return false;
        }
        this.sendLayout.setVisibility(0);
        this.sendTitle.setText(this.params.getProtocolText());
        com.tencent.mobileqq.qwallet.c.f("studentAuth.chsiDetail.show", null, null, null, null, 30, null);
        QLog.d("ChsiCertificationVerifyVC", 1, "successUrl = " + url);
        return true;
    }

    public final void r() {
        this.sendLayout.setVisibility(8);
        this.sendBtn.setVisibility(0);
        this.sendCheckBox.setVisibility(0);
        this.sendCheckBox.setChecked(false);
        this.backBtn.setVisibility(8);
    }
}
