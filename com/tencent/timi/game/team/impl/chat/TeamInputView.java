package com.tencent.timi.game.team.impl.chat;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.widget.util.KeyboardUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.TimiBaseInputViewV2;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.emo.ui.TimiEmoPanelView;
import com.tencent.timi.game.team.impl.chat.TeamInputView;
import com.tencent.timi.game.team.impl.chat.a;
import com.tencent.timi.game.utils.l;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tm4.g;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$MsgContent;
import yn4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\b\u00a2\u0006\u0004\b%\u0010&J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006'"}, d2 = {"Lcom/tencent/timi/game/team/impl/chat/TeamInputView;", "Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2;", "Landroid/widget/EditText;", "w", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/ImageView;", "s0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "M", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/timi/game/emo/ui/TimiEmoPanelView;", "d0", "Landroid/view/ViewGroup;", "g0", "w0", "", "v0", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "sendBtn", "T", "Landroid/widget/EditText;", "inputEt", "U", "Landroid/widget/ImageView;", "emojiIv", "V", "Lcom/tencent/timi/game/emo/ui/TimiEmoPanelView;", "mEmoPanelView", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TeamInputView extends TimiBaseInputViewV2 {

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private View sendBtn;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private EditText inputEt;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ImageView emojiIv;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private TimiEmoPanelView mEmoPanelView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamInputView$b", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "a", "b", "", "state", "onStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements TimiBaseInputView.b {
        b() {
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            int i3;
            if (state == 1) {
                FrameLayout funcLayout = TeamInputView.this.getFuncLayout();
                if (funcLayout != null) {
                    funcLayout.removeAllViews();
                }
                ImageView imageView = TeamInputView.this.emojiIv;
                if (imageView != null) {
                    g.a(imageView, fh4.b.b(16));
                }
            } else {
                ImageView imageView2 = TeamInputView.this.emojiIv;
                if (imageView2 != null) {
                    g.a(imageView2, fh4.b.b(12));
                }
            }
            ImageView imageView3 = TeamInputView.this.emojiIv;
            if (imageView3 != null) {
                if (state == 3) {
                    i3 = R.drawable.f162556o84;
                } else {
                    i3 = R.drawable.f162555o83;
                }
                imageView3.setBackgroundResource(i3);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamInputView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(TeamInputView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.inputEt;
        if (editText != null) {
            editText.setEditableFactory(this$0.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(TeamInputView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.s() == 3) {
            this$0.setState(1);
        } else {
            this$0.setState(3);
            FrameLayout funcLayout = this$0.getFuncLayout();
            if (funcLayout != null) {
                funcLayout.removeAllViews();
            }
            TimiEmoPanelView timiEmoPanelView = this$0.mEmoPanelView;
            if (timiEmoPanelView == null) {
                timiEmoPanelView = this$0.c0(2L);
            } else {
                timiEmoPanelView.j();
            }
            FrameLayout funcLayout2 = this$0.getFuncLayout();
            if (funcLayout2 != null) {
                funcLayout2.addView(timiEmoPanelView, new FrameLayout.LayoutParams(fh4.b.e(this$0), fh4.b.e(this$0)));
            }
            this$0.mEmoPanelView = timiEmoPanelView;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    @Nullable
    /* renamed from: A, reason: from getter */
    public View getSendBtn() {
        return this.sendBtn;
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    public void M() {
        this.sendBtn = findViewById(R.id.f83174iv);
        this.inputEt = (EditText) findViewById(R.id.dmu);
        this.emojiIv = (ImageView) findViewById(R.id.usz);
        EditText editText = this.inputEt;
        if (editText != null) {
            editText.addTextChangedListener(new a());
        }
        EditText editText2 = this.inputEt;
        if (editText2 != null) {
            editText2.post(new Runnable() { // from class: tm4.c
                @Override // java.lang.Runnable
                public final void run() {
                    TeamInputView.t0(TeamInputView.this);
                }
            });
        }
        ImageView imageView = this.emojiIv;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: tm4.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TeamInputView.u0(TeamInputView.this, view);
                }
            });
        }
        String c16 = c.c(R.string.f236787fa);
        Intrinsics.checkNotNullExpressionValue(c16, "getString(R.string.try_send_something)");
        TimiBaseInputView.K(this, 0.0f, 0, c16, 3, null);
        i(new b());
    }

    @Override // com.tencent.timi.game.component.chat.TimiBaseInputViewV2
    @Nullable
    /* renamed from: d0, reason: from getter */
    public TimiEmoPanelView getMEmoPanelView() {
        return this.mEmoPanelView;
    }

    @Override // com.tencent.timi.game.component.chat.TimiBaseInputViewV2
    @Nullable
    public ViewGroup g0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TimiEmoPanelView timiEmoPanelView = this.mEmoPanelView;
        if (timiEmoPanelView != null) {
            timiEmoPanelView.e();
        }
    }

    @Nullable
    /* renamed from: s0, reason: from getter */
    public ImageView getEmojiIv() {
        return this.emojiIv;
    }

    public boolean v0() {
        TimiEmoPanelView timiEmoPanelView;
        if (getCurrentState() != 3 || (timiEmoPanelView = this.mEmoPanelView) == null) {
            return false;
        }
        return timiEmoPanelView.i();
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    @Nullable
    /* renamed from: w, reason: from getter */
    public EditText getInputEt() {
        return this.inputEt;
    }

    public void w0() {
        TimiEmoPanelView timiEmoPanelView;
        if (getCurrentState() == 3 && (timiEmoPanelView = this.mEmoPanelView) != null) {
            timiEmoPanelView.j();
        }
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    public int z() {
        return R.layout.hwx;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamInputView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ TeamInputView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamInputView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamInputView$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final TeamInputView this$0, List list) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (list.size() != 0) {
                EditText editText = this$0.inputEt;
                Intrinsics.checkNotNull(editText);
                int selectionStart = editText.getSelectionStart();
                EditText editText2 = this$0.inputEt;
                Intrinsics.checkNotNull(editText2);
                if (!editText2.getText().toString().equals("")) {
                    EditText editText3 = this$0.inputEt;
                    Intrinsics.checkNotNull(editText3);
                    editText3.getText().delete(selectionStart - 1, selectionStart);
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a.d dVar = (a.d) it.next();
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = dVar.f379428b;
                Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "atMember.qqUserId");
                this$0.g(commonOuterClass$QQUserId, dVar.f379427a, "");
                SpecialMsgUtil specialMsgUtil = SpecialMsgUtil.f376345a;
                CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = dVar.f379428b;
                Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId2, "atMember.qqUserId");
                specialMsgUtil.g(commonOuterClass$QQUserId2, dVar.f379427a, this$0.inputEt, this$0);
            }
            this$0.postDelayed(new Runnable() { // from class: tm4.f
                @Override // java.lang.Runnable
                public final void run() {
                    TeamInputView.a.d(TeamInputView.this);
                }
            }, 550L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(TeamInputView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.U();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16 = false;
            if (s16 == null) {
                View view = TeamInputView.this.sendBtn;
                if (view != null) {
                    view.setEnabled(false);
                    return;
                }
                return;
            }
            View view2 = TeamInputView.this.sendBtn;
            if (view2 != null) {
                if (s16.length() > 0) {
                    z16 = true;
                }
                view2.setEnabled(z16);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            Character ch5;
            boolean z16;
            if (s16 != null) {
                if (s16.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
            }
            if (before == 0 && count == 1) {
                if (s16 != null) {
                    ch5 = Character.valueOf(s16.charAt(start));
                } else {
                    ch5 = null;
                }
                l.b("TeamInputView", String.valueOf(ch5));
                if (String.valueOf(ch5).equals("@") && com.tencent.timi.game.team.impl.chat.a.p0()) {
                    EditText editText = TeamInputView.this.inputEt;
                    Intrinsics.checkNotNull(editText);
                    KeyboardUtils.c(editText);
                    final TeamInputView teamInputView = TeamInputView.this;
                    com.tencent.timi.game.team.impl.chat.a.q0(new a.e() { // from class: tm4.e
                        @Override // com.tencent.timi.game.team.impl.chat.a.e
                        public final void a(List list) {
                            TeamInputView.a.c(TeamInputView.this, list);
                        }
                    });
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
