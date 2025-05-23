package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bo4.f;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.ba;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.profile.impl.view.ProfileItemInTeamView;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.widget.MediumBoldTextView;
import fh4.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr2.al;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import tl.h;
import trpc.yes.common.CommonOuterClass$OnlineRouteInfo;
import trpc.yes.common.CommonOuterClass$OnlineRouteInfoList;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$UserOnlineRouteInfoList;
import ul4.r;
import wn4.a;

@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001J\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u00a2\u0006\u0004\bP\u0010QB\u001d\b\u0016\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u00a2\u0006\u0004\bP\u0010TB%\b\u0016\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u0012\u0006\u0010U\u001a\u00020\u0005\u00a2\u0006\u0004\bP\u0010VJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u000e\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J<\u0010'\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010!2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010(\u001a\u00020\tH\u0014R\u0014\u0010+\u001a\u00020%8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00103R$\u0010:\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R2\u0010?\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0;j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%`<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006W"}, d2 = {"Lcom/tencent/timi/game/profile/impl/view/ProfileItemInTeamView;", "Landroid/widget/RelativeLayout;", "", "uid", "roomId", "", VirtualAppProxy.KEY_GAME_ID, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, ReportConstant.COSTREPORT_PREFIX, "k", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp;", "result", DomainData.DOMAIN_NAME, "o", "", "isEnd", "p", "t", NodeProps.VISIBLE, "u", "Lorg/libpag/PAGFile;", "pag", "j", "i", "pagFile", "width", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lbo4/f;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qqActivity", "", "", "reportParamMap", "setData", NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Ljava/lang/String;", "TAG", "e", "Z", "isDetached", "f", "pagViewInited", h.F, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "clickListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "reportMap", "D", "J", "inTeamRoomId", "Lnr2/al;", "E", "Lnr2/al;", "binding", UserInfo.SEX_FEMALE, "I", "teamGameId", "com/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$b", "G", "Lcom/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$b;", "pagDownloadListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ProfileItemInTeamView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, String> reportMap;

    /* renamed from: D, reason: from kotlin metadata */
    private long inTeamRoomId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final al binding;

    /* renamed from: F, reason: from kotlin metadata */
    private int teamGameId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b pagDownloadListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isDetached;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean pagViewInited;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId userId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QBaseActivity qqActivity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener clickListener;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$b", "Lwn4/a$a;", "", "url", "Lorg/libpag/PAGFile;", "pagFile", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements a.InterfaceC11498a {
        b() {
        }

        @Override // wn4.a.InterfaceC11498a
        public void a(@NotNull String url, @NotNull PAGFile pagFile) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(pagFile, "pagFile");
            if (!ProfileItemInTeamView.this.isDetached) {
                ProfileItemInTeamView.this.j(pagFile);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp;", "result", "", "d", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f378994b;

        c(long j3) {
            this.f378994b = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ProfileItemInTeamView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.isDetached) {
                this$0.u(false);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp result) {
            if (!ProfileItemInTeamView.this.isDetached) {
                ProfileItemInTeamView.this.inTeamRoomId = this.f378994b;
                ProfileItemInTeamView.this.t(result);
                ProfileItemInTeamView.this.n(result);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            final ProfileItemInTeamView profileItemInTeamView = ProfileItemInTeamView.this;
            profileItemInTeamView.post(new Runnable() { // from class: yl4.b
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileItemInTeamView.c.c(ProfileItemInTeamView.this);
                }
            });
        }
    }

    public ProfileItemInTeamView(@Nullable Context context) {
        super(context);
        this.TAG = "ProfileItemInTeamView_";
        this.reportMap = new HashMap<>();
        al f16 = al.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.pagDownloadListener = new b();
        k();
    }

    private final void i() {
        TimiGamePAGView timiGamePAGView = this.binding.f420825d;
        if (timiGamePAGView != null) {
            timiGamePAGView.b(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(PAGFile pag) {
        l.i(this.TAG, "initPagView - start");
        if (this.pagViewInited) {
            return;
        }
        PAGFile r16 = r(pag, 30);
        PAGComposition Make = PAGComposition.Make(fh4.b.b(30), fh4.b.b(30));
        if (Make == null) {
            return;
        }
        Make.addLayer(r16);
        TimiGamePAGView timiGamePAGView = this.binding.f420825d;
        if (timiGamePAGView != null) {
            timiGamePAGView.setComposition(Make);
            timiGamePAGView.setVisibility(0);
            timiGamePAGView.setRepeatCount(0);
            i();
            timiGamePAGView.g();
        }
        this.pagViewInited = true;
        l.i(this.TAG, "initPagView - end");
    }

    private final void k() {
        setPadding(ViewUtils.dip2px(18.0f), 0, ViewUtils.dip2px(12.0f), 0);
        g.f(this, fh4.b.b(6), Color.parseColor("#FAFAFA"));
        setOnClickListener(new View.OnClickListener() { // from class: yl4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileItemInTeamView.l(ProfileItemInTeamView.this, view);
            }
        });
        wn4.a.f445988a.b(this.pagDownloadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ProfileItemInTeamView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.a()) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = this$0.userId;
            if (commonOuterClass$QQUserId != null && this$0.inTeamRoomId != 0 && this$0.qqActivity != null) {
                r rVar = r.f439199a;
                Intrinsics.checkNotNull(commonOuterClass$QQUserId);
                long j3 = this$0.inTeamRoomId;
                int i3 = this$0.teamGameId;
                QBaseActivity qBaseActivity = this$0.qqActivity;
                Intrinsics.checkNotNull(qBaseActivity);
                rVar.b(commonOuterClass$QQUserId, j3, i3, qBaseActivity);
            } else {
                l.e(this$0.TAG, "joinYoloRoomFromTeamView - onError -" + this$0.inTeamRoomId);
            }
            View.OnClickListener onClickListener = this$0.clickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this$0);
            }
            this$0.o();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp result) {
        if (result != null) {
            this.reportMap.put("yes_team_name", result.name.get());
        }
        ((ug4.a) mm4.b.b(ug4.a.class)).c(this, true, null, "em_yes_userprofile_panel_teaming", this.reportMap);
        p(false);
    }

    private final void o() {
        if (getVisibility() == 0) {
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            bVar.reportEvent("clck", this, this.reportMap);
        }
    }

    private final void p(boolean isEnd) {
        if (getVisibility() == 0) {
            if (isEnd) {
                ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                bVar.reportEvent("imp_end", this, this.reportMap);
            } else {
                ug4.b bVar2 = (ug4.b) mm4.b.b(ug4.b.class);
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                bVar2.reportEvent("imp", this, this.reportMap);
            }
        }
    }

    private final void q(long uid, long roomId, int gameId, CommonOuterClass$QQUserId userId) {
        wl4.a.f445793a.a(uid, gameId, userId, new c(roomId));
    }

    private final PAGFile r(PAGFile pagFile, int width) {
        Matrix totalMatrix = pagFile.getTotalMatrix();
        float dp2px = (ba.dp2px(getContext(), width) * 1.0f) / pagFile.width();
        totalMatrix.setScale(dp2px, dp2px);
        pagFile.setMatrix(totalMatrix);
        return pagFile;
    }

    private final void s(CommonOuterClass$QQUserId userId, IUserInfo userInfo) {
        boolean z16;
        String m3;
        String str;
        if (((ll4.a) mm4.b.b(ll4.a.class)).h() == userId.uid.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView = this.binding.f420828g;
            if (textView != null) {
                textView.setText("\u8fdb\u5165");
                return;
            }
            return;
        }
        String str2 = "\u4e0eTA\u73a9";
        if (userInfo != null && (m3 = userInfo.m(userId)) != null) {
            if (Intrinsics.areEqual("\u7537", m3)) {
                str = "\u4e0e\u4ed6\u73a9";
            } else if (Intrinsics.areEqual("\u5973", m3)) {
                str = "\u4e0e\u5979\u73a9";
            }
            str2 = str;
        }
        TextView textView2 = this.binding.f420828g;
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp result) {
        long j3;
        boolean z16;
        String str;
        PBStringField pBStringField;
        String str2;
        PBStringField pBStringField2;
        String str3;
        PBStringField pBStringField3;
        PBUInt64Field pBUInt64Field;
        if (result != null && (pBUInt64Field = result.team_id) != null) {
            j3 = pBUInt64Field.get();
        } else {
            j3 = 0;
        }
        if (j3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        u(z16);
        MediumBoldTextView mediumBoldTextView = this.binding.f420824c;
        String str4 = "";
        if (mediumBoldTextView != null) {
            if (result == null || (pBStringField3 = result.name) == null || (str3 = pBStringField3.get()) == null) {
                str3 = "";
            }
            mediumBoldTextView.setText(str3);
        }
        TextView textView = this.binding.f420827f;
        if (textView != null) {
            if (result == null || (pBStringField2 = result.desc) == null || (str2 = pBStringField2.get()) == null) {
                str2 = "";
            }
            textView.setText(str2);
        }
        if (result != null && (pBStringField = result.pag_url) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str != null) {
            str4 = str;
        }
        l.i(this.TAG, "setDescribeView - " + str4 + " " + this.teamGameId);
        if (!TextUtils.isEmpty(str4)) {
            PAGFile e16 = wn4.a.f445988a.e(str4, "user_info_in_team_" + this.teamGameId);
            if (e16 != null) {
                j(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(boolean visible) {
        g.o(this, visible);
    }

    public final void m(@NotNull CommonOuterClass$QQUserId userId) {
        CommonOuterClass$OnlineRouteInfoList commonOuterClass$OnlineRouteInfoList;
        PBRepeatMessageField<CommonOuterClass$OnlineRouteInfo> pBRepeatMessageField;
        List<CommonOuterClass$OnlineRouteInfo> list;
        Intrinsics.checkNotNullParameter(userId, "userId");
        PremadesTeamServerOuterClass$UserOnlineRouteInfoList i3 = TeamInfoAutoUpdateService.h().i(userId);
        if (i3 != null && (commonOuterClass$OnlineRouteInfoList = i3.list) != null && (pBRepeatMessageField = commonOuterClass$OnlineRouteInfoList.route_list) != null && (list = pBRepeatMessageField.get()) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((fm4.g) mm4.b.b(fm4.g.class)).D(((CommonOuterClass$OnlineRouteInfo) it.next()).yolo_room_route_info.room_type.get())) {
                    u(true);
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.isDetached = true;
        p(true);
        wn4.a.f445988a.k(this.pagDownloadListener);
        super.onDetachedFromWindow();
    }

    public final void setClickListener(@Nullable View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public final void setData(@Nullable f result, @NotNull CommonOuterClass$QQUserId userId, @NotNull QBaseActivity qqActivity, @NotNull Map<String, String> reportParamMap, int gameId) {
        long j3;
        IUserInfo iUserInfo;
        CommonOuterClass$OnlineRouteInfoList onlineRouteInfoList;
        PBRepeatMessageField<CommonOuterClass$OnlineRouteInfo> pBRepeatMessageField;
        List<CommonOuterClass$OnlineRouteInfo> list;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(qqActivity, "qqActivity");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        this.teamGameId = gameId;
        this.qqActivity = qqActivity;
        this.userId = userId;
        this.reportMap = new HashMap<>(reportParamMap);
        if (result != null && (onlineRouteInfoList = result.getOnlineRouteInfoList()) != null && (pBRepeatMessageField = onlineRouteInfoList.route_list) != null && (list = pBRepeatMessageField.get()) != null) {
            j3 = 0;
            for (CommonOuterClass$OnlineRouteInfo commonOuterClass$OnlineRouteInfo : list) {
                if (((fm4.g) mm4.b.b(fm4.g.class)).D(commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_type.get())) {
                    j3 = commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_id.get();
                }
            }
        } else {
            j3 = 0;
        }
        l.i(this.TAG, "setData - " + j3);
        if (j3 != 0) {
            q(userId.uid.get(), j3, gameId, userId);
            this.reportMap.put("yes_team_id", String.valueOf(j3));
        } else {
            u(false);
        }
        if (result != null) {
            iUserInfo = result.getCom.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.KEY_USER_INFO java.lang.String();
        } else {
            iUserInfo = null;
        }
        s(userId, iUserInfo);
    }

    public ProfileItemInTeamView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "ProfileItemInTeamView_";
        this.reportMap = new HashMap<>();
        al f16 = al.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.pagDownloadListener = new b();
        k();
    }

    public ProfileItemInTeamView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.TAG = "ProfileItemInTeamView_";
        this.reportMap = new HashMap<>();
        al f16 = al.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.pagDownloadListener = new b();
        k();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$a", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements PAGView.PAGViewListener {
        a() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
            l.i(ProfileItemInTeamView.this.TAG, "onAnimationCancel " + p06);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            l.i(ProfileItemInTeamView.this.TAG, "onAnimationEnd " + p06);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
            l.i(ProfileItemInTeamView.this.TAG, "onAnimationRepeat " + p06);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
            l.i(ProfileItemInTeamView.this.TAG, "ionAnimationStart " + p06);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}
