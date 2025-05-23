package com.tencent.icgame.game.liveroom.impl.room.profile.manager.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.ui.widget.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw0.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B%\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006'"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/ManagementHistoryView;", "Landroid/widget/FrameLayout;", "", "f", "Lsw0/a;", "data", "", "setData", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "d", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "gender", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "content", tl.h.F, "nickname", "i", "medal_icon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "withdraw", "Lcom/tencent/icgame/game/ui/widget/RoundCornerImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/icgame/game/ui/widget/RoundCornerImageView;", "manage_head", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class ManagementHistoryView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RoundCornerImageView manage_head;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView gender;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView content;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView nickname;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView medal_icon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView withdraw;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ManagementHistoryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final long f() {
        LiveUserInfo selfUserInfo;
        fu0.c cVar = (fu0.c) qx0.a.b(fu0.c.class);
        if (cVar != null && (selfUserInfo = cVar.getSelfUserInfo()) != null) {
            return selfUserInfo.uid;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final sw0.a data, final ManagementHistoryView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = data.f434873f;
        if (i3 == 0) {
            DialogUtil.createCustomDialog(this$0.getContext(), 230, (String) null, "\u786e\u5b9a\u8981\u64a4\u56de\u5417\uff1f", this$0.getContext().getString(R.string.cancel), this$0.getContext().getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    ManagementHistoryView.h(sw0.a.this, this$0, dialogInterface, i16);
                }
            }, (DialogInterface.OnClickListener) null).show();
        } else if (i3 == 1) {
            DialogUtil.createCustomDialog(this$0.getContext(), 230, (String) null, "\u786e\u5b9a\u8981\u64a4\u56de\u5417\uff1f", this$0.getContext().getString(R.string.cancel), "\u64a4\u56de", new DialogInterface.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    ManagementHistoryView.j(sw0.a.this, this$0, dialogInterface, i16);
                }
            }, (DialogInterface.OnClickListener) null).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(sw0.a data, final ManagementHistoryView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        k.B(data.f434872e, data.f434875h, 0, true, new k.h() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.g
            @Override // qw0.k.h
            public final void onResult(boolean z16) {
                ManagementHistoryView.i(ManagementHistoryView.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ManagementHistoryView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.withdraw.setImageResource(R.drawable.oez);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(sw0.a data, final ManagementHistoryView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        k.j(data.f434876i, this$0.f(), data.f434872e, data.f434875h, new k.g() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.h
            @Override // qw0.k.g
            public final void onResult(boolean z16) {
                ManagementHistoryView.k(ManagementHistoryView.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ManagementHistoryView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.withdraw.setImageResource(R.drawable.oez);
        }
    }

    public final void setData(@NotNull final sw0.a data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        this.mAegisLog.i("ICGameManagementHistoryView", "data=" + data);
        if (!TextUtils.isEmpty(data.f434868a)) {
            this.manage_head.setImageDrawable(URLDrawable.getDrawable(data.f434868a));
            this.manage_head.setRadius(uu0.a.d(25));
        }
        this.nickname.setText(data.f434869b);
        this.content.setText(data.f434871d);
        if (data.f434870c) {
            this.gender.setImageResource(R.drawable.o5h);
        } else {
            this.gender.setImageResource(R.drawable.o5i);
        }
        if (TextUtils.isEmpty(data.f434877j)) {
            this.medal_icon.setVisibility(8);
        } else {
            this.medal_icon.setVisibility(0);
            this.medal_icon.setImageDrawable(URLDrawable.getDrawable(data.f434877j));
        }
        HashMap hashMap = new HashMap();
        if (data.f434873f == 0) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("icgame_administrator_history_tab", str);
        hashMap.put("icgame_inf_module_user_id", String.valueOf(data.f434872e));
        ((ru0.a) qx0.a.b(ru0.a.class)).b(this, "pg_icgame_anchorlive_show", hashMap);
        ((ru0.a) qx0.a.b(ru0.a.class)).a(this.withdraw, true, data.f434868a, "em_icgame_administrator_history_cancel", hashMap);
        this.withdraw.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManagementHistoryView.g(sw0.a.this, this, view);
            }
        });
    }

    public /* synthetic */ ManagementHistoryView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i16 & 4) != 0 ? -1 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ManagementHistoryView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        View.inflate(context, R.layout.fb5, this);
        View findViewById = findViewById(R.id.ywr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.manage_head)");
        this.manage_head = (RoundCornerImageView) findViewById;
        View findViewById2 = findViewById(R.id.nickname);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.nickname)");
        this.nickname = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.content)");
        this.content = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.csn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.gender)");
        this.gender = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.yz7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.medal_icon)");
        this.medal_icon = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f124827ke);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.withdraw)");
        this.withdraw = (ImageView) findViewById6;
    }
}
