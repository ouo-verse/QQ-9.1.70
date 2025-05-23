package com.tencent.icgame.liveroom.impl.room.live.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.component.chat.input.TimiBaseInputView;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\b\u00a2\u0006\u0004\b\"\u0010#J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\bH\u0016J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorInputBoxView;", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "Landroid/widget/EditText;", "w", "Landroid/widget/TextView;", "V", "Landroid/widget/ImageView;", "U", "", HippyTKDListViewAdapter.X, "", "J", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "end", "T", "Landroid/view/View;", "view", "j", "M", "Landroid/widget/EditText;", "inputEt", "N", "Landroid/widget/ImageView;", "emojiIv", "P", "Landroid/widget/TextView;", "sendTv", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class HorInputBoxView extends TimiBaseInputView {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private EditText inputEt;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ImageView emojiIv;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TextView sendTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/liveroom/impl/room/live/widget/HorInputBoxView$a", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements TimiBaseInputView.b {
        a() {
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            int i3;
            ImageView imageView = HorInputBoxView.this.emojiIv;
            if (imageView != null) {
                if (state == 3) {
                    i3 = R.drawable.f162554o82;
                } else {
                    i3 = R.drawable.f162553o81;
                }
                imageView.setImageResource(i3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/liveroom/impl/room/live/widget/HorInputBoxView$c", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements InputFilter {
        c() {
        }

        @Override // android.text.InputFilter
        @Nullable
        public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
            String replace$default;
            boolean contains$default;
            boolean z16 = false;
            if (source != null) {
                contains$default = StringsKt__StringsKt.contains$default(source, (CharSequence) "\n", false, 2, (Object) null);
                if (contains$default) {
                    z16 = true;
                }
            }
            if (!z16) {
                return null;
            }
            replace$default = StringsKt__StringsJVMKt.replace$default(source.toString(), "\n", "", false, 4, (Object) null);
            return replace$default;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HorInputBoxView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(HorInputBoxView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.s() == 3) {
            this$0.P();
        } else {
            this$0.setState(3);
            FrameLayout funcLayout = this$0.getFuncLayout();
            if (funcLayout != null) {
                funcLayout.removeAllViews();
            }
            View m3 = this$0.m(Integer.valueOf(Color.parseColor("#0B0820")), 12);
            FrameLayout funcLayout2 = this$0.getFuncLayout();
            if (funcLayout2 != null) {
                funcLayout2.addView(m3, new FrameLayout.LayoutParams(uu0.a.e(this$0), uu0.a.e(this$0)));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    protected int C() {
        return uu0.a.b(52);
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    public void J() {
        this.inputEt = (EditText) findViewById(R.id.dmu);
        this.emojiIv = (ImageView) findViewById(R.id.usz);
        this.sendTv = (TextView) findViewById(R.id.f83174iv);
        EditText editText = this.inputEt;
        if (editText != null) {
            editText.setEditableFactory(t());
        }
        FrameLayout funcLayout = getFuncLayout();
        if (funcLayout != null) {
            funcLayout.setBackgroundColor(Color.parseColor("#0B0820"));
        }
        f(new a());
        EditText editText2 = this.inputEt;
        if (editText2 != null) {
            editText2.addTextChangedListener(new b());
        }
        ImageView imageView = this.emojiIv;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.live.widget.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HorInputBoxView.W(HorInputBoxView.this, view);
                }
            });
        }
        EditText editText3 = this.inputEt;
        if (editText3 != null) {
            editText3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(40), new c()});
        }
        EditText editText4 = this.inputEt;
        Intrinsics.checkNotNull(editText4, "null cannot be cast to non-null type java.lang.Object");
        VideoReport.setElementId(editText4, "em_qqlive_inputpanel_box");
        VideoReport.setLogicParent(this.inputEt, this.sendTv);
    }

    public final void T(boolean end) {
        ImageView emojiIv;
        TextView z16 = z();
        if (z16 == null || (emojiIv = getEmojiIv()) == null) {
            return;
        }
        if (end) {
            ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp_end", z16, new LinkedHashMap());
            ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp_end", emojiIv, new LinkedHashMap());
        } else {
            ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp", z16, new LinkedHashMap());
            ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp", emojiIv, new LinkedHashMap());
        }
    }

    @Nullable
    /* renamed from: U, reason: from getter */
    public ImageView getEmojiIv() {
        return this.emojiIv;
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    @Nullable
    /* renamed from: V, reason: from getter and merged with bridge method [inline-methods] */
    public TextView getSendView() {
        return this.sendTv;
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    protected void j(@NotNull View view) {
        Map<String, String> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("clck", view, new LinkedHashMap());
        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_SUBMIT_WAY, "2"), TuplesKt.to(DTParamKey.REPORT_KEY_SUBMIT_TYPE, DTConstants.KeyBoardAction.ACTION_SEND));
        aVar.reportEvent(DTEventKey.SUBMIT, view, mutableMapOf);
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    public int q() {
        return 40;
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    @Nullable
    /* renamed from: w, reason: from getter */
    public EditText getEditText() {
        return this.inputEt;
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    public int x() {
        return R.layout.fbj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HorInputBoxView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ HorInputBoxView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HorInputBoxView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/liveroom/impl/room/live/widget/HorInputBoxView$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            TextView textView = HorInputBoxView.this.sendTv;
            if (textView != null) {
                int i3 = 0;
                if (s16 != null && s16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    i3 = 8;
                }
                textView.setVisibility(i3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
