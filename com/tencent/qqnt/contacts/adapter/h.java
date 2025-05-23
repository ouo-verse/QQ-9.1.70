package com.tencent.qqnt.contacts.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.a;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.contacts.data.j;
import com.tencent.qqnt.contacts.data.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/contacts/adapter/h;", "Lcom/tencent/qqnt/base/adapter/a;", "Lcom/tencent/qqnt/contacts/data/f;", "Lsw3/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/base/adapter/d;", "l0", "<init>", "()V", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h extends com.tencent.qqnt.base.adapter.a<com.tencent.qqnt.contacts.data.f, sw3.c> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/contacts/adapter/h$a;", "Lcom/tencent/qqnt/base/adapter/d;", "Lcom/tencent/qqnt/contacts/data/f;", "Lsw3/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "p", "binding", "<init>", "(Lsw3/c;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends com.tencent.qqnt.base.adapter.d<com.tencent.qqnt.contacts.data.f, sw3.c> {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull sw3.c binding) {
            super(binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) binding);
            }
        }

        @Override // com.tencent.qqnt.base.adapter.d
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void l(@NotNull com.tencent.qqnt.contacts.data.f item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof com.tencent.qqnt.contacts.data.g) {
                o().f434894c.setVisibility(0);
                o().f434893b.setVisibility(0);
                o().f434895d.f434908c.setVisibility(8);
                com.tencent.qqnt.contacts.data.g gVar = (com.tencent.qqnt.contacts.data.g) item;
                o().f434894c.setText(gVar.g());
                b.Companion companion = com.tencent.qqnt.avatar.b.INSTANCE;
                b.a aVar = new b.a();
                aVar.g(AvatarSizeType.SMALL);
                aVar.b(Integer.valueOf(R.mipmap.f169222w));
                com.tencent.qqnt.avatar.b a16 = aVar.a();
                a.Companion companion2 = com.tencent.qqnt.avatar.a.INSTANCE;
                Context context = o().f434893b.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "binding.contactsAvatar.context");
                com.tencent.qqnt.avatar.f b16 = companion2.b(context);
                RoundRectImageView roundRectImageView = o().f434893b;
                Intrinsics.checkNotNullExpressionValue(roundRectImageView, "binding.contactsAvatar");
                e.a.a(b16.b(roundRectImageView).e(a16), gVar.f(), null, 2, null);
                return;
            }
            if (item instanceof k) {
                o().f434894c.setVisibility(8);
                o().f434893b.setVisibility(8);
                o().f434895d.f434908c.setVisibility(0);
                o().f434895d.f434907b.setText(((k) item).f());
                return;
            }
            if (item instanceof j) {
                o().f434894c.setVisibility(0);
                o().f434893b.setVisibility(0);
                o().f434895d.f434908c.setVisibility(8);
                j jVar = (j) item;
                o().f434894c.setText(jVar.f());
                b.Companion companion3 = com.tencent.qqnt.avatar.b.INSTANCE;
                b.a aVar2 = new b.a();
                aVar2.g(AvatarSizeType.SMALL);
                com.tencent.qqnt.avatar.b a17 = aVar2.a();
                a.Companion companion4 = com.tencent.qqnt.avatar.a.INSTANCE;
                Context context2 = o().f434893b.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "binding.contactsAvatar.context");
                com.tencent.qqnt.avatar.f b17 = companion4.b(context2);
                RoundRectImageView roundRectImageView2 = o().f434893b;
                Intrinsics.checkNotNullExpressionValue(roundRectImageView2, "binding.contactsAvatar");
                e.a.b(b17.b(roundRectImageView2).e(a17), jVar.g(), jVar.h(), null, 4, null);
            }
        }
    }

    public h() {
        super(e.f355784a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.base.adapter.d<com.tencent.qqnt.contacts.data.f, sw3.c> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.base.adapter.d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        sw3.c g16 = sw3.c.g(i0(parent), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(parent.layoutInflater, parent, false)");
        return new a(g16);
    }
}
