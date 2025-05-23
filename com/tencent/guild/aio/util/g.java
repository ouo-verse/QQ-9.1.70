package com.tencent.guild.aio.util;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.guild.api.appsetting.IQQSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/util/g;", "", "Landroid/widget/EditText;", "editText", "Lkotlin/Function0;", "", "onSendAction", "c", "", "msgLen", "", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f112400a = new g();

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Function0 onSendAction, TextView textView, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(onSendAction, "$onSendAction");
        if (i3 == 4) {
            onSendAction.invoke();
            return true;
        }
        return false;
    }

    public final boolean b(int msgLen) {
        if (msgLen > 1900) {
            QQToast.makeText(BaseApplication.getContext(), R.string.c8h, 0).show();
            return false;
        }
        return true;
    }

    public final void c(@NotNull EditText editText, @NotNull final Function0<Unit> onSendAction) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(onSendAction, "onSendAction");
        if (((IQQSetting) QRoute.api(IQQSetting.class)).isEnterSendMsg()) {
            editText.setImeOptions(4);
        } else {
            editText.setImeOptions(0);
        }
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.guild.aio.util.f
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean d16;
                d16 = g.d(Function0.this, textView, i3, keyEvent);
                return d16;
            }
        });
    }
}
