package com.tencent.mobileqq.guild.setting.member.view.topcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.h;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0004,-./B\u001d\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fR\u0018\u0010\u001a\u001a\u00060\u0017R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout;", "", "childCount", "drawingPosition", "getChildDrawingOrder", "", "guildID", "", "setGuildId", "", "list", "", "forceAllUpdate", "I", "size", "setAvatarSize", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "avatarBorderDark", "setAvatarBorderDark", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView$a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView$a;", "mAdapter", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", ExifInterface.LATITUDE_SOUTH, "Z", "T", "H", "()I", "setLoadType", "(I)V", "loadType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "U", "a", "b", "LoadType", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberLoopView extends GuildVoicingAvatarLayout {
    private static final int V = ViewUtils.dpToPx(7.0f);
    private static final int W = ViewUtils.dpToPx(1.0f);

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final a mAdapter;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String guildID;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean avatarBorderDark;

    /* renamed from: T, reason: from kotlin metadata */
    private int loadType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView$LoadType;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface LoadType {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f234752a;
        public static final int LOAD_BY_META = 2;
        public static final int LOAD_BY_URL = 1;
        public static final int LOAD_QQ_TROOP = 3;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView$LoadType$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.member.view.topcard.GuildMemberLoopView$LoadType$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f234752a = new Companion();

            Companion() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002R\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView$a;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout$c;", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView$c;", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "viewHolder", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "(Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class a extends GuildVoicingAvatarLayout.c<c, String> {
        public a() {
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.c
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(@NotNull c viewHolder, @NotNull String data) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(data, "data");
            viewHolder.b(data);
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.c
        @NotNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public c l(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ezs, parent, false);
            GuildMemberLoopView guildMemberLoopView = GuildMemberLoopView.this;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new c(guildMemberLoopView, view, GuildMemberLoopView.this.guildID, ((GuildVoicingAvatarLayout) GuildMemberLoopView.this).C, GuildMemberLoopView.this.avatarBorderDark);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001c\u0010\"\u001a\n \u001c*\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView$c;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout$e;", "", "e", "Landroid/view/View;", "view", "root", "d", "", "data", "b", "Ljava/lang/String;", "getGuildID", "()Ljava/lang/String;", "guildID", "", "c", "I", "()I", "setAvatarSize", "(I)V", "avatarSize", "", "Z", "getDark", "()Z", MiniAppConst.MENU_STYLE_DARK, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "qqTroopAvatar", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "f", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mAvatar", "<init>", "(Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView;Landroid/view/View;Ljava/lang/String;IZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class c extends GuildVoicingAvatarLayout.e {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildID;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int avatarSize;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean dark;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final QQProAvatarView qqTroopAvatar;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final GuildUserAvatarView mAvatar;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ GuildMemberLoopView f234759g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull GuildMemberLoopView guildMemberLoopView, @NotNull View root, String guildID, int i3, boolean z16) {
            super(root);
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(guildID, "guildID");
            this.f234759g = guildMemberLoopView;
            this.guildID = guildID;
            this.avatarSize = i3;
            this.dark = z16;
            QQProAvatarView qQProAvatarView = (QQProAvatarView) root.findViewById(R.id.f627631p);
            Intrinsics.checkNotNullExpressionValue(qQProAvatarView, "this");
            d(qQProAvatarView, root);
            this.qqTroopAvatar = qQProAvatarView;
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) root.findViewById(R.id.a2o);
            Intrinsics.checkNotNullExpressionValue(guildUserAvatarView, "this");
            d(guildUserAvatarView, root);
            this.mAvatar = guildUserAvatarView;
            root.getLayoutParams().width = this.avatarSize;
            root.getLayoutParams().height = this.avatarSize;
            e();
        }

        private final void e() {
            int i3 = this.avatarSize;
            if (i3 < 70) {
                this.mAvatar.setAvatarSize(4);
            } else if (i3 < 120) {
                this.mAvatar.setAvatarSize(3);
            } else if (i3 < 210) {
                this.mAvatar.setAvatarSize(0);
            }
        }

        public final void b(@NotNull String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.avatarSize != ((GuildVoicingAvatarLayout) this.f234759g).C) {
                Logger logger = Logger.f235387a;
                GuildMemberLoopView guildMemberLoopView = this.f234759g;
                logger.d().d("GuildMemberLoopViewGuildMemberLoopView", 1, "avatarSize changed, old: " + getAvatarSize() + ", new: " + ((GuildVoicingAvatarLayout) guildMemberLoopView).C);
                this.avatarSize = ((GuildVoicingAvatarLayout) this.f234759g).C;
                ViewGroup.LayoutParams layoutParams = this.mAvatar.getLayoutParams();
                int i3 = this.avatarSize;
                View rootView = a();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                layoutParams.width = i3 - h.a(rootView);
                ViewGroup.LayoutParams layoutParams2 = this.mAvatar.getLayoutParams();
                int i16 = this.avatarSize;
                View rootView2 = a();
                Intrinsics.checkNotNullExpressionValue(rootView2, "rootView");
                layoutParams2.height = i16 - h.b(rootView2);
                GuildUserAvatarView guildUserAvatarView = this.mAvatar;
                guildUserAvatarView.setLayoutParams(guildUserAvatarView.getLayoutParams());
                a().getLayoutParams().width = this.avatarSize;
                a().getLayoutParams().height = this.avatarSize;
                e();
            }
            this.qqTroopAvatar.setVisibility(8);
            this.mAvatar.setVisibility(0);
            if (this.f234759g.getLoadType() == 2) {
                this.mAvatar.setAvatarMeta(this.guildID, "0", data);
                return;
            }
            if (this.f234759g.getLoadType() == 1) {
                GuildUserAvatarView mAvatar = this.mAvatar;
                Intrinsics.checkNotNullExpressionValue(mAvatar, "mAvatar");
                v.i(data, mAvatar);
            } else if (this.f234759g.getLoadType() == 3) {
                this.qqTroopAvatar.setVisibility(0);
                this.mAvatar.setVisibility(8);
                this.qqTroopAvatar.x(4, data, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(this.avatarSize).a());
            }
        }

        /* renamed from: c, reason: from getter */
        public final int getAvatarSize() {
            return this.avatarSize;
        }

        public final void d(@NotNull View view, @NotNull View root) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(root, "root");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = this.avatarSize - h.a(root);
            layoutParams.height = this.avatarSize - h.b(root);
            view.setLayoutParams(layoutParams);
            if (this.dark) {
                root.setBackground(root.getResources().getDrawable(R.drawable.guild_member_loop_bg_dark));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMemberLoopView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void J(GuildMemberLoopView guildMemberLoopView, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildMemberLoopView.I(list, z16);
    }

    /* renamed from: H, reason: from getter */
    public final int getLoadType() {
        return this.loadType;
    }

    public final void I(@NotNull List<String> list, boolean forceAllUpdate) {
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            setVisibility(8);
            y(false);
            return;
        }
        setVisibility(0);
        if (forceAllUpdate && this.L) {
            y(false);
            a aVar = this.mAdapter;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            aVar.j(emptyList2, list);
            y(true);
            return;
        }
        a aVar2 = this.mAdapter;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        aVar2.j(emptyList, list);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int childCount, int drawingPosition) {
        return (childCount - 1) - drawingPosition;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        boolean z16;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (this.L) {
            if (visibility == 0 && isShown()) {
                z16 = true;
            } else {
                z16 = false;
            }
            y(z16);
        }
    }

    public final void setAvatarBorderDark(boolean avatarBorderDark) {
        this.avatarBorderDark = avatarBorderDark;
    }

    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout
    public void setAvatarSize(int size) {
        Logger.f235387a.d().i("GuildMemberLoopViewGuildMemberLoopView", 1, "setAvatarSize(" + size + ")");
        super.setAvatarSize(size + (W * 2));
    }

    public final void setGuildId(@NotNull String guildID) {
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        this.guildID = guildID;
    }

    public final void setLoadType(int i3) {
        this.loadType = i3;
    }

    public /* synthetic */ GuildMemberLoopView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMemberLoopView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = new a();
        this.mAdapter = aVar;
        this.guildID = "";
        this.loadType = 2;
        this.C += W * 2;
        setAdapter(aVar);
        setMaxAvatarCount(3);
        setLoopDelayMs(500);
        setLoopAnimationDuration(1000);
        setHorizontalSpacing(-V);
        setLoopWhenAudiencePositionEqualsAudienceCount(true);
        setChildrenDrawingOrderEnabled(true);
        setCurrentScene("GuildMemberLoopView");
    }
}
