package com.tencent.nativepreview.biz;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u00109\u001a\u00020\u000b\u0012\b\b\u0002\u0010:\u001a\u00020\u000b\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001fR\u0018\u0010(\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR\u0018\u0010*\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR\u0018\u0010-\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006="}, d2 = {"Lcom/tencent/nativepreview/biz/FindReplaceView;", "Landroid/widget/FrameLayout;", "", "k", HippyTKDListViewAdapter.X, "Lcom/tencent/nativepreview/wrapper/model/DocSearchState;", "result", "y", "", "text", "t", "", "offset", "r", "", "replaceAll", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/nativepreview/biz/i;", "handler", "setSearchHandler", "options", "setSearchOptions", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "mFindInput", "e", "mReplaceInput", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mFindInfoText", tl.h.F, "mCancelBtn", "i", "mPreviousBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mNextBtn", BdhLogUtil.LogTag.Tag_Conn, "mReplaceBtn", "D", "mReplaceAllBtn", "E", "Lcom/tencent/nativepreview/biz/i;", "mSearchHandler", UserInfo.SEX_FEMALE, "Lcom/tencent/nativepreview/wrapper/model/DocSearchState;", "mDocSearchState", "Landroid/os/Handler;", "G", "Landroid/os/Handler;", "mMainHandler", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public final class FindReplaceView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mReplaceBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView mReplaceAllBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private i mSearchHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private DocSearchState mDocSearchState;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Handler mMainHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText mFindInput;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText mReplaceInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mFindInfoText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mCancelBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mPreviousBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mNextBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/nativepreview/biz/FindReplaceView$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes21.dex */
    public static final class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FindReplaceView.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
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
            Editable text;
            String obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            EditText editText = FindReplaceView.this.mFindInput;
            if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null) {
                FindReplaceView.this.t(obj);
            }
        }
    }

    @JvmOverloads
    public FindReplaceView(@Nullable Context context) {
        this(context, null, 0, 0, 14, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
    }

    private final void k() {
        Object systemService = getContext().getSystemService("layout_inflater");
        if (systemService != null) {
            ((LayoutInflater) systemService).inflate(R.layout.e6d, this);
            this.mFindInput = (EditText) findViewById(R.id.v6c);
            this.mReplaceInput = (EditText) findViewById(R.id.f73063sj);
            this.mFindInfoText = (TextView) findViewById(R.id.v6b);
            this.mCancelBtn = (TextView) findViewById(R.id.aou);
            this.mPreviousBtn = (TextView) findViewById(R.id.f27480gc);
            this.mNextBtn = (TextView) findViewById(R.id.f8w);
            this.mReplaceBtn = (TextView) findViewById(R.id.f73043sh);
            this.mReplaceAllBtn = (TextView) findViewById(R.id.f73023sf);
            EditText editText = this.mFindInput;
            if (editText != null) {
                editText.addTextChangedListener(new a());
            }
            TextView textView = this.mPreviousBtn;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.nativepreview.biz.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FindReplaceView.l(FindReplaceView.this, view);
                    }
                });
            }
            TextView textView2 = this.mNextBtn;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.nativepreview.biz.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FindReplaceView.m(FindReplaceView.this, view);
                    }
                });
            }
            TextView textView3 = this.mReplaceBtn;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.nativepreview.biz.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FindReplaceView.n(FindReplaceView.this, view);
                    }
                });
            }
            TextView textView4 = this.mReplaceAllBtn;
            if (textView4 != null) {
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.nativepreview.biz.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FindReplaceView.o(FindReplaceView.this, view);
                    }
                });
            }
            TextView textView5 = this.mCancelBtn;
            if (textView5 != null) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.nativepreview.biz.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FindReplaceView.p(FindReplaceView.this, view);
                    }
                });
            }
            x();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FindReplaceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r(-1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(FindReplaceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(FindReplaceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FindReplaceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(FindReplaceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q() {
        i iVar = this.mSearchHandler;
        if (iVar != null) {
            iVar.a(this.mDocSearchState);
        }
        this.mDocSearchState = new DocSearchState();
        x();
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void r(int offset) {
        i iVar = this.mSearchHandler;
        if (iVar == null) {
            return;
        }
        Intrinsics.checkNotNull(iVar);
        if (iVar.c(this.mDocSearchState, offset)) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.tencent.nativepreview.biz.f
                @Override // java.lang.Runnable
                public final void run() {
                    FindReplaceView.s(FindReplaceView.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(FindReplaceView this$0) {
        DocSearchState currentState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i iVar = this$0.mSearchHandler;
        if (iVar != null && (currentState = iVar.getCurrentState()) != null) {
            this$0.y(currentState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(String text) {
        if (this.mSearchHandler == null) {
            return;
        }
        this.mDocSearchState.setPattern(text);
        i iVar = this.mSearchHandler;
        Intrinsics.checkNotNull(iVar);
        if (iVar.c(this.mDocSearchState, 0L)) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.tencent.nativepreview.biz.h
                @Override // java.lang.Runnable
                public final void run() {
                    FindReplaceView.u(FindReplaceView.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(FindReplaceView this$0) {
        DocSearchState currentState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i iVar = this$0.mSearchHandler;
        if (iVar != null && (currentState = iVar.getCurrentState()) != null) {
            this$0.y(currentState);
        }
    }

    private final void v(boolean replaceAll) {
        if (this.mSearchHandler == null) {
            return;
        }
        DocSearchState docSearchState = this.mDocSearchState;
        EditText editText = this.mReplaceInput;
        Intrinsics.checkNotNull(editText);
        docSearchState.setReplacement(editText.getText().toString());
        i iVar = this.mSearchHandler;
        Intrinsics.checkNotNull(iVar);
        if (iVar.b(this.mDocSearchState, replaceAll)) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.tencent.nativepreview.biz.g
                @Override // java.lang.Runnable
                public final void run() {
                    FindReplaceView.w(FindReplaceView.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(FindReplaceView this$0) {
        DocSearchState currentState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i iVar = this$0.mSearchHandler;
        if (iVar != null && (currentState = iVar.getCurrentState()) != null) {
            this$0.y(currentState);
        }
    }

    private final void x() {
        EditText editText = this.mFindInput;
        if (editText != null) {
            editText.setText("");
        }
        EditText editText2 = this.mReplaceInput;
        if (editText2 != null) {
            editText2.setText("");
        }
        TextView textView = this.mFindInfoText;
        if (textView != null) {
            textView.setText("0");
        }
        TextView textView2 = this.mPreviousBtn;
        if (textView2 != null) {
            textView2.setEnabled(false);
        }
        TextView textView3 = this.mNextBtn;
        if (textView3 != null) {
            textView3.setEnabled(false);
        }
        TextView textView4 = this.mReplaceBtn;
        if (textView4 != null) {
            textView4.setEnabled(false);
        }
        TextView textView5 = this.mReplaceAllBtn;
        if (textView5 != null) {
            textView5.setEnabled(false);
        }
        if (!this.mDocSearchState.getReplace()) {
            EditText editText3 = this.mReplaceInput;
            if (editText3 != null) {
                editText3.setVisibility(8);
            }
            TextView textView6 = this.mReplaceBtn;
            if (textView6 != null) {
                textView6.setVisibility(4);
            }
            TextView textView7 = this.mReplaceAllBtn;
            if (textView7 != null) {
                textView7.setVisibility(4);
                return;
            }
            return;
        }
        EditText editText4 = this.mReplaceInput;
        if (editText4 != null) {
            editText4.setVisibility(0);
        }
        TextView textView8 = this.mReplaceBtn;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        TextView textView9 = this.mReplaceAllBtn;
        if (textView9 != null) {
            textView9.setVisibility(0);
        }
    }

    private final void y(DocSearchState result) {
        this.mDocSearchState = result;
        if (result.getCount() > 0) {
            TextView textView = this.mFindInfoText;
            if (textView != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(result.getIndex());
                sb5.append('/');
                sb5.append(result.getCount());
                textView.setText(sb5.toString());
            }
            TextView textView2 = this.mPreviousBtn;
            if (textView2 != null) {
                textView2.setEnabled(true);
            }
            TextView textView3 = this.mNextBtn;
            if (textView3 != null) {
                textView3.setEnabled(true);
            }
            TextView textView4 = this.mReplaceBtn;
            if (textView4 != null) {
                textView4.setEnabled(true);
            }
            TextView textView5 = this.mReplaceAllBtn;
            if (textView5 != null) {
                textView5.setEnabled(true);
                return;
            }
            return;
        }
        TextView textView6 = this.mFindInfoText;
        if (textView6 != null) {
            textView6.setText("0");
        }
        TextView textView7 = this.mPreviousBtn;
        if (textView7 != null) {
            textView7.setEnabled(false);
        }
        TextView textView8 = this.mNextBtn;
        if (textView8 != null) {
            textView8.setEnabled(false);
        }
        TextView textView9 = this.mReplaceBtn;
        if (textView9 != null) {
            textView9.setEnabled(false);
        }
        TextView textView10 = this.mReplaceAllBtn;
        if (textView10 != null) {
            textView10.setEnabled(false);
        }
    }

    public final void setSearchHandler(@Nullable i handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) handler);
        } else {
            this.mSearchHandler = handler;
        }
    }

    public final void setSearchOptions(@Nullable DocSearchState options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) options);
            return;
        }
        if (options == null) {
            return;
        }
        this.mDocSearchState.setFindType(options.getFindType());
        this.mDocSearchState.setCaseSensitive(options.getCaseSensitive());
        this.mDocSearchState.setHighlight(options.getHighlight());
        this.mDocSearchState.setReplace(options.getReplace());
        x();
    }

    @JvmOverloads
    public FindReplaceView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
    }

    @JvmOverloads
    public FindReplaceView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3));
    }

    public /* synthetic */ FindReplaceView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FindReplaceView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNull(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mDocSearchState = new DocSearchState();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        k();
    }
}
