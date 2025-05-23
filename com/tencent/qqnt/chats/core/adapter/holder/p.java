package com.tencent.qqnt.chats.core.adapter.holder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.api.ITransitionAPI;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/p;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "", "r", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l", "Lpw3/c;", "E", "Lpw3/c;", "binding", "Lcom/tencent/qqnt/chats/core/adapter/h;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chats/core/adapter/h;", "recentContactItemListener", "<init>", "(Lpw3/c;Lcom/tencent/qqnt/chats/core/adapter/h;)V", "G", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class p extends b<com.tencent.qqnt.chats.core.adapter.itemdata.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final pw3.c binding;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.chats.core.adapter.h recentContactItemListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/p$a;", "", "", "CANCEL_BUTTON", "Ljava/lang/String;", "SEARCH_BAR", "SEARCH_BG", "SEARCH_ICON", "TEXT_VIEW", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.holder.p$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p(@NotNull pw3.c binding, @Nullable com.tencent.qqnt.chats.core.adapter.h hVar) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        ConstraintLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) binding, (Object) hVar);
        } else {
            this.binding = binding;
            this.recentContactItemListener = hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(p this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.chats.core.adapter.h hVar = this$0.recentContactItemListener;
        if (hVar != null) {
            hVar.g(this$0.binding);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void r() {
        QRouteApi api = QRoute.api(ITransitionAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITransitionAPI::class.java)");
        ITransitionAPI iTransitionAPI = (ITransitionAPI) api;
        TextView textView = this.binding.f427802c.f427799e;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.searchContainer.textView");
        iTransitionAPI.addViewToTransitionPool(textView, "text_view");
        ConstraintLayout constraintLayout = this.binding.f427802c.f427797c;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.searchContainer.searchBar");
        iTransitionAPI.addViewToTransitionPool(constraintLayout, QCircleDaTongConstant.ElementParamValue.SEARCH_BAR);
        ImageView imageView = this.binding.f427802c.f427796b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchContainer.chatSearchIcon");
        iTransitionAPI.addViewToTransitionPool(imageView, "search_icon");
        ImageView imageView2 = this.binding.f427802c.f427798d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.searchContainer.searchBarBg");
        iTransitionAPI.addViewToTransitionPool(imageView2, "search_bg");
        Button button = this.binding.f427801b;
        Intrinsics.checkNotNullExpressionValue(button, "binding.cancel");
        iTransitionAPI.addViewToTransitionPool(button, "cancel_button");
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void l(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        this.binding.f427802c.f427797c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chats.core.adapter.holder.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.q(p.this, view);
            }
        });
        r();
    }
}
