package com.tencent.icgame.game.userinfo.impl.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.view.widget.InnerTagView;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAchievement;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import fy0.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly0.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@B\u001b\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u00a2\u0006\u0004\b?\u0010CB#\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\u0006\u0010D\u001a\u00020\u0014\u00a2\u0006\u0004\b?\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\u0005H\u0014J\b\u0010\u0018\u001a\u00020\u0005H\u0014J\u0016\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0014J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\u0012\u0010%\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010)R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010&R\u0016\u0010\u001b\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010-R\u0014\u0010.\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010-R\u0014\u0010:\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b5\u00109R\u0014\u0010<\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b;\u00109\u00a8\u0006F"}, d2 = {"Lcom/tencent/icgame/game/userinfo/impl/view/TimUserGameInfoViewImpl;", "Landroid/widget/LinearLayout;", "Lfy0/c;", "", "k", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "l", "Ley0/c;", "roleInfo", "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "url", "Landroid/graphics/drawable/Drawable;", "g", "o", "", "color", "setRoleTextColor", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", VirtualAppProxy.KEY_GAME_ID, "setUserId", h.F, "c", "b", "a", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "allUserInfoModel", "f", "d", "e", "Ljava/lang/String;", "TAG", "Lcom/tencent/icgame/game/userinfo/impl/view/b;", "Lcom/tencent/icgame/game/userinfo/impl/view/b;", "userInfoViewWrapper", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "subUin", "I", "roleIconSize", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "roleNameText", "", "D", UserInfo.SEX_FEMALE, "roleNameTextSizeDp", "E", "roleNameTextColor", "Z", "differentBySender", "G", "showRoleTagList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class TimUserGameInfoViewImpl extends LinearLayout implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView roleNameText;

    /* renamed from: D, reason: from kotlin metadata */
    private float roleNameTextSizeDp;

    /* renamed from: E, reason: from kotlin metadata */
    private int roleNameTextColor;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean differentBySender;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean showRoleTagList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b userInfoViewWrapper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId qqUserId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String subUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int gameId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int roleIconSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimUserGameInfoViewImpl(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ICGameTimUserGameInfoViewImpl";
        this.roleIconSize = ViewUtils.dpToPx(10.0f);
        this.roleNameTextSizeDp = 10.0f;
        this.roleNameTextColor = -16777216;
        i();
    }

    private final Drawable g(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int i3 = this.roleIconSize;
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i3;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        try {
            return ((bv0.a) qx0.a.b(bv0.a.class)).m(url, obtain);
        } catch (Exception e16) {
            g.e(this.TAG, "acquireRoleDrawable error" + this.subUin, e16);
            return null;
        }
    }

    private final void i() {
        setOrientation(0);
        this.roleNameText = new TextView(getContext());
        q();
        this.userInfoViewWrapper = new b(this);
    }

    private final boolean j() {
        return n.f415773a.h(this.qqUserId, this.gameId);
    }

    private final boolean k() {
        boolean z16;
        PBUInt64Field pBUInt64Field;
        boolean z17;
        PBUInt64Field pBUInt64Field2;
        CommonOuterClass$QQUserId selfUid = ((mx0.a) qx0.a.b(mx0.a.class)).E();
        Intrinsics.checkNotNullExpressionValue(selfUid, "selfUid");
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.qqUserId;
        if (selfUid.uid.get() != 0) {
            if (commonOuterClass$QQUserId != null && (pBUInt64Field2 = commonOuterClass$QQUserId.uid) != null && selfUid.uid.get() == pBUInt64Field2.get()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        if (selfUid.yes_uid.get() != 0) {
            if (commonOuterClass$QQUserId != null && (pBUInt64Field = commonOuterClass$QQUserId.yes_uid) != null && selfUid.yes_uid.get() == pBUInt64Field.get()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final void l() {
        removeAllViews();
    }

    private final void m(ey0.c roleInfo) {
        Drawable g16 = g(roleInfo.c());
        if (g16 != null) {
            int i3 = this.roleIconSize;
            g16.setBounds(0, 0, i3, i3);
        }
        if (this.differentBySender && k()) {
            TextView textView = this.roleNameText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleNameText");
                textView = null;
            }
            textView.setCompoundDrawables(g16, null, null, null);
            return;
        }
        TextView textView2 = this.roleNameText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleNameText");
            textView2 = null;
        }
        textView2.setCompoundDrawables(null, null, g16, null);
    }

    private final void n(ey0.c roleInfo) {
        String d16 = roleInfo.d();
        if (TextUtils.isEmpty(d16)) {
            g.a(this.TAG, "showRoleName name null " + this.subUin);
            return;
        }
        TextView textView = this.roleNameText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleNameText");
            textView = null;
        }
        textView.setText(d16);
        m(roleInfo);
        TextView textView3 = this.roleNameText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleNameText");
        } else {
            textView2 = textView3;
        }
        addView(textView2);
    }

    private final void o(ey0.c roleInfo) {
        if (this.showRoleTagList) {
            List<YesGameInfoOuterClass$YesGameRoleAchievement> b16 = roleInfo.b();
            g.a(this.TAG, "showRoleTag " + b16.size() + " " + this.subUin);
            for (YesGameInfoOuterClass$YesGameRoleAchievement yesGameInfoOuterClass$YesGameRoleAchievement : b16) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                InnerTagView innerTagView = new InnerTagView(context);
                innerTagView.setData(yesGameInfoOuterClass$YesGameRoleAchievement);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, uu0.a.b(12));
                layoutParams.leftMargin = uu0.a.b(2);
                layoutParams.rightMargin = uu0.a.b(2);
                addView(innerTagView, layoutParams);
            }
        }
    }

    private final void p(ey0.c roleInfo) {
        removeAllViews();
        if (this.differentBySender && k()) {
            o(roleInfo);
            n(roleInfo);
        } else {
            n(roleInfo);
            o(roleInfo);
        }
    }

    private final void q() {
        TextView textView = this.roleNameText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleNameText");
            textView = null;
        }
        textView.setTextSize(1, this.roleNameTextSizeDp);
        textView.setTextColor(this.roleNameTextColor);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        textView.setIncludeFontPadding(false);
        textView.setCompoundDrawablePadding(uu0.a.b(2));
        textView.setGravity(17);
    }

    @Override // fy0.b
    public void a() {
        l();
    }

    @Override // fy0.b
    public void b() {
        l();
    }

    @Override // fy0.b
    public boolean c() {
        if (h() == null) {
            return true;
        }
        return false;
    }

    @Override // fy0.b
    public void d() {
        a();
    }

    @Override // fy0.c
    public void e(@Nullable ey0.c roleInfo) {
        if (roleInfo != null) {
            p(roleInfo);
        } else {
            l();
        }
    }

    @Nullable
    public final CommonOuterClass$QQUserId h() {
        b bVar = this.userInfoViewWrapper;
        if (bVar != null) {
            return bVar.d();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.userInfoViewWrapper;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.userInfoViewWrapper;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void setRoleTextColor(int color) {
        this.roleNameTextColor = color;
        TextView textView = this.roleNameText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleNameText");
            textView = null;
        }
        textView.setTextColor(this.roleNameTextColor);
    }

    public final void setUserId(@NotNull CommonOuterClass$QQUserId qqUserId, int gameId) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        this.qqUserId = qqUserId;
        this.gameId = gameId;
        this.subUin = g.i(n.f415773a.e(qqUserId));
        if (j()) {
            b bVar = this.userInfoViewWrapper;
            if (bVar != null) {
                bVar.f();
            }
            b bVar2 = this.userInfoViewWrapper;
            if (bVar2 != null) {
                bVar2.a();
            }
            l();
            return;
        }
        b bVar3 = this.userInfoViewWrapper;
        if (bVar3 != null) {
            bVar3.n(qqUserId, gameId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimUserGameInfoViewImpl(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ICGameTimUserGameInfoViewImpl";
        this.roleIconSize = ViewUtils.dpToPx(10.0f);
        this.roleNameTextSizeDp = 10.0f;
        this.roleNameTextColor = -16777216;
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimUserGameInfoViewImpl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ICGameTimUserGameInfoViewImpl";
        this.roleIconSize = ViewUtils.dpToPx(10.0f);
        this.roleNameTextSizeDp = 10.0f;
        this.roleNameTextColor = -16777216;
        i();
    }

    @Override // fy0.b
    public void f(@Nullable IUserInfo allUserInfoModel) {
    }
}
