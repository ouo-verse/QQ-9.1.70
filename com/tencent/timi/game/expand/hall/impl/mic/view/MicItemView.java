package com.tencent.timi.game.expand.hall.impl.mic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.expand.hall.impl.mic.view.MicItemView;
import com.tencent.timi.game.team.impl.team.MicWaveViewLottie;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.m;
import gh4.d;
import gh4.e;
import gh4.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import nr2.bg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ph4.g;
import th4.i;
import th4.k;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import ug4.b;
import ul4.q;
import wf4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\r\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J,\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011J\u0006\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0016\u0010\u0017\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0018j\b\u0012\u0004\u0012\u00020\u000f`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/mic/view/MicItemView;", "Landroid/widget/FrameLayout;", "", "", "g", "l", "i", DomainData.DOMAIN_NAME, "j", "", h.F, "", "roomId", "", "position", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "speakingPosInfo", "", "speakingPosInfoList", "f", "e", "d", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "mSpeakingPosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mSpeakingPosInfoList", "I", "mPos", "J", "mRoomId", "Lnr2/bg;", "Lnr2/bg;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MicItemView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private YoloRoomOuterClass$YoloRoomSpeakingPosInfo mSpeakingPosInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> mSpeakingPosInfoList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mPos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bg binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/expand/hall/impl/mic/view/MicItemView$c", "Lph4/h;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "c", "", "errorCode", "", "errorMessage", "onError", "", "permissionEnable", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements ph4.h {
        c() {
        }

        @Override // nl4.a
        public void a(boolean permissionEnable) {
            a.f445618a.c(MicItemView.this.getContext());
            l.b("MicItemView_", "doOnMic onChecked" + permissionEnable);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            a.f445618a.a(MicItemView.this.getContext());
            l.b("MicItemView_", "doOnMic onSuccess");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            a.f445618a.a(MicItemView.this.getContext());
            QQToast.makeText(MicItemView.this.getContext(), errorMessage, 0).show();
            l.b("MicItemView_", "doOnMic onError");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g() {
        if (this.mSpeakingPosInfo.user_id.yes_uid.get() == 0) {
            i();
        } else {
            l();
        }
    }

    private final boolean h() {
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it = this.mSpeakingPosInfoList.iterator();
        while (it.hasNext()) {
            if (ll4.b.a(it.next().user_id, E)) {
                return true;
            }
        }
        return false;
    }

    private final void i() {
        e I0 = ((f) mm4.b.b(f.class)).I0();
        if (I0 == null) {
            l.e("MicItemView_", "showEmptyMicUI currentHall is null!");
            return;
        }
        this.binding.f421028c.setVisibility(4);
        this.binding.f421027b.g();
        this.binding.f421027b.setVisibility(4);
        this.binding.f421032g.setVisibility(4);
        this.binding.f421031f.setVisibility(4);
        this.binding.f421030e.setVisibility(0);
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(I0.O().f376303f);
        Intrinsics.checkNotNullExpressionValue(l16, "getService(IGameConfigSe\u2026fo(launchParam.yesGameId)");
        i iVar = i.f436350a;
        String str = l16.room_info.mic_card_config.icon_mic_empty.get();
        URLImageView uRLImageView = this.binding.f421030e;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.userAvatarEmptyHintView");
        iVar.e(str, uRLImageView);
        String str2 = l16.room_info.mic_card_config.color_mic_item_nick_name.get();
        Intrinsics.checkNotNullExpressionValue(str2, "gameConfigInfo.room_info\u2026_mic_item_nick_name.get()");
        TextView textView = this.binding.f421029d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.onMicHintTxv");
        iVar.d(str2, textView);
        if (I0.w1()) {
            n();
        } else {
            j();
        }
        d mReporterHelper = I0.getMReporterHelper();
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        URLImageView uRLImageView2 = this.binding.f421030e;
        Intrinsics.checkNotNullExpressionValue(uRLImageView2, "binding.userAvatarEmptyHintView");
        bVar.b(uRLImageView2, mReporterHelper.C(), mReporterHelper.D());
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        URLImageView uRLImageView3 = this.binding.f421030e;
        Intrinsics.checkNotNullExpressionValue(uRLImageView3, "binding.userAvatarEmptyHintView");
        b.a.a((ug4.b) b16, uRLImageView3, false, null, mReporterHelper.v(), mReporterHelper.E(), 6, null);
    }

    private final void j() {
        this.binding.f421029d.setVisibility(4);
        this.binding.f421030e.setOnClickListener(new View.OnClickListener() { // from class: qh4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicItemView.k(MicItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MicItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.h()) {
            com.tencent.timi.game.ui.widget.f.c("\u4f60\u5df2\u7ecf\u5728\u9ea6\u4e0a");
        } else if (!m.a().b()) {
            com.tencent.timi.game.ui.widget.f.d(true, "\u7f51\u7edc\u51fa\u73b0\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u3002");
        } else {
            long h16 = ((ll4.a) mm4.b.b(ll4.a.class)).h();
            b bVar = new b();
            ph4.e eVar = ph4.e.f426246a;
            long j3 = this$0.mRoomId;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            eVar.E(j3, context, h16, bVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l() {
        boolean z16;
        e I0 = ((f) mm4.b.b(f.class)).I0();
        if (I0 == null) {
            l.e("MicItemView_", "showOnMicUI currentHall is null!");
            return;
        }
        d mReporterHelper = I0.getMReporterHelper();
        this.binding.f421029d.setVisibility(4);
        this.binding.f421030e.setVisibility(4);
        final CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.mSpeakingPosInfo.user_id;
        int i3 = 0;
        this.binding.f421031f.setVisibility(0);
        this.binding.f421031f.setUserId(commonOuterClass$QQUserId);
        this.binding.f421031f.setOnClickListener(new View.OnClickListener() { // from class: qh4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicItemView.m(CommonOuterClass$QQUserId.this, view);
            }
        });
        if (mReporterHelper != null) {
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            AvatarRoundImageView avatarRoundImageView = this.binding.f421031f;
            Intrinsics.checkNotNullExpressionValue(avatarRoundImageView, "binding.userAvatarView");
            bVar.b(avatarRoundImageView, mReporterHelper.C(), mReporterHelper.D());
            HashMap<String, String> E = mReporterHelper.E();
            E.put("yes_to_uid", String.valueOf(this.mSpeakingPosInfo.user_id.uid.get()));
            E.put("yes_to_yes_uid", nn4.a.a(this.mSpeakingPosInfo.user_id.yes_uid.get()));
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            AvatarRoundImageView avatarRoundImageView2 = this.binding.f421031f;
            Intrinsics.checkNotNullExpressionValue(avatarRoundImageView2, "binding.userAvatarView");
            b.a.a((ug4.b) b16, avatarRoundImageView2, false, null, mReporterHelper.w(), E, 6, null);
        }
        this.binding.f421032g.setVisibility(0);
        this.binding.f421032g.setUserId(commonOuterClass$QQUserId);
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(I0.O().f376303f);
        Intrinsics.checkNotNullExpressionValue(l16, "getService(IGameConfigSe\u2026fo(launchParam.yesGameId)");
        i iVar = i.f436350a;
        String str = l16.room_info.mic_card_config.color_mic_item_nick_name.get();
        Intrinsics.checkNotNullExpressionValue(str, "gameConfigInfo.room_info\u2026_mic_item_nick_name.get()");
        AvatarTextView avatarTextView = this.binding.f421032g;
        Intrinsics.checkNotNullExpressionValue(avatarTextView, "binding.userNickNameTxv");
        iVar.d(str, avatarTextView);
        this.binding.f421027b.setVisibility(0);
        if (this.mSpeakingPosInfo.voice_switch.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        l.b("MicItemView_", "micEnableInInfo " + z16 + ", uin:" + MobileQQ.getShortUinStr(String.valueOf(this.mSpeakingPosInfo.user_id.yes_uid.get())));
        boolean z17 = this.mSpeakingPosInfo.yolo_room_user_white_list.get().is_community_host.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isHost:");
        sb5.append(z17);
        l.b("MicItemView_", sb5.toString());
        this.binding.f421027b.m(z17);
        this.binding.f421027b.g();
        this.binding.f421027b.setData(commonOuterClass$QQUserId, z16);
        this.binding.f421028c.setUserId(commonOuterClass$QQUserId);
        MicWaveViewLottie micWaveViewLottie = this.binding.f421028c;
        if (this.mSpeakingPosInfo.voice_switch.get() != 1) {
            i3 = 8;
        }
        micWaveViewLottie.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(CommonOuterClass$QQUserId qqUserId, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        e I0 = ((f) mm4.b.b(f.class)).I0();
        if (I0 == null) {
            l.e("MicItemView_", "userAvatarView#OnClick currentHall is null!");
        } else {
            k kVar = k.f436355a;
            QBaseActivity b16 = vf4.a.b();
            Intrinsics.checkNotNullExpressionValue(b16, "getTopQActivity()");
            Intrinsics.checkNotNullExpressionValue(qqUserId, "qqUserId");
            sl4.a e16 = kVar.e(b16, qqUserId, I0.getMRoomIdFromServer());
            if (e16 instanceof q) {
                ((q) e16).w1(true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n() {
        this.binding.f421029d.setVisibility(4);
        this.binding.f421030e.setOnClickListener(new View.OnClickListener() { // from class: qh4.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicItemView.o(MicItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MicItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.h()) {
            com.tencent.timi.game.ui.widget.f.c("\u4f60\u5df2\u7ecf\u5728\u9ea6\u4e0a");
        } else if (!m.a().b()) {
            com.tencent.timi.game.ui.widget.f.d(true, "\u7f51\u7edc\u51fa\u73b0\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u3002");
        } else {
            g.f426260a.b(this$0.mPos, this$0.mRoomId, false, new c());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void d() {
        ll4.b.a(((ll4.a) mm4.b.b(ll4.a.class)).E(), this.mSpeakingPosInfo.user_id);
    }

    public final void e() {
        l.b("MicItemView_", "playWaveAnimation  mSpeakingPosInfo.yesuid.get():" + this.mSpeakingPosInfo.user_id.yes_uid.get());
        this.binding.f421028c.j();
    }

    public final void f(long roomId, int position, @NotNull YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @NotNull List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> speakingPosInfoList) {
        Intrinsics.checkNotNullParameter(speakingPosInfo, "speakingPosInfo");
        Intrinsics.checkNotNullParameter(speakingPosInfoList, "speakingPosInfoList");
        this.mSpeakingPosInfo = speakingPosInfo;
        this.mSpeakingPosInfoList.clear();
        this.mSpeakingPosInfoList.addAll(speakingPosInfoList);
        this.mRoomId = roomId;
        this.mPos = position;
        g();
        ph4.e.f426246a.S(this.mRoomId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSpeakingPosInfo = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
        this.mSpeakingPosInfoList = new ArrayList<>();
        bg g16 = bg.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        i();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/expand/hall/impl/mic/view/MicItemView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            QQToast.makeText(MicItemView.this.getContext(), "\u7533\u8bf7\u6210\u529f\uff0c\u7b49\u5f85\u4e3b\u6301\u4eba\u5ba1\u6838", 0).show();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
        }
    }
}
