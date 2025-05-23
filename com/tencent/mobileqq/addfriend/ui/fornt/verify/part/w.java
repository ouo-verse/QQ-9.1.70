package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.lang.CharEncoding;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b+\u0010,J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016R\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001d8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/w;", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "d", "I", "getMMaxBytes", "()I", "setMMaxBytes", "(I)V", "mMaxBytes", "Landroid/widget/EditText;", "e", "Landroid/widget/EditText;", "getMEditText", "()Landroid/widget/EditText;", "setMEditText", "(Landroid/widget/EditText;)V", "mEditText", "", "f", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", tl.h.F, "getInsertPos", "setInsertPos", "insertPos", "i", "getInsertCount", "setInsertCount", "insertCount", "<init>", "(ILandroid/widget/EditText;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class w implements TextWatcher {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mMaxBytes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EditText mEditText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int insertPos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int insertCount;

    public w(int i3, @NotNull EditText mEditText) {
        Intrinsics.checkNotNullParameter(mEditText, "mEditText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) mEditText);
            return;
        }
        this.mMaxBytes = i3;
        this.mEditText = mEditText;
        this.TAG = "MaxBytesTextWatcher";
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void afterTextChanged(@NotNull Editable s16) {
        String str;
        String str2;
        String str3;
        Throwable th5;
        String str4 = "";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) s16);
            return;
        }
        Intrinsics.checkNotNullParameter(s16, "s");
        String obj = this.mEditText.getText().toString();
        Charset charset = Charsets.UTF_8;
        byte[] bytes = obj.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        if (bytes.length > this.mMaxBytes) {
            try {
                str = obj.substring(0, this.insertPos);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } catch (Throwable th6) {
                th = th6;
                str = "";
                str2 = str;
            }
            try {
                str2 = obj.substring(this.insertPos + this.insertCount, obj.length());
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                try {
                    int i3 = this.insertPos;
                    str3 = obj.substring(i3, this.insertCount + i3);
                    Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    try {
                        byte[] bytes2 = str.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                        int length = bytes2.length;
                        byte[] bytes3 = str2.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                        if (length + bytes3.length <= this.mMaxBytes) {
                            str4 = str3;
                            while (true) {
                                byte[] bytes4 = obj.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
                                if (bytes4.length <= this.mMaxBytes || str4.length() <= 0) {
                                    break;
                                }
                                String substring = str4.substring(0, str4.length() - 1);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                try {
                                    str4 = substring;
                                    obj = str + substring + str2;
                                } catch (Throwable th7) {
                                    th5 = th7;
                                    str3 = substring;
                                    if (QLog.isColorLevel()) {
                                    }
                                }
                            }
                            String valueOf = String.valueOf(obj.charAt(obj.length() - 1));
                            Charset forName = Charset.forName(CharEncoding.UTF_16BE);
                            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                            byte[] bytes5 = valueOf.getBytes(forName);
                            Intrinsics.checkNotNullExpressionValue(bytes5, "this as java.lang.String).getBytes(charset)");
                            if (bytes5.length == 2 && obj.length() > 1) {
                                char c16 = (char) (((char) (bytes5[1] & 255)) | (((char) (bytes5[0] & 255)) << '\b'));
                                if (c16 >= '\ud800' && c16 <= '\ud83f') {
                                    obj = obj.substring(0, obj.length() - 1);
                                    Intrinsics.checkNotNullExpressionValue(obj, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                }
                            }
                            this.mEditText.setText(obj);
                            this.mEditText.setSelection(obj.length());
                        }
                    } catch (Throwable th8) {
                        th5 = th8;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    str3 = str4;
                    th5 = th;
                    if (QLog.isColorLevel()) {
                    }
                }
            } catch (Throwable th10) {
                th = th10;
                str2 = "";
                str3 = str2;
                th5 = th;
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "afterTextChanged, headStr:" + str + ", tailStr = " + str2 + ", insert = " + str3, th5);
                }
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            return;
        }
        Intrinsics.checkNotNullParameter(s16, "s");
        this.insertPos = start;
        this.insertCount = after;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        } else {
            Intrinsics.checkNotNullParameter(s16, "s");
        }
    }
}
