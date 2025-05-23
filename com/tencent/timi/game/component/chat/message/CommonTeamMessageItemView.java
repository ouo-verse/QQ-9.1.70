package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.teamlist.view.TeamListGiftImageView;
import com.tencent.timi.game.ui.widget.TimiRoundImageView;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamIcon;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001)\u0018\u0000 I2\u00020\u0001:\u0001JB'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010F\u001a\u00020E\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010(\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u001fR\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00105\u00a8\u0006K"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/CommonTeamMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Landroid/graphics/drawable/GradientDrawable;", "T", "", "url", "Landroid/graphics/drawable/Drawable;", ExifInterface.LATITUDE_SOUTH, "Ltrpc/yes/common/PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;", "teamInfo", "key", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "I", "", "Lcom/tencent/timi/game/ui/widget/TimiRoundImageView;", "f0", "Ljava/util/List;", "avatarViews", "Landroid/widget/TextView;", "g0", "roadViews", "Landroid/widget/ImageView;", "h0", "userTagViews", "Landroid/view/View;", "i0", "Landroid/view/View;", "invalidMaskView", "j0", "Lkotlin/Lazy;", "P", "()Landroid/graphics/drawable/GradientDrawable;", "maleDrawable", "k0", "O", "femaleDrawable", "com/tencent/timi/game/component/chat/message/CommonTeamMessageItemView$c", "l0", "Lcom/tencent/timi/game/component/chat/message/CommonTeamMessageItemView$c;", "teamUpdateListener", "Landroidx/constraintlayout/widget/ConstraintLayout;", "m0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "contentCl", "n0", "Landroid/widget/ImageView;", "bgView", "o0", "Landroid/widget/TextView;", "nameTv", "p0", "modeTv", "q0", "dividerView", "Lcom/tencent/timi/game/teamlist/view/TeamListGiftImageView;", "r0", "Lcom/tencent/timi/game/teamlist/view/TeamListGiftImageView;", "giftView", "s0", "gradeRangeTv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "t0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class CommonTeamMessageItemView extends BaseMessageView {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<TimiRoundImageView> avatarViews;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<TextView> roadViews;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<ImageView> userTagViews;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View invalidMaskView;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy maleDrawable;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy femaleDrawable;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c teamUpdateListener;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConstraintLayout contentCl;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView bgView;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView nameTv;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView modeTv;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View dividerView;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TeamListGiftImageView giftView;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView gradeRangeTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/CommonTeamMessageItemView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376446a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonTeamMessageItemView f376447b;

        b(com.tencent.timi.game.tim.api.message.a aVar, CommonTeamMessageItemView commonTeamMessageItemView) {
            this.f376446a = aVar;
            this.f376447b = commonTeamMessageItemView;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomInfo result) {
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.d((ug4.b) b16, "ev_smoba_team_join_success", null, 2, null);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            if (errorCode == 920003 || errorCode == 920012) {
                this.f376446a.n(1);
                this.f376447b.I(this.f376446a);
            }
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.d((ug4.b) b16, "ev_smoba_team_join_fail", null, 2, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonTeamMessageItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final GradientDrawable O() {
        return (GradientDrawable) this.femaleDrawable.getValue();
    }

    private final GradientDrawable P() {
        return (GradientDrawable) this.maleDrawable.getValue();
    }

    private final String Q(PremadesTeamServerOuterClass$YesGamePremadesTeamInfo teamInfo, String key) {
        String str;
        Object obj;
        PBStringField pBStringField;
        List<PremadesTeamServerOuterClass$YesGamePremadesTeamIcon> list = teamInfo.icon_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "teamInfo.icon_list.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((PremadesTeamServerOuterClass$YesGamePremadesTeamIcon) obj).key.get(), key)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        PremadesTeamServerOuterClass$YesGamePremadesTeamIcon premadesTeamServerOuterClass$YesGamePremadesTeamIcon = (PremadesTeamServerOuterClass$YesGamePremadesTeamIcon) obj;
        if (premadesTeamServerOuterClass$YesGamePremadesTeamIcon != null && (pBStringField = premadesTeamServerOuterClass$YesGamePremadesTeamIcon.value) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(com.tencent.timi.game.tim.api.message.a msg2, PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo, PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg, List list, CommonTeamMessageItemView this$0, View view) {
        long j3;
        ExpandHallLaunchParam expandHallLaunchParam;
        int i3;
        gh4.d mReporterHelper;
        PBUInt64Field pBUInt64Field;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.f("team_msg_click_" + msg2.id(), 300L)) {
            YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
            if (j06 != null && (pBUInt64Field = j06.room_id) != null) {
                j3 = pBUInt64Field.get();
            } else {
                j3 = 0;
            }
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            fm4.c cVar = null;
            if (I0 != null) {
                expandHallLaunchParam = I0.O();
            } else {
                expandHallLaunchParam = null;
            }
            gh4.e I02 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I02 != null && (mReporterHelper = I02.getMReporterHelper()) != null) {
                cVar = mReporterHelper.i();
            }
            com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
            dVar.f379324a = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.f437250id.get();
            if (expandHallLaunchParam != null) {
                i3 = com.tencent.timi.game.utils.b.h(expandHallLaunchParam.f376301d);
            } else {
                i3 = 1;
            }
            dVar.f379325b = i3;
            dVar.f379326c = 1;
            dVar.f379328e = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.type.get();
            dVar.f379329f = cVar;
            dVar.f379327d = ((fm4.g) mm4.b.b(fm4.g.class)).h2(premadesTeamServerOuterClass$ShareYoloRoomMsg.room_info.room_type.get());
            dVar.f379330g = j3;
            dVar.f379331h = 0L;
            com.tencent.timi.game.room.impl.util.c cVar2 = new com.tencent.timi.game.room.impl.util.c();
            cVar2.f379322a = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.game_mode.get();
            cVar2.f379323b = list;
            ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, vf4.a.b(), dVar, cVar2, new b(msg2, this$0));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Drawable S(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = T();
        obtain.mFailedDrawable = T();
        return ((ei4.a) mm4.b.b(ei4.a.class)).m(url, obtain);
    }

    private final GradientDrawable T() {
        return new GradientDrawable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x03a8, code lost:
    
        if (r12.status.get() == 0) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03aa, code lost:
    
        r26.avatarViews.get(r5).setImageDrawable(T());
        r9 = r26.avatarViews.get(r5);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "teamInfo");
        r9.setBackgroundDrawable(S(Q(r8, org.aspectj.lang.JoinPoint.SYNCHRONIZATION_LOCK)));
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0504 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0287  */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(@NotNull final com.tencent.timi.game.tim.api.message.a msg2) {
        boolean z16;
        PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg;
        byte[] bArr;
        boolean isBlank;
        int collectionSizeOrDefault;
        String str;
        String joinToString$default;
        PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo;
        boolean isBlank2;
        boolean z17;
        Object obj;
        GradientDrawable P;
        boolean isBlank3;
        boolean isBlank4;
        boolean isBlank5;
        gh4.d mReporterHelper;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.I(msg2);
        Object memData = msg2.getMemData();
        if (memData instanceof PremadesTeamServerOuterClass$ShareYoloRoomMsg) {
            premadesTeamServerOuterClass$ShareYoloRoomMsg = (PremadesTeamServerOuterClass$ShareYoloRoomMsg) memData;
        } else {
            String p16 = msg2.p();
            if (p16 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(p16);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        try {
                            PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg2 = new PremadesTeamServerOuterClass$ShareYoloRoomMsg();
                            String p17 = msg2.p();
                            if (p17 != null) {
                                bArr = p17.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                            } else {
                                bArr = null;
                            }
                            premadesTeamServerOuterClass$ShareYoloRoomMsg = premadesTeamServerOuterClass$ShareYoloRoomMsg2.mergeFrom(bArr);
                        } catch (InvalidProtocolBufferMicroException unused) {
                            premadesTeamServerOuterClass$ShareYoloRoomMsg = msg2.a().share_yolo_room_msg;
                        }
                    } else {
                        premadesTeamServerOuterClass$ShareYoloRoomMsg = msg2.a().share_yolo_room_msg;
                    }
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        final PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg3 = premadesTeamServerOuterClass$ShareYoloRoomMsg;
        msg2.e(premadesTeamServerOuterClass$ShareYoloRoomMsg3);
        PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo2 = premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.get();
        final List<Integer> list = premadesTeamServerOuterClass$YesGamePremadesTeamInfo2.grade_list.get();
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = premadesTeamServerOuterClass$ShareYoloRoomMsg3.room_info;
        List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> list2 = premadesTeamServerOuterClass$YesGamePremadesTeamInfo2.user_list.get();
        Intrinsics.checkNotNullExpressionValue(list2, "teamInfo.user_list.get()");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list2) {
            PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo = (PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo) obj2;
            if (premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.uid.get() > 0 && premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.role_achievement.size() > 0) {
                arrayList.add(obj2);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo) it.next()).role_achievement.get(0).type);
        }
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        ug4.b bVar = (ug4.b) b16;
        ImageView imageView = this.bgView;
        String id5 = msg2.id();
        ConcurrentHashMap<String, String> M = YoloRoomUtil.M(yoloRoomOuterClass$YoloRoomInfo);
        M.putAll(YoloRoomUtil.L(getRoomInfo()));
        if (msg2.m() == 1) {
            str = "2";
        } else {
            str = premadesTeamServerOuterClass$YesGamePremadesTeamInfo2.game_status.get() == 3 ? "1" : "0";
        }
        M.put("yes_team_status", str);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, new Function1<PBInt32Field, CharSequence>() { // from class: com.tencent.timi.game.component.chat.message.CommonTeamMessageItemView$renderUI$1$1$membetTags$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(PBInt32Field pBInt32Field) {
                return String.valueOf(pBInt32Field.get());
            }
        }, 30, null);
        M.put("yes_member_tag_id", joinToString$default);
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null || (mReporterHelper = I0.getMReporterHelper()) == null) {
            premadesTeamServerOuterClass$YesGamePremadesTeamInfo = premadesTeamServerOuterClass$YesGamePremadesTeamInfo2;
        } else {
            premadesTeamServerOuterClass$YesGamePremadesTeamInfo = premadesTeamServerOuterClass$YesGamePremadesTeamInfo2;
            mReporterHelper.Z(yoloRoomOuterClass$YoloRoomInfo.room_id.get(), joinToString$default);
        }
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(M, "getCommonTeamInfoReportP\u2026gs)\n                    }");
        b.a.a(bVar, imageView, false, id5, "em_yes_chat_join_team", M, 2, null);
        final PremadesTeamServerOuterClass$YesGamePremadesTeamInfo teamInfo = premadesTeamServerOuterClass$YesGamePremadesTeamInfo;
        try {
            Intrinsics.checkNotNullExpressionValue(teamInfo, "teamInfo");
            String Q = Q(teamInfo, "text_normal_hue");
            String Q2 = Q(teamInfo, "text_weak_hue");
            isBlank4 = StringsKt__StringsJVMKt.isBlank(Q);
            if (!isBlank4) {
                this.nameTv.setTextColor(Color.parseColor(Q));
                this.giftView.setGiftDescTextColor(Color.parseColor(Q));
            }
            isBlank5 = StringsKt__StringsJVMKt.isBlank(Q2);
            if (!isBlank5) {
                this.modeTv.setTextColor(Color.parseColor(Q2));
                this.gradeRangeTv.setTextColor(Color.parseColor(Q2));
                this.dividerView.setBackgroundColor(Color.parseColor(Q2));
            }
        } catch (IllegalArgumentException unused2) {
            com.tencent.timi.game.utils.l.m("CommonTeamMessageItemView", "color parse error");
        }
        this.nameTv.setText(teamInfo.name.get());
        this.modeTv.setText(teamInfo.game_mode_name.get());
        fh4.g.o(this.gradeRangeTv, true);
        this.gradeRangeTv.setText(teamInfo.grade_desc.get());
        View view = this.dividerView;
        String str2 = teamInfo.game_mode_name.get();
        Intrinsics.checkNotNullExpressionValue(str2, "teamInfo.game_mode_name.get()");
        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
        if (!isBlank2) {
            String str3 = teamInfo.grade_desc.get();
            Intrinsics.checkNotNullExpressionValue(str3, "teamInfo.grade_desc.get()");
            isBlank3 = StringsKt__StringsJVMKt.isBlank(str3);
            if (!isBlank3) {
                z17 = true;
                fh4.g.o(view, z17);
                this.bgView.setOnTouchListener(getPositionOnTouchListener());
                this.bgView.setOnLongClickListener(getOnLongClickListner());
                fh4.g.o(this.giftView, premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.has());
                if (premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.has()) {
                    this.giftView.setGiftInfo(premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.gift_num.get(), premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.gift_material_id.get());
                }
                List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> userList = teamInfo.user_list.get();
                int i3 = 0;
                for (Object obj3 : this.avatarViews) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (i3 < userList.size()) {
                        fh4.g.o(this.avatarViews.get(i3), true);
                        fh4.g.o(this.roadViews.get(i3), true);
                        fh4.g.o(this.userTagViews.get(i3), true);
                        Intrinsics.checkNotNullExpressionValue(userList, "userList");
                        Iterator<T> it5 = userList.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                obj = it5.next();
                                if (((PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo) obj).pos.get() == i16) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2 = (PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo) obj;
                        if (premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2 != null && premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.uid.get() != 0) {
                            TimiRoundImageView timiRoundImageView = this.avatarViews.get(i3);
                            int i17 = premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.gender.get();
                            if (i17 == 1) {
                                P = P();
                            } else if (i17 != 2) {
                                P = T();
                            } else {
                                P = O();
                            }
                            timiRoundImageView.setBackgroundDrawable(P);
                            Drawable b17 = yn4.c.b(R.drawable.ovb);
                            URLDrawable b18 = gn4.c.b(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.avatar.get(), b17, 24.0f, 24.0f);
                            if (b18 == null) {
                                this.avatarViews.get(i3).setImageDrawable(b17);
                            } else {
                                this.avatarViews.get(i3).setImageDrawable(b18);
                            }
                            this.roadViews.get(i3).setText(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.lane_type_desc.get());
                            if (!premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.role_achievement.isEmpty()) {
                                fh4.g.o(this.userTagViews.get(i3), true);
                                this.userTagViews.get(i3).setImageDrawable(gn4.c.b(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.role_achievement.get(0).icon.get(), null, 21.0f, 16.0f));
                            } else {
                                fh4.g.o(this.userTagViews.get(i3), false);
                            }
                        }
                        this.avatarViews.get(i3).setImageDrawable(T());
                        TimiRoundImageView timiRoundImageView2 = this.avatarViews.get(i3);
                        Intrinsics.checkNotNullExpressionValue(teamInfo, "teamInfo");
                        timiRoundImageView2.setBackgroundDrawable(S(Q(teamInfo, "add")));
                        this.roadViews.get(i3).setText("");
                        fh4.g.o(this.userTagViews.get(i3), false);
                    } else {
                        fh4.g.o(this.avatarViews.get(i3), false);
                        fh4.g.o(this.roadViews.get(i3), false);
                        fh4.g.o(this.userTagViews.get(i3), false);
                    }
                    i3 = i16;
                }
                ImageView imageView2 = this.bgView;
                Intrinsics.checkNotNullExpressionValue(teamInfo, "teamInfo");
                imageView2.setBackgroundDrawable(S(Q(teamInfo, "i_bg")));
                this.bgView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CommonTeamMessageItemView.R(com.tencent.timi.game.tim.api.message.a.this, teamInfo, premadesTeamServerOuterClass$ShareYoloRoomMsg3, list, this, view2);
                    }
                });
                this.contentCl.setAlpha(1.0f);
                if (teamInfo.game_status.get() == 3) {
                    this.modeTv.setText("\u6e38\u620f\u4e2d");
                    fh4.g.o(this.gradeRangeTv, false);
                    this.bgView.setOnClickListener(null);
                    this.contentCl.setAlpha(0.5f);
                }
                if (msg2.m() != 1) {
                    this.contentCl.setAlpha(0.5f);
                    this.modeTv.setText("\u5df2\u89e3\u6563");
                    fh4.g.o(this.gradeRangeTv, false);
                    fh4.g.o(this.dividerView, false);
                    this.bgView.setOnClickListener(null);
                    for (TimiRoundImageView timiRoundImageView3 : this.avatarViews) {
                        timiRoundImageView3.setImageDrawable(null);
                        timiRoundImageView3.setBackgroundDrawable(S(Q(teamInfo, HippyReporter.RemoveEngineReason.INVALID)));
                    }
                    Iterator<T> it6 = this.userTagViews.iterator();
                    while (it6.hasNext()) {
                        fh4.g.o((ImageView) it6.next(), false);
                    }
                    Iterator<T> it7 = this.roadViews.iterator();
                    while (it7.hasNext()) {
                        ((TextView) it7.next()).setText("");
                    }
                    return;
                }
                return;
            }
        }
        z17 = false;
        fh4.g.o(view, z17);
        this.bgView.setOnTouchListener(getPositionOnTouchListener());
        this.bgView.setOnLongClickListener(getOnLongClickListner());
        fh4.g.o(this.giftView, premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.has());
        if (premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.has()) {
        }
        List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> userList2 = teamInfo.user_list.get();
        int i36 = 0;
        while (r2.hasNext()) {
        }
        ImageView imageView22 = this.bgView;
        Intrinsics.checkNotNullExpressionValue(teamInfo, "teamInfo");
        imageView22.setBackgroundDrawable(S(Q(teamInfo, "i_bg")));
        this.bgView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonTeamMessageItemView.R(com.tencent.timi.game.tim.api.message.a.this, teamInfo, premadesTeamServerOuterClass$ShareYoloRoomMsg3, list, this, view2);
            }
        });
        this.contentCl.setAlpha(1.0f);
        if (teamInfo.game_status.get() == 3) {
        }
        if (msg2.m() != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TeamInfoAutoUpdateService.h().l("chat_" + this.teamUpdateListener.hashCode(), this.teamUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TeamInfoAutoUpdateService.h().o("chat_" + this.teamUpdateListener.hashCode());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonTeamMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CommonTeamMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonTeamMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        List listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatarViews = new ArrayList();
        this.roadViews = new ArrayList();
        this.userTagViews = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.timi.game.component.chat.message.CommonTeamMessageItemView$maleDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(fh4.b.d(26));
                gradientDrawable.setStroke(fh4.b.b(1), Color.parseColor("#72CBFF"));
                return gradientDrawable;
            }
        });
        this.maleDrawable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.timi.game.component.chat.message.CommonTeamMessageItemView$femaleDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(fh4.b.d(26));
                gradientDrawable.setStroke(fh4.b.b(1), Color.parseColor("#FF74A0"));
                return gradientDrawable;
            }
        });
        this.femaleDrawable = lazy2;
        this.teamUpdateListener = new c();
        setContentView(R.layout.htr);
        View findViewById = findViewById(R.id.u7q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.contentCl)");
        this.contentCl = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(R.id.t67);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.bgView)");
        this.bgView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.zlz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.nameTv)");
        this.nameTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.zcr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.modeTv)");
        this.modeTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.lft);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.dividerView)");
        this.dividerView = findViewById5;
        View findViewById6 = findViewById(R.id.voz);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.giftView)");
        this.giftView = (TeamListGiftImageView) findViewById6;
        View findViewById7 = findViewById(R.id.vrl);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.gradeRangeTv)");
        this.gradeRangeTv = (TextView) findViewById7;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.a2y), Integer.valueOf(R.id.a2z), Integer.valueOf(R.id.f164541a30), Integer.valueOf(R.id.f164542t11), Integer.valueOf(R.id.f164543t12), Integer.valueOf(R.id.f164544t13)});
        int i16 = 0;
        for (Object obj : listOf) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) obj).intValue();
            ConstraintLayout constraintLayout = this.contentCl;
            TimiRoundImageView timiRoundImageView = new TimiRoundImageView(context);
            this.avatarViews.add(timiRoundImageView);
            timiRoundImageView.setPadding(fh4.b.b(1), fh4.b.b(1), fh4.b.b(1), fh4.b.b(1));
            timiRoundImageView.setId(intValue);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(fh4.b.b(24), fh4.b.b(24));
            layoutParams.topToTop = this.bgView.getId();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = fh4.b.b(53);
            layoutParams.horizontalChainStyle = 0;
            if (i16 == listOf.size() - 1) {
                layoutParams.rightToRight = this.bgView.getId();
                layoutParams.leftToRight = ((Number) listOf.get(i16 - 1)).intValue();
            } else if (i16 == 0) {
                layoutParams.leftToLeft = this.bgView.getId();
                layoutParams.rightToLeft = ((Number) listOf.get(i17)).intValue();
            } else {
                layoutParams.leftToRight = ((Number) listOf.get(i16 - 1)).intValue();
                layoutParams.rightToLeft = ((Number) listOf.get(i17)).intValue();
            }
            Unit unit = Unit.INSTANCE;
            constraintLayout.addView(timiRoundImageView, layoutParams);
            ConstraintLayout constraintLayout2 = this.contentCl;
            ImageView imageView = new ImageView(context);
            this.userTagViews.add(imageView);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(fh4.b.b(21), fh4.b.b(16));
            layoutParams2.leftToLeft = intValue;
            layoutParams2.bottomToBottom = intValue;
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = fh4.b.b(10);
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = fh4.b.b(15);
            constraintLayout2.addView(imageView, layoutParams2);
            ConstraintLayout constraintLayout3 = this.contentCl;
            TextView textView = new TextView(context);
            this.roadViews.add(textView);
            fh4.b.g(textView, 8.0f);
            textView.setTextColor(yn4.c.a(R.color.f158017al3));
            textView.setGravity(17);
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(fh4.b.b(24), fh4.b.b(17));
            layoutParams3.topToBottom = intValue;
            layoutParams3.leftToLeft = intValue;
            layoutParams3.rightToRight = intValue;
            constraintLayout3.addView(textView, layoutParams3);
            ConstraintLayout constraintLayout4 = this.contentCl;
            View view = new View(context);
            this.invalidMaskView = view;
            view.setVisibility(8);
            fh4.g.f(view, fh4.b.b(6), yn4.c.a(R.color.alb));
            constraintLayout4.addView(view, new ConstraintLayout.LayoutParams(fh4.b.e(this), fh4.b.e(this)));
            i16 = i17;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016JB\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/component/chat/message/CommonTeamMessageItemView$c", "Lcom/tencent/timi/game/teamlist/service/TeamInfoAutoUpdateService$b;", "", "", "b", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "d", "", "requestScene", "Ltrpc/yes/common/PremadesTeamServerOuterClass$ShareYoloRoomMsg;", "shareYoloRoomMsgList", "Ltrpc/yes/common/PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;", "teamList", "reqTeamIds", "", "a", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements TeamInfoAutoUpdateService.b {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        public void a(@Nullable String requestScene, @Nullable List<PremadesTeamServerOuterClass$ShareYoloRoomMsg> shareYoloRoomMsgList, @Nullable List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> teamList, @Nullable List<Long> reqTeamIds) {
            boolean z16;
            boolean z17;
            if (CommonTeamMessageItemView.this.getMsg() != null) {
                com.tencent.timi.game.tim.api.message.a msg2 = CommonTeamMessageItemView.this.getMsg();
                Intrinsics.checkNotNull(msg2);
                if (msg2.m() != 1) {
                    com.tencent.timi.game.tim.api.message.a msg3 = CommonTeamMessageItemView.this.getMsg();
                    Intrinsics.checkNotNull(msg3);
                    long j3 = msg3.a().share_yolo_room_msg.team_info.f437250id.get();
                    if (reqTeamIds != null && reqTeamIds.contains(Long.valueOf(j3))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg = null;
                        if (shareYoloRoomMsgList != null) {
                            Iterator<T> it = shareYoloRoomMsgList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                if (((PremadesTeamServerOuterClass$ShareYoloRoomMsg) next).room_info.room_id.get() == j3) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17) {
                                    premadesTeamServerOuterClass$ShareYoloRoomMsg = next;
                                    break;
                                }
                            }
                            premadesTeamServerOuterClass$ShareYoloRoomMsg = premadesTeamServerOuterClass$ShareYoloRoomMsg;
                        }
                        if (premadesTeamServerOuterClass$ShareYoloRoomMsg != null) {
                            if (premadesTeamServerOuterClass$ShareYoloRoomMsg.team_info.status.get() == 1) {
                                com.tencent.timi.game.tim.api.message.a msg4 = CommonTeamMessageItemView.this.getMsg();
                                if (msg4 != null) {
                                    msg4.e(premadesTeamServerOuterClass$ShareYoloRoomMsg);
                                }
                                com.tencent.timi.game.tim.api.message.a msg5 = CommonTeamMessageItemView.this.getMsg();
                                if (msg5 != null) {
                                    byte[] byteArray = premadesTeamServerOuterClass$ShareYoloRoomMsg.toByteArray();
                                    Intrinsics.checkNotNullExpressionValue(byteArray, "findResult.toByteArray()");
                                    msg5.k(new String(byteArray, Charsets.UTF_8));
                                }
                            } else {
                                com.tencent.timi.game.tim.api.message.a msg6 = CommonTeamMessageItemView.this.getMsg();
                                if (msg6 != null) {
                                    msg6.n(1);
                                }
                            }
                        } else {
                            com.tencent.timi.game.tim.api.message.a msg7 = CommonTeamMessageItemView.this.getMsg();
                            if (msg7 != null) {
                                msg7.n(1);
                            }
                        }
                        CommonTeamMessageItemView commonTeamMessageItemView = CommonTeamMessageItemView.this;
                        com.tencent.timi.game.tim.api.message.a msg8 = commonTeamMessageItemView.getMsg();
                        Intrinsics.checkNotNull(msg8);
                        commonTeamMessageItemView.I(msg8);
                    }
                }
            }
        }

        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        @NotNull
        public List<Long> b() {
            List<Long> mutableListOf;
            if (CommonTeamMessageItemView.this.getMsg() != null) {
                com.tencent.timi.game.tim.api.message.a msg2 = CommonTeamMessageItemView.this.getMsg();
                Intrinsics.checkNotNull(msg2);
                if (msg2.m() != 1) {
                    com.tencent.timi.game.tim.api.message.a msg3 = CommonTeamMessageItemView.this.getMsg();
                    Intrinsics.checkNotNull(msg3);
                    if (msg3.a().share_yolo_room_msg.team_info.status.get() == 1) {
                        com.tencent.timi.game.tim.api.message.a msg4 = CommonTeamMessageItemView.this.getMsg();
                        Intrinsics.checkNotNull(msg4);
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(msg4.a().share_yolo_room_msg.team_info.f437250id.get()));
                        return mutableListOf;
                    }
                }
            }
            return new ArrayList();
        }

        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        @NotNull
        public List<CommonOuterClass$QQUserId> d() {
            return new ArrayList();
        }

        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        public void c() {
        }
    }
}
