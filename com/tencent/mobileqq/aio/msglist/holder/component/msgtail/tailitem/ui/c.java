package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", "aioEmoReplyItem", "", DomainData.DOMAIN_NAME, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", "Landroid/view/View;", "v", "", NodeProps.ON_LONG_CLICK, "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "E", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "p", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "adapter", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", "r", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;)V", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;)V", "G", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class c extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e adapter;

    /* renamed from: F, reason: from kotlin metadata */
    public com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g aioEmoReplyItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c$a;", "", "", "EMOJI_MARGIN_LEFT", UserInfo.SEX_FEMALE, "EMOJI_MARGIN_RIGHT", "EMOJI_SIZE", "ITEM_END_MARGIN", "ITEM_TOP_MARGIN", "", "TAG", "Ljava/lang/String;", "TEXT_MARGIN_RIGHT", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f191275d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f191276e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f191277f;

        public b(long j3, View view, c cVar) {
            this.f191275d = j3;
            this.f191276e = view;
            this.f191277f = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), view, cVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.c() > this.f191275d) {
                    com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.k(currentTimeMillis);
                    this.f191277f.onClick(this.f191276e);
                } else {
                    try {
                        QQToast.makeText(this.f191276e.getContext(), HardCodeUtil.qqStr(R.string.f2172360g), 0).show();
                    } catch (Throwable unused) {
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull View itemView, @NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e adapter) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) adapter);
            return;
        }
        this.adapter = adapter;
        itemView.setOnClickListener(new b(300L, itemView, this));
        itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean m3;
                m3 = c.m(c.this, view);
                return m3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(c this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return this$0.onLongClick(it);
    }

    public final void n(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g aioEmoReplyItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aioEmoReplyItem);
            return;
        }
        Intrinsics.checkNotNullParameter(aioEmoReplyItem, "aioEmoReplyItem");
        r(aioEmoReplyItem);
        View view = this.itemView;
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.j7s);
        Intrinsics.checkNotNull(drawable);
        view.setBackground(drawable.mutate());
        View view2 = this.itemView;
        FlexboxLayoutManager.LayoutParams layoutParams = new FlexboxLayoutManager.LayoutParams(-2, x.a(24.0f));
        layoutParams.setMarginEnd(x.a(4.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = x.a(4.0f);
        view2.setLayoutParams(layoutParams);
        o(aioEmoReplyItem);
    }

    public abstract void o(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g item);

    public boolean onLongClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3)).booleanValue();
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }

    @NotNull
    public final com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.adapter;
    }

    @NotNull
    public final com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g gVar = this.aioEmoReplyItem;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aioEmoReplyItem");
        return null;
    }

    public final void r(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
        } else {
            Intrinsics.checkNotNullParameter(gVar, "<set-?>");
            this.aioEmoReplyItem = gVar;
        }
    }
}
