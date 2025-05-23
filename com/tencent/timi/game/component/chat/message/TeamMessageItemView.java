package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
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
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import nr2.ax;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamIcon;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaGameDataInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001?\u0018\u0000 K2\u00020\u0001:\u0001LB'\b\u0007\u0012\u0006\u0010D\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010H\u001a\u00020G\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0013\u001a\u00020\fH\u0014J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u001b\u0010/\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(R\u001b\u00102\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u0010(R\u001b\u00105\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010&\u001a\u0004\b4\u0010(R#\u0010;\u001a\n 7*\u0004\u0018\u000106068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010&\u001a\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006M"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/TeamMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Landroid/graphics/drawable/GradientDrawable;", "b0", "", "url", "Landroid/graphics/drawable/Drawable;", "P", "X", "a0", "", "show", "", "Z", "Ltrpc/yes/common/PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;", "teamInfo", "key", "W", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "I", "", "Landroid/widget/ImageView;", "f0", "Ljava/util/List;", "avatarViews", "Landroid/widget/TextView;", "g0", "roadViews", "h0", "userTagViews", "Lnr2/ax;", "i0", "Lnr2/ax;", "binding", "j0", "Lkotlin/Lazy;", "U", "()Landroid/graphics/drawable/GradientDrawable;", "maleDrawable", "k0", BdhLogUtil.LogTag.Tag_Req, "femaleDrawable", "l0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "blueDefaultDrawable", "m0", "V", "orangeDefaultDrawable", "n0", ExifInterface.LATITUDE_SOUTH, "grayDefaultDrawable", "Lcom/tencent/image/URLDrawable;", "kotlin.jvm.PlatformType", "o0", "T", "()Lcom/tencent/image/URLDrawable;", "grayDrawable", "p0", "Landroid/graphics/drawable/GradientDrawable;", "modeBgDrawable", "com/tencent/timi/game/component/chat/message/TeamMessageItemView$c", "q0", "Lcom/tencent/timi/game/component/chat/message/TeamMessageItemView$c;", "teamUpdateListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "r0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TeamMessageItemView extends BaseMessageView {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends ImageView> avatarViews;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends TextView> roadViews;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends ImageView> userTagViews;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ax binding;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy maleDrawable;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy femaleDrawable;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy blueDefaultDrawable;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy orangeDefaultDrawable;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy grayDefaultDrawable;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy grayDrawable;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GradientDrawable modeBgDrawable;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c teamUpdateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/TeamMessageItemView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376581a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TeamMessageItemView f376582b;

        b(com.tencent.timi.game.tim.api.message.a aVar, TeamMessageItemView teamMessageItemView) {
            this.f376581a = aVar;
            this.f376582b = teamMessageItemView;
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
                this.f376581a.n(1);
                this.f376582b.I(this.f376581a);
            }
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.d((ug4.b) b16, "ev_smoba_team_join_fail", null, 2, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamMessageItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable P(String url) {
        boolean isBlank;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = Q();
        obtain.mFailedDrawable = Q();
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            return Q();
        }
        return ((ei4.a) mm4.b.b(ei4.a.class)).m(url, obtain);
    }

    private final GradientDrawable Q() {
        return (GradientDrawable) this.blueDefaultDrawable.getValue();
    }

    private final GradientDrawable R() {
        return (GradientDrawable) this.femaleDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GradientDrawable S() {
        return (GradientDrawable) this.grayDefaultDrawable.getValue();
    }

    private final URLDrawable T() {
        return (URLDrawable) this.grayDrawable.getValue();
    }

    private final GradientDrawable U() {
        return (GradientDrawable) this.maleDrawable.getValue();
    }

    private final GradientDrawable V() {
        return (GradientDrawable) this.orangeDefaultDrawable.getValue();
    }

    private final String W(PremadesTeamServerOuterClass$YesGamePremadesTeamInfo teamInfo, String key) {
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

    private final Drawable X(String url) {
        boolean isBlank;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = V();
        obtain.mFailedDrawable = V();
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            return V();
        }
        return ((ei4.a) mm4.b.b(ei4.a.class)).m(url, obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(com.tencent.timi.game.tim.api.message.a msg2, boolean z16, PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo, PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg, Ref.IntRef gameMode, List list, TeamMessageItemView this$0, View view) {
        long j3;
        ExpandHallLaunchParam expandHallLaunchParam;
        PBUInt64Field pBUInt64Field;
        int i3;
        PBInt32Field pBInt32Field;
        gh4.d mReporterHelper;
        PBUInt64Field pBUInt64Field2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(gameMode, "$gameMode");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.f("team_msg_click_" + msg2.id(), 300L)) {
            YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
            if (j06 != null && (pBUInt64Field2 = j06.room_id) != null) {
                j3 = pBUInt64Field2.get();
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
            if (z16) {
                pBUInt64Field = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.f437250id;
            } else {
                pBUInt64Field = premadesTeamServerOuterClass$ShareYoloRoomMsg.room_info.room_id;
            }
            dVar.f379324a = pBUInt64Field.get();
            if (expandHallLaunchParam != null) {
                i3 = com.tencent.timi.game.utils.b.h(expandHallLaunchParam.f376301d);
            } else {
                i3 = 1;
            }
            dVar.f379325b = i3;
            dVar.f379326c = 1;
            if (z16) {
                pBInt32Field = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.type;
            } else {
                pBInt32Field = premadesTeamServerOuterClass$ShareYoloRoomMsg.room_info.room_type;
            }
            dVar.f379328e = pBInt32Field.get();
            dVar.f379329f = cVar;
            dVar.f379327d = ((fm4.g) mm4.b.b(fm4.g.class)).h2(premadesTeamServerOuterClass$ShareYoloRoomMsg.room_info.room_type.get());
            dVar.f379330g = j3;
            dVar.f379331h = 0L;
            com.tencent.timi.game.room.impl.util.c cVar2 = new com.tencent.timi.game.room.impl.util.c();
            cVar2.f379322a = gameMode.element;
            cVar2.f379323b = list;
            ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, vf4.a.b(), dVar, cVar2, new b(msg2, this$0));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Z(boolean show) {
        TimiRoundImageView timiRoundImageView = this.binding.f420929e;
        Intrinsics.checkNotNullExpressionValue(timiRoundImageView, "binding.avatarView4");
        fh4.g.o(timiRoundImageView, show);
        TimiRoundImageView timiRoundImageView2 = this.binding.f420930f;
        Intrinsics.checkNotNullExpressionValue(timiRoundImageView2, "binding.avatarView5");
        fh4.g.o(timiRoundImageView2, show);
        TextView textView = this.binding.f420941q;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.roadView4");
        fh4.g.o(textView, show);
        TextView textView2 = this.binding.f420942r;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.roadView5");
        fh4.g.o(textView2, show);
        ImageView imageView = this.binding.f420948x;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.userTagIv4");
        fh4.g.o(imageView, show);
        ImageView imageView2 = this.binding.f420949y;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.userTagIv5");
        fh4.g.o(imageView2, show);
    }

    private final Drawable a0(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = b0();
        obtain.mFailedDrawable = b0();
        return ((ei4.a) mm4.b.b(ei4.a.class)).m(url, obtain);
    }

    private final GradientDrawable b0() {
        return new GradientDrawable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg2;
        final PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg3;
        String str2;
        Iterable withIndex;
        Iterator it;
        Object obj;
        boolean z17;
        GradientDrawable U;
        Iterable<IndexedValue> withIndex2;
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
                            PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg4 = new PremadesTeamServerOuterClass$ShareYoloRoomMsg();
                            String p17 = msg2.p();
                            if (p17 != null) {
                                bArr = p17.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                            } else {
                                bArr = null;
                            }
                            premadesTeamServerOuterClass$ShareYoloRoomMsg = premadesTeamServerOuterClass$ShareYoloRoomMsg4.mergeFrom(bArr);
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
        PremadesTeamServerOuterClass$ShareYoloRoomMsg premadesTeamServerOuterClass$ShareYoloRoomMsg5 = premadesTeamServerOuterClass$ShareYoloRoomMsg;
        msg2.e(premadesTeamServerOuterClass$ShareYoloRoomMsg5);
        final boolean has = premadesTeamServerOuterClass$ShareYoloRoomMsg5.team_info.has();
        YoloRoomOuterClass$YoloSmobaGameDataInfo yoloRoomOuterClass$YoloSmobaGameDataInfo = premadesTeamServerOuterClass$ShareYoloRoomMsg5.room_info.game_data_info.smoba_game_data_info;
        final PremadesTeamServerOuterClass$YesGamePremadesTeamInfo teamInfo = premadesTeamServerOuterClass$ShareYoloRoomMsg5.team_info.get();
        final List<Integer> list = (has ? teamInfo.grade_list : yoloRoomOuterClass$YoloSmobaGameDataInfo.grade_list).get();
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = premadesTeamServerOuterClass$ShareYoloRoomMsg5.room_info;
        List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> list2 = teamInfo.user_list.get();
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
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo) it5.next()).role_achievement.get(0).type);
        }
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        ug4.b bVar = (ug4.b) b16;
        ImageView imageView = this.binding.f420931g;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.bgView");
        String id5 = msg2.id();
        ConcurrentHashMap<String, String> M = YoloRoomUtil.M(yoloRoomOuterClass$YoloRoomInfo);
        M.putAll(YoloRoomUtil.L(getRoomInfo()));
        if (msg2.m() == 1) {
            str = "2";
        } else {
            str = teamInfo.game_status.get() == 3 ? "1" : "0";
        }
        M.put("yes_team_status", str);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, new Function1<PBInt32Field, CharSequence>() { // from class: com.tencent.timi.game.component.chat.message.TeamMessageItemView$renderUI$1$1$membetTags$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(PBInt32Field pBInt32Field) {
                return String.valueOf(pBInt32Field.get());
            }
        }, 30, null);
        M.put("yes_member_tag_id", joinToString$default);
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null || (mReporterHelper = I0.getMReporterHelper()) == null) {
            premadesTeamServerOuterClass$ShareYoloRoomMsg2 = premadesTeamServerOuterClass$ShareYoloRoomMsg5;
        } else {
            premadesTeamServerOuterClass$ShareYoloRoomMsg2 = premadesTeamServerOuterClass$ShareYoloRoomMsg5;
            mReporterHelper.Z(yoloRoomOuterClass$YoloRoomInfo.room_id.get(), joinToString$default);
        }
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(M, "getCommonTeamInfoReportP\u2026gs)\n                    }");
        b.a.a(bVar, imageView, false, id5, "em_yes_chat_join_team", M, 2, null);
        TextView textView = this.binding.f420937m;
        if (has) {
            str2 = teamInfo.name.get();
            premadesTeamServerOuterClass$ShareYoloRoomMsg3 = premadesTeamServerOuterClass$ShareYoloRoomMsg2;
        } else {
            premadesTeamServerOuterClass$ShareYoloRoomMsg3 = premadesTeamServerOuterClass$ShareYoloRoomMsg2;
            str2 = premadesTeamServerOuterClass$ShareYoloRoomMsg3.room_info.introduce.get();
        }
        textView.setText(str2);
        this.binding.f420936l.setText((has ? teamInfo.game_mode_name : yoloRoomOuterClass$YoloSmobaGameDataInfo.mode_name).get());
        this.binding.f420934j.setText(((pm4.a) mm4.b.b(pm4.a.class)).W2(list));
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        final Ref.IntRef intRef = new Ref.IntRef();
        int i3 = (has ? premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.game_mode : yoloRoomOuterClass$YoloSmobaGameDataInfo.game_mode).get();
        intRef.element = i3;
        if (i3 == 1) {
            arrayList3.addAll(this.avatarViews.subList(0, 3));
            arrayList4.addAll(this.roadViews.subList(0, 3));
            arrayList5.addAll(this.userTagViews.subList(0, 3));
            Z(false);
        } else if (i3 != 2) {
            Z(true);
            arrayList3.addAll(this.avatarViews);
            arrayList4.addAll(this.roadViews);
            arrayList5.addAll(this.userTagViews);
        } else {
            Z(true);
            arrayList3.addAll(this.avatarViews);
            arrayList4.addAll(this.roadViews);
            arrayList5.addAll(this.userTagViews);
        }
        this.binding.f420931g.setOnTouchListener(getPositionOnTouchListener());
        this.binding.f420931g.setOnLongClickListener(getOnLongClickListner());
        if (msg2.m() == 1) {
            this.binding.f420931g.setBackgroundDrawable(T());
            this.binding.f420931g.setOnClickListener(null);
            this.binding.f420943s.setText("\u5df2\u89e3\u6563");
            withIndex2 = CollectionsKt___CollectionsKt.withIndex(arrayList3);
            for (IndexedValue indexedValue : withIndex2) {
                ((ImageView) indexedValue.getValue()).setBackgroundDrawable(yn4.c.b(R.drawable.o_q));
                ((ImageView) indexedValue.getValue()).setImageDrawable(b0());
            }
            Iterator it6 = arrayList4.iterator();
            while (it6.hasNext()) {
                ((TextView) it6.next()).setText("");
            }
            Iterator it7 = arrayList5.iterator();
            while (it7.hasNext()) {
                ((ImageView) it7.next()).setImageResource(0);
            }
            ImageView imageView2 = this.binding.f420932h;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.enterRoomArrow");
            fh4.g.o(imageView2, false);
            this.modeBgDrawable.setColor(Color.parseColor("#A8A8A8"));
            this.binding.f420935k.setImageDrawable(this.modeBgDrawable);
            TeamListGiftImageView teamListGiftImageView = this.binding.f420933i;
            Intrinsics.checkNotNullExpressionValue(teamListGiftImageView, "binding.giftView");
            fh4.g.o(teamListGiftImageView, false);
            return;
        }
        TeamListGiftImageView teamListGiftImageView2 = this.binding.f420933i;
        Intrinsics.checkNotNullExpressionValue(teamListGiftImageView2, "binding.giftView");
        fh4.g.o(teamListGiftImageView2, premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.has());
        if (premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.has()) {
            this.binding.f420933i.setGiftInfo(premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.gift_num.get(), premadesTeamServerOuterClass$ShareYoloRoomMsg3.team_info.gift_config.gift_material_id.get());
        }
        this.binding.f420943s.setText(teamInfo.game_status.get() == 3 ? "\u6e38\u620f\u4e2d" : "\u7acb\u5373\u4e0a\u8f66");
        ImageView imageView3 = this.binding.f420932h;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.enterRoomArrow");
        fh4.g.o(imageView3, true);
        withIndex = CollectionsKt___CollectionsKt.withIndex(arrayList3);
        Iterator it8 = withIndex.iterator();
        while (it8.hasNext()) {
            IndexedValue indexedValue2 = (IndexedValue) it8.next();
            List<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> userList = teamInfo.user_list.get();
            Intrinsics.checkNotNullExpressionValue(userList, "userList");
            Iterator<T> it9 = userList.iterator();
            while (true) {
                if (!it9.hasNext()) {
                    it = it8;
                    obj = null;
                    break;
                } else {
                    obj = it9.next();
                    it = it8;
                    if (((PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo) obj).pos.get() == indexedValue2.getIndex() + 1) {
                        break;
                    } else {
                        it8 = it;
                    }
                }
            }
            PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2 = (PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo) obj;
            if (premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2 != null && premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.uid.get() != 0) {
                ImageView imageView4 = (ImageView) indexedValue2.getValue();
                int i16 = premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.gender.get();
                if (i16 == 1) {
                    U = U();
                } else if (i16 != 2) {
                    U = b0();
                } else {
                    U = R();
                }
                imageView4.setBackgroundDrawable(U);
                ((ImageView) indexedValue2.getValue()).setImageDrawable(gn4.c.b(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.avatar.get(), yn4.c.b(R.drawable.ovb), 24.0f, 24.0f));
                ((TextView) arrayList4.get(indexedValue2.getIndex())).setText(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.lane_type_desc.get());
                if (!premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.role_achievement.isEmpty()) {
                    fh4.g.o((View) arrayList5.get(indexedValue2.getIndex()), true);
                    ((ImageView) arrayList5.get(indexedValue2.getIndex())).setImageDrawable(gn4.c.b(premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.role_achievement.get(0).icon.get(), null, 16.0f, 12.0f));
                    z17 = false;
                } else {
                    fh4.g.o((View) arrayList5.get(indexedValue2.getIndex()), false);
                    z17 = false;
                }
                ((ImageView) indexedValue2.getValue()).setClickable(z17);
                it8 = it;
            }
            if (premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2 != null && premadesTeamServerOuterClass$YesGamePremadesTeamUserInfo2.status.get() != 0) {
                ((ImageView) indexedValue2.getValue()).setImageDrawable(b0());
                ImageView imageView5 = (ImageView) indexedValue2.getValue();
                Intrinsics.checkNotNullExpressionValue(teamInfo, "teamInfo");
                imageView5.setBackgroundDrawable(a0(W(teamInfo, "lock_icon")));
            } else {
                ((ImageView) indexedValue2.getValue()).setImageDrawable(b0());
                ImageView imageView6 = (ImageView) indexedValue2.getValue();
                Intrinsics.checkNotNullExpressionValue(teamInfo, "teamInfo");
                imageView6.setBackgroundDrawable(a0(W(teamInfo, "add_icon")));
            }
            ((TextView) arrayList4.get(indexedValue2.getIndex())).setText("");
            z17 = false;
            fh4.g.o((View) arrayList5.get(indexedValue2.getIndex()), false);
            ((ImageView) indexedValue2.getValue()).setClickable(z17);
            it8 = it;
        }
        ImageView imageView7 = this.binding.f420935k;
        Intrinsics.checkNotNullExpressionValue(teamInfo, "teamInfo");
        imageView7.setImageDrawable(a0(W(teamInfo, "tag_icon")));
        int i17 = intRef.element;
        if (i17 == 1) {
            this.binding.f420931g.setBackgroundDrawable(X(W(teamInfo, "n_i_bg")));
        } else if (i17 != 2) {
            this.binding.f420931g.setBackgroundDrawable(P(W(teamInfo, "n_i_bg")));
        } else {
            this.binding.f420931g.setBackgroundDrawable(X(W(teamInfo, "n_i_bg")));
        }
        this.binding.f420931g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.at
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamMessageItemView.Y(com.tencent.timi.game.tim.api.message.a.this, has, teamInfo, premadesTeamServerOuterClass$ShareYoloRoomMsg3, intRef, list, this, view);
            }
        });
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
    public TeamMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TeamMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        List<? extends ImageView> listOf;
        List<? extends TextView> listOf2;
        List<? extends ImageView> listOf3;
        Intrinsics.checkNotNullParameter(context, "context");
        ax g16 = ax.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.timi.game.component.chat.message.TeamMessageItemView$maleDrawable$2
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
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.timi.game.component.chat.message.TeamMessageItemView$femaleDrawable$2
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
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.timi.game.component.chat.message.TeamMessageItemView$blueDefaultDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#7F9BF5"), Color.parseColor("#B27DF9")});
                gradientDrawable.setCornerRadius(fh4.b.d(15));
                return gradientDrawable;
            }
        });
        this.blueDefaultDrawable = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.timi.game.component.chat.message.TeamMessageItemView$orangeDefaultDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#FFAA2F"), Color.parseColor("#F969AB")});
                gradientDrawable.setCornerRadius(fh4.b.d(15));
                return gradientDrawable;
            }
        });
        this.orangeDefaultDrawable = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.timi.game.component.chat.message.TeamMessageItemView$grayDefaultDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#BEBEBE"), Color.parseColor("#BEBEBE")});
                gradientDrawable.setCornerRadius(fh4.b.d(15));
                return gradientDrawable;
            }
        });
        this.grayDefaultDrawable = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<URLDrawable>() { // from class: com.tencent.timi.game.component.chat.message.TeamMessageItemView$grayDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final URLDrawable invoke() {
                GradientDrawable S;
                GradientDrawable S2;
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                S = TeamMessageItemView.this.S();
                obtain.mLoadingDrawable = S;
                S2 = TeamMessageItemView.this.S();
                obtain.mFailedDrawable = S2;
                return ((ei4.a) mm4.b.b(ei4.a.class)).m("https://cdn.yes.qq.com/smoba/team/tg_team_msg_gray_bg1.png", obtain);
            }
        });
        this.grayDrawable = lazy6;
        this.modeBgDrawable = fh4.g.e(new GradientDrawable(), fh4.b.d(6), fh4.b.d(1), fh4.b.d(1), fh4.b.d(6));
        this.teamUpdateListener = new c();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TimiRoundImageView[]{g16.f420926b, g16.f420927c, g16.f420928d, g16.f420929e, g16.f420930f});
        this.avatarViews = listOf;
        TextView textView = g16.f420938n;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.roadView1");
        TextView textView2 = g16.f420939o;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.roadView2");
        TextView textView3 = g16.f420940p;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.roadView3");
        TextView textView4 = g16.f420941q;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.roadView4");
        TextView textView5 = g16.f420942r;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.roadView5");
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new TextView[]{textView, textView2, textView3, textView4, textView5});
        this.roadViews = listOf2;
        ImageView imageView = g16.f420945u;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.userTagIv1");
        ImageView imageView2 = g16.f420946v;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.userTagIv2");
        ImageView imageView3 = g16.f420947w;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.userTagIv3");
        ImageView imageView4 = g16.f420948x;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.userTagIv4");
        ImageView imageView5 = g16.f420949y;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.userTagIv5");
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5});
        this.userTagViews = listOf3;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016JB\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/component/chat/message/TeamMessageItemView$c", "Lcom/tencent/timi/game/teamlist/service/TeamInfoAutoUpdateService$b;", "", "", "b", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "d", "", "requestScene", "Ltrpc/yes/common/PremadesTeamServerOuterClass$ShareYoloRoomMsg;", "shareYoloRoomMsgList", "Ltrpc/yes/common/PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;", "teamList", "reqTeamIds", "", "a", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements TeamInfoAutoUpdateService.b {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        public void a(@Nullable String requestScene, @Nullable List<PremadesTeamServerOuterClass$ShareYoloRoomMsg> shareYoloRoomMsgList, @Nullable List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> teamList, @Nullable List<Long> reqTeamIds) {
            boolean z16;
            boolean z17;
            if (TeamMessageItemView.this.getMsg() != null) {
                com.tencent.timi.game.tim.api.message.a msg2 = TeamMessageItemView.this.getMsg();
                Intrinsics.checkNotNull(msg2);
                if (msg2.m() != 1) {
                    com.tencent.timi.game.tim.api.message.a msg3 = TeamMessageItemView.this.getMsg();
                    Intrinsics.checkNotNull(msg3);
                    long j3 = msg3.a().share_yolo_room_msg.room_info.room_id.get();
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
                                com.tencent.timi.game.tim.api.message.a msg4 = TeamMessageItemView.this.getMsg();
                                if (msg4 != null) {
                                    msg4.e(premadesTeamServerOuterClass$ShareYoloRoomMsg);
                                }
                                com.tencent.timi.game.tim.api.message.a msg5 = TeamMessageItemView.this.getMsg();
                                if (msg5 != null) {
                                    byte[] byteArray = premadesTeamServerOuterClass$ShareYoloRoomMsg.toByteArray();
                                    Intrinsics.checkNotNullExpressionValue(byteArray, "findResult.toByteArray()");
                                    msg5.k(new String(byteArray, Charsets.UTF_8));
                                }
                            } else {
                                com.tencent.timi.game.tim.api.message.a msg6 = TeamMessageItemView.this.getMsg();
                                if (msg6 != null) {
                                    msg6.n(1);
                                }
                            }
                        } else {
                            com.tencent.timi.game.tim.api.message.a msg7 = TeamMessageItemView.this.getMsg();
                            if (msg7 != null) {
                                msg7.n(1);
                            }
                        }
                        TeamMessageItemView teamMessageItemView = TeamMessageItemView.this;
                        com.tencent.timi.game.tim.api.message.a msg8 = teamMessageItemView.getMsg();
                        Intrinsics.checkNotNull(msg8);
                        teamMessageItemView.I(msg8);
                    }
                }
            }
        }

        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        @NotNull
        public List<Long> b() {
            List<Long> mutableListOf;
            if (TeamMessageItemView.this.getMsg() != null) {
                com.tencent.timi.game.tim.api.message.a msg2 = TeamMessageItemView.this.getMsg();
                Intrinsics.checkNotNull(msg2);
                if (msg2.m() != 1) {
                    com.tencent.timi.game.tim.api.message.a msg3 = TeamMessageItemView.this.getMsg();
                    Intrinsics.checkNotNull(msg3);
                    if (msg3.a().share_yolo_room_msg.room_info.status.get() == 1) {
                        com.tencent.timi.game.tim.api.message.a msg4 = TeamMessageItemView.this.getMsg();
                        Intrinsics.checkNotNull(msg4);
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(msg4.a().share_yolo_room_msg.room_info.room_id.get()));
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
