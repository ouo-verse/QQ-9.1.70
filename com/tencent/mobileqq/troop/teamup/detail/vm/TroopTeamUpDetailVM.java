package com.tencent.mobileqq.troop.teamup.detail.vm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWUploaderWrapper;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseMediaItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.h;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.i;
import com.tencent.mobileqq.troop.teamup.detail.common.TroopTeamUploadPicUtils;
import com.tencent.mobileqq.troop.teamup.member.event.TroopTeamUpUpdateEvent;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpImage;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u0081\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0082\u0001B\b\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00042\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001eJ\b\u0010#\u001a\u00020\u0004H\u0014J\u0012\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&0\nH\u0016R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b5\u00106R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\"\u0010D\u001a\u00020=8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010H\u001a\u00020=8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bE\u0010?\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR$\u0010N\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR$\u0010T\u001a\u00020O2\u0006\u0010I\u001a\u00020O8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020V0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010WR\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020V0Y8\u0006\u00a2\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000f0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010WR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000f0Y8\u0006\u00a2\u0006\f\n\u0004\ba\u0010[\u001a\u0004\bb\u0010]R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00060U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010WR\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00060Y8\u0006\u00a2\u0006\f\n\u0004\bf\u0010[\u001a\u0004\bg\u0010]R\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020i0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010WR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020i0Y8\u0006\u00a2\u0006\f\n\u0004\bl\u0010[\u001a\u0004\bm\u0010]R\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020o0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010WR\u001d\u0010t\u001a\b\u0012\u0004\u0012\u00020o0Y8\u0006\u00a2\u0006\f\n\u0004\br\u0010[\u001a\u0004\bs\u0010]R\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020\u000f0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010WR\u001d\u0010y\u001a\b\u0012\u0004\u0012\u00020\u000f0Y8\u0006\u00a2\u0006\f\n\u0004\bw\u0010[\u001a\u0004\bx\u0010]R\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00020=0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010WR\u001d\u0010~\u001a\b\u0012\u0004\u0012\u00020=0Y8\u0006\u00a2\u0006\f\n\u0004\b|\u0010[\u001a\u0004\b}\u0010]\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "q2", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detail", "y2", "p2", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpImage;", "Lkotlin/collections/ArrayList;", "pictures", "X1", "", "height", "r2", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, ICustomDataEditor.STRING_PARAM_2, "t2", "Landroid/os/Bundle;", "args", "init", "u2", "W1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "v2", "Landroid/content/Intent;", "data", ICustomDataEditor.NUMBER_PARAM_2, "intent", "o2", "onCleared", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/troop/teamup/detail/repo/c;", "i", "Lkotlin/Lazy;", "f2", "()Lcom/tencent/mobileqq/troop/teamup/detail/repo/c;", "repo", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e2", "()Lcom/tencent/mobileqq/troop/teamup/detail/vm/b;", "mediaManager", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWUploaderWrapper;", BdhLogUtil.LogTag.Tag_Conn, "m2", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWUploaderWrapper;", "uploader", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", "D", "Ljava/util/List;", "uploadingItem", "", "E", "Ljava/lang/String;", "k2", "()Ljava/lang/String;", "x2", "(Ljava/lang/String;)V", "troopUin", UserInfo.SEX_FEMALE, "i2", "w2", "teamId", "<set-?>", "G", "I", "j2", "()I", "templateId", "", "H", "Z", SemanticAttributes.DbSystemValues.H2, "()Z", "showMore", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/data/b;", "Landroidx/lifecycle/MutableLiveData;", "_errorResult", "Landroidx/lifecycle/LiveData;", "J", "Landroidx/lifecycle/LiveData;", "c2", "()Landroidx/lifecycle/LiveData;", "errorResult", "K", "_role", "L", "g2", "role", "M", "_detailData", "N", ICustomDataEditor.STRING_ARRAY_PARAM_2, "detailData", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/data/a;", "P", "_applyResult", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z1", "applyResult", "Lcom/tencent/mobileqq/troop/troopjoin/TryJoinTroopResult;", BdhLogUtil.LogTag.Tag_Req, "_joinTroopResult", ExifInterface.LATITUDE_SOUTH, "d2", "joinTroopResult", "T", "_uploadStatus", "U", "l2", "uploadStatus", "V", "_errMsg", "W", "b2", "errMsg", "<init>", "()V", "X", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailVM extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy uploader;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<BaseMediaItem> uploadingItem;

    /* renamed from: E, reason: from kotlin metadata */
    public String troopUin;

    /* renamed from: F, reason: from kotlin metadata */
    public String teamId;

    /* renamed from: G, reason: from kotlin metadata */
    private int templateId;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean showMore;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.b> _errorResult;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.b> errorResult;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _role;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> role;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TeamUpTeamDetail> _detailData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<TeamUpTeamDetail> detailData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.a> _applyResult;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.a> applyResult;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TryJoinTroopResult> _joinTroopResult;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LiveData<TryJoinTroopResult> joinTroopResult;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _uploadStatus;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> uploadStatus;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _errMsg;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> errMsg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy repo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM$a;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "a", "", "DATA_EXPIRED_TIME", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final TroopTeamUpDetailVM a(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopTeamUpDetailVM) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fragment);
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            ViewModel viewModel = new ViewModelProvider(fragment).get(TroopTeamUpDetailVM.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026amUpDetailVM::class.java)");
            return (TroopTeamUpDetailVM) viewModel;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55749);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpDetailVM() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopTeamUpDetailVM$repo$2.INSTANCE);
            this.repo = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$mediaManager$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$mediaManager$2$1, reason: invalid class name */
                /* loaded from: classes19.dex */
                public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
                    static IPatchRedirector $redirector_;

                    AnonymousClass1(Object obj) {
                        super(1, obj, TroopTeamUpDetailVM.class, "onNotifyRecyclerViewHeight", "onNotifyRecyclerViewHeight(I)V", 0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, obj);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        ((TroopTeamUpDetailVM) this.receiver).r2(i3);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new b(TroopTeamUpDetailVM.this.k2(), ViewModelKt.getViewModelScope(TroopTeamUpDetailVM.this), new AnonymousClass1(TroopTeamUpDetailVM.this)) : (b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mediaManager = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<HWUploaderWrapper>() { // from class: com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$uploader$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$uploader$2$1, reason: invalid class name */
                /* loaded from: classes19.dex */
                public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<BaseItem, Unit> {
                    static IPatchRedirector $redirector_;

                    AnonymousClass1(Object obj) {
                        super(1, obj, TroopTeamUpDetailVM.class, "onUploadProgressCallback", "onUploadProgressCallback(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;)V", 0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, obj);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BaseItem baseItem) {
                        invoke2(baseItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable BaseItem baseItem) {
                        ((TroopTeamUpDetailVM) this.receiver).s2(baseItem);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM$uploader$2$2, reason: invalid class name */
                /* loaded from: classes19.dex */
                public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<BaseItem, Unit> {
                    static IPatchRedirector $redirector_;

                    AnonymousClass2(Object obj) {
                        super(1, obj, TroopTeamUpDetailVM.class, "onUploadStatusCallback", "onUploadStatusCallback(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;)V", 0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, obj);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BaseItem baseItem) {
                        invoke2(baseItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable BaseItem baseItem) {
                        ((TroopTeamUpDetailVM) this.receiver).t2(baseItem);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final HWUploaderWrapper invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new HWUploaderWrapper(2018, TroopTeamUpDetailVM.this.k2(), ViewModelKt.getViewModelScope(TroopTeamUpDetailVM.this), new AnonymousClass1(TroopTeamUpDetailVM.this), new AnonymousClass2(TroopTeamUpDetailVM.this)) : (HWUploaderWrapper) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.uploader = lazy3;
            this.uploadingItem = new ArrayList();
            MutableLiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.b> mutableLiveData = new MutableLiveData<>();
            this._errorResult = mutableLiveData;
            this.errorResult = mutableLiveData;
            MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
            this._role = mutableLiveData2;
            this.role = mutableLiveData2;
            MutableLiveData<TeamUpTeamDetail> mutableLiveData3 = new MutableLiveData<>();
            this._detailData = mutableLiveData3;
            this.detailData = mutableLiveData3;
            MutableLiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.a> mutableLiveData4 = new MutableLiveData<>();
            this._applyResult = mutableLiveData4;
            this.applyResult = mutableLiveData4;
            MutableLiveData<TryJoinTroopResult> mutableLiveData5 = new MutableLiveData<>();
            this._joinTroopResult = mutableLiveData5;
            this.joinTroopResult = mutableLiveData5;
            MutableLiveData<Integer> mutableLiveData6 = new MutableLiveData<>();
            this._uploadStatus = mutableLiveData6;
            this.uploadStatus = mutableLiveData6;
            MutableLiveData<String> mutableLiveData7 = new MutableLiveData<>();
            this._errMsg = mutableLiveData7;
            this.errMsg = mutableLiveData7;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void X1(ArrayList<TeamUpImage> pictures) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopTeamUpDetailVM$applyTeamUp$1(this, pictures, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.teamup.detail.repo.c f2() {
        return (com.tencent.mobileqq.troop.teamup.detail.repo.c) this.repo.getValue();
    }

    private final HWUploaderWrapper m2() {
        return (HWUploaderWrapper) this.uploader.getValue();
    }

    private final void p2(TeamUpTeamDetail detail) {
        String str;
        int i3;
        Integer value;
        if (this._role.getValue() == null || ((value = this._role.getValue()) != null && value.intValue() == 0)) {
            MutableLiveData<Integer> mutableLiveData = this._role;
            AppRuntime f16 = bg.f();
            if (f16 != null) {
                str = f16.getCurrentUin();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, String.valueOf(detail.creator.uin))) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            mutableLiveData.setValue(i3);
            QLog.d("TroopTeamUpDetailVM", 1, "initRole: troopUin=" + k2() + ", teamId=" + i2() + ", role=" + this._role.getValue());
        }
    }

    private final void q2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopTeamUpDetailVM$loadData$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t2(BaseItem item) {
        int collectionSizeOrDefault;
        if (item == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamUpDetailVM", 2, "onUploadStatusCallback: item.name=" + item.getFileName() + ", item.http=" + item.getHttpUrl() + ", item.local=" + item.getLocalPath() + ", status=" + item.getState());
        }
        boolean z16 = true;
        boolean z17 = true;
        for (BaseMediaItem baseMediaItem : this.uploadingItem) {
            UploadOrDownloadState state = baseMediaItem.getState();
            UploadOrDownloadState uploadOrDownloadState = UploadOrDownloadState.UPLOAD_SUC;
            if (state != uploadOrDownloadState && baseMediaItem.getState() != UploadOrDownloadState.UPLOAD_ERR) {
                z16 = false;
            }
            if (baseMediaItem.getState() != uploadOrDownloadState) {
                z17 = false;
            }
        }
        if (z16) {
            if (z17) {
                this._uploadStatus.postValue(2);
                List<BaseMediaItem> list = this.uploadingItem;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (BaseMediaItem baseMediaItem2 : list) {
                    TeamUpImage teamUpImage = new TeamUpImage();
                    teamUpImage.width = baseMediaItem2.getWidth();
                    teamUpImage.height = baseMediaItem2.getHeight();
                    String httpUrl = baseMediaItem2.getHttpUrl();
                    String str = "";
                    if (httpUrl == null) {
                        httpUrl = "";
                    }
                    teamUpImage.picUrl = httpUrl;
                    String fileMd5 = baseMediaItem2.getFileMd5();
                    if (fileMd5 != null) {
                        str = fileMd5;
                    }
                    teamUpImage.md5 = str;
                    arrayList.add(teamUpImage);
                }
                X1(new ArrayList<>(arrayList));
                return;
            }
            this._uploadStatus.postValue(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y2(TeamUpTeamDetail detail) {
        p2(detail);
        this._detailData.postValue(detail);
        e2().x(detail);
    }

    public final void W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            X1(new ArrayList<>());
        }
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.a> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LiveData) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.applyResult;
    }

    @NotNull
    public final LiveData<TeamUpTeamDetail> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LiveData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.detailData;
    }

    @NotNull
    public final LiveData<String> b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (LiveData) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.errMsg;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.b> c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.errorResult;
    }

    @NotNull
    public final LiveData<TryJoinTroopResult> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LiveData) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.joinTroopResult;
    }

    @NotNull
    public final b e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (b) this.mediaManager.getValue();
    }

    @NotNull
    public final LiveData<Integer> g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LiveData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.role;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ArrayList) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(TroopTeamUpUpdateEvent.UpdateJoinTeamUp.class);
        return arrayList;
    }

    public final boolean h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.showMore;
    }

    @NotNull
    public final String i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = this.teamId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("teamId");
        return null;
    }

    public final void init(@NotNull Bundle args) {
        TeamUpTeamDetail teamUpTeamDetail;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) args);
            return;
        }
        Intrinsics.checkNotNullParameter(args, "args");
        String string = args.getString("KEY_TROOP_UIN");
        String str = "";
        if (string == null) {
            string = "";
        }
        x2(string);
        String string2 = args.getString("KEY_TEAM_ID");
        if (string2 != null) {
            str = string2;
        }
        w2(str);
        this.showMore = args.getBoolean("KEY_SHOW_MORE");
        this.templateId = args.getInt("KEY_TEMP_ID");
        Serializable serializable = args.getSerializable("KEY_DETAIL");
        if (serializable instanceof TeamUpTeamDetail) {
            teamUpTeamDetail = (TeamUpTeamDetail) serializable;
        } else {
            teamUpTeamDetail = null;
        }
        if (teamUpTeamDetail != null && Intrinsics.areEqual(teamUpTeamDetail.teamId, i2())) {
            y2(teamUpTeamDetail);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamUpDetailVM", 2, "onCreate: troopUin=" + k2() + ", teamId=" + i2() + ", detail=" + teamUpTeamDetail);
        }
        q2();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final int j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.templateId;
    }

    @NotNull
    public final String k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = this.troopUin;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("troopUin");
        return null;
    }

    @NotNull
    public final LiveData<Integer> l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LiveData) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.uploadStatus;
    }

    public final void n2(@NotNull Intent data) {
        BaseMediaItem imageItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Integer value = this._uploadStatus.getValue();
        if (value != null && value.intValue() != 0) {
            QLog.e("TroopTeamUpDetailVM", 1, "handleSelectMediaResult: upload status error " + value);
            return;
        }
        i c16 = TroopTeamUploadPicUtils.f298872a.c(data);
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamUpDetailVM", 2, "handleSelectMediaResult: result.size=" + c16.a().size());
        }
        if (c16.a().isEmpty()) {
            QLog.e("TroopTeamUpDetailVM", 1, "handleSelectMediaResult: result empty");
            return;
        }
        this._uploadStatus.postValue(1);
        for (h hVar : c16.a()) {
            if (hVar.e()) {
                imageItem = new VideoItem();
            } else {
                imageItem = new ImageItem();
            }
            imageItem.setFileSize(hVar.c());
            imageItem.setLocalFile(true);
            imageItem.setLocalPath(hVar.b());
            imageItem.setSupportDelete(true);
            imageItem.setWidth(hVar.d());
            imageItem.setHeight(hVar.a());
            this.uploadingItem.add(imageItem);
            m2().i(imageItem);
        }
    }

    public final void o2(@NotNull Intent intent) {
        List<LocalMediaInfo> e16;
        BaseMediaItem imageItem;
        h hVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Integer value = this._uploadStatus.getValue();
        if (value != null && value.intValue() != 0) {
            QLog.e("TroopTeamUpDetailVM", 1, "handleSelectMediaResult: upload status error " + value);
            return;
        }
        AlbumResult albumResult = (AlbumResult) intent.getParcelableExtra("ALBUM_RESULT");
        if (albumResult == null || (e16 = albumResult.e()) == null) {
            return;
        }
        ArrayList<h> arrayList = new ArrayList();
        for (LocalMediaInfo localMediaInfo : e16) {
            String path = localMediaInfo.getPath();
            if (path != null) {
                long fileSize = localMediaInfo.getFileSize();
                if (QAlbumUtil.getMediaType(localMediaInfo.getPath()) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                hVar = new h(path, fileSize, z16, localMediaInfo.getMediaWidth(), localMediaInfo.getMediaHeight());
            } else {
                hVar = null;
            }
            if (hVar != null) {
                arrayList.add(hVar);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamUpDetailVM", 2, "handleSelectMediaResult: result.size=" + arrayList.size());
        }
        if (arrayList.isEmpty()) {
            QLog.e("TroopTeamUpDetailVM", 1, "handleSelectMediaResult: result empty");
            return;
        }
        this._uploadStatus.postValue(1);
        for (h hVar2 : arrayList) {
            if (hVar2.e()) {
                imageItem = new VideoItem();
            } else {
                imageItem = new ImageItem();
            }
            imageItem.setFileSize(hVar2.c());
            imageItem.setLocalFile(true);
            imageItem.setLocalPath(hVar2.b());
            imageItem.setSupportDelete(true);
            imageItem.setWidth(hVar2.d());
            imageItem.setHeight(hVar2.a());
            this.uploadingItem.add(imageItem);
            m2().i(imageItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.onCleared();
        JobKt__JobKt.cancelChildren$default(ViewModelKt.getViewModelScope(this).getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope(this), null, 1, null);
        e2().i();
        m2().c();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) event);
            return;
        }
        if (event instanceof TroopTeamUpUpdateEvent.UpdateJoinTeamUp) {
            TeamUpTeamDetail value = this._detailData.getValue();
            if (value != null) {
                value.joinedCnt = ((TroopTeamUpUpdateEvent.UpdateJoinTeamUp) event).getTeamUpTeamDetail().joinedCnt;
            }
            TeamUpTeamDetail value2 = this._detailData.getValue();
            if (value2 != null) {
                value2.joinedCnt = ((TroopTeamUpUpdateEvent.UpdateJoinTeamUp) event).getTeamUpTeamDetail().joinedCnt;
                this._detailData.postValue(value2);
            }
        }
    }

    public final void u2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            q2();
        }
    }

    public final void v2(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopTeamUpDetailVM$requestJoinTroop$1(this, activity, null), 3, null);
        }
    }

    public final void w2(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.teamId = str;
        }
    }

    public final void x2(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.troopUin = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(int height) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(BaseItem item) {
    }
}
