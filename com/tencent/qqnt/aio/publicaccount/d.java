package com.tencent.qqnt.aio.publicaccount;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.publicaccount.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p81.l;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010\u001aJ\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000f\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\"\u0010\u001b\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/publicaccount/d;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/qqnt/aio/publicaccount/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "j", "Landroid/text/Editable;", "inputText", DomainData.DOMAIN_NAME, "binding", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Ljava/lang/Class;", "getObserverStates", "state", "i", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", h.F, "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "r", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "Lp81/l;", "f", "Lp81/l;", "mBinding", "", "Z", "requestFocusAndShowSoft", "<init>", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.qqnt.aio.publicaccount.viewbinding.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private l mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean requestFocusAndShowSoft;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                d.this.n(s16);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    public d(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
            this.requestFocusAndShowSoft = true;
        }
    }

    private final void j() {
        l lVar = this.mBinding;
        l lVar2 = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar = null;
        }
        LinearLayout root = lVar.getRoot();
        root.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        l lVar3 = this.mBinding;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar3 = null;
        }
        AIOEditText initView$lambda$2 = lVar3.f425776c;
        Intrinsics.checkNotNullExpressionValue(initView$lambda$2, "initView$lambda$2");
        initView$lambda$2.addTextChangedListener(new a());
        com.tencent.mobileqq.aio.input.themecompat.a aVar = com.tencent.mobileqq.aio.input.themecompat.a.f189924a;
        Context context = initView$lambda$2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        initView$lambda$2.setTextColor(com.tencent.mobileqq.aio.input.themecompat.a.e(aVar, context, false, 2, null));
        ViewGroup.LayoutParams layoutParams2 = initView$lambda$2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = ViewUtils.dip2px(10.0f);
        AIOUtil aIOUtil = AIOUtil.f194084a;
        l lVar4 = this.mBinding;
        if (lVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar4 = null;
        }
        aIOUtil.G(lVar4.f425776c, com.tencent.mobileqq.aio.input.themecompat.a.b(aVar, false, 1, null));
        l lVar5 = this.mBinding;
        if (lVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar5 = null;
        }
        lVar5.f425775b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.publicaccount.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.k(d.this, view);
            }
        });
        l lVar6 = this.mBinding;
        if (lVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            lVar2 = lVar6;
        }
        lVar2.f425777d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.publicaccount.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.l(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p(a.C9493a.f351881d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p(a.b.f351882d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Editable inputText) {
        boolean isBlank;
        if (inputText == null) {
            return;
        }
        l lVar = this.mBinding;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar = null;
        }
        QUIButton qUIButton = lVar.f425778e;
        isBlank = StringsKt__StringsJVMKt.isBlank(inputText);
        boolean z16 = true;
        boolean z17 = !isBlank;
        if (inputText.length() <= 0) {
            z16 = false;
        }
        qUIButton.setEnabled(z17 | z16);
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
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        c.a.e(this, reuseParam);
        l lVar = this.mBinding;
        l lVar2 = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar = null;
        }
        Editable text = lVar.f425776c.getText();
        if (text != null) {
            text.clear();
        }
        l lVar3 = this.mBinding;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar3 = null;
        }
        AIOEditText aIOEditText = lVar3.f425776c;
        com.tencent.mobileqq.aio.input.themecompat.a aVar = com.tencent.mobileqq.aio.input.themecompat.a.f189924a;
        l lVar4 = this.mBinding;
        if (lVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar4 = null;
        }
        Context context = lVar4.f425776c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.input.context");
        aIOEditText.setTextColor(com.tencent.mobileqq.aio.input.themecompat.a.e(aVar, context, false, 2, null));
        AIOUtil aIOUtil = AIOUtil.f194084a;
        l lVar5 = this.mBinding;
        if (lVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar5 = null;
        }
        aIOUtil.G(lVar5.f425776c, com.tencent.mobileqq.aio.input.themecompat.a.b(aVar, false, 1, null));
        l lVar6 = this.mBinding;
        if (lVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            lVar6 = null;
        }
        lVar6.f425775b.setSelected(false);
        l lVar7 = this.mBinding;
        if (lVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            lVar2 = lVar7;
        }
        lVar2.f425777d.setSelected(false);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
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
        List<Class<? extends InputUIState>> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.qqnt.aio.publicaccount.viewbinding.a binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.mContext = context;
        this.mBinding = binding.e();
        j();
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void p(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            c.a.d(this);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
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
