package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.addsource.TroopSourceHandler;
import com.tencent.mobileqq.troop.api.IAddTroopAccountIdentityApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.homework.logic.ModifyHWTroopIdentityHelper;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.a;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.ui.l;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.es;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.protofile.groupMngTransInfo$ChannelInfo;
import com.tencent.protofile.groupMngTransInfo$JoinGroupTransInfo;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.util.LoadingUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u007f2\u00020\u0001:\u0002\u0080\u0001B\u000f\u0012\u0006\u0010I\u001a\u00020D\u00a2\u0006\u0004\b}\u0010~J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J;\u0010(\u001a\u00020'2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010+J#\u0010/\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010.\u001a\u00020-H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u00100J\u0018\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J#\u00102\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010+J\u0010\u00105\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0014\u00106\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u00109\u001a\u00020\u00062\u0006\u00107\u001a\u00020'2\b\u00108\u001a\u0004\u0018\u00010\u0018H\u0002J\u001e\u0010=\u001a\u0004\u0018\u00010<2\b\u0010:\u001a\u0004\u0018\u00010\u00182\b\u0010;\u001a\u0004\u0018\u00010\u0018H\u0002J\u001b\u0010>\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010+J\u0014\u0010@\u001a\u00020\u00062\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010C\u001a\u00020\u0006*\u00020A2\u0006\u0010B\u001a\u00020AH\u0002R\u0017\u0010I\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010Q\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010LR\u0016\u0010S\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010LR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010$\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010%\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0018\u0010:\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010aR\u0016\u0010g\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010fR\u0016\u0010i\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010fR\u0016\u0010k\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010aR\u0016\u0010n\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010aR\u0016\u0010r\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010aR\u0018\u0010v\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u001b\u0010|\u001a\u00020w8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardBottomPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "Landroid/content/Intent;", "intent", "Fa", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/a$a;", "btnType", "ba", "Lcom/tencent/mobileqq/troop/data/v;", "troopInfoWrapper", "da", "ma", "sa", "Ha", "", "msg", "Ja", "Lorg/json/JSONObject;", "resultObj", "Ea", "", "retCode", "ga", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/a$a$b;", "normalJoinBtnUIModel", "ra", "authKey", "authSig", "sourceId", "", "aa", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/a$a$b;Lcom/tencent/mobileqq/troop/data/v;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ca", "(Lcom/tencent/mobileqq/troop/data/v;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Aa", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$b;", "joinTroopResult", "na", "(Lcom/tencent/mobileqq/troop/data/v;Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "oa", "pa", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$b;Lcom/tencent/mobileqq/troop/data/v;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qa", LocaleUtils.L_JAPANESE, "Ga", "needVerify", "troopUin", "xa", "secureBizId", "channelId", "", "ea", "Ba", "intro", "la", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfoInResult", "Ma", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "ha", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "e", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "joinTroopBtn", "f", "sendMsgBtn", tl.h.F, "shareBtn", "i", "editInfoBtn", "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", "troopShareUtil", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "basicInfoViewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a;", "D", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a;", "repo", "E", "Ljava/lang/String;", UserInfo.SEX_FEMALE, "G", "marketChannelSourceId", "H", "I", "curFilterId", "J", "d2gType", "K", "joinTroopReturnAddr", "L", "Z", "isFromThirdApp", "M", "joinTroopMsg", "N", "sourceAIOAppearFrom", "Lcom/tencent/mobileqq/troop/homework/logic/ModifyHWTroopIdentityHelper;", "P", "Lcom/tencent/mobileqq/troop/homework/logic/ModifyHWTroopIdentityHelper;", "modifyHWIdentityHelper", "Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "ia", "()Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager;", "shareManager", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardBottomPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TroopBasicInfoViewModel basicInfoViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopcard.reborn.repo.a repo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String authKey;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String authSig;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String marketChannelSourceId;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String secureBizId;

    /* renamed from: I, reason: from kotlin metadata */
    private int curFilterId;

    /* renamed from: J, reason: from kotlin metadata */
    private int d2gType;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String joinTroopReturnAddr;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isFromThirdApp;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String joinTroopMsg;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String sourceAIOAppearFrom;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ModifyHWTroopIdentityHelper modifyHWIdentityHelper;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface appInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIButton joinTroopBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIButton sendMsgBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIButton shareBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUIButton editInfoBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ITroopShareUtility troopShareUtil;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardBottomPart$a;", "", "", "KEY_SOURCE_AIO_APPEAR_FROM", "Ljava/lang/String;", "", "QQ_NOTIFY_DELAY_TIME", "I", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57167);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoCardBottomPart(@NotNull AppInterface appInterface) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.appInterface = appInterface;
        this.repo = new TroopCardRepo();
        this.authKey = "";
        this.authSig = "";
        this.curFilterId = -1;
        this.joinTroopReturnAddr = "";
        this.joinTroopMsg = "";
        this.sourceAIOAppearFrom = "";
        lazy = LazyKt__LazyJVMKt.lazy(TroopInfoCardBottomPart$shareManager$2.INSTANCE);
        this.shareManager = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Aa(com.tencent.mobileqq.troop.data.v vVar, Continuation<? super Unit> continuation) {
        TroopInfoCardBottomPart$joinTroopDirectly$1 troopInfoCardBottomPart$joinTroopDirectly$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        TroopInfoCardBottomPart troopInfoCardBottomPart;
        if (continuation instanceof TroopInfoCardBottomPart$joinTroopDirectly$1) {
            troopInfoCardBottomPart$joinTroopDirectly$1 = (TroopInfoCardBottomPart$joinTroopDirectly$1) continuation;
            int i16 = troopInfoCardBottomPart$joinTroopDirectly$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                troopInfoCardBottomPart$joinTroopDirectly$1.label = i16 - Integer.MIN_VALUE;
                obj = troopInfoCardBottomPart$joinTroopDirectly$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopInfoCardBottomPart$joinTroopDirectly$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    vVar = (com.tencent.mobileqq.troop.data.v) troopInfoCardBottomPart$joinTroopDirectly$1.L$1;
                    troopInfoCardBottomPart = (TroopInfoCardBottomPart) troopInfoCardBottomPart$joinTroopDirectly$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.troop.troopcard.reborn.repo.a aVar = this.repo;
                    String troopUin = vVar.i().getTroopUin();
                    int h16 = vVar.h();
                    String str = this.authKey;
                    String str2 = this.authSig;
                    byte[] ea5 = ea(this.secureBizId, vVar.f());
                    troopInfoCardBottomPart$joinTroopDirectly$1.L$0 = this;
                    troopInfoCardBottomPart$joinTroopDirectly$1.L$1 = vVar;
                    troopInfoCardBottomPart$joinTroopDirectly$1.label = 1;
                    obj = aVar.b(troopUin, h16, str, str2, ea5, troopInfoCardBottomPart$joinTroopDirectly$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    troopInfoCardBottomPart = this;
                }
                troopInfoCardBottomPart$joinTroopDirectly$1.L$0 = null;
                troopInfoCardBottomPart$joinTroopDirectly$1.L$1 = null;
                troopInfoCardBottomPart$joinTroopDirectly$1.label = 2;
                if (troopInfoCardBottomPart.na(vVar, (a.b) obj, troopInfoCardBottomPart$joinTroopDirectly$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        troopInfoCardBottomPart$joinTroopDirectly$1 = new TroopInfoCardBottomPart$joinTroopDirectly$1(this, continuation);
        obj = troopInfoCardBottomPart$joinTroopDirectly$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopInfoCardBottomPart$joinTroopDirectly$1.label;
        if (i3 == 0) {
        }
        troopInfoCardBottomPart$joinTroopDirectly$1.L$0 = null;
        troopInfoCardBottomPart$joinTroopDirectly$1.L$1 = null;
        troopInfoCardBottomPart$joinTroopDirectly$1.label = 2;
        if (troopInfoCardBottomPart.na(vVar, (a.b) obj, troopInfoCardBottomPart$joinTroopDirectly$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Ba(com.tencent.mobileqq.troop.data.v vVar, Continuation<? super Unit> continuation) {
        TroopInfoCardBottomPart$joinTroopWithVerify$1 troopInfoCardBottomPart$joinTroopWithVerify$1;
        Object coroutine_suspended;
        int i3;
        QBaseActivity qBaseActivity;
        TroopInfoCardBottomPart troopInfoCardBottomPart;
        com.tencent.mobileqq.troop.data.v vVar2;
        a.c cVar;
        if (continuation instanceof TroopInfoCardBottomPart$joinTroopWithVerify$1) {
            troopInfoCardBottomPart$joinTroopWithVerify$1 = (TroopInfoCardBottomPart$joinTroopWithVerify$1) continuation;
            int i16 = troopInfoCardBottomPart$joinTroopWithVerify$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                troopInfoCardBottomPart$joinTroopWithVerify$1.label = i16 - Integer.MIN_VALUE;
                Object obj = troopInfoCardBottomPart$joinTroopWithVerify$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopInfoCardBottomPart$joinTroopWithVerify$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    qBaseActivity = (QBaseActivity) troopInfoCardBottomPart$joinTroopWithVerify$1.L$2;
                    vVar2 = (com.tencent.mobileqq.troop.data.v) troopInfoCardBottomPart$joinTroopWithVerify$1.L$1;
                    troopInfoCardBottomPart = (TroopInfoCardBottomPart) troopInfoCardBottomPart$joinTroopWithVerify$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    Activity activity = getActivity();
                    if (activity instanceof QBaseActivity) {
                        qBaseActivity = (QBaseActivity) activity;
                    } else {
                        qBaseActivity = null;
                    }
                    if (qBaseActivity == null) {
                        return Unit.INSTANCE;
                    }
                    if (!qBaseActivity.isResume()) {
                        QLog.e("TroopInfoCardBottomPart", 1, "joinTroopWithVerify error, activity is not resumed");
                        return Unit.INSTANCE;
                    }
                    QLog.i("TroopInfoCardBottomPart", 1, "joinTroopWithVerify troopUin=" + vVar.i().getTroopUin());
                    ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).calJoinTroop(vVar.i().getTroopUin(), vVar.g(), vVar.h(), ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getExposureSource(), this.curFilterId, 2);
                    if (!NetworkUtil.isNetSupport(qBaseActivity)) {
                        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).notifyUser(getActivity(), qBaseActivity.getTitleBarHeight(), R.string.f235097aq, 1);
                        QLog.i("TroopInfoCardBottomPart", 1, "joinTroopWithVerify, no network, troopUin=" + vVar.i().getTroopUin());
                        return Unit.INSTANCE;
                    }
                    com.tencent.mobileqq.troop.troopcard.reborn.repo.a aVar = this.repo;
                    String troopUin = vVar.i().getTroopUin();
                    LifecycleOwner a16 = com.tencent.mobileqq.troop.troopsetting.part.i.a(this);
                    troopInfoCardBottomPart$joinTroopWithVerify$1.L$0 = this;
                    troopInfoCardBottomPart$joinTroopWithVerify$1.L$1 = vVar;
                    troopInfoCardBottomPart$joinTroopWithVerify$1.L$2 = qBaseActivity;
                    troopInfoCardBottomPart$joinTroopWithVerify$1.label = 1;
                    obj = aVar.d(troopUin, a16, troopInfoCardBottomPart$joinTroopWithVerify$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    troopInfoCardBottomPart = this;
                    vVar2 = vVar;
                }
                cVar = (a.c) obj;
                TroopInfo a17 = cVar.a();
                TroopInfo i17 = vVar2.i();
                if (!cVar.b() && a17 != null) {
                    troopInfoCardBottomPart.Ma(i17, a17);
                    TroopBasicInfoViewModel troopBasicInfoViewModel = troopInfoCardBottomPart.basicInfoViewModel;
                    if (troopBasicInfoViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                        troopBasicInfoViewModel = null;
                    }
                    troopBasicInfoViewModel.m3(i17);
                    short s16 = i17.cGroupOption;
                    if (s16 == 3) {
                        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).notifyUser(qBaseActivity, qBaseActivity.getTitleBarHeight(), R.string.i7i, 0);
                        QLog.i("TroopInfoCardBottomPart", 1, "joinTroopWithVerify, nobody can join troop, troopUin=" + vVar2.i().getTroopUin());
                        return Unit.INSTANCE;
                    }
                    if (s16 == 1) {
                        troopInfoCardBottomPart$joinTroopWithVerify$1.L$0 = null;
                        troopInfoCardBottomPart$joinTroopWithVerify$1.L$1 = null;
                        troopInfoCardBottomPart$joinTroopWithVerify$1.L$2 = null;
                        troopInfoCardBottomPart$joinTroopWithVerify$1.label = 2;
                        if (troopInfoCardBottomPart.Aa(vVar2, troopInfoCardBottomPart$joinTroopWithVerify$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i17.isHomeworkTroop()) {
                        troopInfoCardBottomPart.xa(true, i17.troopuin);
                    } else {
                        troopInfoCardBottomPart.la(troopInfoCardBottomPart.joinTroopMsg);
                    }
                    return Unit.INSTANCE;
                }
                ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).notifyUser(qBaseActivity, qBaseActivity.getTitleBarHeight(), R.string.f173052s4, 1);
                QLog.i("TroopInfoCardBottomPart", 1, "joinTroopWithVerify, fetch setting error, troopUin=" + vVar2.i().getTroopUin());
                return Unit.INSTANCE;
            }
        }
        troopInfoCardBottomPart$joinTroopWithVerify$1 = new TroopInfoCardBottomPart$joinTroopWithVerify$1(this, continuation);
        Object obj2 = troopInfoCardBottomPart$joinTroopWithVerify$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopInfoCardBottomPart$joinTroopWithVerify$1.label;
        if (i3 == 0) {
        }
        cVar = (a.c) obj2;
        TroopInfo a172 = cVar.a();
        TroopInfo i172 = vVar2.i();
        if (!cVar.b()) {
        }
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).notifyUser(qBaseActivity, qBaseActivity.getTitleBarHeight(), R.string.f173052s4, 1);
        QLog.i("TroopInfoCardBottomPart", 1, "joinTroopWithVerify, fetch setting error, troopUin=" + vVar2.i().getTroopUin());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Ca(com.tencent.mobileqq.troop.data.v vVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        QLog.i("TroopInfoCardBottomPart", 1, "joinTroopWithoutVerify isHomework=" + vVar.i().isHomeworkTroop() + " troopUin=" + vVar.i().getTroopUin() + "statOption=" + vVar.h() + "sceneTargetId=" + vVar.f());
        if (vVar.i().isHomeworkTroop()) {
            xa(false, vVar.i().getTroopUin());
            return Unit.INSTANCE;
        }
        Object Aa = Aa(vVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (Aa == coroutine_suspended) {
            return Aa;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ea(JSONObject resultObj) {
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 == null) {
            return;
        }
        Activity activity = getActivity();
        if (activity != null && resultObj != null) {
            try {
                Object obj = resultObj.get("data");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj;
                Object obj2 = jSONObject.get("key");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject2 = (JSONObject) obj2;
                Object obj3 = jSONObject2.get("retCode");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj3).intValue();
                Object obj4 = jSONObject2.get("retMsg");
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj4;
                if (intValue == 0) {
                    ja(D2);
                } else {
                    Ja(ga(activity, intValue));
                }
                QLog.i("TroopInfoCardBottomPart", 1, "dataObj=" + jSONObject + " keyObj=" + jSONObject2 + " retCode=" + str + " retMsg=" + str);
                return;
            } catch (Throwable th5) {
                String string = activity.getString(R.string.i6y);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026d_game_join_system_error)");
                Ja(string);
                QLog.e("TroopInfoCardBottomPart", 1, "onJoinTroopWebReq e=" + th5.getMessage());
                return;
            }
        }
        QLog.e("TroopInfoCardBottomPart", 1, "onJoinTroopWebReq, result=" + resultObj);
    }

    private final void Fa(Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        String str6;
        String str7 = null;
        if (intent != null) {
            str = intent.getStringExtra("authKey");
        } else {
            str = null;
        }
        String str8 = "";
        if (str == null) {
            str = "";
        }
        this.authKey = str;
        if (intent != null) {
            str2 = intent.getStringExtra("authSig");
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.authSig = str2;
        if (intent != null) {
            str3 = intent.getStringExtra("market_channel_source");
        } else {
            str3 = null;
        }
        this.marketChannelSourceId = str3;
        if (intent != null) {
            str4 = intent.getStringExtra("sec_biz_id");
        } else {
            str4 = null;
        }
        this.secureBizId = str4;
        int i16 = -1;
        if (intent != null) {
            i16 = intent.getIntExtra(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, -1);
        }
        this.curFilterId = i16;
        boolean z16 = false;
        if (intent != null) {
            i3 = intent.getIntExtra("D2GType", 0);
        } else {
            i3 = 0;
        }
        this.d2gType = i3;
        if (intent != null) {
            str5 = intent.getStringExtra("param_return_addr");
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str5 = "";
        }
        this.joinTroopReturnAddr = str5;
        if (intent != null) {
            z16 = intent.getBooleanExtra("fromThirdAppByOpenSDK", false);
        }
        this.isFromThirdApp = z16;
        if (intent != null) {
            str6 = intent.getStringExtra("join_troop_verify_message");
        } else {
            str6 = null;
        }
        if (str6 == null) {
            str6 = "";
        }
        this.joinTroopMsg = str6;
        if (intent != null) {
            str7 = intent.getStringExtra("KEY_SOURCE_AIO_APPEAR_FROM");
        }
        if (str7 != null) {
            str8 = str7;
        }
        this.sourceAIOAppearFrom = str8;
        QLog.i("TroopInfoCardBottomPart", 1, "TroopInfoCardFragment.parseFromIntent authKey=" + this.authKey + ", authSig=" + this.authSig + ", marketChannelSourceId=" + this.marketChannelSourceId + ", secureBizId=" + this.secureBizId + ", curFilterId=" + this.curFilterId + ", d2gType=" + this.d2gType + ", joinTroopReturnAddr=" + this.joinTroopReturnAddr + ", isFromThirdApp=" + this.isFromThirdApp + ", sourceAIOAppearFrom=" + str8);
    }

    private final void Ga(Intent intent, Activity activity) {
        Bundle extras;
        intent.putExtra("fromThirdAppByOpenSDK", true);
        Intent intent2 = activity.getIntent();
        if (intent2 != null && (extras = intent2.getExtras()) != null) {
            intent.putExtra("appid", extras.getString("appid"));
            intent.putExtra("pkg_name", extras.getString("pkg_name"));
            intent.putExtra("app_name", extras.getString("app_name"));
            intent.putExtra("action", extras.getInt("pkg_name"));
        }
    }

    private final void Ha() {
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setMessage(activity.getResources().getString(R.string.f173230i72));
        createCustomDialog.setPositiveButton(R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.af
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopInfoCardBottomPart.Ia(QQCustomDialog.this, activity, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(QQCustomDialog qQCustomDialog, Activity activity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        qQCustomDialog.cancel();
        activity.finish();
    }

    private final void Ja(final String msg2) {
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setMessage(msg2);
        createCustomDialog.setPositiveButton(R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ad
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopInfoCardBottomPart.Ka(QQCustomDialog.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ae
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopInfoCardBottomPart.La(activity, msg2, createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        qQCustomDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0026, code lost:
    
        r11 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void La(Activity activity, String msg2, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        long j3;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        ITroopCardApi iTroopCardApi = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
        String stringExtra = activity.getIntent().getStringExtra("appid");
        if (stringExtra != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        iTroopCardApi.ForwardSdkShareOption_startGameSdkCallback(activity, true, "action_game_join_group", j3, -1, msg2);
        qQCustomDialog.cancel();
        activity.finish();
    }

    private final void Ma(TroopInfo troopInfo, TroopInfo troopInfo2) {
        short s16 = troopInfo2.cGroupOption;
        if (s16 == 4 || s16 == 5) {
            troopInfo.joinTroopQuestion = troopInfo2.joinTroopQuestion;
            troopInfo.joinTroopAnswer = troopInfo2.joinTroopAnswer;
        }
        troopInfo.cGroupOption = s16;
        if (troopInfo2.isOnlyTroopMemberInviteOption()) {
            troopInfo.cGroupOption = (short) 2;
            troopInfo.setOnlyTroopMemberInviteOption(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        if (r5 != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object aa(a.AbstractC8794a.b bVar, com.tencent.mobileqq.troop.data.v vVar, String str, String str2, int i3, Continuation<? super Boolean> continuation) {
        TroopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1 troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1;
        Object coroutine_suspended;
        int i16;
        boolean z16;
        boolean z17;
        if (continuation instanceof TroopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1) {
            troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1 = (TroopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1) continuation;
            int i17 = troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1.label = i17 - Integer.MIN_VALUE;
                Object obj = troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    z16 = false;
                    if (!bVar.a()) {
                        if (vVar.i().cGroupOption != 1) {
                            if (str.length() > 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                        }
                        return Boxing.boxBoolean(true);
                    }
                    if (i3 == 5 || i3 == 14 || i3 == 10205) {
                        com.tencent.mobileqq.troop.troopcard.reborn.repo.a aVar = this.repo;
                        String troopUin = vVar.i().getTroopUin();
                        troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1.label = 1;
                        obj = aVar.c(troopUin, str2, troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Boxing.boxBoolean(z16);
                }
                z16 = ((a.d) obj).a();
                return Boxing.boxBoolean(z16);
            }
        }
        troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1 = new TroopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1(this, continuation);
        Object obj2 = troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = troopInfoCardBottomPart$checkCanJoinTroopWithoutVerify$1.label;
        if (i16 == 0) {
        }
        z16 = ((a.d) obj2).a();
        return Boxing.boxBoolean(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(final a.AbstractC8794a btnType) {
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        if (troopBasicInfoViewModel.P2()) {
            com.tencent.mobileqq.troop.utils.ab.c(getActivity());
            return;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel3 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
        } else {
            troopBasicInfoViewModel2 = troopBasicInfoViewModel3;
        }
        final com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel2.D2();
        if (D2 == null) {
            return;
        }
        AppInterface appInterface = this.appInterface;
        if (((IAddTroopAccountIdentityApi) QRoute.api(IAddTroopAccountIdentityApi.class)).isNeedAccountIdentity(D2.h())) {
            QLog.i("TroopInfoCardBottomPart", 1, "checkIdentityThenJoinTroop need identity, troopUin=" + D2.i().getTroopUin());
            ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(appInterface, 10002, getContext(), new IAddAcceptBlockStrategy.a() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.x
                @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
                public final void onSuccess() {
                    TroopInfoCardBottomPart.ca(TroopInfoCardBottomPart.this, btnType, D2);
                }
            });
            return;
        }
        QLog.i("TroopInfoCardBottomPart", 1, "checkIdentityThenJoinTroop no need identity, troopUin=" + D2.i().getTroopUin());
        da(btnType, D2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(TroopInfoCardBottomPart this$0, a.AbstractC8794a btnType, com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(btnType, "$btnType");
        Intrinsics.checkNotNullParameter(troopInfoWrapper, "$troopInfoWrapper");
        this$0.da(btnType, troopInfoWrapper);
    }

    private final void da(final a.AbstractC8794a btnType, final com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
        QLog.i("TroopInfoCardBottomPart", 1, "checkNeedSubTroopThenJoin troopUin=" + troopInfoWrapper.i().getTroopUin());
        try {
            final Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(getContext(), 2, true);
            if (showOnlyLoadingImageDialog != null) {
                showOnlyLoadingImageDialog.show();
            }
            ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).needShowSubTroopWithTroopInfo(troopInfoWrapper.i().getTroopUin(), troopInfoWrapper.i().wMemberNum, troopInfoWrapper.i().wMemberMax, true, new Function2<Boolean, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit>(showOnlyLoadingImageDialog, troopInfoWrapper, this, btnType) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart$checkNeedSubTroopThenJoin$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ a.AbstractC8794a $btnType;
                final /* synthetic */ Dialog $loadingDialog;
                final /* synthetic */ com.tencent.mobileqq.troop.data.v $troopInfoWrapper;
                final /* synthetic */ TroopInfoCardBottomPart this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$loadingDialog = showOnlyLoadingImageDialog;
                    this.$troopInfoWrapper = troopInfoWrapper;
                    this.this$0 = this;
                    this.$btnType = btnType;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, showOnlyLoadingImageDialog, troopInfoWrapper, this, btnType);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp troopJoinQunAutoSwitch$RetrieveSubGroupRsp) {
                    invoke(bool.booleanValue(), troopJoinQunAutoSwitch$RetrieveSubGroupRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), subTroopInfo);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(subTroopInfo, "subTroopInfo");
                    Dialog dialog = this.$loadingDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    QLog.i("TroopInfoCardBottomPart", 1, "needShowSubTroopWithTroopInfo needShow=" + z16 + " troopUin=" + this.$troopInfoWrapper.i().getTroopUin());
                    if (!z16 || this.this$0.getContext() == null || this.$troopInfoWrapper.i().getTroopUin() == null) {
                        this.this$0.ma(this.$btnType, this.$troopInfoWrapper);
                        return;
                    }
                    ITroopJoinApi iTroopJoinApi = (ITroopJoinApi) QRoute.api(ITroopJoinApi.class);
                    Context context = this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    String troopUin = this.$troopInfoWrapper.i().getTroopUin();
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfoWrapper.troopInfo.troopUin");
                    iTroopJoinApi.showSwitchSubTroop(context, troopUin, subTroopInfo, 1003, "pg_group_apply_profile");
                }
            });
        } catch (Throwable th5) {
            QLog.e("TroopInfoCardBottomPart", 1, "checkNeedSubTroopThenJoin, e=" + th5.getMessage());
            ma(btnType, troopInfoWrapper);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final byte[] ea(String secureBizId, String channelId) {
        boolean z16;
        Long longOrNull;
        if (secureBizId != null && secureBizId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        groupMngTransInfo$JoinGroupTransInfo groupmngtransinfo_joingrouptransinfo = new groupMngTransInfo$JoinGroupTransInfo();
        groupmngtransinfo_joingrouptransinfo.business_id.set(ByteStringMicro.copyFromUtf8(secureBizId));
        if (channelId != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            groupMngTransInfo$ChannelInfo groupmngtransinfo_channelinfo = new groupMngTransInfo$ChannelInfo();
            groupmngtransinfo_channelinfo.channel_id.set(longValue);
            groupmngtransinfo_joingrouptransinfo.channel_info.set(groupmngtransinfo_channelinfo);
        }
        return groupmngtransinfo_joingrouptransinfo.toByteArray();
    }

    private final String ga(Activity activity, int retCode) {
        if (retCode != 221002) {
            if (retCode != 221020) {
                String string = activity.getString(R.string.i6y);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026d_game_join_system_error)");
                return string;
            }
            String string2 = activity.getString(R.string.i6z);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t\u2026_card_join_pay_not_allow)");
            return string2;
        }
        String string3 = activity.getString(R.string.i6t);
        Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(com.t\u2026rd_game_already_not_join)");
        return string3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSettingShareManager ia() {
        return (TroopSettingShareManager) this.shareManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja(com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        boolean z16 = true;
        if (troopInfoWrapper.g() == 3) {
            Intent intent = new Intent();
            intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
            activity.setResult(-1, intent);
            activity.finish();
            return;
        }
        if (troopInfoWrapper.g() == 1016) {
            activity.setResult(-1, new Intent());
            activity.finish();
            com.tencent.mobileqq.troop.troopcreate.a.i(activity, troopInfoWrapper.i().getTroopUin(), troopInfoWrapper.i().getTroopDisplayName());
            return;
        }
        Intent chatActivityIntent = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getChatActivityIntent(activity, troopInfoWrapper.g());
        BaseAIOUtils.m(chatActivityIntent, new int[]{2});
        chatActivityIntent.putExtra("uin", troopInfoWrapper.i().troopuin);
        chatActivityIntent.putExtra("uintype", 1);
        String a16 = es.f307750a.a(troopInfoWrapper.h());
        if (Intrinsics.areEqual(a16, "0")) {
            if (this.sourceAIOAppearFrom.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                a16 = this.sourceAIOAppearFrom;
            }
        }
        chatActivityIntent.putExtra("key_from", a16);
        TroopInfo i3 = troopInfoWrapper.i();
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        String r26 = troopBasicInfoViewModel.r2();
        if (r26 == null) {
            r26 = "";
        }
        chatActivityIntent.putExtra("uinname", com.tencent.mobileqq.troop.troopsetting.modules.base.b.c(i3, r26));
        if (this.isFromThirdApp) {
            Intrinsics.checkNotNullExpressionValue(chatActivityIntent, "this");
            Ga(chatActivityIntent, activity);
        }
        activity.startActivity(chatActivityIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la(String intro) {
        int i3;
        boolean z16;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 == null) {
            return;
        }
        int i16 = this.d2gType;
        if (i16 != 1 && i16 != 2) {
            i3 = D2.h();
        } else {
            i3 = 18;
        }
        int i17 = i3;
        QLog.i("TroopInfoCardBottomPart", 1, "gotoJoinTroop, statOption=" + i17 + " returnAddr=" + this.joinTroopReturnAddr + ", troopUin=" + D2.i().getTroopUin());
        if (this.joinTroopReturnAddr.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intent addFriendLogicActivity_startJoinTroop = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(activity, D2.i().getTroopUin(), D2.i().troopNameFromNT, D2.i().cGroupOption, i17, D2.i().joinTroopQuestion, D2.i().joinTroopAnswer, this.joinTroopReturnAddr, activity.getResources().getString(R.string.a1o), this.authKey, this.authSig, intro);
            String f16 = D2.f();
            if (f16 != null) {
                addFriendLogicActivity_startJoinTroop.putExtra("param_scene_target_id", f16);
            }
            activity.startActivity(addFriendLogicActivity_startJoinTroop);
            return;
        }
        Intent addFriendLogicActivity_startJoinTroop2 = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(activity, D2.i().getTroopUin(), D2.i().troopNameFromNT, D2.i().cGroupOption, i17, D2.i().joinTroopQuestion, D2.i().joinTroopAnswer, null, activity.getResources().getString(R.string.a1o), this.authKey, this.authSig, intro);
        addFriendLogicActivity_startJoinTroop2.putExtra("from_newer_guide", activity.getIntent().getBooleanExtra("from_newer_guide", false));
        addFriendLogicActivity_startJoinTroop2.putExtra(AppConstants.Key.KEY_FROM_BABYQ, activity.getIntent().getBooleanExtra(AppConstants.Key.KEY_FROM_BABYQ, false));
        String f17 = D2.f();
        if (f17 != null) {
            addFriendLogicActivity_startJoinTroop2.putExtra("param_scene_target_id", f17);
        }
        activity.startActivityForResult(addFriendLogicActivity_startJoinTroop2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ma(a.AbstractC8794a btnType, com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
        QLog.i("TroopInfoCardBottomPart", 1, "handleJoinTroop btnType=" + btnType + " troopUin=" + troopInfoWrapper.i().getTroopUin());
        if (Intrinsics.areEqual(btnType, a.AbstractC8794a.C8795a.f299745a)) {
            sa();
        } else if (btnType instanceof a.AbstractC8794a.b) {
            ra((a.AbstractC8794a.b) btnType, troopInfoWrapper);
        }
    }

    private final Object na(com.tencent.mobileqq.troop.data.v vVar, a.b bVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        QLog.i("TroopInfoCardBottomPart", 1, "handleJoinTroopResult isHomework=" + vVar.i().isHomeworkTroop() + " troopUin=" + vVar.i().getTroopUin() + "statOption=" + vVar.h() + "sceneTargetId=" + vVar.f() + "result=" + bVar);
        if (bVar.e()) {
            Object pa5 = pa(bVar, vVar, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (pa5 == coroutine_suspended) {
                return pa5;
            }
            return Unit.INSTANCE;
        }
        oa(bVar, vVar);
        return Unit.INSTANCE;
    }

    private final void oa(a.b joinTroopResult, com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
        QBaseActivity qBaseActivity;
        Activity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        QBaseActivity qBaseActivity2 = qBaseActivity;
        if (qBaseActivity2 == null) {
            return;
        }
        AppInterface appInterface = this.appInterface;
        int b16 = joinTroopResult.b();
        if (b16 != 14) {
            if (b16 != 15) {
                ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed(qBaseActivity2, joinTroopResult.b());
                return;
            } else {
                if (!qBaseActivity2.isResume()) {
                    return;
                }
                com.tencent.mobileqq.troop.temporaryban.c.e().g(appInterface, qBaseActivity2, joinTroopResult.a(), troopInfoWrapper.i().troopuin);
                return;
            }
        }
        if (!qBaseActivity2.isResume()) {
            boolean z16 = true;
            if (troopInfoWrapper.i().cGroupOption != 1) {
                if (this.authKey.length() <= 0) {
                    z16 = false;
                }
                if (!z16) {
                    return;
                }
            }
        }
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).JoinTroopSecurityTipsHelper_showTips(appInterface, joinTroopResult.d(), joinTroopResult.c(), qBaseActivity2);
    }

    private final Object pa(a.b bVar, com.tencent.mobileqq.troop.data.v vVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Activity activity = getActivity();
        if (activity == null) {
            return Unit.INSTANCE;
        }
        int b16 = bVar.b();
        if (b16 != -2) {
            if (b16 != 0 && b16 != 1) {
                if (b16 != 2) {
                    new com.tencent.mobileqq.widget.ap(activity).d(2, R.string.f171048c00, 1500);
                } else {
                    new com.tencent.mobileqq.widget.ap(activity).d(2, R.string.i7i, 1500);
                }
            } else {
                Object qa5 = qa(vVar, continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (qa5 == coroutine_suspended) {
                    return qa5;
                }
                return Unit.INSTANCE;
            }
        } else {
            ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).openAddTroopWebInfo(activity, "https://qun.qq.com/joinedrecommend/index.html", vVar.i().troopuin);
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object qa(com.tencent.mobileqq.troop.data.v vVar, Continuation<? super Unit> continuation) {
        TroopInfoCardBottomPart$handleJoinTroopSucceed$1 troopInfoCardBottomPart$handleJoinTroopSucceed$1;
        Object coroutine_suspended;
        int i3;
        AppInterface appInterface;
        Activity activity;
        TroopInfo troopInfo;
        if (continuation instanceof TroopInfoCardBottomPart$handleJoinTroopSucceed$1) {
            troopInfoCardBottomPart$handleJoinTroopSucceed$1 = (TroopInfoCardBottomPart$handleJoinTroopSucceed$1) continuation;
            int i16 = troopInfoCardBottomPart$handleJoinTroopSucceed$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                troopInfoCardBottomPart$handleJoinTroopSucceed$1.label = i16 - Integer.MIN_VALUE;
                Object obj = troopInfoCardBottomPart$handleJoinTroopSucceed$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopInfoCardBottomPart$handleJoinTroopSucceed$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        AppInterface appInterface2 = (AppInterface) troopInfoCardBottomPart$handleJoinTroopSucceed$1.L$2;
                        activity = (Activity) troopInfoCardBottomPart$handleJoinTroopSucceed$1.L$1;
                        com.tencent.mobileqq.troop.data.v vVar2 = (com.tencent.mobileqq.troop.data.v) troopInfoCardBottomPart$handleJoinTroopSucceed$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        appInterface = appInterface2;
                        vVar = vVar2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Activity activity2 = getActivity();
                    if (activity2 == null) {
                        return Unit.INSTANCE;
                    }
                    appInterface = this.appInterface;
                    new com.tencent.mobileqq.widget.ap(activity2).d(2, R.string.f171049c01, 1500);
                    ja(vVar);
                    com.tencent.mobileqq.troop.troopcard.reborn.repo.a aVar = this.repo;
                    String troopUin = vVar.i().getTroopUin();
                    troopInfoCardBottomPart$handleJoinTroopSucceed$1.L$0 = vVar;
                    troopInfoCardBottomPart$handleJoinTroopSucceed$1.L$1 = activity2;
                    troopInfoCardBottomPart$handleJoinTroopSucceed$1.L$2 = appInterface;
                    troopInfoCardBottomPart$handleJoinTroopSucceed$1.label = 1;
                    Object a16 = aVar.a(troopUin, troopInfoCardBottomPart$handleJoinTroopSucceed$1);
                    if (a16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    activity = activity2;
                    obj = a16;
                }
                troopInfo = (TroopInfo) obj;
                if (troopInfo == null) {
                    troopInfo = vVar.i();
                }
                ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).addRecentTroopItemIntoRecentMsgList(appInterface, troopInfo);
                activity.finish();
                return Unit.INSTANCE;
            }
        }
        troopInfoCardBottomPart$handleJoinTroopSucceed$1 = new TroopInfoCardBottomPart$handleJoinTroopSucceed$1(this, continuation);
        Object obj2 = troopInfoCardBottomPart$handleJoinTroopSucceed$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopInfoCardBottomPart$handleJoinTroopSucceed$1.label;
        if (i3 == 0) {
        }
        troopInfo = (TroopInfo) obj2;
        if (troopInfo == null) {
        }
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).addRecentTroopItemIntoRecentMsgList(appInterface, troopInfo);
        activity.finish();
        return Unit.INSTANCE;
    }

    private final void ra(a.AbstractC8794a.b normalJoinBtnUIModel, com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
        AppInterface appInterface = this.appInterface;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        boolean z16 = true;
        QLog.i("TroopInfoCardBottomPart", 1, "handleJoinTroop pa=" + troopInfoWrapper.g() + " troopUin=" + troopInfoWrapper.i().getTroopUin());
        if (troopInfoWrapper.g() == 34 && ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).needAnswerQuestion(appInterface.getCurrentAccountUin())) {
            if (!activity.isFinishing()) {
                ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).createQuestionDialog(activity).show();
                return;
            }
            return;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(troopBasicInfoViewModel), null, null, new TroopInfoCardBottomPart$handleNormalJoinTroop$1(this, normalJoinBtnUIModel, troopInfoWrapper, null), 3, null);
        String str = this.marketChannelSourceId;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            TroopSourceHandler.d(troopInfoWrapper.i().troopuin, this.marketChannelSourceId);
        }
    }

    private final void sa() {
        Intent intent;
        AppInterface appInterface = this.appInterface;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).joinGroupOneStep(appInterface, activity, intent, new e.a() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.y
            @Override // com.tencent.mobileqq.troop.utils.e.a
            public final void rg(JSONObject jSONObject, int i3, Bundle bundle) {
                TroopInfoCardBottomPart.ta(TroopInfoCardBottomPart.this, jSONObject, i3, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(final TroopInfoCardBottomPart this$0, final JSONObject jSONObject, int i3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopInfoCardBottomPart.wa(TroopInfoCardBottomPart.this, jSONObject);
                    }
                });
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.troopcard.ui.l.d(jSONObject, new l.a() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.z
            @Override // com.tencent.mobileqq.troop.troopcard.ui.l.a
            public final void a() {
                TroopInfoCardBottomPart.ua(TroopInfoCardBottomPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(final TroopInfoCardBottomPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ab
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoCardBottomPart.va(TroopInfoCardBottomPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(TroopInfoCardBottomPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(TroopInfoCardBottomPart this$0, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ea(jSONObject);
    }

    private final void xa(final boolean needVerify, String troopUin) {
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        QLog.i("TroopInfoCardBottomPart", 1, "[joinHomeworkGroup] troopUin=" + troopUin);
        if (troopUin == null) {
            return;
        }
        if (this.modifyHWIdentityHelper == null) {
            this.modifyHWIdentityHelper = new ModifyHWTroopIdentityHelper(activity, troopUin, "TroopInfoCardBottomPart", new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ac
                @Override // java.lang.Runnable
                public final void run() {
                    TroopInfoCardBottomPart.za(activity);
                }
            }, null, new Function1<String, Unit>(needVerify) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart$joinHomeworkGroup$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $needVerify;

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart$joinHomeworkGroup$2$1", f = "TroopInfoCardBottomPart.kt", i = {}, l = {MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart$joinHomeworkGroup$2$1, reason: invalid class name */
                /* loaded from: classes19.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.mobileqq.troop.data.v $troopInfoWrapper;
                    int label;
                    final /* synthetic */ TroopInfoCardBottomPart this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(TroopInfoCardBottomPart troopInfoCardBottomPart, com.tencent.mobileqq.troop.data.v vVar, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = troopInfoCardBottomPart;
                        this.$troopInfoWrapper = vVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, troopInfoCardBottomPart, vVar, continuation);
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                        }
                        return new AnonymousClass1(this.this$0, this.$troopInfoWrapper, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended;
                        Object Aa;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i3 = this.label;
                            if (i3 != 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                TroopInfoCardBottomPart troopInfoCardBottomPart = this.this$0;
                                com.tencent.mobileqq.troop.data.v vVar = this.$troopInfoWrapper;
                                this.label = 1;
                                Aa = troopInfoCardBottomPart.Aa(vVar, this);
                                if (Aa == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$needVerify = needVerify;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, TroopInfoCardBottomPart.this, Boolean.valueOf(needVerify));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    TroopBasicInfoViewModel troopBasicInfoViewModel;
                    TroopBasicInfoViewModel troopBasicInfoViewModel2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    troopBasicInfoViewModel = TroopInfoCardBottomPart.this.basicInfoViewModel;
                    if (troopBasicInfoViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                        troopBasicInfoViewModel = null;
                    }
                    com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
                    if (D2 != null && D2.i().isHomeworkTroop()) {
                        if (this.$needVerify) {
                            TroopInfoCardBottomPart.this.la(it);
                            return;
                        }
                        troopBasicInfoViewModel2 = TroopInfoCardBottomPart.this.basicInfoViewModel;
                        if (troopBasicInfoViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                            troopBasicInfoViewModel2 = null;
                        }
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(troopBasicInfoViewModel2), null, null, new AnonymousClass1(TroopInfoCardBottomPart.this, D2, null), 3, null);
                    }
                }
            });
        }
        ModifyHWTroopIdentityHelper modifyHWTroopIdentityHelper = this.modifyHWIdentityHelper;
        if (modifyHWTroopIdentityHelper != null) {
            modifyHWTroopIdentityHelper.j(IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.finish();
    }

    @NotNull
    public final AppInterface ha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appInterface;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.yah);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.join_troop_btn)");
        this.joinTroopBtn = (QUIButton) findViewById;
        View findViewById2 = rootView.findViewById(R.id.inf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.send_msg_btn)");
        this.sendMsgBtn = (QUIButton) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.m8q);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.share_troop_btn)");
        this.shareBtn = (QUIButton) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.uqe);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.edit_info_btn)");
        this.editInfoBtn = (QUIButton) findViewById4;
        QUIButton qUIButton = this.joinTroopBtn;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
            qUIButton = null;
        }
        qUIButton.setAccessibilityTraversalAfter(R.id.kwk);
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a> q26 = troopBasicInfoViewModel.q2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final TroopInfoCardBottomPart$onInitView$1 troopInfoCardBottomPart$onInitView$1 = new TroopInfoCardBottomPart$onInitView$1(this);
        q26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBottomPart.Da(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel2 = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel2.D2();
        if (D2 != null) {
            String troopUin = D2.i().getTroopUin();
            if (troopUin != null && troopUin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QUIButton qUIButton3 = this.joinTroopBtn;
                if (qUIButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
                    qUIButton3 = null;
                }
                String troopUin2 = D2.i().getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin2, "troopInfoWrapper.troopInfo.troopUin");
                TroopCardDtHelper.i(qUIButton3, troopUin2, this.secureBizId, D2.h());
                QUIButton qUIButton4 = this.sendMsgBtn;
                if (qUIButton4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendMsgBtn");
                    qUIButton4 = null;
                }
                String troopUin3 = D2.i().getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin3, "troopInfoWrapper.troopInfo.troopUin");
                TroopCardDtHelper.t(qUIButton4, troopUin3);
                QUIButton qUIButton5 = this.sendMsgBtn;
                if (qUIButton5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendMsgBtn");
                    qUIButton5 = null;
                }
                String troopUin4 = D2.i().getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin4, "troopInfoWrapper.troopInfo.troopUin");
                TroopCardDtHelper.v(qUIButton5, troopUin4);
                QUIButton qUIButton6 = this.editInfoBtn;
                if (qUIButton6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editInfoBtn");
                } else {
                    qUIButton2 = qUIButton6;
                }
                String troopUin5 = D2.i().getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin5, "troopInfoWrapper.troopInfo.troopUin");
                TroopCardDtHelper.j(qUIButton2, troopUin5);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        Intent intent;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QRouteApi api = QRoute.api(ITroopShareUtility.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopShareUtility::class.java)");
        this.troopShareUtil = (ITroopShareUtility) api;
        Integer num2 = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        Fa(intent);
        ViewModel viewModel = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopBasicInfoViewModel::class.java)");
        TroopBasicInfoViewModel troopBasicInfoViewModel = (TroopBasicInfoViewModel) viewModel;
        this.basicInfoViewModel = troopBasicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 != null) {
            num = Integer.valueOf(D2.h());
        } else {
            num = null;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel2 = null;
        }
        com.tencent.mobileqq.troop.data.v D22 = troopBasicInfoViewModel2.D2();
        if (D22 != null) {
            num2 = Integer.valueOf(D22.g());
        }
        QLog.i("TroopInfoCardBottomPart", 1, "onPartCreate statOption=" + num + ", sourceId=" + num2 + ", ");
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        ModifyHWTroopIdentityHelper modifyHWTroopIdentityHelper = this.modifyHWIdentityHelper;
        if (modifyHWTroopIdentityHelper != null) {
            modifyHWTroopIdentityHelper.g();
        }
        ITroopShareUtility iTroopShareUtility = this.troopShareUtil;
        if (iTroopShareUtility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopShareUtil");
            iTroopShareUtility = null;
        }
        iTroopShareUtility.onDestroy();
    }
}
