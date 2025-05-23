package com.tencent.timi.game.component.chat;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.emo.ui.TimiEmoPanelView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import fm4.g;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xg4.k;
import xg4.m;
import xg4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001d\b&\u0018\u0000 .2\u00020\u0001:\u0002/0B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u000e\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000eR$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0018j\b\u0012\u0004\u0012\u00020\u0006`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\u0016\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00061"}, d2 = {"Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2;", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "", "scene", "Lcom/tencent/timi/game/emo/ui/TimiEmoPanelView;", "c0", "Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2$b;", "listener", "", "b0", "h0", "Landroid/view/View;", "f0", "e0", "", "state", "setState", "d0", "Landroid/view/ViewGroup;", "g0", "", "L", "yesGameId", "l0", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "N", "Ljava/util/HashSet;", "timiEmoSendListenerList", "com/tencent/timi/game/component/chat/TimiBaseInputViewV2$c", "P", "Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2$c;", "emojiCallbackV2", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "getYesGameId", "()I", "setYesGameId", "(I)V", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Req, "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class TimiBaseInputViewV2 extends TimiBaseInputView {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final HashSet<b> timiEmoSendListenerList;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final c emojiCallbackV2;

    /* renamed from: Q, reason: from kotlin metadata */
    private int yesGameId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2$b;", "", "Lxg4/k;", "timiEmoInfo", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull k timiEmoInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/timi/game/component/chat/TimiBaseInputViewV2$c", "Lxg4/n;", "", "delete", "Lxg4/k;", "timiEmoInfo", "o2", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements n {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (TimiBaseInputViewV2.this.w() != null) {
                TimiBaseInputViewV2.this.O();
            }
        }

        @Override // xg4.n
        public void o2(@NotNull k timiEmoInfo) {
            Object m476constructorimpl;
            EditText editText;
            AppRuntime waitAppRuntime;
            Intrinsics.checkNotNullParameter(timiEmoInfo, "timiEmoInfo");
            if (!(timiEmoInfo.getQqEmoInfo() instanceof SystemAndEmojiEmoticonInfo) && o.f("sendTimiEmo", ((g) mm4.b.b(g.class)).S2().a() * 1000)) {
                com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
                return;
            }
            Iterator it = TimiBaseInputViewV2.this.timiEmoSendListenerList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(timiEmoInfo);
            }
            TimiBaseInputViewV2 timiBaseInputViewV2 = TimiBaseInputViewV2.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                editText = null;
                waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (timiBaseInputViewV2.getActivityContext() == null) {
                return;
            }
            EditText w3 = timiBaseInputViewV2.w();
            if (w3 != null) {
                timiEmoInfo.getQqEmoInfo().send(waitAppRuntime, timiBaseInputViewV2.getActivityContext(), w3, null);
                editText = w3;
            }
            m476constructorimpl = Result.m476constructorimpl(editText);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                l.e("TimiBaseInputViewV2_", String.valueOf(Result.m479exceptionOrNullimpl(m476constructorimpl)));
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiBaseInputViewV2(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(TimiBaseInputViewV2 this$0) {
        Object obj;
        InputMethodManager inputMethodManager;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context activityContext = this$0.getActivityContext();
        IBinder iBinder = null;
        if (activityContext != null) {
            obj = activityContext.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        } else {
            obj = null;
        }
        if (obj instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) obj;
        } else {
            inputMethodManager = null;
        }
        Activity d16 = com.tencent.timi.game.utils.b.d(this$0);
        if (d16 != null && (frameLayout = (FrameLayout) d16.findViewById(R.id.content)) != null) {
            iBinder = frameLayout.getWindowToken();
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(TimiBaseInputViewV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout funcLayout = this$0.getFuncLayout();
        if (funcLayout != null) {
            funcLayout.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(TimiBaseInputViewV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout funcLayout = this$0.getFuncLayout();
        if (funcLayout != null) {
            funcLayout.removeAllViews();
        }
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    protected boolean L() {
        TimiEmoPanelView d06 = d0();
        if (d06 == null) {
            return false;
        }
        return d06.h();
    }

    public final void b0(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.timiEmoSendListenerList.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TimiEmoPanelView c0(long scene) {
        zg4.d dVar = zg4.d.f452533a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dVar.a(new m(context, this.emojiCallbackV2, scene, w(), this, g0(), this.yesGameId));
    }

    @Nullable
    public abstract TimiEmoPanelView d0();

    @Nullable
    public final View e0() {
        return getFuncLayout();
    }

    @Nullable
    public final View f0() {
        return getInputLayout();
    }

    @Nullable
    public abstract ViewGroup g0();

    public final void h0(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.timiEmoSendListenerList.remove(listener);
    }

    public final void l0(int yesGameId) {
        this.yesGameId = yesGameId;
        TimiEmoPanelView d06 = d0();
        if (d06 == null) {
            return;
        }
        d06.k(yesGameId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        if (r6 != 3) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c2 A[LOOP:0: B:14:0x00bc->B:16:0x00c2, LOOP_END] */
    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setState(int state) {
        Iterator<T> it;
        FrameLayout funcLayout;
        R(s());
        Q(state);
        l.b("TimiBaseInputViewV2_", "state: " + s());
        if (w() != null && s() != 2 && (funcLayout = getFuncLayout()) != null) {
            funcLayout.post(new Runnable() { // from class: com.tencent.timi.game.component.chat.d
                @Override // java.lang.Runnable
                public final void run() {
                    TimiBaseInputViewV2.i0(TimiBaseInputViewV2.this);
                }
            });
        }
        int s16 = s();
        int i3 = 0;
        if (s16 != 1) {
            if (s16 == 2) {
                FrameLayout funcLayout2 = getFuncLayout();
                if (funcLayout2 != null) {
                    if (s() != 1) {
                        i3 = getKeyboardHeight();
                    }
                    fh4.g.k(funcLayout2, i3);
                }
                if (s() == 1) {
                    EditText w3 = w();
                    if (w3 != null) {
                        w3.clearFocus();
                    }
                    FrameLayout funcLayout3 = getFuncLayout();
                    if (funcLayout3 != null) {
                        funcLayout3.post(new Runnable() { // from class: com.tencent.timi.game.component.chat.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                TimiBaseInputViewV2.k0(TimiBaseInputViewV2.this);
                            }
                        });
                    }
                }
            }
            it = B().iterator();
            while (it.hasNext()) {
                ((TimiBaseInputView.b) it.next()).onStateChanged(s());
            }
        }
        FrameLayout funcLayout4 = getFuncLayout();
        if (funcLayout4 != null) {
            if (s() != 1) {
                i3 = getKeyboardHeight();
            }
            fh4.g.l(funcLayout4, i3, 500L);
        }
        if (s() == 1) {
            EditText w16 = w();
            if (w16 != null) {
                w16.clearFocus();
            }
            FrameLayout funcLayout5 = getFuncLayout();
            if (funcLayout5 != null) {
                funcLayout5.postDelayed(new Runnable() { // from class: com.tencent.timi.game.component.chat.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        TimiBaseInputViewV2.j0(TimiBaseInputViewV2.this);
                    }
                }, 500L);
            }
        }
        it = B().iterator();
        while (it.hasNext()) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiBaseInputViewV2(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ TimiBaseInputViewV2(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiBaseInputViewV2(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.timiEmoSendListenerList = new HashSet<>();
        this.emojiCallbackV2 = new c();
        this.yesGameId = -1;
    }
}
