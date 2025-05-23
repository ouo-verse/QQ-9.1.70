package com.tencent.mobileqq.login.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001BB=\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a\u0012\b\u0010)\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u00105\u001a\u000202\u00a2\u0006\u0004\b?\u0010@J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R+\u0010>\u001a\u0002022\u0006\u00109\u001a\u0002028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u00106\"\u0004\b=\u00108\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/login/adapter/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/login/adapter/d;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarIv", "Lcom/tencent/mobileqq/login/account/a;", "account", "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "p0", "holder", "position", "m0", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getAccountList", "()Ljava/util/List;", "setAccountList", "(Ljava/util/List;)V", "accountList", "Lcom/tencent/mobileqq/login/adapter/e;", "D", "Lcom/tencent/mobileqq/login/adapter/e;", "getListener", "()Lcom/tencent/mobileqq/login/adapter/e;", "setListener", "(Lcom/tencent/mobileqq/login/adapter/e;)V", "listener", "", "E", "Ljava/lang/String;", "getUinFromWx", "()Ljava/lang/String;", "setUinFromWx", "(Ljava/lang/String;)V", AppConstants.Key.SHARE_REQ_WX_UIN_FROM_WX, "", UserInfo.SEX_FEMALE, "Z", "isWxBind", "()Z", "setWxBind", "(Z)V", "<set-?>", "G", "Lkotlin/properties/ReadWriteProperty;", "k0", "setDeleteMode", "isDeleteMode", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mobileqq/login/adapter/e;Ljava/lang/String;Z)V", "H", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"NotifyDataSetChanged"})
/* loaded from: classes15.dex */
public final class c extends RecyclerView.Adapter<d> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    static final /* synthetic */ KProperty<Object>[] I;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.login.account.a> accountList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private e listener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String uinFromWx;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isWxBind;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty isDeleteMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/adapter/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.adapter.c$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends ObservableProperty<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f241860b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, c cVar) {
            super(obj);
            this.f241860b = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj, (Object) cVar);
            }
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(@NotNull KProperty<?> property, Boolean oldValue, Boolean newValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, property, oldValue, newValue);
                return;
            }
            Intrinsics.checkNotNullParameter(property, "property");
            newValue.booleanValue();
            oldValue.booleanValue();
            this.f241860b.notifyDataSetChanged();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19585);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            I = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(c.class, "isDeleteMode", "isDeleteMode()Z", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull Context context, @NotNull List<com.tencent.mobileqq.login.account.a> accountList, @Nullable e eVar, @Nullable String str, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountList, "accountList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, accountList, eVar, str, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        this.accountList = accountList;
        this.listener = eVar;
        this.uinFromWx = str;
        this.isWxBind = z16;
        Delegates delegates = Delegates.INSTANCE;
        this.isDeleteMode = new b(Boolean.FALSE, this);
    }

    private final void l0(QQProAvatarView avatarIv, com.tencent.mobileqq.login.account.a account) {
        com.tencent.mobileqq.login.account.d.i(com.tencent.mobileqq.login.account.d.f241848a, avatarIv, account.f(), 200, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(c this$0, com.tencent.mobileqq.login.account.a account, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        e eVar = this$0.listener;
        if (eVar != null) {
            eVar.W2(account);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(c this$0, com.tencent.mobileqq.login.account.a account, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        e eVar = this$0.listener;
        if (eVar != null) {
            eVar.z7(account);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.accountList.size();
    }

    public final boolean k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return ((Boolean) this.isDeleteMode.getValue(this, I[0])).booleanValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        final com.tencent.mobileqq.login.account.a aVar = this.accountList.get(position);
        if (position == 0 && TextUtils.equals(this.uinFromWx, aVar.f())) {
            holder.q().setText(R.string.f200184rf);
        } else if (this.isWxBind) {
            holder.q().setText(R.string.f200084r6);
        } else {
            holder.q().setText(R.string.f199904qo);
        }
        l0(holder.m(), aVar);
        holder.r().setText(aVar.d());
        String c16 = aVar.c();
        if (!TextUtils.isEmpty(c16)) {
            holder.l().setText(c16);
        } else {
            holder.l().setText(aVar.f());
        }
        if (k0()) {
            holder.p().setOnClickListener(null);
            holder.p().setClickable(false);
            holder.o().setVisibility(0);
            holder.q().setVisibility(8);
            holder.o().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.n0(c.this, aVar, view);
                }
            });
            return;
        }
        holder.p().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.o0(c.this, aVar, view);
            }
        });
        holder.o().setVisibility(8);
        holder.q().setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (d) iPatchRedirector.redirect((short) 15, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(this.context).inflate(R.layout.gyb, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new d(itemView);
    }
}
