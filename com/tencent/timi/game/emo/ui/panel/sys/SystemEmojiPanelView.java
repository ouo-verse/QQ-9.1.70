package com.tencent.timi.game.emo.ui.panel.sys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bh4.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.emo.ui.panel.sys.SystemEmojiPanelView;
import com.tencent.timi.game.utils.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xg4.e;
import xg4.m;
import xg4.n;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001;\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001\fB;\b\u0007\u0012\u0006\u0010D\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010G\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0015J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006K"}, d2 = {"Lcom/tencent/timi/game/emo/ui/panel/sys/SystemEmojiPanelView;", "Landroid/widget/FrameLayout;", "Lbh4/a;", "", "l", "k", "p", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "getView", "destroy", "a", "", "onBackEvent", "d", "b", "", com.tencent.luggage.wxa.c8.c.G, "onPageSelected", "yesGameId", "g", "Lxg4/m;", "Lxg4/m;", "getPanelParam", "()Lxg4/m;", "panelParam", "Lxg4/a;", "e", "Lxg4/a;", "getPanelData", "()Lxg4/a;", "panelData", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Ldh4/c;", h.F, "Ldh4/c;", "mAdapter", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "i", "Landroidx/lifecycle/Observer;", "mDataObserver", "Landroid/widget/ImageButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageButton;", "mDeleteButton", "Ljava/util/concurrent/atomic/AtomicBoolean;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/atomic/AtomicBoolean;", "mLongClickFlag", "Lah4/a;", "D", "Lah4/a;", "mReportHelper", "com/tencent/timi/game/emo/ui/panel/sys/SystemEmojiPanelView$b", "E", "Lcom/tencent/timi/game/emo/ui/panel/sys/SystemEmojiPanelView$b;", "mLongClickDeleteTimer", "Landroid/text/TextWatcher;", UserInfo.SEX_FEMALE, "Landroid/text/TextWatcher;", "textWatcher", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILxg4/m;Lxg4/a;)V", "G", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class SystemEmojiPanelView extends FrameLayout implements a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean mLongClickFlag;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ah4.a mReportHelper;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b mLongClickDeleteTimer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextWatcher textWatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m panelParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final xg4.a panelData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final dh4.c mAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<SystemAndEmojiEmoticonInfo>> mDataObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageButton mDeleteButton;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/emo/ui/panel/sys/SystemEmojiPanelView$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            SystemEmojiPanelView.this.mDeleteButton.setEnabled(!TextUtils.isEmpty(s16));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SystemEmojiPanelView(@NotNull Context context) {
        this(context, null, 0, null, null, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void k() {
        this.mLongClickDeleteTimer.start();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void l() {
        Editable editableText;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = com.tencent.timi.game.utils.b.a(5);
        layoutParams.setMarginEnd(com.tencent.timi.game.utils.b.a(5));
        layoutParams.bottomMargin = com.tencent.timi.game.utils.b.a(7);
        layoutParams.gravity = 8388693;
        boolean z16 = false;
        this.mDeleteButton.setVisibility(0);
        this.mDeleteButton.setBackgroundResource(R.drawable.lol);
        addView(this.mDeleteButton, layoutParams);
        this.mDeleteButton.setOnClickListener(new View.OnClickListener() { // from class: dh4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SystemEmojiPanelView.m(SystemEmojiPanelView.this, view);
            }
        });
        EditText inputEditText = this.panelParam.getInputEditText();
        if (inputEditText != null && (editableText = inputEditText.getEditableText()) != null) {
            ImageButton imageButton = this.mDeleteButton;
            if (editableText.length() > 0) {
                z16 = true;
            }
            imageButton.setEnabled(z16);
        }
        this.mDeleteButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: dh4.f
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean n3;
                n3 = SystemEmojiPanelView.n(SystemEmojiPanelView.this, view);
                return n3;
            }
        });
        this.mDeleteButton.setOnTouchListener(new View.OnTouchListener() { // from class: dh4.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean o16;
                o16 = SystemEmojiPanelView.o(SystemEmojiPanelView.this, view, motionEvent);
                return o16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(SystemEmojiPanelView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n callback = this$0.panelParam.getCallback();
        if (callback != null) {
            callback.delete();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(SystemEmojiPanelView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i("SystemEmojiPanelView_", "long click");
        this$0.mLongClickFlag.set(true);
        this$0.k();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(SystemEmojiPanelView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            this$0.mLongClickFlag.set(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        Integer num;
        Editable editableText;
        EditText inputEditText = this.panelParam.getInputEditText();
        if (inputEditText != null && (editableText = inputEditText.getEditableText()) != null) {
            num = Integer.valueOf(editableText.length());
        } else {
            num = null;
        }
        if (this.mLongClickFlag.get() && (num == null || num.intValue() != 0)) {
            n callback = this.panelParam.getCallback();
            if (callback != null) {
                callback.delete();
                return;
            }
            return;
        }
        this.mLongClickDeleteTimer.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(SystemEmojiPanelView this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dh4.c cVar = this$0.mAdapter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        cVar.refresh(it);
        this$0.mReportHelper.a(it.size());
    }

    @Override // bh4.a
    @Nullable
    public View b() {
        return null;
    }

    @Override // bh4.a
    public boolean d() {
        return false;
    }

    @Override // bh4.a
    public void destroy() {
        e.d.f447986b.b().removeObserver(this.mDataObserver);
        this.mLongClickDeleteTimer.cancel();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EditText inputEditText = this.panelParam.getInputEditText();
        if (inputEditText != null) {
            inputEditText.addTextChangedListener(this.textWatcher);
        }
    }

    @Override // bh4.a
    public boolean onBackEvent() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EditText inputEditText = this.panelParam.getInputEditText();
        if (inputEditText != null) {
            inputEditText.removeTextChangedListener(this.textWatcher);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SystemEmojiPanelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SystemEmojiPanelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SystemEmojiPanelView(Context context, AttributeSet attributeSet, int i3, m mVar, xg4.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? new m(context, null, 0L, null, null, null, 0, 126, null) : mVar, (i16 & 16) != 0 ? new xg4.a(0L, 0L, 0, null, 15, null) : aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SystemEmojiPanelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull m panelParam, @NotNull xg4.a panelData) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        Intrinsics.checkNotNullParameter(panelData, "panelData");
        this.panelParam = panelParam;
        this.panelData = panelData;
        RecyclerView recyclerView = new RecyclerView(context);
        this.mRecyclerView = recyclerView;
        dh4.c cVar = new dh4.c(context, 7, panelParam, panelData);
        this.mAdapter = cVar;
        Observer<List<SystemAndEmojiEmoticonInfo>> observer = new Observer() { // from class: dh4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SystemEmojiPanelView.q(SystemEmojiPanelView.this, (List) obj);
            }
        };
        this.mDataObserver = observer;
        this.mDeleteButton = new ImageButton(context);
        this.mLongClickFlag = new AtomicBoolean(false);
        ah4.a aVar = new ah4.a(99L);
        this.mReportHelper = aVar;
        this.mLongClickDeleteTimer = new b();
        this.textWatcher = new c();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setOverScrollMode(2);
        recyclerView.setAdapter(cVar);
        addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
        aVar.b();
        e.d dVar = e.d.f447986b;
        dVar.b().observeForever(observer);
        dVar.d();
        l();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/emo/ui/panel/sys/SystemEmojiPanelView$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends CountDownTimer {
        b() {
            super(Long.MAX_VALUE, 100L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            SystemEmojiPanelView.this.p();
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }
    }

    @Override // bh4.a
    public void a() {
    }

    @Override // bh4.a
    @NotNull
    public View getView() {
        return this;
    }

    @Override // bh4.a
    public void g(int yesGameId) {
    }

    @Override // bh4.a
    public void onPageSelected(int pos) {
    }
}
