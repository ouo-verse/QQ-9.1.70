package com.tencent.mobileqq.zplan.aigc.view.component;

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
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.sqshow.zootopia.aigc.view.component.GuildUserAvatarView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0003,-.B\u001d\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fR\u0018\u0010\u001a\u001a\u00060\u0017R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout;", "", "childCount", "drawingPosition", "getChildDrawingOrder", "", "guildID", "", "setGuildId", "", "list", "", "forceAllUpdate", "I", "size", "setAvatarSize", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "avatarBorderDark", "setAvatarBorderDark", "Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView$a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView$a;", "mAdapter", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", ExifInterface.LATITUDE_SOUTH, "Z", "T", "H", "()I", "setLoadType", "(I)V", "loadType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "U", "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GuildMemberLoopView extends GuildVoicingAvatarLayout {
    private static final int V = ViewUtils.dpToPx(7.0f);
    private static final int W = ViewUtils.dpToPx(1.0f);

    /* renamed from: Q */
    private final a mAdapter;

    /* renamed from: R */
    private String guildID;

    /* renamed from: S */
    private boolean avatarBorderDark;

    /* renamed from: T, reason: from kotlin metadata */
    private int loadType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002R\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView$a;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout$c;", "Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView$c;", "Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "viewHolder", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "(Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class a extends GuildVoicingAvatarLayout.c<c, String> {
        public a() {
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.c
        /* renamed from: m */
        public void k(c viewHolder, String data) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(data, "data");
            viewHolder.b(data);
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.c
        /* renamed from: n */
        public c l(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dcv, parent, false);
            GuildMemberLoopView guildMemberLoopView = GuildMemberLoopView.this;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new c(guildMemberLoopView, view, GuildMemberLoopView.this.guildID, ((GuildVoicingAvatarLayout) GuildMemberLoopView.this).C, GuildMemberLoopView.this.avatarBorderDark);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView$c;", "Lcom/tencent/mobileqq/guild/component/animator/GuildVoicingAvatarLayout$e;", "", "avatarMeta", "", "b", "Ljava/lang/String;", "getGuildID", "()Ljava/lang/String;", "guildID", "", "c", "I", "getAvatarSize", "()I", "setAvatarSize", "(I)V", "avatarSize", "", "d", "Z", "getDark", "()Z", MiniAppConst.MENU_STYLE_DARK, "Lcom/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView;", "kotlin.jvm.PlatformType", "e", "Lcom/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView;", "mAvatar", "Landroid/view/View;", "root", "<init>", "(Lcom/tencent/mobileqq/zplan/aigc/view/component/GuildMemberLoopView;Landroid/view/View;Ljava/lang/String;IZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class c extends GuildVoicingAvatarLayout.e {

        /* renamed from: b, reason: from kotlin metadata */
        private final String guildID;

        /* renamed from: c, reason: from kotlin metadata */
        private int avatarSize;

        /* renamed from: d, reason: from kotlin metadata */
        private final boolean com.tencent.qqmini.sdk.core.MiniAppConst.MENU_STYLE_DARK java.lang.String;

        /* renamed from: e, reason: from kotlin metadata */
        private final GuildUserAvatarView mAvatar;

        /* renamed from: f */
        final /* synthetic */ GuildMemberLoopView f330758f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GuildMemberLoopView guildMemberLoopView, View root, String guildID, int i3, boolean z16) {
            super(root);
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(guildID, "guildID");
            this.f330758f = guildMemberLoopView;
            this.guildID = guildID;
            this.avatarSize = i3;
            this.com.tencent.qqmini.sdk.core.MiniAppConst.MENU_STYLE_DARK java.lang.String = z16;
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) root.findViewById(R.id.pax);
            ViewGroup.LayoutParams layoutParams = guildUserAvatarView.getLayoutParams();
            layoutParams.width = this.avatarSize - h.a(root);
            layoutParams.height = this.avatarSize - h.b(root);
            guildUserAvatarView.setLayoutParams(layoutParams);
            if (z16) {
                root.setBackground(root.getResources().getDrawable(R.drawable.i3f));
            }
            this.mAvatar = guildUserAvatarView;
            guildUserAvatarView.setLoadType(guildMemberLoopView.getLoadType());
            root.getLayoutParams().width = this.avatarSize;
            root.getLayoutParams().height = this.avatarSize;
        }

        public final void b(String avatarMeta) {
            Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
            if (this.avatarSize != ((GuildVoicingAvatarLayout) this.f330758f).C) {
                this.avatarSize = ((GuildVoicingAvatarLayout) this.f330758f).C;
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
            }
            this.mAvatar.setAvatarMeta(this.guildID, "0", avatarMeta);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildMemberLoopView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: H, reason: from getter */
    public final int getLoadType() {
        return this.loadType;
    }

    public final void I(List<String> list, boolean forceAllUpdate) {
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            setVisibility(8);
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
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (this.L) {
            y(visibility == 0 && isShown());
        }
    }

    public final void setAvatarBorderDark(boolean avatarBorderDark) {
        this.avatarBorderDark = avatarBorderDark;
    }

    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout
    public void setAvatarSize(int size) {
        super.setAvatarSize(size + (W * 2));
    }

    public final void setGuildId(String guildID) {
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
    public GuildMemberLoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = new a();
        this.mAdapter = aVar;
        this.guildID = "";
        this.loadType = 1;
        int i3 = this.C + (W * 2);
        this.C = i3;
        QLog.d("GuildMemberLoopView", 1, "logsize:" + i3);
        setAdapter(aVar);
        setMaxAvatarCount(3);
        setLoopDelayMs(500);
        setLoopAnimationDuration(1000);
        setHorizontalSpacing(-V);
        setLoopWhenAudiencePositionEqualsAudienceCount(true);
        setChildrenDrawingOrderEnabled(true);
        setCurrentScene("GuildMemberLoopView");
    }

    public static /* synthetic */ void J(GuildMemberLoopView guildMemberLoopView, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildMemberLoopView.I(list, z16);
    }
}
