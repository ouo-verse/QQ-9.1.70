package com.tencent.mobileqq.troop.teamup.detail.part;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpUser;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailTitleInfoPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "publisherUin", "publisherName", "", "J9", "I9", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "data", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "d", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "detailVM", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "stateText", "f", "titleText", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", tl.h.F, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "publisherAvatar", "i", "publisherText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "publisherTextEnd", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "publisherContainer", "", "D", "Z", "hadSetNick", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailTitleInfoPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup publisherContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hadSetNick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy detailVM;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView stateText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView titleText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView publisherAvatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView publisherText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView publisherTextEnd;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailTitleInfoPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleInfoPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpDetailTitleInfoPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopTeamUpDetailVM>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleInfoPart$detailVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailTitleInfoPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopTeamUpDetailVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopTeamUpDetailVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TroopTeamUpDetailVM.Companion companion = TroopTeamUpDetailVM.INSTANCE;
                    Fragment hostFragment = TroopTeamUpDetailTitleInfoPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.detailVM = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final TroopTeamUpDetailVM G9() {
        return (TroopTeamUpDetailVM) this.detailVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9() {
        TeamUpUser teamUpUser;
        String l3;
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getContext().getString(R.string.i7y));
        TeamUpTeamDetail value = G9().a2().getValue();
        if (value != null && (teamUpUser = value.creator) != null && (l3 = Long.valueOf(teamUpUser.uin).toString()) != null) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopmemberCard(bg.f(), getActivity(), G9().k2(), l3, -1, 9, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(String publisherUin, String publisherName) {
        QQProAvatarView qQProAvatarView = this.publisherAvatar;
        ViewGroup viewGroup = null;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publisherAvatar");
            qQProAvatarView = null;
        }
        qQProAvatarView.w(1, publisherUin);
        TextView textView = this.publisherText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publisherText");
            textView = null;
        }
        textView.setText(publisherName);
        TextView textView2 = this.publisherTextEnd;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publisherTextEnd");
            textView2 = null;
        }
        boolean z16 = false;
        textView2.setVisibility(0);
        Integer value = G9().g2().getValue();
        if (value != null && value.intValue() == 1) {
            TextView textView3 = this.publisherText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publisherText");
                textView3 = null;
            }
            textView3.setTextColor(getContext().getColor(R.color.qui_common_text_link));
            ViewGroup viewGroup2 = this.publisherContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publisherContainer");
                viewGroup2 = null;
            }
            viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopTeamUpDetailTitleInfoPart.K9(TroopTeamUpDetailTitleInfoPart.this, view);
                }
            });
        }
        if (publisherName.length() == 0) {
            z16 = true;
        }
        if (z16) {
            TroopMemberListRepo.INSTANCE.fetchTroopMemberName(G9().k2(), publisherUin, getPartHost().getLifecycleOwner(), "TroopTeamUpDetailTitleInfoPart", new Function1<TroopMemberNickInfo, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleInfoPart$updatePublisher$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailTitleInfoPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                    invoke2(troopMemberNickInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        com.tencent.mobileqq.troop.utils.p.f302196a.b(new Function0<Unit>(troopMemberNickInfo) { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleInfoPart$updatePublisher$2.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ TroopMemberNickInfo $nickInfo;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$nickInfo = troopMemberNickInfo;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailTitleInfoPart.this, (Object) troopMemberNickInfo);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
                            
                                if ((r2.length() > 0) == true) goto L24;
                             */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke2() {
                                boolean z17;
                                TextView textView4;
                                String str;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                z17 = TroopTeamUpDetailTitleInfoPart.this.hadSetNick;
                                if (z17) {
                                    return;
                                }
                                boolean z18 = true;
                                TroopTeamUpDetailTitleInfoPart.this.hadSetNick = true;
                                textView4 = TroopTeamUpDetailTitleInfoPart.this.publisherText;
                                if (textView4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("publisherText");
                                    textView4 = null;
                                }
                                TroopMemberNickInfo troopMemberNickInfo2 = this.$nickInfo;
                                if (troopMemberNickInfo2 != null && (r2 = troopMemberNickInfo2.getTroopNick()) != null) {
                                }
                                z18 = false;
                                if (z18) {
                                    str = this.$nickInfo.getTroopNick();
                                } else {
                                    TroopMemberNickInfo troopMemberNickInfo3 = this.$nickInfo;
                                    if (troopMemberNickInfo3 == null || (str = troopMemberNickInfo3.getFriendNick()) == null) {
                                        str = "";
                                    }
                                }
                                textView4.setText(str);
                            }
                        });
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                    }
                }
            });
        } else {
            this.hadSetNick = true;
        }
        com.tencent.mobileqq.troop.teamup.detail.common.a aVar = com.tencent.mobileqq.troop.teamup.detail.common.a.f298875a;
        ViewGroup viewGroup3 = this.publisherContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publisherContainer");
        } else {
            viewGroup = viewGroup3;
        }
        aVar.d(viewGroup, publisherUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(TroopTeamUpDetailTitleInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(TeamUpTeamDetail data) {
        int i3 = data.status;
        TextView textView = null;
        if (i3 != 1) {
            if (i3 != 2) {
                TextView textView2 = this.stateText;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stateText");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(8);
                QLog.e("TroopTeamUpDetailTitleInfoPart", 1, "updateState: state=" + i3);
                return;
            }
            TextView textView3 = this.stateText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateText");
                textView3 = null;
            }
            textView3.setVisibility(0);
            TextView textView4 = this.stateText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateText");
                textView4 = null;
            }
            textView4.setText(getContext().getString(R.string.f236457ee));
            TextView textView5 = this.stateText;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateText");
            } else {
                textView = textView5;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.kdq, 0, 0, 0);
            return;
        }
        if (data.joinedCnt >= data.joinLimit) {
            TextView textView6 = this.stateText;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateText");
            } else {
                textView = textView6;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView7 = this.stateText;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateText");
            textView7 = null;
        }
        textView7.setVisibility(0);
        TextView textView8 = this.stateText;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateText");
            textView8 = null;
        }
        textView8.setText(getContext().getString(R.string.f236467ef));
        TextView textView9 = this.stateText;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateText");
        } else {
            textView = textView9;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.kdr, 0, 0, 0);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f93735ad);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.team_up_detail_state)");
        this.stateText = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f93745ae);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026eam_up_detail_title_text)");
        this.titleText = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f93695a_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_detail_publisher_avatar)");
        this.publisherAvatar = (QQProAvatarView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f93715ab);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026up_detail_publisher_text)");
        this.publisherText = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f93725ac);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026etail_publisher_text_end)");
        this.publisherTextEnd = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f93705aa);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026tail_publisher_container)");
        this.publisherContainer = (ViewGroup) findViewById6;
        TextView textView = this.stateText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateText");
            textView = null;
        }
        textView.setVisibility(8);
        LiveData<TeamUpTeamDetail> a26 = G9().a2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<TeamUpTeamDetail, Unit> function1 = new Function1<TeamUpTeamDetail, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleInfoPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailTitleInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TeamUpTeamDetail teamUpTeamDetail) {
                invoke2(teamUpTeamDetail);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TeamUpTeamDetail data) {
                TextView textView2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) data);
                    return;
                }
                TroopTeamUpDetailTitleInfoPart troopTeamUpDetailTitleInfoPart = TroopTeamUpDetailTitleInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(data, "data");
                troopTeamUpDetailTitleInfoPart.L9(data);
                textView2 = TroopTeamUpDetailTitleInfoPart.this.titleText;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleText");
                    textView2 = null;
                }
                textView2.setText(data.title);
                TroopTeamUpDetailTitleInfoPart troopTeamUpDetailTitleInfoPart2 = TroopTeamUpDetailTitleInfoPart.this;
                String valueOf = String.valueOf(data.creator.uin);
                String str = data.creator.nick;
                Intrinsics.checkNotNullExpressionValue(str, "data.creator.nick");
                troopTeamUpDetailTitleInfoPart2.J9(valueOf, str);
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailTitleInfoPart.H9(Function1.this, obj);
            }
        });
    }
}
