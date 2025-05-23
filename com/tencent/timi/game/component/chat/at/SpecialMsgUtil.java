package com.tencent.timi.game.component.chat.at;

import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.activity.result.ActivityResultCaller;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqlive.widget.util.KeyboardUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import gh4.f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J@\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J,\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013JL\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 J\u001a\u0010%\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001a\u0010'\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010&2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J!\u0010(\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010&2\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+\u00a8\u00061"}, d2 = {"Lcom/tencent/timi/game/component/chat/at/SpecialMsgUtil;", "", "", "nick", "", "roomId", "b", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "name", "Lcom/tencent/timi/game/component/chat/at/d;", "familyAtFunction", "quickString", "headUrl", "", h.F, "userName", "Landroid/widget/EditText;", "editText", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "inputBox", "g", "", "startPos", "txtStr", "", "idQQUserInfoMap", "Landroid/text/SpannableStringBuilder;", "spannable", "color", "", "underLine", "Lcom/tencent/timi/game/component/chat/at/a;", "clickable", "f", "Lcom/tencent/timi/game/tim/api/message/a;", "data", "c", "Ltrpc/yes/common/MessageOuterClass$AtUserMsg;", "d", "e", "(Ltrpc/yes/common/MessageOuterClass$AtUserMsg;Ljava/lang/Long;)Z", "uid", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/timi/game/component/chat/at/SpecialMsgUtil$a;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class SpecialMsgUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SpecialMsgUtil f376345a = new SpecialMsgUtil();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000e\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR2\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/timi/game/component/chat/at/SpecialMsgUtil$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getActionStr", "()Ljava/lang/String;", "actionStr", "Lkotlin/Function1;", "Landroid/app/Dialog;", "Lkotlin/ParameterName;", "name", "dialog", "", "b", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "action", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.component.chat.at.SpecialMsgUtil$a, reason: from toString */
    /* loaded from: classes26.dex */
    public static final /* data */ class Action {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String actionStr;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Function1<Dialog, Unit> action;

        /* JADX WARN: Multi-variable type inference failed */
        public Action(@NotNull String actionStr, @NotNull Function1<? super Dialog, Unit> action) {
            Intrinsics.checkNotNullParameter(actionStr, "actionStr");
            Intrinsics.checkNotNullParameter(action, "action");
            this.actionStr = actionStr;
            this.action = action;
        }

        @NotNull
        public final Function1<Dialog, Unit> a() {
            return this.action;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Action)) {
                return false;
            }
            Action action = (Action) other;
            if (Intrinsics.areEqual(this.actionStr, action.actionStr) && Intrinsics.areEqual(this.action, action.action)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.actionStr.hashCode() * 31) + this.action.hashCode();
        }

        @NotNull
        public String toString() {
            return "Action(actionStr=" + this.actionStr + ", action=" + this.action + ")";
        }
    }

    SpecialMsgUtil() {
    }

    private final String b(String nick, long roomId) {
        if (roomId == 0) {
            return nick;
        }
        String b16 = com.tencent.timi.game.liveroom.impl.room.manager.d.INSTANCE.a().b(roomId, nick);
        if (b16 == null) {
            return "";
        }
        return b16;
    }

    public static /* synthetic */ void i(SpecialMsgUtil specialMsgUtil, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, d dVar, String str2, String str3, long j3, int i3, Object obj) {
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
        specialMsgUtil.h(commonOuterClass$QQUserId, str, dVar, str4, str5, j16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009e, code lost:
    
        if (r3 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c1, code lost:
    
        if (r1 != false) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [gh4.e, T] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Action a(@NotNull final CommonOuterClass$QQUserId uid, @NotNull final Activity activity) {
        boolean z16;
        PBUInt64Field pBUInt64Field;
        boolean z17;
        PBUInt64Field pBUInt64Field2;
        ?? I0;
        T t16;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(activity, "activity");
        AegisLogger.INSTANCE.i("unknown|SpecialMsgUtil", "acquireAtAction = " + activity);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (!(activity instanceof d)) {
            if (activity instanceof QPublicFragmentActivity) {
                QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) activity;
                if (qPublicFragmentActivity.getFragment() instanceof d) {
                    ActivityResultCaller fragment = qPublicFragmentActivity.getFragment();
                    if (fragment instanceof d) {
                        t16 = (d) fragment;
                    } else {
                        t16 = 0;
                    }
                    objectRef.element = t16;
                }
            }
            if (objectRef.element == 0 && (I0 = ((f) mm4.b.b(f.class)).I0()) != 0 && (I0 instanceof d)) {
                objectRef.element = I0;
            }
        } else {
            objectRef.element = activity;
        }
        if (objectRef.element == 0) {
            return null;
        }
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        boolean z18 = true;
        if (uid.uid.get() != 0) {
            if (E != null && (pBUInt64Field2 = E.uid) != null && uid.uid.get() == pBUInt64Field2.get()) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        if (uid.yes_uid.get() != 0) {
            if (E != null && (pBUInt64Field = E.yes_uid) != null && uid.yes_uid.get() == pBUInt64Field.get()) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z18 = false;
        if (z18) {
            return null;
        }
        return new Action("@TA", new Function1<Dialog, Unit>() { // from class: com.tencent.timi.game.component.chat.at.SpecialMsgUtil$acquireAtAction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Dialog dialog) {
                invoke2(dialog);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Dialog d16) {
                Intrinsics.checkNotNullParameter(d16, "d");
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("unknown|SpecialMsgUtil", "acquireAtAction Action , " + activity);
                if (d16 instanceof sl4.a) {
                    String j06 = ((sl4.a) d16).j0();
                    companion.i("unknown|SpecialMsgUtil", "acquireAtAction end " + activity);
                    SpecialMsgUtil.i(SpecialMsgUtil.f376345a, uid, j06, objectRef.element, null, null, 0L, 56, null);
                }
                d16.dismiss();
            }
        });
    }

    public final boolean c(@Nullable com.tencent.timi.game.tim.api.message.a data, @Nullable CommonOuterClass$QQUserId userId) {
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg;
        MessageOuterClass$MsgContent a16;
        if (data != null && (a16 = data.a()) != null) {
            messageOuterClass$AtUserMsg = a16.at_user_msg;
        } else {
            messageOuterClass$AtUserMsg = null;
        }
        return d(messageOuterClass$AtUserMsg, userId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (r3 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006e, code lost:
    
        if (r2 != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(@Nullable MessageOuterClass$AtUserMsg data, @Nullable CommonOuterClass$QQUserId userId) {
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        List<MessageOuterClass$AtUser> list;
        boolean z16;
        PBUInt64Field pBUInt64Field;
        boolean z17;
        PBInt32Field pBInt32Field;
        boolean z18;
        PBUInt64Field pBUInt64Field2;
        if (data != null && (pBRepeatMessageField = data.user_list) != null && (list = pBRepeatMessageField.get()) != null) {
            for (MessageOuterClass$AtUser messageOuterClass$AtUser : list) {
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = messageOuterClass$AtUser.user_id;
                Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "value.user_id");
                if (commonOuterClass$QQUserId.uid.get() != 0) {
                    if (userId != null && (pBUInt64Field2 = userId.uid) != null && commonOuterClass$QQUserId.uid.get() == pBUInt64Field2.get()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                }
                if (commonOuterClass$QQUserId.yes_uid.get() != 0) {
                    if (userId != null && (pBUInt64Field = userId.yes_uid) != null && commonOuterClass$QQUserId.yes_uid.get() == pBUInt64Field.get()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                boolean z19 = false;
                if (z19) {
                    if (userId != null && (pBInt32Field = userId.user_from) != null && messageOuterClass$AtUser.user_id.user_from.get() == pBInt32Field.get()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean e(@Nullable MessageOuterClass$AtUserMsg data, @Nullable Long userId) {
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        List<MessageOuterClass$AtUser> list;
        if (data != null && (pBRepeatMessageField = data.user_list) != null && (list = pBRepeatMessageField.get()) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = ((MessageOuterClass$AtUser) it.next()).user_id;
                Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "value.user_id");
                if (com.tencent.timi.game.utils.b.e(commonOuterClass$QQUserId, userId)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean f(int startPos, @NotNull String txtStr, @NotNull Map<String, CommonOuterClass$QQUserId> idQQUserInfoMap, @NotNull SpannableStringBuilder spannable, int color, boolean underLine, @Nullable a clickable) {
        Intrinsics.checkNotNullParameter(txtStr, "txtStr");
        Intrinsics.checkNotNullParameter(idQQUserInfoMap, "idQQUserInfoMap");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        return !c.f376355a.c(startPos, txtStr, idQQUserInfoMap, spannable, color, underLine, clickable).isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0074, code lost:
    
        if (r1 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
    
        if (r0 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(@NotNull CommonOuterClass$QQUserId userId, @Nullable String userName, @Nullable EditText editText, @Nullable TimiBaseInputView inputBox) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(userId, "userId");
        AegisLogger.INSTANCE.i("unknown|SpecialMsgUtil", "startInput " + editText + " " + userName + " " + inputBox + " " + userId);
        CommonOuterClass$QQUserId myUserId = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        if (!TextUtils.isEmpty(userName) && editText != null && inputBox != null) {
            Intrinsics.checkNotNullExpressionValue(myUserId, "myUserId");
            boolean z18 = true;
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
            z18 = false;
            if (!z18) {
                TimiBaseInputView.h(inputBox, userId, userName, null, 4, null);
                String str = ((Object) editText.getText()) + "@" + userName + " ";
                editText.setText(str);
                editText.setSelection(str.length());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009f, code lost:
    
        if (r12 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c2, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c0, code lost:
    
        if (r9 != false) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(@NotNull CommonOuterClass$QQUserId userId, @Nullable String name, @Nullable d familyAtFunction, @NotNull String quickString, @NotNull String headUrl, long roomId) {
        EditText editText;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(quickString, "quickString");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        String b16 = b(name, roomId);
        TimiBaseInputView timiBaseInputView = null;
        if (familyAtFunction != 0) {
            editText = familyAtFunction.H();
        } else {
            editText = null;
        }
        if (familyAtFunction != 0) {
            timiBaseInputView = familyAtFunction.F();
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("unknown|SpecialMsgUtil", "startInput " + editText + " " + b16 + " " + timiBaseInputView + " " + userId);
        CommonOuterClass$QQUserId myUserId = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        if (!TextUtils.isEmpty(b16) && editText != null && timiBaseInputView != null) {
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
                timiBaseInputView.g(userId, b16, headUrl);
                editText.setText(((Object) editText.getText()) + "@" + b16 + " " + quickString);
                editText.setSelection(editText.getText().length());
                if ((familyAtFunction instanceof Activity) && (((Activity) familyAtFunction).isDestroyed() || ((Activity) familyAtFunction).isFinishing())) {
                    companion.i("unknown|SpecialMsgUtil", "startInput destroy");
                } else {
                    if ((familyAtFunction instanceof QPublicBaseFragment) && !((QPublicBaseFragment) familyAtFunction).isAdded()) {
                        return;
                    }
                    timiBaseInputView.setVisibility(0);
                    KeyboardUtils.e(editText);
                }
            }
        }
    }
}
