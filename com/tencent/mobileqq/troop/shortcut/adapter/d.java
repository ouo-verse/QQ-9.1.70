package com.tencent.mobileqq.troop.shortcut.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutInfo;
import com.tencent.mobileqq.troop.utils.ay;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts2.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u000f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/adapter/d;", "Lcom/tencent/mobileqq/troop/shortcut/adapter/a;", "", "o", "", "position", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "data", "l", "Lts2/g;", "E", "Lts2/g;", "getBinding", "()Lts2/g;", "binding", "Lkotlin/Function1;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "onItemClick", "G", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "currentData", "<init>", "(Lts2/g;Lkotlin/jvm/functions/Function1;)V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final g binding;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function1<TroopShortcutInfo, Unit> onItemClick;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TroopShortcutInfo currentData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/adapter/d$a;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "", "onItemClick", "Lcom/tencent/mobileqq/troop/shortcut/adapter/d;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.adapter.d$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final d a(@NotNull Context context, @NotNull Function1<? super TroopShortcutInfo, Unit> onItemClick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) onItemClick);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
            g g16 = g.g(LayoutInflater.from(context));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
            return new d(g16, onItemClick);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55051);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d(@NotNull g binding, @NotNull Function1<? super TroopShortcutInfo, Unit> onItemClick) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) binding, (Object) onItemClick);
            return;
        }
        this.binding = binding;
        this.onItemClick = onItemClick;
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.shortcut.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.n(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o() {
        TroopShortcutInfo troopShortcutInfo = this.currentData;
        if (troopShortcutInfo == null) {
            return;
        }
        this.onItemClick.invoke(troopShortcutInfo);
    }

    @Override // com.tencent.mobileqq.troop.shortcut.adapter.a
    public void l(int position, @NotNull TroopShortcutInfo data) {
        int i3;
        int i16;
        int i17;
        Drawable mutate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, position, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.currentData = data;
        this.binding.getRoot().setSelected(data.h());
        ImageView imageView = this.binding.f437395e;
        if (data.e().isEmpty()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        this.binding.f437394d.setText(data.f());
        ay ayVar = ay.f302095a;
        String d16 = data.d();
        ImageFilterView imageFilterView = this.binding.f437393c;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.appIcon");
        ayVar.a(d16, imageFilterView);
        if (data.h()) {
            i16 = R.color.qui_common_brand_standard;
        } else {
            i16 = R.color.qui_common_text_primary;
        }
        this.binding.f437394d.setTextColor(ie0.a.f().g(this.binding.f437394d.getContext(), i16, 1000));
        if (this.binding.f437395e.getVisibility() == 0) {
            if (data.h()) {
                i17 = R.color.qui_common_icon_aio_toolbar_active;
            } else {
                i17 = R.color.qui_common_icon_primary;
            }
            Drawable drawable = this.binding.f437395e.getDrawable();
            if (drawable != null && (mutate = drawable.mutate()) != null) {
                mutate.setTint(ie0.a.f().g(this.binding.f437394d.getContext(), i17, 1000));
            }
        }
    }
}
