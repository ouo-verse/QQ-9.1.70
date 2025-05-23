package com.tencent.mobileqq.register.avatar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.bean.ZPlanOutboundAvatarInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u001f\b\u0016\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/register/avatar/j;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "p1", "onCreateViewHolder", "getItemCount", "viewHolder", "position", "", "onBindViewHolder", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "list", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mZplanAvatarList", "Lcom/tencent/mobileqq/register/avatar/j$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/register/avatar/j$b;", "mSelectorListener", "<init>", "()V", "listener", "(Ljava/util/List;Lcom/tencent/mobileqq/register/avatar/j$b;)V", "D", "a", "b", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private b mSelectorListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<ZPlanAvatarInfo> mZplanAvatarList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/j$a;", "", "", "BORDER_WIDTH", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.avatar.j$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/j$b;", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "avatarInfo", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NotNull ZPlanAvatarInfo avatarInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/j$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "E", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "l", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR, "(Lcom/tencent/mobileqq/proavatar/QQProAvatarView;)V", "avatar", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private QQProAvatarView avatar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.f126127nx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.zplan_avatar_view)");
            QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById;
            this.avatar = qQProAvatarView;
            qQProAvatarView.setDrawAreaMode(1);
        }

        @NotNull
        public final QQProAvatarView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQProAvatarView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.avatar;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26556);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(int i3, j this$0, ZPlanAvatarInfo avatarInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(avatarInfo, "$avatarInfo");
        QLog.d("RegisterAvatarZplanSettingAdapter", 2, "onBindViewHolder onClick zplan avatar position: " + i3);
        b bVar = this$0.mSelectorListener;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectorListener");
            bVar = null;
        }
        bVar.a(avatarInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        List<ZPlanAvatarInfo> list = this.mZplanAvatarList;
        List<ZPlanAvatarInfo> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZplanAvatarList");
            list = null;
        }
        if (!list.isEmpty()) {
            List<ZPlanAvatarInfo> list3 = this.mZplanAvatarList;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZplanAvatarList");
            } else {
                list2 = list3;
            }
            return list2.size();
        }
        return 0;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void k0(@NotNull List<ZPlanAvatarInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        this.mZplanAvatarList = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, final int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (!(viewHolder instanceof c)) {
            return;
        }
        List<ZPlanAvatarInfo> list = this.mZplanAvatarList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZplanAvatarList");
            list = null;
        }
        if (position >= list.size()) {
            QLog.e("RegisterAvatarZplanSettingAdapter", 1, "onBindViewHolder zplanAvatarList out of index");
            return;
        }
        Context context = viewHolder.itemView.getContext();
        if (context != null) {
            FontSettingManager.resetViewSize2Normal(context, viewHolder.itemView);
        }
        List<ZPlanAvatarInfo> list2 = this.mZplanAvatarList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZplanAvatarList");
            list2 = null;
        }
        final ZPlanAvatarInfo zPlanAvatarInfo = list2.get(position);
        if (viewHolder.itemView.getResources() != null) {
            c cVar = (c) viewHolder;
            cVar.l().y(new ZPlanOutboundAvatarInfo(zPlanAvatarInfo.a(), zPlanAvatarInfo.c(), zPlanAvatarInfo.f(), 0, 0, 24, null));
            QQProAvatarView.setEnableFrame$default(cVar.l(), ViewUtils.dip2px(4.0f), 0, 2, null);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.register.avatar.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.j0(position, this, zPlanAvatarInfo, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, p16);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hmz, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new c(view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(@NotNull List<ZPlanAvatarInfo> list, @NotNull b listener) {
        this();
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) listener);
        } else {
            this.mZplanAvatarList = list;
            this.mSelectorListener = listener;
        }
    }
}
