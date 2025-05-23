package du0;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.icgame.game.component.chat.input.KeyboardUtils;
import com.tencent.icgame.game.component.chat.input.TimiBaseInputView;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUserMsg;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J@\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004JL\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ!\u0010\u001f\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Ldu0/e;", "", "", "nick", "", "roomId", "a", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "userId", "name", "Ldu0/d;", "familyAtFunction", "quickString", "headUrl", "", "d", "", "startPos", "txtStr", "", "idQQUserInfoMap", "Landroid/text/SpannableStringBuilder;", "spannable", "color", "", "underLine", "Ldu0/a;", "clickable", "c", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AtUserMsg;", "data", "b", "(Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AtUserMsg;Ljava/lang/Long;)Z", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a */
    @NotNull
    public static final e f394864a = new e();

    e() {
    }

    public static /* synthetic */ void e(e eVar, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, d dVar, String str2, String str3, long j3, int i3, Object obj) {
        String str4;
        String str5;
        long j16;
        if ((i3 & 8) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i3 & 16) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        if ((i3 & 32) != 0) {
            j16 = 0;
        } else {
            j16 = j3;
        }
        eVar.d(commonOuterClass$QQUserId, str, dVar, str4, str5, j16);
    }

    public final boolean b(@Nullable MessageOuterClass$AtUserMsg data, @Nullable Long userId) {
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        List<MessageOuterClass$AtUser> list;
        if (data != null && (pBRepeatMessageField = data.user_list) != null && (list = pBRepeatMessageField.get()) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = ((MessageOuterClass$AtUser) it.next()).user_id;
                Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "value.user_id");
                if (com.tencent.icgame.game.utils.a.d(commonOuterClass$QQUserId, userId)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean c(int startPos, @NotNull String txtStr, @NotNull Map<String, CommonOuterClass$QQUserId> idQQUserInfoMap, @NotNull SpannableStringBuilder spannable, int color, boolean underLine, @Nullable a clickable) {
        Intrinsics.checkNotNullParameter(txtStr, "txtStr");
        Intrinsics.checkNotNullParameter(idQQUserInfoMap, "idQQUserInfoMap");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        return !c.f394859a.c(startPos, txtStr, idQQUserInfoMap, spannable, color, underLine, clickable).isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009f, code lost:
    
        if (r12 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c2, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c0, code lost:
    
        if (r9 != false) goto L82;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(@NotNull CommonOuterClass$QQUserId userId, @Nullable String name, @Nullable d familyAtFunction, @NotNull String quickString, @NotNull String headUrl, long roomId) {
        EditText editText;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(quickString, "quickString");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        String a16 = a(name, roomId);
        TimiBaseInputView timiBaseInputView = null;
        if (familyAtFunction != 0) {
            editText = familyAtFunction.H();
        } else {
            editText = null;
        }
        if (familyAtFunction != 0) {
            timiBaseInputView = familyAtFunction.F();
        }
        a.Companion companion = rt0.a.INSTANCE;
        companion.j("ICGameUnknown|ICGameSpecialMsgUtil", "startInput " + editText + " " + a16 + " " + timiBaseInputView + " " + userId);
        CommonOuterClass$QQUserId myUserId = ((mx0.a) qx0.a.b(mx0.a.class)).E();
        if (!TextUtils.isEmpty(a16) && editText != null && timiBaseInputView != null) {
            Intrinsics.checkNotNullExpressionValue(myUserId, "myUserId");
            if (myUserId.uid.get() != 0) {
                PBUInt64Field pBUInt64Field = userId.uid;
                if (pBUInt64Field != null && myUserId.uid.get() == pBUInt64Field.get()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            if (myUserId.yes_uid.get() != 0) {
                PBUInt64Field pBUInt64Field2 = userId.yes_uid;
                if (pBUInt64Field2 != null && myUserId.yes_uid.get() == pBUInt64Field2.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            boolean z18 = false;
            if (!z18) {
                timiBaseInputView.e(userId, a16, headUrl);
                editText.setText(((Object) editText.getText()) + "@" + a16 + " " + quickString);
                editText.setSelection(editText.getText().length());
                if ((familyAtFunction instanceof Activity) && (((Activity) familyAtFunction).isDestroyed() || ((Activity) familyAtFunction).isFinishing())) {
                    companion.j("ICGameUnknown|ICGameSpecialMsgUtil", "startInput destroy");
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

    private final String a(String nick, long roomId) {
        return nick;
    }
}
