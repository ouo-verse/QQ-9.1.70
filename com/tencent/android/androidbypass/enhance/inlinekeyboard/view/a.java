package com.tencent.android.androidbypass.enhance.inlinekeyboard.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J_\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J$\u0010\u001e\u001a\u00020\u000f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010 R.\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00078\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010&R(\u0010/\u001a\b\u0012\u0004\u0012\u00020(0'8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/a;", "DispatchContext", "Payload", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/a$a;", "ctx", "payload", "", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "buttonRows", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "listener", "Lkotlin/Function1;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "styleSheetProvider", "", "n0", "(Ljava/lang/Object;Ljava/lang/Object;[[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;Lkotlin/jvm/functions/Function1;)V", "j0", "()[[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "getItemCount", "position", "", "getItemId", "holder", "l0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Object;", BdhLogUtil.LogTag.Tag_Conn, "D", "[[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "k0", "setButtonRows$bypass_release", "([[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;)V", "", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/b;", "E", "Ljava/util/List;", "i0", "()Ljava/util/List;", "setButtonList$bypass_release", "(Ljava/util/List;)V", "buttonList", UserInfo.SEX_FEMALE, "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "G", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a<DispatchContext, Payload> extends RecyclerView.Adapter<C0721a<DispatchContext, Payload>> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private Payload payload;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] buttonRows;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.android.androidbypass.enhance.inlinekeyboard.model.b> buttonList;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> listener;

    /* renamed from: G, reason: from kotlin metadata */
    private Function1<? super com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a, ? extends InlineBtnStyleSheet> styleSheetProvider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private DispatchContext ctx;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u00a2\u0006\u0004\b\n\u0010\u000bR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/a$a;", "DispatchContext", "Payload", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "E", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "l", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "<init>", "(Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.enhance.inlinekeyboard.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0721a<DispatchContext, Payload> extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final InlineBtnView<DispatchContext, Payload> btnView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0721a(@NotNull InlineBtnView<DispatchContext, Payload> btnView) {
            super(btnView);
            Intrinsics.checkNotNullParameter(btnView, "btnView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) btnView);
            } else {
                this.btnView = btnView;
            }
        }

        @NotNull
        public final InlineBtnView<DispatchContext, Payload> l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (InlineBtnView) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.btnView;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.buttonRows = new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[0];
        this.buttonList = new ArrayList();
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.buttonList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, position)).longValue();
        }
        return position;
    }

    @NotNull
    public final List<com.tencent.android.androidbypass.enhance.inlinekeyboard.model.b> i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.buttonList;
    }

    @NotNull
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.buttonRows;
    }

    @NotNull
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][]) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.buttonRows;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C0721a<DispatchContext, Payload> holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a a16 = this.buttonList.get(position).a();
        InlineBtnView<DispatchContext, Payload> l3 = holder.l();
        Function1<? super com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a, ? extends InlineBtnStyleSheet> function1 = this.styleSheetProvider;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleSheetProvider");
        }
        l3.setMStyleSheet$bypass_release(function1.invoke(a16));
        l3.setBtnInfo(this.ctx, this.payload, a16, this.listener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public C0721a<DispatchContext, Payload> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (C0721a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new C0721a<>(new InlineBtnView(context, null));
    }

    public final void n0(@Nullable DispatchContext ctx, @Nullable Payload payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] buttonRows, @Nullable com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> listener, @NotNull Function1<? super com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a, ? extends InlineBtnStyleSheet> styleSheetProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, ctx, payload, buttonRows, listener, styleSheetProvider);
            return;
        }
        Intrinsics.checkNotNullParameter(buttonRows, "buttonRows");
        Intrinsics.checkNotNullParameter(styleSheetProvider, "styleSheetProvider");
        this.ctx = ctx;
        this.payload = payload;
        this.buttonRows = buttonRows;
        this.listener = listener;
        this.styleSheetProvider = styleSheetProvider;
        this.buttonList.clear();
        int length = buttonRows.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[] aVarArr = buttonRows[i3];
            int i17 = i16 + 1;
            int length2 = aVarArr.length;
            int i18 = 0;
            int i19 = 0;
            while (i18 < length2) {
                this.buttonList.add(new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.b(i16, i19, aVarArr[i18]));
                i18++;
                i19++;
            }
            i3++;
            i16 = i17;
        }
        notifyDataSetChanged();
    }
}
