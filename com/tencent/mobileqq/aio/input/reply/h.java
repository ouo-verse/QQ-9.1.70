package com.tencent.mobileqq.aio.input.reply;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.MainThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.reply.InputReplyUIState;
import com.tencent.mobileqq.aio.input.reply.b;
import com.tencent.mobileqq.aio.reply.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001H\u0018\u0000 M2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001NB\u000f\u0012\u0006\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\bL\u0010)J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030 \u0018\u00010\u001fH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\"\u0010*\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R6\u00108\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000204\u0018\u000103j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000204\u0018\u0001`58\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/aio/input/reply/h;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Lcom/tencent/mobileqq/aio/input/reply/InputReplyUIState$SetReplyUIState;", "state", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "replyMsgId", "", "nickName", "", "replyContent", "", "from", "y", "Lcom/tencent/mobileqq/aio/reply/d;", "replyMsgSpan", "Lcom/tencent/mobileqq/aio/reply/d$a;", "clearDrawableListener", "k", "l", "", "isFullScreenMode", "w", "binding", ReportConstant.COSTREPORT_PREFIX, "", "Ljava/lang/Class;", "getObserverStates", "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/aio/input/adorn/b;", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "Landroid/widget/EditText;", "f", "Landroid/widget/EditText;", "mEditText", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "mReportParams", "i", "Z", "mIsImmersive", "Landroid/text/method/MovementMethod;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/text/method/MovementMethod;", "mReplyClickMovementMethod", "Landroid/view/View$OnClickListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnClickListener;", "mInputSourceListener", "Landroid/view/View$OnLayoutChangeListener;", "D", "Landroid/view/View$OnLayoutChangeListener;", "mInputWidthChangeListener", "com/tencent/mobileqq/aio/input/reply/h$b", "E", "Lcom/tencent/mobileqq/aio/input/reply/h$b;", "mClearDrawableClickListener", "<init>", UserInfo.SEX_FEMALE, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.adorn.e> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener mInputSourceListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener mInputWidthChangeListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b mClearDrawableClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<String, Object> mReportParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsImmersive;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MovementMethod mReplyClickMovementMethod;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/input/reply/h$a;", "", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.reply.h$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/aio/input/reply/h$b", "Lcom/tencent/mobileqq/aio/reply/d$a;", "", "a", "", "Ljava/lang/Integer;", "getFrom", "()Ljava/lang/Integer;", "b", "(Ljava/lang/Integer;)V", "from", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements d.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer from;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.reply.d.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            h.this.v(b.a.f189818d);
            Integer num = this.from;
            if ((num == null || num.intValue() != 0) && h.this.mReportParams != null) {
                com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_reference_message_deletion");
            }
        }

        public final void b(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
            } else {
                this.from = num;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56850);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mInputSourceListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.reply.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.p(h.this, view);
            }
        };
        this.mInputWidthChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.input.reply.f
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                h.r(h.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
        this.mClearDrawableClickListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(h this$0, InputReplyUIState.SetReplyUIState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.y(state.c(), state.d(), state.b(), state.a());
    }

    private final void k(com.tencent.mobileqq.aio.reply.d replyMsgSpan, d.a clearDrawableListener) {
        if (com.tencent.mobileqq.aio.reply.b.c()) {
            replyMsgSpan.k(clearDrawableListener);
            this.mReplyClickMovementMethod = com.tencent.mobileqq.aio.reply.a.getInstance();
            EditText editText = this.mEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            editText.setCompoundDrawables(null, replyMsgSpan.getDrawable(), null, null);
            editText.setCompoundDrawablePadding(20);
            editText.setTag(R.id.gja, replyMsgSpan);
            editText.setMovementMethod(this.mReplyClickMovementMethod);
        }
    }

    private final void l() {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setCompoundDrawables(null, null, null, null);
        editText.setTag(R.id.gja, null);
        editText.post(new Runnable() { // from class: com.tencent.mobileqq.aio.input.reply.d
            @Override // java.lang.Runnable
            public final void run() {
                h.m(h.this);
            }
        });
        HashMap<String, Object> hashMap = this.mReportParams;
        if (hashMap != null) {
            com.tencent.mobileqq.aio.utils.b.t("em_bas_reference_message_area", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        EditText editText3 = this$0.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        editText.setSelection(editText2.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(b.C7283b.f189819d);
        HashMap<String, Object> hashMap = this$0.mReportParams;
        if (hashMap != null) {
            com.tencent.mobileqq.aio.utils.b.l("em_bas_reference_message_area", hashMap);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(h this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        com.tencent.mobileqq.aio.reply.d dVar;
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i27 - i19;
        int i36 = i17 - i3;
        if (i36 != i29 && i36 > 0 && i29 > 0) {
            EditText editText = this$0.mEditText;
            EditText editText2 = null;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            Object tag = editText.getTag(R.id.gja);
            if (tag instanceof com.tencent.mobileqq.aio.reply.d) {
                dVar = (com.tencent.mobileqq.aio.reply.d) tag;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                Context context2 = this$0.mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context = null;
                } else {
                    context = context2;
                }
                CharSequence charSequence = dVar.f193184h;
                EditText editText3 = this$0.mEditText;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    editText3 = null;
                }
                int paddingLeft = i36 - editText3.getPaddingLeft();
                EditText editText4 = this$0.mEditText;
                if (editText4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    editText4 = null;
                }
                int paddingRight = paddingLeft - editText4.getPaddingRight();
                EditText editText5 = this$0.mEditText;
                if (editText5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                } else {
                    editText2 = editText5;
                }
                com.tencent.mobileqq.aio.reply.d c16 = com.tencent.mobileqq.aio.reply.d.c(context, charSequence, paddingRight, editText2.getPaint(), this$0.mInputSourceListener, this$0.mIsImmersive);
                if (c16 != null) {
                    this$0.k(c16, this$0.mClearDrawableClickListener);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(h this$0, View view, int i3, KeyEvent keyEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 67 && keyEvent.getAction() == 0) {
            EditText editText = this$0.mEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                editText = null;
            }
            Editable text = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "mEditText.text");
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this$0.v(b.a.f189818d);
            }
        }
        return false;
    }

    private final void w(boolean isFullScreenMode) {
        MovementMethod movementMethod = this.mReplyClickMovementMethod;
        if (movementMethod != null && (movementMethod instanceof com.tencent.mobileqq.aio.reply.a)) {
            Intrinsics.checkNotNull(movementMethod, "null cannot be cast to non-null type com.tencent.mobileqq.aio.reply.ReplyClickMovementMethod");
            ((com.tencent.mobileqq.aio.reply.a) movementMethod).c(isFullScreenMode);
        }
    }

    private final void y(long replyMsgId, String nickName, CharSequence replyContent, int from) {
        Context context;
        SpannableStringBuilder append = new SpannableStringBuilder("").append(replyContent);
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        int width = editText.getWidth();
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText3 = null;
        }
        int paddingLeft = width - editText3.getPaddingLeft();
        EditText editText4 = this.mEditText;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText4 = null;
        }
        int paddingRight = paddingLeft - editText4.getPaddingRight();
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        } else {
            context = context2;
        }
        EditText editText5 = this.mEditText;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText5;
        }
        com.tencent.mobileqq.aio.reply.d c16 = com.tencent.mobileqq.aio.reply.d.c(context, append, paddingRight, editText2.getPaint(), this.mInputSourceListener, this.mIsImmersive);
        if (c16 != null) {
            b bVar = this.mClearDrawableClickListener;
            bVar.b(Integer.valueOf(from));
            Unit unit = Unit.INSTANCE;
            k(c16, bVar);
            if (from == 0) {
                return;
            }
            this.mReportParams = new HashMap<>();
            Integer valueOf = Integer.valueOf(from);
            HashMap<String, Object> hashMap = this.mReportParams;
            Intrinsics.checkNotNull(hashMap);
            hashMap.put("source_operation", valueOf);
            HashMap<String, Object> hashMap2 = this.mReportParams;
            Intrinsics.checkNotNull(hashMap2);
            com.tencent.mobileqq.aio.utils.b.q("em_bas_reference_message_area", hashMap2);
        }
    }

    private final void z(final InputReplyUIState.SetReplyUIState state) {
        this.mIsImmersive = state.e();
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.aio.input.reply.g
            @Override // java.lang.Runnable
            public final void run() {
                h.A(h.this, state);
            }
        };
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        if (editText.getWidth() <= 0) {
            EditText editText3 = this.mEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                editText2 = editText3;
            }
            editText2.post(runnable);
            return;
        }
        runnable.run();
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            c.a.b(this);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            c.a.e(this, bVar);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar);
        }
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{InputReplyUIState.SetReplyUIState.class, InputReplyUIState.ClearReplyUIState.class, InputReplyUIState.SetFullScreenModeUIState.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof InputReplyUIState.SetReplyUIState) {
            z((InputReplyUIState.SetReplyUIState) state);
        } else if (state instanceof InputReplyUIState.ClearReplyUIState) {
            l();
        } else if (state instanceof InputReplyUIState.SetFullScreenModeUIState) {
            w(((InputReplyUIState.SetFullScreenModeUIState) state).a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            l();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.adorn.e binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        EditText a16 = binding.a();
        this.mEditText = a16;
        EditText editText = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            a16 = null;
        }
        Context context = a16.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mEditText.context");
        this.mContext = context;
        EditText editText2 = this.mEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText2 = null;
        }
        editText2.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.mobileqq.aio.input.reply.c
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean t16;
                t16 = h.t(h.this, view, i3, keyEvent);
                return t16;
            }
        });
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText = editText3;
        }
        editText.addOnLayoutChangeListener(this.mInputWidthChangeListener);
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void v(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }
}
