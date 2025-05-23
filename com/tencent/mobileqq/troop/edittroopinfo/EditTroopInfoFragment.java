package com.tencent.mobileqq.troop.edittroopinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.avatar.e;
import com.tencent.mobileqq.troop.avatar.f;
import com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopClassifyPart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopGamePart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopIntroPart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopLocationPart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopNamePart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopSchoolPart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopTagsPart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopTitlePart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.cover.EditTroopCoverPart;
import com.tencent.mobileqq.troop.edittroopinfo.parts.g;
import com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameItemHelper;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.report.TroopFeatureReport;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0001lB\u0007\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010#\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002060\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00104R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010U\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010NR\u001b\u0010Z\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010R\u001a\u0004\bY\u0010TR\u0016\u0010\\\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010NR\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010R\u001a\u0004\b_\u0010`R\u001b\u0010f\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010R\u001a\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010N\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/EditTroopInfoFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/troop/avatar/TroopPhotoController$e;", "", "wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "contentView", "onViewCreatedAfterPartInit", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", OcrConfig.CHINESE, "Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameItemHelper;", "Ah", "", "isCover", "Dh", "bundle", "Z9", "Landroid/content/Intent;", "newIntent", "onNewIntent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "isWrapContent", "needImmersive", "beforeFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "D", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recycleView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "E", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/b;", UserInfo.SEX_FEMALE, "Ljava/util/List;", "groupParts", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/a;", "G", "bottomGroupConfigParts", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopTitlePart;", "H", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopTitlePart;", "titlePart", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/EditTroopCoverPart;", "I", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/cover/EditTroopCoverPart;", "coverPart", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/c;", "J", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/c;", "avatarPart", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopGamePart;", "K", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopGamePart;", "gamePart", "Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel;", "L", "Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel;", "viewModel", "M", "Z", "hasInitPhotoController", "Lcom/tencent/mobileqq/troop/avatar/TroopPhotoController;", "N", "Lkotlin/Lazy;", "yh", "()Lcom/tencent/mobileqq/troop/avatar/TroopPhotoController;", "coverPhotoController", "P", "hasInitAvatarController", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "xh", "avatarPhotoController", BdhLogUtil.LogTag.Tag_Req, "hasPhotoManagerObserver", "Lcom/tencent/mobileqq/troop/avatar/e;", ExifInterface.LATITUDE_SOUTH, "Ch", "()Lcom/tencent/mobileqq/troop/avatar/e;", "uploadPhotoManager", "Ljava/util/Observer;", "T", "Bh", "()Ljava/util/Observer;", "uploadObserver", "U", "isFromCover", "<init>", "()V", "V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopInfoFragment extends QPublicBaseFragment implements TroopPhotoController.e {
    static IPatchRedirector $redirector_;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private QUISettingsRecyclerView recycleView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private QUIListItemAdapter adapter;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.troop.edittroopinfo.parts.base.b> groupParts;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.troop.edittroopinfo.parts.base.a> bottomGroupConfigParts;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final EditTroopTitlePart titlePart;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final EditTroopCoverPart coverPart;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.edittroopinfo.parts.c avatarPart;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final EditTroopGamePart gamePart;

    /* renamed from: L, reason: from kotlin metadata */
    private TroopEditInfoViewModel viewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean hasInitPhotoController;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy coverPhotoController;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasInitAvatarController;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy avatarPhotoController;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean hasPhotoManagerObserver;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy uploadPhotoManager;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy uploadObserver;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isFromCover;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/EditTroopInfoFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.EditTroopInfoFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/edittroopinfo/EditTroopInfoFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopInfoFragment.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            LinearLayoutManager linearLayoutManager;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null) {
                EditTroopInfoFragment editTroopInfoFragment = EditTroopInfoFragment.this;
                View findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
                if (findViewByPosition != null) {
                    i3 = findViewByPosition.getTop();
                } else {
                    i3 = 0;
                }
                if (i3 >= (-recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.dgq))) {
                    z16 = false;
                }
                editTroopInfoFragment.titlePart.J9(z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31440);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EditTroopInfoFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.adapter = new QUIListItemAdapter(null, false, true, 3, null);
        this.groupParts = new ArrayList();
        this.bottomGroupConfigParts = new ArrayList();
        this.titlePart = new EditTroopTitlePart();
        this.coverPart = new EditTroopCoverPart(this);
        this.avatarPart = new com.tencent.mobileqq.troop.edittroopinfo.parts.c();
        this.gamePart = new EditTroopGamePart(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopPhotoController>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.EditTroopInfoFragment$coverPhotoController$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopInfoFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopPhotoController invoke() {
                TroopEditInfoViewModel troopEditInfoViewModel;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TroopPhotoController) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context context = EditTroopInfoFragment.this.getContext();
                FragmentActivity activity = EditTroopInfoFragment.this.getActivity();
                AppInterface e16 = bg.e();
                Bundle bundle = new Bundle();
                troopEditInfoViewModel = EditTroopInfoFragment.this.viewModel;
                if (troopEditInfoViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    troopEditInfoViewModel = null;
                }
                bundle.putString("troopUin", troopEditInfoViewModel.m2());
                bundle.putInt("type", 1);
                Unit unit = Unit.INSTANCE;
                TroopPhotoController troopPhotoController = new TroopPhotoController(context, activity, e16, bundle);
                EditTroopInfoFragment editTroopInfoFragment = EditTroopInfoFragment.this;
                editTroopInfoFragment.hasInitPhotoController = true;
                troopPhotoController.N(editTroopInfoFragment);
                return troopPhotoController;
            }
        });
        this.coverPhotoController = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopAvatarController>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.EditTroopInfoFragment$avatarPhotoController$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopInfoFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopAvatarController invoke() {
                TroopEditInfoViewModel troopEditInfoViewModel;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TroopAvatarController) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context context = EditTroopInfoFragment.this.getContext();
                FragmentActivity activity = EditTroopInfoFragment.this.getActivity();
                AppInterface e16 = bg.e();
                Bundle bundle = new Bundle();
                troopEditInfoViewModel = EditTroopInfoFragment.this.viewModel;
                if (troopEditInfoViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    troopEditInfoViewModel = null;
                }
                bundle.putString("troopUin", troopEditInfoViewModel.m2());
                bundle.putInt("type", 1);
                Unit unit = Unit.INSTANCE;
                TroopAvatarController troopAvatarController = new TroopAvatarController(context, activity, e16, bundle);
                EditTroopInfoFragment editTroopInfoFragment = EditTroopInfoFragment.this;
                editTroopInfoFragment.hasInitAvatarController = true;
                troopAvatarController.N(editTroopInfoFragment);
                return troopAvatarController;
            }
        });
        this.avatarPhotoController = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.EditTroopInfoFragment$uploadPhotoManager$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopInfoFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                TroopEditInfoViewModel troopEditInfoViewModel;
                Observer Bh;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                troopEditInfoViewModel = EditTroopInfoFragment.this.viewModel;
                if (troopEditInfoViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    troopEditInfoViewModel = null;
                }
                e eVar = new e(troopEditInfoViewModel.m2(), f.class, bg.e());
                EditTroopInfoFragment editTroopInfoFragment = EditTroopInfoFragment.this;
                Bh = editTroopInfoFragment.Bh();
                eVar.b(Bh);
                editTroopInfoFragment.hasPhotoManagerObserver = true;
                return eVar;
            }
        });
        this.uploadPhotoManager = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new EditTroopInfoFragment$uploadObserver$2(this));
        this.uploadObserver = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observer Bh() {
        return (Observer) this.uploadObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e Ch() {
        return (e) this.uploadPhotoManager.getValue();
    }

    private final void wh() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.groupParts.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((com.tencent.mobileqq.troop.edittroopinfo.parts.base.b) it.next()).I9());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it5 = this.bottomGroupConfigParts.iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.widget.listitem.a<?> I9 = ((com.tencent.mobileqq.troop.edittroopinfo.parts.base.a) it5.next()).I9();
            if (I9 != null) {
                arrayList2.add(I9);
            }
        }
        Object[] array = arrayList2.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        arrayList.add(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        Object[] array2 = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Group[] groupArr = (Group[]) array2;
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
    }

    private final TroopPhotoController xh() {
        return (TroopPhotoController) this.avatarPhotoController.getValue();
    }

    private final TroopPhotoController yh() {
        return (TroopPhotoController) this.coverPhotoController.getValue();
    }

    @Nullable
    public final TroopBindGameItemHelper Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopBindGameItemHelper) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.gamePart.U9();
    }

    public final void Dh(boolean isCover) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isCover);
            return;
        }
        TroopEditInfoViewModel troopEditInfoViewModel = this.viewModel;
        Boolean bool = null;
        if (troopEditInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopEditInfoViewModel = null;
        }
        TroopInfo g26 = troopEditInfoViewModel.g2();
        if (g26 != null) {
            bool = Boolean.valueOf(g26.isOwnerOrAdmin());
        }
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment", 2, "[showPickPicActionSheet] isCover:" + isCover + ", isOwnerOrAdmin:" + bool);
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return;
        }
        this.isFromCover = isCover;
        if (isCover) {
            yh().H();
        } else {
            xh().H();
        }
        String str = Ch().f294549c;
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.e
    public void Z9(@Nullable Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
            return;
        }
        TroopEditInfoViewModel troopEditInfoViewModel = this.viewModel;
        TroopEditInfoViewModel troopEditInfoViewModel2 = null;
        if (troopEditInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopEditInfoViewModel = null;
        }
        TroopInfo g26 = troopEditInfoViewModel.g2();
        if (g26 == null) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopAvatarWallEditActivityClass());
        bundle.putInt("index", 0);
        bundle.putString("troop_uin", g26.getTroopUin());
        bundle.putLong("troop_flag_ext", g26.dwGroupFlagExt);
        TroopEditInfoViewModel troopEditInfoViewModel3 = this.viewModel;
        if (troopEditInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            troopEditInfoViewModel2 = troopEditInfoViewModel3;
        }
        bundle.putInt(AppConstants.Key.TROOP_INFO_TROOP_AUTH_SUBMIT_TIME, troopEditInfoViewModel2.d2());
        bundle.putBoolean(AppConstants.Key.TROOP_INFO_IS_MEMBER, true);
        bundle.putBoolean("isUseClassAvatar", g26.isUseClassAvatar());
        intent.putExtras(bundle);
        intent.addFlags(603979776);
        boolean z16 = bundle.getBoolean("IS_COVER");
        if (z16) {
            this.isFromCover = true;
            i3 = 258;
        } else {
            this.isFromCover = false;
            i3 = 260;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment", 2, "[gotoBigPic] isCover:" + z16);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<com.tencent.mobileqq.troop.edittroopinfo.parts.base.b> mutableListOf;
        List<com.tencent.mobileqq.troop.edittroopinfo.parts.base.a> mutableListOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.titlePart, this.coverPart, this.avatarPart, new EditTroopNamePart(this));
            this.groupParts = mutableListOf;
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(new EditTroopIntroPart(this), new EditTroopClassifyPart(this), new EditTroopSchoolPart(this), this.gamePart, new EditTroopTagsPart(this), new EditTroopLocationPart(this));
            this.bottomGroupConfigParts = mutableListOf2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new g());
            arrayList.addAll(this.groupParts);
            arrayList.addAll(this.bottomGroupConfigParts);
            return arrayList;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        FragmentActivity activity;
        FragmentActivity activity2;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.beforeFinish();
        TroopEditInfoViewModel troopEditInfoViewModel = this.viewModel;
        TroopEditInfoViewModel troopEditInfoViewModel2 = null;
        if (troopEditInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopEditInfoViewModel = null;
        }
        if (troopEditInfoViewModel.Z1() != 28 && (activity2 = getActivity()) != null) {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                intent = activity3.getIntent();
            } else {
                intent = null;
            }
            activity2.setResult(-1, intent);
        }
        TroopEditInfoViewModel troopEditInfoViewModel3 = this.viewModel;
        if (troopEditInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            troopEditInfoViewModel2 = troopEditInfoViewModel3;
        }
        if (troopEditInfoViewModel2.b2() && (activity = getActivity()) != null) {
            ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).goToMsgList(activity);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 257 && resultCode == -1) {
            if (QLog.isColorLevel()) {
                QLog.i("EditTroopInfoFragment", 2, "[onActivityResult] isFromCover:" + this.isFromCover);
            }
            if (this.isFromCover) {
                yh().I();
            } else {
                xh().I();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment", 2, "[onCreate] ");
        }
        ViewModel viewModel = getViewModel(TroopEditInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopEditInfoViewModel::class.java)");
        TroopEditInfoViewModel troopEditInfoViewModel = (TroopEditInfoViewModel) viewModel;
        this.viewModel = troopEditInfoViewModel;
        if (troopEditInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopEditInfoViewModel = null;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        troopEditInfoViewModel.n2(intent, this);
        TroopFeatureReport troopFeatureReport = TroopFeatureReport.f361921a;
        TroopEditInfoViewModel troopEditInfoViewModel2 = this.viewModel;
        if (troopEditInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopEditInfoViewModel2 = null;
        }
        TroopFeatureReport.c(troopFeatureReport, "EditTroopInfoFragment-" + troopEditInfoViewModel2.Z1(), false, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.hzn, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
            this.rootView = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                inflate = null;
            }
            View findViewById = inflate.findViewById(R.id.uqg);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.edit_items_rv)");
            QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) findViewById;
            this.recycleView = qUISettingsRecyclerView;
            if (qUISettingsRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                qUISettingsRecyclerView = null;
            }
            qUISettingsRecyclerView.setHasTopSpace(false);
            QUISettingsRecyclerView qUISettingsRecyclerView2 = this.recycleView;
            if (qUISettingsRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                qUISettingsRecyclerView2 = null;
            }
            qUISettingsRecyclerView2.setHasBottomSpace(true);
            QUISettingsRecyclerView qUISettingsRecyclerView3 = this.recycleView;
            if (qUISettingsRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                qUISettingsRecyclerView3 = null;
            }
            qUISettingsRecyclerView3.addOnScrollListener(new b());
            QUISettingsRecyclerView qUISettingsRecyclerView4 = this.recycleView;
            if (qUISettingsRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                qUISettingsRecyclerView4 = null;
            }
            qUISettingsRecyclerView4.setAdapter(this.adapter);
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment", 2, "[onDestroy] ");
        }
        TroopEditInfoViewModel troopEditInfoViewModel = this.viewModel;
        if (troopEditInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopEditInfoViewModel = null;
        }
        troopEditInfoViewModel.onDestroy();
        if (this.hasInitPhotoController) {
            yh().C();
        }
        if (this.hasInitAvatarController) {
            xh().C();
        }
        if (this.hasPhotoManagerObserver) {
            Ch().h(Bh());
            Ch().f();
        }
        com.tencent.mobileqq.troop.troopcatalog.b.g().b();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent newIntent) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) newIntent);
            return;
        }
        super.onNewIntent(newIntent);
        String str2 = null;
        if (newIntent != null) {
            str = newIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        } else {
            str = null;
        }
        if (newIntent != null) {
            str2 = newIntent.getStringExtra(ITroopPhotoUtilsApi.KEY_CLIP_INFO);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment", 2, "[onNewIntent] isFromCover:" + this.isFromCover);
        }
        if (this.isFromCover) {
            yh().G(str, str2);
        } else {
            xh().G(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) contentView, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        wh();
    }

    @NotNull
    public final QUISettingsRecyclerView zh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUISettingsRecyclerView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            return null;
        }
        return qUISettingsRecyclerView;
    }
}
