package com.tencent.mobileqq.profilesetting;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilesetting.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006+,-./0B\u0019\u0012\u0006\u0010'\u001a\u00020\u0016\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u001aj\b\u0012\u0004\u0012\u00020\u0013`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "position", "", "m0", "s0", "q0", "o0", "Landroid/view/ViewGroup;", "viewGroup", "type", "onCreateViewHolder", "onBindViewHolder", "getItemCount", "getItemViewType", "", "Lcom/tencent/mobileqq/profilesetting/u;", "data", "setData", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "mContext", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mData", "Landroid/view/LayoutInflater;", "D", "Landroid/view/LayoutInflater;", "mInflater", "Lcom/tencent/mobileqq/profilesetting/f$a;", "E", "Lcom/tencent/mobileqq/profilesetting/f$a;", "mPrivacySettingClickListener", "context", "privacySettingClickListener", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/profilesetting/f$a;)V", "a", "b", "c", "d", "e", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<u> mData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LayoutInflater mInflater;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final a mPrivacySettingClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/f$a;", "", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/profilesetting/u;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(@NotNull View view, @Nullable u item);

        void b(@NotNull View view, @NotNull u item);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/f$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "E", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "l", "()Lcom/tencent/mobileqq/widget/FormSimpleItem;", "setProfileBaseSettingItem", "(Lcom/tencent/mobileqq/widget/FormSimpleItem;)V", "profileBaseSettingItem", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private FormSimpleItem profileBaseSettingItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.xwn);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSimpleItem");
            this.profileBaseSettingItem = (FormSimpleItem) findViewById;
        }

        @NotNull
        public final FormSimpleItem l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FormSimpleItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.profileBaseSettingItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/f$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/f$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "E", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "l", "()Lcom/tencent/mobileqq/widget/FormSwitchItem;", "setProfileOtherSettingItem", "(Lcom/tencent/mobileqq/widget/FormSwitchItem;)V", "profileOtherSettingItem", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private FormSwitchItem profileOtherSettingItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.f28200ia);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
            this.profileOtherSettingItem = (FormSwitchItem) findViewById;
        }

        @NotNull
        public final FormSwitchItem l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FormSwitchItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.profileOtherSettingItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/f$e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "E", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "l", "()Lcom/tencent/mobileqq/widget/FormSwitchItem;", "setProfileExtendFriendSettingItem", "(Lcom/tencent/mobileqq/widget/FormSwitchItem;)V", "profileExtendFriendSettingItem", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setProfileExtendFriendTv", "(Landroid/widget/TextView;)V", "profileExtendFriendTv", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private FormSwitchItem profileExtendFriendSettingItem;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView profileExtendFriendTv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.bzz);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
            this.profileExtendFriendSettingItem = (FormSwitchItem) findViewById;
            View findViewById2 = itemView.findViewById(R.id.uym);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.profileExtendFriendTv = (TextView) findViewById2;
        }

        @NotNull
        public final FormSwitchItem l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FormSwitchItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.profileExtendFriendSettingItem;
        }

        @NotNull
        public final TextView m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.profileExtendFriendTv;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/f$f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "setProfileTitleItem", "(Landroid/widget/TextView;)V", "profileTitleItem", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.profilesetting.f$f, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8272f extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private TextView profileTitleItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8272f(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.f28400iu);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.profileTitleItem = (TextView) findViewById;
        }

        @NotNull
        public final TextView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.profileTitleItem;
        }
    }

    public f(@NotNull Context context, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        this.mContext = context;
        this.mData = new ArrayList<>();
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.mInflater = from;
        this.mPrivacySettingClickListener = aVar;
    }

    private final void m0(RecyclerView.ViewHolder viewHolder, final int position) {
        Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.ProfileBaseHolder");
        b bVar = (b) viewHolder;
        int j3 = this.mData.get(position).j();
        if (j3 != -1) {
            bVar.l().setLeftText(this.mContext.getString(j3));
        }
        int a16 = this.mData.get(position).a();
        if (a16 != 0) {
            if (a16 != 1) {
                if (a16 != 2) {
                    bVar.l().setRightText(this.mContext.getString(R.string.f175802zj));
                } else {
                    bVar.l().setRightText(this.mContext.getString(R.string.f17602305));
                }
            } else {
                bVar.l().setRightText(this.mContext.getString(R.string.f17601304));
            }
        } else {
            bVar.l().setRightText(this.mContext.getString(R.string.f175802zj));
        }
        if (this.mData.get(position).d() != -1) {
            bVar.l().setBgType(this.mData.get(position).d());
        }
        final a aVar = this.mPrivacySettingClickListener;
        if (aVar != null) {
            bVar.l().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.n0(f.a.this, this, position, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(a listener, f this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        listener.a(view, this$0.mData.get(i3));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0(RecyclerView.ViewHolder viewHolder, final int position) {
        Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.ProfileBaseHolder");
        b bVar = (b) viewHolder;
        int j3 = this.mData.get(position).j();
        if (j3 != -1) {
            bVar.l().setLeftText(this.mContext.getString(j3));
        }
        int e16 = this.mData.get(position).e();
        if (e16 != 1) {
            if (e16 != 2) {
                if (e16 != 3) {
                    bVar.l().setRightText(this.mContext.getString(R.string.f1366504q));
                } else {
                    bVar.l().setRightText(this.mContext.getString(R.string.f1365904k));
                }
            } else {
                bVar.l().setRightText(this.mContext.getString(R.string.f1366604r));
            }
        } else {
            bVar.l().setRightText(this.mContext.getString(R.string.f1366504q));
        }
        if (this.mData.get(position).d() != -1) {
            bVar.l().setBgType(this.mData.get(position).d());
        }
        final a aVar = this.mPrivacySettingClickListener;
        if (aVar != null) {
            bVar.l().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.p0(f.a.this, this, position, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(a listener, f this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        listener.a(view, this$0.mData.get(i3));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q0(RecyclerView.ViewHolder viewHolder, final int position) {
        Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.ProfileOtherWithSecondHolder");
        e eVar = (e) viewHolder;
        int j3 = this.mData.get(position).j();
        int g16 = this.mData.get(position).g();
        if (j3 != -1 && g16 != -1) {
            eVar.l().setText(this.mContext.getString(j3));
            eVar.m().setText(this.mContext.getString(g16));
        }
        eVar.l().setChecked(this.mData.get(position).f());
        if (this.mData.get(position).d() != -1) {
            eVar.l().setBgType(this.mData.get(position).d());
        }
        final a aVar = this.mPrivacySettingClickListener;
        if (aVar != null) {
            eVar.l().getSwitch().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.r0(f.a.this, this, position, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(a listener, f this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        u uVar = this$0.mData.get(i3);
        Intrinsics.checkNotNullExpressionValue(uVar, "mData[position]");
        listener.b(view, uVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s0(RecyclerView.ViewHolder viewHolder, final int position) {
        Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.ProfileOtherHolder");
        d dVar = (d) viewHolder;
        int j3 = this.mData.get(position).j();
        if (j3 != -1) {
            dVar.l().setText(this.mContext.getString(j3));
        }
        if (!TextUtils.isEmpty(this.mData.get(position).i())) {
            dVar.l().setText(this.mData.get(position).i());
        }
        dVar.l().setChecked(this.mData.get(position).f());
        if (this.mData.get(position).d() != -1) {
            dVar.l().setBgType(this.mData.get(position).d());
        }
        final a aVar = this.mPrivacySettingClickListener;
        if (aVar != null) {
            dVar.l().getSwitch().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilesetting.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.t0(f.a.this, this, position, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(a listener, f this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        u uVar = this$0.mData.get(i3);
        Intrinsics.checkNotNullExpressionValue(uVar, "mData[position]");
        listener.b(view, uVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, position)).intValue();
        }
        return this.mData.get(position).k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int itemViewType = getItemViewType(position);
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                if (itemViewType != 3) {
                    if (itemViewType != 5) {
                        if (itemViewType == 6) {
                            o0(viewHolder, position);
                            return;
                        }
                        return;
                    } else {
                        C8272f c8272f = (C8272f) viewHolder;
                        int j3 = this.mData.get(position).j();
                        if (j3 != -1) {
                            c8272f.l().setText(this.mContext.getString(j3));
                            return;
                        }
                        return;
                    }
                }
                q0(viewHolder, position);
                return;
            }
            s0(viewHolder, position);
            return;
        }
        m0(viewHolder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, type);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        switch (type) {
            case 1:
            case 6:
                View inflate = this.mInflater.inflate(R.layout.h0j, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "mInflater.inflate(R.layo\u2026e_item, viewGroup, false)");
                return new b(inflate);
            case 2:
                View inflate2 = this.mInflater.inflate(R.layout.h0l, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "mInflater.inflate(R.layo\u2026e_item, viewGroup, false)");
                return new d(inflate2);
            case 3:
                View inflate3 = this.mInflater.inflate(R.layout.h0m, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "mInflater.inflate(R.layo\u2026d_item, viewGroup, false)");
                return new e(inflate3);
            case 4:
                View inflate4 = this.mInflater.inflate(R.layout.h0k, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate4, "mInflater.inflate(R.layo\u2026k_item, viewGroup, false)");
                return new c(inflate4);
            case 5:
                View inflate5 = this.mInflater.inflate(R.layout.h0n, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate5, "mInflater.inflate(R.layo\u2026e_item, viewGroup, false)");
                return new C8272f(inflate5);
            default:
                View inflate6 = this.mInflater.inflate(R.layout.h0k, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate6, "mInflater.inflate(R.layo\u2026k_item, viewGroup, false)");
                return new c(inflate6);
        }
    }

    public final void setData(@Nullable List<u> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) data);
            return;
        }
        this.mData.clear();
        if (data != null) {
            for (u uVar : data) {
                if (uVar.l()) {
                    this.mData.add(uVar);
                }
            }
        }
        notifyDataSetChanged();
    }
}
