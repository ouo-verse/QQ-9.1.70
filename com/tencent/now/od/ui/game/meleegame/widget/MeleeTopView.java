package com.tencent.now.od.ui.game.meleegame.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.VisibleForTesting;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.component.ClickListenerKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u00012\u00020\u0002:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0006\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R*\u00102\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00068\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010&\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/now/od/ui/game/meleegame/widget/MeleeTopView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", "d", "a", "", "roomShortNo", "roomId", "", "roomName", "setRoomInfo", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "visibility", "setVisibility", "", "b", "Landroid/content/Context;", "context", "c", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "meleeRoomIdTv", "e", "meleeRoomNameTv", "Landroid/widget/Button;", "f", "Landroid/widget/Button;", "collectButton", "Landroid/widget/ViewFlipper;", h.F, "Landroid/widget/ViewFlipper;", "animator", "i", "userCountTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", BdhLogUtil.LogTag.Tag_Conn, "D", "Ljava/lang/String;", "E", "checkTimes", "value", UserInfo.SEX_FEMALE, "getUserCount", "()I", "setUserCount", "(I)V", QFSSearchBaseRequest.EXTRA_KEY_USER_COUNT, "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MeleeTopView extends FrameLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private int roomId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String roomName;

    /* renamed from: E, reason: from kotlin metadata */
    private int checkTimes;

    /* renamed from: F, reason: from kotlin metadata */
    private int userCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView meleeRoomIdTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView meleeRoomNameTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Button collectButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewFlipper animator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView userCountTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int roomShortNo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeTopView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        this.collectButton.setVisibility(8);
    }

    private final void d() {
        String string = getContext().getString(R.string.ze5, Long.valueOf(b(this.roomShortNo, this.roomId)));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ui_melee_room_id, roomId)");
        this.meleeRoomIdTv.setText(string);
        String str = this.roomName;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.meleeRoomNameTv.setText(c(str, context));
    }

    @VisibleForTesting
    public final long b(int roomShortNo, int roomId) {
        if (roomShortNo > 0) {
            return roomShortNo;
        }
        return roomId;
    }

    @VisibleForTesting
    @NotNull
    public final String c(@NotNull String roomName, @NotNull Context context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        Intrinsics.checkNotNullParameter(context, "context");
        if (roomName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String string = context.getString(R.string.zdy);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            context.ge\u2026e_no_room_name)\n        }");
            return string;
        }
        return roomName;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!ClickListenerKt.isInvalidClick$default(v3, 0L, 2, null)) {
            this.collectButton.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setRoomInfo(int roomShortNo, int roomId, @NotNull String roomName) {
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        this.roomShortNo = roomShortNo;
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public final void setUserCount(int i3) {
        if (this.userCount == i3) {
            return;
        }
        this.userCountTv.setText(getContext().getString(R.string.ze6, Integer.valueOf(i3)));
        this.userCount = i3;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == 0) {
            this.animator.startFlipping();
            this.checkTimes = 0;
            d();
            a();
            return;
        }
        this.animator.stopFlipping();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeTopView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MeleeTopView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeTopView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.roomName = "";
        LayoutInflater.from(context).inflate(R.layout.dzz, this);
        View findViewById = findViewById(R.id.f7811467);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.meleeRoomNameTv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f7808464);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.meleeRoomIdTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.ama);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById3;
        this.collectButton = button;
        button.setOnClickListener(this);
        View findViewById4 = findViewById(R.id.s_);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ViewFlipper");
        this.animator = (ViewFlipper) findViewById4;
        View findViewById5 = findViewById(R.id.f782546k);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.userCountTv = (TextView) findViewById5;
    }
}
