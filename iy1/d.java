package iy1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.repository.h;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.rolegroup.view.singlerevokerole.DialogRoleLabelPanel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u001f\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010#\u00a8\u0006/"}, d2 = {"Liy1/d;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "", "initUI", "P", "U", "", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "roleList", "W", "Landroid/view/View$OnClickListener;", "listener", BdhLogUtil.LogTag.Tag_Req, "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTinyId", "()Ljava/lang/String;", "tinyId", "D", "getGuildId", "guildId", "", "E", "Ljava/util/List;", "Lcom/tencent/mobileqq/guild/rolegroup/view/singlerevokerole/DialogRoleLabelPanel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/rolegroup/view/singlerevokerole/DialogRoleLabelPanel;", "labelPanel", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "G", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarImage", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "nickNameText", "I", "cancelBtn", "J", "addBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends QQCustomDialog {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String tinyId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<RoleLabelData> roleList;

    /* renamed from: F, reason: from kotlin metadata */
    private DialogRoleLabelPanel labelPanel;

    /* renamed from: G, reason: from kotlin metadata */
    private GuildUserAvatarView avatarImage;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView nickNameText;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView cancelBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView addBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Liy1/d$a;", "", "Landroid/content/Context;", "context", "", "tinyId", "guildId", "Landroid/view/View$OnClickListener;", "confirmListener", "Liy1/d;", "b", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "list", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: iy1.d$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"iy1/d$a$a", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: iy1.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C10554a implements h<List<? extends RoleGroupModel>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f408981a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View.OnClickListener f408982b;

            C10554a(d dVar, View.OnClickListener onClickListener) {
                this.f408981a = dVar;
                this.f408982b = onClickListener;
            }

            @Override // com.tencent.mobileqq.guild.base.repository.h
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull ri1.a error, @Nullable List<RoleGroupModel> result) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (error.d() && result != null) {
                    d dVar = this.f408981a;
                    Companion companion = d.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : result) {
                        if (!((RoleGroupModel) obj).getIsLevelRole()) {
                            arrayList.add(obj);
                        }
                    }
                    dVar.W(companion.a(arrayList));
                    this.f408981a.R(this.f408982b);
                    this.f408981a.show();
                    return;
                }
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.rg.SingleRevokeRoleDialog", 2, " fetchRoles error");
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<RoleLabelData> a(@NotNull List<RoleGroupModel> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ArrayList arrayList = new ArrayList();
            for (RoleGroupModel roleGroupModel : list) {
                arrayList.add(new RoleLabelData(roleGroupModel.getId(), roleGroupModel.getColor(), roleGroupModel.getName(), 0, null, null, false, false, 0, 504, null));
            }
            return arrayList;
        }

        @JvmStatic
        @NotNull
        public final d b(@NotNull Context context, @NotNull String tinyId, @NotNull String guildId, @NotNull View.OnClickListener confirmListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(confirmListener, "confirmListener");
            d dVar = new d(context, tinyId, guildId);
            r.p().n(GuildTarget.INSTANCE.b(guildId), tinyId, new C10554a(dVar, confirmListener));
            return dVar;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context, @NotNull String tinyId, @NotNull String guildId) {
        super(context, R.style.qZoneInputDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.tinyId = tinyId;
        this.guildId = guildId;
        this.roleList = new ArrayList();
        initUI();
        P();
    }

    private final void P() {
        DialogRoleLabelPanel dialogRoleLabelPanel = this.labelPanel;
        GuildUserAvatarView guildUserAvatarView = null;
        if (dialogRoleLabelPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelPanel");
            dialogRoleLabelPanel = null;
        }
        dialogRoleLabelPanel.f(this.roleList);
        U();
        GuildUserAvatarView guildUserAvatarView2 = this.avatarImage;
        if (guildUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImage");
        } else {
            guildUserAvatarView = guildUserAvatarView2;
        }
        guildUserAvatarView.setAvatarTinyId(this.guildId, this.tinyId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(View.OnClickListener listener, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        listener.onClick(view);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void U() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        String guildUserDisplayName = ((IGPSService) S0).getGuildUserDisplayName(this.guildId, this.tinyId);
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "IGPSService::class.get()\u2026playName(guildId, tinyId)");
        TextView textView = this.nickNameText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameText");
            textView = null;
        }
        textView.setText(guildUserDisplayName);
    }

    @JvmStatic
    @NotNull
    public static final d X(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull View.OnClickListener onClickListener) {
        return INSTANCE.b(context, str, str2, onClickListener);
    }

    private final void initUI() {
        TextView textView = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168186f93, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.a2o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.avatar)");
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) findViewById;
        this.avatarImage = guildUserAvatarView;
        if (guildUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImage");
            guildUserAvatarView = null;
        }
        guildUserAvatarView.setLogTag("Guild.rg.SingleRevokeRoleDialog");
        View findViewById2 = inflate.findViewById(R.id.f9d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.nick_name)");
        this.nickNameText = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.cancel)");
        this.cancelBtn = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f163995gd);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.add)");
        this.addBtn = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.ych);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.label_panel)");
        this.labelPanel = (DialogRoleLabelPanel) findViewById5;
        TextView textView2 = this.cancelBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: iy1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.Q(d.this, view);
            }
        });
        setContentView(inflate);
    }

    public final void R(@NotNull final View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextView textView = this.addBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: iy1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.S(listener, this, view);
            }
        });
    }

    public final void W(@NotNull List<RoleLabelData> roleList) {
        Intrinsics.checkNotNullParameter(roleList, "roleList");
        this.roleList.addAll(roleList);
        DialogRoleLabelPanel dialogRoleLabelPanel = this.labelPanel;
        if (dialogRoleLabelPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelPanel");
            dialogRoleLabelPanel = null;
        }
        dialogRoleLabelPanel.f(roleList);
    }
}
