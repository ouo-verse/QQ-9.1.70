package com.tencent.qqnt.chats.core.adapter.builder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.quibadge.b;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chats.core.adapter.h;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.itempart.d;
import com.tencent.qqnt.chats.kit.x2k.ChatRecentContactItemLayout;
import com.tencent.qqnt.chats.utils.preload.LayoutPreLoader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J6\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R$\u0010#\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "p", "v", "t", "u", HippyTKDListViewAdapter.X, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View$OnClickListener;", "listener", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "Lcom/tencent/qqnt/chats/core/adapter/h;", "operatorListener", DomainData.DOMAIN_NAME, "w", "b", "Lcom/tencent/qqnt/chats/core/itempart/d;", "getMItemPartCollect", "()Lcom/tencent/qqnt/chats/core/itempart/d;", "o", "(Lcom/tencent/qqnt/chats/core/itempart/d;)V", "mItemPartCollect", "<init>", "()V", "c", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class CommonRecentItemBuilder extends a<RecentContactItemHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final CommonRecentItemBuilder f354453d;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mItemPartCollect;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder$a;", "", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "INSTANCE", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "a", "()Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "getINSTANCE$annotations", "()V", "", "TAG", "Ljava/lang/String;", "<init>", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        public final CommonRecentItemBuilder a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return CommonRecentItemBuilder.f354453d;
            }
            return (CommonRecentItemBuilder) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45533);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
            f354453d = new CommonRecentItemBuilder();
        }
    }

    public CommonRecentItemBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005f, code lost:
    
        if (r5 == null) goto L12;
     */
    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    @NotNull
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecentContactItemHolder a(@NotNull ViewGroup parent, int viewType, @Nullable d itemPartCollect, @Nullable b dragListener, @Nullable h operatorListener) {
        ChatRecentContactItemLayout a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (RecentContactItemHolder) iPatchRedirector.redirect((short) 12, this, parent, Integer.valueOf(viewType), itemPartCollect, dragListener, operatorListener);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutPreLoader a17 = com.tencent.qqnt.chats.utils.preload.b.f355561a.a("chat_list");
        if (a17 != null) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            a16 = (ChatRecentContactItemLayout) a17.k("Default_Recent_Item", new LayoutPreLoader.b(context));
        }
        a16 = com.tencent.qqnt.chats.core.utils.b.f355092a.a(xv3.a.a(parent));
        this.mItemPartCollect = itemPartCollect;
        ab.c(a16.getRoot());
        a16.s().setOnModeChangeListener(dragListener);
        RecentContactItemBinding recentContactItemBinding = new RecentContactItemBinding(a16.s(), a16.p(), a16.q(), a16.r(), a16.o(), a16.f(), a16.getRoot(), a16.i(), a16.g(), a16.j(), a16.l(), a16.h(), null, null, 12288, null);
        recentContactItemBinding.q(a16.k());
        return new RecentContactItemHolder(this, recentContactItemBinding, operatorListener);
    }

    public final void o(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
        } else {
            this.mItemPartCollect = dVar;
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: p */
    public void c(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        d dVar = this.mItemPartCollect;
        if (dVar != null) {
            dVar.a().d(item, holder);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void d(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        com.tencent.qqnt.chats.core.itempart.background.a b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        d dVar = this.mItemPartCollect;
        if (dVar != null && (b16 = dVar.b()) != null) {
            b16.a(item, holder);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        com.tencent.qqnt.chats.core.itempart.content.a c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        d dVar = this.mItemPartCollect;
        if (dVar != null && (c16 = dVar.c()) != null) {
            c16.a(item, holder);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull final g item, @NotNull RecentContactItemHolder holder, @NotNull final View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, item, holder, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final RecentContactItemBinding y16 = holder.y();
        com.tencent.qqnt.chats.utils.h.f355549a.e("updateMenu", false, new Function0<Unit>(y16, item, listener) { // from class: com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder$updateMenu$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ RecentContactItemBinding $binding;
            final /* synthetic */ g $item;
            final /* synthetic */ View.OnClickListener $listener;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$binding = y16;
                this.$item = item;
                this.$listener = listener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, CommonRecentItemBuilder.this, y16, item, listener);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                List<View> a16 = CommonRecentItemBuilder.this.b().a(this.$binding.c(), this.$item.a());
                CommonRecentItemBuilder commonRecentItemBuilder = CommonRecentItemBuilder.this;
                g gVar = this.$item;
                View.OnClickListener onClickListener = this.$listener;
                int i3 = 0;
                for (Object obj : a16) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    View view = (View) obj;
                    commonRecentItemBuilder.b().b(view, gVar.a().get(i3));
                    view.setOnClickListener(onClickListener);
                    if (view instanceof TextView) {
                        arrayList.add(((TextView) view).getText().toString());
                    }
                    i3 = i16;
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        d dVar = this.mItemPartCollect;
        if (dVar != null) {
            dVar.d().a(item, holder);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void i(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        d dVar = this.mItemPartCollect;
        if (dVar != null) {
            dVar.e().a(item, holder);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void j(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        d dVar = this.mItemPartCollect;
        if (dVar != null) {
            dVar.f().b(item, holder);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void k(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) item, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        com.tencent.qqnt.chats.core.itempart.unread.a g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) item, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        d dVar = this.mItemPartCollect;
        if (dVar != null && (g16 = dVar.g()) != null) {
            g16.d(item, holder);
        }
    }
}
