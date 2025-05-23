package com.tencent.mobileqq.icgame.room.debugview.audience;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.room.debugview.audience.QQLiveAudienceDebugView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import h22.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/debugview/audience/QQLiveAudienceDebugView;", "Landroid/widget/LinearLayout;", "", "e", "f", "Lh22/a;", "qqLiveRoomService", "setIQQLiveRoomService", "Lcom/tencent/mobileqq/icgame/room/displayview/component/a;", "liveRoomDisplayService", "setIivLiveRoomDisplayService", "d", "Lh22/a;", "Lcom/tencent/mobileqq/icgame/room/displayview/component/a;", "Landroid/widget/Button;", "Landroid/widget/Button;", "closeButton", h.F, "copyButton", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "roomInfoTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "videoUrlInfoTextView", BdhLogUtil.LogTag.Tag_Conn, "videoDownloadSpeedTextView", "D", "playerInfoTextView", "E", "watchInfoTextView", UserInfo.SEX_FEMALE, "requestProtocolTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveAudienceDebugView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private TextView videoDownloadSpeedTextView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TextView playerInfoTextView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView watchInfoTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private TextView requestProtocolTextView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a qqLiveRoomService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.icgame.room.displayview.component.a liveRoomDisplayService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Button closeButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Button copyButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView roomInfoTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView videoUrlInfoTextView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveAudienceDebugView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QQLiveAudienceDebugView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QQLiveAudienceDebugView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e() {
        setVisibility(8);
    }

    private final void f() {
        com.tencent.timi.game.utils.a.a(getContext(), ((Object) this.roomInfoTextView.getText()) + "\n" + ((Object) this.videoUrlInfoTextView.getText()) + "\n" + ((Object) this.videoDownloadSpeedTextView.getText()) + "\n" + ((Object) this.playerInfoTextView.getText()) + "\n" + ((Object) this.watchInfoTextView.getText()));
        QQToast.makeText(getContext(), "\u590d\u5236\u6210\u529f", 0, 0).show();
    }

    public final void setIQQLiveRoomService(@NotNull a qqLiveRoomService) {
        Intrinsics.checkNotNullParameter(qqLiveRoomService, "qqLiveRoomService");
        this.qqLiveRoomService = qqLiveRoomService;
    }

    public final void setIivLiveRoomDisplayService(@NotNull com.tencent.mobileqq.icgame.room.displayview.component.a liveRoomDisplayService) {
        Intrinsics.checkNotNullParameter(liveRoomDisplayService, "liveRoomDisplayService");
        this.liveRoomDisplayService = liveRoomDisplayService;
    }

    public /* synthetic */ QQLiveAudienceDebugView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveAudienceDebugView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.fak, this);
        View findViewById = inflate.findViewById(R.id.uez);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.debug_view_close)");
        this.closeButton = (Button) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f164954uf0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.debug_view_copy)");
        this.copyButton = (Button) findViewById2;
        this.closeButton.setOnClickListener(new View.OnClickListener() { // from class: c42.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveAudienceDebugView.c(QQLiveAudienceDebugView.this, view);
            }
        });
        this.copyButton.setOnClickListener(new View.OnClickListener() { // from class: c42.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveAudienceDebugView.d(QQLiveAudienceDebugView.this, view);
            }
        });
        View findViewById3 = inflate.findViewById(R.id.f7809465);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.room_info)");
        this.roomInfoTextView = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f11803732);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.video_url_info)");
        this.videoUrlInfoTextView = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f1173971b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.video_download_speed)");
        this.videoDownloadSpeedTextView = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f25860bz);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.player_info)");
        this.playerInfoTextView = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f120667_6);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.watch_info)");
        this.watchInfoTextView = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f28740jr);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.protocol_info)");
        this.requestProtocolTextView = (TextView) findViewById8;
    }
}
