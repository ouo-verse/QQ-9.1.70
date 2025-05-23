package com.tencent.mobileqq.qqlive.sail.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment2;
import com.tencent.mobileqq.qqlive.sail.ui.alert.QQLiveQQNotifyPart;
import com.tencent.mobileqq.qqlive.sail.ui.background.QQLiveAudienceBgPart;
import com.tencent.mobileqq.qqlive.sail.ui.clearscreen.QQLiveClearScreenPart;
import com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceClosePart;
import com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceEndPart;
import com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveBarrageLayoutPart;
import com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart;
import com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveNormalDanmuPart;
import com.tencent.mobileqq.qqlive.sail.ui.debug.QQLiveAudienceDebugPart;
import com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionPopupPart;
import com.tencent.mobileqq.qqlive.sail.ui.definition.QQLiveDefinitionTipsPart;
import com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAudienceECCardPart;
import com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveECBubblePart;
import com.tencent.mobileqq.qqlive.sail.ui.fangroup.QQLiveFanGroupGuidePart;
import com.tencent.mobileqq.qqlive.sail.ui.floatwindow.QQLiveFloatWindowPart;
import com.tencent.mobileqq.qqlive.sail.ui.follow.QQLiveFollowGuidePart;
import com.tencent.mobileqq.qqlive.sail.ui.game.QQLiveGameCardPart;
import com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftGuidePart;
import com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftPanelPart;
import com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftVerifyPart;
import com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftPart;
import com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftTipPart;
import com.tencent.mobileqq.qqlive.sail.ui.input.QQLiveAudienceInputPart;
import com.tencent.mobileqq.qqlive.sail.ui.linkscreen.QQLiveAudienceLinkScreenPart;
import com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart;
import com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart;
import com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceMorePanelPart;
import com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart;
import com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.QQLiveNormalFloatingMsgPart;
import com.tencent.mobileqq.qqlive.sail.ui.orientation.QQLiveOrientationPart;
import com.tencent.mobileqq.qqlive.sail.ui.paylevel.QQLivePayLevelPart;
import com.tencent.mobileqq.qqlive.sail.ui.pendant.QQLivePendantPart;
import com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerPreloadPart;
import com.tencent.mobileqq.qqlive.sail.ui.player.QQLivePlayerStatusPart;
import com.tencent.mobileqq.qqlive.sail.ui.rank.QQLiveRankPart;
import com.tencent.mobileqq.qqlive.sail.ui.report.QQLiveRoomReportPart;
import com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveAudienceRoomPart;
import com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveRoomCleanPart;
import com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveRoomCreatePart;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomFeedsViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.room.r;
import com.tencent.mobileqq.qqlive.sail.ui.tophead.QQLiveTopHeadPart;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/QQLiveAudienceRoomFragment;", "Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment2;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomFeedsViewModel;", "E", "Lkotlin/Lazy;", "yh", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomFeedsViewModel;", "feedsViewModel", "", "<set-?>", UserInfo.SEX_FEMALE, "I", "getPosition", "()I", "position", "Lqr4/b;", "G", "Lqr4/b;", "feed", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart;", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveAudienceRoomPart;", "roomPart", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAudienceEndPart;", "xh", "()Lcom/tencent/mobileqq/qqlive/sail/ui/close/QQLiveAudienceEndPart;", "endPart", "<init>", "()V", "H", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceRoomFragment extends QQLiveBaseFragment2 {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedsViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private int position;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private qr4.b feed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/QQLiveAudienceRoomFragment$a;", "", "", "KEY_FEED_BYTES", "Ljava/lang/String;", "KEY_FEED_POSITION", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.QQLiveAudienceRoomFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51377);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceRoomFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        final Function0<ViewModelStoreOwner> function0 = new Function0<ViewModelStoreOwner>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveAudienceRoomFragment$feedsViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceRoomFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStoreOwner invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ViewModelStoreOwner) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Fragment requireParentFragment = QQLiveAudienceRoomFragment.this.requireParentFragment();
                Intrinsics.checkNotNullExpressionValue(requireParentFragment, "requireParentFragment()");
                return requireParentFragment;
            }
        };
        this.feedsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RoomFeedsViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveAudienceRoomFragment$special$$inlined$viewModels$default$1
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Function0.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ViewModelStore) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.position = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQLiveAudienceEndPart xh() {
        Part part = getPartManager().getPart(QQLiveAudienceEndPart.class.getName());
        if (part instanceof QQLiveAudienceEndPart) {
            return (QQLiveAudienceEndPart) part;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomFeedsViewModel yh() {
        return (RoomFeedsViewModel) this.feedsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQLiveAudienceRoomPart zh() {
        Part part = getPartManager().getPart(QQLiveAudienceRoomPart.class.getName());
        if (part instanceof QQLiveAudienceRoomPart) {
            return (QQLiveAudienceRoomPart) part;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        qr4.b bVar = this.feed;
        String str3 = null;
        if (bVar != null) {
            str = bVar.f429378c;
        } else {
            str = null;
        }
        QLog.d("Audience|QQLiveAudienceRoomFragment", 1, "assembleParts isHuya:" + Intrinsics.areEqual("huya", str));
        qr4.b bVar2 = this.feed;
        if (bVar2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new QQLiveRoomReportPart());
            arrayList.add(new QQLiveRoomCreatePart(QQLiveRoomCreatePart.Companion.CreateType.AUDIENCE, bVar2));
            arrayList.add(new com.tencent.mobileqq.qqlive.sail.ui.busconfig.b());
            arrayList.add(new QQLiveAudienceBgPart(this.position));
            arrayList.add(new QQLiveAudienceRoomPart(this.position));
            arrayList.add(new QQLivePlayerStatusPart());
            arrayList.add(new QQLivePlayerPreloadPart(this.position));
            arrayList.add(new QQLiveOrientationPart());
            arrayList.add(new QQLiveTopHeadPart());
            qr4.b bVar3 = this.feed;
            if (bVar3 != null) {
                str2 = bVar3.f429378c;
            } else {
                str2 = null;
            }
            if (!Intrinsics.areEqual("huya", str2)) {
                arrayList.add(new QQLiveRankPart());
            } else {
                arrayList.add(new com.tencent.mobileqq.qqlive.sail.ui.huyaprivacy.b());
            }
            arrayList.add(new QQLiveFloatWindowPart(this.position, bVar2));
            arrayList.add(new QQLivePendantPart());
            arrayList.add(new QQLiveAudienceECCardPart());
            arrayList.add(new QQLiveECBubblePart());
            arrayList.add(new QQLiveAudienceLinkScreenPart());
            arrayList.add(new QQLiveVideoOverlayPart());
            arrayList.add(new QQLiveDefinitionPopupPart());
            arrayList.add(new QQLiveDefinitionTipsPart());
            arrayList.add(new com.tencent.mobileqq.qqlive.sail.ui.like.b());
            arrayList.add(new QQLiveGiftVerifyPart());
            arrayList.add(new com.tencent.mobileqq.qqlive.sail.ui.gift.g());
            arrayList.add(new QQLiveGiftGuidePart());
            arrayList.add(new QQLiveGiftPanelPart());
            arrayList.add(new QQLiveQuickGiftPart());
            arrayList.add(new QQLiveQuickGiftTipPart());
            arrayList.add(new QQLiveBarrageLayoutPart());
            arrayList.add(new QQLivePayLevelPart());
            arrayList.add(new QQLiveChatMessagePart());
            arrayList.add(new QQLiveNormalDanmuPart());
            arrayList.add(new QQLiveGameCardPart());
            arrayList.add(new QQLiveAudienceBottomPortraitPart());
            qr4.b bVar4 = this.feed;
            if (bVar4 != null) {
                str3 = bVar4.f429378c;
            }
            if (!Intrinsics.areEqual("huya", str3)) {
                arrayList.add(new com.tencent.mobileqq.qqlive.sail.ui.luckybag.b());
            }
            arrayList.add(new QQLiveAudienceBottomLandscapePart());
            arrayList.add(new QQLiveAudienceMorePanelPart());
            arrayList.add(new QQLiveAudienceInputPart());
            arrayList.add(new QQLiveNormalFloatingMsgPart());
            arrayList.add(new QQLiveQQNotifyPart());
            arrayList.add(new QQLiveFanGroupGuidePart());
            arrayList.add(new QQLiveFollowGuidePart());
            arrayList.add(new com.tencent.mobileqq.qqlive.sail.ui.admin.a());
            arrayList.add(new QQLiveClearScreenPart());
            arrayList.add(new ri2.b());
            arrayList.add(new QQLiveAudienceDebugPart());
            arrayList.add(new QQLiveAudienceClosePart());
            arrayList.add(new QQLiveAudienceEndPart(this.position));
            arrayList.add(new QQLiveRoomCleanPart());
            return arrayList;
        }
        return new ArrayList();
    }

    public final int getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.position;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return getPartManager().onBackEvent();
    }

    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment2, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        qr4.b bVar;
        byte[] byteArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("key_feed_position");
        } else {
            i3 = -1;
        }
        this.position = i3;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (byteArray = arguments2.getByteArray("key_feed_bytes")) != null) {
            bVar = qr4.b.d(byteArray);
        } else {
            bVar = null;
        }
        this.feed = bVar;
        MutableLiveData<r> a26 = yh().a2();
        final Function1<r, Unit> function1 = new Function1<r, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveAudienceRoomFragment$onCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceRoomFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(r rVar) {
                invoke2(rVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(r it) {
                QQLiveAudienceRoomPart zh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                zh5 = QQLiveAudienceRoomFragment.this.zh();
                if (zh5 != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    zh5.xa(it);
                }
            }
        };
        a26.observe(this, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceRoomFragment.Ah(Function1.this, obj);
            }
        });
        MutableLiveData<List<qr4.b>> Z1 = yh().Z1();
        final Function1<List<? extends qr4.b>, Unit> function12 = new Function1<List<? extends qr4.b>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.QQLiveAudienceRoomFragment$onCreate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceRoomFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends qr4.b> list) {
                invoke2((List<qr4.b>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<qr4.b> list) {
                QQLiveAudienceEndPart xh5;
                RoomFeedsViewModel yh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                xh5 = QQLiveAudienceRoomFragment.this.xh();
                if (xh5 != null) {
                    yh5 = QQLiveAudienceRoomFragment.this.yh();
                    xh5.Ca(yh5.S1());
                }
            }
        };
        Z1.observe(this, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceRoomFragment.Bh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.h9t, container, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Long l3;
        qr4.f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            qr4.b bVar = this.feed;
            if (bVar != null && (fVar = bVar.f429376a) != null) {
                l3 = Long.valueOf(fVar.f429397a);
            } else {
                l3 = null;
            }
            companion.i("Audience|QQLiveAudienceRoomFragment", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "roomId=" + l3);
        }
    }
}
