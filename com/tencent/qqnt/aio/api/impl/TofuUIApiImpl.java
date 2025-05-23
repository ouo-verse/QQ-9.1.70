package com.tencent.qqnt.aio.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.tofu.IBeancurdFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.ITofuUIApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/TofuUIApiImpl;", "Lcom/tencent/qqnt/aio/api/ITofuUIApi;", "()V", "getDressShowBeancurdView", "Landroid/view/View;", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "getImageBeancurdView", "getMiniCardBeancurdView", "getMultiImageBeancurdView", "getOnlineStatusBeancurdNormalView", "getSystemNoticeBeancurdView", "getTextBeancurdView", "getVideoBeancurdView", "getWithBgTextBeancurdView", "getZPlanAvatarBeancurdView", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class TofuUIApiImpl implements ITofuUIApi {
    static IPatchRedirector $redirector_;

    public TofuUIApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDressShowBeancurdView$lambda$16(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getDressShowBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getImageBeancurdView$lambda$3$lambda$2(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getImageBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMiniCardBeancurdView$lambda$5$lambda$4(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getMiniCardBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMultiImageBeancurdView$lambda$7$lambda$6(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getMultiImageBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOnlineStatusBeancurdNormalView$lambda$9$lambda$8(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getOnlineStatusBeancurdNormalView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSystemNoticeBeancurdView$lambda$18$lambda$17(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getSystemNoticeBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTextBeancurdView$lambda$1$lambda$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click TextBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getVideoBeancurdView$lambda$13$lambda$12(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getVideoBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getWithBgTextBeancurdView$lambda$11$lambda$10(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getWithBgTextBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getZPlanAvatarBeancurdView$lambda$15$lambda$14(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(view.getContext(), "click getZPlanAvatarBeancurdView", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getDressShowBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        IBeancurdFactory.a dressShowBeancurdView = ((IBeancurdFactory) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IBeancurdFactory.class)).getDressShowBeancurdView(context);
        if (!(dressShowBeancurdView instanceof com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a aVar = (com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a) dressShowBeancurdView;
        aVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.ah
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getDressShowBeancurdView$lambda$16(view);
            }
        });
        aVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return aVar.k();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getImageBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.b bVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.b(context);
        bVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getImageBeancurdView$lambda$3$lambda$2(view);
            }
        });
        bVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return bVar.c();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getMiniCardBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.d dVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.d(context);
        dVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.am
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getMiniCardBeancurdView$lambda$5$lambda$4(view);
            }
        });
        dVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return dVar.k();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getMultiImageBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.e eVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.e(context);
        eVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getMultiImageBeancurdView$lambda$7$lambda$6(view);
            }
        });
        eVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return eVar.c();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getOnlineStatusBeancurdNormalView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.f fVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.f(context);
        fVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getOnlineStatusBeancurdNormalView$lambda$9$lambda$8(view);
            }
        });
        fVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return fVar.k();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getSystemNoticeBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.h hVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.h(context);
        hVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getSystemNoticeBeancurdView$lambda$18$lambda$17(view);
            }
        });
        hVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return hVar.c();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getTextBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i iVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i(context);
        iVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getTextBeancurdView$lambda$1$lambda$0(view);
            }
        });
        iVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return iVar.c();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getVideoBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j jVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.j(context);
        jVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getVideoBeancurdView$lambda$13$lambda$12(view);
            }
        });
        jVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return jVar.k();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getWithBgTextBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.k kVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.k(context);
        kVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getWithBgTextBeancurdView$lambda$11$lambda$10(view);
            }
        });
        kVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return kVar.c();
    }

    @Override // com.tencent.qqnt.aio.api.ITofuUIApi
    @Nullable
    public View getZPlanAvatarBeancurdView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.l lVar = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.l(context);
        lVar.w(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TofuUIApiImpl.getZPlanAvatarBeancurdView$lambda$15$lambda$14(view);
            }
        });
        lVar.B((com.tencent.mobileqq.aio.msg.ah) msgItem);
        return lVar.k();
    }
}
