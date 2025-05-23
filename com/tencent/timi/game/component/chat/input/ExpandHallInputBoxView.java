package com.tencent.timi.game.component.chat.input;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.component.chat.TimiBaseInputViewV2;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.emo.ui.TimiEmoPanelView;
import com.tencent.timi.game.utils.IResultListener;
import fm4.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001 B'\b\u0007\u0012\u0006\u0010c\u001a\u00020b\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d\u0012\b\b\u0002\u0010f\u001a\u00020\u0016\u00a2\u0006\u0004\bg\u0010hJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0006\u0010\u001a\u001a\u00020\u0003J\b\u0010\u001b\u001a\u00020\u0003H\u0014J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001c\u0010 \u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00160\u001dH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020&H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00104\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010/R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010=R\u0014\u0010B\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010ER\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010K\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020&0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020&0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010S\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010AR\u0016\u0010V\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u0004\u0018\u00010^8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b_\u0010`\u00a8\u0006j"}, d2 = {"Lcom/tencent/timi/game/component/chat/input/ExpandHallInputBoxView;", "Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2;", "Lnl4/b;", "", "y0", "", "roomId", "Lgm4/a;", "G0", "F0", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "dataList", "T0", "S0", "Landroid/widget/EditText;", "w", "Landroid/widget/TextView;", "K0", "Lcom/tencent/image/URLImageView;", "I0", "H0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B0", "M", "U0", NodeProps.ON_DETACHED_FROM_WINDOW, "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "memberMicLevelList", "a", "Lcom/tencent/timi/game/emo/ui/TimiEmoPanelView;", "d0", "Landroid/view/ViewGroup;", "g0", "R0", "", "Q0", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/EditText;", "inputEditText", "T", "Landroid/widget/TextView;", "sendBtn", "U", "Lcom/tencent/image/URLImageView;", "emojiBtn", "V", "speakerBtn", "W", "micBtn", "Landroidx/constraintlayout/widget/ConstraintLayout;", "a0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "inputAreaRoot", "b0", "profileBtn", "Landroid/graphics/drawable/Drawable;", "c0", "Landroid/graphics/drawable/Drawable;", "sendEnableDrawable", "sendDisableDrawable", "e0", "I", "sendEnabledTextColor", "f0", "sendDisabledTextColor", "J", "Landroidx/lifecycle/LiveData;", "h0", "Landroidx/lifecycle/LiveData;", "isMicMuteLD", "i0", "isSpeakerMuteLD", "Landroidx/lifecycle/Observer;", "j0", "Landroidx/lifecycle/Observer;", "isMicMutableObserver", "k0", "isSpeakerMutableObserver", "l0", "onSpeakingNum", "m0", "Z", "isSelfOnMic", "Lnl4/d;", "n0", "Lnl4/d;", "micDataListener", "o0", "Lcom/tencent/timi/game/emo/ui/TimiEmoPanelView;", "mEmoPanelView", "Lgh4/d;", "J0", "()Lgh4/d;", "reportHelper", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "p0", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ExpandHallInputBoxView extends TimiBaseInputViewV2 implements nl4.b {

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private EditText inputEditText;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private TextView sendBtn;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private URLImageView emojiBtn;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private URLImageView speakerBtn;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private URLImageView micBtn;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout inputAreaRoot;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLImageView profileBtn;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable sendEnableDrawable;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable sendDisableDrawable;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final int sendEnabledTextColor;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final int sendDisabledTextColor;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveData<Boolean> isMicMuteLD;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveData<Boolean> isSpeakerMuteLD;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> isMicMutableObserver;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> isSpeakerMutableObserver;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private int onSpeakingNum;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean isSelfOnMic;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nl4.d micDataListener;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimiEmoPanelView mEmoPanelView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/input/ExpandHallInputBoxView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            com.tencent.timi.game.utils.l.b("ExpandHallInputBoxView", "YOLO_ROOM_VOICE_ON succeed");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.m("ExpandHallInputBoxView", "YOLO_ROOM_VOICE_ON failed errorCode:" + errorCode + ", errorMessage:" + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/component/chat/input/ExpandHallInputBoxView$d", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "a", "b", "", "state", "onStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements TimiBaseInputView.b {
        d() {
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            int i3 = 1;
            if (state == 1) {
                ConstraintLayout constraintLayout = ExpandHallInputBoxView.this.inputAreaRoot;
                if (constraintLayout != null) {
                    constraintLayout.setPadding(0, fh4.b.b(12), 0, fh4.b.b(18));
                }
            } else {
                ConstraintLayout constraintLayout2 = ExpandHallInputBoxView.this.inputAreaRoot;
                if (constraintLayout2 != null) {
                    constraintLayout2.setPadding(0, fh4.b.b(12), 0, fh4.b.b(12));
                }
            }
            URLImageView uRLImageView = ExpandHallInputBoxView.this.emojiBtn;
            if (uRLImageView != null) {
                sh4.a aVar = sh4.a.f433815a;
                if (state != 3) {
                    i3 = 2;
                }
                sh4.d.c(uRLImageView, aVar.a(i3));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallInputBoxView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map A0(ExpandHallInputBoxView this$0, gh4.d reportHelper, String str) {
        String str2;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportHelper, "$reportHelper");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("yes_room_id", String.valueOf(this$0.roomId));
        pairArr[1] = TuplesKt.to("yes_room_type", 5);
        if (this$0.G0(this$0.roomId).b()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        pairArr[2] = TuplesKt.to("yes_mic_status", str2);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        mutableMapOf.putAll(reportHelper.h());
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(final long j3, final ExpandHallInputBoxView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            return;
        }
        gm4.a m06 = ((fm4.g) mm4.b.b(fm4.g.class)).m0(j3);
        this$0.isMicMuteLD = m06.e();
        this$0.isSpeakerMuteLD = m06.d();
        LiveData<Boolean> e16 = m06.e();
        if (e16 != null) {
            e16.observeForever(this$0.isMicMutableObserver);
        }
        LiveData<Boolean> d16 = m06.d();
        if (d16 != null) {
            d16.observeForever(this$0.isSpeakerMutableObserver);
        }
        URLImageView uRLImageView = this$0.speakerBtn;
        if (uRLImageView != null) {
            uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.input.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpandHallInputBoxView.D0(ExpandHallInputBoxView.this, j3, view);
                }
            });
        }
        URLImageView uRLImageView2 = this$0.micBtn;
        if (uRLImageView2 != null) {
            uRLImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.input.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpandHallInputBoxView.E0(ExpandHallInputBoxView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(ExpandHallInputBoxView this$0, long j3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type java.lang.Object");
        bVar.reportEvent("clck", view, new LinkedHashMap());
        this$0.G0(j3).c(!this$0.G0(j3).a());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(ExpandHallInputBoxView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type java.lang.Object");
        bVar.reportEvent("clck", view, new LinkedHashMap());
        this$0.F0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void F0() {
        int i3;
        boolean b16 = G0(this.roomId).b();
        com.tencent.timi.game.utils.l.b("ExpandHallInputBoxView", "onMicSucceed micEnable:" + b16);
        if (b16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        ((fm4.g) mm4.b.b(fm4.g.class)).A(this.roomId).O(null, i3, new b());
    }

    private final gm4.a G0(long roomId) {
        gm4.a m06 = ((fm4.g) mm4.b.b(fm4.g.class)).m0(roomId);
        Intrinsics.checkNotNullExpressionValue(m06, "getService(IRoomService:\u2026ass.java).audioOp(roomId)");
        return m06;
    }

    private final gh4.d J0() {
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            return I0.m0();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(ExpandHallInputBoxView this$0, Boolean bool) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        URLImageView uRLImageView = this$0.micBtn;
        if (uRLImageView != null) {
            sh4.a aVar = sh4.a.f433815a;
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                i3 = 6;
            } else {
                i3 = 5;
            }
            sh4.d.c(uRLImageView, aVar.a(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(ExpandHallInputBoxView this$0, Boolean bool) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        URLImageView uRLImageView = this$0.speakerBtn;
        if (uRLImageView != null) {
            sh4.a aVar = sh4.a.f433815a;
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                i3 = 8;
            } else {
                i3 = 7;
            }
            sh4.d.c(uRLImageView, aVar.a(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            I0.Fa();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(ExpandHallInputBoxView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.inputEditText;
        if (editText != null) {
            editText.setEditableFactory(this$0.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(ExpandHallInputBoxView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.s() == 3) {
            this$0.setState(1);
        } else {
            this$0.setState(3);
            FrameLayout funcLayout = this$0.getFuncLayout();
            if (funcLayout != null) {
                funcLayout.removeAllViews();
            }
            TimiEmoPanelView timiEmoPanelView = this$0.mEmoPanelView;
            if (timiEmoPanelView == null) {
                timiEmoPanelView = this$0.c0(1L);
            } else {
                timiEmoPanelView.j();
            }
            FrameLayout funcLayout2 = this$0.getFuncLayout();
            if (funcLayout2 != null) {
                funcLayout2.addView(timiEmoPanelView, new FrameLayout.LayoutParams(fh4.b.e(this$0), fh4.b.e(this$0)));
            }
            this$0.mEmoPanelView = timiEmoPanelView;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S0() {
        com.tencent.timi.game.utils.l.e("ExpandHallInputBoxView", "onSpeakingNum: " + this.onSpeakingNum);
        if (this.isSelfOnMic) {
            URLImageView uRLImageView = this.speakerBtn;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(0);
            }
            URLImageView uRLImageView2 = this.micBtn;
            if (uRLImageView2 != null) {
                uRLImageView2.setVisibility(0);
                return;
            }
            return;
        }
        if (this.onSpeakingNum > 0) {
            URLImageView uRLImageView3 = this.speakerBtn;
            if (uRLImageView3 != null) {
                uRLImageView3.setVisibility(0);
            }
            URLImageView uRLImageView4 = this.micBtn;
            if (uRLImageView4 != null) {
                uRLImageView4.setVisibility(8);
                return;
            }
            return;
        }
        URLImageView uRLImageView5 = this.speakerBtn;
        if (uRLImageView5 != null) {
            uRLImageView5.setVisibility(8);
        }
        URLImageView uRLImageView6 = this.micBtn;
        if (uRLImageView6 != null) {
            uRLImageView6.setVisibility(8);
        }
    }

    private final void T0(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> dataList) {
        boolean z16;
        int i3;
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list = dataList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (true ^ ll4.b.b(((YoloRoomOuterClass$YoloRoomSpeakingPosInfo) next).user_id)) {
                arrayList.add(next);
            }
        }
        this.onSpeakingNum = arrayList.size();
        if ((list instanceof Collection) && list.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it5 = list.iterator();
            i3 = 0;
            while (it5.hasNext()) {
                if (ll4.b.a(((YoloRoomOuterClass$YoloRoomSpeakingPosInfo) it5.next()).user_id, E) && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i3 <= 0) {
            z16 = false;
        }
        this.isSelfOnMic = z16;
        S0();
    }

    private final void y0() {
        com.tencent.timi.game.utils.l.e("ExpandHallInputBoxView", "bindMicSpeakerReport invoke");
        final gh4.d J0 = J0();
        if (J0 == null) {
            return;
        }
        URLImageView uRLImageView = this.micBtn;
        if (uRLImageView != null) {
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.b((ug4.b) b16, uRLImageView, false, null, J0.j(), null, 22, null);
            VideoReport.setEventDynamicParams(uRLImageView, new IDynamicParams() { // from class: com.tencent.timi.game.component.chat.input.g
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map A0;
                    A0 = ExpandHallInputBoxView.A0(ExpandHallInputBoxView.this, J0, str);
                    return A0;
                }
            });
        }
        URLImageView uRLImageView2 = this.speakerBtn;
        if (uRLImageView2 != null) {
            mm4.a b17 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
            b.a.b((ug4.b) b17, uRLImageView2, false, null, J0.k(), null, 22, null);
            VideoReport.setEventDynamicParams(uRLImageView2, new IDynamicParams() { // from class: com.tencent.timi.game.component.chat.input.h
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map z06;
                    z06 = ExpandHallInputBoxView.z0(ExpandHallInputBoxView.this, J0, str);
                    return z06;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map z0(ExpandHallInputBoxView this$0, gh4.d reportHelper, String str) {
        String str2;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportHelper, "$reportHelper");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("yes_room_id", String.valueOf(this$0.roomId));
        pairArr[1] = TuplesKt.to("yes_room_type", 5);
        if (this$0.G0(this$0.roomId).a()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        pairArr[2] = TuplesKt.to("yes_voice_status", str2);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        mutableMapOf.putAll(reportHelper.h());
        return mutableMapOf;
    }

    public final void B0(final long roomId) {
        this.roomId = roomId;
        ((fm4.g) mm4.b.b(fm4.g.class)).k(roomId).H(new u() { // from class: com.tencent.timi.game.component.chat.input.f
            @Override // fm4.u
            public final void j(boolean z16) {
                ExpandHallInputBoxView.C0(roomId, this, z16);
            }
        });
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> memberList = ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomId).n();
        Intrinsics.checkNotNullExpressionValue(memberList, "memberList");
        T0(memberList);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(roomId).y(this.micDataListener);
        y0();
    }

    @Nullable
    /* renamed from: H0, reason: from getter */
    public URLImageView getEmojiBtn() {
        return this.emojiBtn;
    }

    @Nullable
    /* renamed from: I0, reason: from getter */
    public final URLImageView getProfileBtn() {
        return this.profileBtn;
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    @Nullable
    /* renamed from: K0, reason: from getter */
    public TextView getSendBtn() {
        return this.sendBtn;
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    public void M() {
        GradientDrawable gradientDrawable;
        sh4.a aVar = sh4.a.f433815a;
        GradientDrawable gradientDrawable2 = null;
        sh4.d.b(this, aVar.a(16), 0.0f, 2, null);
        this.inputEditText = (EditText) findViewById(R.id.dmu);
        this.sendBtn = (TextView) findViewById(R.id.f83174iv);
        this.profileBtn = (URLImageView) findViewById(R.id.f28140i5);
        this.emojiBtn = (URLImageView) findViewById(R.id.usz);
        this.speakerBtn = (URLImageView) findViewById(R.id.f87164tm);
        this.micBtn = (URLImageView) findViewById(R.id.z67);
        this.inputAreaRoot = (ConstraintLayout) findViewById(R.id.dmh);
        EditText editText = this.inputEditText;
        if (editText != null) {
            sh4.d.e(editText, aVar.a(19), false, 2, null);
        }
        EditText editText2 = this.inputEditText;
        if (editText2 != null) {
            sh4.d.d(editText2, aVar.a(18), true);
        }
        URLImageView uRLImageView = this.profileBtn;
        if (uRLImageView != null) {
            sh4.d.c(uRLImageView, aVar.a(3));
        }
        URLImageView createTeamBtn = (URLImageView) findViewById(R.id.f164930ub3);
        createTeamBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.input.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallInputBoxView.N0(view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createTeamBtn, "createTeamBtn");
        sh4.d.c(createTeamBtn, aVar.a(4));
        URLImageView uRLImageView2 = this.emojiBtn;
        if (uRLImageView2 != null) {
            sh4.d.c(uRLImageView2, aVar.a(1));
        }
        EditText editText3 = this.inputEditText;
        if (editText3 != null) {
            sh4.d.a(editText3, aVar.a(17), fh4.b.d(18));
        }
        EditText editText4 = this.inputEditText;
        if (editText4 != null) {
            editText4.post(new Runnable() { // from class: com.tencent.timi.game.component.chat.input.d
                @Override // java.lang.Runnable
                public final void run() {
                    ExpandHallInputBoxView.O0(ExpandHallInputBoxView.this);
                }
            });
        }
        TextView textView = this.sendBtn;
        if (textView != null) {
            gradientDrawable = fh4.g.f(textView, fh4.b.b(18), Color.parseColor("#F5A300"));
        } else {
            gradientDrawable = null;
        }
        this.sendEnableDrawable = gradientDrawable;
        TextView textView2 = this.sendBtn;
        if (textView2 != null) {
            gradientDrawable2 = fh4.g.f(textView2, fh4.b.b(18), Color.parseColor("#F7F7F7"));
        }
        this.sendDisableDrawable = gradientDrawable2;
        U0();
        URLImageView uRLImageView3 = this.emojiBtn;
        if (uRLImageView3 != null) {
            uRLImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.input.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpandHallInputBoxView.P0(ExpandHallInputBoxView.this, view);
                }
            });
        }
        String c16 = yn4.c.c(R.string.f236787fa);
        Intrinsics.checkNotNullExpressionValue(c16, "getString(R.string.try_send_something)");
        TimiBaseInputView.K(this, 0.0f, 0, c16, 3, null);
        EditText editText5 = this.inputEditText;
        if (editText5 != null) {
            editText5.addTextChangedListener(new c());
        }
        i(new d());
    }

    public boolean Q0() {
        TimiEmoPanelView timiEmoPanelView;
        if (getCurrentState() != 3 || (timiEmoPanelView = this.mEmoPanelView) == null) {
            return false;
        }
        return timiEmoPanelView.i();
    }

    public void R0() {
        TimiEmoPanelView timiEmoPanelView;
        if (getCurrentState() == 3 && (timiEmoPanelView = this.mEmoPanelView) != null) {
            timiEmoPanelView.j();
        }
    }

    public final void U0() {
        Editable editable;
        boolean z16;
        EditText editText = this.inputEditText;
        if (editText != null) {
            editable = editText.getEditableText();
        } else {
            editable = null;
        }
        if (editable != null && editable.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        URLImageView uRLImageView = this.profileBtn;
        if (uRLImageView != null) {
            fh4.g.o(uRLImageView, z16);
        }
        TextView textView = this.sendBtn;
        if (textView != null) {
            fh4.g.o(textView, !z16);
        }
        if (z16) {
            TextView textView2 = this.sendBtn;
            if (textView2 != null) {
                textView2.setBackgroundDrawable(this.sendDisableDrawable);
            }
            TextView textView3 = this.sendBtn;
            if (textView3 != null) {
                textView3.setTextColor(this.sendDisabledTextColor);
                return;
            }
            return;
        }
        TextView textView4 = this.sendBtn;
        if (textView4 != null) {
            textView4.setBackgroundDrawable(this.sendEnableDrawable);
        }
        TextView textView5 = this.sendBtn;
        if (textView5 != null) {
            textView5.setTextColor(this.sendEnabledTextColor);
        }
    }

    @Override // nl4.b
    public void a(@NotNull ConcurrentHashMap<String, Integer> memberMicLevelList) {
        Intrinsics.checkNotNullParameter(memberMicLevelList, "memberMicLevelList");
    }

    @Override // nl4.b
    public void b(@NotNull List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        T0(dataList);
    }

    @Override // com.tencent.timi.game.component.chat.TimiBaseInputViewV2
    @Nullable
    /* renamed from: d0, reason: from getter */
    public TimiEmoPanelView getMEmoPanelView() {
        return this.mEmoPanelView;
    }

    @Override // com.tencent.timi.game.component.chat.TimiBaseInputViewV2
    @Nullable
    public ViewGroup g0() {
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            return I0.S1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LiveData<Boolean> liveData = this.isMicMuteLD;
        if (liveData != null) {
            liveData.removeObserver(this.isMicMutableObserver);
        }
        LiveData<Boolean> liveData2 = this.isSpeakerMuteLD;
        if (liveData2 != null) {
            liveData2.removeObserver(this.isSpeakerMutableObserver);
        }
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.roomId).Q(this.micDataListener);
        TimiEmoPanelView timiEmoPanelView = this.mEmoPanelView;
        if (timiEmoPanelView != null) {
            timiEmoPanelView.e();
        }
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    @Nullable
    /* renamed from: w, reason: from getter */
    public EditText getInputEditText() {
        return this.inputEditText;
    }

    @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView
    public int z() {
        return R.layout.hu9;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallInputBoxView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ExpandHallInputBoxView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallInputBoxView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.sendEnabledTextColor = Color.parseColor("#FFFFFF");
        this.sendDisabledTextColor = Color.parseColor("#D1D1D1");
        this.isMicMutableObserver = new Observer() { // from class: com.tencent.timi.game.component.chat.input.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExpandHallInputBoxView.L0(ExpandHallInputBoxView.this, (Boolean) obj);
            }
        };
        this.isSpeakerMutableObserver = new Observer() { // from class: com.tencent.timi.game.component.chat.input.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExpandHallInputBoxView.M0(ExpandHallInputBoxView.this, (Boolean) obj);
            }
        };
        this.micDataListener = new nl4.d(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/component/chat/input/ExpandHallInputBoxView$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            ExpandHallInputBoxView.this.U0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
