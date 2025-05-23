package com.tencent.mobileqq.icgame.room.input;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.icgame.game.component.chat.input.KeyboardUtils;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J>\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/input/i;", "", "", "b", "", "a", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "userId", "userName", "showUserName", "Lcom/tencent/mobileqq/icgame/room/input/h;", "familyAtFunction", "quickString", "headUrl", "", "c", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f237649a = new i();

    i() {
    }

    private final String a() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            return firstSimpleAccount.getUin();
        }
        return "";
    }

    private final long b() {
        String a16 = a();
        try {
            Intrinsics.checkNotNull(a16);
            return Long.parseLong(a16);
        } catch (Exception e16) {
            QLog.e("SpecialMsgUtil", 1, "getUserId error", e16);
            return 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(@NotNull CommonOuterClass$QQUserId userId, @Nullable String userName, @NotNull String showUserName, @Nullable h familyAtFunction, @NotNull String quickString, @NotNull String headUrl) {
        EditText editText;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(showUserName, "showUserName");
        Intrinsics.checkNotNullParameter(quickString, "quickString");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        TimiBaseInputView timiBaseInputView = null;
        if (familyAtFunction != 0) {
            editText = familyAtFunction.H();
        } else {
            editText = null;
        }
        if (familyAtFunction != 0) {
            timiBaseInputView = familyAtFunction.F();
        }
        long b16 = b();
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(showUserName) && editText != null && timiBaseInputView != null && b16 != userId.uid.get() && userId.uid.get() != 0) {
            timiBaseInputView.f(userId, userName, showUserName, headUrl);
            editText.setText(((Object) editText.getText()) + "@" + showUserName + " " + quickString);
            editText.setSelection(editText.getText().length());
            if ((familyAtFunction instanceof Activity) && (((Activity) familyAtFunction).isDestroyed() || ((Activity) familyAtFunction).isFinishing())) {
                QLog.i("SpecialMsgUtil", 1, "startInput destroy");
            } else {
                if ((familyAtFunction instanceof QPublicBaseFragment) && !((QPublicBaseFragment) familyAtFunction).isAdded()) {
                    return;
                }
                timiBaseInputView.setVisibility(0);
                KeyboardUtils.d(editText);
            }
        }
    }
}
