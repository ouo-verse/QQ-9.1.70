package com.tenpay.sdk.fakeurl;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.BaseConstants;
import com.tenpay.sdk.QWalletFakeUrl;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "\u5386\u53f2\u9057\u7559\u903b\u8f91\u6539\u9020\uff0c\u8fd9\u4e2a\u7279\u6b8a\u903b\u8f91\u9057\u7559\u5728\u4e86\u5e95\u5c42\uff0c\u540e\u7eed\u5e94\u8be5\u653e\u5728\u4e1a\u52a1\u5c42\u5b9e\u73b0")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FillNameRequestHandler;", "Lcom/tenpay/sdk/fakeurl/FakeUrlHandler;", "context", "Landroid/content/Context;", "fillNameHint", "", BaseConstants.ATTR_KET_EXTRA_MAP, "", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "getExtraMap", "()Ljava/util/Map;", "buildDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "fakeInfo", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FillNameRequestHandler extends FakeUrlHandler {

    @NotNull
    private final Map<String, String> extraMap;

    @Nullable
    private final String fillNameHint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillNameRequestHandler(@Nullable Context context, @Nullable String str, @NotNull Map<String, String> extraMap) {
        super(context);
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        this.fillNameHint = str;
        this.extraMap = extraMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildDialog$lambda$2$lambda$1(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
        if (!Pattern.compile("[a-zA-Z|\u4e00-\u9fa5]+").matcher(charSequence.toString()).matches()) {
            return "";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.fakeurl.FakeUrlHandler
    @Nullable
    public QQCustomDialog buildDialog(@Nullable FakeInfo fakeInfo) {
        final QQCustomDialog buildDialog = super.buildDialog(fakeInfo);
        if (buildDialog == null) {
            return null;
        }
        LayoutInflater.from(buildDialog.getContext()).inflate(R.layout.f168960hh3, (LinearLayout) buildDialog.findViewById(R.id.abb));
        ((TextView) buildDialog.findViewById(R.id.v5l)).setText(this.fillNameHint);
        buildDialog.getBtnight().setEnabled(false);
        buildDialog.getBtnight().setAlpha(0.1f);
        final EditText editText = (EditText) buildDialog.findViewById(R.id.v5j);
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.tenpay.sdk.fakeurl.c
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
                CharSequence buildDialog$lambda$2$lambda$1;
                buildDialog$lambda$2$lambda$1 = FillNameRequestHandler.buildDialog$lambda$2$lambda$1(charSequence, i3, i16, spanned, i17, i18);
                return buildDialog$lambda$2$lambda$1;
            }
        }});
        editText.addTextChangedListener(new x05.b() { // from class: com.tenpay.sdk.fakeurl.FillNameRequestHandler$buildDialog$2$1
            @Override // x05.b, android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s16) {
                char last;
                Intrinsics.checkNotNullParameter(s16, "s");
                String obj = editText.getText().toString();
                if (obj.length() > 1 && !cu.f()) {
                    last = StringsKt___StringsKt.last(obj);
                    obj = String.valueOf(last);
                    editText.setText(obj);
                    editText.setSelection(1);
                }
                if (!TextUtils.isEmpty(obj)) {
                    this.getExtraMap().put(QWalletFakeUrl.FAKEURL_PARAM_FILL_NAME, obj);
                    buildDialog.getBtnight().setEnabled(true);
                    buildDialog.getBtnight().setAlpha(1.0f);
                } else {
                    buildDialog.getBtnight().setEnabled(false);
                    buildDialog.getBtnight().setAlpha(0.1f);
                }
            }
        });
        buildDialog.show();
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        Window window = buildDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
        return buildDialog;
    }

    @NotNull
    public final Map<String, String> getExtraMap() {
        return this.extraMap;
    }
}
