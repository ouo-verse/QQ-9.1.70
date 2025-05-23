package com.tencent.mobileqq.troop.troopsetting.modules.base.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import h53.QUIInputViewWordCountInfo;
import h53.l;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/base/ui/a;", "Lh53/l;", "Lcom/tencent/mobileqq/text/QQText;", "", "b", "", ReportConstant.COSTREPORT_PREFIX, "start", "before", "count", "Lh53/m;", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/base/ui/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.base.ui.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60193);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b(QQText qQText) {
        try {
            String qQText2 = qQText.toString();
            Intrinsics.checkNotNullExpressionValue(qQText2, "toString()");
            Charset forName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = qQText2.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes.length;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopNameInputViewWordCountCalculator", 2, "getLength error" + e16);
            }
            return 0;
        }
    }

    @Override // h53.l
    @NotNull
    public QUIInputViewWordCountInfo a(@Nullable CharSequence s16, int start, int before, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIInputViewWordCountInfo) iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
        QQText qQText = new QQText(s16, 3);
        int b16 = b(qQText);
        String qQText2 = qQText.toString();
        Intrinsics.checkNotNullExpressionValue(qQText2, "qqText.toString()");
        return new QUIInputViewWordCountInfo(b16, qQText2);
    }
}
