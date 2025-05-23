package com.tencent.mobileqq.troop.file.main.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.troop.file.data.TroopFileShowAdapter;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.troop.file.main.vm.a;
import com.tencent.mobileqq.troop.file.widget.TroopFileListView;
import com.tencent.mobileqq.troop.file.widget.TroopFileSearchDialog;
import com.tencent.mobileqq.troop.file.widget.TroopFileViewMoreRelativeLayout;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.bc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileProcessor;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import cooperation.qzone.QzoneIPCModule;
import cooperation.vip.manager.FileBannerTianshuManger;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000\u00c3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0018*\u0001l\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0081\u0001\u0082\u0001B\u0010\u0012\u0006\u0010:\u001a\u000205\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001a\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u001eH\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0016J\u0012\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u00104\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101H\u0016R\u0017\u0010:\u001a\u0002058\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020i8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010r\u001a\u00020B8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bs\u0010tR\u0014\u0010x\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bv\u0010wR\u0014\u0010z\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\by\u0010tR\u0014\u0010|\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b{\u0010wR\u0014\u0010~\u001a\u00020B8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b}\u0010q\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/filemanager/util/x;", "Lcom/tencent/mobileqq/troop/file/data/c;", "", "W9", "R9", "V9", "initData", "Q9", "T9", "Lks2/c;", "model", "Y9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "isSelect", "e0", "A0", "", "action", "", "args", "handleBroadcastMessage", "getMessage", "loadingOver", "Z2", "V", "", RemoteProxy.KEY_RESULT_TYPE, "f4", "headViewEnum", "I3", "isLoading", "loadingProgress", "show", "I5", "q8", "P2", "u0", "visibility", "L7", "Lks2/a;", "W6", "Lcom/tencent/mobileqq/troop/data/n;", "fileInfo", "J1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "d", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "P9", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "searchDialog", "f", "Z", "isFirstEnterUI", "", tl.h.F, "J", "refreshTime", "Lcom/tencent/mobileqq/troop/file/widget/TroopFileListView;", "i", "Lcom/tencent/mobileqq/troop/file/widget/TroopFileListView;", "fileShowList", "Lcom/tencent/mobileqq/troop/file/data/TroopFileShowAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/file/data/TroopFileShowAdapter;", "fileShowAdapter", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "headerView", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "fileCountSpaceLayout", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "fileCountSpaceTv", "Lcom/tencent/mobileqq/troop/file/widget/TroopFileViewMoreRelativeLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/file/widget/TroopFileViewMoreRelativeLayout;", "footerView", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", "businessView", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "noFileArrowIV", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "I", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyState", "Lcom/tencent/mobileqq/widget/PullRefreshHeader;", "Lcom/tencent/mobileqq/widget/PullRefreshHeader;", "overScrollHeader", "com/tencent/mobileqq/troop/file/main/part/TroopFileMainContentPart$c", "K", "Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainContentPart$c;", "groupTeamWorkObserver", "N9", "()J", "troopUinL", "M9", "()I", "source", "O9", "()Ljava/lang/String;", "troopUinStr", "L9", "from", "K9", "folderId", "J9", "filterUin", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;)V", "a", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainContentPart extends Part implements com.tencent.mobileqq.filemanager.util.x, com.tencent.mobileqq.troop.file.data.c {

    /* renamed from: C, reason: from kotlin metadata */
    private View headerView;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout fileCountSpaceLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView fileCountSpaceTv;

    /* renamed from: F, reason: from kotlin metadata */
    private TroopFileViewMoreRelativeLayout footerView;

    /* renamed from: G, reason: from kotlin metadata */
    private RelativeLayout businessView;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView noFileArrowIV;

    /* renamed from: I, reason: from kotlin metadata */
    private QUIEmptyState emptyState;

    /* renamed from: J, reason: from kotlin metadata */
    private PullRefreshHeader overScrollHeader;

    /* renamed from: K, reason: from kotlin metadata */
    private final c groupTeamWorkObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileMainVM viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Dialog searchDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstEnterUI;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long refreshTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TroopFileListView fileShowList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TroopFileShowAdapter fileShowAdapter;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B*\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R/\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainContentPart$a;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "d", "Lkotlin/jvm/functions/Function1;", "cb", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Function1<Animation, Unit> cb;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Animation, Unit> cb5) {
            Intrinsics.checkNotNullParameter(cb5, "cb");
            this.cb = cb5;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.cb.invoke(animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0003\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainContentPart$b;", "", "", "a", "Z", "isKeepingOverScroll", "()Z", "(Z)V", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isKeepingOverScroll;

        public final void a(boolean z16) {
            this.isKeepingOverScroll = z16;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/file/main/part/TroopFileMainContentPart$c", "Lcom/tencent/mobileqq/teamworkforgroup/g;", "", "isSuccess", "", QzoneIPCModule.RESULT_CODE, "", "errorMsg", "", "e", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends com.tencent.mobileqq.teamworkforgroup.g {
        c() {
        }

        @Override // com.tencent.mobileqq.teamworkforgroup.g
        public void e(boolean isSuccess, int resultCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            if (isSuccess && resultCode == 0) {
                TroopFileShowAdapter troopFileShowAdapter = TroopFileMainContentPart.this.fileShowAdapter;
                TroopFileShowAdapter troopFileShowAdapter2 = null;
                if (troopFileShowAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                    troopFileShowAdapter = null;
                }
                troopFileShowAdapter.g(0);
                TroopFileShowAdapter troopFileShowAdapter3 = TroopFileMainContentPart.this.fileShowAdapter;
                if (troopFileShowAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                } else {
                    troopFileShowAdapter2 = troopFileShowAdapter3;
                }
                troopFileShowAdapter2.F = true;
            }
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/file/main/part/TroopFileMainContentPart$d", "Lcom/tencent/widget/OverScrollViewListener;", "", "overScrollPosition", "Landroid/view/View;", "overScrollerView", "Lcom/tencent/widget/ListView;", "listView", "", "onNotCompleteVisable", "onViewCompleteVisable", "", "onViewCompleteVisableAndReleased", "onViewNotCompleteVisableAndReleased", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements OverScrollViewListener {
        d() {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int overScrollPosition, View overScrollerView, ListView listView) {
            long j3;
            Intrinsics.checkNotNullParameter(overScrollerView, "overScrollerView");
            Intrinsics.checkNotNullParameter(listView, "listView");
            PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) overScrollerView;
            if (TroopFileMainContentPart.this.refreshTime != 0) {
                j3 = TroopFileMainContentPart.this.refreshTime;
            } else {
                j3 = System.currentTimeMillis();
            }
            pullRefreshHeader.i(j3);
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int overScrollPosition, View overScrollerView, ListView listView) {
            long j3;
            Intrinsics.checkNotNullParameter(overScrollerView, "overScrollerView");
            Intrinsics.checkNotNullParameter(listView, "listView");
            PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) overScrollerView;
            if (TroopFileMainContentPart.this.refreshTime != 0) {
                j3 = TroopFileMainContentPart.this.refreshTime;
            } else {
                j3 = System.currentTimeMillis();
            }
            pullRefreshHeader.d(j3);
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int overScrollPosition, View overScrollerView, ListView listView) {
            long j3;
            Intrinsics.checkNotNullParameter(overScrollerView, "overScrollerView");
            Intrinsics.checkNotNullParameter(listView, "listView");
            PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) overScrollerView;
            if (TroopFileMainContentPart.this.refreshTime != 0) {
                j3 = TroopFileMainContentPart.this.refreshTime;
            } else {
                j3 = System.currentTimeMillis();
            }
            pullRefreshHeader.h(j3);
            if (NetworkUtil.isNetworkAvailable(TroopFileMainContentPart.this.getActivity())) {
                TroopFileMainContentPart.this.loadingProgress(true);
                TroopFileShowAdapter troopFileShowAdapter = TroopFileMainContentPart.this.fileShowAdapter;
                TroopFileShowAdapter troopFileShowAdapter2 = null;
                if (troopFileShowAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                    troopFileShowAdapter = null;
                }
                troopFileShowAdapter.g(0);
                TroopFileShowAdapter troopFileShowAdapter3 = TroopFileMainContentPart.this.fileShowAdapter;
                if (troopFileShowAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                } else {
                    troopFileShowAdapter2 = troopFileShowAdapter3;
                }
                troopFileShowAdapter2.F = true;
            } else {
                TroopFileMainContentPart.this.f4(1);
                TroopFileUtils.F(bc.a(TroopFileMainContentPart.this), TroopFileMainContentPart.this.N9());
            }
            Object tag = overScrollerView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.troop.file.main.part.TroopFileMainContentPart.OverScrollViewTag");
            ((b) tag).a(true);
            return true;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int overScrollPosition, View overScrollerView, ListView listView) {
            Intrinsics.checkNotNullParameter(overScrollerView, "overScrollerView");
            Intrinsics.checkNotNullParameter(listView, "listView");
        }
    }

    public TroopFileMainContentPart(TroopFileMainVM viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.isFirstEnterUI = true;
        this.groupTeamWorkObserver = new c();
    }

    private final long J9() {
        return this.viewModel.T1().filterUin;
    }

    private final String K9() {
        return this.viewModel.T1().folderId;
    }

    private final int L9() {
        return this.viewModel.T1().from;
    }

    private final int M9() {
        return this.viewModel.T1().source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long N9() {
        return this.viewModel.T1().troopUinL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String O9() {
        return this.viewModel.T1().troopUinStr;
    }

    private final void Q9() {
        Activity activity = getActivity();
        View view = this.headerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view = null;
        }
        new FileBannerTianshuManger(activity, view, 2).h();
    }

    private final void R9() {
        MutableLiveData<com.tencent.mobileqq.troop.file.main.vm.a> obtainUiState = this.viewModel.obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.file.main.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.file.main.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainContentPart$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.file.main.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.file.main.vm.a aVar) {
                if (aVar instanceof a.c) {
                    TroopFileMainContentPart.this.Y9(((a.c) aVar).getModel());
                } else if (aVar instanceof a.f) {
                    TroopFileMainContentPart.this.V9();
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.file.main.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFileMainContentPart.S9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void T9() {
        LayoutInflater from = LayoutInflater.from(getActivity());
        TroopFileListView troopFileListView = this.fileShowList;
        TroopFileListView troopFileListView2 = null;
        if (troopFileListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView = null;
        }
        View inflate = from.inflate(R.layout.f168433w5, (ViewGroup) troopFileListView, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.widget.PullRefreshHeader");
        PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) inflate;
        this.overScrollHeader = pullRefreshHeader;
        if (pullRefreshHeader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overScrollHeader");
            pullRefreshHeader = null;
        }
        pullRefreshHeader.setTag(new b());
        d dVar = new d();
        TroopFileListView troopFileListView3 = this.fileShowList;
        if (troopFileListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView3 = null;
        }
        PullRefreshHeader pullRefreshHeader2 = this.overScrollHeader;
        if (pullRefreshHeader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overScrollHeader");
            pullRefreshHeader2 = null;
        }
        troopFileListView3.setOverScrollHeader(pullRefreshHeader2);
        TroopFileListView troopFileListView4 = this.fileShowList;
        if (troopFileListView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView4 = null;
        }
        troopFileListView4.setOverscrollHeader(bc.c(this, R.drawable.qui_common_bg_bottom_standard));
        TroopFileListView troopFileListView5 = this.fileShowList;
        if (troopFileListView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
        } else {
            troopFileListView2 = troopFileListView5;
        }
        troopFileListView2.setOverScrollListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(TroopFileMainContentPart this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            view.clearFocus();
            if (this$0.searchDialog != null) {
                return;
            }
            this$0.W9();
            ReportController.o(bc.a(this$0), "P_CliOper", "Grp_files", "", "search", "Clk_frame", 0, 0, this$0.O9(), AppSetting.d(), "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        BuildersKt__Builders_commonKt.launch$default(bc.d(this), null, null, new TroopFileMainContentPart$showFileTooManyUI$1(this, null), 3, null);
    }

    private final void W9() {
        final View findViewById = getPartRootView().findViewById(R.id.rlCommenTitle);
        Object parent = findViewById.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view = (View) parent;
        Object parent2 = view.getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent2;
        Activity activity = getActivity();
        Activity activity2 = getActivity();
        TroopFileListView troopFileListView = this.fileShowList;
        if (troopFileListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView = null;
        }
        TroopFileSearchDialog troopFileSearchDialog = new TroopFileSearchDialog(activity, activity2, troopFileListView, N9());
        troopFileSearchDialog.setTitle(HardCodeUtil.qqStr(R.string.uez));
        troopFileSearchDialog.setCanceledOnTouchOutside(true);
        this.searchDialog = troopFileSearchDialog;
        final int height = findViewById.getHeight();
        float f16 = -height;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f16);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillAfter(true);
        final TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, f16, 0.0f);
        translateAnimation2.setDuration(200L);
        translateAnimation.setAnimationListener(new a(new Function1<Animation, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainContentPart$showSearchDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
                invoke2(animation);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Animation it) {
                Dialog dialog;
                Intrinsics.checkNotNullParameter(it, "it");
                dialog = TroopFileMainContentPart.this.searchDialog;
                if (dialog != null) {
                    dialog.show();
                }
                view.setAnimation(null);
                findViewById.setVisibility(8);
                view2.setBackgroundResource(0);
            }
        }));
        translateAnimation2.setAnimationListener(new a(new Function1<Animation, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainContentPart$showSearchDialog$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
                invoke2(animation);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Animation it) {
                Intrinsics.checkNotNullParameter(it, "it");
                view.setAnimation(null);
                view.offsetTopAndBottom(height);
                view.requestLayout();
                view2.setBackgroundResource(0);
            }
        }));
        Dialog dialog = this.searchDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.troop.file.main.part.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TroopFileMainContentPart.X9(view, height, findViewById, view2, translateAnimation2, this, dialogInterface);
                }
            });
        }
        view2.setBackgroundResource(R.drawable.bg_texture);
        view.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(View rootViewLayout, int i3, View view, View rootParent, TranslateAnimation downAnim, TroopFileMainContentPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(rootViewLayout, "$rootViewLayout");
        Intrinsics.checkNotNullParameter(rootParent, "$rootParent");
        Intrinsics.checkNotNullParameter(downAnim, "$downAnim");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rootViewLayout.offsetTopAndBottom(-i3);
        view.setVisibility(0);
        rootParent.setBackgroundResource(R.drawable.bg_texture);
        rootViewLayout.startAnimation(downAnim);
        this$0.searchDialog = null;
    }

    private final void initData() {
        TroopFileShowAdapter troopFileShowAdapter = null;
        BuildersKt__Builders_commonKt.launch$default(bc.d(this), null, null, new TroopFileMainContentPart$initData$1(this, null), 3, null);
        bc.a(this).addObserver(this.groupTeamWorkObserver);
        TroopFileShowAdapter troopFileShowAdapter2 = this.fileShowAdapter;
        if (troopFileShowAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
        } else {
            troopFileShowAdapter = troopFileShowAdapter2;
        }
        troopFileShowAdapter.g(1);
    }

    @Override // com.tencent.mobileqq.filemanager.util.x
    public void A0() {
        broadcastMessage("on_multi_selected_empty", Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v51, types: [android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r10v73, types: [android.view.View] */
    @Override // com.tencent.mobileqq.troop.file.data.c
    public void I3(int headViewEnum) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = BaseAIOUtils.f(320.0f, bc.e(this));
        obtain.mRequestHeight = BaseAIOUtils.f(200.0f, bc.e(this));
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        QUIEmptyState qUIEmptyState = null;
        switch (headViewEnum) {
            case 0:
            case 5:
                TroopFileListView troopFileListView = this.fileShowList;
                if (troopFileListView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                    troopFileListView = null;
                }
                troopFileListView.setVisibility(8);
                View view = this.headerView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view = null;
                }
                view.setVisibility(8);
                ImageView imageView = this.noFileArrowIV;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noFileArrowIV");
                    imageView = null;
                }
                imageView.setVisibility(8);
                RelativeLayout relativeLayout = this.businessView;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessView");
                    relativeLayout = null;
                }
                relativeLayout.setVisibility(0);
                QUIEmptyState qUIEmptyState2 = this.emptyState;
                if (qUIEmptyState2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyState");
                } else {
                    qUIEmptyState = qUIEmptyState2;
                }
                qUIEmptyState.setTitle(bc.f(this, R.string.eq7));
                return;
            case 1:
                TroopFileListView troopFileListView2 = this.fileShowList;
                if (troopFileListView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                    troopFileListView2 = null;
                }
                troopFileListView2.setVisibility(0);
                View view2 = this.headerView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view2 = null;
                }
                view2.setVisibility(8);
                RelativeLayout relativeLayout2 = this.businessView;
                if (relativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessView");
                    relativeLayout2 = null;
                }
                relativeLayout2.setVisibility(0);
                QUIEmptyState qUIEmptyState3 = this.emptyState;
                if (qUIEmptyState3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyState");
                } else {
                    qUIEmptyState = qUIEmptyState3;
                }
                qUIEmptyState.setTitle(bc.f(this, R.string.eq9));
                return;
            case 2:
                TroopFileListView troopFileListView3 = this.fileShowList;
                if (troopFileListView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                    troopFileListView3 = null;
                }
                troopFileListView3.setVisibility(0);
                View view3 = this.headerView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view3 = null;
                }
                view3.setVisibility(8);
                ImageView imageView2 = this.noFileArrowIV;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noFileArrowIV");
                    imageView2 = null;
                }
                imageView2.setVisibility(8);
                RelativeLayout relativeLayout3 = this.businessView;
                if (relativeLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessView");
                    relativeLayout3 = null;
                }
                relativeLayout3.setVisibility(0);
                QUIEmptyState qUIEmptyState4 = this.emptyState;
                if (qUIEmptyState4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyState");
                } else {
                    qUIEmptyState = qUIEmptyState4;
                }
                qUIEmptyState.setTitle(bc.f(this, R.string.i9t));
                return;
            case 3:
                TroopFileListView troopFileListView4 = this.fileShowList;
                if (troopFileListView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                    troopFileListView4 = null;
                }
                troopFileListView4.setVisibility(8);
                View view4 = this.headerView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view4 = null;
                }
                view4.setVisibility(8);
                int L9 = L9();
                if (L9 == 5000) {
                    QUIEmptyState qUIEmptyState5 = this.emptyState;
                    if (qUIEmptyState5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("emptyState");
                        qUIEmptyState5 = null;
                    }
                    qUIEmptyState5.setTitle(bc.f(this, R.string.ueo));
                } else if (L9 != 6000) {
                    ImageView imageView3 = this.noFileArrowIV;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noFileArrowIV");
                        imageView3 = null;
                    }
                    imageView3.setVisibility(0);
                    QUIEmptyState qUIEmptyState6 = this.emptyState;
                    if (qUIEmptyState6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("emptyState");
                        qUIEmptyState6 = null;
                    }
                    qUIEmptyState6.setTitle(bc.f(this, R.string.erw));
                } else {
                    ImageView imageView4 = this.noFileArrowIV;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noFileArrowIV");
                        imageView4 = null;
                    }
                    imageView4.setVisibility(8);
                    QUIEmptyState qUIEmptyState7 = this.emptyState;
                    if (qUIEmptyState7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("emptyState");
                        qUIEmptyState7 = null;
                    }
                    qUIEmptyState7.setTitle(bc.f(this, R.string.erx));
                }
                ?? r102 = this.businessView;
                if (r102 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessView");
                } else {
                    qUIEmptyState = r102;
                }
                qUIEmptyState.setVisibility(0);
                return;
            case 4:
                RelativeLayout relativeLayout4 = this.businessView;
                if (relativeLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessView");
                    relativeLayout4 = null;
                }
                relativeLayout4.setVisibility(8);
                ImageView imageView5 = this.noFileArrowIV;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noFileArrowIV");
                    imageView5 = null;
                }
                imageView5.setVisibility(8);
                TroopFileListView troopFileListView5 = this.fileShowList;
                if (troopFileListView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                    troopFileListView5 = null;
                }
                troopFileListView5.setVisibility(0);
                if (L9() != 4000) {
                    ?? r103 = this.headerView;
                    if (r103 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    } else {
                        qUIEmptyState = r103;
                    }
                    qUIEmptyState.setVisibility(0);
                    return;
                }
                return;
            case 6:
                TroopFileListView troopFileListView6 = this.fileShowList;
                if (troopFileListView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                    troopFileListView6 = null;
                }
                troopFileListView6.setVisibility(8);
                View view5 = this.headerView;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view5 = null;
                }
                view5.setVisibility(8);
                if (L9() != 5000) {
                    ImageView imageView6 = this.noFileArrowIV;
                    if (imageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noFileArrowIV");
                        imageView6 = null;
                    }
                    imageView6.setVisibility(0);
                }
                RelativeLayout relativeLayout5 = this.businessView;
                if (relativeLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessView");
                    relativeLayout5 = null;
                }
                relativeLayout5.setVisibility(0);
                QUIEmptyState qUIEmptyState8 = this.emptyState;
                if (qUIEmptyState8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyState");
                } else {
                    qUIEmptyState = qUIEmptyState8;
                }
                qUIEmptyState.setTitle(bc.f(this, R.string.elu));
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void I5(boolean show) {
        broadcastMessage("set_show_team_work_entrance", Boolean.valueOf(show));
    }

    @Override // com.tencent.mobileqq.troop.file.data.b
    public void J1(com.tencent.mobileqq.troop.data.n fileInfo) {
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        broadcastMessage("show_delete_folder_dialog", fileInfo);
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void L7(int visibility) {
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout = this.footerView;
        if (troopFileViewMoreRelativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            troopFileViewMoreRelativeLayout = null;
        }
        troopFileViewMoreRelativeLayout.setVisibility(visibility);
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void P2() {
        if (this.isFirstEnterUI && L9() == 2000) {
            TroopFileListView troopFileListView = this.fileShowList;
            if (troopFileListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                troopFileListView = null;
            }
            troopFileListView.setSelection(1);
            this.isFirstEnterUI = false;
        }
    }

    /* renamed from: P9, reason: from getter */
    public final TroopFileMainVM getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void V() {
        broadcastMessage("show_guide_view", Unit.INSTANCE);
    }

    @Override // com.tencent.mobileqq.troop.file.data.b
    public void W6(ks2.a model) {
        Intrinsics.checkNotNullParameter(model, "model");
        broadcastMessage("show_create_or_rename_folder_dialog", model);
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void Z2(boolean loadingOver) {
        TroopFileListView troopFileListView = this.fileShowList;
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout = null;
        if (troopFileListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView = null;
        }
        if (troopFileListView.getFirstVisiblePosition() == 0) {
            TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout2 = this.footerView;
            if (troopFileViewMoreRelativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerView");
            } else {
                troopFileViewMoreRelativeLayout = troopFileViewMoreRelativeLayout2;
            }
            troopFileViewMoreRelativeLayout.setVisibility(8);
            return;
        }
        if (loadingOver) {
            TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout3 = this.footerView;
            if (troopFileViewMoreRelativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("footerView");
            } else {
                troopFileViewMoreRelativeLayout = troopFileViewMoreRelativeLayout3;
            }
            troopFileViewMoreRelativeLayout.setVisibility(8);
            return;
        }
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout4 = this.footerView;
        if (troopFileViewMoreRelativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            troopFileViewMoreRelativeLayout4 = null;
        }
        troopFileViewMoreRelativeLayout4.setVisibility(0);
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout5 = this.footerView;
        if (troopFileViewMoreRelativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            troopFileViewMoreRelativeLayout5 = null;
        }
        troopFileViewMoreRelativeLayout5.setText(R.string.hqg);
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout6 = this.footerView;
        if (troopFileViewMoreRelativeLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
        } else {
            troopFileViewMoreRelativeLayout = troopFileViewMoreRelativeLayout6;
        }
        troopFileViewMoreRelativeLayout.setTextLeftDrawable(R.drawable.f160545jt);
    }

    @Override // com.tencent.mobileqq.filemanager.util.x
    public void e0(boolean isSelect) {
        broadcastMessage("on_multi_item_selected", Boolean.valueOf(isSelect));
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void f4(int resultType) {
        PullRefreshHeader pullRefreshHeader = this.overScrollHeader;
        if (pullRefreshHeader != null) {
            PullRefreshHeader pullRefreshHeader2 = null;
            if (pullRefreshHeader == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overScrollHeader");
                pullRefreshHeader = null;
            }
            Object tag = pullRefreshHeader.getTag();
            b bVar = tag instanceof b ? (b) tag : null;
            if (bVar == null) {
                return;
            }
            bVar.a(false);
            TroopFileListView troopFileListView = this.fileShowList;
            if (troopFileListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                troopFileListView = null;
            }
            troopFileListView.springBackOverScrollHeaderView();
            if (resultType == 0) {
                this.refreshTime = System.currentTimeMillis();
            }
            PullRefreshHeader pullRefreshHeader3 = this.overScrollHeader;
            if (pullRefreshHeader3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overScrollHeader");
            } else {
                pullRefreshHeader2 = pullRefreshHeader3;
            }
            pullRefreshHeader2.l(resultType);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "get_select_list")) {
            TroopFileShowAdapter troopFileShowAdapter = this.fileShowAdapter;
            if (troopFileShowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                troopFileShowAdapter = null;
            }
            List<com.tencent.mobileqq.troop.data.n> c16 = troopFileShowAdapter.c();
            Intrinsics.checkNotNullExpressionValue(c16, "fileShowAdapter.fileSelectedList");
            return c16;
        }
        Object message = super.getMessage(action, args);
        Intrinsics.checkNotNullExpressionValue(message, "super.getMessage(action, args)");
        return message;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        bc.a(this).removeObserver(this.groupTeamWorkObserver);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        boolean contains$default;
        TroopFileShowAdapter troopFileShowAdapter = this.fileShowAdapter;
        if (troopFileShowAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
            troopFileShowAdapter = null;
        }
        if (troopFileShowAdapter.getCount() > 0) {
            TroopFileShowAdapter troopFileShowAdapter2 = this.fileShowAdapter;
            if (troopFileShowAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                troopFileShowAdapter2 = null;
            }
            boolean z16 = false;
            Object item = troopFileShowAdapter2.getItem(0);
            com.tencent.mobileqq.troop.data.n nVar = item instanceof com.tencent.mobileqq.troop.data.n ? (com.tencent.mobileqq.troop.data.n) item : null;
            if (nVar == null) {
                return;
            }
            String str = nVar.f294916b;
            if (str != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "online_doc_folder_", false, 2, (Object) null);
                if (contains$default) {
                    z16 = true;
                }
            }
            if (z16 && Intrinsics.areEqual(bc.f(this, R.string.bo7), nVar.f294917c)) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportClickWithTroopType(bc.a(this), "0X8009935", O9());
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void q8() {
        BuildersKt__Builders_commonKt.launch$default(bc.d(this), null, null, new TroopFileMainContentPart$refreshUploadCount$1(this, null), 3, null);
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void u0() {
        BuildersKt__Builders_commonKt.launch$default(bc.d(this), null, null, new TroopFileMainContentPart$updateTroopFileUsedSpace$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (action != null) {
            int hashCode = action.hashCode();
            TroopFileListView troopFileListView = null;
            TroopFileShowAdapter troopFileShowAdapter = null;
            TroopFileShowAdapter troopFileShowAdapter2 = null;
            if (hashCode == -1313317857) {
                if (action.equals("enter_select_mode")) {
                    TroopFileShowAdapter troopFileShowAdapter3 = this.fileShowAdapter;
                    if (troopFileShowAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                        troopFileShowAdapter3 = null;
                    }
                    troopFileShowAdapter3.i(true);
                    TroopFileListView troopFileListView2 = this.fileShowList;
                    if (troopFileListView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                    } else {
                        troopFileListView = troopFileListView2;
                    }
                    troopFileListView.b0();
                    return;
                }
                return;
            }
            if (hashCode != -1132604059) {
                if (hashCode == -1040162731 && action.equals("notify_data_changed")) {
                    TroopFileShowAdapter troopFileShowAdapter4 = this.fileShowAdapter;
                    if (troopFileShowAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                    } else {
                        troopFileShowAdapter = troopFileShowAdapter4;
                    }
                    troopFileShowAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (action.equals("exit_select_mode")) {
                TroopFileShowAdapter troopFileShowAdapter5 = this.fileShowAdapter;
                if (troopFileShowAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                } else {
                    troopFileShowAdapter2 = troopFileShowAdapter5;
                }
                troopFileShowAdapter2.i(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.file.data.c
    public void loadingProgress(boolean isLoading) {
        if (isLoading) {
            return;
        }
        RelativeLayout relativeLayout = this.businessView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessView");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18, types: [android.widget.LinearLayout] */
    public final void Y9(ks2.c model) {
        int indexOf$default;
        TextView textView = null;
        if (!model.a()) {
            ?? r16 = this.fileCountSpaceLayout;
            if (r16 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("fileCountSpaceLayout");
            } else {
                textView = r16;
            }
            textView.setVisibility(8);
            return;
        }
        LinearLayout linearLayout = this.fileCountSpaceLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileCountSpaceLayout");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        long j3 = model.fileUsedSpace;
        if (j3 >= model.fileTotalSpace) {
            QVipTroopFileConfig qVipTroopFileConfig = QVipTroopFileProcessor.get();
            if (qVipTroopFileConfig.isEnable()) {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                SpannableString fullSpaceMessage = qVipTroopFileConfig.getFullSpaceMessage(ff.t((QQAppInterface) runtime));
                TextView textView2 = this.fileCountSpaceTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileCountSpaceTv");
                    textView2 = null;
                }
                textView2.setText(fullSpaceMessage);
                TextView textView3 = this.fileCountSpaceTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileCountSpaceTv");
                } else {
                    textView = textView3;
                }
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
            String fileSize = FileUtils.getFileSize(model.fileTotalSpace);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(bc.f(this, R.string.f171455w41), Arrays.copyOf(new Object[]{Integer.valueOf(model.com.tencent.mm.vfs.QuotaFileSystem.STAT_FILE_COUNT java.lang.String), fileSize}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) format, bc.f(this, R.string.f171456w42), 0, false, 6, (Object) null);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), indexOf$default, indexOf$default + 4, 33);
            TextView textView4 = this.fileCountSpaceTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileCountSpaceTv");
            } else {
                textView = textView4;
            }
            textView.setText(spannableString);
            return;
        }
        String fileSize2 = FileUtils.getFileSize(j3);
        String fileSize3 = FileUtils.getFileSize(model.fileTotalSpace);
        TextView textView5 = this.fileCountSpaceTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileCountSpaceTv");
        } else {
            textView = textView5;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(bc.f(this, R.string.f171457w43), Arrays.copyOf(new Object[]{Integer.valueOf(model.com.tencent.mm.vfs.QuotaFileSystem.STAT_FILE_COUNT java.lang.String), fileSize2, fileSize3}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView.setText(format2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        TroopFileListView troopFileListView;
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.jzq);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.troop.file.widget.TroopFileListView");
        this.fileShowList = (TroopFileListView) findViewById;
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout = new TroopFileViewMoreRelativeLayout(getActivity());
        this.footerView = troopFileViewMoreRelativeLayout;
        troopFileViewMoreRelativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout2 = this.footerView;
        QUIEmptyState qUIEmptyState = null;
        if (troopFileViewMoreRelativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            troopFileViewMoreRelativeLayout2 = null;
        }
        troopFileViewMoreRelativeLayout2.setTextColor(bc.b(this, R.color.qui_common_text_secondary));
        TroopFileListView troopFileListView2 = this.fileShowList;
        if (troopFileListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView2 = null;
        }
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout3 = this.footerView;
        if (troopFileViewMoreRelativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            troopFileViewMoreRelativeLayout3 = null;
        }
        troopFileListView2.addFooterView(troopFileViewMoreRelativeLayout3);
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout4 = this.footerView;
        if (troopFileViewMoreRelativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerView");
            troopFileViewMoreRelativeLayout4 = null;
        }
        troopFileViewMoreRelativeLayout4.setVisibility(8);
        long N9 = N9();
        QQAppInterface a16 = bc.a(this);
        TroopFileListView troopFileListView3 = this.fileShowList;
        if (troopFileListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView = null;
        } else {
            troopFileListView = troopFileListView3;
        }
        TroopFileShowAdapter troopFileShowAdapter = new TroopFileShowAdapter(N9, this, a16, troopFileListView, K9(), J9(), M9());
        this.fileShowAdapter = troopFileShowAdapter;
        troopFileShowAdapter.h(this);
        TroopFileListView troopFileListView4 = this.fileShowList;
        if (troopFileListView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView4 = null;
        }
        TroopFileShowAdapter troopFileShowAdapter2 = this.fileShowAdapter;
        if (troopFileShowAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
            troopFileShowAdapter2 = null;
        }
        troopFileListView4.setAdapter((ListAdapter) troopFileShowAdapter2);
        TroopFileListView troopFileListView5 = this.fileShowList;
        if (troopFileListView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
            troopFileListView5 = null;
        }
        TroopFileShowAdapter troopFileShowAdapter3 = this.fileShowAdapter;
        if (troopFileShowAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
            troopFileShowAdapter3 = null;
        }
        troopFileListView5.setOnScrollListener(troopFileShowAdapter3);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.a1o, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(R\u2026ile_browser_header, null)");
        this.headerView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            inflate = null;
        }
        View findViewById2 = inflate.findViewById(R.id.j88);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "headerView.findViewById(\u2026d.troop_file_count_space)");
        this.fileCountSpaceLayout = (LinearLayout) findViewById2;
        View view = this.headerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view = null;
        }
        View findViewById3 = view.findViewById(R.id.j8e);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "headerView.findViewById(\u2026roop_file_count_space_tv)");
        this.fileCountSpaceTv = (TextView) findViewById3;
        View view2 = this.headerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view2 = null;
        }
        View findViewById4 = view2.findViewById(R.id.search_box);
        AccessibilityUtil.n(findViewById4, false);
        ((TextView) findViewById4.findViewById(R.id.kag)).setText(R.string.el9);
        EditText editText = (EditText) findViewById4.findViewById(R.id.et_search_keyword);
        editText.setCursorVisible(false);
        editText.setContentDescription(bc.f(this, R.string.el9));
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.troop.file.main.part.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view3, boolean z16) {
                TroopFileMainContentPart.U9(TroopFileMainContentPart.this, view3, z16);
            }
        });
        if (L9() != 4000 && L9() != 6000) {
            TroopFileListView troopFileListView6 = this.fileShowList;
            if (troopFileListView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileShowList");
                troopFileListView6 = null;
            }
            View view3 = this.headerView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerView");
                view3 = null;
            }
            troopFileListView6.addHeaderView(view3);
        }
        View findViewById5 = rootView.findViewById(R.id.gif);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.businessView = (RelativeLayout) findViewById5;
        this.emptyState = new QUIEmptyState.Builder(getActivity()).setImageType(2).setBackgroundColorType(0).build();
        RelativeLayout relativeLayout = this.businessView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessView");
            relativeLayout = null;
        }
        relativeLayout.removeAllViews();
        RelativeLayout relativeLayout2 = this.businessView;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessView");
            relativeLayout2 = null;
        }
        QUIEmptyState qUIEmptyState2 = this.emptyState;
        if (qUIEmptyState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyState");
        } else {
            qUIEmptyState = qUIEmptyState2;
        }
        relativeLayout2.addView(qUIEmptyState);
        View findViewById6 = rootView.findViewById(R.id.gie);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.ImageView");
        this.noFileArrowIV = (ImageView) findViewById6;
        Q9();
        I3(5);
        T9();
        R9();
        initData();
    }
}
