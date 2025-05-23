package com.tencent.qqnt.emotion;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\u0006\u0010>\u001a\u00020\u0012\u00a2\u0006\u0004\b?\u0010@B\u001b\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u00a2\u0006\u0004\b?\u0010AB\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b?\u0010BJ\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/emotion/SystemAndEmojiPanel;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/qqnt/emotion/b;", "", "e", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "dataList", "a", "Lcom/tencent/qqnt/b;", "emotionCallback", "f", "Landroid/widget/EditText;", "editText", "g", "", "visibility", "setOperationVisibility", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "d", "Landroid/widget/EditText;", "inputEdit", "Landroid/widget/ImageButton;", "Landroid/widget/ImageButton;", "deleteButton", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "sendButton", "Landroid/view/ViewGroup;", tl.h.F, "Landroid/view/ViewGroup;", "containerOperation", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "emotionRecyclerView", "Lcom/tencent/qqnt/emotion/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/emotion/d;", "emotionAdapter", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/b;", "D", "I", "columnNum", "Lcom/tencent/qqnt/emotion/h;", "E", "Lcom/tencent/qqnt/emotion/h;", "presenter", "Landroid/text/TextWatcher;", UserInfo.SEX_FEMALE, "Landroid/text/TextWatcher;", "textWatcher", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class SystemAndEmojiPanel extends RelativeLayout implements View.OnClickListener, b {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.b emotionCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private int columnNum;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private h presenter;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextWatcher textWatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText inputEdit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageButton deleteButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView sendButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup containerOperation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView emotionRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private d emotionAdapter;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/emotion/SystemAndEmojiPanel$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemAndEmojiPanel.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            ViewGroup viewGroup = SystemAndEmojiPanel.this.containerOperation;
            TextView textView = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerOperation");
                viewGroup = null;
            }
            if (TextUtils.isEmpty(s16)) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            viewGroup.setVisibility(i3);
            ImageButton imageButton = SystemAndEmojiPanel.this.deleteButton;
            if (imageButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
                imageButton = null;
            }
            imageButton.setEnabled(!TextUtils.isEmpty(s16));
            TextView textView2 = SystemAndEmojiPanel.this.sendButton;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendButton");
            } else {
                textView = textView2;
            }
            textView.setEnabled(!TextUtils.isEmpty(s16));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemAndEmojiPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.columnNum = 7;
            this.textWatcher = new a();
        }
    }

    @Override // com.tencent.qqnt.emotion.b
    public void a(@NotNull List<? extends SystemAndEmojiEmotionInfo> dataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dataList);
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        d dVar = this.emotionAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emotionAdapter");
            dVar = null;
        }
        dVar.setData(dataList);
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        h hVar = new h(this);
        this.presenter = hVar;
        hVar.d();
        View.inflate(getContext(), R.layout.e76, this);
        d dVar = null;
        setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bim, null));
        View findViewById = findViewById(R.id.bfq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.delete_btn)");
        this.deleteButton = (ImageButton) findViewById;
        View findViewById2 = findViewById(R.id.send_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.send_btn)");
        this.sendButton = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.u77);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.container_operation)");
        this.containerOperation = (ViewGroup) findViewById3;
        EditText editText = this.inputEdit;
        if (editText != null) {
            Intrinsics.checkNotNull(editText);
            Editable text = editText.getText();
            ImageButton imageButton = this.deleteButton;
            if (imageButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
                imageButton = null;
            }
            imageButton.setEnabled(!TextUtils.isEmpty(text));
            TextView textView = this.sendButton;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendButton");
                textView = null;
            }
            textView.setEnabled(!TextUtils.isEmpty(text));
        }
        ImageButton imageButton2 = this.deleteButton;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
            imageButton2 = null;
        }
        imageButton2.setOnClickListener(this);
        TextView textView2 = this.sendButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendButton");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        View findViewById4 = findViewById(R.id.utn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.emotion_panel_rv)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.emotionRecyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emotionRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), this.columnNum));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.qqnt.emotion.a aVar = new com.tencent.qqnt.emotion.a(context, this.emotionCallback);
        RecyclerView recyclerView2 = this.emotionRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emotionRecyclerView");
            recyclerView2 = null;
        }
        aVar.c(recyclerView2);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.emotionAdapter = new d(aVar, context2);
        RecyclerView recyclerView3 = this.emotionRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emotionRecyclerView");
            recyclerView3 = null;
        }
        d dVar2 = this.emotionAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emotionAdapter");
        } else {
            dVar = dVar2;
        }
        recyclerView3.setAdapter(dVar);
        h hVar2 = this.presenter;
        if (hVar2 != null) {
            hVar2.f();
        }
    }

    @NotNull
    public final SystemAndEmojiPanel f(@NotNull com.tencent.qqnt.b emotionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SystemAndEmojiPanel) iPatchRedirector.redirect((short) 8, (Object) this, (Object) emotionCallback);
        }
        Intrinsics.checkNotNullParameter(emotionCallback, "emotionCallback");
        this.emotionCallback = emotionCallback;
        return this;
    }

    @NotNull
    public final SystemAndEmojiPanel g(@NotNull EditText editText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SystemAndEmojiPanel) iPatchRedirector.redirect((short) 11, (Object) this, (Object) editText);
        }
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.inputEdit = editText;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        EditText editText = this.inputEdit;
        if (editText != null) {
            editText.addTextChangedListener(this.textWatcher);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        com.tencent.qqnt.b bVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) v3);
        } else if (v3 != null) {
            int id5 = v3.getId();
            if (id5 == R.id.bfq) {
                com.tencent.qqnt.b bVar2 = this.emotionCallback;
                if (bVar2 != null) {
                    bVar2.delete();
                }
            } else if (id5 == R.id.send_btn && (bVar = this.emotionCallback) != null) {
                bVar.e0();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        EditText editText = this.inputEdit;
        if (editText != null) {
            editText.removeTextChangedListener(this.textWatcher);
        }
    }

    public final void setOperationVisibility(int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, visibility);
            return;
        }
        ViewGroup viewGroup = this.containerOperation;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerOperation");
            viewGroup = null;
        }
        viewGroup.setVisibility(visibility);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SystemAndEmojiPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SystemAndEmojiPanel(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }
}
