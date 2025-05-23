package com.tencent.mobileqq.aio.input.quicksearch;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.MainThread;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.aio.input.adorn.e;
import com.tencent.mobileqq.aio.input.quicksearch.InputQuickSearchUIState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.api.ability.d;
import com.tencent.qqnt.search.api.IAIOHashTagSearchLinkApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001&\u0018\u0000 +2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001\u000eB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b*\u0010\u0016J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b0\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\"\u0010\u0017\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/aio/input/quicksearch/b;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "Ljava/lang/Class;", "getObserverStates", "binding", "", "i", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "state", h.F, "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "g", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "j", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Lcom/tencent/qqnt/search/api/a;", "e", "Lcom/tencent/qqnt/search/api/a;", "quickSearchHelper", "", "f", "Z", "mEnable", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "mEditText", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "com/tencent/mobileqq/aio/input/quicksearch/b$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/input/quicksearch/b$b;", "mTextWatcher", "<init>", BdhLogUtil.LogTag.Tag_Conn, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, e> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final List<Class<?>> D;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.search.api.a quickSearchHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mEnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7281b mTextWatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/input/quicksearch/b$a;", "", "", "Ljava/lang/Class;", "BARRIER_SPANS", "Ljava/util/List;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.quicksearch.b$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/input/quicksearch/b$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.quicksearch.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7281b implements TextWatcher {
        static IPatchRedirector $redirector_;

        C7281b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
            } else if (b.this.mEnable && s16 != null) {
                b.this.quickSearchHelper.a(s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    static {
        List<Class<?>> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(com.tencent.qqnt.aio.at.c.class);
        D = listOf;
    }

    public b(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.quickSearchHelper = IAIOHashTagSearchLinkApi.f362083g.newInputHelper();
        this.mTextWatcher = new C7281b();
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        c.a.b(this);
        com.tencent.qqnt.search.api.a aVar = this.quickSearchHelper;
        List<Class<?>> list = D;
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        aVar.b(list, editText);
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText3;
        }
        editText2.addTextChangedListener(this.mTextWatcher);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
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

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar);
        }
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(InputQuickSearchUIState.EnableFlag.class);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof InputQuickSearchUIState.EnableFlag) {
            this.mEnable = ((InputQuickSearchUIState.EnableFlag) state).a();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull e binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        EditText a16 = binding.a();
        this.mEditText = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            a16 = null;
        }
        Context context = a16.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mEditText.context");
        this.mContext = context;
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        c.a.d(this);
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.removeTextChangedListener(this.mTextWatcher);
    }
}
